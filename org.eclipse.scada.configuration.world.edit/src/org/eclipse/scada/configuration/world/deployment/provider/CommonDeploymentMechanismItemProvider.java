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
import org.eclipse.scada.configuration.world.deployment.CommonDeploymentMechanism;
import org.eclipse.scada.configuration.world.deployment.DeploymentFactory;
import org.eclipse.scada.configuration.world.deployment.DeploymentPackage;
import org.eclipse.scada.configuration.world.deployment.StartupMechanism;
import org.eclipse.scada.configuration.world.provider.WorldEditPlugin;

/**
 * This is the item provider adapter for a {@link org.eclipse.scada.configuration.world.deployment.CommonDeploymentMechanism} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CommonDeploymentMechanismItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource, ITableItemLabelProvider
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CommonDeploymentMechanismItemProvider ( AdapterFactory adapterFactory )
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

            addMaintainerPropertyDescriptor ( object );
            addAdditionalDependenciesPropertyDescriptor ( object );
            addStartupMechanismPropertyDescriptor ( object );
            addMultiUserScreenPropertyDescriptor ( object );
            addOperatingSystemPropertyDescriptor ( object );
            addAutomaticCreatePropertyDescriptor ( object );
            addRecreateBackupsPropertyDescriptor ( object );
            addSetupPropertyDescriptor ( object );
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Maintainer feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addMaintainerPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_CommonDeploymentMechanism_maintainer_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_CommonDeploymentMechanism_maintainer_feature", "_UI_CommonDeploymentMechanism_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                DeploymentPackage.Literals.COMMON_DEPLOYMENT_MECHANISM__MAINTAINER, true, false, true, null, getString ( "_UI_legalPropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the Additional Dependencies feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addAdditionalDependenciesPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_CommonDeploymentMechanism_additionalDependencies_feature" ), //$NON-NLS-1$
                getString ( "_UI_CommonDeploymentMechanism_additionalDependencies_description" ), //$NON-NLS-1$
                DeploymentPackage.Literals.COMMON_DEPLOYMENT_MECHANISM__ADDITIONAL_DEPENDENCIES, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString ( "_UI_informationPropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the Startup Mechanism feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addStartupMechanismPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_CommonDeploymentMechanism_startupMechanism_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_CommonDeploymentMechanism_startupMechanism_feature", "_UI_CommonDeploymentMechanism_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                DeploymentPackage.Literals.COMMON_DEPLOYMENT_MECHANISM__STARTUP_MECHANISM, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString ( "_UI_informationPropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the Multi User Screen feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addMultiUserScreenPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_CommonDeploymentMechanism_multiUserScreen_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_CommonDeploymentMechanism_multiUserScreen_feature", "_UI_CommonDeploymentMechanism_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                DeploymentPackage.Literals.COMMON_DEPLOYMENT_MECHANISM__MULTI_USER_SCREEN, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, getString ( "_UI_setupPropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the Operating System feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addOperatingSystemPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_CommonDeploymentMechanism_operatingSystem_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_CommonDeploymentMechanism_operatingSystem_feature", "_UI_CommonDeploymentMechanism_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                DeploymentPackage.Literals.COMMON_DEPLOYMENT_MECHANISM__OPERATING_SYSTEM, true, false, true, null, getString ( "_UI_setupPropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the Automatic Create feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addAutomaticCreatePropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_CommonDeploymentMechanism_automaticCreate_feature" ), //$NON-NLS-1$
                getString ( "_UI_CommonDeploymentMechanism_automaticCreate_description" ), //$NON-NLS-1$
                DeploymentPackage.Literals.COMMON_DEPLOYMENT_MECHANISM__AUTOMATIC_CREATE, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, getString ( "_UI_setupPropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the Recreate Backups feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addRecreateBackupsPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_CommonDeploymentMechanism_recreateBackups_feature" ), //$NON-NLS-1$
                getString ( "_UI_CommonDeploymentMechanism_recreateBackups_description" ), //$NON-NLS-1$
                DeploymentPackage.Literals.COMMON_DEPLOYMENT_MECHANISM__RECREATE_BACKUPS, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString ( "_UI_setupPropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the Setup feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addSetupPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_CommonDeploymentMechanism_setup_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_CommonDeploymentMechanism_setup_feature", "_UI_CommonDeploymentMechanism_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                DeploymentPackage.Literals.COMMON_DEPLOYMENT_MECHANISM__SETUP, true, false, true, null, getString ( "_UI_setupPropertyCategory" ), //$NON-NLS-1$
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
            childrenFeatures.add ( DeploymentPackage.Literals.COMMON_DEPLOYMENT_MECHANISM__CHANGES );
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
     * This returns CommonDeploymentMechanism.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage ( Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/CommonDeploymentMechanism" ) ); //$NON-NLS-1$
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
        StartupMechanism labelValue = ( (CommonDeploymentMechanism)object ).getStartupMechanism ();
        String label = labelValue == null ? null : labelValue.toString ();
        return label == null || label.length () == 0 ? getString ( "_UI_CommonDeploymentMechanism_type" ) : //$NON-NLS-1$
        getString ( "_UI_CommonDeploymentMechanism_type" ) + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

        switch ( notification.getFeatureID ( CommonDeploymentMechanism.class ) )
        {
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__ADDITIONAL_DEPENDENCIES:
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__STARTUP_MECHANISM:
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__MULTI_USER_SCREEN:
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__AUTOMATIC_CREATE:
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__RECREATE_BACKUPS:
                fireNotifyChanged ( new ViewerNotification ( notification, notification.getNotifier (), false, true ) );
                return;
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM__CHANGES:
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

        newChildDescriptors.add ( createChildParameter ( DeploymentPackage.Literals.COMMON_DEPLOYMENT_MECHANISM__CHANGES, DeploymentFactory.eINSTANCE.createChangeEntry () ) );
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
