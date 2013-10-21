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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.scada.protocol.ngp.model.Protocol.BooleanAttribute;
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
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ProtocolFactoryImpl extends EFactoryImpl implements ProtocolFactory
{
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static ProtocolFactory init ()
    {
        try
        {
            ProtocolFactory theProtocolFactory = (ProtocolFactory)EPackage.Registry.INSTANCE.getEFactory ( ProtocolPackage.eNS_URI );
            if ( theProtocolFactory != null )
            {
                return theProtocolFactory;
            }
        }
        catch ( Exception exception )
        {
            EcorePlugin.INSTANCE.log ( exception );
        }
        return new ProtocolFactoryImpl ();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ProtocolFactoryImpl ()
    {
        super ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create ( EClass eClass )
    {
        switch ( eClass.getClassifierID () )
        {
            case ProtocolPackage.MESSAGE:
                return createMessage ();
            case ProtocolPackage.PROTOCOL:
                return createProtocol ();
            case ProtocolPackage.STRUCTURE:
                return createStructure ();
            case ProtocolPackage.STRING_ATTRIBUTE:
                return createStringAttribute ();
            case ProtocolPackage.BOOLEAN_ATTRIBUTE:
                return createBooleanAttribute ();
            case ProtocolPackage.STRUCTURE_ATTRIBUTE:
                return createStructureAttribute ();
            case ProtocolPackage.VARIANT_ATTRIBUTE:
                return createVariantAttribute ();
            case ProtocolPackage.INTEGER_ATTRIBUTE:
                return createIntegerAttribute ();
            case ProtocolPackage.LONG_ATTRIBUTE:
                return createLongAttribute ();
            case ProtocolPackage.FLOAT_ATTRIBUTE:
                return createFloatAttribute ();
            case ProtocolPackage.VARIANT_MAP_ATTRIBUTE:
                return createVariantMapAttribute ();
            case ProtocolPackage.PROPERTIES_ATTRIBUTE:
                return createPropertiesAttribute ();
            case ProtocolPackage.ENUM:
                return createEnum ();
            case ProtocolPackage.ENUM_ATTRIBUTE:
                return createEnumAttribute ();
            case ProtocolPackage.INTERFACE:
                return createInterface ();
            default:
                throw new IllegalArgumentException ( "The class '" + eClass.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object createFromString ( EDataType eDataType, String initialValue )
    {
        switch ( eDataType.getClassifierID () )
        {
            case ProtocolPackage.TYPE:
                return createTypeFromString ( eDataType, initialValue );
            default:
                throw new IllegalArgumentException ( "The datatype '" + eDataType.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String convertToString ( EDataType eDataType, Object instanceValue )
    {
        switch ( eDataType.getClassifierID () )
        {
            case ProtocolPackage.TYPE:
                return convertTypeToString ( eDataType, instanceValue );
            default:
                throw new IllegalArgumentException ( "The datatype '" + eDataType.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Message createMessage ()
    {
        MessageImpl message = new MessageImpl ();
        return message;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Protocol createProtocol ()
    {
        ProtocolImpl protocol = new ProtocolImpl ();
        return protocol;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Structure createStructure ()
    {
        StructureImpl structure = new StructureImpl ();
        return structure;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public StringAttribute createStringAttribute ()
    {
        StringAttributeImpl stringAttribute = new StringAttributeImpl ();
        return stringAttribute;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public BooleanAttribute createBooleanAttribute ()
    {
        BooleanAttributeImpl booleanAttribute = new BooleanAttributeImpl ();
        return booleanAttribute;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public StructureAttribute createStructureAttribute ()
    {
        StructureAttributeImpl structureAttribute = new StructureAttributeImpl ();
        return structureAttribute;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public VariantAttribute createVariantAttribute ()
    {
        VariantAttributeImpl variantAttribute = new VariantAttributeImpl ();
        return variantAttribute;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public IntegerAttribute createIntegerAttribute ()
    {
        IntegerAttributeImpl integerAttribute = new IntegerAttributeImpl ();
        return integerAttribute;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public LongAttribute createLongAttribute ()
    {
        LongAttributeImpl longAttribute = new LongAttributeImpl ();
        return longAttribute;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public FloatAttribute createFloatAttribute ()
    {
        FloatAttributeImpl floatAttribute = new FloatAttributeImpl ();
        return floatAttribute;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public VariantMapAttribute createVariantMapAttribute ()
    {
        VariantMapAttributeImpl variantMapAttribute = new VariantMapAttributeImpl ();
        return variantMapAttribute;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public PropertiesAttribute createPropertiesAttribute ()
    {
        PropertiesAttributeImpl propertiesAttribute = new PropertiesAttributeImpl ();
        return propertiesAttribute;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public org.eclipse.scada.protocol.ngp.model.Protocol.Enum createEnum ()
    {
        EnumImpl enum_ = new EnumImpl ();
        return enum_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EnumAttribute createEnumAttribute ()
    {
        EnumAttributeImpl enumAttribute = new EnumAttributeImpl ();
        return enumAttribute;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Interface createInterface ()
    {
        InterfaceImpl interface_ = new InterfaceImpl ();
        return interface_;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Type createTypeFromString ( EDataType eDataType, String initialValue )
    {
        Type result = Type.get ( initialValue );
        if ( result == null )
            throw new IllegalArgumentException ( "The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName () + "'" ); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertTypeToString ( EDataType eDataType, Object instanceValue )
    {
        return instanceValue == null ? null : instanceValue.toString ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ProtocolPackage getProtocolPackage ()
    {
        return (ProtocolPackage)getEPackage ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static ProtocolPackage getPackage ()
    {
        return ProtocolPackage.eINSTANCE;
    }

} //ProtocolFactoryImpl
