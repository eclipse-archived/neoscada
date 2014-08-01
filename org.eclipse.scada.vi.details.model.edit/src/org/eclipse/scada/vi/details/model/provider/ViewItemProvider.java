/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.details.model.provider;

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
import org.eclipse.scada.vi.details.model.DetailViewFactory;
import org.eclipse.scada.vi.details.model.DetailViewPackage;
import org.eclipse.scada.vi.details.model.TabStyle;
import org.eclipse.scada.vi.details.model.View;

/**
 * This is the item provider adapter for a {@link org.eclipse.scada.vi.details.model.View} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ViewItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ViewItemProvider ( AdapterFactory adapterFactory )
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

            addTabStylePropertyDescriptor ( object );
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Tab Style feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addTabStylePropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_View_tabStyle_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_View_tabStyle_feature", "_UI_View_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        DetailViewPackage.Literals.VIEW__TAB_STYLE,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
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
            childrenFeatures.add ( DetailViewPackage.Literals.VIEW__HEADER_COMPONENT );
            childrenFeatures.add ( DetailViewPackage.Literals.VIEW__GROUPS );
            childrenFeatures.add ( DetailViewPackage.Literals.VIEW__HIDDEN_COMPONENT );
            childrenFeatures.add ( DetailViewPackage.Literals.VIEW__SCRIPT_MODULE );
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
     * This returns View.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage ( Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/View" ) ); //$NON-NLS-1$
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
        TabStyle labelValue = ( (View)object ).getTabStyle ();
        String label = labelValue == null ? null : labelValue.toString ();
        return label == null || label.length () == 0 ?
                getString ( "_UI_View_type" ) : //$NON-NLS-1$
                getString ( "_UI_View_type" ) + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

        switch ( notification.getFeatureID ( View.class ) )
        {
            case DetailViewPackage.VIEW__TAB_STYLE:
                fireNotifyChanged ( new ViewerNotification ( notification, notification.getNotifier (), false, true ) );
                return;
            case DetailViewPackage.VIEW__HEADER_COMPONENT:
            case DetailViewPackage.VIEW__GROUPS:
            case DetailViewPackage.VIEW__HIDDEN_COMPONENT:
            case DetailViewPackage.VIEW__SCRIPT_MODULE:
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

        newChildDescriptors.add
                ( createChildParameter
                ( DetailViewPackage.Literals.VIEW__HEADER_COMPONENT,
                        DetailViewFactory.eINSTANCE.createLabelComponent () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( DetailViewPackage.Literals.VIEW__HEADER_COMPONENT,
                        DetailViewFactory.eINSTANCE.createFillLayoutComponent () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( DetailViewPackage.Literals.VIEW__HEADER_COMPONENT,
                        DetailViewFactory.eINSTANCE.createButtonComponent () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( DetailViewPackage.Literals.VIEW__HEADER_COMPONENT,
                        DetailViewFactory.eINSTANCE.createBoolLEDComponent () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( DetailViewPackage.Literals.VIEW__HEADER_COMPONENT,
                        DetailViewFactory.eINSTANCE.createSimpleGridComponent () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( DetailViewPackage.Literals.VIEW__HEADER_COMPONENT,
                        DetailViewFactory.eINSTANCE.createGroupGridComponent () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( DetailViewPackage.Literals.VIEW__HEADER_COMPONENT,
                        DetailViewFactory.eINSTANCE.createValueSetComponent () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( DetailViewPackage.Literals.VIEW__HEADER_COMPONENT,
                        DetailViewFactory.eINSTANCE.createValueComponent () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( DetailViewPackage.Literals.VIEW__HEADER_COMPONENT,
                        DetailViewFactory.eINSTANCE.createTextInputComponent () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( DetailViewPackage.Literals.VIEW__HEADER_COMPONENT,
                        DetailViewFactory.eINSTANCE.createTextComponent () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( DetailViewPackage.Literals.VIEW__HEADER_COMPONENT,
                        DetailViewFactory.eINSTANCE.createTextInputMultiComponent () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( DetailViewPackage.Literals.VIEW__HEADER_COMPONENT,
                        DetailViewFactory.eINSTANCE.createCheckComponent () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( DetailViewPackage.Literals.VIEW__HEADER_COMPONENT,
                        DetailViewFactory.eINSTANCE.createLinkComponent () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( DetailViewPackage.Literals.VIEW__HEADER_COMPONENT,
                        DetailViewFactory.eINSTANCE.createURLImageComponent () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( DetailViewPackage.Literals.VIEW__HEADER_COMPONENT,
                        DetailViewFactory.eINSTANCE.createProgressComponent () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( DetailViewPackage.Literals.VIEW__HEADER_COMPONENT,
                        DetailViewFactory.eINSTANCE.createBrowserComponent () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( DetailViewPackage.Literals.VIEW__GROUPS,
                        DetailViewFactory.eINSTANCE.createGroupEntry () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( DetailViewPackage.Literals.VIEW__HIDDEN_COMPONENT,
                        DetailViewFactory.eINSTANCE.createHiddenComponent () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( DetailViewPackage.Literals.VIEW__SCRIPT_MODULE,
                        DetailViewFactory.eINSTANCE.createScriptModule () ) );
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
