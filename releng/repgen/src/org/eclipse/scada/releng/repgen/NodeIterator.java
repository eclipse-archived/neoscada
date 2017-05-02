/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.releng.repgen;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NodeIterator implements Iterator<Node>
{
    private final NodeList nodes;

    private int index;

    private final int length;

    public NodeIterator ( final NodeList nodes )
    {
        this.nodes = nodes;
        this.length = this.nodes.getLength ();
    }

    @Override
    public boolean hasNext ()
    {
        return this.index < this.length;
    }

    @Override
    public Node next ()
    {
        if ( !hasNext () )
        {
            throw new NoSuchElementException ();
        }
        return this.nodes.item ( this.index++ );
    }

    @Override
    public void remove ()
    {
        throw new UnsupportedOperationException ();
    }

}
