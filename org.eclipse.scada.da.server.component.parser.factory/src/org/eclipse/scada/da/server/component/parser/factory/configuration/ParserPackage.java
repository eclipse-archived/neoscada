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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ParserFactory
 * @model kind="package"
 * @generated
 */
public interface ParserPackage extends EPackage
{
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "configuration"; //$NON-NLS-1$

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://eclipse.org/SCADA/DA/Server/Parser"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "parser"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ParserPackage eINSTANCE = org.eclipse.scada.da.server.component.parser.factory.configuration.impl.ParserPackageImpl.init ();

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.ComponentImpl <em>Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.impl.ComponentImpl
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.impl.ParserPackageImpl#getComponent()
     * @generated
     */
    int COMPONENT = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPONENT__ID = 0;

    /**
     * The feature id for the '<em><b>Input</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPONENT__INPUT = 1;

    /**
     * The feature id for the '<em><b>Extractors</b></em>' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPONENT__EXTRACTORS = 2;

    /**
     * The number of structural features of the '<em>Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPONENT_FEATURE_COUNT = 3;

    /**
     * The number of operations of the '<em>Component</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPONENT_OPERATION_COUNT = 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.InputDefinition <em>Input Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.InputDefinition
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.impl.ParserPackageImpl#getInputDefinition()
     * @generated
     */
    int INPUT_DEFINITION = 1;

    /**
     * The number of structural features of the '<em>Input Definition</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INPUT_DEFINITION_FEATURE_COUNT = 0;

    /**
     * The operation id for the '<em>Create Input</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INPUT_DEFINITION___CREATE_INPUT__CREATIONCONTEXT = 0;

    /**
     * The number of operations of the '<em>Input Definition</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int INPUT_DEFINITION_OPERATION_COUNT = 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.AbstractPeriodInputImpl <em>Abstract Period Input</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.impl.AbstractPeriodInputImpl
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.impl.ParserPackageImpl#getAbstractPeriodInput()
     * @generated
     */
    int ABSTRACT_PERIOD_INPUT = 5;

    /**
     * The feature id for the '<em><b>Period</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PERIOD_INPUT__PERIOD = INPUT_DEFINITION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Abstract Period Input</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PERIOD_INPUT_FEATURE_COUNT = INPUT_DEFINITION_FEATURE_COUNT + 1;

    /**
     * The operation id for the '<em>Create Input</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PERIOD_INPUT___CREATE_INPUT__CREATIONCONTEXT = INPUT_DEFINITION___CREATE_INPUT__CREATIONCONTEXT;

    /**
     * The number of operations of the '<em>Abstract Period Input</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int ABSTRACT_PERIOD_INPUT_OPERATION_COUNT = INPUT_DEFINITION_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.FileInputImpl <em>File Input</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.impl.FileInputImpl
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.impl.ParserPackageImpl#getFileInput()
     * @generated
     */
    int FILE_INPUT = 2;

    /**
     * The feature id for the '<em><b>Period</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_INPUT__PERIOD = ABSTRACT_PERIOD_INPUT__PERIOD;

    /**
     * The feature id for the '<em><b>File Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_INPUT__FILE_NAME = ABSTRACT_PERIOD_INPUT_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>File Input</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_INPUT_FEATURE_COUNT = ABSTRACT_PERIOD_INPUT_FEATURE_COUNT + 1;

    /**
     * The operation id for the '<em>Create Input</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_INPUT___CREATE_INPUT__CREATIONCONTEXT = ABSTRACT_PERIOD_INPUT___CREATE_INPUT__CREATIONCONTEXT;

    /**
     * The number of operations of the '<em>File Input</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int FILE_INPUT_OPERATION_COUNT = ABSTRACT_PERIOD_INPUT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.ExtractorDefinition <em>Extractor Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ExtractorDefinition
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.impl.ParserPackageImpl#getExtractorDefinition()
     * @generated
     */
    int EXTRACTOR_DEFINITION = 3;

    /**
     * The feature id for the '<em><b>Prefix</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTRACTOR_DEFINITION__PREFIX = 0;

    /**
     * The number of structural features of the '<em>Extractor Definition</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTRACTOR_DEFINITION_FEATURE_COUNT = 1;

    /**
     * The operation id for the '<em>Create Extractor</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTRACTOR_DEFINITION___CREATE_EXTRACTOR__CREATIONCONTEXT = 0;

    /**
     * The number of operations of the '<em>Extractor Definition</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXTRACTOR_DEFINITION_OPERATION_COUNT = 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.PlainTextImpl <em>Plain Text</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.impl.PlainTextImpl
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.impl.ParserPackageImpl#getPlainText()
     * @generated
     */
    int PLAIN_TEXT = 4;

