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
package org.eclipse.scada.configuration.world;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Generic Database Settings</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.AbstractGenericDatabaseSettings#getUsername <em>Username</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.AbstractGenericDatabaseSettings#getPassword <em>Password</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.AbstractGenericDatabaseSettings#getLoginTimeout <em>Login Timeout</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.AbstractGenericDatabaseSettings#getAdditionalProperties <em>Additional Properties</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.AbstractGenericDatabaseSettings#getDatabaseName <em>Database Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.AbstractGenericDatabaseSettings#getServerName <em>Server Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.AbstractGenericDatabaseSettings#getPortNumber <em>Port Number</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.world.WorldPackage#getAbstractGenericDatabaseSettings()
 * @model abstract="true"
 * @generated
 */
public interface AbstractGenericDatabaseSettings extends DatabaseSettings
{
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
     * @see org.eclipse.scada.configuration.world.WorldPackage#getAbstractGenericDatabaseSettings_Username()
     * @model
     * @generated
     */
    String getUsername ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.AbstractGenericDatabaseSettings#getUsername <em>Username</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Username</em>' attribute.
     * @see #getUsername()
     * @generated
     */
    void setUsername ( String value );

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
     * @see org.eclipse.scada.configuration.world.WorldPackage#getAbstractGenericDatabaseSettings_Password()
     * @model
     * @generated
     */
    String getPassword ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.AbstractGenericDatabaseSettings#getPassword <em>Password</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Password</em>' attribute.
     * @see #getPassword()
     * @generated
     */
    void setPassword ( String value );

    /**
     * Returns the value of the '<em><b>Login Timeout</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Login Timeout</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Login Timeout</em>' attribute.
     * @see #setLoginTimeout(Integer)
     * @see org.eclipse.scada.configuration.world.WorldPackage#getAbstractGenericDatabaseSettings_LoginTimeout()
     * @model
     * @generated
     */
    Integer getLoginTimeout ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.AbstractGenericDatabaseSettings#getLoginTimeout <em>Login Timeout</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Login Timeout</em>' attribute.
     * @see #getLoginTimeout()
     * @generated
     */
    void setLoginTimeout ( Integer value );

    /**
     * Returns the value of the '<em><b>Additional Properties</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.PropertyEntry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Additional Properties</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Additional Properties</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.WorldPackage#getAbstractGenericDatabaseSettings_AdditionalProperties()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<PropertyEntry> getAdditionalProperties ();

    /**
     * Returns the value of the '<em><b>Database Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Database Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Database Name</em>' attribute.
     * @see #setDatabaseName(String)
     * @see org.eclipse.scada.configuration.world.WorldPackage#getAbstractGenericDatabaseSettings_DatabaseName()
     * @model
     * @generated
     */
    String getDatabaseName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.AbstractGenericDatabaseSettings#getDatabaseName <em>Database Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Database Name</em>' attribute.
     * @see #getDatabaseName()
     * @generated
     */
    void setDatabaseName ( String value );

    /**
     * Returns the value of the '<em><b>Server Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Server Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Server Name</em>' attribute.
     * @see #setServerName(String)
     * @see org.eclipse.scada.configuration.world.WorldPackage#getAbstractGenericDatabaseSettings_ServerName()
     * @model
     * @generated
     */
    String getServerName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.AbstractGenericDatabaseSettings#getServerName <em>Server Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Server Name</em>' attribute.
     * @see #getServerName()
     * @generated
     */
    void setServerName ( String value );

    /**
     * Returns the value of the '<em><b>Port Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Port Number</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Port Number</em>' attribute.
     * @see #setPortNumber(Integer)
     * @see org.eclipse.scada.configuration.world.WorldPackage#getAbstractGenericDatabaseSettings_PortNumber()
     * @model
     * @generated
     */
    Integer getPortNumber ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.AbstractGenericDatabaseSettings#getPortNumber <em>Port Number</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Port Number</em>' attribute.
     * @see #getPortNumber()
     * @generated
     */
    void setPortNumber ( Integer value );

} // AbstractGenericDatabaseSettings
