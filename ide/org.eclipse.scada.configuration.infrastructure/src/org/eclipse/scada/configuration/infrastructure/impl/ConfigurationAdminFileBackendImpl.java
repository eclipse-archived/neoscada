/**
 * Copyright (c) 2015 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.infrastructure.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.scada.configuration.infrastructure.ConfigurationAdminFileBackend;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration Admin File Backend</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.ConfigurationAdminFileBackendImpl#getPath <em>Path</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConfigurationAdminFileBackendImpl extends MinimalEObjectImpl.Container implements ConfigurationAdminFileBackend
{
    /**
     * The default value of the '{@link #getPath() <em>Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPath()
     * @generated
     * @ordered
     */
    protected static final String PATH_EDEFAULT = "${user.home}/.eclipse.scada/ca.#{name}"; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getPath() <em>Path</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPath()
     * @generated
     * @ordered
     */
    protected String path = PATH_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ConfigurationAdminFileBackendImpl ()
    {
        super ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass ()
    {
        return InfrastructurePackage.Literals.CONFIGURATION_ADMIN_FILE_BACKEND;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getPath ()
    {
        return path;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPath ( String newPath )
    {
        String oldPath = path;
        path = newPath;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.CONFIGURATION_ADMIN_FILE_BACKEND__PATH, oldPath, path ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet ( int featureID, boolean resolve, boolean coreType )
    {
        switch ( featureID )
        {
            case InfrastructurePackage.CONFIGURATION_ADMIN_FILE_BACKEND__PATH:
                return getPath ();
        }
        return super.eGet ( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet ( int featureID, Object newValue )
    {
        switch ( featureID )
        {
            case InfrastructurePackage.CONFIGURATION_ADMIN_FILE_BACKEND__PATH:
                setPath ( (String)newValue );
                return;
        }
        super.eSet ( featureID, newValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset ( int featureID )
    {
        switch ( featureID )
        {
            case InfrastructurePackage.CONFIGURATION_ADMIN_FILE_BACKEND__PATH:
                setPath ( PATH_EDEFAULT );
                return;
        }
        super.eUnset ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet ( int featureID )
    {
        switch ( featureID )
        {
            case InfrastructurePackage.CONFIGURATION_ADMIN_FILE_BACKEND__PATH:
                return PATH_EDEFAULT == null ? path != null : !PATH_EDEFAULT.equals ( path );
        }
        return super.eIsSet ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString ()
    {
        if ( eIsProxy () )
            return super.toString ();

        StringBuffer result = new StringBuffer ( super.toString () );
        result.append ( " (path: " ); //$NON-NLS-1$
        result.append ( path );
        result.append ( ')' );
        return result.toString ();
    }

} //ConfigurationAdminFileBackendImpl
