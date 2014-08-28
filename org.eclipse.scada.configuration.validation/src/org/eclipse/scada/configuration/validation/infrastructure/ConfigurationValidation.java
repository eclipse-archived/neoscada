/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.validation.infrastructure;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.eclipse.scada.configuration.infrastructure.ApplicationConfiguration;
import org.eclipse.scada.configuration.infrastructure.OracleVMSettings;
import org.eclipse.scada.configuration.infrastructure.WebAdminConsole;
import org.eclipse.scada.configuration.infrastructure.World;
import org.eclipse.scada.configuration.lib.ExclusiveGroups;

public class ConfigurationValidation extends AbstractModelConstraint
{

    @Override
    public IStatus validate ( final IValidationContext ctx )
    {
        final Collection<IStatus> problems = new LinkedList<> ();

        if ( ctx.getTarget () instanceof ApplicationConfiguration )
        {
            problems.addAll ( validateExclusiveGroup ( ctx, ( (ApplicationConfiguration)ctx.getTarget () ).getConfigurations () ) );
            problems.addAll ( validateExclusiveGroup ( ctx, ( (ApplicationConfiguration)ctx.getTarget () ).getModules () ) );
        }
        else if ( ctx.getTarget () instanceof World )
        {
            problems.addAll ( validateExclusiveGroup ( ctx, ( (World)ctx.getTarget () ).getApplicationConfigurations () ) );
        }
        else if ( ctx.getTarget () instanceof WebAdminConsole )
        {
            validateWebAdminConsole ( ctx, (WebAdminConsole)ctx.getTarget (), problems );
        }
        else if ( ctx.getTarget () instanceof OracleVMSettings )
        {
            validateOracleVmSettings ( ctx, (OracleVMSettings)ctx.getTarget (), problems );
        }

        if ( problems.isEmpty () )
        {
            return ctx.createSuccessStatus ();
        }
        else
        {
            return ConstraintStatus.createMultiStatus ( ctx, problems );
        }
    }

    private static final Pattern MEM_PATTERN = Pattern.compile ( "([0-9]+)([mk]?)" );

    private void validateOracleVmSettings ( final IValidationContext ctx, final OracleVMSettings target, final Collection<IStatus> problems )
    {
        validateMemoryString ( ctx, problems, target, target.getInitialHeapSize (), "Initial heap size" );
        validateMemoryString ( ctx, problems, target, target.getMaximumHeapSize (), "Maximum heap size" );
    }

    private void validateMemoryString ( final IValidationContext ctx, final Collection<IStatus> problems, final OracleVMSettings target, final String memoryValue, final String string )
    {
        if ( memoryValue == null || memoryValue.isEmpty () )
        {
            return;
        }

        final Matcher m = MEM_PATTERN.matcher ( memoryValue );
        if ( !m.matches () )
        {
            problems.add ( ConstraintStatus.createStatus ( ctx, target, null, "{0} must have the format '<size>m', '<size>k' or '<size>'", string ) );
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
            problems.add ( ConstraintStatus.createStatus ( ctx, target, null, "{0} must be greater than zero", string ) );
        }
    }

    private void validateWebAdminConsole ( final IValidationContext ctx, final WebAdminConsole target, final Collection<IStatus> problems )
    {
        if ( target.getHttpService () != null )
        {
            if ( target.eContainer () != target.getHttpService ().eContainer () )
            {
                problems.add ( ConstraintStatus.createStatus ( ctx, target, null, "HTTP service must be contained in the same application configuration instance" ) );
            }
        }
    }

    protected List<IStatus> validateExclusiveGroup ( final IValidationContext ctx, final EList<? extends EObject> objects )
    {
        final Map<String, Set<EObject>> violations = ExclusiveGroups.validate ( objects );

        final List<IStatus> result = new LinkedList<> ();

        for ( final Map.Entry<String, Set<EObject>> entry : violations.entrySet () )
        {
            result.add ( ConstraintStatus.createStatus ( ctx, entry.getValue (), "Object belongs to an exclusive group ({0}), but actually found multiple instances for this group.", entry.getKey () ) );
        }

        return result;
    }
}
