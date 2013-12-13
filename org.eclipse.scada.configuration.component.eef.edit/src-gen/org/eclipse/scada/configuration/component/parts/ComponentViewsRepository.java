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
package org.eclipse.scada.configuration.component.parts;

/**
 * @author IBH SYSTEMS GmbH
 * 
 */
public class ComponentViewsRepository {

	public static final int SWT_KIND = 0;

	public static final int FORM_KIND = 1;


	/**
	 * ComponentWorld view descriptor
	 * 
	 */
	public static class ComponentWorld {
		public static class Properties {
	
			
			public static String itemInterceptors = "component::ComponentWorld::properties::itemInterceptors";
			
			
			public static String configurations = "component::ComponentWorld::properties::configurations";
			
			
			public static String services = "component::ComponentWorld::properties::services";
			
			
			public static String infrastructure = "component::ComponentWorld::properties::infrastructure";
			
			
			public static String defaultCustomizationPipeline = "component::ComponentWorld::properties::defaultCustomizationPipeline";
			
			
			public static String defaultArchiveSelector = "component::ComponentWorld::properties::defaultArchiveSelector";
			
	
		}
	
	}

	/**
	 * Level view descriptor
	 * 
	 */
	public static class Level {
		public static class Properties {
	
			
			public static String itemInterceptors = "component::Level::properties::itemInterceptors";
			
			
			public static String parent_ = "component::Level::properties::parent";
			
			
			public static String customizationPipeline = "component::Level::properties::customizationPipeline";
			
			
			public static String archiveSelector = "component::Level::properties::archiveSelector";
			
			
			public static String name = "component::Level::properties::name";
			
	
		}
	
	}

	/**
	 * ConstantValue view descriptor
	 * 
	 */
	public static class ConstantValue {
		public static class Properties {
	
			
			public static String level = "component::ConstantValue::properties::level";
			
			
			public static String customizationPipeline = "component::ConstantValue::properties::customizationPipeline";
			
			
			public static String archiveSelector = "component::ConstantValue::properties::archiveSelector";
			
			
			public static String masterOn = "component::ConstantValue::properties::masterOn";
			
			
			public static String name = "component::ConstantValue::properties::name";
			
			
			public static String dataType = "component::ConstantValue::properties::dataType";
			
			
			public static String customizationTags = "component::ConstantValue::properties::customizationTags";
			
			
			public static String value = "component::ConstantValue::properties::value";
			
	
		}
	
	}

	/**
	 * MarkerConfiguration view descriptor
	 * 
	 */
	public static class MarkerConfiguration {
		public static class Properties {
	
			
			public static String markers = "component::MarkerConfiguration::properties::markers";
			
	
		}
	
	}

	/**
	 * PersistentValue view descriptor
	 * 
	 */
	public static class PersistentValue {
		public static class Properties {
	
			
			public static String level = "component::PersistentValue::properties::level";
			
			
			public static String customizationPipeline = "component::PersistentValue::properties::customizationPipeline";
			
			
			public static String archiveSelector = "component::PersistentValue::properties::archiveSelector";
			
			
			public static String masterOn = "component::PersistentValue::properties::masterOn";
			
			
			public static String name = "component::PersistentValue::properties::name";
			
			
			public static String dataType = "component::PersistentValue::properties::dataType";
			
			
			public static String customizationTags = "component::PersistentValue::properties::customizationTags";
			
	
		}
	
	}

	/**
	 * DriverConnectionAnalyzer view descriptor
	 * 
	 */
	public static class DriverConnectionAnalyzer {
		public static class Properties {
	
			
			public static String level = "component::DriverConnectionAnalyzer::properties::level";
			
			
			public static String customizationPipeline = "component::DriverConnectionAnalyzer::properties::customizationPipeline";
			
			
			public static String archiveSelector = "component::DriverConnectionAnalyzer::properties::archiveSelector";
			
			
			public static String masterOn = "component::DriverConnectionAnalyzer::properties::masterOn";
			
			
			public static String connection = "component::DriverConnectionAnalyzer::properties::connection";
			
	
		}
	
	}

	/**
	 * MasterImportConnectionAnalyzer view descriptor
	 * 
	 */
	public static class MasterImportConnectionAnalyzer {
		public static class Properties {
	
			
			public static String level = "component::MasterImportConnectionAnalyzer::properties::level";
			
			
			public static String customizationPipeline = "component::MasterImportConnectionAnalyzer::properties::customizationPipeline";
			
			
			public static String archiveSelector = "component::MasterImportConnectionAnalyzer::properties::archiveSelector";
			
			
			public static String masterOn = "component::MasterImportConnectionAnalyzer::properties::masterOn";
			
			
			public static String connection = "component::MasterImportConnectionAnalyzer::properties::connection";
			
	
		}
	
	}

