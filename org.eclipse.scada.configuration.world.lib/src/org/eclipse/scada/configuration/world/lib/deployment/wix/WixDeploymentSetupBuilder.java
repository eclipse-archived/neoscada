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
package org.eclipse.scada.configuration.world.lib.deployment.wix;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;

import org.eclipse.scada.configuration.generator.Profiles;
import org.eclipse.scada.configuration.world.lib.deployment.MsiHandler;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;
import org.eclipse.scada.configuration.world.osgi.profile.SystemProperty;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.common.io.Resources;

public class WixDeploymentSetupBuilder extends XMLBase
{

    public static class CommonDriverService
    {
        private final String name;

        private final File configuration;

        private final Properties props;

        public CommonDriverService ( final String name, final File configuration, final Properties props )
        {
            this.name = name;
            this.configuration = configuration;
            this.props = props;
        }

        public File getConfiguration ()
        {
            return this.configuration;
        }

        public String getName ()
        {
            return this.name;
        }

        public Properties getProps ()
        {
            return this.props;
        }
    }

    public static class EquinoxAppService
    {
        private final String name;

        private final Profile profile;

        private final File configurationBase;

        public EquinoxAppService ( final String name, final Profile profile, final File configurationBase )
        {
            this.name = name;
            this.profile = profile;
            this.configurationBase = configurationBase;
        }

        public String getName ()
        {
            return this.name;
        }

        public Profile getProfile ()
        {
            return this.profile;
        }

        public File getConfigurationBase ()
        {
            return this.configurationBase;
        }
    }

    private MsiPlatform platform = MsiPlatform.WIN32;

    private String version;

    private String manufacturer;

    private String upgradeCode;

    private String name;

    private final List<CommonDriverService> commonDrivers = new LinkedList<> ();

    private final List<EquinoxAppService> apps = new LinkedList<> ();

    private final Set<String> components = new HashSet<> ();

    private Element caDir;

    public void write ( final File base ) throws Exception
    {
        // set up document

        final Document doc = createXmlDocument ();

        // create content

        createDocument ( doc, base );

        // write XML

        storeXmlDocument ( doc, new File ( base, "Setup.wxs" ) ); //$NON-NLS-1$
    }

    protected void createDocument ( final Document doc, final File base ) throws Exception
    {
        final Element ele = doc.createElementNS ( "http://schemas.microsoft.com/wix/2006/wi", "Wix" ); //$NON-NLS-1$ //$NON-NLS-2$
        doc.appendChild ( ele );

        createProduct ( doc, ele, base );
    }

    private void createProduct ( final Document doc, final Element root, final File base ) throws Exception
    {
        final Element ele = createElement ( root, "Product" ); //$NON-NLS-1$ 
        ele.setAttribute ( "Version", this.version ); //$NON-NLS-1$ 
        ele.setAttribute ( "Language", "1033" ); //$NON-NLS-1$ //$NON-NLS-2$
        ele.setAttribute ( "Id", "*" ); //$NON-NLS-1$ //$NON-NLS-2$
        ele.setAttribute ( "Manufacturer", this.manufacturer ); //$NON-NLS-1$ 
        ele.setAttribute ( "UpgradeCode", this.upgradeCode ); //$NON-NLS-1$ 
        ele.setAttribute ( "Name", this.name ); //$NON-NLS-1$ 

        createPackage ( ele );
        createProperties ( ele );
        createMedia ( ele );
        createUpgrade ( ele );
        createTargetDir ( ele );

        createCommonDriverServices ( ele, base );
        createEquinoxApplicationServices ( ele, base );

        createFeature ( ele );
    }

