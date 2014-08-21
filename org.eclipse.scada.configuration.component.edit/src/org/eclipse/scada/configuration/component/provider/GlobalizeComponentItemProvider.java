/**
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 *
 */
package org.eclipse.scada.configuration.component.provider;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.DataComponent;
import org.eclipse.scada.configuration.component.GlobalizeComponent;
import org.eclipse.scada.configuration.infrastructure.MasterServer;
import org.eclipse.scada.configuration.world.WorldPackage;

/**
 * This is the item provider adapter for a
 * {@link org.eclipse.scada.configuration.component.GlobalizeComponent} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class GlobalizeComponentItemProvider
        extends DataComponentItemProvider
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public GlobalizeComponentItemProvider ( final AdapterFactory adapterFactory )
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

            addNamePropertyDescriptor ( object );
            addComponentsPropertyDescriptor ( object );
            addSourceMasterPropertyDescriptor ( object );
            addMasterOnPropertyDescriptor ( object );
        }
        return this.itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Name feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addNamePropertyDescriptor ( final Object object )
    {
        this.itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)this.adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_NamedDocumentable_name_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_NamedDocumentable_name_feature", "_UI_NamedDocumentable_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        WorldPackage.Literals.NAMED_DOCUMENTABLE__NAME,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        getString ( "_UI_namingPropertyCategory" ), //$NON-NLS-1$
                        null ) );
    }

    /**
     * This adds a property descriptor for the Components feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated NOT
     */
    protected void addComponentsPropertyDescriptor ( final Object object )
    {
        this.itemPropertyDescriptors.add
                ( new ItemPropertyDescriptor (
                        ( (ComposeableAdapterFactory)this.adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_GlobalizeComponent_components_feature" ),
                        getString ( "_UI_PropertyDescriptor_description", "_UI_GlobalizeComponent_components_feature", "_UI_GlobalizeComponent_type" ),
                        ComponentPackage.Literals.GLOBALIZE_COMPONENT__COMPONENTS,
                        true,
                        false,
                        true,
                        null,
                        getString ( "_UI_dataPropertyCategory" ),
                        null ) {

                    @Override
                    public java.util.Collection<?> getChoiceOfValues ( final Object object )
                    {
                        if ( ! ( object instanceof GlobalizeComponent ) )
                        {
                            return super.getChoiceOfValues ( object );
                        }

                        final GlobalizeComponent glob = (GlobalizeComponent)object;
                        if ( glob.getSourceMaster () == null )
                        {
                            return Collections.emptyList ();
                        }

                        final MasterServer im = glob.getSourceMaster ().getImportedMaster ();
                        if ( im == null )
                        {
                            return Collections.emptyList ();
                        }

                        // remove all components which are not on the target server

                        final Collection<?> result = super.getChoiceOfValues ( glob );
                        for ( final Iterator<?> i = result.iterator (); i.hasNext (); )
                        {
                            final Object o = i.next ();
                            if ( o instanceof DataComponent )
                            {
                                if ( ! ( (DataComponent)o ).getMasterOn ().contains ( im ) )
                                {
                                    i.remove ();
                                }
                            }
                        }
                        return result;
                    };

                } );
    }

    /**
     * This adds a property descriptor for the Source Master feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addSourceMasterPropertyDescriptor ( final Object object )
    {
        this.itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)this.adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_GlobalizeComponent_sourceMaster_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_GlobalizeComponent_sourceMaster_feature", "_UI_GlobalizeComponent_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        ComponentPackage.Literals.GLOBALIZE_COMPONENT__SOURCE_MASTER,
                        true,
                        false,
                        true,
                        null,
                        getString ( "_UI_runtimePropertyCategory" ), //$NON-NLS-1$
                        null ) );
    }

    /**
     * This adds a property descriptor for the Master On feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected void addMasterOnPropertyDescriptor ( final Object object )
    {
        this.itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)this.adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_GlobalizeComponent_masterOn_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_GlobalizeComponent_masterOn_feature", "_UI_GlobalizeComponent_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        ComponentPackage.Literals.GLOBALIZE_COMPONENT__MASTER_ON,
                        false,
                        false,
                        false,
                        null,
                        getString ( "_UI_runtimePropertyCategory" ), //$NON-NLS-1$
                        null ) );
    }

    /**
     * This returns GlobalizeComponent.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object getImage ( final Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/GlobalizeComponent" ) ); //$NON-NLS-1$
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
        final String label = ( (GlobalizeComponent)object ).getName ();
        return label == null || label.length () == 0 ?
                getString ( "_UI_GlobalizeComponent_type" ) : //$NON-NLS-1$
                getString ( "_UI_GlobalizeComponent_type" ) + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

        switch ( notification.getFeatureID ( GlobalizeComponent.class ) )
        {
            case ComponentPackage.GLOBALIZE_COMPONENT__NAME:
                fireNotifyChanged ( new ViewerNotification ( notification, notification.getNotifier (), false, true ) );
                return;
        }
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
