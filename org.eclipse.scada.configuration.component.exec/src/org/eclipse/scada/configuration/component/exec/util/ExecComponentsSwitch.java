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
package org.eclipse.scada.configuration.component.exec.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.scada.configuration.component.Component;
import org.eclipse.scada.configuration.component.Configuration;
import org.eclipse.scada.configuration.component.DataComponent;
import org.eclipse.scada.configuration.component.exec.*;

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
 * @see org.eclipse.scada.configuration.component.exec.ExecComponentsPackage
 * @generated
 */
public class ExecComponentsSwitch<T> extends Switch<T>
{
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static ExecComponentsPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExecComponentsSwitch ()
    {
        if ( modelPackage == null )
        {
            modelPackage = ExecComponentsPackage.eINSTANCE;
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
            case ExecComponentsPackage.EXEC_JOB:
            {
                ExecJob execJob = (ExecJob)theEObject;
                T result = caseExecJob ( execJob );
                if ( result == null )
                    result = caseDataComponent ( execJob );
                if ( result == null )
                    result = caseComponent ( execJob );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ExecComponentsPackage.LOAD_AVERAGE:
            {
                LoadAverage loadAverage = (LoadAverage)theEObject;
                T result = caseLoadAverage ( loadAverage );
                if ( result == null )
                    result = caseExecJob ( loadAverage );
                if ( result == null )
                    result = caseDataComponent ( loadAverage );
                if ( result == null )
                    result = caseComponent ( loadAverage );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ExecComponentsPackage.LOAD_AVERAGE_CONFIGURATION:
            {
                LoadAverageConfiguration loadAverageConfiguration = (LoadAverageConfiguration)theEObject;
                T result = caseLoadAverageConfiguration ( loadAverageConfiguration );
                if ( result == null )
                    result = caseConfiguration ( loadAverageConfiguration );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ExecComponentsPackage.PING_CHECK:
            {
                PingCheck pingCheck = (PingCheck)theEObject;
                T result = casePingCheck ( pingCheck );
                if ( result == null )
                    result = caseExecJob ( pingCheck );
                if ( result == null )
                    result = caseDataComponent ( pingCheck );
                if ( result == null )
                    result = caseComponent ( pingCheck );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ExecComponentsPackage.PING_CHECK_CONFIGURATION:
            {
                PingCheckConfiguration pingCheckConfiguration = (PingCheckConfiguration)theEObject;
                T result = casePingCheckConfiguration ( pingCheckConfiguration );
                if ( result == null )
                    result = caseConfiguration ( pingCheckConfiguration );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ExecComponentsPackage.SYSTEM_INFORMATION_VM_STAT:
            {
                SystemInformationVMStat systemInformationVMStat = (SystemInformationVMStat)theEObject;
                T result = caseSystemInformationVMStat ( systemInformationVMStat );
                if ( result == null )
                    result = caseExecJob ( systemInformationVMStat );
                if ( result == null )
                    result = caseDataComponent ( systemInformationVMStat );
                if ( result == null )
                    result = caseComponent ( systemInformationVMStat );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            default:
                return defaultCase ( theEObject );
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Exec Job</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Exec Job</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseExecJob ( ExecJob object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Load Average</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Load Average</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLoadAverage ( LoadAverage object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Load Average Configuration</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Load Average Configuration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLoadAverageConfiguration ( LoadAverageConfiguration object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ping Check</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ping Check</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePingCheck ( PingCheck object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Ping Check Configuration</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Ping Check Configuration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePingCheckConfiguration ( PingCheckConfiguration object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>System Information VM Stat</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>System Information VM Stat</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSystemInformationVMStat ( SystemInformationVMStat object )
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
     * Returns the result of interpreting the object as an instance of '<em>Configuration</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Configuration</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseConfiguration ( Configuration object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the
     * last case anyway.
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

} //ExecComponentsSwitch
