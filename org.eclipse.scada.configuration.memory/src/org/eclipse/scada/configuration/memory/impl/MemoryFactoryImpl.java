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
package org.eclipse.scada.configuration.memory.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.scada.configuration.memory.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MemoryFactoryImpl extends EFactoryImpl implements MemoryFactory
{
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static MemoryFactory init ()
    {
        try
        {
            MemoryFactory theMemoryFactory = (MemoryFactory)EPackage.Registry.INSTANCE.getEFactory ( MemoryPackage.eNS_URI );
            if ( theMemoryFactory != null )
            {
                return theMemoryFactory;
            }
        }
        catch ( Exception exception )
        {
            EcorePlugin.INSTANCE.log ( exception );
        }
        return new MemoryFactoryImpl ();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MemoryFactoryImpl ()
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
            case MemoryPackage.TYPE_DEFINITION:
                return createTypeDefinition ();
            case MemoryPackage.BIT_TYPE:
                return createBitType ();
            case MemoryPackage.VARIABLE:
                return createVariable ();
            case MemoryPackage.ATTRIBUTE:
                return createAttribute ();
            case MemoryPackage.FLOAT32_TYPE:
                return createFloat32Type ();
            case MemoryPackage.USER_DEFINED_TYPE:
                return createUserDefinedType ();
            case MemoryPackage.UNSIGNED_INTEGER16_TYPE:
                return createUnsignedInteger16Type ();
            case MemoryPackage.UNSIGNED_INTEGER32_TYPE:
                return createUnsignedInteger32Type ();
            case MemoryPackage.UNSIGNED_INTEGER8_TYPE:
                return createUnsignedInteger8Type ();
            case MemoryPackage.TYPE_SYSTEM:
                return createTypeSystem ();
            case MemoryPackage.FLOAT64_TYPE:
                return createFloat64Type ();
            case MemoryPackage.SIGNED_INTEGER8_TYPE:
                return createSignedInteger8Type ();
            case MemoryPackage.SIGNED_INTEGER16_TYPE:
                return createSignedInteger16Type ();
            case MemoryPackage.SIGNED_INTEGER32_TYPE:
                return createSignedInteger32Type ();
            case MemoryPackage.SIGNED_INTEGER64_TYPE:
                return createSignedInteger64Type ();
            case MemoryPackage.FIXED_LENGTH_STRING_TYPE:
                return createFixedLengthStringType ();
            case MemoryPackage.FIXED_LENGTH_BLOB_TYPE:
                return createFixedLengthBlobType ();
            default:
                throw new IllegalArgumentException ( "The class '" + eClass.getName () + "' is not a valid classifier" );
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
            case MemoryPackage.BYTE_ORDER:
                return createByteOrderFromString ( eDataType, initialValue );
            default:
                throw new IllegalArgumentException ( "The datatype '" + eDataType.getName () + "' is not a valid classifier" );
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
            case MemoryPackage.BYTE_ORDER:
                return convertByteOrderToString ( eDataType, instanceValue );
            default:
                throw new IllegalArgumentException ( "The datatype '" + eDataType.getName () + "' is not a valid classifier" );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TypeDefinition createTypeDefinition ()
    {
        TypeDefinitionImpl typeDefinition = new TypeDefinitionImpl ();
        return typeDefinition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UserDefinedType createUserDefinedType ()
    {
        UserDefinedTypeImpl userDefinedType = new UserDefinedTypeImpl ();
        return userDefinedType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UnsignedInteger16Type createUnsignedInteger16Type ()
    {
        UnsignedInteger16TypeImpl unsignedInteger16Type = new UnsignedInteger16TypeImpl ();
        return unsignedInteger16Type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UnsignedInteger32Type createUnsignedInteger32Type ()
    {
        UnsignedInteger32TypeImpl unsignedInteger32Type = new UnsignedInteger32TypeImpl ();
        return unsignedInteger32Type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UnsignedInteger8Type createUnsignedInteger8Type ()
    {
        UnsignedInteger8TypeImpl unsignedInteger8Type = new UnsignedInteger8TypeImpl ();
        return unsignedInteger8Type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public TypeSystem createTypeSystem ()
    {
        TypeSystemImpl typeSystem = new TypeSystemImpl ();
        return typeSystem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Float64Type createFloat64Type ()
    {
        Float64TypeImpl float64Type = new Float64TypeImpl ();
        return float64Type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SignedInteger8Type createSignedInteger8Type ()
    {
        SignedInteger8TypeImpl signedInteger8Type = new SignedInteger8TypeImpl ();
        return signedInteger8Type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SignedInteger16Type createSignedInteger16Type ()
    {
        SignedInteger16TypeImpl signedInteger16Type = new SignedInteger16TypeImpl ();
        return signedInteger16Type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SignedInteger32Type createSignedInteger32Type ()
    {
        SignedInteger32TypeImpl signedInteger32Type = new SignedInteger32TypeImpl ();
        return signedInteger32Type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SignedInteger64Type createSignedInteger64Type ()
    {
        SignedInteger64TypeImpl signedInteger64Type = new SignedInteger64TypeImpl ();
        return signedInteger64Type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FixedLengthStringType createFixedLengthStringType ()
    {
        FixedLengthStringTypeImpl fixedLengthStringType = new FixedLengthStringTypeImpl ();
        return fixedLengthStringType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FixedLengthBlobType createFixedLengthBlobType ()
    {
        FixedLengthBlobTypeImpl fixedLengthBlobType = new FixedLengthBlobTypeImpl ();
        return fixedLengthBlobType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ByteOrder createByteOrderFromString ( EDataType eDataType, String initialValue )
    {
        ByteOrder result = ByteOrder.get ( initialValue );
        if ( result == null )
            throw new IllegalArgumentException ( "The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName () + "'" );
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertByteOrderToString ( EDataType eDataType, Object instanceValue )
    {
        return instanceValue == null ? null : instanceValue.toString ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public BitType createBitType ()
    {
        BitTypeImpl bitType = new BitTypeImpl ();
        return bitType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Variable createVariable ()
    {
        VariableImpl variable = new VariableImpl ();
        return variable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Attribute createAttribute ()
    {
        AttributeImpl attribute = new AttributeImpl ();
        return attribute;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Float32Type createFloat32Type ()
    {
        Float32TypeImpl float32Type = new Float32TypeImpl ();
        return float32Type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MemoryPackage getMemoryPackage ()
    {
        return (MemoryPackage)getEPackage ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static MemoryPackage getPackage ()
    {
        return MemoryPackage.eINSTANCE;
    }

} //MemoryFactoryImpl
