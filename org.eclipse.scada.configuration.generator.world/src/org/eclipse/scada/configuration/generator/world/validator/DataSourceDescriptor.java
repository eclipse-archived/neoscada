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

package org.eclipse.scada.configuration.generator.world.validator;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DataSourceDescriptor extends DataSourceReference
{

    public DataSourceDescriptor ( final String type, final String id )
    {
        super ( type, id );
    }

    private final Set<DataSourceReference> references = new HashSet<DataSourceReference> ();

    public Set<DataSourceReference> getReferences ()
    {
        return Collections.unmodifiableSet ( this.references );
    }

    public void addReference ( final String type, final String reference )
    {
        this.references.add ( new DataSourceReference ( type, reference ) );
    }

}
