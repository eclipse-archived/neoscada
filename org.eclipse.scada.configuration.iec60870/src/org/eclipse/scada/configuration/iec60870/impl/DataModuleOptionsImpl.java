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

import org.eclipse.scada.configuration.iec60870.DataModuleOptions;
import org.eclipse.scada.configuration.iec60870.IEC60870Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Module Options</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.iec60870.impl.DataModuleOptionsImpl#getBackgroundScanPeriod <em>Background Scan Period</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.iec60870.impl.DataModuleOptionsImpl#getSpontaneousItemBuffer <em>Spontaneous Item Buffer</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.iec60870.impl.DataModuleOptionsImpl#isTimestampsForBoolean <em>Timestamps For Boolean</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.iec60870.impl.DataModuleOptionsImpl#isTimestampsForFloat <em>Timestamps For Float</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataModuleOptionsImpl extends MinimalEObjectImpl.Container implements DataModuleOptions
{
    /**
     * The default value of the '{@link #getBackgroundScanPeriod() <em>Background Scan Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBackgroundScanPeriod()
     * @generated
     * @ordered
     */
    protected static final Integer BACKGROUND_SCAN_PERIOD_EDEFAULT = new Integer ( 60000 );

    /**
     * The cached value of the '{@link #getBackgroundScanPeriod() <em>Background Scan Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBackgroundScanPeriod()
     * @generated
     * @ordered
     */
    protected Integer backgroundScanPeriod = BACKGROUND_SCAN_PERIOD_EDEFAULT;

    /**
     * The default value of the '{@link #getSpontaneousItemBuffer() <em>Spontaneous Item Buffer</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSpontaneousItemBuffer()
     * @generated
     * @ordered
     */
    protected static final Integer SPONTANEOUS_ITEM_BUFFER_EDEFAULT = new Integer ( 100 );

    /**
     * The cached value of the '{@link #getSpontaneousItemBuffer() <em>Spontaneous Item Buffer</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSpontaneousItemBuffer()
     * @generated
     * @ordered
     */
    protected Integer spontaneousItemBuffer = SPONTANEOUS_ITEM_BUFFER_EDEFAULT;

    /**
     * The default value of the '{@link #isTimestampsForBoolean() <em>Timestamps For Boolean</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isTimestampsForBoolean()
     * @generated
     * @ordered
     */
    protected static final boolean TIMESTAMPS_FOR_BOOLEAN_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isTimestampsForBoolean() <em>Timestamps For Boolean</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isTimestampsForBoolean()
     * @generated
     * @ordered
     */
    protected boolean timestampsForBoolean = TIMESTAMPS_FOR_BOOLEAN_EDEFAULT;

    /**
     * The default value of the '{@link #isTimestampsForFloat() <em>Timestamps For Float</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isTimestampsForFloat()
     * @generated
     * @ordered
     */
    protected static final boolean TIMESTAMPS_FOR_FLOAT_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isTimestampsForFloat() <em>Timestamps For Float</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isTimestampsForFloat()
     * @generated
     * @ordered
     */
    protected boolean timestampsForFloat = TIMESTAMPS_FOR_FLOAT_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DataModuleOptionsImpl ()
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
        return IEC60870Package.Literals.DATA_MODULE_OPTIONS;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Integer getBackgroundScanPeriod ()
    {
        return backgroundScanPeriod;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBackgroundScanPeriod ( Integer newBackgroundScanPeriod )
    {
        Integer oldBackgroundScanPeriod = backgroundScanPeriod;
        backgroundScanPeriod = newBackgroundScanPeriod;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.DATA_MODULE_OPTIONS__BACKGROUND_SCAN_PERIOD, oldBackgroundScanPeriod, backgroundScanPeriod ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Integer getSpontaneousItemBuffer ()
    {
        return spontaneousItemBuffer;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSpontaneousItemBuffer ( Integer newSpontaneousItemBuffer )
    {
        Integer oldSpontaneousItemBuffer = spontaneousItemBuffer;
        spontaneousItemBuffer = newSpontaneousItemBuffer;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.DATA_MODULE_OPTIONS__SPONTANEOUS_ITEM_BUFFER, oldSpontaneousItemBuffer, spontaneousItemBuffer ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isTimestampsForBoolean ()
    {
        return timestampsForBoolean;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTimestampsForBoolean ( boolean newTimestampsForBoolean )
    {
        boolean oldTimestampsForBoolean = timestampsForBoolean;
        timestampsForBoolean = newTimestampsForBoolean;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.DATA_MODULE_OPTIONS__TIMESTAMPS_FOR_BOOLEAN, oldTimestampsForBoolean, timestampsForBoolean ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isTimestampsForFloat ()
    {
        return timestampsForFloat;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTimestampsForFloat ( boolean newTimestampsForFloat )
    {
        boolean oldTimestampsForFloat = timestampsForFloat;
        timestampsForFloat = newTimestampsForFloat;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.DATA_MODULE_OPTIONS__TIMESTAMPS_FOR_FLOAT, oldTimestampsForFloat, timestampsForFloat ) );
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
            case IEC60870Package.DATA_MODULE_OPTIONS__BACKGROUND_SCAN_PERIOD:
                return getBackgroundScanPeriod ();
            case IEC60870Package.DATA_MODULE_OPTIONS__SPONTANEOUS_ITEM_BUFFER:
                return getSpontaneousItemBuffer ();
            case IEC60870Package.DATA_MODULE_OPTIONS__TIMESTAMPS_FOR_BOOLEAN:
                return isTimestampsForBoolean ();
            case IEC60870Package.DATA_MODULE_OPTIONS__TIMESTAMPS_FOR_FLOAT:
                return isTimestampsForFloat ();
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
            case IEC60870Package.DATA_MODULE_OPTIONS__BACKGROUND_SCAN_PERIOD:
                setBackgroundScanPeriod ( (Integer)newValue );
                return;
            case IEC60870Package.DATA_MODULE_OPTIONS__SPONTANEOUS_ITEM_BUFFER:
                setSpontaneousItemBuffer ( (Integer)newValue );
                return;
            case IEC60870Package.DATA_MODULE_OPTIONS__TIMESTAMPS_FOR_BOOLEAN:
                setTimestampsForBoolean ( (Boolean)newValue );
                return;
            case IEC60870Package.DATA_MODULE_OPTIONS__TIMESTAMPS_FOR_FLOAT:
                setTimestampsForFloat ( (Boolean)newValue );
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
            case IEC60870Package.DATA_MODULE_OPTIONS__BACKGROUND_SCAN_PERIOD:
                setBackgroundScanPeriod ( BACKGROUND_SCAN_PERIOD_EDEFAULT );
                return;
            case IEC60870Package.DATA_MODULE_OPTIONS__SPONTANEOUS_ITEM_BUFFER:
                setSpontaneousItemBuffer ( SPONTANEOUS_ITEM_BUFFER_EDEFAULT );
                return;
            case IEC60870Package.DATA_MODULE_OPTIONS__TIMESTAMPS_FOR_BOOLEAN:
                setTimestampsForBoolean ( TIMESTAMPS_FOR_BOOLEAN_EDEFAULT );
                return;
            case IEC60870Package.DATA_MODULE_OPTIONS__TIMESTAMPS_FOR_FLOAT:
                setTimestampsForFloat ( TIMESTAMPS_FOR_FLOAT_EDEFAULT );
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
            case IEC60870Package.DATA_MODULE_OPTIONS__BACKGROUND_SCAN_PERIOD:
                return BACKGROUND_SCAN_PERIOD_EDEFAULT == null ? backgroundScanPeriod != null : !BACKGROUND_SCAN_PERIOD_EDEFAULT.equals ( backgroundScanPeriod );
            case IEC60870Package.DATA_MODULE_OPTIONS__SPONTANEOUS_ITEM_BUFFER:
                return SPONTANEOUS_ITEM_BUFFER_EDEFAULT == null ? spontaneousItemBuffer != null : !SPONTANEOUS_ITEM_BUFFER_EDEFAULT.equals ( spontaneousItemBuffer );
            case IEC60870Package.DATA_MODULE_OPTIONS__TIMESTAMPS_FOR_BOOLEAN:
                return timestampsForBoolean != TIMESTAMPS_FOR_BOOLEAN_EDEFAULT;
            case IEC60870Package.DATA_MODULE_OPTIONS__TIMESTAMPS_FOR_FLOAT:
                return timestampsForFloat != TIMESTAMPS_FOR_FLOAT_EDEFAULT;
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
        result.append ( " (backgroundScanPeriod: " ); //$NON-NLS-1$
        result.append ( backgroundScanPeriod );
        result.append ( ", spontaneousItemBuffer: " ); //$NON-NLS-1$
        result.append ( spontaneousItemBuffer );
        result.append ( ", timestampsForBoolean: " ); //$NON-NLS-1$
        result.append ( timestampsForBoolean );
        result.append ( ", timestampsForFloat: " ); //$NON-NLS-1$
        result.append ( timestampsForFloat );
        result.append ( ')' );
        return result.toString ();
    }

} //DataModuleOptionsImpl
