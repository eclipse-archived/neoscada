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
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.scada.configuration.component.common.CommonPackage;
import org.eclipse.scada.configuration.component.common.CurrentTimeComponent;
import org.eclipse.scada.configuration.component.common.DateFormat;
import org.eclipse.scada.configuration.component.provider.MasterComponentItemProvider;

/**
 * This is the item provider adapter for a {@link org.eclipse.scada.configuration.component.common.CurrentTimeComponent} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CurrentTimeComponentItemProvider extends MasterComponentItemProvider
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CurrentTimeComponentItemProvider ( AdapterFactory adapterFactory )
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

            addNamePropertyDescriptor ( object );
            addUpdatePeriodPropertyDescriptor ( object );
            addDateFormatPropertyDescriptor ( object );
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Name feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addNamePropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_CurrentTimeComponent_name_feature" ), //$NON-NLS-1$
        getString ( "_UI_PropertyDescriptor_description", "_UI_CurrentTimeComponent_name_feature", "_UI_CurrentTimeComponent_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        CommonPackage.Literals.CURRENT_TIME_COMPONENT__NAME, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString ( "_UI_customizationPropertyCategory" ), //$NON-NLS-1$
        null ) );
    }

    /**
     * This adds a property descriptor for the Update Period feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addUpdatePeriodPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_CurrentTimeComponent_updatePeriod_feature" ), //$NON-NLS-1$
        getString ( "_UI_PropertyDescriptor_description", "_UI_CurrentTimeComponent_updatePeriod_feature", "_UI_CurrentTimeComponent_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        CommonPackage.Literals.CURRENT_TIME_COMPONENT__UPDATE_PERIOD, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, getString ( "_UI_configurationPropertyCategory" ), //$NON-NLS-1$
        null ) );
    }

    /**
     * This adds a property descriptor for the Date Format feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addDateFormatPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_CurrentTimeComponent_dateFormat_feature" ), //$NON-NLS-1$
        getString ( "_UI_CurrentTimeComponent_dateFormat_description" ), //$NON-NLS-1$
        CommonPackage.Literals.CURRENT_TIME_COMPONENT__DATE_FORMAT, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString ( "_UI_configurationPropertyCategory" ), //$NON-NLS-1$
        null ) );
    }

    /**
     * This returns CurrentTimeComponent.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public Object getImage ( final Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/clock.png" ) ); //$NON-NLS-1$
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
        final DateFormat label = ( (CurrentTimeComponent)object ).getDateFormat ();
        final StyledString styledLabel = new StyledString ();
        if ( label == null )
        {
            styledLabel.append ( getString ( "_UI_CurrentTimeComponent_type" ), StyledString.Style.QUALIFIER_STYLER ); //$NON-NLS-1$
        }
        else
        {
            styledLabel.append ( getString ( "_UI_CurrentTimeComponent_type" ), StyledString.Style.QUALIFIER_STYLER ).append ( " " + label ); //$NON-NLS-1$ //$NON-NLS-2$
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

        switch ( notification.getFeatureID ( CurrentTimeComponent.class ) )
        {
            case CommonPackage.CURRENT_TIME_COMPONENT__NAME:
            case CommonPackage.CURRENT_TIME_COMPONENT__UPDATE_PERIOD:
            case CommonPackage.CURRENT_TIME_COMPONENT__DATE_FORMAT:
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
