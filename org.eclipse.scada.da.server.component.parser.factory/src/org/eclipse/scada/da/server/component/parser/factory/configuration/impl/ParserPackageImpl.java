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
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.scada.base.extractor.convert.ValueConverter;
import org.eclipse.scada.base.extractor.extract.Extractor;
import org.eclipse.scada.base.extractor.input.Input;
import org.eclipse.scada.base.extractor.transform.Transformer;
import org.eclipse.scada.da.server.component.parser.factory.CreationContext;
import org.eclipse.scada.da.server.component.parser.factory.configuration.AbstractInput;
import org.eclipse.scada.da.server.component.parser.factory.configuration.AbstractPeriodInput;
import org.eclipse.scada.da.server.component.parser.factory.configuration.AttributeValue;
import org.eclipse.scada.da.server.component.parser.factory.configuration.BooleanSetValueConverter;
import org.eclipse.scada.da.server.component.parser.factory.configuration.BooleanValueConverter;
import org.eclipse.scada.da.server.component.parser.factory.configuration.Component;
import org.eclipse.scada.da.server.component.parser.factory.configuration.DefaultValueConverter;
import org.eclipse.scada.da.server.component.parser.factory.configuration.DoubleValueConverter;
import org.eclipse.scada.da.server.component.parser.factory.configuration.ExtractorDefinition;
import org.eclipse.scada.da.server.component.parser.factory.configuration.Field;
import org.eclipse.scada.da.server.component.parser.factory.configuration.FileInput;
import org.eclipse.scada.da.server.component.parser.factory.configuration.InputDefinition;
import org.eclipse.scada.da.server.component.parser.factory.configuration.MainGroupField;
import org.eclipse.scada.da.server.component.parser.factory.configuration.MqttInput;
import org.eclipse.scada.da.server.component.parser.factory.configuration.NumericGroupField;
import org.eclipse.scada.da.server.component.parser.factory.configuration.ParserFactory;
import org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage;
import org.eclipse.scada.da.server.component.parser.factory.configuration.PlainText;
import org.eclipse.scada.da.server.component.parser.factory.configuration.SinglePattern;
import org.eclipse.scada.da.server.component.parser.factory.configuration.SplitTable;
import org.eclipse.scada.da.server.component.parser.factory.configuration.StringGroupField;
import org.eclipse.scada.da.server.component.parser.factory.configuration.StringTransformer;
import org.eclipse.scada.da.server.component.parser.factory.configuration.TransformerDefinition;
import org.eclipse.scada.da.server.component.parser.factory.configuration.UrlInput;
import org.eclipse.scada.da.server.component.parser.factory.configuration.ValueConverterDefinition;
import org.eclipse.scada.da.server.component.parser.factory.configuration.ValueDescriptor;
import org.eclipse.scada.da.server.component.parser.factory.configuration.VariantType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ParserPackageImpl extends EPackageImpl implements ParserPackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass componentEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass inputDefinitionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass fileInputEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass extractorDefinitionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass plainTextEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass abstractPeriodInputEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass urlInputEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass singlePatternEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass valueDescriptorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass fieldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass attributeValueEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass mainGroupFieldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass stringGroupFieldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass numericGroupFieldEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass splitTableEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass transformerDefinitionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass stringTransformerEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass mqttInputEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass abstractInputEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass valueConverterDefinitionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass booleanValueConverterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass defaultValueConverterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass doubleValueConverterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass booleanSetValueConverterEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum variantTypeEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType inputEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType creationContextEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType extractorEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType patternEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType transformerEDataType = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType valueConverterEDataType = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private ParserPackageImpl ()
    {
        super ( eNS_URI, ParserFactory.eINSTANCE );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link ParserPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static ParserPackage init ()
    {
        if ( isInited )
            return (ParserPackage)EPackage.Registry.INSTANCE.getEPackage ( ParserPackage.eNS_URI );

        // Obtain or create and register package
        ParserPackageImpl theParserPackage = (ParserPackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof ParserPackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new ParserPackageImpl () );

        isInited = true;

        // Create package meta-data objects
        theParserPackage.createPackageContents ();

        // Initialize created meta-data
        theParserPackage.initializePackageContents ();

        // Mark meta-data to indicate it can't be changed
        theParserPackage.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( ParserPackage.eNS_URI, theParserPackage );
        return theParserPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getComponent ()
    {
        return componentEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getComponent_Id ()
    {
        return (EAttribute)componentEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getComponent_Input ()
    {
        return (EReference)componentEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getComponent_Extractors ()
    {
        return (EReference)componentEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getInputDefinition ()
    {
        return inputDefinitionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getInputDefinition_Transformers ()
    {
        return (EReference)inputDefinitionEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getInputDefinition__CreateInput__CreationContext ()
    {
        return inputDefinitionEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFileInput ()
    {
        return fileInputEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFileInput_FileName ()
    {
        return (EAttribute)fileInputEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getExtractorDefinition ()
    {
        return extractorDefinitionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExtractorDefinition_Prefix ()
    {
        return (EAttribute)extractorDefinitionEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getExtractorDefinition__CreateExtractor__CreationContext ()
    {
        return extractorDefinitionEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPlainText ()
    {
        return plainTextEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPlainText_Trim ()
    {
        return (EAttribute)plainTextEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPlainText_ValueConverter ()
    {
        return (EReference)plainTextEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAbstractPeriodInput ()
    {
        return abstractPeriodInputEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAbstractPeriodInput_Period ()
    {
        return (EAttribute)abstractPeriodInputEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getUrlInput ()
    {
        return urlInputEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUrlInput_Url ()
    {
        return (EAttribute)urlInputEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUrlInput_ProbeCharacterSet ()
    {
        return (EAttribute)urlInputEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getUrlInput_Charset ()
    {
        return (EAttribute)urlInputEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSinglePattern ()
    {
        return singlePatternEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSinglePattern_Pattern ()
    {
        return (EAttribute)singlePatternEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSinglePattern_FullMatch ()
    {
        return (EAttribute)singlePatternEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSinglePattern_Value ()
    {
        return (EReference)singlePatternEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getValueDescriptor ()
    {
        return valueDescriptorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getValueDescriptor_PrimaryValue ()
    {
        return (EReference)valueDescriptorEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getValueDescriptor_Attributes ()
    {
        return (EReference)valueDescriptorEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getField ()
    {
        return fieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getField_Type ()
    {
        return (EAttribute)fieldEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAttributeValue ()
    {
        return attributeValueEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAttributeValue_Name ()
    {
        return (EAttribute)attributeValueEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getAttributeValue_Field ()
    {
        return (EReference)attributeValueEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMainGroupField ()
    {
        return mainGroupFieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getStringGroupField ()
    {
        return stringGroupFieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getStringGroupField_GroupName ()
    {
        return (EAttribute)stringGroupFieldEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getNumericGroupField ()
    {
        return numericGroupFieldEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getNumericGroupField_GroupNumber ()
    {
        return (EAttribute)numericGroupFieldEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSplitTable ()
    {
        return splitTableEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSplitTable_LineSeparatorPattern ()
    {
        return (EAttribute)splitTableEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSplitTable_FieldSeparatorPattern ()
    {
        return (EAttribute)splitTableEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSplitTable_IdColumn ()
    {
        return (EAttribute)splitTableEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getSplitTable_Fields ()
    {
        return (EAttribute)splitTableEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSplitTable_ValueConverter ()
    {
        return (EReference)splitTableEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTransformerDefinition ()
    {
        return transformerDefinitionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getTransformerDefinition__CreateTransformer__CreationContext ()
    {
        return transformerDefinitionEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getStringTransformer ()
    {
        return stringTransformerEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getStringTransformer_Charset ()
    {
        return (EAttribute)stringTransformerEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMqttInput ()
    {
        return mqttInputEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMqttInput_ServerUri ()
    {
        return (EAttribute)mqttInputEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMqttInput_ClientId ()
    {
        return (EAttribute)mqttInputEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMqttInput_Topic ()
    {
        return (EAttribute)mqttInputEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMqttInput_Qos ()
    {
        return (EAttribute)mqttInputEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAbstractInput ()
    {
        return abstractInputEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getValueConverterDefinition ()
    {
        return valueConverterDefinitionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getValueConverterDefinition__CreateConverter ()
    {
        return valueConverterDefinitionEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getBooleanValueConverter ()
    {
        return booleanValueConverterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDefaultValueConverter ()
    {
        return defaultValueConverterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDoubleValueConverter ()
    {
        return doubleValueConverterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getBooleanSetValueConverter ()
    {
        return booleanSetValueConverterEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getBooleanSetValueConverter_TrueValues ()
    {
        return (EAttribute)booleanSetValueConverterEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getBooleanSetValueConverter_FalseValues ()
    {
        return (EAttribute)booleanSetValueConverterEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getBooleanSetValueConverter_Otherwise ()
    {
        return (EAttribute)booleanSetValueConverterEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getBooleanSetValueConverter_IgnoreCase ()
    {
        return (EAttribute)booleanSetValueConverterEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EEnum getVariantType ()
    {
        return variantTypeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getInput ()
    {
        return inputEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getCreationContext ()
    {
        return creationContextEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getExtractor ()
    {
        return extractorEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getPattern ()
    {
        return patternEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getTransformer ()
    {
        return transformerEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getValueConverter ()
    {
        return valueConverterEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ParserFactory getParserFactory ()
    {
        return (ParserFactory)getEFactoryInstance ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents ()
    {
        if ( isCreated )
            return;
        isCreated = true;

        // Create classes and their features
        componentEClass = createEClass ( COMPONENT );
        createEAttribute ( componentEClass, COMPONENT__ID );
        createEReference ( componentEClass, COMPONENT__INPUT );
        createEReference ( componentEClass, COMPONENT__EXTRACTORS );

        inputDefinitionEClass = createEClass ( INPUT_DEFINITION );
        createEReference ( inputDefinitionEClass, INPUT_DEFINITION__TRANSFORMERS );
        createEOperation ( inputDefinitionEClass, INPUT_DEFINITION___CREATE_INPUT__CREATIONCONTEXT );

        fileInputEClass = createEClass ( FILE_INPUT );
        createEAttribute ( fileInputEClass, FILE_INPUT__FILE_NAME );

        extractorDefinitionEClass = createEClass ( EXTRACTOR_DEFINITION );
        createEAttribute ( extractorDefinitionEClass, EXTRACTOR_DEFINITION__PREFIX );
        createEOperation ( extractorDefinitionEClass, EXTRACTOR_DEFINITION___CREATE_EXTRACTOR__CREATIONCONTEXT );

        plainTextEClass = createEClass ( PLAIN_TEXT );
        createEAttribute ( plainTextEClass, PLAIN_TEXT__TRIM );
        createEReference ( plainTextEClass, PLAIN_TEXT__VALUE_CONVERTER );

        abstractPeriodInputEClass = createEClass ( ABSTRACT_PERIOD_INPUT );
        createEAttribute ( abstractPeriodInputEClass, ABSTRACT_PERIOD_INPUT__PERIOD );

        urlInputEClass = createEClass ( URL_INPUT );
        createEAttribute ( urlInputEClass, URL_INPUT__URL );
        createEAttribute ( urlInputEClass, URL_INPUT__PROBE_CHARACTER_SET );
        createEAttribute ( urlInputEClass, URL_INPUT__CHARSET );

        singlePatternEClass = createEClass ( SINGLE_PATTERN );
        createEAttribute ( singlePatternEClass, SINGLE_PATTERN__PATTERN );
        createEAttribute ( singlePatternEClass, SINGLE_PATTERN__FULL_MATCH );
        createEReference ( singlePatternEClass, SINGLE_PATTERN__VALUE );

        valueDescriptorEClass = createEClass ( VALUE_DESCRIPTOR );
        createEReference ( valueDescriptorEClass, VALUE_DESCRIPTOR__PRIMARY_VALUE );
        createEReference ( valueDescriptorEClass, VALUE_DESCRIPTOR__ATTRIBUTES );

        fieldEClass = createEClass ( FIELD );
        createEAttribute ( fieldEClass, FIELD__TYPE );

        attributeValueEClass = createEClass ( ATTRIBUTE_VALUE );
        createEAttribute ( attributeValueEClass, ATTRIBUTE_VALUE__NAME );
        createEReference ( attributeValueEClass, ATTRIBUTE_VALUE__FIELD );

        mainGroupFieldEClass = createEClass ( MAIN_GROUP_FIELD );

        stringGroupFieldEClass = createEClass ( STRING_GROUP_FIELD );
        createEAttribute ( stringGroupFieldEClass, STRING_GROUP_FIELD__GROUP_NAME );

        numericGroupFieldEClass = createEClass ( NUMERIC_GROUP_FIELD );
        createEAttribute ( numericGroupFieldEClass, NUMERIC_GROUP_FIELD__GROUP_NUMBER );

        splitTableEClass = createEClass ( SPLIT_TABLE );
        createEAttribute ( splitTableEClass, SPLIT_TABLE__LINE_SEPARATOR_PATTERN );
        createEAttribute ( splitTableEClass, SPLIT_TABLE__FIELD_SEPARATOR_PATTERN );
        createEAttribute ( splitTableEClass, SPLIT_TABLE__ID_COLUMN );
        createEAttribute ( splitTableEClass, SPLIT_TABLE__FIELDS );
        createEReference ( splitTableEClass, SPLIT_TABLE__VALUE_CONVERTER );

        transformerDefinitionEClass = createEClass ( TRANSFORMER_DEFINITION );
        createEOperation ( transformerDefinitionEClass, TRANSFORMER_DEFINITION___CREATE_TRANSFORMER__CREATIONCONTEXT );

        stringTransformerEClass = createEClass ( STRING_TRANSFORMER );
        createEAttribute ( stringTransformerEClass, STRING_TRANSFORMER__CHARSET );

        mqttInputEClass = createEClass ( MQTT_INPUT );
        createEAttribute ( mqttInputEClass, MQTT_INPUT__SERVER_URI );
        createEAttribute ( mqttInputEClass, MQTT_INPUT__CLIENT_ID );
        createEAttribute ( mqttInputEClass, MQTT_INPUT__TOPIC );
        createEAttribute ( mqttInputEClass, MQTT_INPUT__QOS );

        abstractInputEClass = createEClass ( ABSTRACT_INPUT );

        valueConverterDefinitionEClass = createEClass ( VALUE_CONVERTER_DEFINITION );
        createEOperation ( valueConverterDefinitionEClass, VALUE_CONVERTER_DEFINITION___CREATE_CONVERTER );

        booleanValueConverterEClass = createEClass ( BOOLEAN_VALUE_CONVERTER );

        defaultValueConverterEClass = createEClass ( DEFAULT_VALUE_CONVERTER );

        doubleValueConverterEClass = createEClass ( DOUBLE_VALUE_CONVERTER );

        booleanSetValueConverterEClass = createEClass ( BOOLEAN_SET_VALUE_CONVERTER );
        createEAttribute ( booleanSetValueConverterEClass, BOOLEAN_SET_VALUE_CONVERTER__TRUE_VALUES );
        createEAttribute ( booleanSetValueConverterEClass, BOOLEAN_SET_VALUE_CONVERTER__FALSE_VALUES );
        createEAttribute ( booleanSetValueConverterEClass, BOOLEAN_SET_VALUE_CONVERTER__OTHERWISE );
        createEAttribute ( booleanSetValueConverterEClass, BOOLEAN_SET_VALUE_CONVERTER__IGNORE_CASE );

        // Create enums
        variantTypeEEnum = createEEnum ( VARIANT_TYPE );

        // Create data types
        inputEDataType = createEDataType ( INPUT );
        creationContextEDataType = createEDataType ( CREATION_CONTEXT );
        extractorEDataType = createEDataType ( EXTRACTOR );
        patternEDataType = createEDataType ( PATTERN );
        transformerEDataType = createEDataType ( TRANSFORMER );
        valueConverterEDataType = createEDataType ( VALUE_CONVERTER );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents ()
    {
        if ( isInitialized )
            return;
        isInitialized = true;

        // Initialize package
        setName ( eNAME );
        setNsPrefix ( eNS_PREFIX );
        setNsURI ( eNS_URI );

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        fileInputEClass.getESuperTypes ().add ( this.getAbstractPeriodInput () );
        plainTextEClass.getESuperTypes ().add ( this.getExtractorDefinition () );
        abstractPeriodInputEClass.getESuperTypes ().add ( this.getAbstractInput () );
        urlInputEClass.getESuperTypes ().add ( this.getAbstractPeriodInput () );
        singlePatternEClass.getESuperTypes ().add ( this.getExtractorDefinition () );
        mainGroupFieldEClass.getESuperTypes ().add ( this.getField () );
        stringGroupFieldEClass.getESuperTypes ().add ( this.getField () );
        numericGroupFieldEClass.getESuperTypes ().add ( this.getField () );
        splitTableEClass.getESuperTypes ().add ( this.getExtractorDefinition () );
        stringTransformerEClass.getESuperTypes ().add ( this.getTransformerDefinition () );
        mqttInputEClass.getESuperTypes ().add ( this.getAbstractInput () );
        abstractInputEClass.getESuperTypes ().add ( this.getInputDefinition () );
        booleanValueConverterEClass.getESuperTypes ().add ( this.getValueConverterDefinition () );
        defaultValueConverterEClass.getESuperTypes ().add ( this.getValueConverterDefinition () );
        doubleValueConverterEClass.getESuperTypes ().add ( this.getValueConverterDefinition () );
        booleanSetValueConverterEClass.getESuperTypes ().add ( this.getValueConverterDefinition () );

        // Initialize classes, features, and operations; add parameters
        initEClass ( componentEClass, Component.class, "Component", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getComponent_Id (), ecorePackage.getEString (), "id", null, 1, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getComponent_Input (), this.getInputDefinition (), null, "input", null, 1, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getComponent_Extractors (), this.getExtractorDefinition (), null, "extractors", null, 0, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( inputDefinitionEClass, InputDefinition.class, "InputDefinition", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getInputDefinition_Transformers (), this.getTransformerDefinition (), null, "transformers", null, 0, -1, InputDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        EOperation op = initEOperation ( getInputDefinition__CreateInput__CreationContext (), this.getInput (), "createInput", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$
        addEParameter ( op, this.getCreationContext (), "creationContext", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( fileInputEClass, FileInput.class, "FileInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getFileInput_FileName (), ecorePackage.getEString (), "fileName", null, 1, 1, FileInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( extractorDefinitionEClass, ExtractorDefinition.class, "ExtractorDefinition", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getExtractorDefinition_Prefix (), ecorePackage.getEString (), "prefix", null, 0, 1, ExtractorDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        op = initEOperation ( getExtractorDefinition__CreateExtractor__CreationContext (), this.getExtractor (), "createExtractor", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$
        addEParameter ( op, this.getCreationContext (), "creationContext", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( plainTextEClass, PlainText.class, "PlainText", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getPlainText_Trim (), ecorePackage.getEBoolean (), "trim", "true", 1, 1, PlainText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEReference ( getPlainText_ValueConverter (), this.getValueConverterDefinition (), null, "valueConverter", null, 0, 1, PlainText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( abstractPeriodInputEClass, AbstractPeriodInput.class, "AbstractPeriodInput", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getAbstractPeriodInput_Period (), ecorePackage.getELong (), "period", "1000", 1, 1, AbstractPeriodInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( urlInputEClass, UrlInput.class, "UrlInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getUrlInput_Url (), ecorePackage.getEString (), "url", null, 1, 1, UrlInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getUrlInput_ProbeCharacterSet (), ecorePackage.getEBoolean (), "probeCharacterSet", "true", 1, 1, UrlInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getUrlInput_Charset (), ecorePackage.getEString (), "charset", null, 0, 1, UrlInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( singlePatternEClass, SinglePattern.class, "SinglePattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getSinglePattern_Pattern (), this.getPattern (), "pattern", null, 1, 1, SinglePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getSinglePattern_FullMatch (), ecorePackage.getEBoolean (), "fullMatch", null, 1, 1, SinglePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getSinglePattern_Value (), this.getValueDescriptor (), null, "value", null, 1, 1, SinglePattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( valueDescriptorEClass, ValueDescriptor.class, "ValueDescriptor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getValueDescriptor_PrimaryValue (), this.getField (), null, "primaryValue", null, 0, 1, ValueDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getValueDescriptor_Attributes (), this.getAttributeValue (), null, "attributes", null, 0, -1, ValueDescriptor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( fieldEClass, Field.class, "Field", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getField_Type (), this.getVariantType (), "type", null, 0, 1, Field.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( attributeValueEClass, AttributeValue.class, "AttributeValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getAttributeValue_Name (), ecorePackage.getEString (), "name", null, 1, 1, AttributeValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getAttributeValue_Field (), this.getField (), null, "field", null, 0, 1, AttributeValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( mainGroupFieldEClass, MainGroupField.class, "MainGroupField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( stringGroupFieldEClass, StringGroupField.class, "StringGroupField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getStringGroupField_GroupName (), ecorePackage.getEString (), "groupName", null, 1, 1, StringGroupField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( numericGroupFieldEClass, NumericGroupField.class, "NumericGroupField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getNumericGroupField_GroupNumber (), ecorePackage.getEInt (), "groupNumber", null, 1, 1, NumericGroupField.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( splitTableEClass, SplitTable.class, "SplitTable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getSplitTable_LineSeparatorPattern (), this.getPattern (), "lineSeparatorPattern", null, 1, 1, SplitTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getSplitTable_FieldSeparatorPattern (), this.getPattern (), "fieldSeparatorPattern", null, 1, 1, SplitTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getSplitTable_IdColumn (), ecorePackage.getEInt (), "idColumn", null, 1, 1, SplitTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getSplitTable_Fields (), ecorePackage.getEString (), "fields", null, 0, -1, SplitTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getSplitTable_ValueConverter (), this.getValueConverterDefinition (), null, "valueConverter", null, 0, 1, SplitTable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( transformerDefinitionEClass, TransformerDefinition.class, "TransformerDefinition", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        op = initEOperation ( getTransformerDefinition__CreateTransformer__CreationContext (), this.getTransformer (), "createTransformer", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$
        addEParameter ( op, this.getCreationContext (), "creationContext", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( stringTransformerEClass, StringTransformer.class, "StringTransformer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getStringTransformer_Charset (), ecorePackage.getEString (), "charset", "UTF-8", 1, 1, StringTransformer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( mqttInputEClass, MqttInput.class, "MqttInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getMqttInput_ServerUri (), ecorePackage.getEString (), "serverUri", null, 1, 1, MqttInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getMqttInput_ClientId (), ecorePackage.getEString (), "clientId", null, 0, 1, MqttInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getMqttInput_Topic (), ecorePackage.getEString (), "topic", null, 1, 1, MqttInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getMqttInput_Qos (), ecorePackage.getEInt (), "qos", null, 1, 1, MqttInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( abstractInputEClass, AbstractInput.class, "AbstractInput", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( valueConverterDefinitionEClass, ValueConverterDefinition.class, "ValueConverterDefinition", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEOperation ( getValueConverterDefinition__CreateConverter (), this.getValueConverter (), "createConverter", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( booleanValueConverterEClass, BooleanValueConverter.class, "BooleanValueConverter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( defaultValueConverterEClass, DefaultValueConverter.class, "DefaultValueConverter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( doubleValueConverterEClass, DoubleValueConverter.class, "DoubleValueConverter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( booleanSetValueConverterEClass, BooleanSetValueConverter.class, "BooleanSetValueConverter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getBooleanSetValueConverter_TrueValues (), ecorePackage.getEString (), "trueValues", null, 0, -1, BooleanSetValueConverter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getBooleanSetValueConverter_FalseValues (), ecorePackage.getEString (), "falseValues", null, 0, -1, BooleanSetValueConverter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getBooleanSetValueConverter_Otherwise (), ecorePackage.getEBooleanObject (), "otherwise", null, 0, 1, BooleanSetValueConverter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getBooleanSetValueConverter_IgnoreCase (), ecorePackage.getEBoolean (), "ignoreCase", "false", 1, 1, BooleanSetValueConverter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        // Initialize enums and add enum literals
        initEEnum ( variantTypeEEnum, VariantType.class, "VariantType" ); //$NON-NLS-1$
        addEEnumLiteral ( variantTypeEEnum, VariantType.DEFAULT );
        addEEnumLiteral ( variantTypeEEnum, VariantType.STRING );
        addEEnumLiteral ( variantTypeEEnum, VariantType.INT32 );
        addEEnumLiteral ( variantTypeEEnum, VariantType.INT64 );
        addEEnumLiteral ( variantTypeEEnum, VariantType.DOUBLE );
        addEEnumLiteral ( variantTypeEEnum, VariantType.BOOLEAN );

        // Initialize data types
        initEDataType ( inputEDataType, Input.class, "Input", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEDataType ( creationContextEDataType, CreationContext.class, "CreationContext", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEDataType ( extractorEDataType, Extractor.class, "Extractor", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEDataType ( patternEDataType, Pattern.class, "Pattern", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEDataType ( transformerEDataType, Transformer.class, "Transformer", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEDataType ( valueConverterEDataType, ValueConverter.class, "ValueConverter", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        // Create resource
        createResource ( eNS_URI );
    }

} //ParserPackageImpl
