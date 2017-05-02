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
package org.eclipse.scada.configuration.setup.common.validation;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.scada.configuration.setup.common.CommonPackage;
import org.eclipse.scada.configuration.setup.common.Postgres;
import org.eclipse.scada.configuration.setup.common.PostgresSetupModule;
import org.eclipse.scada.utils.ecore.validation.Severity;
import org.eclipse.scada.utils.ecore.validation.TypedValidator;
import org.eclipse.scada.utils.ecore.validation.ValidationContext;

public class PostgresSetupModuleValidator extends TypedValidator<PostgresSetupModule>
{
    public PostgresSetupModuleValidator ()
    {
        super ( PostgresSetupModule.class );
    }

    private void checkResource ( final ValidationContext ctx, final PostgresSetupModule postgres, final EStructuralFeature feature, final String uriString )
    {
        if ( uriString == null || uriString.isEmpty () )
        {
            return;
        }

        try
        {
            new Postgres ( postgres ).openResource ( uriString ).close (); // don't read, just test
        }
        catch ( final Exception e )
        {
            final Object[] arguments = { uriString };
            ctx.add ( Severity.ERROR, new Object[] { postgres, feature }, "Unable to load resource: {0}", arguments );
        }
    }

    @Override
    protected void validate ( final PostgresSetupModule target, final ValidationContext ctx )
    {
        checkResource ( ctx, target, CommonPackage.Literals.POSTGRES_SETUP_MODULE__HOST_BASED_ACCESS_FILE, target.getHostBasedAccessFile () );
        checkResource ( ctx, target, CommonPackage.Literals.POSTGRES_SETUP_MODULE__CONFIGURATION_FILE, target.getConfigurationFile () );
    }
}
