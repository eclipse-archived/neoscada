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

import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;

import org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart;

import org.eclipse.emf.eef.runtime.api.providers.IPropertiesEditionPartProvider;

import org.eclipse.scada.configuration.component.parts.ComponentViewsRepository;

import org.eclipse.scada.configuration.component.parts.forms.AbsoluteDanglingReferencePropertiesEditionPartForm;
import org.eclipse.scada.configuration.component.parts.forms.AverageModulePropertiesEditionPartForm;
import org.eclipse.scada.configuration.component.parts.forms.CalculationComponentPropertiesEditionPartForm;
import org.eclipse.scada.configuration.component.parts.forms.ComponentDanglingReferencePropertiesEditionPartForm;
import org.eclipse.scada.configuration.component.parts.forms.ComponentReferenceInputDefinitionPropertiesEditionPartForm;
import org.eclipse.scada.configuration.component.parts.forms.ComponentWorldPropertiesEditionPartForm;
import org.eclipse.scada.configuration.component.parts.forms.ConstantValuePropertiesEditionPartForm;
import org.eclipse.scada.configuration.component.parts.forms.DataMapperAnalyzerPropertiesEditionPartForm;
import org.eclipse.scada.configuration.component.parts.forms.DataMapperServicePropertiesEditionPartForm;
import org.eclipse.scada.configuration.component.parts.forms.DriverConnectionAnalyzerPropertiesEditionPartForm;
import org.eclipse.scada.configuration.component.parts.forms.ExternalValuePropertiesEditionPartForm;
import org.eclipse.scada.configuration.component.parts.forms.FormulaModulePropertiesEditionPartForm;
import org.eclipse.scada.configuration.component.parts.forms.GlobalizeComponentPropertiesEditionPartForm;
import org.eclipse.scada.configuration.component.parts.forms.InputSpecificationPropertiesEditionPartForm;
import org.eclipse.scada.configuration.component.parts.forms.ItemReferenceInputDefinitionPropertiesEditionPartForm;
import org.eclipse.scada.configuration.component.parts.forms.LevelPropertiesEditionPartForm;
import org.eclipse.scada.configuration.component.parts.forms.MappedSourceValuePropertiesEditionPartForm;
import org.eclipse.scada.configuration.component.parts.forms.MarkerConfigurationPropertiesEditionPartForm;
import org.eclipse.scada.configuration.component.parts.forms.MasterComponentPropertiesEditionPartForm;
import org.eclipse.scada.configuration.component.parts.forms.MasterImportConnectionAnalyzerPropertiesEditionPartForm;
import org.eclipse.scada.configuration.component.parts.forms.OutputDefinitionPropertiesEditionPartForm;
import org.eclipse.scada.configuration.component.parts.forms.OutputSpecificationPropertiesEditionPartForm;
import org.eclipse.scada.configuration.component.parts.forms.PersistentValuePropertiesEditionPartForm;
import org.eclipse.scada.configuration.component.parts.forms.RestInterceptorPropertiesEditionPartForm;
import org.eclipse.scada.configuration.component.parts.forms.ScriptModulePropertiesEditionPartForm;
import org.eclipse.scada.configuration.component.parts.forms.ScriptPropertiesEditionPartForm;
import org.eclipse.scada.configuration.component.parts.forms.SummariesConfigurationPropertiesEditionPartForm;
import org.eclipse.scada.configuration.component.parts.forms.TransientValuePropertiesEditionPartForm;

