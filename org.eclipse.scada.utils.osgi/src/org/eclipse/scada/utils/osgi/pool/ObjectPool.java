/*******************************************************************************
 * Copyright (c) 2006, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.osgi.pool;

public interface ObjectPool<S>
{
    public static final String OBJECT_POOL_CLASS = "object.pool.class";

    public abstract void addListener ( final String id, final ObjectPoolListener<S> listener );

    public abstract void removeListener ( final String id, final ObjectPoolListener<S> listener );

    public abstract void addListener ( final ObjectPoolListener<S> listener );

    public abstract void removeListener ( final ObjectPoolListener<S> listener );
}