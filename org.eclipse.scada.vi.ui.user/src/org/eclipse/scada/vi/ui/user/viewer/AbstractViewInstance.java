/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.ui.user.viewer;

import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.services.IEvaluationReference;
import org.eclipse.ui.services.IEvaluationService;

public abstract class AbstractViewInstance implements ViewInstance
{
    private static final String PROP_DEFAULT_INSTANCE = "defaultInstance";

    private static final String PROP_LAZY = "lazy";

    private static final String PROP_VISIBLE = "visible";

    private IEvaluationReference visibileRef;

    private IEvaluationReference lazyRef;

    private IEvaluationReference defaultInstanceRef;

    private final IEvaluationService evaluationService;

    private boolean lazy = true;

    private boolean active;

    private boolean defaultInstance;

    private boolean visible;

    private final ViewManagerContext viewManagerContext;

    private boolean suppressActiveEvent = false;

    protected final ViewInstanceDescriptor descriptor;

    public AbstractViewInstance ( final ViewManagerContext viewManagerContext, final ViewInstanceDescriptor descriptor, final IEvaluationService evaluationService )
    {
        this.viewManagerContext = viewManagerContext;
        this.evaluationService = evaluationService;
        this.descriptor = descriptor;
    }

    public void init ()
    {
        attachVisibleExpression ( this.descriptor, this.evaluationService );
        attachLazyExpression ( this.descriptor, this.evaluationService );
        attachDefaultInstanceExpression ( this.descriptor, this.evaluationService );
    }

    protected abstract void activateView ();

    protected abstract void deactivateView ();

    public void dispose ()
    {
        deactivateView ();

        if ( this.visibileRef != null )
        {
            this.evaluationService.removeEvaluationListener ( this.visibileRef );
            this.visibileRef = null;
        }

        if ( this.lazyRef != null )
        {
            this.evaluationService.removeEvaluationListener ( this.lazyRef );
            this.lazyRef = null;
        }

        if ( this.defaultInstanceRef != null )
        {
            this.evaluationService.removeEvaluationListener ( this.defaultInstanceRef );
            this.defaultInstanceRef = null;
        }
    }

    private void attachVisibleExpression ( final ViewInstanceDescriptor descriptor, final IEvaluationService evaluationService )
    {
        if ( descriptor.getVisibleExpression () != null )
        {
            this.visibileRef = evaluationService.addEvaluationListener ( descriptor.getVisibleExpression (), new IPropertyChangeListener () {

                @Override
                public void propertyChange ( final PropertyChangeEvent event )
                {
                    if ( PROP_VISIBLE.equals ( event.getProperty () ) && event.getNewValue () instanceof Boolean )
                    {
                        setVisibleState ( (Boolean)event.getNewValue () );
                    }
                }
            }, PROP_VISIBLE );
        }
        else
        {
            setVisibleState ( true );
        }
    }

    private void attachLazyExpression ( final ViewInstanceDescriptor descriptor, final IEvaluationService evaluationService )
    {
        if ( descriptor.getLazyExpression () != null )
        {
            this.lazyRef = evaluationService.addEvaluationListener ( descriptor.getLazyExpression (), new IPropertyChangeListener () {

                @Override
                public void propertyChange ( final PropertyChangeEvent event )
                {
                    if ( PROP_LAZY.equals ( event.getProperty () ) && event.getNewValue () instanceof Boolean )
                    {
                        setLazy ( (Boolean)event.getNewValue () );
                    }
                }
            }, PROP_LAZY );
        }
        else
        {
            setLazy ( false );
        }
    }

    private void attachDefaultInstanceExpression ( final ViewInstanceDescriptor descriptor, final IEvaluationService evaluationService )
    {
        if ( descriptor.getDefaultInstanceExpression () != null )
        {
            this.defaultInstanceRef = evaluationService.addEvaluationListener ( descriptor.getDefaultInstanceExpression (), new IPropertyChangeListener () {

                @Override
                public void propertyChange ( final PropertyChangeEvent event )
                {
                    if ( PROP_DEFAULT_INSTANCE.equals ( event.getProperty () ) && event.getNewValue () instanceof Boolean )
                    {
                        setDefaultInstance ( (Boolean)event.getNewValue () );
                    }
                }
            }, PROP_DEFAULT_INSTANCE );
        }
        else
        {
            setDefaultInstance ( descriptor.isDefaultInstance () );
        }
    }

    @Override
    public ViewInstanceDescriptor getDescriptor ()
    {
        return this.descriptor;
    }

    protected void setDefaultInstance ( final boolean defaultInstance )
    {
        this.defaultInstance = defaultInstance;
        fireDefaultStateChanged ( defaultInstance );
    }

    @Override
    public boolean isDefaultInstance ()
    {
        return this.defaultInstance;
    }

    @Override
    public boolean isActive ()
    {
        return this.active;
    }

    @Override
    public boolean isLazy ()
    {
        return this.lazy;
    }

    protected void setLazy ( final boolean lazy )
    {
        if ( this.lazy == lazy )
        {
            // if nothing changes, we pass
            return;
        }

        if ( this.lazy )
        {
            // if we were lazy, but are non-lazy now, we need to activate
            activateView ();
        }
        else if ( !this.active )
        {
            // if we were not lazy, are lazy now and are not active, we deactivate
            deactivateView ();
        }

        this.lazy = lazy;
        fireLazyStateChanged ( lazy );
    }

    public boolean isVisible ()
    {
        return this.visible;
    }

    protected void setVisibleState ( final boolean state )
    {
        if ( this.visible == state )
        {
            return;
        }

        this.visible = state;

        fireVisibleStateChanged ( state );
    }

    private void fireVisibleStateChanged ( final boolean state )
    {
        if ( this.viewManagerContext != null )
        {
            this.viewManagerContext.viewVisibilityChanged ( this, state );
        }
    }

    private void fireLazyStateChanged ( final boolean state )
    {
        if ( this.viewManagerContext != null )
        {
            this.viewManagerContext.viewLazynessChanged ( this, state );
        }
    }

    private void fireDefaultStateChanged ( final boolean state )
    {
        if ( this.viewManagerContext != null )
        {
            this.viewManagerContext.viewDefaultChanged ( this, state );
        }
    }

    private void fireActiveStateChanged ( final boolean state )
    {
        if ( this.viewManagerContext != null && !this.suppressActiveEvent )
        {
            this.viewManagerContext.viewActiveChanged ( this, state );
        }
    }

    @Override
    public void reload ()
    {
        try
        {
            this.suppressActiveEvent = true;

            // dispose first
            deactivateView ();

            // now create
            activateView ();

            // notify that our control changed
            fireControlChanged ();
        }
        finally
        {
            this.suppressActiveEvent = false;
        }
    }

    private void fireControlChanged ()
    {
        if ( this.viewManagerContext != null )
        {
            this.viewManagerContext.viewControlChanged ( this );
        }
    }

    @Override
    public void deactivate ()
    {
        this.active = false;
        fireActiveStateChanged ( false );

        if ( this.lazy )
        {
            deactivateView ();
        }
    }

    @Override
    public void activate ()
    {
        this.active = true;
        fireActiveStateChanged ( true );

        if ( this.lazy )
        {
            activateView ();
        }
    }

}
