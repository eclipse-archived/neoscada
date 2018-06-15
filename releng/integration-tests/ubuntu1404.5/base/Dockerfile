FROM ubuntu:trusty-20180531
MAINTAINER juergen.rose@ibh-systems.com 

RUN apt-get update
RUN apt-get install -y software-properties-common
RUN add-apt-repository -y ppa:openjdk-r/ppa
RUN apt-get update
RUN apt-get install -y openjdk-8-jdk-headless screen gdebi-core python2.7 perl rsync sudo

CMD java -version 