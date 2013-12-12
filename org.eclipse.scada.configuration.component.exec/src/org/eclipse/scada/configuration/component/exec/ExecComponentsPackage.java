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
package org.eclipse.scada.configuration.component.exec;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.scada.configuration.component.ComponentPackage;

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
 * <!-- begin-model-doc -->
 * Reports system information using "vmstat".
 * <!-- end-model-doc -->
 * @see org.eclipse.scada.configuration.component.exec.ExecComponentsFactory
 * @model kind="package"
 * @generated
 */
public interface ExecComponentsPackage extends EPackage
{
    /**
     * The package name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNAME = "exec"; //$NON-NLS-1$

    /**
     * The package namespace URI.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_URI = "http://eclipse.org/SCADA/Configuration/Component/Exec"; //$NON-NLS-1$

    /**
     * The package namespace name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    String eNS_PREFIX = "exec"; //$NON-NLS-1$

    /**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ExecComponentsPackage eINSTANCE = org.eclipse.scada.configuration.component.exec.impl.ExecComponentsPackageImpl.init ();

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.exec.impl.ExecJobImpl <em>Exec Job</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.exec.impl.ExecJobImpl
     * @see org.eclipse.scada.configuration.component.exec.impl.ExecComponentsPackageImpl#getExecJob()
     * @generated
     */
    int EXEC_JOB = 0;

    /**
     * The feature id for the '<em><b>Level</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXEC_JOB__LEVEL = ComponentPackage.MASTER_COMPONENT__LEVEL;

    /**
     * The feature id for the '<em><b>Customization Pipeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXEC_JOB__CUSTOMIZATION_PIPELINE = ComponentPackage.MASTER_COMPONENT__CUSTOMIZATION_PIPELINE;

    /**
     * The feature id for the '<em><b>Archive Selector</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXEC_JOB__ARCHIVE_SELECTOR = ComponentPackage.MASTER_COMPONENT__ARCHIVE_SELECTOR;

    /**
     * The feature id for the '<em><b>Master On</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXEC_JOB__MASTER_ON = ComponentPackage.MASTER_COMPONENT__MASTER_ON;

    /**
     * The feature id for the '<em><b>Runs On</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXEC_JOB__RUNS_ON = ComponentPackage.MASTER_COMPONENT_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXEC_JOB__NAME = ComponentPackage.MASTER_COMPONENT_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Exec Job</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXEC_JOB_FEATURE_COUNT = ComponentPackage.MASTER_COMPONENT_FEATURE_COUNT + 2;

    /**
     * The operation id for the '<em>Get Master On</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXEC_JOB___GET_MASTER_ON = ComponentPackage.MASTER_COMPONENT___GET_MASTER_ON;

    /**
     * The operation id for the '<em>Has Exec Driver</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXEC_JOB___HAS_EXEC_DRIVER__DIAGNOSTICCHAIN_MAP = ComponentPackage.MASTER_COMPONENT_OPERATION_COUNT + 0;

    /**
     * The number of operations of the '<em>Exec Job</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int EXEC_JOB_OPERATION_COUNT = ComponentPackage.MASTER_COMPONENT_OPERATION_COUNT + 1;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.exec.impl.LoadAverageImpl <em>Load Average</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.exec.impl.LoadAverageImpl
     * @see org.eclipse.scada.configuration.component.exec.impl.ExecComponentsPackageImpl#getLoadAverage()
     * @generated
     */
    int LOAD_AVERAGE = 1;

    /**
     * The feature id for the '<em><b>Level</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOAD_AVERAGE__LEVEL = EXEC_JOB__LEVEL;

    /**
     * The feature id for the '<em><b>Customization Pipeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOAD_AVERAGE__CUSTOMIZATION_PIPELINE = EXEC_JOB__CUSTOMIZATION_PIPELINE;

    /**
     * The feature id for the '<em><b>Archive Selector</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOAD_AVERAGE__ARCHIVE_SELECTOR = EXEC_JOB__ARCHIVE_SELECTOR;

    /**
     * The feature id for the '<em><b>Master On</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOAD_AVERAGE__MASTER_ON = EXEC_JOB__MASTER_ON;

    /**
     * The feature id for the '<em><b>Runs On</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOAD_AVERAGE__RUNS_ON = EXEC_JOB__RUNS_ON;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOAD_AVERAGE__NAME = EXEC_JOB__NAME;

    /**
     * The number of structural features of the '<em>Load Average</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOAD_AVERAGE_FEATURE_COUNT = EXEC_JOB_FEATURE_COUNT + 0;

    /**
     * The operation id for the '<em>Get Master On</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOAD_AVERAGE___GET_MASTER_ON = EXEC_JOB___GET_MASTER_ON;

    /**
     * The operation id for the '<em>Has Exec Driver</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOAD_AVERAGE___HAS_EXEC_DRIVER__DIAGNOSTICCHAIN_MAP = EXEC_JOB___HAS_EXEC_DRIVER__DIAGNOSTICCHAIN_MAP;

    /**
     * The number of operations of the '<em>Load Average</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOAD_AVERAGE_OPERATION_COUNT = EXEC_JOB_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.exec.impl.LoadAverageConfigurationImpl <em>Load Average Configuration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.exec.impl.LoadAverageConfigurationImpl
     * @see org.eclipse.scada.configuration.component.exec.impl.ExecComponentsPackageImpl#getLoadAverageConfiguration()
     * @generated
     */
    int LOAD_AVERAGE_CONFIGURATION = 2;

