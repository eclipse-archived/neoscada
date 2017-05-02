/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.details.model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Script Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.details.model.ScriptModule#getScriptLanguage <em>Script Language</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.ScriptModule#getCode <em>Code</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.ScriptModule#getCodeUri <em>Code Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getScriptModule()
 * @model
 * @generated
 */
public interface ScriptModule extends EObject
{
    /**
     * Returns the value of the '<em><b>Script Language</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Script Language</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The language of the script module. Default is "JavaScript".
     * <!-- end-model-doc -->
     * @return the value of the '<em>Script Language</em>' attribute.
     * @see #setScriptLanguage(String)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getScriptModule_ScriptLanguage()
     * @model
     * @generated
     */
    String getScriptLanguage ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.ScriptModule#getScriptLanguage <em>Script Language</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Script Language</em>' attribute.
     * @see #getScriptLanguage()
     * @generated
     */
    void setScriptLanguage ( String value );

    /**
     * Returns the value of the '<em><b>Code</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Code</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The script code to execute.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Code</em>' attribute.
     * @see #setCode(String)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getScriptModule_Code()
     * @model
     * @generated
     */
    String getCode ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.ScriptModule#getCode <em>Code</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Code</em>' attribute.
     * @see #getCode()
     * @generated
     */
    void setCode ( String value );

    /**
     * Returns the value of the '<em><b>Code Uri</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Code Uri</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The URL which points to a resource that will be executed as script.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Code Uri</em>' attribute.
     * @see #setCodeUri(String)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getScriptModule_CodeUri()
     * @model
     * @generated
     */
    String getCodeUri ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.ScriptModule#getCodeUri <em>Code Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Code Uri</em>' attribute.
     * @see #getCodeUri()
     * @generated
     */
    void setCodeUri ( String value );

} // ScriptModule
