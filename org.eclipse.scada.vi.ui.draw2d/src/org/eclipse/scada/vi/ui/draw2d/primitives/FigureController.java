/*******************************************************************************
 * Copyright (c) 2011, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - fix some bugs with border parser, add mouse
 *          motion events, fix bug 437536
 *******************************************************************************/
package org.eclipse.scada.vi.ui.draw2d.primitives;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.CompoundBorder;
import org.eclipse.draw2d.GroupBoxBorder;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.TitleBarBorder;
import org.eclipse.draw2d.geometry.PrecisionDimension;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.ui.blink.AbstractBlinker;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.eclipse.scada.utils.script.ScriptExecutor;
import org.eclipse.scada.vi.model.Cursor;
import org.eclipse.scada.vi.model.Dimension;
import org.eclipse.scada.vi.model.Figure;
import org.eclipse.scada.vi.model.SystemCursor;
import org.eclipse.scada.vi.model.VisualInterfaceFactory;
import org.eclipse.scada.vi.ui.draw2d.Activator;
import org.eclipse.scada.vi.ui.draw2d.Controller;
import org.eclipse.scada.vi.ui.draw2d.SymbolController;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.statushandlers.StatusManager;

/**
 * A figure controller
 * <p>
 * This figure controller needs to know when the figure it controls was added or
 * removed. Since draw2d does not provide a "addRemovedListener" for IFigure but
 * a {@link IFigure#removeNotify()} that can be overridden it is the
 * responsibility of the implementing controller to call {@link #start()} and
 * {@link #stop()} when the implementing {@link IFigure#addNotify()} and
 * {@link IFigure#removeNotify()} get called. So create your figure like the
 * following snippet shows: <code><pre>
IFigure figure = new PolylineShape () {
    public void addNotify () {
        super.addNotify ();
        start (); // FigureController.start ();
    }

    public void removeNotify () {
        stop (); // FigureController.stop ();
        super.removeNotify ();
    }
};
 * </pre></code>
 * </p>
 *
 * @author Jens Reimann
 */
public abstract class FigureController implements Controller
{

    private class ClickHandlerImpl extends MouseListener.Stub
    {
        @Override
        public void mouseReleased ( final MouseEvent me )
        {
            handleOnClick ( me );
        }

        @Override
        public void mouseDoubleClicked ( final MouseEvent me )
        {
            handleOnDoubleClick ( me );
        }
    }

    private class MotionHandlerImpl implements MouseMotionListener
    {

        @Override
        public void mouseDragged ( final MouseEvent me )
        {
            handleMouseDragged ( me );
        }

        @Override
        public void mouseEntered ( final MouseEvent me )
        {
            handleMouseEntered ( me );
        }

        @Override
        public void mouseExited ( final MouseEvent me )
        {
            handleMouseExited ( me );
        }

        @Override
        public void mouseHover ( final MouseEvent me )
        {
            handleMouseHover ( me );
        }

        @Override
        public void mouseMoved ( final MouseEvent me )
        {
            handleMouseMoved ( me );
        }

    }

    private static interface ColorApplier
    {
        public void applyColor ( IFigure figure, Color color );
    }

    private static class ForegroundApplier implements ColorApplier
    {
        @Override
        public void applyColor ( final IFigure figure, final Color color )
        {
            figure.setForegroundColor ( color );
        }
    }

    private static class BackgroundApplier implements ColorApplier
    {
        @Override
        public void applyColor ( final IFigure figure, final Color color )
        {
            figure.setBackgroundColor ( color );
        }
    }

    private static interface ColorHandler
    {
        public void start ();

        public void stop ();
    }

    private static class DefaultColor implements ColorHandler
    {
        private final IFigure figure;

        private final ColorApplier applier;

        public DefaultColor ( final IFigure figure, final ColorApplier applier )
        {
            this.figure = figure;
            this.applier = applier;
        }

        @Override
        public void start ()
        {
            this.applier.applyColor ( this.figure, null );
        }

        @Override
        public void stop ()
        {
            // nothing to do
        }
    }

    private static class StaticColor implements ColorHandler
    {
        private final IFigure figure;

        private final ColorApplier applier;

        private final Color color;

