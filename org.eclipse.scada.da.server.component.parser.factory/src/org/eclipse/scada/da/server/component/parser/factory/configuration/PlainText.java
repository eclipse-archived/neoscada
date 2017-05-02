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
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.PlainText#isTrim <em>Trim</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.PlainText#getValueConverter <em>Value Converter</em>}</li>
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

    /**
     * Returns the value of the '<em><b>Value Converter</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Value Converter</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Value Converter</em>' containment reference.
     * @see #setValueConverter(ValueConverterDefinition)
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getPlainText_ValueConverter()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    ValueConverterDefinition getValueConverter ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.PlainText#getValueConverter <em>Value Converter</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value Converter</em>' containment reference.
     * @see #getValueConverter()
     * @generated
     */
    void setValueConverter ( ValueConverterDefinition value );
} // PlainText
