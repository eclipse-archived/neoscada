#!/bin/bash

uname -a
cat /etc/lsb-release || true

set -e

which rpmbuild || true
which debuild || true
which createrepo || true

#rpm --showrc

echo START BUILD

echo "Version: $version"

# the reason why this must go to "tmp" is that the suse rpmbuild
# setup converts all - to _ of all file names. Also the topdir!
# This causes the rpm build to fail always if the topdir
# contains a -, which is the case in the hudson jobs

pushd ..

make clean

rm -Rf /tmp/eclipse.scada.rpmbuild
mkdir -p /tmp/eclipse.scada.rpmbuild/{BUILD,RPMS,SOURCES,SPECS,SRPMS}

make dist VERSION=$version
tar tzf *.tar.gz
rpmbuild -ta -vv --define _topdir/tmp/eclipse.scada.rpmbuild org.eclipse.scada-*.tar.gz

popd

echo DONE

