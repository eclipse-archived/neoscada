/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.item.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.scada.configuration.item.Call;
import org.eclipse.scada.configuration.item.CallSuper;
import org.eclipse.scada.configuration.item.CompositePipeline;
import org.eclipse.scada.configuration.item.CustomScriptCustomizationPipeline;
import org.eclipse.scada.configuration.item.CustomScriptSelector;
import org.eclipse.scada.configuration.item.CustomizationPipeline;
import org.eclipse.scada.configuration.item.CustomizationRequest;
import org.eclipse.scada.configuration.item.ItemFactory;
import org.eclipse.scada.configuration.item.ItemPackage;
import org.eclipse.scada.configuration.item.JavaScriptCustomizationPipeline;
import org.eclipse.scada.configuration.item.JavaScriptSelector;
import org.eclipse.scada.configuration.item.ScriptCustomizationPipeline;
import org.eclipse.scada.configuration.item.ScriptSelector;
import org.eclipse.scada.configuration.item.Selector;
import org.eclipse.scada.configuration.item.Step;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ItemPackageImpl extends EPackageImpl implements ItemPackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass customizationPipelineEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass scriptCustomizationPipelineEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass compositePipelineEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass callEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass stepEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass callSuperEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass selectorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass scriptSelectorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass javaScriptCustomizationPipelineEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass customScriptCustomizationPipelineEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass javaScriptSelectorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass customScriptSelectorEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType customizationRequestEDataType = null;

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
     * @see org.eclipse.scada.configuration.item.ItemPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private ItemPackageImpl ()
    {
        super ( eNS_URI, ItemFactory.eINSTANCE );
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
     * <p>This method is used to initialize {@link ItemPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static ItemPackage init ()
    {
        if ( isInited )
            return (ItemPackage)EPackage.Registry.INSTANCE.getEPackage ( ItemPackage.eNS_URI );

        // Obtain or create and register package
        ItemPackageImpl theItemPackage = (ItemPackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof ItemPackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new ItemPackageImpl () );

        isInited = true;

        // Create package meta-data objects
        theItemPackage.createPackageContents ();

        // Initialize created meta-data
        theItemPackage.initializePackageContents ();

        // Mark meta-data to indicate it can't be changed
        theItemPackage.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( ItemPackage.eNS_URI, theItemPackage );
        return theItemPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCustomizationPipeline ()
    {
        return customizationPipelineEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getCustomizationPipeline__Customize__CustomizationRequest ()
    {
        return customizationPipelineEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getScriptCustomizationPipeline ()
    {
        return scriptCustomizationPipelineEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getScriptCustomizationPipeline_Code ()
    {
        return (EAttribute)scriptCustomizationPipelineEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getScriptCustomizationPipeline__GetScriptEngine ()
    {
        return scriptCustomizationPipelineEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCompositePipeline ()
    {
        return compositePipelineEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCompositePipeline_Steps ()
    {
        return (EReference)compositePipelineEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCompositePipeline_Id ()
    {
        return (EAttribute)compositePipelineEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCompositePipeline_Parent ()
    {
        return (EReference)compositePipelineEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getCompositePipeline__Customize__CustomizationRequest ()
    {
        return compositePipelineEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCall ()
    {
        return callEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getCall_Pipeline ()
    {
        return (EReference)callEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getCall__Execute__CustomizationRequest ()
    {
        return callEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getStep ()
    {
        return stepEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getStep_ContainingPipeline ()
    {
        return (EReference)stepEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getStep__Execute__CustomizationRequest ()
    {
        return stepEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCallSuper ()
    {
        return callSuperEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getCallSuper__Execute__CustomizationRequest ()
    {
        return callSuperEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSelector ()
    {
        return selectorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getSelector__Selected__CustomizationRequest ()
    {
        return selectorEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getScriptSelector ()
    {
        return scriptSelectorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getScriptSelector_Code ()
    {
        return (EAttribute)scriptSelectorEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getScriptSelector__GetScriptEngine ()
    {
        return scriptSelectorEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getJavaScriptCustomizationPipeline ()
    {
        return javaScriptCustomizationPipelineEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getJavaScriptCustomizationPipeline__GetScriptEngine ()
    {
        return javaScriptCustomizationPipelineEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCustomScriptCustomizationPipeline ()
    {
        return customScriptCustomizationPipelineEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCustomScriptCustomizationPipeline_ScriptEngine ()
    {
        return (EAttribute)customScriptCustomizationPipelineEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getJavaScriptSelector ()
    {
        return javaScriptSelectorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getJavaScriptSelector__GetScriptEngine ()
    {
        return javaScriptSelectorEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getCustomScriptSelector ()
    {
        return customScriptSelectorEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getCustomScriptSelector_ScriptEngine ()
    {
        return (EAttribute)customScriptSelectorEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getCustomizationRequest ()
    {
        return customizationRequestEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ItemFactory getItemFactory ()
    {
        return (ItemFactory)getEFactoryInstance ();
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
        customizationPipelineEClass = createEClass ( CUSTOMIZATION_PIPELINE );
        createEOperation ( customizationPipelineEClass, CUSTOMIZATION_PIPELINE___CUSTOMIZE__CUSTOMIZATIONREQUEST );

        scriptCustomizationPipelineEClass = createEClass ( SCRIPT_CUSTOMIZATION_PIPELINE );
        createEAttribute ( scriptCustomizationPipelineEClass, SCRIPT_CUSTOMIZATION_PIPELINE__CODE );
        createEOperation ( scriptCustomizationPipelineEClass, SCRIPT_CUSTOMIZATION_PIPELINE___GET_SCRIPT_ENGINE );

        compositePipelineEClass = createEClass ( COMPOSITE_PIPELINE );
        createEReference ( compositePipelineEClass, COMPOSITE_PIPELINE__STEPS );
        createEAttribute ( compositePipelineEClass, COMPOSITE_PIPELINE__ID );
        createEReference ( compositePipelineEClass, COMPOSITE_PIPELINE__PARENT );
        createEOperation ( compositePipelineEClass, COMPOSITE_PIPELINE___CUSTOMIZE__CUSTOMIZATIONREQUEST );

        callEClass = createEClass ( CALL );
        createEReference ( callEClass, CALL__PIPELINE );
        createEOperation ( callEClass, CALL___EXECUTE__CUSTOMIZATIONREQUEST );

        stepEClass = createEClass ( STEP );
        createEReference ( stepEClass, STEP__CONTAINING_PIPELINE );
        createEOperation ( stepEClass, STEP___EXECUTE__CUSTOMIZATIONREQUEST );

        callSuperEClass = createEClass ( CALL_SUPER );
        createEOperation ( callSuperEClass, CALL_SUPER___EXECUTE__CUSTOMIZATIONREQUEST );

        selectorEClass = createEClass ( SELECTOR );
        createEOperation ( selectorEClass, SELECTOR___SELECTED__CUSTOMIZATIONREQUEST );

        scriptSelectorEClass = createEClass ( SCRIPT_SELECTOR );
        createEAttribute ( scriptSelectorEClass, SCRIPT_SELECTOR__CODE );
        createEOperation ( scriptSelectorEClass, SCRIPT_SELECTOR___GET_SCRIPT_ENGINE );

        javaScriptCustomizationPipelineEClass = createEClass ( JAVA_SCRIPT_CUSTOMIZATION_PIPELINE );
        createEOperation ( javaScriptCustomizationPipelineEClass, JAVA_SCRIPT_CUSTOMIZATION_PIPELINE___GET_SCRIPT_ENGINE );

        customScriptCustomizationPipelineEClass = createEClass ( CUSTOM_SCRIPT_CUSTOMIZATION_PIPELINE );
        createEAttribute ( customScriptCustomizationPipelineEClass, CUSTOM_SCRIPT_CUSTOMIZATION_PIPELINE__SCRIPT_ENGINE );

        javaScriptSelectorEClass = createEClass ( JAVA_SCRIPT_SELECTOR );
        createEOperation ( javaScriptSelectorEClass, JAVA_SCRIPT_SELECTOR___GET_SCRIPT_ENGINE );

        customScriptSelectorEClass = createEClass ( CUSTOM_SCRIPT_SELECTOR );
        createEAttribute ( customScriptSelectorEClass, CUSTOM_SCRIPT_SELECTOR__SCRIPT_ENGINE );

        // Create data types
        customizationRequestEDataType = createEDataType ( CUSTOMIZATION_REQUEST );
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
        scriptCustomizationPipelineEClass.getESuperTypes ().add ( this.getCustomizationPipeline () );
        compositePipelineEClass.getESuperTypes ().add ( this.getCustomizationPipeline () );
        callEClass.getESuperTypes ().add ( this.getStep () );
        callSuperEClass.getESuperTypes ().add ( this.getStep () );
        scriptSelectorEClass.getESuperTypes ().add ( this.getSelector () );
        javaScriptCustomizationPipelineEClass.getESuperTypes ().add ( this.getScriptCustomizationPipeline () );
        customScriptCustomizationPipelineEClass.getESuperTypes ().add ( this.getScriptCustomizationPipeline () );
        javaScriptSelectorEClass.getESuperTypes ().add ( this.getScriptSelector () );
        customScriptSelectorEClass.getESuperTypes ().add ( this.getScriptSelector () );

        // Initialize classes, features, and operations; add parameters
        initEClass ( customizationPipelineEClass, CustomizationPipeline.class, "CustomizationPipeline", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        EOperation op = initEOperation ( getCustomizationPipeline__Customize__CustomizationRequest (), null, "customize", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$
        addEParameter ( op, this.getCustomizationRequest (), "request", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( scriptCustomizationPipelineEClass, ScriptCustomizationPipeline.class, "ScriptCustomizationPipeline", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getScriptCustomizationPipeline_Code (), ecorePackage.getEString (), "code", null, 0, 1, ScriptCustomizationPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEOperation ( getScriptCustomizationPipeline__GetScriptEngine (), ecorePackage.getEString (), "getScriptEngine", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( compositePipelineEClass, CompositePipeline.class, "CompositePipeline", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getCompositePipeline_Steps (), this.getStep (), this.getStep_ContainingPipeline (), "steps", null, 0, -1, CompositePipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getCompositePipeline_Id (), ecorePackage.getEString (), "id", null, 1, 1, CompositePipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getCompositePipeline_Parent (), this.getCompositePipeline (), null, "parent", null, 0, 1, CompositePipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        op = initEOperation ( getCompositePipeline__Customize__CustomizationRequest (), null, "customize", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$
        addEParameter ( op, this.getCustomizationRequest (), "request", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( callEClass, Call.class, "Call", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getCall_Pipeline (), this.getCustomizationPipeline (), null, "pipeline", null, 0, 1, Call.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        op = initEOperation ( getCall__Execute__CustomizationRequest (), null, "execute", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$
        addEParameter ( op, this.getCustomizationRequest (), "request", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( stepEClass, Step.class, "Step", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getStep_ContainingPipeline (), this.getCompositePipeline (), this.getCompositePipeline_Steps (), "containingPipeline", null, 0, 1, Step.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        op = initEOperation ( getStep__Execute__CustomizationRequest (), null, "execute", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$
        addEParameter ( op, this.getCustomizationRequest (), "request", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( callSuperEClass, CallSuper.class, "CallSuper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        op = initEOperation ( getCallSuper__Execute__CustomizationRequest (), null, "execute", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$
        addEParameter ( op, this.getCustomizationRequest (), "request", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( selectorEClass, Selector.class, "Selector", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        op = initEOperation ( getSelector__Selected__CustomizationRequest (), ecorePackage.getEBooleanObject (), "selected", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$
        addEParameter ( op, this.getCustomizationRequest (), "request", 0, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( scriptSelectorEClass, ScriptSelector.class, "ScriptSelector", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getScriptSelector_Code (), ecorePackage.getEString (), "code", null, 1, 1, ScriptSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEOperation ( getScriptSelector__GetScriptEngine (), ecorePackage.getEString (), "getScriptEngine", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( javaScriptCustomizationPipelineEClass, JavaScriptCustomizationPipeline.class, "JavaScriptCustomizationPipeline", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEOperation ( getJavaScriptCustomizationPipeline__GetScriptEngine (), ecorePackage.getEString (), "getScriptEngine", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( customScriptCustomizationPipelineEClass, CustomScriptCustomizationPipeline.class, "CustomScriptCustomizationPipeline", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getCustomScriptCustomizationPipeline_ScriptEngine (), ecorePackage.getEString (), "scriptEngine", "JavaScript", 1, 1, CustomScriptCustomizationPipeline.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( javaScriptSelectorEClass, JavaScriptSelector.class, "JavaScriptSelector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEOperation ( getJavaScriptSelector__GetScriptEngine (), ecorePackage.getEString (), "getScriptEngine", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( customScriptSelectorEClass, CustomScriptSelector.class, "CustomScriptSelector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getCustomScriptSelector_ScriptEngine (), ecorePackage.getEString (), "scriptEngine", "JavaScript", 1, 1, CustomScriptSelector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        // Initialize data types
        initEDataType ( customizationRequestEDataType, CustomizationRequest.class, "CustomizationRequest", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        // Create resource
        createResource ( eNS_URI );
    }

} //ItemPackageImpl
