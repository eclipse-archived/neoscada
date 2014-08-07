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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.scada.vi.details.model.CompositeComponent;
import org.eclipse.scada.vi.details.model.DetailViewFactory;
import org.eclipse.scada.vi.details.model.DetailViewPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.scada.vi.details.model.CompositeComponent} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CompositeComponentItemProvider extends ComponentItemProvider implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CompositeComponentItemProvider ( AdapterFactory adapterFactory )
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

        }
        return itemPropertyDescriptors;
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
            childrenFeatures.add ( DetailViewPackage.Literals.COMPOSITE_COMPONENT__CHILDREN );
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
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getText ( Object object )
    {
        return getString ( "_UI_CompositeComponent_type" ); //$NON-NLS-1$
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

        switch ( notification.getFeatureID ( CompositeComponent.class ) )
        {
            case DetailViewPackage.COMPOSITE_COMPONENT__CHILDREN:
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
                ( DetailViewPackage.Literals.COMPOSITE_COMPONENT__CHILDREN,
                        DetailViewFactory.eINSTANCE.createLabelComponent () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( DetailViewPackage.Literals.COMPOSITE_COMPONENT__CHILDREN,
                        DetailViewFactory.eINSTANCE.createFillLayoutComponent () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( DetailViewPackage.Literals.COMPOSITE_COMPONENT__CHILDREN,
                        DetailViewFactory.eINSTANCE.createButtonComponent () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( DetailViewPackage.Literals.COMPOSITE_COMPONENT__CHILDREN,
                        DetailViewFactory.eINSTANCE.createBoolLEDComponent () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( DetailViewPackage.Literals.COMPOSITE_COMPONENT__CHILDREN,
                        DetailViewFactory.eINSTANCE.createSimpleGridComponent () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( DetailViewPackage.Literals.COMPOSITE_COMPONENT__CHILDREN,
                        DetailViewFactory.eINSTANCE.createGroupGridComponent () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( DetailViewPackage.Literals.COMPOSITE_COMPONENT__CHILDREN,
                        DetailViewFactory.eINSTANCE.createValueSetComponent () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( DetailViewPackage.Literals.COMPOSITE_COMPONENT__CHILDREN,
                        DetailViewFactory.eINSTANCE.createValueComponent () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( DetailViewPackage.Literals.COMPOSITE_COMPONENT__CHILDREN,
                        DetailViewFactory.eINSTANCE.createTextInputComponent () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( DetailViewPackage.Literals.COMPOSITE_COMPONENT__CHILDREN,
                        DetailViewFactory.eINSTANCE.createTextComponent () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( DetailViewPackage.Literals.COMPOSITE_COMPONENT__CHILDREN,
                        DetailViewFactory.eINSTANCE.createTextInputMultiComponent () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( DetailViewPackage.Literals.COMPOSITE_COMPONENT__CHILDREN,
                        DetailViewFactory.eINSTANCE.createCheckComponent () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( DetailViewPackage.Literals.COMPOSITE_COMPONENT__CHILDREN,
                        DetailViewFactory.eINSTANCE.createLinkComponent () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( DetailViewPackage.Literals.COMPOSITE_COMPONENT__CHILDREN,
                        DetailViewFactory.eINSTANCE.createURLImageComponent () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( DetailViewPackage.Literals.COMPOSITE_COMPONENT__CHILDREN,
                        DetailViewFactory.eINSTANCE.createProgressComponent () ) );

        newChildDescriptors.add
                ( createChildParameter
                ( DetailViewPackage.Literals.COMPOSITE_COMPONENT__CHILDREN,
                        DetailViewFactory.eINSTANCE.createBrowserComponent () ) );
    }

}
