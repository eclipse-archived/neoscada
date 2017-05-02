/*******************************************************************************
 * Copyright (c) 2015 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.component.validation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.scada.configuration.component.Component;
import org.eclipse.scada.configuration.component.ComponentReferenceInputDefinition;
import org.eclipse.scada.configuration.component.DataComponent;
import org.eclipse.scada.configuration.component.lib.create.CaptureItemCreator;
import org.eclipse.scada.configuration.component.lib.create.CaptureItemCreator.ItemCreation;
import org.eclipse.scada.configuration.component.lib.create.ItemSource;
import org.eclipse.scada.configuration.component.lib.create.ItemSources;
import org.eclipse.scada.configuration.infrastructure.MasterServer;
import org.eclipse.scada.utils.ecore.validation.TypedValidator;
import org.eclipse.scada.utils.ecore.validation.ValidationContext;

public class ComponentReferenceInputDefinitionValidator extends TypedValidator<ComponentReferenceInputDefinition>
{

    public ComponentReferenceInputDefinitionValidator ()
    {
        super ( ComponentReferenceInputDefinition.class );
    }

    @Override
    protected void validate ( final ComponentReferenceInputDefinition ref, final ValidationContext ctx )
    {
        if ( ! ( ref.eContainer () instanceof DataComponent ) )
        {
            return;
        }

        if ( ! ( ref.getComponent () instanceof DataComponent ) )
        {
            return;
        }

        final DataComponent dc = (DataComponent)ref.eContainer ();
        final DataComponent refComp = (DataComponent)ref.getComponent ();

        for ( final MasterServer m : dc.getMasterOn () )
        {
            // master server of data component we validate
            if ( !refComp.getMasterOn ().contains ( m ) )
            {
                ctx.add ( "\"{0}\" of data component \"{1}\" references to a component \"{2}\" that is not available on the master server \"'{3}\".", ref, dc, refComp, m );
            }
        }

        for ( final MasterServer m : dc.getMasterOn () )
        {
            validateRef ( m, ref, ctx );
        }
    }

    private Map<List<String>, CaptureItemCreator.ItemCreation> createItems ( final Component component )
    {
        final Map<List<String>, CaptureItemCreator.ItemCreation> result = new HashMap<> ();
        final ItemSource source = ItemSources.createItemSource ( component );
        final CaptureItemCreator creator = new CaptureItemCreator ( component, result );
        source.createItems ( creator );
        return result;
    }

    private void validateRef ( final MasterServer m, final ComponentReferenceInputDefinition ref, final ValidationContext ctx )
    {
        final Map<List<String>, ItemCreation> itemResult = createItems ( ref.getComponent () );

        final ItemCreation refItem = itemResult.get ( ref.getLocalTag () );
        if ( refItem == null )
        {
            ctx.add ( "The reference points to an invalid item (LocalTags: {0}) on the component: {1}", ref.getLocalTag (), ref.getComponent () );
        }
    }

}
