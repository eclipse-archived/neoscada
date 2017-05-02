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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Script Visibility</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.details.model.ScriptVisibility#getScript <em>Script</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.ScriptVisibility#getScriptLanguage <em>Script Language</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getScriptVisibility()
 * @model
 * @generated
 */
public interface ScriptVisibility extends Visibility
{
    /**
     * Returns the value of the '<em><b>Script</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Script</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Script</em>' attribute.
     * @see #setScript(String)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getScriptVisibility_Script()
     * @model required="true"
     * @generated
     */
    String getScript ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.ScriptVisibility#getScript <em>Script</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Script</em>' attribute.
     * @see #getScript()
     * @generated
     */
    void setScript ( String value );

    /**
     * Returns the value of the '<em><b>Script Language</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The script interpreter. If left empty "JavaScript" willl be used.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Script Language</em>' attribute.
     * @see #setScriptLanguage(String)
     * @see org.eclipse.scada.vi.details.model.DetailViewPackage#getScriptVisibility_ScriptLanguage()
     * @model
     * @generated
     */
    String getScriptLanguage ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.vi.details.model.ScriptVisibility#getScriptLanguage <em>Script Language</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Script Language</em>' attribute.
     * @see #getScriptLanguage()
     * @generated
     */
    void setScriptLanguage ( String value );

} // ScriptVisibility
