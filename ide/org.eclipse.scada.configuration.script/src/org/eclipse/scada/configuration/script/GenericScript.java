/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.script;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generic Script</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A generic script snippet.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.script.GenericScript#getLanguage <em>Language</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.script.ScriptPackage#getGenericScript()
 * @model
 * @generated
 */
public interface GenericScript extends AbstractScript
{
    /**
     * Returns the value of the '<em><b>Language</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Language</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Language</em>' attribute.
     * @see #setLanguage(String)
     * @see org.eclipse.scada.configuration.script.ScriptPackage#getGenericScript_Language()
     * @model required="true"
     * @generated
     */
    String getLanguage ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.script.GenericScript#getLanguage <em>Language</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Language</em>' attribute.
     * @see #getLanguage()
     * @generated
     */
    void setLanguage ( String value );

} // GenericScript
