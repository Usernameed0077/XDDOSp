![alt text](https://cdn.discordapp.com/attachments/949290845222350928/964583278789148763/cover.png)
#                  TEAMXD Discord - https://discord.gg/4DQnbEnv87

## XDDOS is a tool to stress test your minecraft server.

## Features avilable

XDDOS has the following features:

- `54` different attack methods
- supports all version 
- `proxy scraper` (just put the links to scrape proxy from in urls.txt)
- `user friendly CLI` dont worry about hard to remeber startup commands
- also supports startup commands 
- auto ip resolver you can use domain names or ip addresses
- chat spam bots
- beautiful cli
- now supports both colored and plain mode just use -noansi as argument
- inbuilt jar updater

## How to use XDDOS

### Things to know

- CPS is Connection per second. Use -1 as cps to use max power
- Jar is compiled used java 8 so use java 8 or above to run
- To get protocols go [here](https://wiki.vg/Protocol_version_numbers) and see Version number
 example for version 1.8.9 protocol is 47

### Steps to take to run XDDOS:
 1) Download the jar -> [Download](https://github.com/AnAverageBeing/XDDOS/raw/master/XDDOS.jar)
 2) make a folder to store XDDOS and files related to it and move jar into that folder
 3) now make a file called urls.txt in that folder
 4) put the links to scrape socks4 proxies from in that file
   ### Some links to scrape socks4 proxies from
  ```
  https://raw.githubusercontent.com/TheSpeedX/PROXY-List/master/socks4.txt
  https://raw.githubusercontent.com/ShiftyTR/Proxy-List/master/socks4.txt
  https://raw.githubusercontent.com/monosans/proxy-list/main/proxies/socks4.txt
  https://raw.githubusercontent.com/jetkai/proxy-list/main/online-proxies/txt/proxies-socks4.txt
  ```
  
 5) now open ur terminal and move to that directory 
 6) now use the command to run jar commands can be found below

### Update Command:
```
java -jar XDDOS.jar -update
```

### Startup Command: 

- For user friendly CLI/auto mode with colors:
```
java -jar XDDOS.jar
```
- For user friendly CLI/auto mode without colors:
```
java -jar XDDOS.jar -noansi
```

- for manual startup with colors:
```
java -jar XDDOS.jar [ip] [protocol] [method] [time] [cps] [y/n]
```
- for manual startup without colors:
```
java -jar XDDOS.jar [ip] [protocol] [method] [time] [cps] [y/n] -noansi
```

#### NOTE! :-
**y/n** is optional y if you want to scrape proxy from links in urls.txt and **n** to use your own proxy) 
#### IMPORTANT :-
if u are using **n** it will use proxies.txt as proxy file

## Example Attack Commands  

- To run botjoiner for 10 seconds with 1000 cps and use auto proxy generator:
```
java -jar XDDOS.jar localhost:25565 47 botjoiner 10 1000 y
```

- To run botjoiner for 10 seconds with 1000 cps and use your own proxy:
```
java -jar XDDOS.jar localhost:25565 47 botjoiner 10 1000 n
```

- To run botjoiner for 10 seconds with MAX POWER or CPS and use auto proxy generator:
```
java -jar XDDOS.jar localhost:25565 47 botjoiner 10 -1 y
```

- To use user friendly CLI:
```
java -jar XDDOS.jar
```

## Methods avilable

- BigHandshake
- BigPacket
- BotJoiner
- BotRiad
- BungeeDowner
- ChatSpam
- ColorCrasher
- CpuDowner
- DoubleJoin
- EmptyNames
- EmptyPacket
- ExtremeJoin
- ExtremeKiller
- Handshake
- InstantDowner
- InvalidData
- InvalidNames
- InvalidSpoof
- IpSpooffFlood
- Join
- LegacyPing
- LegitnameJoin
- LocalHost
- LongHost
- LongNames
- Memory
- MOTD
- nabCry
- NettyDowner
- Network
- NullPing 2.0//newnullping
- NullPing
- Ping
- PingJoin
- Query
- Queue
- QuitExceptions
- RAM
- RandomExceptions
- RandomPacket
- ServerFucker//this is sf
- Slapper
- SmartBot
- Spoof
- TCPBypass
- TCPHit
- UltimateKiller
- UltimateSmasher
- UnexpectedPacket
- uuidCrash
- WaterfallBypass
- XDJoin
- xDSpam
- YooniksCry

### VirusTotal Scan
https://www.virustotal.com/gui/file/fa3c335a366da31b825b06281dbad74bd590bd12acb53d6dc644c699d591cf2b
