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

import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.concurrent.Future;

import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.scada.sec.callback.Callback;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.sec.callback.Callbacks;
import org.eclipse.scada.sec.callback.PasswordCallback;
import org.eclipse.scada.sec.ui.providers.internal.Activator;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.eclipse.scada.utils.beans.AbstractPropertyChange;
import org.eclipse.scada.utils.concurrent.FutureListener;
import org.eclipse.scada.utils.concurrent.NotifyFuture;
import org.eclipse.ui.PlatformUI;

public class KeyImpl extends AbstractPropertyChange implements Key
{

    private final String alias;

    private final KeyStore keyStore;

    private java.security.Key key;

    private Certificate certificate;

    private boolean locked = true;

    public KeyImpl ( final String alias, final KeyStore keyStore, final String initialPassword )
    {
        this.alias = alias;
        this.keyStore = keyStore;

        try
        {
            performUnlock ( initialPassword );
        }
        catch ( final Exception e )
        {
            // silently ignore .. need manual operation
        }
    }

    @Override
    public boolean isLocked ()
    {
        return this.locked;
    }

    @Override
    public void dispose ()
    {
        this.key = null;
        this.certificate = null;
    }

    @Override
    public void unlock ( final CallbackHandler callbackHandler )
    {
        final NotifyFuture<Callback[]> future = Callbacks.callback ( callbackHandler, new PasswordCallback ( "Key password", 0 ) );
        future.addListener ( new FutureListener<Callback[]> () {

            @Override
            public void complete ( final Future<Callback[]> future )
            {
                try
                {
                    performUnlock ( ( (PasswordCallback)future.get ()[0] ).getPlainPassword () );
                }
                catch ( final Exception e )
                {
                    ErrorDialog.openError ( PlatformUI.getWorkbench ().getActiveWorkbenchWindow ().getShell (), "Error", "Failed to unlock", StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ) );
                }
            }
        } );
    }

    protected void performUnlock ( final String password ) throws Exception
    {
        if ( !this.locked )
        {
            return;
        }

        this.key = this.keyStore.getKey ( this.alias, password != null ? password.toCharArray () : null );
        this.certificate = this.keyStore.getCertificate ( this.alias );
        setLocked ( false );
    }

    private void setLocked ( final boolean locked )
    {
        firePropertyChange ( PROP_LOCKED, this.locked, this.locked = locked );
    }

    @Override
    public String toString ()
    {
        if ( this.key != null && this.certificate instanceof X509Certificate )
        {
            return String.format ( "%s - %s", this.alias, ( (X509Certificate)this.certificate ).getSubjectX500Principal () );
        }
        else if ( this.key != null )
        {
            return String.format ( "%s - %s - %s", this.alias, this.key.getAlgorithm (), this.key.getFormat () );
        }
        else
        {
            return String.format ( "%s", this.alias );
        }
    }

    @Override
    public boolean isPrivate ()
    {
        return this.key != null;
    }

    @Override
    public java.security.Key getKey ()
    {
        return this.key;
    }

    @Override
    public Certificate getCertificate ()
    {
        return this.certificate;
    }

    @Override
    public String getName ()
    {
        return this.alias;
    }

}
