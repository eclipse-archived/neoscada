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
package org.eclipse.scada.protocol.ngp.model.Protocol;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolFactory
 * @model kind="package"
 * @generated
 */
public interface ProtocolPackage extends EPackage
{
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNAME = "Protocol";

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_URI = "urn:eclipse:scada:protocol:ngp";

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_PREFIX = "protocol";

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    ProtocolPackage eINSTANCE = org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl.init ();

    /**
     * The meta object id for the '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.DocumentedElementImpl
     * <em>Documented Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.DocumentedElementImpl
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getDocumentedElement()
     * @generated
     */
    int DOCUMENTED_ELEMENT = 17;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENTED_ELEMENT__DESCRIPTION = 0;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENTED_ELEMENT__SHORT_DESCRIPTION = 1;

    /**
     * The number of structural features of the '<em>Documented Element</em>'
     * class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int DOCUMENTED_ELEMENT_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.AttributeStructureImpl
     * <em>Attribute Structure</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.AttributeStructureImpl
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getAttributeStructure()
     * @generated
     */
    int ATTRIBUTE_STRUCTURE = 16;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ATTRIBUTE_STRUCTURE__DESCRIPTION = DOCUMENTED_ELEMENT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ATTRIBUTE_STRUCTURE__SHORT_DESCRIPTION = DOCUMENTED_ELEMENT__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ATTRIBUTE_STRUCTURE__NAME = DOCUMENTED_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Attributes</b></em>' containment reference
     * list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ATTRIBUTE_STRUCTURE__ATTRIBUTES = DOCUMENTED_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Attribute Structure</em>'
     * class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ATTRIBUTE_STRUCTURE_FEATURE_COUNT = DOCUMENTED_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The meta object id for the '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.StructureImpl
     * <em>Structure</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.StructureImpl
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getStructure()
     * @generated
     */
    int STRUCTURE = 3;

    /**
     * The meta object id for the '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.MessageImpl
     * <em>Message</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.MessageImpl
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getMessage()
     * @generated
     */
    int MESSAGE = 0;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE__DESCRIPTION = ATTRIBUTE_STRUCTURE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE__SHORT_DESCRIPTION = ATTRIBUTE_STRUCTURE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE__NAME = ATTRIBUTE_STRUCTURE__NAME;

    /**
     * The feature id for the '<em><b>Attributes</b></em>' containment reference
     * list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE__ATTRIBUTES = ATTRIBUTE_STRUCTURE__ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Code</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE__CODE = ATTRIBUTE_STRUCTURE_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Protocol</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE__PROTOCOL = ATTRIBUTE_STRUCTURE_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Interfaces</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE__INTERFACES = ATTRIBUTE_STRUCTURE_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Message</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int MESSAGE_FEATURE_COUNT = ATTRIBUTE_STRUCTURE_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.AttributeImpl
     * <em>Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.AttributeImpl
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getAttribute()
     * @generated
     */
    int ATTRIBUTE = 1;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ATTRIBUTE__DESCRIPTION = DOCUMENTED_ELEMENT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ATTRIBUTE__SHORT_DESCRIPTION = DOCUMENTED_ELEMENT__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ATTRIBUTE__NAME = DOCUMENTED_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Field Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ATTRIBUTE__FIELD_NUMBER = DOCUMENTED_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Equality</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ATTRIBUTE__EQUALITY = DOCUMENTED_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ATTRIBUTE__TYPE = DOCUMENTED_ELEMENT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Transient</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ATTRIBUTE__TRANSIENT = DOCUMENTED_ELEMENT_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>Deleted</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ATTRIBUTE__DELETED = DOCUMENTED_ELEMENT_FEATURE_COUNT + 5;

    /**
     * The number of structural features of the '<em>Attribute</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ATTRIBUTE_FEATURE_COUNT = DOCUMENTED_ELEMENT_FEATURE_COUNT + 6;

    /**
     * The meta object id for the '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolImpl
     * <em>Protocol</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolImpl
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getProtocol()
     * @generated
     */
    int PROTOCOL = 2;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PROTOCOL__DESCRIPTION = DOCUMENTED_ELEMENT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PROTOCOL__SHORT_DESCRIPTION = DOCUMENTED_ELEMENT__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Messages</b></em>' containment reference
     * list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PROTOCOL__MESSAGES = DOCUMENTED_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PROTOCOL__NAME = DOCUMENTED_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Structures</b></em>' containment reference
     * list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PROTOCOL__STRUCTURES = DOCUMENTED_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The feature id for the '<em><b>Package Prefix</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PROTOCOL__PACKAGE_PREFIX = DOCUMENTED_ELEMENT_FEATURE_COUNT + 3;

