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
package org.eclipse.scada.configuration.security;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Script Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.security.ScriptRule#getScript <em>Script</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.security.ScriptRule#getCallbackScript <em>Callback Script</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.security.SecurityPackage#getScriptRule()
 * @model
 * @generated
 */
public interface ScriptRule extends Rule
{

    /**
     * Returns the value of the '<em><b>Script</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Script</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Script</em>' reference.
     * @see #setScript(Script)
     * @see org.eclipse.scada.configuration.security.SecurityPackage#getScriptRule_Script()
     * @model
     * @generated
     */
    Script getScript ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.security.ScriptRule#getScript <em>Script</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Script</em>' reference.
     * @see #getScript()
     * @generated
     */
    void setScript ( Script value );

    /**
     * Returns the value of the '<em><b>Callback Script</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Callback Script</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Callback Script</em>' reference.
     * @see #setCallbackScript(Script)
     * @see org.eclipse.scada.configuration.security.SecurityPackage#getScriptRule_CallbackScript()
     * @model
     * @generated
     */
    Script getCallbackScript ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.security.ScriptRule#getCallbackScript <em>Callback Script</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Callback Script</em>' reference.
     * @see #getCallbackScript()
     * @generated
     */
    void setCallbackScript ( Script value );
} // ScriptRule
