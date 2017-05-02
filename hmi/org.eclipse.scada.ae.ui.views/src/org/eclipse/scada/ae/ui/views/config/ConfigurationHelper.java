/*******************************************************************************
 * Copyright (c) 2010, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - fix fields for levels
 *******************************************************************************/
package org.eclipse.scada.ae.ui.views.config;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.IParameter;
import org.eclipse.core.commands.Parameterization;
import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.scada.ae.Event.Fields;
import org.eclipse.scada.ae.ui.views.views.ColumnProperties;
import org.eclipse.scada.ae.ui.views.views.table.VariantLabelProvider.Decoration;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Enums;

public class ConfigurationHelper
{

    private static final int DEFAULT_INITIAL_SIZE = 120;

    private static final Logger logger = LoggerFactory.getLogger ( ConfigurationHelper.class );

    private static final String EXTP_CFG_ID = "org.eclipse.scada.ae.ui.views.configuration"; //$NON-NLS-1$

    public static MonitorViewConfiguration findMonitorViewConfiguration ( final String configurationId )
    {
        if ( configurationId == null )
        {
            return null;
        }

        for ( final MonitorViewConfiguration cfg : loadAllMonitorConfigurations () )
        {
            if ( configurationId.equals ( cfg.getId () ) )
            {
                return cfg;
            }
        }

        return null;
    }

    public static List<MonitorViewConfiguration> loadAllMonitorConfigurations ()
    {
        final List<MonitorViewConfiguration> result = new ArrayList<MonitorViewConfiguration> ();

        for ( final IConfigurationElement ele : Platform.getExtensionRegistry ().getConfigurationElementsFor ( EXTP_CFG_ID ) )
        {
            if ( !"monitorView".equals ( ele.getName () ) ) //$NON-NLS-1$
            {
                continue;
            }

            final MonitorViewConfiguration cfg = convertMonitor ( ele );
            if ( cfg != null )
            {
                result.add ( cfg );
            }
        }

        return result;
    }

    private static MonitorViewConfiguration convertMonitor ( final IConfigurationElement ele )
    {
        try
        {
            final String id = ele.getAttribute ( "id" ); //$NON-NLS-1$
            final String monitorQueryId = ele.getAttribute ( "monitorQueryId" ); //$NON-NLS-1$
            final String connectionString = ele.getAttribute ( "connectionString" ); //$NON-NLS-1$
            final ConnectionType connectionType = ConnectionType.valueOf ( ele.getAttribute ( "connectionType" ) ); //$NON-NLS-1$
            final String label = ele.getAttribute ( "label" ); //$NON-NLS-1$
            final List<ColumnProperties> columns = parseColumnSettings ( ele.getAttribute ( "columns" ) ); //$NON-NLS-1$

            return new MonitorViewConfiguration ( id, monitorQueryId, connectionString, connectionType, label, columns );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to convert monitor configuration: {}", ele ); //$NON-NLS-1$
            return null;
        }
    }

    public static EventPoolViewConfiguration findEventPoolViewConfiguration ( final String configurationId )
    {
        if ( configurationId == null )
        {
            return null;
        }

        for ( final EventPoolViewConfiguration cfg : loadAllEventPoolConfigurations () )
        {
            if ( configurationId.equals ( cfg.getId () ) )
            {
                return cfg;
            }
        }

        return null;
    }

    public static List<EventPoolViewConfiguration> loadAllEventPoolConfigurations ()
    {
        final List<EventPoolViewConfiguration> result = new ArrayList<EventPoolViewConfiguration> ();

        for ( final IConfigurationElement ele : Platform.getExtensionRegistry ().getConfigurationElementsFor ( EXTP_CFG_ID ) )
        {
            if ( !"eventPoolView".equals ( ele.getName () ) ) //$NON-NLS-1$
            {
                continue;
            }

            final EventPoolViewConfiguration cfg = convertEventPool ( ele );
            if ( cfg != null )
            {
                result.add ( cfg );
            }
        }

        return result;
    }

