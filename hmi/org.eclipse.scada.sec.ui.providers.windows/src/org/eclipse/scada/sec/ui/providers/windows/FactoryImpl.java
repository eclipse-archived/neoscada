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
package org.eclipse.scada.sec.ui.providers.windows;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.scada.sec.ui.providers.KeyProviderFactory;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.eclipse.ui.statushandlers.StatusManager;

public class FactoryImpl implements KeyProviderFactory
{

    private final Set<String> names = new HashSet<String> ();

    private Realm realm;

    private WritableList list;

    public FactoryImpl ()
    {
        try
        {
            final String[] tokens = System.getProperty ( "org.eclipse.scada.sec.ui.providers.windows.defaultStoreNames", "Windows-MY,Windows-ROOT" ).split ( "\\s*,\\s*" );
            this.names.addAll ( Arrays.asList ( tokens ) );
        }
        catch ( final Exception e )
        {
            this.names.clear ();
            this.names.add ( "Windows-MY" );
            this.names.add ( "Windows-ROOT" );
        }
    }

    @Override
    public void init ( final Realm realm )
    {
        this.realm = realm;
        this.list = new WritableList ();

        for ( final String name : this.names )
        {
            try
            {
                this.list.add ( new SunMSCAPIProvider ( this.realm, name ) );
            }
            catch ( final Exception e )
            {
                StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ) );
            }
        }
    }

    @Override
    public void dispose ()
    {
        for ( final Object o : this.list )
        {
            ( (SunMSCAPIProvider)o ).dispose ();
        }
        this.list.dispose ();
    }

    @Override
    public String toString ()
    {
        return "SunMSCAPI";
    }

    @Override
    public IObservableList getKeyProviders ()
    {
        return this.list;
    }

}
