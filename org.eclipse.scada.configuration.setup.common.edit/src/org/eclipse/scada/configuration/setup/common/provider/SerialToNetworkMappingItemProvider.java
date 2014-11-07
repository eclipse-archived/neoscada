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
package org.eclipse.scada.configuration.setup.common.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

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

import org.eclipse.scada.configuration.setup.common.CommonPackage;
import org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping;

/**
 * This is the item provider adapter for a {@link org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SerialToNetworkMappingItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SerialToNetworkMappingItemProvider ( AdapterFactory adapterFactory )
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

            addDevicePropertyDescriptor ( object );
            addTcpPortPropertyDescriptor ( object );
            addTimeoutPropertyDescriptor ( object );
            addBaudRatePropertyDescriptor ( object );
            addParityPropertyDescriptor ( object );
            addXonxoffPropertyDescriptor ( object );
            addRtsctsPropertyDescriptor ( object );
            addDataBitsPropertyDescriptor ( object );
            addStopBitsPropertyDescriptor ( object );
            addModemControlPropertyDescriptor ( object );
            addBreakPropertyDescriptor ( object );
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Device feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addDevicePropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_SerialToNetworkMapping_device_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_SerialToNetworkMapping_device_feature", "_UI_SerialToNetworkMapping_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                CommonPackage.Literals.SERIAL_TO_NETWORK_MAPPING__DEVICE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString ( "_UI_basePropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the Tcp Port feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addTcpPortPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_SerialToNetworkMapping_tcpPort_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_SerialToNetworkMapping_tcpPort_feature", "_UI_SerialToNetworkMapping_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                CommonPackage.Literals.SERIAL_TO_NETWORK_MAPPING__TCP_PORT, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, getString ( "_UI_basePropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the Timeout feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addTimeoutPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_SerialToNetworkMapping_timeout_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_SerialToNetworkMapping_timeout_feature", "_UI_SerialToNetworkMapping_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                CommonPackage.Literals.SERIAL_TO_NETWORK_MAPPING__TIMEOUT, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, getString ( "_UI_comPropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the Baud Rate feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addBaudRatePropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_SerialToNetworkMapping_baudRate_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_SerialToNetworkMapping_baudRate_feature", "_UI_SerialToNetworkMapping_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                CommonPackage.Literals.SERIAL_TO_NETWORK_MAPPING__BAUD_RATE, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, getString ( "_UI_comPropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the Parity feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addParityPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_SerialToNetworkMapping_parity_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_SerialToNetworkMapping_parity_feature", "_UI_SerialToNetworkMapping_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                CommonPackage.Literals.SERIAL_TO_NETWORK_MAPPING__PARITY, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString ( "_UI_comPropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the Xonxoff feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addXonxoffPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_SerialToNetworkMapping_xonxoff_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_SerialToNetworkMapping_xonxoff_feature", "_UI_SerialToNetworkMapping_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                CommonPackage.Literals.SERIAL_TO_NETWORK_MAPPING__XONXOFF, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, getString ( "_UI_controlPropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the Rtscts feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addRtsctsPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_SerialToNetworkMapping_rtscts_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_SerialToNetworkMapping_rtscts_feature", "_UI_SerialToNetworkMapping_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                CommonPackage.Literals.SERIAL_TO_NETWORK_MAPPING__RTSCTS, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, getString ( "_UI_controlPropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the Data Bits feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addDataBitsPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_SerialToNetworkMapping_dataBits_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_SerialToNetworkMapping_dataBits_feature", "_UI_SerialToNetworkMapping_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                CommonPackage.Literals.SERIAL_TO_NETWORK_MAPPING__DATA_BITS, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, getString ( "_UI_comPropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the Stop Bits feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addStopBitsPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_SerialToNetworkMapping_stopBits_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_SerialToNetworkMapping_stopBits_feature", "_UI_SerialToNetworkMapping_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                CommonPackage.Literals.SERIAL_TO_NETWORK_MAPPING__STOP_BITS, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, getString ( "_UI_comPropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the Modem Control feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addModemControlPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_SerialToNetworkMapping_modemControl_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_SerialToNetworkMapping_modemControl_feature", "_UI_SerialToNetworkMapping_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                CommonPackage.Literals.SERIAL_TO_NETWORK_MAPPING__MODEM_CONTROL, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, getString ( "_UI_controlPropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the Break feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addBreakPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_SerialToNetworkMapping_break_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_SerialToNetworkMapping_break_feature", "_UI_SerialToNetworkMapping_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                CommonPackage.Literals.SERIAL_TO_NETWORK_MAPPING__BREAK, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, getString ( "_UI_controlPropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This returns SerialToNetworkMapping.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage ( Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/SerialToNetworkMapping" ) ); //$NON-NLS-1$
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
        String label = ( (SerialToNetworkMapping)object ).getDevice ();
        return label == null || label.length () == 0 ? getString ( "_UI_SerialToNetworkMapping_type" ) : //$NON-NLS-1$
        getString ( "_UI_SerialToNetworkMapping_type" ) + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

        switch ( notification.getFeatureID ( SerialToNetworkMapping.class ) )
        {
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__DEVICE:
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__TCP_PORT:
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__TIMEOUT:
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__BAUD_RATE:
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__PARITY:
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__XONXOFF:
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__RTSCTS:
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__DATA_BITS:
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__STOP_BITS:
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__MODEM_CONTROL:
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__BREAK:
                fireNotifyChanged ( new ViewerNotification ( notification, notification.getNotifier (), false, true ) );
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