        public StaticColor ( final IFigure figure, final ColorApplier applier, final Color color )
        {
            this.figure = figure;
            this.applier = applier;
            this.color = color;
        }

        @Override
        public void start ()
        {
            this.applier.applyColor ( this.figure, this.color );
        }

        @Override
        public void stop ()
        {
            // nothing to do
        }
    }

    private static class BlinkingColor extends AbstractBlinker implements ColorHandler
    {
        private final IFigure figure;

        private final ColorApplier applier;

        private final Color[] colors;

        public BlinkingColor ( final IFigure figure, final ColorApplier applier, final Color[] colors )
        {
            this.figure = figure;
            this.applier = applier;
            this.colors = colors;
        }

        @Override
        public void start ()
        {
            enableBlinking ( true );
        }

        @Override
        public void stop ()
        {
            enableBlinking ( false );
            super.dispose ();
        }

        @Override
        public void toggle ( final int globalCounter )
        {
            if ( this.colors == null || this.colors.length == 0 )
            {
                this.applier.applyColor ( this.figure, null );
            }
            else
            {
                this.applier.applyColor ( this.figure, this.colors[globalCounter % this.colors.length] );
            }
        }
    }

    protected final ResourceManager manager;

    private final SymbolController controller;

    private ScriptExecutor onClick;

    private ScriptExecutor onDoubleClick;

    private final Map<Object, ColorHandler> colorHandler = new HashMap<Object, FigureController.ColorHandler> ();

    private boolean started;

    private ScriptExecutor onMouseEnter;

    private ScriptExecutor onMouseExit;

    private ScriptExecutor onMouseMove;

    private ScriptExecutor onMouseHover;

    private ScriptExecutor onMouseDrag;

    public FigureController ( final SymbolController controller, final ResourceManager manager )
    {
        this.manager = manager;
        this.controller = controller;
    }

    /**
     * Get the figure that is used for controlling the properties of this
     * controller.
     * <p>
     * The figure returned is by default the same as the {@link #getFigure()}.
     * But in some cases it might be necessary to return a different figure.
     * </p>
     *
     * @return the figure that should the attributes applied
     */
    protected abstract IFigure getPropertyFigure ();

    @Override
    public IFigure getFigure ()
    {
        return getPropertyFigure ();
    }

    protected void applyCommon ( final Figure figure )
    {
        setBorder ( figure.getBorder () );
        setBackgroundColor ( figure.getBackgroundColor () );
        setForegroundColor ( figure.getForegroundColor () );

        setPreferredSize ( create ( figure.getSize () ) );

        setCursor ( convert ( figure.getCursor () ) );
        setVisible ( figure.isVisible () );
        setOpaque ( figure.getOpaque () );
        setToolTip ( figure.getToolTip () );

        try
        {
            this.onClick = this.controller.createScriptExecutor ( figure.getOnClick (), "onClick" );
            this.onDoubleClick = this.controller.createScriptExecutor ( figure.getOnDoubleClick (), "onDoubleClick" );
            this.onMouseEnter = this.controller.createScriptExecutor ( figure.getOnMouseIn (), "onMouseIn" );
            this.onMouseExit = this.controller.createScriptExecutor ( figure.getOnMouseOut (), "onMouseOut" );
            this.onMouseMove = this.controller.createScriptExecutor ( figure.getOnMouseMove (), "onMouseMove" );
            this.onMouseHover = this.controller.createScriptExecutor ( figure.getOnMouseHover (), "onMouseHover" );
            this.onMouseDrag = this.controller.createScriptExecutor ( figure.getOnMouseDrag (), "onMouseDrag" );
        }
        catch ( final Exception e )
        {
            throw new RuntimeException ( "Failed to initialize", e ); //$NON-NLS-1$
        }

        if ( this.onClick != null || this.onDoubleClick != null )
        {
            getPropertyFigure ().addMouseListener ( new ClickHandlerImpl () );
        }
        if ( this.onMouseEnter != null || this.onMouseExit != null || this.onMouseMove != null || this.onMouseHover != null || this.onMouseDrag != null )
        {
            getPropertyFigure ().addMouseMotionListener ( new MotionHandlerImpl () );
        }
    }

    public void setToolTip ( final String string )
    {
        if ( string == null || string.isEmpty () )
        {
            getPropertyFigure ().setToolTip ( null );
        }
        else
        {
            getPropertyFigure ().setToolTip ( new Label ( string ) );
        }
    }