    /**
     * The feature id for the '<em><b>Prefix</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAIN_TEXT__PREFIX = EXTRACTOR_DEFINITION__PREFIX;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAIN_TEXT__NAME = EXTRACTOR_DEFINITION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAIN_TEXT__DESCRIPTION = EXTRACTOR_DEFINITION_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Trim</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAIN_TEXT__TRIM = EXTRACTOR_DEFINITION_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Plain Text</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAIN_TEXT_FEATURE_COUNT = EXTRACTOR_DEFINITION_FEATURE_COUNT + 3;

    /**
     * The operation id for the '<em>Create Extractor</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAIN_TEXT___CREATE_EXTRACTOR__CREATIONCONTEXT = EXTRACTOR_DEFINITION___CREATE_EXTRACTOR__CREATIONCONTEXT;

    /**
     * The number of operations of the '<em>Plain Text</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PLAIN_TEXT_OPERATION_COUNT = EXTRACTOR_DEFINITION_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.UrlInputImpl <em>Url Input</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.impl.UrlInputImpl
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.impl.ParserPackageImpl#getUrlInput()
     * @generated
     */
    int URL_INPUT = 6;

    /**
     * The feature id for the '<em><b>Period</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int URL_INPUT__PERIOD = ABSTRACT_PERIOD_INPUT__PERIOD;

    /**
     * The feature id for the '<em><b>Url</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int URL_INPUT__URL = ABSTRACT_PERIOD_INPUT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Probe Character Set</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int URL_INPUT__PROBE_CHARACTER_SET = ABSTRACT_PERIOD_INPUT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Charset</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int URL_INPUT__CHARSET = ABSTRACT_PERIOD_INPUT_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Url Input</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int URL_INPUT_FEATURE_COUNT = ABSTRACT_PERIOD_INPUT_FEATURE_COUNT + 3;

    /**
     * The operation id for the '<em>Create Input</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int URL_INPUT___CREATE_INPUT__CREATIONCONTEXT = ABSTRACT_PERIOD_INPUT___CREATE_INPUT__CREATIONCONTEXT;

    /**
     * The number of operations of the '<em>Url Input</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int URL_INPUT_OPERATION_COUNT = ABSTRACT_PERIOD_INPUT_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '<em>Input</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.base.extractor.input.Input
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.impl.ParserPackageImpl#getInput()
     * @generated
     */
    int INPUT = 7;

    /**
     * The meta object id for the '<em>Creation Context</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.da.server.component.parser.factory.CreationContext
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.impl.ParserPackageImpl#getCreationContext()
     * @generated
     */
    int CREATION_CONTEXT = 8;

    /**
     * The meta object id for the '<em>Extractor</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.base.extractor.extract.Extractor
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.impl.ParserPackageImpl#getExtractor()
     * @generated
     */
    int EXTRACTOR = 9;

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.Component <em>Component</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Component</em>'.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.Component
     * @generated
     */
    EClass getComponent ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.Component#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.Component#getId()
     * @see #getComponent()
     * @generated
     */
    EAttribute getComponent_Id ();

    /**
     * Returns the meta object for the containment reference '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.Component#getInput <em>Input</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference '<em>Input</em>'.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.Component#getInput()
     * @see #getComponent()
     * @generated
     */
    EReference getComponent_Input ();

