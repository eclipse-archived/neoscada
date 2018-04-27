/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.neoscada.configuration.iec60870.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.neoscada.configuration.iec60870.ExporterItemInterceptor;
import org.eclipse.neoscada.configuration.iec60870.IEC60870Factory;
import org.eclipse.neoscada.configuration.iec60870.IEC60870Package;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.script.ScriptFactory;
import org.eclipse.scada.configuration.world.WorldFactory;

/**
 * This is the item provider adapter for a {@link org.eclipse.neoscada.configuration.iec60870.ExporterItemInterceptor} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ExporterItemInterceptorItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExporterItemInterceptorItemProvider ( AdapterFactory adapterFactory )
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

            addMasterOnPropertyDescriptor ( object );
            addPortPropertyDescriptor ( object );
            addSpontaneousBufferWindowPropertyDescriptor ( object );
            addCyclicPeriodPropertyDescriptor ( object );
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Master On feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addMasterOnPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_MasterAssigned_masterOn_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_MasterAssigned_masterOn_feature", "_UI_MasterAssigned_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                ComponentPackage.Literals.MASTER_ASSIGNED__MASTER_ON, true, false, true, null, getString ( "_UI_corePropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the Port feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addPortPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ExporterItemInterceptor_port_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_ExporterItemInterceptor_port_feature", "_UI_ExporterItemInterceptor_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                IEC60870Package.Literals.EXPORTER_ITEM_INTERCEPTOR__PORT, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, getString ( "_UI_communicationPropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the Spontaneous Buffer Window feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addSpontaneousBufferWindowPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ExporterItemInterceptor_spontaneousBufferWindow_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_ExporterItemInterceptor_spontaneousBufferWindow_feature", "_UI_ExporterItemInterceptor_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                IEC60870Package.Literals.EXPORTER_ITEM_INTERCEPTOR__SPONTANEOUS_BUFFER_WINDOW, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString ( "_UI_communicationPropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the Cyclic Period feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addCyclicPeriodPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ExporterItemInterceptor_cyclicPeriod_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_ExporterItemInterceptor_cyclicPeriod_feature", "_UI_ExporterItemInterceptor_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                IEC60870Package.Literals.EXPORTER_ITEM_INTERCEPTOR__CYCLIC_PERIOD, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null ) );
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
    public Collection<? extends EStructuralFeature> getChildrenFeatures ( Object object )
    {
        if ( childrenFeatures == null )
        {
            super.getChildrenFeatures ( object );
            childrenFeatures.add ( ComponentPackage.Literals.ITEM_INTERCEPTOR__PROPERTIES );
            childrenFeatures.add ( IEC60870Package.Literals.EXPORTER_ITEM_INTERCEPTOR__SCRIPT );
            childrenFeatures.add ( IEC60870Package.Literals.EXPORTER_ITEM_INTERCEPTOR__PROTOCOL_OPTIONS );
            childrenFeatures.add ( IEC60870Package.Literals.EXPORTER_ITEM_INTERCEPTOR__DATA_MODULE_OPTIONS );
            childrenFeatures.add ( IEC60870Package.Literals.EXPORTER_ITEM_INTERCEPTOR__HIVE_PROPERTIES );
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
     * This returns ExporterItemInterceptor.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage ( Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/ExporterItemInterceptor" ) ); //$NON-NLS-1$
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
        ExporterItemInterceptor exporterItemInterceptor = (ExporterItemInterceptor)object;
        return getString ( "_UI_ExporterItemInterceptor_type" ) + " " + exporterItemInterceptor.getPort (); //$NON-NLS-1$ //$NON-NLS-2$
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

        switch ( notification.getFeatureID ( ExporterItemInterceptor.class ) )
        {
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__PORT:
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__SPONTANEOUS_BUFFER_WINDOW:
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__CYCLIC_PERIOD:
                fireNotifyChanged ( new ViewerNotification ( notification, notification.getNotifier (), false, true ) );
                return;
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__PROPERTIES:
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__SCRIPT:
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__PROTOCOL_OPTIONS:
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__DATA_MODULE_OPTIONS:
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__HIVE_PROPERTIES:
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
    protected void collectNewChildDescriptors ( Collection<Object> newChildDescriptors, Object object )
    {
        super.collectNewChildDescriptors ( newChildDescriptors, object );

        newChildDescriptors.add ( createChildParameter ( ComponentPackage.Literals.ITEM_INTERCEPTOR__PROPERTIES, WorldFactory.eINSTANCE.createPropertyEntry () ) );

        newChildDescriptors.add ( createChildParameter ( IEC60870Package.Literals.EXPORTER_ITEM_INTERCEPTOR__SCRIPT, ScriptFactory.eINSTANCE.createGenericScript () ) );

        newChildDescriptors.add ( createChildParameter ( IEC60870Package.Literals.EXPORTER_ITEM_INTERCEPTOR__SCRIPT, ScriptFactory.eINSTANCE.createJavaScript () ) );

        newChildDescriptors.add ( createChildParameter ( IEC60870Package.Literals.EXPORTER_ITEM_INTERCEPTOR__SCRIPT, ScriptFactory.eINSTANCE.createScriptReference () ) );

        newChildDescriptors.add ( createChildParameter ( IEC60870Package.Literals.EXPORTER_ITEM_INTERCEPTOR__PROTOCOL_OPTIONS, IEC60870Factory.eINSTANCE.createProtocolOptions () ) );

        newChildDescriptors.add ( createChildParameter ( IEC60870Package.Literals.EXPORTER_ITEM_INTERCEPTOR__DATA_MODULE_OPTIONS, IEC60870Factory.eINSTANCE.createDataModuleOptions () ) );

        newChildDescriptors.add ( createChildParameter ( IEC60870Package.Literals.EXPORTER_ITEM_INTERCEPTOR__HIVE_PROPERTIES, WorldFactory.eINSTANCE.createPropertyEntry () ) );
    }

    /**
     * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getCreateChildText ( Object owner, Object feature, Object child, Collection<?> selection )
    {
        Object childFeature = feature;
        Object childObject = child;

        boolean qualify = childFeature == ComponentPackage.Literals.ITEM_INTERCEPTOR__PROPERTIES || childFeature == IEC60870Package.Literals.EXPORTER_ITEM_INTERCEPTOR__HIVE_PROPERTIES;

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
        return ( (IChildCreationExtender)adapterFactory ).getResourceLocator ();
    }

}
