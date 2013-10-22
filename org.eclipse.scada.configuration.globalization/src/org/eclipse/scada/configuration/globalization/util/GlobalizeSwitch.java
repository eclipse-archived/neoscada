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
package org.eclipse.scada.configuration.globalization.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.scada.configuration.globalization.*;
import org.eclipse.scada.configuration.world.Documentable;

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
 * @see org.eclipse.scada.configuration.globalization.GlobalizePackage
 * @generated
 */
public class GlobalizeSwitch<T> extends Switch<T>
{
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static GlobalizePackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GlobalizeSwitch ()
    {
        if ( modelPackage == null )
        {
            modelPackage = GlobalizePackage.eINSTANCE;
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
            case GlobalizePackage.GLOBALIZATION:
            {
                Globalization globalization = (Globalization)theEObject;
                T result = caseGlobalization ( globalization );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case GlobalizePackage.LOCAL:
            {
                Local local = (Local)theEObject;
                T result = caseLocal ( local );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case GlobalizePackage.INCLUDE:
            {
                Include include = (Include)theEObject;
                T result = caseInclude ( include );
                if ( result == null )
                    result = casePatternFilter ( include );
                if ( result == null )
                    result = caseFilter ( include );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case GlobalizePackage.EXCLUDE:
            {
                Exclude exclude = (Exclude)theEObject;
                T result = caseExclude ( exclude );
                if ( result == null )
                    result = casePatternFilter ( exclude );
                if ( result == null )
                    result = caseFilter ( exclude );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case GlobalizePackage.FILTER:
            {
                Filter filter = (Filter)theEObject;
                T result = caseFilter ( filter );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case GlobalizePackage.PATTERN_FILTER:
            {
                PatternFilter patternFilter = (PatternFilter)theEObject;
                T result = casePatternFilter ( patternFilter );
                if ( result == null )
                    result = caseFilter ( patternFilter );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case GlobalizePackage.GLOBAL:
            {
                Global global = (Global)theEObject;
                T result = caseGlobal ( global );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case GlobalizePackage.EVENT_POOL_IMPORT:
            {
                EventPoolImport eventPoolImport = (EventPoolImport)theEObject;
                T result = caseEventPoolImport ( eventPoolImport );
                if ( result == null )
                    result = caseDocumentable ( eventPoolImport );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case GlobalizePackage.MONITOR_POOL_IMPORT:
            {
                MonitorPoolImport monitorPoolImport = (MonitorPoolImport)theEObject;
                T result = caseMonitorPoolImport ( monitorPoolImport );
                if ( result == null )
                    result = caseDocumentable ( monitorPoolImport );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case GlobalizePackage.AUTHORATIVE:
            {
                Authorative authorative = (Authorative)theEObject;
                T result = caseAuthorative ( authorative );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case GlobalizePackage.ITEM_NAME_FILTER:
            {
                ItemNameFilter itemNameFilter = (ItemNameFilter)theEObject;
                T result = caseItemNameFilter ( itemNameFilter );
                if ( result == null )
                    result = caseFilter ( itemNameFilter );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            default:
                return defaultCase ( theEObject );
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Globalization</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Globalization</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseGlobalization ( Globalization object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Local</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Local</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseLocal ( Local object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Include</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Include</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseInclude ( Include object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Exclude</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Exclude</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseExclude ( Exclude object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Filter</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Filter</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseFilter ( Filter object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Pattern Filter</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Pattern Filter</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePatternFilter ( PatternFilter object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Global</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Global</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseGlobal ( Global object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Event Pool Import</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Event Pool Import</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEventPoolImport ( EventPoolImport object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Monitor Pool Import</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Monitor Pool Import</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMonitorPoolImport ( MonitorPoolImport object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Authorative</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Authorative</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAuthorative ( Authorative object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Item Name Filter</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Item Name Filter</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseItemNameFilter ( ItemNameFilter object )
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

} //GlobalizeSwitch
