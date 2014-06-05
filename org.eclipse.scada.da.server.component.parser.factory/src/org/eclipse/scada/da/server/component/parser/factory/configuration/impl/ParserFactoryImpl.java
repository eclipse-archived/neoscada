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
package org.eclipse.scada.da.server.component.parser.factory.configuration.impl;

import java.util.regex.Pattern;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.scada.da.server.component.parser.factory.configuration.*;
import org.eclipse.scada.da.server.component.parser.factory.configuration.Component;
import org.eclipse.scada.da.server.component.parser.factory.configuration.FileInput;
import org.eclipse.scada.da.server.component.parser.factory.configuration.ParserFactory;
import org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage;
import org.eclipse.scada.da.server.component.parser.factory.configuration.PlainText;
import org.eclipse.scada.da.server.component.parser.factory.configuration.SinglePattern;
import org.eclipse.scada.da.server.component.parser.factory.configuration.UrlInput;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ParserFactoryImpl extends EFactoryImpl implements ParserFactory
{
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static ParserFactory init ()
    {
        try
        {
            ParserFactory theParserFactory = (ParserFactory)EPackage.Registry.INSTANCE.getEFactory ( ParserPackage.eNS_URI );
            if ( theParserFactory != null )
            {
                return theParserFactory;
            }
        }
        catch ( Exception exception )
        {
            EcorePlugin.INSTANCE.log ( exception );
        }
        return new ParserFactoryImpl ();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ParserFactoryImpl ()
    {
        super ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create ( EClass eClass )
    {
        switch ( eClass.getClassifierID () )
        {
            case ParserPackage.COMPONENT:
                return createComponent ();
            case ParserPackage.FILE_INPUT:
                return createFileInput ();
            case ParserPackage.PLAIN_TEXT:
                return createPlainText ();
            case ParserPackage.URL_INPUT:
                return createUrlInput ();
            case ParserPackage.SINGLE_PATTERN:
                return createSinglePattern ();
            case ParserPackage.VALUE_DESCRIPTOR:
                return createValueDescriptor ();
            case ParserPackage.ATTRIBUTE_VALUE:
                return createAttributeValue ();
            case ParserPackage.MAIN_GROUP_FIELD:
                return createMainGroupField ();
            case ParserPackage.STRING_GROUP_FIELD:
                return createStringGroupField ();
            case ParserPackage.NUMERIC_GROUP_FIELD:
                return createNumericGroupField ();
            case ParserPackage.SPLIT_TABLE:
                return createSplitTable ();
            default:
                throw new IllegalArgumentException ( "The class '" + eClass.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object createFromString ( EDataType eDataType, String initialValue )
    {
        switch ( eDataType.getClassifierID () )
        {
            case ParserPackage.VARIANT_TYPE:
                return createVariantTypeFromString ( eDataType, initialValue );
            case ParserPackage.PATTERN:
                return createPatternFromString ( eDataType, initialValue );
            default:
                throw new IllegalArgumentException ( "The datatype '" + eDataType.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String convertToString ( EDataType eDataType, Object instanceValue )
    {
        switch ( eDataType.getClassifierID () )
        {
            case ParserPackage.VARIANT_TYPE:
                return convertVariantTypeToString ( eDataType, instanceValue );
            case ParserPackage.PATTERN:
                return convertPatternToString ( eDataType, instanceValue );
            default:
                throw new IllegalArgumentException ( "The datatype '" + eDataType.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Component createComponent ()
    {
        ComponentImpl component = new ComponentImpl ();
        return component;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public FileInput createFileInput ()
    {
        FileInputImpl fileInput = new FileInputImpl ();
        return fileInput;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PlainText createPlainText ()
    {
        PlainTextImpl plainText = new PlainTextImpl ();
        return plainText;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public UrlInput createUrlInput ()
    {
        UrlInputImpl urlInput = new UrlInputImpl ();
        return urlInput;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public SinglePattern createSinglePattern ()
    {
        SinglePatternImpl singlePattern = new SinglePatternImpl ();
        return singlePattern;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ValueDescriptor createValueDescriptor ()
    {
        ValueDescriptorImpl valueDescriptor = new ValueDescriptorImpl ();
        return valueDescriptor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AttributeValue createAttributeValue ()
    {
        AttributeValueImpl attributeValue = new AttributeValueImpl ();
        return attributeValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MainGroupField createMainGroupField ()
    {
        MainGroupFieldImpl mainGroupField = new MainGroupFieldImpl ();
        return mainGroupField;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public StringGroupField createStringGroupField ()
    {
        StringGroupFieldImpl stringGroupField = new StringGroupFieldImpl ();
        return stringGroupField;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NumericGroupField createNumericGroupField ()
    {
        NumericGroupFieldImpl numericGroupField = new NumericGroupFieldImpl ();
        return numericGroupField;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SplitTable createSplitTable ()
    {
        SplitTableImpl splitTable = new SplitTableImpl ();
        return splitTable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public VariantType createVariantTypeFromString ( EDataType eDataType, String initialValue )
    {
        VariantType result = VariantType.get ( initialValue );
        if ( result == null )
            throw new IllegalArgumentException ( "The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName () + "'" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertVariantTypeToString ( EDataType eDataType, Object instanceValue )
    {
        return instanceValue == null ? null : instanceValue.toString ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    public Pattern createPatternFromString ( final EDataType eDataType, final String initialValue )
    {
        return Pattern.compile ( initialValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertPatternToString ( EDataType eDataType, Object instanceValue )
    {
        return super.convertToString ( eDataType, instanceValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ParserPackage getParserPackage ()
    {
        return (ParserPackage)getEPackage ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static ParserPackage getPackage ()
    {
        return ParserPackage.eINSTANCE;
    }

} //ParserFactoryImpl