    /**
     * The feature id for the '<em><b>Included Protocols</b></em>' reference
     * list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PROTOCOL__INCLUDED_PROTOCOLS = DOCUMENTED_ELEMENT_FEATURE_COUNT + 4;

    /**
     * The feature id for the '<em><b>License Header</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PROTOCOL__LICENSE_HEADER = DOCUMENTED_ELEMENT_FEATURE_COUNT + 5;

    /**
     * The feature id for the '<em><b>Enums</b></em>' containment reference
     * list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PROTOCOL__ENUMS = DOCUMENTED_ELEMENT_FEATURE_COUNT + 6;

    /**
     * The feature id for the '<em><b>Interfaces</b></em>' containment reference
     * list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PROTOCOL__INTERFACES = DOCUMENTED_ELEMENT_FEATURE_COUNT + 7;

    /**
     * The feature id for the '<em><b>Version</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PROTOCOL__VERSION = DOCUMENTED_ELEMENT_FEATURE_COUNT + 8;

    /**
     * The number of structural features of the '<em>Protocol</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PROTOCOL_FEATURE_COUNT = DOCUMENTED_ELEMENT_FEATURE_COUNT + 9;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STRUCTURE__DESCRIPTION = ATTRIBUTE_STRUCTURE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STRUCTURE__SHORT_DESCRIPTION = ATTRIBUTE_STRUCTURE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STRUCTURE__NAME = ATTRIBUTE_STRUCTURE__NAME;

    /**
     * The feature id for the '<em><b>Attributes</b></em>' containment reference
     * list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STRUCTURE__ATTRIBUTES = ATTRIBUTE_STRUCTURE__ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Protocol</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STRUCTURE__PROTOCOL = ATTRIBUTE_STRUCTURE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Structure</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STRUCTURE_FEATURE_COUNT = ATTRIBUTE_STRUCTURE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.StringAttributeImpl
     * <em>String Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.StringAttributeImpl
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getStringAttribute()
     * @generated
     */
    int STRING_ATTRIBUTE = 4;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STRING_ATTRIBUTE__DESCRIPTION = ATTRIBUTE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STRING_ATTRIBUTE__SHORT_DESCRIPTION = ATTRIBUTE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STRING_ATTRIBUTE__NAME = ATTRIBUTE__NAME;

    /**
     * The feature id for the '<em><b>Field Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STRING_ATTRIBUTE__FIELD_NUMBER = ATTRIBUTE__FIELD_NUMBER;

    /**
     * The feature id for the '<em><b>Equality</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STRING_ATTRIBUTE__EQUALITY = ATTRIBUTE__EQUALITY;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STRING_ATTRIBUTE__TYPE = ATTRIBUTE__TYPE;

    /**
     * The feature id for the '<em><b>Transient</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STRING_ATTRIBUTE__TRANSIENT = ATTRIBUTE__TRANSIENT;

    /**
     * The feature id for the '<em><b>Deleted</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STRING_ATTRIBUTE__DELETED = ATTRIBUTE__DELETED;

    /**
     * The number of structural features of the '<em>String Attribute</em>'
     * class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STRING_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.BooleanAttributeImpl
     * <em>Boolean Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.BooleanAttributeImpl
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getBooleanAttribute()
     * @generated
     */
    int BOOLEAN_ATTRIBUTE = 5;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int BOOLEAN_ATTRIBUTE__DESCRIPTION = ATTRIBUTE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int BOOLEAN_ATTRIBUTE__SHORT_DESCRIPTION = ATTRIBUTE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int BOOLEAN_ATTRIBUTE__NAME = ATTRIBUTE__NAME;

    /**
     * The feature id for the '<em><b>Field Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int BOOLEAN_ATTRIBUTE__FIELD_NUMBER = ATTRIBUTE__FIELD_NUMBER;

    /**
     * The feature id for the '<em><b>Equality</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int BOOLEAN_ATTRIBUTE__EQUALITY = ATTRIBUTE__EQUALITY;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int BOOLEAN_ATTRIBUTE__TYPE = ATTRIBUTE__TYPE;

    /**
     * The feature id for the '<em><b>Transient</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int BOOLEAN_ATTRIBUTE__TRANSIENT = ATTRIBUTE__TRANSIENT;

    /**
     * The feature id for the '<em><b>Deleted</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int BOOLEAN_ATTRIBUTE__DELETED = ATTRIBUTE__DELETED;

    /**
     * The number of structural features of the '<em>Boolean Attribute</em>'
     * class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int BOOLEAN_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.StructureAttributeImpl
     * <em>Structure Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.StructureAttributeImpl
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getStructureAttribute()
     * @generated
     */
    int STRUCTURE_ATTRIBUTE = 6;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STRUCTURE_ATTRIBUTE__DESCRIPTION = ATTRIBUTE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STRUCTURE_ATTRIBUTE__SHORT_DESCRIPTION = ATTRIBUTE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STRUCTURE_ATTRIBUTE__NAME = ATTRIBUTE__NAME;

    /**
     * The feature id for the '<em><b>Field Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STRUCTURE_ATTRIBUTE__FIELD_NUMBER = ATTRIBUTE__FIELD_NUMBER;

    /**
     * The feature id for the '<em><b>Equality</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STRUCTURE_ATTRIBUTE__EQUALITY = ATTRIBUTE__EQUALITY;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STRUCTURE_ATTRIBUTE__TYPE = ATTRIBUTE__TYPE;

    /**
     * The feature id for the '<em><b>Transient</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STRUCTURE_ATTRIBUTE__TRANSIENT = ATTRIBUTE__TRANSIENT;

    /**
     * The feature id for the '<em><b>Deleted</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STRUCTURE_ATTRIBUTE__DELETED = ATTRIBUTE__DELETED;

    /**
     * The feature id for the '<em><b>Structure</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STRUCTURE_ATTRIBUTE__STRUCTURE = ATTRIBUTE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Structure Attribute</em>'
     * class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int STRUCTURE_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.VariantAttributeImpl
     * <em>Variant Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.VariantAttributeImpl
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getVariantAttribute()
     * @generated
     */
    int VARIANT_ATTRIBUTE = 7;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VARIANT_ATTRIBUTE__DESCRIPTION = ATTRIBUTE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VARIANT_ATTRIBUTE__SHORT_DESCRIPTION = ATTRIBUTE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VARIANT_ATTRIBUTE__NAME = ATTRIBUTE__NAME;

