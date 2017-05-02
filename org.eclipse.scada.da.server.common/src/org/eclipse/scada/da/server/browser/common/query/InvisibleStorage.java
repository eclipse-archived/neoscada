/*******************************************************************************
 * Copyright (c) 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.browser.common.query;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class InvisibleStorage implements SubscribeableStorage
{
    private final Set<ItemDescriptor> items = new HashSet<ItemDescriptor> ();

    private final Collection<ItemStorage> childs = new LinkedList<ItemStorage> ();

    public void added ( final ItemDescriptor descriptor )
    {
        synchronized ( this )
        {
            if ( this.items.contains ( descriptor ) )
            {
                return;
            }

            this.items.add ( descriptor );
            notifyAdd ( descriptor );
        }
    }

    public void removed ( final ItemDescriptor descriptor )
    {
        synchronized ( this )
        {
            if ( !this.items.remove ( descriptor ) )
            {
                return;
            }

            notifyRemove ( descriptor );
        }
    }

    public void addChild ( final ItemStorage child )
    {
        synchronized ( this )
        {
            this.childs.add ( child );

            // now push all possible descriptors
            for ( final ItemDescriptor desc : this.items )
            {
                child.added ( desc );
            }
        }
    }

    public void removeChild ( final ItemStorage child )
    {
        synchronized ( this )
        {
            this.childs.remove ( child );
        }
    }

    private void notifyAdd ( final ItemDescriptor desc )
    {
        // notify childs
        for ( final ItemStorage child : this.childs )
        {
            child.added ( desc );
        }
    }

    private void notifyRemove ( final ItemDescriptor desc )
    {
        // notify childs
        for ( final ItemStorage child : this.childs )
        {
            child.removed ( desc );
        }
    }

    public void clear ()
    {
        synchronized ( this )
        {
            for ( final ItemDescriptor desc : this.items )
            {
                notifyRemove ( desc );
            }
            this.items.clear ();
        }
    }

}
