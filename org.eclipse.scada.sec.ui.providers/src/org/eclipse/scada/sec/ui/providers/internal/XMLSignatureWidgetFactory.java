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
package org.eclipse.scada.sec.ui.providers.internal;

import java.security.Key;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

import javax.xml.crypto.dsig.DigestMethod;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.scada.sec.authz.signature.RequestSigner;
import org.eclipse.scada.sec.authz.signature.SignatureRequestBuilder;
import org.eclipse.scada.sec.authz.signature.RequestSigner.Configuration;
import org.eclipse.scada.sec.callback.XMLSignatureCallback;
import org.eclipse.scada.sec.ui.CallbackWidgetFactory;
import org.eclipse.scada.sec.ui.providers.KeyInformation;
import org.eclipse.scada.sec.ui.providers.KeyInstanceManager;
import org.eclipse.scada.sec.ui.providers.KeySelectorDialog;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.statushandlers.StatusManager;
import org.w3c.dom.Document;

public class XMLSignatureWidgetFactory implements CallbackWidgetFactory
{

    private final XMLSignatureCallback callback;

    private Text text;

    public XMLSignatureWidgetFactory ( final XMLSignatureCallback callback )
    {
        this.callback = callback;
    }

    @Override
    public void createGridWidgets ( final DataBindingContext dbc, final Composite composite )
    {
        final Label label = new Label ( composite, SWT.NONE );
        label.setText ( "Certificate:" );

        final Composite wrapper = new Composite ( composite, SWT.NONE );
        wrapper.setLayout ( new GridLayout ( 2, false ) );
        wrapper.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, false ) );

        this.text = new Text ( wrapper, SWT.BORDER | SWT.READ_ONLY );
        this.text.setEnabled ( false );
        this.text.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );

        setKeyCert ( null );

        final Button button = new Button ( wrapper, SWT.PUSH );
        button.setText ( "Select key" );
        button.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                openDialog ( composite.getShell () );
            }
        } );
        button.setLayoutData ( new GridData ( SWT.FILL, SWT.BEGINNING, false, false ) );
    }

    protected void openDialog ( final Shell shell )
    {
        final KeySelectorDialog dlg = new KeySelectorDialog ( shell, "Select Key", "Select a key for signing", this.callback.getMaximumRememberPeriod () / ( 1000 * 60 ) );

        if ( dlg.open () == org.eclipse.jface.window.Window.OK )
        {
            final KeyInformation ki = dlg.getKeyInformation ();

            setKeyCert ( ki );
            sign ( ki.getKey (), ki.getCertificate () );
        }
        else
        {
            setKeyCert ( null );
        }
    }

    private void setKeyCert ( final KeyInformation ki )
    {
        if ( ki == null )
        {
            this.text.setText ( "<none>" );
            return;
        }

        final Certificate certificate = ki.getCertificate ();
        final Key key = ki.getKey ();

        if ( certificate instanceof X509Certificate )
        {
            this.text.setText ( "" + ( (X509Certificate)certificate ).getSubjectX500Principal () );
        }
        else
        {
            this.text.setText ( String.format ( "%s - %s - %s", ki.getAlias (), key.getFormat (), key.getAlgorithm () ) );
        }
    }

    private void sign ( final Key key, final Certificate cert )
    {
        try
        {
            performSign ( key, cert );
        }
        catch ( final Exception e )
        {
            final IStatus status = StatusHelper.convertStatus ( Activator.PLUGIN_ID, e );
            StatusManager.getManager ().handle ( status );
            ErrorDialog.openError ( this.text.getShell (), "Error", "Error signing", status );
        }
    }

    private void performSign ( final Key key, final Certificate cert ) throws Exception
    {
        final SignatureRequestBuilder builder = new SignatureRequestBuilder ();
        final Document doc = builder.fromString ( this.callback.getDocument () );
        final Configuration cfg = new RequestSigner.Configuration ();
        cfg.setDigestMethod ( DigestMethod.SHA1 );
        new RequestSigner ( cfg ).sign ( key, cert, doc );
        this.callback.setSignedDocument ( builder.toString ( doc, false ) );
    }

    @Override
    public void complete ()
    {
    }

    @Override
    public boolean tryInstantComplete ()
    {
        final KeyInstanceManager mgr = KeyInstanceManager.getInstance ( Display.getCurrent () );
        if ( mgr == null )
        {
            return false;
        }

        final KeyInformation key = mgr.getDefaultKey ();
        if ( key == null )
        {
            return false;
        }

        try
        {
            performSign ( key.getKey (), key.getCertificate () );
            return true;
        }
        catch ( final Exception e )
        {
            mgr.clearDefaultKey ();
            StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ) );
            return false;
        }
    }
}
