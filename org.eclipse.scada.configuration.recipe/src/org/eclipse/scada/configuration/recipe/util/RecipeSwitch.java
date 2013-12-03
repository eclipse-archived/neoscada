/**
 * Copyright (c) 2013 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.recipe.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.scada.configuration.recipe.*;

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
 * @see org.eclipse.scada.configuration.recipe.RecipePackage
 * @generated
 */
public class RecipeSwitch<T> extends Switch<T>
{
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static RecipePackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public RecipeSwitch ()
    {
        if ( modelPackage == null )
        {
            modelPackage = RecipePackage.eINSTANCE;
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
            case RecipePackage.DEFINITION:
            {
                Definition definition = (Definition)theEObject;
                T result = caseDefinition ( definition );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case RecipePackage.TASK:
            {
                Task task = (Task)theEObject;
                T result = caseTask ( task );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case RecipePackage.EXECUTE:
            {
                Execute execute = (Execute)theEObject;
                T result = caseExecute ( execute );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case RecipePackage.MAP_INPUT:
            {
                MapInput mapInput = (MapInput)theEObject;
                T result = caseMapInput ( mapInput );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case RecipePackage.INPUT_VALUE:
            {
                InputValue inputValue = (InputValue)theEObject;
                T result = caseInputValue ( inputValue );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case RecipePackage.STRING_INPUT_VALUE:
            {
                StringInputValue stringInputValue = (StringInputValue)theEObject;
                T result = caseStringInputValue ( stringInputValue );
                if ( result == null )
                    result = caseInputValue ( stringInputValue );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case RecipePackage.CAPTURE_OUTPUT:
            {
                CaptureOutput captureOutput = (CaptureOutput)theEObject;
                T result = caseCaptureOutput ( captureOutput );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case RecipePackage.INPUT_REFERENCE:
            {
                InputReference inputReference = (InputReference)theEObject;
                T result = caseInputReference ( inputReference );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            default:
                return defaultCase ( theEObject );
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Definition</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Definition</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDefinition ( Definition object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Task</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Task</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTask ( Task object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Execute</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Execute</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseExecute ( Execute object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Map Input</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Map Input</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMapInput ( MapInput object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Input Value</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Input Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseInputValue ( InputValue object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>String Input Value</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>String Input Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseStringInputValue ( StringInputValue object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Capture Output</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Capture Output</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCaptureOutput ( CaptureOutput object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Input Reference</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Input Reference</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseInputReference ( InputReference object )
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

} //RecipeSwitch
