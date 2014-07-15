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
package org.eclipse.scada.configuration.world.deployment.provider;

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
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.scada.configuration.world.deployment.DeploymentFactory;
import org.eclipse.scada.configuration.world.deployment.DeploymentPackage;
import org.eclipse.scada.configuration.world.deployment.MsiDeploymentMechanism;

import org.eclipse.scada.configuration.world.provider.WorldEditPlugin;

/**
 * This is the item provider adapter for a {@link org.eclipse.scada.configuration.world.deployment.MsiDeploymentMechanism} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MsiDeploymentMechanismItemProvider
        extends ItemProviderAdapter
        implements
        IEditingDomainItemProvider,
        IStructuredItemContentProvider,
        ITreeItemContentProvider,
        IItemLabelProvider,
        IItemPropertySource,
        ITableItemLabelProvider
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MsiDeploymentMechanismItemProvider ( AdapterFactory adapterFactory )
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

            addVersionPropertyDescriptor ( object );
            addUpgradeCodePropertyDescriptor ( object );
            addManufacturerPropertyDescriptor ( object );
            addSharedPlatformPropertyDescriptor ( object );
            addArchitecturePropertyDescriptor ( object );
            addEnableFirewallPropertyDescriptor ( object );
            addEnableUserInterfacePropertyDescriptor ( object );
            addLicenseFilePropertyDescriptor ( object );
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Version feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addVersionPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_MsiDeploymentMechanism_version_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_MsiDeploymentMechanism_version_feature", "_UI_MsiDeploymentMechanism_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        DeploymentPackage.Literals.MSI_DEPLOYMENT_MECHANISM__VERSION,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null ) );
    }

    /**
     * This adds a property descriptor for the Upgrade Code feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addUpgradeCodePropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_MsiDeploymentMechanism_upgradeCode_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_MsiDeploymentMechanism_upgradeCode_feature", "_UI_MsiDeploymentMechanism_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        DeploymentPackage.Literals.MSI_DEPLOYMENT_MECHANISM__UPGRADE_CODE,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null ) );
    }

    /**
     * This adds a property descriptor for the Manufacturer feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addManufacturerPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_MsiDeploymentMechanism_manufacturer_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_MsiDeploymentMechanism_manufacturer_feature", "_UI_MsiDeploymentMechanism_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        DeploymentPackage.Literals.MSI_DEPLOYMENT_MECHANISM__MANUFACTURER,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null ) );
    }

    /**
     * This adds a property descriptor for the Shared Platform feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addSharedPlatformPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_MsiDeploymentMechanism_sharedPlatform_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_MsiDeploymentMechanism_sharedPlatform_feature", "_UI_MsiDeploymentMechanism_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        DeploymentPackage.Literals.MSI_DEPLOYMENT_MECHANISM__SHARED_PLATFORM,
                        true,
                        false,
                        true,
                        null,
                        null,
                        null ) );
    }

    /**
     * This adds a property descriptor for the Architecture feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addArchitecturePropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_MsiDeploymentMechanism_architecture_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_MsiDeploymentMechanism_architecture_feature", "_UI_MsiDeploymentMechanism_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        DeploymentPackage.Literals.MSI_DEPLOYMENT_MECHANISM__ARCHITECTURE,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null ) );
    }

    /**
     * This adds a property descriptor for the Enable Firewall feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addEnableFirewallPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_MsiDeploymentMechanism_enableFirewall_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_MsiDeploymentMechanism_enableFirewall_feature", "_UI_MsiDeploymentMechanism_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        DeploymentPackage.Literals.MSI_DEPLOYMENT_MECHANISM__ENABLE_FIREWALL,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                        null,
                        null ) );
    }

    /**
     * This adds a property descriptor for the Enable User Interface feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addEnableUserInterfacePropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_MsiDeploymentMechanism_enableUserInterface_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_MsiDeploymentMechanism_enableUserInterface_feature", "_UI_MsiDeploymentMechanism_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        DeploymentPackage.Literals.MSI_DEPLOYMENT_MECHANISM__ENABLE_USER_INTERFACE,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                        null,
                        null ) );
    }

    /**
     * This adds a property descriptor for the License File feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addLicenseFilePropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_MsiDeploymentMechanism_licenseFile_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_MsiDeploymentMechanism_licenseFile_feature", "_UI_MsiDeploymentMechanism_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        DeploymentPackage.Literals.MSI_DEPLOYMENT_MECHANISM__LICENSE_FILE,
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
    public Collection<? extends EStructuralFeature> getChildrenFeatures ( Object object )
    {
        if ( childrenFeatures == null )
        {
            super.getChildrenFeatures ( object );
            childrenFeatures.add ( DeploymentPackage.Literals.MSI_DEPLOYMENT_MECHANISM__LOCAL_PLATFORM );
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
     * This returns MsiDeploymentMechanism.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage ( Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/MsiDeploymentMechanism" ) ); //$NON-NLS-1$
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
     * @generated
     */
    @Override
    public String getText ( Object object )
    {
        String label = ( (MsiDeploymentMechanism)object ).getVersion ();
        return label == null || label.length () == 0 ?
                getString ( "_UI_MsiDeploymentMechanism_type" ) : //$NON-NLS-1$
                getString ( "_UI_MsiDeploymentMechanism_type" ) + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

        switch ( notification.getFeatureID ( MsiDeploymentMechanism.class ) )
        {
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__VERSION:
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__UPGRADE_CODE:
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__MANUFACTURER:
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__ARCHITECTURE:
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__ENABLE_FIREWALL:
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__ENABLE_USER_INTERFACE:
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__LICENSE_FILE:
                fireNotifyChanged ( new ViewerNotification ( notification, notification.getNotifier (), false, true ) );
                return;
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM__LOCAL_PLATFORM:
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

        newChildDescriptors.add
                ( createChildParameter
                ( DeploymentPackage.Literals.MSI_DEPLOYMENT_MECHANISM__LOCAL_PLATFORM,
                        DeploymentFactory.eINSTANCE.createP2Platform () ) );
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
        return WorldEditPlugin.INSTANCE;
    }

}
