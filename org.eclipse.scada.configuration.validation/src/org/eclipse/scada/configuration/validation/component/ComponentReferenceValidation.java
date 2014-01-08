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
package org.eclipse.scada.configuration.validation.component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.eclipse.scada.configuration.component.Component;
import org.eclipse.scada.configuration.component.ComponentReferenceInputDefinition;
import org.eclipse.scada.configuration.component.DataComponent;
import org.eclipse.scada.configuration.component.lib.create.CaptureItemCreator;
import org.eclipse.scada.configuration.component.lib.create.CaptureItemCreator.ItemCreation;
import org.eclipse.scada.configuration.component.lib.create.ItemSource;
import org.eclipse.scada.configuration.component.lib.create.ItemSources;
import org.eclipse.scada.configuration.infrastructure.MasterServer;

public class ComponentReferenceValidation extends AbstractModelConstraint
{

    @Override
    public IStatus validate ( final IValidationContext ctx )
    {
        if ( ! ( ctx.getTarget () instanceof ComponentReferenceInputDefinition ) )
        {
            return ctx.createSuccessStatus ();
        }

        final ComponentReferenceInputDefinition ref = (ComponentReferenceInputDefinition)ctx.getTarget ();

        final List<IStatus> result = new LinkedList<> ();

        validate ( ref, ctx, result );

        if ( result.isEmpty () )
        {
            return ctx.createSuccessStatus ();
        }
        else if ( result.size () == 1 )
        {
            return result.get ( 0 );
        }
        else
        {
            return ConstraintStatus.createMultiStatus ( ctx, result );
        }
    }

    private void validate ( final ComponentReferenceInputDefinition ref, final IValidationContext ctx, final List<IStatus> result )
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
        if ( !dc.getMasterOn ().containsAll ( ( (DataComponent)ref.getComponent () ).getMasterOn () ) )
        {
            result.add ( ConstraintStatus.createStatus ( ctx, Arrays.asList ( ref ), IStatus.ERROR, 1, "The component reference references to a component that is not available on all master servers that the containing component is." ) );
        }

        for ( final MasterServer m : dc.getMasterOn () )
        {
            validateRef ( m, ref, ctx, result );
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

    private void validateRef ( final MasterServer m, final ComponentReferenceInputDefinition ref, final IValidationContext ctx, final List<IStatus> result )
    {
        final Map<List<String>, ItemCreation> itemResult = createItems ( ref.getComponent () );

        final ItemCreation refItem = itemResult.get ( ref.getLocalTag () );
        if ( refItem == null )
        {
            result.add ( ConstraintStatus.createStatus ( ctx, Arrays.asList ( ref ), IStatus.ERROR, 2, "The reference points to an invalid item (LocalTags: {0}) on the component: {1}", ref.getLocalTag (), ref.getComponent () ) );
        }
    }
}
