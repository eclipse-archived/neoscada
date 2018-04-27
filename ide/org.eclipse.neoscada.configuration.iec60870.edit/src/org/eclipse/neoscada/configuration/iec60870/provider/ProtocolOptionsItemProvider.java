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

import java.util.Arrays;
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
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.neoscada.configuration.iec60870.IEC60870Package;
import org.eclipse.neoscada.configuration.iec60870.ProtocolOptions;
import org.eclipse.neoscada.configuration.iec60870.edit.TimeZoneCellEditor;
import org.eclipse.scada.configuration.ecore.ui.ItemPropertyDescriptor2;
import org.eclipse.swt.widgets.Composite;

/**
 * This is the item provider adapter for a {@link org.eclipse.neoscada.configuration.iec60870.ProtocolOptions} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ProtocolOptionsItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ProtocolOptionsItemProvider ( AdapterFactory adapterFactory )
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

            addTimeout1PropertyDescriptor ( object );
            addTimeout2PropertyDescriptor ( object );
            addTimeout3PropertyDescriptor ( object );
            addAsduAddressSizePropertyDescriptor ( object );
            addInformationObjectAddressSizePropertyDescriptor ( object );
            addCauseOfTransmissionSizePropertyDescriptor ( object );
            addWPropertyDescriptor ( object );
            addKPropertyDescriptor ( object );
            addTargetTimeZonePropertyDescriptor ( object );
            addIgnoreDaylightSavingTimePropertyDescriptor ( object );
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Timeout1 feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addTimeout1PropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ProtocolOptions_timeout1_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_ProtocolOptions_timeout1_feature", "_UI_ProtocolOptions_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                IEC60870Package.Literals.PROTOCOL_OPTIONS__TIMEOUT1, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, getString ( "_UI_communicationPropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the Timeout2 feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addTimeout2PropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ProtocolOptions_timeout2_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_ProtocolOptions_timeout2_feature", "_UI_ProtocolOptions_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                IEC60870Package.Literals.PROTOCOL_OPTIONS__TIMEOUT2, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, getString ( "_UI_communicationPropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the Timeout3 feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addTimeout3PropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ProtocolOptions_timeout3_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_ProtocolOptions_timeout3_feature", "_UI_ProtocolOptions_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                IEC60870Package.Literals.PROTOCOL_OPTIONS__TIMEOUT3, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, getString ( "_UI_communicationPropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the Asdu Address Size feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated NOT
     */
    protected void addAsduAddressSizePropertyDescriptor ( final Object object )
    {
        this.itemPropertyDescriptors.add ( new ItemPropertyDescriptor ( ( (ComposeableAdapterFactory)this.adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ProtocolOptions_asduAddressSize_feature" ), getString ( "_UI_PropertyDescriptor_description", "_UI_ProtocolOptions_asduAddressSize_feature", "_UI_ProtocolOptions_type" ), IEC60870Package.Literals.PROTOCOL_OPTIONS__ASDU_ADDRESS_SIZE, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, getString ( "_UI_parametersPropertyCategory" ), null ) {

            @Override
            public Collection<?> getChoiceOfValues ( final Object object )
            {
                return Arrays.asList ( (byte)1, (byte)2 );
            }

        } );
    }

    /**
     * This adds a property descriptor for the Information Object Address Size
     * feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated NOT
     */
    protected void addInformationObjectAddressSizePropertyDescriptor ( final Object object )
    {
        this.itemPropertyDescriptors.add ( new ItemPropertyDescriptor ( ( (ComposeableAdapterFactory)this.adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ProtocolOptions_informationObjectAddressSize_feature" ), getString ( "_UI_PropertyDescriptor_description", "_UI_ProtocolOptions_informationObjectAddressSize_feature", "_UI_ProtocolOptions_type" ), IEC60870Package.Literals.PROTOCOL_OPTIONS__INFORMATION_OBJECT_ADDRESS_SIZE, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, getString ( "_UI_parametersPropertyCategory" ), null ) {
            @Override
            public Collection<?> getChoiceOfValues ( final Object object )
            {
                return Arrays.asList ( (byte)1, (byte)2, (byte)3 );
            }
        } );
    }

    /**
     * This adds a property descriptor for the Cause Of Transmission Size
     * feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated NOT
     */
    protected void addCauseOfTransmissionSizePropertyDescriptor ( final Object object )
    {
        this.itemPropertyDescriptors.add ( new ItemPropertyDescriptor ( ( (ComposeableAdapterFactory)this.adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ProtocolOptions_causeOfTransmissionSize_feature" ), getString ( "_UI_PropertyDescriptor_description", "_UI_ProtocolOptions_causeOfTransmissionSize_feature", "_UI_ProtocolOptions_type" ), IEC60870Package.Literals.PROTOCOL_OPTIONS__CAUSE_OF_TRANSMISSION_SIZE, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, getString ( "_UI_parametersPropertyCategory" ), null ) {
            @Override
            public Collection<?> getChoiceOfValues ( final Object object )
            {
                return Arrays.asList ( (byte)1, (byte)2 );
            }
        } );
    }

    /**
     * This adds a property descriptor for the W feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addWPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ProtocolOptions_w_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_ProtocolOptions_w_feature", "_UI_ProtocolOptions_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                IEC60870Package.Literals.PROTOCOL_OPTIONS__W, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, getString ( "_UI_communicationPropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the K feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addKPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ProtocolOptions_k_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_ProtocolOptions_k_feature", "_UI_ProtocolOptions_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                IEC60870Package.Literals.PROTOCOL_OPTIONS__K, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, getString ( "_UI_communicationPropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the Target Time Zone feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated NOT
     */
    protected void addTargetTimeZonePropertyDescriptor ( final Object object )
    {
        this.itemPropertyDescriptors.add ( new ItemPropertyDescriptor2 ( ( (ComposeableAdapterFactory)this.adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ProtocolOptions_targetTimeZone_feature" ), getString ( "_UI_PropertyDescriptor_description", "_UI_ProtocolOptions_targetTimeZone_feature", "_UI_ProtocolOptions_type" ), IEC60870Package.Literals.PROTOCOL_OPTIONS__TARGET_TIME_ZONE, true, false, true, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString ( "_UI_timePropertyCategory" ), null ) {

            @Override
            public CellEditor createPropertyEditor ( final Composite composite, final Object object )
            {
                return new TimeZoneCellEditor ( composite );
            }
        } );
    }

    /**
     * This adds a property descriptor for the Ignore Daylight Saving Time feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addIgnoreDaylightSavingTimePropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ProtocolOptions_ignoreDaylightSavingTime_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_ProtocolOptions_ignoreDaylightSavingTime_feature", "_UI_ProtocolOptions_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                IEC60870Package.Literals.PROTOCOL_OPTIONS__IGNORE_DAYLIGHT_SAVING_TIME, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, getString ( "_UI_timePropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This returns ProtocolOptions.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage ( Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/ProtocolOptions" ) ); //$NON-NLS-1$
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public String getText ( final Object object )
    {
        return getString ( "_UI_ProtocolOptions_type" ); //$NON-NLS-1$
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

        switch ( notification.getFeatureID ( ProtocolOptions.class ) )
        {
            case IEC60870Package.PROTOCOL_OPTIONS__TIMEOUT1:
            case IEC60870Package.PROTOCOL_OPTIONS__TIMEOUT2:
            case IEC60870Package.PROTOCOL_OPTIONS__TIMEOUT3:
            case IEC60870Package.PROTOCOL_OPTIONS__ASDU_ADDRESS_SIZE:
            case IEC60870Package.PROTOCOL_OPTIONS__INFORMATION_OBJECT_ADDRESS_SIZE:
            case IEC60870Package.PROTOCOL_OPTIONS__CAUSE_OF_TRANSMISSION_SIZE:
            case IEC60870Package.PROTOCOL_OPTIONS__W:
            case IEC60870Package.PROTOCOL_OPTIONS__K:
            case IEC60870Package.PROTOCOL_OPTIONS__TARGET_TIME_ZONE:
            case IEC60870Package.PROTOCOL_OPTIONS__IGNORE_DAYLIGHT_SAVING_TIME:
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
