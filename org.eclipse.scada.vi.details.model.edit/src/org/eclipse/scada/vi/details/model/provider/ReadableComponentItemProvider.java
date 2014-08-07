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
import org.eclipse.scada.vi.details.model.ReadableComponent;

/**
 * This is the item provider adapter for a {@link org.eclipse.scada.vi.details.model.ReadableComponent} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ReadableComponentItemProvider extends ComponentItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ReadableComponentItemProvider ( AdapterFactory adapterFactory )
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

            addFormatPropertyDescriptor ( object );
            addDecimalPropertyDescriptor ( object );
            addAttributePropertyDescriptor ( object );
            addHdConnectionIdPropertyDescriptor ( object );
            addHdItemIdPropertyDescriptor ( object );
            addHdQueryStringPropertyDescriptor ( object );
            addIsTextPropertyDescriptor ( object );
            addNullReplacementValuePropertyDescriptor ( object );
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Format feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addFormatPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_ReadableComponent_format_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_ReadableComponent_format_feature", "_UI_ReadableComponent_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        DetailViewPackage.Literals.READABLE_COMPONENT__FORMAT,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        getString ( "_UI_formatPropertyCategory" ), //$NON-NLS-1$
                        null ) );
    }

    /**
     * This adds a property descriptor for the Decimal feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addDecimalPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_ReadableComponent_decimal_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_ReadableComponent_decimal_feature", "_UI_ReadableComponent_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        DetailViewPackage.Literals.READABLE_COMPONENT__DECIMAL,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        getString ( "_UI_formatPropertyCategory" ), //$NON-NLS-1$
                        null ) );
    }

    /**
     * This adds a property descriptor for the Attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addAttributePropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_ReadableComponent_attribute_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_ReadableComponent_attribute_feature", "_UI_ReadableComponent_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        DetailViewPackage.Literals.READABLE_COMPONENT__ATTRIBUTE,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        getString ( "_UI_formatPropertyCategory" ), //$NON-NLS-1$
                        null ) );
    }

    /**
     * This adds a property descriptor for the Hd Connection Id feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addHdConnectionIdPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_ReadableComponent_hdConnectionId_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_ReadableComponent_hdConnectionId_feature", "_UI_ReadableComponent_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        DetailViewPackage.Literals.READABLE_COMPONENT__HD_CONNECTION_ID,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        getString ( "_UI_hdPropertyCategory" ), //$NON-NLS-1$
                        null ) );
    }

    /**
     * This adds a property descriptor for the Hd Item Id feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addHdItemIdPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_ReadableComponent_hdItemId_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_ReadableComponent_hdItemId_feature", "_UI_ReadableComponent_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        DetailViewPackage.Literals.READABLE_COMPONENT__HD_ITEM_ID,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        getString ( "_UI_hdPropertyCategory" ), //$NON-NLS-1$
                        null ) );
    }

    /**
     * This adds a property descriptor for the Hd Query String feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected void addHdQueryStringPropertyDescriptor ( final Object object )
    {
        this.itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)this.adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ReadableComponent_hdQueryString_feature" ), //$NON-NLS-1$
                "The query string in the format: START:END[:MIN:MAX]. Where START, END is the relative start and end time in milliseconds based on now. And MIN, MAX is the range for the Y-axis.", DetailViewPackage.Literals.READABLE_COMPONENT__HD_QUERY_STRING, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString ( "_UI_hdPropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the Is Text feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addIsTextPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_ReadableComponent_isText_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_ReadableComponent_isText_feature", "_UI_ReadableComponent_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        DetailViewPackage.Literals.READABLE_COMPONENT__IS_TEXT,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                        getString ( "_UI_formatPropertyCategory" ), //$NON-NLS-1$
                        null ) );
    }

    /**
     * This adds a property descriptor for the Null Replacement Value feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addNullReplacementValuePropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_ReadableComponent_nullReplacementValue_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_ReadableComponent_nullReplacementValue_feature", "_UI_ReadableComponent_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        DetailViewPackage.Literals.READABLE_COMPONENT__NULL_REPLACEMENT_VALUE,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null ) );
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
        String label = ( (ReadableComponent)object ).getFormat ();
        return label == null || label.length () == 0 ?
                getString ( "_UI_ReadableComponent_type" ) : //$NON-NLS-1$
                getString ( "_UI_ReadableComponent_type" ) + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

        switch ( notification.getFeatureID ( ReadableComponent.class ) )
        {
            case DetailViewPackage.READABLE_COMPONENT__FORMAT:
            case DetailViewPackage.READABLE_COMPONENT__DECIMAL:
            case DetailViewPackage.READABLE_COMPONENT__ATTRIBUTE:
            case DetailViewPackage.READABLE_COMPONENT__HD_CONNECTION_ID:
            case DetailViewPackage.READABLE_COMPONENT__HD_ITEM_ID:
            case DetailViewPackage.READABLE_COMPONENT__HD_QUERY_STRING:
            case DetailViewPackage.READABLE_COMPONENT__IS_TEXT:
            case DetailViewPackage.READABLE_COMPONENT__NULL_REPLACEMENT_VALUE:
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
