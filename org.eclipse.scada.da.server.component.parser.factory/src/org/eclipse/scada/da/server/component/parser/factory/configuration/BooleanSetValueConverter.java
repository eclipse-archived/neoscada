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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Set Value Converter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.BooleanSetValueConverter#getTrueValues <em>True Values</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.BooleanSetValueConverter#getFalseValues <em>False Values</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.BooleanSetValueConverter#getOtherwise <em>Otherwise</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.BooleanSetValueConverter#isIgnoreCase <em>Ignore Case</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getBooleanSetValueConverter()
 * @model
 * @generated
 */
public interface BooleanSetValueConverter extends ValueConverterDefinition
{
    /**
     * Returns the value of the '<em><b>True Values</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>True Values</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>True Values</em>' attribute list.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getBooleanSetValueConverter_TrueValues()
     * @model
     * @generated
     */
    EList<String> getTrueValues ();

    /**
     * Returns the value of the '<em><b>False Values</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>False Values</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>False Values</em>' attribute list.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getBooleanSetValueConverter_FalseValues()
     * @model
     * @generated
     */
    EList<String> getFalseValues ();

    /**
     * Returns the value of the '<em><b>Otherwise</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Otherwise</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Otherwise</em>' attribute.
     * @see #setOtherwise(Boolean)
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getBooleanSetValueConverter_Otherwise()
     * @model
     * @generated
     */
    Boolean getOtherwise ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.BooleanSetValueConverter#getOtherwise <em>Otherwise</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Otherwise</em>' attribute.
     * @see #getOtherwise()
     * @generated
     */
    void setOtherwise ( Boolean value );

    /**
     * Returns the value of the '<em><b>Ignore Case</b></em>' attribute.
     * The default value is <code>"false"</code>.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Ignore Case</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Ignore Case</em>' attribute.
     * @see #setIgnoreCase(boolean)
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getBooleanSetValueConverter_IgnoreCase()
     * @model default="false" required="true"
     * @generated
     */
    boolean isIgnoreCase ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.BooleanSetValueConverter#isIgnoreCase <em>Ignore Case</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Ignore Case</em>' attribute.
     * @see #isIgnoreCase()
     * @generated
     */
    void setIgnoreCase ( boolean value );

} // BooleanSetValueConverter
