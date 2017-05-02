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
package org.eclipse.scada.da.server.exporter.modbus.internal;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

import org.apache.mina.core.service.IoProcessor;
import org.apache.mina.transport.socket.nio.NioSession;
import org.eclipse.scada.ca.ConfigurationDataHelper;
import org.eclipse.scada.da.server.common.DataItem;
import org.eclipse.scada.da.server.exporter.common.HiveSource;
import org.eclipse.scada.da.server.exporter.modbus.ModbusExport;
import org.eclipse.scada.da.server.exporter.modbus.io.DoubleType;
import org.eclipse.scada.da.server.exporter.modbus.io.IntegerType;
import org.eclipse.scada.da.server.exporter.modbus.io.ShortIntegerType;
import org.eclipse.scada.da.server.exporter.modbus.io.SourceDefinition;
import org.eclipse.scada.da.server.exporter.modbus.io.SourceType;
import org.eclipse.scada.da.server.exporter.modbus.io.UnsignedIntegerType;
import org.eclipse.scada.da.server.exporter.modbus.io.UnsignedShortIntegerType;
import org.eclipse.scada.utils.osgi.pool.ManageableObjectPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModbusExportImpl extends ModbusExport
{

    private final static Logger logger = LoggerFactory.getLogger ( ModbusExportImpl.class );

    public ModbusExportImpl ( final String id, final ScheduledExecutorService executor, final IoProcessor<NioSession> processor, final HiveSource hiveSource, final ManageableObjectPool<DataItem> itemObjectPool )
    {
        super ( id, executor, processor, hiveSource, itemObjectPool );
    }

    public void update ( final Map<String, String> parameters ) throws Exception
    {
        final ConfigurationDataHelper cfg = new ConfigurationDataHelper ( parameters );
        setReadTimeout ( cfg.getInteger ( "timeout", 10_000 ) ); //$NON-NLS-1$
        setPort ( cfg.getInteger ( "port", 502 ) ); //$NON-NLS-1$
        setSlaveId ( (short)cfg.getInteger ( "slaveId", 1 ) ); //$NON-NLS-1$
        setProperties ( cfg.getPrefixedProperties ( "hive." ) ); //$NON-NLS-1$
        configureDefinitions ( cfg );
    }

    protected void configureDefinitions ( final ConfigurationDataHelper cfg )
    {
        final List<SourceDefinition> defs = new LinkedList<> ();

        for ( final Map.Entry<String, String> entry : cfg.getPrefixed ( "item." ).entrySet () ) //$NON-NLS-1$
        {
            final String itemId = entry.getKey ();
            final String[] args = entry.getValue ().split ( ":" ); //$NON-NLS-1$
            logger.info ( "Adding - itemId: {}, arguments: {}", itemId, args ); //$NON-NLS-1$
            defs.add ( convert ( itemId, args ) );
        }

        setBlockConfiguration ( defs );
    }

    private SourceDefinition convert ( final String itemId, final String[] args )
    {
        final int offset = Integer.parseInt ( args[0] );
        final SourceType type;

        switch ( args[1].toUpperCase () )
        {
            case "DOUBLE": //$NON-NLS-1$
                type = new DoubleType ( getFactor ( args ) );
                break;
            case "INT16": //$NON-NLS-1$
            case "SHORT": //$NON-NLS-1$
                type = new ShortIntegerType ( getFactor ( args ) );
                break;
            case "UINT16": //$NON-NLS-1$
            case "WORD": //$NON-NLS-1$
                type = new UnsignedShortIntegerType ( getFactor ( args ) );
                break;
            case "INT32": //$NON-NLS-1$
                type = new IntegerType ( getFactor ( args ) );
                break;
            case "UINT32": //$NON-NLS-1$
                type = new UnsignedIntegerType ( getFactor ( args ) );
                break;
            default:
                throw new IllegalArgumentException ( String.format ( "Type '%s' is unknown.", args[1] ) ); //$NON-NLS-1$
        }

        // offset is stored in words, SourceDefinition uses bytes
        return new SourceDefinition ( itemId, offset * 2, type );
    }

    private static Double getFactor ( final String[] args )
    {
        if ( args.length > 2 )
        {
            return Double.parseDouble ( args[2] );
        }
        return null;
    }

}
