/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
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
import org.eclipse.scada.configuration.world.Application;
import org.eclipse.scada.configuration.world.ApplicationNode;
import org.eclipse.scada.configuration.world.CommonDriver;
import org.eclipse.scada.configuration.world.Credentials;
import org.eclipse.scada.configuration.world.Documentable;
import org.eclipse.scada.configuration.world.Driver;
import org.eclipse.scada.configuration.world.Endpoint;
import org.eclipse.scada.configuration.world.ExecDriver;
import org.eclipse.scada.configuration.world.ExternalNode;
import org.eclipse.scada.configuration.world.HandlerPriorityRule;
import org.eclipse.scada.configuration.world.MasterHandlerPriorities;
import org.eclipse.scada.configuration.world.NamedDocumentable;
import org.eclipse.scada.configuration.world.Node;
import org.eclipse.scada.configuration.world.Options;
import org.eclipse.scada.configuration.world.PasswordCredentials;
import org.eclipse.scada.configuration.world.Service;
import org.eclipse.scada.configuration.world.UsernamePasswordCredentials;
import org.eclipse.scada.configuration.world.World;
import org.eclipse.scada.configuration.world.WorldPackage;

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
 * 
 * @see org.eclipse.scada.configuration.world.WorldPackage
 * @generated
 */
