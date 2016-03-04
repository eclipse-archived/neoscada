/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
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
import java.util.List;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.scada.configuration.component.ComponentFactory;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.Level;

/**
 * This is the item provider adapter for a {@link org.eclipse.scada.configuration.component.Level} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class LevelItemProvider extends ContainerItemProvider
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LevelItemProvider ( AdapterFactory adapterFactory )
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

            addCustomizationPipelinePropertyDescriptor ( object );
            addArchiveSelectorPropertyDescriptor ( object );
            addNamePropertyDescriptor ( object );
            addDescriptionPropertyDescriptor ( object );
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
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_Level_name_feature" ), //$NON-NLS-1$
        getString ( "_UI_PropertyDescriptor_description", "_UI_Level_name_feature", "_UI_Level_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        ComponentPackage.Literals.LEVEL__NAME, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null ) );
    }

    /**
     * This adds a property descriptor for the Description feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addDescriptionPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_Level_description_feature" ), //$NON-NLS-1$
        getString ( "_UI_PropertyDescriptor_description", "_UI_Level_description_feature", "_UI_Level_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        ComponentPackage.Literals.LEVEL__DESCRIPTION, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null ) );
    }

    /**
     * This adds a property descriptor for the Customization Pipeline feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addCustomizationPipelinePropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_Level_customizationPipeline_feature" ), //$NON-NLS-1$
        getString ( "_UI_PropertyDescriptor_description", "_UI_Level_customizationPipeline_feature", "_UI_Level_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        ComponentPackage.Literals.LEVEL__CUSTOMIZATION_PIPELINE, true, false, true, null, null, null ) );
    }

    /**
     * This adds a property descriptor for the Archive Selector feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addArchiveSelectorPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_Level_archiveSelector_feature" ), //$NON-NLS-1$
        getString ( "_UI_PropertyDescriptor_description", "_UI_Level_archiveSelector_feature", "_UI_Level_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        ComponentPackage.Literals.LEVEL__ARCHIVE_SELECTOR, true, false, true, null, null, null ) );
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
            childrenFeatures.add ( ComponentPackage.Literals.LEVEL__COMPONENTS );
            childrenFeatures.add ( ComponentPackage.Literals.LEVEL__LEVELS );
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
     * This returns Level.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage ( Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/Level" ) ); //$NON-NLS-1$
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
     * @generated NOT
     */
    @Override
    public Object getStyledText ( Object object )
    {
        String label = ( (Level)object ).getName ();
        String description = ( (Level)object ).getDescription ();

        StyledString styledLabel = new StyledString ();
        if ( label == null || label.length () == 0 )
        {
            styledLabel.append ( getString ( "_UI_Level_type" ), StyledString.Style.QUALIFIER_STYLER ); //$NON-NLS-1$
        }
        else
        {
            styledLabel.append ( getString ( "_UI_Level_type" ), StyledString.Style.QUALIFIER_STYLER ).append ( " " + label ); //$NON-NLS-1$ //$NON-NLS-2$
        }

        if ( description != null && !description.isEmpty () )
        {
            styledLabel.append ( " (" + description + ")", StyledString.Style.DECORATIONS_STYLER ); //$NON-NLS-1$  //$NON-NLS-2$
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

        switch ( notification.getFeatureID ( Level.class ) )
        {
            case ComponentPackage.LEVEL__NAME:
            case ComponentPackage.LEVEL__DESCRIPTION:
                fireNotifyChanged ( new ViewerNotification ( notification, notification.getNotifier (), false, true ) );
                return;
            case ComponentPackage.LEVEL__COMPONENTS:
            case ComponentPackage.LEVEL__LEVELS:
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

        newChildDescriptors.add ( createChildParameter ( ComponentPackage.Literals.LEVEL__COMPONENTS, ComponentFactory.eINSTANCE.createMasterComponent () ) );

        newChildDescriptors.add ( createChildParameter ( ComponentPackage.Literals.LEVEL__COMPONENTS, ComponentFactory.eINSTANCE.createConstantValue () ) );

        newChildDescriptors.add ( createChildParameter ( ComponentPackage.Literals.LEVEL__COMPONENTS, ComponentFactory.eINSTANCE.createPersistentValue () ) );

        newChildDescriptors.add ( createChildParameter ( ComponentPackage.Literals.LEVEL__COMPONENTS, ComponentFactory.eINSTANCE.createDriverConnectionAnalyzer () ) );

        newChildDescriptors.add ( createChildParameter ( ComponentPackage.Literals.LEVEL__COMPONENTS, ComponentFactory.eINSTANCE.createMasterImportConnectionAnalyzer () ) );

        newChildDescriptors.add ( createChildParameter ( ComponentPackage.Literals.LEVEL__COMPONENTS, ComponentFactory.eINSTANCE.createDataMapperAnalyzer () ) );

        newChildDescriptors.add ( createChildParameter ( ComponentPackage.Literals.LEVEL__COMPONENTS, ComponentFactory.eINSTANCE.createMappedSourceValue () ) );

        newChildDescriptors.add ( createChildParameter ( ComponentPackage.Literals.LEVEL__COMPONENTS, ComponentFactory.eINSTANCE.createCalculationComponent () ) );

        newChildDescriptors.add ( createChildParameter ( ComponentPackage.Literals.LEVEL__COMPONENTS, ComponentFactory.eINSTANCE.createExternalValue () ) );

        newChildDescriptors.add ( createChildParameter ( ComponentPackage.Literals.LEVEL__COMPONENTS, ComponentFactory.eINSTANCE.createGlobalizeComponent () ) );

        newChildDescriptors.add ( createChildParameter ( ComponentPackage.Literals.LEVEL__COMPONENTS, ComponentFactory.eINSTANCE.createTransientValue () ) );

        newChildDescriptors.add ( createChildParameter ( ComponentPackage.Literals.LEVEL__COMPONENTS, ComponentFactory.eINSTANCE.createBufferedValue () ) );

        newChildDescriptors.add ( createChildParameter ( ComponentPackage.Literals.LEVEL__COMPONENTS, ComponentFactory.eINSTANCE.createChangeCounter () ) );

        newChildDescriptors.add ( createChildParameter ( ComponentPackage.Literals.LEVEL__COMPONENTS, ComponentFactory.eINSTANCE.createDeltaValue () ) );

        newChildDescriptors.add ( createChildParameter ( ComponentPackage.Literals.LEVEL__LEVELS, ComponentFactory.eINSTANCE.createLevel () ) );
    }

    @Override
    public Command createCommand ( final Object object, final EditingDomain domain, final Class<? extends Command> commandClass, final CommandParameter commandParameter )
    {
        // TODO Auto-generated method stub
        return super.createCommand ( object, domain, commandClass, commandParameter );
    }
}
