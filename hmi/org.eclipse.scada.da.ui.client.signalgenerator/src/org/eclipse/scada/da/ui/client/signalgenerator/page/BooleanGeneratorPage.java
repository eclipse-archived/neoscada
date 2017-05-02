/*******************************************************************************
 * Copyright (c) 2009, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - remove number of iterations
 *******************************************************************************/
package org.eclipse.scada.da.ui.client.signalgenerator.page;

import org.eclipse.scada.da.ui.client.signalgenerator.SimulationTarget;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;

public class BooleanGeneratorPage implements GeneratorPage
{
    private Spinner startDelaySpinner;

    private Spinner endDelaySpinner;

    private Composite parent;

    private BooleanGenerator generator;

    private SimulationTarget target;

    @Override
    public void createPage ( final Composite parent )
    {
        this.parent = parent;
        parent.setLayout ( new FillLayout ( SWT.VERTICAL ) );
        createTimedGroup ( parent );
        update ();
    }

    private void createTimedGroup ( final Composite parent )
    {
        parent.setLayout ( new GridLayout ( 4, false ) );
        new Label ( parent, SWT.NONE ).setText ( Messages.getString ( "BooleanGeneratorPage.timedGroup.beforeDelay" ) ); //$NON-NLS-1$
        new Label ( parent, SWT.NONE ).setText ( Messages.getString ( "BooleanGeneratorPage.timedGroup.0to1" ) ); //$NON-NLS-1$
        new Label ( parent, SWT.NONE ).setText ( Messages.getString ( "BooleanGeneratorPage.timedGroup.afterDelay" ) ); //$NON-NLS-1$
        new Label ( parent, SWT.NONE ).setText ( Messages.getString ( "BooleanGeneratorPage.timedGroup.1to0" ) ); //$NON-NLS-1$

        this.startDelaySpinner = new Spinner ( parent, SWT.BORDER );
        this.startDelaySpinner.setValues ( 1000, 0, Integer.MAX_VALUE, 0, 100, 1000 );
        new Label ( parent, SWT.NONE ).setText ( Messages.getString ( "BooleanGeneratorPage.timedGroup.transition" ) ); //$NON-NLS-1$
        this.endDelaySpinner = new Spinner ( parent, SWT.BORDER );
        this.endDelaySpinner.setValues ( 1000, 0, Integer.MAX_VALUE, 0, 100, 1000 );
    }

    @Override
    public void start ()
    {
        final int startDelay = this.startDelaySpinner.getSelection ();
        final int endDelay = this.endDelaySpinner.getSelection ();
        this.generator = new BooleanGenerator ( this.parent.getDisplay (), this.target );
        this.generator.setStartDelay ( startDelay );
        this.generator.setEndDelay ( endDelay );
        this.generator.start ();
    }

    @Override
    public void stop ()
    {
        dispose ();
    }

    @Override
    public void dispose ()
    {
        if ( this.generator != null )
        {
            this.generator.dispose ();
            this.generator = null;
        }
    }

    @Override
    public void setTarget ( final SimulationTarget target )
    {
        this.target = target;
        update ();
    }

    private void update ()
    {
        this.startDelaySpinner.setEnabled ( this.generator == null );
        this.endDelaySpinner.setEnabled ( this.generator == null );
    }

}
