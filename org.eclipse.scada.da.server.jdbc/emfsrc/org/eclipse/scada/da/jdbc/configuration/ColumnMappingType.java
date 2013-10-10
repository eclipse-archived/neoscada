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
 * A representation of the model object '<em><b>Column Mapping Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.ColumnMappingType#getAliasName <em>Alias Name</em>}</li>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.ColumnMappingType#getColumnNumber <em>Column Number</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage#getColumnMappingType()
 * @model extendedMetaData="name='ColumnMappingType' kind='empty'"
 * @generated
 */
public interface ColumnMappingType extends EObject
{

    /**
     * Returns the value of the '<em><b>Alias Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Alias Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Alias Name</em>' attribute.
     * @see #setAliasName(String)
     * @see org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage#getColumnMappingType_AliasName()
     * @model dataType="org.eclipse.scada.da.jdbc.configuration.AliasNameType" required="true"
     *        extendedMetaData="kind='attribute' name='aliasName'"
     * @generated
     */
    String getAliasName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.jdbc.configuration.ColumnMappingType#getAliasName <em>Alias Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Alias Name</em>' attribute.
     * @see #getAliasName()
     * @generated
     */
    void setAliasName ( String value );

    /**
     * Returns the value of the '<em><b>Column Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Column Number</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Column Number</em>' attribute.
     * @see #isSetColumnNumber()
     * @see #unsetColumnNumber()
     * @see #setColumnNumber(int)
     * @see org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage#getColumnMappingType_ColumnNumber()
     * @model unsettable="true" dataType="org.eclipse.scada.da.jdbc.configuration.ColumnNumberType" required="true"
     *        extendedMetaData="kind='attribute' name='columnNumber'"
     * @generated
     */
    int getColumnNumber ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.jdbc.configuration.ColumnMappingType#getColumnNumber <em>Column Number</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Column Number</em>' attribute.
     * @see #isSetColumnNumber()
     * @see #unsetColumnNumber()
     * @see #getColumnNumber()
     * @generated
     */
    void setColumnNumber ( int value );

    /**
     * Unsets the value of the '{@link org.eclipse.scada.da.jdbc.configuration.ColumnMappingType#getColumnNumber <em>Column Number</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isSetColumnNumber()
     * @see #getColumnNumber()
     * @see #setColumnNumber(int)
     * @generated
     */
    void unsetColumnNumber ();

    /**
     * Returns whether the value of the '{@link org.eclipse.scada.da.jdbc.configuration.ColumnMappingType#getColumnNumber <em>Column Number</em>}' attribute is set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return whether the value of the '<em>Column Number</em>' attribute is set.
     * @see #unsetColumnNumber()
     * @see #getColumnNumber()
     * @see #setColumnNumber(int)
     * @generated
     */
    boolean isSetColumnNumber ();

} // ColumnMappingType
