/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.memory.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.scada.configuration.memory.Attribute;
import org.eclipse.scada.configuration.memory.BaseScalarType;
import org.eclipse.scada.configuration.memory.BitType;
import org.eclipse.scada.configuration.memory.ByteOrder;
import org.eclipse.scada.configuration.memory.Float32Type;
import org.eclipse.scada.configuration.memory.MemoryFactory;
import org.eclipse.scada.configuration.memory.MemoryPackage;
import org.eclipse.scada.configuration.memory.OrderedType;
import org.eclipse.scada.configuration.memory.ScalarType;
import org.eclipse.scada.configuration.memory.Type;
import org.eclipse.scada.configuration.memory.TypeDefinition;
import org.eclipse.scada.configuration.memory.TypeSystem;
import org.eclipse.scada.configuration.memory.UnsignedInteger16Type;
import org.eclipse.scada.configuration.memory.UnsignedInteger32Type;
import org.eclipse.scada.configuration.memory.UnsignedInteger8Type;
import org.eclipse.scada.configuration.memory.UserDefinedType;
import org.eclipse.scada.configuration.memory.Variable;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MemoryPackageImpl extends EPackageImpl implements MemoryPackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass typeDefinitionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass userDefinedTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass unsignedInteger16TypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass scalarTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass unsignedInteger32TypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass unsignedInteger8TypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass typeSystemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass orderedTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum byteOrderEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass bitTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass typeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass variableEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass attributeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass float32TypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass baseScalarTypeEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
     * package
     * package URI value.
     * <p>
     * Note: the correct way to create the package is via the static factory
     * method {@link #init init()}, which also performs initialization of the
     * package, or returns the registered package, if one already exists. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.eclipse.scada.configuration.memory.MemoryPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private MemoryPackageImpl ()
    {
        super ( eNS_URI, MemoryFactory.eINSTANCE );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model,
     * and for any others upon which it depends.
     * <p>
     * This method is used to initialize {@link MemoryPackage#eINSTANCE} when
     * that field is accessed. Clients should not invoke it directly. Instead,
     * they should simply access that field to obtain the package. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static MemoryPackage init ()
    {
        if ( isInited )
            return (MemoryPackage)EPackage.Registry.INSTANCE.getEPackage ( MemoryPackage.eNS_URI );

        // Obtain or create and register package
        MemoryPackageImpl theMemoryPackage = (MemoryPackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof MemoryPackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new MemoryPackageImpl () );

        isInited = true;

        // Create package meta-data objects
        theMemoryPackage.createPackageContents ();

        // Initialize created meta-data
        theMemoryPackage.initializePackageContents ();

        // Mark meta-data to indicate it can't be changed
        theMemoryPackage.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( MemoryPackage.eNS_URI, theMemoryPackage );
        return theMemoryPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getTypeDefinition ()
    {
        return typeDefinitionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getTypeDefinition_Name ()
    {
        return (EAttribute)typeDefinitionEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getTypeDefinition_Variables ()
    {
        return (EReference)typeDefinitionEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getUserDefinedType ()
    {
        return userDefinedTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getUserDefinedType_Type ()
    {
        return (EReference)userDefinedTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getUnsignedInteger16Type ()
    {
        return unsignedInteger16TypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getScalarType ()
    {
        return scalarTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getUnsignedInteger32Type ()
    {
        return unsignedInteger32TypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getUnsignedInteger8Type ()
    {
        return unsignedInteger8TypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getTypeSystem ()
    {
        return typeSystemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getTypeSystem_Types ()
    {
        return (EReference)typeSystemEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getTypeSystem_Includes ()
    {
        return (EReference)typeSystemEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getTypeSystem_Name ()
    {
        return (EAttribute)typeSystemEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getOrderedType ()
    {
        return orderedTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getOrderedType_Order ()
    {
        return (EAttribute)orderedTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EEnum getByteOrder ()
    {
        return byteOrderEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getBitType ()
    {
        return bitTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getBitType_SubIndex ()
    {
        return (EAttribute)bitTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getType ()
    {
        return typeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getType_Index ()
    {
        return (EAttribute)typeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getType_Length ()
    {
        return (EAttribute)typeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EOperation getType__Encode ()
    {
        return typeEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getVariable ()
    {
        return variableEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getVariable_Type ()
    {
        return (EReference)variableEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getVariable_Name ()
    {
        return (EAttribute)variableEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getVariable_Attributes ()
    {
        return (EReference)variableEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getAttribute ()
    {
        return attributeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getAttribute_Name ()
    {
        return (EAttribute)attributeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getAttribute_Type ()
    {
        return (EReference)attributeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getFloat32Type ()
    {
        return float32TypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getBaseScalarType ()
    {
        return baseScalarTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public MemoryFactory getMemoryFactory ()
    {
        return (MemoryFactory)getEFactoryInstance ();
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
        typeDefinitionEClass = createEClass ( TYPE_DEFINITION );
        createEAttribute ( typeDefinitionEClass, TYPE_DEFINITION__NAME );
        createEReference ( typeDefinitionEClass, TYPE_DEFINITION__VARIABLES );

        bitTypeEClass = createEClass ( BIT_TYPE );
        createEAttribute ( bitTypeEClass, BIT_TYPE__SUB_INDEX );

        typeEClass = createEClass ( TYPE );
        createEAttribute ( typeEClass, TYPE__INDEX );
        createEAttribute ( typeEClass, TYPE__LENGTH );
        createEOperation ( typeEClass, TYPE___ENCODE );

        variableEClass = createEClass ( VARIABLE );
        createEReference ( variableEClass, VARIABLE__TYPE );
        createEAttribute ( variableEClass, VARIABLE__NAME );
        createEReference ( variableEClass, VARIABLE__ATTRIBUTES );

        attributeEClass = createEClass ( ATTRIBUTE );
        createEAttribute ( attributeEClass, ATTRIBUTE__NAME );
        createEReference ( attributeEClass, ATTRIBUTE__TYPE );

        float32TypeEClass = createEClass ( FLOAT32_TYPE );

        baseScalarTypeEClass = createEClass ( BASE_SCALAR_TYPE );

        userDefinedTypeEClass = createEClass ( USER_DEFINED_TYPE );
        createEReference ( userDefinedTypeEClass, USER_DEFINED_TYPE__TYPE );

        unsignedInteger16TypeEClass = createEClass ( UNSIGNED_INTEGER16_TYPE );

        scalarTypeEClass = createEClass ( SCALAR_TYPE );

        unsignedInteger32TypeEClass = createEClass ( UNSIGNED_INTEGER32_TYPE );

        unsignedInteger8TypeEClass = createEClass ( UNSIGNED_INTEGER8_TYPE );

        typeSystemEClass = createEClass ( TYPE_SYSTEM );
        createEReference ( typeSystemEClass, TYPE_SYSTEM__TYPES );
        createEReference ( typeSystemEClass, TYPE_SYSTEM__INCLUDES );
        createEAttribute ( typeSystemEClass, TYPE_SYSTEM__NAME );

        orderedTypeEClass = createEClass ( ORDERED_TYPE );
        createEAttribute ( orderedTypeEClass, ORDERED_TYPE__ORDER );

        // Create enums
        byteOrderEEnum = createEEnum ( BYTE_ORDER );
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
        bitTypeEClass.getESuperTypes ().add ( this.getBaseScalarType () );
        float32TypeEClass.getESuperTypes ().add ( this.getBaseScalarType () );
        baseScalarTypeEClass.getESuperTypes ().add ( this.getScalarType () );
        userDefinedTypeEClass.getESuperTypes ().add ( this.getType () );
        unsignedInteger16TypeEClass.getESuperTypes ().add ( this.getOrderedType () );
        scalarTypeEClass.getESuperTypes ().add ( this.getType () );
        unsignedInteger32TypeEClass.getESuperTypes ().add ( this.getOrderedType () );
        unsignedInteger8TypeEClass.getESuperTypes ().add ( this.getBaseScalarType () );
        orderedTypeEClass.getESuperTypes ().add ( this.getBaseScalarType () );

        // Initialize classes, features, and operations; add parameters
        initEClass ( typeDefinitionEClass, TypeDefinition.class, "TypeDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getTypeDefinition_Name (), ecorePackage.getEString (), "name", null, 1, 1, TypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getTypeDefinition_Variables (), this.getVariable (), null, "variables", null, 0, -1, TypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( bitTypeEClass, BitType.class, "BitType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getBitType_SubIndex (), ecorePackage.getEInt (), "subIndex", null, 1, 1, BitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( typeEClass, Type.class, "Type", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getType_Index (), ecorePackage.getEInt (), "index", null, 1, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getType_Length (), ecorePackage.getEInt (), "length", null, 1, 1, Type.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEOperation ( getType__Encode (), ecorePackage.getEString (), "encode", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( variableEClass, Variable.class, "Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getVariable_Type (), this.getType (), null, "type", null, 1, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getVariable_Name (), ecorePackage.getEString (), "name", null, 1, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getVariable_Attributes (), this.getAttribute (), null, "attributes", null, 0, -1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( attributeEClass, Attribute.class, "Attribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getAttribute_Name (), ecorePackage.getEString (), "name", null, 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getAttribute_Type (), this.getScalarType (), null, "type", null, 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( float32TypeEClass, Float32Type.class, "Float32Type", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( baseScalarTypeEClass, BaseScalarType.class, "BaseScalarType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( userDefinedTypeEClass, UserDefinedType.class, "UserDefinedType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getUserDefinedType_Type (), this.getTypeDefinition (), null, "type", null, 1, 1, UserDefinedType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        getUserDefinedType_Type ().getEKeys ().add ( this.getTypeDefinition_Name () );

        initEClass ( unsignedInteger16TypeEClass, UnsignedInteger16Type.class, "UnsignedInteger16Type", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( scalarTypeEClass, ScalarType.class, "ScalarType", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( unsignedInteger32TypeEClass, UnsignedInteger32Type.class, "UnsignedInteger32Type", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( unsignedInteger8TypeEClass, UnsignedInteger8Type.class, "UnsignedInteger8Type", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( typeSystemEClass, TypeSystem.class, "TypeSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getTypeSystem_Types (), this.getTypeDefinition (), null, "types", null, 0, -1, TypeSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        getTypeSystem_Types ().getEKeys ().add ( this.getTypeDefinition_Name () );
        initEReference ( getTypeSystem_Includes (), this.getTypeSystem (), null, "includes", null, 0, -1, TypeSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED ); //$NON-NLS-1$
        getTypeSystem_Includes ().getEKeys ().add ( this.getTypeSystem_Name () );
        initEAttribute ( getTypeSystem_Name (), ecorePackage.getEString (), "name", null, 1, 1, TypeSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( orderedTypeEClass, OrderedType.class, "OrderedType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getOrderedType_Order (), this.getByteOrder (), "order", "BIG_ENDIAN", 1, 1, OrderedType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        // Initialize enums and add enum literals
        initEEnum ( byteOrderEEnum, ByteOrder.class, "ByteOrder" ); //$NON-NLS-1$
        addEEnumLiteral ( byteOrderEEnum, ByteOrder.BIG_ENDIAN );
        addEEnumLiteral ( byteOrderEEnum, ByteOrder.LITTLE_ENDIAN );

        // Create resource
        createResource ( eNS_URI );
    }

} //MemoryPackageImpl
