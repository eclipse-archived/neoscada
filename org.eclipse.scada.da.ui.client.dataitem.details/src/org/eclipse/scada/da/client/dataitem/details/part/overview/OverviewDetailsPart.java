/*******************************************************************************
 * Copyright (c) 2009, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *     IBH SYSTEMS GmbH - add scrolling
 *******************************************************************************/
package org.eclipse.scada.da.client.dataitem.details.part.overview;

import java.util.Calendar;

import org.eclipse.scada.core.ConnectionInformation;
import org.eclipse.scada.da.client.dataitem.details.part.AbstractBaseDetailsPart;
import org.eclipse.scada.da.ui.connection.data.DataItemHolder;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class OverviewDetailsPart extends AbstractBaseDetailsPart
{

    private Text connectionUriText;

    private Text itemIdText;

    private Text stateText;

    private Text alarmText;

    private Text errorText;

    private Text valueText;

    private Text timestampText;

    private Text manualText;

    private Text blockedText;

    private Text warnText;

    @Override
    public void createPart ( final Composite parent )
    {
        super.createPart ( parent );

        parent.setLayout ( new FillLayout () );

        Label label;

        parent.setBackgroundMode ( SWT.INHERIT_FORCE );
        final ScrolledComposite scroll = new ScrolledComposite ( parent, SWT.V_SCROLL );
        scroll.setBackgroundMode ( SWT.INHERIT_FORCE );
        scroll.setExpandHorizontal ( true );
        scroll.setExpandVertical ( true );

        final Composite wrapper = new Composite ( scroll, SWT.NONE );
        wrapper.setLayout ( new GridLayout ( 2, false ) );
        scroll.setContent ( wrapper );

        // connection uri
        label = new Label ( wrapper, SWT.NONE );
        label.setText ( Messages.OverviewDetailsPart_ConnectionLabel );
        this.connectionUriText = new Text ( wrapper, SWT.READ_ONLY | SWT.BORDER );
        this.connectionUriText.setLayoutData ( new GridData ( SWT.FILL, SWT.BEGINNING, true, false ) );

        // item id
        label = new Label ( wrapper, SWT.NONE );
        label.setText ( Messages.OverviewDetailsPart_ItemIdLabel );
        this.itemIdText = new Text ( wrapper, SWT.READ_ONLY | SWT.BORDER );
        this.itemIdText.setLayoutData ( new GridData ( SWT.FILL, SWT.BEGINNING, true, false ) );

        // item state
        label = new Label ( wrapper, SWT.NONE );
        label.setText ( Messages.OverviewDetailsPart_SubscriptionStateLabel );
        this.stateText = new Text ( wrapper, SWT.READ_ONLY | SWT.BORDER );
        this.stateText.setLayoutData ( new GridData ( SWT.FILL, SWT.BEGINNING, true, false ) );

        label = new Label ( wrapper, SWT.NONE );
        label.setText ( Messages.OverviewDetailsPart_WarningLabel );
        this.warnText = new Text ( wrapper, SWT.READ_ONLY | SWT.BORDER );
        this.warnText.setLayoutData ( new GridData ( SWT.FILL, SWT.BEGINNING, true, false ) );

        label = new Label ( wrapper, SWT.NONE );
        label.setText ( Messages.OverviewDetailsPart_AlarmLabel );
        this.alarmText = new Text ( wrapper, SWT.READ_ONLY | SWT.BORDER );
        this.alarmText.setLayoutData ( new GridData ( SWT.FILL, SWT.BEGINNING, true, false ) );

        label = new Label ( wrapper, SWT.NONE );
        label.setText ( Messages.OverviewDetailsPart_ErrorLabel );
        this.errorText = new Text ( wrapper, SWT.READ_ONLY | SWT.BORDER );
        this.errorText.setLayoutData ( new GridData ( SWT.FILL, SWT.BEGINNING, true, false ) );

        label = new Label ( wrapper, SWT.NONE );
        label.setText ( Messages.OverviewDetailsPart_ManualLabel );
        this.manualText = new Text ( wrapper, SWT.READ_ONLY | SWT.BORDER );
        this.manualText.setLayoutData ( new GridData ( SWT.FILL, SWT.BEGINNING, true, false ) );

        label = new Label ( wrapper, SWT.NONE );
        label.setText ( Messages.OverviewDetailsPart_BlockedLabel );
        this.blockedText = new Text ( wrapper, SWT.READ_ONLY | SWT.BORDER );
        this.blockedText.setLayoutData ( new GridData ( SWT.FILL, SWT.BEGINNING, true, false ) );

        label = new Label ( wrapper, SWT.NONE );
        label.setText ( Messages.OverviewDetailsPart_ValueLabel );
        this.valueText = new Text ( wrapper, SWT.READ_ONLY | SWT.BORDER );
        this.valueText.setLayoutData ( new GridData ( SWT.FILL, SWT.BEGINNING, true, false ) );

        label = new Label ( wrapper, SWT.NONE );
        label.setText ( Messages.OverviewDetailsPart_TimestampLabel );
        this.timestampText = new Text ( wrapper, SWT.READ_ONLY | SWT.BORDER );
        this.timestampText.setLayoutData ( new GridData ( SWT.FILL, SWT.BEGINNING, true, false ) );

        scroll.setMinSize ( wrapper.computeSize ( SWT.DEFAULT, SWT.DEFAULT ) );
    }

    @Override
    public void setDataItem ( final DataItemHolder item )
    {
        super.setDataItem ( item );

        if ( item != null )
        {
            this.connectionUriText.setText ( getConnectionString ( item ) );
            this.itemIdText.setText ( item.getItem ().getId () );
        }
        else
        {
            this.connectionUriText.setText ( "" ); //$NON-NLS-1$
            this.itemIdText.setText ( "" ); //$NON-NLS-1$
            this.stateText.setText ( "" ); //$NON-NLS-1$
            this.warnText.setText ( "" ); //$NON-NLS-1$
            this.alarmText.setText ( "" ); //$NON-NLS-1$
            this.errorText.setText ( "" ); //$NON-NLS-1$
            this.manualText.setText ( "" ); //$NON-NLS-1$
            this.blockedText.setText ( "" ); //$NON-NLS-1$
            this.valueText.setText ( "" ); //$NON-NLS-1$
            this.timestampText.setText ( "" ); //$NON-NLS-1$
        }
    }

    private String getConnectionString ( final DataItemHolder itemHolder )
    {
        if ( itemHolder == null || itemHolder.getItem () == null )
        {
            return ""; //$NON-NLS-1$
        }

        final Item item = itemHolder.getItem ();

        if ( item == null )
        {
            return ""; //$NON-NLS-1$
        }

        final String str = item.getConnectionString ();

        try
        {
            final ConnectionInformation ci = ConnectionInformation.fromURI ( str );
            return ci.toMaskedString ();
        }
        catch ( final Exception e )
        {
            return str;
        }
    }

    @Override
    protected void update ()
    {
        if ( this.value == null )
        {
            return;
        }

        if ( this.value.getSubscriptionError () == null )
        {
            this.stateText.setText ( this.value.getSubscriptionState ().name () );
        }
        else
        {
            this.stateText.setText ( String.format ( Messages.OverviewDetailsPart_SubscriptionStateFormat, this.value.getSubscriptionState ().name (), this.value.getSubscriptionError ().getMessage () ) );
        }

        this.warnText.setText ( this.value.isWarning () ? Messages.OverviewDetailsPart_WarningActiveText : Messages.OverviewDetailsPart_WarningInactiveText );
        this.alarmText.setText ( this.value.isAlarm () ? Messages.OverviewDetailsPart_AlarmActiveText : Messages.OverviewDetailsPart_AlarmInactiveText );
        this.errorText.setText ( this.value.isError () ? Messages.OverviewDetailsPart_ErrorActiveText : Messages.OverviewDetailsPart_ErrorInactiveText );
        this.manualText.setText ( this.value.isManual () ? Messages.OverviewDetailsPart_ManualActiveText : Messages.OverviewDetailsPart_ManualInactiveText );
        this.blockedText.setText ( this.value.isBlocked () ? Messages.OverviewDetailsPart_BlockedActiveText : Messages.OverviewDetailsPart_BlockedInactiveText );

        this.valueText.setText ( this.value.getValue () != null ? this.value.getValue ().toString () : Messages.OverviewDetailsPart_NullText );
        final Calendar c = this.value.getTimestamp ();
        this.timestampText.setText ( c != null ? String.format ( Messages.OverviewDetailsPart_TimeFormat, c ) : Messages.OverviewDetailsPart_NullText );
    }
}
