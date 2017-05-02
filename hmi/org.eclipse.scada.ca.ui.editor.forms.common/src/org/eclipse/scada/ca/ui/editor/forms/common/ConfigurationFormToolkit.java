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
package org.eclipse.scada.ca.ui.editor.forms.common;

import java.util.Map;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.Observables;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.IViewerObservableList;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableValueEditingSupport;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.window.Window;
import org.eclipse.scada.ca.ui.editor.EditorHelper;
import org.eclipse.scada.ca.ui.editor.forms.common.internal.Activator;
import org.eclipse.scada.ca.ui.editor.input.ConfigurationEditorInput;
import org.eclipse.scada.ui.databinding.observable.KeyPrefixMapObservable;
import org.eclipse.scada.ui.databinding.observable.ObservableMapContentProvider;
import org.eclipse.scada.ui.databinding.observable.StringSplitListObservable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

public class ConfigurationFormToolkit
{
    private final FormToolkit toolkit;

    private final boolean toolkitCreated;

    private final DataBindingContext dbc;

    public ConfigurationFormToolkit ( final Display display )
    {
        this.toolkit = new FormToolkit ( display );
        this.toolkitCreated = true;

        this.dbc = new DataBindingContext ();
    }

    public ConfigurationFormToolkit ( final FormToolkit providedToolkit )
    {
        this.toolkit = providedToolkit;
        this.toolkitCreated = false;

        this.dbc = new DataBindingContext ();
    }

    public DataBindingContext getDataBindingContext ()
    {
        return this.dbc;
    }

    public FormToolkit getFormToolkit ()
    {
        return this.toolkit;
    }

    public void dispose ()
    {
        if ( this.toolkitCreated )
        {
            this.toolkit.dispose ();
        }
    }

    public ScrolledForm createScrolledForm ( final Composite parent, final String label )
    {
        final ScrolledForm form = this.toolkit.createScrolledForm ( parent );
        form.setText ( label );
        this.toolkit.decorateFormHeading ( form.getForm () );
        return form;
    }

    // standard section

    public Composite createStandardSection ( final Composite parent, final String sectionLabel )
    {
        return createStandardSection ( parent, sectionLabel, false );
    }

    public Composite createStandardSection ( final Composite parent, final String sectionLabel, final boolean fillVeritcal )
    {
        final Section section = this.toolkit.createSection ( parent, sectionLabel != null ? ExpandableComposite.TITLE_BAR : ExpandableComposite.NO_TITLE );
        if ( sectionLabel != null )
        {
            section.setText ( sectionLabel );
        }

        final Composite client = createStandardComposite ( section );
        section.setClient ( client );
        client.setLayout ( new GridLayout ( 3, false ) );
        section.setLayoutData ( new GridData ( GridData.FILL, GridData.BEGINNING, true, fillVeritcal ) );

        return client;
    }

    public Composite createStandardComposite ( final Composite parent )
    {
        final Composite client = this.toolkit.createComposite ( parent, SWT.NONE );

        this.toolkit.paintBordersFor ( client );

        return client;
    }

    public void createStandardLinkText ( final Composite parent, final String linkFactory, final String attributeName, final String label, final String textMessage, final ConfigurationEditorInput input, final Object valueType )
    {
        this.toolkit.createLabel ( parent, label + ":" );

        final Text text = this.toolkit.createText ( parent, "" );
        text.setMessage ( textMessage );
        text.setLayoutData ( new GridData ( GridData.FILL, GridData.BEGINNING, true, true ) );
        text.setToolTipText ( textMessage );

        final IObservableValue value = Observables.observeMapEntry ( input.getDataMap (), attributeName, valueType );
        this.dbc.bindValue ( WidgetProperties.text ( SWT.Modify ).observe ( text ), value );

        final Hyperlink link = this.toolkit.createHyperlink ( parent, "link", SWT.NONE );
        link.setLayoutData ( new GridData ( GridData.FILL, GridData.BEGINNING, false, false ) );

        link.addHyperlinkListener ( new HyperlinkAdapter () {

            @Override
            public void linkActivated ( final HyperlinkEvent e )
            {
                EditorHelper.handleOpen ( PlatformUI.getWorkbench ().getActiveWorkbenchWindow ().getActivePage (), input.getConnectionUri (), linkFactory, text.getText () );
            }
        } );
    }

    public void createStandardText ( final Composite parent, final String attributeName, final String label, final String textMessage, final IObservableMap data, final Object valueType )
    {
        createStandardText ( parent, attributeName, SWT.SINGLE, label, textMessage, data, valueType );
    }

    public void createStandardMultiText ( final Composite parent, final String attributeName, final String label, final String textMessage, final IObservableMap data, final Object valueType )
    {
        createStandardText ( parent, attributeName, SWT.MULTI, label, textMessage, data, valueType );
    }