    /**
     * The feature id for the '<em><b>Field Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VARIANT_ATTRIBUTE__FIELD_NUMBER = ATTRIBUTE__FIELD_NUMBER;

    /**
     * The feature id for the '<em><b>Equality</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VARIANT_ATTRIBUTE__EQUALITY = ATTRIBUTE__EQUALITY;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VARIANT_ATTRIBUTE__TYPE = ATTRIBUTE__TYPE;

    /**
     * The feature id for the '<em><b>Transient</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VARIANT_ATTRIBUTE__TRANSIENT = ATTRIBUTE__TRANSIENT;

    /**
     * The feature id for the '<em><b>Deleted</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VARIANT_ATTRIBUTE__DELETED = ATTRIBUTE__DELETED;

    /**
     * The number of structural features of the '<em>Variant Attribute</em>'
     * class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VARIANT_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.IntegerAttributeImpl
     * <em>Integer Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.IntegerAttributeImpl
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getIntegerAttribute()
     * @generated
     */
    int INTEGER_ATTRIBUTE = 8;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INTEGER_ATTRIBUTE__DESCRIPTION = ATTRIBUTE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INTEGER_ATTRIBUTE__SHORT_DESCRIPTION = ATTRIBUTE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INTEGER_ATTRIBUTE__NAME = ATTRIBUTE__NAME;

    /**
     * The feature id for the '<em><b>Field Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INTEGER_ATTRIBUTE__FIELD_NUMBER = ATTRIBUTE__FIELD_NUMBER;

    /**
     * The feature id for the '<em><b>Equality</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INTEGER_ATTRIBUTE__EQUALITY = ATTRIBUTE__EQUALITY;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INTEGER_ATTRIBUTE__TYPE = ATTRIBUTE__TYPE;

    /**
     * The feature id for the '<em><b>Transient</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INTEGER_ATTRIBUTE__TRANSIENT = ATTRIBUTE__TRANSIENT;

    /**
     * The feature id for the '<em><b>Deleted</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INTEGER_ATTRIBUTE__DELETED = ATTRIBUTE__DELETED;

    /**
     * The number of structural features of the '<em>Integer Attribute</em>'
     * class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INTEGER_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.LongAttributeImpl
     * <em>Long Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.LongAttributeImpl
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getLongAttribute()
     * @generated
     */
    int LONG_ATTRIBUTE = 9;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LONG_ATTRIBUTE__DESCRIPTION = ATTRIBUTE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LONG_ATTRIBUTE__SHORT_DESCRIPTION = ATTRIBUTE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LONG_ATTRIBUTE__NAME = ATTRIBUTE__NAME;

    /**
     * The feature id for the '<em><b>Field Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LONG_ATTRIBUTE__FIELD_NUMBER = ATTRIBUTE__FIELD_NUMBER;

    /**
     * The feature id for the '<em><b>Equality</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LONG_ATTRIBUTE__EQUALITY = ATTRIBUTE__EQUALITY;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LONG_ATTRIBUTE__TYPE = ATTRIBUTE__TYPE;

    /**
     * The feature id for the '<em><b>Transient</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LONG_ATTRIBUTE__TRANSIENT = ATTRIBUTE__TRANSIENT;

    /**
     * The feature id for the '<em><b>Deleted</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LONG_ATTRIBUTE__DELETED = ATTRIBUTE__DELETED;

    /**
     * The number of structural features of the '<em>Long Attribute</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int LONG_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.FloatAttributeImpl
     * <em>Float Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.FloatAttributeImpl
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getFloatAttribute()
     * @generated
     */
    int FLOAT_ATTRIBUTE = 10;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FLOAT_ATTRIBUTE__DESCRIPTION = ATTRIBUTE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FLOAT_ATTRIBUTE__SHORT_DESCRIPTION = ATTRIBUTE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FLOAT_ATTRIBUTE__NAME = ATTRIBUTE__NAME;

    /**
     * The feature id for the '<em><b>Field Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FLOAT_ATTRIBUTE__FIELD_NUMBER = ATTRIBUTE__FIELD_NUMBER;

    /**
     * The feature id for the '<em><b>Equality</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FLOAT_ATTRIBUTE__EQUALITY = ATTRIBUTE__EQUALITY;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FLOAT_ATTRIBUTE__TYPE = ATTRIBUTE__TYPE;

    /**
     * The feature id for the '<em><b>Transient</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FLOAT_ATTRIBUTE__TRANSIENT = ATTRIBUTE__TRANSIENT;

    /**
     * The feature id for the '<em><b>Deleted</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FLOAT_ATTRIBUTE__DELETED = ATTRIBUTE__DELETED;

    /**
     * The number of structural features of the '<em>Float Attribute</em>'
     * class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int FLOAT_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.VariantMapAttributeImpl
     * <em>Variant Map Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.VariantMapAttributeImpl
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getVariantMapAttribute()
     * @generated
     */
    int VARIANT_MAP_ATTRIBUTE = 11;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VARIANT_MAP_ATTRIBUTE__DESCRIPTION = ATTRIBUTE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VARIANT_MAP_ATTRIBUTE__SHORT_DESCRIPTION = ATTRIBUTE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VARIANT_MAP_ATTRIBUTE__NAME = ATTRIBUTE__NAME;

