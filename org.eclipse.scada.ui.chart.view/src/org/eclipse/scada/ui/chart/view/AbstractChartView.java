/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ui.chart.view;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.scada.chart.swt.ChartArea;
import org.eclipse.scada.chart.swt.SWTGraphics;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.scada.ui.chart.model.Chart;
import org.eclipse.scada.ui.chart.model.ChartPackage;
import org.eclipse.scada.ui.chart.viewer.ChartViewer;
import org.eclipse.scada.ui.chart.viewer.CompositeExtensionSpace;
import org.eclipse.scada.ui.chart.viewer.input.ChartInput;
import org.eclipse.scada.ui.databinding.SelectionHelper;
import org.eclipse.scada.ui.utils.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.printing.PrintDialog;
import org.eclipse.swt.printing.Printer;
import org.eclipse.swt.printing.PrinterData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;

public abstract class AbstractChartView extends ViewPart
{
    protected ChartViewer viewer;

    private ChartArea chartArea;

    private Shell shell;

    private Composite parent;

    public class CenterNowAction extends Action
    {
        public CenterNowAction ()
        {
            super ( "<now>" );
            setDescription ( "Center chart to current time" );
            setToolTipText ( "Center chart to current time" );
        }

        @Override
        public void run ()
        {
            AbstractChartView.this.viewer.setNowCenter ();
        }
    }

    public class PrintAction extends Action
    {

        public PrintAction ()
        {
            super ( "Print…" );
            setDescription ( "Print the current chart view" );
            setToolTipText ( "Print the current chart view" );
        }

        @Override
        public void run ()
        {
            print ();
        }
    }

    private class TimeAction extends Action
    {
        protected final long duration;

        protected final TimeUnit timeUnit;

        public TimeAction ( final long duration, final TimeUnit timeUnit, final String label, final String description )
        {
            super ( label );
            setDescription ( description );
            setToolTipText ( description );
            this.duration = duration;
            this.timeUnit = timeUnit;
        }
    }

    class SetTimespanAction extends TimeAction
    {
        public SetTimespanAction ( final long duration, final TimeUnit timeUnit, final String label, final String description )
        {
            super ( duration, timeUnit, label, description );
        }

        @Override
        public void run ()
        {
            showTimespan ( this.duration, this.timeUnit );
        }
    }

    class PageTimespanAction extends TimeAction
    {
        public PageTimespanAction ( final long duration, final TimeUnit timeUnit, final String label, final String description )
        {
            super ( duration, timeUnit, label, description );
        }

        @Override
        public void run ()
        {
            pageTimespan ( this.duration, this.timeUnit );
        }
    }

    protected static Chart load ( final InputStream input ) throws IOException
    {
        final Resource resource = new XMIResourceFactoryImpl ().createResource ( URI.createURI ( "urn:memento" ) );

        final Map<?, ?> options = new HashMap<Object, Object> ();
        resource.load ( input, options );

        return (Chart)EcoreUtil.getObjectByType ( resource.getContents (), ChartPackage.Literals.CHART );
    }

    @Override
    public void createPartControl ( final Composite parent )
    {
        parent.setLayout ( GridLayoutFactory.slimStack () );

        this.parent = parent;
        this.shell = parent.getShell ();

        fillToolbar ( getViewSite ().getActionBars ().getToolBarManager () );
    }

