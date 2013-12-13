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
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.scada.configuration.component.Component;
import org.eclipse.scada.configuration.component.ComponentDanglingReference;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.parts.ComponentDanglingReferencePropertiesEditionPart;
import org.eclipse.scada.configuration.component.parts.ComponentViewsRepository;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;


// End of user code

/**
 * @author IBH SYSTEMS GmbH
 * 
 */
public class ComponentDanglingReferencePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for component EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings componentSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public ComponentDanglingReferencePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject componentDanglingReference, String editing_mode) {
		super(editingContext, componentDanglingReference, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = ComponentViewsRepository.class;
		partKey = ComponentViewsRepository.ComponentDanglingReference.class;
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
			
			final ComponentDanglingReference componentDanglingReference = (ComponentDanglingReference)elt;
			final ComponentDanglingReferencePropertiesEditionPart basePart = (ComponentDanglingReferencePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(ComponentViewsRepository.ComponentDanglingReference.Properties.name))
				basePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, componentDanglingReference.getName()));
			
			if (isAccessible(ComponentViewsRepository.ComponentDanglingReference.Properties.localTag))
				basePart.setLocalTag(componentDanglingReference.getLocalTag());
			
			if (isAccessible(ComponentViewsRepository.ComponentDanglingReference.Properties.component_)) {
				// init part
				componentSettings = new EObjectFlatComboSettings(componentDanglingReference, ComponentPackage.eINSTANCE.getComponentDanglingReference_Component());
				basePart.initComponent(componentSettings);
				// set the button mode
				basePart.setComponentButtonMode(ButtonsModeEnum.BROWSE);
			}
			// init filters
			
			
			if (isAccessible(ComponentViewsRepository.ComponentDanglingReference.Properties.component_)) {
				basePart.addFilterToComponent(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof Component);
					}
					
				});
				// Start of user code for additional businessfilters for component
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
		if (editorKey == ComponentViewsRepository.ComponentDanglingReference.Properties.name) {
			return OsgiPackage.eINSTANCE.getItem_Name();
		}
		if (editorKey == ComponentViewsRepository.ComponentDanglingReference.Properties.localTag) {
			return ComponentPackage.eINSTANCE.getComponentDanglingReference_LocalTag();
		}
		if (editorKey == ComponentViewsRepository.ComponentDanglingReference.Properties.component_) {
			return ComponentPackage.eINSTANCE.getComponentDanglingReference_Component();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		ComponentDanglingReference componentDanglingReference = (ComponentDanglingReference)semanticObject;
		if (ComponentViewsRepository.ComponentDanglingReference.Properties.name == event.getAffectedEditor()) {
			componentDanglingReference.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (ComponentViewsRepository.ComponentDanglingReference.Properties.localTag == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				componentDanglingReference.getLocalTag().clear();
				componentDanglingReference.getLocalTag().addAll(((EList) event.getNewValue()));
			}
		}
		if (ComponentViewsRepository.ComponentDanglingReference.Properties.component_ == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				componentSettings.setToReference((Component)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, componentSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
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
			ComponentDanglingReferencePropertiesEditionPart basePart = (ComponentDanglingReferencePropertiesEditionPart)editingPart;
			if (OsgiPackage.eINSTANCE.getItem_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(ComponentViewsRepository.ComponentDanglingReference.Properties.name)) {
				if (msg.getNewValue() != null) {
					basePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setName("");
				}
			}
			if (ComponentPackage.eINSTANCE.getComponentDanglingReference_LocalTag().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(ComponentViewsRepository.ComponentDanglingReference.Properties.localTag)) {
				if (msg.getNewValue() instanceof EList<?>) {
					basePart.setLocalTag((EList<?>)msg.getNewValue());
				} else if (msg.getNewValue() == null) {
					basePart.setLocalTag(new BasicEList<Object>());
				} else {
					BasicEList<Object> newValueAsList = new BasicEList<Object>();
					newValueAsList.add(msg.getNewValue());
					basePart.setLocalTag(newValueAsList);
				}
			}
			
			if (ComponentPackage.eINSTANCE.getComponentDanglingReference_Component().equals(msg.getFeature()) && basePart != null && isAccessible(ComponentViewsRepository.ComponentDanglingReference.Properties.component_))
				basePart.setComponent((EObject)msg.getNewValue());
			
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
			OsgiPackage.eINSTANCE.getItem_Name(),
			ComponentPackage.eINSTANCE.getComponentDanglingReference_LocalTag(),
			ComponentPackage.eINSTANCE.getComponentDanglingReference_Component()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == ComponentViewsRepository.ComponentDanglingReference.Properties.name || key == ComponentViewsRepository.ComponentDanglingReference.Properties.localTag || key == ComponentViewsRepository.ComponentDanglingReference.Properties.component_;
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
				if (ComponentViewsRepository.ComponentDanglingReference.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(OsgiPackage.eINSTANCE.getItem_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(OsgiPackage.eINSTANCE.getItem_Name().getEAttributeType(), newValue);
				}
				if (ComponentViewsRepository.ComponentDanglingReference.Properties.localTag == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(ComponentPackage.eINSTANCE.getComponentDanglingReference_LocalTag().getEAttributeType(), iterator.next()));
					}
					ret = chain;
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
