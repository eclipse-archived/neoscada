/*******************************************************************************
 * Copyright (c) 2006, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.lang;

/**
 * This class is inteded to by used for passing objects as "reference to
 * reference".
 * 
 * @author Jens Reimann <jens.reimann@th4-systems.com>
 * @param <T>
 *            type that should be wrapped
 */
public class Holder<T>
{
    public T value = null;

    public Holder ()
    {
        super ();
    }

    public Holder ( final T value )
    {
        this.value = value;
    }
}
