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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the
 * model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.world.WorldPackage
 * @generated
 */
public class WorldAdapterFactory extends AdapterFactoryImpl
{
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static WorldPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public WorldAdapterFactory ()
    {
        if ( modelPackage == null )
        {
            modelPackage = WorldPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the
     * model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType ( Object object )
    {
        if ( object == modelPackage )
        {
            return true;
        }
        if ( object instanceof EObject )
        {
            return ( (EObject)object ).eClass ().getEPackage () == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected WorldSwitch<Adapter> modelSwitch = new WorldSwitch<Adapter> ()
    {
        @Override
        public Adapter caseWorld ( World object )
        {
            return createWorldAdapter ();
        }

        @Override
        public Adapter caseNode ( Node object )
        {
            return createNodeAdapter ();
        }

        @Override
        public Adapter caseApplicationNode ( ApplicationNode object )
        {
            return createApplicationNodeAdapter ();
        }

        @Override
        public Adapter caseDocumentable ( Documentable object )
        {
            return createDocumentableAdapter ();
        }

        @Override
        public Adapter caseApplication ( Application object )
        {
            return createApplicationAdapter ();
        }

        @Override
        public Adapter caseDriver ( Driver object )
        {
            return createDriverAdapter ();
        }

        @Override
        public Adapter caseEndpoint ( Endpoint object )
        {
            return createEndpointAdapter ();
        }

        @Override
        public Adapter caseExecDriver ( ExecDriver object )
        {
            return createExecDriverAdapter ();
        }

        @Override
        public Adapter caseCommonDriver ( CommonDriver object )
        {
            return createCommonDriverAdapter ();
        }

        @Override
        public Adapter caseHandlerPriorityRule ( HandlerPriorityRule object )
        {
            return createHandlerPriorityRuleAdapter ();
        }

        @Override
        public Adapter caseMasterHandlerPriorities ( MasterHandlerPriorities object )
        {
            return createMasterHandlerPrioritiesAdapter ();
        }

        @Override
        public Adapter caseOptions ( Options object )
        {
            return createOptionsAdapter ();
        }

        @Override
        public Adapter caseUsernamePasswordCredentials ( UsernamePasswordCredentials object )
        {
            return createUsernamePasswordCredentialsAdapter ();
        }

        @Override
        public Adapter casePasswordCredentials ( PasswordCredentials object )
        {
            return createPasswordCredentialsAdapter ();
        }

        @Override
        public Adapter caseCredentials ( Credentials object )
        {
            return createCredentialsAdapter ();
        }

        @Override
        public Adapter caseExternalNode ( ExternalNode object )
        {
            return createExternalNodeAdapter ();
        }

        @Override
        public Adapter caseService ( Service object )
        {
            return createServiceAdapter ();
        }

        @Override
        public Adapter caseNamedDocumentable ( NamedDocumentable object )
        {
            return createNamedDocumentableAdapter ();
        }

        @Override
        public Adapter defaultCase ( EObject object )
        {
            return createEObjectAdapter ();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter ( Notifier target )
    {
        return modelSwitch.doSwitch ( (EObject)target );
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.World <em>World</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.World
     * @generated
     */
    public Adapter createWorldAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.Node <em>Node</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.Node
     * @generated
     */
    public Adapter createNodeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.ApplicationNode <em>Application Node</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.ApplicationNode
     * @generated
     */
    public Adapter createApplicationNodeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.Documentable <em>Documentable</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.Documentable
     * @generated
     */
    public Adapter createDocumentableAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.Application <em>Application</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.Application
     * @generated
     */
    public Adapter createApplicationAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.Driver <em>Driver</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.Driver
     * @generated
     */
    public Adapter createDriverAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.Endpoint <em>Endpoint</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.Endpoint
     * @generated
     */
    public Adapter createEndpointAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.ExecDriver <em>Exec Driver</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.ExecDriver
     * @generated
     */
    public Adapter createExecDriverAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.CommonDriver <em>Common Driver</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.CommonDriver
     * @generated
     */
    public Adapter createCommonDriverAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.HandlerPriorityRule <em>Handler Priority Rule</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.HandlerPriorityRule
     * @generated
     */
    public Adapter createHandlerPriorityRuleAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.MasterHandlerPriorities <em>Master Handler Priorities</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.MasterHandlerPriorities
     * @generated
     */
    public Adapter createMasterHandlerPrioritiesAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.Options <em>Options</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.Options
     * @generated
     */
    public Adapter createOptionsAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.UsernamePasswordCredentials <em>Username Password Credentials</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.UsernamePasswordCredentials
     * @generated
     */
    public Adapter createUsernamePasswordCredentialsAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.PasswordCredentials <em>Password Credentials</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.PasswordCredentials
     * @generated
     */
    public Adapter createPasswordCredentialsAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.Credentials <em>Credentials</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.Credentials
     * @generated
     */
    public Adapter createCredentialsAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.ExternalNode <em>External Node</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.ExternalNode
     * @generated
     */
    public Adapter createExternalNodeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.Service <em>Service</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.Service
     * @generated
     */
    public Adapter createServiceAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.NamedDocumentable <em>Named Documentable</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.NamedDocumentable
     * @generated
     */
    public Adapter createNamedDocumentableAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter ()
    {
        return null;
    }

} //ConfigurationAdapterFactory
