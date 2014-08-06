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
package org.eclipse.scada.configuration.setup.common;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.eclipse.scada.configuration.lib.Properties;
import org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor;

public class PostgresValidator extends Postgres
{
    private final OperatingSystemDescriptor os;

    private final IValidationContext ctx;

    public PostgresValidator ( final PostgresSetupModule postgres, final OperatingSystemDescriptor os, final IValidationContext ctx )
    {
        super ( postgres );
        this.os = os;
        this.ctx = ctx;
    }

    protected IStatus createFailure ( final String message, final Object... arguments )
    {
        return ConstraintStatus.createStatus ( this.ctx, (EObject)null, null, message, arguments );
    }

    public IStatus validate ()
    {
        final Collection<IStatus> result = new LinkedList<IStatus> ();

        performValidation ( result );

        if ( result.isEmpty () )
        {
            return Status.OK_STATUS;
        }
        else
        {
            return ConstraintStatus.createMultiStatus ( this.ctx, result );
        }
    }

    protected void performValidation ( final Collection<IStatus> result )
    {
        final String version = Properties.get ( this.os.getProperties (), POSTGRES_VERSION_KEY, null );
        if ( version == null )
        {
            result.add ( createFailure ( "Operating system does not provide PostgreSQL" ) );
        }
        else if ( !POSTGRES_VERSION_VALUE.equals ( version ) )
        {
            result.add ( createFailure ( "Requires '{0}' = {1} but found ({2})", POSTGRES_VERSION_KEY, POSTGRES_VERSION_VALUE, version ) );
        }

        checkResource ( this.postgres.getHostBasedAccessFile (), result );
        checkResource ( this.postgres.getConfigurationFile (), result );

        final Map<String, String> props = Properties.makeAttributes ( this.os.getProperties () );
        getConfigurationFile ( props );
        getHostBasedAccessFile ( props );
    }

    private void checkResource ( final String uriString, final Collection<IStatus> result )
    {
        if ( uriString == null || uriString.isEmpty () )
        {
            return;
        }

        try
        {
            openResource ( uriString ).close (); // don't read, just test
        }
        catch ( final Exception e )
        {
            result.add ( createFailure ( "Unable to load resource: {0}", uriString ) );
        }
    }

}