    /**
     * The feature id for the '<em><b>Period</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOAD_AVERAGE_CONFIGURATION__PERIOD = ComponentPackage.CONFIGURATION_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Pattern</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOAD_AVERAGE_CONFIGURATION__PATTERN = ComponentPackage.CONFIGURATION_FEATURE_COUNT + 1;

    /**
     * The number of structural features of the '<em>Load Average Configuration</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOAD_AVERAGE_CONFIGURATION_FEATURE_COUNT = ComponentPackage.CONFIGURATION_FEATURE_COUNT + 2;

    /**
     * The number of operations of the '<em>Load Average Configuration</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int LOAD_AVERAGE_CONFIGURATION_OPERATION_COUNT = ComponentPackage.CONFIGURATION_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.exec.impl.PingCheckImpl <em>Ping Check</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.exec.impl.PingCheckImpl
     * @see org.eclipse.scada.configuration.component.exec.impl.ExecComponentsPackageImpl#getPingCheck()
     * @generated
     */
    int PING_CHECK = 3;

    /**
     * The feature id for the '<em><b>Level</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PING_CHECK__LEVEL = EXEC_JOB__LEVEL;

    /**
     * The feature id for the '<em><b>Customization Pipeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PING_CHECK__CUSTOMIZATION_PIPELINE = EXEC_JOB__CUSTOMIZATION_PIPELINE;

    /**
     * The feature id for the '<em><b>Archive Selector</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PING_CHECK__ARCHIVE_SELECTOR = EXEC_JOB__ARCHIVE_SELECTOR;

    /**
     * The feature id for the '<em><b>Master On</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PING_CHECK__MASTER_ON = EXEC_JOB__MASTER_ON;

    /**
     * The feature id for the '<em><b>Runs On</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PING_CHECK__RUNS_ON = EXEC_JOB__RUNS_ON;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PING_CHECK__NAME = EXEC_JOB__NAME;

    /**
     * The feature id for the '<em><b>Node</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PING_CHECK__NODE = EXEC_JOB_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Ping Check</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PING_CHECK_FEATURE_COUNT = EXEC_JOB_FEATURE_COUNT + 1;

    /**
     * The operation id for the '<em>Get Master On</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PING_CHECK___GET_MASTER_ON = EXEC_JOB___GET_MASTER_ON;

    /**
     * The operation id for the '<em>Has Exec Driver</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PING_CHECK___HAS_EXEC_DRIVER__DIAGNOSTICCHAIN_MAP = EXEC_JOB___HAS_EXEC_DRIVER__DIAGNOSTICCHAIN_MAP;

    /**
     * The number of operations of the '<em>Ping Check</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PING_CHECK_OPERATION_COUNT = EXEC_JOB_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.exec.impl.PingCheckConfigurationImpl <em>Ping Check Configuration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.exec.impl.PingCheckConfigurationImpl
     * @see org.eclipse.scada.configuration.component.exec.impl.ExecComponentsPackageImpl#getPingCheckConfiguration()
     * @generated
     */
    int PING_CHECK_CONFIGURATION = 4;

    /**
     * The feature id for the '<em><b>Ping Delay</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PING_CHECK_CONFIGURATION__PING_DELAY = ComponentPackage.CONFIGURATION_FEATURE_COUNT + 0;

    /**
     * The number of structural features of the '<em>Ping Check Configuration</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PING_CHECK_CONFIGURATION_FEATURE_COUNT = ComponentPackage.CONFIGURATION_FEATURE_COUNT + 1;

    /**
     * The number of operations of the '<em>Ping Check Configuration</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int PING_CHECK_CONFIGURATION_OPERATION_COUNT = ComponentPackage.CONFIGURATION_OPERATION_COUNT + 0;

    /**
     * The meta object id for the '{@link org.eclipse.scada.configuration.component.exec.impl.SystemInformationVMStatImpl <em>System Information VM Stat</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.scada.configuration.component.exec.impl.SystemInformationVMStatImpl
     * @see org.eclipse.scada.configuration.component.exec.impl.ExecComponentsPackageImpl#getSystemInformationVMStat()
     * @generated
     */
    int SYSTEM_INFORMATION_VM_STAT = 5;

