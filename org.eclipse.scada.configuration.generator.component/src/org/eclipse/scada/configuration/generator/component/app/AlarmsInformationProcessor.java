/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.generator.component.app;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.scada.configuration.component.ComponentWorld;
import org.eclipse.scada.configuration.generator.GeneratorContext.MasterContext;
import org.eclipse.scada.configuration.infrastructure.lib.WorldGenerator;
import org.eclipse.scada.configuration.lib.Items;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;
import org.eclipse.scada.configuration.world.osgi.WeakReferenceDataSourceItem;

public class AlarmsInformationProcessor extends MasterApplicationProcessor
{
    public AlarmsInformationProcessor ()
    {
    }

    public AlarmsInformationProcessor ( final ComponentWorld system, final WorldGenerator worldGenerator )
    {
        super ( system, worldGenerator );
    }

    @Override
    protected void processContext ( final MasterContext masterContext, final IProgressMonitor monitor ) throws Exception
    {
        // FIXME: this must be set from external

        if ( masterContext.getImplementation ().getAeServerInformationPrefix () == null || masterContext.getImplementation ().getAeServerInformationPrefix ().isEmpty () )
        {
            return;
        }

        createInternalItem ( masterContext, "ae.server.info.ALERT_ACTIVE", "Alert active" );
        createInternalItem ( masterContext, "ae.server.info.ALERT_DISABLED", "Alert disabled" );
        createInternalItem ( masterContext, "ae.server.info.OK", "Summarized state OK" );
        createInternalItem ( masterContext, "ae.server.info.NOT_OK", "Summarized state NOT_OK_AKN" );
        createInternalItem ( masterContext, "ae.server.info.UNSAFE", "Summarized state UNSAFE" );
        createInternalItem ( masterContext, "ae.server.info.INACTIVE", "Summarized state INACTIVE" );
        createInternalItem ( masterContext, "ae.server.info.INIT", "Summarized state INIT" );
        createInternalItem ( masterContext, "ae.server.info.NOT_OK_AKN", "Summarized state NOT_OK_AKN" );
        createInternalItem ( masterContext, "ae.server.info.NOT_OK_NOT_AKN", "Summarized state NOT_OK_NOT_AKN" );
        createInternalItem ( masterContext, "ae.server.info.NOT_AKN", "Summarized state NOT_OK_AKN" );
    }

    private void createInternalItem ( final MasterContext masterContext, final String dataSourceId, final String description )
    {
        final WeakReferenceDataSourceItem item = OsgiFactory.eINSTANCE.createWeakReferenceDataSourceItem ();

        item.setDataSourceId ( dataSourceId );
        item.setName ( dataSourceId );

        item.setInformation ( OsgiFactory.eINSTANCE.createItemInformation () );
        item.getInformation ().setDescription ( description );
        item.getInformation ().setSystem ( "SCADA" );

        Items.addItem ( masterContext.getImplementation (), item );
    }

}
