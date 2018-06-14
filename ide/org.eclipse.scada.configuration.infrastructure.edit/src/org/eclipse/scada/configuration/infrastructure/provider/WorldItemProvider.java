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
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IItemStyledLabelProvider;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.scada.configuration.infrastructure.InfrastructureFactory;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.infrastructure.World;
import org.eclipse.scada.configuration.world.WorldFactory;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;

/**
 * This is the item provider adapter for a {@link org.eclipse.scada.configuration.infrastructure.World} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class WorldItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource, IItemStyledLabelProvider
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WorldItemProvider ( AdapterFactory adapterFactory )
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

            addDefaultSecurityConfigurationPropertyDescriptor ( object );
            addDefaultMasterHandlerPrioritiesPropertyDescriptor ( object );
            addDefaultMasterCustomizationProfilePropertyDescriptor ( object );
            addDefaultValueArchiveCustomizationProfilePropertyDescriptor ( object );
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Default Security Configuration feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addDefaultSecurityConfigurationPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_World_defaultSecurityConfiguration_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_World_defaultSecurityConfiguration_feature", "_UI_World_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                InfrastructurePackage.Literals.WORLD__DEFAULT_SECURITY_CONFIGURATION, true, false, true, null, null, null ) );
    }

    /**
     * This adds a property descriptor for the Default Master Handler Priorities feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addDefaultMasterHandlerPrioritiesPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_World_defaultMasterHandlerPriorities_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_World_defaultMasterHandlerPriorities_feature", "_UI_World_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                InfrastructurePackage.Literals.WORLD__DEFAULT_MASTER_HANDLER_PRIORITIES, true, false, true, null, null, null ) );
    }

    /**
     * This adds a property descriptor for the Default Master Customization Profile feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addDefaultMasterCustomizationProfilePropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_World_defaultMasterCustomizationProfile_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_World_defaultMasterCustomizationProfile_feature", "_UI_World_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                InfrastructurePackage.Literals.WORLD__DEFAULT_MASTER_CUSTOMIZATION_PROFILE, true, false, true, null, null, null ) );
    }

    /**
     * This adds a property descriptor for the Default Value Archive Customization Profile feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addDefaultValueArchiveCustomizationProfilePropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_World_defaultValueArchiveCustomizationProfile_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_World_defaultValueArchiveCustomizationProfile_feature", "_UI_World_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                InfrastructurePackage.Literals.WORLD__DEFAULT_VALUE_ARCHIVE_CUSTOMIZATION_PROFILE, true, false, true, null, null, null ) );
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
            childrenFeatures.add ( InfrastructurePackage.Literals.WORLD__NODES );
            childrenFeatures.add ( InfrastructurePackage.Literals.WORLD__OPTIONS );
            childrenFeatures.add ( InfrastructurePackage.Literals.WORLD__DEFAULT_CREDENTIALS );
            childrenFeatures.add ( InfrastructurePackage.Literals.WORLD__DEFAULT_DRIVER_PASSWORD );
            childrenFeatures.add ( InfrastructurePackage.Literals.WORLD__APPLICATION_CONFIGURATIONS );
            childrenFeatures.add ( InfrastructurePackage.Literals.WORLD__DEFAULT_DRIVER_ACCESS_CREDENTIALS );
            childrenFeatures.add ( InfrastructurePackage.Literals.WORLD__CONFIGURATIONS );
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
     * This returns World.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public Object getImage ( final Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/World.png" ) ); //$NON-NLS-1$
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
        return ( (StyledString)getStyledText ( object ) ).getString ();
    }

    /**
     * This returns the label styled text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getStyledText ( Object object )
    {
        return new StyledString ( getString ( "_UI_World_type" ) ); //$NON-NLS-1$
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

        switch ( notification.getFeatureID ( World.class ) )
        {
            case InfrastructurePackage.WORLD__NODES:
            case InfrastructurePackage.WORLD__OPTIONS:
            case InfrastructurePackage.WORLD__DEFAULT_CREDENTIALS:
            case InfrastructurePackage.WORLD__DEFAULT_DRIVER_PASSWORD:
            case InfrastructurePackage.WORLD__APPLICATION_CONFIGURATIONS:
            case InfrastructurePackage.WORLD__DEFAULT_DRIVER_ACCESS_CREDENTIALS:
            case InfrastructurePackage.WORLD__CONFIGURATIONS:
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

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.WORLD__NODES, InfrastructureFactory.eINSTANCE.createExternalNode () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.WORLD__NODES, InfrastructureFactory.eINSTANCE.createSystemNode () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.WORLD__OPTIONS, InfrastructureFactory.eINSTANCE.createOptions () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.WORLD__DEFAULT_CREDENTIALS, WorldFactory.eINSTANCE.createUsernamePasswordCredentials () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.WORLD__DEFAULT_CREDENTIALS, WorldFactory.eINSTANCE.createPasswordCredentials () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.WORLD__DEFAULT_DRIVER_PASSWORD, WorldFactory.eINSTANCE.createPasswordCredentials () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.WORLD__APPLICATION_CONFIGURATIONS, OsgiFactory.eINSTANCE.createEventStorageJdbc () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.WORLD__APPLICATION_CONFIGURATIONS, OsgiFactory.eINSTANCE.createEventStoragePostgres () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.WORLD__APPLICATION_CONFIGURATIONS, OsgiFactory.eINSTANCE.createTelnetConsole () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.WORLD__APPLICATION_CONFIGURATIONS, OsgiFactory.eINSTANCE.createEventInjectorPostgres () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.WORLD__APPLICATION_CONFIGURATIONS, OsgiFactory.eINSTANCE.createEventInjectorJdbc () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.WORLD__APPLICATION_CONFIGURATIONS, OsgiFactory.eINSTANCE.createProfileConfiguration () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.WORLD__APPLICATION_CONFIGURATIONS, OsgiFactory.eINSTANCE.createEventInjectorManager () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.WORLD__DEFAULT_DRIVER_ACCESS_CREDENTIALS, WorldFactory.eINSTANCE.createUsernamePasswordCredentials () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.WORLD__DEFAULT_DRIVER_ACCESS_CREDENTIALS, WorldFactory.eINSTANCE.createPasswordCredentials () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.WORLD__CONFIGURATIONS, InfrastructureFactory.eINSTANCE.createConfigurations () ) );
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

        boolean qualify = childFeature == InfrastructurePackage.Literals.WORLD__DEFAULT_CREDENTIALS || childFeature == InfrastructurePackage.Literals.WORLD__DEFAULT_DRIVER_ACCESS_CREDENTIALS || childFeature == InfrastructurePackage.Literals.WORLD__DEFAULT_DRIVER_PASSWORD;

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
