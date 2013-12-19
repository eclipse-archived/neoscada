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
package org.eclipse.scada.configuration.world.deployment;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage
 * @generated
 */
public interface DeploymentFactory extends EFactory
{
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    DeploymentFactory eINSTANCE = org.eclipse.scada.configuration.world.deployment.impl.DeploymentFactoryImpl.init ();

    /**
     * Returns a new object of class '<em>Debian Deployment Mechanism</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Debian Deployment Mechanism</em>'.
     * @generated
     */
    DebianDeploymentMechanism createDebianDeploymentMechanism ();

    /**
     * Returns a new object of class '<em>Author</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Author</em>'.
     * @generated
     */
    Author createAuthor ();

    /**
     * Returns a new object of class '<em>Redhat Deployment Mechanism</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Redhat Deployment Mechanism</em>'.
     * @generated
     */
    RedhatDeploymentMechanism createRedhatDeploymentMechanism ();

    /**
     * Returns a new object of class '<em>Information</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Information</em>'.
     * @generated
     */
    DeploymentInformation createDeploymentInformation ();

    /**
     * Returns a new object of class '<em>Change Entry</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Change Entry</em>'.
     * @generated
     */
    ChangeEntry createChangeEntry ();

    /**
     * Returns a new object of class '<em>Node Mappings</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Node Mappings</em>'.
     * @generated
     */
    NodeMappings createNodeMappings ();

    /**
     * Returns a new object of class '<em>Expression Node Mapping Entry</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Expression Node Mapping Entry</em>'.
     * @generated
     */
    ExpressionNodeMappingEntry createExpressionNodeMappingEntry ();

    /**
     * Returns a new object of class '<em>Simple Node Mapping Entry</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Simple Node Mapping Entry</em>'.
     * @generated
     */
    SimpleNodeMappingEntry createSimpleNodeMappingEntry ();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    DeploymentPackage getDeploymentPackage ();

} //DeploymentFactory