    /**
     * The feature id for the '<em><b>Field Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VARIANT_MAP_ATTRIBUTE__FIELD_NUMBER = ATTRIBUTE__FIELD_NUMBER;

    /**
     * The feature id for the '<em><b>Equality</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VARIANT_MAP_ATTRIBUTE__EQUALITY = ATTRIBUTE__EQUALITY;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VARIANT_MAP_ATTRIBUTE__TYPE = ATTRIBUTE__TYPE;

    /**
     * The feature id for the '<em><b>Transient</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VARIANT_MAP_ATTRIBUTE__TRANSIENT = ATTRIBUTE__TRANSIENT;

    /**
     * The feature id for the '<em><b>Deleted</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VARIANT_MAP_ATTRIBUTE__DELETED = ATTRIBUTE__DELETED;

    /**
     * The number of structural features of the '<em>Variant Map Attribute</em>'
     * class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int VARIANT_MAP_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.PropertiesAttributeImpl
     * <em>Properties Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.PropertiesAttributeImpl
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getPropertiesAttribute()
     * @generated
     */
    int PROPERTIES_ATTRIBUTE = 12;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PROPERTIES_ATTRIBUTE__DESCRIPTION = ATTRIBUTE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PROPERTIES_ATTRIBUTE__SHORT_DESCRIPTION = ATTRIBUTE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PROPERTIES_ATTRIBUTE__NAME = ATTRIBUTE__NAME;

    /**
     * The feature id for the '<em><b>Field Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PROPERTIES_ATTRIBUTE__FIELD_NUMBER = ATTRIBUTE__FIELD_NUMBER;

    /**
     * The feature id for the '<em><b>Equality</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PROPERTIES_ATTRIBUTE__EQUALITY = ATTRIBUTE__EQUALITY;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PROPERTIES_ATTRIBUTE__TYPE = ATTRIBUTE__TYPE;

    /**
     * The feature id for the '<em><b>Transient</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PROPERTIES_ATTRIBUTE__TRANSIENT = ATTRIBUTE__TRANSIENT;

    /**
     * The feature id for the '<em><b>Deleted</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PROPERTIES_ATTRIBUTE__DELETED = ATTRIBUTE__DELETED;

    /**
     * The number of structural features of the '<em>Properties Attribute</em>'
     * class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int PROPERTIES_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 0;

    /**
     * The meta object id for the '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.EnumImpl
     * <em>Enum</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.EnumImpl
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getEnum()
     * @generated
     */
    int ENUM = 13;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ENUM__DESCRIPTION = DOCUMENTED_ELEMENT__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ENUM__SHORT_DESCRIPTION = DOCUMENTED_ELEMENT__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ENUM__NAME = DOCUMENTED_ELEMENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Literals</b></em>' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ENUM__LITERALS = DOCUMENTED_ELEMENT_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Protocol</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ENUM__PROTOCOL = DOCUMENTED_ELEMENT_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Enum</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ENUM_FEATURE_COUNT = DOCUMENTED_ELEMENT_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.EnumAttributeImpl
     * <em>Enum Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.EnumAttributeImpl
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getEnumAttribute()
     * @generated
     */
    int ENUM_ATTRIBUTE = 14;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ENUM_ATTRIBUTE__DESCRIPTION = ATTRIBUTE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ENUM_ATTRIBUTE__SHORT_DESCRIPTION = ATTRIBUTE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ENUM_ATTRIBUTE__NAME = ATTRIBUTE__NAME;

    /**
     * The feature id for the '<em><b>Field Number</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ENUM_ATTRIBUTE__FIELD_NUMBER = ATTRIBUTE__FIELD_NUMBER;

    /**
     * The feature id for the '<em><b>Equality</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ENUM_ATTRIBUTE__EQUALITY = ATTRIBUTE__EQUALITY;

    /**
     * The feature id for the '<em><b>Type</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ENUM_ATTRIBUTE__TYPE = ATTRIBUTE__TYPE;

    /**
     * The feature id for the '<em><b>Transient</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ENUM_ATTRIBUTE__TRANSIENT = ATTRIBUTE__TRANSIENT;

    /**
     * The feature id for the '<em><b>Deleted</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ENUM_ATTRIBUTE__DELETED = ATTRIBUTE__DELETED;

    /**
     * The feature id for the '<em><b>Enum Type</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ENUM_ATTRIBUTE__ENUM_TYPE = ATTRIBUTE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Enum Attribute</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int ENUM_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.InterfaceImpl
     * <em>Interface</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.InterfaceImpl
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getInterface()
     * @generated
     */
    int INTERFACE = 15;

