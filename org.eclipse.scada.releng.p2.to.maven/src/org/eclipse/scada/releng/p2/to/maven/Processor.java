/*******************************************************************************
 * Copyright (c) 2014, 2016 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *     Red Hat Inc - minor enhancements, allow creating an upload JAR
 *******************************************************************************/
package org.eclipse.scada.releng.p2.to.maven;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.equinox.internal.p2.metadata.IRequiredCapability;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.metadata.IArtifactKey;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.IRequirement;
import org.eclipse.equinox.p2.query.IQuery;
import org.eclipse.equinox.p2.query.IQueryResult;
import org.eclipse.equinox.p2.query.QueryUtil;
import org.eclipse.equinox.p2.repository.artifact.IArtifactDescriptor;
import org.eclipse.equinox.p2.repository.artifact.IArtifactRepository;
import org.eclipse.equinox.p2.repository.artifact.IArtifactRepositoryManager;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepository;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager;
import org.osgi.framework.BundleContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

@SuppressWarnings ( "restriction" )
public class Processor
{
    private static final SimpleDateFormat META_DF = new SimpleDateFormat ( "yyyyMMddHHmmss" );

    private static class Developer
    {
        String id;

        String name;

        String email;

        String url;
    }

    private final boolean dryRun = Boolean.getBoolean ( "dryRun" );

    private final boolean fakeForCentral = Boolean.getBoolean ( "fakeForCentral" );

    private final IProvisioningAgent agent;

    private final File output;

    private final MavenMapping mapping;

    private final URI repositoryLocation;

    private final Properties properties;

    private final DocumentBuilderFactory documentBuilderFactor;

    private final DocumentBuilder documentBuilder;

    private final TransformerFactory transformerFactory;

    private IMetadataRepository metaRepo;

    private IArtifactRepository artRepo;

    private final IMetadataRepositoryManager metaManager;

    private final IArtifactRepositoryManager artManager;

    private final Set<URI> validationRepositoryUris = new HashSet<> ();

    private final Map<URI, IMetadataRepository> validationRepositories = new HashMap<> ();

    private final Map<MavenReference, Set<String>> metadata = new HashMap<> ();

    private final List<Developer> developers = new LinkedList<> ();

    private final Set<MavenDependency> mavenDependencies = new HashSet<> ();

    private final Set<MavenReference> mavenExports = new HashSet<> ();

    private final List<String> errors = new LinkedList<> ();

    public Processor ( final IProvisioningAgent agent, final File output, final URI repositoryLocation, final Properties properties ) throws Exception
    {
        this.mapping = makeMappingInstance ( properties );

        this.agent = agent;
        this.output = output;
        this.properties = properties;
        this.repositoryLocation = repositoryLocation;

        this.metaManager = (IMetadataRepositoryManager)this.agent.getService ( IMetadataRepositoryManager.SERVICE_NAME );
        this.artManager = (IArtifactRepositoryManager)this.agent.getService ( IArtifactRepositoryManager.SERVICE_NAME );

        this.documentBuilderFactor = DocumentBuilderFactory.newInstance ();
        this.documentBuilder = this.documentBuilderFactor.newDocumentBuilder ();
        this.transformerFactory = TransformerFactory.newInstance ();

        loadDevelopers ();
    }

    private void loadDevelopers ()
    {
        final String devs = this.properties.getProperty ( "developers" );
        for ( final String dev : devs.split ( "\\s*,+\\s*" ) )
        {
            this.developers.add ( loadDeveloper ( dev ) );
        }
    }

    private Developer loadDeveloper ( final String dev )
    {
        final Developer result = new Developer ();
        result.id = dev;
        result.name = this.properties.getProperty ( String.format ( "developer.%s.name", dev ) );
        result.email = this.properties.getProperty ( String.format ( "developer.%s.email", dev ) );
        result.url = this.properties.getProperty ( String.format ( "developer.%s.url", dev ) );
        return result;
    }

