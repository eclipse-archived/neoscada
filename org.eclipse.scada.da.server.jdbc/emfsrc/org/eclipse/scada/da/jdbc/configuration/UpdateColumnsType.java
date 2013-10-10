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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Update Columns Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.UpdateColumnsType#getColumnName <em>Column Name</em>}</li>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.UpdateColumnsType#getCustomUpdateSql <em>Custom Update Sql</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage#getUpdateColumnsType()
 * @model extendedMetaData="name='UpdateColumnsType' kind='empty'"
 * @generated
 */
public interface UpdateColumnsType extends EObject
{

    /**
     * Returns the value of the '<em><b>Column Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Column Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Column Name</em>' attribute.
     * @see #setColumnName(String)
     * @see org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage#getUpdateColumnsType_ColumnName()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='attribute' name='columnName'"
     * @generated
     */
    String getColumnName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.jdbc.configuration.UpdateColumnsType#getColumnName <em>Column Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Column Name</em>' attribute.
     * @see #getColumnName()
     * @generated
     */
    void setColumnName ( String value );

    /**
     * Returns the value of the '<em><b>Custom Update Sql</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Custom Update Sql</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * This SQL needs to have exactly one parameter. The value.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Custom Update Sql</em>' attribute.
     * @see #setCustomUpdateSql(String)
     * @see org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage#getUpdateColumnsType_CustomUpdateSql()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='customUpdateSql'"
     * @generated
     */
    String getCustomUpdateSql ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.jdbc.configuration.UpdateColumnsType#getCustomUpdateSql <em>Custom Update Sql</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Custom Update Sql</em>' attribute.
     * @see #getCustomUpdateSql()
     * @generated
     */
    void setCustomUpdateSql ( String value );

} // UpdateColumnsType
