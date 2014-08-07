/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.details.model.provider;

import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.scada.vi.details.model.DetailViewPackage;
import org.eclipse.scada.vi.details.model.ValueSetComponent;

/**
 * This is the item provider adapter for a {@link org.eclipse.scada.vi.details.model.ValueSetComponent} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ValueSetComponentItemProvider extends WriteableComponentItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ValueSetComponentItemProvider ( AdapterFactory adapterFactory )
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

            addValueDescriptorPropertyDescriptor ( object );
            addSetDescriptorPropertyDescriptor ( object );
            addResetDescriptorPropertyDescriptor ( object );
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Value Descriptor feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addValueDescriptorPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_ValueSetComponent_valueDescriptor_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_ValueSetComponent_valueDescriptor_feature", "_UI_ValueSetComponent_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        DetailViewPackage.Literals.VALUE_SET_COMPONENT__VALUE_DESCRIPTOR,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        getString ( "_UI_dataPropertyCategory" ), //$NON-NLS-1$
                        null ) );
    }

    /**
     * This adds a property descriptor for the Set Descriptor feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addSetDescriptorPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_ValueSetComponent_setDescriptor_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_ValueSetComponent_setDescriptor_feature", "_UI_ValueSetComponent_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        DetailViewPackage.Literals.VALUE_SET_COMPONENT__SET_DESCRIPTOR,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        getString ( "_UI_dataPropertyCategory" ), //$NON-NLS-1$
                        null ) );
    }

    /**
     * This adds a property descriptor for the Reset Descriptor feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addResetDescriptorPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_ValueSetComponent_resetDescriptor_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_ValueSetComponent_resetDescriptor_feature", "_UI_ValueSetComponent_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        DetailViewPackage.Literals.VALUE_SET_COMPONENT__RESET_DESCRIPTOR,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        getString ( "_UI_dataPropertyCategory" ), //$NON-NLS-1$
                        null ) );
    }

    /**
     * This returns ValueSetComponent.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage ( Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/ValueSetComponent" ) ); //$NON-NLS-1$
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
        String label = ( (ValueSetComponent)object ).getFormat ();
        return label == null || label.length () == 0 ?
                getString ( "_UI_ValueSetComponent_type" ) : //$NON-NLS-1$
                getString ( "_UI_ValueSetComponent_type" ) + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

        switch ( notification.getFeatureID ( ValueSetComponent.class ) )
        {
            case DetailViewPackage.VALUE_SET_COMPONENT__VALUE_DESCRIPTOR:
            case DetailViewPackage.VALUE_SET_COMPONENT__SET_DESCRIPTOR:
            case DetailViewPackage.VALUE_SET_COMPONENT__RESET_DESCRIPTOR:
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

}
