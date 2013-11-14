#!/bin/bash

set -e

rm -Rf output
mkdir output
for i in `find /tmp/eclipse.scada.rpmbuild -name "*.rpm"`; do
 cp -v "$i" output/
done
find org.eclipse.scada.deploy.packages/ -name "*.deb" -exec cp -v {} output/ \;
find org.eclipse.scada.deploy.packages/ -name "*.changes" -exec cp -v {} output/ \;

pushd output
v=`ls org.eclipse.scada-p2*.rpm | sed -s 's/^org.eclipse.scada-p2-\(.*\).noarch.rpm$/\1/'`
echo Version: $v
echo org.eclipse.scada.rpmFileName=org.eclipse.scada-${v}.noarch.rpm > rpm.properties
echo org.eclipse.scada-p2.rpmFileName=org.eclipse.scada-p2-${v}.noarch.rpm >> rpm.properties
popd
