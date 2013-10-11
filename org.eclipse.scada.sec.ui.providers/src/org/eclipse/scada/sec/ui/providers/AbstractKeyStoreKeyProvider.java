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

import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.KeyStore.ProtectionParameter;
import java.security.KeyStoreException;
import java.util.Enumeration;
import java.util.concurrent.Future;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.scada.sec.callback.Callback;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.sec.callback.CallbackHandlerTranslator;
import org.eclipse.scada.sec.callback.Callbacks;
import org.eclipse.scada.sec.callback.PasswordCallback;
import org.eclipse.scada.sec.ui.providers.internal.Activator;
import org.eclipse.scada.sec.utils.password.PasswordEncoding;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.eclipse.scada.utils.beans.AbstractPropertyChange;
import org.eclipse.scada.utils.concurrent.FutureListener;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.ui.PlatformUI;

public abstract class AbstractKeyStoreKeyProvider extends AbstractPropertyChange implements KeyProvider
{

    private boolean locked = true;

    private final WritableList list;

    private KeyStore keyStore;

    public AbstractKeyStoreKeyProvider ( final Realm realm )
    {
        this.list = new WritableList ( realm );
    }

    protected void setKeyStore ( final KeyStore keyStore )
    {
        this.keyStore = keyStore;
    }

    @Override
    public IObservableList getKeys ()
    {
        return this.list;
    }

    @Override
    public void dispose ()
    {
        for ( final Object o : this.list )
        {
            ( (Key)o ).dispose ();
        }
        this.list.dispose ();
    }

    @Override
    public boolean isLocked ()
    {
        return this.locked;
    }

    protected void setLocked ( final boolean locked )
    {
        firePropertyChange ( PROP_LOCKED, this.locked, this.locked = locked );
    }

    protected void handleLoadError ( final Throwable e )
    {
        ErrorDialog.openError ( PlatformUI.getWorkbench ().getActiveWorkbenchWindow ().getShell (), "Error", "Failed to unlock", StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ) );
    }

    protected void load ()
    {
        try
        {
            performLoad ();
        }

        catch ( final Exception e )
        {
            handleLoadError ( e );
        }
    }

    protected void load ( final CallbackHandler callbackHandler )
    {
        try
        {
            performLoad ( callbackHandler );
        }
        catch ( final Exception e )
        {
            handleLoadError ( e );
        }
    }

    protected void load ( final File file, final CallbackHandler callbackHandler )
    {
        final NotifyFuture<Callback[]> future = Callbacks.callback ( callbackHandler, new PasswordCallback ( "Key store password", 0, PasswordEncoding.PLAIN ) );
        future.addListener ( new FutureListener<Callback[]> () {

            @Override
            public void complete ( final Future<Callback[]> future )
            {
                try
                {
                    performLoad ( file, ( (PasswordCallback)future.get ()[0] ).getPlainPassword () );
                }
                catch ( final Exception e )
                {
                    handleLoadError ( e );
                }
            }
        } );
    }

    private void extractKeys ( final String initPassword ) throws KeyStoreException
    {
        final Enumeration<String> en = this.keyStore.aliases ();
        while ( en.hasMoreElements () )
        {
            final Key key = createKey ( en.nextElement (), this.keyStore, initPassword );
            if ( key == null )
            {
                continue;
            }

            if ( key.isLocked () || key.isPrivate () )
            {
                // if the key is unlocked and not provide it is only a certificate...
                this.list.add ( key );
            }
            else
            {
                key.dispose ();
            }
        }
    }

    protected void performLoad ( final CallbackHandler callbackHandler ) throws Exception
    {
        this.list.clear ();

        setLocked ( true );

        this.keyStore.load ( new KeyStore.LoadStoreParameter () {

            @Override
            public ProtectionParameter getProtectionParameter ()
            {
                return new KeyStore.CallbackHandlerProtection ( new CallbackHandlerTranslator ( callbackHandler ) );
            }
        } );

        setLocked ( false );

        extractKeys ( null );
    }

    protected void performLoad () throws Exception
    {
        this.list.clear ();

        setLocked ( true );

        this.keyStore.load ( null, null );

        setLocked ( false );

        extractKeys ( null );
    }

    protected void performLoad ( final File file, final String password ) throws Exception
    {
        this.list.clear ();

        setLocked ( true );

        final FileInputStream stream = new FileInputStream ( file );
        try
        {
            this.keyStore.load ( stream, password != null ? password.toCharArray () : null );
        }
        finally
        {
            stream.close ();
        }

        setLocked ( false );

        extractKeys ( password );
    }

    protected Key createKey ( final String alias, final KeyStore keyStore, final String initialPassword )
    {
        return new KeyImpl ( alias, keyStore, initialPassword );
    }
}
