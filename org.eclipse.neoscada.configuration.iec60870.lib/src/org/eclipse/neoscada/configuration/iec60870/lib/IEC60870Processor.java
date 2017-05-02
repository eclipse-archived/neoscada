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
package org.eclipse.neoscada.configuration.iec60870.lib;

import org.eclipse.neoscada.configuration.iec60870.AddressInformation;
import org.eclipse.neoscada.configuration.iec60870.DataType;
import org.eclipse.neoscada.configuration.iec60870.ExporterItemInterceptor;
import org.eclipse.scada.configuration.generator.GeneratorContext.MasterContext;
import org.eclipse.scada.configuration.world.osgi.Item;

public class IEC60870Processor
{
    private final ExporterInterceptorHandler handler;

    private final ExporterItemInterceptor interceptor;

    private final MasterContext masterContext;

    private final Item item;

    public IEC60870Processor ( final ExporterInterceptorHandler handler, final ExporterItemInterceptor interceptor, final MasterContext masterContext, final Item item )
    {
        this.handler = handler;
        this.interceptor = interceptor;
        this.masterContext = masterContext;
        this.item = item;
    }

    public void doExportFloat ( final String address )
    {
        doExportFloat ( AddressInformation.valueOf ( address ) );
    }

    public void doExportFloat ( final AddressInformation address )
    {
        this.handler.processExport ( this.interceptor, this.masterContext, this.item, address, DataType.FLOAT );
    }

    public void doExportBoolean ( final String address )
    {
        doExportBoolean ( AddressInformation.valueOf ( address ) );
    }

    public void doExportBoolean ( final AddressInformation address )
    {
        this.handler.processExport ( this.interceptor, this.masterContext, this.item, address, DataType.BOOLEAN );
    }
}
