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
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.scada.sec.ui.providers.KeyProvider;
import org.eclipse.scada.sec.ui.providers.KeyProviderFactory;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.eclipse.ui.statushandlers.StatusManager;

public class FactoryImpl implements KeyProviderFactory
{

    private final Set<String> files = new HashSet<String> ();

    private Realm realm;

    private WritableList list;

    private final Preferences prefs;

    public FactoryImpl ()
    {
        this.prefs = Preferences.userNodeForPackage ( FactoryImpl.class ).node ( "files" );

        try
        {
            for ( final String child : this.prefs.childrenNames () )
            {
                final Preferences childNode = this.prefs.node ( child );
                final String fileName = childNode.get ( "file", null );
                if ( fileName != null )
                {
                    this.files.add ( fileName );
                }
            }
        }
        catch ( final BackingStoreException e )
        {
            StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ) );
        }
    }

    public void addFile ( final String fileName ) throws Exception
    {
        final File file = new File ( fileName ).getAbsoluteFile ();

        final Preferences newChild = this.prefs.node ( UUID.randomUUID ().toString () );
        newChild.put ( "file", file.toString () );
        newChild.flush ();

        this.files.add ( fileName );
        loadFile ( fileName );
    }

    public void remove ( final KeyProvider keyProvider ) throws Exception
    {
        if ( ! ( keyProvider instanceof PKCS12KeyProvider ) )
        {
            return;
        }

        if ( !this.list.remove ( keyProvider ) )
        {
            return;
        }

        final File file = ( (PKCS12KeyProvider)keyProvider ).getFile ();

        keyProvider.dispose ();

        removeFile ( file.getAbsoluteFile () );
    }

    private void removeFile ( final File file ) throws Exception
    {
        for ( final String childName : this.prefs.childrenNames () )
        {
            final Preferences child = this.prefs.node ( childName );
            final String fileName = new File ( child.get ( "file", null ) ).getAbsolutePath ();
            if ( file.getAbsolutePath ().equals ( fileName ) )
            {
                child.removeNode ();
            }
        }
        this.prefs.flush ();
    }

    @Override
    public void init ( final Realm realm )
    {
        this.realm = realm;
        this.list = new WritableList ();

        for ( final String fileName : this.files )
        {
            loadFile ( fileName );
        }
    }

    private void loadFile ( final String fileName )
    {
        try
        {
            this.list.add ( new PKCS12KeyProvider ( this.realm, new File ( fileName ) ) );
        }
        catch ( final Exception e )
        {
            StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ) );
        }
    }

    @Override
    public void dispose ()
    {
        for ( final Object o : this.list )
        {
            ( (PKCS12KeyProvider)o ).dispose ();
        }
        this.list.dispose ();
    }

    @Override
    public String toString ()
    {
        return "PKCS12";
    }

    @Override
    public IObservableList getKeyProviders ()
    {
        return this.list;
    }

}
