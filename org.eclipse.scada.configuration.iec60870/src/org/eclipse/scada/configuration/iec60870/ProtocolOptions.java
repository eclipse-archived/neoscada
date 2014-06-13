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
package org.eclipse.scada.configuration.iec60870;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Protocol Options</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.iec60870.ProtocolOptions#getTimeout1 <em>Timeout1</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.iec60870.ProtocolOptions#getTimeout2 <em>Timeout2</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.iec60870.ProtocolOptions#getTimeout3 <em>Timeout3</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.iec60870.ProtocolOptions#getAsduAddressSize <em>Asdu Address Size</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.iec60870.ProtocolOptions#getInformationObjectAddressSize <em>Information Object Address Size</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.iec60870.ProtocolOptions#getCauseOfTransmissionSize <em>Cause Of Transmission Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.iec60870.IEC60870Package#getProtocolOptions()
 * @model
 * @generated
 */
public interface ProtocolOptions extends EObject
{

    /**
     * Returns the value of the '<em><b>Timeout1</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Timeout1</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Timeout1</em>' attribute.
     * @see #setTimeout1(int)
     * @see org.eclipse.scada.configuration.iec60870.IEC60870Package#getProtocolOptions_Timeout1()
     * @model required="true"
     * @generated
     */
    int getTimeout1 ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.iec60870.ProtocolOptions#getTimeout1 <em>Timeout1</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Timeout1</em>' attribute.
     * @see #getTimeout1()
     * @generated
     */
    void setTimeout1 ( int value );

    /**
     * Returns the value of the '<em><b>Timeout2</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Timeout2</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Timeout2</em>' attribute.
     * @see #setTimeout2(int)
     * @see org.eclipse.scada.configuration.iec60870.IEC60870Package#getProtocolOptions_Timeout2()
     * @model required="true"
     * @generated
     */
    int getTimeout2 ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.iec60870.ProtocolOptions#getTimeout2 <em>Timeout2</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Timeout2</em>' attribute.
     * @see #getTimeout2()
     * @generated
     */
    void setTimeout2 ( int value );

    /**
     * Returns the value of the '<em><b>Timeout3</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Timeout3</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Timeout3</em>' attribute.
     * @see #setTimeout3(int)
     * @see org.eclipse.scada.configuration.iec60870.IEC60870Package#getProtocolOptions_Timeout3()
     * @model required="true"
     * @generated
     */
    int getTimeout3 ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.iec60870.ProtocolOptions#getTimeout3 <em>Timeout3</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Timeout3</em>' attribute.
     * @see #getTimeout3()
     * @generated
     */
    void setTimeout3 ( int value );

    /**
     * Returns the value of the '<em><b>Asdu Address Size</b></em>' attribute.
     * The default value is <code>"2"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Asdu Address Size</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Asdu Address Size</em>' attribute.
     * @see #setAsduAddressSize(byte)
     * @see org.eclipse.scada.configuration.iec60870.IEC60870Package#getProtocolOptions_AsduAddressSize()
     * @model default="2" required="true"
     * @generated
     */
    byte getAsduAddressSize ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.iec60870.ProtocolOptions#getAsduAddressSize <em>Asdu Address Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Asdu Address Size</em>' attribute.
     * @see #getAsduAddressSize()
     * @generated
     */
    void setAsduAddressSize ( byte value );

    /**
     * Returns the value of the '<em><b>Information Object Address Size</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Information Object Address Size</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Information Object Address Size</em>' attribute.
     * @see #setInformationObjectAddressSize(byte)
     * @see org.eclipse.scada.configuration.iec60870.IEC60870Package#getProtocolOptions_InformationObjectAddressSize()
     * @model required="true"
     * @generated
     */
    byte getInformationObjectAddressSize ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.iec60870.ProtocolOptions#getInformationObjectAddressSize <em>Information Object Address Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Information Object Address Size</em>' attribute.
     * @see #getInformationObjectAddressSize()
     * @generated
     */
    void setInformationObjectAddressSize ( byte value );

    /**
     * Returns the value of the '<em><b>Cause Of Transmission Size</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Cause Of Transmission Size</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Cause Of Transmission Size</em>' attribute.
     * @see #setCauseOfTransmissionSize(byte)
     * @see org.eclipse.scada.configuration.iec60870.IEC60870Package#getProtocolOptions_CauseOfTransmissionSize()
     * @model required="true"
     * @generated
     */
    byte getCauseOfTransmissionSize ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.iec60870.ProtocolOptions#getCauseOfTransmissionSize <em>Cause Of Transmission Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Cause Of Transmission Size</em>' attribute.
     * @see #getCauseOfTransmissionSize()
     * @generated
     */
    void setCauseOfTransmissionSize ( byte value );
} // ProtocolOptions
