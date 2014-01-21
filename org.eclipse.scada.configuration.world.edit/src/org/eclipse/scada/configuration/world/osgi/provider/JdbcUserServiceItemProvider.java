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
package org.eclipse.scada.configuration.world.osgi.provider;

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
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.scada.configuration.world.WorldPackage;
import org.eclipse.scada.configuration.world.osgi.JdbcUserService;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;

/**
 * This is the item provider adapter for a
 * {@link org.eclipse.scada.configuration.world.osgi.JdbcUserService} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class JdbcUserServiceItemProvider extends ItemProviderAdapter implements
        IEditingDomainItemProvider, IStructuredItemContentProvider,
        ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource,
        ITableItemLabelProvider
{
    /**
     * This constructs an instance from a factory and a notifier.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public JdbcUserServiceItemProvider ( final AdapterFactory adapterFactory )
    {
        super ( adapterFactory );
    }

    /**
     * This returns the property descriptors for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors ( final Object object )
    {
        if ( this.itemPropertyDescriptors == null )
        {
            super.getPropertyDescriptors ( object );

            addShortDescriptionPropertyDescriptor ( object );
            addNamePropertyDescriptor ( object );
            addJdbcDriverPropertyDescriptor ( object );
            addAuthorativePropertyDescriptor ( object );
            addFindUserSqlPropertyDescriptor ( object );
            addFindRolesForUserSqlPropertyDescriptor ( object );
            addUpdatePasswordSqlPropertyDescriptor ( object );
            addUserIdColumnNamePropertyDescriptor ( object );
            addPasswordColumnNamePropertyDescriptor ( object );
            addPasswordTypePropertyDescriptor ( object );
        }
        return this.itemPropertyDescriptors;
    }

    /**
     * This adds a property descriptor for the Short Description feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addShortDescriptionPropertyDescriptor ( final Object object )
    {
        this.itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)this.adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_Documentable_shortDescription_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_Documentable_shortDescription_feature", "_UI_Documentable_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        WorldPackage.Literals.DOCUMENTABLE__SHORT_DESCRIPTION,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null ) );
    }

    /**
     * This adds a property descriptor for the Name feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addNamePropertyDescriptor ( final Object object )
    {
        this.itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)this.adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_NamedDocumentable_name_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_NamedDocumentable_name_feature", "_UI_NamedDocumentable_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        WorldPackage.Literals.NAMED_DOCUMENTABLE__NAME,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null ) );
    }

    /**
     * This adds a property descriptor for the Jdbc Driver feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addJdbcDriverPropertyDescriptor ( final Object object )
    {
        this.itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)this.adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_JdbcUserService_jdbcDriver_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_JdbcUserService_jdbcDriver_feature", "_UI_JdbcUserService_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        OsgiPackage.Literals.JDBC_USER_SERVICE__JDBC_DRIVER,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null ) );
    }

    /**
     * This adds a property descriptor for the Authorative feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addAuthorativePropertyDescriptor ( final Object object )
    {
        this.itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)this.adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_JdbcUserService_authorative_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_JdbcUserService_authorative_feature", "_UI_JdbcUserService_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        OsgiPackage.Literals.JDBC_USER_SERVICE__AUTHORATIVE,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
                        null,
                        null ) );
    }

    /**
     * This adds a property descriptor for the Find User Sql feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addFindUserSqlPropertyDescriptor ( final Object object )
    {
        this.itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)this.adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_JdbcUserService_findUserSql_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_JdbcUserService_findUserSql_feature", "_UI_JdbcUserService_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        OsgiPackage.Literals.JDBC_USER_SERVICE__FIND_USER_SQL,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null ) );
    }

    /**
     * This adds a property descriptor for the Find Roles For User Sql feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addFindRolesForUserSqlPropertyDescriptor ( final Object object )
    {
        this.itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)this.adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_JdbcUserService_findRolesForUserSql_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_JdbcUserService_findRolesForUserSql_feature", "_UI_JdbcUserService_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        OsgiPackage.Literals.JDBC_USER_SERVICE__FIND_ROLES_FOR_USER_SQL,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null ) );
    }

    /**
     * This adds a property descriptor for the Update Password Sql feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addUpdatePasswordSqlPropertyDescriptor ( final Object object )
    {
        this.itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)this.adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_JdbcUserService_updatePasswordSql_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_JdbcUserService_updatePasswordSql_feature", "_UI_JdbcUserService_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        OsgiPackage.Literals.JDBC_USER_SERVICE__UPDATE_PASSWORD_SQL,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null ) );
    }

    /**
     * This adds a property descriptor for the User Id Column Name feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addUserIdColumnNamePropertyDescriptor ( final Object object )
    {
        this.itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)this.adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_JdbcUserService_userIdColumnName_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_JdbcUserService_userIdColumnName_feature", "_UI_JdbcUserService_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        OsgiPackage.Literals.JDBC_USER_SERVICE__USER_ID_COLUMN_NAME,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null ) );
    }

    /**
     * This adds a property descriptor for the Password Column Name feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addPasswordColumnNamePropertyDescriptor ( final Object object )
    {
        this.itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)this.adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_JdbcUserService_passwordColumnName_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_JdbcUserService_passwordColumnName_feature", "_UI_JdbcUserService_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        OsgiPackage.Literals.JDBC_USER_SERVICE__PASSWORD_COLUMN_NAME,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null ) );
    }

    /**
     * This adds a property descriptor for the Password Type feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected void addPasswordTypePropertyDescriptor ( final Object object )
    {
        this.itemPropertyDescriptors.add
                ( createItemPropertyDescriptor
                ( ( (ComposeableAdapterFactory)this.adapterFactory ).getRootAdapterFactory (),
                        getResourceLocator (),
                        getString ( "_UI_JdbcUserService_passwordType_feature" ), //$NON-NLS-1$
                        getString ( "_UI_PropertyDescriptor_description", "_UI_JdbcUserService_passwordType_feature", "_UI_JdbcUserService_type" ), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                        OsgiPackage.Literals.JDBC_USER_SERVICE__PASSWORD_TYPE,
                        true,
                        false,
                        false,
                        ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
                        null,
                        null ) );
    }

    /**
     * This specifies how to implement {@link #getChildren} and is used to
     * deduce an appropriate feature for an
     * {@link org.eclipse.emf.edit.command.AddCommand},
     * {@link org.eclipse.emf.edit.command.RemoveCommand} or
     * {@link org.eclipse.emf.edit.command.MoveCommand} in
     * {@link #createCommand}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Collection<? extends EStructuralFeature> getChildrenFeatures (
            final Object object )
    {
        if ( this.childrenFeatures == null )
        {
            super.getChildrenFeatures ( object );
            this.childrenFeatures.add ( OsgiPackage.Literals.JDBC_USER_SERVICE__JDBC_PROPETIES );
        }
        return this.childrenFeatures;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EStructuralFeature getChildFeature ( final Object object, final Object child )
    {
        // Check the type of the specified child object and return the proper feature to use for
        // adding (see {@link AddCommand}) it as a child.

        return super.getChildFeature ( object, child );
    }

    /**
     * This returns JdbcUserService.gif.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object getImage ( final Object object )
    {
        return overlayImage ( object, getResourceLocator ().getImage ( "full/obj16/JdbcUserService" ) ); //$NON-NLS-1$
    }

    /**
     * This returns the label text for the adapted class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getText ( final Object object )
    {
        final String label = ( (JdbcUserService)object ).getName ();
        return label == null || label.length () == 0 ?
                getString ( "_UI_JdbcUserService_type" ) : //$NON-NLS-1$
                getString ( "_UI_JdbcUserService_type" ) + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
    }

    /**
     * This handles model notifications by calling {@link #updateChildren} to
     * update any cached
     * children and by creating a viewer notification, which it passes to
     * {@link #fireNotifyChanged}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void notifyChanged ( final Notification notification )
    {
        updateChildren ( notification );

        switch ( notification.getFeatureID ( JdbcUserService.class ) )
        {
            case OsgiPackage.JDBC_USER_SERVICE__SHORT_DESCRIPTION:
            case OsgiPackage.JDBC_USER_SERVICE__NAME:
            case OsgiPackage.JDBC_USER_SERVICE__JDBC_DRIVER:
            case OsgiPackage.JDBC_USER_SERVICE__AUTHORATIVE:
            case OsgiPackage.JDBC_USER_SERVICE__FIND_USER_SQL:
            case OsgiPackage.JDBC_USER_SERVICE__FIND_ROLES_FOR_USER_SQL:
            case OsgiPackage.JDBC_USER_SERVICE__UPDATE_PASSWORD_SQL:
            case OsgiPackage.JDBC_USER_SERVICE__USER_ID_COLUMN_NAME:
            case OsgiPackage.JDBC_USER_SERVICE__PASSWORD_COLUMN_NAME:
            case OsgiPackage.JDBC_USER_SERVICE__PASSWORD_TYPE:
                fireNotifyChanged ( new ViewerNotification ( notification, notification.getNotifier (), false, true ) );
                return;
            case OsgiPackage.JDBC_USER_SERVICE__JDBC_PROPETIES:
                fireNotifyChanged ( new ViewerNotification ( notification, notification.getNotifier (), true, false ) );
                return;
        }
        super.notifyChanged ( notification );
    }

    /**
     * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
     * describing the children
     * that can be created under this object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected void collectNewChildDescriptors (
            final Collection<Object> newChildDescriptors, final Object object )
    {
        super.collectNewChildDescriptors ( newChildDescriptors, object );

        newChildDescriptors.add
                ( createChildParameter
                ( OsgiPackage.Literals.JDBC_USER_SERVICE__JDBC_PROPETIES,
                        OsgiFactory.eINSTANCE.createPropertyEntry () ) );
    }

    /**
     * Return the resource locator for this item provider's resources.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator ()
    {
        return ( (IChildCreationExtender)this.adapterFactory ).getResourceLocator ();
    }

}
