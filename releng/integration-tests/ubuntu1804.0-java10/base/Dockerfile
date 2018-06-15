FROM ubuntu:bionic-20180526
MAINTAINER juergen.rose@ibh-systems.com 

RUN apt-get update -y
RUN apt-get install -y wget screen gdebi-core python2.7 perl rsync sudo openjdk-8-jre-headless
RUN wget -nv https://github.com/AdoptOpenJDK/openjdk10-nightly/releases/download/jdk-10%2B23-20180613/OpenJDK10_x64_Linux_20180613.tar.gz -O /root/openjdk-10.tgz
RUN tar xzf /root/openjdk-10.tgz -C /opt
RUN ls -la /opt
RUN sudo update-alternatives --install "/usr/bin/java" "java" "/opt/jdk-10.0.1+10/bin/java" 10000
RUN sudo update-alternatives --install "/usr/bin/javac" "javac" "/opt/jdk-10.0.1+10/bin/javac" 10000
RUN sudo update-alternatives --install "/usr/bin/jar" "jar" "/opt/jdk-10.0.1+10/bin/jar" 10000

CMD java -version 