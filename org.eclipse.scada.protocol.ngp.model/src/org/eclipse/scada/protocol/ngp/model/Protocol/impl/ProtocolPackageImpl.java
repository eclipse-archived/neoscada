/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - implement security callback system
 *******************************************************************************/
package org.eclipse.scada.protocol.ngp.model.Protocol.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.scada.protocol.ngp.model.Protocol.Attribute;
import org.eclipse.scada.protocol.ngp.model.Protocol.AttributeStructure;
import org.eclipse.scada.protocol.ngp.model.Protocol.BooleanAttribute;
import org.eclipse.scada.protocol.ngp.model.Protocol.DocumentedElement;
import org.eclipse.scada.protocol.ngp.model.Protocol.EnumAttribute;
import org.eclipse.scada.protocol.ngp.model.Protocol.FloatAttribute;
import org.eclipse.scada.protocol.ngp.model.Protocol.IntegerAttribute;
import org.eclipse.scada.protocol.ngp.model.Protocol.Interface;
import org.eclipse.scada.protocol.ngp.model.Protocol.LongAttribute;
import org.eclipse.scada.protocol.ngp.model.Protocol.Message;
import org.eclipse.scada.protocol.ngp.model.Protocol.PropertiesAttribute;
import org.eclipse.scada.protocol.ngp.model.Protocol.Protocol;
import org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolFactory;
import org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage;
import org.eclipse.scada.protocol.ngp.model.Protocol.StringAttribute;
import org.eclipse.scada.protocol.ngp.model.Protocol.Structure;
import org.eclipse.scada.protocol.ngp.model.Protocol.StructureAttribute;
import org.eclipse.scada.protocol.ngp.model.Protocol.Type;
import org.eclipse.scada.protocol.ngp.model.Protocol.VariantAttribute;
import org.eclipse.scada.protocol.ngp.model.Protocol.VariantMapAttribute;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProtocolPackageImpl extends EPackageImpl implements ProtocolPackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass messageEClass = null;

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
    private EClass protocolEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass structureEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass stringAttributeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass booleanAttributeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass structureAttributeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass variantAttributeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass integerAttributeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass longAttributeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass floatAttributeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass variantMapAttributeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass propertiesAttributeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass enumEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass enumAttributeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass interfaceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass attributeStructureEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass documentedElementEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EEnum typeEEnum = null;

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
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private ProtocolPackageImpl ()
    {
        super ( eNS_URI, ProtocolFactory.eINSTANCE );
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
     * This method is used to initialize {@link ProtocolPackage#eINSTANCE} when
     * that field is accessed. Clients should not invoke it directly. Instead,
     * they should simply access that field to obtain the package. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static ProtocolPackage init ()
    {
        if ( isInited )
            return (ProtocolPackage)EPackage.Registry.INSTANCE.getEPackage ( ProtocolPackage.eNS_URI );

        // Obtain or create and register package
        ProtocolPackageImpl theProtocolPackage = (ProtocolPackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof ProtocolPackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new ProtocolPackageImpl () );

        isInited = true;

        // Create package meta-data objects
        theProtocolPackage.createPackageContents ();

        // Initialize created meta-data
        theProtocolPackage.initializePackageContents ();

        // Mark meta-data to indicate it can't be changed
        theProtocolPackage.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( ProtocolPackage.eNS_URI, theProtocolPackage );
        return theProtocolPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getMessage ()
    {
        return messageEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getMessage_Code ()
    {
        return (EAttribute)messageEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getMessage_Protocol ()
    {
        return (EReference)messageEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getMessage_Interfaces ()
    {
        return (EReference)messageEClass.getEStructuralFeatures ().get ( 2 );
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
    public EAttribute getAttribute_FieldNumber ()
    {
        return (EAttribute)attributeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getAttribute_Equality ()
    {
        return (EAttribute)attributeEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getAttribute_Type ()
    {
        return (EAttribute)attributeEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getAttribute_Transient ()
    {
        return (EAttribute)attributeEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getAttribute_Deleted ()
    {
        return (EAttribute)attributeEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getProtocol ()
    {
        return protocolEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getProtocol_Messages ()
    {
        return (EReference)protocolEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getProtocol_Name ()
    {
        return (EAttribute)protocolEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getProtocol_IncludedProtocols ()
    {
        return (EReference)protocolEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getProtocol_LicenseHeader ()
    {
        return (EAttribute)protocolEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getProtocol_Enums ()
    {
        return (EReference)protocolEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getProtocol_Interfaces ()
    {
        return (EReference)protocolEClass.getEStructuralFeatures ().get ( 7 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getProtocol_Version ()
    {
        return (EAttribute)protocolEClass.getEStructuralFeatures ().get ( 8 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getProtocol_Structures ()
    {
        return (EReference)protocolEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getProtocol_PackagePrefix ()
    {
        return (EAttribute)protocolEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getStructure ()
    {
        return structureEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getStructure_Protocol ()
    {
        return (EReference)structureEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getStringAttribute ()
    {
        return stringAttributeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getBooleanAttribute ()
    {
        return booleanAttributeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getStructureAttribute ()
    {
        return structureAttributeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getStructureAttribute_Structure ()
    {
        return (EReference)structureAttributeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getVariantAttribute ()
    {
        return variantAttributeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getIntegerAttribute ()
    {
        return integerAttributeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getLongAttribute ()
    {
        return longAttributeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getFloatAttribute ()
    {
        return floatAttributeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getVariantMapAttribute ()
    {
        return variantMapAttributeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getPropertiesAttribute ()
    {
        return propertiesAttributeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getEnum ()
    {
        return enumEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getEnum_Name ()
    {
        return (EAttribute)enumEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getEnum_Literals ()
    {
        return (EAttribute)enumEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getEnum_Protocol ()
    {
        return (EReference)enumEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getEnumAttribute ()
    {
        return enumAttributeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getEnumAttribute_EnumType ()
    {
        return (EReference)enumAttributeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getInterface ()
    {
        return interfaceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getInterface_Protocol ()
    {
        return (EReference)interfaceEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getAttributeStructure ()
    {
        return attributeStructureEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getAttributeStructure_Name ()
    {
        return (EAttribute)attributeStructureEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EReference getAttributeStructure_Attributes ()
    {
        return (EReference)attributeStructureEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EClass getDocumentedElement ()
    {
        return documentedElementEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getDocumentedElement_Description ()
    {
        return (EAttribute)documentedElementEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EAttribute getDocumentedElement_ShortDescription ()
    {
        return (EAttribute)documentedElementEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EEnum getType ()
    {
        return typeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ProtocolFactory getProtocolFactory ()
    {
        return (ProtocolFactory)getEFactoryInstance ();
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
        messageEClass = createEClass ( MESSAGE );
        createEAttribute ( messageEClass, MESSAGE__CODE );
        createEReference ( messageEClass, MESSAGE__PROTOCOL );
        createEReference ( messageEClass, MESSAGE__INTERFACES );

        attributeEClass = createEClass ( ATTRIBUTE );
        createEAttribute ( attributeEClass, ATTRIBUTE__NAME );
        createEAttribute ( attributeEClass, ATTRIBUTE__FIELD_NUMBER );
        createEAttribute ( attributeEClass, ATTRIBUTE__EQUALITY );
        createEAttribute ( attributeEClass, ATTRIBUTE__TYPE );
        createEAttribute ( attributeEClass, ATTRIBUTE__TRANSIENT );
        createEAttribute ( attributeEClass, ATTRIBUTE__DELETED );

        protocolEClass = createEClass ( PROTOCOL );
        createEReference ( protocolEClass, PROTOCOL__MESSAGES );
        createEAttribute ( protocolEClass, PROTOCOL__NAME );
        createEReference ( protocolEClass, PROTOCOL__STRUCTURES );
        createEAttribute ( protocolEClass, PROTOCOL__PACKAGE_PREFIX );
        createEReference ( protocolEClass, PROTOCOL__INCLUDED_PROTOCOLS );
        createEAttribute ( protocolEClass, PROTOCOL__LICENSE_HEADER );
        createEReference ( protocolEClass, PROTOCOL__ENUMS );
        createEReference ( protocolEClass, PROTOCOL__INTERFACES );
        createEAttribute ( protocolEClass, PROTOCOL__VERSION );

        structureEClass = createEClass ( STRUCTURE );
        createEReference ( structureEClass, STRUCTURE__PROTOCOL );

        stringAttributeEClass = createEClass ( STRING_ATTRIBUTE );

        booleanAttributeEClass = createEClass ( BOOLEAN_ATTRIBUTE );

        structureAttributeEClass = createEClass ( STRUCTURE_ATTRIBUTE );
        createEReference ( structureAttributeEClass, STRUCTURE_ATTRIBUTE__STRUCTURE );

        variantAttributeEClass = createEClass ( VARIANT_ATTRIBUTE );

        integerAttributeEClass = createEClass ( INTEGER_ATTRIBUTE );

        longAttributeEClass = createEClass ( LONG_ATTRIBUTE );

        floatAttributeEClass = createEClass ( FLOAT_ATTRIBUTE );

        variantMapAttributeEClass = createEClass ( VARIANT_MAP_ATTRIBUTE );

        propertiesAttributeEClass = createEClass ( PROPERTIES_ATTRIBUTE );

        enumEClass = createEClass ( ENUM );
        createEAttribute ( enumEClass, ENUM__NAME );
        createEAttribute ( enumEClass, ENUM__LITERALS );
        createEReference ( enumEClass, ENUM__PROTOCOL );

        enumAttributeEClass = createEClass ( ENUM_ATTRIBUTE );
        createEReference ( enumAttributeEClass, ENUM_ATTRIBUTE__ENUM_TYPE );

        interfaceEClass = createEClass ( INTERFACE );
        createEReference ( interfaceEClass, INTERFACE__PROTOCOL );

        attributeStructureEClass = createEClass ( ATTRIBUTE_STRUCTURE );
        createEAttribute ( attributeStructureEClass, ATTRIBUTE_STRUCTURE__NAME );
        createEReference ( attributeStructureEClass, ATTRIBUTE_STRUCTURE__ATTRIBUTES );

        documentedElementEClass = createEClass ( DOCUMENTED_ELEMENT );
        createEAttribute ( documentedElementEClass, DOCUMENTED_ELEMENT__DESCRIPTION );
        createEAttribute ( documentedElementEClass, DOCUMENTED_ELEMENT__SHORT_DESCRIPTION );

        // Create enums
        typeEEnum = createEEnum ( TYPE );
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
        messageEClass.getESuperTypes ().add ( this.getAttributeStructure () );
        attributeEClass.getESuperTypes ().add ( this.getDocumentedElement () );
        protocolEClass.getESuperTypes ().add ( this.getDocumentedElement () );
        structureEClass.getESuperTypes ().add ( this.getAttributeStructure () );
        stringAttributeEClass.getESuperTypes ().add ( this.getAttribute () );
        booleanAttributeEClass.getESuperTypes ().add ( this.getAttribute () );
        structureAttributeEClass.getESuperTypes ().add ( this.getAttribute () );
        variantAttributeEClass.getESuperTypes ().add ( this.getAttribute () );
        integerAttributeEClass.getESuperTypes ().add ( this.getAttribute () );
        longAttributeEClass.getESuperTypes ().add ( this.getAttribute () );
        floatAttributeEClass.getESuperTypes ().add ( this.getAttribute () );
        variantMapAttributeEClass.getESuperTypes ().add ( this.getAttribute () );
        propertiesAttributeEClass.getESuperTypes ().add ( this.getAttribute () );
        enumEClass.getESuperTypes ().add ( this.getDocumentedElement () );
        enumAttributeEClass.getESuperTypes ().add ( this.getAttribute () );
        interfaceEClass.getESuperTypes ().add ( this.getAttributeStructure () );
        attributeStructureEClass.getESuperTypes ().add ( this.getDocumentedElement () );

        // Initialize classes and features; add operations and parameters
        initEClass ( messageEClass, Message.class, "Message", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getMessage_Code (), ecorePackage.getEInt (), "code", null, 1, 1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getMessage_Protocol (), this.getProtocol (), this.getProtocol_Messages (), "protocol", null, 1, 1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getMessage_Interfaces (), this.getInterface (), null, "interfaces", null, 0, -1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( attributeEClass, Attribute.class, "Attribute", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getAttribute_Name (), ecorePackage.getEString (), "name", null, 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getAttribute_FieldNumber (), ecorePackage.getEByte (), "fieldNumber", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getAttribute_Equality (), ecorePackage.getEBoolean (), "equality", "false", 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getAttribute_Type (), this.getType (), "type", "SCALAR", 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getAttribute_Transient (), ecorePackage.getEBoolean (), "transient", "false", 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$
        initEAttribute ( getAttribute_Deleted (), ecorePackage.getEBoolean (), "deleted", "false", 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( protocolEClass, Protocol.class, "Protocol", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getProtocol_Messages (), this.getMessage (), this.getMessage_Protocol (), "messages", null, 0, -1, Protocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getProtocol_Name (), ecorePackage.getEString (), "name", null, 1, 1, Protocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getProtocol_Structures (), this.getStructure (), this.getStructure_Protocol (), "structures", null, 0, -1, Protocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getProtocol_PackagePrefix (), ecorePackage.getEString (), "packagePrefix", null, 1, 1, Protocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getProtocol_IncludedProtocols (), this.getProtocol (), null, "includedProtocols", null, 0, -1, Protocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getProtocol_LicenseHeader (), ecorePackage.getEString (), "licenseHeader", null, 0, 1, Protocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getProtocol_Enums (), this.getEnum (), this.getEnum_Protocol (), "enums", null, 0, -1, Protocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getProtocol_Interfaces (), this.getInterface (), this.getInterface_Protocol (), "interfaces", null, 0, -1, Protocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getProtocol_Version (), ecorePackage.getEShort (), "version", null, 1, 1, Protocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( structureEClass, Structure.class, "Structure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getStructure_Protocol (), this.getProtocol (), this.getProtocol_Structures (), "protocol", null, 1, 1, Structure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( stringAttributeEClass, StringAttribute.class, "StringAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( booleanAttributeEClass, BooleanAttribute.class, "BooleanAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( structureAttributeEClass, StructureAttribute.class, "StructureAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getStructureAttribute_Structure (), this.getStructure (), null, "structure", null, 1, 1, StructureAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( variantAttributeEClass, VariantAttribute.class, "VariantAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( integerAttributeEClass, IntegerAttribute.class, "IntegerAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( longAttributeEClass, LongAttribute.class, "LongAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( floatAttributeEClass, FloatAttribute.class, "FloatAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( variantMapAttributeEClass, VariantMapAttribute.class, "VariantMapAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( propertiesAttributeEClass, PropertiesAttribute.class, "PropertiesAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$

        initEClass ( enumEClass, org.eclipse.scada.protocol.ngp.model.Protocol.Enum.class, "Enum", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getEnum_Name (), ecorePackage.getEString (), "name", null, 1, 1, org.eclipse.scada.protocol.ngp.model.Protocol.Enum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getEnum_Literals (), ecorePackage.getEString (), "literals", null, 0, -1, org.eclipse.scada.protocol.ngp.model.Protocol.Enum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getEnum_Protocol (), this.getProtocol (), this.getProtocol_Enums (), "protocol", null, 0, 1, org.eclipse.scada.protocol.ngp.model.Protocol.Enum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( enumAttributeEClass, EnumAttribute.class, "EnumAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getEnumAttribute_EnumType (), this.getEnum (), null, "enumType", null, 1, 1, EnumAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( interfaceEClass, Interface.class, "Interface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getInterface_Protocol (), this.getProtocol (), this.getProtocol_Interfaces (), "protocol", null, 1, 1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( attributeStructureEClass, AttributeStructure.class, "AttributeStructure", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getAttributeStructure_Name (), ecorePackage.getEString (), "name", null, 1, 1, AttributeStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getAttributeStructure_Attributes (), this.getAttribute (), null, "attributes", null, 0, -1, AttributeStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( documentedElementEClass, DocumentedElement.class, "DocumentedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getDocumentedElement_Description (), ecorePackage.getEString (), "description", null, 0, 1, DocumentedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getDocumentedElement_ShortDescription (), ecorePackage.getEString (), "shortDescription", null, 0, 1, DocumentedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        // Initialize enums and add enum literals
        initEEnum ( typeEEnum, Type.class, "Type" ); //$NON-NLS-1$
        addEEnumLiteral ( typeEEnum, Type.SCALAR );
        addEEnumLiteral ( typeEEnum, Type.OPTIONAL );
        addEEnumLiteral ( typeEEnum, Type.ORDERED );
        addEEnumLiteral ( typeEEnum, Type.UNIQUE );

        // Create resource
        createResource ( eNS_URI );
    }

} //ProtocolPackageImpl