    private void createProperties ( final Element product )
    {
        final Element p1 = createElement ( product, "Property" ); //$NON-NLS-1$ 
        p1.setAttribute ( "Id", "ES_JARS" ); //$NON-NLS-1$ //$NON-NLS-2$
        final Element cs1 = createElement ( p1, "RegistrySearch" ); //$NON-NLS-1$ 
        cs1.setAttribute ( "Id", "search.jars" ); //$NON-NLS-1$ //$NON-NLS-2$
        cs1.setAttribute ( "Root", "HKLM" ); //$NON-NLS-1$ //$NON-NLS-2$
        cs1.setAttribute ( "Type", "raw" ); //$NON-NLS-1$ //$NON-NLS-2$
        cs1.setAttribute ( "Key", "SOFTWARE\\Eclipse SCADA Common Drivers" ); //$NON-NLS-1$ //$NON-NLS-2$
        cs1.setAttribute ( "Name", "JarPath" ); //$NON-NLS-1$ //$NON-NLS-2$

        final Element p2 = createElement ( product, "Property" ); //$NON-NLS-1$ 
        p2.setAttribute ( "Id", "ES_EXTRA_JARS" ); //$NON-NLS-1$ //$NON-NLS-2$
        final Element cs2 = createElement ( p2, "RegistrySearch" ); //$NON-NLS-1$ 
        cs2.setAttribute ( "Id", "search.extra.jars" ); //$NON-NLS-1$ //$NON-NLS-2$
        cs2.setAttribute ( "Root", "HKLM" ); //$NON-NLS-1$ //$NON-NLS-2$
        cs2.setAttribute ( "Type", "raw" ); //$NON-NLS-1$ //$NON-NLS-2$
        cs2.setAttribute ( "Key", "SOFTWARE\\Eclipse SCADA Common Drivers" ); //$NON-NLS-1$ //$NON-NLS-2$
        cs2.setAttribute ( "Name", "ExtraJarPath" ); //$NON-NLS-1$ //$NON-NLS-2$

        Element cond;

        cond = createElement ( product, "Condition" ); //$NON-NLS-1$
        cond.setAttribute ( "Message", "You need to install the Eclipse SCADA Common Driver package first (jar)" ); //$NON-NLS-1$ //$NON-NLS-2$
        cond.appendChild ( product.getOwnerDocument ().createCDATASection ( "ES_JARS OR Installed" ) ); //$NON-NLS-1$ 

        cond = createElement ( product, "Condition" ); //$NON-NLS-1$
        cond.setAttribute ( "Message", "You need to install the Eclipse SCADA Common Driver package first (extra-jars)" ); //$NON-NLS-1$ //$NON-NLS-2$
        cond.appendChild ( product.getOwnerDocument ().createCDATASection ( "ES_EXTRA_JARS OR Installed" ) ); //$NON-NLS-1$ 
    }

    private void createCommonDriverServices ( final Element product, final File base ) throws Exception
    {
        final Element dir = createElement ( product, "DirectoryRef" ); //$NON-NLS-1$ 
        dir.setAttribute ( "Id", "INSTALLDIR" ); //$NON-NLS-1$ //$NON-NLS-2$

        final Element dir2 = createElement ( dir, "Directory" ); //$NON-NLS-1$ 
        dir2.setAttribute ( "Id", "drivers" ); //$NON-NLS-1$ //$NON-NLS-2$
        dir2.setAttribute ( "Name", "drivers" ); //$NON-NLS-1$ //$NON-NLS-2$

        for ( final CommonDriverService cds : this.commonDrivers )
        {
            final File driverResourceBase = new File ( new File ( new File ( base, "resources" ), "drivers" ), cds.getName () ); //$NON-NLS-1$ //$NON-NLS-2$
            driverResourceBase.mkdirs ();
            createCommonDriverService ( dir2, cds, driverResourceBase );
        }
    }

    private String makeServiceName ( final CommonDriverService cds )
    {
        return String.format ( "eclipse_scada_common_driver_%s", cds.getName () ); //$NON-NLS-1$
    }

    private String makeServiceName ( final EquinoxAppService eas )
    {
        return String.format ( "eclipse_scada_app_%s", eas.getName () ); //$NON-NLS-1$
    }

    /**
     * Create a component element and register it <br/>
     * Note: This method must be called <em>before</em> the method
     * {@link #createFeature(Element)} is called
     */
    private Element createComponent ( final Element parent, final String id )
    {
        final Element comp = createElement ( parent, "Component" ); //$NON-NLS-1$
        comp.setAttribute ( "Id", id ); //$NON-NLS-1$
        this.components.add ( id );
        return comp;
    }

