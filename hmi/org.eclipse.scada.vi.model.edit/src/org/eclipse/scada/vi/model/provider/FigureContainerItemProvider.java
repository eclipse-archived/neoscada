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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.scada.vi.model.FigureContainer;
import org.eclipse.scada.vi.model.VisualInterfaceFactory;
import org.eclipse.scada.vi.model.VisualInterfacePackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.scada.vi.model.FigureContainer} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FigureContainerItemProvider extends FigureItemProvider
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FigureContainerItemProvider ( AdapterFactory adapterFactory )
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
            childrenFeatures.add ( VisualInterfacePackage.Literals.FIGURE_CONTAINER__CONTENT );
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
     * This returns FigureContainer.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage ( Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/FigureContainer" ) ); //$NON-NLS-1$
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
        String label = ( (FigureContainer)object ).getName ();
        return label == null || label.length () == 0 ? getString ( "_UI_FigureContainer_type" ) : //$NON-NLS-1$
                getString ( "_UI_FigureContainer_type" ) + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
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

        switch ( notification.getFeatureID ( FigureContainer.class ) )
        {
            case VisualInterfacePackage.FIGURE_CONTAINER__CONTENT:
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

        newChildDescriptors.add ( createChildParameter ( VisualInterfacePackage.Literals.FIGURE_CONTAINER__CONTENT, VisualInterfaceFactory.eINSTANCE.createRectangle () ) );

        newChildDescriptors.add ( createChildParameter ( VisualInterfacePackage.Literals.FIGURE_CONTAINER__CONTENT, VisualInterfaceFactory.eINSTANCE.createText () ) );

        newChildDescriptors.add ( createChildParameter ( VisualInterfacePackage.Literals.FIGURE_CONTAINER__CONTENT, VisualInterfaceFactory.eINSTANCE.createXYContainer () ) );

        newChildDescriptors.add ( createChildParameter ( VisualInterfacePackage.Literals.FIGURE_CONTAINER__CONTENT, VisualInterfaceFactory.eINSTANCE.createLine () ) );

        newChildDescriptors.add ( createChildParameter ( VisualInterfacePackage.Literals.FIGURE_CONTAINER__CONTENT, VisualInterfaceFactory.eINSTANCE.createSymbolReference () ) );

        newChildDescriptors.add ( createChildParameter ( VisualInterfacePackage.Literals.FIGURE_CONTAINER__CONTENT, VisualInterfaceFactory.eINSTANCE.createGridContainer () ) );

        newChildDescriptors.add ( createChildParameter ( VisualInterfacePackage.Literals.FIGURE_CONTAINER__CONTENT, VisualInterfaceFactory.eINSTANCE.createBorderContainer () ) );

        newChildDescriptors.add ( createChildParameter ( VisualInterfacePackage.Literals.FIGURE_CONTAINER__CONTENT, VisualInterfaceFactory.eINSTANCE.createFigureContainer () ) );

        newChildDescriptors.add ( createChildParameter ( VisualInterfacePackage.Literals.FIGURE_CONTAINER__CONTENT, VisualInterfaceFactory.eINSTANCE.createImage () ) );

        newChildDescriptors.add ( createChildParameter ( VisualInterfacePackage.Literals.FIGURE_CONTAINER__CONTENT, VisualInterfaceFactory.eINSTANCE.createEllipse () ) );

        newChildDescriptors.add ( createChildParameter ( VisualInterfacePackage.Literals.FIGURE_CONTAINER__CONTENT, VisualInterfaceFactory.eINSTANCE.createArc () ) );

        newChildDescriptors.add ( createChildParameter ( VisualInterfacePackage.Literals.FIGURE_CONTAINER__CONTENT, VisualInterfaceFactory.eINSTANCE.createStackContainer () ) );

        newChildDescriptors.add ( createChildParameter ( VisualInterfacePackage.Literals.FIGURE_CONTAINER__CONTENT, VisualInterfaceFactory.eINSTANCE.createPolygon () ) );

        newChildDescriptors.add ( createChildParameter ( VisualInterfacePackage.Literals.FIGURE_CONTAINER__CONTENT, VisualInterfaceFactory.eINSTANCE.createRoundedRectangle () ) );
    }

}
