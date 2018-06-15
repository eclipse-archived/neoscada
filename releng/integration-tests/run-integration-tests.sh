#!/bin/bash

if [[ $EUID -ne 0 ]]; then
   echo "This script must be run as root" 
   exit 1
fi

# ---------------------------------------------------------------
# build a base image to improve runtime of integration tests
# ---------------------------------------------------------------
#docker build -t neoscada:it-centos73-base ./centos7.3/base
#docker run neoscada:it-centos73-base

#docker build -t neoscada:it-opensuse422-base ./opensuse42.2/base 
#docker run neoscada:it-opensuse422-base

#docker build -t neoscada:it-ubuntu14045-base ./ubuntu1404.5/base 
#docker run neoscada:it-ubuntu14045-base

#docker build -t neoscada:it-ubuntu16042-base ./ubuntu1604.2/base 
#docker run neoscada:it-ubuntu16042-base

#docker build -t neoscada:it-ubuntu18040-java9-base ./ubuntu1804.0-java9/base 
#docker run neoscada:it-ubuntu18040-java9-base

docker build -t neoscada:it-ubuntu18040-java10-base ./ubuntu1804.0-java10/base 
docker run neoscada:it-ubuntu18040-java10-base

# ---------------------------------------------------------------
# assemble installation files
# ---------------------------------------------------------------
rm -rf centos7.3/neoscada/install
rm -rf opensuse42.2/neoscada/install
rm -rf ubuntu1404.5/neoscada/install
rm -rf ubuntu1604.2/neoscada/install
rm -rf ubuntu1804.0-java9/neoscada/install
rm -rf ubuntu1804.0-java10/neoscada/install

rm -rf install

mkdir -p install

mkdir -p centos7.3/neoscada/install
mkdir -p opensuse42.2/neoscada/install
mkdir -p ubuntu1404.5/neoscada/install
mkdir -p ubuntu1604.2/neoscada/install
mkdir -p ubuntu1804.0-java9/neoscada/install
mkdir -p ubuntu1804.0-java10/neoscada/install

cp ../../deploy/org.eclipse.scada.deploy.repack/target/*.deb install/
cp ../../deploy/org.eclipse.scada.deploy.repack/target/*.rpm install/

cp ../../deploy/org.eclipse.neoscada.deploy.common/ubuntu/target/*.deb install/
cp ../../deploy/org.eclipse.scada.deploy.p2director/target/*.deb install/
cp ../../external/org.eclipse.neoscada.external-p2/target/*.deb install/
cp ../../utils/org.eclipse.scada.utils-p2/target/*.deb install/
cp ../../base/org.eclipse.scada.base-p2/target/*.deb install/
cp ../../core/org.eclipse.scada.core-p2/target/*.deb install/
cp ../../protocols/org.eclipse.scada.protocols-p2/target/*.deb install/
cp ../../deploy/org.eclipse.scada.deploy-p2/target/*.deb install/

cp ../../deploy/org.eclipse.neoscada.deploy.common/centos/target/*.rpm install/
cp ../../deploy/org.eclipse.neoscada.deploy.common/suse/target/*.rpm install/
cp ../../deploy/org.eclipse.scada.deploy.p2director/target/*.rpm install/
cp ../../external/org.eclipse.neoscada.external-p2/target/*.rpm install/
cp ../../utils/org.eclipse.scada.utils-p2/target/*.rpm install/
cp ../../base/org.eclipse.scada.base-p2/target/*.rpm install/
cp ../../core/org.eclipse.scada.core-p2/target/*.rpm install/
cp ../../protocols/org.eclipse.scada.protocols-p2/target/*.rpm install/
cp ../../deploy/org.eclipse.scada.deploy-p2/target/*.rpm install/

cp install/*.rpm centos7.3/neoscada/install
cp install/*.rpm opensuse42.2/neoscada/install
cp install/*.deb ubuntu1404.5/neoscada/install
cp install/*.deb ubuntu1604.2/neoscada/install
cp install/*.deb ubuntu1804.0-java9/neoscada/install
cp install/*.deb ubuntu1804.0-java10/neoscada/install

cp common/* centos7.3/neoscada/install
cp common/* opensuse42.2/neoscada/install
cp common/* ubuntu1404.5/neoscada/install
cp common/* ubuntu1604.2/neoscada/install
cp common/* ubuntu1804.0-java9/neoscada/install
cp common/* ubuntu1804.0-java10/neoscada/install

cp configurations/results/rpmbased*.rpm centos7.3/neoscada/install
cp configurations/results/rpmbased*.rpm opensuse42.2/neoscada/install
cp configurations/results/ubuntu-upstart*.deb ubuntu1404.5/neoscada/install
cp configurations/results/ubuntu-systemd*.deb ubuntu1604.2/neoscada/install
cp configurations/results/ubuntu-systemd*.deb ubuntu1804.0-java9/neoscada/install
cp configurations/results/ubuntu-systemd*.deb ubuntu1804.0-java10/neoscada/install

# ---------------------------------------------------------------
# install and run integration tests
# ---------------------------------------------------------------
#docker build -t neoscada:it-centos73-test1 ./centos7.3/neoscada
#docker run neoscada:it-centos73-test1

#docker build -t neoscada:it-opensuse422-test1 ./opensuse42.2/neoscada 
#docker run neoscada:it-opensuse422-test1

#docker build -t neoscada:it-ubuntu14045-test1 ./ubuntu1404.5/neoscada 
#docker run neoscada:it-ubuntu14045-test1

#docker build -t neoscada:it-ubuntu16042-test1 ./ubuntu1604.2/neoscada 
#docker run neoscada:it-ubuntu16042-test1

#docker build -t neoscada:it-ubuntu18040-java9-test1 ./ubuntu1804.0-java9/neoscada 
#docker run neoscada:it-ubuntu18040-java9-test1

docker build -t neoscada:it-ubuntu18040-java10-test1 ./ubuntu1804.0-java10/neoscada 
docker run neoscada:it-ubuntu18040-java10-test1
