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
package org.eclipse.scada.da.exec.configuration;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage
 * @generated
 */
public interface ConfigurationFactory extends EFactory
{

    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ConfigurationFactory eINSTANCE = org.eclipse.scada.da.exec.configuration.impl.ConfigurationFactoryImpl.init ();

    /**
     * Returns a new object of class '<em>Continuous Command Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Continuous Command Type</em>'.
     * @generated
     */
    ContinuousCommandType createContinuousCommandType ();

    /**
     * Returns a new object of class '<em>Custom Extractor Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Custom Extractor Type</em>'.
     * @generated
     */
    CustomExtractorType createCustomExtractorType ();

    /**
     * Returns a new object of class '<em>Document Root</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Document Root</em>'.
     * @generated
     */
    DocumentRoot createDocumentRoot ();

    /**
     * Returns a new object of class '<em>Env Entry Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Env Entry Type</em>'.
     * @generated
     */
    EnvEntryType createEnvEntryType ();

    /**
     * Returns a new object of class '<em>Field Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Field Type</em>'.
     * @generated
     */
    FieldType createFieldType ();

    /**
     * Returns a new object of class '<em>Hive Process Command Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Hive Process Command Type</em>'.
     * @generated
     */
    HiveProcessCommandType createHiveProcessCommandType ();

    /**
     * Returns a new object of class '<em>Nagios Return Code Extractor Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Nagios Return Code Extractor Type</em>'.
     * @generated
     */
    NagiosReturnCodeExtractorType createNagiosReturnCodeExtractorType ();

    /**
     * Returns a new object of class '<em>Plain Stream Extractor Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Plain Stream Extractor Type</em>'.
     * @generated
     */
    PlainStreamExtractorType createPlainStreamExtractorType ();

    /**
     * Returns a new object of class '<em>Process Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Process Type</em>'.
     * @generated
     */
    ProcessType createProcessType ();

    /**
     * Returns a new object of class '<em>Queue Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Queue Type</em>'.
     * @generated
     */
    QueueType createQueueType ();

    /**
     * Returns a new object of class '<em>Reg Ex Extractor Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Reg Ex Extractor Type</em>'.
     * @generated
     */
    RegExExtractorType createRegExExtractorType ();

    /**
     * Returns a new object of class '<em>Return Code Extractor Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Return Code Extractor Type</em>'.
     * @generated
     */
    ReturnCodeExtractorType createReturnCodeExtractorType ();

    /**
     * Returns a new object of class '<em>Root Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Root Type</em>'.
     * @generated
     */
    RootType createRootType ();

    /**
     * Returns a new object of class '<em>Single Command Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Single Command Type</em>'.
     * @generated
     */
    SingleCommandType createSingleCommandType ();

    /**
     * Returns a new object of class '<em>Split Continuous Command Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Split Continuous Command Type</em>'.
     * @generated
     */
    SplitContinuousCommandType createSplitContinuousCommandType ();

    /**
     * Returns a new object of class '<em>Splitter Extractor Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Splitter Extractor Type</em>'.
     * @generated
     */
    SplitterExtractorType createSplitterExtractorType ();

    /**
     * Returns a new object of class '<em>Splitter Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Splitter Type</em>'.
     * @generated
     */
    SplitterType createSplitterType ();

    /**
     * Returns a new object of class '<em>Trigger Command Type</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Trigger Command Type</em>'.
     * @generated
     */
    TriggerCommandType createTriggerCommandType ();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    ConfigurationPackage getConfigurationPackage ();

} //ConfigurationFactory
