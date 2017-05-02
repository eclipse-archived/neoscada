/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.ui.views.dialog;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.Event.Fields;
import org.eclipse.scada.ae.ui.views.Messages;
import org.eclipse.scada.utils.filter.Assertion;
import org.eclipse.scada.utils.filter.Filter;
import org.eclipse.scada.utils.filter.FilterAssertion;
import org.eclipse.scada.utils.filter.FilterExpression;
import org.eclipse.scada.utils.filter.Operator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

public class FilterAdvancedComposite extends Composite
{
    private final List<OrCondition> orConditions = new ArrayList<OrCondition> ();

    private final CTabFolder tabFolder;

    private final Button addOrConditionButton;

    private enum Type
    {
        Text,
        Number,
        DateTime
    }

    /**
     * @author jrose
     *
     */
    private static class AddAssertionComposite extends Composite
    {
        // fields
        private final OrCondition orCondition;

        // widgets
        private final Combo attributeCombo;

        public AddAssertionComposite ( final OrCondition orCondition, final Composite parent )
        {
            // fields
            super ( parent, SWT.NONE );
            this.orCondition = orCondition;

            // widgets
            this.attributeCombo = createAttributeCombo ();
            createTypeCombo ();
            createAddButton ();

            // layout
            final RowLayout layout = new RowLayout ();
            this.setLayout ( layout );
        }

        private Combo createAttributeCombo ()
        {
            final Combo c = new Combo ( this, SWT.NONE );
            c.add ( "sourceTimestamp" ); //$NON-NLS-1$
            c.add ( "entryTimestamp" ); //$NON-NLS-1$
            for ( final Event.Fields field : Event.Fields.values () )
            {
                c.add ( field.getName () );
            }
            c.add ( Messages.custom_field );
            c.select ( 0 );
            return c;
        }

        private Combo createTypeCombo ()
        {
            final Combo c = new Combo ( this, SWT.NONE );
            for ( final Type type : Type.values () )
            {
                c.add ( type.name () );
            }
            c.select ( 0 );
            return c;
        }

        private Button createAddButton ()
        {
            final Button b = new Button ( this, SWT.PUSH );
            b.setText ( Messages.add_assertion );
            b.addSelectionListener ( new SelectionAdapter () {
                @Override
                public void widgetSelected ( final SelectionEvent e )
                {
                    AddAssertionComposite.this.orCondition.addAssertion ();
                }
            } );
            return b;
        }
    }

    /**
     * 
     * @author jrose
     */
    private static class AssertionComposite extends Composite
    {
        // fields
        private final OrCondition orCondition;

        // widgets
        private final Button notCheck;

        private final Text attributeText;

        private final Text valueText;

        private final Combo assertionCombo;

        public AssertionComposite ( final OrCondition orCondition, final Composite parent, final String attribute, final Type type )
        {
            // final fields
            super ( parent, SWT.NONE );
            this.orCondition = orCondition;

            // widgets
            this.notCheck = createNotCheck ();
            this.attributeText = createAttributeText ( attribute );
            createFieldTypeLabel ( type );
            this.assertionCombo = createAssertionCombo ();
            this.valueText = createValueText ();
            createRemoveButton ();

            // layout
            final RowLayout layout = new RowLayout ();
            layout.center = true;
            this.setLayout ( layout );

            parent.notifyListeners ( SWT.Resize, new org.eclipse.swt.widgets.Event () );
        }

        private Button createNotCheck ()
        {
            final Button b = new Button ( this, SWT.CHECK );
            b.setText ( Messages.not );
            b.addSelectionListener ( new SelectionAdapter () {
                @Override
                public void widgetSelected ( final SelectionEvent e )
                {
                    AssertionComposite.this.orCondition.updateFilter ();
                }
            } );
            return b;
        }

        private Text createAttributeText ( final String attribute )
        {
            final Text t = new Text ( this, SWT.BORDER );
            final Fields field = Fields.byField ( attribute );
            if ( field == null )
            {
                t.setEditable ( true );
                t.setMessage ( Messages.custom_field );
            }
            else
            {
                t.setEditable ( false );
                t.setText ( field.getName () );
            }
            t.addKeyListener ( new KeyAdapter () {
                @Override
                public void keyReleased ( final KeyEvent e )
                {
                    AssertionComposite.this.orCondition.updateFilter ();
                };
            } );
            final RowData rowData = new RowData ();
            rowData.width = 132;
            t.setLayoutData ( rowData );
            return t;
        }

