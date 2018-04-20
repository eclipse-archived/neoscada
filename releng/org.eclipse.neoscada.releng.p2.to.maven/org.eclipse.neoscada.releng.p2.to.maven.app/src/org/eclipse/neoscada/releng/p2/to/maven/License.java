/*******************************************************************************
 * Copyright (c) 2016 Red Hat Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat Inc - initial API and implementation
 *******************************************************************************/
package org.eclipse.neoscada.releng.p2.to.maven;

public class License
{
    public static final License EPL = new License ( "The Eclipse Public License Version 1.0", "http://www.eclipse.org/legal/epl-v10.html" );

    private final String name;

    private final String url;

    public License ( final String name, final String url )
    {
        this.name = name;
        this.url = url;
    }

    public String getName ()
    {
        return this.name;
    }

    public String getUrl ()
    {
        return this.url;
    }
}
