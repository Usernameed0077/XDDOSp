package XD.XDDOS.utils.proxy;

import java.io.BufferedReader;
import java.io.File;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import XD.XDDOS.XDDOS;
import XD.XDDOS.utils.NettyBootstrap;

public class ProxyLoader {
   private File file;
   private BufferedReader bufferedReader;
   public volatile List<ProxyLoader.Proxy> finals = Collections.synchronizedList(new ArrayList<Proxy>());
   public ExecutorService exe = Executors.newFixedThreadPool(50, new ThreadFactory() {
      public Thread newThread(Runnable r) {
         return new Thread(r);
      }
   });
   private volatile int at = 0;
   public ConcurrentHashMap<ProxyLoader.Proxy, Long> disabledProxies = new ConcurrentHashMap<ProxyLoader.Proxy, Long>(1000);

   public ProxyLoader(File file) {
      if (file != null) {
         this.file = file;
         this.loadFile();
      }
   }

   public ProxyLoader(BufferedReader in) {
      this.bufferedReader = in;
      this.loadBuffer();
   }

   private void loadFile() {
      try {
         List<String> lines = Files.readAllLines(this.file.toPath());
         Iterator<String> var3 = lines.iterator();

         while(var3.hasNext()) {
            String s = (String)var3.next();
            this.exe.execute(() -> {
               try {
                  String[] split = s.split(":");
                  this.finals.add(new ProxyLoader.Proxy(new InetSocketAddress(split[0], Integer.parseInt(split[1]))));
               } catch (Throwable tw) {
                  tw.getMessage();
               }

            });
         }
      } catch (Throwable var5) {
         var5.getMessage();
         return;
      }

      this.exe.shutdown();

      try {
         this.exe.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
      } catch (InterruptedException var4) {
         var4.getMessage();
      }

      System.out.println(XDDOS.GREEN_BOLD+"["+XDDOS.RED_BOLD+"XDDOS"+XDDOS.GREEN_BOLD+"] "+XDDOS.WHITE_BOLD+this.finals.size() + " proxies loaded\n");
   }

   private void loadBuffer() {
      try {
         String inputLine;
         while((inputLine = this.bufferedReader.readLine()) != null) {
            String[] split = inputLine.split(":", 2);
            this.finals.add(new ProxyLoader.Proxy(new InetSocketAddress(split[0], Integer.parseInt(split[1]))));
         }

         this.bufferedReader.close();
      } catch (Throwable var4) {
         var4.getMessage();
         return;
      }

      this.exe.shutdown();

      try {
         this.exe.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
      } catch (InterruptedException var3) {
         var3.getMessage();
      }

      System.out.println(this.finals.size() + " proxies loaded.");
   }

   public ProxyLoader.Proxy getProxy() {
      int get;
      if ((get = this.at++) > this.finals.size() - 1) {
         get = 0;
         this.at = 1;
      }

      if (NettyBootstrap.disableFailedProxies) {
         return (ProxyLoader.Proxy)this.finals.get(get);
      } else {
         ProxyLoader.Proxy proxie = (ProxyLoader.Proxy)this.finals.get(get);
         Long time = (Long)this.disabledProxies.get(proxie);
         if (time != null) {
            if (System.currentTimeMillis() > time + 10000L) {
               proxie = this.getProxy();
            } else {
               this.disabledProxies.remove(proxie);
            }
         }

         return proxie;
      }
   }

   public static class Proxy {
      public final InetSocketAddress addrs;

      public Proxy(InetSocketAddress addrs) {
         this.addrs = addrs;
      }
   }
}
