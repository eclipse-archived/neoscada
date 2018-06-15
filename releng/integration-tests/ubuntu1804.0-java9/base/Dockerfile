FROM ubuntu:bionic-20180526
MAINTAINER juergen.rose@ibh-systems.com 

RUN apt-get update -y
RUN apt-get install -y wget screen gdebi-core python2.7 perl rsync sudo openjdk-8-jre-headless
RUN wget -nv https://github.com/AdoptOpenJDK/openjdk9-nightly/releases/download/jdk-9%2B181-20180614/OpenJDK9_x64_Linux_20180614.tar.gz -O /root/openjdk-9.tgz
RUN tar xzf /root/openjdk-9.tgz -C /opt
RUN sudo update-alternatives --install "/usr/bin/java" "java" "/opt/jdk-9.0.4+11/bin/java" 9000
RUN sudo update-alternatives --install "/usr/bin/javac" "javac" "/opt/jdk-9.0.4+11/bin/javac" 9000
RUN sudo update-alternatives --install "/usr/bin/jar" "jar" "/opt/jdk-9.0.4+11/bin/jar" 9000

CMD java -version 