    private static MavenMapping makeMappingInstance ( final Properties properties ) throws Exception
    {
        final String clazzName = properties.getProperty ( "implementation.mavenMapping", DefaultMavenMapping.class.getName () );

        if ( clazzName == null || clazzName.isEmpty () )
        {
            return new DefaultMavenMapping ( properties );
        }

        final BundleContext context = Activator.getDefault ().getContext ();

        final Class<?> clazz = context.getBundle ().loadClass ( clazzName );

        final Constructor<?> ctor = clazz.getConstructor ( Properties.class );
        return MavenMapping.class.cast ( ctor.newInstance ( properties ) );
    }

    public void addValidationRepository ( final URI uri )
    {
        this.validationRepositoryUris.add ( uri );
    }

    public void process ( final IProgressMonitor pm ) throws Exception
    {
        this.output.mkdirs ();

        System.out.println ( "Loading metadata..." );
        this.metaRepo = this.metaManager.loadRepository ( this.repositoryLocation, pm );
        System.out.println ( "Loading artifacts..." );
        this.artRepo = this.artManager.loadRepository ( this.repositoryLocation, pm );
        System.out.println ( "done!" );

        for ( final URI uri : this.validationRepositoryUris )
        {
            System.out.println ( "Loading validation repository: " + uri );
            final IMetadataRepository repo = this.metaManager.loadRepository ( uri, pm );
            this.validationRepositories.put ( uri, repo );
            System.out.println ( "Done!" );
        }

        final IQuery<IInstallableUnit> query = QueryUtil.createIUAnyQuery ();
        final IQueryResult<IInstallableUnit> result = this.metaRepo.query ( query, pm );

        for ( final IInstallableUnit iu : result )
        {
            processUnit ( iu, pm );
        }

        writeUploadScript ();

        for ( final Map.Entry<MavenReference, Set<String>> entry : this.metadata.entrySet () )
        {
            writeMetaData ( entry.getKey (), entry.getValue () );
        }

    }

    private void writeUploadScript () throws IOException
    {
        final Path path = this.output.toPath ().resolve ( "upload.sh" );

        final int maxJobs = 5;

        try ( PrintWriter script = new PrintWriter ( Files.newBufferedWriter ( path ) ) )
        {
            script.println ( "#!/bin/bash" );
            script.println ();
            script.println ( "set -e" );
            script.println ();
            script.println ( "REPO=${REPO:-https://oss.sonatype.org/service/local/staging/deploy/maven2/}" );
            script.println ( "ID=${ID:-ossrh}" );
            script.println ();
            script.format ( "function waitMax { while [ $(jobs -rp | wc -l) -ge %s ] ; do sleep 1; done }%n%n", maxJobs );

            final List<MavenReference> exports = getMavenExports ();
            Collections.sort ( exports, MavenReference.COMPARATOR );

            for ( final MavenReference export : exports )
            {
                if ( maxJobs > 1 )
                {
                    script.print ( "waitMax; " );
                }

                script.print ( "mvn gpg:sign-and-deploy-file -Durl=\"$REPO\" -DrepositoryId=$ID " );
                script.format ( " -DpomFile=%s", makePomName ( export ) );
                script.format ( " -Dfile=%s", makeFileName ( export ) );

                if ( export.getClassifier () != null )
                {
                    script.format ( " -Dclassifier=%s", export.getClassifier () );
                }

                if ( maxJobs > 1 )
                {
                    script.println ( " &" );
                }
            }

            script.println ();
            script.println ( "wait" );
        }
    }

    private static String makePomName ( final MavenReference export )
    {
        return String.format ( "%1$s/%2$s/%3$s/%2$s-%3$s.pom", export.getGroupId ().replace ( '.', File.separatorChar ), export.getArtifactId (), export.getVersion () );
    }

    private static String makeFileName ( final MavenReference export )
    {
        final String groupPath = export.getGroupId ().replace ( '.', File.separatorChar );

        if ( export.getClassifier () == null )
        {
            return String.format ( "%1$s/%2$s/%3$s/%2$s-%3$s.jar", groupPath, export.getArtifactId (), export.getVersion () );
        }
        else
        {
            return String.format ( "%1$s/%2$s/%3$s/%2$s-%3$s-%4$s.jar", groupPath, export.getArtifactId (), export.getVersion (), export.getClassifier () );
        }
    }

