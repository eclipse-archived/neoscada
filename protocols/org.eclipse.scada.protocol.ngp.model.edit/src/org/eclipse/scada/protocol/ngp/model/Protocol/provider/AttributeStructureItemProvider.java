/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - implement security callback system
 *******************************************************************************/
package org.eclipse.scada.protocol.ngp.model.Protocol.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.scada.protocol.ngp.model.Protocol.AttributeStructure;
import org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolFactory;
import org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.scada.protocol.ngp.model.Protocol.AttributeStructure} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AttributeStructureItemProvider extends DocumentedElementItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AttributeStructureItemProvider ( AdapterFactory adapterFactory )
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

            addNamePropertyDescriptor ( object );
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Name feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addNamePropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_AttributeStructure_name_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_AttributeStructure_name_feature", "_UI_AttributeStructure_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        ProtocolPackage.Literals.ATTRIBUTE_STRUCTURE__NAME,
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
            childrenFeatures.add ( ProtocolPackage.Literals.ATTRIBUTE_STRUCTURE__ATTRIBUTES );
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
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getText ( Object object )
    {
        String label = ( (AttributeStructure)object ).getName ();
        return label == null || label.length () == 0 ?
                getString ( "_UI_AttributeStructure_type" ) : //$NON-NLS-1$
                getString ( "_UI_AttributeStructure_type" ) + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

        switch ( notification.getFeatureID ( AttributeStructure.class ) )
        {
            case ProtocolPackage.ATTRIBUTE_STRUCTURE__NAME:
                fireNotifyChanged ( new ViewerNotification ( notification, notification.getNotifier (), false, true ) );
                return;
            case ProtocolPackage.ATTRIBUTE_STRUCTURE__ATTRIBUTES:
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
                ( ProtocolPackage.Literals.ATTRIBUTE_STRUCTURE__ATTRIBUTES,
                        ProtocolFactory.eINSTANCE.createStringAttribute () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( ProtocolPackage.Literals.ATTRIBUTE_STRUCTURE__ATTRIBUTES,
                        ProtocolFactory.eINSTANCE.createBooleanAttribute () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( ProtocolPackage.Literals.ATTRIBUTE_STRUCTURE__ATTRIBUTES,
                        ProtocolFactory.eINSTANCE.createStructureAttribute () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( ProtocolPackage.Literals.ATTRIBUTE_STRUCTURE__ATTRIBUTES,
                        ProtocolFactory.eINSTANCE.createVariantAttribute () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( ProtocolPackage.Literals.ATTRIBUTE_STRUCTURE__ATTRIBUTES,
                        ProtocolFactory.eINSTANCE.createIntegerAttribute () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( ProtocolPackage.Literals.ATTRIBUTE_STRUCTURE__ATTRIBUTES,
                        ProtocolFactory.eINSTANCE.createLongAttribute () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( ProtocolPackage.Literals.ATTRIBUTE_STRUCTURE__ATTRIBUTES,
                        ProtocolFactory.eINSTANCE.createFloatAttribute () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( ProtocolPackage.Literals.ATTRIBUTE_STRUCTURE__ATTRIBUTES,
                        ProtocolFactory.eINSTANCE.createVariantMapAttribute () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( ProtocolPackage.Literals.ATTRIBUTE_STRUCTURE__ATTRIBUTES,
                        ProtocolFactory.eINSTANCE.createPropertiesAttribute () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( ProtocolPackage.Literals.ATTRIBUTE_STRUCTURE__ATTRIBUTES,
                        ProtocolFactory.eINSTANCE.createEnumAttribute () ) );
    }

}
