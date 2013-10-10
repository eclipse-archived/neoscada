/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.common.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.scada.common.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CommonFactoryImpl extends EFactoryImpl implements CommonFactory
{
   

    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static CommonFactory init ()
    {
        try
        {
            CommonFactory theCommonFactory = (CommonFactory)EPackage.Registry.INSTANCE.getEFactory ( CommonPackage.eNS_URI );
            if ( theCommonFactory != null )
            {
                return theCommonFactory;
            }
        }
        catch ( Exception exception )
        {
            EcorePlugin.INSTANCE.log ( exception );
        }
        return new CommonFactoryImpl ();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CommonFactoryImpl ()
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
            case CommonPackage.ATTRIBUTES_TYPE:
                return createAttributesType ();
            case CommonPackage.ATTRIBUTE_TYPE:
                return createAttributeType ();
            case CommonPackage.VARIANT_BOOLEAN_TYPE:
                return createVariantBooleanType ();
            case CommonPackage.VARIANT_DOUBLE_TYPE:
                return createVariantDoubleType ();
            case CommonPackage.VARIANT_INT32_TYPE:
                return createVariantInt32Type ();
            case CommonPackage.VARIANT_INT64_TYPE:
                return createVariantInt64Type ();
            case CommonPackage.VARIANT_NULL_TYPE:
                return createVariantNullType ();
            case CommonPackage.VARIANT_TYPE:
                return createVariantType ();
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
            case CommonPackage.CLASS_TYPE:
                return createClassTypeFromString ( eDataType, initialValue );
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
            case CommonPackage.CLASS_TYPE:
                return convertClassTypeToString ( eDataType, instanceValue );
            default:
                throw new IllegalArgumentException ( "The datatype '" + eDataType.getName () + "' is not a valid classifier" );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AttributesType createAttributesType ()
    {
        AttributesTypeImpl attributesType = new AttributesTypeImpl ();
        return attributesType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AttributeType createAttributeType ()
    {
        AttributeTypeImpl attributeType = new AttributeTypeImpl ();
        return attributeType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public VariantBooleanType createVariantBooleanType ()
    {
        VariantBooleanTypeImpl variantBooleanType = new VariantBooleanTypeImpl ();
        return variantBooleanType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public VariantDoubleType createVariantDoubleType ()
    {
        VariantDoubleTypeImpl variantDoubleType = new VariantDoubleTypeImpl ();
        return variantDoubleType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public VariantInt32Type createVariantInt32Type ()
    {
        VariantInt32TypeImpl variantInt32Type = new VariantInt32TypeImpl ();
        return variantInt32Type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public VariantInt64Type createVariantInt64Type ()
    {
        VariantInt64TypeImpl variantInt64Type = new VariantInt64TypeImpl ();
        return variantInt64Type;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public VariantNullType createVariantNullType ()
    {
        VariantNullTypeImpl variantNullType = new VariantNullTypeImpl ();
        return variantNullType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public VariantType createVariantType ()
    {
        VariantTypeImpl variantType = new VariantTypeImpl ();
        return variantType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String createClassTypeFromString ( EDataType eDataType, String initialValue )
    {
        return (String)XMLTypeFactory.eINSTANCE.createFromString ( XMLTypePackage.Literals.STRING, initialValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertClassTypeToString ( EDataType eDataType, Object instanceValue )
    {
        return XMLTypeFactory.eINSTANCE.convertToString ( XMLTypePackage.Literals.STRING, instanceValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CommonPackage getCommonPackage ()
    {
        return (CommonPackage)getEPackage ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static CommonPackage getPackage ()
    {
        return CommonPackage.eINSTANCE;
    }

} //CommonFactoryImpl
