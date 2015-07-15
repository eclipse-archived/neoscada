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
import org.eclipse.scada.configuration.component.MasterImportConnectionAnalyzer;
import org.eclipse.scada.configuration.infrastructure.MasterImport;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Master Import Connection Analyzer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.MasterImportConnectionAnalyzerImpl#getConnection <em>Connection</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MasterImportConnectionAnalyzerImpl extends MasterComponentImpl implements MasterImportConnectionAnalyzer
{
    /**
     * The cached value of the '{@link #getConnection() <em>Connection</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConnection()
     * @generated
     * @ordered
     */
    protected MasterImport connection;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MasterImportConnectionAnalyzerImpl ()
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
        return ComponentPackage.Literals.MASTER_IMPORT_CONNECTION_ANALYZER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MasterImport getConnection ()
    {
        if ( connection != null && connection.eIsProxy () )
        {
            InternalEObject oldConnection = (InternalEObject)connection;
            connection = (MasterImport)eResolveProxy ( oldConnection );
            if ( connection != oldConnection )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.MASTER_IMPORT_CONNECTION_ANALYZER__CONNECTION, oldConnection, connection ) );
            }
        }
        return connection;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MasterImport basicGetConnection ()
    {
        return connection;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setConnection ( MasterImport newConnection )
    {
        MasterImport oldConnection = connection;
        connection = newConnection;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.MASTER_IMPORT_CONNECTION_ANALYZER__CONNECTION, oldConnection, connection ) );
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
            case ComponentPackage.MASTER_IMPORT_CONNECTION_ANALYZER__CONNECTION:
                if ( resolve )
                    return getConnection ();
                return basicGetConnection ();
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
            case ComponentPackage.MASTER_IMPORT_CONNECTION_ANALYZER__CONNECTION:
                setConnection ( (MasterImport)newValue );
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
            case ComponentPackage.MASTER_IMPORT_CONNECTION_ANALYZER__CONNECTION:
                setConnection ( (MasterImport)null );
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
            case ComponentPackage.MASTER_IMPORT_CONNECTION_ANALYZER__CONNECTION:
                return connection != null;
        }
        return super.eIsSet ( featureID );
    }

} //MasterImportConnectionAnalyzerImpl
