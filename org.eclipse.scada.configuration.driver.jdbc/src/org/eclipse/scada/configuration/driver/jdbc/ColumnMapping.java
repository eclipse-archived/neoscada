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
package org.eclipse.scada.configuration.driver.jdbc;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.configuration.world.osgi.DataType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Column Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.driver.jdbc.ColumnMapping#getColumnNumber <em>Column Number</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.driver.jdbc.ColumnMapping#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.driver.jdbc.ColumnMapping#getCustomizationTags <em>Customization Tags</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.driver.jdbc.ColumnMapping#getDataType <em>Data Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.driver.jdbc.JdbcPackage#getColumnMapping()
 * @model
 * @generated
 */
public interface ColumnMapping extends EObject
{

    /**
     * Returns the value of the '<em><b>Column Number</b></em>' attribute.
     * The default value is <code>"1"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Column Number</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Column Number</em>' attribute.
     * @see #setColumnNumber(int)
     * @see org.eclipse.scada.configuration.driver.jdbc.JdbcPackage#getColumnMapping_ColumnNumber()
     * @model default="1" required="true"
     * @generated
     */
    int getColumnNumber ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.driver.jdbc.ColumnMapping#getColumnNumber <em>Column Number</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Column Number</em>' attribute.
     * @see #getColumnNumber()
     * @generated
     */
    void setColumnNumber ( int value );

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see org.eclipse.scada.configuration.driver.jdbc.JdbcPackage#getColumnMapping_Name()
     * @model required="true"
     * @generated
     */
    String getName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.driver.jdbc.ColumnMapping#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName ( String value );

    /**
     * Returns the value of the '<em><b>Customization Tags</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Customization Tags</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Customization Tags</em>' attribute list.
     * @see org.eclipse.scada.configuration.driver.jdbc.JdbcPackage#getColumnMapping_CustomizationTags()
     * @model
     * @generated
     */
    EList<String> getCustomizationTags ();

    /**
     * Returns the value of the '<em><b>Data Type</b></em>' attribute.
     * The default value is <code>"NULL"</code>.
     * The literals are from the enumeration {@link org.eclipse.scada.configuration.world.osgi.DataType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Data Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Data Type</em>' attribute.
     * @see org.eclipse.scada.configuration.world.osgi.DataType
     * @see #setDataType(DataType)
     * @see org.eclipse.scada.configuration.driver.jdbc.JdbcPackage#getColumnMapping_DataType()
     * @model default="NULL"
     * @generated
     */
    DataType getDataType ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.driver.jdbc.ColumnMapping#getDataType <em>Data Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Data Type</em>' attribute.
     * @see org.eclipse.scada.configuration.world.osgi.DataType
     * @see #getDataType()
     * @generated
     */
    void setDataType ( DataType value );
} // ColumnMapping
