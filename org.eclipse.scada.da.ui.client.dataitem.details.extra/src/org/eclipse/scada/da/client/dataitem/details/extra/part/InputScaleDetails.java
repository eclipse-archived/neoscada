/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.client.dataitem.details.extra.part;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.ActionEvent;
import org.eclipse.draw2d.ActionListener;
import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.CheckBox;
import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.sec.ui.DisplayCallbackHandler;
import org.eclipse.swt.SWT;

public class InputScaleDetails extends AbstractBaseDraw2DDetailsPart
{

    private RoundedRectangle factorFigure;

    private RoundedRectangle rawFigure;

    private RoundedRectangle valueFigure;

    private Label factorLabel;

    private Label valueLabel;

    private Label rawLabel;

    private RoundedRectangle offsetFigure;

    private Label offsetLabel;

    private CheckBox button;

    @Override
    protected IFigure createMain ()
    {
        final Figure rootFigure = new Figure ();

        rootFigure.setLayoutManager ( new GridLayout ( 4, true ) );
        rootFigure.setBackgroundColor ( ColorConstants.white );

        // cell 1,0 
        rootFigure.add ( makeHeader (), new GridData ( GridData.BEGINNING, GridData.CENTER, true, false, 4, 1 ) );

        // cell 1,1
        rootFigure.add ( new Figure () );

        // cell 2,1
        rootFigure.add ( this.factorFigure = new RoundedRectangle (), new GridData ( GridData.CENTER, GridData.CENTER, true, true ) );
        this.factorFigure.setAntialias ( SWT.ON );
        this.factorFigure.setBackgroundColor ( ColorConstants.lightGray );
        this.factorFigure.setForegroundColor ( ColorConstants.black );
        this.factorFigure.setBorder ( new MarginBorder ( 10 ) );
        this.factorFigure.setLayoutManager ( new BorderLayout () );
        this.factorFigure.add ( this.factorLabel = new Label (), BorderLayout.CENTER );
        this.factorFigure.addMouseMotionListener ( new MouseMotionListener.Stub () {
            @Override
            public void mouseEntered ( final MouseEvent me )
            {
                InputScaleDetails.this.factorFigure.setLineWidth ( 2 );
            }

            @Override
            public void mouseExited ( final MouseEvent me )
            {
                InputScaleDetails.this.factorFigure.setLineWidth ( 1 );
            }
        } );

        // cell 3,1
        rootFigure.add ( this.offsetFigure = new RoundedRectangle (), new GridData ( GridData.CENTER, GridData.CENTER, true, true ) );
        this.offsetFigure.setAntialias ( SWT.ON );
        this.offsetFigure.setBackgroundColor ( ColorConstants.lightGray );
        this.offsetFigure.setForegroundColor ( ColorConstants.black );
        this.offsetFigure.setBorder ( new MarginBorder ( 10 ) );
        this.offsetFigure.setLayoutManager ( new BorderLayout () );
        this.offsetFigure.add ( this.offsetLabel = new Label (), BorderLayout.CENTER );
        this.offsetFigure.addMouseMotionListener ( new MouseMotionListener.Stub () {
            @Override
            public void mouseEntered ( final MouseEvent me )
            {
                InputScaleDetails.this.offsetFigure.setLineWidth ( 2 );
            }

            @Override
            public void mouseExited ( final MouseEvent me )
            {
                InputScaleDetails.this.offsetFigure.setLineWidth ( 1 );
            }
        } );

        // cell 4,1
        rootFigure.add ( new Figure () );

        // cell 1,2
        rootFigure.add ( this.rawFigure = new RoundedRectangle (), new GridData ( GridData.CENTER, GridData.CENTER, true, true ) );
        this.rawFigure.setAntialias ( SWT.ON );
        this.rawFigure.setBackgroundColor ( ColorConstants.lightGray );
        this.rawFigure.setForegroundColor ( ColorConstants.black );
        this.rawFigure.setBorder ( new MarginBorder ( 10 ) );
        this.rawFigure.setLayoutManager ( new BorderLayout () );
        this.rawFigure.add ( this.rawLabel = new Label (), BorderLayout.CENTER );

        // cell 2,2
        final RectangleFigure factorRect = new RectangleFigure ();
        factorRect.setLayoutManager ( new BorderLayout () );
        factorRect.add ( new Label ( Messages.InputScaleDetails_Multiply ), BorderLayout.CENTER );
        factorRect.setBorder ( new MarginBorder ( 10 ) );
        factorRect.setBackgroundColor ( ColorConstants.lightGray );
        factorRect.setForegroundColor ( ColorConstants.black );
        factorRect.setLineStyle ( Graphics.LINE_SOLID );
        factorRect.setLineWidth ( 1 );
        factorRect.setFill ( true );
        factorRect.setOpaque ( true );
        rootFigure.add ( factorRect, new GridData ( GridData.CENTER, GridData.CENTER, true, true ) );

        // cell 3, 2
        final RectangleFigure offsetRect = new RectangleFigure ();
        offsetRect.setLayoutManager ( new BorderLayout () );
        offsetRect.add ( new Label ( Messages.InputScaleDetails_Add ), BorderLayout.CENTER );
        offsetRect.setBorder ( new MarginBorder ( 10 ) );
        offsetRect.setBackgroundColor ( ColorConstants.lightGray );
        offsetRect.setForegroundColor ( ColorConstants.black );
        offsetRect.setLineStyle ( Graphics.LINE_SOLID );
        offsetRect.setLineWidth ( 1 );
        offsetRect.setFill ( true );
        offsetRect.setOpaque ( true );
        rootFigure.add ( offsetRect, new GridData ( GridData.CENTER, GridData.CENTER, true, true ) );

        // cell 4,2
        rootFigure.add ( this.valueFigure = new RoundedRectangle (), new GridData ( GridData.CENTER, GridData.CENTER, true, true ) );
        this.valueFigure.setAntialias ( SWT.ON );
        this.valueFigure.setLayoutManager ( new BorderLayout () );
        this.valueFigure.setBackgroundColor ( ColorConstants.lightGray );
        this.valueFigure.setForegroundColor ( ColorConstants.black );
        this.valueFigure.setBorder ( new MarginBorder ( 10 ) );
        this.valueFigure.add ( this.valueLabel = new Label (), BorderLayout.CENTER );

        // add connections
        connect ( rootFigure, this.factorFigure, factorRect );
        connect ( rootFigure, this.rawFigure, factorRect );
        connect ( rootFigure, factorRect, offsetRect );
        connect ( rootFigure, this.offsetFigure, offsetRect );
        connect ( rootFigure, offsetRect, this.valueFigure );

        // hook up entry dialogs
        this.factorFigure.addMouseListener ( new MouseListener.Stub () {
            @Override
            public void mouseDoubleClicked ( final MouseEvent me )
            {
                InputScaleDetails.this.triggerFactorInput ();
            }
        } );
        this.offsetFigure.addMouseListener ( new MouseListener.Stub () {
            @Override
            public void mouseDoubleClicked ( final MouseEvent me )
            {
                InputScaleDetails.this.triggerOffsetInput ();
            }
        } );

        return rootFigure;
    }

