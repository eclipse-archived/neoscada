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

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.ibm.icu.text.MessageFormat;

public class ValidationContextImpl implements ValidationContext
{
    private final Object target;

    private final List<Diagnostic> result = new LinkedList<> ();

    private final String source;

    public ValidationContextImpl ( final String source, final Object target )
    {
        this.source = source;
        this.target = target;
    }

    @Override
    public Object getTarget ()
    {
        return this.target;
    }

    public boolean apply ( final DiagnosticChain diagnostics )
    {
        for ( final Diagnostic d : this.result )
        {
            diagnostics.add ( d );
        }
        return this.result.isEmpty ();
    }

    protected Object[] makeTargetData ( final EStructuralFeature feature )
    {
        if ( feature == null )
        {
            return new Object[] { this.target };
        }
        else
        {
            return new Object[] { this.target, feature };
        }
    }

    @Override
    public void add ( final Severity severity, Object[] data, final String message, final Object... arguments )
    {
        if ( data == null )
        {
            data = new Object[] { this.target };
        }

        String formattedMessage;

        if ( arguments == null || arguments.length <= 0 )
        {
            formattedMessage = message;
        }
        else
        {
            formattedMessage = MessageFormat.format ( message, arguments );
        }

        final int severityCode = severity == null ? Diagnostic.OK : severity.getSeverityCode ();
        this.result.add ( new BasicDiagnostic ( severityCode, this.source, 0, formattedMessage, data ) );
    }

    @Override
    public void add ( final EStructuralFeature feature, final Severity severity, final String message, final Object... arguments )
    {
        add ( severity, makeTargetData ( feature ), message, arguments );
    }

    @Override
    public void add ( final String message, final Object... arguments )
    {
        add ( (EStructuralFeature)null, Severity.ERROR, null, message, arguments );
    }

    @Override
    public void add ( final EStructuralFeature feature, final String message, final Object... arguments )
    {
        add ( feature, Severity.ERROR, message, arguments );
    }
}