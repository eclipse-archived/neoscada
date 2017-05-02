/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.vi.details.swt.widgets;

import java.util.Collection;
import java.util.Map;

import org.eclipse.scada.sec.callback.CallbackHandler;
import org.eclipse.scada.sec.ui.DisplayCallbackHandler;
import org.eclipse.scada.vi.data.DataValue;
import org.eclipse.scada.vi.data.RegistrationManager;
import org.eclipse.scada.vi.data.SummaryInformation;
import org.eclipse.scada.vi.data.SummaryProvider;
import org.eclipse.scada.vi.data.RegistrationManager.Listener;
import org.eclipse.scada.vi.details.model.Registration;
import org.eclipse.scada.vi.details.swt.Activator;
import org.eclipse.scada.vi.details.swt.data.DataItemDescriptor;
import org.eclipse.scada.vi.details.swt.impl.DetailComponentImpl;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

public abstract class GenericComposite extends Composite implements Listener
{
    protected final RegistrationManager registrationManager;

    private final RegistrationManagerSummaryProvider summaryProvider;

    protected final CallbackHandler callbackHandler;

    public GenericComposite ( final Composite parent, final int style, final Collection<Registration> registrations, final Map<String, String> properties )
    {
        super ( parent, style );

        this.callbackHandler = new DisplayCallbackHandler ( parent.getShell (), "Operation", "Confirmation required" );

        this.registrationManager = new RegistrationManager ( Activator.getDefault ().getBundle ().getBundleContext () );
        this.registrationManager.addListener ( this );

        this.summaryProvider = new RegistrationManagerSummaryProvider ( this.registrationManager );

        if ( registrations != null )
        {
            for ( final Registration reg : registrations )
            {
                final DataItemDescriptor descriptor = DataItemDescriptor.create ( DetailComponentImpl.resolve ( reg.getDescriptor (), properties ) );
                this.registrationManager.registerItem ( reg.getKey (), descriptor.getItemId (), descriptor.getConnectionInformation (), reg.isAggregateState (), true );
            }
        }

        addDisposeListener ( new DisposeListener () {

            @Override
            public void widgetDisposed ( final DisposeEvent e )
            {
                handleDispose ();
            }
        } );
    }

    public void start ()
    {
        this.registrationManager.open ();
        this.summaryProvider.open ();

        for ( final Control control : getChildren () )
        {
            if ( control instanceof GenericComposite )
            {
                ( (GenericComposite)control ).start ();
            }
        }
    }

    public void stop ()
    {
        for ( final Control control : getChildren () )
        {
            if ( control instanceof GenericComposite )
            {
                ( (GenericComposite)control ).stop ();
            }
        }

        this.registrationManager.close ();
        this.summaryProvider.close ();
    }

    protected void handleDispose ()
    {
        this.summaryProvider.dispose ();
        this.registrationManager.dispose ();
    }

    public SummaryProvider getSummaryProvider ()
    {
        return this.summaryProvider;
    }

    @Override
    public void dispose ()
    {
        handleDispose ();
        super.dispose ();
    }

    @Override
    public void triggerDataUpdate ()
    {
        Display.getDefault ().asyncExec ( new Runnable () {

            @Override
            public void run ()
            {
                if ( Display.getCurrent ().isDisposed () )
                {
                    return;
                }
                processUpdate ();
            }
        } );
    }

    private void processUpdate ()
    {
        final Map<String, DataValue> data = this.registrationManager.getData ();

        final SummaryInformation summaryInformation = new SummaryInformation ( data );
        updateState ( data, summaryInformation );
    }

    protected abstract void updateState ( Map<String, DataValue> data, SummaryInformation summaryInformation );
}
