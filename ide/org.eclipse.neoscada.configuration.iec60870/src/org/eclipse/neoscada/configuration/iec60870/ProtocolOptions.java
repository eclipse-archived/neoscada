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
package org.eclipse.neoscada.configuration.iec60870;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Protocol Options</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#getTimeout1 <em>Timeout1</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#getTimeout2 <em>Timeout2</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#getTimeout3 <em>Timeout3</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#getAsduAddressSize <em>Asdu Address Size</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#getInformationObjectAddressSize <em>Information Object Address Size</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#getCauseOfTransmissionSize <em>Cause Of Transmission Size</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#getW <em>W</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#getK <em>K</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#getTargetTimeZone <em>Target Time Zone</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#isIgnoreDaylightSavingTime <em>Ignore Daylight Saving Time</em>}</li>
 * </ul>
 *
 * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getProtocolOptions()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='asduAddressSizeCheck\ncauseOfTransmissionSizeCheck'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL asduAddressSizeCheck='asduAddressSize&gt;=1 and asduAddressSize &lt;=2' causeOfTransmissionSizeCheck='causeOfTransmissionSize&gt;=1 and causeOfTransmissionSize&lt;=2' informationObjectAddressSizeCheck='informationObjectAddressSize&gt;=1 and informationObjectAddressSize&lt;=3'"
 * @generated
 */
public interface ProtocolOptions extends EObject
{

    /**
     * Returns the value of the '<em><b>Timeout1</b></em>' attribute.
     * The default value is <code>"15000"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Timeout1</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Timeout1</em>' attribute.
     * @see #setTimeout1(int)
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getProtocolOptions_Timeout1()
     * @model default="15000" required="true"
     *        annotation="http://eclipse.org/SCADA/CA/Descriptor name='t1'"
     * @generated
     */
    int getTimeout1 ();

    /**
     * Sets the value of the '{@link org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#getTimeout1 <em>Timeout1</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Timeout1</em>' attribute.
     * @see #getTimeout1()
     * @generated
     */
    void setTimeout1 ( int value );

    /**
     * Returns the value of the '<em><b>Timeout2</b></em>' attribute.
     * The default value is <code>"10000"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Timeout2</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Timeout2</em>' attribute.
     * @see #setTimeout2(int)
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getProtocolOptions_Timeout2()
     * @model default="10000" required="true"
     *        annotation="http://eclipse.org/SCADA/CA/Descriptor name='t2'"
     * @generated
     */
    int getTimeout2 ();

    /**
     * Sets the value of the '{@link org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#getTimeout2 <em>Timeout2</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Timeout2</em>' attribute.
     * @see #getTimeout2()
     * @generated
     */
    void setTimeout2 ( int value );

    /**
     * Returns the value of the '<em><b>Timeout3</b></em>' attribute.
     * The default value is <code>"20000"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Timeout3</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Timeout3</em>' attribute.
     * @see #setTimeout3(int)
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getProtocolOptions_Timeout3()
     * @model default="20000" required="true"
     *        annotation="http://eclipse.org/SCADA/CA/Descriptor name='t3'"
     * @generated
     */
    int getTimeout3 ();

    /**
     * Sets the value of the '{@link org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#getTimeout3 <em>Timeout3</em>}' attribute.
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
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getProtocolOptions_AsduAddressSize()
     * @model default="2" required="true"
     *        annotation="http://eclipse.org/SCADA/CA/Descriptor name='asduAddressType' format='SIZE_%d'"
     * @generated
     */
    byte getAsduAddressSize ();

    /**
     * Sets the value of the '{@link org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#getAsduAddressSize <em>Asdu Address Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Asdu Address Size</em>' attribute.
     * @see #getAsduAddressSize()
     * @generated
     */
    void setAsduAddressSize ( byte value );

    /**
     * Returns the value of the '<em><b>Information Object Address Size</b></em>' attribute.
     * The default value is <code>"3"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Information Object Address Size</em>'
     * attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Information Object Address Size</em>' attribute.
     * @see #setInformationObjectAddressSize(byte)
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getProtocolOptions_InformationObjectAddressSize()
     * @model default="3" required="true"
     *        annotation="http://eclipse.org/SCADA/CA/Descriptor name='informationObjectAddressType' format='SIZE_%d'"
     * @generated
     */
    byte getInformationObjectAddressSize ();