    private void writeMetaData ( final MavenReference key, final Set<String> value ) throws Exception
    {
        final File base = makeBase ( key.getGroupId (), key.getArtifactId () );
        final File file = new File ( base, "maven-metadata.xml" );

        System.out.println ( "Write meta data: " + file );

        final Document doc = this.documentBuilder.newDocument ();

        final Element main = doc.createElement ( "metadata" );
        doc.appendChild ( main );

        addElement ( main, "groupId", key.getGroupId () );
        addElement ( main, "artifactId", key.getArtifactId () );
        addElement ( main, "version", key.getVersion () );

        final Element v = doc.createElement ( "versioning" );
        main.appendChild ( v );
        final Element vs = doc.createElement ( "versions" );
        v.appendChild ( vs );

        for ( final String version : value )
        {
            addElement ( vs, "version", version );
        }

        addElement ( v, "lastUpdated", Processor.META_DF.format ( new Date () ) );

        saveXml ( doc, file );

        makeChecksum ( "MD5", file, new File ( base, "maven-metadata.xml.md5" ) );
        makeChecksum ( "SHA1", file, new File ( base, "maven-metadata.xml.sha1" ) );
    }

    private void processUnit ( final IInstallableUnit iu, final IProgressMonitor pm ) throws Exception
    {
        final IArtifactKey art = findArtifact ( iu );
        if ( art == null )
        {
            System.out.println ( "Ignore: " + iu );
            return;
        }

        System.out.println ( "IU : " + iu + " -> " + art );

        if ( ignoreMirror ( iu ) )
        {
            System.out.println ( "Action: SKIP" );
            return;
        }

        for ( final Map.Entry<String, String> entry : iu.getProperties ().entrySet () )
        {
            System.out.println ( String.format ( "\t%s -> %s", entry.getKey (), entry.getValue () ) );
        }

        final MavenReference ref = this.mapping.makeReference ( iu );

        System.out.println ( "POM : " + ref );

        final File base = makeBase ( ref.getGroupId (), ref.getArtifactId () );
        final File versionBase = new File ( base, ref.getVersion () );
        versionBase.mkdirs ();
        System.out.println ( "\tStoring to: " + base );

        mirrorArtifact ( art, versionBase, ref, pm );

        if ( ref.getClassifier () == null )
        {
            // only do this for main artifacts

            final Set<MavenDependency> deps = makeDependencies ( iu, pm );
            makePom ( ref, versionBase, deps, iu );
            makeMetaData ( ref, versionBase );
            makeFake ( ref, versionBase, "javadoc" );
            makeFake ( ref, versionBase, "sources" );

            this.mavenDependencies.addAll ( deps );
        }

        this.mavenExports.add ( ref );
    }

    private Set<MavenDependency> makeDependencies ( final IInstallableUnit iu, final IProgressMonitor pm ) throws Exception
    {
        final Set<MavenDependency> result = new HashSet<> ();

        for ( final IRequirement req : iu.getRequirements () )
        {
            if ( ! ( req instanceof IRequiredCapability ) )
            {
                continue;
            }
            final MavenDependency dep = makeDependency ( iu, (IRequiredCapability)req, pm );
            if ( dep != null )
            {
                result.add ( dep );
            }
        }

        return result;
    }

    private MavenDependency makeDependency ( final IInstallableUnit iu, final IRequiredCapability req, final IProgressMonitor pm ) throws Exception
    {
        if ( ignoreDependency ( req ) )
        {
            return null;
        }

        System.out.println ( "\tDep: " + req + " NS: " + req.getNamespace () );

        final IInstallableUnit depIu = findBest ( findCandidates ( req, pm ) );

        if ( depIu == null )
        {
            if ( req.getMin () <= 0 )
            {
                return null;
            }
            throw new IllegalArgumentException ( String.format ( "Unable to find dependency - req: %s (min: %s)", req, req.getMin () ) );
        }

        if ( iu.equals ( depIu ) )
        {
            return null;
        }

        final MavenReference ref = this.mapping.makeReference ( depIu );

        if ( ref == null )
        {
            return null;
        }

        final MavenDependency result = new MavenDependency ();

        result.setGroupId ( ref.getGroupId () );
        result.setArtifactId ( ref.getArtifactId () );
        result.setVersion ( ref.getVersion () );

        result.setOptional ( req.getMin () <= 0 );

        System.out.println ( "\t\tResolve to: " + result );

        return result;
    }

