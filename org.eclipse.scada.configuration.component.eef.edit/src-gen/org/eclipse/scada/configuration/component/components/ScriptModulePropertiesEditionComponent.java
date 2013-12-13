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
import org.eclipse.scada.configuration.component.InputSpecification;
import org.eclipse.scada.configuration.component.OutputSpecification;
import org.eclipse.scada.configuration.component.ScriptModule;
import org.eclipse.scada.configuration.component.parts.ComponentViewsRepository;
import org.eclipse.scada.configuration.component.parts.ScriptModulePropertiesEditionPart;
import org.eclipse.scada.configuration.world.WorldPackage;


// End of user code

/**
 * @author IBH SYSTEMS GmbH
 * 
 */
public class ScriptModulePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for inputs ReferencesTable
	 */
	protected ReferencesTableSettings inputsSettings;
	
	/**
	 * Settings for outputs ReferencesTable
	 */
	protected ReferencesTableSettings outputsSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public ScriptModulePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject scriptModule, String editing_mode) {
		super(editingContext, scriptModule, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = ComponentViewsRepository.class;
		partKey = ComponentViewsRepository.ScriptModule.class;
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
			
			final ScriptModule scriptModule = (ScriptModule)elt;
			final ScriptModulePropertiesEditionPart basePart = (ScriptModulePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(ComponentViewsRepository.ScriptModule.Properties.shortDescription))
				basePart.setShortDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, scriptModule.getShortDescription()));
			
			if (isAccessible(ComponentViewsRepository.ScriptModule.Properties.name))
				basePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, scriptModule.getName()));
			
			if (isAccessible(ComponentViewsRepository.ScriptModule.Properties.inputs)) {
				inputsSettings = new ReferencesTableSettings(scriptModule, ComponentPackage.eINSTANCE.getScriptModule_Inputs());
				basePart.initInputs(inputsSettings);
			}
			if (isAccessible(ComponentViewsRepository.ScriptModule.Properties.outputs)) {
				outputsSettings = new ReferencesTableSettings(scriptModule, ComponentPackage.eINSTANCE.getScriptModule_Outputs());
				basePart.initOutputs(outputsSettings);
			}
			if (isAccessible(ComponentViewsRepository.ScriptModule.Properties.scriptEngine))
				basePart.setScriptEngine(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, scriptModule.getScriptEngine()));
			
			// init filters
			
			
			if (isAccessible(ComponentViewsRepository.ScriptModule.Properties.inputs)) {
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
			if (isAccessible(ComponentViewsRepository.ScriptModule.Properties.outputs)) {
				basePart.addFilterToOutputs(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof OutputSpecification); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for outputs
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
		if (editorKey == ComponentViewsRepository.ScriptModule.Properties.shortDescription) {
			return WorldPackage.eINSTANCE.getDocumentable_ShortDescription();
		}
		if (editorKey == ComponentViewsRepository.ScriptModule.Properties.name) {
			return WorldPackage.eINSTANCE.getDocumentable_Name();
		}
		if (editorKey == ComponentViewsRepository.ScriptModule.Properties.inputs) {
			return ComponentPackage.eINSTANCE.getScriptModule_Inputs();
		}
		if (editorKey == ComponentViewsRepository.ScriptModule.Properties.outputs) {
			return ComponentPackage.eINSTANCE.getScriptModule_Outputs();
		}
		if (editorKey == ComponentViewsRepository.ScriptModule.Properties.scriptEngine) {
			return ComponentPackage.eINSTANCE.getScriptModule_ScriptEngine();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		ScriptModule scriptModule = (ScriptModule)semanticObject;
		if (ComponentViewsRepository.ScriptModule.Properties.shortDescription == event.getAffectedEditor()) {
			scriptModule.setShortDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (ComponentViewsRepository.ScriptModule.Properties.name == event.getAffectedEditor()) {
			scriptModule.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (ComponentViewsRepository.ScriptModule.Properties.inputs == event.getAffectedEditor()) {
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
		if (ComponentViewsRepository.ScriptModule.Properties.outputs == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, outputsSettings, editingContext.getAdapterFactory());
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
				outputsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				outputsSettings.move(event.getNewIndex(), (OutputSpecification) event.getNewValue());
			}
		}
		if (ComponentViewsRepository.ScriptModule.Properties.scriptEngine == event.getAffectedEditor()) {
			scriptModule.setScriptEngine((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			ScriptModulePropertiesEditionPart basePart = (ScriptModulePropertiesEditionPart)editingPart;
			if (WorldPackage.eINSTANCE.getDocumentable_ShortDescription().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(ComponentViewsRepository.ScriptModule.Properties.shortDescription)) {
				if (msg.getNewValue() != null) {
					basePart.setShortDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setShortDescription("");
				}
			}
			if (WorldPackage.eINSTANCE.getDocumentable_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(ComponentViewsRepository.ScriptModule.Properties.name)) {
				if (msg.getNewValue() != null) {
					basePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setName("");
				}
			}
			if (ComponentPackage.eINSTANCE.getScriptModule_Inputs().equals(msg.getFeature()) && isAccessible(ComponentViewsRepository.ScriptModule.Properties.inputs))
				basePart.updateInputs();
			if (ComponentPackage.eINSTANCE.getScriptModule_Outputs().equals(msg.getFeature()) && isAccessible(ComponentViewsRepository.ScriptModule.Properties.outputs))
				basePart.updateOutputs();
			if (ComponentPackage.eINSTANCE.getScriptModule_ScriptEngine().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(ComponentViewsRepository.ScriptModule.Properties.scriptEngine)) {
				if (msg.getNewValue() != null) {
					basePart.setScriptEngine(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setScriptEngine("");
				}
			}
			
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
			ComponentPackage.eINSTANCE.getScriptModule_Inputs(),
			ComponentPackage.eINSTANCE.getScriptModule_Outputs(),
			ComponentPackage.eINSTANCE.getScriptModule_ScriptEngine()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == ComponentViewsRepository.ScriptModule.Properties.scriptEngine;
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
				if (ComponentViewsRepository.ScriptModule.Properties.shortDescription == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(WorldPackage.eINSTANCE.getDocumentable_ShortDescription().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(WorldPackage.eINSTANCE.getDocumentable_ShortDescription().getEAttributeType(), newValue);
				}
				if (ComponentViewsRepository.ScriptModule.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(WorldPackage.eINSTANCE.getDocumentable_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(WorldPackage.eINSTANCE.getDocumentable_Name().getEAttributeType(), newValue);
				}
				if (ComponentViewsRepository.ScriptModule.Properties.scriptEngine == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(ComponentPackage.eINSTANCE.getScriptModule_ScriptEngine().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(ComponentPackage.eINSTANCE.getScriptModule_ScriptEngine().getEAttributeType(), newValue);
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
