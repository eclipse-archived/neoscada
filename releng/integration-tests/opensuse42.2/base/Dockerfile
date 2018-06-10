FROM opensuse:42.2
MAINTAINER juergen.rose@ibh-systems.com 

RUN zypper --non-interactive install deltarpm
RUN zypper --non-interactive install java-1_8_0-openjdk screen perl python2 rsync sudo which

CMD java -version