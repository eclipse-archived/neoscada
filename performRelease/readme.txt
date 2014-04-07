Long story short:

First configure your stuff in "profile".

Ensure that ECLIPSE_COMMITER is set.

Then:

# once per release cycle
createBranch
 
# once per release build

createTag     # for the first tag
createTag -m  # for the following tags

#build

buildLocally

# check output and then

pushTag
 
Also see: https://wiki.eclipse.org/EclipseSCADA/Release/Perform  
