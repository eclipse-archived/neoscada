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
package org.eclipse.scada.sec.ui.providers.pkcs12;

import java.io.File;
import java.security.KeyStore;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.sec.ui.providers.AbstractKeyStoreKeyProvider;

public class PKCS12KeyProvider extends AbstractKeyStoreKeyProvider
{

    private final File file;

    public PKCS12KeyProvider ( final Realm realm, final File file ) throws Exception
    {
        super ( realm );
        this.file = file;

        setKeyStore ( KeyStore.getInstance ( "PKCS12" ) );

        /*
         * we cannot try an initial load without password since java succeeds and gives
         * us the locked key, but refuses to give us the certificate then.
        */
    }

    @Override
    public String toString ()
    {
        return String.format ( "%s", this.file );
    }

    @Override
    public void unlock ( final CallbackHandler callbackHandler ) throws Exception
    {
        load ( this.file, callbackHandler );
    }

    public File getFile ()
    {
        return this.file;
    }
}