    private Set<IInstallableUnit> findCandidates ( final IRequirement req, final IProgressMonitor pm )
    {
        final IQuery<IInstallableUnit> query = QueryUtil.createMatchQuery ( req.getMatches () );

        {
            final Set<IInstallableUnit> result = this.metaRepo.query ( query, pm ).toUnmodifiableSet ();
            if ( !result.isEmpty () )
            {
                return result;
            }
        }

        for ( final IMetadataRepository repo : this.validationRepositories.values () )
        {
            final Set<IInstallableUnit> result = repo.query ( query, pm ).toUnmodifiableSet ();
            if ( !result.isEmpty () )
            {
                return result;
            }
        }

        return Collections.emptySet ();
    }

    private IInstallableUnit findBest ( final Set<IInstallableUnit> candidates )
    {
        if ( candidates.isEmpty () )
        {
            return null;
        }
        return candidates.iterator ().next ();
    }

    private void makeMetaData ( final MavenReference ref, final File versionBase ) throws Exception
    {
        final Document doc = this.documentBuilder.newDocument ();
        final Element metadata = doc.createElement ( "metadata" );
        doc.appendChild ( metadata );

        addElement ( metadata, "groupId", ref.getGroupId () );
        addElement ( metadata, "artifactId", ref.getArtifactId () );
        addElement ( metadata, "version", ref.getVersion () );

        final File file = new File ( versionBase, "maven-metadata.xml" );
        saveXml ( doc, file );

        makeChecksum ( "MD5", file, new File ( versionBase, "maven-metadata.xml.md5" ) );
        makeChecksum ( "SHA1", file, new File ( versionBase, "maven-metadata.xml.sha1" ) );
    }

    private void makeFake ( final MavenReference ref, final File versionBase, final String classifier ) throws Exception
    {
        if ( !this.fakeForCentral )
        {
            return;
        }

        final String name = ref.getArtifactId () + "-" + ref.getVersion () + "-" + classifier + ".jar";
        final File file = new File ( versionBase, name );

        this.mavenExports.add ( new MavenReference ( ref.getGroupId (), ref.getArtifactId (), ref.getVersion (), classifier ) );

        if ( file.exists () )
        {
            return;
        }

        try ( JarOutputStream jar = new JarOutputStream ( new FileOutputStream ( file ) ) )
        {
        }

        makeChecksum ( "MD5", file, new File ( versionBase, name + ".md5" ) );
        makeChecksum ( "SHA1", file, new File ( versionBase, name + ".sha1" ) );
    }

    private void makePom ( final MavenReference ref, final File versionBase, final Set<MavenDependency> deps, final IInstallableUnit iu ) throws Exception
    {
        final Document doc = this.documentBuilder.newDocument ();
        final Element project = doc.createElementNS ( "http://maven.apache.org/POM/4.0.0", "project" );
        project.setAttributeNS ( "http://www.w3.org/2001/XMLSchema-instance", "xsi:schemaLocation", "http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd" );
        doc.appendChild ( project );

        addElement ( project, "modelVersion", "4.0.0" );
        addElement ( project, "groupId", ref.getGroupId () );
        addElement ( project, "artifactId", ref.getArtifactId () );
        addElement ( project, "version", ref.getVersion () );

        addElement ( project, "url", makeProjectUrl ( iu ) );

        // name and description

        String name = iu.getProperty ( "org.eclipse.equinox.p2.name", null );
        if ( name == null )
        {
            name = String.format ( "%s:%s", ref.getGroupId (), ref.getArtifactId () );
        }

        String description = iu.getProperty ( "org.eclipse.equinox.p2.description", null );
        if ( description == null )
        {
            description = name;
        }

        addElement ( project, "name", name );
        addElement ( project, "description", description );

        addDevelopers ( project );

        // license

        if ( ref.getArtifactId ().startsWith ( "org.eclipse." ) )
        {
            addEpl ( project );
        }
        else
        {
            this.errors.add ( String.format ( "%s: no license information", ref ) );
        }

        final String scm = loadScm ( versionBase, ref );
        if ( scm == null )
        {
            this.errors.add ( String.format ( "%s: no scm information", ref ) );
        }
        else
        {
            makeScm ( doc, project, scm );
        }

        if ( !deps.isEmpty () )
        {
            final Element depsEle = doc.createElement ( "dependencies" );
            project.appendChild ( depsEle );

            for ( final MavenDependency dep : deps )
            {
                final Element depEle = doc.createElement ( "dependency" );
                depsEle.appendChild ( depEle );
                addElement ( depEle, "groupId", dep.getGroupId () );
                addElement ( depEle, "artifactId", dep.getArtifactId () );
                addElement ( depEle, "version", dep.getVersion () );
                if ( dep.isOptional () )
                {
                    addElement ( depEle, "optional", "true" );
                }
            }
        }

        final File pomFile = new File ( versionBase, ref.getArtifactId () + "-" + ref.getVersion () + ".pom" );

        saveXml ( doc, pomFile );

        makeChecksum ( "MD5", pomFile, new File ( versionBase, ref.getArtifactId () + "-" + ref.getVersion () + ".pom.md5" ) );
        makeChecksum ( "SHA1", pomFile, new File ( versionBase, ref.getArtifactId () + "-" + ref.getVersion () + ".pom.sha1" ) );

        addMetaDataVersion ( ref );
    }

