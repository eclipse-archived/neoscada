#!/bin/bash

set -e

OUTPUT="target"

echo "Output: $OUTPUT"

rm -Rf "$OUTPUT"
mkdir "$OUTPUT"
for i in `find /tmp/eclipse.scada.rpmbuild -name "*.rpm"`; do
 cp -v "$i" "$OUTPUT"
done
find . -name "*.deb" -exec cp -v {} "$OUTPUT" \;
find . -name "*.changes" -exec cp -v {} "$OUTPUT" \;

pushd "$OUTPUT"
v=`ls org.eclipse.scada-p2*.rpm | sed -s 's/^org.eclipse.scada-p2-\(.*\).noarch.rpm$/\1/'`
echo Version: $v
echo org.eclipse.scada.rpmFileName=org.eclipse.scada-${v}.noarch.rpm > rpm.properties
echo org.eclipse.scada-p2.rpmFileName=org.eclipse.scada-p2-${v}.noarch.rpm >> rpm.properties
popd
