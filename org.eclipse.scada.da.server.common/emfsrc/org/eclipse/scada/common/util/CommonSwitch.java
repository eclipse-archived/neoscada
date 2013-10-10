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
package org.eclipse.scada.common.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.scada.common.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.common.CommonPackage
 * @generated
 */
public class CommonSwitch<T> extends Switch<T>
{
   

    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static CommonPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CommonSwitch ()
    {
        if ( modelPackage == null )
        {
            modelPackage = CommonPackage.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @parameter ePackage the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor ( EPackage ePackage )
    {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T doSwitch ( int classifierID, EObject theEObject )
    {
        switch ( classifierID )
        {
            case CommonPackage.ATTRIBUTES_TYPE:
            {
                AttributesType attributesType = (AttributesType)theEObject;
                T result = caseAttributesType ( attributesType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case CommonPackage.ATTRIBUTE_TYPE:
            {
                AttributeType attributeType = (AttributeType)theEObject;
                T result = caseAttributeType ( attributeType );
                if ( result == null )
                    result = caseVariantType ( attributeType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case CommonPackage.VARIANT_BOOLEAN_TYPE:
            {
                VariantBooleanType variantBooleanType = (VariantBooleanType)theEObject;
                T result = caseVariantBooleanType ( variantBooleanType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case CommonPackage.VARIANT_DOUBLE_TYPE:
            {
                VariantDoubleType variantDoubleType = (VariantDoubleType)theEObject;
                T result = caseVariantDoubleType ( variantDoubleType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case CommonPackage.VARIANT_INT32_TYPE:
            {
                VariantInt32Type variantInt32Type = (VariantInt32Type)theEObject;
                T result = caseVariantInt32Type ( variantInt32Type );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case CommonPackage.VARIANT_INT64_TYPE:
            {
                VariantInt64Type variantInt64Type = (VariantInt64Type)theEObject;
                T result = caseVariantInt64Type ( variantInt64Type );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case CommonPackage.VARIANT_NULL_TYPE:
            {
                VariantNullType variantNullType = (VariantNullType)theEObject;
                T result = caseVariantNullType ( variantNullType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case CommonPackage.VARIANT_TYPE:
            {
                VariantType variantType = (VariantType)theEObject;
                T result = caseVariantType ( variantType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            default:
                return defaultCase ( theEObject );
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Attributes Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Attributes Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAttributesType ( AttributesType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Attribute Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Attribute Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAttributeType ( AttributeType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Variant Boolean Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Variant Boolean Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseVariantBooleanType ( VariantBooleanType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Variant Double Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Variant Double Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseVariantDoubleType ( VariantDoubleType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Variant Int32 Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Variant Int32 Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseVariantInt32Type ( VariantInt32Type object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Variant Int64 Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Variant Int64 Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseVariantInt64Type ( VariantInt64Type object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Variant Null Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Variant Null Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseVariantNullType ( VariantNullType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Variant Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Variant Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseVariantType ( VariantType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the last case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase ( EObject object )
    {
        return null;
    }

} //CommonSwitch
