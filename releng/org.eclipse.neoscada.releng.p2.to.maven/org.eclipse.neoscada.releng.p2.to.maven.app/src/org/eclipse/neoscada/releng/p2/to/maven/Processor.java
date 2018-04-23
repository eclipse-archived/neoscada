/*******************************************************************************
 * Copyright (c) 2014, 2017 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *     Red Hat Inc - enhancements
 *******************************************************************************/
package org.eclipse.neoscada.releng.p2.to.maven;

import static java.lang.Integer.getInteger;
import static java.util.Collections.singletonList;
import static org.eclipse.neoscada.releng.p2.to.maven.License.EPL;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import java.lang.reflect.Constructor;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
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
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;
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
import org.eclipse.equinox.p2.core.ProvisionException;
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
import org.osgi.framework.Constants;
import org.osgi.framework.Version;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.common.io.ByteStreams;

@SuppressWarnings ( "restriction" )
public class Processor implements AutoCloseable
{
    private static final SimpleDateFormat META_DF = new SimpleDateFormat ( "yyyyMMddHHmmss" );

    @FunctionalInterface
    private interface IOFunction<T, R>
    {
        R apply ( T t ) throws IOException;
    }

    private static class Developer
    {
        String id;

        String name;

        String email;

        String url;

        String organization;

        String organizationUrl;
    }

    private final boolean scrubJars;

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

    private Path tmpBndTools;

    private final String organizationName;

    private final String organizationUrl;

    private final LicenseProvider licenseProvider;

    private final boolean checkQualifier;

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

        this.organizationName = properties.getProperty ( "pom.organization.name", "Eclipse Foundation" );
        this.organizationUrl = properties.getProperty ( "pom.organization.url", "http://www.eclipse.org/" );

        this.licenseProvider = new LicenseProvider ( this.properties );

        this.scrubJars = Boolean.parseBoolean ( properties.getProperty ( "scrubJars" ) );

        this.checkQualifier = Boolean.parseBoolean ( properties.getProperty ( "checkQualifier", "true" ) );