    /**
     * The feature id for the '<em><b>Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INTERFACE__DESCRIPTION = ATTRIBUTE_STRUCTURE__DESCRIPTION;

    /**
     * The feature id for the '<em><b>Short Description</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INTERFACE__SHORT_DESCRIPTION = ATTRIBUTE_STRUCTURE__SHORT_DESCRIPTION;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INTERFACE__NAME = ATTRIBUTE_STRUCTURE__NAME;

    /**
     * The feature id for the '<em><b>Attributes</b></em>' containment reference
     * list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INTERFACE__ATTRIBUTES = ATTRIBUTE_STRUCTURE__ATTRIBUTES;

    /**
     * The feature id for the '<em><b>Protocol</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INTERFACE__PROTOCOL = ATTRIBUTE_STRUCTURE_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Interface</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int INTERFACE_FEATURE_COUNT = ATTRIBUTE_STRUCTURE_FEATURE_COUNT + 1;

    /**
     * The meta object id for the '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Type <em>Type</em>}'
     * enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Type
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getType()
     * @generated
     */
    int TYPE = 18;

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Message
     * <em>Message</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Message</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Message
     * @generated
     */
    EClass getMessage ();

    /**
     * Returns the meta object for the attribute '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Message#getCode
     * <em>Code</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Code</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Message#getCode()
     * @see #getMessage()
     * @generated
     */
    EAttribute getMessage_Code ();

    /**
     * Returns the meta object for the container reference '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Message#getProtocol
     * <em>Protocol</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the container reference '<em>Protocol</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Message#getProtocol()
     * @see #getMessage()
     * @generated
     */
    EReference getMessage_Protocol ();

    /**
     * Returns the meta object for the reference list '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Message#getInterfaces
     * <em>Interfaces</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the reference list '<em>Interfaces</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Message#getInterfaces()
     * @see #getMessage()
     * @generated
     */
    EReference getMessage_Interfaces ();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Attribute
     * <em>Attribute</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Attribute</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Attribute
     * @generated
     */
    EClass getAttribute ();

    /**
     * Returns the meta object for the attribute '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Attribute#getName
     * <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Attribute#getName()
     * @see #getAttribute()
     * @generated
     */
    EAttribute getAttribute_Name ();

    /**
     * Returns the meta object for the attribute '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Attribute#getFieldNumber
     * <em>Field Number</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Field Number</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Attribute#getFieldNumber()
     * @see #getAttribute()
     * @generated
     */
    EAttribute getAttribute_FieldNumber ();

    /**
     * Returns the meta object for the attribute '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Attribute#isEquality
     * <em>Equality</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Equality</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Attribute#isEquality()
     * @see #getAttribute()
     * @generated
     */
    EAttribute getAttribute_Equality ();

    /**
     * Returns the meta object for the attribute '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Attribute#getType
     * <em>Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Type</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Attribute#getType()
     * @see #getAttribute()
     * @generated
     */
    EAttribute getAttribute_Type ();

    /**
     * Returns the meta object for the attribute '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Attribute#isTransient
     * <em>Transient</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Transient</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Attribute#isTransient()
     * @see #getAttribute()
     * @generated
     */
    EAttribute getAttribute_Transient ();

    /**
     * Returns the meta object for the attribute '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Attribute#isDeleted
     * <em>Deleted</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Deleted</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Attribute#isDeleted()
     * @see #getAttribute()
     * @generated
     */
    EAttribute getAttribute_Deleted ();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Protocol
     * <em>Protocol</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Protocol</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Protocol
     * @generated
     */
    EClass getProtocol ();

    /**
     * Returns the meta object for the containment reference list '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getMessages
     * <em>Messages</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '
     *         <em>Messages</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getMessages()
     * @see #getProtocol()
     * @generated
     */
    EReference getProtocol_Messages ();

    /**
     * Returns the meta object for the attribute '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getName
     * <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getName()
     * @see #getProtocol()
     * @generated
     */
    EAttribute getProtocol_Name ();

    /**
     * Returns the meta object for the reference list '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getIncludedProtocols
     * <em>Included Protocols</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the reference list '
     *         <em>Included Protocols</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getIncludedProtocols()
     * @see #getProtocol()
     * @generated
     */
    EReference getProtocol_IncludedProtocols ();

    /**
     * Returns the meta object for the attribute '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getLicenseHeader
     * <em>License Header</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>License Header</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getLicenseHeader()
     * @see #getProtocol()
     * @generated
     */
    EAttribute getProtocol_LicenseHeader ();

    /**
     * Returns the meta object for the containment reference list '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getEnums
     * <em>Enums</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '
     *         <em>Enums</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getEnums()
     * @see #getProtocol()
     * @generated
     */
    EReference getProtocol_Enums ();

    /**
     * Returns the meta object for the containment reference list '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getInterfaces
     * <em>Interfaces</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '
     *         <em>Interfaces</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getInterfaces()
     * @see #getProtocol()
     * @generated
     */
    EReference getProtocol_Interfaces ();

    /**
     * Returns the meta object for the attribute '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getVersion
     * <em>Version</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Version</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getVersion()
     * @see #getProtocol()
     * @generated
     */
    EAttribute getProtocol_Version ();

    /**
     * Returns the meta object for the containment reference list '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getStructures
     * <em>Structures</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '
     *         <em>Structures</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getStructures()
     * @see #getProtocol()
     * @generated
     */
    EReference getProtocol_Structures ();

