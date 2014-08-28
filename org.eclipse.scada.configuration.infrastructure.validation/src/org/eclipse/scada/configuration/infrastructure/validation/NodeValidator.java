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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.infrastructure.Node;
import org.eclipse.scada.ide.validation.TypedValidator;
import org.eclipse.scada.ide.validation.ValidationContext;

public class NodeValidator extends TypedValidator<Node>
{

    public NodeValidator ()
    {
        super ( Node.class );
    }

    private static final Pattern HOSTNAME_PATTERN = Pattern.compile ( "[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.?" );

    @Override
    protected void validate ( final Node target, final ValidationContext context )
    {
        if ( target.getHostName () == null )
        {
            return;
        }

        final Matcher m = HOSTNAME_PATTERN.matcher ( target.getHostName () );
        if ( !m.matches () )
        {
            context.add ( InfrastructurePackage.Literals.NODE__HOST_NAME, "Hostname \"{0}\" does not match pattern \"{1}\"", target.getHostName (), HOSTNAME_PATTERN.pattern () );
        }
    }
}
