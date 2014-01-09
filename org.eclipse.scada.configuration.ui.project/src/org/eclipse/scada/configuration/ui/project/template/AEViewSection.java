/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.ui.project.template;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelFactory;
import org.eclipse.pde.core.plugin.IPluginReference;
import org.eclipse.pde.ui.templates.PluginReference;
import org.eclipse.scada.utils.collection.MapBuilder;

public class AEViewSection extends BaseTemplate
{

    private final List<ColumnInformation> defaultConfigurationConfiguration;

    public AEViewSection ()
    {
        this.defaultConfigurationConfiguration = new LinkedList<AEViewSection.ColumnInformation> ();
        this.defaultConfigurationConfiguration.add ( new ColumnInformation ( "Source Timestamp", true, 120, "sourceTimestamp", null ) ); //$NON-NLS-2$
        this.defaultConfigurationConfiguration.add ( new ColumnInformation ( "Event Type", false, 120, "variant", new MapBuilder<String, String> ().put ( "key", "eventType" ).put ( "decoration", "MONITOR" ).build () ) );
        addDefaultColumn ( this.defaultConfigurationConfiguration, "Value", "value" ); //$NON-NLS-2$
        addDefaultColumn ( this.defaultConfigurationConfiguration, "Monitor Type", "monitorType" ); //$NON-NLS-2$
        addDefaultColumn ( this.defaultConfigurationConfiguration, "Item", "item" ); //$NON-NLS-2$
        addDefaultColumn ( this.defaultConfigurationConfiguration, "Item Description", "itemDescription" ); //$NON-NLS-2$
        addDefaultColumn ( this.defaultConfigurationConfiguration, "Message", "message" ); //$NON-NLS-2$
        addDefaultColumn ( this.defaultConfigurationConfiguration, "Actor Name", "actorName" ); //$NON-NLS-2$
        this.defaultConfigurationConfiguration.add ( new ColumnInformation ( "Actor Type", false, 120, "variant", new MapBuilder<String, String> ().put ( "decoration", "ACTOR" ).build () ) );
        addDefaultColumn ( this.defaultConfigurationConfiguration, "Priority", "priority" ); //$NON-NLS-2$
        addDefaultColumn ( this.defaultConfigurationConfiguration, "Source", "source" ); //$NON-NLS-2$
        addDefaultColumn ( this.defaultConfigurationConfiguration, "Hive", "hive" ); //$NON-NLS-2$
        addDefaultColumn ( this.defaultConfigurationConfiguration, "System", "system" ); //$NON-NLS-2$
        for ( int i = 0; i < 10; i++ )
        {
            this.defaultConfigurationConfiguration.add ( new ColumnInformation ( String.format ( "Level %d", i ), false, 90, "variant", new MapBuilder<String, String> ().put ( "key", String.format ( "level.%d", i ) ).build () ) ); //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
        }
        this.defaultConfigurationConfiguration.add ( new ColumnInformation ( "Entry Timestamp", true, 120, "entryTimestamp", null ) ); //$NON-NLS-2$
    }

    private static void addDefaultColumn ( final List<ColumnInformation> defaultConfigurationConfiguration, final String label, final String field )
    {
        defaultConfigurationConfiguration.add ( new ColumnInformation ( label, false, 120, "variant", new MapBuilder<String, String> ().put ( "key", field ).build () ) ); //$NON-NLS-1$ //$NON-NLS-2$ 
    }

    @Override
    public String getUsedExtensionPoint ()
    {
        return null;
    }

    @Override
    public String[] getNewFiles ()
    {
        return new String[] { "resources/" }; //$NON-NLS-1$ 
    }

    @Override
    public String getSectionId ()
    {
        return "aeViews"; //$NON-NLS-1$ 
    }

    private static final class ColumnInformation
    {
        private final String label;

        private final boolean sortable;

        private final int initialSize;

        private final String type;

        private final Map<String, String> parameters;

        public ColumnInformation ( final String label, final boolean sortable, final int initialSize, final String type, final Map<String, String> parameters )
        {
            super ();
            this.label = label;
            this.sortable = sortable;
            this.initialSize = initialSize;
            this.type = type;
            this.parameters = parameters;
        }

        public String getLabel ()
        {
            return this.label;
        }

