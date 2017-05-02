/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *     IBH SYSTEMS GmbH - adding browser component, fix resolve issue
 *******************************************************************************/
package org.eclipse.scada.vi.details.swt.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.set.UnionSet;
import org.eclipse.core.databinding.observable.set.WritableSet;
import org.eclipse.scada.core.ui.connection.login.SessionManager;
import org.eclipse.scada.utils.str.StringReplacer;
import org.eclipse.scada.vi.data.SummaryProvider;
import org.eclipse.scada.vi.details.model.AndTransformer;
import org.eclipse.scada.vi.details.model.BoolLEDComponent;
import org.eclipse.scada.vi.details.model.BrowserComponent;
import org.eclipse.scada.vi.details.model.ButtonComponent;
import org.eclipse.scada.vi.details.model.CheckComponent;
import org.eclipse.scada.vi.details.model.Component;
import org.eclipse.scada.vi.details.model.CompositeTransformer;
import org.eclipse.scada.vi.details.model.FillLayoutComponent;
import org.eclipse.scada.vi.details.model.GroupGridComponent;
import org.eclipse.scada.vi.details.model.GroupGridEntry;
import org.eclipse.scada.vi.details.model.HiddenComponent;
import org.eclipse.scada.vi.details.model.ItemValueSource;
import org.eclipse.scada.vi.details.model.LabelComponent;
import org.eclipse.scada.vi.details.model.LinkComponent;
import org.eclipse.scada.vi.details.model.NotTransformer;
import org.eclipse.scada.vi.details.model.OrTransformer;
import org.eclipse.scada.vi.details.model.ProgressComponent;
import org.eclipse.scada.vi.details.model.SimpleGridComponent;
import org.eclipse.scada.vi.details.model.TextComponent;
import org.eclipse.scada.vi.details.model.TextInputComponent;
import org.eclipse.scada.vi.details.model.TextInputMultiComponent;
import org.eclipse.scada.vi.details.model.URLImageComponent;
import org.eclipse.scada.vi.details.model.ValueComponent;
import org.eclipse.scada.vi.details.model.ValueSetComponent;
import org.eclipse.scada.vi.details.model.ValueSource;
import org.eclipse.scada.vi.details.swt.Constants;
import org.eclipse.scada.vi.details.swt.DetailComponent;
import org.eclipse.scada.vi.details.swt.data.DataItemDescriptor;
import org.eclipse.scada.vi.details.swt.impl.visibility.ComponentVisibility;
import org.eclipse.scada.vi.details.swt.impl.visibility.SubTrackingVisibleComponent;
import org.eclipse.scada.vi.details.swt.impl.visibility.TrackingVisibleComponent;
import org.eclipse.scada.vi.details.swt.impl.visibility.VisibilityProvider;
import org.eclipse.scada.vi.details.swt.impl.visibility.VisibilityProviderFactory;
import org.eclipse.scada.vi.details.swt.source.ItemValueSourceController;
import org.eclipse.scada.vi.details.swt.source.NotEvaluatorController;
import org.eclipse.scada.vi.details.swt.source.ValueSourceController;
import org.eclipse.scada.vi.details.swt.widgets.BoolLEDComposite;
import org.eclipse.scada.vi.details.swt.widgets.ButtonComposite;
import org.eclipse.scada.vi.details.swt.widgets.CheckComposite;
import org.eclipse.scada.vi.details.swt.widgets.LabelComposite;
import org.eclipse.scada.vi.details.swt.widgets.LinkComposite;
import org.eclipse.scada.vi.details.swt.widgets.ProgressComposite;
import org.eclipse.scada.vi.details.swt.widgets.TextComposite;
import org.eclipse.scada.vi.details.swt.widgets.TextInputComposite;
import org.eclipse.scada.vi.details.swt.widgets.TextInputMultiComposite;
import org.eclipse.scada.vi.details.swt.widgets.URLImageLabel;
import org.eclipse.scada.vi.details.swt.widgets.ValueComposite;
import org.eclipse.scada.vi.details.swt.widgets.ValueSetComposite;
import org.eclipse.scada.vi.details.swt.widgets.WriteableComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

