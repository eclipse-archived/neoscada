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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.world.deployment.DeploymentFactory
 * @model kind="package"
 * @generated
 */
public interface DeploymentPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "deployment"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/SCADA/Configuration/World/Deployment"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "deployment"; //$NON-NLS-1$

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eCONTENT_TYPE = "org.eclipse.scada.configuration.deployment"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DeploymentPackage eINSTANCE = org.eclipse.scada.configuration.world.deployment.impl.DeploymentPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link org.eclipse.scada.configuration.world.deployment.DeploymentMechanism <em>Mechanism</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.scada.configuration.world.deployment.DeploymentMechanism
	 * @see org.eclipse.scada.configuration.world.deployment.impl.DeploymentPackageImpl#getDeploymentMechanism()
	 * @generated
	 */
	int DEPLOYMENT_MECHANISM = 0;

	/**
	 * The number of structural features of the '<em>Mechanism</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_MECHANISM_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Mechanism</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_MECHANISM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.scada.configuration.world.deployment.impl.CommonDeploymentMechanismImpl <em>Common Deployment Mechanism</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.scada.configuration.world.deployment.impl.CommonDeploymentMechanismImpl
	 * @see org.eclipse.scada.configuration.world.deployment.impl.DeploymentPackageImpl#getCommonDeploymentMechanism()
	 * @generated
	 */
	int COMMON_DEPLOYMENT_MECHANISM = 5;

	/**
	 * The feature id for the '<em><b>Changes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_DEPLOYMENT_MECHANISM__CHANGES = DEPLOYMENT_MECHANISM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Maintainer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_DEPLOYMENT_MECHANISM__MAINTAINER = DEPLOYMENT_MECHANISM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Common Deployment Mechanism</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_DEPLOYMENT_MECHANISM_FEATURE_COUNT = DEPLOYMENT_MECHANISM_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Common Deployment Mechanism</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMON_DEPLOYMENT_MECHANISM_OPERATION_COUNT = DEPLOYMENT_MECHANISM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.scada.configuration.world.deployment.impl.DebianDeploymentMechanismImpl <em>Debian Deployment Mechanism</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.scada.configuration.world.deployment.impl.DebianDeploymentMechanismImpl
	 * @see org.eclipse.scada.configuration.world.deployment.impl.DeploymentPackageImpl#getDebianDeploymentMechanism()
	 * @generated
	 */
	int DEBIAN_DEPLOYMENT_MECHANISM = 1;

	/**
	 * The feature id for the '<em><b>Changes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBIAN_DEPLOYMENT_MECHANISM__CHANGES = COMMON_DEPLOYMENT_MECHANISM__CHANGES;

	/**
	 * The feature id for the '<em><b>Maintainer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBIAN_DEPLOYMENT_MECHANISM__MAINTAINER = COMMON_DEPLOYMENT_MECHANISM__MAINTAINER;

	/**
	 * The feature id for the '<em><b>Additional Dependencies</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBIAN_DEPLOYMENT_MECHANISM__ADDITIONAL_DEPENDENCIES = COMMON_DEPLOYMENT_MECHANISM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Debian Deployment Mechanism</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBIAN_DEPLOYMENT_MECHANISM_FEATURE_COUNT = COMMON_DEPLOYMENT_MECHANISM_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Debian Deployment Mechanism</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEBIAN_DEPLOYMENT_MECHANISM_OPERATION_COUNT = COMMON_DEPLOYMENT_MECHANISM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.scada.configuration.world.deployment.impl.AuthorImpl <em>Author</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.scada.configuration.world.deployment.impl.AuthorImpl
	 * @see org.eclipse.scada.configuration.world.deployment.impl.DeploymentPackageImpl#getAuthor()
	 * @generated
	 */
	int AUTHOR = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR__NAME = 0;

	/**
	 * The feature id for the '<em><b>Email</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR__EMAIL = 1;

	/**
	 * The number of structural features of the '<em>Author</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Author</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.scada.configuration.world.deployment.impl.RedhatDeploymentMechanismImpl <em>Redhat Deployment Mechanism</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.scada.configuration.world.deployment.impl.RedhatDeploymentMechanismImpl
	 * @see org.eclipse.scada.configuration.world.deployment.impl.DeploymentPackageImpl#getRedhatDeploymentMechanism()
	 * @generated
	 */
	int REDHAT_DEPLOYMENT_MECHANISM = 3;

	/**
	 * The feature id for the '<em><b>Changes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_DEPLOYMENT_MECHANISM__CHANGES = COMMON_DEPLOYMENT_MECHANISM__CHANGES;

	/**
	 * The feature id for the '<em><b>Maintainer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_DEPLOYMENT_MECHANISM__MAINTAINER = COMMON_DEPLOYMENT_MECHANISM__MAINTAINER;

	/**
	 * The number of structural features of the '<em>Redhat Deployment Mechanism</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_DEPLOYMENT_MECHANISM_FEATURE_COUNT = COMMON_DEPLOYMENT_MECHANISM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Redhat Deployment Mechanism</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDHAT_DEPLOYMENT_MECHANISM_OPERATION_COUNT = COMMON_DEPLOYMENT_MECHANISM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.scada.configuration.world.deployment.impl.DeploymentInformationImpl <em>Information</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.scada.configuration.world.deployment.impl.DeploymentInformationImpl
	 * @see org.eclipse.scada.configuration.world.deployment.impl.DeploymentPackageImpl#getDeploymentInformation()
	 * @generated
	 */
	int DEPLOYMENT_INFORMATION = 4;

	/**
	 * The feature id for the '<em><b>Authors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_INFORMATION__AUTHORS = 0;

	/**
	 * The number of structural features of the '<em>Information</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_INFORMATION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Information</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_INFORMATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.scada.configuration.world.deployment.impl.ChangeEntryImpl <em>Change Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.scada.configuration.world.deployment.impl.ChangeEntryImpl
	 * @see org.eclipse.scada.configuration.world.deployment.impl.DeploymentPackageImpl#getChangeEntry()
	 * @generated
	 */
	int CHANGE_ENTRY = 6;

	/**
	 * The feature id for the '<em><b>Author</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_ENTRY__AUTHOR = 0;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_ENTRY__DATE = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_ENTRY__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_ENTRY__VERSION = 3;

	/**
	 * The number of structural features of the '<em>Change Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_ENTRY_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Change Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_ENTRY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.scada.configuration.world.deployment.impl.NodeMappingsImpl <em>Node Mappings</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.scada.configuration.world.deployment.impl.NodeMappingsImpl
	 * @see org.eclipse.scada.configuration.world.deployment.impl.DeploymentPackageImpl#getNodeMappings()
	 * @generated
	 */
	int NODE_MAPPINGS = 7;

	/**
	 * The feature id for the '<em><b>Entries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_MAPPINGS__ENTRIES = 0;

	/**
	 * The feature id for the '<em><b>Fallback Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_MAPPINGS__FALLBACK_MODE = 1;

	/**
	 * The number of structural features of the '<em>Node Mappings</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_MAPPINGS_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Node Mappings</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_MAPPINGS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.scada.configuration.world.deployment.NodeMappingEntry <em>Node Mapping Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.scada.configuration.world.deployment.NodeMappingEntry
	 * @see org.eclipse.scada.configuration.world.deployment.impl.DeploymentPackageImpl#getNodeMappingEntry()
	 * @generated
	 */
	int NODE_MAPPING_ENTRY = 9;

	/**
	 * The number of structural features of the '<em>Node Mapping Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_MAPPING_ENTRY_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Map Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_MAPPING_ENTRY___MAP_NODE__NODE = 0;

	/**
	 * The number of operations of the '<em>Node Mapping Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_MAPPING_ENTRY_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.scada.configuration.world.deployment.impl.ExpressionNodeMappingEntryImpl <em>Expression Node Mapping Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.scada.configuration.world.deployment.impl.ExpressionNodeMappingEntryImpl
	 * @see org.eclipse.scada.configuration.world.deployment.impl.DeploymentPackageImpl#getExpressionNodeMappingEntry()
	 * @generated
	 */
	int EXPRESSION_NODE_MAPPING_ENTRY = 8;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_NODE_MAPPING_ENTRY__PATTERN = NODE_MAPPING_ENTRY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Replacement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_NODE_MAPPING_ENTRY__REPLACEMENT = NODE_MAPPING_ENTRY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Expression Node Mapping Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_NODE_MAPPING_ENTRY_FEATURE_COUNT = NODE_MAPPING_ENTRY_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Map Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_NODE_MAPPING_ENTRY___MAP_NODE__NODE = NODE_MAPPING_ENTRY___MAP_NODE__NODE;

	/**
	 * The number of operations of the '<em>Expression Node Mapping Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_NODE_MAPPING_ENTRY_OPERATION_COUNT = NODE_MAPPING_ENTRY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.scada.configuration.world.deployment.impl.SimpleNodeMappingEntryImpl <em>Simple Node Mapping Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.scada.configuration.world.deployment.impl.SimpleNodeMappingEntryImpl
	 * @see org.eclipse.scada.configuration.world.deployment.impl.DeploymentPackageImpl#getSimpleNodeMappingEntry()
	 * @generated
	 */
	int SIMPLE_NODE_MAPPING_ENTRY = 10;

	/**
	 * The feature id for the '<em><b>From Host Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_NODE_MAPPING_ENTRY__FROM_HOST_NAME = NODE_MAPPING_ENTRY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>To Host Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_NODE_MAPPING_ENTRY__TO_HOST_NAME = NODE_MAPPING_ENTRY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Simple Node Mapping Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_NODE_MAPPING_ENTRY_FEATURE_COUNT = NODE_MAPPING_ENTRY_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Map Node</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_NODE_MAPPING_ENTRY___MAP_NODE__NODE = NODE_MAPPING_ENTRY___MAP_NODE__NODE;

	/**
	 * The number of operations of the '<em>Simple Node Mapping Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_NODE_MAPPING_ENTRY_OPERATION_COUNT = NODE_MAPPING_ENTRY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.scada.configuration.world.deployment.FallbackNodeMappingMode <em>Fallback Node Mapping Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.scada.configuration.world.deployment.FallbackNodeMappingMode
	 * @see org.eclipse.scada.configuration.world.deployment.impl.DeploymentPackageImpl#getFallbackNodeMappingMode()
	 * @generated
	 */
	int FALLBACK_NODE_MAPPING_MODE = 11;

	/**
	 * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.deployment.DeploymentMechanism <em>Mechanism</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mechanism</em>'.
	 * @see org.eclipse.scada.configuration.world.deployment.DeploymentMechanism
	 * @generated
	 */
	EClass getDeploymentMechanism();

	/**
	 * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.deployment.DebianDeploymentMechanism <em>Debian Deployment Mechanism</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Debian Deployment Mechanism</em>'.
	 * @see org.eclipse.scada.configuration.world.deployment.DebianDeploymentMechanism
	 * @generated
	 */
	EClass getDebianDeploymentMechanism();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.scada.configuration.world.deployment.DebianDeploymentMechanism#getAdditionalDependencies <em>Additional Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Additional Dependencies</em>'.
	 * @see org.eclipse.scada.configuration.world.deployment.DebianDeploymentMechanism#getAdditionalDependencies()
	 * @see #getDebianDeploymentMechanism()
	 * @generated
	 */
	EAttribute getDebianDeploymentMechanism_AdditionalDependencies();

	/**
	 * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.deployment.Author <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Author</em>'.
	 * @see org.eclipse.scada.configuration.world.deployment.Author
	 * @generated
	 */
	EClass getAuthor();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.deployment.Author#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.scada.configuration.world.deployment.Author#getName()
	 * @see #getAuthor()
	 * @generated
	 */
	EAttribute getAuthor_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.deployment.Author#getEmail <em>Email</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Email</em>'.
	 * @see org.eclipse.scada.configuration.world.deployment.Author#getEmail()
	 * @see #getAuthor()
	 * @generated
	 */
	EAttribute getAuthor_Email();

	/**
	 * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.deployment.RedhatDeploymentMechanism <em>Redhat Deployment Mechanism</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Redhat Deployment Mechanism</em>'.
	 * @see org.eclipse.scada.configuration.world.deployment.RedhatDeploymentMechanism
	 * @generated
	 */
	EClass getRedhatDeploymentMechanism();

	/**
	 * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.deployment.DeploymentInformation <em>Information</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Information</em>'.
	 * @see org.eclipse.scada.configuration.world.deployment.DeploymentInformation
	 * @generated
	 */
	EClass getDeploymentInformation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.deployment.DeploymentInformation#getAuthors <em>Authors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Authors</em>'.
	 * @see org.eclipse.scada.configuration.world.deployment.DeploymentInformation#getAuthors()
	 * @see #getDeploymentInformation()
	 * @generated
	 */
	EReference getDeploymentInformation_Authors();

	/**
	 * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.deployment.CommonDeploymentMechanism <em>Common Deployment Mechanism</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Common Deployment Mechanism</em>'.
	 * @see org.eclipse.scada.configuration.world.deployment.CommonDeploymentMechanism
	 * @generated
	 */
	EClass getCommonDeploymentMechanism();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.deployment.CommonDeploymentMechanism#getChanges <em>Changes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Changes</em>'.
	 * @see org.eclipse.scada.configuration.world.deployment.CommonDeploymentMechanism#getChanges()
	 * @see #getCommonDeploymentMechanism()
	 * @generated
	 */
	EReference getCommonDeploymentMechanism_Changes();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.world.deployment.CommonDeploymentMechanism#getMaintainer <em>Maintainer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Maintainer</em>'.
	 * @see org.eclipse.scada.configuration.world.deployment.CommonDeploymentMechanism#getMaintainer()
	 * @see #getCommonDeploymentMechanism()
	 * @generated
	 */
	EReference getCommonDeploymentMechanism_Maintainer();

	/**
	 * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.deployment.ChangeEntry <em>Change Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Change Entry</em>'.
	 * @see org.eclipse.scada.configuration.world.deployment.ChangeEntry
	 * @generated
	 */
	EClass getChangeEntry();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.world.deployment.ChangeEntry#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Author</em>'.
	 * @see org.eclipse.scada.configuration.world.deployment.ChangeEntry#getAuthor()
	 * @see #getChangeEntry()
	 * @generated
	 */
	EReference getChangeEntry_Author();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.deployment.ChangeEntry#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.eclipse.scada.configuration.world.deployment.ChangeEntry#getDate()
	 * @see #getChangeEntry()
	 * @generated
	 */
	EAttribute getChangeEntry_Date();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.deployment.ChangeEntry#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.scada.configuration.world.deployment.ChangeEntry#getDescription()
	 * @see #getChangeEntry()
	 * @generated
	 */
	EAttribute getChangeEntry_Description();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.deployment.ChangeEntry#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.eclipse.scada.configuration.world.deployment.ChangeEntry#getVersion()
	 * @see #getChangeEntry()
	 * @generated
	 */
	EAttribute getChangeEntry_Version();

	/**
	 * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.deployment.NodeMappings <em>Node Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Mappings</em>'.
	 * @see org.eclipse.scada.configuration.world.deployment.NodeMappings
	 * @generated
	 */
	EClass getNodeMappings();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.scada.configuration.world.deployment.NodeMappings#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entries</em>'.
	 * @see org.eclipse.scada.configuration.world.deployment.NodeMappings#getEntries()
	 * @see #getNodeMappings()
	 * @generated
	 */
	EReference getNodeMappings_Entries();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.deployment.NodeMappings#getFallbackMode <em>Fallback Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fallback Mode</em>'.
	 * @see org.eclipse.scada.configuration.world.deployment.NodeMappings#getFallbackMode()
	 * @see #getNodeMappings()
	 * @generated
	 */
	EAttribute getNodeMappings_FallbackMode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.deployment.ExpressionNodeMappingEntry <em>Expression Node Mapping Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Node Mapping Entry</em>'.
	 * @see org.eclipse.scada.configuration.world.deployment.ExpressionNodeMappingEntry
	 * @generated
	 */
	EClass getExpressionNodeMappingEntry();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.deployment.ExpressionNodeMappingEntry#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pattern</em>'.
	 * @see org.eclipse.scada.configuration.world.deployment.ExpressionNodeMappingEntry#getPattern()
	 * @see #getExpressionNodeMappingEntry()
	 * @generated
	 */
	EAttribute getExpressionNodeMappingEntry_Pattern();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.deployment.ExpressionNodeMappingEntry#getReplacement <em>Replacement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Replacement</em>'.
	 * @see org.eclipse.scada.configuration.world.deployment.ExpressionNodeMappingEntry#getReplacement()
	 * @see #getExpressionNodeMappingEntry()
	 * @generated
	 */
	EAttribute getExpressionNodeMappingEntry_Replacement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.deployment.NodeMappingEntry <em>Node Mapping Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Mapping Entry</em>'.
	 * @see org.eclipse.scada.configuration.world.deployment.NodeMappingEntry
	 * @generated
	 */
	EClass getNodeMappingEntry();

	/**
	 * Returns the meta object for the '{@link org.eclipse.scada.configuration.world.deployment.NodeMappingEntry#mapNode(org.eclipse.scada.configuration.world.Node) <em>Map Node</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Map Node</em>' operation.
	 * @see org.eclipse.scada.configuration.world.deployment.NodeMappingEntry#mapNode(org.eclipse.scada.configuration.world.Node)
	 * @generated
	 */
	EOperation getNodeMappingEntry__MapNode__Node();

	/**
	 * Returns the meta object for class '{@link org.eclipse.scada.configuration.world.deployment.SimpleNodeMappingEntry <em>Simple Node Mapping Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Node Mapping Entry</em>'.
	 * @see org.eclipse.scada.configuration.world.deployment.SimpleNodeMappingEntry
	 * @generated
	 */
	EClass getSimpleNodeMappingEntry();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.deployment.SimpleNodeMappingEntry#getFromHostName <em>From Host Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From Host Name</em>'.
	 * @see org.eclipse.scada.configuration.world.deployment.SimpleNodeMappingEntry#getFromHostName()
	 * @see #getSimpleNodeMappingEntry()
	 * @generated
	 */
	EAttribute getSimpleNodeMappingEntry_FromHostName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.world.deployment.SimpleNodeMappingEntry#getToHostName <em>To Host Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To Host Name</em>'.
	 * @see org.eclipse.scada.configuration.world.deployment.SimpleNodeMappingEntry#getToHostName()
	 * @see #getSimpleNodeMappingEntry()
	 * @generated
	 */
	EAttribute getSimpleNodeMappingEntry_ToHostName();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.scada.configuration.world.deployment.FallbackNodeMappingMode <em>Fallback Node Mapping Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Fallback Node Mapping Mode</em>'.
	 * @see org.eclipse.scada.configuration.world.deployment.FallbackNodeMappingMode
	 * @generated
	 */
	EEnum getFallbackNodeMappingMode();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DeploymentFactory getDeploymentFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.scada.configuration.world.deployment.DeploymentMechanism <em>Mechanism</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.scada.configuration.world.deployment.DeploymentMechanism
		 * @see org.eclipse.scada.configuration.world.deployment.impl.DeploymentPackageImpl#getDeploymentMechanism()
		 * @generated
		 */
		EClass DEPLOYMENT_MECHANISM = eINSTANCE.getDeploymentMechanism();

		/**
		 * The meta object literal for the '{@link org.eclipse.scada.configuration.world.deployment.impl.DebianDeploymentMechanismImpl <em>Debian Deployment Mechanism</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.scada.configuration.world.deployment.impl.DebianDeploymentMechanismImpl
		 * @see org.eclipse.scada.configuration.world.deployment.impl.DeploymentPackageImpl#getDebianDeploymentMechanism()
		 * @generated
		 */
		EClass DEBIAN_DEPLOYMENT_MECHANISM = eINSTANCE
				.getDebianDeploymentMechanism();

		/**
		 * The meta object literal for the '<em><b>Additional Dependencies</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEBIAN_DEPLOYMENT_MECHANISM__ADDITIONAL_DEPENDENCIES = eINSTANCE
				.getDebianDeploymentMechanism_AdditionalDependencies();

		/**
		 * The meta object literal for the '{@link org.eclipse.scada.configuration.world.deployment.impl.AuthorImpl <em>Author</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.scada.configuration.world.deployment.impl.AuthorImpl
		 * @see org.eclipse.scada.configuration.world.deployment.impl.DeploymentPackageImpl#getAuthor()
		 * @generated
		 */
		EClass AUTHOR = eINSTANCE.getAuthor();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTHOR__NAME = eINSTANCE.getAuthor_Name();

		/**
		 * The meta object literal for the '<em><b>Email</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTHOR__EMAIL = eINSTANCE.getAuthor_Email();

		/**
		 * The meta object literal for the '{@link org.eclipse.scada.configuration.world.deployment.impl.RedhatDeploymentMechanismImpl <em>Redhat Deployment Mechanism</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.scada.configuration.world.deployment.impl.RedhatDeploymentMechanismImpl
		 * @see org.eclipse.scada.configuration.world.deployment.impl.DeploymentPackageImpl#getRedhatDeploymentMechanism()
		 * @generated
		 */
		EClass REDHAT_DEPLOYMENT_MECHANISM = eINSTANCE
				.getRedhatDeploymentMechanism();

		/**
		 * The meta object literal for the '{@link org.eclipse.scada.configuration.world.deployment.impl.DeploymentInformationImpl <em>Information</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.scada.configuration.world.deployment.impl.DeploymentInformationImpl
		 * @see org.eclipse.scada.configuration.world.deployment.impl.DeploymentPackageImpl#getDeploymentInformation()
		 * @generated
		 */
		EClass DEPLOYMENT_INFORMATION = eINSTANCE.getDeploymentInformation();

		/**
		 * The meta object literal for the '<em><b>Authors</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOYMENT_INFORMATION__AUTHORS = eINSTANCE
				.getDeploymentInformation_Authors();

		/**
		 * The meta object literal for the '{@link org.eclipse.scada.configuration.world.deployment.impl.CommonDeploymentMechanismImpl <em>Common Deployment Mechanism</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.scada.configuration.world.deployment.impl.CommonDeploymentMechanismImpl
		 * @see org.eclipse.scada.configuration.world.deployment.impl.DeploymentPackageImpl#getCommonDeploymentMechanism()
		 * @generated
		 */
		EClass COMMON_DEPLOYMENT_MECHANISM = eINSTANCE
				.getCommonDeploymentMechanism();

		/**
		 * The meta object literal for the '<em><b>Changes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMON_DEPLOYMENT_MECHANISM__CHANGES = eINSTANCE
				.getCommonDeploymentMechanism_Changes();

		/**
		 * The meta object literal for the '<em><b>Maintainer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMON_DEPLOYMENT_MECHANISM__MAINTAINER = eINSTANCE
				.getCommonDeploymentMechanism_Maintainer();

		/**
		 * The meta object literal for the '{@link org.eclipse.scada.configuration.world.deployment.impl.ChangeEntryImpl <em>Change Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.scada.configuration.world.deployment.impl.ChangeEntryImpl
		 * @see org.eclipse.scada.configuration.world.deployment.impl.DeploymentPackageImpl#getChangeEntry()
		 * @generated
		 */
		EClass CHANGE_ENTRY = eINSTANCE.getChangeEntry();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANGE_ENTRY__AUTHOR = eINSTANCE.getChangeEntry_Author();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHANGE_ENTRY__DATE = eINSTANCE.getChangeEntry_Date();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHANGE_ENTRY__DESCRIPTION = eINSTANCE
				.getChangeEntry_Description();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHANGE_ENTRY__VERSION = eINSTANCE.getChangeEntry_Version();

		/**
		 * The meta object literal for the '{@link org.eclipse.scada.configuration.world.deployment.impl.NodeMappingsImpl <em>Node Mappings</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.scada.configuration.world.deployment.impl.NodeMappingsImpl
		 * @see org.eclipse.scada.configuration.world.deployment.impl.DeploymentPackageImpl#getNodeMappings()
		 * @generated
		 */
		EClass NODE_MAPPINGS = eINSTANCE.getNodeMappings();

		/**
		 * The meta object literal for the '<em><b>Entries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_MAPPINGS__ENTRIES = eINSTANCE.getNodeMappings_Entries();

		/**
		 * The meta object literal for the '<em><b>Fallback Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE_MAPPINGS__FALLBACK_MODE = eINSTANCE
				.getNodeMappings_FallbackMode();

		/**
		 * The meta object literal for the '{@link org.eclipse.scada.configuration.world.deployment.impl.ExpressionNodeMappingEntryImpl <em>Expression Node Mapping Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.scada.configuration.world.deployment.impl.ExpressionNodeMappingEntryImpl
		 * @see org.eclipse.scada.configuration.world.deployment.impl.DeploymentPackageImpl#getExpressionNodeMappingEntry()
		 * @generated
		 */
		EClass EXPRESSION_NODE_MAPPING_ENTRY = eINSTANCE
				.getExpressionNodeMappingEntry();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION_NODE_MAPPING_ENTRY__PATTERN = eINSTANCE
				.getExpressionNodeMappingEntry_Pattern();

		/**
		 * The meta object literal for the '<em><b>Replacement</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION_NODE_MAPPING_ENTRY__REPLACEMENT = eINSTANCE
				.getExpressionNodeMappingEntry_Replacement();

		/**
		 * The meta object literal for the '{@link org.eclipse.scada.configuration.world.deployment.NodeMappingEntry <em>Node Mapping Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.scada.configuration.world.deployment.NodeMappingEntry
		 * @see org.eclipse.scada.configuration.world.deployment.impl.DeploymentPackageImpl#getNodeMappingEntry()
		 * @generated
		 */
		EClass NODE_MAPPING_ENTRY = eINSTANCE.getNodeMappingEntry();

		/**
		 * The meta object literal for the '<em><b>Map Node</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NODE_MAPPING_ENTRY___MAP_NODE__NODE = eINSTANCE
				.getNodeMappingEntry__MapNode__Node();

		/**
		 * The meta object literal for the '{@link org.eclipse.scada.configuration.world.deployment.impl.SimpleNodeMappingEntryImpl <em>Simple Node Mapping Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.scada.configuration.world.deployment.impl.SimpleNodeMappingEntryImpl
		 * @see org.eclipse.scada.configuration.world.deployment.impl.DeploymentPackageImpl#getSimpleNodeMappingEntry()
		 * @generated
		 */
		EClass SIMPLE_NODE_MAPPING_ENTRY = eINSTANCE
				.getSimpleNodeMappingEntry();

		/**
		 * The meta object literal for the '<em><b>From Host Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_NODE_MAPPING_ENTRY__FROM_HOST_NAME = eINSTANCE
				.getSimpleNodeMappingEntry_FromHostName();

		/**
		 * The meta object literal for the '<em><b>To Host Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_NODE_MAPPING_ENTRY__TO_HOST_NAME = eINSTANCE
				.getSimpleNodeMappingEntry_ToHostName();

		/**
		 * The meta object literal for the '{@link org.eclipse.scada.configuration.world.deployment.FallbackNodeMappingMode <em>Fallback Node Mapping Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.scada.configuration.world.deployment.FallbackNodeMappingMode
		 * @see org.eclipse.scada.configuration.world.deployment.impl.DeploymentPackageImpl#getFallbackNodeMappingMode()
		 * @generated
		 */
		EEnum FALLBACK_NODE_MAPPING_MODE = eINSTANCE
				.getFallbackNodeMappingMode();

	}

} //DeploymentPackage
