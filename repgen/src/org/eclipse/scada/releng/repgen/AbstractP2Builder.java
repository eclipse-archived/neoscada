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

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;

public class AbstractP2Builder extends AbstractBuilder
{
    public AbstractP2Builder () throws ParserConfigurationException
    {
        super ();
    }

    protected void addProperty ( final Element properties, final String key, final String value )
    {
        final Element pe = properties.getOwnerDocument ().createElement ( "property" );
        pe.setAttribute ( "name", key );
        pe.setAttribute ( "value", value );
        properties.appendChild ( pe );
        properties.setAttribute ( "size", "" + properties.getChildNodes ().getLength () );
    }

}