public class DetailComponentImpl implements DetailComponent
{
    private final Component component;

    private final List<ComponentVisibility> visibilites = new LinkedList<ComponentVisibility> ();

    private VisibilityProviderFactory visibleFactory;

    private final WritableSet descriptors = new WritableSet ();

    private final CompositeSummaryProvider summaryProvider = new CompositeSummaryProvider ();

    private final ViewContext viewContext;

    public DetailComponentImpl ( final Component component, final ViewContext viewContext )
    {
        this.viewContext = viewContext;
        this.component = component;
    }

    @Override
    public void dispose ()
    {
        for ( final ComponentVisibility visibility : this.visibilites )
        {
            visibility.dispose ();
        }
        this.summaryProvider.dispose ();
    }

    @Override
    public void start ()
    {
        for ( final ComponentVisibility visibility : this.visibilites )
        {
            visibility.start ();
        }
    }

    @Override
    public void stop ()
    {
        for ( final ComponentVisibility visibility : this.visibilites )
        {
            visibility.stop ();
        }
    }

    /**
     * Returns a list of descriptors used by this and all sub components
     *
     * @return the list of descriptors. It never returns <code>null</code>.
     */
    @Override
    public IObservableSet getDescriptors ()
    {
        final List<IObservableSet> lists = new LinkedList<IObservableSet> ();

        lists.add ( this.descriptors );

        for ( final ComponentVisibility visibility : this.visibilites )
        {
            lists.add ( visibility.getDescriptors () );
        }

        return new UnionSet ( lists.toArray ( new IObservableSet[lists.size ()] ) );
    }

    private void addDescriptor ( final DataItemDescriptor descriptor )
    {
        if ( descriptor != null )
        {
            this.descriptors.add ( descriptor );
        }
    }

    @Override
    public void init ( final VisibilityProviderFactory visibleFactory, final Composite parent, final Map<String, String> properties )
    {
        this.visibleFactory = visibleFactory;

        // create widgets
        if ( this.component instanceof LabelComponent )
        {
            createLabel ( parent, (LabelComponent)this.component, properties );
        }
        else if ( this.component instanceof FillLayoutComponent )
        {
            createFillLayout ( parent, (FillLayoutComponent)this.component, properties );
        }
        else if ( this.component instanceof SimpleGridComponent )
        {
            createSimpleGrid ( parent, (SimpleGridComponent)this.component, properties );
        }
        else if ( this.component instanceof GroupGridComponent )
        {
            createGroupGrid ( parent, (GroupGridComponent)this.component, properties );
        }
        else if ( this.component instanceof ButtonComponent )
        {
            createButton ( parent, (ButtonComponent)this.component, properties );
        }
        else if ( this.component instanceof BoolLEDComponent )
        {
            createBoolLED ( parent, (BoolLEDComponent)this.component, properties );
        }
        else if ( this.component instanceof ValueSetComponent )
        {
            createValueSet ( parent, (ValueSetComponent)this.component, properties );
        }
        else if ( this.component instanceof ValueComponent )
        {
            createValue ( parent, (ValueComponent)this.component, properties );
        }
        else if ( this.component instanceof TextComponent )
        {
            createText ( parent, (TextComponent)this.component, properties );
        }
        else if ( this.component instanceof TextInputComponent )
        {
            createTextInput ( parent, (TextInputComponent)this.component, properties );
        }
        else if ( this.component instanceof TextInputMultiComponent )
        {
            createTextInputMulti ( parent, (TextInputMultiComponent)this.component, properties );
        }
        else if ( this.component instanceof CheckComponent )
        {
            createCheck ( parent, (CheckComponent)this.component, properties );
        }
        else if ( this.component instanceof LinkComponent )
        {
            createLink ( parent, (LinkComponent)this.component, properties );
        }
        else if ( this.component instanceof ProgressComponent )
        {
            createProgress ( parent, (ProgressComponent)this.component, properties );
        }
        else if ( this.component instanceof URLImageComponent )
        {
            createURLImage ( parent, (URLImageComponent)this.component, properties );
        }
        else if ( this.component instanceof BrowserComponent )
        {
            createBrowser ( parent, (BrowserComponent)this.component, properties );
        }
        else if ( this.component instanceof HiddenComponent )
        {
            createHidden ( (HiddenComponent)this.component, properties );
        }
    }