    /**
     * Returns the meta object for the containment reference list '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.Component#getExtractors <em>Extractors</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Extractors</em>'.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.Component#getExtractors()
     * @see #getComponent()
     * @generated
     */
    EReference getComponent_Extractors ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.InputDefinition <em>Input Definition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Input Definition</em>'.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.InputDefinition
     * @generated
     */
    EClass getInputDefinition ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.InputDefinition#createInput(org.eclipse.scada.da.server.component.parser.factory.CreationContext) <em>Create Input</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Create Input</em>' operation.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.InputDefinition#createInput(org.eclipse.scada.da.server.component.parser.factory.CreationContext)
     * @generated
     */
    EOperation getInputDefinition__CreateInput__CreationContext ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.FileInput <em>File Input</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>File Input</em>'.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.FileInput
     * @generated
     */
    EClass getFileInput ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.FileInput#getFileName <em>File Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>File Name</em>'.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.FileInput#getFileName()
     * @see #getFileInput()
     * @generated
     */
    EAttribute getFileInput_FileName ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.ExtractorDefinition <em>Extractor Definition</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Extractor Definition</em>'.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ExtractorDefinition
     * @generated
     */
    EClass getExtractorDefinition ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.ExtractorDefinition#getPrefix <em>Prefix</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Prefix</em>'.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ExtractorDefinition#getPrefix()
     * @see #getExtractorDefinition()
     * @generated
     */
    EAttribute getExtractorDefinition_Prefix ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.ExtractorDefinition#createExtractor(org.eclipse.scada.da.server.component.parser.factory.CreationContext) <em>Create Extractor</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Create Extractor</em>' operation.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ExtractorDefinition#createExtractor(org.eclipse.scada.da.server.component.parser.factory.CreationContext)
     * @generated
     */
    EOperation getExtractorDefinition__CreateExtractor__CreationContext ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.PlainText <em>Plain Text</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Plain Text</em>'.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.PlainText
     * @generated
     */
    EClass getPlainText ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.PlainText#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.PlainText#getName()
     * @see #getPlainText()
     * @generated
     */
    EAttribute getPlainText_Name ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.PlainText#getDescription <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.PlainText#getDescription()
     * @see #getPlainText()
     * @generated
     */
    EAttribute getPlainText_Description ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.PlainText#isTrim <em>Trim</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Trim</em>'.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.PlainText#isTrim()
     * @see #getPlainText()
     * @generated
     */
    EAttribute getPlainText_Trim ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.AbstractPeriodInput <em>Abstract Period Input</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Abstract Period Input</em>'.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.AbstractPeriodInput
     * @generated
     */
    EClass getAbstractPeriodInput ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.AbstractPeriodInput#getPeriod <em>Period</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Period</em>'.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.AbstractPeriodInput#getPeriod()
     * @see #getAbstractPeriodInput()
     * @generated
     */
    EAttribute getAbstractPeriodInput_Period ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.UrlInput <em>Url Input</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Url Input</em>'.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.UrlInput
     * @generated
     */
    EClass getUrlInput ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.UrlInput#getUrl <em>Url</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Url</em>'.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.UrlInput#getUrl()
     * @see #getUrlInput()
     * @generated
     */
    EAttribute getUrlInput_Url ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.UrlInput#isProbeCharacterSet <em>Probe Character Set</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Probe Character Set</em>'.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.UrlInput#isProbeCharacterSet()
     * @see #getUrlInput()
     * @generated
     */
    EAttribute getUrlInput_ProbeCharacterSet ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.UrlInput#getCharset <em>Charset</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Charset</em>'.
     * @see org.eclipse.scada.da.server.component.parser.factory.configuration.UrlInput#getCharset()
     * @see #getUrlInput()
     * @generated
     */
    EAttribute getUrlInput_Charset ();

    /**
     * Returns the meta object for data type '{@link org.eclipse.scada.base.extractor.input.Input <em>Input</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Input</em>'.
     * @see org.eclipse.scada.base.extractor.input.Input
     * @model instanceClass="org.eclipse.scada.base.extractor.input.Input" serializeable="false"
     * @generated
     */
    EDataType getInput ();

    /**
     * Returns the meta object for data type '{@link org.eclipse.scada.da.server.component.parser.factory.CreationContext <em>Creation Context</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Creation Context</em>'.
     * @see org.eclipse.scada.da.server.component.parser.factory.CreationContext
     * @model instanceClass="org.eclipse.scada.da.server.component.parser.factory.CreationContext" serializeable="false"
     * @generated
     */
    EDataType getCreationContext ();

    /**
     * Returns the meta object for data type '{@link org.eclipse.scada.base.extractor.extract.Extractor <em>Extractor</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Extractor</em>'.
     * @see org.eclipse.scada.base.extractor.extract.Extractor
     * @model instanceClass="org.eclipse.scada.base.extractor.extract.Extractor" serializeable="false"
     * @generated
     */
    EDataType getExtractor ();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    ParserFactory getParserFactory ();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     *   <li>each class,</li>
     *   <li>each feature of each class,</li>
     *   <li>each operation of each class,</li>
     *   <li>each enum,</li>
     *   <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * @generated
     */
    interface Literals
    {
        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.ComponentImpl <em>Component</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.server.component.parser.factory.configuration.impl.ComponentImpl
         * @see org.eclipse.scada.da.server.component.parser.factory.configuration.impl.ParserPackageImpl#getComponent()
         * @generated
         */
        EClass COMPONENT = eINSTANCE.getComponent ();

        /**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COMPONENT__ID = eINSTANCE.getComponent_Id ();

        /**
         * The meta object literal for the '<em><b>Input</b></em>' containment reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference COMPONENT__INPUT = eINSTANCE.getComponent_Input ();

        /**
         * The meta object literal for the '<em><b>Extractors</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference COMPONENT__EXTRACTORS = eINSTANCE.getComponent_Extractors ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.InputDefinition <em>Input Definition</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.server.component.parser.factory.configuration.InputDefinition
         * @see org.eclipse.scada.da.server.component.parser.factory.configuration.impl.ParserPackageImpl#getInputDefinition()
         * @generated
         */
        EClass INPUT_DEFINITION = eINSTANCE.getInputDefinition ();

