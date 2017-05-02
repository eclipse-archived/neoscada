/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core.server.exporter;

import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.utils.lang.Immutable;

@Immutable
public class ExporterInformation
{
    private final ConnectionInformation connectionInformation;

    private final String description;

    public ExporterInformation ( final ConnectionInformation connectionInformation, final String description )
    {
        this.connectionInformation = connectionInformation;
        this.description = description;
    }

    public String getDescription ()
    {
        return this.description;
    }

    public ConnectionInformation getConnectionInformation ()
    {
        return this.connectionInformation;
    }

    @Override
    public String toString ()
    {
        return String.format ( "[%s, description=%s]", this.connectionInformation, this.description );
    }
}