    /**
     * Sets the value of the '{@link org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#getInformationObjectAddressSize <em>Information Object Address Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Information Object Address Size</em>' attribute.
     * @see #getInformationObjectAddressSize()
     * @generated
     */
    void setInformationObjectAddressSize ( byte value );

    /**
     * Returns the value of the '<em><b>Cause Of Transmission Size</b></em>' attribute.
     * The default value is <code>"2"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Cause Of Transmission Size</em>' attribute
     * isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Cause Of Transmission Size</em>' attribute.
     * @see #setCauseOfTransmissionSize(byte)
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getProtocolOptions_CauseOfTransmissionSize()
     * @model default="2" required="true"
     *        annotation="http://eclipse.org/SCADA/CA/Descriptor name='causeOfTransmissionType' format='SIZE_%d'"
     * @generated
     */
    byte getCauseOfTransmissionSize ();

    /**
     * Sets the value of the '{@link org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#getCauseOfTransmissionSize <em>Cause Of Transmission Size</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Cause Of Transmission Size</em>' attribute.
     * @see #getCauseOfTransmissionSize()
     * @generated
     */
    void setCauseOfTransmissionSize ( byte value );

    /**
     * Returns the value of the '<em><b>W</b></em>' attribute.
     * The default value is <code>"10"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>W</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>W</em>' attribute.
     * @see #setW(int)
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getProtocolOptions_W()
     * @model default="10" required="true"
     *        annotation="http://eclipse.org/SCADA/CA/Descriptor name='w'"
     * @generated
     */
    int getW ();

    /**
     * Sets the value of the '{@link org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#getW <em>W</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>W</em>' attribute.
     * @see #getW()
     * @generated
     */
    void setW ( int value );

    /**
     * Returns the value of the '<em><b>K</b></em>' attribute.
     * The default value is <code>"15"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>K</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>K</em>' attribute.
     * @see #setK(int)
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getProtocolOptions_K()
     * @model default="15" required="true"
     *        annotation="http://eclipse.org/SCADA/CA/Descriptor name='k'"
     * @generated
     */
    int getK ();

    /**
     * Sets the value of the '{@link org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#getK <em>K</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>K</em>' attribute.
     * @see #getK()
     * @generated
     */
    void setK ( int value );

    /**
     * Returns the value of the '<em><b>Target Time Zone</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * This defines in which time zone the timestamps will be converted before they are sent/or after they have been received from communication partner.
     * IEC60870-5 recommends to use the UTC as time zone, however not all systems follow that recommendation.
     * 
     * This value must be a valid Java time zone ID.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Target Time Zone</em>' attribute.
     * @see #setTargetTimeZone(String)
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getProtocolOptions_TargetTimeZone()
     * @model annotation="http://eclipse.org/SCADA/CA/Descriptor name='timeZone'"
     * @generated
     */
    String getTargetTimeZone ();

    /**
     * Sets the value of the '{@link org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#getTargetTimeZone <em>Target Time Zone</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Target Time Zone</em>' attribute.
     * @see #getTargetTimeZone()
     * @generated
     */
    void setTargetTimeZone ( String value );

    /**
     * Returns the value of the '<em><b>Ignore Daylight Saving Time</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ignore Daylight Saving Time</em>' attribute
     * isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ignore Daylight Saving Time</em>' attribute.
     * @see #setIgnoreDaylightSavingTime(boolean)
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getProtocolOptions_IgnoreDaylightSavingTime()
     * @model default="false" required="true"
     *        annotation="http://eclipse.org/SCADA/CA/Descriptor name='ignoreDaylightSavingTime'"
     * @generated
     */
    boolean isIgnoreDaylightSavingTime ();

    /**
     * Sets the value of the '{@link org.eclipse.neoscada.configuration.iec60870.ProtocolOptions#isIgnoreDaylightSavingTime <em>Ignore Daylight Saving Time</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ignore Daylight Saving Time</em>' attribute.
     * @see #isIgnoreDaylightSavingTime()
     * @generated
     */
    void setIgnoreDaylightSavingTime ( boolean value );
} // ProtocolOptions
