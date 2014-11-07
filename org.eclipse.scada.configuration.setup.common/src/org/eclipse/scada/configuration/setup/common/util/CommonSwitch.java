/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 *
 */
package org.eclipse.scada.configuration.setup.common.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.scada.configuration.setup.common.*;
import org.eclipse.scada.configuration.setup.common.CommonPackage;
import org.eclipse.scada.configuration.setup.common.PostgresSetupModule;
import org.eclipse.scada.configuration.world.setup.SetupModule;

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
 * @see org.eclipse.scada.configuration.setup.common.CommonPackage
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
            case CommonPackage.POSTGRES_SETUP_MODULE:
            {
                PostgresSetupModule postgresSetupModule = (PostgresSetupModule)theEObject;
                T result = casePostgresSetupModule ( postgresSetupModule );
                if ( result == null )
                    result = caseSetupModule ( postgresSetupModule );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case CommonPackage.SERIAL_TO_NETWORK_SETUP_MODULE:
            {
                SerialToNetworkSetupModule serialToNetworkSetupModule = (SerialToNetworkSetupModule)theEObject;
                T result = caseSerialToNetworkSetupModule ( serialToNetworkSetupModule );
                if ( result == null )
                    result = caseSetupModule ( serialToNetworkSetupModule );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case CommonPackage.SERIAL_TO_NETWORK_MAPPING:
            {
                SerialToNetworkMapping serialToNetworkMapping = (SerialToNetworkMapping)theEObject;
                T result = caseSerialToNetworkMapping ( serialToNetworkMapping );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            default:
                return defaultCase ( theEObject );
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Postgres Setup Module</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Postgres Setup Module</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePostgresSetupModule ( PostgresSetupModule object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Serial To Network Setup Module</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Serial To Network Setup Module</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSerialToNetworkSetupModule ( SerialToNetworkSetupModule object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Serial To Network Mapping</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Serial To Network Mapping</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSerialToNetworkMapping ( SerialToNetworkMapping object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Module</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Module</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSetupModule ( SetupModule object )
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

} //CommonSwitch
