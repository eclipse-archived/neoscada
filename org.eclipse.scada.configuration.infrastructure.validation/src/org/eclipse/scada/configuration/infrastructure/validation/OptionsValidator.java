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
package org.eclipse.scada.configuration.infrastructure.validation;

import org.eclipse.scada.configuration.infrastructure.Options;
import org.eclipse.scada.ide.validation.TypedValidator;
import org.eclipse.scada.ide.validation.ValidationContext;

public class OptionsValidator extends TypedValidator<Options>
{
    public OptionsValidator ()
    {
        super ( Options.class );
    }

    @Override
    protected void validate ( final Options target, final ValidationContext context )
    {
        if ( target.getBaseAeNgpPort () == target.getBaseCaNgpPort () )
        {
            context.add ( "AE base port must be different than the CA base port" );
        }
        if ( target.getBaseAeNgpPort () == target.getBaseHdNgpPort () )
        {
            context.add ( "AE base port must be different than the HD base port" );
        }
        if ( target.getBaseAeNgpPort () == target.getBaseDaNgpPort () )
        {
            context.add ( "AE base port must be different than the DA base port" );
        }
        if ( target.getBaseDaNgpPort () == target.getBaseCaNgpPort () )
        {
            context.add ( "DA base port must be different than the CA base port" );
        }
        if ( target.getBaseDaNgpPort () == target.getBaseHdNgpPort () )
        {
            context.add ( "DA base port must be different than the HD base port" );
        }
        if ( target.getBaseHdNgpPort () == target.getBaseCaNgpPort () )
        {
            context.add ( "HD base port must be different than the CA base port" );
        }
    }
}
