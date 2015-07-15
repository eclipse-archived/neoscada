/**
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.component.provider;

import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.scada.configuration.component.ComponentFactory;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.ComponentWorld;

/**
 * This is the item provider adapter for a {@link org.eclipse.scada.configuration.component.ComponentWorld} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ComponentWorldItemProvider extends ContainerItemProvider
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComponentWorldItemProvider ( AdapterFactory adapterFactory )
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

            addInfrastructurePropertyDescriptor ( object );
            addDefaultCustomizationPipelinePropertyDescriptor ( object );
            addDefaultArchiveSelectorPropertyDescriptor ( object );
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Infrastructure feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addInfrastructurePropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ComponentWorld_infrastructure_feature" ), //$NON-NLS-1$
        getString ( "_UI_PropertyDescriptor_description", "_UI_ComponentWorld_infrastructure_feature", "_UI_ComponentWorld_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        ComponentPackage.Literals.COMPONENT_WORLD__INFRASTRUCTURE, true, false, true, null, null, null ) );
    }

    /**
     * This adds a property descriptor for the Default Customization Pipeline feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addDefaultCustomizationPipelinePropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ComponentWorld_defaultCustomizationPipeline_feature" ), //$NON-NLS-1$
        getString ( "_UI_PropertyDescriptor_description", "_UI_ComponentWorld_defaultCustomizationPipeline_feature", "_UI_ComponentWorld_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        ComponentPackage.Literals.COMPONENT_WORLD__DEFAULT_CUSTOMIZATION_PIPELINE, true, false, true, null, null, null ) );
    }

    /**
     * This adds a property descriptor for the Default Archive Selector feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addDefaultArchiveSelectorPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ComponentWorld_defaultArchiveSelector_feature" ), //$NON-NLS-1$
        getString ( "_UI_PropertyDescriptor_description", "_UI_ComponentWorld_defaultArchiveSelector_feature", "_UI_ComponentWorld_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        ComponentPackage.Literals.COMPONENT_WORLD__DEFAULT_ARCHIVE_SELECTOR, true, false, true, null, null, null ) );
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
            childrenFeatures.add ( ComponentPackage.Literals.COMPONENT_WORLD__LEVELS );
            childrenFeatures.add ( ComponentPackage.Literals.COMPONENT_WORLD__CONFIGURATIONS );
            childrenFeatures.add ( ComponentPackage.Literals.COMPONENT_WORLD__SERVICES );
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
     * This returns ComponentWorld.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public Object getImage ( final Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/ComponentWorld.png" ) ); //$NON-NLS-1$
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
        return getString ( "_UI_ComponentWorld_type" ); //$NON-NLS-1$
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

        switch ( notification.getFeatureID ( ComponentWorld.class ) )
        {
            case ComponentPackage.COMPONENT_WORLD__LEVELS:
            case ComponentPackage.COMPONENT_WORLD__CONFIGURATIONS:
            case ComponentPackage.COMPONENT_WORLD__SERVICES:
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

        newChildDescriptors.add ( createChildParameter ( ComponentPackage.Literals.COMPONENT_WORLD__LEVELS, ComponentFactory.eINSTANCE.createLevel () ) );

        newChildDescriptors.add ( createChildParameter ( ComponentPackage.Literals.COMPONENT_WORLD__CONFIGURATIONS, ComponentFactory.eINSTANCE.createMarkerConfiguration () ) );

        newChildDescriptors.add ( createChildParameter ( ComponentPackage.Literals.COMPONENT_WORLD__CONFIGURATIONS, ComponentFactory.eINSTANCE.createSummariesConfiguration () ) );

        newChildDescriptors.add ( createChildParameter ( ComponentPackage.Literals.COMPONENT_WORLD__SERVICES, ComponentFactory.eINSTANCE.createDataMapperService () ) );

        newChildDescriptors.add ( createChildParameter ( ComponentPackage.Literals.COMPONENT_WORLD__SERVICES, ComponentFactory.eINSTANCE.createFormulaModule () ) );

        newChildDescriptors.add ( createChildParameter ( ComponentPackage.Literals.COMPONENT_WORLD__SERVICES, ComponentFactory.eINSTANCE.createAverageModule () ) );

        newChildDescriptors.add ( createChildParameter ( ComponentPackage.Literals.COMPONENT_WORLD__SERVICES, ComponentFactory.eINSTANCE.createScriptModule () ) );

        newChildDescriptors.add ( createChildParameter ( ComponentPackage.Literals.COMPONENT_WORLD__SERVICES, ComponentFactory.eINSTANCE.createMovingAverageModule () ) );
    }

}
