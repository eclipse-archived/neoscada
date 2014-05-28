/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 */
package org.eclipse.scada.da.server.component.parser.factory.configuration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Plain Text</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.PlainText#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.PlainText#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.PlainText#isTrim <em>Trim</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getPlainText()
 * @model
 * @generated
 */
public interface PlainText extends ExtractorDefinition
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
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getPlainText_Name()
     * @model required="true"
     * @generated
     */
    String getName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.PlainText#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName ( String value );

    /**
     * Returns the value of the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Description</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Description</em>' attribute.
     * @see #setDescription(String)
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getPlainText_Description()
     * @model
     * @generated
     */
    String getDescription ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.PlainText#getDescription <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Description</em>' attribute.
     * @see #getDescription()
     * @generated
     */
    void setDescription ( String value );

    /**
     * Returns the value of the '<em><b>Trim</b></em>' attribute.
     * The default value is <code>"true"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Trim</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Trim</em>' attribute.
     * @see #setTrim(boolean)
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getPlainText_Trim()
     * @model default="true" required="true"
     * @generated
     */
    boolean isTrim ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.PlainText#isTrim <em>Trim</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Trim</em>' attribute.
     * @see #isTrim()
     * @generated
     */
    void setTrim ( boolean value );
} // PlainText
