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
package org.eclipse.scada.configuration.component.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.DriverConnectionAnalyzer;
import org.eclipse.scada.configuration.infrastructure.Driver;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Driver Connection Analyzer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.DriverConnectionAnalyzerImpl#getDriver <em>Driver</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DriverConnectionAnalyzerImpl extends MasterComponentImpl implements DriverConnectionAnalyzer
{
    /**
     * The cached value of the '{@link #getDriver() <em>Driver</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDriver()
     * @generated
     * @ordered
     */
    protected Driver driver;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DriverConnectionAnalyzerImpl ()
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
        return ComponentPackage.Literals.DRIVER_CONNECTION_ANALYZER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Driver getDriver ()
    {
        if ( driver != null && driver.eIsProxy () )
        {
            InternalEObject oldDriver = (InternalEObject)driver;
            driver = (Driver)eResolveProxy ( oldDriver );
            if ( driver != oldDriver )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.DRIVER_CONNECTION_ANALYZER__DRIVER, oldDriver, driver ) );
            }
        }
        return driver;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Driver basicGetDriver ()
    {
        return driver;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDriver ( Driver newDriver )
    {
        Driver oldDriver = driver;
        driver = newDriver;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.DRIVER_CONNECTION_ANALYZER__DRIVER, oldDriver, driver ) );
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
            case ComponentPackage.DRIVER_CONNECTION_ANALYZER__DRIVER:
                if ( resolve )
                    return getDriver ();
                return basicGetDriver ();
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
            case ComponentPackage.DRIVER_CONNECTION_ANALYZER__DRIVER:
                setDriver ( (Driver)newValue );
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
            case ComponentPackage.DRIVER_CONNECTION_ANALYZER__DRIVER:
                setDriver ( (Driver)null );
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
            case ComponentPackage.DRIVER_CONNECTION_ANALYZER__DRIVER:
                return driver != null;
        }
        return super.eIsSet ( featureID );
    }

} //DriverConnectionAnalyzerImpl
