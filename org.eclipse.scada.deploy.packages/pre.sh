#!/bin/bash

set -e

uname -a
cat /etc/motd

which rpmbuild || true
which debuild || true
which createrepo || true

rpm --showrc

echo START BUILD

pushd org.eclipse.scada.deploy.packages
rm -Rf /tmp/eclipse.scada.rpmbuild
mkdir -p /tmp/eclipse.scada.rpmbuild/{BUILD,RPMS,SOURCES,SPECS,SRPMS}
make dist
tar tzf *.tar.gz
rpmbuild -ta -vv --define _topdir/tmp/eclipse.scada.rpmbuild org.eclipse.scada-*.tar.gz
popd