        public boolean isSortable ()
        {
            return this.sortable;
        }

        public int getInitialSize ()
        {
            return this.initialSize;
        }

        public String getType ()
        {
            return this.type;
        }

        public Map<String, String> getParameters ()
        {
            return this.parameters;
        }

    }

    @Override
    protected void updateModel ( final IProgressMonitor monitor ) throws CoreException
    {
        final IPluginModelFactory factory = this.model.getPluginFactory ();
        final IPluginBase plugin = this.model.getPluginBase ();

        // setManifestHeader ( Constants.BUNDLE_LOCALIZATION_DEFAULT_BASENAME, "OSGI-INF/in10/bundle.properties" );

        final IPluginExtension ext = createExtension ( "org.eclipse.scada.ae.ui.views.configuration", false ); //$NON-NLS-1$
        plugin.add ( ext );

        final IPluginElement menu = createAlarmsMenu ( factory, plugin );

        createMonitorView ( factory, ext, menu, "monitors.not_ok", "All &Alarms" ); //$NON-NLS-1$ 
        createMonitorView ( factory, ext, menu, "monitors.ack_required", "A&cknowledge required" ); //$NON-NLS-1$ 
        createMonitorView ( factory, ext, menu, "monitors.warning.not_ok", "Only active warnings" ); //$NON-NLS-1$ 
        createMonitorView ( factory, ext, menu, "monitors.alarm.not_ok", "Only active alarms" ); //$NON-NLS-1$
        addSeperator ( factory, menu, "separator2" ); //$NON-NLS-1$ 
        createEventView ( factory, ext, menu, "events.all", "&Latest Events", 20000, "monitors.not_ok" ); //$NON-NLS-1$ //$NON-NLS-3$
        createQueryView ( factory, ext, menu, "eventHistoryView", "Query &Historic Events" ); //$NON-NLS-1$ 
        createAlarmNotifier ( factory, ext );
        createColumnInformation ( factory, ext, "defaultConfiguration", this.defaultConfigurationConfiguration );//$NON-NLS-1$ 

    }

    private void addSeperator ( final IPluginModelFactory factory, final IPluginElement menu, final String id ) throws CoreException
    {
        final IPluginElement ele = factory.createElement ( menu );
        ele.setName ( "separator" ); //$NON-NLS-1$ 
        ele.setAttribute ( "name", makeId ( id ) ); //$NON-NLS-1$ 
        ele.setAttribute ( "visible", "true" ); //$NON-NLS-1$ //$NON-NLS-2$ 
    }

    protected IPluginElement createAlarmsMenu ( final IPluginModelFactory factory, final IPluginBase plugin ) throws CoreException
    {
        final IPluginExtension menuExt = createExtension ( "org.eclipse.ui.menus", false ); //$NON-NLS-1$
        plugin.add ( menuExt );

        final IPluginElement menuEle = factory.createElement ( menuExt );
        menuExt.add ( menuEle );
        menuEle.setName ( "menuContribution" ); //$NON-NLS-1$ 
        menuEle.setAttribute ( "locationURI", "menu:org.eclipse.ui.main.menu" ); //$NON-NLS-1$ //$NON-NLS-2$ 

        final IPluginElement menu = factory.createElement ( menuEle );
        menuEle.add ( menu );
        menu.setName ( "menu" ); //$NON-NLS-1$ 
        menu.setAttribute ( "label", "Alarms" ); //$NON-NLS-1$

        return menu;
    }

