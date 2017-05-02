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

import java.security.KeyStore;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.sec.ui.providers.AbstractKeyStoreKeyProvider;

public class SunMSCAPIProvider extends AbstractKeyStoreKeyProvider
{

    private final String name;

    public SunMSCAPIProvider ( final Realm realm, final String name ) throws Exception
    {
        super ( realm );
        this.name = name;

        setKeyStore ( KeyStore.getInstance ( name, "SunMSCAPI" ) );
        try
        {
            // try to load initially
            performLoad ();
        }
        catch ( final Exception e )
        {
            // silently fail
        }
    }

    @Override
    public String toString ()
    {
        return String.format ( "%s", this.name );
    }

    @Override
    public void unlock ( final CallbackHandler callbackHandler ) throws Exception
    {
        load ();
    }

}
