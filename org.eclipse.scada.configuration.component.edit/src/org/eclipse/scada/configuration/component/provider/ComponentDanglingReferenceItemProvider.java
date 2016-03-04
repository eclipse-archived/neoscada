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
package org.eclipse.scada.configuration.component.provider;

import java.util.Collection;
import java.util.List;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.scada.configuration.component.ComponentDanglingReference;
import org.eclipse.scada.configuration.component.ComponentPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.scada.configuration.component.ComponentDanglingReference} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ComponentDanglingReferenceItemProvider extends DanglingItemReferenceItemProvider
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComponentDanglingReferenceItemProvider ( AdapterFactory adapterFactory )
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

            addLocalTagPropertyDescriptor ( object );
            addComponentPropertyDescriptor ( object );
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Local Tag feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addLocalTagPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ComponentDanglingReference_localTag_feature" ), //$NON-NLS-1$
        getString ( "_UI_PropertyDescriptor_description", "_UI_ComponentDanglingReference_localTag_feature", "_UI_ComponentDanglingReference_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        ComponentPackage.Literals.COMPONENT_DANGLING_REFERENCE__LOCAL_TAG, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null ) );
    }

    /**
     * This adds a property descriptor for the Component feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addComponentPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ComponentDanglingReference_component_feature" ), //$NON-NLS-1$
        getString ( "_UI_PropertyDescriptor_description", "_UI_ComponentDanglingReference_component_feature", "_UI_ComponentDanglingReference_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        ComponentPackage.Literals.COMPONENT_DANGLING_REFERENCE__COMPONENT, true, false, true, null, null, null ) );
    }

    /**
     * This returns ComponentDanglingReference.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage ( Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/ComponentDanglingReference" ) ); //$NON-NLS-1$
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
        String label = ( (ComponentDanglingReference)object ).getName ();
        StyledString styledLabel = new StyledString ();
        if ( label == null || label.length () == 0 )
        {
            styledLabel.append ( getString ( "_UI_ComponentDanglingReference_type" ), StyledString.Style.QUALIFIER_STYLER ); //$NON-NLS-1$
        }
        else
        {
            styledLabel.append ( getString ( "_UI_ComponentDanglingReference_type" ), StyledString.Style.QUALIFIER_STYLER ).append ( " " + label ); //$NON-NLS-1$ //$NON-NLS-2$
        }
        return styledLabel;
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

        switch ( notification.getFeatureID ( ComponentDanglingReference.class ) )
        {
            case ComponentPackage.COMPONENT_DANGLING_REFERENCE__LOCAL_TAG:
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