	/**
	 * DataMapperAnalyzer view descriptor
	 * 
	 */
	public static class DataMapperAnalyzer {
		public static class Properties {
	
			
			public static String level = "component::DataMapperAnalyzer::properties::level";
			
			
			public static String customizationPipeline = "component::DataMapperAnalyzer::properties::customizationPipeline";
			
			
			public static String archiveSelector = "component::DataMapperAnalyzer::properties::archiveSelector";
			
			
			public static String masterOn = "component::DataMapperAnalyzer::properties::masterOn";
			
			
			public static String dataMapper = "component::DataMapperAnalyzer::properties::dataMapper";
			
	
		}
	
	}

	/**
	 * DataMapperService view descriptor
	 * 
	 */
	public static class DataMapperService {
		public static class Properties {
	
			
			public static String masterOn = "component::DataMapperService::properties::masterOn";
			
	
		}
	
	}

	/**
	 * MappedSourceValue view descriptor
	 * 
	 */
	public static class MappedSourceValue {
		public static class Properties {
	
			
			public static String shortDescription = "component::MappedSourceValue::properties::shortDescription";
			
			
			public static String name = "component::MappedSourceValue::properties::name";
			
			
			public static String level = "component::MappedSourceValue::properties::level";
			
			
			public static String customizationPipeline = "component::MappedSourceValue::properties::customizationPipeline";
			
			
			public static String archiveSelector = "component::MappedSourceValue::properties::archiveSelector";
			
			
			public static String masterOn = "component::MappedSourceValue::properties::masterOn";
			
			
			public static String mapper = "component::MappedSourceValue::properties::mapper";
			
	
		}
	
	}

	/**
	 * CalculationComponent view descriptor
	 * 
	 */
	public static class CalculationComponent {
		public static class Properties {
	
			
			public static String shortDescription = "component::CalculationComponent::properties::shortDescription";
			
			
			public static String name = "component::CalculationComponent::properties::name";
			
			
			public static String level = "component::CalculationComponent::properties::level";
			
			
			public static String customizationPipeline = "component::CalculationComponent::properties::customizationPipeline";
			
			
			public static String archiveSelector = "component::CalculationComponent::properties::archiveSelector";
			
			
			public static String masterOn = "component::CalculationComponent::properties::masterOn";
			
			
			public static String implementation = "component::CalculationComponent::properties::implementation";
			
			
			public static String outputs = "component::CalculationComponent::properties::outputs";
			
			
			public static String inputs = "component::CalculationComponent::properties::inputs";
			
	
		}
	
	}

	/**
	 * InputSpecification view descriptor
	 * 
	 */
	public static class InputSpecification {
		public static class Properties {
	
			
			public static String name = "component::InputSpecification::properties::name";
			
	
		}
	
	}

	/**
	 * OutputSpecification view descriptor
	 * 
	 */
	public static class OutputSpecification {
		public static class Properties {
	
			
			public static String name = "component::OutputSpecification::properties::name";
			
			
			public static String dataType = "component::OutputSpecification::properties::dataType";
			
	
		}
	
	}

	/**
	 * OutputDefinition view descriptor
	 * 
	 */
	public static class OutputDefinition {
		public static class Properties {
	
			
			public static String name = "component::OutputDefinition::properties::name";
			
			
			public static String localTag = "component::OutputDefinition::properties::localTag";
			
	
		}
	
	}

	/**
	 * ItemReferenceInputDefinition view descriptor
	 * 
	 */
	public static class ItemReferenceInputDefinition {
		public static class Properties {
	
			
			public static String name = "component::ItemReferenceInputDefinition::properties::name";
			
			
			public static String itemId = "component::ItemReferenceInputDefinition::properties::itemId";
			
	
		}
	
	}

	/**
	 * ComponentReferenceInputDefinition view descriptor
	 * 
	 */
	public static class ComponentReferenceInputDefinition {
		public static class Properties {
	
			
			public static String name = "component::ComponentReferenceInputDefinition::properties::name";
			
			
			public static String component_ = "component::ComponentReferenceInputDefinition::properties::component_";
			
			
			public static String localTag = "component::ComponentReferenceInputDefinition::properties::localTag";
			
	
		}
	
	}

	/**
	 * FormulaModule view descriptor
	 * 
	 */
	public static class FormulaModule {
		public static class Properties {
	
			
			public static String shortDescription = "component::FormulaModule::properties::shortDescription";
			
			
			public static String name = "component::FormulaModule::properties::name";
			
			
			public static String inputs = "component::FormulaModule::properties::inputs";
			
			
			public static String scriptEngine = "component::FormulaModule::properties::scriptEngine";
			
			
			public static String init = "component::FormulaModule::properties::init";
			
	
		}
	
	}

	/**
	 * AverageModule view descriptor
	 * 
	 */
	public static class AverageModule {
		public static class Properties {
	
			
			public static String validSourcesRequired = "component::AverageModule::properties::validSourcesRequired";
			
	
		}
	
	}

