/**
 * Copyright (c) 2015, 2016 IBH SYSTEMS GmbH.
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
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.ComponentReferenceOutputDefinition;
import org.eclipse.scada.configuration.component.OutputDefinition;
import org.eclipse.scada.configuration.component.edit.ComponentHelper;
import org.eclipse.scada.configuration.component.edit.ComponentLabelProvider;

/**
 * This is the item provider adapter for a {@link org.eclipse.scada.configuration.component.ComponentReferenceOutputDefinition} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ComponentReferenceOutputDefinitionItemProvider extends OutputDefinitionItemProvider
{
    private final ComponentLabelProvider componentLabelProvider;

    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated NOT
     */
    public ComponentReferenceOutputDefinitionItemProvider ( final AdapterFactory adapterFactory )
    {
        super ( adapterFactory );
        this.componentLabelProvider = new ComponentLabelProvider ( adapterFactory );
    }

    /**
     * @generated NOT
     */
    @Override
    public void dispose ()
    {
        super.dispose ();
        this.componentLabelProvider.dispose ();
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
        ComponentHelper.addComponentProperty ( this.itemPropertyDescriptors, this.adapterFactory, getResourceLocator (), getString ( "_UI_ComponentReferenceOutputDefinition_component_feature" ), getString ( "_UI_PropertyDescriptor_description", "_UI_ComponentReferenceOutputDefinition_component_feature", "_UI_ComponentReferenceOutputDefinition_type" ), ComponentPackage.Literals.COMPONENT_REFERENCE_OUTPUT_DEFINITION__COMPONENT );
    }

    /**
     * This returns ComponentReferenceOutputDefinition.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage ( Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/ComponentReferenceOutputDefinition" ) ); //$NON-NLS-1$
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
     *
     * @generated NOT
     */
    @Override
    public Object getStyledText ( final Object object )
    {
        final ComponentReferenceOutputDefinition ref = (ComponentReferenceOutputDefinition)object;

        final String label = ref.getName ();
        final StyledString styledLabel = new StyledString ();
        if ( label == null || label.length () == 0 )
        {
            styledLabel.append ( getString ( "_UI_ComponentReferenceOutputDefinition_type" ), StyledString.Style.QUALIFIER_STYLER ); //$NON-NLS-1$
        }
        else
        {
            styledLabel.append ( getString ( "_UI_ComponentReferenceOutputDefinition_type" ), StyledString.Style.QUALIFIER_STYLER ).append ( " " + label ); //$NON-NLS-1$ //$NON-NLS-2$
        }

        if ( ref.getComponent () != null )
        {
            final String componentLabel = this.componentLabelProvider.getText ( ref.getComponent () );
            if ( componentLabel != null && !componentLabel.isEmpty () )
            {
                styledLabel.append ( " " + componentLabel, StyledString.Style.DECORATIONS_STYLER );
            }
        }

        return styledLabel;
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to
     * update any cached
     * children and by creating a viewer notification, which it passes to
     * {@link #fireNotifyChanged}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public void notifyChanged ( final Notification notification )
    {
        updateChildren ( notification );
        switch ( notification.getFeatureID ( OutputDefinition.class ) )
        {
            case ComponentPackage.COMPONENT_REFERENCE_OUTPUT_DEFINITION__COMPONENT:
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
