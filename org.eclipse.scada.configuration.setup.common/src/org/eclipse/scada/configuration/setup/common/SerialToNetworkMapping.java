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
package org.eclipse.scada.configuration.setup.common;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Serial To Network Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#getDevice <em>Device</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#getTcpPort <em>Tcp Port</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#getBaudRate <em>Baud Rate</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#getParity <em>Parity</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#isXonxoff <em>Xonxoff</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#isRtscts <em>Rtscts</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#getDataBits <em>Data Bits</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#getStopBits <em>Stop Bits</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#isModemControl <em>Modem Control</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#isBreak <em>Break</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.setup.common.CommonPackage#getSerialToNetworkMapping()
 * @model
 * @generated
 */
public interface SerialToNetworkMapping extends EObject
{
    /**
     * Returns the value of the '<em><b>Device</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Device</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Device</em>' attribute.
     * @see #setDevice(String)
     * @see org.eclipse.scada.configuration.setup.common.CommonPackage#getSerialToNetworkMapping_Device()
     * @model required="true"
     * @generated
     */
    String getDevice ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#getDevice <em>Device</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Device</em>' attribute.
     * @see #getDevice()
     * @generated
     */
    void setDevice ( String value );

    /**
     * Returns the value of the '<em><b>Tcp Port</b></em>' attribute.
     * The default value is <code>"2000"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Tcp Port</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Tcp Port</em>' attribute.
     * @see #setTcpPort(int)
     * @see org.eclipse.scada.configuration.setup.common.CommonPackage#getSerialToNetworkMapping_TcpPort()
     * @model default="2000" required="true"
     * @generated
     */
    int getTcpPort ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#getTcpPort <em>Tcp Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Tcp Port</em>' attribute.
     * @see #getTcpPort()
     * @generated
     */
    void setTcpPort ( int value );

    /**
     * Returns the value of the '<em><b>Timeout</b></em>' attribute.
     * The default value is <code>"30"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Timeout</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Timeout</em>' attribute.
     * @see #setTimeout(int)
     * @see org.eclipse.scada.configuration.setup.common.CommonPackage#getSerialToNetworkMapping_Timeout()
     * @model default="30" required="true"
     * @generated
     */
    int getTimeout ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#getTimeout <em>Timeout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Timeout</em>' attribute.
     * @see #getTimeout()
     * @generated
     */
    void setTimeout ( int value );

    /**
     * Returns the value of the '<em><b>Baud Rate</b></em>' attribute.
     * The default value is <code>"9600"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Baud Rate</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Baud Rate</em>' attribute.
     * @see #setBaudRate(int)
     * @see org.eclipse.scada.configuration.setup.common.CommonPackage#getSerialToNetworkMapping_BaudRate()
     * @model default="9600" required="true"
     * @generated
     */
    int getBaudRate ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#getBaudRate <em>Baud Rate</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Baud Rate</em>' attribute.
     * @see #getBaudRate()
     * @generated
     */
    void setBaudRate ( int value );

    /**
     * Returns the value of the '<em><b>Parity</b></em>' attribute.
     * The literals are from the enumeration {@link org.eclipse.scada.configuration.setup.common.Parity}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Parity</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Parity</em>' attribute.
     * @see org.eclipse.scada.configuration.setup.common.Parity
     * @see #setParity(Parity)
     * @see org.eclipse.scada.configuration.setup.common.CommonPackage#getSerialToNetworkMapping_Parity()
     * @model required="true"
     * @generated
     */
    Parity getParity ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#getParity <em>Parity</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Parity</em>' attribute.
     * @see org.eclipse.scada.configuration.setup.common.Parity
     * @see #getParity()
     * @generated
     */
    void setParity ( Parity value );

    /**
     * Returns the value of the '<em><b>Xonxoff</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Xonxoff</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Xonxoff</em>' attribute.
     * @see #setXonxoff(boolean)
     * @see org.eclipse.scada.configuration.setup.common.CommonPackage#getSerialToNetworkMapping_Xonxoff()
     * @model default="false" required="true"
     * @generated
     */
    boolean isXonxoff ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#isXonxoff <em>Xonxoff</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Xonxoff</em>' attribute.
     * @see #isXonxoff()
     * @generated
     */
    void setXonxoff ( boolean value );

    /**
     * Returns the value of the '<em><b>Rtscts</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Rtscts</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Rtscts</em>' attribute.
     * @see #setRtscts(boolean)
     * @see org.eclipse.scada.configuration.setup.common.CommonPackage#getSerialToNetworkMapping_Rtscts()
     * @model default="false" required="true"
     * @generated
     */
    boolean isRtscts ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#isRtscts <em>Rtscts</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Rtscts</em>' attribute.
     * @see #isRtscts()
     * @generated
     */
    void setRtscts ( boolean value );

    /**
     * Returns the value of the '<em><b>Data Bits</b></em>' attribute.
     * The default value is <code>"8"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Bits</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Bits</em>' attribute.
     * @see #setDataBits(short)
     * @see org.eclipse.scada.configuration.setup.common.CommonPackage#getSerialToNetworkMapping_DataBits()
     * @model default="8" required="true"
     * @generated
     */
    short getDataBits ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#getDataBits <em>Data Bits</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Bits</em>' attribute.
     * @see #getDataBits()
     * @generated
     */
    void setDataBits ( short value );

    /**
     * Returns the value of the '<em><b>Stop Bits</b></em>' attribute.
     * The default value is <code>"1"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Stop Bits</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Stop Bits</em>' attribute.
     * @see #setStopBits(short)
     * @see org.eclipse.scada.configuration.setup.common.CommonPackage#getSerialToNetworkMapping_StopBits()
     * @model default="1" required="true"
     * @generated
     */
    short getStopBits ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#getStopBits <em>Stop Bits</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Stop Bits</em>' attribute.
     * @see #getStopBits()
     * @generated
     */
    void setStopBits ( short value );

    /**
     * Returns the value of the '<em><b>Modem Control</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Modem Control</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Modem Control</em>' attribute.
     * @see #setModemControl(boolean)
     * @see org.eclipse.scada.configuration.setup.common.CommonPackage#getSerialToNetworkMapping_ModemControl()
     * @model required="true"
     * @generated
     */
    boolean isModemControl ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#isModemControl <em>Modem Control</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Modem Control</em>' attribute.
     * @see #isModemControl()
     * @generated
     */
    void setModemControl ( boolean value );

    /**
     * Returns the value of the '<em><b>Break</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Break</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Break</em>' attribute.
     * @see #setBreak(boolean)
     * @see org.eclipse.scada.configuration.setup.common.CommonPackage#getSerialToNetworkMapping_Break()
     * @model required="true"
     * @generated
     */
    boolean isBreak ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.setup.common.SerialToNetworkMapping#isBreak <em>Break</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Break</em>' attribute.
     * @see #isBreak()
     * @generated
     */
    void setBreak ( boolean value );

} // SerialToNetworkMapping
