/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *     IBH SYSTEMS GmbH - additional work, stale initial update
 *     IBH SYSTEMS GmbH - bug fixes and extensions, enhancements for legends
 *******************************************************************************/
package org.eclipse.scada.ui.chart.viewer;

import java.util.Calendar;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.databinding.AggregateValidationStatus;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.scada.chart.Realm;
import org.eclipse.scada.chart.swt.ChartMouseListener.MouseState;
import org.eclipse.scada.chart.swt.ChartRenderer;
import org.eclipse.scada.chart.swt.DisplayRealm;
import org.eclipse.scada.chart.swt.DisposeListener;
import org.eclipse.scada.chart.swt.controller.MouseHover;
import org.eclipse.scada.chart.swt.controller.MouseHover.Listener;
import org.eclipse.scada.chart.swt.render.CurrentTimeRuler;
import org.eclipse.scada.chart.swt.render.TitleRenderer;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.scada.ui.chart.model.ArchiveSeries;
import org.eclipse.scada.ui.chart.model.Chart;
import org.eclipse.scada.ui.chart.model.ChartFactory;
import org.eclipse.scada.ui.chart.model.ChartPackage;
import org.eclipse.scada.ui.chart.model.DataItemSeries;
import org.eclipse.scada.ui.chart.model.IdItem;
import org.eclipse.scada.ui.chart.model.UriItem;
import org.eclipse.scada.ui.chart.model.XAxis;
import org.eclipse.scada.ui.chart.model.YAxis;
import org.eclipse.scada.ui.chart.viewer.controller.ControllerManager;
import org.eclipse.scada.ui.chart.viewer.input.ChartInput;
import org.eclipse.scada.ui.chart.viewer.profile.ProfileManager;
import org.eclipse.scada.ui.utils.AbstractSelectionProvider;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChartViewer extends AbstractSelectionProvider
{
    private final static Logger logger = LoggerFactory.getLogger ( ChartViewer.class );

    private final ChartRenderer manager;

    private final WritableList items = new WritableList ( new LinkedList<Object> (), ChartInput.class );

    private final IObservableList unmodItems = Observables.unmodifiableObservableList ( this.items );

    private CurrentTimeRuler timeRuler;

    private ChartInput selection;

    private final Chart chart;

    private final DataBindingContext ctx;

    private final ResourceManager resourceManager;

    private final YAxisManager leftManager;

    private final YAxisManager rightManager;

    private final XAxisManager topManager;

    private final XAxisManager bottomManager;

    private XAxisViewer selectedXAxis;

    private YAxisViewer selectedYAxis;

    private boolean showTimeRuler;

    private final Realm realm;

    private final SimpleAxisLocator<XAxis, XAxisViewer> xLocator;

    private final SimpleAxisLocator<YAxis, YAxisViewer> yLocator;

    private final InputManager inputManager;

    private YAxis selectedYAxisElement;

    private XAxis selectedXAxisElement;

    private final Set<ChartViewerListener> listeners = new LinkedHashSet<ChartViewerListener> ();

    private boolean mutable;

    private boolean hoverable;

    private final MouseHover.Listener hoverListener = new Listener () {

        @Override
        public void mouseMove ( final MouseState e, final long timestamp )
        {
            // no-op
        }
    };

    private MouseHover mouseHover;

    private final ControllerManager controllerManager;

    private final ProfileManager profileManager;

    private final ChartContext chartContext;

    private TitleRenderer titleRenderer;

    private Display display;

    public ChartViewer ( final Display display, final ChartRenderer chartRenderer, final Chart chart, final ExtensionSpaceProvider extensionSpaceProvider, final ResetHandler resetHandler )
    {
        this.chart = chart;
        this.display = display;

        this.resourceManager = new LocalResourceManager ( JFaceResources.getResources ( this.display ) );

        this.ctx = new DataBindingContext ( SWTObservables.getRealm ( this.display ) );

        final AggregateValidationStatus status = new AggregateValidationStatus ( this.ctx, AggregateValidationStatus.MERGED );
        status.addValueChangeListener ( new IValueChangeListener () {

            @Override
            public void handleValueChange ( final ValueChangeEvent event )
            {
                if ( event.diff.getNewValue () == null )
                {
                    return;
                }

                final Status value = (Status)event.diff.getNewValue ();
                if ( value.isOK () || value.getException () == null )
                {
                    return;
                }

                logger.warn ( "Changed", value.getException () );
            }
        } );

        // create content

        this.manager = chartRenderer;

        this.manager.setStale ( true );
        this.realm = new DisplayRealm ( this.display );

        this.manager.createDropTarget ( new Transfer[] { LocalSelectionTransfer.getTransfer () }, createDropTarget () );

        this.titleRenderer = new TitleRenderer ( this.manager );
        this.manager.addRenderer ( this.titleRenderer, -100 );

        this.leftManager = new YAxisManager ( this.ctx, this.manager, true );
        this.ctx.bindList ( this.leftManager.getList (), EMFObservables.observeList ( chart, ChartPackage.Literals.CHART__LEFT ) );
        this.rightManager = new YAxisManager ( this.ctx, this.manager, false );
        this.ctx.bindList ( this.rightManager.getList (), EMFObservables.observeList ( chart, ChartPackage.Literals.CHART__RIGHT ) );

        this.topManager = new XAxisManager ( this.ctx, this.manager, true );
        this.ctx.bindList ( this.topManager.getList (), EMFObservables.observeList ( chart, ChartPackage.Literals.CHART__TOP ) );
        this.bottomManager = new XAxisManager ( this.ctx, this.manager, false );
        this.ctx.bindList ( this.bottomManager.getList (), EMFObservables.observeList ( chart, ChartPackage.Literals.CHART__BOTTOM ) );

        this.xLocator = new SimpleAxisLocator<XAxis, XAxisViewer> ( this.topManager, this.bottomManager );
        this.yLocator = new SimpleAxisLocator<YAxis, YAxisViewer> ( this.leftManager, this.rightManager );

        this.inputManager = new InputManager ( this.ctx, this, this.resourceManager, this.xLocator, this.yLocator );
        this.ctx.bindList ( this.inputManager.getList (), EMFObservables.observeList ( chart, ChartPackage.Literals.CHART__INPUTS ) );

        this.ctx.bindValue ( PojoObservables.observeValue ( this.titleRenderer, "title" ), EMFObservables.observeValue ( this.chart, ChartPackage.Literals.CHART__TITLE ) ); //$NON-NLS-1$

        this.ctx.bindValue ( PojoObservables.observeValue ( this, "showCurrentTimeRuler" ), EMFObservables.observeValue ( this.chart, ChartPackage.Literals.CHART__SHOW_CURRENT_TIME_RULER ) ); //$NON-NLS-1$
        this.ctx.bindValue ( PojoObservables.observeValue ( this, "mutable" ), EMFObservables.observeValue ( this.chart, ChartPackage.Literals.CHART__MUTABLE ) ); //$NON-NLS-1$
        this.ctx.bindValue ( PojoObservables.observeValue ( this, "hoverable" ), EMFObservables.observeValue ( this.chart, ChartPackage.Literals.CHART__HOVERABLE ) ); //$NON-NLS-1$
        this.ctx.bindValue ( PojoObservables.observeValue ( this, "chartBackground" ), EMFObservables.observeValue ( this.chart, ChartPackage.Literals.CHART__BACKGROUND_COLOR ) ); //$NON-NLS-1$

        this.ctx.bindValue ( PojoObservables.observeValue ( this, "selectedXAxis" ), EMFObservables.observeValue ( this.chart, ChartPackage.Literals.CHART__SELECTED_XAXIS ) ); //$NON-NLS-1$
        this.ctx.bindValue ( PojoObservables.observeValue ( this, "selectedYAxis" ), EMFObservables.observeValue ( this.chart, ChartPackage.Literals.CHART__SELECTED_YAXIS ) ); //$NON-NLS-1$

        this.chartContext = new ChartContextImpl ( this.xLocator, this.yLocator, extensionSpaceProvider, chartRenderer, chart, resetHandler, this.unmodItems );

        this.controllerManager = new ControllerManager ( this.ctx, this.ctx.getValidationRealm (), this.chartContext );
        this.ctx.bindList ( this.controllerManager.getList (), EMFObservables.observeList ( chart, ChartPackage.Literals.CHART__CONTROLLERS ) );

        this.profileManager = new ProfileManager ( this.ctx, this.ctx.getValidationRealm (), extensionSpaceProvider, this.chartContext );
        this.ctx.bindList ( this.profileManager.getList (), EMFObservables.observeList ( chart, ChartPackage.Literals.CHART__PROFILES ) );
        this.ctx.bindValue ( PojoObservables.observeValue ( this.profileManager, "type" ), EMFObservables.observeValue ( chart, ChartPackage.Literals.CHART__PROFILE_SWITCHER_TYPE ) ); //$NON-NLS-1$
        this.ctx.bindValue ( PojoObservables.observeValue ( this.profileManager, "activeProfile" ), EMFObservables.observeValue ( chart, ChartPackage.Literals.CHART__ACTIVE_PROFILE ) ); //$NON-NLS-1$

        this.manager.setStale ( false );

        startTimer ();

        this.manager.addDisposeListener ( new DisposeListener () {

            @Override
            public void onDispose ()
            {
                handleDispose ();
            }
        } );

        setSelection ( new StructuredSelection ( this ) );
        updateState ();
    }

    public boolean isHoverable ()
    {
        return this.hoverable;
    }

    public void setHoverable ( final boolean hoverable )
    {
        this.hoverable = hoverable;
        updateState ();
    }

    public ChartRenderer getChartRenderer ()
    {
        return this.manager;
    }

    protected void handleMouseMove ( final MouseEvent e, final long timestamp )
    {
        setInputSelection ( timestamp );
    }

    private void setInputSelection ( final long timestamp )
    {
        final Calendar c = Calendar.getInstance ();
        c.setTimeInMillis ( timestamp );
        for ( final Object input : this.items )
        {
            ( (ChartInput)input ).setSelection ( c );
        }
    }

    public void setMutable ( final boolean mutable )
    {
        this.mutable = mutable;
    }

    public boolean isMutable ()
    {
        return this.mutable;
    }

    public void addChartViewerListener ( final ChartViewerListener chartViewerListener )
    {
        this.listeners.add ( chartViewerListener );
    }

    public void removeChartViewerListener ( final ChartViewerListener chartViewerListener )
    {
        this.listeners.remove ( chartViewerListener );
    }

    private void fireInputAdded ( final ChartInput input )
    {
        for ( final ChartViewerListener listener : this.listeners )
        {
            SafeRunner.run ( new SafeRunnable () {

                @Override
                public void run () throws Exception
                {
                    listener.inputAdded ( input );
                }
            } );
        }
    }

    private void fireInputRemoved ( final ChartInput input )
    {
        for ( final ChartViewerListener listener : this.listeners )
        {
            SafeRunner.run ( new SafeRunnable () {

                @Override
                public void run () throws Exception
                {
                    listener.inputRemoved ( input );
                }
            } );
        }
    }

    public Realm getRealm ()
    {
        return this.realm;
    }

    protected void updateState ()
    {
        final org.eclipse.scada.chart.XAxis x;
        final org.eclipse.scada.chart.YAxis y;

        x = getSelectedXAxisViewer ();
        y = getSelectedYAxisViewer ();

        // update mouse controllers

        if ( this.mouseHover != null )
        {
            this.mouseHover.dispose ();
            this.mouseHover = null;
        }

        if ( x != null && y != null && isHoverable () )
        {
            this.mouseHover = new MouseHover ( this.manager, x, this.hoverListener );
            this.mouseHover.setVisible ( true );
        }

        // update current time tracker

        if ( this.timeRuler == null && this.showTimeRuler && x != null )
        {
            this.timeRuler = new CurrentTimeRuler ( x );
            this.timeRuler.setColor ( new RGB ( 0, 0, 255 ) );
            this.manager.addRenderer ( this.timeRuler, 100 );
        }
        else if ( this.timeRuler != null && !this.showTimeRuler || x == null )
        {
            disposeTimeRuler ();
        }
    }

    protected void disposeTimeRuler ()
    {
        this.manager.removeRenderer ( this.timeRuler );
        this.timeRuler = null;
    }

    private org.eclipse.scada.chart.YAxis getSelectedYAxisViewer ()
    {
        return this.selectedYAxis != null ? this.selectedYAxis.getAxis () : null;
    }

    private org.eclipse.scada.chart.XAxis getSelectedXAxisViewer ()
    {
        return this.selectedXAxis != null ? this.selectedXAxis.getAxis () : null;
    }

    public XAxis getSelectedXAxis ()
    {
        return this.selectedXAxisElement;
    }

    public YAxis getSelectedYAxis ()
    {
        return this.selectedYAxisElement;
    }

    public void setSelectedXAxis ( final XAxis axis )
    {
        final XAxisViewer newSelection = this.xLocator.findAxis ( axis );
        if ( this.selectedXAxis == newSelection )
        {
            return;
        }
        this.selectedXAxis = newSelection;
        this.selectedXAxisElement = axis;

        disposeTimeRuler (); // dispose time ruler, as the axis changed
        updateState ();
    }

    public void setSelectedYAxis ( final YAxis axis )
    {
        final YAxisViewer newSelection = this.yLocator.findAxis ( axis );
        if ( this.selectedYAxis == newSelection )
        {
            return;
        }
        this.selectedYAxis = newSelection;
        this.selectedYAxisElement = axis;

        updateState ();
    }

    public void setChartBackground ( final RGB rgb )
    {
        this.manager.setChartBackground ( rgb );
    }

    public RGB getChartBackground ()
    {
        return this.manager.getChartBackground ();
    }

    protected void handleDispose ()
    {
        this.titleRenderer.dispose ();

        this.inputManager.dispose ();

        this.topManager.dispose ();
        this.bottomManager.dispose ();
        this.leftManager.dispose ();
        this.rightManager.dispose ();

        this.manager.dispose ();

        this.ctx.dispose ();
    }

    private DropTargetAdapter createDropTarget ()
    {
        return new DropTargetAdapter () {
            @Override
            public void dragEnter ( final DropTargetEvent event )
            {
                event.detail = DND.DROP_NONE;
                if ( !ChartViewer.this.mutable )
                {
                    return;
                }

                final ISelection selection = LocalSelectionTransfer.getTransfer ().getSelection ();

                {
                    final Collection<org.eclipse.scada.da.ui.connection.data.Item> data = org.eclipse.scada.da.ui.connection.data.ItemSelectionHelper.getSelection ( selection );
                    if ( !data.isEmpty () )
                    {
                        event.detail = DND.DROP_COPY;
                        return;
                    }
                }

                {
                    final Collection<org.eclipse.scada.hd.ui.connection.data.Item> data = org.eclipse.scada.hd.ui.connection.data.ItemSelectionHelper.getSelection ( LocalSelectionTransfer.getTransfer ().getSelection () );
                    if ( !data.isEmpty () )
                    {
                        event.detail = DND.DROP_COPY;
                        return;
                    }
                }
            };

            @Override
            public void drop ( final DropTargetEvent event )
            {
                handleDrop ();
            };
        };
    }

    public void setShowCurrentTimeRuler ( final boolean state )
    {
        this.showTimeRuler = state;
        updateState ();
    }

    public boolean isShowCurrentTimeRuler ()
    {
        return this.showTimeRuler;
    }

    private void startTimer ()
    {
        if ( this.display.isDisposed () )
        {
            return;
        }

        this.display.timerExec ( 250, new Runnable () {

            @Override
            public void run ()
            {
                if ( ChartViewer.this.manager.isDisposed () )
                {
                    return;
                }

                tick ();
                startTimer ();
            }
        } );
    }

    public void addItem ( final org.eclipse.scada.hd.ui.connection.data.Item item )
    {
        if ( this.selectedXAxisElement == null || this.selectedYAxisElement == null )
        {
            return;
        }

        org.eclipse.scada.ui.chart.model.Item itemRef = null;

        switch ( item.getType () )
        {
            case ID:
            {
                itemRef = ChartFactory.eINSTANCE.createIdItem ();
                itemRef.setItemId ( item.getId () );
                ( (IdItem)itemRef ).setConnectionId ( item.getConnectionString () );
                break;
            }
            case URI:
            {
                itemRef = ChartFactory.eINSTANCE.createUriItem ();
                itemRef.setItemId ( item.getId () );
                ( (UriItem)itemRef ).setConnectionUri ( item.getConnectionString () );
                break;
            }
        }

        if ( itemRef == null )
        {
            return;
        }

        final ArchiveSeries input = ChartFactory.eINSTANCE.createArchiveSeries ();
        input.setLabel ( item.toLabel () );
        input.setItem ( itemRef );
        input.setX ( this.selectedXAxisElement );
        input.setY ( this.selectedYAxisElement );

        input.getLineProperties ().setColor ( nextFreeColor () );

        this.chart.getInputs ().add ( input );
    }

    public void addItem ( final Item item )
    {
        if ( this.selectedXAxisElement == null || this.selectedYAxisElement == null )
        {
            return;
        }

        org.eclipse.scada.ui.chart.model.Item itemRef = null;

        switch ( item.getType () )
        {
            case ID:
            {
                itemRef = ChartFactory.eINSTANCE.createIdItem ();
                ( (IdItem)itemRef ).setConnectionId ( item.getId () );
                itemRef.setItemId ( item.getId () );
                break;
            }
            case URI:
            {
                itemRef = ChartFactory.eINSTANCE.createUriItem ();
                ( (UriItem)itemRef ).setConnectionUri ( item.getConnectionString () );
                itemRef.setItemId ( item.getId () );
                break;
            }
        }

        if ( itemRef == null )
        {
            return;
        }

        final DataItemSeries input = ChartFactory.eINSTANCE.createDataItemSeries ();
        input.setLabel ( item.toLabel () );
        input.setItem ( itemRef );
        input.setX ( this.selectedXAxisElement );
        input.setY ( this.selectedYAxisElement );

        input.getLineProperties ().setColor ( nextFreeColor () );

        this.chart.getInputs ().add ( input );
    }

    private static RGB[] DEFAULT_COLORS = new RGB[] { // 
    new RGB ( 255, 0, 0 ), // red
    new RGB ( 0, 255, 0 ), // green
    new RGB ( 0, 255, 255 ), // blue
    new RGB ( 255, 194, 0 ), // yellow
    new RGB ( 255, 0, 255 ), // magenta
    new RGB ( 0, 255, 255 ), // cyan
    };

    private RGB nextFreeColor ()
    {
        return DEFAULT_COLORS[this.items.size () % DEFAULT_COLORS.length];
    }

    public void addInput ( final ChartInput input )
    {
        if ( this.items.size () == 1 )
        {
            ( (ChartInput)this.items.get ( 0 ) ).setSelection ( false );
        }

        if ( !this.items.add ( input ) )
        {
            return;
        }
        if ( this.items.size () == 1 )
        {
            setSelection ( input );
        }

        // fire events
        fireInputAdded ( input );
    }

    public void removeInput ( final ChartInput input )
    {
        if ( input == this.selection )
        {
            setSelection ( (ChartInput)null );
        }
        if ( this.items.remove ( input ) )
        {
            fireInputRemoved ( input );
        }
    }

    public void setSelection ( final ChartInput chartInput )
    {
        if ( chartInput != null && !this.items.contains ( chartInput ) )
        {
            return;
        }

        this.selection = chartInput;

        for ( final Object input : this.items )
        {
            ( (ChartInput)input ).setSelection ( false );
        }

        if ( chartInput != null )
        {
            chartInput.setSelection ( true );
        }
    }

    public void tick ()
    {
        final long now = System.currentTimeMillis ();

        boolean forceUpdate = false;
        try
        {
            this.manager.setStale ( true );

            for ( final Object item : this.items )
            {
                if ( ( (ChartInput)item ).tick ( now ) )
                {
                    forceUpdate = true;
                }
            }
            if ( this.timeRuler != null )
            {
                forceUpdate = this.timeRuler.showingCurrentTime ();
            }
        }
        finally
        {
            this.manager.setStale ( false, forceUpdate );
        }
    }

    public void setFocus ()
    {
        this.manager.setFocus ();
        setSelection ( new StructuredSelection ( this ) );
    }

    public void dispose ()
    {
        final Object[] items = this.items.toArray ();
        this.items.clear ();

        for ( final Object item : items )
        {
            ( (ChartInput)item ).dispose ();
        }

        this.controllerManager.dispose ();
    }

    public IObservableList getItems ()
    {
        return this.unmodItems;
    }

    public void showTimespan ( final long duration, final TimeUnit timeUnit )
    {
        final org.eclipse.scada.chart.XAxis x = getSelectedXAxisViewer ();
        if ( x != null )
        {
            x.setByTimespan ( duration, timeUnit );
        }
    }

    public void pageTimespan ( final long duration, final TimeUnit timeUnit )
    {
        final org.eclipse.scada.chart.XAxis x = getSelectedXAxisViewer ();
        if ( x != null )
        {
            x.shiftByTimespan ( duration, timeUnit );
        }
    }

    public void setNowCenter ()
    {
        final org.eclipse.scada.chart.XAxis x = getSelectedXAxisViewer ();
        if ( x != null )
        {
            x.setNowCenter ();
        }
    }

    public Chart getChartConfiguration ()
    {
        return this.chart;
    }

    private void handleDrop ()
    {
        if ( !this.mutable )
        {
            return;
        }

        final ISelection selection = LocalSelectionTransfer.getTransfer ().getSelection ();
        {
            final Collection<org.eclipse.scada.da.ui.connection.data.Item> data = org.eclipse.scada.da.ui.connection.data.ItemSelectionHelper.getSelection ( selection );
            if ( !data.isEmpty () )
            {
                for ( final Item item : data )
                {
                    addItem ( item );
                }
                return;
            }
        }

        {
            final Collection<org.eclipse.scada.hd.ui.connection.data.Item> data = org.eclipse.scada.hd.ui.connection.data.ItemSelectionHelper.getSelection ( LocalSelectionTransfer.getTransfer ().getSelection () );
            if ( !data.isEmpty () )
            {
                for ( final org.eclipse.scada.hd.ui.connection.data.Item item : data )
                {
                    addItem ( item );
                }
                return;
            }
        }
    }

}
