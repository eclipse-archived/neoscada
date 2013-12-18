Long story short:

First configure your stuff in "profile".

Ensure that ECLIPSE_COMMITER is set.

Then:

# once per release cycle
createBranch
 
# once per release build

createTag

buildLocally

# check output and then

pushTag
 
  