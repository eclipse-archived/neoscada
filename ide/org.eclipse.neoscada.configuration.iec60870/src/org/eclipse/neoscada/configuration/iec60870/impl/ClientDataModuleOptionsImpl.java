/**
 * Copyright (c) 2014, 2016 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 *
 */
package org.eclipse.neoscada.configuration.iec60870.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.neoscada.configuration.iec60870.ClientDataModuleOptions;
import org.eclipse.neoscada.configuration.iec60870.IEC60870Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '
 * <em><b>Client Data Module Options</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.ClientDataModuleOptionsImpl#isIgnoreBackgroundScan <em>Ignore Background Scan</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.ClientDataModuleOptionsImpl#isDelayStart <em>Delay Start</em>}</li>
 * </ul>
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
     * The default value of the '{@link #isDelayStart() <em>Delay Start</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDelayStart()
     * @generated
     * @ordered
     */
    protected static final boolean DELAY_START_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isDelayStart() <em>Delay Start</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDelayStart()
     * @generated
     * @ordered
     */
    protected boolean delayStart = DELAY_START_EDEFAULT;

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
    @Override
    public boolean isIgnoreBackgroundScan ()
    {
        return ignoreBackgroundScan;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
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
    public boolean isDelayStart ()
    {
        return delayStart;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDelayStart ( boolean newDelayStart )
    {
        boolean oldDelayStart = delayStart;
        delayStart = newDelayStart;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.CLIENT_DATA_MODULE_OPTIONS__DELAY_START, oldDelayStart, delayStart ) );
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
            case IEC60870Package.CLIENT_DATA_MODULE_OPTIONS__DELAY_START:
                return isDelayStart ();
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
            case IEC60870Package.CLIENT_DATA_MODULE_OPTIONS__DELAY_START:
                setDelayStart ( (Boolean)newValue );
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
            case IEC60870Package.CLIENT_DATA_MODULE_OPTIONS__DELAY_START:
                setDelayStart ( DELAY_START_EDEFAULT );
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
            case IEC60870Package.CLIENT_DATA_MODULE_OPTIONS__DELAY_START:
                return delayStart != DELAY_START_EDEFAULT;
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
        result.append ( ", delayStart: " ); //$NON-NLS-1$
        result.append ( delayStart );
        result.append ( ')' );
        return result.toString ();
    }

} //ClientDataModuleOptionsImpl