	/**
	 * ScriptModule view descriptor
	 * 
	 */
	public static class ScriptModule {
		public static class Properties {
	
			
			public static String shortDescription = "component::ScriptModule::properties::shortDescription";
			
			
			public static String name = "component::ScriptModule::properties::name";
			
			
			public static String inputs = "component::ScriptModule::properties::inputs";
			
			
			public static String outputs = "component::ScriptModule::properties::outputs";
			
			
			public static String scriptEngine = "component::ScriptModule::properties::scriptEngine";
			
	
		}
	
	}

	/**
	 * Script view descriptor
	 * 
	 */
	public static class Script {
		public static class Properties {
	
			
			public static String code = "component::Script::properties::code";
			
	
		}
	
	}

	/**
	 * AbsoluteDanglingReference view descriptor
	 * 
	 */
	public static class AbsoluteDanglingReference {
		public static class Properties {
	
			
			public static String name = "component::AbsoluteDanglingReference::properties::name";
			
	
		}
	
	}

	/**
	 * ComponentDanglingReference view descriptor
	 * 
	 */
	public static class ComponentDanglingReference {
		public static class Properties {
	
			
			public static String name = "component::ComponentDanglingReference::properties::name";
			
			
			public static String localTag = "component::ComponentDanglingReference::properties::localTag";
			
			
			public static String component_ = "component::ComponentDanglingReference::properties::component_";
			
	
		}
	
	}

	/**
	 * ExternalValue view descriptor
	 * 
	 */
	public static class ExternalValue {
		public static class Properties {
	
			
			public static String level = "component::ExternalValue::properties::level";
			
			
			public static String customizationPipeline = "component::ExternalValue::properties::customizationPipeline";
			
			
			public static String archiveSelector = "component::ExternalValue::properties::archiveSelector";
			
			
			public static String masterOn = "component::ExternalValue::properties::masterOn";
			
			
			public static String name = "component::ExternalValue::properties::name";
			
			
			public static String dataType = "component::ExternalValue::properties::dataType";
			
			
			public static String customizationTags = "component::ExternalValue::properties::customizationTags";
			
			
			public static String connection = "component::ExternalValue::properties::connection";
			
			
			public static String sourceName = "component::ExternalValue::properties::sourceName";
			
	
		}
	
	}

	/**
	 * SummariesConfiguration view descriptor
	 * 
	 */
	public static class SummariesConfiguration {
		public static class Properties {
	
			
			public static String itemThreshold = "component::SummariesConfiguration::properties::itemThreshold";
			
	
		}
	
	}

	/**
	 * RestInterceptor view descriptor
	 * 
	 */
	public static class RestInterceptor {
		public static class Properties {
	
			
			public static String masterOn = "component::RestInterceptor::properties::masterOn";
			
			
			public static String definition = "component::RestInterceptor::properties::definition";
			
	
		}
	
	}

	/**
	 * GlobalizeComponent view descriptor
	 * 
	 */
	public static class GlobalizeComponent {
		public static class Properties {
	
			
			public static String shortDescription = "component::GlobalizeComponent::properties::shortDescription";
			
			
			public static String name = "component::GlobalizeComponent::properties::name";
			
			
			public static String level = "component::GlobalizeComponent::properties::level";
			
			
			public static String customizationPipeline = "component::GlobalizeComponent::properties::customizationPipeline";
			
			
			public static String archiveSelector = "component::GlobalizeComponent::properties::archiveSelector";
			
			
			public static String components = "component::GlobalizeComponent::properties::components";
			
			
			public static String sourceMaster = "component::GlobalizeComponent::properties::sourceMaster";
			
	
		}
	
	}

	/**
	 * TransientValue view descriptor
	 * 
	 */
	public static class TransientValue {
		public static class Properties {
	
			
			public static String level = "component::TransientValue::properties::level";
			
			
			public static String customizationPipeline = "component::TransientValue::properties::customizationPipeline";
			
			
			public static String archiveSelector = "component::TransientValue::properties::archiveSelector";
			
			
			public static String masterOn = "component::TransientValue::properties::masterOn";
			
			
			public static String name = "component::TransientValue::properties::name";
			
			
			public static String dataType = "component::TransientValue::properties::dataType";
			
			
			public static String customizationTags = "component::TransientValue::properties::customizationTags";
			
	
		}
	
	}

	/**
	 * MasterComponent view descriptor
	 * 
	 */
	public static class MasterComponent {
		public static class Properties {
	
			
			public static String level = "component::MasterComponent::properties::level";
			
			
			public static String customizationPipeline = "component::MasterComponent::properties::customizationPipeline";
			
			
			public static String archiveSelector = "component::MasterComponent::properties::archiveSelector";
			
			
			public static String masterOn = "component::MasterComponent::properties::masterOn";
			
	
		}
	
	}

}
