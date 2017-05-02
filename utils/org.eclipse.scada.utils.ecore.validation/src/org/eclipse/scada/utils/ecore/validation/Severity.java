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

import org.eclipse.emf.common.util.Diagnostic;

public enum Severity
{
    WARNING ( Diagnostic.WARNING ),
    ERROR ( Diagnostic.ERROR );

    private final int severityCode;

    private Severity ( final int severityCode )
    {
        this.severityCode = severityCode;
    }

    public int getSeverityCode ()
    {
        return this.severityCode;
    }
}