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
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.scada.configuration.infrastructure.InfrastructureFactory;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.infrastructure.Node;
import org.eclipse.scada.configuration.infrastructure.SystemNode;
import org.eclipse.scada.configuration.world.deployment.DeploymentFactory;

/**
 * This is the item provider adapter for a {@link org.eclipse.scada.configuration.infrastructure.SystemNode} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SystemNodeItemProvider extends NodeItemProvider
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SystemNodeItemProvider ( AdapterFactory adapterFactory )
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

        }
        return itemPropertyDescriptors;
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
            childrenFeatures.add ( InfrastructurePackage.Literals.SYSTEM_NODE__DEPLOYMENT );
            childrenFeatures.add ( InfrastructurePackage.Literals.SYSTEM_NODE__DRIVERS );
            childrenFeatures.add ( InfrastructurePackage.Literals.SYSTEM_NODE__MASTERS );
            childrenFeatures.add ( InfrastructurePackage.Literals.SYSTEM_NODE__VALUE_ARCHIVES );
            childrenFeatures.add ( InfrastructurePackage.Literals.SYSTEM_NODE__SERVICES );
            childrenFeatures.add ( InfrastructurePackage.Literals.SYSTEM_NODE__VALUE_SLAVES );
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
     * This returns SystemNode.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public Object getImage ( final Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/SystemNode.png" ) ); //$NON-NLS-1$
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
     *
     * @generated NOT
     */
    @Override
    public Object getStyledText ( final Object object )
    {
        return getStyledNodeLabel ( (Node)object, getString ( "_UI_SystemNode_type" ) );
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

        switch ( notification.getFeatureID ( SystemNode.class ) )
        {
            case InfrastructurePackage.SYSTEM_NODE__APPLICATIONS:
                fireNotifyChanged ( new ViewerNotification ( notification, notification.getNotifier (), false, true ) );
                return;
            case InfrastructurePackage.SYSTEM_NODE__DEPLOYMENT:
            case InfrastructurePackage.SYSTEM_NODE__DRIVERS:
            case InfrastructurePackage.SYSTEM_NODE__MASTERS:
            case InfrastructurePackage.SYSTEM_NODE__VALUE_ARCHIVES:
            case InfrastructurePackage.SYSTEM_NODE__SERVICES:
            case InfrastructurePackage.SYSTEM_NODE__VALUE_SLAVES:
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

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.SYSTEM_NODE__DEPLOYMENT, DeploymentFactory.eINSTANCE.createDebianDeploymentMechanism () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.SYSTEM_NODE__DEPLOYMENT, DeploymentFactory.eINSTANCE.createRedhatDeploymentMechanism () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.SYSTEM_NODE__DEPLOYMENT, DeploymentFactory.eINSTANCE.createMsiDeploymentMechanism () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.SYSTEM_NODE__DRIVERS, InfrastructureFactory.eINSTANCE.createCommonDriver () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.SYSTEM_NODE__DRIVERS, InfrastructureFactory.eINSTANCE.createEquinoxDriver () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.SYSTEM_NODE__DRIVERS, InfrastructureFactory.eINSTANCE.createExternalDriver () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.SYSTEM_NODE__MASTERS, InfrastructureFactory.eINSTANCE.createMasterServer () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.SYSTEM_NODE__VALUE_ARCHIVES, InfrastructureFactory.eINSTANCE.createValueArchiveServer () ) );

        newChildDescriptors.add ( createChildParameter ( InfrastructurePackage.Literals.SYSTEM_NODE__VALUE_SLAVES, InfrastructureFactory.eINSTANCE.createValueArchiveSlave () ) );
    }

}
