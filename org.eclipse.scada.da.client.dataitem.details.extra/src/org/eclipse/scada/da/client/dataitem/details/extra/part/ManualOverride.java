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

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.Layer;
import org.eclipse.draw2d.LayeredPane;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.sec.ui.DisplayCallbackHandler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.scada.core.ui.styles.StateInformation.State;
import org.eclipse.scada.core.ui.styles.StateStyler;
import org.eclipse.scada.core.ui.styles.StaticStateInformation;
import org.eclipse.scada.core.ui.styles.StyleBlinker;

/**
 * A detail view for the manual override value, setting and getting the status
 * 
 * @author Jens Reimann
 */
public class ManualOverride extends AbstractBaseDraw2DDetailsPart
{

    private Label pvValue;

    private Label mvValue;

    private Label rvValue;

    private RoundedRectangle rvRect;

    private RoundedRectangle mvRect;

    private RoundedRectangle pvRect;

    private PolylineConnection p2rConnection;

    private PolylineConnection m2rConnection;

    private Variant manualValue;

    private RoundedRectangle rmvRect;

    private Label rmvValue;

    private RoundedRectangle rpvRect;

    private Label rpvValue;

    private PolylineConnection rp2pConnection;

    private PolylineConnection rm2pConnection;

    private LocalResourceManager resourceManager;;

    private Figure rmvFigure;

    private Figure rpvFigure;

    private StyleBlinker pvRectBlinker;

    private StyleBlinker rvRectBlinker;

    private StateStyler pvRectStyler;

    private StateStyler rvRectStyler;

    @Override
    public void createPart ( final Composite parent )
    {
        this.resourceManager = new LocalResourceManager ( JFaceResources.getResources () );

        super.createPart ( parent );
    }

    @Override
    public IFigure createMain ()
    {
        final LayeredPane root = new LayeredPane ();

        final Layer figureLayer = new Layer ();
        figureLayer.setLayoutManager ( new FlowLayout () );

        final ConnectionLayer connectionLayer = new ConnectionLayer ();
        connectionLayer.setAntialias ( SWT.ON );

        final Figure figure = new Figure ();
        figureLayer.add ( figure );

        final GridLayout gridLayout = new GridLayout ( 3, true );
        gridLayout.horizontalSpacing = 50;
        gridLayout.verticalSpacing = 50;
        figure.setLayoutManager ( gridLayout );

        final Figure rpvFigure = createRPV ();
        final Figure pvFigure = createPV ();
        final Figure rmvFigure = createRMV ();
        final Figure mvFigure = createMV ();
        final Figure rvFigure = createRV ();

        figure.add ( rpvFigure, new GridData ( GridData.CENTER, GridData.CENTER, true, true, 1, 1 ) );
        figure.add ( pvFigure, new GridData ( GridData.CENTER, GridData.CENTER, true, true, 1, 2 ) );
        figure.add ( rvFigure, new GridData ( GridData.CENTER, GridData.CENTER, true, true, 1, 3 ) );

        figure.add ( rmvFigure, new GridData ( GridData.CENTER, GridData.CENTER, true, true, 1, 1 ) );

        figure.add ( mvFigure, new GridData ( GridData.CENTER, GridData.CENTER, true, true, 1, 1 ) );
        figure.add ( new Figure (), new GridData ( GridData.CENTER, GridData.CENTER, true, true, 1, 1 ) ); // placeholder

        connectionLayer.add ( this.p2rConnection = createConnection ( this.pvRect, this.rvRect ) );
        connectionLayer.add ( this.m2rConnection = createConnection ( this.mvRect, this.rvRect ) );

        connectionLayer.add ( this.rp2pConnection = createConnection ( this.rpvRect, this.pvRect ) );
        connectionLayer.add ( this.rm2pConnection = createConnection ( this.rmvRect, this.pvRect ) );

        root.add ( figureLayer );
        root.add ( connectionLayer );

        return root;
    }

    private CallbackHandler makeDisplayCallback ()
    {
        return new DisplayCallbackHandler ( this.shell, "Configure Manual Override", "Confirmation required for configuring manual override" );
    }

