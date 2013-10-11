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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.ae.ui.views.Activator;
import org.eclipse.scada.ae.ui.views.Messages;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.VariantEditor;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.eclipse.scada.utils.filter.Assertion;
import org.eclipse.scada.utils.filter.Filter;
import org.eclipse.scada.utils.filter.FilterAssertion;
import org.eclipse.scada.utils.filter.FilterExpression;
import org.eclipse.scada.utils.filter.FilterParser;
import org.eclipse.scada.utils.filter.Operator;
import org.eclipse.scada.utils.lang.Pair;
import org.eclipse.scada.utils.propertyeditors.DateEditor;
import org.eclipse.scada.utils.str.StringHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.statushandlers.StatusManager;

public class FilterQueryByExampleComposite extends Composite
{
    private interface FilterModified
    {
        public void onModified ();
    }

    private interface FieldEntry
    {
        public abstract Filter asExpression ();

        public abstract boolean isEmpty ();

        public abstract void clear ();

        public abstract void focus ();
    }

    private static class DateFieldEntry implements FieldEntry
    {
        private final String field;

        private final Label captionLabel;

        private final Label fromLabel;

        private final Label toLabel;

        private final DateTime fromDate;

        private final DateTime fromTime;

        private final DateTime toDate;

        private final DateTime toTime;

        private final Button useCheckbox;

        private final FilterModified filterModified;

        private static final DateFormat isoDateFormat = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss.SSS" ); //$NON-NLS-1$

        public DateFieldEntry ( final Composite parent, final String field, final String caption, final FilterModified filterModified )
        {
            final GridData dateLayoutData = new GridData ();
            dateLayoutData.widthHint = 180;
            this.field = field;
            this.captionLabel = new Label ( parent, SWT.NONE );
            this.captionLabel.setText ( caption );

            this.filterModified = filterModified;

            this.useCheckbox = new Button ( parent, SWT.CHECK );
            this.useCheckbox.addSelectionListener ( new SelectionAdapter () {
                @Override
                public void widgetSelected ( final SelectionEvent e )
                {
                    updateFromCheckbox ();
                    filterModified.onModified ();
                }
            } );

            this.fromLabel = new Label ( parent, SWT.NONE );
            this.fromLabel.setText ( Messages.from );

            final SelectionAdapter updater = new SelectionAdapter () {
                @Override
                public void widgetSelected ( final SelectionEvent e )
                {
                    filterModified.onModified ();
                }
            };

            Composite wrapper;

            wrapper = new Composite ( parent, SWT.NONE );
            wrapper.setLayout ( new GridLayout ( 2, false ) );

            this.fromDate = new DateTime ( wrapper, SWT.DATE | needBorder () );
            this.fromTime = new DateTime ( wrapper, SWT.TIME | needBorder () );
            this.fromDate.addSelectionListener ( updater );
            this.fromTime.addSelectionListener ( updater );

            this.toLabel = new Label ( parent, SWT.NONE );
            this.toLabel.setText ( Messages.to );

            wrapper = new Composite ( parent, SWT.NONE );
            wrapper.setLayout ( new GridLayout ( 2, false ) );

            this.toDate = new DateTime ( wrapper, SWT.DATE | needBorder () );
            this.toTime = new DateTime ( wrapper, SWT.TIME | needBorder () );
            this.toDate.addSelectionListener ( updater );
            this.toTime.addSelectionListener ( updater );

            updateFromCheckbox ();
        }

        protected void updateFromCheckbox ()
        {
            final boolean enabled = this.useCheckbox.getSelection ();
            this.fromDate.setEnabled ( enabled );
            this.fromTime.setEnabled ( enabled );
            this.toDate.setEnabled ( enabled );
            this.toTime.setEnabled ( enabled );
        }

        @Override
        public Filter asExpression ()
        {
            FilterAssertion assertionFrom = null;
            FilterAssertion assertionTo = null;
            final FilterExpression expression = new FilterExpression ();
            expression.setOperator ( Operator.AND );

            if ( this.useCheckbox.getSelection () )
            {
                // from

                final Calendar from = new GregorianCalendar ();
                from.set ( this.fromDate.getYear (), this.fromDate.getMonth (), this.fromDate.getDay (), this.fromTime.getHours (), this.fromTime.getMinutes (), this.fromTime.getSeconds () );

                assertionFrom = new FilterAssertion ( this.field, Assertion.GREATEREQ, isoDateFormat.format ( from.getTime () ) );
                expression.getFilterSet ().add ( assertionFrom );

                // to

                final Calendar to = new GregorianCalendar ();
                to.set ( this.toDate.getYear (), this.toDate.getMonth (), this.toDate.getDay (), this.toTime.getHours (), this.toTime.getMinutes (), this.toTime.getSeconds () );

                assertionTo = new FilterAssertion ( this.field, Assertion.LESSEQ, isoDateFormat.format ( to.getTime () ) );
                expression.getFilterSet ().add ( assertionTo );
            }

            return expression;
        }

