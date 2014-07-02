#!/bin/bash

set -e

echo "buildTypeLong: $buildTypeLong"
echo "release: $release"

test ! -z "$buildTypeLong"
test ! -z "$release"

rm -Rf "/home/data/httpd/download.eclipse.org/eclipsescada/repos/$buildTypeLong/$release"
rm -Rf "/home/data/httpd/download.eclipse.org/eclipsescada/updates/$buildTypeLong/$release"

rsync -av /jobs/genie.technology.scada/aggregator-release/workspace/staging/* /home/data/httpd/download.eclipse.org/eclipsescada/