        private Label createFieldTypeLabel ( final Type type )
        {
            final Label l = new Label ( this, SWT.NONE );
            l.setText ( type.name () );
            return l;
        }

        private Combo createAssertionCombo ()
        {
            final Combo c = new Combo ( this, SWT.NONE );
            for ( final Assertion assertion : Assertion.values () )
            {
                c.add ( assertion.toString () );
            }
            c.select ( 0 );
            c.addSelectionListener ( new SelectionAdapter () {
                @Override
                public void widgetSelected ( final SelectionEvent e )
                {
                    AssertionComposite.this.orCondition.updateFilter ();
                }
            } );
            final RowData rowData = new RowData ();
            rowData.width = 75;
            c.setLayoutData ( rowData );
            return c;
        }

        private Text createValueText ()
        {
            final Text t = new Text ( this, SWT.BORDER );
            t.setMessage ( Messages.argument );
            t.addKeyListener ( new KeyAdapter () {
                @Override
                public void keyReleased ( final KeyEvent e )
                {
                    AssertionComposite.this.orCondition.updateFilter ();
                }
            } );
            final RowData rowData = new RowData ();
            rowData.width = 132;
            t.setLayoutData ( rowData );
            return t;
        }

        private Button createRemoveButton ()
        {
            final Button b = new Button ( this, SWT.PUSH );
            b.setText ( Messages.remove );
            b.addSelectionListener ( new SelectionAdapter () {
                @Override
                public void widgetSelected ( final SelectionEvent e )
                {
                    AssertionComposite.this.orCondition.removeAssertion ( AssertionComposite.this );
                }
            } );
            return b;
        }

        public Filter getExpression ()
        {
            final String attr = this.attributeText.getText ();
            final String ass = this.assertionCombo.getText ();
            final String val = this.valueText.getText ();
            final FilterAssertion assertion = new FilterAssertion ( attr, Assertion.fromString ( ass ), val );
            if ( val.contains ( "*" ) ) //$NON-NLS-1$
            {
                assertion.setAssertion ( Assertion.SUBSTRING );
                assertion.setValue ( val.split ( "\\*" ) ); //$NON-NLS-1$
            }
            if ( this.notCheck.getSelection () )
            {
                return FilterExpression.negate ( assertion );
            }
            return assertion;
        }
    }

    /**
     * @author jrose
     *
     */
    private static class OrCondition
    {
        private final FilterAdvancedComposite filterAdvancedComposite;

        private final CTabItem tabItem;

        private final Composite tabContent;

        private final List<AssertionComposite> assertionComposites = new ArrayList<AssertionComposite> ();

        private final AddAssertionComposite addAssertionComposite;

        private final ScrolledComposite assertionScrolledComposite;

        private final Composite assertionComposite;

        public OrCondition ( final FilterAdvancedComposite filterAdvancedComposite, final CTabFolder tabFolder )
        {
            // fields
            this.filterAdvancedComposite = filterAdvancedComposite;
            this.tabItem = new CTabItem ( tabFolder, SWT.NULL );
            this.tabItem.setText ( Messages.a_condition );
            this.tabContent = new Composite ( tabFolder, SWT.NONE );
            this.tabItem.setControl ( this.tabContent );

            // widgets
            this.addAssertionComposite = new AddAssertionComposite ( this, this.tabContent );
            this.assertionScrolledComposite = new ScrolledComposite ( this.tabContent, SWT.V_SCROLL | SWT.NONE );
            this.assertionComposite = new Composite ( this.assertionScrolledComposite, SWT.NONE );
            this.assertionScrolledComposite.setContent ( this.assertionComposite );

            // layout
            final GridLayout layout = new GridLayout ();
            layout.marginLeft = 6;
            layout.marginRight = 6;
            layout.marginTop = 6;
            layout.marginBottom = 6;
            layout.verticalSpacing = 12;
            this.tabContent.setLayout ( layout );

            final GridData addAssertionCompositeLayoutData = new GridData ();
            addAssertionCompositeLayoutData.grabExcessHorizontalSpace = true;
            addAssertionCompositeLayoutData.horizontalAlignment = GridData.FILL;
            this.addAssertionComposite.setLayoutData ( addAssertionCompositeLayoutData );

            final GridData assertionCompositeLayoutData = new GridData ();
            assertionCompositeLayoutData.grabExcessHorizontalSpace = true;
            assertionCompositeLayoutData.horizontalAlignment = GridData.FILL;
            assertionCompositeLayoutData.grabExcessVerticalSpace = true;
            assertionCompositeLayoutData.verticalAlignment = GridData.FILL;
            this.assertionScrolledComposite.setLayoutData ( assertionCompositeLayoutData );
            this.assertionScrolledComposite.setExpandHorizontal ( true );

            final RowLayout innerlayout = new RowLayout ( SWT.VERTICAL );
            innerlayout.wrap = false;
            this.assertionComposite.setLayout ( innerlayout );
            this.assertionComposite.addListener ( SWT.Resize, new Listener () {
                public void handleEvent ( final org.eclipse.swt.widgets.Event event )
                {
                    final Point s = OrCondition.this.assertionComposite.computeSize ( SWT.DEFAULT, SWT.DEFAULT );
                    OrCondition.this.assertionComposite.setSize ( s.x, s.y );
                    refreshGUI ();
                }
            } );
        }

