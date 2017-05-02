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
 * A representation of the model object '<em><b>Abstract Script</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.script.AbstractScript#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.script.ScriptPackage#getAbstractScript()
 * @model abstract="true"
 * @generated
 */
public interface AbstractScript extends Script
{
    /**
     * Returns the value of the '<em><b>Source</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Source</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Source</em>' attribute.
     * @see #setSource(String)
     * @see org.eclipse.scada.configuration.script.ScriptPackage#getAbstractScript_Source()
     * @model required="true"
     * @generated
     */
    String getSource ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.script.AbstractScript#getSource <em>Source</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Source</em>' attribute.
     * @see #getSource()
     * @generated
     */
    void setSource ( String value );

} // AbstractScript
