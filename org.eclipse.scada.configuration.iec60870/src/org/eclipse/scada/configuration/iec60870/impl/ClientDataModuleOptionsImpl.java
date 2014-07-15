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
package org.eclipse.scada.configuration.iec60870.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.scada.configuration.iec60870.ClientDataModuleOptions;
import org.eclipse.scada.configuration.iec60870.IEC60870Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Client Data Module Options</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.iec60870.impl.ClientDataModuleOptionsImpl#isIgnoreBackgroundScan <em>Ignore Background Scan</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClientDataModuleOptionsImpl extends MinimalEObjectImpl.Container implements ClientDataModuleOptions
{
    /**
     * The default value of the '{@link #isIgnoreBackgroundScan() <em>Ignore Background Scan</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIgnoreBackgroundScan()
     * @generated
     * @ordered
     */
    protected static final boolean IGNORE_BACKGROUND_SCAN_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isIgnoreBackgroundScan() <em>Ignore Background Scan</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIgnoreBackgroundScan()
     * @generated
     * @ordered
     */
    protected boolean ignoreBackgroundScan = IGNORE_BACKGROUND_SCAN_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ClientDataModuleOptionsImpl ()
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
        return IEC60870Package.Literals.CLIENT_DATA_MODULE_OPTIONS;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isIgnoreBackgroundScan ()
    {
        return ignoreBackgroundScan;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIgnoreBackgroundScan ( boolean newIgnoreBackgroundScan )
    {
        boolean oldIgnoreBackgroundScan = ignoreBackgroundScan;
        ignoreBackgroundScan = newIgnoreBackgroundScan;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.CLIENT_DATA_MODULE_OPTIONS__IGNORE_BACKGROUND_SCAN, oldIgnoreBackgroundScan, ignoreBackgroundScan ) );
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
            case IEC60870Package.CLIENT_DATA_MODULE_OPTIONS__IGNORE_BACKGROUND_SCAN:
                return isIgnoreBackgroundScan ();
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
            case IEC60870Package.CLIENT_DATA_MODULE_OPTIONS__IGNORE_BACKGROUND_SCAN:
                setIgnoreBackgroundScan ( (Boolean)newValue );
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
            case IEC60870Package.CLIENT_DATA_MODULE_OPTIONS__IGNORE_BACKGROUND_SCAN:
                setIgnoreBackgroundScan ( IGNORE_BACKGROUND_SCAN_EDEFAULT );
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
            case IEC60870Package.CLIENT_DATA_MODULE_OPTIONS__IGNORE_BACKGROUND_SCAN:
                return ignoreBackgroundScan != IGNORE_BACKGROUND_SCAN_EDEFAULT;
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
        result.append ( " (ignoreBackgroundScan: " ); //$NON-NLS-1$
        result.append ( ignoreBackgroundScan );
        result.append ( ')' );
        return result.toString ();
    }

} //ClientDataModuleOptionsImpl
