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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.eclipse.scada.configuration.infrastructure.ApplicationConfiguration;
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

        if ( problems.isEmpty () )
        {
            return ctx.createSuccessStatus ();
        }
        else
        {
            return ConstraintStatus.createMultiStatus ( ctx, problems );
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
