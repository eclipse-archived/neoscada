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
package org.eclipse.scada.configuration.infrastructure.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.infrastructure.OracleVMSettings;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Oracle VM Settings</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.OracleVMSettingsImpl#getInitialHeapSize <em>Initial Heap Size</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.OracleVMSettingsImpl#getMaximumHeapSize <em>Maximum Heap Size</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OracleVMSettingsImpl extends MinimalEObjectImpl.Container implements OracleVMSettings
{
    /**
     * The default value of the '{@link #getInitialHeapSize() <em>Initial Heap Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInitialHeapSize()
     * @generated
     * @ordered
     */
    protected static final String INITIAL_HEAP_SIZE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getInitialHeapSize() <em>Initial Heap Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInitialHeapSize()
     * @generated
     * @ordered
     */
    protected String initialHeapSize = INITIAL_HEAP_SIZE_EDEFAULT;

    /**
     * The default value of the '{@link #getMaximumHeapSize() <em>Maximum Heap Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMaximumHeapSize()
     * @generated
     * @ordered
     */
    protected static final String MAXIMUM_HEAP_SIZE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getMaximumHeapSize() <em>Maximum Heap Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMaximumHeapSize()
     * @generated
     * @ordered
     */
    protected String maximumHeapSize = MAXIMUM_HEAP_SIZE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected OracleVMSettingsImpl ()
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
        return InfrastructurePackage.Literals.ORACLE_VM_SETTINGS;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getInitialHeapSize ()
    {
        return initialHeapSize;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInitialHeapSize ( String newInitialHeapSize )
    {
        String oldInitialHeapSize = initialHeapSize;
        initialHeapSize = newInitialHeapSize;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.ORACLE_VM_SETTINGS__INITIAL_HEAP_SIZE, oldInitialHeapSize, initialHeapSize ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getMaximumHeapSize ()
    {
        return maximumHeapSize;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMaximumHeapSize ( String newMaximumHeapSize )
    {
        String oldMaximumHeapSize = maximumHeapSize;
        maximumHeapSize = newMaximumHeapSize;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.ORACLE_VM_SETTINGS__MAXIMUM_HEAP_SIZE, oldMaximumHeapSize, maximumHeapSize ) );
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
            case InfrastructurePackage.ORACLE_VM_SETTINGS__INITIAL_HEAP_SIZE:
                return getInitialHeapSize ();
            case InfrastructurePackage.ORACLE_VM_SETTINGS__MAXIMUM_HEAP_SIZE:
                return getMaximumHeapSize ();
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
            case InfrastructurePackage.ORACLE_VM_SETTINGS__INITIAL_HEAP_SIZE:
                setInitialHeapSize ( (String)newValue );
                return;
            case InfrastructurePackage.ORACLE_VM_SETTINGS__MAXIMUM_HEAP_SIZE:
                setMaximumHeapSize ( (String)newValue );
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
            case InfrastructurePackage.ORACLE_VM_SETTINGS__INITIAL_HEAP_SIZE:
                setInitialHeapSize ( INITIAL_HEAP_SIZE_EDEFAULT );
                return;
            case InfrastructurePackage.ORACLE_VM_SETTINGS__MAXIMUM_HEAP_SIZE:
                setMaximumHeapSize ( MAXIMUM_HEAP_SIZE_EDEFAULT );
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
            case InfrastructurePackage.ORACLE_VM_SETTINGS__INITIAL_HEAP_SIZE:
                return INITIAL_HEAP_SIZE_EDEFAULT == null ? initialHeapSize != null : !INITIAL_HEAP_SIZE_EDEFAULT.equals ( initialHeapSize );
            case InfrastructurePackage.ORACLE_VM_SETTINGS__MAXIMUM_HEAP_SIZE:
                return MAXIMUM_HEAP_SIZE_EDEFAULT == null ? maximumHeapSize != null : !MAXIMUM_HEAP_SIZE_EDEFAULT.equals ( maximumHeapSize );
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
        result.append ( " (initialHeapSize: " ); //$NON-NLS-1$
        result.append ( initialHeapSize );
        result.append ( ", maximumHeapSize: " ); //$NON-NLS-1$
        result.append ( maximumHeapSize );
        result.append ( ')' );
        return result.toString ();
    }

} //OracleVMSettingsImpl
