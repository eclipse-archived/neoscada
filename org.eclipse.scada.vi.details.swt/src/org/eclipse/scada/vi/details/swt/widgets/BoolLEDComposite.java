/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.details.swt.widgets;

import java.util.Map;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.vi.data.DataValue;
import org.eclipse.scada.vi.data.SummaryInformation;
import org.eclipse.scada.vi.details.swt.data.DataItemDescriptor;
import org.eclipse.scada.vi.details.swt.widgets.control.ControlImage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BoolLEDComposite extends GenericComposite
{
    private static final Logger logger = LoggerFactory.getLogger ( BoolLEDComposite.class );

    private final ResourceManager resourceManager;

    private final Label signalLabel;

    private final boolean expectedValue;

    private final boolean isAlarm;

    private final boolean isOnOff;

    private final Image imageGreen;

    private final Image imageRed;

    private final Image imageGray;

    private final Image imageOn;

    private final Image imageOff;

    private final String attribute;

    private final ControlImage controlImage;

    public BoolLEDComposite ( final Composite parent, final int style, final DataItemDescriptor descriptor, final String format, final boolean expectedValue, final boolean isAlarm, final boolean isOnOff, final String attribute )
    {
        super ( parent, style, null, null );

        this.resourceManager = new LocalResourceManager ( JFaceResources.getResources () );
        this.imageGreen = this.resourceManager.createImageWithDefault ( ImageDescriptor.createFromFile ( BoolLEDComposite.class, "icons/ledGreen.png" ) ); //$NON-NLS-1$
        this.imageGray = this.resourceManager.createImageWithDefault ( ImageDescriptor.createFromFile ( BoolLEDComposite.class, "icons/ledGray.png" ) ); //$NON-NLS-1$
        this.imageRed = this.resourceManager.createImageWithDefault ( ImageDescriptor.createFromFile ( BoolLEDComposite.class, "icons/ledRed.png" ) ); //$NON-NLS-1$
        this.imageOn = this.resourceManager.createImageWithDefault ( ImageDescriptor.createFromFile ( BoolLEDComposite.class, "icons/on.png" ) ); //$NON-NLS-1$
        this.imageOff = this.resourceManager.createImageWithDefault ( ImageDescriptor.createFromFile ( BoolLEDComposite.class, "icons/off.png" ) ); //$NON-NLS-1$

        final RowLayout layout = new RowLayout ();
        layout.wrap = false;
        layout.center = true;
        layout.spacing = 3;
        setLayout ( layout );

        this.expectedValue = expectedValue;
        this.isAlarm = isAlarm;
        this.isOnOff = isOnOff;
        this.attribute = attribute;

        this.controlImage = new ControlImage ( this, this.registrationManager );
        this.controlImage.setDetailItem ( descriptor.asItem () );

        this.signalLabel = new Label ( this, SWT.NONE );
        this.signalLabel.setImage ( this.imageGray );
        new DescriptorLabel ( this, SWT.NONE, format, descriptor );

        if ( descriptor != null )
        {
            this.registrationManager.registerItem ( "value", descriptor.getItemId (), descriptor.getConnectionInformation (), false, false ); //$NON-NLS-1$
        }

        if ( Boolean.getBoolean ( "org.eclipse.scada.developer" ) ) //$NON-NLS-1$
        {

            if ( this.isAlarm == true )
            {
                this.signalLabel.setToolTipText ( "Red" );
            }
            else
            {
                this.signalLabel.setToolTipText ( "Green" );
            }
        }
    }

    @Override
    protected void handleDispose ()
    {
        this.resourceManager.dispose ();
        super.handleDispose ();
    }

    @Override
    protected void updateState ( final Map<String, DataValue> values, final SummaryInformation summaryInformation )
    {
        if ( isDisposed () )
        {
            logger.info ( "No updateView cause widget is disposed" ); //$NON-NLS-1$
            return;
        }

        Variant value;
        if ( this.attribute == null )
        {
            try
            {
                value = values.get ( "value" ).getValue ().getValue (); //$NON-NLS-1$
            }
            catch ( final NullPointerException e )
            {
                logger.info ( "could not get value", e ); //$NON-NLS-1$
                value = Variant.NULL;
            }
        }
        else
        {
            try
            {
                value = values.get ( "value" ).getValue ().getAttributes ().get ( this.attribute ); //$NON-NLS-1$
            }
            catch ( final NullPointerException e )
            {
                logger.info ( "could not get attribute", e ); //$NON-NLS-1$
                value = Variant.NULL;
            }
        }

        if ( value == null )
        {
            return;
        }

        if ( this.isOnOff )
        {
            if ( value.asBoolean () )
            {
                this.signalLabel.setImage ( this.imageOn );
            }
            else
            {
                this.signalLabel.setImage ( this.imageOff );
            }
        }
        else
        {
            if ( value.asBoolean () == this.expectedValue )
            {
                this.signalLabel.setImage ( this.imageGray );
            }
            else
            {
                if ( this.isAlarm )
                {
                    this.signalLabel.setImage ( this.imageRed );
                }
                else
                {
                    this.signalLabel.setImage ( this.imageGreen );
                }
            }
        }
    }
}
