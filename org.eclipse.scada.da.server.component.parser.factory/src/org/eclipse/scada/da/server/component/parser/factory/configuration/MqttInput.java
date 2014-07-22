/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 */
package org.eclipse.scada.da.server.component.parser.factory.configuration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mqtt Input</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.MqttInput#getServerUri <em>Server Uri</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.MqttInput#getClientId <em>Client Id</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.MqttInput#getTopic <em>Topic</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.MqttInput#getQos <em>Qos</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getMqttInput()
 * @model
 * @generated
 */
public interface MqttInput extends AbstractInput
{
    /**
     * Returns the value of the '<em><b>Server Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Server Uri</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Server Uri</em>' attribute.
     * @see #setServerUri(String)
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getMqttInput_ServerUri()
     * @model required="true"
     * @generated
     */
    String getServerUri ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.MqttInput#getServerUri <em>Server Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Server Uri</em>' attribute.
     * @see #getServerUri()
     * @generated
     */
    void setServerUri ( String value );

    /**
     * Returns the value of the '<em><b>Client Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Client Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Client Id</em>' attribute.
     * @see #setClientId(String)
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getMqttInput_ClientId()
     * @model
     * @generated
     */
    String getClientId ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.MqttInput#getClientId <em>Client Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Client Id</em>' attribute.
     * @see #getClientId()
     * @generated
     */
    void setClientId ( String value );

    /**
     * Returns the value of the '<em><b>Topic</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Topic</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Topic</em>' attribute.
     * @see #setTopic(String)
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getMqttInput_Topic()
     * @model required="true"
     * @generated
     */
    String getTopic ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.MqttInput#getTopic <em>Topic</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Topic</em>' attribute.
     * @see #getTopic()
     * @generated
     */
    void setTopic ( String value );

    /**
     * Returns the value of the '<em><b>Qos</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Qos</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Qos</em>' attribute.
     * @see #setQos(int)
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getMqttInput_Qos()
     * @model required="true"
     * @generated
     */
    int getQos ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.MqttInput#getQos <em>Qos</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Qos</em>' attribute.
     * @see #getQos()
     * @generated
     */
    void setQos ( int value );

} // MqttInput
