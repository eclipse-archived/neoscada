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
import org.eclipse.scada.vi.model.Figure;
import org.eclipse.scada.vi.model.VisualInterfaceFactory;
import org.eclipse.scada.vi.model.VisualInterfacePackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.scada.vi.model.Figure} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FigureItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FigureItemProvider ( AdapterFactory adapterFactory )
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
            addForegroundColorPropertyDescriptor ( object );
            addBackgroundColorPropertyDescriptor ( object );
            addOnClickPropertyDescriptor ( object );
            addOnDoubleClickPropertyDescriptor ( object );
            addCursorPropertyDescriptor ( object );
            addVisiblePropertyDescriptor ( object );
            addBorderPropertyDescriptor ( object );
            addOpaquePropertyDescriptor ( object );
            addToolTipPropertyDescriptor ( object );
            addOnMouseInPropertyDescriptor ( object );
            addOnMouseOutPropertyDescriptor ( object );
            addOnMouseMovePropertyDescriptor ( object );
            addOnMouseHoverPropertyDescriptor ( object );
            addOnMouseDragPropertyDescriptor ( object );
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
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_Primitive_name_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_Primitive_name_feature", "_UI_Primitive_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                VisualInterfacePackage.Literals.PRIMITIVE__NAME, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString ( "_UI_commonPropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the Foreground Color feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addForegroundColorPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_Figure_foregroundColor_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_Figure_foregroundColor_feature", "_UI_Figure_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                VisualInterfacePackage.Literals.FIGURE__FOREGROUND_COLOR, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString ( "_UI_figurePropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the Background Color feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addBackgroundColorPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_Figure_backgroundColor_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_Figure_backgroundColor_feature", "_UI_Figure_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                VisualInterfacePackage.Literals.FIGURE__BACKGROUND_COLOR, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString ( "_UI_figurePropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the On Click feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addOnClickPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_Figure_onClick_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_Figure_onClick_feature", "_UI_Figure_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                VisualInterfacePackage.Literals.FIGURE__ON_CLICK, true, true, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString ( "_UI_handlerPropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the On Double Click feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addOnDoubleClickPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_Figure_onDoubleClick_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_Figure_onDoubleClick_feature", "_UI_Figure_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                VisualInterfacePackage.Literals.FIGURE__ON_DOUBLE_CLICK, true, true, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString ( "_UI_handlerPropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the Cursor feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addCursorPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_Figure_cursor_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_Figure_cursor_feature", "_UI_Figure_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                VisualInterfacePackage.Literals.FIGURE__CURSOR, true, false, true, null, getString ( "_UI_figurePropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the Visible feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addVisiblePropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_Figure_visible_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_Figure_visible_feature", "_UI_Figure_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                VisualInterfacePackage.Literals.FIGURE__VISIBLE, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, getString ( "_UI_figurePropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the Border feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addBorderPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_Figure_border_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_Figure_border_feature", "_UI_Figure_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                VisualInterfacePackage.Literals.FIGURE__BORDER, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString ( "_UI_figurePropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the Opaque feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addOpaquePropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_Figure_opaque_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_Figure_opaque_feature", "_UI_Figure_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                VisualInterfacePackage.Literals.FIGURE__OPAQUE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString ( "_UI_figurePropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the Tool Tip feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addToolTipPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_Figure_toolTip_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_Figure_toolTip_feature", "_UI_Figure_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                VisualInterfacePackage.Literals.FIGURE__TOOL_TIP, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString ( "_UI_figurePropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the On Mouse In feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addOnMouseInPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_Figure_onMouseIn_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_Figure_onMouseIn_feature", "_UI_Figure_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                VisualInterfacePackage.Literals.FIGURE__ON_MOUSE_IN, true, true, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString ( "_UI_handlerPropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the On Mouse Out feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addOnMouseOutPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_Figure_onMouseOut_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_Figure_onMouseOut_feature", "_UI_Figure_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                VisualInterfacePackage.Literals.FIGURE__ON_MOUSE_OUT, true, true, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString ( "_UI_handlerPropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the On Mouse Move feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addOnMouseMovePropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_Figure_onMouseMove_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_Figure_onMouseMove_feature", "_UI_Figure_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                VisualInterfacePackage.Literals.FIGURE__ON_MOUSE_MOVE, true, true, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString ( "_UI_handlerPropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the On Mouse Hover feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addOnMouseHoverPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_Figure_onMouseHover_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_Figure_onMouseHover_feature", "_UI_Figure_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                VisualInterfacePackage.Literals.FIGURE__ON_MOUSE_HOVER, true, true, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString ( "_UI_handlerPropertyCategory" ), //$NON-NLS-1$
                null ) );
    }

    /**
     * This adds a property descriptor for the On Mouse Drag feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addOnMouseDragPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_Figure_onMouseDrag_feature" ), //$NON-NLS-1$
                getString ( "_UI_PropertyDescriptor_description", "_UI_Figure_onMouseDrag_feature", "_UI_Figure_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                VisualInterfacePackage.Literals.FIGURE__ON_MOUSE_DRAG, true, true, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, getString ( "_UI_handlerPropertyCategory" ), //$NON-NLS-1$
                null ) );
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
            childrenFeatures.add ( VisualInterfacePackage.Literals.FIGURE__SIZE );
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
     * This returns Figure.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage ( Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/Figure" ) ); //$NON-NLS-1$
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
        String label = ( (Figure)object ).getName ();
        return label == null || label.length () == 0 ? getString ( "_UI_Figure_type" ) : //$NON-NLS-1$
                getString ( "_UI_Figure_type" ) + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

        switch ( notification.getFeatureID ( Figure.class ) )
        {
            case VisualInterfacePackage.FIGURE__NAME:
            case VisualInterfacePackage.FIGURE__FOREGROUND_COLOR:
            case VisualInterfacePackage.FIGURE__BACKGROUND_COLOR:
            case VisualInterfacePackage.FIGURE__ON_CLICK:
            case VisualInterfacePackage.FIGURE__ON_DOUBLE_CLICK:
            case VisualInterfacePackage.FIGURE__VISIBLE:
            case VisualInterfacePackage.FIGURE__BORDER:
            case VisualInterfacePackage.FIGURE__OPAQUE:
            case VisualInterfacePackage.FIGURE__TOOL_TIP:
            case VisualInterfacePackage.FIGURE__ON_MOUSE_IN:
            case VisualInterfacePackage.FIGURE__ON_MOUSE_OUT:
            case VisualInterfacePackage.FIGURE__ON_MOUSE_MOVE:
            case VisualInterfacePackage.FIGURE__ON_MOUSE_HOVER:
            case VisualInterfacePackage.FIGURE__ON_MOUSE_DRAG:
                fireNotifyChanged ( new ViewerNotification ( notification, notification.getNotifier (), false, true ) );
                return;
            case VisualInterfacePackage.FIGURE__SIZE:
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

        newChildDescriptors.add ( createChildParameter ( VisualInterfacePackage.Literals.FIGURE__SIZE, VisualInterfaceFactory.eINSTANCE.createDimension () ) );
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
