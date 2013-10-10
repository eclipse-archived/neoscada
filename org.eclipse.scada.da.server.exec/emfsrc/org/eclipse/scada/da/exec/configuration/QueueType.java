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
package org.eclipse.scada.da.exec.configuration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Queue Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.QueueType#getCommand <em>Command</em>}</li>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.QueueType#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getQueueType()
 * @model extendedMetaData="name='QueueType' kind='elementOnly'"
 * @generated
 */
public interface QueueType extends EObject
{

    /**
     * Returns the value of the '<em><b>Command</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.da.exec.configuration.SingleCommandType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Command</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Command</em>' containment reference list.
     * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getQueueType_Command()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='command' namespace='##targetNamespace'"
     * @generated
     */
    EList<SingleCommandType> getCommand ();

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
     * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getQueueType_Name()
     * @model dataType="org.eclipse.scada.da.exec.configuration.NameType1"
     *        extendedMetaData="kind='attribute' name='name'"
     * @generated
     */
    String getName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.exec.configuration.QueueType#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName ( String value );

} // QueueType