import org.eclipse.scada.configuration.component.parts.impl.AbsoluteDanglingReferencePropertiesEditionPartImpl;
import org.eclipse.scada.configuration.component.parts.impl.AverageModulePropertiesEditionPartImpl;
import org.eclipse.scada.configuration.component.parts.impl.CalculationComponentPropertiesEditionPartImpl;
import org.eclipse.scada.configuration.component.parts.impl.ComponentDanglingReferencePropertiesEditionPartImpl;
import org.eclipse.scada.configuration.component.parts.impl.ComponentReferenceInputDefinitionPropertiesEditionPartImpl;
import org.eclipse.scada.configuration.component.parts.impl.ComponentWorldPropertiesEditionPartImpl;
import org.eclipse.scada.configuration.component.parts.impl.ConstantValuePropertiesEditionPartImpl;
import org.eclipse.scada.configuration.component.parts.impl.DataMapperAnalyzerPropertiesEditionPartImpl;
import org.eclipse.scada.configuration.component.parts.impl.DataMapperServicePropertiesEditionPartImpl;
import org.eclipse.scada.configuration.component.parts.impl.DriverConnectionAnalyzerPropertiesEditionPartImpl;
import org.eclipse.scada.configuration.component.parts.impl.ExternalValuePropertiesEditionPartImpl;
import org.eclipse.scada.configuration.component.parts.impl.FormulaModulePropertiesEditionPartImpl;
import org.eclipse.scada.configuration.component.parts.impl.GlobalizeComponentPropertiesEditionPartImpl;
import org.eclipse.scada.configuration.component.parts.impl.InputSpecificationPropertiesEditionPartImpl;
import org.eclipse.scada.configuration.component.parts.impl.ItemReferenceInputDefinitionPropertiesEditionPartImpl;
import org.eclipse.scada.configuration.component.parts.impl.LevelPropertiesEditionPartImpl;
import org.eclipse.scada.configuration.component.parts.impl.MappedSourceValuePropertiesEditionPartImpl;
import org.eclipse.scada.configuration.component.parts.impl.MarkerConfigurationPropertiesEditionPartImpl;
import org.eclipse.scada.configuration.component.parts.impl.MasterComponentPropertiesEditionPartImpl;
import org.eclipse.scada.configuration.component.parts.impl.MasterImportConnectionAnalyzerPropertiesEditionPartImpl;
import org.eclipse.scada.configuration.component.parts.impl.OutputDefinitionPropertiesEditionPartImpl;
import org.eclipse.scada.configuration.component.parts.impl.OutputSpecificationPropertiesEditionPartImpl;
import org.eclipse.scada.configuration.component.parts.impl.PersistentValuePropertiesEditionPartImpl;
import org.eclipse.scada.configuration.component.parts.impl.RestInterceptorPropertiesEditionPartImpl;
import org.eclipse.scada.configuration.component.parts.impl.ScriptModulePropertiesEditionPartImpl;
import org.eclipse.scada.configuration.component.parts.impl.ScriptPropertiesEditionPartImpl;
import org.eclipse.scada.configuration.component.parts.impl.SummariesConfigurationPropertiesEditionPartImpl;
import org.eclipse.scada.configuration.component.parts.impl.TransientValuePropertiesEditionPartImpl;

/**
 * @author IBH SYSTEMS GmbH
 * 
 */
