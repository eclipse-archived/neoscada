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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.configuration.world.Endpoint;
import org.eclipse.scada.configuration.world.PropertyEntry;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Device</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.Device#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.Device#getItems <em>Items</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.Device#getEndpoint <em>Endpoint</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.Device#getProtocolOptions <em>Protocol Options</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.Device#getDataModuleOptions <em>Data Module Options</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.Device#getHiveProperties <em>Hive Properties</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.Device#getSpontaneousBufferWindow <em>Spontaneous Buffer Window</em>}</li>
 *   <li>{@link org.eclipse.neoscada.configuration.iec60870.Device#getCyclicPeriod <em>Cyclic Period</em>}</li>
 * </ul>
 *
 * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getDevice()
 * @model
 * @generated
 */
public interface Device extends EObject
{
    /**
     * Returns the value of the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Id</em>' attribute.
     * @see #setId(String)
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getDevice_Id()
     * @model id="true" required="true"
     * @generated
     */
    String getId ();

    /**
     * Sets the value of the '{@link org.eclipse.neoscada.configuration.iec60870.Device#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId ( String value );

    /**
     * Returns the value of the '<em><b>Items</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.neoscada.configuration.iec60870.Item}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Items</em>' containment reference list isn't
     * clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Items</em>' containment reference list.
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getDevice_Items()
     * @model containment="true"
     * @generated
     */
    EList<Item> getItems ();

    /**
     * Returns the value of the '<em><b>Endpoint</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Endpoint</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Endpoint</em>' reference.
     * @see #setEndpoint(Endpoint)
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getDevice_Endpoint()
     * @model required="true"
     * @generated
     */
    Endpoint getEndpoint ();

    /**
     * Sets the value of the '{@link org.eclipse.neoscada.configuration.iec60870.Device#getEndpoint <em>Endpoint</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Endpoint</em>' reference.
     * @see #getEndpoint()
     * @generated
     */
    void setEndpoint ( Endpoint value );

    /**
     * Returns the value of the '<em><b>Protocol Options</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Protocol Options</em>' containment reference
     * isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Protocol Options</em>' containment reference.
     * @see #setProtocolOptions(ProtocolOptions)
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getDevice_ProtocolOptions()
     * @model containment="true"
     * @generated
     */
    ProtocolOptions getProtocolOptions ();

    /**
     * Sets the value of the '{@link org.eclipse.neoscada.configuration.iec60870.Device#getProtocolOptions <em>Protocol Options</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Protocol Options</em>' containment reference.
     * @see #getProtocolOptions()
     * @generated
     */
    void setProtocolOptions ( ProtocolOptions value );

    /**
     * Returns the value of the '<em><b>Data Module Options</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Module Options</em>' containment
     * reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Module Options</em>' containment reference.
     * @see #setDataModuleOptions(DataModuleOptions)
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getDevice_DataModuleOptions()
     * @model containment="true"
     * @generated
     */
    DataModuleOptions getDataModuleOptions ();

    /**
     * Sets the value of the '{@link org.eclipse.neoscada.configuration.iec60870.Device#getDataModuleOptions <em>Data Module Options</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Module Options</em>' containment reference.
     * @see #getDataModuleOptions()
     * @generated
     */
    void setDataModuleOptions ( DataModuleOptions value );

    /**
     * Returns the value of the '<em><b>Hive Properties</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.PropertyEntry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Hive Properties</em>' containment reference
     * list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Hive Properties</em>' containment reference list.
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getDevice_HiveProperties()
     * @model containment="true"
     * @generated
     */
    EList<PropertyEntry> getHiveProperties ();

    /**
     * Returns the value of the '<em><b>Spontaneous Buffer Window</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Number of milliseconds used to buffer spontaneous events
     * <!-- end-model-doc -->
     * @return the value of the '<em>Spontaneous Buffer Window</em>' attribute.
     * @see #setSpontaneousBufferWindow(Long)
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getDevice_SpontaneousBufferWindow()
     * @model
     * @generated
     */
    Long getSpontaneousBufferWindow ();

    /**
     * Sets the value of the '{@link org.eclipse.neoscada.configuration.iec60870.Device#getSpontaneousBufferWindow <em>Spontaneous Buffer Window</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Spontaneous Buffer Window</em>' attribute.
     * @see #getSpontaneousBufferWindow()
     * @generated
     */
    void setSpontaneousBufferWindow ( Long value );

    /**
     * Returns the value of the '<em><b>Cyclic Period</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Number of milliseconds used to buffer spontaneous events
     * <!-- end-model-doc -->
     * @return the value of the '<em>Cyclic Period</em>' attribute.
     * @see #setCyclicPeriod(Long)
     * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package#getDevice_CyclicPeriod()
     * @model
     * @generated
     */
    Long getCyclicPeriod ();

    /**
     * Sets the value of the '{@link org.eclipse.neoscada.configuration.iec60870.Device#getCyclicPeriod <em>Cyclic Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Cyclic Period</em>' attribute.
     * @see #getCyclicPeriod()
     * @generated
     */
    void setCyclicPeriod ( Long value );

} // Device