    private void createHidden ( final HiddenComponent component, final Map<String, String> properties )
    {
        final DataItemDescriptor descriptor = DataItemDescriptor.create ( resolve ( component.getDescriptor (), properties ) );

        addDescriptor ( descriptor );
    }

    private void createURLImage ( final Composite parent, final URLImageComponent component, final Map<String, String> properties )
    {
        final DataItemDescriptor descriptor = DataItemDescriptor.create ( resolve ( component.getDescriptor (), properties ) );

        final VisibilityProvider provider = this.visibleFactory.createProvider ( component.getVisibility () );

        final ComponentVisibility visibility = new ComponentVisibility ( provider, new TrackingVisibleComponent () {

            @Override
            public void create ()
            {
                final URLImageLabel image = new URLImageLabel ( parent, SWT.NONE, descriptor, component );

                setSummaryProvider ( image.getSummaryProvider () );

                trackControl ( image );
                trackItem ( descriptor );
            }

        } );

        addComponent ( visibility );
    }

    private void createBrowser ( final Composite parent, final BrowserComponent component, final Map<String, String> properties )
    {
        final VisibilityProvider provider = this.visibleFactory.createProvider ( component.getVisibility () );

        final ComponentVisibility visibility = new ComponentVisibility ( provider, new TrackingVisibleComponent () {

            @Override
            public void create ()
            {
                final org.eclipse.scada.vi.details.swt.widgets.BrowserComponent image = new org.eclipse.scada.vi.details.swt.widgets.BrowserComponent ( parent, SWT.NONE, null, component );

                setSummaryProvider ( image.getSummaryProvider () );

                trackControl ( image );
            }

        } );

        addComponent ( visibility );
    }

    private void createProgress ( final Composite parent, final ProgressComponent component, final Map<String, String> properties )
    {
        final DataItemDescriptor progressItem = DataItemDescriptor.create ( resolve ( component.getDescriptor (), properties ) );

        final VisibilityProvider provider = this.visibleFactory.createProvider ( component.getVisibility () );

        final ComponentVisibility visibility = new ComponentVisibility ( provider, new TrackingVisibleComponent () {

            @Override
            public void create ()
            {
                final ProgressComposite progress = new ProgressComposite ( parent, SWT.NONE, progressItem, resolve ( component.getFormat (), properties ), component.getDecimal (), resolve ( component.getAttribute (), properties ), component.getMax (), component.getMin (), component.getFactor (), component.getWidth (), resolve ( component.getHdConnectionId (), properties ), resolve ( component.getHdItemId (), properties ), component.getHdQueryString () );
                progress.setNullReplacementValue ( component.getNullReplacementValue () );

                setSummaryProvider ( progress.getSummaryProvider () );

                trackControl ( progress );
                trackItem ( progressItem );
            }

        } );

        addComponent ( visibility );
    }

    private void createLink ( final Composite parent, final LinkComponent component, final Map<String, String> properties )
    {
        final VisibilityProvider provider = this.visibleFactory.createProvider ( component.getVisibility () );

        final ComponentVisibility visibility = new ComponentVisibility ( provider, new TrackingVisibleComponent () {

            @Override
            public void create ()
            {
                final LinkComposite link = new LinkComposite ( parent, SWT.NONE, resolve ( component.getFormat (), properties ) );

                trackControl ( link );
            }

        } );

        addComponent ( visibility );
    }