        /**
         * The meta object literal for the '<em><b>Create Input</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation INPUT_DEFINITION___CREATE_INPUT__CREATIONCONTEXT = eINSTANCE.getInputDefinition__CreateInput__CreationContext ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.FileInputImpl <em>File Input</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.server.component.parser.factory.configuration.impl.FileInputImpl
         * @see org.eclipse.scada.da.server.component.parser.factory.configuration.impl.ParserPackageImpl#getFileInput()
         * @generated
         */
        EClass FILE_INPUT = eINSTANCE.getFileInput ();

        /**
         * The meta object literal for the '<em><b>File Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute FILE_INPUT__FILE_NAME = eINSTANCE.getFileInput_FileName ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.ExtractorDefinition <em>Extractor Definition</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.server.component.parser.factory.configuration.ExtractorDefinition
         * @see org.eclipse.scada.da.server.component.parser.factory.configuration.impl.ParserPackageImpl#getExtractorDefinition()
         * @generated
         */
        EClass EXTRACTOR_DEFINITION = eINSTANCE.getExtractorDefinition ();

        /**
         * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXTRACTOR_DEFINITION__PREFIX = eINSTANCE.getExtractorDefinition_Prefix ();

        /**
         * The meta object literal for the '<em><b>Create Extractor</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation EXTRACTOR_DEFINITION___CREATE_EXTRACTOR__CREATIONCONTEXT = eINSTANCE.getExtractorDefinition__CreateExtractor__CreationContext ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.PlainTextImpl <em>Plain Text</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.server.component.parser.factory.configuration.impl.PlainTextImpl
         * @see org.eclipse.scada.da.server.component.parser.factory.configuration.impl.ParserPackageImpl#getPlainText()
         * @generated
         */
        EClass PLAIN_TEXT = eINSTANCE.getPlainText ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PLAIN_TEXT__NAME = eINSTANCE.getPlainText_Name ();

        /**
         * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PLAIN_TEXT__DESCRIPTION = eINSTANCE.getPlainText_Description ();

        /**
         * The meta object literal for the '<em><b>Trim</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PLAIN_TEXT__TRIM = eINSTANCE.getPlainText_Trim ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.AbstractPeriodInputImpl <em>Abstract Period Input</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.server.component.parser.factory.configuration.impl.AbstractPeriodInputImpl
         * @see org.eclipse.scada.da.server.component.parser.factory.configuration.impl.ParserPackageImpl#getAbstractPeriodInput()
         * @generated
         */
        EClass ABSTRACT_PERIOD_INPUT = eINSTANCE.getAbstractPeriodInput ();

        /**
         * The meta object literal for the '<em><b>Period</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute ABSTRACT_PERIOD_INPUT__PERIOD = eINSTANCE.getAbstractPeriodInput_Period ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.UrlInputImpl <em>Url Input</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.server.component.parser.factory.configuration.impl.UrlInputImpl
         * @see org.eclipse.scada.da.server.component.parser.factory.configuration.impl.ParserPackageImpl#getUrlInput()
         * @generated
         */
        EClass URL_INPUT = eINSTANCE.getUrlInput ();

        /**
         * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute URL_INPUT__URL = eINSTANCE.getUrlInput_Url ();

        /**
         * The meta object literal for the '<em><b>Probe Character Set</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute URL_INPUT__PROBE_CHARACTER_SET = eINSTANCE.getUrlInput_ProbeCharacterSet ();

        /**
         * The meta object literal for the '<em><b>Charset</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute URL_INPUT__CHARSET = eINSTANCE.getUrlInput_Charset ();

        /**
         * The meta object literal for the '<em>Input</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.base.extractor.input.Input
         * @see org.eclipse.scada.da.server.component.parser.factory.configuration.impl.ParserPackageImpl#getInput()
         * @generated
         */
        EDataType INPUT = eINSTANCE.getInput ();

        /**
         * The meta object literal for the '<em>Creation Context</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.da.server.component.parser.factory.CreationContext
         * @see org.eclipse.scada.da.server.component.parser.factory.configuration.impl.ParserPackageImpl#getCreationContext()
         * @generated
         */
        EDataType CREATION_CONTEXT = eINSTANCE.getCreationContext ();

        /**
         * The meta object literal for the '<em>Extractor</em>' data type.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.base.extractor.extract.Extractor
         * @see org.eclipse.scada.da.server.component.parser.factory.configuration.impl.ParserPackageImpl#getExtractor()
         * @generated
         */
        EDataType EXTRACTOR = eINSTANCE.getExtractor ();

    }

} //ParserPackage
