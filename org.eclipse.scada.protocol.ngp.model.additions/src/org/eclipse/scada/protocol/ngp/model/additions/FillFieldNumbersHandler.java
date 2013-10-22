/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.ngp.model.additions;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.scada.protocol.ngp.model.Protocol.Attribute;
import org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage;
import org.eclipse.scada.ui.databinding.AbstractSelectionHandler;
import org.eclipse.scada.ui.databinding.SelectionHelper;
import org.eclipse.ui.IEditorPart;

public class FillFieldNumbersHandler extends AbstractSelectionHandler
{

    @Override
    public Object execute ( final ExecutionEvent event ) throws ExecutionException
    {

        final IEditorPart editor = getActivePage ().getActiveEditor ();

        byte b = (byte)1;
        for ( final Attribute attribute : SelectionHelper.iterable ( getSelection (), Attribute.class ) )
        {
            EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor ( attribute );

            if ( domain == null && editor instanceof IEditingDomainProvider )
            {
                domain = ( (IEditingDomainProvider)editor ).getEditingDomain ();
            }

            SetCommand.create ( domain, attribute, ProtocolPackage.Literals.ATTRIBUTE__FIELD_NUMBER, b ).execute ();

            b++;
        }

        return null;
    }
}
