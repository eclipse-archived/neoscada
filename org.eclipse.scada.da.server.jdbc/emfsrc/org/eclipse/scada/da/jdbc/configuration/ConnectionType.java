/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.jdbc.configuration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.ConnectionType#getQuery <em>Query</em>}</li>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.ConnectionType#getTabularQuery <em>Tabular Query</em>}</li>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.ConnectionType#getUpdate <em>Update</em>}</li>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.ConnectionType#getConnectionClass <em>Connection Class</em>}</li>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.ConnectionType#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.ConnectionType#getPassword <em>Password</em>}</li>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.ConnectionType#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.ConnectionType#getUri <em>Uri</em>}</li>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.ConnectionType#getUsername <em>Username</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage#getConnectionType()
 * @model extendedMetaData="name='ConnectionType' kind='elementOnly'"
 * @generated
 */
public interface ConnectionType extends EObject
{

    /**
     * Returns the value of the '<em><b>Query</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.da.jdbc.configuration.QueryType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Query</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Query</em>' containment reference list.
     * @see org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage#getConnectionType_Query()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='query' namespace='##targetNamespace'"
     * @generated
     */
    EList<QueryType> getQuery ();

    /**
     * Returns the value of the '<em><b>Tabular Query</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.da.jdbc.configuration.TabularQueryType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Tabular Query</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Tabular Query</em>' containment reference list.
     * @see org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage#getConnectionType_TabularQuery()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='tabularQuery' namespace='##targetNamespace'"
     * @generated
     */
    EList<TabularQueryType> getTabularQuery ();

    /**
     * Returns the value of the '<em><b>Update</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.da.jdbc.configuration.UpdateType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Update</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Update</em>' containment reference list.
     * @see org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage#getConnectionType_Update()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='update' namespace='##targetNamespace'"
     * @generated
     */
    EList<UpdateType> getUpdate ();

    /**
     * Returns the value of the '<em><b>Connection Class</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Connection Class</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Connection Class</em>' attribute.
     * @see #setConnectionClass(String)
     * @see org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage#getConnectionType_ConnectionClass()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='connectionClass'"
     * @generated
     */
    String getConnectionClass ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.jdbc.configuration.ConnectionType#getConnectionClass <em>Connection Class</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Connection Class</em>' attribute.
     * @see #getConnectionClass()
     * @generated
     */
    void setConnectionClass ( String value );

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
     * @see org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage#getConnectionType_Id()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='attribute' name='id'"
     * @generated
     */
    String getId ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.jdbc.configuration.ConnectionType#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId ( String value );

    /**
     * Returns the value of the '<em><b>Password</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Password</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Password</em>' attribute.
     * @see #setPassword(String)
     * @see org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage#getConnectionType_Password()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='password'"
     * @generated
     */
    String getPassword ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.jdbc.configuration.ConnectionType#getPassword <em>Password</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Password</em>' attribute.
     * @see #getPassword()
     * @generated
     */
    void setPassword ( String value );

    /**
     * Returns the value of the '<em><b>Timeout</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Timeout</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Timeout</em>' attribute.
     * @see #isSetTimeout()
     * @see #unsetTimeout()
     * @see #setTimeout(int)
     * @see org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage#getConnectionType_Timeout()
     * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
     *        extendedMetaData="kind='attribute' name='timeout'"
     * @generated
     */
    int getTimeout ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.jdbc.configuration.ConnectionType#getTimeout <em>Timeout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Timeout</em>' attribute.
     * @see #isSetTimeout()
     * @see #unsetTimeout()
     * @see #getTimeout()
     * @generated
     */
    void setTimeout ( int value );

    /**
     * Unsets the value of the '{@link org.eclipse.scada.da.jdbc.configuration.ConnectionType#getTimeout <em>Timeout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSetTimeout()
     * @see #getTimeout()
     * @see #setTimeout(int)
     * @generated
     */
    void unsetTimeout ();

    /**
     * Returns whether the value of the '{@link org.eclipse.scada.da.jdbc.configuration.ConnectionType#getTimeout <em>Timeout</em>}' attribute is set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return whether the value of the '<em>Timeout</em>' attribute is set.
     * @see #unsetTimeout()
     * @see #getTimeout()
     * @see #setTimeout(int)
     * @generated
     */
    boolean isSetTimeout ();

    /**
     * Returns the value of the '<em><b>Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Uri</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Uri</em>' attribute.
     * @see #setUri(String)
     * @see org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage#getConnectionType_Uri()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='attribute' name='uri'"
     * @generated
     */
    String getUri ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.jdbc.configuration.ConnectionType#getUri <em>Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Uri</em>' attribute.
     * @see #getUri()
     * @generated
     */
    void setUri ( String value );

    /**
     * Returns the value of the '<em><b>Username</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Username</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Username</em>' attribute.
     * @see #setUsername(String)
     * @see org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage#getConnectionType_Username()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='username'"
     * @generated
     */
    String getUsername ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.jdbc.configuration.ConnectionType#getUsername <em>Username</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Username</em>' attribute.
     * @see #getUsername()
     * @generated
     */
    void setUsername ( String value );

} // ConnectionType
