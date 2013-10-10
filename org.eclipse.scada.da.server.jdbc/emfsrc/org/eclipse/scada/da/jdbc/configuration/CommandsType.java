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
 * A representation of the model object '<em><b>Commands Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.CommandsType#getSql <em>Sql</em>}</li>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.CommandsType#getLocalName <em>Local Name</em>}</li>
 *   <li>{@link org.eclipse.scada.da.jdbc.configuration.CommandsType#getSql1 <em>Sql1</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage#getCommandsType()
 * @model extendedMetaData="name='CommandsType' kind='elementOnly'"
 * @generated
 */
public interface CommandsType extends EObject
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
     * @see org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage#getCommandsType_Sql()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='element' name='sql' namespace='##targetNamespace'"
     * @generated
     */
    String getSql ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.jdbc.configuration.CommandsType#getSql <em>Sql</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Sql</em>' attribute.
     * @see #getSql()
     * @generated
     */
    void setSql ( String value );

    /**
     * Returns the value of the '<em><b>Local Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Local Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Local Name</em>' attribute.
     * @see #setLocalName(String)
     * @see org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage#getCommandsType_LocalName()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
     *        extendedMetaData="kind='attribute' name='localName'"
     * @generated
     */
    String getLocalName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.jdbc.configuration.CommandsType#getLocalName <em>Local Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Local Name</em>' attribute.
     * @see #getLocalName()
     * @generated
     */
    void setLocalName ( String value );

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
     * @see org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage#getCommandsType_Sql1()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='sql'"
     * @generated
     */
    String getSql1 ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.jdbc.configuration.CommandsType#getSql1 <em>Sql1</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Sql1</em>' attribute.
     * @see #getSql1()
     * @generated
     */
    void setSql1 ( String value );

} // CommandsType
