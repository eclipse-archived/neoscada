/**
 * Copyright (c) 2013 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.recipe.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.scada.configuration.recipe.CaptureOutput;
import org.eclipse.scada.configuration.recipe.Definition;
import org.eclipse.scada.configuration.recipe.Execute;
import org.eclipse.scada.configuration.recipe.InputReference;
import org.eclipse.scada.configuration.recipe.InputValue;
import org.eclipse.scada.configuration.recipe.MapInput;
import org.eclipse.scada.configuration.recipe.Profile;
import org.eclipse.scada.configuration.recipe.PropertyEntry;
import org.eclipse.scada.configuration.recipe.RecipeFactory;
import org.eclipse.scada.configuration.recipe.RecipePackage;
import org.eclipse.scada.configuration.recipe.StringInputValue;
import org.eclipse.scada.configuration.recipe.Task;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RecipePackageImpl extends EPackageImpl implements RecipePackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass definitionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass taskEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass executeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass mapInputEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass inputValueEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass stringInputValueEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass captureOutputEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass inputReferenceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass propertyEntryEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass profileEClass = null;

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
     * @see org.eclipse.scada.configuration.recipe.RecipePackage#eNS_URI
     * @see #init()
     * @generated
     */
    private RecipePackageImpl ()
    {
        super ( eNS_URI, RecipeFactory.eINSTANCE );
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
     * <p>This method is used to initialize {@link RecipePackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static RecipePackage init ()
    {
        if ( isInited )
            return (RecipePackage)EPackage.Registry.INSTANCE.getEPackage ( RecipePackage.eNS_URI );

        // Obtain or create and register package
        RecipePackageImpl theRecipePackage = (RecipePackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof RecipePackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new RecipePackageImpl () );

        isInited = true;

        // Create package meta-data objects
        theRecipePackage.createPackageContents ();

        // Initialize created meta-data
        theRecipePackage.initializePackageContents ();

        // Mark meta-data to indicate it can't be changed
        theRecipePackage.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( RecipePackage.eNS_URI, theRecipePackage );
        return theRecipePackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDefinition ()
    {
        return definitionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDefinition_Task ()
    {
        return (EReference)definitionEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDefinition_Import ()
    {
        return (EReference)definitionEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDefinition_Name ()
    {
        return (EAttribute)definitionEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDefinition_Id ()
    {
        return (EAttribute)definitionEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDefinition_Properties ()
    {
        return (EReference)definitionEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDefinition_Profiles ()
    {
        return (EReference)definitionEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getTask ()
    {
        return taskEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTask_Execute ()
    {
        return (EReference)taskEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTask_Name ()
    {
        return (EAttribute)taskEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getTask_Definition ()
    {
        return (EReference)taskEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getTask_Order ()
    {
        return (EAttribute)taskEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getExecute ()
    {
        return executeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getExecute_Name ()
    {
        return (EAttribute)executeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getExecute_Task ()
    {
        return (EReference)executeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getExecute_MapInput ()
    {
        return (EReference)executeEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getExecute_InputValue ()
    {
        return (EReference)executeEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getExecute_Output ()
    {
        return (EReference)executeEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getExecute_InputReference ()
    {
        return (EReference)executeEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMapInput ()
    {
        return mapInputEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMapInput_LocalName ()
    {
        return (EAttribute)mapInputEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getMapInput_ContextName ()
    {
        return (EAttribute)mapInputEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getInputValue ()
    {
        return inputValueEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getInputValue_Name ()
    {
        return (EAttribute)inputValueEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getInputValue__GetValue ()
    {
        return inputValueEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getStringInputValue ()
    {
        return stringInputValueEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getStringInputValue_Value ()
    {
        return (EAttribute)stringInputValueEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCaptureOutput ()
    {
        return captureOutputEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCaptureOutput_LocalName ()
    {
        return (EAttribute)captureOutputEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCaptureOutput_ContextName ()
    {
        return (EAttribute)captureOutputEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getInputReference ()
    {
        return inputReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getInputReference_Expression ()
    {
        return (EAttribute)inputReferenceEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getInputReference_Name ()
    {
        return (EAttribute)inputReferenceEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPropertyEntry ()
    {
        return propertyEntryEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPropertyEntry_Key ()
    {
        return (EAttribute)propertyEntryEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getPropertyEntry_Value ()
    {
        return (EAttribute)propertyEntryEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getProfile ()
    {
        return profileEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProfile_Name ()
    {
        return (EAttribute)profileEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getProfile_Properties ()
    {
        return (EReference)profileEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RecipeFactory getRecipeFactory ()
    {
        return (RecipeFactory)getEFactoryInstance ();
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
        definitionEClass = createEClass ( DEFINITION );
        createEReference ( definitionEClass, DEFINITION__TASK );
        createEReference ( definitionEClass, DEFINITION__IMPORT );
        createEAttribute ( definitionEClass, DEFINITION__NAME );
        createEAttribute ( definitionEClass, DEFINITION__ID );
        createEReference ( definitionEClass, DEFINITION__PROPERTIES );
        createEReference ( definitionEClass, DEFINITION__PROFILES );

        taskEClass = createEClass ( TASK );
        createEReference ( taskEClass, TASK__EXECUTE );
        createEAttribute ( taskEClass, TASK__NAME );
        createEReference ( taskEClass, TASK__DEFINITION );
        createEAttribute ( taskEClass, TASK__ORDER );

        executeEClass = createEClass ( EXECUTE );
        createEAttribute ( executeEClass, EXECUTE__NAME );
        createEReference ( executeEClass, EXECUTE__TASK );
        createEReference ( executeEClass, EXECUTE__MAP_INPUT );
        createEReference ( executeEClass, EXECUTE__INPUT_VALUE );
        createEReference ( executeEClass, EXECUTE__OUTPUT );
        createEReference ( executeEClass, EXECUTE__INPUT_REFERENCE );

        mapInputEClass = createEClass ( MAP_INPUT );
        createEAttribute ( mapInputEClass, MAP_INPUT__LOCAL_NAME );
        createEAttribute ( mapInputEClass, MAP_INPUT__CONTEXT_NAME );

        inputValueEClass = createEClass ( INPUT_VALUE );
        createEAttribute ( inputValueEClass, INPUT_VALUE__NAME );
        createEOperation ( inputValueEClass, INPUT_VALUE___GET_VALUE );

        stringInputValueEClass = createEClass ( STRING_INPUT_VALUE );
        createEAttribute ( stringInputValueEClass, STRING_INPUT_VALUE__VALUE );

        captureOutputEClass = createEClass ( CAPTURE_OUTPUT );
        createEAttribute ( captureOutputEClass, CAPTURE_OUTPUT__LOCAL_NAME );
        createEAttribute ( captureOutputEClass, CAPTURE_OUTPUT__CONTEXT_NAME );

        inputReferenceEClass = createEClass ( INPUT_REFERENCE );
        createEAttribute ( inputReferenceEClass, INPUT_REFERENCE__EXPRESSION );
        createEAttribute ( inputReferenceEClass, INPUT_REFERENCE__NAME );

        propertyEntryEClass = createEClass ( PROPERTY_ENTRY );
        createEAttribute ( propertyEntryEClass, PROPERTY_ENTRY__KEY );
        createEAttribute ( propertyEntryEClass, PROPERTY_ENTRY__VALUE );

        profileEClass = createEClass ( PROFILE );
        createEAttribute ( profileEClass, PROFILE__NAME );
        createEReference ( profileEClass, PROFILE__PROPERTIES );
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
        stringInputValueEClass.getESuperTypes ().add ( this.getInputValue () );

        // Initialize classes, features, and operations; add parameters
        initEClass ( definitionEClass, Definition.class, "Definition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getDefinition_Task (), this.getTask (), this.getTask_Definition (), "task", null, 0, -1, Definition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getDefinition_Import (), this.getDefinition (), null, "import", null, 0, -1, Definition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getDefinition_Name (), ecorePackage.getEString (), "name", null, 1, 1, Definition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getDefinition_Id (), ecorePackage.getEString (), "id", null, 1, 1, Definition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getDefinition_Properties (), this.getPropertyEntry (), null, "properties", null, 0, -1, Definition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getDefinition_Profiles (), this.getProfile (), null, "profiles", null, 0, -1, Definition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( taskEClass, Task.class, "Task", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getTask_Execute (), this.getExecute (), this.getExecute_Task (), "execute", null, 0, -1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getTask_Name (), ecorePackage.getEString (), "name", null, 1, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getTask_Definition (), this.getDefinition (), this.getDefinition_Task (), "definition", null, 1, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getTask_Order (), ecorePackage.getEInt (), "order", null, 1, 1, Task.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( executeEClass, Execute.class, "Execute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getExecute_Name (), ecorePackage.getEString (), "name", null, 1, 1, Execute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getExecute_Task (), this.getTask (), this.getTask_Execute (), "task", null, 1, 1, Execute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getExecute_MapInput (), this.getMapInput (), null, "mapInput", null, 0, -1, Execute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getExecute_InputValue (), this.getInputValue (), null, "inputValue", null, 0, -1, Execute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getExecute_Output (), this.getCaptureOutput (), null, "output", null, 0, -1, Execute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getExecute_InputReference (), this.getInputReference (), null, "inputReference", null, 0, -1, Execute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( mapInputEClass, MapInput.class, "MapInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getMapInput_LocalName (), ecorePackage.getEString (), "localName", null, 1, 1, MapInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getMapInput_ContextName (), ecorePackage.getEString (), "contextName", null, 1, 1, MapInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( inputValueEClass, InputValue.class, "InputValue", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getInputValue_Name (), ecorePackage.getEString (), "name", null, 1, 1, InputValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEOperation ( getInputValue__GetValue (), ecorePackage.getEJavaObject (), "getValue", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( stringInputValueEClass, StringInputValue.class, "StringInputValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getStringInputValue_Value (), ecorePackage.getEString (), "value", null, 0, 1, StringInputValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( captureOutputEClass, CaptureOutput.class, "CaptureOutput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getCaptureOutput_LocalName (), ecorePackage.getEString (), "localName", null, 1, 1, CaptureOutput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getCaptureOutput_ContextName (), ecorePackage.getEString (), "contextName", null, 0, 1, CaptureOutput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( inputReferenceEClass, InputReference.class, "InputReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getInputReference_Expression (), ecorePackage.getEString (), "expression", null, 1, 1, InputReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getInputReference_Name (), ecorePackage.getEString (), "name", null, 1, 1, InputReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( propertyEntryEClass, PropertyEntry.class, "PropertyEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getPropertyEntry_Key (), ecorePackage.getEString (), "key", null, 1, 1, PropertyEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getPropertyEntry_Value (), ecorePackage.getEString (), "value", null, 0, 1, PropertyEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( profileEClass, Profile.class, "Profile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getProfile_Name (), ecorePackage.getEString (), "name", null, 1, 1, Profile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getProfile_Properties (), this.getPropertyEntry (), null, "properties", null, 0, -1, Profile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        // Create resource
        createResource ( eNS_URI );
    }

} //RecipePackageImpl
