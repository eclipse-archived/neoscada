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

import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.scada.configuration.lib.ExclusiveGroups;
import org.eclipse.scada.utils.ecore.validation.Severity;
import org.eclipse.scada.utils.ecore.validation.ValidationContext;
import org.eclipse.scada.utils.ecore.validation.Validator;

public class ExclusiveGroupValidator implements Validator, IExecutableExtension
{

    private String featureName;

    public ExclusiveGroupValidator ()
    {
    }

    @Override
    public void validate ( final ValidationContext context )
    {
        final Object o = context.getTarget ();
        if ( ! ( o instanceof EObject ) )
        {
            return;
        }

        final EObject eo = (EObject)o;
        final EStructuralFeature f = eo.eClass ().getEStructuralFeature ( this.featureName );
        if ( f == null )
        {
            return;
        }

    }

    protected void validateExclusiveGroup ( final ValidationContext context, final EList<? extends EObject> objects )
    {
        final Map<String, Set<EObject>> violations = ExclusiveGroups.validate ( objects );

        for ( final Map.Entry<String, Set<EObject>> entry : violations.entrySet () )
        {
            context.add ( Severity.ERROR, new Object[] { entry.getValue () }, "Object belongs to an exclusive group ({0}), but actually found multiple instances for this group.", entry.getKey () );
        }
    }

    @Override
    public void setInitializationData ( final IConfigurationElement config, final String propertyName, final Object data ) throws CoreException
    {
        if ( data instanceof String )
        {
            this.featureName = (String)data;
        }
        else if ( data instanceof Map<?, ?> )
        {
            final Object o = ( (Map<?, ?>)data ).get ( "feature" );
            if ( o instanceof String )
            {
                this.featureName = (String)o;
            }
        }
    }

}
