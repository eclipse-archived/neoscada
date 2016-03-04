/**
 * Copyright (c) 2016 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 *
 */
package org.eclipse.scada.configuration.world.osgi.provider;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IItemStyledLabelProvider;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.StyledString;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.scada.configuration.world.osgi.ArchiveConfiguration;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.scada.configuration.world.osgi.ArchiveConfiguration} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ArchiveConfigurationItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource, ITableItemLabelProvider, IItemStyledLabelProvider
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ArchiveConfigurationItemProvider ( AdapterFactory adapterFactory )
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

            addFileSizeInMillisecondsPropertyDescriptor ( object );
            addNumberOfFilesPropertyDescriptor ( object );
        }
        return itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the File Size In Milliseconds feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addFileSizeInMillisecondsPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ArchiveConfiguration_fileSizeInMilliseconds_feature" ), //$NON-NLS-1$
        getString ( "_UI_PropertyDescriptor_description", "_UI_ArchiveConfiguration_fileSizeInMilliseconds_feature", "_UI_ArchiveConfiguration_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        OsgiPackage.Literals.ARCHIVE_CONFIGURATION__FILE_SIZE_IN_MILLISECONDS, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null ) );
    }

    /**
     * This adds a property descriptor for the Number Of Files feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void addNumberOfFilesPropertyDescriptor ( Object object )
    {
        itemPropertyDescriptors.add ( createItemPropertyDescriptor ( ( (ComposeableAdapterFactory)adapterFactory ).getRootAdapterFactory (), getResourceLocator (), getString ( "_UI_ArchiveConfiguration_numberOfFiles_feature" ), //$NON-NLS-1$
        getString ( "_UI_PropertyDescriptor_description", "_UI_ArchiveConfiguration_numberOfFiles_feature", "_UI_ArchiveConfiguration_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        OsgiPackage.Literals.ARCHIVE_CONFIGURATION__NUMBER_OF_FILES, true, false, false, ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null ) );
    }

    /**
     * This returns ArchiveConfiguration.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object getImage ( Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/ArchiveConfiguration" ) ); //$NON-NLS-1$
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
     *
     * @generated NOT
     */
    @Override
    public String getText ( final Object object )
    {
        final ArchiveConfiguration archiveConfiguration = (ArchiveConfiguration)object;

        final String type = getString ( "_UI_ArchiveConfiguration_type" ); //$NON-NLS-1$

        final long minutes = TimeUnit.MILLISECONDS.toMinutes ( archiveConfiguration.getFileSizeInMilliseconds () );
        final long daysOfStorage = TimeUnit.MILLISECONDS.toDays ( archiveConfiguration.getFileSizeInMilliseconds () * archiveConfiguration.getNumberOfFiles () );

        return String.format ( "%s: %s minutes per file, %s files = %s days of storage", type, minutes, archiveConfiguration.getNumberOfFiles (), daysOfStorage );
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
        return new StyledString ( getText ( object ) );
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

        switch ( notification.getFeatureID ( ArchiveConfiguration.class ) )
        {
            case OsgiPackage.ARCHIVE_CONFIGURATION__FILE_SIZE_IN_MILLISECONDS:
            case OsgiPackage.ARCHIVE_CONFIGURATION__NUMBER_OF_FILES:
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