    private void createCheck ( final Composite parent, final CheckComponent component, final Map<String, String> properties )
    {
        final DataItemDescriptor descriptor = DataItemDescriptor.create ( resolve ( component.getDescriptor (), properties ) );
        final DataItemDescriptor readDescriptor = DataItemDescriptor.create ( resolve ( component.getReadDescriptor (), properties ) );

        final VisibilityProvider provider = this.visibleFactory.createProvider ( component.getVisibility () );

        final ComponentVisibility visibility = new ComponentVisibility ( provider, new TrackingVisibleComponent () {

            @Override
            public void create ()
            {
                final CheckComposite check = new CheckComposite ( DetailComponentImpl.this.viewContext, parent, SWT.NONE, descriptor, resolve ( component.getFormat (), properties ), resolve ( component.getAttribute (), properties ), readDescriptor );

                setSummaryProvider ( check.getSummaryProvider () );

                trackControl ( check );
                trackItem ( descriptor );
                trackItem ( readDescriptor );
            }
        } );

        addComponent ( visibility );
    }

    private void createText ( final Composite parent, final TextComponent component, final Map<String, String> properties )
    {
        final DataItemDescriptor textItem = DataItemDescriptor.create ( resolve ( component.getDescriptor (), properties ) );

        final VisibilityProvider provider = this.visibleFactory.createProvider ( component.getVisibility () );

        final ComponentVisibility visibility = new ComponentVisibility ( provider, new TrackingVisibleComponent () {

            @Override
            public void create ()
            {
                final TextComposite text = new TextComposite ( parent, SWT.NONE, textItem, resolve ( component.getFormat (), properties ), component.getDecimal (), component.isIsText (), resolve ( component.getAttribute (), properties ), component.getWidth (), component.getHeight (), component.isDate (), component.getTextHeight (), component.getTextMap (), resolve ( component.getHdConnectionId (), properties ), resolve ( component.getHdItemId (), properties ), component.getHdQueryString () );
                text.setNullReplacementValue ( component.getNullReplacementValue () );

                setSummaryProvider ( text.getSummaryProvider () );

                trackControl ( text );
                trackItem ( textItem );
            }
        } );

        addComponent ( visibility );
    }

    private void createTextInput ( final Composite parent, final TextInputComponent component, final Map<String, String> properties )
    {
        final DataItemDescriptor textInputItem = DataItemDescriptor.create ( resolve ( component.getDescriptor (), properties ) );
        final DataItemDescriptor readItem = DataItemDescriptor.create ( resolve ( component.getReadDescriptor (), properties ) );

        final VisibilityProvider provider = this.visibleFactory.createProvider ( component.getVisibility () );

        final ComponentVisibility visibility = new ComponentVisibility ( provider, new TrackingVisibleComponent () {

            @Override
            public void create ()
            {
                final WriteableComposite valueSet = new TextInputComposite ( DetailComponentImpl.this.viewContext, parent, SWT.NONE, textInputItem, resolve ( component.getFormat (), properties ), component.getCeil (), component.getFloor (), component.getDecimal (), component.isIsText (), resolve ( component.getAttribute (), properties ), readItem, component.getHdConnectionId (), resolve ( component.getHdItemId (), properties ), component.getWidth (), component.getHdQueryString () );
                valueSet.setNullReplacementValue ( component.getNullReplacementValue () );

                setSummaryProvider ( valueSet.getSummaryProvider () );

                trackControl ( valueSet );
                trackItem ( textInputItem );
                trackItem ( readItem );
            }
        } );

        addComponent ( visibility );
    }

    private void createTextInputMulti ( final Composite parent, final TextInputMultiComponent component, final Map<String, String> properties )
    {
        final DataItemDescriptor textInputItem = DataItemDescriptor.create ( resolve ( component.getDescriptor (), properties ) );

        final VisibilityProvider provider = this.visibleFactory.createProvider ( component.getVisibility () );

        final ComponentVisibility visibility = new ComponentVisibility ( provider, new TrackingVisibleComponent () {

            @Override
            public void create ()
            {
                final TextInputMultiComposite text = new TextInputMultiComposite ( DetailComponentImpl.this.viewContext, parent, SWT.NONE, textInputItem, resolve ( component.getFormat (), properties ), resolve ( component.getAttribute (), properties ), component.getHdConnectionId (), resolve ( component.getHdItemId (), properties ) );
                text.setNullReplacementValue ( component.getNullReplacementValue () );

                setSummaryProvider ( text.getSummaryProvider () );

                trackControl ( text );
                trackItem ( textInputItem );
            }
        } );

        addComponent ( visibility );
    }

