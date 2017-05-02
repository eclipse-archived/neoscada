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
package org.eclipse.scada.da.mapper.osgi.jdbc;

import org.eclipse.scada.utils.beans.AbstractPropertyChange;

public class JdbcValueMapperState extends AbstractPropertyChange
{
    private static final String PROP_LOADING = "loading";

    private static final String PROP_ERROR = "error";

    private static final String PROP_ENTRIES = "entries";

    private boolean loading;

    private boolean error;

    private int entries;

    public boolean isLoading ()
    {
        return this.loading;
    }

    public void setLoading ( final boolean loading )
    {
        firePropertyChange ( PROP_LOADING, this.loading, this.loading = loading );
    }

    public boolean isError ()
    {
        return this.error;
    }

    public void setError ( final boolean error )
    {
        firePropertyChange ( PROP_ERROR, this.error, this.error = error );
    }

    public int getEntries ()
    {
        return this.entries;
    }

    public void setEntries ( final int entries )
    {
        firePropertyChange ( PROP_ENTRIES, this.entries, this.entries = entries );
    }
}
