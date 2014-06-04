/**
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - prepare for Eclipse contribution
 */
package org.eclipse.scada.ui.chart.model.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.scada.ui.chart.model.Chart;
import org.eclipse.scada.ui.chart.model.ChartFactory;
import org.eclipse.scada.ui.chart.model.ChartPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.scada.ui.chart.model.Chart} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ChartItemProvider extends ItemProviderAdapter implements
        IEditingDomainItemProvider, IStructuredItemContentProvider,
        ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ChartItemProvider ( AdapterFactory adapterFactory )
    {
        super ( adapterFactory );
    }

    /**
     * This returns the property descriptors for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors ( Object object )
    {
        if ( itemPropertyDescriptors == null )
        {
            super.getPropertyDescriptors ( object );

            addTitlePropertyDescriptor ( object );
            addShowCurrentTimeRulerPropertyDescriptor ( object );
            addBackgroundColorPropertyDescriptor ( object );
            addSelectedYAxisPropertyDescriptor ( object );
            addSelectedXAxisPropertyDescriptor ( object );
            addMutablePropertyDescriptor ( object );
            addHoverablePropertyDescriptor ( object );
            addActiveProfilePropertyDescriptor ( object );
            addProfileSwitcherTypePropertyDescriptor ( object );
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Title feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addTitlePropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_Chart_title_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_Chart_title_feature", "_UI_Chart_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        ChartPackage.Literals.CHART__TITLE,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null ) );
    }

    /**
     * This adds a property descriptor for the Show Current Time Ruler feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addShowCurrentTimeRulerPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_Chart_showCurrentTimeRuler_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_Chart_showCurrentTimeRuler_feature", "_UI_Chart_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        ChartPackage.Literals.CHART__SHOW_CURRENT_TIME_RULER,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                        null,
                        null ) );
    }

    /**
     * This adds a property descriptor for the Background Color feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addBackgroundColorPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_Chart_backgroundColor_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_Chart_backgroundColor_feature", "_UI_Chart_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        ChartPackage.Literals.CHART__BACKGROUND_COLOR,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null ) );
    }

    /**
     * This adds a property descriptor for the Selected YAxis feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addSelectedYAxisPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_Chart_selectedYAxis_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_Chart_selectedYAxis_feature", "_UI_Chart_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        ChartPackage.Literals.CHART__SELECTED_YAXIS,
                        true,
                        false,
                        true,
                        null,
                        null,
                        null ) );
    }

    /**
     * This adds a property descriptor for the Selected XAxis feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addSelectedXAxisPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_Chart_selectedXAxis_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_Chart_selectedXAxis_feature", "_UI_Chart_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        ChartPackage.Literals.CHART__SELECTED_XAXIS,
                        true,
                        false,
                        true,
                        null,
                        null,
                        null ) );
    }

    /**
     * This adds a property descriptor for the Mutable feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addMutablePropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_Chart_mutable_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_Chart_mutable_feature", "_UI_Chart_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        ChartPackage.Literals.CHART__MUTABLE,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                        null,
                        null ) );
    }

    /**
     * This adds a property descriptor for the Hoverable feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addHoverablePropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_Chart_hoverable_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_Chart_hoverable_feature", "_UI_Chart_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        ChartPackage.Literals.CHART__HOVERABLE,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                        null,
                        null ) );
    }

    /**
     * This adds a property descriptor for the Active Profile feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addActiveProfilePropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_Chart_activeProfile_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_Chart_activeProfile_feature", "_UI_Chart_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        ChartPackage.Literals.CHART__ACTIVE_PROFILE,
                        true,
                        false,
                        true,
                        null,
                        null,
                        null ) );
    }

    /**
     * This adds a property descriptor for the Profile Switcher Type feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addProfileSwitcherTypePropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_Chart_profileSwitcherType_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_Chart_profileSwitcherType_feature", "_UI_Chart_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        ChartPackage.Literals.CHART__PROFILE_SWITCHER_TYPE,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null ) );
    }

    /**
     * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
     * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
     * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Collection<? extends EStructuralFeature> getChildrenFeatures (
            Object object )
    {
        if ( childrenFeatures == null )
        {
            super.getChildrenFeatures ( object );
            childrenFeatures.add ( ChartPackage.Literals.CHART__BOTTOM );
            childrenFeatures.add ( ChartPackage.Literals.CHART__TOP );
            childrenFeatures.add ( ChartPackage.Literals.CHART__LEFT );
            childrenFeatures.add ( ChartPackage.Literals.CHART__RIGHT );
            childrenFeatures.add ( ChartPackage.Literals.CHART__INPUTS );
            childrenFeatures.add ( ChartPackage.Literals.CHART__CONTROLLERS );
            childrenFeatures.add ( ChartPackage.Literals.CHART__PROFILES );
        }
        return childrenFeatures;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EStructuralFeature getChildFeature ( Object object, Object child )
    {
        // Check the type of the specified child object and return the proper feature to use for
        // adding (see {@link AddCommand}) it as a child.

        return super.getChildFeature ( object, child );
    }

    /**
     * This returns Chart.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage ( Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/Chart" ) ); //$NON-NLS-1$
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getText ( Object object )
    {
        String label = ( (Chart)object ).getTitle ();
        return label == null || label.length () == 0 ?
                getString ( "_UI_Chart_type" ) : //$NON-NLS-1$
                getString ( "_UI_Chart_type" ) + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to update any cached
     * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void notifyChanged ( Notification notification )
    {
        updateChildren ( notification );

        switch ( notification.getFeatureID ( Chart.class ) )
        {
            case ChartPackage.CHART__TITLE:
            case ChartPackage.CHART__SHOW_CURRENT_TIME_RULER:
            case ChartPackage.CHART__BACKGROUND_COLOR:
            case ChartPackage.CHART__MUTABLE:
            case ChartPackage.CHART__HOVERABLE:
            case ChartPackage.CHART__PROFILE_SWITCHER_TYPE:
                fireNotifyChanged ( new ViewerNotification ( notification, notification.getNotifier (), false, true ) );
                return;
            case ChartPackage.CHART__BOTTOM:
            case ChartPackage.CHART__TOP:
            case ChartPackage.CHART__LEFT:
            case ChartPackage.CHART__RIGHT:
            case ChartPackage.CHART__INPUTS:
            case ChartPackage.CHART__CONTROLLERS:
            case ChartPackage.CHART__PROFILES:
                fireNotifyChanged ( new ViewerNotification ( notification, notification.getNotifier (), true, false ) );
                return;
        }
        super.notifyChanged ( notification );
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
     * that can be created under this object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected void collectNewChildDescriptors (
            Collection<Object> newChildDescriptors, Object object )
    {
        super.collectNewChildDescriptors ( newChildDescriptors, object );

        newChildDescriptors.add
                ( createChildParameter
                ( ChartPackage.Literals.CHART__BOTTOM,
                        ChartFactory.eINSTANCE.createXAxis () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( ChartPackage.Literals.CHART__TOP,
                        ChartFactory.eINSTANCE.createXAxis () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( ChartPackage.Literals.CHART__LEFT,
                        ChartFactory.eINSTANCE.createYAxis () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( ChartPackage.Literals.CHART__RIGHT,
                        ChartFactory.eINSTANCE.createYAxis () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( ChartPackage.Literals.CHART__INPUTS,
                        ChartFactory.eINSTANCE.createDataItemSeries () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( ChartPackage.Literals.CHART__INPUTS,
                        ChartFactory.eINSTANCE.createArchiveSeries () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( ChartPackage.Literals.CHART__INPUTS,
                        ChartFactory.eINSTANCE.createScriptSeries () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( ChartPackage.Literals.CHART__INPUTS,
                        ChartFactory.eINSTANCE.createCompositeArchiveQualitySeries () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( ChartPackage.Literals.CHART__CONTROLLERS,
                        ChartFactory.eINSTANCE.createCurrentTimeController () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( ChartPackage.Literals.CHART__CONTROLLERS,
                        ChartFactory.eINSTANCE.createTimeShiftAction () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( ChartPackage.Literals.CHART__CONTROLLERS,
                        ChartFactory.eINSTANCE.createTimeNowAction () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( ChartPackage.Literals.CHART__CONTROLLERS,
                        ChartFactory.eINSTANCE.createScaleAction () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( ChartPackage.Literals.CHART__CONTROLLERS,
                        ChartFactory.eINSTANCE.createSeparatorController () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( ChartPackage.Literals.CHART__CONTROLLERS,
                        ChartFactory.eINSTANCE.createMouseController () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( ChartPackage.Literals.CHART__CONTROLLERS,
                        ChartFactory.eINSTANCE.createResetController () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( ChartPackage.Literals.CHART__CONTROLLERS,
                        ChartFactory.eINSTANCE.createLegendController () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( ChartPackage.Literals.CHART__PROFILES,
                        ChartFactory.eINSTANCE.createProfile () ) );
    }

    /**
     * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getCreateChildText ( Object owner, Object feature,
            Object child, Collection<?> selection )
    {
        Object childFeature = feature;
        Object childObject = child;

        boolean qualify =
                childFeature == ChartPackage.Literals.CHART__BOTTOM ||
                        childFeature == ChartPackage.Literals.CHART__TOP ||
                        childFeature == ChartPackage.Literals.CHART__LEFT ||
                        childFeature == ChartPackage.Literals.CHART__RIGHT;

        if ( qualify )
        {
            return getString ( "_UI_CreateChild_text2", //$NON-NLS-1$
                    new Object[] { getTypeText ( childObject ), getFeatureText ( childFeature ), getTypeText ( owner ) } );
        }
        return super.getCreateChildText ( owner, feature, child, selection );
    }

    /**
     * Return the resource locator for this item provider's resources.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator ()
    {
        return ChartEditPlugin.INSTANCE;
    }

}
