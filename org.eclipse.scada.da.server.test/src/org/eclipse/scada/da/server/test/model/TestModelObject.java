/*******************************************************************************
 * Copyright (c) 2009, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.test.model;

public class TestModelObject extends AbstractPropertyChange
{
    private static final String PROP_LONG_VALUE = "longValue";

    private long longValue;

    public long getLongValue ()
    {
        return this.longValue;
    }

    public void setLongValue ( final long longValue )
    {
        final long oldLongValue = this.longValue;
        this.longValue = longValue;

        firePropertyChange ( PROP_LONG_VALUE, oldLongValue, longValue );
    }

}