        private void refreshGUI ()
        {
            this.filterAdvancedComposite.refreshGUI ();
        }

        public void addAssertion ()
        {
            this.assertionComposites.add ( new AssertionComposite ( this, this.assertionComposite, this.addAssertionComposite.attributeCombo.getText (), Type.Text ) );
            refreshGUI ();
            updateFilter ();
        }

        public void removeAssertion ( final AssertionComposite assertion )
        {
            this.assertionComposites.remove ( assertion );
            assertion.dispose ();
            refreshGUI ();
            if ( this.assertionComposites.size () == 0 )
            {
                this.tabItem.setText ( Messages.a_condition );
            }
        }

        public FilterExpression getExpression ()
        {
            final FilterExpression expression = new FilterExpression ();
            expression.setOperator ( Operator.AND );
            for ( final AssertionComposite assertionComposite : this.assertionComposites )
            {
                expression.getFilterSet ().add ( assertionComposite.getExpression () );
            }
            return expression;
        }

        private void updateFilter ()
        {
            this.tabItem.setText ( getExpression ().toString ().replace ( "&", "&&" ) ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    public FilterAdvancedComposite ( final FilterChangedListener filterChangedListener, final Composite parent, final int style )
    {
        // fields
        super ( parent, style );

        // widgets
        this.tabFolder = new CTabFolder ( this, SWT.TOP | SWT.BORDER | SWT.CLOSE );
        this.addOrConditionButton = creteAddOrConditionButton ();
        addOrCondition ();

        // layout
        final GridLayout layout = new GridLayout ( 1, true );
        layout.marginLeft = 6;
        layout.marginRight = 6;
        layout.marginTop = 6;
        layout.marginBottom = 6;
        layout.verticalSpacing = 12;
        this.setLayout ( layout );

        final GridData tabFolderLayoutData = new GridData ();
        tabFolderLayoutData.horizontalAlignment = GridData.FILL;
        tabFolderLayoutData.grabExcessHorizontalSpace = true;
        tabFolderLayoutData.verticalAlignment = GridData.FILL;
        tabFolderLayoutData.grabExcessVerticalSpace = true;
        this.tabFolder.setLayoutData ( tabFolderLayoutData );
        this.tabFolder.setBackgroundMode ( SWT.INHERIT_FORCE );

        final GridData addOrConditionButtonLayoutdata = new GridData ();
        addOrConditionButtonLayoutdata.horizontalAlignment = GridData.END;
        this.addOrConditionButton.setLayoutData ( addOrConditionButtonLayoutdata );
    }

    private Button creteAddOrConditionButton ()
    {
        final Button b = new Button ( this, SWT.PUSH );
        b.setText ( Messages.add_or_condition );
        b.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                addOrCondition ();
            }
        } );
        b.addDisposeListener ( new DisposeListener () {
            public void widgetDisposed ( final DisposeEvent e )
            {
                final int i = FilterAdvancedComposite.this.tabFolder.getSelectionIndex ();
                FilterAdvancedComposite.this.orConditions.remove ( i );
            }
        } );
        return b;
    }

    private void addOrCondition ()
    {
        this.orConditions.add ( new OrCondition ( this, this.tabFolder ) );
        this.tabFolder.setSelection ( this.tabFolder.getItemCount () - 1 );
        refreshGUI ();
    }

    private void refreshGUI ()
    {
        this.layout ( true, true );
    }
}
