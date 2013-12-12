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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Formula Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.FormulaItem#getScriptEngine <em>Script Engine</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.FormulaItem#getInitScripts <em>Init Scripts</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.FormulaItem#getOutbound <em>Outbound</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.FormulaItem#getInbound <em>Inbound</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getFormulaItem()
 * @model
 * @generated
 */
public interface FormulaItem extends Item {
	/**
	 * Returns the value of the '<em><b>Script Engine</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Script Engine</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Script Engine</em>' attribute.
	 * @see #setScriptEngine(String)
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getFormulaItem_ScriptEngine()
	 * @model
	 * @generated
	 */
	String getScriptEngine();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.FormulaItem#getScriptEngine <em>Script Engine</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Script Engine</em>' attribute.
	 * @see #getScriptEngine()
	 * @generated
	 */
	void setScriptEngine(String value);

	/**
	 * Returns the value of the '<em><b>Init Scripts</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.CodeFragment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Scripts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init Scripts</em>' containment reference list.
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getFormulaItem_InitScripts()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<CodeFragment> getInitScripts();

	/**
	 * Returns the value of the '<em><b>Outbound</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outbound</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outbound</em>' containment reference.
	 * @see #setOutbound(FormulaItemOutbound)
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getFormulaItem_Outbound()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	FormulaItemOutbound getOutbound();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.FormulaItem#getOutbound <em>Outbound</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outbound</em>' containment reference.
	 * @see #getOutbound()
	 * @generated
	 */
	void setOutbound(FormulaItemOutbound value);

	/**
	 * Returns the value of the '<em><b>Inbound</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inbound</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inbound</em>' containment reference.
	 * @see #setInbound(FormulaItemInbound)
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getFormulaItem_Inbound()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	FormulaItemInbound getInbound();

	/**
	 * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.FormulaItem#getInbound <em>Inbound</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inbound</em>' containment reference.
	 * @see #getInbound()
	 * @generated
	 */
	void setInbound(FormulaItemInbound value);

} // FormulaItem
