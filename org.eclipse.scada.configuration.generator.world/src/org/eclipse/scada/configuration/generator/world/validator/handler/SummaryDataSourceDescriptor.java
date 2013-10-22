/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/

package org.eclipse.scada.configuration.generator.world.validator.handler;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.scada.configuration.generator.world.validator.DataSourceDescriptor;

public class SummaryDataSourceDescriptor extends DataSourceDescriptor
{

    private final Set<String> blacklist;

    private final boolean masterOnly;

    public SummaryDataSourceDescriptor ( final String id, final Set<String> blacklist, final boolean masterOnly )
    {
        super ( "datasource", id );
        this.blacklist = new HashSet<String> ( blacklist );
        this.masterOnly = masterOnly;
    }

    public Set<String> getBlacklist ()
    {
        return Collections.unmodifiableSet ( this.blacklist );
    }

    public boolean isMasterOnly ()
    {
        return this.masterOnly;
    }
}
