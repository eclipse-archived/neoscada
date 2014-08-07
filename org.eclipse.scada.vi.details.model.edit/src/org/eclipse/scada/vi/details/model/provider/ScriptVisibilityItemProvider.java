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
import org.eclipse.scada.vi.details.model.ScriptVisibility;

/**
 * This is the item provider adapter for a {@link org.eclipse.scada.vi.details.model.ScriptVisibility} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ScriptVisibilityItemProvider extends VisibilityItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ScriptVisibilityItemProvider ( AdapterFactory adapterFactory )
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

            addScriptPropertyDescriptor ( object );
            addScriptLanguagePropertyDescriptor ( object );
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Script feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addScriptPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_ScriptVisibility_script_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_ScriptVisibility_script_feature", "_UI_ScriptVisibility_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        DetailViewPackage.Literals.SCRIPT_VISIBILITY__SCRIPT,
                        true,
                        true,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null ) );
    }

    /**
     * This adds a property descriptor for the Script Language feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addScriptLanguagePropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_ScriptVisibility_scriptLanguage_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_ScriptVisibility_scriptLanguage_feature", "_UI_ScriptVisibility_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        DetailViewPackage.Literals.SCRIPT_VISIBILITY__SCRIPT_LANGUAGE,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null ) );
    }

    /**
     * This returns ScriptVisibility.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage ( Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/ScriptVisibility" ) ); //$NON-NLS-1$
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
        String label = crop ( ( (ScriptVisibility)object ).getScript () );
        return label == null || label.length () == 0 ?
                getString ( "_UI_ScriptVisibility_type" ) : //$NON-NLS-1$
                getString ( "_UI_ScriptVisibility_type" ) + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

        switch ( notification.getFeatureID ( ScriptVisibility.class ) )
        {
            case DetailViewPackage.SCRIPT_VISIBILITY__SCRIPT:
            case DetailViewPackage.SCRIPT_VISIBILITY__SCRIPT_LANGUAGE:
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
