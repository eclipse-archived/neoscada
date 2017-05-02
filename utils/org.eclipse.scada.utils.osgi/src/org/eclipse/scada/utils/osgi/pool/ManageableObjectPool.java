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

import java.util.Dictionary;

public interface ManageableObjectPool<S> extends ObjectPool<S>
{
    public void addService ( final String id, final S service, Dictionary<?, ?> properties );

    public void modifyService ( final String id, final S service, final Dictionary<?, ?> properties );

    public void removeService ( final String id, final S service );
}