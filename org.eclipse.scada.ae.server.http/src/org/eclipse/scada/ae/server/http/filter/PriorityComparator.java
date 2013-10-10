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
package org.eclipse.scada.ae.server.http.filter;

import java.util.Comparator;

public class PriorityComparator implements Comparator<FilterEntry>
{
    @Override
    public int compare ( final FilterEntry o1, final FilterEntry o2 )
    {
        final long thisVal = o1.getPriority ();
        final long anotherVal = o2.getPriority ();
        return thisVal < anotherVal ? -1 : thisVal == anotherVal ? 0 : 1;
    }
}
