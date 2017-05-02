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
package org.eclipse.scada.configuration.item;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Custom Script Selector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.item.CustomScriptSelector#getScriptEngine <em>Script Engine</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.item.ItemPackage#getCustomScriptSelector()
 * @model
 * @generated
 */
public interface CustomScriptSelector extends ScriptSelector
{
    /**
     * Returns the value of the '<em><b>Script Engine</b></em>' attribute.
     * The default value is <code>"JavaScript"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Script Engine</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Script Engine</em>' attribute.
     * @see #setScriptEngine(String)
     * @see org.eclipse.scada.configuration.item.ItemPackage#getCustomScriptSelector_ScriptEngine()
     * @model default="JavaScript" required="true"
     * @generated
     */
    String getScriptEngine ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.item.CustomScriptSelector#getScriptEngine <em>Script Engine</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Script Engine</em>' attribute.
     * @see #getScriptEngine()
     * @generated
     */
    void setScriptEngine ( String value );

} // CustomScriptSelector
