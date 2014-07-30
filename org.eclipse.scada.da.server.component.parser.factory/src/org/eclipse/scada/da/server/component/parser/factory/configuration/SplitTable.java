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

import java.util.regex.Pattern;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Split Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.SplitTable#getLineSeparatorPattern <em>Line Separator Pattern</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.SplitTable#getFieldSeparatorPattern <em>Field Separator Pattern</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.SplitTable#getIdColumn <em>Id Column</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.SplitTable#getFields <em>Fields</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.SplitTable#getValueConverter <em>Value Converter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getSplitTable()
 * @model
 * @generated
 */
public interface SplitTable extends ExtractorDefinition
{
    /**
     * Returns the value of the '<em><b>Line Separator Pattern</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Line Separator Pattern</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Line Separator Pattern</em>' attribute.
     * @see #setLineSeparatorPattern(Pattern)
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getSplitTable_LineSeparatorPattern()
     * @model dataType="org.eclipse.scada.da.server.component.parser.factory.configuration.Pattern" required="true"
     * @generated
     */
    Pattern getLineSeparatorPattern ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.SplitTable#getLineSeparatorPattern <em>Line Separator Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Line Separator Pattern</em>' attribute.
     * @see #getLineSeparatorPattern()
     * @generated
     */
    void setLineSeparatorPattern ( Pattern value );

    /**
     * Returns the value of the '<em><b>Field Separator Pattern</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Field Separator Pattern</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Field Separator Pattern</em>' attribute.
     * @see #setFieldSeparatorPattern(Pattern)
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getSplitTable_FieldSeparatorPattern()
     * @model dataType="org.eclipse.scada.da.server.component.parser.factory.configuration.Pattern" required="true"
     * @generated
     */
    Pattern getFieldSeparatorPattern ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.SplitTable#getFieldSeparatorPattern <em>Field Separator Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Field Separator Pattern</em>' attribute.
     * @see #getFieldSeparatorPattern()
     * @generated
     */
    void setFieldSeparatorPattern ( Pattern value );

    /**
     * Returns the value of the '<em><b>Id Column</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Id Column</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Id Column</em>' attribute.
     * @see #setIdColumn(int)
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getSplitTable_IdColumn()
     * @model required="true"
     * @generated
     */
    int getIdColumn ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.SplitTable#getIdColumn <em>Id Column</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Id Column</em>' attribute.
     * @see #getIdColumn()
     * @generated
     */
    void setIdColumn ( int value );

    /**
     * Returns the value of the '<em><b>Fields</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * Defines the names of the fields. Of none are set, then the first row will be used instead.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Fields</em>' attribute list.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getSplitTable_Fields()
     * @model
     * @generated
     */
    EList<String> getFields ();

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
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#getSplitTable_ValueConverter()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    ValueConverterDefinition getValueConverter ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.SplitTable#getValueConverter <em>Value Converter</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value Converter</em>' containment reference.
     * @see #getValueConverter()
     * @generated
     */
    void setValueConverter ( ValueConverterDefinition value );

} // SplitTable
