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
package org.eclipse.scada.configuration.world.osgi;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Injector Jdbc</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.EventInjectorJdbc#getSelectSql <em>Select Sql</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.EventInjectorJdbc#getDeleteSql <em>Delete Sql</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.EventInjectorJdbc#getExistsSql <em>Exists Sql</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEventInjectorJdbc()
 * @model
 * @generated
 */
public interface EventInjectorJdbc extends EventInjector
{
    /**
     * Returns the value of the '<em><b>Select Sql</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Select Sql</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Select Sql</em>' attribute.
     * @see #setSelectSql(String)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEventInjectorJdbc_SelectSql()
     * @model
     * @generated
     */
    String getSelectSql ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.EventInjectorJdbc#getSelectSql <em>Select Sql</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Select Sql</em>' attribute.
     * @see #getSelectSql()
     * @generated
     */
    void setSelectSql ( String value );

    /**
     * Returns the value of the '<em><b>Delete Sql</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Delete Sql</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Delete Sql</em>' attribute.
     * @see #setDeleteSql(String)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEventInjectorJdbc_DeleteSql()
     * @model
     * @generated
     */
    String getDeleteSql ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.EventInjectorJdbc#getDeleteSql <em>Delete Sql</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Delete Sql</em>' attribute.
     * @see #getDeleteSql()
     * @generated
     */
    void setDeleteSql ( String value );

    /**
     * Returns the value of the '<em><b>Exists Sql</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Exists Sql</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Exists Sql</em>' attribute.
     * @see #setExistsSql(String)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEventInjectorJdbc_ExistsSql()
     * @model
     * @generated
     */
    String getExistsSql ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.EventInjectorJdbc#getExistsSql <em>Exists Sql</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Exists Sql</em>' attribute.
     * @see #getExistsSql()
     * @generated
     */
    void setExistsSql ( String value );

} // EventInjectorJdbc
