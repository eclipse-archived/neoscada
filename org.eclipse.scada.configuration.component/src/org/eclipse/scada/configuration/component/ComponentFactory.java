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
package org.eclipse.scada.configuration.component;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.component.ComponentPackage
 * @generated
 */
public interface ComponentFactory extends EFactory
{
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ComponentFactory eINSTANCE = org.eclipse.scada.configuration.component.impl.ComponentFactoryImpl.init ();

    /**
     * Returns a new object of class '<em>World</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>World</em>'.
     * @generated
     */
    ComponentWorld createComponentWorld ();

    /**
     * Returns a new object of class '<em>Level</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Level</em>'.
     * @generated
     */
    Level createLevel ();

    /**
     * Returns a new object of class '<em>Constant Value</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Constant Value</em>'.
     * @generated
     */
    ConstantValue createConstantValue ();

    /**
     * Returns a new object of class '<em>Marker Configuration</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Marker Configuration</em>'.
     * @generated
     */
    MarkerConfiguration createMarkerConfiguration ();

    /**
     * Returns a new object of class '<em>Persistent Value</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Persistent Value</em>'.
     * @generated
     */
    PersistentValue createPersistentValue ();

    /**
     * Returns a new object of class '<em>Driver Connection Analyzer</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Driver Connection Analyzer</em>'.
     * @generated
     */
    DriverConnectionAnalyzer createDriverConnectionAnalyzer ();

    /**
     * Returns a new object of class '<em>Master Import Connection Analyzer</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Master Import Connection Analyzer</em>'.
     * @generated
     */
    MasterImportConnectionAnalyzer createMasterImportConnectionAnalyzer ();

    /**
     * Returns a new object of class '<em>Data Mapper Analyzer</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Data Mapper Analyzer</em>'.
     * @generated
     */
    DataMapperAnalyzer createDataMapperAnalyzer ();

    /**
     * Returns a new object of class '<em>Data Mapper Service</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Data Mapper Service</em>'.
     * @generated
     */
    DataMapperService createDataMapperService ();

    /**
     * Returns a new object of class '<em>Mapped Source Value</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Mapped Source Value</em>'.
     * @generated
     */
    MappedSourceValue createMappedSourceValue ();

    /**
     * Returns a new object of class '<em>Calculation Component</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Calculation Component</em>'.
     * @generated
     */
    CalculationComponent createCalculationComponent ();

    /**
     * Returns a new object of class '<em>Input Specification</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Input Specification</em>'.
     * @generated
     */
    InputSpecification createInputSpecification ();

    /**
     * Returns a new object of class '<em>Output Specification</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Output Specification</em>'.
     * @generated
     */
    OutputSpecification createOutputSpecification ();

    /**
     * Returns a new object of class '<em>Output Definition</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Output Definition</em>'.
     * @generated
     */
    OutputDefinition createOutputDefinition ();

    /**
     * Returns a new object of class '<em>Item Reference Input Definition</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Item Reference Input Definition</em>'.
     * @generated
     */
    ItemReferenceInputDefinition createItemReferenceInputDefinition ();

    /**
     * Returns a new object of class '<em>Item Reference Output Definition</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Item Reference Output Definition</em>'.
     * @generated
     */
    ItemReferenceOutputDefinition createItemReferenceOutputDefinition ();

    /**
     * Returns a new object of class '<em>Reference Input Definition</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Reference Input Definition</em>'.
     * @generated
     */
    ComponentReferenceInputDefinition createComponentReferenceInputDefinition ();

    /**
     * Returns a new object of class '<em>Formula Module</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Formula Module</em>'.
     * @generated
     */
    FormulaModule createFormulaModule ();

    /**
     * Returns a new object of class '<em>Average Module</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Average Module</em>'.
     * @generated
     */
    AverageModule createAverageModule ();

    /**
     * Returns a new object of class '<em>Script Module</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Script Module</em>'.
     * @generated
     */
    ScriptModule createScriptModule ();

    /**
     * Returns a new object of class '<em>Script</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Script</em>'.
     * @generated
     */
    Script createScript ();

    /**
     * Returns a new object of class '<em>Timer Script</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Timer Script</em>'.
     * @generated
     */
    TimerScript createTimerScript ();

    /**
     * Returns a new object of class '<em>Absolute Dangling Reference</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Absolute Dangling Reference</em>'.
     * @generated
     */
    AbsoluteDanglingReference createAbsoluteDanglingReference ();

    /**
     * Returns a new object of class '<em>Dangling Reference</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Dangling Reference</em>'.
     * @generated
     */
    ComponentDanglingReference createComponentDanglingReference ();

    /**
     * Returns a new object of class '<em>External Value</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>External Value</em>'.
     * @generated
     */
    ExternalValue createExternalValue ();

    /**
     * Returns a new object of class '<em>Summaries Configuration</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Summaries Configuration</em>'.
     * @generated
     */
    SummariesConfiguration createSummariesConfiguration ();

    /**
     * Returns a new object of class '<em>Rest Interceptor</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Rest Interceptor</em>'.
     * @generated
     */
    RestInterceptor createRestInterceptor ();

    /**
     * Returns a new object of class '<em>Globalize Component</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Globalize Component</em>'.
     * @generated
     */
    GlobalizeComponent createGlobalizeComponent ();

    /**
     * Returns a new object of class '<em>Transient Value</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Transient Value</em>'.
     * @generated
     */
    TransientValue createTransientValue ();

    /**
     * Returns a new object of class '<em>Master Component</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Master Component</em>'.
     * @generated
     */
    MasterComponent createMasterComponent ();

    /**
     * Returns a new object of class '<em>Buffered Value</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Buffered Value</em>'.
     * @generated
     */
    BufferedValue createBufferedValue ();

    /**
     * Returns a new object of class '<em>Change Counter</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Change Counter</em>'.
     * @generated
     */
    ChangeCounter createChangeCounter ();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    ComponentPackage getComponentPackage ();

} //ComponentFactory
