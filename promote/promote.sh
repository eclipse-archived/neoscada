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

rsync -av /home/hudson/genie.eclipsescada/.hudson/jobs/genie.iot.eclipsescada/aggregator-release/workspace/staging/* /home/data/httpd/download.eclipse.org/eclipsescada/

# rebuild the composite repositories

ant -f updateRepos.ant -DbuildTypeLong=$buildTypeLong -DbuildTypeShort=$buildTypeShort -Drelease=$release