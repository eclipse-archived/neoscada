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

import org.eclipse.scada.configuration.world.PostgresDatabaseSettings;
import org.eclipse.scada.configuration.world.setup.SetupModule;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Postgres Setup Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.setup.common.PostgresSetupModule#getDatabase <em>Database</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.setup.common.PostgresSetupModule#getPostgresUser <em>Postgres User</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.setup.common.PostgresSetupModule#getHostBasedAccessFile <em>Host Based Access File</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.setup.common.PostgresSetupModule#getConfigurationFile <em>Configuration File</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.setup.common.CommonPackage#getPostgresSetupModule()
 * @model
 * @generated
 */
public interface PostgresSetupModule extends SetupModule
{
    /**
     * Returns the value of the '<em><b>Database</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Database</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Database</em>' reference.
     * @see #setDatabase(PostgresDatabaseSettings)
     * @see org.eclipse.scada.configuration.setup.common.CommonPackage#getPostgresSetupModule_Database()
     * @model required="true"
     * @generated
     */
    PostgresDatabaseSettings getDatabase ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.setup.common.PostgresSetupModule#getDatabase <em>Database</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Database</em>' reference.
     * @see #getDatabase()
     * @generated
     */
    void setDatabase ( PostgresDatabaseSettings value );

    /**
     * Returns the value of the '<em><b>Postgres User</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Postgres User</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Postgres User</em>' attribute.
     * @see #setPostgresUser(String)
     * @see org.eclipse.scada.configuration.setup.common.CommonPackage#getPostgresSetupModule_PostgresUser()
     * @model required="true"
     * @generated
     */
    String getPostgresUser ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.setup.common.PostgresSetupModule#getPostgresUser <em>Postgres User</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Postgres User</em>' attribute.
     * @see #getPostgresUser()
     * @generated
     */
    void setPostgresUser ( String value );

    /**
     * Returns the value of the '<em><b>Host Based Access File</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Host Based Access File</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Host Based Access File</em>' attribute.
     * @see #setHostBasedAccessFile(String)
     * @see org.eclipse.scada.configuration.setup.common.CommonPackage#getPostgresSetupModule_HostBasedAccessFile()
     * @model
     * @generated
     */
    String getHostBasedAccessFile ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.setup.common.PostgresSetupModule#getHostBasedAccessFile <em>Host Based Access File</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Host Based Access File</em>' attribute.
     * @see #getHostBasedAccessFile()
     * @generated
     */
    void setHostBasedAccessFile ( String value );

    /**
     * Returns the value of the '<em><b>Configuration File</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Configuration File</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Configuration File</em>' attribute.
     * @see #setConfigurationFile(String)
     * @see org.eclipse.scada.configuration.setup.common.CommonPackage#getPostgresSetupModule_ConfigurationFile()
     * @model
     * @generated
     */
    String getConfigurationFile ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.setup.common.PostgresSetupModule#getConfigurationFile <em>Configuration File</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Configuration File</em>' attribute.
     * @see #getConfigurationFile()
     * @generated
     */
    void setConfigurationFile ( String value );

} // PostgresSetupModule
