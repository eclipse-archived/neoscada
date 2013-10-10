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
 * A representation of the model object '<em><b>Update Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.UpdateType#getSql <em>Sql</em>}</li>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.UpdateType#getMapping <em>Mapping</em>}</li>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.UpdateType#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.UpdateType#getSql1 <em>Sql1</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage#getUpdateType()
 * @model extendedMetaData="name='UpdateType' kind='elementOnly'"
 * @generated
 */
public interface UpdateType extends EObject
{

    /**
     * Returns the value of the '<em><b>Sql</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Sql</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Sql</em>' attribute.
     * @see #setSql(String)
     * @see org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage#getUpdateType_Sql()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='element' name='sql' namespace='##targetNamespace'"
     * @generated
     */
    String getSql ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.jdbc.configuration.UpdateType#getSql <em>Sql</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Sql</em>' attribute.
     * @see #getSql()
     * @generated
     */
    void setSql ( String value );

    /**
     * Returns the value of the '<em><b>Mapping</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.da.jdbc.configuration.UpdateMappingType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Mapping</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Mapping</em>' containment reference list.
     * @see org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage#getUpdateType_Mapping()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='mapping' namespace='##targetNamespace'"
     * @generated
     */
    EList<UpdateMappingType> getMapping ();

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
     * @see org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage#getUpdateType_Id()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='attribute' name='id'"
     * @generated
     */
    String getId ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.jdbc.configuration.UpdateType#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId ( String value );

    /**
     * Returns the value of the '<em><b>Sql1</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Sql1</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Sql1</em>' attribute.
     * @see #setSql1(String)
     * @see org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage#getUpdateType_Sql1()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='sql'"
     * @generated
     */
    String getSql1 ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.jdbc.configuration.UpdateType#getSql1 <em>Sql1</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Sql1</em>' attribute.
     * @see #getSql1()
     * @generated
     */
    void setSql1 ( String value );

} // UpdateType
