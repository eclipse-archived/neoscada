/*******************************************************************************
 * Copyright (c) 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.vi.ui.viewer.ext.item;

import java.util.Hashtable;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;

public abstract class AbstractItemExtension implements IExecutableExtension
{

    protected String connectionId;

    protected String itemId;

    @Override
    public void setInitializationData ( final IConfigurationElement config, final String propertyName, final Object data ) throws CoreException
    {

        if ( data instanceof String )
        {
            final String str = (String)data;
            if ( str.contains ( "#" ) )
            {
                final String[] tok = str.split ( "\\#", 2 );
                this.connectionId = tok[0];
                this.itemId = tok[1];
            }
        }
        if ( data instanceof Hashtable<?, ?> )
        {
            final Hashtable<?, ?> props = (Hashtable<?, ?>)data;

            this.connectionId = "" + props.get ( "connectionId" );
            this.itemId = "" + props.get ( "itemId" );
        }

    }
}
