/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.monitor.datasource.common;

import org.eclipse.scada.ae.data.Severity;

public enum ListSeverity
{
    OK ( null ),
    INFORMATION ( Severity.INFORMATION ),
    WARNING ( Severity.WARNING ),
    ALARM ( Severity.ALARM ),
    ERROR ( Severity.ERROR );

    private Severity severity;

    private ListSeverity ( final Severity severity )
    {
        this.severity = severity;
    }

    public Severity getSeverity ()
    {
        return this.severity;
    }
}