    private PolylineConnection createConnection ( final IFigure source, final IFigure target )
    {
        final PolylineConnection c = new PolylineConnection ();
        final ChopboxAnchor sourceAnchor = new ChopboxAnchor ( source );
        final ChopboxAnchor targetAnchor = new ChopboxAnchor ( target );
        c.setSourceAnchor ( sourceAnchor );
        c.setTargetAnchor ( targetAnchor );

        return c;
    }

    private Figure createRV ()
    {
        final Figure rvFigure = new Figure ();
        rvFigure.setLayoutManager ( new BorderLayout () );
        final Label label = new Label ( Messages.ManualOverride_ResetValue_Label );
        label.setBorder ( new MarginBorder ( 10 ) );
        rvFigure.add ( label, BorderLayout.RIGHT );

        this.rvRect = new RoundedRectangle ();
        this.rvRect.setLayoutManager ( new BorderLayout () );
        this.rvValue = new Label ();
        this.rvRect.setBackgroundColor ( ColorConstants.lightGray );
        this.rvValue.setBorder ( new MarginBorder ( 10 ) );
        this.rvRect.add ( this.rvValue, BorderLayout.CENTER );

        this.rvRectBlinker = new StyleBlinker () {

            @Override
            public void update ( final CurrentStyle style )
            {
                ManualOverride.this.rvRect.setBackgroundColor ( style.background );
                ManualOverride.this.rvRect.setForegroundColor ( style.foreground );
                ManualOverride.this.rvRect.setFont ( style.font );
            }
        };
        this.rvRectStyler = new StateStyler ( this.rvRectBlinker );

        rvFigure.add ( this.rvRect, BorderLayout.CENTER );
        return rvFigure;
    }

    private Figure createRMV ()
    {
        this.rmvFigure = new Figure ();
        this.rmvFigure.setLayoutManager ( new BorderLayout () );
        final Label label = new Label ( Messages.ManualOverride_RemoteManualvalue_Label );
        label.setBorder ( new MarginBorder ( 10 ) );
        this.rmvFigure.add ( label, BorderLayout.LEFT );

        this.rmvRect = new RoundedRectangle ();
        this.rmvRect.setLayoutManager ( new BorderLayout () );
        this.rmvValue = new Label ();
        this.rmvValue.setBorder ( new MarginBorder ( 10 ) );
        this.rmvRect.setBackgroundColor ( ColorConstants.lightGray );
        this.rmvRect.add ( this.rmvValue, BorderLayout.CENTER );

        this.rmvRect.addMouseMotionListener ( new MouseMotionListener.Stub () {

            @Override
            public void mouseEntered ( final MouseEvent me )
            {
                ManualOverride.this.rmvRect.setLineWidth ( 2 );
            }

            @Override
            public void mouseExited ( final MouseEvent me )
            {
                ManualOverride.this.rmvRect.setLineWidth ( 1 );
            }
        } );

        this.rmvRect.addMouseListener ( new MouseListener () {

            @Override
            public void mouseDoubleClicked ( final MouseEvent me )
            {
                handleSetRemoteManualValue ();
            }

            @Override
            public void mousePressed ( final MouseEvent me )
            {
                setRemoteManualState ( true );
            }

            @Override
            public void mouseReleased ( final MouseEvent me )
            {
            }
        } );

        this.rmvFigure.add ( this.rmvRect, BorderLayout.CENTER );
        return this.rmvFigure;
    }

