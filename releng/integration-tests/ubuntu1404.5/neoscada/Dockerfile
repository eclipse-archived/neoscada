FROM neoscada:it-ubuntu14045-base
MAINTAINER juergen.rose@ibh-systems.com 

ADD install /root/neoscada-install/

RUN dpkg -i /root/neoscada-install/neoscada.common*.deb
RUN dpkg -i /root/neoscada-install/org.eclipse.platform*.deb
RUN dpkg -i /root/neoscada-install/emf-xsd-Update*.deb
RUN dpkg -i /root/neoscada-install/equinox-sdk*.deb
RUN dpkg -i /root/neoscada-install/gemini-dbaccess*.deb
RUN dpkg -i /root/neoscada-install/neoscada.external.p2*.deb
RUN dpkg -i /root/neoscada-install/neoscada.utils.p2*.deb
RUN dpkg -i /root/neoscada-install/neoscada.base.p2*.deb
RUN dpkg -i /root/neoscada-install/neoscada.core.p2*.deb
RUN dpkg -i /root/neoscada-install/neoscada.protocols.p2*.deb
RUN dpkg -i /root/neoscada-install/neoscada.deploy.p2*.deb

RUN dpkg -i /root/neoscada-install/ubuntu-upstart-configuration*.deb
RUN scada.create.master

CMD /bin/bash /root/neoscada-install/launch-master.sh