    public void createStandardText ( final Composite parent, final String attributeName, final int style, final String label, final String textMessage, final IObservableMap data, final Object valueType )
    {
        final Label labelControl = this.toolkit.createLabel ( parent, label + ":" );

        final boolean multi = ( style & SWT.MULTI ) > 0;

        if ( multi )
        {
            labelControl.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, false, false ) );
        }

        final Text text = this.toolkit.createText ( parent, "", style );
        text.setMessage ( textMessage );
        final GridData gd = new GridData ( GridData.FILL, multi ? GridData.FILL : GridData.BEGINNING, true, true );
        gd.horizontalSpan = 2;
        text.setLayoutData ( gd );
        text.setToolTipText ( textMessage );

        final IObservableValue value = Observables.observeMapEntry ( data, attributeName, String.class );

        if ( valueType != null && valueType != String.class )
        {
            final WritableValue conversionValue = new WritableValue ( null, valueType );
            this.dbc.bindValue ( WidgetProperties.text ( SWT.Modify ).observe ( text ), conversionValue );
            this.dbc.bindValue ( conversionValue, value );
        }
        else
        {
            this.dbc.bindValue ( WidgetProperties.text ( SWT.Modify ).observe ( text ), value );
        }
    }

    public void createStandardCombo ( final Composite parent, final String attributeName, final String label, final Object[] items, final IObservableMap data, final Object valueType )
    {
        final String[] stringItems = new String[items.length];

        for ( int i = 0; i < items.length; i++ )
        {
            stringItems[i] = items[i].toString ();
        }

        createStandardCombo ( parent, attributeName, label, stringItems, data, valueType );
    }

    public void createStandardCombo ( final Composite parent, final String attributeName, final String label, final String[] items, final IObservableMap data, final Object valueType )
    {
        this.toolkit.createLabel ( parent, label + ":" );

        final Combo combo = new Combo ( parent, SWT.DROP_DOWN );

        combo.setItems ( items );
        this.toolkit.adapt ( combo );

        final GridData gd = new GridData ( GridData.FILL, GridData.BEGINNING, true, true );
        gd.horizontalSpan = 2;
        combo.setLayoutData ( gd );

        final IObservableValue value = Observables.observeMapEntry ( data, attributeName, valueType );
        this.dbc.bindValue ( WidgetProperties.text ().observe ( combo ), value );
    }

    public void createStandardCheckbox ( final Composite parent, final String attributeName, final String label, final IObservableMap data, final Object valueType )
    {
        final Button button = this.toolkit.createButton ( parent, label, SWT.CHECK );
        {
            final GridData gd = new GridData ( GridData.FILL_HORIZONTAL );
            gd.horizontalSpan = 3;
            button.setLayoutData ( gd );
            final IObservableValue value = Observables.observeMapEntry ( data, attributeName, valueType );
            this.dbc.bindValue ( WidgetProperties.selection ().observe ( button ), value );
        }
    }

    // info table

    public void createInfoSection ( final ScrolledForm form, final ConfigurationEditorInput input )
    {
        createTableSection ( form, input, "info.", "Informational Attributes" );
    }

    public void createListSection ( final ScrolledForm form, final ConfigurationEditorInput input, final String attribute, final String label, final String delimiter, final String pattern )
    {
        final IObservableList list = StringSplitListObservable.observeString ( Observables.observeMapEntry ( input.getDataMap (), attribute, String.class ), delimiter, pattern );

        // section

        final Section section = this.toolkit.createSection ( form.getBody (), ExpandableComposite.TITLE_BAR );
        section.setText ( label );

        final Composite client = this.toolkit.createComposite ( section, SWT.NONE );
        section.setClient ( client );
        this.toolkit.paintBordersFor ( client );

        client.setLayout ( new GridLayout ( 1, true ) );
        final GridData gd = new GridData ( GridData.FILL_BOTH );
        gd.horizontalSpan = 2;
        section.setLayoutData ( gd );

        // fields
        final ListViewer viewer = new ListViewer ( client );

        viewer.setContentProvider ( new ObservableListContentProvider () );
        viewer.setInput ( list );

        viewer.getControl ().setLayoutData ( new GridData ( GridData.FILL_BOTH ) );

        viewer.setSorter ( new ViewerSorter () );
    }

    public void createTableSection ( final ScrolledForm form, final ConfigurationEditorInput input, final String prefix, final String label )
    {

        // data
        final IObservableMap map = KeyPrefixMapObservable.observePrefix ( input.getDataMap (), String.class, prefix, true );

        // section

        final Section section = this.toolkit.createSection ( form.getBody (), ExpandableComposite.TITLE_BAR );
        section.setText ( label );

        final Composite client = this.toolkit.createComposite ( section, SWT.NONE );
        section.setClient ( client );
        this.toolkit.paintBordersFor ( client );

        client.setLayout ( new GridLayout ( 1, true ) );
        final GridData gd = new GridData ( GridData.FILL_BOTH );
        gd.horizontalSpan = 2;
        section.setLayoutData ( gd );

        // fields
        final TableViewer viewer = new TableViewer ( client );

        final TableLayout tableLayout = new TableLayout ();
        viewer.getTable ().setLayout ( tableLayout );

        {
            final TableViewerColumn col = new TableViewerColumn ( viewer, SWT.NONE );
            col.getColumn ().setText ( "Key" );
            col.setLabelProvider ( new CellLabelProvider () {

                @Override
                public void update ( final ViewerCell cell )
                {
                    cell.setText ( String.format ( "%s", ( (Map.Entry<?, ?>)cell.getElement () ).getKey () ) );
                }
            } );
            tableLayout.addColumnData ( new ColumnWeightData ( 50, true ) );
        }
        {
            final TableViewerColumn col = new TableViewerColumn ( viewer, SWT.NONE );
            col.getColumn ().setText ( "Value" );
            col.setLabelProvider ( new CellLabelProvider () {

                @Override
                public void update ( final ViewerCell cell )
                {
                    cell.setText ( String.format ( "%s", ( (Map.Entry<?, ?>)cell.getElement () ).getValue () ) );
                }
            } );
            tableLayout.addColumnData ( new ColumnWeightData ( 100, true ) );
            col.setEditingSupport ( new InlineEditingSupport ( map, viewer, this.dbc ) );
        }

        viewer.getTable ().setHeaderVisible ( true );

        viewer.setContentProvider ( new ObservableMapContentProvider () );
        viewer.setInput ( map );

        viewer.getControl ().setLayoutData ( new GridData ( GridData.FILL_BOTH ) );

        viewer.setSorter ( new ViewerSorter () );

        final ToolBarManager tbm = new ToolBarManager ();
        tbm.add ( new AddAction ( map, form.getShell () ) );
        tbm.add ( new RemoveAction ( map, ViewersObservables.observeMultiSelection ( viewer ) ) );
        section.setTextClient ( tbm.createControl ( section ) );

    }

    private static class RemoveAction extends Action
    {
        private final IObservableMap map;

        private final IViewerObservableList selectedItems;

        public RemoveAction ( final IObservableMap map, final IViewerObservableList selectedItems )
        {
            this.map = map;
            this.selectedItems = selectedItems;
        }

        @Override
        public String getText ()
        {
            return "-";
        }

        @Override
        public ImageDescriptor getImageDescriptor ()
        {
            return ImageDescriptor.createFromURL ( Activator.getDefault ().getBundle ().getEntry ( "/icons/delete.gif" ) );
        }

        @Override
        public void run ()
        {
            for ( final Object o : this.selectedItems )
            {
                final Map.Entry<?, ?> entry = (Map.Entry<?, ?>)o;
                this.map.remove ( entry.getKey () );
            }
        }
    }

    private static class AddAction extends Action
    {
        private final IObservableMap map;

        private final Shell shell;

        public AddAction ( final IObservableMap map, final Shell shell )
        {
            this.map = map;
            this.shell = shell;
        }

        @Override
        public String getText ()
        {
            return "+";
        }

        @Override
        public ImageDescriptor getImageDescriptor ()
        {
            return ImageDescriptor.createFromURL ( Activator.getDefault ().getBundle ().getEntry ( "/icons/add.gif" ) );
        }

        @Override
        public void runWithEvent ( final Event event )
        {
            final InputDialog dialog = new InputDialog ( this.shell, "Add key", "Enter the name of the key to add", "", null );
            if ( dialog.open () == Window.OK )
            {
                this.map.put ( dialog.getValue (), "" );
            }
        }
    }

    private static class InlineEditingSupport extends ObservableValueEditingSupport
    {
        private final CellEditor cellEditor;

        private final IObservableMap map;

        public InlineEditingSupport ( final IObservableMap map, final ColumnViewer viewer, final DataBindingContext dbc )
        {
            super ( viewer, dbc );
            this.map = map;
            this.cellEditor = new TextCellEditor ( (Composite)viewer.getControl () );
        }

        @Override
        protected CellEditor getCellEditor ( final Object element )
        {
            return this.cellEditor;
        }

        @Override
        protected IObservableValue doCreateCellEditorObservable ( final CellEditor cellEditor )
        {
            return WidgetProperties.text ( SWT.Modify ).observe ( cellEditor.getControl () );
        }

        @Override
        protected IObservableValue doCreateElementObservable ( final Object element, final ViewerCell cell )
        {
            final Object key = ( (Map.Entry<?, ?>)element ).getKey ();
            if ( key == null )
            {
                return null;
            }

            return Observables.observeMapEntry ( this.map, key, String.class );
        }
    }
}
