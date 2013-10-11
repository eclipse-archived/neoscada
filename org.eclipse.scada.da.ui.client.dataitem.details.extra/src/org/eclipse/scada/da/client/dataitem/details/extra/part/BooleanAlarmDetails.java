/*******************************************************************************
 * Copyright (c) 2013 Jürgen Rose and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jürgen Rose - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.client.dataitem.details.extra.part;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.ActionEvent;
import org.eclipse.draw2d.ActionListener;
import org.eclipse.draw2d.CheckBox;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.ToggleButton;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.sec.ui.DisplayCallbackHandler;

public class BooleanAlarmDetails extends AbstractBaseDraw2DDetailsPart
{
    private CheckBox button;

    private ToggleButton trueButton;

    private ToggleButton falseButton;

    @Override
    protected IFigure createMain ()
    {
        final Figure rootFigure = new Figure ();

        rootFigure.setLayoutManager ( new GridLayout ( 5, true ) );
        rootFigure.setBackgroundColor ( ColorConstants.white );

        // cell 1,0 
        rootFigure.add ( makeHeader (), new GridData ( GridData.BEGINNING, GridData.CENTER, true, false, 5, 1 ) );

        // cell 1,1
        rootFigure.add ( new Figure () );

        // cell 2,1
        rootFigure.add ( new Label ( Messages.BooleanAlarmDetails_trigger_alarm_if_value_is ) );

        // cell 3,1
        rootFigure.add ( this.trueButton = new ToggleButton ( "true" ), new GridData ( GridData.CENTER, GridData.CENTER, true, true ) ); //$NON-NLS-1$
        this.trueButton.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed ( final ActionEvent event )
            {
                setReference ( false );
            }
        } );

        // cell 4,1
        rootFigure.add ( this.falseButton = new ToggleButton ( "false" ), new GridData ( GridData.CENTER, GridData.CENTER, true, true ) ); //$NON-NLS-1$
        this.falseButton.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed ( final ActionEvent event )
            {
                setReference ( true );
            }
        } );

        // cell 5,1
        rootFigure.add ( new Figure () );

        return rootFigure;
    }

    private Figure makeHeader ()
    {
        this.button = new CheckBox ( Messages.BooleanAlarmDetails_active );

        this.button.getModel ().addActionListener ( new ActionListener () {

            @Override
            public void actionPerformed ( final ActionEvent event )
            {
                setEnabled ( BooleanAlarmDetails.this.button.getModel ().isSelected () );
            }
        } );

        return this.button;
    }

    protected void setReference ( final boolean b )
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ();
        attributes.put ( "org.eclipse.scada.ae.monitor.bit.reference", Variant.valueOf ( b ) ); //$NON-NLS-1$
        this.item.writeAtrtibutes ( attributes, null, makeDisplayCallback () );
    }

    private CallbackHandler makeDisplayCallback ()
    {
        return new DisplayCallbackHandler ( this.shell, "Configure Boolean Monitor", "Confirmation required for configuring boolean monitor" );
    }

    protected void setEnabled ( final boolean selected )
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ( 1 );
        attributes.put ( "org.eclipse.scada.ae.monitor.bit.active", Variant.valueOf ( selected ) ); //$NON-NLS-1$
        this.item.writeAtrtibutes ( attributes, null, makeDisplayCallback () );
    }

    @Override
    protected void update ()
    {
        super.update ();
        if ( this.value == null )
        {
            return;
        }

        final Variant active = this.value.getAttributes ().get ( "org.eclipse.scada.ae.monitor.bit.active" ); //$NON-NLS-1$

        if ( active != null && active.asBoolean () )
        {
            this.button.getModel ().setSelected ( true );
        }
        else
        {
            this.button.getModel ().setSelected ( false );
        }

        final Variant reference = this.value.getAttributes ().get ( "org.eclipse.scada.ae.monitor.bit.reference" ); //$NON-NLS-1$

        if ( reference != null && reference.asBoolean () )
        {
            this.trueButton.getModel ().setSelected ( false );
            this.falseButton.getModel ().setSelected ( true );
        }
        else
        {
            this.trueButton.getModel ().setSelected ( true );
            this.falseButton.getModel ().setSelected ( false );
        }
    }

    @Override
    protected boolean isAvailable ()
    {
        return hasAttribute ( "org.eclipse.scada.ae.monitor.bit.reference" ); //$NON-NLS-1$
    }

}