    private void createValue ( final Composite parent, final ValueComponent component, final Map<String, String> properties )
    {
        final DataItemDescriptor item = DataItemDescriptor.create ( resolve ( component.getDescriptor (), properties ) );

        final VisibilityProvider provider = this.visibleFactory.createProvider ( component.getVisibility () );

        final ComponentVisibility visibility = new ComponentVisibility ( provider, new TrackingVisibleComponent () {

            @Override
            public void create ()
            {
                final ValueComposite value = new ValueComposite ( parent, SWT.NONE, item, resolve ( component.getFormat (), properties ), component.getDecimal (), component.isIsText (), resolve ( component.getAttribute (), properties ), component.getDate (), resolve ( component.getHdConnectionId (), properties ), resolve ( component.getHdItemId (), properties ), component.getHdQueryString () );
                value.setNullReplacementValue ( component.getNullReplacementValue () );

                setSummaryProvider ( value.getSummaryProvider () );

                trackControl ( value );
                trackItem ( item );
            }
        } );

        addComponent ( visibility );
    }

    private void createValueSet ( final Composite parent, final ValueSetComponent component, final Map<String, String> properties )
    {
        final DataItemDescriptor valueItem = DataItemDescriptor.create ( resolve ( component.getValueDescriptor (), properties ) );
        final DataItemDescriptor setItem = DataItemDescriptor.create ( resolve ( component.getSetDescriptor (), properties ) );
        final DataItemDescriptor resetItem = DataItemDescriptor.create ( resolve ( component.getResetDescriptor (), properties ) );

        final VisibilityProvider provider = this.visibleFactory.createProvider ( component.getVisibility () );

        final ComponentVisibility visibility = new ComponentVisibility ( provider, new TrackingVisibleComponent () {

            @Override
            public void create ()
            {
                final ValueSetComposite valueSet = new ValueSetComposite ( DetailComponentImpl.this.viewContext, parent, SWT.NONE, valueItem, setItem, resetItem, resolve ( component.getFormat (), properties ), component.getCeil (), component.getFloor (), component.getDecimal (), component.isIsText (), resolve ( component.getAttribute (), properties ), resolve ( component.getHdConnectionId (), properties ), resolve ( component.getHdItemId (), properties ) );
                valueSet.setNullReplacementValue ( component.getNullReplacementValue () );

                setSummaryProvider ( valueSet.getSummaryProvider () );

                trackControl ( valueSet );
                trackItem ( valueItem );
                trackItem ( setItem );
                trackItem ( resetItem );
            }
        } );

        addComponent ( visibility );
    }

    private void createGroupGrid ( final Composite parent, final GroupGridComponent component, final Map<String, String> properties )
    {
        final VisibilityProvider provider = this.visibleFactory.createProvider ( component.getVisibility () );

        final ComponentVisibility visibility = new ComponentVisibility ( provider, new TrackingVisibleComponent () {

            @Override
            public void create ()
            {
                final Composite childParent = new Composite ( parent, SWT.NONE );
                childParent.setLayout ( new GridLayout ( component.getCols (), component.isEqually () ) );

                for ( final GroupGridEntry groupEntry : component.getGroups () )
                {
                    if ( groupEntry.getPermission () == null )
                    {
                        // there are no special user rights available, so just show the TAB
                        createGroupGridEntry ( properties, childParent, groupEntry );
                    }
                    else if ( SessionManager.getDefault ().hasRole ( groupEntry.getPermission () ) )
                    {
                        createGroupGridEntry ( properties, childParent, groupEntry );
                    }
                }
                trackControl ( childParent );
            }
        } );

        addComponent ( visibility );
    }

