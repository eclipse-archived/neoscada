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
import java.util.HashSet;
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
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.ComponentReferenceInputDefinition;
import org.eclipse.scada.configuration.component.DataComponent;

/**
 * This is the item provider adapter for a {@link org.eclipse.scada.configuration.component.ComponentReferenceInputDefinition} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ComponentReferenceInputDefinitionItemProvider extends InputDefinitionItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComponentReferenceInputDefinitionItemProvider ( AdapterFactory adapterFactory )
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

            addComponentPropertyDescriptor ( object );
            addLocalTagPropertyDescriptor ( object );
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Component feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    protected void addComponentPropertyDescriptor ( final Object object )
    {
        this.itemPropertyDescriptors.add
                ( new ItemPropertyDescriptor (
                        ( (ComposeableAdapterFactory)this.adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_ComponentReferenceInputDefinition_component_feature" ),
                        getString ( "_UI_PropertyDescriptor_description", "_UI_ComponentReferenceInputDefinition_component_feature", "_UI_ComponentReferenceInputDefinition_type" ),
                        ComponentPackage.Literals.COMPONENT_REFERENCE_INPUT_DEFINITION__COMPONENT,
                        true,
                        false,
                        true,
                        null,
                        null,
                        null ) {
                    @Override
                    public Collection<?> getChoiceOfValues ( final Object object )
                    {
                        final ComponentReferenceInputDefinition ref = (ComponentReferenceInputDefinition)object;
                        if ( ! ( ref.eContainer () instanceof DataComponent ) )
                        {
                            return super.getChoiceOfValues ( object );
                        }

                        final Collection<Object> result = new HashSet<> ();
                        final DataComponent container = (DataComponent)ref.eContainer ();
                        for ( final Object o : super.getChoiceOfValues ( object ) )
                        {
                            if ( o == container )
                            {
                                // remove self
                                continue;
                            }

                            if ( ! ( o instanceof DataComponent ) )
                            {
                                result.add ( o );
                                continue;
                            }
                            final DataComponent dc = (DataComponent)o;
                            if ( dc.getMasterOn ().containsAll ( container.getMasterOn () ) )
                            {
                                result.add ( dc );
                            }
                        }
                        return result;
                    }
                } );
    }

    /**
     * This adds a property descriptor for the Local Tag feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addLocalTagPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_ComponentReferenceInputDefinition_localTag_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_ComponentReferenceInputDefinition_localTag_feature", "_UI_ComponentReferenceInputDefinition_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        ComponentPackage.Literals.COMPONENT_REFERENCE_INPUT_DEFINITION__LOCAL_TAG,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null ) );
    }

    /**
     * This returns ComponentReferenceInputDefinition.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage ( Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/ComponentReferenceInputDefinition" ) ); //$NON-NLS-1$
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
        String label = ( (ComponentReferenceInputDefinition)object ).getName ();
        return label == null || label.length () == 0 ?
                getString ( "_UI_ComponentReferenceInputDefinition_type" ) : //$NON-NLS-1$
                getString ( "_UI_ComponentReferenceInputDefinition_type" ) + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

        switch ( notification.getFeatureID ( ComponentReferenceInputDefinition.class ) )
        {
            case ComponentPackage.COMPONENT_REFERENCE_INPUT_DEFINITION__LOCAL_TAG:
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
