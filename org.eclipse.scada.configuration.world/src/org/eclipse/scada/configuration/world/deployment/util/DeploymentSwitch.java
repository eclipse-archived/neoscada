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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.scada.configuration.world.deployment.Author;
import org.eclipse.scada.configuration.world.deployment.ChangeEntry;
import org.eclipse.scada.configuration.world.deployment.CommonDeploymentMechanism;
import org.eclipse.scada.configuration.world.deployment.DebianDeploymentMechanism;
import org.eclipse.scada.configuration.world.deployment.DeploymentInformation;
import org.eclipse.scada.configuration.world.deployment.DeploymentMechanism;
import org.eclipse.scada.configuration.world.deployment.DeploymentPackage;
import org.eclipse.scada.configuration.world.deployment.ExpressionNodeMappingEntry;
import org.eclipse.scada.configuration.world.deployment.MsiDeploymentMechanism;
import org.eclipse.scada.configuration.world.deployment.NodeMappingEntry;
import org.eclipse.scada.configuration.world.deployment.NodeMappings;
import org.eclipse.scada.configuration.world.deployment.P2Platform;
import org.eclipse.scada.configuration.world.deployment.RedhatDeploymentMechanism;
import org.eclipse.scada.configuration.world.deployment.SimpleNodeMappingEntry;

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
 * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage
 * @generated
 */
public class DeploymentSwitch<T> extends Switch<T>
{
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static DeploymentPackage modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DeploymentSwitch ()
    {
        if ( modelPackage == null )
        {
            modelPackage = DeploymentPackage.eINSTANCE;
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
            case DeploymentPackage.DEPLOYMENT_MECHANISM:
            {
                DeploymentMechanism deploymentMechanism = (DeploymentMechanism)theEObject;
                T result = caseDeploymentMechanism ( deploymentMechanism );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DeploymentPackage.DEBIAN_DEPLOYMENT_MECHANISM:
            {
                DebianDeploymentMechanism debianDeploymentMechanism = (DebianDeploymentMechanism)theEObject;
                T result = caseDebianDeploymentMechanism ( debianDeploymentMechanism );
                if ( result == null )
                    result = caseCommonDeploymentMechanism ( debianDeploymentMechanism );
                if ( result == null )
                    result = caseDeploymentMechanism ( debianDeploymentMechanism );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DeploymentPackage.AUTHOR:
            {
                Author author = (Author)theEObject;
                T result = caseAuthor ( author );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DeploymentPackage.REDHAT_DEPLOYMENT_MECHANISM:
            {
                RedhatDeploymentMechanism redhatDeploymentMechanism = (RedhatDeploymentMechanism)theEObject;
                T result = caseRedhatDeploymentMechanism ( redhatDeploymentMechanism );
                if ( result == null )
                    result = caseCommonDeploymentMechanism ( redhatDeploymentMechanism );
                if ( result == null )
                    result = caseDeploymentMechanism ( redhatDeploymentMechanism );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DeploymentPackage.DEPLOYMENT_INFORMATION:
            {
                DeploymentInformation deploymentInformation = (DeploymentInformation)theEObject;
                T result = caseDeploymentInformation ( deploymentInformation );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DeploymentPackage.COMMON_DEPLOYMENT_MECHANISM:
            {
                CommonDeploymentMechanism commonDeploymentMechanism = (CommonDeploymentMechanism)theEObject;
                T result = caseCommonDeploymentMechanism ( commonDeploymentMechanism );
                if ( result == null )
                    result = caseDeploymentMechanism ( commonDeploymentMechanism );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DeploymentPackage.CHANGE_ENTRY:
            {
                ChangeEntry changeEntry = (ChangeEntry)theEObject;
                T result = caseChangeEntry ( changeEntry );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DeploymentPackage.NODE_MAPPINGS:
            {
                NodeMappings nodeMappings = (NodeMappings)theEObject;
                T result = caseNodeMappings ( nodeMappings );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DeploymentPackage.EXPRESSION_NODE_MAPPING_ENTRY:
            {
                ExpressionNodeMappingEntry expressionNodeMappingEntry = (ExpressionNodeMappingEntry)theEObject;
                T result = caseExpressionNodeMappingEntry ( expressionNodeMappingEntry );
                if ( result == null )
                    result = caseNodeMappingEntry ( expressionNodeMappingEntry );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DeploymentPackage.NODE_MAPPING_ENTRY:
            {
                NodeMappingEntry nodeMappingEntry = (NodeMappingEntry)theEObject;
                T result = caseNodeMappingEntry ( nodeMappingEntry );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DeploymentPackage.SIMPLE_NODE_MAPPING_ENTRY:
            {
                SimpleNodeMappingEntry simpleNodeMappingEntry = (SimpleNodeMappingEntry)theEObject;
                T result = caseSimpleNodeMappingEntry ( simpleNodeMappingEntry );
                if ( result == null )
                    result = caseNodeMappingEntry ( simpleNodeMappingEntry );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DeploymentPackage.MSI_DEPLOYMENT_MECHANISM:
            {
                MsiDeploymentMechanism msiDeploymentMechanism = (MsiDeploymentMechanism)theEObject;
                T result = caseMsiDeploymentMechanism ( msiDeploymentMechanism );
                if ( result == null )
                    result = caseDeploymentMechanism ( msiDeploymentMechanism );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case DeploymentPackage.P2_PLATFORM:
            {
                P2Platform p2Platform = (P2Platform)theEObject;
                T result = caseP2Platform ( p2Platform );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            default:
                return defaultCase ( theEObject );
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Mechanism</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Mechanism</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDeploymentMechanism ( DeploymentMechanism object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Debian Deployment Mechanism</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Debian Deployment Mechanism</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDebianDeploymentMechanism ( DebianDeploymentMechanism object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Author</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Author</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAuthor ( Author object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Redhat Deployment Mechanism</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Redhat Deployment Mechanism</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseRedhatDeploymentMechanism ( RedhatDeploymentMechanism object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Information</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Information</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDeploymentInformation ( DeploymentInformation object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Common Deployment Mechanism</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Common Deployment Mechanism</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseCommonDeploymentMechanism ( CommonDeploymentMechanism object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Change Entry</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Change Entry</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseChangeEntry ( ChangeEntry object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Node Mappings</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Node Mappings</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNodeMappings ( NodeMappings object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Expression Node Mapping Entry</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Expression Node Mapping Entry</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseExpressionNodeMappingEntry ( ExpressionNodeMappingEntry object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Node Mapping Entry</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Node Mapping Entry</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNodeMappingEntry ( NodeMappingEntry object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Simple Node Mapping Entry</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Simple Node Mapping Entry</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseSimpleNodeMappingEntry ( SimpleNodeMappingEntry object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Msi Deployment Mechanism</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Msi Deployment Mechanism</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMsiDeploymentMechanism ( MsiDeploymentMechanism object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>P2 Platform</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>P2 Platform</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseP2Platform ( P2Platform object )
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

} //DeploymentSwitch
