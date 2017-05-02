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

import java.util.LinkedList;
import java.util.List;

import org.eclipse.scada.configuration.component.DataComponent;
import org.eclipse.scada.configuration.component.GlobalizeComponent;
import org.eclipse.scada.configuration.infrastructure.MasterImport;
import org.eclipse.scada.utils.ecore.validation.Severity;
import org.eclipse.scada.utils.ecore.validation.TypedValidator;
import org.eclipse.scada.utils.ecore.validation.ValidationContext;

public class GlobalizeComponentValidator extends TypedValidator<GlobalizeComponent>
{

    public GlobalizeComponentValidator ()
    {
        super ( GlobalizeComponent.class );
    }

    @Override
    protected void validate ( final GlobalizeComponent glob, final ValidationContext context )
    {
        if ( glob.getComponents ().contains ( glob ) )
        {
            context.add ( "The globalization component imports itself. This is not allowed." );
            return;
        }

        final MasterImport sourceMaster = glob.getSourceMaster ();
        if ( sourceMaster != null )
        {
            // check components

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
                context.add ( Severity.ERROR, illegal.toArray (), "The globalization component imports components through MasterImport {0} but some referenced components do not run there.", sourceMaster );
            }
        }
    }

}
