/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.script.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.scada.configuration.script.AbstractScript;
import org.eclipse.scada.configuration.script.GenericScript;
import org.eclipse.scada.configuration.script.JavaScript;
import org.eclipse.scada.configuration.script.Script;
import org.eclipse.scada.configuration.script.ScriptFactory;
import org.eclipse.scada.configuration.script.ScriptPackage;
import org.eclipse.scada.configuration.script.ScriptReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ScriptPackageImpl extends EPackageImpl implements ScriptPackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass scriptEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass genericScriptEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass javaScriptEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass scriptReferenceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass abstractScriptEClass = null;

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
     * @see org.eclipse.scada.configuration.script.ScriptPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private ScriptPackageImpl ()
    {
        super ( eNS_URI, ScriptFactory.eINSTANCE );
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
     * <p>This method is used to initialize {@link ScriptPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static ScriptPackage init ()
    {
        if ( isInited )
            return (ScriptPackage)EPackage.Registry.INSTANCE.getEPackage ( ScriptPackage.eNS_URI );

        // Obtain or create and register package
        ScriptPackageImpl theScriptPackage = (ScriptPackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof ScriptPackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new ScriptPackageImpl () );

        isInited = true;

        // Create package meta-data objects
        theScriptPackage.createPackageContents ();

        // Initialize created meta-data
        theScriptPackage.initializePackageContents ();

        // Mark meta-data to indicate it can't be changed
        theScriptPackage.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( ScriptPackage.eNS_URI, theScriptPackage );
        return theScriptPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getScript ()
    {
        return scriptEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getScript__GetLanguage ()
    {
        return scriptEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EOperation getScript__GetSource ()
    {
        return scriptEClass.getEOperations ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getGenericScript ()
    {
        return genericScriptEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getGenericScript_Language ()
    {
        return (EAttribute)genericScriptEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getJavaScript ()
    {
        return javaScriptEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getScriptReference ()
    {
        return scriptReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getScriptReference_Reference ()
    {
        return (EReference)scriptReferenceEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAbstractScript ()
    {
        return abstractScriptEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAbstractScript_Source ()
    {
        return (EAttribute)abstractScriptEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ScriptFactory getScriptFactory ()
    {
        return (ScriptFactory)getEFactoryInstance ();
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
        scriptEClass = createEClass ( SCRIPT );
        createEOperation ( scriptEClass, SCRIPT___GET_LANGUAGE );
        createEOperation ( scriptEClass, SCRIPT___GET_SOURCE );

        genericScriptEClass = createEClass ( GENERIC_SCRIPT );
        createEAttribute ( genericScriptEClass, GENERIC_SCRIPT__LANGUAGE );

        javaScriptEClass = createEClass ( JAVA_SCRIPT );

        scriptReferenceEClass = createEClass ( SCRIPT_REFERENCE );
        createEReference ( scriptReferenceEClass, SCRIPT_REFERENCE__REFERENCE );

        abstractScriptEClass = createEClass ( ABSTRACT_SCRIPT );
        createEAttribute ( abstractScriptEClass, ABSTRACT_SCRIPT__SOURCE );
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
        genericScriptEClass.getESuperTypes ().add ( this.getAbstractScript () );
        javaScriptEClass.getESuperTypes ().add ( this.getAbstractScript () );
        scriptReferenceEClass.getESuperTypes ().add ( this.getScript () );
        abstractScriptEClass.getESuperTypes ().add ( this.getScript () );

        // Initialize classes, features, and operations; add parameters
        initEClass ( scriptEClass, Script.class, "Script", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEOperation ( getScript__GetLanguage (), ecorePackage.getEString (), "getLanguage", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEOperation ( getScript__GetSource (), ecorePackage.getEString (), "getSource", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( genericScriptEClass, GenericScript.class, "GenericScript", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getGenericScript_Language (), ecorePackage.getEString (), "language", null, 1, 1, GenericScript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( javaScriptEClass, JavaScript.class, "JavaScript", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( scriptReferenceEClass, ScriptReference.class, "ScriptReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getScriptReference_Reference (), this.getScript (), null, "reference", null, 1, 1, ScriptReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( abstractScriptEClass, AbstractScript.class, "AbstractScript", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getAbstractScript_Source (), ecorePackage.getEString (), "source", null, 1, 1, AbstractScript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        // Create resource
        createResource ( eNS_URI );
    }

} //ScriptPackageImpl
