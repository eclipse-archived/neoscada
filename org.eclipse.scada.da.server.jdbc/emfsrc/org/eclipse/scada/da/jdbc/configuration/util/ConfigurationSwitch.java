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
package org.eclipse.scada.da.jdbc.configuration.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.scada.da.jdbc.configuration.*;

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
 * @see org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage
 * @generated
 */
public class ConfigurationSwitch<T> extends Switch<T>
{
    //$NON-NLS-1$

    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static ConfigurationPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ConfigurationSwitch ()
    {
        if ( modelPackage == null )
        {
            modelPackage = ConfigurationPackage.eINSTANCE;
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
            case ConfigurationPackage.ABSTRACT_QUERY_TYPE:
            {
                AbstractQueryType abstractQueryType = (AbstractQueryType)theEObject;
                T result = caseAbstractQueryType ( abstractQueryType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ConfigurationPackage.COLUMN_MAPPING_TYPE:
            {
                ColumnMappingType columnMappingType = (ColumnMappingType)theEObject;
                T result = caseColumnMappingType ( columnMappingType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ConfigurationPackage.COMMANDS_TYPE:
            {
                CommandsType commandsType = (CommandsType)theEObject;
                T result = caseCommandsType ( commandsType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ConfigurationPackage.CONNECTION_TYPE:
            {
                ConnectionType connectionType = (ConnectionType)theEObject;
                T result = caseConnectionType ( connectionType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ConfigurationPackage.DOCUMENT_ROOT:
            {
                DocumentRoot documentRoot = (DocumentRoot)theEObject;
                T result = caseDocumentRoot ( documentRoot );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ConfigurationPackage.QUERY_TYPE:
            {
                QueryType queryType = (QueryType)theEObject;
                T result = caseQueryType ( queryType );
                if ( result == null )
                    result = caseAbstractQueryType ( queryType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ConfigurationPackage.ROOT_TYPE:
            {
                RootType rootType = (RootType)theEObject;
                T result = caseRootType ( rootType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ConfigurationPackage.TABULAR_QUERY_TYPE:
            {
                TabularQueryType tabularQueryType = (TabularQueryType)theEObject;
                T result = caseTabularQueryType ( tabularQueryType );
                if ( result == null )
                    result = caseAbstractQueryType ( tabularQueryType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ConfigurationPackage.UPDATE_COLUMNS_TYPE:
            {
                UpdateColumnsType updateColumnsType = (UpdateColumnsType)theEObject;
                T result = caseUpdateColumnsType ( updateColumnsType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ConfigurationPackage.UPDATE_MAPPING_TYPE:
            {
                UpdateMappingType updateMappingType = (UpdateMappingType)theEObject;
                T result = caseUpdateMappingType ( updateMappingType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case ConfigurationPackage.UPDATE_TYPE:
            {
                UpdateType updateType = (UpdateType)theEObject;
                T result = caseUpdateType ( updateType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            default:
                return defaultCase ( theEObject );
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Abstract Query Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Abstract Query Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAbstractQueryType ( AbstractQueryType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Column Mapping Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Column Mapping Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseColumnMappingType ( ColumnMappingType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Commands Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Commands Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCommandsType ( CommandsType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Connection Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Connection Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseConnectionType ( ConnectionType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Document Root</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Document Root</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDocumentRoot ( DocumentRoot object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Query Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Query Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseQueryType ( QueryType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Root Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Root Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRootType ( RootType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Tabular Query Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Tabular Query Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseTabularQueryType ( TabularQueryType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Update Columns Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Update Columns Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseUpdateColumnsType ( UpdateColumnsType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Update Mapping Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Update Mapping Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseUpdateMappingType ( UpdateMappingType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Update Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Update Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseUpdateType ( UpdateType object )
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

} //ConfigurationSwitch
