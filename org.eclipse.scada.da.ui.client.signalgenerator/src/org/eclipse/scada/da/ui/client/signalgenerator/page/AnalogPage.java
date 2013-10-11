/*******************************************************************************
 * Copyright (c) 2009, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.ui.client.signalgenerator.page;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class AnalogPage extends AbstractStepGeneratorPage implements GeneratorPage
{
    private Text minText;

    private Text maxText;

    private Combo functionCombo;

    private ComboViewer functionComboViewer;

    private Text perText;

    private double minimum;

    private double maximum;

    private double selectedPeriod;

    private AnalogType function;

    public void createPage ( final Composite parent )
    {
        setDisplay ( parent.getDisplay () );

        parent.setLayout ( new FillLayout ( SWT.VERTICAL ) );

        final Composite comp = new Composite ( parent, SWT.NONE );
        comp.setLayout ( new GridLayout ( 2, false ) );

        Label label;

        final ModifyListener updateAdapter = new ModifyListener () {
            public void modifyText ( final ModifyEvent e )
            {
                updateSelection ();
            }
        };

        // min
        label = new Label ( comp, SWT.NONE );
        label.setText ( Messages.getString ( "AnalogPage.PresetMin" ) ); //$NON-NLS-1$
        this.minText = new Text ( comp, SWT.BORDER | SWT.SINGLE );
        this.minText.setText ( "-20" ); //$NON-NLS-1$
        this.minText.addModifyListener ( updateAdapter );
        this.minText.setLayoutData ( labelData () );

        // max
        label = new Label ( comp, SWT.NONE );
        label.setText ( Messages.getString ( "AnalogPage.PresetMax" ) ); //$NON-NLS-1$
        this.maxText = new Text ( comp, SWT.BORDER | SWT.SINGLE );
        this.maxText.setText ( "20" ); //$NON-NLS-1$
        this.maxText.addModifyListener ( updateAdapter );
        this.maxText.setLayoutData ( labelData () );

        // frequency
        label = new Label ( comp, SWT.NONE );
        label.setText ( Messages.getString ( "AnalogPage.PresetPeriod" ) ); //$NON-NLS-1$
        this.perText = new Text ( comp, SWT.BORDER | SWT.SINGLE );
        this.perText.setText ( "2000" ); //$NON-NLS-1$
        this.perText.addModifyListener ( updateAdapter );
        this.perText.setLayoutData ( labelData () );

        // function
        label = new Label ( comp, SWT.NONE );
        label.setText ( Messages.getString ( "AnalogPage.PresetFunction" ) ); //$NON-NLS-1$
        this.functionCombo = new Combo ( comp, SWT.DROP_DOWN | SWT.READ_ONLY );
        this.functionCombo.setLayoutData ( labelData () );
        this.functionComboViewer = new ComboViewer ( this.functionCombo );
        this.functionComboViewer.setContentProvider ( new ArrayContentProvider () );
        this.functionComboViewer.setLabelProvider ( new LabelProvider () {
            @Override
            public String getText ( final Object element )
            {
                if ( element instanceof AnalogType )
                {
                    return ( (AnalogType)element ).toLabel ();
                }
                return super.getText ( element );
            }
        } );
        // add all elements from the enum
        this.functionComboViewer.add ( AnalogType.values () );
        // select the first entry from the enum
        this.functionComboViewer.setSelection ( new StructuredSelection ( AnalogType.values ()[0] ), true );
        this.functionComboViewer.addSelectionChangedListener ( new ISelectionChangedListener () {

            public void selectionChanged ( final SelectionChangedEvent event )
            {
                updateSelection ();
            }
        } );

        updateSelection ();
    }

    private Object labelData ()
    {
        final GridData data = new GridData ( SWT.FILL, SWT.CENTER, false, false );

        return data;
    }

    protected void updateSelection ()
    {
        this.minimum = getMinimum ();
        this.maximum = getMaximum ();
        this.selectedPeriod = getPeriod ();
        this.function = getFunction ();
    }

    protected double getMinimum ()
    {
        try
        {
            return Double.parseDouble ( this.minText.getText () );
        }
        catch ( final Throwable e )
        {
            return Double.MIN_VALUE;
        }
    }

    protected double getMaximum ()
    {
        try
        {
            return Double.parseDouble ( this.maxText.getText () );
        }
        catch ( final Throwable e )
        {
            return Double.MAX_VALUE;
        }
    }

    protected double getPeriod ()
    {
        try
        {
            return Double.parseDouble ( this.perText.getText () );
        }
        catch ( final Throwable e )
        {
            return 1.0;
        }
    }

    protected AnalogType getFunction ()
    {
        return (AnalogType) ( (IStructuredSelection)this.functionComboViewer.getSelection () ).getFirstElement ();
    }

    @Override
    protected void step ()
    {
        this.target.writeValue ( this.function.generate ( System.currentTimeMillis (), this.minimum, this.maximum, this.selectedPeriod ) );
    }
}
