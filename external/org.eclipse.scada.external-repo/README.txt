This is a project to build a P2 repository with externals that
are binaries and not part of Eclipse Orbit.

Maven/Tycho needs a P2 repository for consuming them.

So here we add the source (binary) jars and the
target (P2 converted) repository to the git repository.

We could also try to create the P2 repository during the main build
cycle instead of building them locally and checking in the result.
However the plan is to move these JARs to Eclipse Orbit.

If another bundle has to be added:
 - copy the bundle to "source"
 - run the "build.ant" inside the Eclipse IDE
 - add, commit and push 