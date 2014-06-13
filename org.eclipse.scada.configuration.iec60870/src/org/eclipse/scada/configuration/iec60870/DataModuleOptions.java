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
 * A representation of the model object '<em><b>Data Module Options</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.iec60870.DataModuleOptions#getBackgroundScanPeriod <em>Background Scan Period</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.iec60870.DataModuleOptions#getSpontaneousItemBuffer <em>Spontaneous Item Buffer</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.iec60870.DataModuleOptions#isTimestampsForBoolean <em>Timestamps For Boolean</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.iec60870.DataModuleOptions#isTimestampsForFloat <em>Timestamps For Float</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.iec60870.IEC60870Package#getDataModuleOptions()
 * @model
 * @generated
 */
public interface DataModuleOptions extends EObject
{

    /**
     * Returns the value of the '<em><b>Background Scan Period</b></em>' attribute.
     * The default value is <code>"60000"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Background Scan Period</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Background Scan Period</em>' attribute.
     * @see #setBackgroundScanPeriod(Integer)
     * @see org.eclipse.scada.configuration.iec60870.IEC60870Package#getDataModuleOptions_BackgroundScanPeriod()
     * @model default="60000"
     *        annotation="http://eclipse.org/SCADA/CA/Descriptor name='backgroundScanPeriod'"
     * @generated
     */
    Integer getBackgroundScanPeriod ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.iec60870.DataModuleOptions#getBackgroundScanPeriod <em>Background Scan Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Background Scan Period</em>' attribute.
     * @see #getBackgroundScanPeriod()
     * @generated
     */
    void setBackgroundScanPeriod ( Integer value );

    /**
     * Returns the value of the '<em><b>Spontaneous Item Buffer</b></em>' attribute.
     * The default value is <code>"100"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Spontaneous Item Buffer</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Spontaneous Item Buffer</em>' attribute.
     * @see #setSpontaneousItemBuffer(Integer)
     * @see org.eclipse.scada.configuration.iec60870.IEC60870Package#getDataModuleOptions_SpontaneousItemBuffer()
     * @model default="100"
     *        annotation="http://eclipse.org/SCADA/CA/Descriptor name='spontaneousItemBuffer'"
     * @generated
     */
    Integer getSpontaneousItemBuffer ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.iec60870.DataModuleOptions#getSpontaneousItemBuffer <em>Spontaneous Item Buffer</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Spontaneous Item Buffer</em>' attribute.
     * @see #getSpontaneousItemBuffer()
     * @generated
     */
    void setSpontaneousItemBuffer ( Integer value );

    /**
     * Returns the value of the '<em><b>Timestamps For Boolean</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Timestamps For Boolean</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Timestamps For Boolean</em>' attribute.
     * @see #setTimestampsForBoolean(boolean)
     * @see org.eclipse.scada.configuration.iec60870.IEC60870Package#getDataModuleOptions_TimestampsForBoolean()
     * @model default="true" required="true"
     *        annotation="http://eclipse.org/SCADA/CA/Descriptor name='withTimestamp.boolean'"
     * @generated
     */
    boolean isTimestampsForBoolean ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.iec60870.DataModuleOptions#isTimestampsForBoolean <em>Timestamps For Boolean</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Timestamps For Boolean</em>' attribute.
     * @see #isTimestampsForBoolean()
     * @generated
     */
    void setTimestampsForBoolean ( boolean value );

    /**
     * Returns the value of the '<em><b>Timestamps For Float</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Timestamps For Float</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Timestamps For Float</em>' attribute.
     * @see #setTimestampsForFloat(boolean)
     * @see org.eclipse.scada.configuration.iec60870.IEC60870Package#getDataModuleOptions_TimestampsForFloat()
     * @model default="true" required="true"
     *        annotation="http://eclipse.org/SCADA/CA/Descriptor name='withTimestamp.float'"
     * @generated
     */
    boolean isTimestampsForFloat ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.iec60870.DataModuleOptions#isTimestampsForFloat <em>Timestamps For Float</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Timestamps For Float</em>' attribute.
     * @see #isTimestampsForFloat()
     * @generated
     */
    void setTimestampsForFloat ( boolean value );
} // DataModuleOptions