        loadDevelopers ();
        setupBndTools ();
    }

    private void setupBndTools () throws IOException
    {
        this.tmpBndTools = Files.createTempFile ( "bndtools-", ".jar" );
        final URL url = new URL ( "http://repo1.maven.org/maven2/biz/aQute/bnd/biz.aQute.bnd/3.3.0/biz.aQute.bnd-3.3.0.jar" );

        System.out.format ( "Loading: %s...%n", url );

        try ( InputStream in = openConnection ( url ).getInputStream ();
              OutputStream out = Files.newOutputStream ( this.tmpBndTools ); )
        {
            ByteStreams.copy ( in, out );
        }

        System.out.format ( "Loading: %s... done!%n", url );
    }

    @Override
    public void close () throws Exception
    {
        Files.deleteIfExists ( this.tmpBndTools );
    }

    private void loadDevelopers ()
    {
        final String devs = this.properties.getProperty ( "developers" );
        if ( devs == null )
        {
            return;
        }

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
        result.organization = this.properties.getProperty ( String.format ( "developer.%s.organization", dev ) );
        result.organizationUrl = this.properties.getProperty ( String.format ( "developer.%s.organizationUrl", dev ) );
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
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor ();
        try
        {
            try
            {
                scheduler.schedule ( new Runnable () {
                    @Override
                    public void run ()
                    {
                        System.out.println ( "... still alive ..." );
                    }
                }, 10, TimeUnit.SECONDS );
                processInternal ( pm );
            }
            catch ( Exception e )
            {
                throw e;
            }
        }
        finally
        {
            scheduler.shutdown ();
        }
    }

    private void processInternal ( final IProgressMonitor pm ) throws ProvisionException, Exception
    {
        this.output.mkdirs ();

        System.out.println ( "Loading metadata..." );
        this.metaRepo = this.metaManager.loadRepository ( this.repositoryLocation, pm );
        System.out.println ( "Loading artifacts..." );
        this.artRepo = this.artManager.loadRepository ( this.repositoryLocation, pm );
        System.out.println ( "done!" );

        for ( final URI uri : this.validationRepositoryUris )
        {
            System.out.format ( "Loading validation repository: %s%n", uri );
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

    private void writeUploadScript () throws Exception
    {
        final List<MavenReference> exports = getMavenExports ();
        Collections.sort ( exports, MavenReference.COMPARATOR );

        final Set<MavenReference> skips = new HashSet<> ();

        // process only main artifacts as first step

        for ( final MavenReference export : exports )
        {
            if ( export.getClassifier () != null )
            {
                continue;
            }

            if ( !shouldUpload ( export ) )
            {
                System.out.println ( "Skipping upload of: " + export );
                skips.add ( export );
            }
        }

        final Path path = this.output.toPath ().resolve ( "upload.sh" );
        final int maxJobs = Integer.getInteger ( "maxUploadJobs", 1 );

        try ( final PrintWriter script = new PrintWriter ( Files.newBufferedWriter ( path ) ) )
        {
            script.println ( "#!/bin/bash" );
            script.println ();
            script.println ( "set -e" );
            script.println ();
            script.println ( "REPO=${REPO:-https://oss.sonatype.org/service/local/staging/deploy/maven2/}" );
            script.println ( "ID=${ID:-ossrh}" );
            script.println ( "MVN=${MVN:-mvn}" );
            script.println ();

            if ( maxJobs > 1 )
            {
                script.format ( "function waitMax { while [ $(jobs -rp | wc -l) -ge %s ] ; do sleep 1; done }%n%n", maxJobs );
            }

            for ( final MavenReference export : exports )
            {
                if ( skips.contains ( new MavenReference ( export.getGroupId (), export.getArtifactId (), export.getVersion () ) ) )
                {
                    script.println ( "# skipping - " + export );
                    continue;
                }

                if ( maxJobs > 1 )
                {
                    script.print ( "waitMax; " );
                }

                script.print ( "\"$MVN\" \"$@\" gpg:sign-and-deploy-file -Durl=\"$REPO\" -DrepositoryId=$ID " );
                script.format ( " -DpomFile=%s", makePomName ( export ) );
                script.format ( " -Dfile=%s", makeFileName ( export ) );

                if ( export.getClassifier () != null )
                {
                    script.format ( " -Dclassifier=%s", export.getClassifier () );
                }

                if ( maxJobs > 1 )
                {
                    script.print ( " &" );
                }

                script.println ();
            }

            script.println ();

            if ( maxJobs > 1 )
            {
                script.println ( "wait" );
            }
        }
    }

    private boolean shouldUpload ( final MavenReference ref ) throws Exception
    {
        System.out.format ( "baseline validation: %s%n", ref );

        final String group = ref.getGroupId ().replace ( '.', '/' );

        final String uri = String.format ( "http://central.maven.org/maven2/%s/%s/%s/%s", group, ref.getArtifactId (), ref.getVersion (), ref.toFileName () );

        final URL url = new URL ( uri );
        final HttpURLConnection con = openConnection ( url );
        con.setAllowUserInteraction ( false );

        con.setConnectTimeout ( getInteger ( "maven.central.connectTimeout", getInteger ( "maven.central.timeout", 0 ) ) );
        con.setReadTimeout ( getInteger ( "maven.central.readTimeout", getInteger ( "maven.central.timeout", 0 ) ) );

        con.connect ();
        try
        {
            final int rc = con.getResponseCode ();
            System.out.format ( "\t%s -> %s%n", url, rc );
            if ( rc == 404 )
            {
                // file is not there ... upload
                return true;
            }

            final Path tmp = Files.createTempFile ( null, ".jar" );
            try
            {
                try ( final InputStream in = con.getInputStream ();
                      final OutputStream out = Files.newOutputStream ( tmp ) )
                {
                    ByteStreams.copy ( in, out );
                }

                performBaselineCheck ( makeJarFile ( makeVersionBase ( ref ), ref ), tmp );
            }
            finally
            {
                Files.deleteIfExists ( tmp );
            }
        }
        finally
        {
            con.disconnect ();
        }

        // don't upload, since the bundle is already there
        return false;
    }

    private HttpURLConnection openConnection ( final URL url ) throws IOException
    {
        final String host = this.properties.getProperty ( "local.proxy.host" );
        final String port = this.properties.getProperty ( "local.proxy.port" );

        if ( host != null && port != null && !host.isEmpty () && !port.isEmpty () )
        {
            final Proxy proxy = new Proxy ( Type.HTTP, new InetSocketAddress ( host, Integer.parseInt ( port ) ) );
            return (HttpURLConnection)url.openConnection ( proxy );
        }
        else
        {
            return (HttpURLConnection)url.openConnection ();
        }
    }

    private void performBaselineCheck ( final Path newFile, final Path oldFile ) throws Exception
    {
        System.out.format ( "\tComparing - %s - %s%n", newFile, oldFile );

        if ( this.checkQualifier )
        {
            final String oldQualifier = readQualifier ( oldFile );
            final String newQualifier = readQualifier ( newFile );

            System.out.format ( "\tQualifier : %s -> %s%n", oldQualifier, newQualifier );

            if ( oldQualifier != null && newQualifier != null )
            {
                if ( !oldQualifier.equals ( newQualifier ) )
                {
                    // we have the same base version, now check for the qualifier
                    this.errors.add ( String.format ( "Qualifier change! %s : %s -> %s", newFile.getFileName (), oldQualifier, newQualifier ) );
                }
            }
        }

        // compare with downloaded version (which is the same version)

        final ProcessBuilder pb = new ProcessBuilder ( "java", "-jar", this.tmpBndTools.toString (), "baseline", newFile.toAbsolutePath ().toString (), oldFile.toAbsolutePath ().toString () );
        pb.redirectError ( Redirect.INHERIT );

        final Path tmp = Files.createTempFile ( null, null );
        try
        {
            pb.redirectOutput ( tmp.toFile () );

            final Process process = pb.start ();
            process.waitFor ();

            final List<String> lines = Files.readAllLines ( tmp, StandardCharsets.UTF_8 );
            for ( final String line : lines )
            {
                if ( line.contains ( "MAJOR" ) || line.contains ( "MINOR" ) )
                {
                    // if versions are the same but bundles are incompatible, fail
                    this.errors.add ( String.format ( "Baseline validation failed for: %s - %s", newFile.getFileName (), String.join ( "\n", lines ) ) );
                }
            }
        }
        finally
        {
            Files.deleteIfExists ( tmp );
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
        final Path base = makeBase ( key.getGroupId (), key.getArtifactId () );
        final Path file = base.resolve ( "maven-metadata.xml" );

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

        makeChecksum ( "MD5", file, base.resolve ( "maven-metadata.xml.md5" ) );
        makeChecksum ( "SHA1", file, base.resolve ( "maven-metadata.xml.sha1" ) );
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

        final List<MavenReference> refs = this.mapping.makeReference ( iu );

        if ( refs == null )
        {
            throw new IllegalStateException ( "Exported artifact must be mappable" );
        }
        if ( refs.size () != 1 )
        {
            throw new IllegalStateException ( "Exported artifact must be mappable to exactly one Maven reference - currently: " + refs );
        }

        final MavenReference ref = refs.get ( 0 );

        System.out.println ( "POM : " + ref );

        final Path versionBase = makeVersionBase ( ref );
        Files.createDirectories ( versionBase );
        System.out.println ( "\tStoring to: " + versionBase );

        mirrorArtifact ( art, versionBase, ref, pm );

        if ( ref.getClassifier () == null )
        {
            processMainArtifact ( iu, pm, ref, versionBase );
        }

        this.mavenExports.add ( ref );
    }

    private Path makeVersionBase ( final MavenReference ref )
    {
        final Path base = makeBase ( ref.getGroupId (), ref.getArtifactId () );
        return base.resolve ( ref.getVersion () );
    }

    private void processMainArtifact ( final IInstallableUnit iu, final IProgressMonitor pm, final MavenReference ref, final Path versionBase ) throws Exception
    {
        final Set<MavenDependency> deps = makeDependencies ( iu, pm );
        makePom ( ref, versionBase, deps, iu );
        makeMetaData ( ref, versionBase );
        makeFake ( ref, versionBase, "javadoc" );
        makeFake ( ref, versionBase, "sources" );

        this.mavenDependencies.addAll ( deps );
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
            final List<MavenDependency> deps = makeDependency ( iu, (IRequiredCapability)req, pm );
            if ( deps != null )
            {
                result.addAll ( deps );
            }
        }

        return result;
    }

    private List<MavenDependency> makeDependency ( final IInstallableUnit iu, final IRequiredCapability req, final IProgressMonitor pm ) throws Exception
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

        final List<MavenReference> refs = this.mapping.makeReference ( depIu );

        if ( refs == null )
        {
            return null;
        }

        final List<MavenDependency> result = new ArrayList<> ( refs.size () );

        for ( final MavenReference ref : refs )
        {
            final MavenDependency dep = new MavenDependency ();

            dep.setGroupId ( ref.getGroupId () );
            dep.setArtifactId ( ref.getArtifactId () );
            dep.setVersion ( ref.getVersion () );

            dep.setOptional ( req.getMin () <= 0 );

            result.add ( dep );

            System.out.println ( "\t\tResolve to: " + result );
        }

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

    private void makeMetaData ( final MavenReference ref, final Path versionBase ) throws Exception
    {
        final Document doc = this.documentBuilder.newDocument ();
        final Element metadata = doc.createElement ( "metadata" );
        doc.appendChild ( metadata );

        addElement ( metadata, "groupId", ref.getGroupId () );
        addElement ( metadata, "artifactId", ref.getArtifactId () );
        addElement ( metadata, "version", ref.getVersion () );

        final Path file = versionBase.resolve ( "maven-metadata.xml" );
        saveXml ( doc, file );

        makeChecksum ( "MD5", file, versionBase.resolve ( "maven-metadata.xml.md5" ) );
        makeChecksum ( "SHA1", file, versionBase.resolve ( "maven-metadata.xml.sha1" ) );
    }

    private void makeFake ( final MavenReference ref, final Path versionBase, final String classifier ) throws Exception
    {
        if ( !this.fakeForCentral )
        {
            return;
        }

        final String name = ref.getArtifactId () + "-" + ref.getVersion () + "-" + classifier + ".jar";
        final Path file = versionBase.resolve ( name );

        this.mavenExports.add ( new MavenReference ( ref.getGroupId (), ref.getArtifactId (), ref.getVersion (), classifier ) );

        if ( Files.exists ( file ) )
        {
            return;
        }

        try ( JarOutputStream jar = new JarOutputStream ( Files.newOutputStream ( file ) ) )
        {
            // create an empty JAR
        }

        makeChecksum ( "MD5", file, versionBase.resolve ( name + ".md5" ) );
        makeChecksum ( "SHA1", file, versionBase.resolve ( name + ".sha1" ) );
    }

    private void makePom ( final MavenReference ref, final Path versionBase, final Set<MavenDependency> deps, final IInstallableUnit iu ) throws Exception
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

        addOrganization ( project );

        addDevelopers ( project );

        // license

        final List<License> lics = this.licenseProvider.getLicenses ( iu );
        if ( lics != null )
        {
            addLicense ( project, lics );
        }
        else if ( ref.getArtifactId ().startsWith ( "org.eclipse." ) )
        {
            addLicense ( project, singletonList ( EPL ) );
        }
        else
        {
            this.errors.add ( String.format ( "%s: no license information", ref ) );
        }

        makeScm ( iu, doc, project, versionBase, ref );

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

        final Path pomFile = versionBase.resolve ( ref.getArtifactId () + "-" + ref.getVersion () + ".pom" );

        saveXml ( doc, pomFile );

        makeChecksum ( "MD5", pomFile, versionBase.resolve ( ref.getArtifactId () + "-" + ref.getVersion () + ".pom.md5" ) );
        makeChecksum ( "SHA1", pomFile, versionBase.resolve ( ref.getArtifactId () + "-" + ref.getVersion () + ".pom.sha1" ) );

        addMetaDataVersion ( ref );
    }

    private void addOrganization ( final Element project )
    {
        if ( this.organizationName == null || this.organizationUrl == null )
        {
            return;
        }
        if ( this.organizationName.isEmpty () || this.organizationUrl.isEmpty () )
        {
            return;
        }

        final Document doc = project.getOwnerDocument ();
        final Element orga = doc.createElement ( "organization" );
        project.appendChild ( orga );

        addElement ( orga, "name", this.organizationName );
        addElement ( orga, "url", this.organizationUrl );
    }

    private void makeScm ( final IInstallableUnit iu, final Document doc, final Element project, final Path versionBase, final MavenReference ref )
    {
        String scmUrl = null;
        String scmCon = null;
        String scmDev = null;
        String scm = null;

        // try override

        scmUrl = this.properties.getProperty ( "scm.url." + iu.getId () );
        scm = this.properties.getProperty ( "scm.ref." + iu.getId () );

        // try load and map

        if ( scmUrl == null )
        {
            scm = loadScm ( versionBase, ref );
            if ( scm != null )
            {
                final String[] scmToks = scm.split ( ";", 2 );
                if ( scmToks.length > 0 )
                {
                    final String key = "scm.url." + scmToks[0];
                    scmUrl = this.properties.getProperty ( key );
                }
            }
        }

        // use default if exists
        if ( scmUrl == null )
        {
            scmUrl = this.properties.getProperty ( "scm.default.url" );
            scm = this.properties.getProperty ( "scm.default.ref" );
            scmCon = this.properties.getProperty ( "scm.default.con" );
            scmDev = this.properties.getProperty ( "scm.default.dev" );
        }

        if ( scmUrl == null )
        {
            this.errors.add ( String.format ( "%s: no SCM information", iu.getId () ) );
            return;
        }

        final Element scmEle = doc.createElement ( "scm" );
        project.appendChild ( scmEle );
        addElement ( scmEle, "connection", scmCon == null ? scm : scmCon );
        addElement ( scmEle, "developerConnection", scmCon == null ? scm : scmDev );

        addElement ( scmEle, "url", scmUrl );
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
            addElement ( devNode, "organization", dev.organization );
            addElement ( devNode, "organizationUrl", dev.organizationUrl );
        }
    }

    private static String processJar ( final Path versionBase, final MavenReference ref, final IOFunction<Path, String> func )
    {
        // Try reading SCM

        try
        {
            final Path jarFile = makeJarFile ( versionBase, ref );
            if ( !Files.isRegularFile ( jarFile ) )
            {
                // dry run
                return null;
            }

            return func.apply ( jarFile );
        }
        catch ( final Exception e )
        {
            e.printStackTrace ();
        }

        return null;
    }

    private static String loadScm ( final Path versionBase, final MavenReference ref )
    {
        return processJar ( versionBase, ref, Processor::readSourceReference );
    }

    private static String readSourceReference ( final Path jarFile ) throws IOException
    {
        return readManifest ( jarFile ).getMainAttributes ().getValue ( "Eclipse-SourceReferences" );
    }

    private static String readQualifier ( final Path jarFile ) throws IOException
    {
        final String version = readManifest ( jarFile ).getMainAttributes ().getValue ( Constants.BUNDLE_VERSION );
        if ( version == null )
        {
            return version;
        }

        return Version.parseVersion ( version ).getQualifier ();
    }

    private static Manifest readManifest ( final Path jarFile ) throws IOException
    {
        try ( final JarFile jar = new JarFile ( jarFile.toFile () ) )
        {
            return jar.getManifest ();
        }
    }

    private static Path makeJarFile ( final Path versionBase, final MavenReference ref )
    {
        return versionBase.resolve ( ref.getArtifactId () + "-" + ref.getVersion () + ".jar" );
    }

    private void addLicense ( final Element project, final List<License> licenses )
    {
        final Document doc = project.getOwnerDocument ();

        final Element lics = doc.createElement ( "licenses" );
        project.appendChild ( lics );

        for ( final License license : licenses )
        {
            final Element lic = doc.createElement ( "license" );
            lics.appendChild ( lic );

            addElement ( lic, "name", license.getName () );
            addElement ( lic, "url", license.getUrl () );
            addElement ( lic, "distribution", "repo" );
        }
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

    private void saveXml ( final Document doc, final Path file ) throws Exception
    {
        final Transformer transformer = this.transformerFactory.newTransformer ();

        transformer.setOutputProperty ( OutputKeys.INDENT, "yes" );
        transformer.setOutputProperty ( "{http://xml.apache.org/xslt}indent-amount", "2" );

        final DOMSource source = new DOMSource ( doc );
        final StreamResult result = new StreamResult ( file.toFile () );

        transformer.transform ( source, result );
    }

    private void mirrorArtifact ( final IArtifactKey art, final Path versionBase, final MavenReference ref, final IProgressMonitor pm ) throws Exception
    {
        if ( this.dryRun )
        {
            return;
        }

        final Path jarFile = versionBase.resolve ( ref.toFileName () );
        System.out.format ( "Storing to: %s%n", jarFile );

        if ( this.scrubJars && ref.getClassifier () == null )
        {
            final Path tmp = Files.createTempFile ( null, ".jar" );
            try
            {
                fetchArtifact ( art, pm, tmp );
                try ( JarInputStream jin = new JarInputStream ( Files.newInputStream ( tmp ) );
                      JarOutputStream jout = new JarOutputStream ( Files.newOutputStream ( jarFile ), jin.getManifest () ); )
                {
                    JarEntry entry;
                    while ( ( entry = jin.getNextJarEntry () ) != null )
                    {
                        final String name = entry.getName ();
                        if ( name.startsWith ( "META-INF/maven/" ) )
                        {
                            System.out.format ( "Scrubbing Maven information: %s%n", name );
                            continue;
                        }
                        jout.putNextEntry ( entry );
                        ByteStreams.copy ( jin, jout );
                    }
                }
            }
            finally
            {
                Files.deleteIfExists ( tmp );
            }
        }
        else
        {
            fetchArtifact ( art, pm, jarFile );
        }

        makeChecksum ( "MD5", jarFile, versionBase.resolve ( ref.toFileName ( "md5" ) ) );
        makeChecksum ( "SHA1", jarFile, versionBase.resolve ( ref.toFileName ( "sha1" ) ) );
    }

    private void fetchArtifact ( final IArtifactKey art, final IProgressMonitor pm, final Path targetFile ) throws IOException
    {
        try ( OutputStream output = Files.newOutputStream ( targetFile ) )
        {
            final IArtifactDescriptor desc = this.artRepo.createArtifactDescriptor ( art );
            this.artRepo.getArtifact ( desc, output, pm );
        }
    }

    private void makeChecksum ( final String mdName, final Path sourceFile, final Path targetFile ) throws Exception
    {
        final MessageDigest md = MessageDigest.getInstance ( mdName );
        final byte[] buffer = new byte[4096];

        try ( final InputStream input = new BufferedInputStream ( Files.newInputStream ( sourceFile ) ) )
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

        try ( PrintWriter pw = new PrintWriter ( Files.newBufferedWriter ( targetFile, StandardCharsets.UTF_8 ) ) )
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

    private Path makeBase ( final String groupId, final String artifactId )
    {
        final String toks[] = groupId.split ( "\\." );

        Path file = this.output.toPath ();
        for ( final String tok : toks )
        {
            file = file.resolve ( tok );
        }

        return file.resolve ( artifactId );
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
