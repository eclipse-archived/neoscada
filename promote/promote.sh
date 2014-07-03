#!/bin/bash

set -e

echo "buildTypeShort: $buildTypeShort"
echo "buildTypeLong: $buildTypeLong"
echo "release: $release"

test ! -z "$buildTypeShort"
test ! -z "$buildTypeLong"
test ! -z "$release"

rm -Rf "/home/data/httpd/download.eclipse.org/eclipsescada/repos/$buildTypeLong/$release"
rm -Rf "/home/data/httpd/download.eclipse.org/eclipsescada/updates/$buildTypeLong/$release"

rsync -av /jobs/genie.technology.scada/aggregator-release/workspace/staging/* /home/data/httpd/download.eclipse.org/eclipsescada/

# rebuild the composite repositories

ant -f updateRepos.ant -DbuildTypeLong=$buildTypeLong -DbuildTypeShort=$buildTypeShort -Drelease=$release