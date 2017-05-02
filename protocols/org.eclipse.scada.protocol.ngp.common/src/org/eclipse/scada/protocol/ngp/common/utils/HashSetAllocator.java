/*******************************************************************************
 * Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.protocol.ngp.common.utils;

import java.util.HashSet;
import java.util.Set;

public class HashSetAllocator<T> implements CollectionAllocator<T, Set<T>>
{
    @Override
    public Set<T> allocate ( final int items )
    {
        return new HashSet<T> ( items );
    }
}