    private Figure makeHeader ()
    {
        this.button = new CheckBox ( "Active" );

        this.button.getModel ().addActionListener ( new ActionListener () {

            @Override
            public void actionPerformed ( final ActionEvent event )
            {
                setEnabled ( InputScaleDetails.this.button.getModel ().isSelected () );
            }
        } );

        return this.button;
    }

    protected void setEnabled ( final boolean selected )
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ( 1 );
        attributes.put ( "org.eclipse.scada.da.scale.input.active", Variant.valueOf ( selected ) ); //$NON-NLS-1$
        this.item.writeAtrtibutes ( attributes, null, makeDisplayCallback () );
    }

    private DisplayCallbackHandler makeDisplayCallback ()
    {
        return new DisplayCallbackHandler ( this.shell, "Configure", "Confirmation required for configuration of input scale" );
    }

    protected void triggerFactorInput ()
    {
        final Variant factor = new VariantEntryDialog ( this.shell ).getValue ();
        if ( factor != null )
        {
            final Map<String, Variant> attributes = new HashMap<String, Variant> ( 1 );
            attributes.put ( "org.eclipse.scada.da.scale.input.factor", factor ); //$NON-NLS-1$
            this.item.writeAtrtibutes ( attributes, null, makeDisplayCallback () );
        }
    }

    protected void triggerOffsetInput ()
    {
        final Variant factor = new VariantEntryDialog ( this.shell ).getValue ();
        if ( factor != null )
        {
            final Map<String, Variant> attributes = new HashMap<String, Variant> ( 1 );
            attributes.put ( "org.eclipse.scada.da.scale.input.offset", factor ); //$NON-NLS-1$
            this.item.writeAtrtibutes ( attributes, null, makeDisplayCallback () );
        }
    }

    private void connect ( final IFigure figure, final IFigure source, final IFigure target )
    {
        final PolylineConnection c = new PolylineConnection ();
        c.setSourceAnchor ( new ChopboxAnchor ( source ) );
        c.setTargetAnchor ( new ChopboxAnchor ( target ) );

        final PolygonDecoration dec = new PolygonDecoration ();
        dec.setTemplate ( PolygonDecoration.TRIANGLE_TIP );
        dec.setBackgroundColor ( ColorConstants.black );
        c.setTargetDecoration ( dec );

        figure.add ( c );
    }

    @Override
    protected void update ()
    {
        super.update ();
        if ( this.value == null )
        {
            return;
        }

        // set the main value
        this.valueLabel.setText ( this.value.getValue ().toString () );

        final Variant factor = this.value.getAttributes ().get ( "org.eclipse.scada.da.scale.input.factor" ); //$NON-NLS-1$
        final Variant raw = this.value.getAttributes ().get ( "org.eclipse.scada.da.scale.input.value.original" ); //$NON-NLS-1$
        final Variant active = this.value.getAttributes ().get ( "org.eclipse.scada.da.scale.input.active" ); //$NON-NLS-1$
        final Variant offset = this.value.getAttributes ().get ( "org.eclipse.scada.da.scale.input.offset" ); //$NON-NLS-1$

        if ( active != null && active.asBoolean () )
        {
            this.button.getModel ().setSelected ( true );
        }
        else
        {
            this.button.getModel ().setSelected ( false );
        }

        // set the factor value if available
        if ( factor != null )
        {
            this.factorLabel.setText ( factor.toString () );
        }
        else
        {
            this.factorLabel.setText ( "" ); //$NON-NLS-1$
        }

        // set the raw value if available
        if ( raw != null )
        {
            this.rawLabel.setText ( raw.toString () );
        }
        else
        {
            this.rawLabel.setText ( "" ); //$NON-NLS-1$
        }

        // set the offset value if available
        if ( offset != null )
        {
            this.offsetLabel.setText ( offset.toString () );
        }
        else
        {
            this.offsetLabel.setText ( "" ); //$NON-NLS-1$
        }
    }

    @Override
    protected boolean isAvailable ()
    {
        return hasAttribute ( "org.eclipse.scada.da.scale.input.active" );
    }

}