    private void createColumnInformation ( final IPluginModelFactory factory, final IPluginExtension ext, final String id, final List<ColumnInformation> configuration ) throws CoreException
    {
        final IPluginElement ele = addElement ( factory, ext, "columnInformationDefinition", id );//$NON-NLS-1$ 

        for ( final ColumnInformation ci : configuration )
        {
            final IPluginElement colEle = factory.createElement ( ele );
            ele.add ( colEle );
            colEle.setName ( "columnInformation" ); //$NON-NLS-1$ 
            colEle.setAttribute ( "initialSize", String.format ( "%d", ci.getInitialSize () ) ); //$NON-NLS-1$ //$NON-NLS-2$ 
            colEle.setAttribute ( "sortable", ci.isSortable () ? "true" : "false" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
            colEle.setAttribute ( "label", ci.getLabel () ); //$NON-NLS-1$ 
            colEle.setAttribute ( "type", ci.getType () ); //$NON-NLS-1$ 
            if ( ci.getParameters () != null )
            {
                for ( final Map.Entry<String, String> entry : ci.getParameters ().entrySet () )
                {
                    final IPluginElement colPara = factory.createElement ( colEle );
                    colEle.add ( colPara );
                    colPara.setName ( "columnParameter" ); //$NON-NLS-1$ 
                    colPara.setAttribute ( "key", entry.getKey () ); //$NON-NLS-1$ 
                    colPara.setAttribute ( "value", entry.getValue () ); //$NON-NLS-1$ 
                }
            }
        }
    }

    private void createAlarmNotifier ( final IPluginModelFactory factory, final IPluginExtension ext ) throws CoreException
    {
        final IPluginElement ele = factory.createElement ( ext );
        ext.add ( ele );

        ele.setName ( "alarmNotifier" ); //$NON-NLS-1$
        ele.setAttribute ( "connectionId", makeConnectionId ( "da" ) ); //$NON-NLS-1$ //$NON-NLS-2$
        ele.setAttribute ( "prefix", "ae.server.info" ); //$NON-NLS-1$ //$NON-NLS-2$
        ele.setAttribute ( "soundFile", "resources/alert.wav" ); //$NON-NLS-1$ //$NON-NLS-2$

        final IPluginElement cmd1 = factory.createElement ( ele );
        ele.add ( cmd1 );
        cmd1.setName ( "ackAlarmsAvailableCommand" ); //$NON-NLS-1$ 
        cmd1.setAttribute ( "id", "org.eclipse.scada.ui.utils.showView" ); //$NON-NLS-1$ //$NON-NLS-2$
        addParameter ( factory, cmd1, "org.eclipse.scada.ui.utils.showView.viewId", String.format ( "org.eclipse.scada.ae.ui.views.views.monitors:%s", makeId ( "monitors.ack_required" ) ) ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

        final IPluginElement cmd2 = factory.createElement ( ele );
        ele.add ( cmd2 );
        cmd2.setName ( "alarmsAvailableCommand" ); //$NON-NLS-1$ 
        cmd2.setAttribute ( "id", "org.eclipse.scada.ui.utils.showView" ); //$NON-NLS-1$ //$NON-NLS-2$
        addParameter ( factory, cmd2, "org.eclipse.scada.ui.utils.showView.viewId", String.format ( "org.eclipse.scada.ae.ui.views.views.monitors:%s", makeId ( "monitors.not_ok" ) ) ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

        // the menu

        final IPluginExtension menuExt = createExtension ( "org.eclipse.ui.menus", false ); //$NON-NLS-1$
        this.model.getPluginBase ().add ( menuExt );

        final IPluginElement menuEle = factory.createElement ( menuExt );
        menuEle.setName ( "menuContribution" ); //$NON-NLS-1$
        menuEle.setAttribute ( "locationURI", "toolbar:org.eclipse.scada.core.ui.connection.login.verticalTrim" ); //$NON-NLS-1$ //$NON-NLS-2$
        menuExt.add ( menuEle );

        final IPluginElement sub = factory.createElement ( menuEle );
        menuEle.add ( sub );
        sub.setName ( "control" ); //$NON-NLS-1$ 
        sub.setAttribute ( "class", "org.eclipse.scada.ae.ui.views.contributions.AlarmNotifier" ); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private void createQueryView ( final IPluginModelFactory factory, final IPluginExtension ext, final IPluginElement menu, final String id, final String label ) throws CoreException
    {
        final IPluginElement ele = factory.createElement ( ext );
        ele.setName ( "eventHistoryView" ); //$NON-NLS-1$ 
        ele.setAttribute ( "id", makeId ( id ) ); //$NON-NLS-1$ 
        ele.setAttribute ( "columnInformationDefinition", "defaultConfiguration" ); //$NON-NLS-1$ //$NON-NLS-2$
        ele.setAttribute ( "connectionString", makeConnectionId ( "ae" ) ); //$NON-NLS-1$ //$NON-NLS-2$
        ele.setAttribute ( "connectionType", "ID" ); //$NON-NLS-1$ //$NON-NLS-2$
        ele.setAttribute ( "label", clear ( label ) ); //$NON-NLS-1$ 
        ext.add ( ele );

        createShowView ( factory, menu, makeId ( id ), label, "org.eclipse.scada.ae.ui.views.views.eventhistory" );
    }

    protected void createEventView ( final IPluginModelFactory factory, final IPluginExtension ext, final IPluginElement menu, final String eventPoolQueryId, final String label, final int size, final String monitorId ) throws CoreException
    {
        final IPluginElement ele = factory.createElement ( ext );
        ele.setName ( "eventPoolView" );//$NON-NLS-1$ 
        ele.setAttribute ( "id", makeId ( eventPoolQueryId ) ); //$NON-NLS-1$
        ele.setAttribute ( "eventPoolQueryId", eventPoolQueryId );
        ele.setAttribute ( "columnInformationDefinition", "defaultConfiguration" ); //$NON-NLS-1$ //$NON-NLS-2$
        ele.setAttribute ( "connectionString", makeConnectionId ( "ae" ) ); //$NON-NLS-1$ //$NON-NLS-2$
        ele.setAttribute ( "connectionType", "ID" ); //$NON-NLS-1$ //$NON-NLS-2$
        ele.setAttribute ( "monitorQueryId", monitorId ); //$NON-NLS-1$ 
        ele.setAttribute ( "label", clear ( label ) ); //$NON-NLS-1$ 
        ele.setAttribute ( "maxNumberOfEvents", String.format ( "%d", size ) ); //$NON-NLS-1$ //$NON-NLS-2$
        ext.add ( ele );

        createShowView ( factory, menu, makeId ( eventPoolQueryId ), label, "org.eclipse.scada.ae.ui.views.views.eventpool" );
    }

    protected void createMonitorView ( final IPluginModelFactory factory, final IPluginExtension ext, final IPluginElement menu, final String monitorId, final String label ) throws CoreException
    {
        final IPluginElement ele = factory.createElement ( ext );
        ele.setName ( "monitorView" ); //$NON-NLS-1$ 
        ele.setAttribute ( "id", makeId ( monitorId ) ); //$NON-NLS-1$ 
        ele.setAttribute ( "connectionString", makeConnectionId ( "ae" ) ); //$NON-NLS-1$ //$NON-NLS-2$
        ele.setAttribute ( "connectionType", "ID" ); //$NON-NLS-1$ //$NON-NLS-2$
        ele.setAttribute ( "monitorQueryId", monitorId ); //$NON-NLS-1$ 
        ele.setAttribute ( "label", clear ( label ) ); //$NON-NLS-1$ 
        ext.add ( ele );

        createShowView ( factory, menu, makeId ( monitorId ), label, "org.eclipse.scada.ae.ui.views.views.monitors" );
    }

    protected void createShowView ( final IPluginModelFactory factory, final IPluginElement menu, final String subViewId, final String label, final String viewId ) throws CoreException
    {
        final IPluginElement cmd = factory.createElement ( menu );
        menu.add ( cmd );
        cmd.setName ( "command" );//$NON-NLS-1$ 
        cmd.setAttribute ( "commandId", "org.eclipse.scada.ui.utils.showView" );//$NON-NLS-1$ //$NON-NLS-2$
        cmd.setAttribute ( "label", label );//$NON-NLS-1$ 
        cmd.setAttribute ( "style", "push" );//$NON-NLS-1$ //$NON-NLS-2$

        final IPluginElement para = factory.createElement ( cmd );
        cmd.add ( para );
        para.setName ( "parameter" );
        para.setAttribute ( "name", "org.eclipse.scada.ui.utils.showView.viewId" );//$NON-NLS-1$ //$NON-NLS-2$
        para.setAttribute ( "value", String.format ( "%s:%s", viewId, subViewId ) );//$NON-NLS-1$ //$NON-NLS-2$
    }

    private String clear ( final String label )
    {
        return label.replace ( "&", "" ); //$NON-NLS-1$ //$NON-NLS-2$
    }

    @Override
    protected void fillDependencies ( final Collection<IPluginReference> dependencies, final String schemaVersion )
    {
        dependencies.add ( new PluginReference ( "org.eclipse.scada.ae.ui.views", "0.1.0", 0 ) ); //$NON-NLS-1$
    }

}
