Long story short:

NOTE: This only works with maven 3.1.1+ (tested with 3.2.1)

First configure your stuff in "profile".

Ensure that ECLIPSE_COMMITER is set.

Then:

# creating the release cycle (only once per release - e.g. 0.2.x)

./createBranch
./pushBranch

# performing a release build (integration, milestone, release) 

./checkoutBranch
./mergeFromMaster

 -> check and resolve conflicts -> may need to commit

./applyVersion
./createTag

# build

./buildLocally [-r] # use -r for release builds

# check output and then

./pushTag
 
Also see: https://wiki.eclipse.org/EclipseSCADA/Release/Perform  
