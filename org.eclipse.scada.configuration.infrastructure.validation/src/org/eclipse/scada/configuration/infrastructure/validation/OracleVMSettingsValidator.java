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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.infrastructure.OracleVMSettings;
import org.eclipse.scada.ide.validation.TypedValidator;
import org.eclipse.scada.ide.validation.ValidationContext;

public class OracleVMSettingsValidator extends TypedValidator<OracleVMSettings>
{

    private static final Pattern MEM_PATTERN = Pattern.compile ( "([0-9]+)([mk]?)" );

    public OracleVMSettingsValidator ()
    {
        super ( OracleVMSettings.class );
    }

    @Override
    protected void validate ( final OracleVMSettings target, final ValidationContext context )
    {
        validateMemoryString ( context, target, target.getInitialHeapSize (), InfrastructurePackage.Literals.ORACLE_VM_SETTINGS__INITIAL_HEAP_SIZE, "Initial heap size" );
        validateMemoryString ( context, target, target.getMaximumHeapSize (), InfrastructurePackage.Literals.ORACLE_VM_SETTINGS__MAXIMUM_HEAP_SIZE, "Maximum heap size" );
    }

    private void validateMemoryString ( final ValidationContext ctx, final OracleVMSettings target, final String memoryValue, final EAttribute feature, final String string )
    {
        if ( memoryValue == null || memoryValue.isEmpty () )
        {
            return;
        }

        final Matcher m = MEM_PATTERN.matcher ( memoryValue );
        if ( !m.matches () )
        {
            ctx.add ( feature, "{0} must have the format '<size>m', '<size>k' or '<size>'", string );
            return;
        }

        long value = Long.parseLong ( m.group ( 1 ) );
        final String unit = m.group ( 2 );
        if ( "k".equals ( unit ) )
        {
            value = value * 1024;
        }
        else if ( "m".equals ( unit ) )
        {
            value = value * 1024 * 1024;
        }
        if ( value <= 0 )
        {
            ctx.add ( feature, "{0} must be greater than zero", string );
        }
    }

}
