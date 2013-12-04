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
package org.eclipse.scada.configuration.world.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.scada.configuration.world.*;

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
 * @see org.eclipse.scada.configuration.world.WorldPackage
 * @generated
 */
public class WorldSwitch<T> extends Switch<T>
{
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static WorldPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WorldSwitch ()
    {
        if ( modelPackage == null )
        {
            modelPackage = WorldPackage.eINSTANCE;
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
            case WorldPackage.WORLD:
            {
                World world = (World)theEObject;
                T result = caseWorld ( world );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case WorldPackage.NODE:
            {
                Node node = (Node)theEObject;
                T result = caseNode ( node );
                if ( result == null )
                    result = caseDocumentable ( node );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case WorldPackage.APPLICATION_NODE:
            {
                ApplicationNode applicationNode = (ApplicationNode)theEObject;
                T result = caseApplicationNode ( applicationNode );
                if ( result == null )
                    result = caseNode ( applicationNode );
                if ( result == null )
                    result = caseDocumentable ( applicationNode );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case WorldPackage.DOCUMENTABLE:
            {
                Documentable documentable = (Documentable)theEObject;
                T result = caseDocumentable ( documentable );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case WorldPackage.APPLICATION:
            {
                Application application = (Application)theEObject;
                T result = caseApplication ( application );
                if ( result == null )
                    result = caseDocumentable ( application );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case WorldPackage.DRIVER:
            {
                Driver driver = (Driver)theEObject;
                T result = caseDriver ( driver );
                if ( result == null )
                    result = caseApplication ( driver );
                if ( result == null )
                    result = caseDocumentable ( driver );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case WorldPackage.ENDPOINT:
            {
                Endpoint endpoint = (Endpoint)theEObject;
                T result = caseEndpoint ( endpoint );
                if ( result == null )
                    result = caseDocumentable ( endpoint );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case WorldPackage.EXEC_DRIVER:
            {
                ExecDriver execDriver = (ExecDriver)theEObject;
                T result = caseExecDriver ( execDriver );
                if ( result == null )
                    result = caseCommonDriver ( execDriver );
                if ( result == null )
                    result = caseDriver ( execDriver );
                if ( result == null )
                    result = caseApplication ( execDriver );
                if ( result == null )
                    result = caseDocumentable ( execDriver );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case WorldPackage.COMMON_DRIVER:
            {
                CommonDriver commonDriver = (CommonDriver)theEObject;
                T result = caseCommonDriver ( commonDriver );
                if ( result == null )
                    result = caseDriver ( commonDriver );
                if ( result == null )
                    result = caseApplication ( commonDriver );
                if ( result == null )
                    result = caseDocumentable ( commonDriver );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case WorldPackage.HANDLER_PRIORITY_RULE:
            {
                HandlerPriorityRule handlerPriorityRule = (HandlerPriorityRule)theEObject;
                T result = caseHandlerPriorityRule ( handlerPriorityRule );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case WorldPackage.MASTER_HANDLER_PRIORITIES:
            {
                MasterHandlerPriorities masterHandlerPriorities = (MasterHandlerPriorities)theEObject;
                T result = caseMasterHandlerPriorities ( masterHandlerPriorities );
                if ( result == null )
                    result = caseDocumentable ( masterHandlerPriorities );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case WorldPackage.OPTIONS:
            {
                Options options = (Options)theEObject;
                T result = caseOptions ( options );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case WorldPackage.USERNAME_PASSWORD_CREDENTIALS:
            {
                UsernamePasswordCredentials usernamePasswordCredentials = (UsernamePasswordCredentials)theEObject;
                T result = caseUsernamePasswordCredentials ( usernamePasswordCredentials );
                if ( result == null )
                    result = caseCredentials ( usernamePasswordCredentials );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case WorldPackage.PASSWORD_CREDENTIALS:
            {
                PasswordCredentials passwordCredentials = (PasswordCredentials)theEObject;
                T result = casePasswordCredentials ( passwordCredentials );
                if ( result == null )
                    result = caseCredentials ( passwordCredentials );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case WorldPackage.CREDENTIALS:
            {
                Credentials credentials = (Credentials)theEObject;
                T result = caseCredentials ( credentials );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case WorldPackage.EXTERNAL_NODE:
            {
                ExternalNode externalNode = (ExternalNode)theEObject;
                T result = caseExternalNode ( externalNode );
                if ( result == null )
                    result = caseNode ( externalNode );
                if ( result == null )
                    result = caseDocumentable ( externalNode );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case WorldPackage.SERVICE:
            {
                Service service = (Service)theEObject;
                T result = caseService ( service );
                if ( result == null )
                    result = caseDocumentable ( service );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            default:
                return defaultCase ( theEObject );
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>World</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>World</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWorld ( World object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNode ( Node object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Application Node</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Application Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseApplicationNode ( ApplicationNode object )
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
     * Returns the result of interpreting the object as an instance of '<em>Endpoint</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Endpoint</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEndpoint ( Endpoint object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Exec Driver</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Exec Driver</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseExecDriver ( ExecDriver object )
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
     * Returns the result of interpreting the object as an instance of '<em>Handler Priority Rule</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Handler Priority Rule</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseHandlerPriorityRule ( HandlerPriorityRule object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Master Handler Priorities</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Master Handler Priorities</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMasterHandlerPriorities ( MasterHandlerPriorities object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Options</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Options</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOptions ( Options object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Username Password Credentials</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Username Password Credentials</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseUsernamePasswordCredentials ( UsernamePasswordCredentials object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Password Credentials</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Password Credentials</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePasswordCredentials ( PasswordCredentials object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Credentials</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Credentials</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCredentials ( Credentials object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>External Node</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>External Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseExternalNode ( ExternalNode object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Service</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Service</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseService ( Service object )
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

} //ConfigurationSwitch
