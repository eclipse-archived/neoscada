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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.scada.base.extractor.extract.Extractor;
import org.eclipse.scada.base.extractor.input.Input;
import org.eclipse.scada.da.server.component.parser.factory.CreationContext;
import org.eclipse.scada.da.server.component.parser.factory.configuration.AbstractPeriodInput;
import org.eclipse.scada.da.server.component.parser.factory.configuration.Component;
import org.eclipse.scada.da.server.component.parser.factory.configuration.ExtractorDefinition;
import org.eclipse.scada.da.server.component.parser.factory.configuration.FileInput;
import org.eclipse.scada.da.server.component.parser.factory.configuration.InputDefinition;
import org.eclipse.scada.da.server.component.parser.factory.configuration.ParserFactory;
import org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage;
import org.eclipse.scada.da.server.component.parser.factory.configuration.PlainText;

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
    public EAttribute getPlainText_Name ()
    {
        return (EAttribute)plainTextEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPlainText_Description ()
    {
        return (EAttribute)plainTextEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPlainText_Trim ()
    {
        return (EAttribute)plainTextEClass.getEStructuralFeatures ().get ( 2 );
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
        createEOperation ( inputDefinitionEClass, INPUT_DEFINITION___CREATE_INPUT__CREATIONCONTEXT );

        fileInputEClass = createEClass ( FILE_INPUT );
        createEAttribute ( fileInputEClass, FILE_INPUT__FILE_NAME );

        extractorDefinitionEClass = createEClass ( EXTRACTOR_DEFINITION );
        createEAttribute ( extractorDefinitionEClass, EXTRACTOR_DEFINITION__PREFIX );
        createEOperation ( extractorDefinitionEClass, EXTRACTOR_DEFINITION___CREATE_EXTRACTOR__CREATIONCONTEXT );

        plainTextEClass = createEClass ( PLAIN_TEXT );
        createEAttribute ( plainTextEClass, PLAIN_TEXT__NAME );
        createEAttribute ( plainTextEClass, PLAIN_TEXT__DESCRIPTION );
        createEAttribute ( plainTextEClass, PLAIN_TEXT__TRIM );

        abstractPeriodInputEClass = createEClass ( ABSTRACT_PERIOD_INPUT );
        createEAttribute ( abstractPeriodInputEClass, ABSTRACT_PERIOD_INPUT__PERIOD );

        // Create data types
        inputEDataType = createEDataType ( INPUT );
        creationContextEDataType = createEDataType ( CREATION_CONTEXT );
        extractorEDataType = createEDataType ( EXTRACTOR );
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
        abstractPeriodInputEClass.getESuperTypes ().add ( this.getInputDefinition () );

        // Initialize classes, features, and operations; add parameters
        initEClass ( componentEClass, Component.class, "Component", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getComponent_Id (), ecorePackage.getEString (), "id", null, 1, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getComponent_Input (), this.getInputDefinition (), null, "input", null, 1, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getComponent_Extractors (), this.getExtractorDefinition (), null, "extractors", null, 0, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( inputDefinitionEClass, InputDefinition.class, "InputDefinition", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        EOperation op = initEOperation ( getInputDefinition__CreateInput__CreationContext (), this.getInput (), "createInput", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$
        addEParameter ( op, this.getCreationContext (), "creationContext", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( fileInputEClass, FileInput.class, "FileInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getFileInput_FileName (), ecorePackage.getEString (), "fileName", null, 1, 1, FileInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( extractorDefinitionEClass, ExtractorDefinition.class, "ExtractorDefinition", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getExtractorDefinition_Prefix (), ecorePackage.getEString (), "prefix", null, 0, 1, ExtractorDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        op = initEOperation ( getExtractorDefinition__CreateExtractor__CreationContext (), this.getExtractor (), "createExtractor", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$
        addEParameter ( op, this.getCreationContext (), "creationContext", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( plainTextEClass, PlainText.class, "PlainText", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getPlainText_Name (), ecorePackage.getEString (), "name", null, 1, 1, PlainText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getPlainText_Description (), ecorePackage.getEString (), "description", null, 0, 1, PlainText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getPlainText_Trim (), ecorePackage.getEBoolean (), "trim", "true", 1, 1, PlainText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( abstractPeriodInputEClass, AbstractPeriodInput.class, "AbstractPeriodInput", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getAbstractPeriodInput_Period (), ecorePackage.getELong (), "period", "1000", 1, 1, AbstractPeriodInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        // Initialize data types
        initEDataType ( inputEDataType, Input.class, "Input", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEDataType ( creationContextEDataType, CreationContext.class, "CreationContext", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEDataType ( extractorEDataType, Extractor.class, "Extractor", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        // Create resource
        createResource ( eNS_URI );
    }

} //ParserPackageImpl
