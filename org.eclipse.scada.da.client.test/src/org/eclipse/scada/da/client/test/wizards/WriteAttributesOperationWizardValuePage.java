/*******************************************************************************
 * Copyright (c) 2009, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.client.test.wizards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.client.base.browser.ValueType;
import org.eclipse.scada.da.ui.connection.data.Item;
import org.eclipse.scada.da.ui.connection.data.ItemSelectionHelper;
import org.eclipse.scada.da.ui.widgets.realtime.AttributePair;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class WriteAttributesOperationWizardValuePage extends WizardPage implements IWizardPage
{

    private final static Logger logger = LoggerFactory.getLogger ( WriteAttributesOperationWizardValuePage.class );

    private Text itemIdText;

    private TableViewer table;

    private class AttributeEntry
    {
        private String name = "";

        private ValueType valueType = ValueType.STRING;

        private String valueString = "";

        private Variant value = Variant.NULL;

        private Throwable valueError = null;

        public AttributeEntry ( final String name, final ValueType valueType, final String value )
        {
            super ();
            this.name = name;
            this.valueType = valueType;
            setValue ( value );
        }

        public String getName ()
        {
            return this.name;
        }

        public void setName ( final String name )
        {
            this.name = name;
        }

        public Variant getValue ()
        {
            return this.value;
        }

        public String getValueString ()
        {
            return this.valueString;
        }

        public void setValue ( final String value )
        {
            try
            {
                this.valueString = value;
                this.value = this.valueType.convertTo ( value );
                this.valueError = null;
            }
            catch ( final Exception e )
            {
                this.valueError = e;
            }
        }

        public ValueType getValueType ()
        {
            return this.valueType;
        }

        public void setValueType ( final ValueType valueType )
        {
            this.valueType = valueType;
            setValue ( this.valueString );
        }

        public Throwable getValueError ()
        {
            return this.valueError;
        }
    }

    private class Attributes
    {
        private final List<AttributeEntry> entries = new ArrayList<AttributeEntry> ();

        public void add ( final AttributeEntry entry )
        {
            this.entries.add ( entry );
        }

        public void remove ( final AttributeEntry entry )
        {
            this.entries.remove ( entry );
        }

        public List<AttributeEntry> getEntries ()
        {
            return this.entries;
        }
    }

    private class MyLabelProvider extends LabelProvider implements ITableLabelProvider
    {

        @Override
        public Image getColumnImage ( final Object element, final int columnIndex )
        {
            return getImage ( element );
        }

        @Override
        public String getColumnText ( final Object element, final int columnIndex )
        {
            logger.debug ( "Label for: {} - {}", element, columnIndex );

            if ( element instanceof AttributeEntry )
            {
                final AttributeEntry entry = (AttributeEntry)element;
                logger.debug ( "Label: {}", entry.getName () );
                switch ( columnIndex )
                {
                case 0:
                    return entry.getName ();
                case 1:
                    return entry.getValueType ().toString ();
                case 2:
                    return entry.getValue ().asString ( "<null>" );
                case 3:
                {
                    if ( entry.getValueError () != null )
                    {
                        return entry.getValueError ().getMessage ();
                    }
                    return "";
                }
                }
            }
            return getText ( element );
        }

    }

    private class MyContentProvider implements IStructuredContentProvider
    {
        @Override
        public Object[] getElements ( final Object inputElement )
        {
            if ( inputElement instanceof Attributes )
            {
                final Attributes attributes = (Attributes)inputElement;
                return attributes.getEntries ().toArray ( new AttributeEntry[0] );
            }
            return new Object[0];
        }

        @Override
        public void dispose ()
        {
        }

        @Override
        public void inputChanged ( final Viewer viewer, final Object oldInput, final Object newInput )
        {
        }

    }

    private ComboBoxCellEditor valueTypeEditor;

    private final String[] PROPERTIES = new String[] { "name", "value-type", "value", "value-error" };

    private class MyCellModifier implements ICellModifier
    {
        private TableViewer viewer = null;

        public MyCellModifier ( final TableViewer viewer )
        {
            this.viewer = viewer;
        }

        @Override
        public boolean canModify ( final Object element, final String property )
        {
            logger.debug ( "Can modify: {}:{}", element, property );

            if ( element instanceof AttributeEntry )
            {
                if ( property.equals ( "value" ) )
                {
                    return true;
                }
                if ( property.equals ( "name" ) )
                {
                    return true;
                }
                if ( property.equals ( "value-type" ) )
                {
                    return true;
                }
            }
            return false;
        }

        @Override
        public Object getValue ( final Object element, final String property )
        {
            logger.debug ( "Get Value: " + element + ":" + property );

            if ( element instanceof AttributeEntry )
            {
                final AttributeEntry entry = (AttributeEntry)element;
                if ( property.equals ( "value" ) )
                {
                    return entry.getValueString ();
                }
                if ( property.equals ( "name" ) )
                {
                    return entry.getName ();
                }
                if ( property.equals ( "value-type" ) )
                {
                    return entry.getValueType ().index ();
                }
            }
            return null;
        }

        @Override
        public void modify ( final Object element, final String property, final Object value )
        {
            logger.debug ( "Modify Value: {}:{}:{}", new Object[] { element, property, value } );

            final TableItem tableItem = (TableItem)element;

            if ( tableItem.getData () instanceof AttributeEntry )
            {
                final AttributeEntry entry = (AttributeEntry)tableItem.getData ();
                if ( property.equals ( "value" ) )
                {
                    entry.setValue ( value.toString () );
                }
                else if ( property.equals ( "name" ) )
                {
                    entry.setName ( value.toString () );
                }
                else if ( property.equals ( "value-type" ) )
                {
                    final Integer i = (Integer)value;
                    final String valueType = WriteAttributesOperationWizardValuePage.this.valueTypeEditor.getItems ()[i];
                    for ( final ValueType vt : ValueType.values () )
                    {
                        if ( vt.label ().equals ( valueType ) )
                        {
                            entry.setValueType ( vt );
                        }
                    }
                }
                this.viewer.update ( entry, WriteAttributesOperationWizardValuePage.this.PROPERTIES );
                dialogChanged ();
            }
        }
    }

    private final Attributes attributes = new Attributes ();

    private class AddAction extends Action
    {
        public AddAction ()
        {
            super ( "Add Entry", IAction.AS_PUSH_BUTTON );
            setEnabled ( true );
        }

        @Override
        public void run ()
        {
            final AttributeEntry entry = new AttributeEntry ( "", ValueType.STRING, "" );
            WriteAttributesOperationWizardValuePage.this.attributes.add ( entry );
            WriteAttributesOperationWizardValuePage.this.table.add ( entry );
            dialogChanged ();
        }
    }

    private class RemoveAction extends Action implements ISelectionChangedListener
    {

        private ISelection selection;

        public RemoveAction ()
        {
            super ( "Remove Entry", IAction.AS_PUSH_BUTTON );
        }

        @Override
        public void run ()
        {
            if ( this.selection instanceof IStructuredSelection )
            {
                final IStructuredSelection selection = (IStructuredSelection)this.selection;
                final Iterator<?> i = selection.iterator ();
                while ( i.hasNext () )
                {
                    final Object o = i.next ();
                    if ( o instanceof AttributeEntry )
                    {
                        WriteAttributesOperationWizardValuePage.this.attributes.remove ( (AttributeEntry)o );
                        WriteAttributesOperationWizardValuePage.this.table.remove ( o );
                    }
                }
                dialogChanged ();
            }
        }

        @Override
        public void selectionChanged ( final SelectionChangedEvent event )
        {
            this.selection = event.getSelection ();
        }

    }

    private final AddAction addAction = new AddAction ();

    private final RemoveAction removeAction = new RemoveAction ();

    private Item item;

    protected WriteAttributesOperationWizardValuePage ()
    {
        super ( "wizardPage" );
        setTitle ( "Write Attributes" );
        setDescription ( "Configure the attributes to write" );
    }

    @Override
    public void createControl ( final Composite parent )
    {
        final Composite container = new Composite ( parent, SWT.NONE );

        final GridLayout layout = new GridLayout ();
        container.setLayout ( layout );
        layout.numColumns = 3;
        layout.verticalSpacing = 9;

        Label label = new Label ( container, SWT.NONE );
        label.setText ( "&Item:" );

        this.itemIdText = new Text ( container, SWT.BORDER | SWT.SINGLE );
        GridData gd = new GridData ( GridData.FILL_HORIZONTAL );
        this.itemIdText.setLayoutData ( gd );
        this.itemIdText.addModifyListener ( new ModifyListener () {
            @Override
            public void modifyText ( final ModifyEvent e )
            {
                dialogChanged ();
            }
        } );

        label = new Label ( container, SWT.NONE );

        // row 2

        gd = new GridData ( GridData.FILL_HORIZONTAL );
        gd.horizontalSpan = 3;
        gd.grabExcessHorizontalSpace = true;
        final ToolBar toolbar = new ToolBar ( container, SWT.NONE );
        toolbar.setLayoutData ( gd );
        final ToolBarManager tbm = new ToolBarManager ( toolbar );
        tbm.add ( this.addAction );
        tbm.add ( this.removeAction );
        tbm.update ( true );

        // row 3

        gd = new GridData ( GridData.FILL_BOTH );
        gd.horizontalSpan = 3;
        gd.grabExcessHorizontalSpace = true;
        gd.grabExcessVerticalSpace = true;
        this.table = new TableViewer ( container, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL );

        TableColumn col;

        col = new TableColumn ( this.table.getTable (), SWT.NONE );
        col.setText ( "Name" );
        col = new TableColumn ( this.table.getTable (), SWT.NONE );
        col.setText ( "Value Type" );
        col = new TableColumn ( this.table.getTable (), SWT.NONE );
        col.setText ( "Value" );
        col = new TableColumn ( this.table.getTable (), SWT.NONE );
        col.setText ( "Value Error" );
        this.table.getTable ().setHeaderVisible ( true );

        try
        {
            this.table.setLabelProvider ( new MyLabelProvider () );
            this.table.setContentProvider ( new MyContentProvider () );

            this.table.setColumnProperties ( this.PROPERTIES );
            this.table.setCellModifier ( new MyCellModifier ( this.table ) );

            final TextCellEditor nameEditor = new TextCellEditor ( this.table.getTable () );

            final List<String> values = new LinkedList<String> ();
            for ( final ValueType vt : ValueType.values () )
            {
                values.add ( vt.label () );
            }
            this.valueTypeEditor = new ComboBoxCellEditor ( this.table.getTable (), values.toArray ( new String[0] ) );

            final TextCellEditor valueEditor = new TextCellEditor ( this.table.getTable () );
            this.table.setCellEditors ( new CellEditor[] { nameEditor, this.valueTypeEditor, valueEditor, new TextCellEditor ( this.table.getTable () ) } );

            final TableLayout tableLayout = new TableLayout ();
            tableLayout.addColumnData ( new ColumnWeightData ( 50, 75, true ) );
            tableLayout.addColumnData ( new ColumnWeightData ( 50, 75, true ) );
            tableLayout.addColumnData ( new ColumnWeightData ( 50, 75, true ) );
            tableLayout.addColumnData ( new ColumnWeightData ( 50, 75, true ) );
            this.table.getTable ().setLayout ( tableLayout );

            this.table.setInput ( this.attributes );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Unable to create control", e );
        }

        this.table.getTable ().setLayoutData ( gd );
        this.table.addSelectionChangedListener ( this.removeAction );

        setControl ( container );
        updateSelection ();
        dialogChanged ();
    }

    private void updateSelection ()
    {
        this.itemIdText.setText ( this.item.getId () );
    }

    private void dialogChanged ()
    {
        // connection
        if ( this.item == null )
        {
            updateStatus ( "No item selection" );
            return;
        }

        // item
        if ( this.itemIdText.getText ().length () <= 0 )
        {
            updateStatus ( "Item name must not be empty" );
            return;
        }

        if ( this.attributes.entries.size () <= 0 )
        {
            updateStatus ( "No attributes" );
            return;
        }

        for ( final AttributeEntry entry : this.attributes.entries )
        {
            if ( entry.name.equals ( "" ) )
            {
                updateStatus ( "Attribute with an empty name is not allowed" );
                return;
            }
        }

        updateStatus ( null );
    }

    private void updateStatus ( final String message )
    {
        setErrorMessage ( message );
        setPageComplete ( message == null );
    }

    public Item getItem ()
    {
        return new Item ( this.item.getConnectionString (), this.itemIdText.getText (), this.item.getType () );
    }

    public Map<String, Variant> getAttributes ()
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ();

        for ( final AttributeEntry entry : this.attributes.entries )
        {
            attributes.put ( entry.getName (), entry.getValue () );
        }

        return attributes;
    }

    public void setSelection ( final IStructuredSelection selection )
    {
        this.item = ItemSelectionHelper.getFirstFromSelection ( selection );
        findAttributes ( selection );
    }

    private void findAttributes ( final IStructuredSelection selection )
    {
        final Iterator<?> i = selection.iterator ();
        while ( i.hasNext () )
        {
            final Object o = i.next ();
            if ( o instanceof AttributePair )
            {
                final AttributePair pair = (AttributePair)o;

                final AttributeEntry entry = new AttributeEntry ( pair.key, ValueType.fromVariantType ( pair.value.getType () ), pair.value.asString ( "" ) );
                this.attributes.add ( entry );
                if ( this.table != null )
                {
                    this.table.add ( entry );
                }
            }
        }
    }
}