/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world.osgi;

import org.eclipse.emf.common.util.EList;
import org.eclipse.scada.configuration.world.Credentials;
import org.eclipse.scada.configuration.world.Endpoint;
import org.eclipse.scada.configuration.world.NamedDocumentable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.Connection#getEndpoint <em>Endpoint</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.Connection#getEndpointLabel <em>Endpoint Label</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.Connection#getCredentials <em>Credentials</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.Connection#getTimeout <em>Timeout</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getConnection()
 * @model abstract="true"
 * @generated
 */
public interface Connection extends NamedDocumentable
{
    /**
     * Returns the value of the '<em><b>Endpoint</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Endpoint</em>' reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Endpoint</em>' reference.
     * @see #setEndpoint(Endpoint)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getConnection_Endpoint()
     * @model keys="portNumber" required="true"
     * @generated
     */
    Endpoint getEndpoint ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.Connection#getEndpoint <em>Endpoint</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Endpoint</em>' reference.
     * @see #getEndpoint()
     * @generated
     */
    void setEndpoint ( Endpoint value );

    /**
     * Returns the value of the '<em><b>Endpoint Label</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Endpoint Label</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Endpoint Label</em>' attribute.
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getConnection_EndpointLabel()
     * @model transient="true" changeable="false" volatile="true" derived="true"
     * @generated
     */
    String getEndpointLabel ();

    /**
     * Returns the value of the '<em><b>Credentials</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Credentials</em>' reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Credentials</em>' containment reference.
     * @see #setCredentials(Credentials)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getConnection_Credentials()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    Credentials getCredentials ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.Connection#getCredentials <em>Credentials</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Credentials</em>' containment reference.
     * @see #getCredentials()
     * @generated
     */
    void setCredentials ( Credentials value );

    /**
     * Returns the value of the '<em><b>Timeout</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Timeout</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Timeout</em>' attribute.
     * @see #setTimeout(Integer)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getConnection_Timeout()
     * @model
     * @generated
     */
    Integer getTimeout ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.Connection#getTimeout <em>Timeout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Timeout</em>' attribute.
     * @see #getTimeout()
     * @generated
     */
    void setTimeout ( Integer value );

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation" required="true"
     * @generated
     */
    String getTypeTag ();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    EList<Endpoint> getPossibleEndpoints ( Exporter exporter );

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model required="true"
     * @generated
     */
    String makeUri ( boolean localhost );

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model
     * @generated
     */
    Endpoint getMatchingEndpoint ( Exporter exporter );

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation" required="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return getTypeTag () + \".connection\";'"
     * @generated
     */
    String getFactoryId ();

} // Connection