    protected void createView ( final Chart configuration )
    {
        final Composite extensionSpace = new Composite ( this.parent, SWT.NONE );
        extensionSpace.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, false ) );
        extensionSpace.setLayout ( new RowLayout ( SWT.HORIZONTAL ) );
        this.chartArea = new ChartArea ( this.parent, SWT.NONE );
        this.chartArea.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );
        this.viewer = new ChartViewer ( this.chartArea.getChartRenderer (), configuration, new CompositeExtensionSpace ( extensionSpace ), null );

        getSite ().setSelectionProvider ( this.viewer );

        getSite ().getWorkbenchWindow ().getSelectionService ().addPostSelectionListener ( new ISelectionListener () {

            @Override
            public void selectionChanged ( final IWorkbenchPart part, final ISelection selection )
            {
                final Object sel = SelectionHelper.first ( selection, Object.class );
                if ( sel == null )
                {
                    AbstractChartView.this.viewer.setSelection ( (ChartInput)null );
                }
                else if ( sel instanceof ChartInput )
                {
                    AbstractChartView.this.viewer.setSelection ( (ChartInput)sel );
                }
                // else: don't select anything which we do not care about
            }
        } );
    }

    private void fillToolbar ( final IToolBarManager toolBarManager )
    {
        toolBarManager.add ( new SetTimespanAction ( 1, TimeUnit.MINUTES, "<1m>", "Scale to one minute" ) );
        toolBarManager.add ( new SetTimespanAction ( 1, TimeUnit.HOURS, "<1h>", "Scale to one hour" ) );
        toolBarManager.add ( new SetTimespanAction ( 1, TimeUnit.DAYS, "<1d>", "Scale to one day" ) );

        toolBarManager.add ( new CenterNowAction () );

        toolBarManager.add ( new Separator () );

        toolBarManager.add ( new PageTimespanAction ( -1, TimeUnit.DAYS, "<1d", "Move back 1 day" ) );
        toolBarManager.add ( new PageTimespanAction ( -1, TimeUnit.HOURS, "<1h", "Move back 1 hour" ) );
        toolBarManager.add ( new PageTimespanAction ( -1, TimeUnit.MINUTES, "<1m", "Move back 1 minute" ) );

        toolBarManager.add ( new Separator () );

        toolBarManager.add ( new PageTimespanAction ( 1, TimeUnit.MINUTES, "1m>", "Move forward 1 minute" ) );
        toolBarManager.add ( new PageTimespanAction ( 1, TimeUnit.HOURS, "1h>", "Move forward 1 hour" ) );
        toolBarManager.add ( new PageTimespanAction ( 1, TimeUnit.DAYS, "1d>", "Move forward 1 day" ) );

        toolBarManager.add ( new Separator () );

        toolBarManager.add ( new PrintAction () );
    }

    @Override
    public void dispose ()
    {
        if ( this.viewer != null )
        {
            this.viewer.dispose ();
        }
        super.dispose ();
    }

    @Override
    public void setFocus ()
    {
        if ( this.viewer != null )
        {
            this.viewer.setFocus ();
        }
    }

    public void print ()
    {
        if ( Printer.getPrinterList ().length == 0 )
        {
            MessageDialog.openInformation ( this.shell, "No printer", "No installed printer could be found" );
            return;
        }

        final PrintDialog dlg = new PrintDialog ( this.shell, SWT.APPLICATION_MODAL );

        final PrinterData initialPd = Printer.getDefaultPrinterData ();
        initialPd.orientation = PrinterData.LANDSCAPE;
        dlg.setPrinterData ( initialPd );

        final PrinterData pd = dlg.open ();

        if ( pd != null )
        {
            final Printer printer = new Printer ( pd );
            try
            {
                printer.startJob ( "Chart" );
                printer.startPage ();

                final GC gc = new GC ( printer );
                try
                {
                    this.viewer.getChartRenderer ().paint ( new SWTGraphics ( gc ) );
                }
                finally
                {
                    gc.dispose ();
                }

                printer.endPage ();
                printer.endJob ();
            }
            finally
            {
                printer.dispose ();
            }
        }
    }

    public void showTimespan ( final long duration, final TimeUnit timeUnit )
    {
        this.viewer.showTimespan ( duration, timeUnit );
    }

    public void pageTimespan ( final long duration, final TimeUnit timeUnit )
    {
        this.viewer.pageTimespan ( duration, timeUnit );
    }

    public void addItem ( final Item item )
    {
        this.viewer.addItem ( item );
    }

    public void addItem ( final org.eclipse.scada.hd.ui.connection.data.Item item )
    {
        this.viewer.addItem ( item );
    }

}