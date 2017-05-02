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
package org.eclipse.scada.configuration.lib;

import java.util.Arrays;

import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;

public class AttributesSummary implements ItemCustomizer
{

    private final int level;

    public AttributesSummary ( final int level )
    {
        this.level = level;
    }

    @Override
    public void customize ( final Item item )
    {
        final int phase1 = this.level * 2 - 1;
        final int phase2 = this.level * 2;

        // add the first summary which summarizes up all entry "error" attributes
        final org.eclipse.scada.configuration.world.osgi.AttributesSummary feature1 = OsgiFactory.eINSTANCE.createAttributesSummary ();
        feature1.setItem ( item );
        feature1.setName ( "sum.phase1" );
        feature1.getAttributes ().add ( "error" );
        feature1.setOutputPrefix ( String.format ( "phase%d", phase1 ) );
        DefaultFeatures.registerFeature ( item, feature1 );

        /*
         * Between phase1 and phase2 the master handlers must be processed. This includes the manual override which would override an error attribute
         * summarized in phase1. Still if the output of the master handlers contains an "error" it will again be summarized in phase2.
         */

        // add the second summary which summarizes up all attributes after the master handlers have been processed
        final org.eclipse.scada.configuration.world.osgi.AttributesSummary feature2 = OsgiFactory.eINSTANCE.createAttributesSummary ();
        feature2.setItem ( item );
        feature2.setName ( "sum.phase2" );
        feature2.getAttributes ().addAll ( Arrays.asList ( "manual", "error", "alarm", "warning", "info", "error.ackRequired", "alarm.ackRequired", "warning.ackRequired", "blocked" ) );
        feature2.setOutputPrefix ( String.format ( "phase%d", phase2 ) );
        DefaultFeatures.registerFeature ( item, feature2 );
    }
}
