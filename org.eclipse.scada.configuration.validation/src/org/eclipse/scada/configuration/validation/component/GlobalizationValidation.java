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
package org.eclipse.scada.configuration.validation.component;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.eclipse.scada.configuration.component.DataComponent;
import org.eclipse.scada.configuration.component.GlobalizeComponent;
import org.eclipse.scada.configuration.infrastructure.MasterImport;

public class GlobalizationValidation extends AbstractModelConstraint
{

    @Override
    public IStatus validate ( final IValidationContext ctx )
    {
        if ( ! ( ctx.getTarget () instanceof GlobalizeComponent ) )
        {
            return ctx.createSuccessStatus ();
        }

        final GlobalizeComponent glob = (GlobalizeComponent)ctx.getTarget ();

        final List<IStatus> result = new LinkedList<> ();

        validate ( glob, ctx, result );

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

    private void validate ( final GlobalizeComponent glob, final IValidationContext ctx, final List<IStatus> result )
    {
        if ( glob.getComponents ().contains ( glob ) )
        {
            result.add ( ConstraintStatus.createStatus ( ctx, Arrays.asList ( glob ), IStatus.ERROR, 1, "The globalization component import itself. This is not allowed." ) );
        }

        final MasterImport sourceMaster = glob.getSourceMaster ();
        if ( sourceMaster != null )
        {
            final List<DataComponent> illegal = new LinkedList<> ();
            for ( final DataComponent dc : glob.getComponents () )
            {
                if ( !dc.getMasterOn ().contains ( sourceMaster.getImportedMaster () ) )
                {
                    illegal.add ( dc );
                }
            }

            if ( !illegal.isEmpty () )
            {
                result.add ( ConstraintStatus.createStatus ( ctx, illegal, IStatus.ERROR, 1, "The globalization component imports components through MasterImport {0} but some referenced components do not run there.", sourceMaster ) );
            }
        }
    }

}