    protected void setRemoteManualState ( final boolean state )
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ();
        attributes.put ( "remote.manual.active", Variant.valueOf ( state ) ); //$NON-NLS-1$
        writeAttributes ( attributes );
    }

    protected void handleSetRemoteManualValue ()
    {
        Variant var = null;
        try
        {
            var = this.value.getAttributes ().get ( "remote.manual.value" ); //$NON-NLS-1$
        }
        catch ( final Exception e )
        {
            var = null; //just call the editor with his default configuration
        }

        final Variant value = new VariantEntryDialog ( this.shell, var ).getValue ();
        if ( value != null )
        {
            final Map<String, Variant> attributes = new HashMap<String, Variant> ();
            attributes.put ( "remote.manual.value", value ); //$NON-NLS-1$
            writeAttributes ( attributes );
        }
    }

    private Figure createMV ()
    {
        final Figure mvFigure = new Figure ();
        mvFigure.setLayoutManager ( new BorderLayout () );
        final Label label = new Label ( Messages.ManualOverride_LocalManualValue_Label );
        label.setBorder ( new MarginBorder ( 10 ) );
        mvFigure.add ( label, BorderLayout.LEFT );

        this.mvRect = new RoundedRectangle ();
        this.mvRect.setLayoutManager ( new BorderLayout () );
        this.mvValue = new Label ();
        this.mvValue.setBorder ( new MarginBorder ( 10 ) );
        this.mvRect.setBackgroundColor ( ColorConstants.lightGray );
        this.mvRect.add ( this.mvValue, BorderLayout.CENTER );

        this.mvRect.addMouseMotionListener ( new MouseMotionListener.Stub () {

            @Override
            public void mouseEntered ( final MouseEvent me )
            {
                ManualOverride.this.mvRect.setLineWidth ( 2 );
            }

            @Override
            public void mouseExited ( final MouseEvent me )
            {
                ManualOverride.this.mvRect.setLineWidth ( 1 );
            }
        } );

        this.mvRect.addMouseListener ( new MouseListener () {

            @Override
            public void mouseDoubleClicked ( final MouseEvent me )
            {
                ManualOverride.this.manualValue = null;
                ManualOverride.this.switchToManual ();
            }

            @Override
            public void mousePressed ( final MouseEvent me )
            {
                ManualOverride.this.switchToManual ();
            }

            @Override
            public void mouseReleased ( final MouseEvent me )
            {
            }
        } );

        mvFigure.add ( this.mvRect, BorderLayout.CENTER );
        return mvFigure;
    }

    protected void switchToManual ()
    {
        if ( this.manualValue == null )
        {
            // enter manual value if we don't have one
            enterManualValue ();
            if ( this.manualValue == null )
            {
                // still have none ... abort
                return;
            }
        }

        final Map<String, Variant> attributes = new HashMap<String, Variant> ();
        attributes.put ( "org.eclipse.scada.da.manual.value", this.manualValue ); //$NON-NLS-1$
        writeAttributes ( attributes );
    }

    protected void writeAttributes ( final Map<String, Variant> attributes )
    {
        this.item.writeAtrtibutes ( attributes, null, makeDisplayCallback () );
    }

    private Figure createRPV ()
    {
        this.rpvFigure = new Figure ();
        this.rpvFigure.setLayoutManager ( new BorderLayout () );
        final Label label = new Label ( Messages.ManualOverride_RemoteProcessValue_Label );
        label.setBorder ( new MarginBorder ( 10 ) );
        this.rpvFigure.add ( label, BorderLayout.LEFT );

        this.rpvRect = new RoundedRectangle ();
        this.rpvRect.setLayoutManager ( new BorderLayout () );
        this.rpvValue = new Label ();
        this.rpvValue.setBorder ( new MarginBorder ( 10 ) );
        this.rpvRect.setBackgroundColor ( ColorConstants.lightGray );
        this.rpvRect.add ( this.rpvValue, BorderLayout.CENTER );

        this.rpvFigure.add ( this.rpvRect, BorderLayout.CENTER );

        this.rpvRect.addMouseMotionListener ( new MouseMotionListener.Stub () {

            @Override
            public void mouseEntered ( final MouseEvent me )
            {
                ManualOverride.this.rpvRect.setLineWidth ( 2 );
            }

            @Override
            public void mouseExited ( final MouseEvent me )
            {
                ManualOverride.this.rpvRect.setLineWidth ( 1 );
            }
        } );
        this.rpvRect.addMouseListener ( new MouseListener () {

            @Override
            public void mouseDoubleClicked ( final MouseEvent me )
            {
            }

            @Override
            public void mousePressed ( final MouseEvent me )
            {
                setRemoteManualState ( false );
            }

            @Override
            public void mouseReleased ( final MouseEvent me )
            {
            }
        } );

        return this.rpvFigure;
    }

    private Figure createPV ()
    {
        final Figure pvFigure = new Figure ();
        pvFigure.setLayoutManager ( new BorderLayout () );
        final Label label = new Label ( Messages.ManualOverride_ProcessValue_Label );
        label.setBorder ( new MarginBorder ( 10 ) );
        pvFigure.add ( label, BorderLayout.LEFT );

        this.pvRect = new RoundedRectangle ();
        this.pvRect.setLayoutManager ( new BorderLayout () );
        this.pvValue = new Label ();
        this.pvValue.setBorder ( new MarginBorder ( 10 ) );
        this.pvRect.setBackgroundColor ( ColorConstants.lightGray );
        this.pvRect.add ( this.pvValue, BorderLayout.CENTER );

        this.pvRectBlinker = new StyleBlinker () {

            @Override
            public void update ( final CurrentStyle style )
            {
                ManualOverride.this.pvRect.setBackgroundColor ( style.background );
                ManualOverride.this.pvRect.setForegroundColor ( style.foreground );
                ManualOverride.this.pvRect.setFont ( style.font );
            }
        };
        this.pvRectStyler = new StateStyler ( this.pvRectBlinker );

        pvFigure.add ( this.pvRect, BorderLayout.CENTER );

        this.pvRect.addMouseMotionListener ( new MouseMotionListener.Stub () {

            @Override
            public void mouseEntered ( final MouseEvent me )
            {
                ManualOverride.this.pvRect.setLineWidth ( 2 );
            }

            @Override
            public void mouseExited ( final MouseEvent me )
            {
                ManualOverride.this.pvRect.setLineWidth ( 1 );
            }
        } );
        this.pvRect.addMouseListener ( new MouseListener () {

            @Override
            public void mouseDoubleClicked ( final MouseEvent me )
            {
            }

            @Override
            public void mousePressed ( final MouseEvent me )
            {
                ManualOverride.this.switchToProcess ();
            }

            @Override
            public void mouseReleased ( final MouseEvent me )
            {
            }
        } );

        return pvFigure;
    }

    /**
     * Enter the manual value
     */
    protected void enterManualValue ()
    {
        final VariantEntryDialog dlg;
        if ( this.value != null )
        {
            dlg = new VariantEntryDialog ( this.shell, this.value.getValue () );
        }
        else
        {
            dlg = new VariantEntryDialog ( this.shell );
        }
        this.manualValue = dlg.getValue ();
    }

    protected void switchToProcess ()
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ();

        attributes.put ( "org.eclipse.scada.da.manual.value", Variant.NULL ); //$NON-NLS-1$
        this.item.writeAtrtibutes ( attributes, null, makeDisplayCallback () );
    }

    @Override
    public void dispose ()
    {
        this.pvRectStyler.dispose ();
        this.rvRectStyler.dispose ();

        this.rvRectBlinker.dispose ();
        this.pvRectBlinker.dispose ();

        this.resourceManager.dispose ();

        super.dispose ();
    }

    protected void updateRemote ()
    {
        final Boolean remoteManual = this.value.isAttribute ( "remote.manual.active" ); //$NON-NLS-1$
        final Variant remoteProcessValue = this.value.getAttributes ().get ( "remote.manual.value.original" ); //$NON-NLS-1$
        final Variant remoteManualValue = this.value.getAttributes ().get ( "remote.manual.value" ); //$NON-NLS-1$

        setRemoteVisible ( remoteManual != null );

        if ( remoteManual == null )
        {
            setConnectionState ( this.rp2pConnection, false );
            setConnectionState ( this.rm2pConnection, false );
        }
        else if ( remoteManual )
        {
            setConnectionState ( this.rp2pConnection, false );
            setConnectionState ( this.rm2pConnection, true );
        }
        else
        {
            setConnectionState ( this.rp2pConnection, true );
            setConnectionState ( this.rm2pConnection, false );
        }

        if ( remoteManualValue != null )
        {
            this.rmvValue.setText ( remoteManualValue.toString () );
        }
        if ( remoteProcessValue != null )
        {
            this.rpvValue.setText ( remoteProcessValue.toString () );
        }
    }

    private void setRemoteVisible ( final boolean visible )
    {
        this.rmvFigure.setVisible ( visible );
        this.rpvFigure.setVisible ( visible );
        this.rp2pConnection.setVisible ( visible );
        this.rm2pConnection.setVisible ( visible );
    }

    private boolean isLocalManual ()
    {
        return this.value.isAttribute ( "org.eclipse.scada.da.manual.active", false ); //$NON-NLS-1$
    }

    private boolean isRemoteManual ()
    {
        return this.value.isAttribute ( "remote.manual.active", false ); //$NON-NLS-1$
    }

    private void updateLocalManualValue ()
    {
        if ( this.manualValue == null )
        {
            this.manualValue = this.value.getAttributes ().get ( "org.eclipse.scada.da.manual.value" ); //$NON-NLS-1$
        }
    }

    @Override
    protected void update ()
    {
        super.update ();
        if ( this.value == null )
        {
            return;
        }

        updateRemote ();
        updateLocalManualValue ();

        // set result value
        this.rvValue.setText ( this.value.getValue ().toString () );

        if ( isRemoteManual () )
        {
            this.pvRectStyler.style ( new StaticStateInformation ( State.MANUAL ) );
        }
        else
        {
            this.pvRectStyler.style ( null );
        }

        if ( isManual () )
        {
            this.rvRectStyler.style ( new StaticStateInformation ( State.MANUAL ) );
        }
        else
        {
            this.rvRectStyler.style ( null );
        }

        // set manual value
        final Variant manualValue = this.value.getAttributes ().get ( "org.eclipse.scada.da.manual.value" ); //$NON-NLS-1$
        final Variant processValue = this.value.getAttributes ().get ( "org.eclipse.scada.da.manual.value.original" ); //$NON-NLS-1$
        Variant processError = this.value.getAttributes ().get ( "org.eclipse.scada.da.manual.error.original" ); //$NON-NLS-1$
        if ( processError == null )
        {
            processError = Variant.FALSE;
        }

        if ( manualValue != null )
        {
            this.mvValue.setText ( manualValue.toString () );
        }
        else
        {
            this.mvValue.setText ( Messages.ManualOverride_None );
        }

        if ( isLocalManual () )
        {
            setConnectionState ( this.p2rConnection, false );
            setConnectionState ( this.m2rConnection, true );

            // set process value
            if ( processValue != null )
            {
                this.pvValue.setText ( processValue.toString () );
            }
            else
            {
                this.pvValue.setText ( Messages.ManualOverride_None );
            }

            if ( processError.asBoolean () )
            {
                this.pvRect.setBackgroundColor ( ColorConstants.red );
            }
        }
        else
        {
            setConnectionState ( this.p2rConnection, true );
            setConnectionState ( this.m2rConnection, false );

            this.pvValue.setText ( this.value.getValue ().toString () );
        }
    }

    /**
     * Set graphics attribute according to the connection state
     * 
     * @param connection
     *            the connection to change
     * @param state
     *            the state
     */
    protected void setConnectionState ( final PolylineConnection connection, final boolean state )
    {
        final PolygonDecoration dec = new PolygonDecoration ();
        dec.setTemplate ( PolygonDecoration.TRIANGLE_TIP );

        connection.setLineStyle ( state ? Graphics.LINE_SOLID : Graphics.LINE_DOT );
        connection.setLineWidth ( state ? 2 : 1 );
        connection.setTargetDecoration ( state ? dec : null );
    }

    @Override
    protected boolean isAvailable ()
    {
        return hasAttribute ( "org.eclipse.scada.da.manual.active" );
    }

}