        @Override
        public boolean isEmpty ()
        {
            return !this.useCheckbox.getSelection ();
        }

        @Override
        public void clear ()
        {
            this.useCheckbox.setSelection ( false );
            updateFromCheckbox ();
            this.filterModified.onModified ();
        }

        @Override
        public void focus ()
        {
            this.fromDate.setFocus ();
        }

        public void setFrom ( final Date date )
        {
            this.useCheckbox.setSelection ( true );
            updateFromCheckbox ();

            final Calendar c = new GregorianCalendar ();
            c.setTime ( date );

            this.fromDate.setDate ( c.get ( Calendar.YEAR ), c.get ( Calendar.MONTH ), c.get ( Calendar.DAY_OF_MONTH ) );
            this.fromTime.setTime ( c.get ( Calendar.HOUR_OF_DAY ), c.get ( Calendar.MINUTE ), c.get ( Calendar.SECOND ) );
        }

        public void setTo ( final Date date )
        {
            this.useCheckbox.setSelection ( true );
            updateFromCheckbox ();

            final Calendar c = new GregorianCalendar ();
            c.setTime ( date );

            this.toDate.setDate ( c.get ( Calendar.YEAR ), c.get ( Calendar.MONTH ), c.get ( Calendar.DAY_OF_MONTH ) );
            this.toTime.setTime ( c.get ( Calendar.HOUR_OF_DAY ), c.get ( Calendar.MINUTE ), c.get ( Calendar.SECOND ) );

        }
    }

    private static class TextFieldEntry implements FieldEntry
    {
        protected final String field;

        protected final Label captionLabel;

        protected final Button notCheckBox;

        protected final Text textText;

        public TextFieldEntry ( final Composite parent, final String field, final String caption, final FilterModified filterModified )
        {
            this.field = field;
            this.captionLabel = new Label ( parent, SWT.NONE );
            this.captionLabel.setText ( caption );
            this.notCheckBox = new Button ( parent, SWT.CHECK );
            this.notCheckBox.setText ( Messages.not );
            this.notCheckBox.addSelectionListener ( new SelectionListener () {
                @Override
                public void widgetSelected ( final SelectionEvent e )
                {
                    filterModified.onModified ();
                }

                @Override
                public void widgetDefaultSelected ( final SelectionEvent e )
                {
                }
            } );
            this.textText = new Text ( parent, SWT.BORDER );
            final GridData layoutData = new GridData ();
            layoutData.horizontalAlignment = GridData.FILL;
            layoutData.horizontalSpan = 4;
            layoutData.grabExcessHorizontalSpace = true;
            this.textText.setLayoutData ( layoutData );
            this.textText.addSelectionListener ( new SelectionAdapter () {
                @Override
                public void widgetSelected ( final SelectionEvent e )
                {
                    filterModified.onModified ();
                }
            } );
            this.textText.addModifyListener ( new ModifyListener () {
                @Override
                public void modifyText ( final ModifyEvent e )
                {
                    filterModified.onModified ();
                }
            } );
        }

        @Override
        public Filter asExpression ()
        {
            final FilterAssertion assertion;
            if ( this.textText.getText ().contains ( "*" ) ) //$NON-NLS-1$
            {
                assertion = new FilterAssertion ( this.field, Assertion.SUBSTRING, toCollection ( this.textText.getText () ) );
            }
            else
            {
                assertion = new FilterAssertion ( this.field, Assertion.EQUALITY, this.textText.getText () );
            }
            if ( this.notCheckBox.getSelection () )
            {
                return FilterExpression.negate ( assertion );
            }
            return assertion;
        }

        @Override
        public boolean isEmpty ()
        {
            return this.textText.getText ().trim ().length () == 0;
        }

        @Override
        public void clear ()
        {
            this.textText.setText ( "" );//$NON-NLS-1$
        }

        @Override
        public void focus ()
        {
            this.textText.setFocus ();
        }

        public void setValue ( final String value )
        {
            this.textText.setText ( value );
        }

        public void setNegation ( final boolean negate )
        {
            this.notCheckBox.setSelection ( negate );
        }
    }

    // clear button
    final Button clearButton;

