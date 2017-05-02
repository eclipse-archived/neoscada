/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ca.ui.jobs;

import java.util.Map;
import java.util.Set;

import org.eclipse.scada.ca.data.DiffEntry;
import org.eclipse.scada.ca.data.Operation;

public class UpdateJob extends DiffJob
{
    public UpdateJob ( final String connectionUri, final String factoryId, final String configurationId, final Map<String, String> addedOrUpdated, final Set<String> removed )
    {
        super ( String.format ( "Updating: %s/%s", factoryId, configurationId ), connectionUri, new DiffEntry ( factoryId, configurationId, Operation.UPDATE_SET, null, addedOrUpdated, removed ) );
    }
}