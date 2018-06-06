/*******************************************************************************
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.model.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.scada.vi.model.Symbol;
import org.eclipse.scada.vi.model.VisualInterfaceFactory;
import org.eclipse.scada.vi.model.VisualInterfacePackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.scada.vi.model.Symbol} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SymbolItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SymbolItemProvider ( AdapterFactory adapterFactory )
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

            addOnInitPropertyDescriptor ( object );
            addOnDisposePropertyDescriptor ( object );
            addOnUpdatePropertyDescriptor ( object );
            addScriptModulesPropertyDescriptor ( object );
            addBackgroundColorPropertyDescriptor ( object );
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the On Init feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addOnInitPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_Symbol_onInit_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_Symbol_onInit_feature", "_UI_Symbol_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                VisualInterfacePackage.Literals.SYMBOL__ON_INIT, true, true, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null ) );
    }

    /**
     * This adds a property descriptor for the On Dispose feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addOnDisposePropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_Symbol_onDispose_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_Symbol_onDispose_feature", "_UI_Symbol_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                VisualInterfacePackage.Literals.SYMBOL__ON_DISPOSE, true, true, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null ) );
    }

    /**
     * This adds a property descriptor for the On Update feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addOnUpdatePropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_Symbol_onUpdate_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_Symbol_onUpdate_feature", "_UI_Symbol_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                VisualInterfacePackage.Literals.SYMBOL__ON_UPDATE, true, true, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null ) );
    }

    /**
     * This adds a property descriptor for the Script Modules feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addScriptModulesPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_Symbol_scriptModules_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_Symbol_scriptModules_feature", "_UI_Symbol_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                VisualInterfacePackage.Literals.SYMBOL__SCRIPT_MODULES, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null ) );
    }

    /**
     * This adds a property descriptor for the Background Color feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addBackgroundColorPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_Symbol_backgroundColor_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_Symbol_backgroundColor_feature", "_UI_Symbol_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                VisualInterfacePackage.Literals.SYMBOL__BACKGROUND_COLOR, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null ) );
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
            childrenFeatures.add ( VisualInterfacePackage.Literals.SYMBOL__ROOT );
            childrenFeatures.add ( VisualInterfacePackage.Literals.SYMBOL__PROPERTIES );
            childrenFeatures.add ( VisualInterfacePackage.Literals.SYMBOL__SCRIPT_MODULES );
            childrenFeatures.add ( VisualInterfacePackage.Literals.SYMBOL__CURSORS );
            childrenFeatures.add ( VisualInterfacePackage.Literals.SYMBOL__DESIGN_SIZE );
            childrenFeatures.add ( VisualInterfacePackage.Literals.SYMBOL__CONNECTIONS );
            childrenFeatures.add ( VisualInterfacePackage.Literals.SYMBOL__TIME_TRIGGERS );
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
     * This returns Symbol.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage ( Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/Symbol" ) ); //$NON-NLS-1$
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
        String label = crop ( ( (Symbol)object ).getOnInit () );
        return label == null || label.length () == 0 ? getString ( "_UI_Symbol_type" ) : //$NON-NLS-1$
                getString ( "_UI_Symbol_type" ) + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

        switch ( notification.getFeatureID ( Symbol.class ) )
        {
            case VisualInterfacePackage.SYMBOL__ON_INIT:
            case VisualInterfacePackage.SYMBOL__ON_DISPOSE:
            case VisualInterfacePackage.SYMBOL__ON_UPDATE:
            case VisualInterfacePackage.SYMBOL__BACKGROUND_COLOR:
            case VisualInterfacePackage.SYMBOL__BACKGROUND_IMAGE:
                fireNotifyChanged ( new ViewerNotification ( notification, notification.getNotifier (), false, true ) );
                return;
            case VisualInterfacePackage.SYMBOL__ROOT:
            case VisualInterfacePackage.SYMBOL__PROPERTIES:
            case VisualInterfacePackage.SYMBOL__SCRIPT_MODULES:
            case VisualInterfacePackage.SYMBOL__CURSORS:
            case VisualInterfacePackage.SYMBOL__DESIGN_SIZE:
            case VisualInterfacePackage.SYMBOL__CONNECTIONS:
            case VisualInterfacePackage.SYMBOL__TIME_TRIGGERS:
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

        newChildDescriptors.add ( createChildParameter ( VisualInterfacePackage.Literals.SYMBOL__ROOT, VisualInterfaceFactory.eINSTANCE.createRectangle () ) );

        newChildDescriptors.add ( createChildParameter ( VisualInterfacePackage.Literals.SYMBOL__ROOT, VisualInterfaceFactory.eINSTANCE.createText () ) );

        newChildDescriptors.add ( createChildParameter ( VisualInterfacePackage.Literals.SYMBOL__ROOT, VisualInterfaceFactory.eINSTANCE.createXYContainer () ) );

        newChildDescriptors.add ( createChildParameter ( VisualInterfacePackage.Literals.SYMBOL__ROOT, VisualInterfaceFactory.eINSTANCE.createLine () ) );

        newChildDescriptors.add ( createChildParameter ( VisualInterfacePackage.Literals.SYMBOL__ROOT, VisualInterfaceFactory.eINSTANCE.createSymbolReference () ) );

        newChildDescriptors.add ( createChildParameter ( VisualInterfacePackage.Literals.SYMBOL__ROOT, VisualInterfaceFactory.eINSTANCE.createGridContainer () ) );

        newChildDescriptors.add ( createChildParameter ( VisualInterfacePackage.Literals.SYMBOL__ROOT, VisualInterfaceFactory.eINSTANCE.createBorderContainer () ) );

        newChildDescriptors.add ( createChildParameter ( VisualInterfacePackage.Literals.SYMBOL__ROOT, VisualInterfaceFactory.eINSTANCE.createFigureContainer () ) );

        newChildDescriptors.add ( createChildParameter ( VisualInterfacePackage.Literals.SYMBOL__ROOT, VisualInterfaceFactory.eINSTANCE.createImage () ) );

        newChildDescriptors.add ( createChildParameter ( VisualInterfacePackage.Literals.SYMBOL__ROOT, VisualInterfaceFactory.eINSTANCE.createEllipse () ) );

        newChildDescriptors.add ( createChildParameter ( VisualInterfacePackage.Literals.SYMBOL__ROOT, VisualInterfaceFactory.eINSTANCE.createArc () ) );

        newChildDescriptors.add ( createChildParameter ( VisualInterfacePackage.Literals.SYMBOL__ROOT, VisualInterfaceFactory.eINSTANCE.createStackContainer () ) );

        newChildDescriptors.add ( createChildParameter ( VisualInterfacePackage.Literals.SYMBOL__ROOT, VisualInterfaceFactory.eINSTANCE.createPolygon () ) );

        newChildDescriptors.add ( createChildParameter ( VisualInterfacePackage.Literals.SYMBOL__ROOT, VisualInterfaceFactory.eINSTANCE.createRoundedRectangle () ) );

        newChildDescriptors.add ( createChildParameter ( VisualInterfacePackage.Literals.SYMBOL__PROPERTIES, VisualInterfaceFactory.eINSTANCE.create ( VisualInterfacePackage.Literals.STRING_TO_STRING_MAP ) ) );

        newChildDescriptors.add ( createChildParameter ( VisualInterfacePackage.Literals.SYMBOL__SCRIPT_MODULES, "" ) ); //$NON-NLS-1$

        newChildDescriptors.add ( createChildParameter ( VisualInterfacePackage.Literals.SYMBOL__CURSORS, VisualInterfaceFactory.eINSTANCE.createSystemCursor () ) );

        newChildDescriptors.add ( createChildParameter ( VisualInterfacePackage.Literals.SYMBOL__DESIGN_SIZE, VisualInterfaceFactory.eINSTANCE.createDimension () ) );

        newChildDescriptors.add ( createChildParameter ( VisualInterfacePackage.Literals.SYMBOL__CONNECTIONS, VisualInterfaceFactory.eINSTANCE.createConnection () ) );

        newChildDescriptors.add ( createChildParameter ( VisualInterfacePackage.Literals.SYMBOL__TIME_TRIGGERS, VisualInterfaceFactory.eINSTANCE.createTimeTrigger () ) );
    }

    /**
     * Return the resource locator for this item provider's resources.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator ()
    {
        return ( (IChildCreationExtender)adapterFactory ).getResourceLocator ();
    }

}
