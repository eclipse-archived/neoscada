/**
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Jens Reimann - initial API and implementation
 */
package org.eclipse.scada.da.server.common.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import org.eclipse.scada.da.server.common.AttributeType;
import org.eclipse.scada.da.server.common.AttributesType;
import org.eclipse.scada.da.server.common.CommonFactory;
import org.eclipse.scada.da.server.common.CommonPackage;
import org.eclipse.scada.da.server.common.VariantBooleanType;
import org.eclipse.scada.da.server.common.VariantDoubleType;
import org.eclipse.scada.da.server.common.VariantInt32Type;
import org.eclipse.scada.da.server.common.VariantInt64Type;
import org.eclipse.scada.da.server.common.VariantNullType;
import org.eclipse.scada.da.server.common.VariantType;

import org.eclipse.scada.da.server.common.util.CommonValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CommonPackageImpl extends EPackageImpl implements CommonPackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass attributesTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass attributeTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass variantBooleanTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass variantDoubleTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass variantInt32TypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass variantInt64TypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass variantNullTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass variantTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EDataType classTypeEDataType = null;

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
     * @see org.eclipse.scada.da.server.common.CommonPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private CommonPackageImpl ()
    {
        super ( eNS_URI, CommonFactory.eINSTANCE );
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
     * <p>This method is used to initialize {@link CommonPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static CommonPackage init ()
    {
        if ( isInited )
            return (CommonPackage)EPackage.Registry.INSTANCE.getEPackage ( CommonPackage.eNS_URI );

        // Obtain or create and register package
        CommonPackageImpl theCommonPackage = (CommonPackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof CommonPackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new CommonPackageImpl () );

        isInited = true;

        // Initialize simple dependencies
        XMLTypePackage.eINSTANCE.eClass ();

        // Create package meta-data objects
        theCommonPackage.createPackageContents ();

        // Initialize created meta-data
        theCommonPackage.initializePackageContents ();

        // Register package validator
        EValidator.Registry.INSTANCE.put
                ( theCommonPackage,
                        new EValidator.Descriptor ()
                        {
                            public EValidator getEValidator ()
                            {
                                return CommonValidator.INSTANCE;
                            }
                        } );

        // Mark meta-data to indicate it can't be changed
        theCommonPackage.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( CommonPackage.eNS_URI, theCommonPackage );
        return theCommonPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAttributesType ()
    {
        return attributesTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getAttributesType_Attribute ()
    {
        return (EReference)attributesTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAttributeType ()
    {
        return attributeTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getAttributeType_Name ()
    {
        return (EAttribute)attributeTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getVariantBooleanType ()
    {
        return variantBooleanTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getVariantBooleanType_Value ()
    {
        return (EAttribute)variantBooleanTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getVariantDoubleType ()
    {
        return variantDoubleTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getVariantDoubleType_Value ()
    {
        return (EAttribute)variantDoubleTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getVariantInt32Type ()
    {
        return variantInt32TypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getVariantInt32Type_Value ()
    {
        return (EAttribute)variantInt32TypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getVariantInt64Type ()
    {
        return variantInt64TypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getVariantInt64Type_Value ()
    {
        return (EAttribute)variantInt64TypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getVariantNullType ()
    {
        return variantNullTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getVariantType ()
    {
        return variantTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getVariantType_Null ()
    {
        return (EReference)variantTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getVariantType_String ()
    {
        return (EAttribute)variantTypeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getVariantType_Int32 ()
    {
        return (EReference)variantTypeEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getVariantType_Double ()
    {
        return (EReference)variantTypeEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getVariantType_Boolean ()
    {
        return (EReference)variantTypeEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getVariantType_Int64 ()
    {
        return (EReference)variantTypeEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EDataType getClassType ()
    {
        return classTypeEDataType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CommonFactory getCommonFactory ()
    {
        return (CommonFactory)getEFactoryInstance ();
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
        attributesTypeEClass = createEClass ( ATTRIBUTES_TYPE );
        createEReference ( attributesTypeEClass, ATTRIBUTES_TYPE__ATTRIBUTE );

        attributeTypeEClass = createEClass ( ATTRIBUTE_TYPE );
        createEAttribute ( attributeTypeEClass, ATTRIBUTE_TYPE__NAME );

        variantBooleanTypeEClass = createEClass ( VARIANT_BOOLEAN_TYPE );
        createEAttribute ( variantBooleanTypeEClass, VARIANT_BOOLEAN_TYPE__VALUE );

        variantDoubleTypeEClass = createEClass ( VARIANT_DOUBLE_TYPE );
        createEAttribute ( variantDoubleTypeEClass, VARIANT_DOUBLE_TYPE__VALUE );

        variantInt32TypeEClass = createEClass ( VARIANT_INT32_TYPE );
        createEAttribute ( variantInt32TypeEClass, VARIANT_INT32_TYPE__VALUE );

        variantInt64TypeEClass = createEClass ( VARIANT_INT64_TYPE );
        createEAttribute ( variantInt64TypeEClass, VARIANT_INT64_TYPE__VALUE );

        variantNullTypeEClass = createEClass ( VARIANT_NULL_TYPE );

        variantTypeEClass = createEClass ( VARIANT_TYPE );
        createEReference ( variantTypeEClass, VARIANT_TYPE__NULL );
        createEAttribute ( variantTypeEClass, VARIANT_TYPE__STRING );
        createEReference ( variantTypeEClass, VARIANT_TYPE__INT32 );
        createEReference ( variantTypeEClass, VARIANT_TYPE__DOUBLE );
        createEReference ( variantTypeEClass, VARIANT_TYPE__BOOLEAN );
        createEReference ( variantTypeEClass, VARIANT_TYPE__INT64 );

        // Create data types
        classTypeEDataType = createEDataType ( CLASS_TYPE );
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

        // Obtain other dependent packages
        XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage ( XMLTypePackage.eNS_URI );

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        attributeTypeEClass.getESuperTypes ().add ( this.getVariantType () );

        // Initialize classes, features, and operations; add parameters
        initEClass ( attributesTypeEClass, AttributesType.class, "AttributesType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getAttributesType_Attribute (), this.getAttributeType (), null, "attribute", null, 0, -1, AttributesType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( attributeTypeEClass, AttributeType.class, "AttributeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getAttributeType_Name (), theXMLTypePackage.getString (), "name", null, 1, 1, AttributeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( variantBooleanTypeEClass, VariantBooleanType.class, "VariantBooleanType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getVariantBooleanType_Value (), theXMLTypePackage.getBoolean (), "value", null, 0, 1, VariantBooleanType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( variantDoubleTypeEClass, VariantDoubleType.class, "VariantDoubleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getVariantDoubleType_Value (), theXMLTypePackage.getDouble (), "value", null, 0, 1, VariantDoubleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( variantInt32TypeEClass, VariantInt32Type.class, "VariantInt32Type", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getVariantInt32Type_Value (), theXMLTypePackage.getInt (), "value", null, 0, 1, VariantInt32Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( variantInt64TypeEClass, VariantInt64Type.class, "VariantInt64Type", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getVariantInt64Type_Value (), theXMLTypePackage.getLong (), "value", null, 0, 1, VariantInt64Type.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( variantNullTypeEClass, VariantNullType.class, "VariantNullType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( variantTypeEClass, VariantType.class, "VariantType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getVariantType_Null (), this.getVariantNullType (), null, "null", null, 0, 1, VariantType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getVariantType_String (), theXMLTypePackage.getString (), "string", null, 0, 1, VariantType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getVariantType_Int32 (), this.getVariantInt32Type (), null, "int32", null, 0, 1, VariantType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getVariantType_Double (), this.getVariantDoubleType (), null, "double", null, 0, 1, VariantType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getVariantType_Boolean (), this.getVariantBooleanType (), null, "boolean", null, 0, 1, VariantType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getVariantType_Int64 (), this.getVariantInt64Type (), null, "int64", null, 0, 1, VariantType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        // Initialize data types
        initEDataType ( classTypeEDataType, String.class, "ClassType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        // Create resource
        createResource ( eNS_URI );

        // Create annotations
        // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
        createExtendedMetaDataAnnotations ();
    }

    /**
     * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createExtendedMetaDataAnnotations ()
    {
        String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData"; //$NON-NLS-1$		
        addAnnotation ( attributesTypeEClass,
                source,
                new String[]
                {       "name", "AttributesType", //$NON-NLS-1$ //$NON-NLS-2$
                        "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( getAttributesType_Attribute (),
                source,
                new String[]
                {       "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
                        "name", "attribute" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( attributeTypeEClass,
                source,
                new String[]
                {       "name", "AttributeType", //$NON-NLS-1$ //$NON-NLS-2$
                        "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( getAttributeType_Name (),
                source,
                new String[]
                {       "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
                        "name", "name" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( classTypeEDataType,
                source,
                new String[]
                {       "name", "ClassType", //$NON-NLS-1$ //$NON-NLS-2$
                        "baseType", "http://www.eclipse.org/emf/2003/XMLType#string", //$NON-NLS-1$ //$NON-NLS-2$
                        "pattern", "[a-zA-Z]+(\\.[a-zA-Z0-9]+)*" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( variantBooleanTypeEClass,
                source,
                new String[]
                {       "name", "VariantBooleanType", //$NON-NLS-1$ //$NON-NLS-2$
                        "kind", "simple" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( getVariantBooleanType_Value (),
                source,
                new String[]
                {       "name", ":0", //$NON-NLS-1$ //$NON-NLS-2$
                        "kind", "simple" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( variantDoubleTypeEClass,
                source,
                new String[]
                {       "name", "VariantDoubleType", //$NON-NLS-1$ //$NON-NLS-2$
                        "kind", "simple" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( getVariantDoubleType_Value (),
                source,
                new String[]
                {       "name", ":0", //$NON-NLS-1$ //$NON-NLS-2$
                        "kind", "simple" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( variantInt32TypeEClass,
                source,
                new String[]
                {       "name", "VariantInt32Type", //$NON-NLS-1$ //$NON-NLS-2$
                        "kind", "simple" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( getVariantInt32Type_Value (),
                source,
                new String[]
                {       "name", ":0", //$NON-NLS-1$ //$NON-NLS-2$
                        "kind", "simple" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( variantInt64TypeEClass,
                source,
                new String[]
                {       "name", "VariantInt64Type", //$NON-NLS-1$ //$NON-NLS-2$
                        "kind", "simple" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( getVariantInt64Type_Value (),
                source,
                new String[]
                {       "name", ":0", //$NON-NLS-1$ //$NON-NLS-2$
                        "kind", "simple" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( variantNullTypeEClass,
                source,
                new String[]
                {       "name", "VariantNullType", //$NON-NLS-1$ //$NON-NLS-2$
                        "kind", "empty" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( variantTypeEClass,
                source,
                new String[]
                {       "name", "VariantType", //$NON-NLS-1$ //$NON-NLS-2$
                        "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( getVariantType_Null (),
                source,
                new String[]
                {       "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
                        "name", "null" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( getVariantType_String (),
                source,
                new String[]
                {       "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
                        "name", "string" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( getVariantType_Int32 (),
                source,
                new String[]
                {       "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
                        "name", "int32" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( getVariantType_Double (),
                source,
                new String[]
                {       "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
                        "name", "double" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( getVariantType_Boolean (),
                source,
                new String[]
                {       "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
                        "name", "boolean" //$NON-NLS-1$ //$NON-NLS-2$
                } );
        addAnnotation ( getVariantType_Int64 (),
                source,
                new String[]
                {       "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
                        "name", "int64" //$NON-NLS-1$ //$NON-NLS-2$
                } );
    }

} //CommonPackageImpl
