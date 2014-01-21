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
package org.eclipse.scada.configuration.component.provider;

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
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.DriverConnectionAnalyzer;

/**
 * This is the item provider adapter for a
 * {@link org.eclipse.scada.configuration.component.DriverConnectionAnalyzer}
 * object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class DriverConnectionAnalyzerItemProvider extends MasterComponentItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public DriverConnectionAnalyzerItemProvider ( final AdapterFactory adapterFactory )
    {
        super ( adapterFactory );
    }

    /**
     * This returns the property descriptors for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors ( final Object object )
    {
        if ( this.itemPropertyDescriptors == null )
        {
            super.getPropertyDescriptors ( object );

            addDriverPropertyDescriptor ( object );
        }
        return this.itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Driver feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addDriverPropertyDescriptor ( final Object object )
    {
        this.itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)this.adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_DriverConnectionAnalyzer_driver_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_DriverConnectionAnalyzer_driver_feature", "_UI_DriverConnectionAnalyzer_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        ComponentPackage.Literals.DRIVER_CONNECTION_ANALYZER__DRIVER,
                        true,
                        false,
                        true,
                        null,
                        null,
                        null ) );
    }

    /**
     * This returns DriverConnectionAnalyzer.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object getImage ( final Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/DriverConnectionAnalyzer" ) ); //$NON-NLS-1$
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getText ( final Object object )
    {
        final String label = ( (DriverConnectionAnalyzer)object ).getShortDescription ();
        return label == null || label.length () == 0 ?
                getString ( "_UI_DriverConnectionAnalyzer_type" ) : //$NON-NLS-1$
                getString ( "_UI_DriverConnectionAnalyzer_type" ) + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to
     * update any cached
     * children and by creating a viewer notification, which it passes to
     * {@link #fireNotifyChanged}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void notifyChanged ( final Notification notification )
    {
        updateChildren ( notification );
        super.notifyChanged ( notification );
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
     * describing the children
     * that can be created under this object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected void collectNewChildDescriptors ( final Collection<Object> newChildDescriptors, final Object object )
    {
        super.collectNewChildDescriptors ( newChildDescriptors, object );
    }

}