    private static EventPoolViewConfiguration convertEventPool ( final IConfigurationElement ele )
    {
        try
        {
            final String id = ele.getAttribute ( "id" ); //$NON-NLS-1$
            final String monitorQueryId = ele.getAttribute ( "monitorQueryId" ); //$NON-NLS-1$
            final String connectionString = ele.getAttribute ( "connectionString" ); //$NON-NLS-1$
            final String eventPoolQueryId = ele.getAttribute ( "eventPoolQueryId" ); //$NON-NLS-1$
            final ConnectionType connectionType = ConnectionType.valueOf ( ele.getAttribute ( "connectionType" ) ); //$NON-NLS-1$
            final String label = ele.getAttribute ( "label" ); //$NON-NLS-1$

            int maxNumberOfEvents = 0;
            int forceEventLimit = Integer.getInteger ( "org.eclipse.scada.ae.ui.views.config.defaultForceLimit", 200000 );//$NON-NLS-1$

            try
            {
                forceEventLimit = Integer.parseInt ( ele.getAttribute ( "forceEventLimit" ) );//$NON-NLS-1$
            }
            catch ( final Exception e )
            {
                // ignore
            }

            if ( Arrays.asList ( ele.getAttributeNames () ).contains ( "maxNumberOfEvents" ) ) //$NON-NLS-1$
            {
                final String s = ele.getAttribute ( "maxNumberOfEvents" ); //$NON-NLS-1$
                try
                {
                    maxNumberOfEvents = Integer.parseInt ( s );
                }
                catch ( final NumberFormatException e )
                {
                    // pass
                }

            }
            final List<ColumnLabelProviderInformation> columnInformation = new LinkedList<ColumnLabelProviderInformation> ();
            fillColumnInformation ( columnInformation, ele );

            return new EventPoolViewConfiguration ( id, monitorQueryId, eventPoolQueryId, connectionString, connectionType, label, maxNumberOfEvents, forceEventLimit, columnInformation );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to convert event pool configuration: {}", ele ); //$NON-NLS-1$
            return null;
        }
    }

    private static void fillColumnInformation ( final List<ColumnLabelProviderInformation> columnInformation, final IConfigurationElement ele )
    {
        // load definition

        final String definitionId = ele.getAttribute ( "columnInformationDefinition" );
        if ( definitionId != null && !definitionId.isEmpty () )
        {
            for ( final IConfigurationElement defEle : Platform.getExtensionRegistry ().getConfigurationElementsFor ( EXTP_CFG_ID ) )
            {
                if ( !"columnInformationDefinition".equals ( defEle.getName () ) ) //$NON-NLS-1$
                {
                    continue;
                }
                fillColumnInformation ( columnInformation, defEle );
            }
        }

        // load direct elements

        for ( final IConfigurationElement child : ele.getChildren ( "columnInformation" ) )
        {
            final String type = child.getAttribute ( "type" );
            final String label = child.getAttribute ( "label" );

            int initialSize = DEFAULT_INITIAL_SIZE;
            try
            {
                initialSize = Integer.parseInt ( child.getAttribute ( "initialSize" ) );
            }
            catch ( final Exception e )
            {
            }

            final boolean sortable = Boolean.parseBoolean ( child.getAttribute ( "sortable" ) );

            final Map<String, String> parameters = new HashMap<String, String> ();

            for ( final IConfigurationElement param : child.getChildren ( "columnParameter" ) )
            {
                final String key = param.getAttribute ( "key" );
                final String value = param.getAttribute ( "value" );
                if ( key != null )
                {
                    parameters.put ( key, value );
                }
            }

            if ( type != null )
            {
                columnInformation.add ( new ColumnLabelProviderInformation ( label, type, sortable, initialSize, parameters ) );
            }
        }

        if ( columnInformation.isEmpty () )
        {
            fillWithDefault ( columnInformation );
        }
    }

    private static void fillWithDefault ( final List<ColumnLabelProviderInformation> columnInformation )
    {

        columnInformation.add ( new ColumnLabelProviderInformation ( "sourceTimestamp", "sourceTimestamp", true, DEFAULT_INITIAL_SIZE, Collections.<String, String> emptyMap () ) );

        for ( final Fields field : Fields.values () )
        {
            if ( Enums.getField ( field ).getAnnotation ( Deprecated.class ) != null )
            {
                // ignore deprecated fields
                continue;
            }

            final Map<String, String> properties = new HashMap<String, String> ();
            properties.put ( "key", field.getName () );

            switch ( field )
            {
                case ACTOR_NAME:
                    properties.put ( "decoration", Decoration.ACTOR.toString () );
                    break;
                case EVENT_TYPE:
                    properties.put ( "decoration", Decoration.MONITOR.toString () );
                    break;
                default:
                    break;
            }

            columnInformation.add ( new ColumnLabelProviderInformation ( field.getName (), "variant", false, DEFAULT_INITIAL_SIZE, properties ) );
        }

        columnInformation.add ( new ColumnLabelProviderInformation ( "entryTimestamp", "entryTimestamp", true, DEFAULT_INITIAL_SIZE, Collections.<String, String> emptyMap () ) );
    }

    private static List<ColumnProperties> parseColumnSettings ( final String columns )
    {
        final ArrayList<ColumnProperties> result = new ArrayList<ColumnProperties> ();
        if ( columns == null || "".equals ( columns.trim () ) ) //$NON-NLS-1$
        {
            return result;
        }
        for ( final String col : columns.split ( "," ) ) //$NON-NLS-1$
        {
            final String[] settings = col.split ( ":" ); //$NON-NLS-1$
            if ( settings.length == 0 )
            {
                continue;
            }
            final ColumnProperties cp = new ColumnProperties ();
            if ( settings.length > 0 )
            {
                cp.setNo ( Integer.parseInt ( settings[0] ) );
            }
            if ( settings.length > 1 )
            {
                cp.setWidth ( Integer.parseInt ( settings[1] ) );
            }
            result.add ( cp );
        }
        return result;
    }