    private void createGroupGridEntry ( final Map<String, String> properties, final Composite childParent, final GroupGridEntry groupEntry )
    {
        final VisibilityProvider provider = this.visibleFactory.createProvider ( groupEntry.getVisibility () );

        final ComponentVisibility visibility = new ComponentVisibility ( provider, new SubTrackingVisibleComponent () {

            @Override
            public void create ()
            {
                final Group groupWidget = new Group ( childParent, SWT.NONE );

                groupWidget.setLayout ( new GridLayout ( 1, false ) );
                groupWidget.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, false ) );

                final String label = groupEntry.getLabel ();
                if ( label != null )
                {
                    groupWidget.setText ( label );
                }

                for ( final Component child : groupEntry.getComponents () )
                {
                    final DetailComponentImpl comp = new DetailComponentImpl ( child, DetailComponentImpl.this.viewContext );

                    final Composite wrapper = new Composite ( groupWidget, SWT.NONE );
                    wrapper.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, false ) );
                    wrapper.setLayout ( new FillLayout () );

                    comp.init ( DetailComponentImpl.this.visibleFactory, wrapper, properties );

                    trackSub ( comp );
                }

                trackControl ( groupWidget );
            }
        } );

        addComponent ( visibility );
    }

    private void createSimpleGrid ( final Composite parent, final SimpleGridComponent component, final Map<String, String> properties )
    {
        final VisibilityProvider provider = this.visibleFactory.createProvider ( component.getVisibility () );

        final ComponentVisibility visibility = new ComponentVisibility ( provider, new SubTrackingVisibleComponent () {

            @Override
            public void create ()
            {
                final Composite childParent = new Composite ( parent, SWT.NONE );
                childParent.setLayout ( new GridLayout ( component.getCols (), component.isEqually () ) );

                for ( final Component child : component.getChildren () )
                {
                    final DetailComponentImpl comp = new DetailComponentImpl ( child, DetailComponentImpl.this.viewContext );
                    trackSub ( comp );

                    final Composite wrapper = new Composite ( childParent, SWT.NONE );
                    wrapper.setLayout ( new FillLayout () );
                    wrapper.setLayoutData ( new GridData ( SWT.FILL, SWT.FILL, true, false ) );
                    comp.init ( DetailComponentImpl.this.visibleFactory, wrapper, properties );
                }

                trackControl ( childParent );
            }
        } );

        addComponent ( visibility );
    }

    private void createBoolLED ( final Composite parent, final BoolLEDComponent component, final Map<String, String> properties )
    {
        final DataItemDescriptor item = DataItemDescriptor.create ( resolve ( component.getDescriptor (), properties ) );

        final VisibilityProvider provider = this.visibleFactory.createProvider ( component.getVisibility () );

        final ComponentVisibility visibility = new ComponentVisibility ( provider, new TrackingVisibleComponent () {

            @Override
            public void create ()
            {
                final BoolLEDComposite led = new BoolLEDComposite ( parent, SWT.NONE, item, resolve ( component.getFormat (), properties ), component.isExpectedValue (), component.isAlarm (), component.isOnOff (), resolve ( component.getAttribute (), properties ) );

                setSummaryProvider ( led.getSummaryProvider () );

                trackControl ( led );
                trackItem ( item );
            }
        } );

        addComponent ( visibility );
    }

    private void createButton ( final Composite parent, final ButtonComponent component, final Map<String, String> properties )
    {
        final String readDescriptor = component.getReadDescriptor ();
        final DataItemDescriptor readItem;
        if ( readDescriptor != null && !readDescriptor.equals ( "" ) ) //$NON-NLS-1$
        {
            readItem = DataItemDescriptor.create ( resolve ( component.getReadDescriptor (), properties ) );
        }
        else
        {
            readItem = null;
        }

        final DataItemDescriptor writeItem = DataItemDescriptor.create ( resolve ( component.getWriteDescriptor (), properties ) );

        final VisibilityProvider provider = this.visibleFactory.createProvider ( component.getVisibility () );

        final ComponentVisibility visibility = new ComponentVisibility ( provider, new TrackingVisibleComponent () {

            @Override
            public void create ()
            {
                final ButtonComposite button = new ButtonComposite ( DetailComponentImpl.this.viewContext, parent, SWT.NONE, readItem, writeItem, resolve ( component.getFormat (), properties ), resolve ( component.getValue (), properties ), createValueSource ( component.getActive (), properties ), component.getRegistrations (), properties, resolve ( component.getAttribute (), properties ), component.getTextHeight () );

                setSummaryProvider ( button.getSummaryProvider () );

                trackControl ( button );
                trackItem ( writeItem );
                trackItem ( readItem );
            }
        } );

        addComponent ( visibility );
    }

    private static ValueSourceController createValueSource ( final ValueSource valueSource, final Map<String, String> properties )
    {
        if ( valueSource instanceof NotTransformer )
        {
            return new NotEvaluatorController ( createValueSource ( ( (NotTransformer)valueSource ).getValue (), properties ) );
        }
        else if ( valueSource instanceof AndTransformer )
        {
            return new AndTransformerController ( createValueSources ( ( (CompositeTransformer)valueSource ).getValues (), properties ) );
        }
        else if ( valueSource instanceof OrTransformer )
        {
            return new OrTransformerController ( createValueSources ( ( (CompositeTransformer)valueSource ).getValues (), properties ) );
        }
        else if ( valueSource instanceof ItemValueSource )
        {
            final ItemValueSource itemSource = (ItemValueSource)valueSource;
            return new ItemValueSourceController ( resolve ( itemSource.getValueKey (), properties ) );
        }
        else
        {
            return null;
        }
    }

    private static List<ValueSourceController> createValueSources ( final List<ValueSource> values, final Map<String, String> properties )
    {
        final List<ValueSourceController> result = new LinkedList<ValueSourceController> ();

        for ( final ValueSource source : values )
        {
            result.add ( createValueSource ( source, properties ) );
        }

        return result;
    }

    private void createFillLayout ( final Composite parent, final FillLayoutComponent component, final Map<String, String> properties )
    {
        final VisibilityProvider provider = this.visibleFactory.createProvider ( component.getVisibility () );

        final ComponentVisibility visibility = new ComponentVisibility ( provider, new SubTrackingVisibleComponent () {

            @Override
            public void create ()
            {

                final Composite childParent = new Composite ( parent, SWT.NONE );
                childParent.setLayout ( new FillLayout ( SWT.VERTICAL ) );

                for ( final Component child : component.getChildren () )
                {
                    final DetailComponentImpl comp = new DetailComponentImpl ( child, DetailComponentImpl.this.viewContext );
                    comp.init ( DetailComponentImpl.this.visibleFactory, childParent, properties );
                    trackSub ( comp );
                }
                trackControl ( childParent );
            }

        } );

        addComponent ( visibility );
    }

    private void createLabel ( final Composite parent, final LabelComponent component, final Map<String, String> properties )
    {
        final DataItemDescriptor item = DataItemDescriptor.create ( resolve ( component.getDescriptor (), properties ) );

        final VisibilityProvider provider = this.visibleFactory.createProvider ( component.getVisibility () );

        final ComponentVisibility visibility = new ComponentVisibility ( provider, new TrackingVisibleComponent () {

            @Override
            public void create ()
            {
                final LabelComposite label = new LabelComposite ( parent, SWT.NONE, item, resolve ( component.getFormat (), properties ) );
                setSummaryProvider ( label.getSummaryProvider () );
                trackControl ( label );
                trackItem ( item );
            }

        } );

        addComponent ( visibility );
    }

    public static String resolve ( final String input, final Map<String, String> properties )
    {
        if ( input == null )
        {
            return null;
        }

        return StringReplacer.replace ( input, StringReplacer.newSource ( properties ), Constants.DEFAULT_PATTERN );
    }

    private void addComponent ( final ComponentVisibility visibility )
    {
        this.visibilites.add ( visibility );
        this.summaryProvider.addSummaryProvider ( visibility.getSummaryProvider () );
    }

    @Override
    public SummaryProvider getSummaryProvider ()
    {
        return this.summaryProvider;
    }
}
