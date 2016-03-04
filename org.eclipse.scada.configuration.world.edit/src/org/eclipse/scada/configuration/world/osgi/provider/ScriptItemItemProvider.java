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
package org.eclipse.scada.configuration.world.osgi.provider;

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
import org.eclipse.scada.configuration.world.WorldFactory;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.configuration.world.osgi.ScriptItem;

/**
 * This is the item provider adapter for a {@link org.eclipse.scada.configuration.world.osgi.ScriptItem} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ScriptItemItemProvider extends ItemItemProvider
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ScriptItemItemProvider ( AdapterFactory adapterFactory )
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

            addInitScriptPropertyDescriptor ( object );
            addUpdateScriptPropertyDescriptor ( object );
            addScriptEnginePropertyDescriptor ( object );
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Init Script feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addInitScriptPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ScriptItem_initScript_feature" ), //$NON-NLS-1$
        getString ( "_UI_PropertyDescriptor_description", "_UI_ScriptItem_initScript_feature", "_UI_ScriptItem_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        OsgiPackage.Literals.SCRIPT_ITEM__INIT_SCRIPT, true, false, false, null, null, null ) );
    }

    /**
     * This adds a property descriptor for the Update Script feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addUpdateScriptPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ScriptItem_updateScript_feature" ), //$NON-NLS-1$
        getString ( "_UI_PropertyDescriptor_description", "_UI_ScriptItem_updateScript_feature", "_UI_ScriptItem_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        OsgiPackage.Literals.SCRIPT_ITEM__UPDATE_SCRIPT, true, false, false, null, null, null ) );
    }

    /**
     * This adds a property descriptor for the Script Engine feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addScriptEnginePropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ScriptItem_scriptEngine_feature" ), //$NON-NLS-1$
        getString ( "_UI_PropertyDescriptor_description", "_UI_ScriptItem_scriptEngine_feature", "_UI_ScriptItem_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        OsgiPackage.Literals.SCRIPT_ITEM__SCRIPT_ENGINE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null ) );
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
            childrenFeatures.add ( OsgiPackage.Literals.SCRIPT_ITEM__INPUTS );
            childrenFeatures.add ( OsgiPackage.Literals.SCRIPT_ITEM__TIMER );
            childrenFeatures.add ( OsgiPackage.Literals.SCRIPT_ITEM__COMMANDS );
            childrenFeatures.add ( OsgiPackage.Literals.SCRIPT_ITEM__WRITE_COMMAND_SCRIPT );
            childrenFeatures.add ( OsgiPackage.Literals.SCRIPT_ITEM__INIT_PROPERTIES );
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
     * This returns ScriptItem.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage ( Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/ScriptItem" ) ); //$NON-NLS-1$
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
        String label = ( (ScriptItem)object ).getName ();
        StyledString styledLabel = new StyledString ();
        if ( label == null || label.length () == 0 )
        {
            styledLabel.append ( getString ( "_UI_ScriptItem_type" ), StyledString.Style.QUALIFIER_STYLER ); //$NON-NLS-1$
        }
        else
        {
            styledLabel.append ( getString ( "_UI_ScriptItem_type" ), StyledString.Style.QUALIFIER_STYLER ).append ( " " + label ); //$NON-NLS-1$ //$NON-NLS-2$
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

        switch ( notification.getFeatureID ( ScriptItem.class ) )
        {
            case OsgiPackage.SCRIPT_ITEM__INIT_SCRIPT:
            case OsgiPackage.SCRIPT_ITEM__UPDATE_SCRIPT:
            case OsgiPackage.SCRIPT_ITEM__SCRIPT_ENGINE:
                fireNotifyChanged ( new ViewerNotification ( notification, notification.getNotifier (), false, true ) );
                return;
            case OsgiPackage.SCRIPT_ITEM__INPUTS:
            case OsgiPackage.SCRIPT_ITEM__TIMER:
            case OsgiPackage.SCRIPT_ITEM__COMMANDS:
            case OsgiPackage.SCRIPT_ITEM__WRITE_COMMAND_SCRIPT:
            case OsgiPackage.SCRIPT_ITEM__INIT_PROPERTIES:
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

        newChildDescriptors.add ( createChildParameter ( OsgiPackage.Literals.SCRIPT_ITEM__INPUTS, OsgiFactory.eINSTANCE.createItemReference () ) );

        newChildDescriptors.add ( createChildParameter ( OsgiPackage.Literals.SCRIPT_ITEM__INPUTS, OsgiFactory.eINSTANCE.createTypedItemReference () ) );

        newChildDescriptors.add ( createChildParameter ( OsgiPackage.Literals.SCRIPT_ITEM__TIMER, OsgiFactory.eINSTANCE.createScriptTimer () ) );

        newChildDescriptors.add ( createChildParameter ( OsgiPackage.Literals.SCRIPT_ITEM__COMMANDS, OsgiFactory.eINSTANCE.createItemReference () ) );

        newChildDescriptors.add ( createChildParameter ( OsgiPackage.Literals.SCRIPT_ITEM__COMMANDS, OsgiFactory.eINSTANCE.createTypedItemReference () ) );

        newChildDescriptors.add ( createChildParameter ( OsgiPackage.Literals.SCRIPT_ITEM__WRITE_COMMAND_SCRIPT, OsgiFactory.eINSTANCE.createCodeFragment () ) );

        newChildDescriptors.add ( createChildParameter ( OsgiPackage.Literals.SCRIPT_ITEM__INIT_PROPERTIES, WorldFactory.eINSTANCE.createPropertyEntry () ) );
    }

    /**
     * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getCreateChildText ( Object owner, Object feature, Object child, Collection<?> selection )
    {
        Object childFeature = feature;
        Object childObject = child;

        boolean qualify = childFeature == OsgiPackage.Literals.SCRIPT_ITEM__INPUTS || childFeature == OsgiPackage.Literals.SCRIPT_ITEM__COMMANDS;

        if ( qualify )
        {
            return getString ( "_UI_CreateChild_text2", //$NON-NLS-1$
            new Object[] { getTypeText ( childObject ), getFeatureText ( childFeature ), getTypeText ( owner ) } );
        }
        return super.getCreateChildText ( owner, feature, child, selection );
    }

}