    public static EventHistoryViewConfiguration findEventHistoryViewConfiguration ( final String configurationId )
    {
        if ( configurationId == null )
        {
            return null;
        }

        for ( final EventHistoryViewConfiguration cfg : loadAllEventHistoryConfigurations () )
        {
            if ( configurationId.equals ( cfg.getId () ) )
            {
                return cfg;
            }
        }

        return null;
    }

    public static List<EventHistoryViewConfiguration> loadAllEventHistoryConfigurations ()
    {
        final List<EventHistoryViewConfiguration> result = new ArrayList<EventHistoryViewConfiguration> ();

        for ( final IConfigurationElement ele : Platform.getExtensionRegistry ().getConfigurationElementsFor ( EXTP_CFG_ID ) )
        {
            if ( !"eventHistoryView".equals ( ele.getName () ) ) //$NON-NLS-1$
            {
                continue;
            }

            final EventHistoryViewConfiguration cfg = convertEventHistory ( ele );
            if ( cfg != null )
            {
                result.add ( cfg );
            }
        }

        return result;
    }

    private static EventHistoryViewConfiguration convertEventHistory ( final IConfigurationElement ele )
    {
        try
        {
            final String id = ele.getAttribute ( "id" ); //$NON-NLS-1$
            final String connectionString = ele.getAttribute ( "connectionString" ); //$NON-NLS-1$
            final ConnectionType connectionType = ConnectionType.valueOf ( ele.getAttribute ( "connectionType" ) ); //$NON-NLS-1$
            final String label = ele.getAttribute ( "label" ); //$NON-NLS-1$

            final List<ColumnLabelProviderInformation> columnInformation = new LinkedList<ColumnLabelProviderInformation> ();
            fillColumnInformation ( columnInformation, ele );

            return new EventHistoryViewConfiguration ( id, connectionString, connectionType, label, columnInformation );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to convert event history configuration: {}", ele ); //$NON-NLS-1$
            return null;
        }
    }

    public static AlarmNotifierConfiguration findAlarmNotifierConfiguration ()
    {
        for ( final IConfigurationElement ele : Platform.getExtensionRegistry ().getConfigurationElementsFor ( EXTP_CFG_ID ) )
        {
            if ( !"alarmNotifier".equals ( ele.getName () ) ) //$NON-NLS-1$
            {
                continue;
            }

            final AlarmNotifierConfiguration cfg = convertAlarmNotifier ( ele );
            if ( cfg != null )
            {
                return cfg;
            }
        }
        return null;
    }

    private static AlarmNotifierConfiguration convertAlarmNotifier ( final IConfigurationElement ele )
    {
        try
        {
            final String connectionId = ele.getAttribute ( "connectionId" ); //$NON-NLS-1$
            final String prefix = ele.getAttribute ( "prefix" ) == null ? "ae.server.info" : ele.getAttribute ( "prefix" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ $NON-NLS-2$
            final URL soundFile = Platform.getBundle ( ele.getContributor ().getName () ).getEntry ( ele.getAttribute ( "soundFile" ) ); //$NON-NLS-1$
            final ParameterizedCommand ackAlarmsAvailableCommand = convertCommand ( ele.getChildren ( "ackAlarmsAvailableCommand" )[0] ); //$NON-NLS-1$
            final ParameterizedCommand alarmsAvailableCommand = convertCommand ( ele.getChildren ( "alarmsAvailableCommand" )[0] ); //$NON-NLS-1$
            return new AlarmNotifierConfiguration ( connectionId, prefix, soundFile, ackAlarmsAvailableCommand, alarmsAvailableCommand );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to convert alarm notifier configuration: {}", ele ); //$NON-NLS-1$
            return null;
        }
    }

    private static ParameterizedCommand convertCommand ( final IConfigurationElement commandElement ) throws NotDefinedException, InvalidRegistryObjectException
    {
        final ICommandService commandService = (ICommandService)PlatformUI.getWorkbench ().getService ( ICommandService.class );
        final Command command = commandService.getCommand ( commandElement.getAttribute ( "id" ) ); //$NON-NLS-1$
        final List<Parameterization> parameters = new ArrayList<Parameterization> ();
        for ( final IConfigurationElement parameter : commandElement.getChildren ( "parameter" ) ) //$NON-NLS-1$
        {
            final IParameter name = command.getParameter ( parameter.getAttribute ( "name" ) ); //$NON-NLS-1$
            final String value = parameter.getAttribute ( "value" ); //$NON-NLS-1$
            parameters.add ( new Parameterization ( name, value ) );
        }
        return new ParameterizedCommand ( command, parameters.toArray ( new Parameterization[] {} ) );
    }
}
