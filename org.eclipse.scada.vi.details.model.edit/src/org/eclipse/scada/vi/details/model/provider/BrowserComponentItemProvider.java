/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 */
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
import org.eclipse.scada.vi.details.model.BrowserComponent;
import org.eclipse.scada.vi.details.model.DetailViewPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.scada.vi.details.model.BrowserComponent} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class BrowserComponentItemProvider extends ComponentItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BrowserComponentItemProvider ( AdapterFactory adapterFactory )
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

            addUrlPropertyDescriptor ( object );
            addWidthPropertyDescriptor ( object );
            addHeightPropertyDescriptor ( object );
            addReloadTimerPropertyDescriptor ( object );
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Url feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addUrlPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_BrowserComponent_url_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_BrowserComponent_url_feature", "_UI_BrowserComponent_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        DetailViewPackage.Literals.BROWSER_COMPONENT__URL,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null ) );
    }

    /**
     * This adds a property descriptor for the Width feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addWidthPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_BrowserComponent_width_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_BrowserComponent_width_feature", "_UI_BrowserComponent_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        DetailViewPackage.Literals.BROWSER_COMPONENT__WIDTH,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null ) );
    }

    /**
     * This adds a property descriptor for the Height feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addHeightPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_BrowserComponent_height_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_BrowserComponent_height_feature", "_UI_BrowserComponent_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        DetailViewPackage.Literals.BROWSER_COMPONENT__HEIGHT,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null ) );
    }

    /**
     * This adds a property descriptor for the Reload Timer feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addReloadTimerPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_BrowserComponent_reloadTimer_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_BrowserComponent_reloadTimer_feature", "_UI_BrowserComponent_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        DetailViewPackage.Literals.BROWSER_COMPONENT__RELOAD_TIMER,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null ) );
    }

    /**
     * This returns BrowserComponent.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage ( Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/BrowserComponent" ) ); //$NON-NLS-1$
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
        String label = ( (BrowserComponent)object ).getUrl ();
        return label == null || label.length () == 0 ?
                getString ( "_UI_BrowserComponent_type" ) : //$NON-NLS-1$
                getString ( "_UI_BrowserComponent_type" ) + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

        switch ( notification.getFeatureID ( BrowserComponent.class ) )
        {
            case DetailViewPackage.BROWSER_COMPONENT__URL:
            case DetailViewPackage.BROWSER_COMPONENT__WIDTH:
            case DetailViewPackage.BROWSER_COMPONENT__HEIGHT:
            case DetailViewPackage.BROWSER_COMPONENT__RELOAD_TIMER:
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
