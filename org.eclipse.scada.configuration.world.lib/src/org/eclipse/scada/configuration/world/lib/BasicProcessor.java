/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world.lib;

import org.eclipse.scada.configuration.lib.Names;
import org.eclipse.scada.configuration.world.NamedDocumentable;

public class BasicProcessor
{
    private final NamedDocumentable documentable;

    public BasicProcessor ( final NamedDocumentable documentable )
    {
        this.documentable = documentable;
    }

    protected String makeName ()
    {
        return Names.makeName ( this.documentable );
    }

}
