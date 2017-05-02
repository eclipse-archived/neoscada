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
 * A representation of the model object '
 * <em><b>Script Customization Pipeline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.item.ScriptCustomizationPipeline#getCode <em>Code</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.item.ItemPackage#getScriptCustomizationPipeline()
 * @model abstract="true"
 * @generated
 */
public interface ScriptCustomizationPipeline extends CustomizationPipeline
{
    /**
     * Returns the value of the '<em><b>Code</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Code</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Code</em>' attribute.
     * @see #setCode(String)
     * @see org.eclipse.scada.configuration.item.ItemPackage#getScriptCustomizationPipeline_Code()
     * @model
     * @generated
     */
    String getCode ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.item.ScriptCustomizationPipeline#getCode <em>Code</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Code</em>' attribute.
     * @see #getCode()
     * @generated
     */
    void setCode ( String value );

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation" required="true"
     * @generated
     */
    String getScriptEngine ();

} // ScriptCustomizationPipeline