    /**
     * Returns the meta object for the attribute '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getPackagePrefix
     * <em>Package Prefix</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Package Prefix</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Protocol#getPackagePrefix()
     * @see #getProtocol()
     * @generated
     */
    EAttribute getProtocol_PackagePrefix ();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Structure
     * <em>Structure</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Structure</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Structure
     * @generated
     */
    EClass getStructure ();

    /**
     * Returns the meta object for the container reference '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Structure#getProtocol
     * <em>Protocol</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the container reference '<em>Protocol</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Structure#getProtocol()
     * @see #getStructure()
     * @generated
     */
    EReference getStructure_Protocol ();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.StringAttribute
     * <em>String Attribute</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>String Attribute</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.StringAttribute
     * @generated
     */
    EClass getStringAttribute ();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.BooleanAttribute
     * <em>Boolean Attribute</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Boolean Attribute</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.BooleanAttribute
     * @generated
     */
    EClass getBooleanAttribute ();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.StructureAttribute
     * <em>Structure Attribute</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Structure Attribute</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.StructureAttribute
     * @generated
     */
    EClass getStructureAttribute ();

    /**
     * Returns the meta object for the reference '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.StructureAttribute#getStructure
     * <em>Structure</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Structure</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.StructureAttribute#getStructure()
     * @see #getStructureAttribute()
     * @generated
     */
    EReference getStructureAttribute_Structure ();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.VariantAttribute
     * <em>Variant Attribute</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Variant Attribute</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.VariantAttribute
     * @generated
     */
    EClass getVariantAttribute ();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.IntegerAttribute
     * <em>Integer Attribute</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Integer Attribute</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.IntegerAttribute
     * @generated
     */
    EClass getIntegerAttribute ();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.LongAttribute
     * <em>Long Attribute</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Long Attribute</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.LongAttribute
     * @generated
     */
    EClass getLongAttribute ();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.FloatAttribute
     * <em>Float Attribute</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Float Attribute</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.FloatAttribute
     * @generated
     */
    EClass getFloatAttribute ();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.VariantMapAttribute
     * <em>Variant Map Attribute</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Variant Map Attribute</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.VariantMapAttribute
     * @generated
     */
    EClass getVariantMapAttribute ();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.PropertiesAttribute
     * <em>Properties Attribute</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Properties Attribute</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.PropertiesAttribute
     * @generated
     */
    EClass getPropertiesAttribute ();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Enum <em>Enum</em>}
     * '.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Enum</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Enum
     * @generated
     */
    EClass getEnum ();

    /**
     * Returns the meta object for the attribute '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Enum#getName
     * <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Enum#getName()
     * @see #getEnum()
     * @generated
     */
    EAttribute getEnum_Name ();

    /**
     * Returns the meta object for the attribute list '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Enum#getLiterals
     * <em>Literals</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute list '<em>Literals</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Enum#getLiterals()
     * @see #getEnum()
     * @generated
     */
    EAttribute getEnum_Literals ();

    /**
     * Returns the meta object for the container reference '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Enum#getProtocol
     * <em>Protocol</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the container reference '<em>Protocol</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Enum#getProtocol()
     * @see #getEnum()
     * @generated
     */
    EReference getEnum_Protocol ();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.EnumAttribute
     * <em>Enum Attribute</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Enum Attribute</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.EnumAttribute
     * @generated
     */
    EClass getEnumAttribute ();

    /**
     * Returns the meta object for the reference '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.EnumAttribute#getEnumType
     * <em>Enum Type</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Enum Type</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.EnumAttribute#getEnumType()
     * @see #getEnumAttribute()
     * @generated
     */
    EReference getEnumAttribute_EnumType ();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Interface
     * <em>Interface</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Interface</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Interface
     * @generated
     */
    EClass getInterface ();

    /**
     * Returns the meta object for the container reference '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Interface#getProtocol
     * <em>Protocol</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the container reference '<em>Protocol</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Interface#getProtocol()
     * @see #getInterface()
     * @generated
     */
    EReference getInterface_Protocol ();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.AttributeStructure
     * <em>Attribute Structure</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Attribute Structure</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.AttributeStructure
     * @generated
     */
    EClass getAttributeStructure ();

    /**
     * Returns the meta object for the attribute '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.AttributeStructure#getName
     * <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.AttributeStructure#getName()
     * @see #getAttributeStructure()
     * @generated
     */
    EAttribute getAttributeStructure_Name ();

    /**
     * Returns the meta object for the containment reference list '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.AttributeStructure#getAttributes
     * <em>Attributes</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference list '
     *         <em>Attributes</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.AttributeStructure#getAttributes()
     * @see #getAttributeStructure()
     * @generated
     */
    EReference getAttributeStructure_Attributes ();

    /**
     * Returns the meta object for class '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.DocumentedElement
     * <em>Documented Element</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Documented Element</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.DocumentedElement
     * @generated
     */
    EClass getDocumentedElement ();

    /**
     * Returns the meta object for the attribute '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.DocumentedElement#getDescription
     * <em>Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Description</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.DocumentedElement#getDescription()
     * @see #getDocumentedElement()
     * @generated
     */
    EAttribute getDocumentedElement_Description ();

    /**
     * Returns the meta object for the attribute '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.DocumentedElement#getShortDescription
     * <em>Short Description</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for the attribute '<em>Short Description</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.DocumentedElement#getShortDescription()
     * @see #getDocumentedElement()
     * @generated
     */
    EAttribute getDocumentedElement_ShortDescription ();

    /**
     * Returns the meta object for enum '
     * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Type <em>Type</em>}
     * '.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the meta object for enum '<em>Type</em>'.
     * @see org.eclipse.scada.protocol.ngp.model.Protocol.Type
     * @generated
     */
    EEnum getType ();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the factory that creates the instances of the model.
     * @generated
     */
    ProtocolFactory getProtocolFactory ();

    /**
     * <!-- begin-user-doc -->
     * Defines literals for the meta objects that represent
     * <ul>
     * <li>each class,</li>
     * <li>each feature of each class,</li>
     * <li>each enum,</li>
     * <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    interface Literals
    {
        /**
         * The meta object literal for the '
         * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.MessageImpl
         * <em>Message</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.MessageImpl
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getMessage()
         * @generated
         */
        EClass MESSAGE = eINSTANCE.getMessage ();

        /**
         * The meta object literal for the '<em><b>Code</b></em>' attribute
         * feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute MESSAGE__CODE = eINSTANCE.getMessage_Code ();

        /**
         * The meta object literal for the '<em><b>Protocol</b></em>' container
         * reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference MESSAGE__PROTOCOL = eINSTANCE.getMessage_Protocol ();

        /**
         * The meta object literal for the '<em><b>Interfaces</b></em>'
         * reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference MESSAGE__INTERFACES = eINSTANCE.getMessage_Interfaces ();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.AttributeImpl
         * <em>Attribute</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.AttributeImpl
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getAttribute()
         * @generated
         */
        EClass ATTRIBUTE = eINSTANCE.getAttribute ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute
         * feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute ATTRIBUTE__NAME = eINSTANCE.getAttribute_Name ();

        /**
         * The meta object literal for the '<em><b>Field Number</b></em>'
         * attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute ATTRIBUTE__FIELD_NUMBER = eINSTANCE.getAttribute_FieldNumber ();

        /**
         * The meta object literal for the '<em><b>Equality</b></em>' attribute
         * feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute ATTRIBUTE__EQUALITY = eINSTANCE.getAttribute_Equality ();

        /**
         * The meta object literal for the '<em><b>Type</b></em>' attribute
         * feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute ATTRIBUTE__TYPE = eINSTANCE.getAttribute_Type ();

        /**
         * The meta object literal for the '<em><b>Transient</b></em>' attribute
         * feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute ATTRIBUTE__TRANSIENT = eINSTANCE.getAttribute_Transient ();

        /**
         * The meta object literal for the '<em><b>Deleted</b></em>' attribute
         * feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute ATTRIBUTE__DELETED = eINSTANCE.getAttribute_Deleted ();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolImpl
         * <em>Protocol</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolImpl
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getProtocol()
         * @generated
         */
        EClass PROTOCOL = eINSTANCE.getProtocol ();

        /**
         * The meta object literal for the '<em><b>Messages</b></em>'
         * containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference PROTOCOL__MESSAGES = eINSTANCE.getProtocol_Messages ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute
         * feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute PROTOCOL__NAME = eINSTANCE.getProtocol_Name ();

        /**
         * The meta object literal for the '<em><b>Included Protocols</b></em>'
         * reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference PROTOCOL__INCLUDED_PROTOCOLS = eINSTANCE.getProtocol_IncludedProtocols ();

        /**
         * The meta object literal for the '<em><b>License Header</b></em>'
         * attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute PROTOCOL__LICENSE_HEADER = eINSTANCE.getProtocol_LicenseHeader ();

        /**
         * The meta object literal for the '<em><b>Enums</b></em>' containment
         * reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference PROTOCOL__ENUMS = eINSTANCE.getProtocol_Enums ();

        /**
         * The meta object literal for the '<em><b>Interfaces</b></em>'
         * containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference PROTOCOL__INTERFACES = eINSTANCE.getProtocol_Interfaces ();

        /**
         * The meta object literal for the '<em><b>Version</b></em>' attribute
         * feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute PROTOCOL__VERSION = eINSTANCE.getProtocol_Version ();

        /**
         * The meta object literal for the '<em><b>Structures</b></em>'
         * containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference PROTOCOL__STRUCTURES = eINSTANCE.getProtocol_Structures ();

        /**
         * The meta object literal for the '<em><b>Package Prefix</b></em>'
         * attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute PROTOCOL__PACKAGE_PREFIX = eINSTANCE.getProtocol_PackagePrefix ();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.StructureImpl
         * <em>Structure</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.StructureImpl
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getStructure()
         * @generated
         */
        EClass STRUCTURE = eINSTANCE.getStructure ();

        /**
         * The meta object literal for the '<em><b>Protocol</b></em>' container
         * reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference STRUCTURE__PROTOCOL = eINSTANCE.getStructure_Protocol ();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.StringAttributeImpl
         * <em>String Attribute</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.StringAttributeImpl
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getStringAttribute()
         * @generated
         */
        EClass STRING_ATTRIBUTE = eINSTANCE.getStringAttribute ();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.BooleanAttributeImpl
         * <em>Boolean Attribute</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.BooleanAttributeImpl
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getBooleanAttribute()
         * @generated
         */
        EClass BOOLEAN_ATTRIBUTE = eINSTANCE.getBooleanAttribute ();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.StructureAttributeImpl
         * <em>Structure Attribute</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.StructureAttributeImpl
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getStructureAttribute()
         * @generated
         */
        EClass STRUCTURE_ATTRIBUTE = eINSTANCE.getStructureAttribute ();

        /**
         * The meta object literal for the '<em><b>Structure</b></em>' reference
         * feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference STRUCTURE_ATTRIBUTE__STRUCTURE = eINSTANCE.getStructureAttribute_Structure ();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.VariantAttributeImpl
         * <em>Variant Attribute</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.VariantAttributeImpl
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getVariantAttribute()
         * @generated
         */
        EClass VARIANT_ATTRIBUTE = eINSTANCE.getVariantAttribute ();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.IntegerAttributeImpl
         * <em>Integer Attribute</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.IntegerAttributeImpl
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getIntegerAttribute()
         * @generated
         */
        EClass INTEGER_ATTRIBUTE = eINSTANCE.getIntegerAttribute ();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.LongAttributeImpl
         * <em>Long Attribute</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.LongAttributeImpl
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getLongAttribute()
         * @generated
         */
        EClass LONG_ATTRIBUTE = eINSTANCE.getLongAttribute ();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.FloatAttributeImpl
         * <em>Float Attribute</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.FloatAttributeImpl
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getFloatAttribute()
         * @generated
         */
        EClass FLOAT_ATTRIBUTE = eINSTANCE.getFloatAttribute ();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.VariantMapAttributeImpl
         * <em>Variant Map Attribute</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.VariantMapAttributeImpl
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getVariantMapAttribute()
         * @generated
         */
        EClass VARIANT_MAP_ATTRIBUTE = eINSTANCE.getVariantMapAttribute ();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.PropertiesAttributeImpl
         * <em>Properties Attribute</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.PropertiesAttributeImpl
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getPropertiesAttribute()
         * @generated
         */
        EClass PROPERTIES_ATTRIBUTE = eINSTANCE.getPropertiesAttribute ();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.EnumImpl
         * <em>Enum</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.EnumImpl
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getEnum()
         * @generated
         */
        EClass ENUM = eINSTANCE.getEnum ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute
         * feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute ENUM__NAME = eINSTANCE.getEnum_Name ();

        /**
         * The meta object literal for the '<em><b>Literals</b></em>' attribute
         * list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute ENUM__LITERALS = eINSTANCE.getEnum_Literals ();

        /**
         * The meta object literal for the '<em><b>Protocol</b></em>' container
         * reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference ENUM__PROTOCOL = eINSTANCE.getEnum_Protocol ();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.EnumAttributeImpl
         * <em>Enum Attribute</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.EnumAttributeImpl
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getEnumAttribute()
         * @generated
         */
        EClass ENUM_ATTRIBUTE = eINSTANCE.getEnumAttribute ();

        /**
         * The meta object literal for the '<em><b>Enum Type</b></em>' reference
         * feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference ENUM_ATTRIBUTE__ENUM_TYPE = eINSTANCE.getEnumAttribute_EnumType ();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.InterfaceImpl
         * <em>Interface</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.InterfaceImpl
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getInterface()
         * @generated
         */
        EClass INTERFACE = eINSTANCE.getInterface ();

        /**
         * The meta object literal for the '<em><b>Protocol</b></em>' container
         * reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference INTERFACE__PROTOCOL = eINSTANCE.getInterface_Protocol ();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.AttributeStructureImpl
         * <em>Attribute Structure</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.AttributeStructureImpl
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getAttributeStructure()
         * @generated
         */
        EClass ATTRIBUTE_STRUCTURE = eINSTANCE.getAttributeStructure ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute
         * feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute ATTRIBUTE_STRUCTURE__NAME = eINSTANCE.getAttributeStructure_Name ();

        /**
         * The meta object literal for the '<em><b>Attributes</b></em>'
         * containment reference list feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference ATTRIBUTE_STRUCTURE__ATTRIBUTES = eINSTANCE.getAttributeStructure_Attributes ();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.scada.protocol.ngp.model.Protocol.impl.DocumentedElementImpl
         * <em>Documented Element</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.DocumentedElementImpl
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getDocumentedElement()
         * @generated
         */
        EClass DOCUMENTED_ELEMENT = eINSTANCE.getDocumentedElement ();

        /**
         * The meta object literal for the '<em><b>Description</b></em>'
         * attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOCUMENTED_ELEMENT__DESCRIPTION = eINSTANCE.getDocumentedElement_Description ();

        /**
         * The meta object literal for the '<em><b>Short Description</b></em>'
         * attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @generated
         */
        EAttribute DOCUMENTED_ELEMENT__SHORT_DESCRIPTION = eINSTANCE.getDocumentedElement_ShortDescription ();

        /**
         * The meta object literal for the '
         * {@link org.eclipse.scada.protocol.ngp.model.Protocol.Type
         * <em>Type</em>}' enum.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * 
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.Type
         * @see org.eclipse.scada.protocol.ngp.model.Protocol.impl.ProtocolPackageImpl#getType()
         * @generated
         */
        EEnum TYPE = eINSTANCE.getType ();

    }

} //ProtocolPackage
