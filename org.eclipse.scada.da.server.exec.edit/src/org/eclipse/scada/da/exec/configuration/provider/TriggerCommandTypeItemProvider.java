/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.exec.configuration.provider;

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
import org.eclipse.scada.da.exec.configuration.ConfigurationPackage;
import org.eclipse.scada.da.exec.configuration.TriggerCommandType;

/**
 * This is the item provider adapter for a {@link org.eclipse.scada.da.exec.configuration.TriggerCommandType} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TriggerCommandTypeItemProvider extends CommandTypeItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
    //$NON-NLS-1$

    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TriggerCommandTypeItemProvider ( AdapterFactory adapterFactory )
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

            addArgumentPlaceholderPropertyDescriptor ( object );
            addForkPropertyDescriptor ( object );
            addSkipIfNullPropertyDescriptor ( object );
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Argument Placeholder feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addArgumentPlaceholderPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_TriggerCommandType_argumentPlaceholder_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_TriggerCommandType_argumentPlaceholder_feature", "_UI_TriggerCommandType_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                ConfigurationPackage.Literals.TRIGGER_COMMAND_TYPE__ARGUMENT_PLACEHOLDER, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null ) );
    }

    /**
     * This adds a property descriptor for the Fork feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addForkPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_TriggerCommandType_fork_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_TriggerCommandType_fork_feature", "_UI_TriggerCommandType_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                ConfigurationPackage.Literals.TRIGGER_COMMAND_TYPE__FORK, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null ) );
    }

    /**
     * This adds a property descriptor for the Skip If Null feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addSkipIfNullPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_TriggerCommandType_skipIfNull_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_TriggerCommandType_skipIfNull_feature", "_UI_TriggerCommandType_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                ConfigurationPackage.Literals.TRIGGER_COMMAND_TYPE__SKIP_IF_NULL, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null ) );
    }

    /**
     * This returns TriggerCommandType.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage ( Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/TriggerCommandType" ) ); //$NON-NLS-1$
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
        String label = ( (TriggerCommandType)object ).getId ();
        return label == null || label.length () == 0 ? getString ( "_UI_TriggerCommandType_type" ) : //$NON-NLS-1$
        getString ( "_UI_TriggerCommandType_type" ) + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

        switch ( notification.getFeatureID ( TriggerCommandType.class ) )
        {
            case ConfigurationPackage.TRIGGER_COMMAND_TYPE__ARGUMENT_PLACEHOLDER:
            case ConfigurationPackage.TRIGGER_COMMAND_TYPE__FORK:
            case ConfigurationPackage.TRIGGER_COMMAND_TYPE__SKIP_IF_NULL:
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
