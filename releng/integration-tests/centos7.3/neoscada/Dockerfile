FROM neoscada:it-centos73-base
MAINTAINER juergen.rose@ibh-systems.com 

ADD install /root/neoscada-install/

RUN rpm -Uvh /root/neoscada-install/neoscada.common.centos*.rpm
RUN rpm -Uvh /root/neoscada-install/org.eclipse.platform*.rpm
RUN rpm -Uvh /root/neoscada-install/emf-xsd-Update*.rpm
RUN rpm -Uvh /root/neoscada-install/equinox-sdk*.rpm
RUN rpm -Uvh /root/neoscada-install/gemini-dbaccess*.rpm
RUN rpm -Uvh /root/neoscada-install/neoscada.external.p2*.rpm
RUN rpm -Uvh /root/neoscada-install/neoscada.utils.p2*.rpm
RUN rpm -Uvh /root/neoscada-install/neoscada.base.p2*.rpm
RUN rpm -Uvh /root/neoscada-install/neoscada.core.p2*.rpm
RUN rpm -Uvh /root/neoscada-install/neoscada.protocols.p2*.rpm
RUN rpm -Uvh /root/neoscada-install/neoscada.deploy.p2*.rpm

RUN rpm -Uvh /root/neoscada-install/rpmbased-configuration*.rpm
RUN scada.create.master

CMD /bin/bash /root/neoscada-install/launch-master.sh
