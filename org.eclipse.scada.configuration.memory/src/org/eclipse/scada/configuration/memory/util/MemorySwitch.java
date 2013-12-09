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
package org.eclipse.scada.configuration.memory.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.scada.configuration.memory.*;

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
 * @see org.eclipse.scada.configuration.memory.MemoryPackage
 * @generated
 */
public class MemorySwitch<T> extends Switch<T>
{
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static MemoryPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MemorySwitch ()
    {
        if ( modelPackage == null )
        {
            modelPackage = MemoryPackage.eINSTANCE;
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
            case MemoryPackage.TYPE_DEFINITION:
            {
                TypeDefinition typeDefinition = (TypeDefinition)theEObject;
                T result = caseTypeDefinition ( typeDefinition );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case MemoryPackage.BIT_TYPE:
            {
                BitType bitType = (BitType)theEObject;
                T result = caseBitType ( bitType );
                if ( result == null )
                    result = caseBaseScalarType ( bitType );
                if ( result == null )
                    result = caseScalarType ( bitType );
                if ( result == null )
                    result = caseType ( bitType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case MemoryPackage.TYPE:
            {
                Type type = (Type)theEObject;
                T result = caseType ( type );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case MemoryPackage.VARIABLE:
            {
                Variable variable = (Variable)theEObject;
                T result = caseVariable ( variable );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case MemoryPackage.ATTRIBUTE:
            {
                Attribute attribute = (Attribute)theEObject;
                T result = caseAttribute ( attribute );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case MemoryPackage.FLOAT32_TYPE:
            {
                Float32Type float32Type = (Float32Type)theEObject;
                T result = caseFloat32Type ( float32Type );
                if ( result == null )
                    result = caseBaseScalarType ( float32Type );
                if ( result == null )
                    result = caseScalarType ( float32Type );
                if ( result == null )
                    result = caseType ( float32Type );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case MemoryPackage.BASE_SCALAR_TYPE:
            {
                BaseScalarType baseScalarType = (BaseScalarType)theEObject;
                T result = caseBaseScalarType ( baseScalarType );
                if ( result == null )
                    result = caseScalarType ( baseScalarType );
                if ( result == null )
                    result = caseType ( baseScalarType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case MemoryPackage.USER_DEFINED_TYPE:
            {
                UserDefinedType userDefinedType = (UserDefinedType)theEObject;
                T result = caseUserDefinedType ( userDefinedType );
                if ( result == null )
                    result = caseType ( userDefinedType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case MemoryPackage.UNSIGNED_INTEGER16_TYPE:
            {
                UnsignedInteger16Type unsignedInteger16Type = (UnsignedInteger16Type)theEObject;
                T result = caseUnsignedInteger16Type ( unsignedInteger16Type );
                if ( result == null )
                    result = caseOrderedType ( unsignedInteger16Type );
                if ( result == null )
                    result = caseBaseScalarType ( unsignedInteger16Type );
                if ( result == null )
                    result = caseScalarType ( unsignedInteger16Type );
                if ( result == null )
                    result = caseType ( unsignedInteger16Type );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case MemoryPackage.SCALAR_TYPE:
            {
                ScalarType scalarType = (ScalarType)theEObject;
                T result = caseScalarType ( scalarType );
                if ( result == null )
                    result = caseType ( scalarType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case MemoryPackage.UNSIGNED_INTEGER32_TYPE:
            {
                UnsignedInteger32Type unsignedInteger32Type = (UnsignedInteger32Type)theEObject;
                T result = caseUnsignedInteger32Type ( unsignedInteger32Type );
                if ( result == null )
                    result = caseOrderedType ( unsignedInteger32Type );
                if ( result == null )
                    result = caseBaseScalarType ( unsignedInteger32Type );
                if ( result == null )
                    result = caseScalarType ( unsignedInteger32Type );
                if ( result == null )
                    result = caseType ( unsignedInteger32Type );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case MemoryPackage.UNSIGNED_INTEGER8_TYPE:
            {
                UnsignedInteger8Type unsignedInteger8Type = (UnsignedInteger8Type)theEObject;
                T result = caseUnsignedInteger8Type ( unsignedInteger8Type );
                if ( result == null )
                    result = caseBaseScalarType ( unsignedInteger8Type );
                if ( result == null )
                    result = caseScalarType ( unsignedInteger8Type );
                if ( result == null )
                    result = caseType ( unsignedInteger8Type );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case MemoryPackage.TYPE_SYSTEM:
            {
                TypeSystem typeSystem = (TypeSystem)theEObject;
                T result = caseTypeSystem ( typeSystem );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case MemoryPackage.ORDERED_TYPE:
            {
                OrderedType orderedType = (OrderedType)theEObject;
                T result = caseOrderedType ( orderedType );
                if ( result == null )
                    result = caseBaseScalarType ( orderedType );
                if ( result == null )
                    result = caseScalarType ( orderedType );
                if ( result == null )
                    result = caseType ( orderedType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            default:
                return defaultCase ( theEObject );
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Type Definition</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Type Definition</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTypeDefinition ( TypeDefinition object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>User Defined Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>User Defined Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseUserDefinedType ( UserDefinedType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Unsigned Integer16 Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Unsigned Integer16 Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseUnsignedInteger16Type ( UnsignedInteger16Type object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Scalar Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Scalar Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseScalarType ( ScalarType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Unsigned Integer32 Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Unsigned Integer32 Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseUnsignedInteger32Type ( UnsignedInteger32Type object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Unsigned Integer8 Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Unsigned Integer8 Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseUnsignedInteger8Type ( UnsignedInteger8Type object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Type System</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Type System</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTypeSystem ( TypeSystem object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ordered Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ordered Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOrderedType ( OrderedType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Bit Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Bit Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBitType ( BitType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseType ( Type object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseVariable ( Variable object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Attribute</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Attribute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAttribute ( Attribute object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Float32 Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Float32 Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFloat32Type ( Float32Type object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Base Scalar Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Base Scalar Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseBaseScalarType ( BaseScalarType object )
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

} //MemorySwitch
