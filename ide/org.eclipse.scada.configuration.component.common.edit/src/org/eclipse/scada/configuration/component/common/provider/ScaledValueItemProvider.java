/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 *
 */
package org.eclipse.scada.configuration.component.common.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.scada.configuration.component.ComponentFactory;
import org.eclipse.scada.configuration.component.common.CommonPackage;
import org.eclipse.scada.configuration.component.common.ScaledValue;
import org.eclipse.scada.configuration.component.provider.SingleValueItemProvider;
import org.eclipse.scada.configuration.ecore.ui.ItemPropertyDescriptor2;

/**
 * This is the item provider adapter for a {@link org.eclipse.scada.configuration.component.common.ScaledValue} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ScaledValueItemProvider extends SingleValueItemProvider
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ScaledValueItemProvider ( AdapterFactory adapterFactory )
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

            addInputMinimumPropertyDescriptor ( object );
            addInputMaximumPropertyDescriptor ( object );
            addOutputMinimumPropertyDescriptor ( object );
            addOutputMaximumPropertyDescriptor ( object );
            addValidateRangePropertyDescriptor ( object );
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Input Minimum feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated NOT
     */
    protected void addInputMinimumPropertyDescriptor ( final Object object )
    {
        this.itemPropertyDescriptors.add ( new ItemPropertyDescriptor2 ( ( (ComposeableAdapterFactory)this.adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ScaledValue_inputMinimum_feature" ), getString ( "_UI_PropertyDescriptor_description", "_UI_ScaledValue_inputMinimum_feature", "_UI_ScaledValue_type" ), CommonPackage.Literals.SCALED_VALUE__INPUT_MINIMUM, true, false, false, ItemPropertyDescriptor.REAL_VALUE_IMAGE, getString ( "_UI_rangePropertyCategory" ), null) {
            @Override
            public int getSortKey ( )
            {
                return 100;
            }
        } );
    }

    /**
     * This adds a property descriptor for the Input Maximum feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated NOT
     */
    protected void addInputMaximumPropertyDescriptor ( final Object object )
    {
        this.itemPropertyDescriptors.add ( new ItemPropertyDescriptor2 ( ( (ComposeableAdapterFactory)this.adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ScaledValue_inputMaximum_feature" ), getString ( "_UI_PropertyDescriptor_description", "_UI_ScaledValue_inputMaximum_feature", "_UI_ScaledValue_type" ), CommonPackage.Literals.SCALED_VALUE__INPUT_MAXIMUM, true, false, false, ItemPropertyDescriptor.REAL_VALUE_IMAGE, getString ( "_UI_rangePropertyCategory" ), null) {
            @Override
            public int getSortKey ( )
            {
                return 200;
            }
        } );
    }

    /**
     * This adds a property descriptor for the Output Minimum feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated NOT
     */
    protected void addOutputMinimumPropertyDescriptor ( final Object object )
    {
        this.itemPropertyDescriptors.add ( new ItemPropertyDescriptor2 ( ( (ComposeableAdapterFactory)this.adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ScaledValue_outputMinimum_feature" ), getString ( "_UI_PropertyDescriptor_description", "_UI_ScaledValue_outputMinimum_feature", "_UI_ScaledValue_type" ), CommonPackage.Literals.SCALED_VALUE__OUTPUT_MINIMUM, true, false, false, ItemPropertyDescriptor.REAL_VALUE_IMAGE, getString ( "_UI_rangePropertyCategory" ), null) {
            @Override
            public int getSortKey ( )
            {
                return 300;
            }
        } );
    }

    /**
     * This adds a property descriptor for the Output Maximum feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated NOT
     */
    protected void addOutputMaximumPropertyDescriptor ( final Object object )
    {
        this.itemPropertyDescriptors.add ( new ItemPropertyDescriptor2 ( ( (ComposeableAdapterFactory)this.adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ScaledValue_outputMaximum_feature" ), getString ( "_UI_PropertyDescriptor_description", "_UI_ScaledValue_outputMaximum_feature", "_UI_ScaledValue_type" ), CommonPackage.Literals.SCALED_VALUE__OUTPUT_MAXIMUM, true, false, false, ItemPropertyDescriptor.REAL_VALUE_IMAGE, getString ( "_UI_rangePropertyCategory" ), null) {
            @Override
            public int getSortKey ( )
            {
                return 400;
            }
        } );
    }

    /**
     * This adds a property descriptor for the Validate Range feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated NOT
     */
    protected void addValidateRangePropertyDescriptor ( final Object object )
    {
        this.itemPropertyDescriptors.add ( new ItemPropertyDescriptor2 ( ( (ComposeableAdapterFactory)this.adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ScaledValue_validateRange_feature" ), getString ( "_UI_ScaledValue_validateRange_description" ), CommonPackage.Literals.SCALED_VALUE__VALIDATE_RANGE, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, getString ( "_UI_rangePropertyCategory" ), null) {
            @Override
            public int getSortKey ( )
            {
                return 500;
            }
        } );
    }

    /**
     * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
     * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
     * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Collection<? extends EStructuralFeature> getChildrenFeatures ( Object object )
    {
        if ( childrenFeatures == null )
        {
            super.getChildrenFeatures ( object );
            childrenFeatures.add ( CommonPackage.Literals.SCALED_VALUE__SOURCE_ITEM );
        }
        return childrenFeatures;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EStructuralFeature getChildFeature ( Object object, Object child )
    {
        // Check the type of the specified child object and return the proper feature to use for
        // adding (see {@link AddCommand}) it as a child.

        return super.getChildFeature ( object, child );
    }

    /**
     * This returns ScaledValue.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public Object getImage ( final Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/function.png" ) ); //$NON-NLS-1$
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
        String label = ( (ScaledValue)object ).getName ();
        StyledString styledLabel = new StyledString ();
        if ( label == null || label.length () == 0 )
        {
            styledLabel.append ( getString ( "_UI_ScaledValue_type" ), StyledString.Style.QUALIFIER_STYLER ); //$NON-NLS-1$
        }
        else
        {
            styledLabel.append ( getString ( "_UI_ScaledValue_type" ), StyledString.Style.QUALIFIER_STYLER ).append ( " " + label ); //$NON-NLS-1$ //$NON-NLS-2$
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

        switch ( notification.getFeatureID ( ScaledValue.class ) )
        {
            case CommonPackage.SCALED_VALUE__INPUT_MINIMUM:
            case CommonPackage.SCALED_VALUE__INPUT_MAXIMUM:
            case CommonPackage.SCALED_VALUE__OUTPUT_MINIMUM:
            case CommonPackage.SCALED_VALUE__OUTPUT_MAXIMUM:
            case CommonPackage.SCALED_VALUE__VALIDATE_RANGE:
                fireNotifyChanged ( new ViewerNotification ( notification, notification.getNotifier (), false, true ) );
                return;
            case CommonPackage.SCALED_VALUE__SOURCE_ITEM:
                fireNotifyChanged ( new ViewerNotification ( notification, notification.getNotifier (), true, false ) );
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

        newChildDescriptors.add ( createChildParameter ( CommonPackage.Literals.SCALED_VALUE__SOURCE_ITEM, ComponentFactory.eINSTANCE.createItemReferenceInputDefinition () ) );

        newChildDescriptors.add ( createChildParameter ( CommonPackage.Literals.SCALED_VALUE__SOURCE_ITEM, ComponentFactory.eINSTANCE.createComponentReferenceInputDefinition () ) );
    }

}
