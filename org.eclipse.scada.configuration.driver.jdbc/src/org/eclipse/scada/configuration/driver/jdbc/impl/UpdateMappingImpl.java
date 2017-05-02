/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.driver.jdbc.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.scada.configuration.driver.jdbc.JdbcPackage;
import org.eclipse.scada.configuration.driver.jdbc.UpdateMapping;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Update Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.driver.jdbc.impl.UpdateMappingImpl#getNamedParameter <em>Named Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UpdateMappingImpl extends MinimalEObjectImpl.Container implements UpdateMapping
{
    /**
     * The default value of the '{@link #getNamedParameter() <em>Named Parameter</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNamedParameter()
     * @generated
     * @ordered
     */
    protected static final String NAMED_PARAMETER_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getNamedParameter() <em>Named Parameter</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNamedParameter()
     * @generated
     * @ordered
     */
    protected String namedParameter = NAMED_PARAMETER_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected UpdateMappingImpl ()
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
        return JdbcPackage.Literals.UPDATE_MAPPING;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getNamedParameter ()
    {
        return namedParameter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setNamedParameter ( String newNamedParameter )
    {
        String oldNamedParameter = namedParameter;
        namedParameter = newNamedParameter;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, JdbcPackage.UPDATE_MAPPING__NAMED_PARAMETER, oldNamedParameter, namedParameter ) );
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
            case JdbcPackage.UPDATE_MAPPING__NAMED_PARAMETER:
                return getNamedParameter ();
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
            case JdbcPackage.UPDATE_MAPPING__NAMED_PARAMETER:
                setNamedParameter ( (String)newValue );
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
            case JdbcPackage.UPDATE_MAPPING__NAMED_PARAMETER:
                setNamedParameter ( NAMED_PARAMETER_EDEFAULT );
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
            case JdbcPackage.UPDATE_MAPPING__NAMED_PARAMETER:
                return NAMED_PARAMETER_EDEFAULT == null ? namedParameter != null : !NAMED_PARAMETER_EDEFAULT.equals ( namedParameter );
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
        result.append ( " (namedParameter: " ); //$NON-NLS-1$
        result.append ( namedParameter );
        result.append ( ')' );
        return result.toString ();
    }

} //UpdateMappingImpl