public class WorldSwitch<T> extends Switch<T>
{
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static WorldPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
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
     * 
     * @parameter ePackage the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor ( final EPackage ePackage )
    {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns
     * a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @return the first non-null result returned by a <code>caseXXX</code>
     *         call.
     * @generated
     */
    @Override
    protected T doSwitch ( final int classifierID, final EObject theEObject )
    {
        switch ( classifierID )
        {
            case WorldPackage.WORLD:
            {
                final World world = (World)theEObject;
                T result = caseWorld ( world );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case WorldPackage.NODE:
            {
                final Node node = (Node)theEObject;
                T result = caseNode ( node );
                if ( result == null )
                {
                    result = caseNamedDocumentable ( node );
                }
                if ( result == null )
                {
                    result = caseDocumentable ( node );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case WorldPackage.APPLICATION_NODE:
            {
                final ApplicationNode applicationNode = (ApplicationNode)theEObject;
                T result = caseApplicationNode ( applicationNode );
                if ( result == null )
                {
                    result = caseNode ( applicationNode );
                }
                if ( result == null )
                {
                    result = caseNamedDocumentable ( applicationNode );
                }
                if ( result == null )
                {
                    result = caseDocumentable ( applicationNode );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case WorldPackage.DOCUMENTABLE:
            {
                final Documentable documentable = (Documentable)theEObject;
                T result = caseDocumentable ( documentable );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case WorldPackage.APPLICATION:
            {
                final Application application = (Application)theEObject;
                T result = caseApplication ( application );
                if ( result == null )
                {
                    result = caseNamedDocumentable ( application );
                }
                if ( result == null )
                {
                    result = caseDocumentable ( application );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case WorldPackage.DRIVER:
            {
                final Driver driver = (Driver)theEObject;
                T result = caseDriver ( driver );
                if ( result == null )
                {
                    result = caseApplication ( driver );
                }
                if ( result == null )
                {
                    result = caseNamedDocumentable ( driver );
                }
                if ( result == null )
                {
                    result = caseDocumentable ( driver );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case WorldPackage.ENDPOINT:
            {
                final Endpoint endpoint = (Endpoint)theEObject;
                T result = caseEndpoint ( endpoint );
                if ( result == null )
                {
                    result = caseNamedDocumentable ( endpoint );
                }
                if ( result == null )
                {
                    result = caseDocumentable ( endpoint );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case WorldPackage.EXEC_DRIVER:
            {
                final ExecDriver execDriver = (ExecDriver)theEObject;
                T result = caseExecDriver ( execDriver );
                if ( result == null )
                {
                    result = caseCommonDriver ( execDriver );
                }
                if ( result == null )
                {
                    result = caseDriver ( execDriver );
                }
                if ( result == null )
                {
                    result = caseApplication ( execDriver );
                }
                if ( result == null )
                {
                    result = caseNamedDocumentable ( execDriver );
                }
                if ( result == null )
                {
                    result = caseDocumentable ( execDriver );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case WorldPackage.COMMON_DRIVER:
            {
                final CommonDriver commonDriver = (CommonDriver)theEObject;
                T result = caseCommonDriver ( commonDriver );
                if ( result == null )
                {
                    result = caseDriver ( commonDriver );
                }
                if ( result == null )
                {
                    result = caseApplication ( commonDriver );
                }
                if ( result == null )
                {
                    result = caseNamedDocumentable ( commonDriver );
                }
                if ( result == null )
                {
                    result = caseDocumentable ( commonDriver );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case WorldPackage.HANDLER_PRIORITY_RULE:
            {
                final HandlerPriorityRule handlerPriorityRule = (HandlerPriorityRule)theEObject;
                T result = caseHandlerPriorityRule ( handlerPriorityRule );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case WorldPackage.MASTER_HANDLER_PRIORITIES:
            {
                final MasterHandlerPriorities masterHandlerPriorities = (MasterHandlerPriorities)theEObject;
                T result = caseMasterHandlerPriorities ( masterHandlerPriorities );
                if ( result == null )
                {
                    result = caseNamedDocumentable ( masterHandlerPriorities );
                }
                if ( result == null )
                {
                    result = caseDocumentable ( masterHandlerPriorities );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case WorldPackage.OPTIONS:
            {
                final Options options = (Options)theEObject;
                T result = caseOptions ( options );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case WorldPackage.USERNAME_PASSWORD_CREDENTIALS:
            {
                final UsernamePasswordCredentials usernamePasswordCredentials = (UsernamePasswordCredentials)theEObject;
                T result = caseUsernamePasswordCredentials ( usernamePasswordCredentials );
                if ( result == null )
                {
                    result = caseCredentials ( usernamePasswordCredentials );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case WorldPackage.PASSWORD_CREDENTIALS:
            {
                final PasswordCredentials passwordCredentials = (PasswordCredentials)theEObject;
                T result = casePasswordCredentials ( passwordCredentials );
                if ( result == null )
                {
                    result = caseCredentials ( passwordCredentials );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case WorldPackage.CREDENTIALS:
            {
                final Credentials credentials = (Credentials)theEObject;
                T result = caseCredentials ( credentials );
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case WorldPackage.EXTERNAL_NODE:
            {
                final ExternalNode externalNode = (ExternalNode)theEObject;
                T result = caseExternalNode ( externalNode );
                if ( result == null )
                {
                    result = caseNode ( externalNode );
                }
                if ( result == null )
                {
                    result = caseNamedDocumentable ( externalNode );
                }
                if ( result == null )
                {
                    result = caseDocumentable ( externalNode );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case WorldPackage.SERVICE:
            {
                final Service service = (Service)theEObject;
                T result = caseService ( service );
                if ( result == null )
                {
                    result = caseNamedDocumentable ( service );
                }
                if ( result == null )
                {
                    result = caseDocumentable ( service );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            case WorldPackage.NAMED_DOCUMENTABLE:
            {
                final NamedDocumentable namedDocumentable = (NamedDocumentable)theEObject;
                T result = caseNamedDocumentable ( namedDocumentable );
                if ( result == null )
                {
                    result = caseDocumentable ( namedDocumentable );
                }
                if ( result == null )
                {
                    result = defaultCase ( theEObject );
                }
                return result;
            }
            default:
                return defaultCase ( theEObject );
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>World</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>World</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseWorld ( final World object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Node</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNode ( final Node object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Application Node</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Application Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseApplicationNode ( final ApplicationNode object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Documentable</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Documentable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDocumentable ( final Documentable object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Application</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Application</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseApplication ( final Application object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Driver</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Driver</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDriver ( final Driver object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Endpoint</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Endpoint</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEndpoint ( final Endpoint object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Exec Driver</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Exec Driver</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseExecDriver ( final ExecDriver object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Common Driver</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Common Driver</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCommonDriver ( final CommonDriver object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Handler Priority Rule</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Handler Priority Rule</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseHandlerPriorityRule ( final HandlerPriorityRule object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Master Handler Priorities</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Master Handler Priorities</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMasterHandlerPriorities ( final MasterHandlerPriorities object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Options</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Options</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseOptions ( final Options object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Username Password Credentials</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Username Password Credentials</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseUsernamePasswordCredentials ( final UsernamePasswordCredentials object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Password Credentials</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Password Credentials</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T casePasswordCredentials ( final PasswordCredentials object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Credentials</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Credentials</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCredentials ( final Credentials object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>External Node</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>External Node</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseExternalNode ( final ExternalNode object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Service</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Service</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseService ( final Service object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>Named Documentable</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>Named Documentable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNamedDocumentable ( final NamedDocumentable object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '
     * <em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the
     * last case anyway.
     * <!-- end-user-doc -->
     * 
     * @param object
     *            the target of the switch.
     * @return the result of interpreting the object as an instance of '
     *         <em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase ( final EObject object )
    {
        return null;
    }

} //ConfigurationSwitch