    private void makeScm ( final Document doc, final Element project, final String scm )
    {
        final String[] scmToks = scm.split ( ";", 2 );

        final Element scmEle = doc.createElement ( "scm" );
        project.appendChild ( scmEle );
        addElement ( scmEle, "connection", scm );
        addElement ( scmEle, "developerConnection", scm );

        if ( scmToks.length > 0 )
        {
            final String key = "scm.url." + scmToks[0];
            final String url = this.properties.getProperty ( key );
            if ( url == null )
            {
                throw new IllegalStateException ( String.format ( "SCM URL missing for key '%s'", key ) );
            }
            addElement ( scmEle, "url", url );
        }
    }

    private void addDevelopers ( final Element project )
    {
        final Document doc = project.getOwnerDocument ();

        final Element devs = doc.createElement ( "developers" );
        project.appendChild ( devs );

        for ( final Developer dev : this.developers )
        {
            final Element devNode = doc.createElement ( "developer" );
            devs.appendChild ( devNode );

            addElement ( devNode, "id", dev.id );
            addElement ( devNode, "name", dev.name );
            addElement ( devNode, "email", dev.email );
            addElement ( devNode, "url", dev.url );
        }
    }

    private String loadScm ( final File versionBase, final MavenReference ref )
    {
        try
        {
            final File jarFile = new File ( versionBase, ref.getArtifactId () + "-" + ref.getVersion () + ".jar" );
            if ( !jarFile.isFile () )
            {
                // dry run
                return null;
            }

            try ( final JarFile jar = new JarFile ( jarFile ) )
            {
                final Manifest mf = jar.getManifest ();
                final String scm = mf.getMainAttributes ().getValue ( "Eclipse-SourceReferences" );
                return scm;
            }
        }
        catch ( final Exception e )
        {
            e.printStackTrace ();
        }

        return null;
    }

    private void addEpl ( final Element project )
    {
        final Document doc = project.getOwnerDocument ();

        final Element lics = doc.createElement ( "licenses" );
        project.appendChild ( lics );

        final Element lic = doc.createElement ( "license" );
        lics.appendChild ( lic );

        addElement ( lic, "name", "The Eclipse Public License Version 1.0" );
        addElement ( lic, "url", "http://www.eclipse.org/legal/epl-v10.html" );
        addElement ( lic, "distribution", "repo" );
    }

    private String makeProjectUrl ( final IInstallableUnit iu )
    {
        String url = iu.getProperty ( "org.eclipse.equinox.p2.doc.url", null );
        if ( url == null || url.isEmpty () )
        {
            url = this.properties.getProperty ( "default.project.url" );
        }
        return url;
    }

    private void addMetaDataVersion ( final MavenReference ref )
    {
        final MavenReference metaRef = new MavenReference ( ref.getGroupId (), ref.getArtifactId (), "1" );
        Set<String> versions = this.metadata.get ( metaRef );
        if ( versions == null )
        {
            versions = new HashSet<> ();
            this.metadata.put ( metaRef, versions );
        }
        versions.add ( ref.getVersion () );
    }

