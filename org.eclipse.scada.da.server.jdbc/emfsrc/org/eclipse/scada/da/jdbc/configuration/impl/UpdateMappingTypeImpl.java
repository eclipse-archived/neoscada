/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.jdbc.configuration.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage;
import org.eclipse.scada.da.jdbc.configuration.UpdateMappingType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Update Mapping Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.impl.UpdateMappingTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.impl.UpdateMappingTypeImpl#getNamedParameter <em>Named Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UpdateMappingTypeImpl extends MinimalEObjectImpl.Container implements UpdateMappingType
{
    //$NON-NLS-1$

    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

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
    protected UpdateMappingTypeImpl ()
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
        return ConfigurationPackage.Literals.UPDATE_MAPPING_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName ()
    {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName ( String newName )
    {
        String oldName = name;
        name = newName;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.UPDATE_MAPPING_TYPE__NAME, oldName, name ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.UPDATE_MAPPING_TYPE__NAMED_PARAMETER, oldNamedParameter, namedParameter ) );
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
            case ConfigurationPackage.UPDATE_MAPPING_TYPE__NAME:
                return getName ();
            case ConfigurationPackage.UPDATE_MAPPING_TYPE__NAMED_PARAMETER:
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
            case ConfigurationPackage.UPDATE_MAPPING_TYPE__NAME:
                setName ( (String)newValue );
                return;
            case ConfigurationPackage.UPDATE_MAPPING_TYPE__NAMED_PARAMETER:
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
            case ConfigurationPackage.UPDATE_MAPPING_TYPE__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case ConfigurationPackage.UPDATE_MAPPING_TYPE__NAMED_PARAMETER:
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
            case ConfigurationPackage.UPDATE_MAPPING_TYPE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
            case ConfigurationPackage.UPDATE_MAPPING_TYPE__NAMED_PARAMETER:
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
        result.append ( " (name: " ); //$NON-NLS-1$
        result.append ( name );
        result.append ( ", namedParameter: " ); //$NON-NLS-1$
        result.append ( namedParameter );
        result.append ( ')' );
        return result.toString ();
    }

} //UpdateMappingTypeImpl
