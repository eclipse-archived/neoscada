/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.memory.provider;

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
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.scada.configuration.memory.MemoryFactory;
import org.eclipse.scada.configuration.memory.MemoryPackage;
import org.eclipse.scada.configuration.memory.Variable;

/**
 * This is the item provider adapter for a {@link org.eclipse.scada.configuration.memory.Variable} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class VariableItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public VariableItemProvider ( AdapterFactory adapterFactory )
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
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_Variable_name_feature" ), getString ( "_UI_PropertyDescriptor_description", "_UI_Variable_name_feature", "_UI_Variable_type" ), MemoryPackage.Literals.VARIABLE__NAME, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null ) );
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
            childrenFeatures.add ( MemoryPackage.Literals.VARIABLE__TYPE );
            childrenFeatures.add ( MemoryPackage.Literals.VARIABLE__ATTRIBUTES );
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
     * This returns Variable.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage ( Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/Variable" ) );
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
        String label = ( (Variable)object ).getName ();
        return label == null || label.length () == 0 ? getString ( "_UI_Variable_type" ) : getString ( "_UI_Variable_type" ) + " " + label;
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

        switch ( notification.getFeatureID ( Variable.class ) )
        {
            case MemoryPackage.VARIABLE__NAME:
                fireNotifyChanged ( new ViewerNotification ( notification, notification.getNotifier (), false, true ) );
                return;
            case MemoryPackage.VARIABLE__TYPE:
            case MemoryPackage.VARIABLE__ATTRIBUTES:
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

        newChildDescriptors.add ( createChildParameter ( MemoryPackage.Literals.VARIABLE__TYPE, MemoryFactory.eINSTANCE.createBitType () ) );

        newChildDescriptors.add ( createChildParameter ( MemoryPackage.Literals.VARIABLE__TYPE, MemoryFactory.eINSTANCE.createFloat32Type () ) );

        newChildDescriptors.add ( createChildParameter ( MemoryPackage.Literals.VARIABLE__TYPE, MemoryFactory.eINSTANCE.createUserDefinedType () ) );

        newChildDescriptors.add ( createChildParameter ( MemoryPackage.Literals.VARIABLE__TYPE, MemoryFactory.eINSTANCE.createUnsignedInteger16Type () ) );

        newChildDescriptors.add ( createChildParameter ( MemoryPackage.Literals.VARIABLE__TYPE, MemoryFactory.eINSTANCE.createUnsignedInteger32Type () ) );

        newChildDescriptors.add ( createChildParameter ( MemoryPackage.Literals.VARIABLE__TYPE, MemoryFactory.eINSTANCE.createUnsignedInteger8Type () ) );

        newChildDescriptors.add ( createChildParameter ( MemoryPackage.Literals.VARIABLE__TYPE, MemoryFactory.eINSTANCE.createFloat64Type () ) );

        newChildDescriptors.add ( createChildParameter ( MemoryPackage.Literals.VARIABLE__TYPE, MemoryFactory.eINSTANCE.createSignedInteger8Type () ) );

        newChildDescriptors.add ( createChildParameter ( MemoryPackage.Literals.VARIABLE__TYPE, MemoryFactory.eINSTANCE.createSignedInteger16Type () ) );

        newChildDescriptors.add ( createChildParameter ( MemoryPackage.Literals.VARIABLE__TYPE, MemoryFactory.eINSTANCE.createSignedInteger32Type () ) );

        newChildDescriptors.add ( createChildParameter ( MemoryPackage.Literals.VARIABLE__TYPE, MemoryFactory.eINSTANCE.createSignedInteger64Type () ) );

        newChildDescriptors.add ( createChildParameter ( MemoryPackage.Literals.VARIABLE__TYPE, MemoryFactory.eINSTANCE.createFixedLengthStringType () ) );

        newChildDescriptors.add ( createChildParameter ( MemoryPackage.Literals.VARIABLE__TYPE, MemoryFactory.eINSTANCE.createFixedLengthBlobType () ) );

        newChildDescriptors.add ( createChildParameter ( MemoryPackage.Literals.VARIABLE__ATTRIBUTES, MemoryFactory.eINSTANCE.createAttribute () ) );
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
        return MemoryEditPlugin.INSTANCE;
    }

}
