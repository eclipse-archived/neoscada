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
import org.eclipse.neoscada.configuration.iec60870.IEC60870Package;
import org.eclipse.neoscada.configuration.iec60870.ProtocolOptions;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Protocol Options</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.ProtocolOptionsImpl#getTimeout1 <em>Timeout1</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.ProtocolOptionsImpl#getTimeout2 <em>Timeout2</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.ProtocolOptionsImpl#getTimeout3 <em>Timeout3</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.ProtocolOptionsImpl#getAsduAddressSize <em>Asdu Address Size</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.ProtocolOptionsImpl#getInformationObjectAddressSize <em>Information Object Address Size</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.ProtocolOptionsImpl#getCauseOfTransmissionSize <em>Cause Of Transmission Size</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.ProtocolOptionsImpl#getW <em>W</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.ProtocolOptionsImpl#getK <em>K</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.ProtocolOptionsImpl#getTargetTimeZone <em>Target Time Zone</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.impl.ProtocolOptionsImpl#isIgnoreDaylightSavingTime <em>Ignore Daylight Saving Time</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProtocolOptionsImpl extends MinimalEObjectImpl.Container implements ProtocolOptions
{
    /**
     * The default value of the '{@link #getTimeout1() <em>Timeout1</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTimeout1()
     * @generated
     * @ordered
     */
    protected static final int TIMEOUT1_EDEFAULT = 15000;

    /**
     * The cached value of the '{@link #getTimeout1() <em>Timeout1</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTimeout1()
     * @generated
     * @ordered
     */
    protected int timeout1 = TIMEOUT1_EDEFAULT;

    /**
     * The default value of the '{@link #getTimeout2() <em>Timeout2</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTimeout2()
     * @generated
     * @ordered
     */
    protected static final int TIMEOUT2_EDEFAULT = 10000;

    /**
     * The cached value of the '{@link #getTimeout2() <em>Timeout2</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTimeout2()
     * @generated
     * @ordered
     */
    protected int timeout2 = TIMEOUT2_EDEFAULT;

    /**
     * The default value of the '{@link #getTimeout3() <em>Timeout3</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTimeout3()
     * @generated
     * @ordered
     */
    protected static final int TIMEOUT3_EDEFAULT = 20000;

    /**
     * The cached value of the '{@link #getTimeout3() <em>Timeout3</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTimeout3()
     * @generated
     * @ordered
     */
    protected int timeout3 = TIMEOUT3_EDEFAULT;

    /**
     * The default value of the '{@link #getAsduAddressSize() <em>Asdu Address Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAsduAddressSize()
     * @generated
     * @ordered
     */
    protected static final byte ASDU_ADDRESS_SIZE_EDEFAULT = 0x02;

    /**
     * The cached value of the '{@link #getAsduAddressSize() <em>Asdu Address Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAsduAddressSize()
     * @generated
     * @ordered
     */
    protected byte asduAddressSize = ASDU_ADDRESS_SIZE_EDEFAULT;

    /**
     * The default value of the '{@link #getInformationObjectAddressSize() <em>Information Object Address Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInformationObjectAddressSize()
     * @generated
     * @ordered
     */
    protected static final byte INFORMATION_OBJECT_ADDRESS_SIZE_EDEFAULT = 0x03;

    /**
     * The cached value of the '{@link #getInformationObjectAddressSize() <em>Information Object Address Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInformationObjectAddressSize()
     * @generated
     * @ordered
     */
    protected byte informationObjectAddressSize = INFORMATION_OBJECT_ADDRESS_SIZE_EDEFAULT;

    /**
     * The default value of the '{@link #getCauseOfTransmissionSize() <em>Cause Of Transmission Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCauseOfTransmissionSize()
     * @generated
     * @ordered
     */
    protected static final byte CAUSE_OF_TRANSMISSION_SIZE_EDEFAULT = 0x02;

    /**
     * The cached value of the '{@link #getCauseOfTransmissionSize() <em>Cause Of Transmission Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCauseOfTransmissionSize()
     * @generated
     * @ordered
     */
    protected byte causeOfTransmissionSize = CAUSE_OF_TRANSMISSION_SIZE_EDEFAULT;

    /**
     * The default value of the '{@link #getW() <em>W</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getW()
     * @generated
     * @ordered
     */
    protected static final int W_EDEFAULT = 10;

    /**
     * The cached value of the '{@link #getW() <em>W</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getW()
     * @generated
     * @ordered
     */
    protected int w = W_EDEFAULT;

    /**
     * The default value of the '{@link #getK() <em>K</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getK()
     * @generated
     * @ordered
     */
    protected static final int K_EDEFAULT = 15;

    /**
     * The cached value of the '{@link #getK() <em>K</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getK()
     * @generated
     * @ordered
     */
    protected int k = K_EDEFAULT;

    /**
     * The default value of the '{@link #getTargetTimeZone() <em>Target Time Zone</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTargetTimeZone()
     * @generated
     * @ordered
     */
    protected static final String TARGET_TIME_ZONE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getTargetTimeZone() <em>Target Time Zone</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTargetTimeZone()
     * @generated
     * @ordered
     */
    protected String targetTimeZone = TARGET_TIME_ZONE_EDEFAULT;

    /**
     * The default value of the '{@link #isIgnoreDaylightSavingTime() <em>Ignore Daylight Saving Time</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIgnoreDaylightSavingTime()
     * @generated
     * @ordered
     */
    protected static final boolean IGNORE_DAYLIGHT_SAVING_TIME_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isIgnoreDaylightSavingTime() <em>Ignore Daylight Saving Time</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIgnoreDaylightSavingTime()
     * @generated
     * @ordered
     */
    protected boolean ignoreDaylightSavingTime = IGNORE_DAYLIGHT_SAVING_TIME_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ProtocolOptionsImpl ()
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
        return IEC60870Package.Literals.PROTOCOL_OPTIONS;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int getTimeout1 ()
    {
        return timeout1;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setTimeout1 ( int newTimeout1 )
    {
        int oldTimeout1 = timeout1;
        timeout1 = newTimeout1;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.PROTOCOL_OPTIONS__TIMEOUT1, oldTimeout1, timeout1 ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int getTimeout2 ()
    {
        return timeout2;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setTimeout2 ( int newTimeout2 )
    {
        int oldTimeout2 = timeout2;
        timeout2 = newTimeout2;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.PROTOCOL_OPTIONS__TIMEOUT2, oldTimeout2, timeout2 ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int getTimeout3 ()
    {
        return timeout3;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setTimeout3 ( int newTimeout3 )
    {
        int oldTimeout3 = timeout3;
        timeout3 = newTimeout3;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.PROTOCOL_OPTIONS__TIMEOUT3, oldTimeout3, timeout3 ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public byte getAsduAddressSize ()
    {
        return asduAddressSize;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setAsduAddressSize ( byte newAsduAddressSize )
    {
        byte oldAsduAddressSize = asduAddressSize;
        asduAddressSize = newAsduAddressSize;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.PROTOCOL_OPTIONS__ASDU_ADDRESS_SIZE, oldAsduAddressSize, asduAddressSize ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public byte getInformationObjectAddressSize ()
    {
        return informationObjectAddressSize;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setInformationObjectAddressSize ( byte newInformationObjectAddressSize )
    {
        byte oldInformationObjectAddressSize = informationObjectAddressSize;
        informationObjectAddressSize = newInformationObjectAddressSize;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.PROTOCOL_OPTIONS__INFORMATION_OBJECT_ADDRESS_SIZE, oldInformationObjectAddressSize, informationObjectAddressSize ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public byte getCauseOfTransmissionSize ()
    {
        return causeOfTransmissionSize;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setCauseOfTransmissionSize ( byte newCauseOfTransmissionSize )
    {
        byte oldCauseOfTransmissionSize = causeOfTransmissionSize;
        causeOfTransmissionSize = newCauseOfTransmissionSize;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.PROTOCOL_OPTIONS__CAUSE_OF_TRANSMISSION_SIZE, oldCauseOfTransmissionSize, causeOfTransmissionSize ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int getW ()
    {
        return w;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setW ( int newW )
    {
        int oldW = w;
        w = newW;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.PROTOCOL_OPTIONS__W, oldW, w ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int getK ()
    {
        return k;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setK ( int newK )
    {
        int oldK = k;
        k = newK;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.PROTOCOL_OPTIONS__K, oldK, k ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getTargetTimeZone ()
    {
        return targetTimeZone;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setTargetTimeZone ( String newTargetTimeZone )
    {
        String oldTargetTimeZone = targetTimeZone;
        targetTimeZone = newTargetTimeZone;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.PROTOCOL_OPTIONS__TARGET_TIME_ZONE, oldTargetTimeZone, targetTimeZone ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isIgnoreDaylightSavingTime ()
    {
        return ignoreDaylightSavingTime;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setIgnoreDaylightSavingTime ( boolean newIgnoreDaylightSavingTime )
    {
        boolean oldIgnoreDaylightSavingTime = ignoreDaylightSavingTime;
        ignoreDaylightSavingTime = newIgnoreDaylightSavingTime;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.PROTOCOL_OPTIONS__IGNORE_DAYLIGHT_SAVING_TIME, oldIgnoreDaylightSavingTime, ignoreDaylightSavingTime ) );
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
            case IEC60870Package.PROTOCOL_OPTIONS__TIMEOUT1:
                return getTimeout1 ();
            case IEC60870Package.PROTOCOL_OPTIONS__TIMEOUT2:
                return getTimeout2 ();
            case IEC60870Package.PROTOCOL_OPTIONS__TIMEOUT3:
                return getTimeout3 ();
            case IEC60870Package.PROTOCOL_OPTIONS__ASDU_ADDRESS_SIZE:
                return getAsduAddressSize ();
            case IEC60870Package.PROTOCOL_OPTIONS__INFORMATION_OBJECT_ADDRESS_SIZE:
                return getInformationObjectAddressSize ();
            case IEC60870Package.PROTOCOL_OPTIONS__CAUSE_OF_TRANSMISSION_SIZE:
                return getCauseOfTransmissionSize ();
            case IEC60870Package.PROTOCOL_OPTIONS__W:
                return getW ();
            case IEC60870Package.PROTOCOL_OPTIONS__K:
                return getK ();
            case IEC60870Package.PROTOCOL_OPTIONS__TARGET_TIME_ZONE:
                return getTargetTimeZone ();
            case IEC60870Package.PROTOCOL_OPTIONS__IGNORE_DAYLIGHT_SAVING_TIME:
                return isIgnoreDaylightSavingTime ();
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
            case IEC60870Package.PROTOCOL_OPTIONS__TIMEOUT1:
                setTimeout1 ( (Integer)newValue );
                return;
            case IEC60870Package.PROTOCOL_OPTIONS__TIMEOUT2:
                setTimeout2 ( (Integer)newValue );
                return;
            case IEC60870Package.PROTOCOL_OPTIONS__TIMEOUT3:
                setTimeout3 ( (Integer)newValue );
                return;
            case IEC60870Package.PROTOCOL_OPTIONS__ASDU_ADDRESS_SIZE:
                setAsduAddressSize ( (Byte)newValue );
                return;
            case IEC60870Package.PROTOCOL_OPTIONS__INFORMATION_OBJECT_ADDRESS_SIZE:
                setInformationObjectAddressSize ( (Byte)newValue );
                return;
            case IEC60870Package.PROTOCOL_OPTIONS__CAUSE_OF_TRANSMISSION_SIZE:
                setCauseOfTransmissionSize ( (Byte)newValue );
                return;
            case IEC60870Package.PROTOCOL_OPTIONS__W:
                setW ( (Integer)newValue );
                return;
            case IEC60870Package.PROTOCOL_OPTIONS__K:
                setK ( (Integer)newValue );
                return;
            case IEC60870Package.PROTOCOL_OPTIONS__TARGET_TIME_ZONE:
                setTargetTimeZone ( (String)newValue );
                return;
            case IEC60870Package.PROTOCOL_OPTIONS__IGNORE_DAYLIGHT_SAVING_TIME:
                setIgnoreDaylightSavingTime ( (Boolean)newValue );
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
            case IEC60870Package.PROTOCOL_OPTIONS__TIMEOUT1:
                setTimeout1 ( TIMEOUT1_EDEFAULT );
                return;
            case IEC60870Package.PROTOCOL_OPTIONS__TIMEOUT2:
                setTimeout2 ( TIMEOUT2_EDEFAULT );
                return;
            case IEC60870Package.PROTOCOL_OPTIONS__TIMEOUT3:
                setTimeout3 ( TIMEOUT3_EDEFAULT );
                return;
            case IEC60870Package.PROTOCOL_OPTIONS__ASDU_ADDRESS_SIZE:
                setAsduAddressSize ( ASDU_ADDRESS_SIZE_EDEFAULT );
                return;
            case IEC60870Package.PROTOCOL_OPTIONS__INFORMATION_OBJECT_ADDRESS_SIZE:
                setInformationObjectAddressSize ( INFORMATION_OBJECT_ADDRESS_SIZE_EDEFAULT );
                return;
            case IEC60870Package.PROTOCOL_OPTIONS__CAUSE_OF_TRANSMISSION_SIZE:
                setCauseOfTransmissionSize ( CAUSE_OF_TRANSMISSION_SIZE_EDEFAULT );
                return;
            case IEC60870Package.PROTOCOL_OPTIONS__W:
                setW ( W_EDEFAULT );
                return;
            case IEC60870Package.PROTOCOL_OPTIONS__K:
                setK ( K_EDEFAULT );
                return;
            case IEC60870Package.PROTOCOL_OPTIONS__TARGET_TIME_ZONE:
                setTargetTimeZone ( TARGET_TIME_ZONE_EDEFAULT );
                return;
            case IEC60870Package.PROTOCOL_OPTIONS__IGNORE_DAYLIGHT_SAVING_TIME:
                setIgnoreDaylightSavingTime ( IGNORE_DAYLIGHT_SAVING_TIME_EDEFAULT );
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
            case IEC60870Package.PROTOCOL_OPTIONS__TIMEOUT1:
                return timeout1 != TIMEOUT1_EDEFAULT;
            case IEC60870Package.PROTOCOL_OPTIONS__TIMEOUT2:
                return timeout2 != TIMEOUT2_EDEFAULT;
            case IEC60870Package.PROTOCOL_OPTIONS__TIMEOUT3:
                return timeout3 != TIMEOUT3_EDEFAULT;
            case IEC60870Package.PROTOCOL_OPTIONS__ASDU_ADDRESS_SIZE:
                return asduAddressSize != ASDU_ADDRESS_SIZE_EDEFAULT;
            case IEC60870Package.PROTOCOL_OPTIONS__INFORMATION_OBJECT_ADDRESS_SIZE:
                return informationObjectAddressSize != INFORMATION_OBJECT_ADDRESS_SIZE_EDEFAULT;
            case IEC60870Package.PROTOCOL_OPTIONS__CAUSE_OF_TRANSMISSION_SIZE:
                return causeOfTransmissionSize != CAUSE_OF_TRANSMISSION_SIZE_EDEFAULT;
            case IEC60870Package.PROTOCOL_OPTIONS__W:
                return w != W_EDEFAULT;
            case IEC60870Package.PROTOCOL_OPTIONS__K:
                return k != K_EDEFAULT;
            case IEC60870Package.PROTOCOL_OPTIONS__TARGET_TIME_ZONE:
                return TARGET_TIME_ZONE_EDEFAULT == null ? targetTimeZone != null : !TARGET_TIME_ZONE_EDEFAULT.equals ( targetTimeZone );
            case IEC60870Package.PROTOCOL_OPTIONS__IGNORE_DAYLIGHT_SAVING_TIME:
                return ignoreDaylightSavingTime != IGNORE_DAYLIGHT_SAVING_TIME_EDEFAULT;
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
        result.append ( " (timeout1: " ); //$NON-NLS-1$
        result.append ( timeout1 );
        result.append ( ", timeout2: " ); //$NON-NLS-1$
        result.append ( timeout2 );
        result.append ( ", timeout3: " ); //$NON-NLS-1$
        result.append ( timeout3 );
        result.append ( ", asduAddressSize: " ); //$NON-NLS-1$
        result.append ( asduAddressSize );
        result.append ( ", informationObjectAddressSize: " ); //$NON-NLS-1$
        result.append ( informationObjectAddressSize );
        result.append ( ", causeOfTransmissionSize: " ); //$NON-NLS-1$
        result.append ( causeOfTransmissionSize );
        result.append ( ", w: " ); //$NON-NLS-1$
        result.append ( w );
        result.append ( ", k: " ); //$NON-NLS-1$
        result.append ( k );
        result.append ( ", targetTimeZone: " ); //$NON-NLS-1$
        result.append ( targetTimeZone );
        result.append ( ", ignoreDaylightSavingTime: " ); //$NON-NLS-1$
        result.append ( ignoreDaylightSavingTime );
        result.append ( ')' );
        return result.toString ();
    }

} //ProtocolOptionsImpl
