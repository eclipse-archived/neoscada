/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.details.swt.widgets;

import java.util.Map;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.scada.vi.data.DataValue;
import org.eclipse.scada.vi.data.SummaryInformation;
import org.eclipse.scada.vi.details.swt.data.DataItemDescriptor;
import org.eclipse.scada.vi.details.swt.widgets.control.ControlImage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BrowserComponent extends GenericComposite
{
    private static final Logger logger = LoggerFactory.getLogger ( BrowserComponent.class );

    private final org.eclipse.scada.vi.details.model.BrowserComponent component;

    private final Browser browser;

    private final LocalResourceManager resourceManager;

    private String currentUrl;

    private Image currentImage;

    private final ControlImage controlImage;

    public BrowserComponent ( final Composite parent, final int style, final DataItemDescriptor descriptor, final org.eclipse.scada.vi.details.model.BrowserComponent component )
    {
        super ( parent, style, null, null );
        this.component = component;

        final GridLayout layout = new GridLayout ( 2, false );
        layout.marginHeight = layout.marginWidth = 3;
        layout.horizontalSpacing = layout.verticalSpacing = 3;

        setLayout ( layout );

        this.resourceManager = new LocalResourceManager ( JFaceResources.getResources () );

        this.controlImage = new ControlImage ( this, this.registrationManager );

        this.browser = new Browser ( this, SWT.NONE );

        final GridData gd = new GridData ( SWT.CENTER, SWT.CENTER, true, true );
        if ( component.getHeight () != null && component.getWidth () != null )
        {
            gd.minimumHeight = component.getHeight ();
            gd.minimumWidth = component.getWidth ();
            // this.label.setLayoutData ( new GridData ( component.getWidth (), component.getHeight () ) );
            this.browser.setSize ( component.getWidth (), component.getHeight () );
        }
        this.browser.setLayoutData ( gd );

        if ( descriptor != null )
        {
            this.controlImage.setDetailItem ( descriptor.asItem () );
            this.registrationManager.registerItem ( "value", descriptor.getItemId (), descriptor.getConnectionInformation (), false, false );
        }

        showUrl ( makeUrl () );
        if ( component.getReloadTimer () != null && component.getReloadTimer () > 0 )
        {
            triggerReload ( component.getReloadTimer () );
        }
    }

    private void triggerReload ( final long delay )
    {
        if ( this.browser.isDisposed () )
        {
            return;
        }
        if ( this.browser.getDisplay ().isDisposed () )
        {
            return;
        }

        this.browser.getDisplay ().timerExec ( (int)delay, new Runnable () {

            @Override
            public void run ()
            {
                if ( !BrowserComponent.this.browser.isDisposed () )
                {
                    reload ();
                    triggerReload ( delay );
                }
            }
        } );
    }

    private String makeUrl ()
    {
        if ( this.component.getUrl () == null )
        {
            return "about:blank";
        }

        return this.component.getUrl ();
    }

    @Override
    protected void handleDispose ()
    {
        if ( this.currentImage != null )
        {
            this.currentImage.dispose ();
            this.currentImage = null;
        }

        this.resourceManager.dispose ();
    }

    @Override
    protected void updateState ( final Map<String, DataValue> values, final SummaryInformation aggregatedState )
    {
        if ( isDisposed () )
        {
            logger.info ( "No updateView cause widget is disposed" ); //$NON-NLS-1$
            return;
        }

        showUrl ( makeUrl () );
    }

    protected void showUrl ( final String url )
    {
        logger.debug ( "Requesting URL: {}", url );

        synchronized ( this )
        {
            if ( this.currentUrl != null && this.currentUrl.equals ( url ) )
            {
                logger.debug ( "URL did not change" );
                return;
            }

            this.currentUrl = url;
            this.browser.setUrl ( this.currentUrl );
        }
    }

    public void reload ()
    {
        this.browser.refresh ();
    }

}