    private void addElement ( final Element parent, final String name, final String value )
    {
        if ( value == null )
        {
            return;
        }

        final Element ele = parent.getOwnerDocument ().createElement ( name );
        parent.appendChild ( ele );
        ele.appendChild ( parent.getOwnerDocument ().createTextNode ( value ) );
    }

    private void saveXml ( final Document doc, final File file ) throws Exception
    {
        final Transformer transformer = this.transformerFactory.newTransformer ();

        transformer.setOutputProperty ( OutputKeys.INDENT, "yes" );
        transformer.setOutputProperty ( "{http://xml.apache.org/xslt}indent-amount", "2" );

        final DOMSource source = new DOMSource ( doc );
        final StreamResult result = new StreamResult ( file );

        transformer.transform ( source, result );
    }

    private void mirrorArtifact ( final IArtifactKey art, final File versionBase, final MavenReference ref, final IProgressMonitor pm ) throws Exception
    {
        if ( this.dryRun )
        {
            return;
        }

        final File jarFile = new File ( versionBase, ref.toFileName () );

        try ( OutputStream output = new FileOutputStream ( jarFile ) )
        {
            final IArtifactDescriptor desc = this.artRepo.createArtifactDescriptor ( art );
            System.out.println ( "Storing to: " + jarFile );
            this.artRepo.getArtifact ( desc, output, pm );
        }

        makeChecksum ( "MD5", jarFile, new File ( versionBase, ref.toFileName ( "md5" ) ) );
        makeChecksum ( "SHA1", jarFile, new File ( versionBase, ref.toFileName ( "sha1" ) ) );
    }

    private void makeChecksum ( final String mdName, final File sourceFile, final File targetFile ) throws Exception
    {
        final MessageDigest md = MessageDigest.getInstance ( mdName );
        final byte[] buffer = new byte[4096];

        try ( InputStream input = new BufferedInputStream ( new FileInputStream ( sourceFile ) ) )
        {
            int len;
            while ( ( len = input.read ( buffer ) ) > 0 )
            {
                md.update ( buffer, 0, len );
            }
        }
        final byte[] result = md.digest ();
        final StringBuilder sb = new StringBuilder ( result.length * 2 );
        for ( final byte b : result )
        {
            sb.append ( String.format ( "%02x", b ) );
        }

        try ( PrintWriter pw = new PrintWriter ( targetFile ) )
        {
            pw.print ( sb.toString () );
        }
    }

    private boolean ignoreMirror ( final IInstallableUnit iu )
    {
        String value = this.properties.getProperty ( "mirror." + iu.getId (), null );
        if ( value != null )
        {
            return !Boolean.parseBoolean ( value );
        }

        value = this.properties.getProperty ( "external." + iu.getId () );
        if ( value != null )
        {
            return true;
        }

        // default
        return false;
    }

    private boolean ignoreDependency ( final IRequiredCapability req )
    {
        final String ns = req.getNamespace ();
        final String name = req.getName ();

        final String value = this.properties.getProperty ( "dependency." + ns + "." + name + ".ignore", "false" );
        return Boolean.parseBoolean ( value );
    }

    private File makeBase ( final String groupId, final String artifactId )
    {
        final String toks[] = groupId.split ( "\\." );

        File file = this.output;
        for ( final String tok : toks )
        {
            file = new File ( file, tok );
        }

        return new File ( file, artifactId );
    }

    private IArtifactKey findArtifact ( final IInstallableUnit iu )
    {
        for ( final IArtifactKey key : iu.getArtifacts () )
        {
            if ( "osgi.bundle".equals ( key.getClassifier () ) )
            {
                return key;
            }
        }
        return null;
    }

    /**
     * Get all dependencies which got declared by this build
     *
     * @return a sorted list of dependencies
     */
    public List<MavenDependency> getMavenDependencies ()
    {
        final List<MavenDependency> refs = new ArrayList<> ( this.mavenDependencies );
        Collections.sort ( refs, MavenDependency.COMPARATOR );
        return refs;
    }

    public List<MavenReference> getMavenExports ()
    {
        final List<MavenReference> result = new ArrayList<> ( this.mavenExports );
        Collections.sort ( result, MavenReference.COMPARATOR );
        return result;
    }

    public List<String> getErrors ()
    {
        return this.errors;
    }
}
