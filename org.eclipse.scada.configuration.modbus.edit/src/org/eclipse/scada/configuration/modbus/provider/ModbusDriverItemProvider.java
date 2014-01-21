/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.modbus.provider;

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
import org.eclipse.scada.configuration.modbus.ModbusDriver;
import org.eclipse.scada.configuration.modbus.ModbusFactory;
import org.eclipse.scada.configuration.modbus.ModbusPackage;
import org.eclipse.scada.configuration.world.WorldPackage;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.configuration.world.osgi.profile.ProfileFactory;

/**
 * This is the item provider adapter for a
 * {@link org.eclipse.scada.configuration.modbus.ModbusDriver} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class ModbusDriverItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public ModbusDriverItemProvider ( final AdapterFactory adapterFactory )
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

            addShortDescriptionPropertyDescriptor ( object );
            addNamePropertyDescriptor ( object );
            addCustomizationProfilePropertyDescriptor ( object );
            addSecurityConfigurationPropertyDescriptor ( object );
        }
        return this.itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Short Description feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addShortDescriptionPropertyDescriptor ( final Object object )
    {
        this.itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)this.adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_Documentable_shortDescription_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_Documentable_shortDescription_feature", "_UI_Documentable_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        WorldPackage.Literals.DOCUMENTABLE__SHORT_DESCRIPTION,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null ) );
    }

    /**
     * This adds a property descriptor for the Name feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addNamePropertyDescriptor ( final Object object )
    {
        this.itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)this.adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_NamedDocumentable_name_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_NamedDocumentable_name_feature", "_UI_NamedDocumentable_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        WorldPackage.Literals.NAMED_DOCUMENTABLE__NAME,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null ) );
    }

    /**
     * This adds a property descriptor for the Customization Profile feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addCustomizationProfilePropertyDescriptor ( final Object object )
    {
        this.itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)this.adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_EquinoxApplication_customizationProfile_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_EquinoxApplication_customizationProfile_feature", "_UI_EquinoxApplication_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        OsgiPackage.Literals.EQUINOX_APPLICATION__CUSTOMIZATION_PROFILE,
                        true,
                        false,
                        true,
                        null,
                        null,
                        null ) );
    }

    /**
     * This adds a property descriptor for the Security Configuration feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addSecurityConfigurationPropertyDescriptor ( final Object object )
    {
        this.itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)this.adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_EquinoxApplication_securityConfiguration_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_EquinoxApplication_securityConfiguration_feature", "_UI_EquinoxApplication_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        OsgiPackage.Literals.EQUINOX_APPLICATION__SECURITY_CONFIGURATION,
                        true,
                        false,
                        true,
                        null,
                        null,
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
            this.childrenFeatures.add ( OsgiPackage.Literals.EQUINOX_APPLICATION__CONNECTIONS );
            this.childrenFeatures.add ( OsgiPackage.Literals.EQUINOX_APPLICATION__EXPORTER );
            this.childrenFeatures.add ( OsgiPackage.Literals.EQUINOX_APPLICATION__CUSTOMIZATION_PROFILE );
            this.childrenFeatures.add ( OsgiPackage.Literals.EQUINOX_APPLICATION__MODULES );
            this.childrenFeatures.add ( ModbusPackage.Literals.MODBUS_DRIVER__MASTERS );
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
     * This returns ModbusDriver.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object getImage ( final Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/ModbusDriver" ) ); //$NON-NLS-1$
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getText ( final Object object )
    {
        final String label = ( (ModbusDriver)object ).getName ();
        return label == null || label.length () == 0 ?
                getString ( "_UI_ModbusDriver_type" ) : //$NON-NLS-1$
                getString ( "_UI_ModbusDriver_type" ) + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

        switch ( notification.getFeatureID ( ModbusDriver.class ) )
        {
            case ModbusPackage.MODBUS_DRIVER__SHORT_DESCRIPTION:
            case ModbusPackage.MODBUS_DRIVER__NAME:
                fireNotifyChanged ( new ViewerNotification ( notification, notification.getNotifier (), false, true ) );
                return;
            case ModbusPackage.MODBUS_DRIVER__CONNECTIONS:
            case ModbusPackage.MODBUS_DRIVER__EXPORTER:
            case ModbusPackage.MODBUS_DRIVER__CUSTOMIZATION_PROFILE:
            case ModbusPackage.MODBUS_DRIVER__MODULES:
            case ModbusPackage.MODBUS_DRIVER__MASTERS:
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

        newChildDescriptors.add
                ( createChildParameter
                ( OsgiPackage.Literals.EQUINOX_APPLICATION__CONNECTIONS,
                        OsgiFactory.eINSTANCE.createDataAccessConnection () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( OsgiPackage.Literals.EQUINOX_APPLICATION__CONNECTIONS,
                        OsgiFactory.eINSTANCE.createAlarmsEventsConnection () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( OsgiPackage.Literals.EQUINOX_APPLICATION__EXPORTER,
                        OsgiFactory.eINSTANCE.createDataAccessExporter () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( OsgiPackage.Literals.EQUINOX_APPLICATION__EXPORTER,
                        OsgiFactory.eINSTANCE.createAlarmsEventsExporter () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( OsgiPackage.Literals.EQUINOX_APPLICATION__EXPORTER,
                        OsgiFactory.eINSTANCE.createHistoricalDataExporter () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( OsgiPackage.Literals.EQUINOX_APPLICATION__EXPORTER,
                        OsgiFactory.eINSTANCE.createConfigurationAdministratorExporter () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( OsgiPackage.Literals.EQUINOX_APPLICATION__CUSTOMIZATION_PROFILE,
                        ProfileFactory.eINSTANCE.createProfile () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( OsgiPackage.Literals.EQUINOX_APPLICATION__MODULES,
                        ModbusFactory.eINSTANCE.createModbusExporter () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( OsgiPackage.Literals.EQUINOX_APPLICATION__MODULES,
                        OsgiFactory.eINSTANCE.createBlockings () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( OsgiPackage.Literals.EQUINOX_APPLICATION__MODULES,
                        OsgiFactory.eINSTANCE.createAlarmsEventsModule () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( OsgiPackage.Literals.EQUINOX_APPLICATION__MODULES,
                        OsgiFactory.eINSTANCE.createJdbcUserServiceModule () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( OsgiPackage.Literals.EQUINOX_APPLICATION__MODULES,
                        OsgiFactory.eINSTANCE.createEventStorageJdbc () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( OsgiPackage.Literals.EQUINOX_APPLICATION__MODULES,
                        OsgiFactory.eINSTANCE.createEventStoragePostgres () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( OsgiPackage.Literals.EQUINOX_APPLICATION__MODULES,
                        OsgiFactory.eINSTANCE.createRestExporter () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( OsgiPackage.Literals.EQUINOX_APPLICATION__MODULES,
                        OsgiFactory.eINSTANCE.createHttpService () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( ModbusPackage.Literals.MODBUS_DRIVER__MASTERS,
                        ModbusFactory.eINSTANCE.createModbusMaster () ) );
    }

    /**
     * Return the resource locator for this item provider's resources.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator ()
    {
        return ( (IChildCreationExtender)this.adapterFactory ).getResourceLocator ();
    }

}