    /**
     * Set a cursor for the figure <br/>
     * The name of the cursor must be one of the {@link SWTCursors} enum.
     *
     * @param cursor
     *            the name of the cursor
     */
    public void setCursor ( final String cursor )
    {
        getPropertyFigure ().setCursor ( getCursor ( cursor ) );
    }

    public static enum SWTCursors
    {
        ARROW ( SWT.CURSOR_ARROW ),
        HAND ( SWT.CURSOR_HAND ),
        HELP ( SWT.CURSOR_HELP ),
        WAIT ( SWT.CURSOR_WAIT ),
        CROSS ( SWT.CURSOR_CROSS ),
        IBEAM ( SWT.CURSOR_IBEAM ),
        NO ( SWT.CURSOR_NO );

        private int id;

        private SWTCursors ( final int id )
        {
            this.id = id;
        }

        public int id ()
        {
            return this.id;
        }
    }

    protected org.eclipse.swt.graphics.Cursor getCursor ( final String cursor )
    {
        try
        {
            final SWTCursors cursorValue = SWTCursors.valueOf ( cursor );
            return Display.getDefault ().getSystemCursor ( cursorValue.id () );
        }
        catch ( final Exception e )
        {
            // TODO: try to load as resource instead
            return null;
        }
    }

    private String convert ( final Cursor cursor )
    {
        if ( cursor instanceof SystemCursor )
        {
            return ( (SystemCursor)cursor ).getType ().toString ();
        }
        return null;
    }

