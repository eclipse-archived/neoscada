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
 * A representation of the model object '<em><b>Command Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.CommandType#getProcess <em>Process</em>}</li>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.CommandType#getExtractor <em>Extractor</em>}</li>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.CommandType#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getCommandType()
 * @model abstract="true"
 *        extendedMetaData="name='CommandType' kind='elementOnly'"
 * @generated
 */
public interface CommandType extends EObject
{

    /**
     * Returns the value of the '<em><b>Process</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Process</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Process</em>' containment reference.
     * @see #setProcess(ProcessType)
     * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getCommandType_Process()
     * @model containment="true" required="true"
     *        extendedMetaData="kind='element' name='process' namespace='##targetNamespace'"
     * @generated
     */
    ProcessType getProcess ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.exec.configuration.CommandType#getProcess <em>Process</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Process</em>' containment reference.
     * @see #getProcess()
     * @generated
     */
    void setProcess ( ProcessType value );

    /**
     * Returns the value of the '<em><b>Extractor</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.da.exec.configuration.ExtractorType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Extractor</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Extractor</em>' containment reference list.
     * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getCommandType_Extractor()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='extractor' namespace='##targetNamespace'"
     * @generated
     */
    EList<ExtractorType> getExtractor ();

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
     * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getCommandType_Id()
     * @model id="true" dataType="org.eclipse.emf.ecore.xml.type.ID" required="true"
     *        extendedMetaData="kind='attribute' name='id'"
     * @generated
     */
    String getId ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.exec.configuration.CommandType#getId <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id</em>' attribute.
     * @see #getId()
     * @generated
     */
    void setId ( String value );

} // CommandType
