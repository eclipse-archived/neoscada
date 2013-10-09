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
 * 
 * @generated
 */
public class ProtocolPackageImpl extends EPackageImpl implements ProtocolPackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass messageEClass = null;

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
    private EClass protocolEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass structureEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass stringAttributeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass booleanAttributeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass structureAttributeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass variantAttributeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass integerAttributeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass longAttributeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass floatAttributeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass variantMapAttributeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass propertiesAttributeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass enumEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass enumAttributeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass interfaceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass attributeStructureEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass documentedElementEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
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
     * 
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
        {
            return (ProtocolPackage)EPackage.Registry.INSTANCE.getEPackage ( ProtocolPackage.eNS_URI );
        }

        // Obtain or create and register package
        final ProtocolPackageImpl theProtocolPackage = (ProtocolPackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof ProtocolPackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new ProtocolPackageImpl () );

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
     * 
     * @generated
     */
    @Override
    public EClass getMessage ()
    {
        return this.messageEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getMessage_Code ()
    {
        return (EAttribute)this.messageEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getMessage_Protocol ()
    {
        return (EReference)this.messageEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getMessage_Interfaces ()
    {
        return (EReference)this.messageEClass.getEStructuralFeatures ().get ( 2 );
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
    public EAttribute getAttribute_FieldNumber ()
    {
        return (EAttribute)this.attributeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getAttribute_Equality ()
    {
        return (EAttribute)this.attributeEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getAttribute_Type ()
    {
        return (EAttribute)this.attributeEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getAttribute_Transient ()
    {
        return (EAttribute)this.attributeEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getAttribute_Deleted ()
    {
        return (EAttribute)this.attributeEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getProtocol ()
    {
        return this.protocolEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getProtocol_Messages ()
    {
        return (EReference)this.protocolEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getProtocol_Name ()
    {
        return (EAttribute)this.protocolEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getProtocol_IncludedProtocols ()
    {
        return (EReference)this.protocolEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getProtocol_LicenseHeader ()
    {
        return (EAttribute)this.protocolEClass.getEStructuralFeatures ().get ( 5 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getProtocol_Enums ()
    {
        return (EReference)this.protocolEClass.getEStructuralFeatures ().get ( 6 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getProtocol_Interfaces ()
    {
        return (EReference)this.protocolEClass.getEStructuralFeatures ().get ( 7 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getProtocol_Version ()
    {
        return (EAttribute)this.protocolEClass.getEStructuralFeatures ().get ( 8 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getProtocol_Structures ()
    {
        return (EReference)this.protocolEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getProtocol_PackagePrefix ()
    {
        return (EAttribute)this.protocolEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getStructure ()
    {
        return this.structureEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getStructure_Protocol ()
    {
        return (EReference)this.structureEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getStringAttribute ()
    {
        return this.stringAttributeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getBooleanAttribute ()
    {
        return this.booleanAttributeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getStructureAttribute ()
    {
        return this.structureAttributeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getStructureAttribute_Structure ()
    {
        return (EReference)this.structureAttributeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getVariantAttribute ()
    {
        return this.variantAttributeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getIntegerAttribute ()
    {
        return this.integerAttributeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getLongAttribute ()
    {
        return this.longAttributeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getFloatAttribute ()
    {
        return this.floatAttributeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getVariantMapAttribute ()
    {
        return this.variantMapAttributeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getPropertiesAttribute ()
    {
        return this.propertiesAttributeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getEnum ()
    {
        return this.enumEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getEnum_Name ()
    {
        return (EAttribute)this.enumEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getEnum_Literals ()
    {
        return (EAttribute)this.enumEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getEnum_Protocol ()
    {
        return (EReference)this.enumEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getEnumAttribute ()
    {
        return this.enumAttributeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getEnumAttribute_EnumType ()
    {
        return (EReference)this.enumAttributeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getInterface ()
    {
        return this.interfaceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getInterface_Protocol ()
    {
        return (EReference)this.interfaceEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getAttributeStructure ()
    {
        return this.attributeStructureEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getAttributeStructure_Name ()
    {
        return (EAttribute)this.attributeStructureEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getAttributeStructure_Attributes ()
    {
        return (EReference)this.attributeStructureEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getDocumentedElement ()
    {
        return this.documentedElementEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDocumentedElement_Description ()
    {
        return (EAttribute)this.documentedElementEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getDocumentedElement_ShortDescription ()
    {
        return (EAttribute)this.documentedElementEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EEnum getType ()
    {
        return this.typeEEnum;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
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
        this.messageEClass = createEClass ( MESSAGE );
        createEAttribute ( this.messageEClass, MESSAGE__CODE );
        createEReference ( this.messageEClass, MESSAGE__PROTOCOL );
        createEReference ( this.messageEClass, MESSAGE__INTERFACES );

        this.attributeEClass = createEClass ( ATTRIBUTE );
        createEAttribute ( this.attributeEClass, ATTRIBUTE__NAME );
        createEAttribute ( this.attributeEClass, ATTRIBUTE__FIELD_NUMBER );
        createEAttribute ( this.attributeEClass, ATTRIBUTE__EQUALITY );
        createEAttribute ( this.attributeEClass, ATTRIBUTE__TYPE );
        createEAttribute ( this.attributeEClass, ATTRIBUTE__TRANSIENT );
        createEAttribute ( this.attributeEClass, ATTRIBUTE__DELETED );

        this.protocolEClass = createEClass ( PROTOCOL );
        createEReference ( this.protocolEClass, PROTOCOL__MESSAGES );
        createEAttribute ( this.protocolEClass, PROTOCOL__NAME );
        createEReference ( this.protocolEClass, PROTOCOL__STRUCTURES );
        createEAttribute ( this.protocolEClass, PROTOCOL__PACKAGE_PREFIX );
        createEReference ( this.protocolEClass, PROTOCOL__INCLUDED_PROTOCOLS );
        createEAttribute ( this.protocolEClass, PROTOCOL__LICENSE_HEADER );
        createEReference ( this.protocolEClass, PROTOCOL__ENUMS );
        createEReference ( this.protocolEClass, PROTOCOL__INTERFACES );
        createEAttribute ( this.protocolEClass, PROTOCOL__VERSION );

        this.structureEClass = createEClass ( STRUCTURE );
        createEReference ( this.structureEClass, STRUCTURE__PROTOCOL );

        this.stringAttributeEClass = createEClass ( STRING_ATTRIBUTE );

        this.booleanAttributeEClass = createEClass ( BOOLEAN_ATTRIBUTE );

        this.structureAttributeEClass = createEClass ( STRUCTURE_ATTRIBUTE );
        createEReference ( this.structureAttributeEClass, STRUCTURE_ATTRIBUTE__STRUCTURE );

        this.variantAttributeEClass = createEClass ( VARIANT_ATTRIBUTE );

        this.integerAttributeEClass = createEClass ( INTEGER_ATTRIBUTE );

        this.longAttributeEClass = createEClass ( LONG_ATTRIBUTE );

        this.floatAttributeEClass = createEClass ( FLOAT_ATTRIBUTE );

        this.variantMapAttributeEClass = createEClass ( VARIANT_MAP_ATTRIBUTE );

        this.propertiesAttributeEClass = createEClass ( PROPERTIES_ATTRIBUTE );

        this.enumEClass = createEClass ( ENUM );
        createEAttribute ( this.enumEClass, ENUM__NAME );
        createEAttribute ( this.enumEClass, ENUM__LITERALS );
        createEReference ( this.enumEClass, ENUM__PROTOCOL );

        this.enumAttributeEClass = createEClass ( ENUM_ATTRIBUTE );
        createEReference ( this.enumAttributeEClass, ENUM_ATTRIBUTE__ENUM_TYPE );

        this.interfaceEClass = createEClass ( INTERFACE );
        createEReference ( this.interfaceEClass, INTERFACE__PROTOCOL );

        this.attributeStructureEClass = createEClass ( ATTRIBUTE_STRUCTURE );
        createEAttribute ( this.attributeStructureEClass, ATTRIBUTE_STRUCTURE__NAME );
        createEReference ( this.attributeStructureEClass, ATTRIBUTE_STRUCTURE__ATTRIBUTES );

        this.documentedElementEClass = createEClass ( DOCUMENTED_ELEMENT );
        createEAttribute ( this.documentedElementEClass, DOCUMENTED_ELEMENT__DESCRIPTION );
        createEAttribute ( this.documentedElementEClass, DOCUMENTED_ELEMENT__SHORT_DESCRIPTION );

        // Create enums
        this.typeEEnum = createEEnum ( TYPE );
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
        this.messageEClass.getESuperTypes ().add ( getAttributeStructure () );
        this.attributeEClass.getESuperTypes ().add ( getDocumentedElement () );
        this.protocolEClass.getESuperTypes ().add ( getDocumentedElement () );
        this.structureEClass.getESuperTypes ().add ( getAttributeStructure () );
        this.stringAttributeEClass.getESuperTypes ().add ( getAttribute () );
        this.booleanAttributeEClass.getESuperTypes ().add ( getAttribute () );
        this.structureAttributeEClass.getESuperTypes ().add ( getAttribute () );
        this.variantAttributeEClass.getESuperTypes ().add ( getAttribute () );
        this.integerAttributeEClass.getESuperTypes ().add ( getAttribute () );
        this.longAttributeEClass.getESuperTypes ().add ( getAttribute () );
        this.floatAttributeEClass.getESuperTypes ().add ( getAttribute () );
        this.variantMapAttributeEClass.getESuperTypes ().add ( getAttribute () );
        this.propertiesAttributeEClass.getESuperTypes ().add ( getAttribute () );
        this.enumEClass.getESuperTypes ().add ( getDocumentedElement () );
        this.enumAttributeEClass.getESuperTypes ().add ( getAttribute () );
        this.interfaceEClass.getESuperTypes ().add ( getAttributeStructure () );
        this.attributeStructureEClass.getESuperTypes ().add ( getDocumentedElement () );

        // Initialize classes and features; add operations and parameters
        initEClass ( this.messageEClass, Message.class, "Message", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEAttribute ( getMessage_Code (), this.ecorePackage.getEInt (), "code", null, 1, 1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEReference ( getMessage_Protocol (), getProtocol (), getProtocol_Messages (), "protocol", null, 1, 1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEReference ( getMessage_Interfaces (), getInterface (), null, "interfaces", null, 0, -1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        initEClass ( this.attributeEClass, Attribute.class, "Attribute", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEAttribute ( getAttribute_Name (), this.ecorePackage.getEString (), "name", null, 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getAttribute_FieldNumber (), this.ecorePackage.getEByte (), "fieldNumber", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getAttribute_Equality (), this.ecorePackage.getEBoolean (), "equality", "false", 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getAttribute_Type (), getType (), "type", "SCALAR", 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getAttribute_Transient (), this.ecorePackage.getEBoolean (), "transient", "false", 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getAttribute_Deleted (), this.ecorePackage.getEBoolean (), "deleted", "false", 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        initEClass ( this.protocolEClass, Protocol.class, "Protocol", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEReference ( getProtocol_Messages (), getMessage (), getMessage_Protocol (), "messages", null, 0, -1, Protocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getProtocol_Name (), this.ecorePackage.getEString (), "name", null, 1, 1, Protocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEReference ( getProtocol_Structures (), getStructure (), getStructure_Protocol (), "structures", null, 0, -1, Protocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getProtocol_PackagePrefix (), this.ecorePackage.getEString (), "packagePrefix", null, 1, 1, Protocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEReference ( getProtocol_IncludedProtocols (), getProtocol (), null, "includedProtocols", null, 0, -1, Protocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getProtocol_LicenseHeader (), this.ecorePackage.getEString (), "licenseHeader", null, 0, 1, Protocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEReference ( getProtocol_Enums (), getEnum (), getEnum_Protocol (), "enums", null, 0, -1, Protocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEReference ( getProtocol_Interfaces (), getInterface (), getInterface_Protocol (), "interfaces", null, 0, -1, Protocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getProtocol_Version (), this.ecorePackage.getEShort (), "version", null, 1, 1, Protocol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        initEClass ( this.structureEClass, Structure.class, "Structure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEReference ( getStructure_Protocol (), getProtocol (), getProtocol_Structures (), "protocol", null, 1, 1, Structure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        initEClass ( this.stringAttributeEClass, StringAttribute.class, "StringAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );

        initEClass ( this.booleanAttributeEClass, BooleanAttribute.class, "BooleanAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );

        initEClass ( this.structureAttributeEClass, StructureAttribute.class, "StructureAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEReference ( getStructureAttribute_Structure (), getStructure (), null, "structure", null, 1, 1, StructureAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        initEClass ( this.variantAttributeEClass, VariantAttribute.class, "VariantAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );

        initEClass ( this.integerAttributeEClass, IntegerAttribute.class, "IntegerAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );

        initEClass ( this.longAttributeEClass, LongAttribute.class, "LongAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );

        initEClass ( this.floatAttributeEClass, FloatAttribute.class, "FloatAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );

        initEClass ( this.variantMapAttributeEClass, VariantMapAttribute.class, "VariantMapAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );

        initEClass ( this.propertiesAttributeEClass, PropertiesAttribute.class, "PropertiesAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );

        initEClass ( this.enumEClass, org.eclipse.scada.protocol.ngp.model.Protocol.Enum.class, "Enum", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEAttribute ( getEnum_Name (), this.ecorePackage.getEString (), "name", null, 1, 1, org.eclipse.scada.protocol.ngp.model.Protocol.Enum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getEnum_Literals (), this.ecorePackage.getEString (), "literals", null, 0, -1, org.eclipse.scada.protocol.ngp.model.Protocol.Enum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEReference ( getEnum_Protocol (), getProtocol (), getProtocol_Enums (), "protocol", null, 0, 1, org.eclipse.scada.protocol.ngp.model.Protocol.Enum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        initEClass ( this.enumAttributeEClass, EnumAttribute.class, "EnumAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEReference ( getEnumAttribute_EnumType (), getEnum (), null, "enumType", null, 1, 1, EnumAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        initEClass ( this.interfaceEClass, Interface.class, "Interface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEReference ( getInterface_Protocol (), getProtocol (), getProtocol_Interfaces (), "protocol", null, 1, 1, Interface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        initEClass ( this.attributeStructureEClass, AttributeStructure.class, "AttributeStructure", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEAttribute ( getAttributeStructure_Name (), this.ecorePackage.getEString (), "name", null, 1, 1, AttributeStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEReference ( getAttributeStructure_Attributes (), getAttribute (), null, "attributes", null, 0, -1, AttributeStructure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        initEClass ( this.documentedElementEClass, DocumentedElement.class, "DocumentedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS );
        initEAttribute ( getDocumentedElement_Description (), this.ecorePackage.getEString (), "description", null, 0, 1, DocumentedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );
        initEAttribute ( getDocumentedElement_ShortDescription (), this.ecorePackage.getEString (), "shortDescription", null, 0, 1, DocumentedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED );

        // Initialize enums and add enum literals
        initEEnum ( this.typeEEnum, Type.class, "Type" );
        addEEnumLiteral ( this.typeEEnum, Type.SCALAR );
        addEEnumLiteral ( this.typeEEnum, Type.OPTIONAL );
        addEEnumLiteral ( this.typeEEnum, Type.ORDERED );
        addEEnumLiteral ( this.typeEEnum, Type.UNIQUE );

        // Create resource
        createResource ( eNS_URI );
    }

} //ProtocolPackageImpl
