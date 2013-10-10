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
 * A representation of the model object '<em><b>Update Mapping Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.UpdateMappingType#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.UpdateMappingType#getNamedParameter <em>Named Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage#getUpdateMappingType()
 * @model extendedMetaData="name='UpdateMappingType' kind='empty'"
 * @generated
 */
public interface UpdateMappingType extends EObject
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
     * @see org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage#getUpdateMappingType_Name()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='name'"
     * @generated
     */
    String getName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.jdbc.configuration.UpdateMappingType#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName ( String value );

    /**
     * Returns the value of the '<em><b>Named Parameter</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Named Parameter</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Named Parameter</em>' attribute.
     * @see #setNamedParameter(String)
     * @see org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage#getUpdateMappingType_NamedParameter()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='attribute' name='namedParameter'"
     * @generated
     */
    String getNamedParameter ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.jdbc.configuration.UpdateMappingType#getNamedParameter <em>Named Parameter</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Named Parameter</em>' attribute.
     * @see #getNamedParameter()
     * @generated
     */
    void setNamedParameter ( String value );

} // UpdateMappingType
