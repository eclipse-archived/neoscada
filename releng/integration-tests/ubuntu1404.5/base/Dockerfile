FROM ubuntu:trusty-20180531
MAINTAINER juergen.rose@ibh-systems.com 

RUN apt-get update
RUN apt-get install software-properties-common
RUN add-apt-repository ppa:webupd8team/java -y
RUN apt-get update
RUN apt-get install -y openjdk-8-jdk screen gdebi-core python2.7 perl rsync sudo

CMD java -version 