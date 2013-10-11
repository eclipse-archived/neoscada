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
package org.eclipse.scada.sec.ui.providers;

import java.util.Collection;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.WritableList;

public class KeyFactoryManager
{
    private final WritableList list;

    public KeyFactoryManager ( final Realm realm )
    {
        this.list = new WritableList ( realm );

        final Collection<KeyProviderFactory> factories = Helper.createFactories ();
        for ( final KeyProviderFactory factory : factories )
        {
            factory.init ( realm );
        }

        this.list.addAll ( factories );
    }

    public WritableList getList ()
    {
        return this.list;
    }

    public void dispose ()
    {
        for ( final Object o : this.list )
        {
            ( (KeyProviderFactory)o ).dispose ();
        }
        this.list.dispose ();
    }
}