    /**
     * The feature id for the '<em><b>Level</b></em>' container reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_INFORMATION_VM_STAT__LEVEL = EXEC_JOB__LEVEL;

    /**
     * The feature id for the '<em><b>Customization Pipeline</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_INFORMATION_VM_STAT__CUSTOMIZATION_PIPELINE = EXEC_JOB__CUSTOMIZATION_PIPELINE;

    /**
     * The feature id for the '<em><b>Archive Selector</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_INFORMATION_VM_STAT__ARCHIVE_SELECTOR = EXEC_JOB__ARCHIVE_SELECTOR;

    /**
     * The feature id for the '<em><b>Master On</b></em>' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_INFORMATION_VM_STAT__MASTER_ON = EXEC_JOB__MASTER_ON;

    /**
     * The feature id for the '<em><b>Runs On</b></em>' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_INFORMATION_VM_STAT__RUNS_ON = EXEC_JOB__RUNS_ON;

    /**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_INFORMATION_VM_STAT__NAME = EXEC_JOB__NAME;

    /**
     * The number of structural features of the '<em>System Information VM Stat</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_INFORMATION_VM_STAT_FEATURE_COUNT = EXEC_JOB_FEATURE_COUNT + 0;

    /**
     * The operation id for the '<em>Get Master On</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_INFORMATION_VM_STAT___GET_MASTER_ON = EXEC_JOB___GET_MASTER_ON;

    /**
     * The operation id for the '<em>Has Exec Driver</em>' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_INFORMATION_VM_STAT___HAS_EXEC_DRIVER__DIAGNOSTICCHAIN_MAP = EXEC_JOB___HAS_EXEC_DRIVER__DIAGNOSTICCHAIN_MAP;

    /**
     * The number of operations of the '<em>System Information VM Stat</em>' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int SYSTEM_INFORMATION_VM_STAT_OPERATION_COUNT = EXEC_JOB_OPERATION_COUNT + 0;

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.exec.ExecJob <em>Exec Job</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Exec Job</em>'.
     * @see org.eclipse.scada.configuration.component.exec.ExecJob
     * @generated
     */
    EClass getExecJob ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.component.exec.ExecJob#getRunsOn <em>Runs On</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Runs On</em>'.
     * @see org.eclipse.scada.configuration.component.exec.ExecJob#getRunsOn()
     * @see #getExecJob()
     * @generated
     */
    EReference getExecJob_RunsOn ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.exec.ExecJob#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see org.eclipse.scada.configuration.component.exec.ExecJob#getName()
     * @see #getExecJob()
     * @generated
     */
    EAttribute getExecJob_Name ();

    /**
     * Returns the meta object for the '{@link org.eclipse.scada.configuration.component.exec.ExecJob#hasExecDriver(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Has Exec Driver</em>}' operation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the '<em>Has Exec Driver</em>' operation.
     * @see org.eclipse.scada.configuration.component.exec.ExecJob#hasExecDriver(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * @generated
     */
    EOperation getExecJob__HasExecDriver__DiagnosticChain_Map ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.exec.LoadAverage <em>Load Average</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Load Average</em>'.
     * @see org.eclipse.scada.configuration.component.exec.LoadAverage
     * @generated
     */
    EClass getLoadAverage ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.exec.LoadAverageConfiguration <em>Load Average Configuration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Load Average Configuration</em>'.
     * @see org.eclipse.scada.configuration.component.exec.LoadAverageConfiguration
     * @generated
     */
    EClass getLoadAverageConfiguration ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.exec.LoadAverageConfiguration#getPeriod <em>Period</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Period</em>'.
     * @see org.eclipse.scada.configuration.component.exec.LoadAverageConfiguration#getPeriod()
     * @see #getLoadAverageConfiguration()
     * @generated
     */
    EAttribute getLoadAverageConfiguration_Period ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.exec.LoadAverageConfiguration#getPattern <em>Pattern</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Pattern</em>'.
     * @see org.eclipse.scada.configuration.component.exec.LoadAverageConfiguration#getPattern()
     * @see #getLoadAverageConfiguration()
     * @generated
     */
    EAttribute getLoadAverageConfiguration_Pattern ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.exec.PingCheck <em>Ping Check</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ping Check</em>'.
     * @see org.eclipse.scada.configuration.component.exec.PingCheck
     * @generated
     */
    EClass getPingCheck ();

    /**
     * Returns the meta object for the reference '{@link org.eclipse.scada.configuration.component.exec.PingCheck#getNode <em>Node</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Node</em>'.
     * @see org.eclipse.scada.configuration.component.exec.PingCheck#getNode()
     * @see #getPingCheck()
     * @generated
     */
    EReference getPingCheck_Node ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.exec.PingCheckConfiguration <em>Ping Check Configuration</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>Ping Check Configuration</em>'.
     * @see org.eclipse.scada.configuration.component.exec.PingCheckConfiguration
     * @generated
     */
    EClass getPingCheckConfiguration ();

