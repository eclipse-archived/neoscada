The configurator created an ANT file for creating the MSI based setup.

You need to:

 * Have the Wix Toolset 3.7+ installed
 * Call the ant target "provision" from inside the Eclipse IDE with
   the option JRE -> Runtime JRE set to "Run in the same JRE as the workspace"
 
If you need to provision on one computer but run the Wix Toolset on another,
you can share the directory and:

 * Run the target "provision" from inside the IDE on the one computer
 * Run ant on the other computer with:
    ant -f build.ant -Dskip.provision=true
