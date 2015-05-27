/**
 * Copyright (c) 2015 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.memory;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fixed Length String Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.memory.FixedLengthStringType#getMaxLength <em>Max Length</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.memory.FixedLengthStringType#getCharset <em>Charset</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.memory.MemoryPackage#getFixedLengthStringType()
 * @model
 * @generated
 */
public interface FixedLengthStringType extends BaseScalarType
{
    /**
     * Returns the value of the '<em><b>Max Length</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Max Length</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Max Length</em>' attribute.
     * @see #setMaxLength(int)
     * @see org.eclipse.scada.configuration.memory.MemoryPackage#getFixedLengthStringType_MaxLength()
     * @model required="true"
     * @generated
     */
    int getMaxLength ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.memory.FixedLengthStringType#getMaxLength <em>Max Length</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Max Length</em>' attribute.
     * @see #getMaxLength()
     * @generated
     */
    void setMaxLength ( int value );

    /**
     * Returns the value of the '<em><b>Charset</b></em>' attribute.
     * The default value is <code>"UTF-8"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Charset</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Charset</em>' attribute.
     * @see #setCharset(String)
     * @see org.eclipse.scada.configuration.memory.MemoryPackage#getFixedLengthStringType_Charset()
     * @model default="UTF-8" required="true"
     * @generated
     */
    String getCharset ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.memory.FixedLengthStringType#getCharset <em>Charset</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Charset</em>' attribute.
     * @see #getCharset()
     * @generated
     */
    void setCharset ( String value );

} // FixedLengthStringType