    /**
     * Returns the meta object for the attribute '{@link org.eclipse.scada.configuration.component.exec.PingCheckConfiguration#getPingDelay <em>Ping Delay</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Ping Delay</em>'.
     * @see org.eclipse.scada.configuration.component.exec.PingCheckConfiguration#getPingDelay()
     * @see #getPingCheckConfiguration()
     * @generated
     */
    EAttribute getPingCheckConfiguration_PingDelay ();

    /**
     * Returns the meta object for class '{@link org.eclipse.scada.configuration.component.exec.SystemInformationVMStat <em>System Information VM Stat</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for class '<em>System Information VM Stat</em>'.
     * @see org.eclipse.scada.configuration.component.exec.SystemInformationVMStat
     * @generated
     */
    EClass getSystemInformationVMStat ();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
    ExecComponentsFactory getExecComponentsFactory ();

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
    interface Literals
    {
        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.exec.impl.ExecJobImpl <em>Exec Job</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.exec.impl.ExecJobImpl
         * @see org.eclipse.scada.configuration.component.exec.impl.ExecComponentsPackageImpl#getExecJob()
         * @generated
         */
        EClass EXEC_JOB = eINSTANCE.getExecJob ();

        /**
         * The meta object literal for the '<em><b>Runs On</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference EXEC_JOB__RUNS_ON = eINSTANCE.getExecJob_RunsOn ();

        /**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute EXEC_JOB__NAME = eINSTANCE.getExecJob_Name ();

        /**
         * The meta object literal for the '<em><b>Has Exec Driver</b></em>' operation.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EOperation EXEC_JOB___HAS_EXEC_DRIVER__DIAGNOSTICCHAIN_MAP = eINSTANCE.getExecJob__HasExecDriver__DiagnosticChain_Map ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.exec.impl.LoadAverageImpl <em>Load Average</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.exec.impl.LoadAverageImpl
         * @see org.eclipse.scada.configuration.component.exec.impl.ExecComponentsPackageImpl#getLoadAverage()
         * @generated
         */
        EClass LOAD_AVERAGE = eINSTANCE.getLoadAverage ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.exec.impl.LoadAverageConfigurationImpl <em>Load Average Configuration</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.exec.impl.LoadAverageConfigurationImpl
         * @see org.eclipse.scada.configuration.component.exec.impl.ExecComponentsPackageImpl#getLoadAverageConfiguration()
         * @generated
         */
        EClass LOAD_AVERAGE_CONFIGURATION = eINSTANCE.getLoadAverageConfiguration ();

        /**
         * The meta object literal for the '<em><b>Period</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LOAD_AVERAGE_CONFIGURATION__PERIOD = eINSTANCE.getLoadAverageConfiguration_Period ();

        /**
         * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute LOAD_AVERAGE_CONFIGURATION__PATTERN = eINSTANCE.getLoadAverageConfiguration_Pattern ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.exec.impl.PingCheckImpl <em>Ping Check</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.exec.impl.PingCheckImpl
         * @see org.eclipse.scada.configuration.component.exec.impl.ExecComponentsPackageImpl#getPingCheck()
         * @generated
         */
        EClass PING_CHECK = eINSTANCE.getPingCheck ();

        /**
         * The meta object literal for the '<em><b>Node</b></em>' reference feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EReference PING_CHECK__NODE = eINSTANCE.getPingCheck_Node ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.exec.impl.PingCheckConfigurationImpl <em>Ping Check Configuration</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.exec.impl.PingCheckConfigurationImpl
         * @see org.eclipse.scada.configuration.component.exec.impl.ExecComponentsPackageImpl#getPingCheckConfiguration()
         * @generated
         */
        EClass PING_CHECK_CONFIGURATION = eINSTANCE.getPingCheckConfiguration ();

        /**
         * The meta object literal for the '<em><b>Ping Delay</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute PING_CHECK_CONFIGURATION__PING_DELAY = eINSTANCE.getPingCheckConfiguration_PingDelay ();

        /**
         * The meta object literal for the '{@link org.eclipse.scada.configuration.component.exec.impl.SystemInformationVMStatImpl <em>System Information VM Stat</em>}' class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @see org.eclipse.scada.configuration.component.exec.impl.SystemInformationVMStatImpl
         * @see org.eclipse.scada.configuration.component.exec.impl.ExecComponentsPackageImpl#getSystemInformationVMStat()
         * @generated
         */
        EClass SYSTEM_INFORMATION_VM_STAT = eINSTANCE.getSystemInformationVMStat ();

    }

} //ExecComponentsPackage
