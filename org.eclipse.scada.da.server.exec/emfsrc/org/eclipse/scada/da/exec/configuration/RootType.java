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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.RootType#getGroup <em>Group</em>}</li>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.RootType#getQueue <em>Queue</em>}</li>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.RootType#getCommand <em>Command</em>}</li>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.RootType#getHiveProcess <em>Hive Process</em>}</li>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.RootType#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.RootType#getAdditionalConfigurationDirectory <em>Additional Configuration Directory</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getRootType()
 * @model extendedMetaData="name='RootType' kind='elementOnly'"
 * @generated
 */
public interface RootType extends EObject
{

    /**
     * Returns the value of the '<em><b>Group</b></em>' attribute list.
     * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Group</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Group</em>' attribute list.
     * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getRootType_Group()
     * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
     *        extendedMetaData="kind='group' name='group:0'"
     * @generated
     */
    FeatureMap getGroup ();

    /**
     * Returns the value of the '<em><b>Queue</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.da.exec.configuration.QueueType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Queue</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Queue</em>' containment reference list.
     * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getRootType_Queue()
     * @model containment="true" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='queue' namespace='##targetNamespace' group='#group:0'"
     * @generated
     */
    EList<QueueType> getQueue ();

    /**
     * Returns the value of the '<em><b>Command</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.da.exec.configuration.SplitContinuousCommandType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Command</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Command</em>' containment reference list.
     * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getRootType_Command()
     * @model containment="true" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='command' namespace='##targetNamespace' group='#group:0'"
     * @generated
     */
    EList<SplitContinuousCommandType> getCommand ();

    /**
     * Returns the value of the '<em><b>Hive Process</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.da.exec.configuration.HiveProcessCommandType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Hive Process</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Hive Process</em>' containment reference list.
     * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getRootType_HiveProcess()
     * @model containment="true" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='hiveProcess' namespace='##targetNamespace' group='#group:0'"
     * @generated
     */
    EList<HiveProcessCommandType> getHiveProcess ();

    /**
     * Returns the value of the '<em><b>Trigger</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.da.exec.configuration.TriggerCommandType}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Trigger</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Trigger</em>' containment reference list.
     * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getRootType_Trigger()
     * @model containment="true" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='trigger' namespace='##targetNamespace' group='#group:0'"
     * @generated
     */
    EList<TriggerCommandType> getTrigger ();

    /**
     * Returns the value of the '<em><b>Additional Configuration Directory</b></em>' attribute list.
     * The list contents are of type {@link java.lang.String}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Additional Configuration Directory</em>' attribute list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Additional Configuration Directory</em>' attribute list.
     * @see org.eclipse.scada.da.exec.configuration.ConfigurationPackage#getRootType_AdditionalConfigurationDirectory()
     * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" transient="true" volatile="true" derived="true"
     *        extendedMetaData="kind='element' name='additionalConfigurationDirectory' namespace='##targetNamespace' group='#group:0'"
     * @generated
     */
    EList<String> getAdditionalConfigurationDirectory ();

} // RootType
