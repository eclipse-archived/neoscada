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
package org.eclipse.scada.configuration.world.deployment.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.configuration.world.deployment.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the
 * model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage
 * @generated
 */
public class DeploymentAdapterFactory extends AdapterFactoryImpl
{
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static DeploymentPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DeploymentAdapterFactory ()
    {
        if ( modelPackage == null )
        {
            modelPackage = DeploymentPackage.eINSTANCE;
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
    protected DeploymentSwitch<Adapter> modelSwitch = new DeploymentSwitch<Adapter> () {
        @Override
        public Adapter caseDeploymentMechanism ( DeploymentMechanism object )
        {
            return createDeploymentMechanismAdapter ();
        }

        @Override
        public Adapter caseDebianDeploymentMechanism ( DebianDeploymentMechanism object )
        {
            return createDebianDeploymentMechanismAdapter ();
        }

        @Override
        public Adapter caseAuthor ( Author object )
        {
            return createAuthorAdapter ();
        }

        @Override
        public Adapter caseRedhatDeploymentMechanism ( RedhatDeploymentMechanism object )
        {
            return createRedhatDeploymentMechanismAdapter ();
        }

        @Override
        public Adapter caseDeploymentInformation ( DeploymentInformation object )
        {
            return createDeploymentInformationAdapter ();
        }

        @Override
        public Adapter caseCommonDeploymentMechanism ( CommonDeploymentMechanism object )
        {
            return createCommonDeploymentMechanismAdapter ();
        }

        @Override
        public Adapter caseChangeEntry ( ChangeEntry object )
        {
            return createChangeEntryAdapter ();
        }

        @Override
        public Adapter caseNodeMappings ( NodeMappings object )
        {
            return createNodeMappingsAdapter ();
        }

        @Override
        public Adapter caseExpressionNodeMappingEntry ( ExpressionNodeMappingEntry object )
        {
            return createExpressionNodeMappingEntryAdapter ();
        }

        @Override
        public Adapter caseMappingEntry ( MappingEntry object )
        {
            return createMappingEntryAdapter ();
        }

        @Override
        public Adapter caseSimpleNodeMappingEntry ( SimpleNodeMappingEntry object )
        {
            return createSimpleNodeMappingEntryAdapter ();
        }

        @Override
        public Adapter caseMsiDeploymentMechanism ( MsiDeploymentMechanism object )
        {
            return createMsiDeploymentMechanismAdapter ();
        }

        @Override
        public Adapter caseP2Platform ( P2Platform object )
        {
            return createP2PlatformAdapter ();
        }

        @Override
        public Adapter caseMappings ( Mappings object )
        {
            return createMappingsAdapter ();
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
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.deployment.DeploymentMechanism <em>Mechanism</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.deployment.DeploymentMechanism
     * @generated
     */
    public Adapter createDeploymentMechanismAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.deployment.DebianDeploymentMechanism <em>Debian Deployment Mechanism</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.deployment.DebianDeploymentMechanism
     * @generated
     */
    public Adapter createDebianDeploymentMechanismAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.deployment.Author <em>Author</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.deployment.Author
     * @generated
     */
    public Adapter createAuthorAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.deployment.RedhatDeploymentMechanism <em>Redhat Deployment Mechanism</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.deployment.RedhatDeploymentMechanism
     * @generated
     */
    public Adapter createRedhatDeploymentMechanismAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.deployment.DeploymentInformation <em>Information</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.deployment.DeploymentInformation
     * @generated
     */
    public Adapter createDeploymentInformationAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.deployment.CommonDeploymentMechanism <em>Common Deployment Mechanism</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.deployment.CommonDeploymentMechanism
     * @generated
     */
    public Adapter createCommonDeploymentMechanismAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.deployment.ChangeEntry <em>Change Entry</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.deployment.ChangeEntry
     * @generated
     */
    public Adapter createChangeEntryAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.deployment.NodeMappings <em>Node Mappings</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.deployment.NodeMappings
     * @generated
     */
    public Adapter createNodeMappingsAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.deployment.ExpressionNodeMappingEntry <em>Expression Node Mapping Entry</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.deployment.ExpressionNodeMappingEntry
     * @generated
     */
    public Adapter createExpressionNodeMappingEntryAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.deployment.MappingEntry <em>Mapping Entry</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.deployment.MappingEntry
     * @generated
     */
    public Adapter createMappingEntryAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.deployment.SimpleNodeMappingEntry <em>Simple Node Mapping Entry</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.deployment.SimpleNodeMappingEntry
     * @generated
     */
    public Adapter createSimpleNodeMappingEntryAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.deployment.MsiDeploymentMechanism <em>Msi Deployment Mechanism</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.deployment.MsiDeploymentMechanism
     * @generated
     */
    public Adapter createMsiDeploymentMechanismAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.deployment.P2Platform <em>P2 Platform</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore
     * cases;
     * it's useful to ignore a case when inheritance will catch all the cases
     * anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.deployment.P2Platform
     * @generated
     */
    public Adapter createP2PlatformAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.deployment.Mappings <em>Mappings</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.deployment.Mappings
     * @generated
     */
    public Adapter createMappingsAdapter ()
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

} //DeploymentAdapterFactory