    private Element createCommonService ( final Element parent, final String serviceName, final String name )
    {
        final Element dir = createElement ( parent, "Directory" ); //$NON-NLS-1$
        dir.setAttribute ( "Id", serviceName ); //$NON-NLS-1$
        dir.setAttribute ( "Name", name ); //$NON-NLS-1$

        final Element comp = createComponent ( dir, serviceName );
        comp.setAttribute ( "Guid", "*" ); //$NON-NLS-1$ //$NON-NLS-2$

        Element file;
        file = createElement ( comp, "File" ); //$NON-NLS-1$
        file.setAttribute ( "Id", serviceName + ".exe" ); //$NON-NLS-1$ //$NON-NLS-2$
        if ( this.platform == MsiPlatform.WIN32 )
        {
            file.setAttribute ( "Source", "unpack\\commons-daemon\\prunsrv.exe" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
        else
        {
            file.setAttribute ( "Source", "unpack\\commons-daemon\\amd64\\prunsrv.exe" ); //$NON-NLS-1$ //$NON-NLS-2$
        }

        Element reg;
        reg = createElement ( comp, "RegistryKey" ); //$NON-NLS-1$
        reg.setAttribute ( "Root", "HKLM" ); //$NON-NLS-1$ //$NON-NLS-2$
        reg.setAttribute ( "Key", "SYSTEM\\CurrentControlSet\\services\\" + serviceName ); //$NON-NLS-1$ //$NON-NLS-2$

        reg = createElement ( reg, "RegistryKey" ); //$NON-NLS-1$
        reg.setAttribute ( "Key", "Parameters" ); //$NON-NLS-1$ //$NON-NLS-2$
        reg.setAttribute ( "ForceCreateOnInstall", "yes" ); //$NON-NLS-1$ //$NON-NLS-2$

        return comp;
    }

    private static class ServiceConfiguration
    {
        String displayName;

        String description;

        String startClass;

        String startMethod;

        String stopClass;

        String stopMethod;

        String[] startArguments;

        Properties properties;

        String classpath;

        List<String> jvmArgs;

        List<String> args;
    }

    private void createProcrunService ( final Element comp, final String serviceName, final ServiceConfiguration serviceConfiguration )
    {
        Element reg;
        Element regSub;
        // create prunsrv configuration

        reg = createElement ( comp, "RegistryKey" ); //$NON-NLS-1$
        reg.setAttribute ( "Root", "HKLM" ); //$NON-NLS-1$ //$NON-NLS-2$
        if ( this.platform == MsiPlatform.WIN32 )
        {
            reg.setAttribute ( "Key", "SOFTWARE\\Apache Software Foundation\\Procrun 2.0\\" + serviceName ); //$NON-NLS-1$ //$NON-NLS-2$
        }
        else
        {
            // this has to always go to the 32bit registry
            reg.setAttribute ( "Key", "SOFTWARE\\Wow6432Node\\Apache Software Foundation\\Procrun 2.0\\" + serviceName ); // FIXME: check if this really works
        }
        reg = createElement ( reg, "RegistryKey" ); //$NON-NLS-1$ 
        reg.setAttribute ( "Key", "Parameters" ); //$NON-NLS-1$ //$NON-NLS-2$

        // java

        regSub = createElement ( reg, "RegistryKey" ); //$NON-NLS-1$ 
        regSub.setAttribute ( "Key", "Java" ); //$NON-NLS-1$ //$NON-NLS-2$
        addValue ( regSub, "Jvm", "auto" ); //$NON-NLS-1$ //$NON-NLS-2$
        addValue ( regSub, "Classpath", serviceConfiguration.classpath ); //$NON-NLS-1$

        final List<String> jvmProps = new LinkedList<> ();

        for ( final String key : serviceConfiguration.properties.stringPropertyNames () )
        {
            jvmProps.add ( String.format ( "-D%s=%s", key, serviceConfiguration.properties.getProperty ( key ) ) ); //$NON-NLS-1$
        }
        if ( serviceConfiguration.jvmArgs != null )
        {
            jvmProps.addAll ( serviceConfiguration.jvmArgs );
        }
        addValues ( regSub, "Options", jvmProps.toArray ( new String[jvmProps.size ()] ) ); //$NON-NLS-1$

        // log

        regSub = createElement ( reg, "RegistryKey" ); //$NON-NLS-1$
        regSub.setAttribute ( "Key", "Log" ); //$NON-NLS-1$ //$NON-NLS-2$
        addValue ( regSub, "Prefix", "common-driver-" + serviceName ); //$NON-NLS-1$ //$NON-NLS-2$
        addValue ( regSub, "StdOutput", "auto" ); //$NON-NLS-1$ //$NON-NLS-2$
        addValue ( regSub, "StdError", "auto" ); //$NON-NLS-1$ //$NON-NLS-2$

        // start

        regSub = createElement ( reg, "RegistryKey" ); //$NON-NLS-1$
        regSub.setAttribute ( "Key", "Start" ); //$NON-NLS-1$ //$NON-NLS-2$
        addValue ( regSub, "Class", serviceConfiguration.startClass ); //$NON-NLS-1$ 
        addValue ( regSub, "Method", serviceConfiguration.startMethod ); //$NON-NLS-1$ 
        addValue ( regSub, "Mode", "jvm" ); //$NON-NLS-1$ //$NON-NLS-2$
        addValues ( regSub, "Params", serviceConfiguration.startArguments ); //$NON-NLS-1$ 

        // stop

        regSub = createElement ( reg, "RegistryKey" ); //$NON-NLS-1$
        regSub.setAttribute ( "Key", "Stop" ); //$NON-NLS-1$ //$NON-NLS-2$
        addValue ( regSub, "Class", serviceConfiguration.stopClass ); //$NON-NLS-1$ 
        addValue ( regSub, "Method", serviceConfiguration.stopMethod ); //$NON-NLS-1$ 
        addValue ( regSub, "Mode", "jvm" ); //$NON-NLS-1$ //$NON-NLS-2$

        final Element si = createElement ( comp, "ServiceInstall" ); //$NON-NLS-1$
        si.setAttribute ( "Id", "ServiceInstall_" + serviceName ); //$NON-NLS-1$ //$NON-NLS-2$
        si.setAttribute ( "DisplayName", serviceConfiguration.displayName ); //$NON-NLS-1$ 
        si.setAttribute ( "Description", serviceConfiguration.description ); //$NON-NLS-1$ 
        si.setAttribute ( "Name", serviceName ); //$NON-NLS-1$ 
        si.setAttribute ( "Type", "ownProcess" ); //$NON-NLS-1$ //$NON-NLS-2$
        si.setAttribute ( "Start", "auto" ); //$NON-NLS-1$ //$NON-NLS-2$
        si.setAttribute ( "ErrorControl", "normal" ); //$NON-NLS-1$ //$NON-NLS-2$
        si.setAttribute ( "Vital", "yes" ); //$NON-NLS-1$ //$NON-NLS-2$
        si.setAttribute ( "Arguments", String.format ( "//RS//%s", serviceName ) ); //$NON-NLS-1$ //$NON-NLS-2$

        final Element sd = createElement ( si, "ServiceDependency" ); //$NON-NLS-1$
        sd.setAttribute ( "Id", "tcpip" ); //$NON-NLS-1$ //$NON-NLS-2$

        final Element sc = createElement ( comp, "ServiceControl" ); //$NON-NLS-1$
        sc.setAttribute ( "Id", "ServiceControl_" + serviceName );
        sc.setAttribute ( "Name", serviceName ); //$NON-NLS-1$ 
        sc.setAttribute ( "Stop", "both" ); //$NON-NLS-1$ //$NON-NLS-2$
        sc.setAttribute ( "Remove", "uninstall" ); //$NON-NLS-1$ //$NON-NLS-2$
        sc.setAttribute ( "Wait", "yes" ); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private void createEquinoxApplicationService ( final Element parent, final EquinoxAppService eas, final File resourceBase ) throws Exception
    {
        final Profile profile = eas.getProfile ();

        final String serviceName = makeServiceName ( eas );
        final Element comp = createCommonService ( parent, serviceName, eas.getName () );

        // cfg dir

        final String cfgDirId = "cfg_" + serviceName; //$NON-NLS-1$

        final Element cfgDir = createElement ( this.caDir, "Directory" ); //$NON-NLS-1$
        cfgDir.setAttribute ( "Id", cfgDirId ); //$NON-NLS-1$ 
        cfgDir.setAttribute ( "Name", eas.getName () ); //$NON-NLS-1$ 

        final Element cfgDirComp = createComponent ( cfgDir, "comp_" + cfgDirId );
        cfgDirComp.setAttribute ( "Guid", UUID.nameUUIDFromBytes ( cfgDirId.getBytes () ).toString () );

        createElement ( cfgDirComp, "CreateFolder" ); //$NON-NLS-1$
        final Element rmdir = createElement ( cfgDirComp, "RemoveFolder" ); //$NON-NLS-1$
        rmdir.setAttribute ( "Id", "rmdir_" + serviceName ); //$NON-NLS-1$ //$NON-NLS-2$
        rmdir.setAttribute ( "On", "uninstall" ); //$NON-NLS-1$ //$NON-NLS-2$

        // create start level file

        final File startLevel = new File ( resourceBase, "startLevels.properties" ); //$NON-NLS-1$
        writeStartLevels ( startLevel, profile );

        Element file = createElement ( comp, "File" ); //$NON-NLS-1$
        file.setAttribute ( "Id", "startLevels_" + serviceName ); //$NON-NLS-1$ //$NON-NLS-2$
        file.setAttribute ( "Source", String.format ( "resources\\apps\\%s\\startLevels.properties", eas.getName () ) ); //$NON-NLS-1$ //$NON-NLS-2$

        // CA bootstrap file

        file = createElement ( comp, "File" ); //$NON-NLS-1$
        file.setAttribute ( "Id", "caBootstrap_" + serviceName ); //$NON-NLS-1$
        file.setAttribute ( "Source", String.format ( "resources\\apps\\%s\\ca.bootstrap.json", eas.getName () ) ); //$NON-NLS-1$ //$NON-NLS-2$

        Files.copy ( new File ( eas.getConfigurationBase (), "data.json" ).toPath (), new File ( resourceBase, "ca.bootstrap.json" ).toPath (), StandardCopyOption.REPLACE_EXISTING ); //$NON-NLS-1$ //$NON-NLS-2$

        // create properties for equinox

        final Properties p = new Properties ();
        p.setProperty ( "eclipse.ignoreApp", "true" ); //$NON-NLS-1$ //$NON-NLS-2$
        p.setProperty ( "osgi.noShutdown", "true" ); //$NON-NLS-1$ //$NON-NLS-2$
        p.setProperty ( "osgi.syspath", String.format ( "[INSTALLDIR]\\apps\\%1$s\\plugins", eas.getName () ) ); //$NON-NLS-1$ //$NON-NLS-2$
        for ( final SystemProperty prop : profile.getProperty () )
        {
            p.setProperty ( prop.getKey (), prop.getValue () );
        }
        if ( p.containsKey ( "logback.configurationFile" ) ) //$NON-NLS-1$
        {
            // override, since "eval" will not work here
            p.setProperty ( "logback.configurationFile", String.format ( "[INSTALLDIR]\\apps\\%s\\logback.xml", eas.getName () ) ); //$NON-NLS-1$ //$NON-NLS-2$
            createLogback ( comp, eas, resourceBase );
        }
        if ( p.containsKey ( "org.eclipse.scada.ca.file.root" ) ) //$NON-NLS-1$ 
        {
            p.setProperty ( "org.eclipse.scada.ca.file.root", String.format ( "[%s]\\ca", cfgDirId ) ); //$NON-NLS-1$ //$NON-NLS-2$
        }
        p.setProperty ( "org.osgi.framework.bootdelegation", "com.sun.script.javascript" ); //$NON-NLS-1$ //$NON-NLS-2$
        p.setProperty ( "org.eclipse.scada.ca.file.provisionJsonUrl", String.format ( "file:[INSTALLDIR]\\apps\\%s\\ca.bootstrap.json", eas.getName () ) ); //$NON-NLS-1$ //$NON-NLS-2$

        final ServiceConfiguration cfg = new ServiceConfiguration ();
        cfg.displayName = "Eclipse SCADA Application: " + eas.getName (); //$NON-NLS-1$
        cfg.description = String.format ( "This is the Eclipse SCADA application instance '%s'", eas.getName () ); //$NON-NLS-1$
        cfg.startClass = "org.eclipse.scada.utils.osgi.daemon.EclipseDaemon"; //$NON-NLS-1$
        cfg.startMethod = "start"; //$NON-NLS-1$
        cfg.startArguments = new String[] {
                "-consoleLog" // we cannot start with -console, since the service will hang then when stopping
        };
        cfg.stopClass = "org.eclipse.scada.utils.osgi.daemon.EclipseDaemon"; //$NON-NLS-1$
        cfg.stopMethod = "stop"; //$NON-NLS-1$
        cfg.properties = p;
        cfg.jvmArgs = profile.getJvmArguments ();
        cfg.args = profile.getArguments ();
        cfg.classpath = String.format ( "[INSTALLDIR]\\apps\\%1$s\\daemon.jar;[INSTALLDIR]\\apps\\%1$s\\osgi.jar", eas.getName () ); //$NON-NLS-1$
        createProcrunService ( comp, serviceName, cfg );
    }

    private void createLogback ( final Element comp, final EquinoxAppService eas, final File resourceBase ) throws Exception
    {
        final Element file = createElement ( comp, "File" ); //$NON-NLS-1$ 
        final String serviceName = makeServiceName ( eas );
        file.setAttribute ( "Id", "logback.xml_" + serviceName ); //$NON-NLS-1$ //$NON-NLS-2$
        file.setAttribute ( "Source", String.format ( "resources\\apps\\%s\\logback.xml", eas.getName () ) ); //$NON-NLS-1$ //$NON-NLS-2$

        final File logback = new File ( resourceBase, "logback.xml" ); //$NON-NLS-1$
        try ( FileOutputStream out = new FileOutputStream ( logback ) )
        {
            Resources.copy ( Resources.getResource ( MsiHandler.class, "templates/msi/app.logback.xml" ), out ); //$NON-NLS-1$ 
        }
    }

    private void writeStartLevels ( final File startLevel, final Profile profile ) throws IOException
    {
        try ( final PrintWriter writer = new PrintWriter ( startLevel ) )
        {
            for ( final Map.Entry<String, Integer> entry : Profiles.makeStartLevelMap ( profile ).entrySet () )
            {
                writer.println ( String.format ( "%s=%s", entry.getKey (), entry.getValue () ) ); //$NON-NLS-1$ 
            }
        }
    }

    private void createCommonDriverService ( final Element parent, final CommonDriverService cds, final File resourceBase ) throws Exception
    {
        final Path configurationFile = new File ( resourceBase, "exporter.xml" ).toPath (); //$NON-NLS-1$

        final Element comp = createCommonService ( parent, makeServiceName ( cds ), cds.getName () );

        Element file;

        final String serviceName = makeServiceName ( cds );

        final String fileIdConfiguration = "configuration_" + serviceName; //$NON-NLS-1$
        file = createElement ( comp, "File" ); //$NON-NLS-1$
        file.setAttribute ( "Id", fileIdConfiguration ); //$NON-NLS-1$
        file.setAttribute ( "Source", String.format ( "resources\\drivers\\%s\\exporter.xml", cds.getName () ) ); //$NON-NLS-1$ //$NON-NLS-2$

        // copy configuration file
        Files.copy ( cds.getConfiguration ().toPath (), configurationFile );

        // create prunsrv configuration
        final ServiceConfiguration cfg = new ServiceConfiguration ();
        cfg.displayName = "Eclipse SCADA Common Driver: " + cds.getName (); //$NON-NLS-1$ 
        cfg.description = String.format ( "This is the Eclipse SCADA common driver instance '%s'", cds.getName () ); //$NON-NLS-1$ 
        cfg.startClass = cfg.stopClass = "org.eclipse.scada.da.server.exporter.Application"; //$NON-NLS-1$ 
        cfg.startMethod = "main"; //$NON-NLS-1$ 
        cfg.startArguments = new String[] {
                "[#" + fileIdConfiguration + "]" //$NON-NLS-1$ //$NON-NLS-2$
        };
        cfg.stopMethod = "stop"; //$NON-NLS-1$ 
        cfg.properties = cds.getProps ();
        cfg.classpath = "[ES_JARS]\\*;[ES_EXTRA_JARS]\\*"; //$NON-NLS-1$ 
        createProcrunService ( comp, serviceName, cfg );

        // TODO: add firewall rule
    }

    private void createEquinoxApplicationServices ( final Element product, final File base ) throws Exception
    {
        if ( this.apps.isEmpty () )
        {
            return;
        }

        createAppCleanup ( product );

        final Element dir = createElement ( product, "DirectoryRef" ); //$NON-NLS-1$ 
        dir.setAttribute ( "Id", "apps" ); //$NON-NLS-1$ //$NON-NLS-2$

        for ( final EquinoxAppService eqs : this.apps )
        {
            final File resourceBase = new File ( new File ( new File ( base, "resources" ), "apps" ), eqs.getName () ); //$NON-NLS-1$ //$NON-NLS-2$
            resourceBase.mkdirs ();
            createEquinoxApplicationService ( dir, eqs, resourceBase );
        }
    }

    private void createAppCleanup ( final Element product )
    {
        final Element ca = createElement ( product, "CustomAction" ); //$NON-NLS-1$ 
        ca.setAttribute ( "Id", "CleanupApps" ); //$NON-NLS-1$ //$NON-NLS-2$
        ca.setAttribute ( "Directory", "INSTALLDIR" ); //$NON-NLS-1$ //$NON-NLS-2$
        ca.setAttribute ( "Execute", "deferred" ); //$NON-NLS-1$ //$NON-NLS-2$
        ca.setAttribute ( "Return", "ignore" ); //$NON-NLS-1$ //$NON-NLS-2$
        ca.setAttribute ( "HideTarget", "no" ); //$NON-NLS-1$ //$NON-NLS-2$
        ca.setAttribute ( "Impersonate", "no" ); //$NON-NLS-1$ //$NON-NLS-2$
        ca.setAttribute ( "ExeCommand", "cmd /C \"rmdir /Q /S apps\"" ); //$NON-NLS-1$ //$NON-NLS-2$

        final Element ies = createElement ( product, "InstallExecuteSequence" ); //$NON-NLS-1$ 
        final Element c = createElement ( ies, "Custom" ); //$NON-NLS-1$ 
        c.setAttribute ( "Action", "CleanupApps" ); //$NON-NLS-1$ //$NON-NLS-2$
        c.setAttribute ( "After", "RemoveFiles" ); //$NON-NLS-1$ //$NON-NLS-2$
        c.appendChild ( product.getOwnerDocument ().createTextNode ( "REMOVE=\"ALL\"" ) ); //$NON-NLS-1$ 
    }

    private void addValue ( final Element reg, final String key, final String value )
    {
        final Element ele = createElement ( reg, "RegistryValue" ); //$NON-NLS-1$ 
        ele.setAttribute ( "Type", "string" ); //$NON-NLS-1$ //$NON-NLS-2$
        ele.setAttribute ( "Name", key ); //$NON-NLS-1$ 
        ele.setAttribute ( "Value", value ); //$NON-NLS-1$ 
    }

    private void addValues ( final Element reg, final String key, final String[] values )
    {
        if ( values == null || values.length <= 0 )
        {
            return;
        }

        final Element ele = createElement ( reg, "RegistryValue" ); //$NON-NLS-1$ 
        ele.setAttribute ( "Type", "multiString" ); //$NON-NLS-1$ //$NON-NLS-2$
        ele.setAttribute ( "Name", key ); //$NON-NLS-1$ 

        for ( final String value : values )
        {
            createElementWithText ( ele, "MultiStringValue", value ); //$NON-NLS-1$ 
        }
    }

    private void createFeature ( final Element product )
    {
        final Element feat = createElement ( product, "Feature" ); //$NON-NLS-1$ 
        feat.setAttribute ( "Id", "Complete" ); //$NON-NLS-1$ //$NON-NLS-2$
        feat.setAttribute ( "Level", "1" ); //$NON-NLS-1$ //$NON-NLS-2$

        Element entry;

        entry = createElement ( feat, "ComponentGroupRef" ); //$NON-NLS-1$ 
        entry.setAttribute ( "Id", "ScanComponent" ); //$NON-NLS-1$ //$NON-NLS-2$

        for ( final String comp : this.components )
        {
            entry = createElement ( feat, "ComponentRef" ); //$NON-NLS-1$ 
            entry.setAttribute ( "Id", comp ); //$NON-NLS-1$ 
        }
    }

    private void createTargetDir ( final Element product )
    {
        final Element dir1 = createElement ( product, "Directory" ); //$NON-NLS-1$ 
        dir1.setAttribute ( "Id", "TARGETDIR" ); //$NON-NLS-1$ //$NON-NLS-2$
        dir1.setAttribute ( "Name", "SourceDir" ); //$NON-NLS-1$ //$NON-NLS-2$

        final Element dir2 = createElement ( dir1, "Directory" ); //$NON-NLS-1$ 
        dir2.setAttribute ( "Name", "PFiles" ); //$NON-NLS-1$ //$NON-NLS-2$
        if ( this.platform == MsiPlatform.WIN32 )
        {
            dir2.setAttribute ( "Id", "ProgramFilesFolder" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
        else
        {
            dir2.setAttribute ( "Id", "ProgramFiles64Folder" ); //$NON-NLS-1$ //$NON-NLS-2$
        }

        final Element dir3 = createElement ( dir2, "Directory" ); //$NON-NLS-1$ 
        dir3.setAttribute ( "Id", "INSTALLDIR" ); //$NON-NLS-1$ //$NON-NLS-2$
        dir3.setAttribute ( "Name", this.name ); //$NON-NLS-1$ 

        this.caDir = createElement ( dir3, "Directory" ); //$NON-NLS-1$ 
        this.caDir.setAttribute ( "Id", "CA_DIR" ); //$NON-NLS-1$ //$NON-NLS-2$
        this.caDir.setAttribute ( "Name", "configuration" ); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private void createUpgrade ( final Element product )
    {
        final Element ele = createElement ( product, "MajorUpgrade" ); //$NON-NLS-1$
        ele.setAttribute ( "AllowDowngrades", "yes" ); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private void createMedia ( final Element product )
    {
        final Element ele = createElement ( product, "Media" ); //$NON-NLS-1$ 
        ele.setAttribute ( "Id", "1" ); //$NON-NLS-1$ //$NON-NLS-2$
        ele.setAttribute ( "Cabinet", "contents.cab" ); //$NON-NLS-1$ //$NON-NLS-2$
        ele.setAttribute ( "EmbedCab", "yes" ); //$NON-NLS-1$ //$NON-NLS-2$
        ele.setAttribute ( "CompressionLevel", "none" ); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private void createPackage ( final Element product )
    {
        final Element ele = createElement ( product, "Package" ); //$NON-NLS-1$ 
        ele.setAttribute ( "InstallScope", "perMachine" ); //$NON-NLS-1$ //$NON-NLS-2$
        ele.setAttribute ( "InstallPrivileges", "elevated" ); //$NON-NLS-1$ //$NON-NLS-2$
        ele.setAttribute ( "InstallerVersion", "200" ); //$NON-NLS-1$ //$NON-NLS-2$
        ele.setAttribute ( "Compressed", "yes" ); //$NON-NLS-1$ //$NON-NLS-2$
    }

    public String getManufacturer ()
    {
        return this.manufacturer;
    }

    public void setManufacturer ( final String manufacturer )
    {
        this.manufacturer = manufacturer;
    }

    public String getUpgradeCode ()
    {
        return this.upgradeCode;
    }

    public void setUpgradeCode ( final String upgradeCode )
    {
        this.upgradeCode = upgradeCode;
    }

    public String getName ()
    {
        return this.name;
    }

    public void setName ( final String name )
    {
        this.name = name;
    }

    public String getVersion ()
    {
        return this.version;
    }

    public void setVersion ( final String version )
    {
        this.version = version;
    }

    public void addCommonDriver ( final CommonDriverService driver )
    {
        this.commonDrivers.add ( driver );
    }

    public void addApplication ( final EquinoxAppService equinoxAppService )
    {
        this.apps.add ( equinoxAppService );
    }

    public MsiPlatform getPlatform ()
    {
        return this.platform;
    }

    public void setPlatform ( final MsiPlatform platform )
    {
        this.platform = platform;
    }

}
