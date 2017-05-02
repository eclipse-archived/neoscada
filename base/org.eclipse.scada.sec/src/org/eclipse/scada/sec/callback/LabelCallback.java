/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.sec.callback;

import java.util.Map;

/**
 * @since 1.1
 */
public abstract class LabelCallback extends AbstractCallback
{

    private String label;

    public LabelCallback ()
    {
    }

    public LabelCallback ( final String label, final int order )
    {
        super ( order );
        this.label = label;
    }

    public String getLabel ()
    {
        return this.label;
    }

    @Override
    protected void injectRequestAttributes ( final Map<String, String> request )
    {
        super.injectRequestAttributes ( request );
        request.put ( "label", this.label );
    }

    @Override
    public void parseRequestAttributes ( final Map<String, String> attributes )
    {
        super.parseRequestAttributes ( attributes );
        this.label = attributes.get ( "label" );
    }
}