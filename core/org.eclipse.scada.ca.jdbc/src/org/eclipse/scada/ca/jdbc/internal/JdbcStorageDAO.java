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
package org.eclipse.scada.ca.jdbc.internal;

import java.util.List;
import java.util.Map;

public interface JdbcStorageDAO
{
    public Map<String, String> storeConfiguration ( final String factoryId, final String configurationId, final Map<String, String> properties, boolean fullSet );

    public void deleteConfiguration ( final String factoryId, final String configurationId );

    public List<Entry> loadFactory ( String factoryId );

    public List<String> listFactories ();

    public List<Entry> loadAll ();

    public List<Entry> purgeFactory ( String factoryId );
}
