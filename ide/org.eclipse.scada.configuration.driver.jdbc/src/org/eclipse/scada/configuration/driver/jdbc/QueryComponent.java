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
import org.eclipse.scada.configuration.component.MasterComponent;
import org.eclipse.scada.configuration.world.osgi.DataType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.driver.jdbc.QueryComponent#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.driver.jdbc.QueryComponent#getMappings <em>Mappings</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.driver.jdbc.QueryComponent#getPeriod <em>Period</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.driver.jdbc.QueryComponent#getDefaultCustomizationTags <em>Default Customization Tags</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.driver.jdbc.QueryComponent#getDefaultDataType <em>Default Data Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.driver.jdbc.JdbcPackage#getQueryComponent()
 * @model
 * @generated
 */
public interface QueryComponent extends MasterComponent, QueryBase
{

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
     * @see org.eclipse.scada.configuration.driver.jdbc.JdbcPackage#getQueryComponent_Name()
     * @model required="true"
     * @generated
     */
    String getName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.driver.jdbc.QueryComponent#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName ( String value );

    /**
     * Returns the value of the '<em><b>Mappings</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.driver.jdbc.ColumnMapping}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mappings</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mappings</em>' containment reference list.
     * @see org.eclipse.scada.configuration.driver.jdbc.JdbcPackage#getQueryComponent_Mappings()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<ColumnMapping> getMappings ();

    /**
     * Returns the value of the '<em><b>Period</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Period</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The scheduling period of the query in milliseconds.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Period</em>' attribute.
     * @see #setPeriod(int)
     * @see org.eclipse.scada.configuration.driver.jdbc.JdbcPackage#getQueryComponent_Period()
     * @model required="true"
     * @generated
     */
    int getPeriod ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.driver.jdbc.QueryComponent#getPeriod <em>Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Period</em>' attribute.
     * @see #getPeriod()
     * @generated
     */
    void setPeriod ( int value );

    /**
     * Returns the value of the '<em><b>Default Customization Tags</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Customization Tags</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default Customization Tags</em>' attribute list.
     * @see org.eclipse.scada.configuration.driver.jdbc.JdbcPackage#getQueryComponent_DefaultCustomizationTags()
     * @model
     * @generated
     */
    EList<String> getDefaultCustomizationTags ();

    /**
     * Returns the value of the '<em><b>Default Data Type</b></em>' attribute.
     * The literals are from the enumeration {@link org.eclipse.scada.configuration.world.osgi.DataType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Data Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default Data Type</em>' attribute.
     * @see org.eclipse.scada.configuration.world.osgi.DataType
     * @see #setDefaultDataType(DataType)
     * @see org.eclipse.scada.configuration.driver.jdbc.JdbcPackage#getQueryComponent_DefaultDataType()
     * @model
     * @generated
     */
    DataType getDefaultDataType ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.driver.jdbc.QueryComponent#getDefaultDataType <em>Default Data Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Data Type</em>' attribute.
     * @see org.eclipse.scada.configuration.world.osgi.DataType
     * @see #getDefaultDataType()
     * @generated
     */
    void setDefaultDataType ( DataType value );
} // QueryComponent