    private void fireScriptEvent ( final ScriptExecutor script, final Object event, final String eventName )
    {
        this.controller.debugLog ( String.format ( "%s: %s", eventName, event ) ); //$NON-NLS-1$

        final Map<String, Object> scriptObjects = new LinkedHashMap<String, Object> ( 1 );
        scriptObjects.put ( "event", event ); //$NON-NLS-1$
        try
        {
            this.controller.execute ( script, scriptObjects );
        }
        catch ( final Exception e )
        {
            this.controller.errorLog ( "Failed to handle event: " + eventName, e ); //$NON-NLS-1$
            if ( !Boolean.getBoolean ( "org.eclipse.scada.vi.ui.draw2d.suppressErrors" ) ) //$NON-NLS-1$
            {
                StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, "Failed to handle event", e ), StatusManager.SHOW );
            }
        }
    }

    protected void handleOnDoubleClick ( final MouseEvent me )
    {
        fireScriptEvent ( this.onDoubleClick, me, "Double click" ); //$NON-NLS-1$
    }

    protected void handleOnClick ( final MouseEvent me )
    {
        fireScriptEvent ( this.onClick, me, "Click" ); //$NON-NLS-1$
    }

    public void handleMouseMoved ( final MouseEvent me )
    {
        fireScriptEvent ( this.onMouseMove, me, "Mouse move" ); //$NON-NLS-1$
    }

    public void handleMouseHover ( final MouseEvent me )
    {
        fireScriptEvent ( this.onMouseHover, me, "Mouse hover" ); //$NON-NLS-1$
    }

    public void handleMouseExited ( final MouseEvent me )
    {
        fireScriptEvent ( this.onMouseExit, me, "Mouse exited" ); //$NON-NLS-1$
    }

    public void handleMouseEntered ( final MouseEvent me )
    {
        fireScriptEvent ( this.onMouseEnter, me, "Mouse entered" ); //$NON-NLS-1$
    }

    public void handleMouseDragged ( final MouseEvent me )
    {
        fireScriptEvent ( this.onMouseDrag, me, "Mouse dragged" ); //$NON-NLS-1$
    }

    public void setPreferredSize ( final double width, final double height )
    {
        setPreferredSize ( new PrecisionDimension ( width, height ) );
    }

    public void setPreferredSize ( final org.eclipse.draw2d.geometry.Dimension size )
    {
        getPropertyFigure ().setPreferredSize ( size );
    }

    public void setSize ( final org.eclipse.draw2d.geometry.Dimension size )
    {
        if ( size != null )
        {
            getPropertyFigure ().setSize ( size );
        }
    }

    public void setSize ( final double width, final double height )
    {
        final Rectangle b = getPropertyFigure ().getBounds ();

        getPropertyFigure ().setBounds ( new PrecisionRectangle ( b.preciseX (), b.preciseY (), width, height ) );
    }

    public void setWidth ( final double width )
    {
        final Rectangle b = getPropertyFigure ().getBounds ();

        getPropertyFigure ().setBounds ( new PrecisionRectangle ( b.preciseX (), b.preciseY (), width, b.preciseHeight () ) );
    }

    public void setHeight ( final double height )
    {
        final Rectangle b = getPropertyFigure ().getBounds ();

        getPropertyFigure ().setBounds ( new PrecisionRectangle ( b.preciseX (), b.preciseY (), b.preciseWidth (), height ) );
    }

    public Dimension getPreferredSize ()
    {
        final Dimension dimension = VisualInterfaceFactory.eINSTANCE.createDimension ();
        final org.eclipse.draw2d.geometry.Dimension size = getPropertyFigure ().getPreferredSize ();
        dimension.setHeight ( size.preciseWidth () );
        dimension.setWidth ( size.preciseWidth () );
        return dimension;
    }

    public void setPreferredWidth ( final double value )
    {
        final PrecisionDimension dim = new PrecisionDimension ();
        dim.setPreciseWidth ( value );
        dim.setPreciseHeight ( getPropertyFigure ().getPreferredSize ().preciseHeight () );

        getPropertyFigure ().setPreferredSize ( dim );
    }

    public void setPreferredHeight ( final double value )
    {
        final PrecisionDimension dim = new PrecisionDimension ();
        dim.setPreciseWidth ( getPropertyFigure ().getPreferredSize ().preciseWidth () );
        dim.setPreciseHeight ( value );

        getPropertyFigure ().setPreferredSize ( dim );
    }

    public void setBorder ( final String border )
    {
        getPropertyFigure ().setBorder ( makeBorder ( border ) );
    }

    public void setBackgroundColor ( final String color )
    {
        final ColorHandler colorHandler = makeColorHandler ( color, new BackgroundApplier () );
        setColor ( "backgroundColor", colorHandler ); //$NON-NLS-1$
    }

    public void setForegroundColor ( final String color )
    {
        final ColorHandler colorHandler = makeColorHandler ( color, new ForegroundApplier () );
        setColor ( "foregroundColor", colorHandler ); //$NON-NLS-1$
    }

    protected void setColor ( final Object key, final ColorHandler colorHandler )
    {
        final ColorHandler oldColorHandler = this.colorHandler.put ( key, colorHandler );
        if ( oldColorHandler != null )
        {
            // dispose
            oldColorHandler.stop ();
        }

        // we are started, so start the color
        if ( this.started )
        {
            colorHandler.start ();
        }
    }

    public void start ()
    {
        if ( this.started )
        {
            return;
        }
        this.started = true;

        // start all colors
        for ( final ColorHandler color : this.colorHandler.values () )
        {
            color.start ();
        }
    }

    public void stop ()
    {
        if ( !this.started )
        {
            return;
        }
        this.started = false;

        // stop all colors
        for ( final ColorHandler color : this.colorHandler.values () )
        {
            color.stop ();
        }
    }

    public void setVisible ( final boolean flag )
    {
        getPropertyFigure ().setVisible ( flag );
    }

    public abstract void setOpaque ( final Boolean flag );

    protected void setOpaque ( final Boolean flag, final boolean defaultValue )
    {
        if ( flag == null )
        {
            getPropertyFigure ().setOpaque ( defaultValue );
        }
        else
        {
            getPropertyFigure ().setOpaque ( flag );
        }
    }

    /**
     * Create a new border
     * <p>
     *
     * <pre>
     * 3
     * GROUP:x
     * COMPOUND:[GROUP:2|GROUP:3]
     * </pre>
     *
     * </p>
     *
     * @param border
     * @return a new border
     */
    protected Border makeBorder ( final String border )
    {
        if ( border == null || border.isEmpty () )
        {
            return null;
        }

        if ( border.matches ( "[0-9]+" ) ) //$NON-NLS-1$
        {
            return new LineBorder ( Integer.parseInt ( border ) );
        }

        if ( border.startsWith ( "LINE:" ) ) //$NON-NLS-1$
        {
            final Map<String, String> args = parseBorderArguments ( "lineWidth", border.substring ( "LINE:".length () ) ); //$NON-NLS-1$ //$NON-NLS-2$
            final LineBorder lineBorder = new LineBorder ();
            if ( args.containsKey ( "lineWidth" ) ) //$NON-NLS-1$
            {
                lineBorder.setWidth ( Integer.parseInt ( args.get ( "lineWidth" ) ) ); //$NON-NLS-1$
            }
            lineBorder.setColor ( createColor ( Helper.makeColor ( args.get ( "color" ) ) ) ); //$NON-NLS-1$

            return lineBorder;
        }
        if ( border.startsWith ( "GROUP:" ) ) //$NON-NLS-1$
        {
            final GroupBoxBorder groupBorder = new GroupBoxBorder ();

            final Map<String, String> args = parseBorderArguments ( "text", border.substring ( "GROUP:".length () ) ); //$NON-NLS-1$ //$NON-NLS-2$
            if ( args.containsKey ( "text" ) ) //$NON-NLS-1$
            {
                groupBorder.setLabel ( args.get ( "text" ) ); //$NON-NLS-1$
            }
            final Color color = createColor ( Helper.makeColor ( args.get ( "textColor" ) ) ); //$NON-NLS-1$
            if ( color != null )
            {
                groupBorder.setTextColor ( color );
            }

            return groupBorder;
        }
        if ( border.startsWith ( "TITLE:" ) ) //$NON-NLS-1$
        {
            final TitleBarBorder titleBorder = new TitleBarBorder ();

            final Map<String, String> args = parseBorderArguments ( "text", border.substring ( "TITLE:".length () ) ); //$NON-NLS-1$ //$NON-NLS-2$
            if ( args.containsKey ( "text" ) ) //$NON-NLS-1$
            {
                titleBorder.setLabel ( args.get ( "text" ) ); //$NON-NLS-1$
            }
            final Color color = createColor ( Helper.makeColor ( args.get ( "textColor" ) ) ); //$NON-NLS-1$
            if ( color != null )
            {
                titleBorder.setTextColor ( color );
            }
            final Color backgroundColor = createColor ( Helper.makeColor ( args.get ( "backgroundColor" ) ) ); //$NON-NLS-1$
            if ( backgroundColor != null )
            {
                titleBorder.setBackgroundColor ( backgroundColor );
            }

            return titleBorder;
        }
        if ( border.startsWith ( "MARGIN:" ) ) //$NON-NLS-1$
        {
            final Map<String, String> args = parseBorderArguments ( "inset", border.substring ( "MARGIN:".length () ) ); //$NON-NLS-1$ //$NON-NLS-2$
            if ( args.containsKey ( "inset" ) ) //$NON-NLS-1$
            {
                final String value = args.get ( "inset" ); //$NON-NLS-1$
                if ( value.contains ( "," ) ) //$NON-NLS-1$
                {
                    final String[] insets = args.get ( "inset" ).split ( ", ?" ); //$NON-NLS-1$ //$NON-NLS-2$
                    return new MarginBorder ( Integer.parseInt ( insets[0] ), Integer.parseInt ( insets[1] ), Integer.parseInt ( insets[2] ), Integer.parseInt ( insets[3] ) );
                }
                else
                {
                    return new MarginBorder ( Integer.parseInt ( args.get ( "inset" ) ) ); //$NON-NLS-1$
                }
            }
            else if ( args.containsKey ( "t" ) || args.containsKey ( "l" ) || args.containsKey ( "r" ) || args.containsKey ( "b" ) ) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
            {
                return new MarginBorder ( makeInt ( args, "t", 0 ), makeInt ( args, "l", 0 ), makeInt ( args, "b", 0 ), makeInt ( args, "r", 0 ) ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
            }
            else
            {
                return new MarginBorder ( 0 );
            }
        }
        if ( border.startsWith ( "COMPOUND:" ) ) //$NON-NLS-1$
        {
            final Map<String, String> args = parseBorderArguments ( "", border.substring ( "COMPOUND:".length () ) ); //$NON-NLS-1$ //$NON-NLS-2$
            return new CompoundBorder ( makeBorder ( args.get ( "outer" ) ), makeBorder ( args.get ( "inner" ) ) ); //$NON-NLS-1$ //$NON-NLS-2$
        }

        StatusManager.getManager ().handle ( new Status ( IStatus.WARNING, Activator.PLUGIN_ID, "Invalid border string: " + border ), StatusManager.LOG );
        return null;
    }

    private int makeInt ( final Map<String, String> args, final String string, final int defaultValue )
    {
        final String value = args.get ( string );
        if ( value == null || value.isEmpty () )
        {
            return defaultValue;
        }
        return Integer.parseInt ( value );
    }

    protected static Map<String, String> parseBorderArguments ( final String singleArgumentName, final String border )
    {
        if ( border == null || border.isEmpty () )
        {
            return Collections.emptyMap ();
        }
        if ( border.startsWith ( "[" ) && border.endsWith ( "]" ) ) //$NON-NLS-1$ //$NON-NLS-2$
        {
            final Map<String, String> result = new LinkedHashMap<String, String> ();
            final String str = border.substring ( 1, border.length () - 1 );

            String key = null;
            StringBuilder temp = null;

            int levels = 0;

            for ( int i = 0; i < str.length (); i++ )
            {
                final char c = str.charAt ( i );
                switch ( c )
                {
                    case '[':
                        temp = add ( temp, c );
                        levels++;
                        break;
                    case ']':
                        temp = add ( temp, c );
                        levels--;
                        break;
                    case '=':
                        if ( levels == 0 )
                        {
                            if ( key == null )
                            {
                                key = temp != null ? temp.toString () : ""; //$NON-NLS-1$
                                temp = null;
                            }
                            else
                            {
                                temp = add ( temp, c );
                            }
                        }
                        else
                        {
                            temp = add ( temp, c );
                        }
                        break;
                    case ',':
                        if ( levels == 0 )
                        {
                            if ( key != null && temp != null )
                            {
                                result.put ( key, temp.toString () );
                            }
                            key = null;
                            temp = null;
                        }
                        else
                        {
                            temp = add ( temp, c );
                        }
                        break;
                    default:
                        temp = add ( temp, c );
                        break;
                }
            }

            if ( levels > 0 )
            {
                throw new IllegalArgumentException ( "Unbalanced brackets" );
            }

            // the end
            if ( key != null && temp != null )
            {
                result.put ( key, temp.toString () );
            }

            return result;
        }
        else
        {
            final Map<String, String> result = new LinkedHashMap<String, String> ( 1 );
            result.put ( singleArgumentName, border );
            return result;
        }
    }

    private static StringBuilder add ( final StringBuilder temp, final char c )
    {
        if ( temp == null )
        {
            return new StringBuilder ().append ( c );
        }
        else
        {
            temp.append ( c );
            return temp;
        }
    }

    protected org.eclipse.draw2d.geometry.Dimension create ( final Dimension dimension )
    {
        if ( dimension == null )
        {
            return null;
        }
        return new PrecisionDimension ( dimension.getWidth (), dimension.getHeight () );
    }

    protected ColorHandler makeColorHandler ( final String color, final ColorApplier applier )
    {
        if ( color == null || color.isEmpty () )
        {
            return new DefaultColor ( getPropertyFigure (), applier );
        }

        if ( color.startsWith ( "#" ) && !color.contains ( "|" ) ) //$NON-NLS-1$ //$NON-NLS-2$
        {
            return new StaticColor ( getPropertyFigure (), applier, createColor ( Helper.makeColor ( color ) ) );
        }
        else if ( ( color.startsWith ( "#" ) || color.startsWith ( "|" ) ) && color.contains ( "|" ) ) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        {
            final String tok[] = color.split ( "\\|", -1 ); //$NON-NLS-1$

            final Color[] colors = new Color[tok.length];
            int i = 0;
            for ( final String colorString : tok )
            {
                colors[i] = createColor ( Helper.makeColor ( colorString ) );
                i++;
            }
            return new BlinkingColor ( getPropertyFigure (), applier, colors );
        }
        return new DefaultColor ( getPropertyFigure (), applier );
    }

    protected Color createColor ( final RGB rgb )
    {
        if ( rgb == null )
        {
            return null;
        }
        return this.manager.createColor ( rgb );
    }

}
