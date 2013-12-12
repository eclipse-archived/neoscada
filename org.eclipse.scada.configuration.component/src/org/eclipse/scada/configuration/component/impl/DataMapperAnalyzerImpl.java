/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.component.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.DataMapperAnalyzer;
import org.eclipse.scada.configuration.component.DataMapperService;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Mapper Analyzer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.DataMapperAnalyzerImpl#getDataMapper <em>Data Mapper</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataMapperAnalyzerImpl extends MasterComponentImpl implements DataMapperAnalyzer
{
    /**
     * The cached value of the '{@link #getDataMapper() <em>Data Mapper</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataMapper()
     * @generated
     * @ordered
     */
    protected DataMapperService dataMapper;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DataMapperAnalyzerImpl ()
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
        return ComponentPackage.Literals.DATA_MAPPER_ANALYZER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataMapperService getDataMapper ()
    {
        if ( dataMapper != null && dataMapper.eIsProxy () )
        {
            InternalEObject oldDataMapper = (InternalEObject)dataMapper;
            dataMapper = (DataMapperService)eResolveProxy ( oldDataMapper );
            if ( dataMapper != oldDataMapper )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.DATA_MAPPER_ANALYZER__DATA_MAPPER, oldDataMapper, dataMapper ) );
            }
        }
        return dataMapper;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataMapperService basicGetDataMapper ()
    {
        return dataMapper;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDataMapper ( DataMapperService newDataMapper )
    {
        DataMapperService oldDataMapper = dataMapper;
        dataMapper = newDataMapper;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.DATA_MAPPER_ANALYZER__DATA_MAPPER, oldDataMapper, dataMapper ) );
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
            case ComponentPackage.DATA_MAPPER_ANALYZER__DATA_MAPPER:
                if ( resolve )
                    return getDataMapper ();
                return basicGetDataMapper ();
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
            case ComponentPackage.DATA_MAPPER_ANALYZER__DATA_MAPPER:
                setDataMapper ( (DataMapperService)newValue );
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
            case ComponentPackage.DATA_MAPPER_ANALYZER__DATA_MAPPER:
                setDataMapper ( (DataMapperService)null );
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
            case ComponentPackage.DATA_MAPPER_ANALYZER__DATA_MAPPER:
                return dataMapper != null;
        }
        return super.eIsSet ( featureID );
    }

} //DataMapperAnalyzerImpl
