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
package org.eclipse.scada.configuration.infrastructure.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.scada.configuration.infrastructure.EquinoxDriver;
import org.eclipse.scada.configuration.infrastructure.InfrastructureFactory;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.world.WorldFactory;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;

/**
 * This is the item provider adapter for a {@link org.eclipse.scada.configuration.infrastructure.EquinoxDriver} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class EquinoxDriverItemProvider extends AbstractFactoryDriverItemProvider
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EquinoxDriverItemProvider ( AdapterFactory adapterFactory )
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

            addInstanceNumberPropertyDescriptor ( object );
            addSecurityConfigurationPropertyDescriptor ( object );
            addConfigurationPropertyDescriptor ( object );
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Instance Number feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addInstanceNumberPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_EquinoxBase_instanceNumber_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_EquinoxBase_instanceNumber_feature", "_UI_EquinoxBase_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                InfrastructurePackage.Literals.EQUINOX_BASE__INSTANCE_NUMBER, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null ) );
    }

    /**
     * This adds a property descriptor for the Security Configuration feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addSecurityConfigurationPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_EquinoxBase_securityConfiguration_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_EquinoxBase_securityConfiguration_feature", "_UI_EquinoxBase_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                InfrastructurePackage.Literals.EQUINOX_BASE__SECURITY_CONFIGURATION, true, false, true, null, null, null ) );
    }

    /**
     * This adds a property descriptor for the Configuration feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addConfigurationPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_EquinoxBase_configuration_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_EquinoxBase_configuration_feature", "_UI_EquinoxBase_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                InfrastructurePackage.Literals.EQUINOX_BASE__CONFIGURATION, true, false, true, null, null, null ) );
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
            childrenFeatures.add ( InfrastructurePackage.Literals.EQUINOX_BASE__USER_SERVICE );
            childrenFeatures.add ( InfrastructurePackage.Literals.EQUINOX_BASE__MODULES );
            childrenFeatures.add ( InfrastructurePackage.Literals.EQUINOX_BASE__CONFIGURATIONS );
            childrenFeatures.add ( InfrastructurePackage.Literals.EQUINOX_DRIVER__ACCESS_CREDENTIALS );
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
     * This returns EquinoxDriver.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public Object getImage ( final Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/EquinoxDriver.png" ) ); //$NON-NLS-1$
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected boolean shouldComposeCreationImage ()
    {
        return true;
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
        return getDriverLabel ( (EquinoxDriver)object, getString ( "_UI_EquinoxDriver_type" ) );
    }

    /**
     * This returns the label styled text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public Object getStyledText ( final Object object )
    {
        return getStyledDriverLabel ( (EquinoxDriver)object, getString ( "_UI_EquinoxDriver_type" ) );
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

        switch ( notification.getFeatureID ( EquinoxDriver.class ) )
        {
            case InfrastructurePackage.EQUINOX_DRIVER__INSTANCE_NUMBER:
                fireNotifyChanged ( new ViewerNotification ( notification, notification.getNotifier (), false, true ) );
                return;
            case InfrastructurePackage.EQUINOX_DRIVER__USER_SERVICE:
            case InfrastructurePackage.EQUINOX_DRIVER__MODULES:
            case InfrastructurePackage.EQUINOX_DRIVER__CONFIGURATIONS:
            case InfrastructurePackage.EQUINOX_DRIVER__ACCESS_CREDENTIALS:
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

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.EQUINOX_BASE__USER_SERVICE, InfrastructureFactory.eINSTANCE.createSystemPropertyUserService () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.EQUINOX_BASE__USER_SERVICE, InfrastructureFactory.eINSTANCE.createJdbcUserService () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.EQUINOX_BASE__MODULES, InfrastructureFactory.eINSTANCE.createHttpServiceModule () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.EQUINOX_BASE__MODULES, InfrastructureFactory.eINSTANCE.createRestExporterModule () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.EQUINOX_BASE__MODULES, InfrastructureFactory.eINSTANCE.createWebAdminConsole () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.EQUINOX_BASE__MODULES, InfrastructureFactory.eINSTANCE.createOracleVMSettings () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.EQUINOX_BASE__MODULES, InfrastructureFactory.eINSTANCE.createGenericVMSettings () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.EQUINOX_BASE__MODULES, InfrastructureFactory.eINSTANCE.createEventInjectorHttp () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.EQUINOX_BASE__MODULES, InfrastructureFactory.eINSTANCE.createEventInjectorSyslog () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.EQUINOX_BASE__MODULES, InfrastructureFactory.eINSTANCE.createJMXSettings () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.EQUINOX_BASE__MODULES, InfrastructureFactory.eINSTANCE.createConfigurationAdminFileBackend () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.EQUINOX_BASE__MODULES, InfrastructureFactory.eINSTANCE.createDSFileBackend () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.EQUINOX_BASE__MODULES, InfrastructureFactory.eINSTANCE.createConfigurationAdminSettings () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.EQUINOX_BASE__CONFIGURATIONS, OsgiFactory.eINSTANCE.createEventStorageJdbc () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.EQUINOX_BASE__CONFIGURATIONS, OsgiFactory.eINSTANCE.createEventStoragePostgres () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.EQUINOX_BASE__CONFIGURATIONS, OsgiFactory.eINSTANCE.createTelnetConsole () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.EQUINOX_BASE__CONFIGURATIONS, OsgiFactory.eINSTANCE.createEventInjectorPostgres () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.EQUINOX_BASE__CONFIGURATIONS, OsgiFactory.eINSTANCE.createEventInjectorJdbc () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.EQUINOX_BASE__CONFIGURATIONS, OsgiFactory.eINSTANCE.createProfileConfiguration () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.EQUINOX_BASE__CONFIGURATIONS, OsgiFactory.eINSTANCE.createEventInjectorManager () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.EQUINOX_DRIVER__ACCESS_CREDENTIALS, WorldFactory.eINSTANCE.createUsernamePasswordCredentials () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.EQUINOX_DRIVER__ACCESS_CREDENTIALS, WorldFactory.eINSTANCE.createPasswordCredentials () ) );
    }

}
