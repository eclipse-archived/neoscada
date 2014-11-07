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
package org.eclipse.scada.configuration.setup.common.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.scada.configuration.setup.common.CommonPackage;
import org.eclipse.scada.configuration.setup.common.Parity;
import org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Serial To Network Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.setup.common.impl.SerialToNetworkMappingImpl#getDevice <em>Device</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.setup.common.impl.SerialToNetworkMappingImpl#getTcpPort <em>Tcp Port</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.setup.common.impl.SerialToNetworkMappingImpl#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.setup.common.impl.SerialToNetworkMappingImpl#getBaudRate <em>Baud Rate</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.setup.common.impl.SerialToNetworkMappingImpl#getParity <em>Parity</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.setup.common.impl.SerialToNetworkMappingImpl#isXonxoff <em>Xonxoff</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.setup.common.impl.SerialToNetworkMappingImpl#isRtscts <em>Rtscts</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.setup.common.impl.SerialToNetworkMappingImpl#getDataBits <em>Data Bits</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.setup.common.impl.SerialToNetworkMappingImpl#getStopBits <em>Stop Bits</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.setup.common.impl.SerialToNetworkMappingImpl#isModemControl <em>Modem Control</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.setup.common.impl.SerialToNetworkMappingImpl#isBreak <em>Break</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SerialToNetworkMappingImpl extends MinimalEObjectImpl.Container implements SerialToNetworkMapping
{
    /**
     * The default value of the '{@link #getDevice() <em>Device</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDevice()
     * @generated
     * @ordered
     */
    protected static final String DEVICE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDevice() <em>Device</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDevice()
     * @generated
     * @ordered
     */
    protected String device = DEVICE_EDEFAULT;

    /**
     * The default value of the '{@link #getTcpPort() <em>Tcp Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTcpPort()
     * @generated
     * @ordered
     */
    protected static final int TCP_PORT_EDEFAULT = 2000;

    /**
     * The cached value of the '{@link #getTcpPort() <em>Tcp Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTcpPort()
     * @generated
     * @ordered
     */
    protected int tcpPort = TCP_PORT_EDEFAULT;

    /**
     * The default value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTimeout()
     * @generated
     * @ordered
     */
    protected static final int TIMEOUT_EDEFAULT = 30;

    /**
     * The cached value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTimeout()
     * @generated
     * @ordered
     */
    protected int timeout = TIMEOUT_EDEFAULT;

    /**
     * The default value of the '{@link #getBaudRate() <em>Baud Rate</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBaudRate()
     * @generated
     * @ordered
     */
    protected static final int BAUD_RATE_EDEFAULT = 9600;

    /**
     * The cached value of the '{@link #getBaudRate() <em>Baud Rate</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBaudRate()
     * @generated
     * @ordered
     */
    protected int baudRate = BAUD_RATE_EDEFAULT;

    /**
     * The default value of the '{@link #getParity() <em>Parity</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getParity()
     * @generated
     * @ordered
     */
    protected static final Parity PARITY_EDEFAULT = Parity.NONE;

    /**
     * The cached value of the '{@link #getParity() <em>Parity</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getParity()
     * @generated
     * @ordered
     */
    protected Parity parity = PARITY_EDEFAULT;

    /**
     * The default value of the '{@link #isXonxoff() <em>Xonxoff</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isXonxoff()
     * @generated
     * @ordered
     */
    protected static final boolean XONXOFF_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isXonxoff() <em>Xonxoff</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isXonxoff()
     * @generated
     * @ordered
     */
    protected boolean xonxoff = XONXOFF_EDEFAULT;

    /**
     * The default value of the '{@link #isRtscts() <em>Rtscts</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isRtscts()
     * @generated
     * @ordered
     */
    protected static final boolean RTSCTS_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isRtscts() <em>Rtscts</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isRtscts()
     * @generated
     * @ordered
     */
    protected boolean rtscts = RTSCTS_EDEFAULT;

    /**
     * The default value of the '{@link #getDataBits() <em>Data Bits</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataBits()
     * @generated
     * @ordered
     */
    protected static final short DATA_BITS_EDEFAULT = 8;

    /**
     * The cached value of the '{@link #getDataBits() <em>Data Bits</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataBits()
     * @generated
     * @ordered
     */
    protected short dataBits = DATA_BITS_EDEFAULT;

    /**
     * The default value of the '{@link #getStopBits() <em>Stop Bits</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStopBits()
     * @generated
     * @ordered
     */
    protected static final short STOP_BITS_EDEFAULT = 1;

    /**
     * The cached value of the '{@link #getStopBits() <em>Stop Bits</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getStopBits()
     * @generated
     * @ordered
     */
    protected short stopBits = STOP_BITS_EDEFAULT;

    /**
     * The default value of the '{@link #isModemControl() <em>Modem Control</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isModemControl()
     * @generated
     * @ordered
     */
    protected static final boolean MODEM_CONTROL_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isModemControl() <em>Modem Control</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isModemControl()
     * @generated
     * @ordered
     */
    protected boolean modemControl = MODEM_CONTROL_EDEFAULT;

    /**
     * The default value of the '{@link #isBreak() <em>Break</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isBreak()
     * @generated
     * @ordered
     */
    protected static final boolean BREAK_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isBreak() <em>Break</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isBreak()
     * @generated
     * @ordered
     */
    protected boolean break_ = BREAK_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SerialToNetworkMappingImpl ()
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
        return CommonPackage.Literals.SERIAL_TO_NETWORK_MAPPING;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDevice ()
    {
        return device;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDevice ( String newDevice )
    {
        String oldDevice = device;
        device = newDevice;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, CommonPackage.SERIAL_TO_NETWORK_MAPPING__DEVICE, oldDevice, device ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getTcpPort ()
    {
        return tcpPort;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTcpPort ( int newTcpPort )
    {
        int oldTcpPort = tcpPort;
        tcpPort = newTcpPort;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, CommonPackage.SERIAL_TO_NETWORK_MAPPING__TCP_PORT, oldTcpPort, tcpPort ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getTimeout ()
    {
        return timeout;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTimeout ( int newTimeout )
    {
        int oldTimeout = timeout;
        timeout = newTimeout;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, CommonPackage.SERIAL_TO_NETWORK_MAPPING__TIMEOUT, oldTimeout, timeout ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getBaudRate ()
    {
        return baudRate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBaudRate ( int newBaudRate )
    {
        int oldBaudRate = baudRate;
        baudRate = newBaudRate;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, CommonPackage.SERIAL_TO_NETWORK_MAPPING__BAUD_RATE, oldBaudRate, baudRate ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Parity getParity ()
    {
        return parity;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParity ( Parity newParity )
    {
        Parity oldParity = parity;
        parity = newParity == null ? PARITY_EDEFAULT : newParity;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, CommonPackage.SERIAL_TO_NETWORK_MAPPING__PARITY, oldParity, parity ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isXonxoff ()
    {
        return xonxoff;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setXonxoff ( boolean newXonxoff )
    {
        boolean oldXonxoff = xonxoff;
        xonxoff = newXonxoff;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, CommonPackage.SERIAL_TO_NETWORK_MAPPING__XONXOFF, oldXonxoff, xonxoff ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isRtscts ()
    {
        return rtscts;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRtscts ( boolean newRtscts )
    {
        boolean oldRtscts = rtscts;
        rtscts = newRtscts;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, CommonPackage.SERIAL_TO_NETWORK_MAPPING__RTSCTS, oldRtscts, rtscts ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public short getDataBits ()
    {
        return dataBits;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDataBits ( short newDataBits )
    {
        short oldDataBits = dataBits;
        dataBits = newDataBits;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, CommonPackage.SERIAL_TO_NETWORK_MAPPING__DATA_BITS, oldDataBits, dataBits ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public short getStopBits ()
    {
        return stopBits;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setStopBits ( short newStopBits )
    {
        short oldStopBits = stopBits;
        stopBits = newStopBits;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, CommonPackage.SERIAL_TO_NETWORK_MAPPING__STOP_BITS, oldStopBits, stopBits ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isModemControl ()
    {
        return modemControl;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setModemControl ( boolean newModemControl )
    {
        boolean oldModemControl = modemControl;
        modemControl = newModemControl;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, CommonPackage.SERIAL_TO_NETWORK_MAPPING__MODEM_CONTROL, oldModemControl, modemControl ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isBreak ()
    {
        return break_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBreak ( boolean newBreak )
    {
        boolean oldBreak = break_;
        break_ = newBreak;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, CommonPackage.SERIAL_TO_NETWORK_MAPPING__BREAK, oldBreak, break_ ) );
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
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__DEVICE:
                return getDevice ();
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__TCP_PORT:
                return getTcpPort ();
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__TIMEOUT:
                return getTimeout ();
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__BAUD_RATE:
                return getBaudRate ();
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__PARITY:
                return getParity ();
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__XONXOFF:
                return isXonxoff ();
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__RTSCTS:
                return isRtscts ();
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__DATA_BITS:
                return getDataBits ();
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__STOP_BITS:
                return getStopBits ();
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__MODEM_CONTROL:
                return isModemControl ();
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__BREAK:
                return isBreak ();
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
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__DEVICE:
                setDevice ( (String)newValue );
                return;
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__TCP_PORT:
                setTcpPort ( (Integer)newValue );
                return;
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__TIMEOUT:
                setTimeout ( (Integer)newValue );
                return;
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__BAUD_RATE:
                setBaudRate ( (Integer)newValue );
                return;
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__PARITY:
                setParity ( (Parity)newValue );
                return;
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__XONXOFF:
                setXonxoff ( (Boolean)newValue );
                return;
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__RTSCTS:
                setRtscts ( (Boolean)newValue );
                return;
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__DATA_BITS:
                setDataBits ( (Short)newValue );
                return;
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__STOP_BITS:
                setStopBits ( (Short)newValue );
                return;
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__MODEM_CONTROL:
                setModemControl ( (Boolean)newValue );
                return;
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__BREAK:
                setBreak ( (Boolean)newValue );
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
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__DEVICE:
                setDevice ( DEVICE_EDEFAULT );
                return;
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__TCP_PORT:
                setTcpPort ( TCP_PORT_EDEFAULT );
                return;
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__TIMEOUT:
                setTimeout ( TIMEOUT_EDEFAULT );
                return;
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__BAUD_RATE:
                setBaudRate ( BAUD_RATE_EDEFAULT );
                return;
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__PARITY:
                setParity ( PARITY_EDEFAULT );
                return;
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__XONXOFF:
                setXonxoff ( XONXOFF_EDEFAULT );
                return;
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__RTSCTS:
                setRtscts ( RTSCTS_EDEFAULT );
                return;
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__DATA_BITS:
                setDataBits ( DATA_BITS_EDEFAULT );
                return;
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__STOP_BITS:
                setStopBits ( STOP_BITS_EDEFAULT );
                return;
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__MODEM_CONTROL:
                setModemControl ( MODEM_CONTROL_EDEFAULT );
                return;
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__BREAK:
                setBreak ( BREAK_EDEFAULT );
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
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__DEVICE:
                return DEVICE_EDEFAULT == null ? device != null : !DEVICE_EDEFAULT.equals ( device );
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__TCP_PORT:
                return tcpPort != TCP_PORT_EDEFAULT;
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__TIMEOUT:
                return timeout != TIMEOUT_EDEFAULT;
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__BAUD_RATE:
                return baudRate != BAUD_RATE_EDEFAULT;
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__PARITY:
                return parity != PARITY_EDEFAULT;
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__XONXOFF:
                return xonxoff != XONXOFF_EDEFAULT;
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__RTSCTS:
                return rtscts != RTSCTS_EDEFAULT;
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__DATA_BITS:
                return dataBits != DATA_BITS_EDEFAULT;
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__STOP_BITS:
                return stopBits != STOP_BITS_EDEFAULT;
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__MODEM_CONTROL:
                return modemControl != MODEM_CONTROL_EDEFAULT;
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING__BREAK:
                return break_ != BREAK_EDEFAULT;
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
        result.append ( " (device: " ); //$NON-NLS-1$
        result.append ( device );
        result.append ( ", tcpPort: " ); //$NON-NLS-1$
        result.append ( tcpPort );
        result.append ( ", timeout: " ); //$NON-NLS-1$
        result.append ( timeout );
        result.append ( ", baudRate: " ); //$NON-NLS-1$
        result.append ( baudRate );
        result.append ( ", parity: " ); //$NON-NLS-1$
        result.append ( parity );
        result.append ( ", xonxoff: " ); //$NON-NLS-1$
        result.append ( xonxoff );
        result.append ( ", rtscts: " ); //$NON-NLS-1$
        result.append ( rtscts );
        result.append ( ", dataBits: " ); //$NON-NLS-1$
        result.append ( dataBits );
        result.append ( ", stopBits: " ); //$NON-NLS-1$
        result.append ( stopBits );
        result.append ( ", modemControl: " ); //$NON-NLS-1$
        result.append ( modemControl );
        result.append ( ", break: " ); //$NON-NLS-1$
        result.append ( break_ );
        result.append ( ')' );
        return result.toString ();
    }

} //SerialToNetworkMappingImpl
