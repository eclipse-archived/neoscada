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
 * A representation of the model object '<em><b>Process Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.ProcessType#getArgument <em>Argument</em>}</li>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.ProcessType#getEnv <em>Env</em>}</li>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.ProcessType#getExec <em>Exec</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getProcessType()
 * @model extendedMetaData="name='ProcessType' kind='elementOnly'"
 * @generated
 */
public interface ProcessType extends EObject
{

    /**
     * Returns the value of the '<em><b>Argument</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Argument</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Argument</em>' attribute list.
     * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getProcessType_Argument()
     * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='element' name='argument' namespace='##targetNamespace'"
     * @generated
     */
    EList<String> getArgument ();

    /**
     * Returns the value of the '<em><b>Env</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.da.exec.configuration.EnvEntryType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Env</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Env</em>' containment reference list.
     * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getProcessType_Env()
     * @model containment="true"
     *        extendedMetaData="kind='element' name='env' namespace='##targetNamespace'"
     * @generated
     */
    EList<EnvEntryType> getEnv ();

    /**
     * Returns the value of the '<em><b>Exec</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Exec</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Exec</em>' attribute.
     * @see #setExec(String)
     * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getProcessType_Exec()
     * @model dataType="org.eclipse.emf.ecore.xml.type.String"
     *        extendedMetaData="kind='attribute' name='exec'"
     * @generated
     */
    String getExec ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.exec.configuration.ProcessType#getExec <em>Exec</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Exec</em>' attribute.
     * @see #getExec()
     * @generated
     */
    void setExec ( String value );

} // ProcessType
