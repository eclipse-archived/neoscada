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
 * 
 * @generated
 */
public class MemoryPackageImpl extends EPackageImpl implements MemoryPackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass typeDefinitionEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass userDefinedTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass unsignedInteger16TypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass scalarTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass unsignedInteger32TypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass unsignedInteger8TypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass typeSystemEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass orderedTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EEnum byteOrderEEnum = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass bitTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass typeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass variableEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass attributeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass float32TypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
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
     * 
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
        {
            return (MemoryPackage)EPackage.Registry.INSTANCE.getEPackage ( MemoryPackage.eNS_URI );
        }

        // Obtain or create and register package
        final MemoryPackageImpl theMemoryPackage = (MemoryPackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof MemoryPackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new MemoryPackageImpl () );

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
     * 
     * @generated
     */
    @Override
    public EClass getTypeDefinition ()
    {
        return this.typeDefinitionEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getTypeDefinition_Name ()
    {
        return (EAttribute)this.typeDefinitionEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getTypeDefinition_Variables ()
    {
        return (EReference)this.typeDefinitionEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getUserDefinedType ()
    {
        return this.userDefinedTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getUserDefinedType_Type ()
    {
        return (EReference)this.userDefinedTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getUnsignedInteger16Type ()
    {
        return this.unsignedInteger16TypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getScalarType ()
    {
        return this.scalarTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getUnsignedInteger32Type ()
    {
        return this.unsignedInteger32TypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getUnsignedInteger8Type ()
    {
        return this.unsignedInteger8TypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getTypeSystem ()
    {
        return this.typeSystemEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getTypeSystem_Types ()
    {
        return (EReference)this.typeSystemEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getTypeSystem_Includes ()
    {
        return (EReference)this.typeSystemEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getTypeSystem_Name ()
    {
        return (EAttribute)this.typeSystemEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getOrderedType ()
    {
        return this.orderedTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getOrderedType_Order ()
    {
        return (EAttribute)this.orderedTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EEnum getByteOrder ()
    {
        return this.byteOrderEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getBitType ()
    {
        return this.bitTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getBitType_SubIndex ()
    {
        return (EAttribute)this.bitTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getType ()
    {
        return this.typeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getType_Index ()
    {
        return (EAttribute)this.typeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EOperation getType__Encode ()
    {
        return this.typeEClass.getEOperations ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getVariable ()
    {
        return this.variableEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getVariable_Type ()
    {
        return (EReference)this.variableEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getVariable_Name ()
    {
        return (EAttribute)this.variableEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getVariable_Attributes ()
    {
        return (EReference)this.variableEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getAttribute ()
    {
        return this.attributeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getAttribute_Name ()
    {
        return (EAttribute)this.attributeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getAttribute_Type ()
    {
        return (EReference)this.attributeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getFloat32Type ()
    {
        return this.float32TypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getBaseScalarType ()
    {
        return this.baseScalarTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
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
     * 
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package. This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void createPackageContents ()
    {
        if ( this.isCreated )
        {
            return;
        }
        this.isCreated = true;

        // Create classes and their features
        this.typeDefinitionEClass = createEClass ( TYPE_DEFINITION );
        createEAttribute ( this.typeDefinitionEClass, TYPE_DEFINITION__NAME );
        createEReference ( this.typeDefinitionEClass, TYPE_DEFINITION__VARIABLES );

        this.bitTypeEClass = createEClass ( BIT_TYPE );
        createEAttribute ( this.bitTypeEClass, BIT_TYPE__SUB_INDEX );

        this.typeEClass = createEClass ( TYPE );
        createEAttribute ( this.typeEClass, TYPE__INDEX );
        createEOperation ( this.typeEClass, TYPE___ENCODE );

        this.variableEClass = createEClass ( VARIABLE );
        createEReference ( this.variableEClass, VARIABLE__TYPE );
        createEAttribute ( this.variableEClass, VARIABLE__NAME );
        createEReference ( this.variableEClass, VARIABLE__ATTRIBUTES );

        this.attributeEClass = createEClass ( ATTRIBUTE );
        createEAttribute ( this.attributeEClass, ATTRIBUTE__NAME );
        createEReference ( this.attributeEClass, ATTRIBUTE__TYPE );

        this.float32TypeEClass = createEClass ( FLOAT32_TYPE );

        this.baseScalarTypeEClass = createEClass ( BASE_SCALAR_TYPE );

        this.userDefinedTypeEClass = createEClass ( USER_DEFINED_TYPE );
        createEReference ( this.userDefinedTypeEClass, USER_DEFINED_TYPE__TYPE );

        this.unsignedInteger16TypeEClass = createEClass ( UNSIGNED_INTEGER16_TYPE );

        this.scalarTypeEClass = createEClass ( SCALAR_TYPE );

        this.unsignedInteger32TypeEClass = createEClass ( UNSIGNED_INTEGER32_TYPE );

        this.unsignedInteger8TypeEClass = createEClass ( UNSIGNED_INTEGER8_TYPE );

        this.typeSystemEClass = createEClass ( TYPE_SYSTEM );
        createEReference ( this.typeSystemEClass, TYPE_SYSTEM__TYPES );
        createEReference ( this.typeSystemEClass, TYPE_SYSTEM__INCLUDES );
        createEAttribute ( this.typeSystemEClass, TYPE_SYSTEM__NAME );

        this.orderedTypeEClass = createEClass ( ORDERED_TYPE );
        createEAttribute ( this.orderedTypeEClass, ORDERED_TYPE__ORDER );

        // Create enums
        this.byteOrderEEnum = createEEnum ( BYTE_ORDER );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model. This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void initializePackageContents ()
    {
        if ( this.isInitialized )
        {
            return;
        }
        this.isInitialized = true;

        // Initialize package
        setName ( eNAME );
        setNsPrefix ( eNS_PREFIX );
        setNsURI ( eNS_URI );

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.bitTypeEClass.getESuperTypes ().add ( getBaseScalarType () );
        this.float32TypeEClass.getESuperTypes ().add ( getBaseScalarType () );
        this.baseScalarTypeEClass.getESuperTypes ().add ( getScalarType () );
        this.userDefinedTypeEClass.getESuperTypes ().add ( getType () );
        this.unsignedInteger16TypeEClass.getESuperTypes ().add ( getOrderedType () );
        this.scalarTypeEClass.getESuperTypes ().add ( getType () );
        this.unsignedInteger32TypeEClass.getESuperTypes ().add ( getOrderedType () );
        this.unsignedInteger8TypeEClass.getESuperTypes ().add ( getBaseScalarType () );
        this.orderedTypeEClass.getESuperTypes ().add ( getBaseScalarType () );

        // Initialize classes, features, and operations; add parameters
        initEClass ( this.typeDefinitionEClass, TypeDefinition.class, "TypeDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getTypeDefinition_Name (), this.ecorePackage.getEString (), "name", null, 1, 1, TypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getTypeDefinition_Variables (), getVariable (), null, "variables", null, 0, -1, TypeDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.bitTypeEClass, BitType.class, "BitType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getBitType_SubIndex (), this.ecorePackage.getEInt (), "subIndex", null, 1, 1, BitType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.typeEClass, Type.class, "Type", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getType_Index (), this.ecorePackage.getEInt (), "index", null, 1, 1, Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEOperation ( getType__Encode (), this.ecorePackage.getEString (), "encode", 1, 1, IS_UNIQUE, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.variableEClass, Variable.class, "Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getVariable_Type (), getType (), null, "type", null, 1, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getVariable_Name (), this.ecorePackage.getEString (), "name", null, 1, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getVariable_Attributes (), getAttribute (), null, "attributes", null, 0, -1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.attributeEClass, Attribute.class, "Attribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getAttribute_Name (), this.ecorePackage.getEString (), "name", null, 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getAttribute_Type (), getScalarType (), null, "type", null, 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.float32TypeEClass, Float32Type.class, "Float32Type", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.baseScalarTypeEClass, BaseScalarType.class, "BaseScalarType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.userDefinedTypeEClass, UserDefinedType.class, "UserDefinedType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getUserDefinedType_Type (), getTypeDefinition (), null, "type", null, 1, 1, UserDefinedType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        getUserDefinedType_Type ().getEKeys ().add ( getTypeDefinition_Name () );

        initEClass ( this.unsignedInteger16TypeEClass, UnsignedInteger16Type.class, "UnsignedInteger16Type", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.scalarTypeEClass, ScalarType.class, "ScalarType", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.unsignedInteger32TypeEClass, UnsignedInteger32Type.class, "UnsignedInteger32Type", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.unsignedInteger8TypeEClass, UnsignedInteger8Type.class, "UnsignedInteger8Type", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( this.typeSystemEClass, TypeSystem.class, "TypeSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getTypeSystem_Types (), getTypeDefinition (), null, "types", null, 0, -1, TypeSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        getTypeSystem_Types ().getEKeys ().add ( getTypeDefinition_Name () );
        initEReference ( getTypeSystem_Includes (), getTypeSystem (), null, "includes", null, 0, -1, TypeSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED ); //$NON-NLS-1$
        getTypeSystem_Includes ().getEKeys ().add ( getTypeSystem_Name () );
        initEAttribute ( getTypeSystem_Name (), this.ecorePackage.getEString (), "name", null, 1, 1, TypeSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( this.orderedTypeEClass, OrderedType.class, "OrderedType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getOrderedType_Order (), getByteOrder (), "order", "BIG_ENDIAN", 1, 1, OrderedType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        // Initialize enums and add enum literals
        initEEnum ( this.byteOrderEEnum, ByteOrder.class, "ByteOrder" ); //$NON-NLS-1$
        addEEnumLiteral ( this.byteOrderEEnum, ByteOrder.BIG_ENDIAN );
        addEEnumLiteral ( this.byteOrderEEnum, ByteOrder.LITTLE_ENDIAN );

        // Create resource
        createResource ( eNS_URI );
    }

} //MemoryPackageImpl
