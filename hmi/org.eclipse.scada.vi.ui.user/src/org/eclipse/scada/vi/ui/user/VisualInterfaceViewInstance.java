/*******************************************************************************
 * Copyright (c) 2012, 2016 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - minor cleanups
 *******************************************************************************/
package org.eclipse.scada.vi.ui.user;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.scada.vi.data.SummaryInformation;
import org.eclipse.scada.vi.data.SummaryListener;
import org.eclipse.scada.vi.data.SummaryProvider;
import org.eclipse.scada.vi.ui.draw2d.VisualInterfaceViewer;
import org.eclipse.scada.vi.ui.user.viewer.AbstractViewInstance;
import org.eclipse.scada.vi.ui.user.viewer.ViewInstanceDescriptor;
import org.eclipse.scada.vi.ui.user.viewer.ViewManager;
import org.eclipse.scada.vi.ui.user.viewer.ViewManagerContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.services.IEvaluationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VisualInterfaceViewInstance extends AbstractViewInstance implements SummaryListener, SummaryProvider
{
    private final static Logger logger = LoggerFactory.getLogger ( VisualInterfaceViewInstance.class );

    private VisualInterfaceViewer viewer;

    private final Composite parent;

    private final Map<String, Object> scriptObjects;

    private SummaryInformation currentSummary;

    private final Set<SummaryListener> summaryListeners = new LinkedHashSet<SummaryListener> ();

    public VisualInterfaceViewInstance ( final ViewManager viewManager, final ViewManagerContext viewManagerContext, final Composite parent, final ViewInstanceDescriptor descriptor, final IEvaluationService evaluationService )
    {
        super ( viewManagerContext, descriptor, evaluationService );
        this.parent = parent;

        // create the visual interface view

        this.scriptObjects = new HashMap<String, Object> ();
        this.scriptObjects.put ( "viewManager", viewManager ); //$NON-NLS-1$
    }

    @Override
    protected void activateView ()
    {
        if ( this.viewer != null )
        {
            return;
        }

        this.viewer = new VisualInterfaceViewer ( this.parent, SWT.NONE, this.descriptor.getUri (), this.scriptObjects, this.descriptor.getProperties () );
        this.viewer.setZooming ( this.descriptor.getZooming () );
        this.viewer.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, true ) );

        // always add summary listener if we are active
        this.viewer.addSummaryListener ( this );
    }

    @Override
    protected void deactivateView ()
    {
        if ( this.viewer != null )
        {
            this.viewer.removeSummaryListener ( this );

            this.viewer.dispose ();
            this.viewer = null;
        }
    }

    @Override
    public void setFocus ()
    {
        this.viewer.setFocus ();
    }

    @Override
    public Control getControl ()
    {
        return this.viewer;
    }

    @Override
    public SummaryInformation getSummary ()
    {
        return this.currentSummary;
    }

    @Override
    public void summaryChanged ( final SummaryInformation summary )
    {
        logger.debug ( "Summary changed: {}", summary ); //$NON-NLS-1$
        this.currentSummary = summary;
        fireSummaryChanged ( summary );
    }

    private void fireSummaryChanged ( final SummaryInformation summary )
    {
        for ( final SummaryListener listener : this.summaryListeners )
        {
            SafeRunner.run ( new SafeRunnable () {

                @Override
                public void run () throws Exception
                {
                    listener.summaryChanged ( summary );
                }
            } );
        }
    }

    @Override
    public void addSummaryListener ( final SummaryListener summaryListener )
    {
        if ( this.summaryListeners.add ( summaryListener ) )
        {
            summaryListener.summaryChanged ( this.currentSummary );
        }
    }

    @Override
    public void removeSummaryListener ( final SummaryListener summaryListener )
    {
        this.summaryListeners.remove ( summaryListener );
    }
}
