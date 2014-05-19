/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.memory;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.scada.configuration.memory.Type#getIndex <em>Index
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.scada.configuration.memory.MemoryPackage#getType()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Type extends EObject
{

    /**
     * Returns the value of the '<em><b>Index</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Index</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Index</em>' attribute.
     * @see #setIndex(int)
     * @see org.eclipse.scada.configuration.memory.MemoryPackage#getType_Index()
     * @model required="true"
     * @generated
     */
    int getIndex ();

    /**
     * Sets the value of the '
     * {@link org.eclipse.scada.configuration.memory.Type#getIndex
     * <em>Index</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Index</em>' attribute.
     * @see #getIndex()
     * @generated
     */
    void setIndex ( int value );

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @model required="true"
     * @generated
     */
    String encode ();
} // Type
