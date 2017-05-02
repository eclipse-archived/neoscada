/*******************************************************************************
 * Copyright (c) 2011, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - allow re-layouting, adding legend
 *******************************************************************************/
package org.eclipse.scada.chart.swt;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.scada.chart.Realm;
import org.eclipse.scada.chart.swt.render.Renderer;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.MouseWheelListener;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;

public abstract class ChartRenderer
{

    private static class RendererEntry
    {
        private final Integer order;

        private final Renderer renderer;

        private Rectangle bounds;

        public RendererEntry ( final Renderer renderer, final int order )
        {
            this.renderer = renderer;
            this.order = order;
        }

        public Integer getOrder ()
        {
            return this.order;
        }

        public Renderer getRenderer ()
        {
            return this.renderer;
        }

        public void setBounds ( final Rectangle bounds )
        {
            this.bounds = bounds;
        }

        public void render ( final Graphics g )
        {
            this.renderer.render ( g, this.bounds );
        }
    }

    public static class SizeRenderProxy implements Renderer
    {
        private Rectangle clientRectangle;

        @Override
        public void render ( final Graphics g, final Rectangle clientRectangle )
        {
        }

        @Override
        public Rectangle resize ( final ResourceManager resourceManager, final Rectangle clientRectangle )
        {
            this.clientRectangle = clientRectangle;
            return null;
        }

        public Rectangle getClientRectangle ()
        {
            return this.clientRectangle;
        }
    }

    private final List<RendererEntry> renderers = new LinkedList<RendererEntry> ();

    private boolean stale;

    private boolean updatePending;

    private boolean disposed;

    private final SizeRenderProxy clientAreaProxy;

    private Rectangle clientRectangle;

    private final Set<DisposeListener> disposeListeners = new LinkedHashSet<DisposeListener> ();

    private RGB background;

    private final ResourceManager resourceManager;

    public ChartRenderer ( final ResourceManager resourceManager )
    {
        this.resourceManager = resourceManager;
        this.clientAreaProxy = new SizeRenderProxy ();
        this.renderers.add ( new RendererEntry ( this.clientAreaProxy, 0 ) );
    }

    public void relayout ()
    {
        if ( this.stale )
        {
            this.updatePending = true;
            return;
        }

        Rectangle current = this.clientRectangle;
        for ( final RendererEntry renderer : this.renderers )
        {
            renderer.setBounds ( current );
            final Rectangle newBounds = renderer.getRenderer ().resize ( this.resourceManager, current );
            if ( newBounds != null )
            {
                current = newBounds;
            }
        }
    }

    public void resizeAll ( final Rectangle clientRectangle )
    {
        this.clientRectangle = clientRectangle;
        relayout ();
    }

    protected void checkWidget ()
    {
    }

    protected abstract void redraw ();

    public abstract Rectangle getClientArea ();

    /**
     * Get the proxy that be <q>rendered</q> just before the client area
     * 
     * @return the instance of the proxy, never <code>null</code>.
     */
    public SizeRenderProxy getClientAreaProxy ()
    {
        return this.clientAreaProxy;
    }

    public void paint ( final Graphics g )
    {
        g.setAntialias ( true );

        if ( this.background != null )
        {
            g.setBackground ( this.background );
            g.fillRectangle ( getClientArea () );
        }

        for ( final RendererEntry renderer : this.renderers )
        {
            renderer.render ( g );
        }
    }

    public void addRenderer ( final Renderer renderer )
    {
        addRenderer ( renderer, 0 );
    }

    public void addRenderer ( final Renderer renderer, final int order )
    {
        checkWidget ();

        this.renderers.add ( new RendererEntry ( renderer, order ) );

        Collections.sort ( this.renderers, new Comparator<RendererEntry> () {

            @Override
            public int compare ( final RendererEntry o1, final RendererEntry o2 )
            {
                return o1.getOrder ().compareTo ( o2.getOrder () );
            }
        } );

        resizeAll ( getClientArea () );
    }

    public void removeRenderer ( final Renderer renderer )
    {
        checkWidget ();

        final Iterator<RendererEntry> i = this.renderers.iterator ();
        while ( i.hasNext () )
        {
            final RendererEntry entry = i.next ();
            if ( entry.getRenderer ().equals ( renderer ) )
            {
                i.remove ();
            }
        }
    }

    public void refresh ()
    {
        checkWidget ();
        if ( this.stale )
        {
            this.updatePending = true;
        }
        else
        {
            redraw ();
        }
    }

    public void setStale ( final boolean stale )
    {
        setStale ( stale, false );
    }

    public void setStale ( final boolean stale, final boolean forceUpdate )
    {
        checkWidget ();
        this.stale = stale;
        if ( !stale && ( this.updatePending || forceUpdate ) )
        {
            this.updatePending = false;
            relayout ();
            redraw ();
        }
    }

    public void dispose ()
    {
        checkWidget ();

        if ( this.disposed )
        {
            return;
        }

        this.disposed = true;

        for ( final DisposeListener listener : this.disposeListeners )
        {
            SafeRunnable.getRunner ().run ( new SafeRunnable () {
                @Override
                public void run () throws Exception
                {
                    listener.onDispose ();
                };
            } );
        }

        this.resourceManager.dispose ();
    }

    public void addDisposeListener ( final DisposeListener disposeListener )
    {
        checkWidget ();
        this.disposeListeners.add ( disposeListener );
    }

    public abstract void addMouseListener ( ChartMouseListener mouseListener );

    public abstract void removeMouseListener ( ChartMouseListener mouseListener );

    public abstract void addMouseMoveListener ( ChartMouseMoveListener mouseMoveListener );

    public abstract void removeMouseMoveListener ( ChartMouseMoveListener mouseMoveListener );

    public abstract void addMouseWheelListener ( MouseWheelListener listener );

    public abstract void removeMouseWheelListener ( MouseWheelListener listener );

    public boolean isDisposed ()
    {
        return this.disposed;
    }

    public abstract Realm getRealm ();

    public void setChartBackground ( final RGB background )
    {
        this.background = background;
    }

    public RGB getChartBackground ()
    {
        return this.background;
    }

    public void setFocus ()
    {
    }

    public DropTarget createDropTarget ( final Transfer[] transfers, final DropTargetAdapter createDropTarget )
    {
        return null;
    }
}
