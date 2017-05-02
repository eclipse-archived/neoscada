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
package org.eclipse.scada.configuration.driver.jdbc.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.scada.configuration.component.Component;
import org.eclipse.scada.configuration.component.DataComponent;
import org.eclipse.scada.configuration.component.MasterComponent;
import org.eclipse.scada.configuration.component.SingleValue;
import org.eclipse.scada.configuration.driver.jdbc.*;

import org.eclipse.scada.configuration.infrastructure.AbstractCommonDriver;
import org.eclipse.scada.configuration.world.Application;
import org.eclipse.scada.configuration.world.CommonDriver;
import org.eclipse.scada.configuration.world.Documentable;
import org.eclipse.scada.configuration.world.Driver;
import org.eclipse.scada.configuration.world.NamedDocumentable;

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
 * @see org.eclipse.scada.configuration.driver.jdbc.JdbcPackage
 * @generated
 */
public class JdbcSwitch<T> extends Switch<T>
{
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static JdbcPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public JdbcSwitch ()
    {
        if ( modelPackage == null )
        {
            modelPackage = JdbcPackage.eINSTANCE;
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
            case JdbcPackage.JDBC_DRIVER_INSTANCE:
            {
                JdbcDriverInstance jdbcDriverInstance = (JdbcDriverInstance)theEObject;
                T result = caseJdbcDriverInstance ( jdbcDriverInstance );
                if ( result == null )
                    result = caseCommonDriver ( jdbcDriverInstance );
                if ( result == null )
                    result = caseDriver ( jdbcDriverInstance );
                if ( result == null )
                    result = caseApplication ( jdbcDriverInstance );
                if ( result == null )
                    result = caseNamedDocumentable ( jdbcDriverInstance );
                if ( result == null )
                    result = caseDocumentable ( jdbcDriverInstance );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case JdbcPackage.UPDATE_COMMAND:
            {
                UpdateCommand updateCommand = (UpdateCommand)theEObject;
                T result = caseUpdateCommand ( updateCommand );
                if ( result == null )
                    result = caseSingleValue ( updateCommand );
                if ( result == null )
                    result = caseQueryBase ( updateCommand );
                if ( result == null )
                    result = caseMasterComponent ( updateCommand );
                if ( result == null )
                    result = caseDataComponent ( updateCommand );
                if ( result == null )
                    result = caseComponent ( updateCommand );
                if ( result == null )
                    result = caseDocumentable ( updateCommand );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case JdbcPackage.QUERY_COMPONENT:
            {
                QueryComponent queryComponent = (QueryComponent)theEObject;
                T result = caseQueryComponent ( queryComponent );
                if ( result == null )
                    result = caseMasterComponent ( queryComponent );
                if ( result == null )
                    result = caseQueryBase ( queryComponent );
                if ( result == null )
                    result = caseDataComponent ( queryComponent );
                if ( result == null )
                    result = caseComponent ( queryComponent );
                if ( result == null )
                    result = caseDocumentable ( queryComponent );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case JdbcPackage.QUERY_BASE:
            {
                QueryBase queryBase = (QueryBase)theEObject;
                T result = caseQueryBase ( queryBase );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case JdbcPackage.UPDATE_MAPPING:
            {
                UpdateMapping updateMapping = (UpdateMapping)theEObject;
                T result = caseUpdateMapping ( updateMapping );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case JdbcPackage.COLUMN_MAPPING:
            {
                ColumnMapping columnMapping = (ColumnMapping)theEObject;
                T result = caseColumnMapping ( columnMapping );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case JdbcPackage.JDBC_DRIVER:
            {
                JdbcDriver jdbcDriver = (JdbcDriver)theEObject;
                T result = caseJdbcDriver ( jdbcDriver );
                if ( result == null )
                    result = caseAbstractCommonDriver ( jdbcDriver );
                if ( result == null )
                    result = caseInfrastructure_Driver ( jdbcDriver );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            default:
                return defaultCase ( theEObject );
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Driver Instance</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Driver Instance</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseJdbcDriverInstance ( JdbcDriverInstance object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Update Command</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Update Command</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseUpdateCommand ( UpdateCommand object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Query Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Query Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseQueryComponent ( QueryComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Query Base</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Query Base</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseQueryBase ( QueryBase object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Update Mapping</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Update Mapping</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseUpdateMapping ( UpdateMapping object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Column Mapping</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Column Mapping</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseColumnMapping ( ColumnMapping object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Driver</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Driver</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseJdbcDriver ( JdbcDriver object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Documentable</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Documentable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDocumentable ( Documentable object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Named Documentable</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Named Documentable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNamedDocumentable ( NamedDocumentable object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Application</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Application</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseApplication ( Application object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Driver</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Driver</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDriver ( Driver object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Common Driver</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Common Driver</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCommonDriver ( CommonDriver object )
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
     * Returns the result of interpreting the object as an instance of '<em>Master Component</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Master Component</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMasterComponent ( MasterComponent object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Single Value</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Single Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSingleValue ( SingleValue object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Driver</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Driver</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseInfrastructure_Driver ( org.eclipse.scada.configuration.infrastructure.Driver object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Abstract Common Driver</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Abstract Common Driver</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAbstractCommonDriver ( AbstractCommonDriver object )
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

} //JdbcSwitch
