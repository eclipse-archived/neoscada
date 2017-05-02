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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage
 * @generated
 */
public interface ParserFactory extends EFactory
{
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ParserFactory eINSTANCE = org.eclipse.scada.da.server.component.parser.factory.configuration.impl.ParserFactoryImpl.init ();

    /**
     * Returns a new object of class '<em>Component</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Component</em>'.
     * @generated
     */
    Component createComponent ();

    /**
     * Returns a new object of class '<em>File Input</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>File Input</em>'.
     * @generated
     */
    FileInput createFileInput ();

    /**
     * Returns a new object of class '<em>Plain Text</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Plain Text</em>'.
     * @generated
     */
    PlainText createPlainText ();

    /**
     * Returns a new object of class '<em>Url Input</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Url Input</em>'.
     * @generated
     */
    UrlInput createUrlInput ();

    /**
     * Returns a new object of class '<em>Single Pattern</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Single Pattern</em>'.
     * @generated
     */
    SinglePattern createSinglePattern ();

    /**
     * Returns a new object of class '<em>Value Descriptor</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Value Descriptor</em>'.
     * @generated
     */
    ValueDescriptor createValueDescriptor ();

    /**
     * Returns a new object of class '<em>Attribute Value</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Attribute Value</em>'.
     * @generated
     */
    AttributeValue createAttributeValue ();

    /**
     * Returns a new object of class '<em>Main Group Field</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Main Group Field</em>'.
     * @generated
     */
    MainGroupField createMainGroupField ();

    /**
     * Returns a new object of class '<em>String Group Field</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>String Group Field</em>'.
     * @generated
     */
    StringGroupField createStringGroupField ();

    /**
     * Returns a new object of class '<em>Numeric Group Field</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Numeric Group Field</em>'.
     * @generated
     */
    NumericGroupField createNumericGroupField ();

    /**
     * Returns a new object of class '<em>Split Table</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Split Table</em>'.
     * @generated
     */
    SplitTable createSplitTable ();

    /**
     * Returns a new object of class '<em>String Transformer</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>String Transformer</em>'.
     * @generated
     */
    StringTransformer createStringTransformer ();

    /**
     * Returns a new object of class '<em>Mqtt Input</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Mqtt Input</em>'.
     * @generated
     */
    MqttInput createMqttInput ();

    /**
     * Returns a new object of class '<em>Boolean Value Converter</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Boolean Value Converter</em>'.
     * @generated
     */
    BooleanValueConverter createBooleanValueConverter ();

    /**
     * Returns a new object of class '<em>Default Value Converter</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Default Value Converter</em>'.
     * @generated
     */
    DefaultValueConverter createDefaultValueConverter ();

    /**
     * Returns a new object of class '<em>Double Value Converter</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Double Value Converter</em>'.
     * @generated
     */
    DoubleValueConverter createDoubleValueConverter ();

    /**
     * Returns a new object of class '<em>Boolean Set Value Converter</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Boolean Set Value Converter</em>'.
     * @generated
     */
    BooleanSetValueConverter createBooleanSetValueConverter ();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    ParserPackage getParserPackage ();

} //ParserFactory