    private final Map<String, FieldEntry> fields = new HashMap<String, FieldEntry> ();

    public FilterQueryByExampleComposite ( final FilterChangedListener filterChangedListener, final Composite parent, final int style, final String filter )
    {
        super ( parent, style );

        final GridLayout layout = new GridLayout ();
        layout.numColumns = 6;
        layout.marginHeight = 12;
        layout.marginWidth = 12;
        setLayout ( layout );

        final FilterModified filterModified = new FilterModified () {
            @Override
            public void onModified ()
            {
                final String filterString = toFilter ().toString ();
                filterChangedListener.onFilterChanged ( new Pair<SearchType, String> ( SearchType.SIMPLE, filterString ) );
            };
        };
        this.fields.put ( "sourceTimestamp", new DateFieldEntry ( this, "sourceTimestamp", Messages.sourceTimestamp, filterModified ) ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        this.fields.put ( "entryTimestamp", new DateFieldEntry ( this, "entryTimestamp", Messages.entryTimestamp, filterModified ) ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

        this.fields.put ( "message", new TextFieldEntry ( this, "message", Messages.message, filterModified ) ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        this.fields.put ( "monitorType", new TextFieldEntry ( this, "monitorType", Messages.monitorType, filterModified ) ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        this.fields.put ( "eventType", new TextFieldEntry ( this, "eventType", Messages.eventType, filterModified ) ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        this.fields.put ( "item", new TextFieldEntry ( this, "item", Messages.item, filterModified ) ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        this.fields.put ( "value", new TextFieldEntry ( this, "value", Messages.value, filterModified ) ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        this.fields.put ( "priority", new TextFieldEntry ( this, "priority", Messages.priority, filterModified ) ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        this.fields.put ( "source", new TextFieldEntry ( this, "source", Messages.source, filterModified ) ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        this.fields.put ( "actorType", new TextFieldEntry ( this, "actorType", Messages.actorType, filterModified ) ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        this.fields.put ( "actorName", new TextFieldEntry ( this, "actorName", Messages.actorName, filterModified ) ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        this.fields.put ( "component", new TextFieldEntry ( this, "component", Messages.component, filterModified ) ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        this.fields.put ( "system", new TextFieldEntry ( this, "system", Messages.system, filterModified ) ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        this.fields.put ( "hive", new TextFieldEntry ( this, "hive", Messages.hive, filterModified ) ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        this.fields.put ( "location", new TextFieldEntry ( this, "location", Messages.location, filterModified ) ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        this.fields.put ( "messageSource", new TextFieldEntry ( this, "messageSource", Messages.messageSource, filterModified ) );
        this.fields.put ( "comment", new TextFieldEntry ( this, "comment", Messages.comment, filterModified ) ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

        // clear button
        this.clearButton = new Button ( this, SWT.PUSH );
        this.clearButton.setText ( Messages.clear );
        final GridData clearButtonLayoutData = new GridData ();
        clearButtonLayoutData.horizontalAlignment = SWT.BEGINNING;
        clearButtonLayoutData.horizontalSpan = 6;
        this.clearButton.setLayoutData ( clearButtonLayoutData );
        this.clearButton.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent e )
            {
                for ( final FieldEntry fieldEntry : FilterQueryByExampleComposite.this.fields.values () )
                {
                    fieldEntry.clear ();
                }
                FilterQueryByExampleComposite.this.fields.get ( "sourceTimestamp" ).focus (); //$NON-NLS-1$
            }
        } );

        populateFromFilter ( filter );

        this.fields.get ( "sourceTimestamp" ).focus (); //$NON-NLS-1$
    }

    public static int needBorder ()
    {
        return SWT.BORDER;
    }

    private void populateFromFilter ( final String filterString )
    {
        // no filter given
        if ( ( filterString == null ) || ( filterString.length () == 0 ) )
        {
            return;
        }
        // it has to be an expression
        final Filter filter;
        try
        {
            filter = new FilterParser ( filterString ).getFilter ();
        }
        catch ( final Exception e )
        {
            StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ), StatusManager.LOG );
            return;
        }
        if ( !filter.isExpression () )
        {
            return;
        }
        final FilterExpression filterExpression = (FilterExpression)filter;
        // and it has to be a and conjunction 
        if ( filterExpression.getOperator () != Operator.AND )
        {
            return;
        }
        for ( final Filter subFilter : filterExpression.getFilterSet () )
        {
            if ( subFilter.isAssertion () )
            {
                // normal case
                populateFromAssertion ( false, (FilterAssertion)subFilter );
            }
            else if ( subFilter.isExpression () )
            {
                // negation
                final FilterExpression subFilterExpression = (FilterExpression)subFilter;
                if ( subFilterExpression.getOperator () == Operator.NOT )
                {
                    if ( ( subFilterExpression.getFilterSet ().size () == 1 ) && subFilterExpression.getFilterSet ().get ( 0 ).isAssertion () )
                    {
                        populateFromAssertion ( true, (FilterAssertion)subFilterExpression.getFilterSet ().get ( 0 ) );
                    }
                }
                // special handling for date
                else if ( subFilterExpression.getOperator () == Operator.AND )
                {
                    String attribute = null;
                    String from = null;
                    String to = null;
                    if ( ( subFilterExpression.getFilterSet ().size () == 1 ) || ( ( subFilterExpression.getFilterSet ().size () == 2 ) && subFilterExpression.getFilterSet ().get ( 0 ).isAssertion () ) )
                    {
                        final FilterAssertion filterAssertion = (FilterAssertion)subFilterExpression.getFilterSet ().get ( 0 );
                        attribute = filterAssertion.getAttribute ();
                        if ( ( filterAssertion != null ) && ( filterAssertion.getAssertion () == Assertion.GREATEREQ ) )
                        {
                            from = (String)filterAssertion.getValue ();
                        }
                        else if ( ( filterAssertion != null ) && ( filterAssertion.getAssertion () == Assertion.LESSEQ ) )
                        {
                            to = (String)filterAssertion.getValue ();
                        }
                    }
                    if ( ( subFilterExpression.getFilterSet ().size () == 2 ) && subFilterExpression.getFilterSet ().get ( 1 ).isAssertion () )
                    {
                        final FilterAssertion filterAssertion = (FilterAssertion)subFilterExpression.getFilterSet ().get ( 1 );
                        if ( ( filterAssertion != null ) && ( filterAssertion.getAssertion () == Assertion.GREATEREQ ) )
                        {
                            from = (String)filterAssertion.getValue ();
                        }
                        else if ( ( filterAssertion != null ) && ( filterAssertion.getAssertion () == Assertion.LESSEQ ) )
                        {
                            to = (String)filterAssertion.getValue ();
                        }
                    }
                    populateFromDate ( attribute, from, to );
                }
            }
        }
    }

    private void populateFromAssertion ( final boolean negate, final FilterAssertion filter )
    {
        final FieldEntry fieldEntry = this.fields.get ( filter.getAttribute () );
        if ( fieldEntry instanceof TextFieldEntry )
        {
            final VariantEditor ve = new VariantEditor ();
            // special case if filter is substring
            if ( filter.getValue () instanceof String )
            {
                ve.setAsText ( (String)filter.getValue () );
            }
            else if ( filter.getValue () instanceof Collection<?> )
            {
                ve.setAsText ( StringHelper.join ( (Collection<?>)filter.getValue (), "*" ) ); //$NON-NLS-1$
            }
            final Variant value = (Variant)ve.getValue ();
            ( (TextFieldEntry)fieldEntry ).setValue ( value.toLabel ( "" ) ); //$NON-NLS-1$
            ( (TextFieldEntry)fieldEntry ).setNegation ( negate );
        }
    }

    private void populateFromDate ( final String fieldName, final String from, final String to )
    {
        final FieldEntry fieldEntry = this.fields.get ( fieldName );
        if ( fieldEntry instanceof DateFieldEntry )
        {
            final DateEditor dateEditor = new DateEditor ();
            final DateFieldEntry dateFieldEntry = (DateFieldEntry)fieldEntry;
            dateEditor.setAsText ( from );
            dateFieldEntry.setFrom ( (Date)dateEditor.getValue () );
            dateEditor.setAsText ( to );
            dateFieldEntry.setTo ( (Date)dateEditor.getValue () );
        }
    }

    private Filter toFilter ()
    {
        final FilterExpression filter = new FilterExpression ();
        filter.setOperator ( Operator.AND );
        for ( final FieldEntry fieldEntry : this.fields.values () )
        {
            if ( !fieldEntry.isEmpty () )
            {
                filter.getFilterSet ().add ( fieldEntry.asExpression () );
            }
        }
        return filter;
    }

    private static Collection<String> toCollection ( final String text )
    {
        final ArrayList<String> result = new ArrayList<String> ();
        result.addAll ( Arrays.asList ( text.split ( "\\*" ) ) ); //$NON-NLS-1$
        if ( text.endsWith ( "*" ) ) //$NON-NLS-1$
        {
            result.add ( "" ); //$NON-NLS-1$
        }
        return result;
    }
}
