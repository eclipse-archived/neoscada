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
package org.eclipse.scada.configuration.component.components;

// Start of user code for imports
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.FormulaModule;
import org.eclipse.scada.configuration.component.InputSpecification;
import org.eclipse.scada.configuration.component.Script;
import org.eclipse.scada.configuration.component.parts.ComponentViewsRepository;
import org.eclipse.scada.configuration.component.parts.FormulaModulePropertiesEditionPart;
import org.eclipse.scada.configuration.world.WorldPackage;


// End of user code

/**
 * @author IBH SYSTEMS GmbH
 * 
 */
public class FormulaModulePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for inputs ReferencesTable
	 */
	protected ReferencesTableSettings inputsSettings;
	
	/**
	 * Settings for init ReferencesTable
	 */
	protected ReferencesTableSettings initSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public FormulaModulePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject formulaModule, String editing_mode) {
		super(editingContext, formulaModule, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = ComponentViewsRepository.class;
		partKey = ComponentViewsRepository.FormulaModule.class;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Object, int, org.eclipse.emf.ecore.EObject, 
	 *      org.eclipse.emf.ecore.resource.ResourceSet)
	 * 
	 */
	public void initPart(Object key, int kind, EObject elt, ResourceSet allResource) {
		setInitializing(true);
		if (editingPart != null && key == partKey) {
			editingPart.setContext(elt, allResource);
			
			final FormulaModule formulaModule = (FormulaModule)elt;
			final FormulaModulePropertiesEditionPart basePart = (FormulaModulePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(ComponentViewsRepository.FormulaModule.Properties.shortDescription))
				basePart.setShortDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, formulaModule.getShortDescription()));
			
			if (isAccessible(ComponentViewsRepository.FormulaModule.Properties.name))
				basePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, formulaModule.getName()));
			
			if (isAccessible(ComponentViewsRepository.FormulaModule.Properties.inputs)) {
				inputsSettings = new ReferencesTableSettings(formulaModule, ComponentPackage.eINSTANCE.getFormulaModule_Inputs());
				basePart.initInputs(inputsSettings);
			}
			if (isAccessible(ComponentViewsRepository.FormulaModule.Properties.scriptEngine))
				basePart.setScriptEngine(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, formulaModule.getScriptEngine()));
			
			if (isAccessible(ComponentViewsRepository.FormulaModule.Properties.init)) {
				initSettings = new ReferencesTableSettings(formulaModule, ComponentPackage.eINSTANCE.getFormulaModule_Init());
				basePart.initInit(initSettings);
			}
			// init filters
			
			
			if (isAccessible(ComponentViewsRepository.FormulaModule.Properties.inputs)) {
				basePart.addFilterToInputs(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof InputSpecification); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for inputs
				// End of user code
			}
			
			if (isAccessible(ComponentViewsRepository.FormulaModule.Properties.init)) {
				basePart.addFilterToInit(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Script); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for init
				// End of user code
			}
			// init values for referenced views
			
			// init filters for referenced views
			
		}
		setInitializing(false);
	}








	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
	 */
	public EStructuralFeature associatedFeature(Object editorKey) {
		if (editorKey == ComponentViewsRepository.FormulaModule.Properties.shortDescription) {
			return WorldPackage.eINSTANCE.getDocumentable_ShortDescription();
		}
		if (editorKey == ComponentViewsRepository.FormulaModule.Properties.name) {
			return WorldPackage.eINSTANCE.getDocumentable_Name();
		}
		if (editorKey == ComponentViewsRepository.FormulaModule.Properties.inputs) {
			return ComponentPackage.eINSTANCE.getFormulaModule_Inputs();
		}
		if (editorKey == ComponentViewsRepository.FormulaModule.Properties.scriptEngine) {
			return ComponentPackage.eINSTANCE.getFormulaModule_ScriptEngine();
		}
		if (editorKey == ComponentViewsRepository.FormulaModule.Properties.init) {
			return ComponentPackage.eINSTANCE.getFormulaModule_Init();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		FormulaModule formulaModule = (FormulaModule)semanticObject;
		if (ComponentViewsRepository.FormulaModule.Properties.shortDescription == event.getAffectedEditor()) {
			formulaModule.setShortDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (ComponentViewsRepository.FormulaModule.Properties.name == event.getAffectedEditor()) {
			formulaModule.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (ComponentViewsRepository.FormulaModule.Properties.inputs == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, inputsSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.EDIT) {
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, (EObject) event.getNewValue(), editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt((EObject) event.getNewValue(), PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy editionPolicy = provider.getPolicy(context);
					if (editionPolicy != null) {
						editionPolicy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				inputsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				inputsSettings.move(event.getNewIndex(), (InputSpecification) event.getNewValue());
			}
		}
		if (ComponentViewsRepository.FormulaModule.Properties.scriptEngine == event.getAffectedEditor()) {
			formulaModule.setScriptEngine((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (ComponentViewsRepository.FormulaModule.Properties.init == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, initSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.EDIT) {
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, (EObject) event.getNewValue(), editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt((EObject) event.getNewValue(), PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy editionPolicy = provider.getPolicy(context);
					if (editionPolicy != null) {
						editionPolicy.execute();
					}
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				initSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				initSettings.move(event.getNewIndex(), (Script) event.getNewValue());
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			FormulaModulePropertiesEditionPart basePart = (FormulaModulePropertiesEditionPart)editingPart;
			if (WorldPackage.eINSTANCE.getDocumentable_ShortDescription().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(ComponentViewsRepository.FormulaModule.Properties.shortDescription)) {
				if (msg.getNewValue() != null) {
					basePart.setShortDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setShortDescription("");
				}
			}
			if (WorldPackage.eINSTANCE.getDocumentable_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(ComponentViewsRepository.FormulaModule.Properties.name)) {
				if (msg.getNewValue() != null) {
					basePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setName("");
				}
			}
			if (ComponentPackage.eINSTANCE.getFormulaModule_Inputs().equals(msg.getFeature()) && isAccessible(ComponentViewsRepository.FormulaModule.Properties.inputs))
				basePart.updateInputs();
			if (ComponentPackage.eINSTANCE.getFormulaModule_ScriptEngine().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(ComponentViewsRepository.FormulaModule.Properties.scriptEngine)) {
				if (msg.getNewValue() != null) {
					basePart.setScriptEngine(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setScriptEngine("");
				}
			}
			if (ComponentPackage.eINSTANCE.getFormulaModule_Init().equals(msg.getFeature()) && isAccessible(ComponentViewsRepository.FormulaModule.Properties.init))
				basePart.updateInit();
			
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getNotificationFilters()
	 */
	@Override
	protected NotificationFilter[] getNotificationFilters() {
		NotificationFilter filter = new EStructuralFeatureNotificationFilter(
			WorldPackage.eINSTANCE.getDocumentable_ShortDescription(),
			WorldPackage.eINSTANCE.getDocumentable_Name(),
			ComponentPackage.eINSTANCE.getFormulaModule_Inputs(),
			ComponentPackage.eINSTANCE.getFormulaModule_ScriptEngine(),
			ComponentPackage.eINSTANCE.getFormulaModule_Init()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == ComponentViewsRepository.FormulaModule.Properties.scriptEngine;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public Diagnostic validateValue(IPropertiesEditionEvent event) {
		Diagnostic ret = Diagnostic.OK_INSTANCE;
		if (event.getNewValue() != null) {
			try {
				if (ComponentViewsRepository.FormulaModule.Properties.shortDescription == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(WorldPackage.eINSTANCE.getDocumentable_ShortDescription().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(WorldPackage.eINSTANCE.getDocumentable_ShortDescription().getEAttributeType(), newValue);
				}
				if (ComponentViewsRepository.FormulaModule.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(WorldPackage.eINSTANCE.getDocumentable_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(WorldPackage.eINSTANCE.getDocumentable_Name().getEAttributeType(), newValue);
				}
				if (ComponentViewsRepository.FormulaModule.Properties.scriptEngine == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(ComponentPackage.eINSTANCE.getFormulaModule_ScriptEngine().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(ComponentPackage.eINSTANCE.getFormulaModule_ScriptEngine().getEAttributeType(), newValue);
				}
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}


	

}
