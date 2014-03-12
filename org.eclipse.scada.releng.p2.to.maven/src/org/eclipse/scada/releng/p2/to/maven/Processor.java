/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.releng.p2.to.maven;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.net.URI;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

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

        for ( final Map.Entry<MavenReference, Set<String>> entry : this.metadata.entrySet () )
        {
            writeMetaData ( entry.getKey (), entry.getValue () );
        }
    }

    private final SimpleDateFormat META_DF = new SimpleDateFormat ( "yyyyMMddHHmmss" );

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

        addElement ( v, "lastUpdated", this.META_DF.format ( new Date () ) );

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
        }
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

        final MavenDependency result = new MavenDependency ();

        final MavenReference ref = this.mapping.makeReference ( depIu );

        if ( ref == null )
        {
            return null;
        }

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

        addElement ( project, "url", iu.getProperty ( "org.eclipse.equinox.p2.doc.url", null ) );
        addElement ( project, "description", iu.getProperty ( "org.eclipse.equinox.p2.description", null ) );

        addElement ( project, "name", iu.getProperty ( "org.eclipse.equinox.p2.name", null ) );

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

}
