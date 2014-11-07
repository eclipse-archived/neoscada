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
package org.eclipse.scada.utils.ecore.validation;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;

public class ExtensibleValidator implements EValidator
{
    private final EValidator[] otherValidators;

    public ExtensibleValidator ( final EValidator[] otherValidators )
    {
        this.otherValidators = otherValidators;
    }

    @Override
    public boolean validate ( final EObject eObject, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        boolean result = true;
        for ( final EValidator v : this.otherValidators )
        {
            if ( !v.validate ( eObject, diagnostics, context ) )
            {
                result = false;
            }
        }

        ValidationPlugin.runValidation ( eObject, diagnostics, context );

        return result;
    }

    @Override
    public boolean validate ( final EClass eClass, final EObject eObject, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        boolean result = true;
        for ( final EValidator v : this.otherValidators )
        {
            if ( !v.validate ( eClass, eObject, diagnostics, context ) )
            {
                result = false;
            }
        }

        ValidationPlugin.runValidation ( eObject, diagnostics, context );

        return result;
    }

    @Override
    public boolean validate ( final EDataType eDataType, final Object value, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        boolean result = true;
        for ( final EValidator v : this.otherValidators )
        {
            if ( !v.validate ( eDataType, value, diagnostics, context ) )
            {
                result = false;
            }
        }
        return result;
    }
}
