Short explanation
===================

heat.exe has problems with long filenames.

Change the "subst.drive" ant property to a free drive letter:

 ant -f build.ant -Dsubst.drive=M:

The default is "K:".

Long explanation
=================

The full path of a file name in windows might not exceed about 250 characters
for some windows applications.

Your Eclipse workspace hosting the project might already be located at some sub-directory,
the deployment mechanism creates a directory structure and the P2 provisioner extracts
the directories and rather lengthy OSGi bundle names.

This leads to a situation of file names longer than 250 rather quickly. And while
neither Java nor Windows itself has problem with that, the .NET based "heat.exe" tool
of the Wix Toolset does.

The easiest workaround is to remove all those, rather lengthy, prefix of the actual
staging directory by using the "subst" command.

So the ant script creates a virtual drive letter to the target path, which solves
the issue for most cases.

The default drive letter it uses is "K:". If this letter is already used by your
system then you can specify a different drive letter using the ant property
"subst.drive".

 ant -f build.ant -Dsubst.drive=M:
 
Note: At the moment it is not supported to skip the "subst" call