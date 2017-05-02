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

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NodeIterable implements Iterable<Node>
{

    private final NodeList nodes;

    public NodeIterable ( final Node node )
    {
        this.nodes = node.getChildNodes ();
    }

    public NodeIterable ( final NodeList nodes )
    {
        this.nodes = nodes;
    }

    @Override
    public Iterator<Node> iterator ()
    {
        return new NodeIterator ( this.nodes );
    }

}
