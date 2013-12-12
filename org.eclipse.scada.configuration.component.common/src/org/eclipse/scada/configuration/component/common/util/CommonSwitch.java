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
package org.eclipse.scada.configuration.component.common.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.scada.configuration.component.Component;
import org.eclipse.scada.configuration.component.DataComponent;

import org.eclipse.scada.configuration.component.common.*;

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
 * @see org.eclipse.scada.configuration.component.common.CommonPackage
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
            case CommonPackage.HEARTBEAT_GENERATOR:
            {
                HeartbeatGenerator heartbeatGenerator = (HeartbeatGenerator)theEObject;
                T result = caseHeartbeatGenerator ( heartbeatGenerator );
                if ( result == null )
                    result = caseDataComponent ( heartbeatGenerator );
                if ( result == null )
                    result = caseComponent ( heartbeatGenerator );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case CommonPackage.TOGGLE_HEARTBEAT_GENERATOR:
            {
                ToggleHeartbeatGenerator toggleHeartbeatGenerator = (ToggleHeartbeatGenerator)theEObject;
                T result = caseToggleHeartbeatGenerator ( toggleHeartbeatGenerator );
                if ( result == null )
                    result = caseHeartbeatGenerator ( toggleHeartbeatGenerator );
                if ( result == null )
                    result = caseDataComponent ( toggleHeartbeatGenerator );
                if ( result == null )
                    result = caseComponent ( toggleHeartbeatGenerator );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case CommonPackage.HEARTBEAT_DETECTOR:
            {
                HeartbeatDetector heartbeatDetector = (HeartbeatDetector)theEObject;
                T result = caseHeartbeatDetector ( heartbeatDetector );
                if ( result == null )
                    result = caseDataComponent ( heartbeatDetector );
                if ( result == null )
                    result = caseComponent ( heartbeatDetector );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case CommonPackage.CHANGE_HEARTBEAT_DETECTOR:
            {
                ChangeHeartbeatDetector changeHeartbeatDetector = (ChangeHeartbeatDetector)theEObject;
                T result = caseChangeHeartbeatDetector ( changeHeartbeatDetector );
                if ( result == null )
                    result = caseHeartbeatDetector ( changeHeartbeatDetector );
                if ( result == null )
                    result = caseDataComponent ( changeHeartbeatDetector );
                if ( result == null )
                    result = caseComponent ( changeHeartbeatDetector );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            default:
                return defaultCase ( theEObject );
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Heartbeat Generator</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Heartbeat Generator</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseHeartbeatGenerator ( HeartbeatGenerator object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Toggle Heartbeat Generator</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Toggle Heartbeat Generator</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseToggleHeartbeatGenerator ( ToggleHeartbeatGenerator object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Heartbeat Detector</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Heartbeat Detector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseHeartbeatDetector ( HeartbeatDetector object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Change Heartbeat Detector</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Change Heartbeat Detector</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseChangeHeartbeatDetector ( ChangeHeartbeatDetector object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseComponent ( Component object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Data Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDataComponent ( DataComponent object )
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
