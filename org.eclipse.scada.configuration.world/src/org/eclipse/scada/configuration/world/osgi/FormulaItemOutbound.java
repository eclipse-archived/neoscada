/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world.osgi;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Formula Item Outbound</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.FormulaItemOutbound#getOutput <em>Output</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.FormulaItemOutbound#getOutputFormula <em>Output Formula</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.FormulaItemOutbound#getWriteValueVariableName <em>Write Value Variable Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getFormulaItemOutbound()
 * @model
 * @generated
 */
public interface FormulaItemOutbound extends EObject {
	/**
	 * Returns the value of the '<em><b>Output</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output</em>' containment reference.
	 * @see #setOutput(TypedItemReference)
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getFormulaItemOutbound_Output()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	TypedItemReference getOutput();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.FormulaItemOutbound#getOutput <em>Output</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output</em>' containment reference.
	 * @see #getOutput()
	 * @generated
	 */
	void setOutput(TypedItemReference value);

	/**
	 * Returns the value of the '<em><b>Output Formula</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Formula</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Formula</em>' attribute.
	 * @see #setOutputFormula(String)
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getFormulaItemOutbound_OutputFormula()
	 * @model
	 * @generated
	 */
	String getOutputFormula();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.FormulaItemOutbound#getOutputFormula <em>Output Formula</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Formula</em>' attribute.
	 * @see #getOutputFormula()
	 * @generated
	 */
	void setOutputFormula(String value);

	/**
	 * Returns the value of the '<em><b>Write Value Variable Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Write Value Variable Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Write Value Variable Name</em>' attribute.
	 * @see #setWriteValueVariableName(String)
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getFormulaItemOutbound_WriteValueVariableName()
	 * @model
	 * @generated
	 */
	String getWriteValueVariableName();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.FormulaItemOutbound#getWriteValueVariableName <em>Write Value Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Write Value Variable Name</em>' attribute.
	 * @see #getWriteValueVariableName()
	 * @generated
	 */
	void setWriteValueVariableName(String value);

} // FormulaItemOutbound
