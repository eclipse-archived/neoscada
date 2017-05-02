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
package org.eclipse.scada.configuration.dave.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.scada.configuration.dave.DaveDevice;
import org.eclipse.scada.configuration.dave.DaveFactory;
import org.eclipse.scada.configuration.dave.DavePackage;
import org.eclipse.scada.configuration.infrastructure.provider.DeviceItemProvider;

/**
 * This is the item provider adapter for a
 * {@link org.eclipse.scada.configuration.dave.DaveDevice} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class DaveDeviceItemProvider extends DeviceItemProvider
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public DaveDeviceItemProvider ( final AdapterFactory adapterFactory )
    {
        super ( adapterFactory );
    }

    /**
     * This returns the property descriptors for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors ( final Object object )
    {
        if ( this.itemPropertyDescriptors == null )
        {
            super.getPropertyDescriptors ( object );

            addPortPropertyDescriptor ( object );
            addRackPropertyDescriptor ( object );
            addSlotPropertyDescriptor ( object );
            addTypeSystemPropertyDescriptor ( object );
            addReadTimeoutPropertyDescriptor ( object );
        }
        return this.itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Port feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addPortPropertyDescriptor ( final Object object )
    {
        this.itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)this.adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_DaveDevice_port_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_DaveDevice_port_feature", "_UI_DaveDevice_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                DavePackage.Literals.DAVE_DEVICE__PORT, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, getString ( "_UI_connectionPropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the Rack feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addRackPropertyDescriptor ( final Object object )
    {
        this.itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)this.adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_DaveDevice_rack_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_DaveDevice_rack_feature", "_UI_DaveDevice_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                DavePackage.Literals.DAVE_DEVICE__RACK, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, getString ( "_UI_connectionPropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the Slot feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addSlotPropertyDescriptor ( final Object object )
    {
        this.itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)this.adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_DaveDevice_slot_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_DaveDevice_slot_feature", "_UI_DaveDevice_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                DavePackage.Literals.DAVE_DEVICE__SLOT, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, getString ( "_UI_connectionPropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the Type System feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addTypeSystemPropertyDescriptor ( final Object object )
    {
        this.itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)this.adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_DaveDevice_typeSystem_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_DaveDevice_typeSystem_feature", "_UI_DaveDevice_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                DavePackage.Literals.DAVE_DEVICE__TYPE_SYSTEM, true, false, true, null, getString ( "_UI_dataPropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the Read Timeout feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addReadTimeoutPropertyDescriptor ( final Object object )
    {
        this.itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)this.adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_DaveDevice_readTimeout_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_DaveDevice_readTimeout_feature", "_UI_DaveDevice_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                DavePackage.Literals.DAVE_DEVICE__READ_TIMEOUT, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, getString ( "_UI_connectionPropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This specifies how to implement {@link #getChildren} and is used to
     * deduce an appropriate feature for an
     * {@link org.eclipse.emf.edit.command.AddCommand},
     * {@link org.eclipse.emf.edit.command.RemoveCommand} or
     * {@link org.eclipse.emf.edit.command.MoveCommand} in
     * {@link #createCommand}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Collection<? extends EStructuralFeature> getChildrenFeatures ( final Object object )
    {
        if ( this.childrenFeatures == null )
        {
            super.getChildrenFeatures ( object );
            this.childrenFeatures.add ( DavePackage.Literals.DAVE_DEVICE__BLOCKS );
        }
        return this.childrenFeatures;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EStructuralFeature getChildFeature ( final Object object, final Object child )
    {
        // Check the type of the specified child object and return the proper feature to use for
        // adding (see {@link AddCommand}) it as a child.

        return super.getChildFeature ( object, child );
    }

    /**
     * This returns DaveDevice.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object getImage ( final Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/DaveDevice" ) ); //$NON-NLS-1$
    }

    @Override
    protected String getDeviceType ()
    {
        return getString ( "_UI_DaveDevice_type" );
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to
     * update any cached
     * children and by creating a viewer notification, which it passes to
     * {@link #fireNotifyChanged}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void notifyChanged ( final Notification notification )
    {
        updateChildren ( notification );

        switch ( notification.getFeatureID ( DaveDevice.class ) )
        {
            case DavePackage.DAVE_DEVICE__PORT:
            case DavePackage.DAVE_DEVICE__RACK:
            case DavePackage.DAVE_DEVICE__SLOT:
            case DavePackage.DAVE_DEVICE__READ_TIMEOUT:
                fireNotifyChanged ( new ViewerNotification ( notification, notification.getNotifier (), false, true ) );
                return;
            case DavePackage.DAVE_DEVICE__BLOCKS:
                fireNotifyChanged ( new ViewerNotification ( notification, notification.getNotifier (), true, false ) );
                return;
        }
        super.notifyChanged ( notification );
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
     * describing the children
     * that can be created under this object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected void collectNewChildDescriptors ( final Collection<Object> newChildDescriptors, final Object object )
    {
        super.collectNewChildDescriptors ( newChildDescriptors, object );

        newChildDescriptors.add ( createChildParameter ( DavePackage.Literals.DAVE_DEVICE__BLOCKS, DaveFactory.eINSTANCE.createDaveBlockDefinition () ) );
    }

}
