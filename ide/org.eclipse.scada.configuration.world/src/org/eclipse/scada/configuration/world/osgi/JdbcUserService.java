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
import org.eclipse.scada.configuration.world.NamedDocumentable;
import org.eclipse.scada.configuration.world.PropertyEntry;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Jdbc User Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.JdbcUserService#getJdbcPropeties <em>Jdbc Propeties</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.JdbcUserService#getJdbcDriver <em>Jdbc Driver</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.JdbcUserService#isAuthorative <em>Authorative</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.JdbcUserService#getFindUserSql <em>Find User Sql</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.JdbcUserService#getFindRolesForUserSql <em>Find Roles For User Sql</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.JdbcUserService#getUpdatePasswordSql <em>Update Password Sql</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.JdbcUserService#getUserIdColumnName <em>User Id Column Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.JdbcUserService#getPasswordColumnName <em>Password Column Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.JdbcUserService#getPasswordType <em>Password Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getJdbcUserService()
 * @model
 * @generated
 */
public interface JdbcUserService extends NamedDocumentable
{
    /**
     * Returns the value of the '<em><b>Jdbc Propeties</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.PropertyEntry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Jdbc Propeties</em>' containment reference
     * list isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Jdbc Propeties</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getJdbcUserService_JdbcPropeties()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<PropertyEntry> getJdbcPropeties ();

    /**
     * Returns the value of the '<em><b>Jdbc Driver</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Jdbc Driver</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Jdbc Driver</em>' attribute.
     * @see #setJdbcDriver(String)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getJdbcUserService_JdbcDriver()
     * @model required="true"
     * @generated
     */
    String getJdbcDriver ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.JdbcUserService#getJdbcDriver <em>Jdbc Driver</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Jdbc Driver</em>' attribute.
     * @see #getJdbcDriver()
     * @generated
     */
    void setJdbcDriver ( String value );

    /**
     * Returns the value of the '<em><b>Authorative</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Authorative</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Authorative</em>' attribute.
     * @see #setAuthorative(boolean)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getJdbcUserService_Authorative()
     * @model default="true" required="true"
     * @generated
     */
    boolean isAuthorative ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.JdbcUserService#isAuthorative <em>Authorative</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Authorative</em>' attribute.
     * @see #isAuthorative()
     * @generated
     */
    void setAuthorative ( boolean value );

    /**
     * Returns the value of the '<em><b>Find User Sql</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Find the user and its password.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Find User Sql</em>' attribute.
     * @see #setFindUserSql(String)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getJdbcUserService_FindUserSql()
     * @model required="true"
     * @generated
     */
    String getFindUserSql ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.JdbcUserService#getFindUserSql <em>Find User Sql</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Find User Sql</em>' attribute.
     * @see #getFindUserSql()
     * @generated
     */
    void setFindUserSql ( String value );

    /**
     * Returns the value of the '<em><b>Find Roles For User Sql</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Find all roles for the user.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Find Roles For User Sql</em>' attribute.
     * @see #setFindRolesForUserSql(String)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getJdbcUserService_FindRolesForUserSql()
     * @model required="true"
     * @generated
     */
    String getFindRolesForUserSql ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.JdbcUserService#getFindRolesForUserSql <em>Find Roles For User Sql</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Find Roles For User Sql</em>' attribute.
     * @see #getFindRolesForUserSql()
     * @generated
     */
    void setFindRolesForUserSql ( String value );

    /**
     * Returns the value of the '<em><b>Update Password Sql</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * An optional SQL statement to update the password for the user.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Update Password Sql</em>' attribute.
     * @see #setUpdatePasswordSql(String)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getJdbcUserService_UpdatePasswordSql()
     * @model
     * @generated
     */
    String getUpdatePasswordSql ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.JdbcUserService#getUpdatePasswordSql <em>Update Password Sql</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Update Password Sql</em>' attribute.
     * @see #getUpdatePasswordSql()
     * @generated
     */
    void setUpdatePasswordSql ( String value );

    /**
     * Returns the value of the '<em><b>User Id Column Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * An optional user id column name. If the column name is not specified the provided user id will be used instead of the user id re-read from the database.
     * <!-- end-model-doc -->
     * @return the value of the '<em>User Id Column Name</em>' attribute.
     * @see #setUserIdColumnName(String)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getJdbcUserService_UserIdColumnName()
     * @model
     * @generated
     */
    String getUserIdColumnName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.JdbcUserService#getUserIdColumnName <em>User Id Column Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>User Id Column Name</em>' attribute.
     * @see #getUserIdColumnName()
     * @generated
     */
    void setUserIdColumnName ( String value );

    /**
     * Returns the value of the '<em><b>Password Column Name</b></em>' attribute.
     * The default value is <code>"password"</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The name of the password column.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Password Column Name</em>' attribute.
     * @see #setPasswordColumnName(String)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getJdbcUserService_PasswordColumnName()
     * @model default="password" required="true"
     * @generated
     */
    String getPasswordColumnName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.JdbcUserService#getPasswordColumnName <em>Password Column Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Password Column Name</em>' attribute.
     * @see #getPasswordColumnName()
     * @generated
     */
    void setPasswordColumnName ( String value );

    /**
     * Returns the value of the '<em><b>Password Type</b></em>' attribute.
     * The literals are from the enumeration {@link org.eclipse.scada.configuration.world.osgi.PasswordType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Password Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Password Type</em>' attribute.
     * @see org.eclipse.scada.configuration.world.osgi.PasswordType
     * @see #setPasswordType(PasswordType)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getJdbcUserService_PasswordType()
     * @model required="true"
     * @generated
     */
    PasswordType getPasswordType ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.JdbcUserService#getPasswordType <em>Password Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Password Type</em>' attribute.
     * @see org.eclipse.scada.configuration.world.osgi.PasswordType
     * @see #getPasswordType()
     * @generated
     */
    void setPasswordType ( PasswordType value );

} // JdbcUserService
