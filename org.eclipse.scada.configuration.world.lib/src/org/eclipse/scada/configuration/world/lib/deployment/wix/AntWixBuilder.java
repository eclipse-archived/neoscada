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
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.scada.configuration.world.deployment.P2Platform;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;
import org.eclipse.scada.utils.str.StringHelper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class AntWixBuilder extends XMLBase
{
    public static class Application
    {
        private final String name;

        private final Profile profile;

        public Application ( final String name, final Profile profile )
        {
            super ();
            this.name = name;
            this.profile = profile;
        }

        public String getName ()
        {
            return this.name;
        }

        public Profile getProfile ()
        {
            return this.profile;
        }
    }

    private static final String[] DEFAULT_IUS = new String[] { // 
    "org.eclipse.equinox.launcher", //$NON-NLS-1$
    "org.eclipse.osgi", //$NON-NLS-1$
    "org.eclipse.equinox.common", //$NON-NLS-1$
    "org.eclipse.update.configurator", //$NON-NLS-1$
    "org.eclipse.equinox.ds", //$NON-NLS-1$
    "org.eclipse.equinox.p2.console", //$NON-NLS-1$
    "org.eclipse.equinox.simpleconfigurator", //$NON-NLS-1$
    "org.eclipse.scada.utils.osgi.autostart", //$NON-NLS-1$
    "org.eclipse.equinox.console", //$NON-NLS-1$
    "org.apache.felix.gogo.shell", //$NON-NLS-1$
    "org.apache.felix.gogo.runtime", //$NON-NLS-1$
    "org.apache.felix.gogo.command", //$NON-NLS-1$
    "org.eclipse.scada.utils.osgi.daemon" //$NON-NLS-1$
    };

    private final String outputFilename;

    private final MsiPlatform platform;

    private final List<Application> applications = new LinkedList<> ();

    private final P2Platform p2Platform;

    private final Set<String> wixExtensions;

    public AntWixBuilder ( final String outputFilename, final MsiPlatform platform, final P2Platform p2Platform, final Set<String> wixExtensions )
    {
        this.outputFilename = outputFilename;
        this.platform = platform;
        this.p2Platform = p2Platform;
        this.wixExtensions = wixExtensions;
    }

    public void write ( final File packageFolder ) throws Exception
    {
        final Document doc = createXmlDocument ();

        createDocument ( doc );

        storeXmlDocument ( doc, new File ( packageFolder, "build.ant" ) ); //$NON-NLS-1$
    }

    private void createDocument ( final Document doc ) throws Exception
    {
        final Element ele = doc.createElement ( "project" ); //$NON-NLS-1$ 
        doc.appendChild ( ele );
        ele.setAttribute ( "name", "project" ); //$NON-NLS-1$ //$NON-NLS-2$ 
        ele.setAttribute ( "default", "default" ); //$NON-NLS-1$ //$NON-NLS-2$ 

        final Element desc = createElement ( ele, "description" ); //$NON-NLS-1$ 
        desc.appendChild ( doc.createTextNode ( String.format ( "Build the Wix setup project" ) ) ); //$NON-NLS-1$ 

        final Element env = createElement ( ele, "property" ); //$NON-NLS-1$ 
        env.setAttribute ( "environment", "env" ); //$NON-NLS-1$ //$NON-NLS-2$ 

        createProperty ( ele, "wix.root", "value", "${env.WIX}" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ 
        createProperty ( ele, "staging.dir", "location", "staging" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ 
        createProperty ( ele, "subst.drive", "value", "K:" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ 
        createProperty ( ele, "staging.dir.short", "location", "${subst.drive}/staging" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ 

        createTarget ( ele, "default", Arrays.asList ( "clean", "download", "unpack", "provision", "heat", "build" ) ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ 
        final Element clean = createTarget ( ele, "clean" ); //$NON-NLS-1$ 
        final Element download = createTarget ( ele, "download" ); //$NON-NLS-1$ 
        final Element unpack = createTarget ( ele, "unpack" ); //$NON-NLS-1$ 
        final Element provision = createTarget ( ele, "provision" ); //$NON-NLS-1$ 
        final Element heat = createTarget ( ele, "heat" ); //$NON-NLS-1$ 
        final Element build = createTarget ( ele, "build" ); //$NON-NLS-1$ 

        fillCleanTarget ( clean );
        fillDownloadTaret ( download );
        fillUnpackTaret ( unpack );
        fillProvisionTarget ( provision );
        fillHeatTarget ( heat );
        fillBuildTarget ( build );
    }

    private void fillProvisionTarget ( final Element provision ) throws Exception
    {
        for ( final Application app : this.applications )
        {
            appendFragment ( provision, String.format ( "<property name=\"%1$s.dir\" location=\"staging/apps/%1$s\"/>", app.getName () ) ); //$NON-NLS-1$ 

            final String dest = String.format ( "${%s.dir}", app.getName () ); //$NON-NLS-1$ 

            appendFragment ( provision, String.format ( "<mkdir dir=\"%s\"/>", dest ) ); //$NON-NLS-1$ 

            appendFragment ( provision, String.format ( "<echo message=\"Running P2 director application. This might take some time!\"/>" ) ); //$NON-NLS-1$ 
            final Element p2 = createElement ( provision, "p2.director" ); //$NON-NLS-1$ 

            p2.setAttribute ( "roaming", "true" ); //$NON-NLS-1$ //$NON-NLS-2$ 
            p2.setAttribute ( "bundlepool", dest ); //$NON-NLS-1$ 
            p2.setAttribute ( "flavor", "tooling" ); //$NON-NLS-1$ //$NON-NLS-2$ 
            p2.setAttribute ( "profile", "SDKProfile" ); //$NON-NLS-1$ //$NON-NLS-2$ 
            p2.setAttribute ( "ws", "win32" ); //$NON-NLS-1$ //$NON-NLS-2$ 
            p2.setAttribute ( "os", "win32" ); //$NON-NLS-1$ //$NON-NLS-2$ 
            p2.setAttribute ( "arch", makeArch () ); //$NON-NLS-1$ 
            p2.setAttribute ( "nl", "en_US" ); //$NON-NLS-1$ //$NON-NLS-2$ 
            p2.setAttribute ( "destination", dest ); //$NON-NLS-1$ 

            StringBuilder sb = new StringBuilder ();
            for ( final String repo : this.p2Platform.getRepositories () )
            {
                sb.append ( "-repository " ); //$NON-NLS-1$ 
                sb.append ( repo );
                sb.append ( "\n" ); //$NON-NLS-1$ 
            }
            sb.append ( "-profileProperties org.eclipse.update.install.features=true\n" ); //$NON-NLS-1$ 
            p2.setAttribute ( "extraarguments", sb.toString () ); //$NON-NLS-1$ 

            for ( final String iu : defaultIUs () )
            {
                final Element ele = createElement ( p2, "iu" ); //$NON-NLS-1$ 
                ele.setAttribute ( "id", iu ); //$NON-NLS-1$ 
            }
            for ( final String iu : app.getProfile ().getInstallationUnits () )
            {
                final Element ele = createElement ( p2, "iu" ); //$NON-NLS-1$ 
                ele.setAttribute ( "id", iu ); //$NON-NLS-1$ 
            }

            final Element echo = createElement ( provision, "echo" ); //$NON-NLS-1$ 
            echo.setAttribute ( "append", "false" ); //$NON-NLS-1$ //$NON-NLS-2$ 
            echo.setAttribute ( "file", dest + "/configuration/config.ini" ); //$NON-NLS-1$ //$NON-NLS-2$ 

            sb = new StringBuilder ();
            sb.append ( "osgi.bundles=org.eclipse.equinox.common@1:start, org.eclipse.update.configurator@2:start, org.eclipse.scada.utils.osgi.autostart@3:start\n" ); //$NON-NLS-1$ 
            sb.append ( "eclipse.ignoreApp=true\n" ); //$NON-NLS-1$ 
            sb.append ( "osgi.noShutdown=true\n" ); //$NON-NLS-1$ 
            sb.append ( "equinox.use.ds=true\n" ); //$NON-NLS-1$ 
            sb.append ( "eclipse.p2.data.area=@config.dir/../p2/\n" ); //$NON-NLS-1$ 
            sb.append ( "eclipse.p2.profile=SDKProfile\n" ); //$NON-NLS-1$
            sb.append ( "org.eclipse.scada.utils.osgi.autostart.file=$${osgi.install.area}/startLevels.properties\n" ); //$NON-NLS-1$ 
            sb.append ( "org.eclipse.equinox.simpleconfigurator.configUrl=file\\:org.eclipse.equinox.simpleconfigurator/bundles.info\n" ); //$NON-NLS-1$ 

            echo.appendChild ( echo.getOwnerDocument ().createCDATASection ( sb.toString () ) );

            // find the two files we need for the classpath of the OSGi framework launcher
            // note: this will only work for equinox

            appendFragment ( provision, String.format ( "<copy tofile=\"%1$s/osgi.jar\"><fileset dir=\"%1$s/plugins\" includes=\"org.eclipse.osgi_*.jar\" /><mapper type=\"flatten\" /></copy>", dest ) );
            appendFragment ( provision, String.format ( "<copy tofile=\"%1$s/daemon.jar\"><fileset dir=\"%1$s/plugins\" includes=\"org.eclipse.scada.utils.osgi.daemon_*.jar\" /><mapper type=\"flatten\" /></copy>", dest ) );
        }
    }

    private String[] defaultIUs ()
    {
        return DEFAULT_IUS;
    }

    private String makeArch ()
    {
        switch ( this.platform )
        {
            case WIN32:
                return "x86"; //$NON-NLS-1$
            case WIN64:
                return "x86_64"; //$NON-NLS-1$
            default:
                throw new IllegalStateException ( String.format ( "Unsupported platform for P2: %s", this.platform ) );
        }
    }

    private void fillUnpackTaret ( final Element unpack ) throws Exception
    {
        appendFragment ( unpack, "<mkdir dir=\"unpack/commons-daemon\"/>" ); //$NON-NLS-1$
        appendFragment ( unpack, "<unzip src=\"download/commons-daemon-bin-windows.zip\" dest=\"unpack/commons-daemon\"/>" ); //$NON-NLS-1$
    }

    private void fillDownloadTaret ( final Element download ) throws Exception
    {
        appendFragment ( download, "<mkdir dir=\"download\"/>" ); //$NON-NLS-1$

        String commonsDaemonSrc = System.getProperty ( "org.eclipse.scada.configuration.world.lib.deployment.wix.commonsDaemon.nativeBin.source" ); //$NON-NLS-1$
        if ( commonsDaemonSrc == null )
        {
            commonsDaemonSrc = "https://www.apache.org/dist/commons/daemon/binaries/windows/commons-daemon-1.0.15-bin-windows.zip";
        }

        appendFragment ( download, "<get usetimestamp=\"true\" src=\"" + commonsDaemonSrc + "\" dest=\"download/commons-daemon-bin-windows.zip\"/>" ); //$NON-NLS-1$
    }

    private void fillBuildTarget ( final Element build )
    {
        final Element substc = createElement ( build, "exec" ); //$NON-NLS-1$ 
        substc.setAttribute ( "executable", "subst" ); //$NON-NLS-1$ //$NON-NLS-2$ 
        substc.setAttribute ( "failifexecutionfails", "false" ); //$NON-NLS-1$ //$NON-NLS-2$ 
        substc.setAttribute ( "failonerror", "false" ); //$NON-NLS-1$ //$NON-NLS-2$ 

        addArg ( substc, "${subst.drive}" ); //$NON-NLS-1$
        addArg ( substc, "." ); //$NON-NLS-1$

        final Element candle = createElement ( build, "exec" ); //$NON-NLS-1$
        candle.setAttribute ( "executable", "${wix.root}/bin/candle.exe" ); //$NON-NLS-1$ //$NON-NLS-2$ 
        candle.setAttribute ( "dir", "${subst.drive}/" ); //$NON-NLS-1$ //$NON-NLS-2$ 
        candle.setAttribute ( "failifexecutionfails", "true" ); //$NON-NLS-1$ //$NON-NLS-2$ 
        candle.setAttribute ( "failonerror", "true" ); //$NON-NLS-1$ //$NON-NLS-2$ 
        addArg ( candle, "-dStagingDir=${staging.dir.short}" ); //$NON-NLS-1$ 
        addArg ( candle, "-arch" ); //$NON-NLS-1$ 
        addArg ( candle, this.platform != null ? this.platform.toWixString () : MsiPlatform.WIN32.toWixString () );
        for ( final String ext : this.wixExtensions )
        {
            addArg ( candle, "-ext" );
            addArg ( candle, ext );
        }
        addArg ( candle, "Setup.wxs" ); //$NON-NLS-1$ 
        addArg ( candle, "Scan.wxs" ); //$NON-NLS-1$ 

        final Element light = createElement ( build, "exec" ); //$NON-NLS-1$ 
        light.setAttribute ( "executable", "${wix.root}/bin/light.exe" ); //$NON-NLS-1$ //$NON-NLS-2$ 
        light.setAttribute ( "dir", "${subst.drive}/" ); //$NON-NLS-1$ //$NON-NLS-2$ 
        light.setAttribute ( "failifexecutionfails", "true" ); //$NON-NLS-1$ //$NON-NLS-2$ 
        light.setAttribute ( "failonerror", "true" ); //$NON-NLS-1$ //$NON-NLS-2$ 
        for ( final String ext : this.wixExtensions )
        {
            addArg ( light, "-ext" );
            addArg ( light, ext );
        }
        addArg ( light, "Setup.wixobj" ); //$NON-NLS-1$ 
        addArg ( light, "Scan.wixobj" ); //$NON-NLS-1$ 
        addArg ( light, "-out" ); //$NON-NLS-1$ 
        addArg ( light, this.outputFilename );

        final Element substd = createElement ( build, "exec" ); //$NON-NLS-1$ 
        substd.setAttribute ( "executable", "subst" ); //$NON-NLS-1$ //$NON-NLS-2$ 
        substd.setAttribute ( "failifexecutionfails", "false" ); //$NON-NLS-1$ //$NON-NLS-2$ 
        substd.setAttribute ( "failonerror", "false" ); //$NON-NLS-1$ //$NON-NLS-2$ 

        addArg ( substd, "${subst.drive}" ); //$NON-NLS-1$
        addArg ( substd, "/D" ); //$NON-NLS-1$
    }

    private void fillHeatTarget ( final Element heat )
    {
        final Element substc = createElement ( heat, "exec" ); //$NON-NLS-1$ 
        substc.setAttribute ( "executable", "subst" ); //$NON-NLS-1$ //$NON-NLS-2$ 
        substc.setAttribute ( "failifexecutionfails", "false" ); //$NON-NLS-1$ //$NON-NLS-2$ 
        substc.setAttribute ( "failonerror", "false" ); //$NON-NLS-1$ //$NON-NLS-2$ 

        addArg ( substc, "${subst.drive}" ); //$NON-NLS-1$
        addArg ( substc, "." ); //$NON-NLS-1$

        final Element ele = createElement ( heat, "exec" ); //$NON-NLS-1$ 
        ele.setAttribute ( "executable", "${wix.root}/bin/heat.exe" ); //$NON-NLS-1$ //$NON-NLS-2$ 
        ele.setAttribute ( "dir", "${staging.dir.short}" ); //$NON-NLS-1$ //$NON-NLS-2$ 
        ele.setAttribute ( "failifexecutionfails", "true" ); //$NON-NLS-1$ //$NON-NLS-2$ 
        ele.setAttribute ( "failonerror", "true" ); //$NON-NLS-1$ //$NON-NLS-2$ 

        addArg ( ele, "dir" ); //$NON-NLS-1$
        addArg ( ele, "${staging.dir.short}" ); //$NON-NLS-1$
        addArg ( ele, "-gg" ); //$NON-NLS-1$
        addArg ( ele, "-cg" ); //$NON-NLS-1$
        addArg ( ele, "ScanComponent" ); //$NON-NLS-1$
        addArg ( ele, "-sfrag" ); //$NON-NLS-1$
        addArg ( ele, "-sreg" ); //$NON-NLS-1$
        addArg ( ele, "-scom" ); //$NON-NLS-1$
        addArg ( ele, "-suid" ); //$NON-NLS-1$
        addArg ( ele, "-srd" ); //$NON-NLS-1$
        addArg ( ele, "-dr" ); //$NON-NLS-1$
        addArg ( ele, "INSTALLDIR" ); //$NON-NLS-1$
        addArg ( ele, "-var" ); //$NON-NLS-1$
        addArg ( ele, "var.StagingDir" ); //$NON-NLS-1$
        addArg ( ele, "-out" ); //$NON-NLS-1$
        addArg ( ele, "${subst.drive}/Scan.wxs" ); //$NON-NLS-1$

        final Element substd = createElement ( heat, "exec" ); //$NON-NLS-1$ 
        substd.setAttribute ( "executable", "subst" ); //$NON-NLS-1$ //$NON-NLS-2$ 
        substd.setAttribute ( "failifexecutionfails", "false" ); //$NON-NLS-1$ //$NON-NLS-2$ 
        substd.setAttribute ( "failonerror", "false" ); //$NON-NLS-1$ //$NON-NLS-2$ 

        addArg ( substd, "${subst.drive}" ); //$NON-NLS-1$
        addArg ( substd, "/D" ); //$NON-NLS-1$

    }

    private void addArg ( final Element ele, final String string )
    {
        final Element arg = createElement ( ele, "arg" ); //$NON-NLS-1$
        arg.setAttribute ( "value", string ); //$NON-NLS-1$
    }

    private void fillCleanTarget ( final Element clean ) throws Exception
    {
        appendFragment ( clean, "<delete dir=\"unpack\"/>" ); //$NON-NLS-1$
        appendFragment ( clean, "<delete dir=\".\"><include name=\"*.msi\"/><include name=\"*.wixobj\"/><include name=\"Scan.wxs\"/></delete>" ); //$NON-NLS-1$
    }

    private Element createTarget ( final Element project, final String name )
    {
        return createTarget ( project, name, Collections.<String> emptyList () );
    }

    private Element createTarget ( final Element project, final String name, final List<String> depends )
    {
        final Element ele = createElement ( project, "target" ); //$NON-NLS-1$
        ele.setAttribute ( "name", name ); //$NON-NLS-1$
        if ( !depends.isEmpty () )
        {
            ele.setAttribute ( "depends", StringHelper.join ( depends, "," ) ); //$NON-NLS-1$  //$NON-NLS-2$
        }

        ele.setAttribute ( "unless", "skip." + name ); //$NON-NLS-1$ //$NON-NLS-2$ 
        return ele;
    }

    private void createProperty ( final Element parent, final String key, final String type, final String value )
    {
        final Element ele = createElement ( parent, "property" ); //$NON-NLS-1$
        ele.setAttribute ( "name", key ); //$NON-NLS-1$
        ele.setAttribute ( type, value );
    }

    public void addApplication ( final Application application )
    {
        this.applications.add ( application );
    }

}
