/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.component.providers;

import org.eclipse.emf.common.notify.Adapter;

import org.eclipse.scada.configuration.component.util.ComponentAdapterFactory;

/**
 * @author IBH SYSTEMS GmbH
 * 
 */
public class ComponentEEFAdapterFactory extends ComponentAdapterFactory {

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.scada.configuration.component.util.ComponentAdapterFactory#createComponentWorldAdapter()
	 * 
	 */
	public Adapter createComponentWorldAdapter() {
		return new ComponentWorldPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.scada.configuration.component.util.ComponentAdapterFactory#createLevelAdapter()
	 * 
	 */
	public Adapter createLevelAdapter() {
		return new LevelPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.scada.configuration.component.util.ComponentAdapterFactory#createMasterComponentAdapter()
	 * 
	 */
	public Adapter createMasterComponentAdapter() {
		return new MasterComponentPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.scada.configuration.component.util.ComponentAdapterFactory#createConstantValueAdapter()
	 * 
	 */
	public Adapter createConstantValueAdapter() {
		return new ConstantValuePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.scada.configuration.component.util.ComponentAdapterFactory#createMarkerConfigurationAdapter()
	 * 
	 */
	public Adapter createMarkerConfigurationAdapter() {
		return new MarkerConfigurationPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.scada.configuration.component.util.ComponentAdapterFactory#createPersistentValueAdapter()
	 * 
	 */
	public Adapter createPersistentValueAdapter() {
		return new PersistentValuePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.scada.configuration.component.util.ComponentAdapterFactory#createDriverConnectionAnalyzerAdapter()
	 * 
	 */
	public Adapter createDriverConnectionAnalyzerAdapter() {
		return new DriverConnectionAnalyzerPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.scada.configuration.component.util.ComponentAdapterFactory#createMasterImportConnectionAnalyzerAdapter()
	 * 
	 */
	public Adapter createMasterImportConnectionAnalyzerAdapter() {
		return new MasterImportConnectionAnalyzerPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.scada.configuration.component.util.ComponentAdapterFactory#createDataMapperAnalyzerAdapter()
	 * 
	 */
	public Adapter createDataMapperAnalyzerAdapter() {
		return new DataMapperAnalyzerPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.scada.configuration.component.util.ComponentAdapterFactory#createDataMapperServiceAdapter()
	 * 
	 */
	public Adapter createDataMapperServiceAdapter() {
		return new DataMapperServicePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.scada.configuration.component.util.ComponentAdapterFactory#createMappedSourceValueAdapter()
	 * 
	 */
	public Adapter createMappedSourceValueAdapter() {
		return new MappedSourceValuePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.scada.configuration.component.util.ComponentAdapterFactory#createCalculationComponentAdapter()
	 * 
	 */
	public Adapter createCalculationComponentAdapter() {
		return new CalculationComponentPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.scada.configuration.component.util.ComponentAdapterFactory#createInputSpecificationAdapter()
	 * 
	 */
	public Adapter createInputSpecificationAdapter() {
		return new InputSpecificationPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.scada.configuration.component.util.ComponentAdapterFactory#createOutputSpecificationAdapter()
	 * 
	 */
	public Adapter createOutputSpecificationAdapter() {
		return new OutputSpecificationPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.scada.configuration.component.util.ComponentAdapterFactory#createOutputDefinitionAdapter()
	 * 
	 */
	public Adapter createOutputDefinitionAdapter() {
		return new OutputDefinitionPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.scada.configuration.component.util.ComponentAdapterFactory#createItemReferenceInputDefinitionAdapter()
	 * 
	 */
	public Adapter createItemReferenceInputDefinitionAdapter() {
		return new ItemReferenceInputDefinitionPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.scada.configuration.component.util.ComponentAdapterFactory#createComponentReferenceInputDefinitionAdapter()
	 * 
	 */
	public Adapter createComponentReferenceInputDefinitionAdapter() {
		return new ComponentReferenceInputDefinitionPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.scada.configuration.component.util.ComponentAdapterFactory#createFormulaModuleAdapter()
	 * 
	 */
	public Adapter createFormulaModuleAdapter() {
		return new FormulaModulePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.scada.configuration.component.util.ComponentAdapterFactory#createAverageModuleAdapter()
	 * 
	 */
	public Adapter createAverageModuleAdapter() {
		return new AverageModulePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.scada.configuration.component.util.ComponentAdapterFactory#createScriptModuleAdapter()
	 * 
	 */
	public Adapter createScriptModuleAdapter() {
		return new ScriptModulePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.scada.configuration.component.util.ComponentAdapterFactory#createScriptAdapter()
	 * 
	 */
	public Adapter createScriptAdapter() {
		return new ScriptPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.scada.configuration.component.util.ComponentAdapterFactory#createAbsoluteDanglingReferenceAdapter()
	 * 
	 */
	public Adapter createAbsoluteDanglingReferenceAdapter() {
		return new AbsoluteDanglingReferencePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.scada.configuration.component.util.ComponentAdapterFactory#createComponentDanglingReferenceAdapter()
	 * 
	 */
	public Adapter createComponentDanglingReferenceAdapter() {
		return new ComponentDanglingReferencePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.scada.configuration.component.util.ComponentAdapterFactory#createExternalValueAdapter()
	 * 
	 */
	public Adapter createExternalValueAdapter() {
		return new ExternalValuePropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.scada.configuration.component.util.ComponentAdapterFactory#createSummariesConfigurationAdapter()
	 * 
	 */
	public Adapter createSummariesConfigurationAdapter() {
		return new SummariesConfigurationPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.scada.configuration.component.util.ComponentAdapterFactory#createRestInterceptorAdapter()
	 * 
	 */
	public Adapter createRestInterceptorAdapter() {
		return new RestInterceptorPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.scada.configuration.component.util.ComponentAdapterFactory#createGlobalizeComponentAdapter()
	 * 
	 */
	public Adapter createGlobalizeComponentAdapter() {
		return new GlobalizeComponentPropertiesEditionProvider();
	}
	/**
	 * {@inheritDoc}
	 * @see org.eclipse.scada.configuration.component.util.ComponentAdapterFactory#createTransientValueAdapter()
	 * 
	 */
	public Adapter createTransientValueAdapter() {
		return new TransientValuePropertiesEditionProvider();
	}

}
