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

/**
 * Return an attribute as the name
 * @author Jens Reimann
 *
 */
public class AttributeNameProvider implements NameProvider
{
    private String attribute = null;

    public AttributeNameProvider ( final String attribute )
    {
        this.attribute = attribute;
    }

    public String getName ( final ItemDescriptor descriptor )
    {
        if ( this.attribute == null )
        {
            return null;
        }

        return descriptor.getAttributes ().get ( this.attribute ).asString ( null );
    }

}
