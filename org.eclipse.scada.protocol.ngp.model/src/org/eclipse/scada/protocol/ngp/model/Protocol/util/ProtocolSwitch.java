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
package org.eclipse.scada.protocol.ngp.model.Protocol.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
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
import org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage;
import org.eclipse.scada.protocol.ngp.model.Protocol.StringAttribute;
import org.eclipse.scada.protocol.ngp.model.Protocol.Structure;
import org.eclipse.scada.protocol.ngp.model.Protocol.StructureAttribute;
import org.eclipse.scada.protocol.ngp.model.Protocol.VariantAttribute;
import org.eclipse.scada.protocol.ngp.model.Protocol.VariantMapAttribute;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)} to invoke
 * the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.scada.protocol.ngp.model.Protocol.ProtocolPackage
 * @generated
 */
public class ProtocolSwitch<T> extends Switch<T>
{
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static ProtocolPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public ProtocolSwitch ()
    {
        if ( modelPackage == null )
        {
            modelPackage = ProtocolPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @parameter ePackage the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor ( final EPackage ePackage )
    {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns
     * a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the first non-null result returned by a <code>caseXXX</code>
     *         call.
     * @generated
     */
    @Override
    protected T doSwitch ( final int classifierID, final EObject theEObject )
    {
        switch ( classifierID )
        {
            case ProtocolPackage.MESSAGE:
            {
                final Message message = (Message)theEObject;
                T result = caseMessage ( message );
                if ( result == null )
                {
                    result = caseAttributeStructure ( message );
                }
                if ( result == null )
                {
                    result = caseDocumentedElement ( message );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ProtocolPackage.ATTRIBUTE:
            {
                final Attribute attribute = (Attribute)theEObject;
                T result = caseAttribute ( attribute );
                if ( result == null )
                {
                    result = caseDocumentedElement ( attribute );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ProtocolPackage.PROTOCOL:
            {
                final Protocol protocol = (Protocol)theEObject;
                T result = caseProtocol ( protocol );
                if ( result == null )
                {
                    result = caseDocumentedElement ( protocol );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ProtocolPackage.STRUCTURE:
            {
                final Structure structure = (Structure)theEObject;
                T result = caseStructure ( structure );
                if ( result == null )
                {
                    result = caseAttributeStructure ( structure );
                }
                if ( result == null )
                {
                    result = caseDocumentedElement ( structure );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ProtocolPackage.STRING_ATTRIBUTE:
            {
                final StringAttribute stringAttribute = (StringAttribute)theEObject;
                T result = caseStringAttribute ( stringAttribute );
                if ( result == null )
                {
                    result = caseAttribute ( stringAttribute );
                }
                if ( result == null )
                {
                    result = caseDocumentedElement ( stringAttribute );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ProtocolPackage.BOOLEAN_ATTRIBUTE:
            {
                final BooleanAttribute booleanAttribute = (BooleanAttribute)theEObject;
                T result = caseBooleanAttribute ( booleanAttribute );
                if ( result == null )
                {
                    result = caseAttribute ( booleanAttribute );
                }
                if ( result == null )
                {
                    result = caseDocumentedElement ( booleanAttribute );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ProtocolPackage.STRUCTURE_ATTRIBUTE:
            {
                final StructureAttribute structureAttribute = (StructureAttribute)theEObject;
                T result = caseStructureAttribute ( structureAttribute );
                if ( result == null )
                {
                    result = caseAttribute ( structureAttribute );
                }
                if ( result == null )
                {
                    result = caseDocumentedElement ( structureAttribute );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ProtocolPackage.VARIANT_ATTRIBUTE:
            {
                final VariantAttribute variantAttribute = (VariantAttribute)theEObject;
                T result = caseVariantAttribute ( variantAttribute );
                if ( result == null )
                {
                    result = caseAttribute ( variantAttribute );
                }
                if ( result == null )
                {
                    result = caseDocumentedElement ( variantAttribute );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ProtocolPackage.INTEGER_ATTRIBUTE:
            {
                final IntegerAttribute integerAttribute = (IntegerAttribute)theEObject;
                T result = caseIntegerAttribute ( integerAttribute );
                if ( result == null )
                {
                    result = caseAttribute ( integerAttribute );
                }
                if ( result == null )
                {
                    result = caseDocumentedElement ( integerAttribute );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ProtocolPackage.LONG_ATTRIBUTE:
            {
                final LongAttribute longAttribute = (LongAttribute)theEObject;
                T result = caseLongAttribute ( longAttribute );
                if ( result == null )
                {
                    result = caseAttribute ( longAttribute );
                }
                if ( result == null )
                {
                    result = caseDocumentedElement ( longAttribute );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ProtocolPackage.FLOAT_ATTRIBUTE:
            {
                final FloatAttribute floatAttribute = (FloatAttribute)theEObject;
                T result = caseFloatAttribute ( floatAttribute );
                if ( result == null )
                {
                    result = caseAttribute ( floatAttribute );
                }
                if ( result == null )
                {
                    result = caseDocumentedElement ( floatAttribute );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ProtocolPackage.VARIANT_MAP_ATTRIBUTE:
            {
                final VariantMapAttribute variantMapAttribute = (VariantMapAttribute)theEObject;
                T result = caseVariantMapAttribute ( variantMapAttribute );
                if ( result == null )
                {
                    result = caseAttribute ( variantMapAttribute );
                }
                if ( result == null )
                {
                    result = caseDocumentedElement ( variantMapAttribute );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ProtocolPackage.PROPERTIES_ATTRIBUTE:
            {
                final PropertiesAttribute propertiesAttribute = (PropertiesAttribute)theEObject;
                T result = casePropertiesAttribute ( propertiesAttribute );
                if ( result == null )
                {
                    result = caseAttribute ( propertiesAttribute );
                }
                if ( result == null )
                {
                    result = caseDocumentedElement ( propertiesAttribute );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ProtocolPackage.ENUM:
            {
                final org.eclipse.scada.protocol.ngp.model.Protocol.Enum enum_ = (org.eclipse.scada.protocol.ngp.model.Protocol.Enum)theEObject;
                T result = caseEnum ( enum_ );
                if ( result == null )
                {
                    result = caseDocumentedElement ( enum_ );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ProtocolPackage.ENUM_ATTRIBUTE:
            {
                final EnumAttribute enumAttribute = (EnumAttribute)theEObject;
                T result = caseEnumAttribute ( enumAttribute );
                if ( result == null )
                {
                    result = caseAttribute ( enumAttribute );
                }
                if ( result == null )
                {
                    result = caseDocumentedElement ( enumAttribute );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ProtocolPackage.INTERFACE:
            {
                final Interface interface_ = (Interface)theEObject;
                T result = caseInterface ( interface_ );
                if ( result == null )
                {
                    result = caseAttributeStructure ( interface_ );
                }
                if ( result == null )
                {
                    result = caseDocumentedElement ( interface_ );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ProtocolPackage.ATTRIBUTE_STRUCTURE:
            {
                final AttributeStructure attributeStructure = (AttributeStructure)theEObject;
                T result = caseAttributeStructure ( attributeStructure );
                if ( result == null )
                {
                    result = caseDocumentedElement ( attributeStructure );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case ProtocolPackage.DOCUMENTED_ELEMENT:
            {
                final DocumentedElement documentedElement = (DocumentedElement)theEObject;
                T result = caseDocumentedElement ( documentedElement );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            default:
                return defaultCase ( theEObject );
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Message</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Message</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMessage ( final Message object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Attribute</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAttribute ( final Attribute object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Protocol</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Protocol</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseProtocol ( final Protocol object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Structure</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Structure</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseStructure ( final Structure object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>String Attribute</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>String Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseStringAttribute ( final StringAttribute object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Boolean Attribute</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Boolean Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBooleanAttribute ( final BooleanAttribute object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Structure Attribute</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Structure Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseStructureAttribute ( final StructureAttribute object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Variant Attribute</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Variant Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseVariantAttribute ( final VariantAttribute object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Integer Attribute</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Integer Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIntegerAttribute ( final IntegerAttribute object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Long Attribute</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Long Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLongAttribute ( final LongAttribute object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Float Attribute</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Float Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFloatAttribute ( final FloatAttribute object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Variant Map Attribute</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Variant Map Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseVariantMapAttribute ( final VariantMapAttribute object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Properties Attribute</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Properties Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePropertiesAttribute ( final PropertiesAttribute object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Enum</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Enum</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEnum ( final org.eclipse.scada.protocol.ngp.model.Protocol.Enum object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Enum Attribute</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Enum Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEnumAttribute ( final EnumAttribute object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Interface</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Interface</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseInterface ( final Interface object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Attribute Structure</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Attribute Structure</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAttributeStructure ( final AttributeStructure object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Documented Element</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Documented Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDocumentedElement ( final DocumentedElement object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the
     * last case anyway.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase ( final EObject object )
    {
        return null;
    }

} //ProtocolSwitch
