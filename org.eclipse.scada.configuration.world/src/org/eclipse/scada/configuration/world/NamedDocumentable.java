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
package org.eclipse.scada.configuration.world;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Documentable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.NamedDocumentable#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.WorldPackage#getNamedDocumentable()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface NamedDocumentable extends Documentable
{
    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see org.eclipse.scada.configuration.world.WorldPackage#getNamedDocumentable_Name()
     * @model
     * @generated
     */
    String getName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.NamedDocumentable#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName ( String value );

} // NamedDocumentable