public class ComponentPropertiesEditionPartProvider implements IPropertiesEditionPartProvider {

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#provides(java.lang.Object)
	 * 
	 */
	public boolean provides(Object key) {
		return key == ComponentViewsRepository.class;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPartProvider#getPropertiesEditionPart(java.lang.Object, int, org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent)
	 * 
	 */
	public IPropertiesEditionPart getPropertiesEditionPart(Object key, int kind, IPropertiesEditionComponent component) {
		if (key == ComponentViewsRepository.ComponentWorld.class) {
			if (kind == ComponentViewsRepository.SWT_KIND)
				return new ComponentWorldPropertiesEditionPartImpl(component);
			if (kind == ComponentViewsRepository.FORM_KIND)
				return new ComponentWorldPropertiesEditionPartForm(component);
		}
		if (key == ComponentViewsRepository.Level.class) {
			if (kind == ComponentViewsRepository.SWT_KIND)
				return new LevelPropertiesEditionPartImpl(component);
			if (kind == ComponentViewsRepository.FORM_KIND)
				return new LevelPropertiesEditionPartForm(component);
		}
		if (key == ComponentViewsRepository.ConstantValue.class) {
			if (kind == ComponentViewsRepository.SWT_KIND)
				return new ConstantValuePropertiesEditionPartImpl(component);
			if (kind == ComponentViewsRepository.FORM_KIND)
				return new ConstantValuePropertiesEditionPartForm(component);
		}
		if (key == ComponentViewsRepository.MarkerConfiguration.class) {
			if (kind == ComponentViewsRepository.SWT_KIND)
				return new MarkerConfigurationPropertiesEditionPartImpl(component);
			if (kind == ComponentViewsRepository.FORM_KIND)
				return new MarkerConfigurationPropertiesEditionPartForm(component);
		}
		if (key == ComponentViewsRepository.PersistentValue.class) {
			if (kind == ComponentViewsRepository.SWT_KIND)
				return new PersistentValuePropertiesEditionPartImpl(component);
			if (kind == ComponentViewsRepository.FORM_KIND)
				return new PersistentValuePropertiesEditionPartForm(component);
		}
		if (key == ComponentViewsRepository.DriverConnectionAnalyzer.class) {
			if (kind == ComponentViewsRepository.SWT_KIND)
				return new DriverConnectionAnalyzerPropertiesEditionPartImpl(component);
			if (kind == ComponentViewsRepository.FORM_KIND)
				return new DriverConnectionAnalyzerPropertiesEditionPartForm(component);
		}
		if (key == ComponentViewsRepository.MasterImportConnectionAnalyzer.class) {
			if (kind == ComponentViewsRepository.SWT_KIND)
				return new MasterImportConnectionAnalyzerPropertiesEditionPartImpl(component);
			if (kind == ComponentViewsRepository.FORM_KIND)
				return new MasterImportConnectionAnalyzerPropertiesEditionPartForm(component);
		}
		if (key == ComponentViewsRepository.DataMapperAnalyzer.class) {
			if (kind == ComponentViewsRepository.SWT_KIND)
				return new DataMapperAnalyzerPropertiesEditionPartImpl(component);
			if (kind == ComponentViewsRepository.FORM_KIND)
				return new DataMapperAnalyzerPropertiesEditionPartForm(component);
		}
		if (key == ComponentViewsRepository.DataMapperService.class) {
			if (kind == ComponentViewsRepository.SWT_KIND)
				return new DataMapperServicePropertiesEditionPartImpl(component);
			if (kind == ComponentViewsRepository.FORM_KIND)
				return new DataMapperServicePropertiesEditionPartForm(component);
		}
		if (key == ComponentViewsRepository.MappedSourceValue.class) {
			if (kind == ComponentViewsRepository.SWT_KIND)
				return new MappedSourceValuePropertiesEditionPartImpl(component);
			if (kind == ComponentViewsRepository.FORM_KIND)
				return new MappedSourceValuePropertiesEditionPartForm(component);
		}
		if (key == ComponentViewsRepository.CalculationComponent.class) {
			if (kind == ComponentViewsRepository.SWT_KIND)
				return new CalculationComponentPropertiesEditionPartImpl(component);
			if (kind == ComponentViewsRepository.FORM_KIND)
				return new CalculationComponentPropertiesEditionPartForm(component);
		}
		if (key == ComponentViewsRepository.InputSpecification.class) {
			if (kind == ComponentViewsRepository.SWT_KIND)
				return new InputSpecificationPropertiesEditionPartImpl(component);
			if (kind == ComponentViewsRepository.FORM_KIND)
				return new InputSpecificationPropertiesEditionPartForm(component);
		}
		if (key == ComponentViewsRepository.OutputSpecification.class) {
			if (kind == ComponentViewsRepository.SWT_KIND)
				return new OutputSpecificationPropertiesEditionPartImpl(component);
			if (kind == ComponentViewsRepository.FORM_KIND)
				return new OutputSpecificationPropertiesEditionPartForm(component);
		}
		if (key == ComponentViewsRepository.OutputDefinition.class) {
			if (kind == ComponentViewsRepository.SWT_KIND)
				return new OutputDefinitionPropertiesEditionPartImpl(component);
			if (kind == ComponentViewsRepository.FORM_KIND)
				return new OutputDefinitionPropertiesEditionPartForm(component);
		}
		if (key == ComponentViewsRepository.ItemReferenceInputDefinition.class) {
			if (kind == ComponentViewsRepository.SWT_KIND)
				return new ItemReferenceInputDefinitionPropertiesEditionPartImpl(component);
			if (kind == ComponentViewsRepository.FORM_KIND)
				return new ItemReferenceInputDefinitionPropertiesEditionPartForm(component);
		}
		if (key == ComponentViewsRepository.ComponentReferenceInputDefinition.class) {
			if (kind == ComponentViewsRepository.SWT_KIND)
				return new ComponentReferenceInputDefinitionPropertiesEditionPartImpl(component);
			if (kind == ComponentViewsRepository.FORM_KIND)
				return new ComponentReferenceInputDefinitionPropertiesEditionPartForm(component);
		}
		if (key == ComponentViewsRepository.FormulaModule.class) {
			if (kind == ComponentViewsRepository.SWT_KIND)
				return new FormulaModulePropertiesEditionPartImpl(component);
			if (kind == ComponentViewsRepository.FORM_KIND)
				return new FormulaModulePropertiesEditionPartForm(component);
		}
		if (key == ComponentViewsRepository.AverageModule.class) {
			if (kind == ComponentViewsRepository.SWT_KIND)
				return new AverageModulePropertiesEditionPartImpl(component);
			if (kind == ComponentViewsRepository.FORM_KIND)
				return new AverageModulePropertiesEditionPartForm(component);
		}
		if (key == ComponentViewsRepository.ScriptModule.class) {
			if (kind == ComponentViewsRepository.SWT_KIND)
				return new ScriptModulePropertiesEditionPartImpl(component);
			if (kind == ComponentViewsRepository.FORM_KIND)
				return new ScriptModulePropertiesEditionPartForm(component);
		}
		if (key == ComponentViewsRepository.Script.class) {
			if (kind == ComponentViewsRepository.SWT_KIND)
				return new ScriptPropertiesEditionPartImpl(component);
			if (kind == ComponentViewsRepository.FORM_KIND)
				return new ScriptPropertiesEditionPartForm(component);
		}
		if (key == ComponentViewsRepository.AbsoluteDanglingReference.class) {
			if (kind == ComponentViewsRepository.SWT_KIND)
				return new AbsoluteDanglingReferencePropertiesEditionPartImpl(component);
			if (kind == ComponentViewsRepository.FORM_KIND)
				return new AbsoluteDanglingReferencePropertiesEditionPartForm(component);
		}
		if (key == ComponentViewsRepository.ComponentDanglingReference.class) {
			if (kind == ComponentViewsRepository.SWT_KIND)
				return new ComponentDanglingReferencePropertiesEditionPartImpl(component);
			if (kind == ComponentViewsRepository.FORM_KIND)
				return new ComponentDanglingReferencePropertiesEditionPartForm(component);
		}
		if (key == ComponentViewsRepository.ExternalValue.class) {
			if (kind == ComponentViewsRepository.SWT_KIND)
				return new ExternalValuePropertiesEditionPartImpl(component);
			if (kind == ComponentViewsRepository.FORM_KIND)
				return new ExternalValuePropertiesEditionPartForm(component);
		}
		if (key == ComponentViewsRepository.SummariesConfiguration.class) {
			if (kind == ComponentViewsRepository.SWT_KIND)
				return new SummariesConfigurationPropertiesEditionPartImpl(component);
			if (kind == ComponentViewsRepository.FORM_KIND)
				return new SummariesConfigurationPropertiesEditionPartForm(component);
		}
		if (key == ComponentViewsRepository.RestInterceptor.class) {
			if (kind == ComponentViewsRepository.SWT_KIND)
				return new RestInterceptorPropertiesEditionPartImpl(component);
			if (kind == ComponentViewsRepository.FORM_KIND)
				return new RestInterceptorPropertiesEditionPartForm(component);
		}
		if (key == ComponentViewsRepository.GlobalizeComponent.class) {
			if (kind == ComponentViewsRepository.SWT_KIND)
				return new GlobalizeComponentPropertiesEditionPartImpl(component);
			if (kind == ComponentViewsRepository.FORM_KIND)
				return new GlobalizeComponentPropertiesEditionPartForm(component);
		}
		if (key == ComponentViewsRepository.TransientValue.class) {
			if (kind == ComponentViewsRepository.SWT_KIND)
				return new TransientValuePropertiesEditionPartImpl(component);
			if (kind == ComponentViewsRepository.FORM_KIND)
				return new TransientValuePropertiesEditionPartForm(component);
		}
		if (key == ComponentViewsRepository.MasterComponent.class) {
			if (kind == ComponentViewsRepository.SWT_KIND)
				return new MasterComponentPropertiesEditionPartImpl(component);
			if (kind == ComponentViewsRepository.FORM_KIND)
				return new MasterComponentPropertiesEditionPartForm(component);
		}
		return null;
	}

}
