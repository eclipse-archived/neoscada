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
package org.eclipse.scada.configuration.component.tools.handler;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.ReplaceCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.scada.configuration.component.ComponentFactory;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.ExternalValue;
import org.eclipse.scada.configuration.component.SingleValue;
import org.eclipse.scada.configuration.component.tools.utils.CompoundManager;
import org.eclipse.scada.ui.databinding.AbstractSelectionHandler;
import org.eclipse.scada.ui.utils.SelectionHelper;

public class ConvertToExternalHandler extends AbstractSelectionHandler
{
    @Override
    public Object execute ( final ExecutionEvent event ) throws ExecutionException
    {
        final CompoundManager manager = new CompoundManager ();

        for ( final SingleValue v : SelectionHelper.iterable ( getSelection (), SingleValue.class ) )
        {
            replace ( manager, v );
        }

        manager.executeAll ();

        return true;
    }

    private void replace ( final CompoundManager manager, final SingleValue v )
    {
        if ( v instanceof ExternalValue )
        {
            return;
        }

        final EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor ( v );

        final Command command = ReplaceCommand.create ( domain, v.eContainer (), v.eContainmentFeature (), v, Collections.singletonList ( convert ( v ) ) );
        manager.append ( domain, command );
    }

    @SuppressWarnings ( "unchecked" )
    private EObject convert ( final SingleValue v )
    {
        final ExternalValue result = ComponentFactory.eINSTANCE.createExternalValue ();

        for ( final EStructuralFeature sf : ComponentPackage.Literals.SINGLE_VALUE.getEAllStructuralFeatures () )
        {
            final Object value = v.eGet ( sf, true );

            Object nv = value;

            if ( sf instanceof EReference )
            {
                if ( ( (EReference)sf ).isContainment () )
                {
                    if ( sf.isMany () )
                    {
                        nv = EcoreUtil.copyAll ( (Collection<EObject>)value );
                    }
                    else
                    {
                        nv = EcoreUtil.copy ( (EObject)value );
                    }
                }
            }

            result.eSet ( sf, nv );
        }

        return result;
    }
}
