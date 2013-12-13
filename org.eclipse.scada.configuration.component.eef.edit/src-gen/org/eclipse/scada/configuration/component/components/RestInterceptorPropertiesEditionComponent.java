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
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.RestInterceptor;
import org.eclipse.scada.configuration.component.parts.ComponentViewsRepository;
import org.eclipse.scada.configuration.component.parts.RestInterceptorPropertiesEditionPart;
import org.eclipse.scada.configuration.infrastructure.InfrastructureFactory;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.infrastructure.MasterServer;
import org.eclipse.scada.configuration.infrastructure.RestExporterModule;


// End of user code

/**
 * @author IBH SYSTEMS GmbH
 * 
 */
public class RestInterceptorPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for masterOn ReferencesTable
	 */
	private ReferencesTableSettings masterOnSettings;
	
	/**
	 * Settings for definition EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings definitionSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public RestInterceptorPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject restInterceptor, String editing_mode) {
		super(editingContext, restInterceptor, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = ComponentViewsRepository.class;
		partKey = ComponentViewsRepository.RestInterceptor.class;
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
			
			final RestInterceptor restInterceptor = (RestInterceptor)elt;
			final RestInterceptorPropertiesEditionPart basePart = (RestInterceptorPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(ComponentViewsRepository.RestInterceptor.Properties.masterOn)) {
				masterOnSettings = new ReferencesTableSettings(restInterceptor, ComponentPackage.eINSTANCE.getItemInterceptor_MasterOn());
				basePart.initMasterOn(masterOnSettings);
			}
			if (isAccessible(ComponentViewsRepository.RestInterceptor.Properties.definition)) {
				// init part
				definitionSettings = new EObjectFlatComboSettings(restInterceptor, ComponentPackage.eINSTANCE.getRestInterceptor_Definition());
				basePart.initDefinition(definitionSettings);
				// set the button mode
				basePart.setDefinitionButtonMode(ButtonsModeEnum.BROWSE);
			}
			// init filters
			if (isAccessible(ComponentViewsRepository.RestInterceptor.Properties.masterOn)) {
				basePart.addFilterToMasterOn(new EObjectFilter(InfrastructurePackage.Literals.MASTER_SERVER));
				// Start of user code for additional businessfilters for masterOn
				// End of user code
			}
			if (isAccessible(ComponentViewsRepository.RestInterceptor.Properties.definition)) {
				basePart.addFilterToDefinition(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof RestExporterModule);
					}
					
				});
				// Start of user code for additional businessfilters for definition
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
		if (editorKey == ComponentViewsRepository.RestInterceptor.Properties.masterOn) {
			return ComponentPackage.eINSTANCE.getItemInterceptor_MasterOn();
		}
		if (editorKey == ComponentViewsRepository.RestInterceptor.Properties.definition) {
			return ComponentPackage.eINSTANCE.getRestInterceptor_Definition();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		RestInterceptor restInterceptor = (RestInterceptor)semanticObject;
		if (ComponentViewsRepository.RestInterceptor.Properties.masterOn == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof MasterServer) {
					masterOnSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				masterOnSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				masterOnSettings.move(event.getNewIndex(), (MasterServer) event.getNewValue());
			}
		}
		if (ComponentViewsRepository.RestInterceptor.Properties.definition == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				definitionSettings.setToReference((RestExporterModule)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				RestExporterModule eObject = InfrastructureFactory.eINSTANCE.createRestExporterModule();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				definitionSettings.setToReference(eObject);
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
			RestInterceptorPropertiesEditionPart basePart = (RestInterceptorPropertiesEditionPart)editingPart;
			if (ComponentPackage.eINSTANCE.getItemInterceptor_MasterOn().equals(msg.getFeature())  && isAccessible(ComponentViewsRepository.RestInterceptor.Properties.masterOn))
				basePart.updateMasterOn();
			if (ComponentPackage.eINSTANCE.getRestInterceptor_Definition().equals(msg.getFeature()) && basePart != null && isAccessible(ComponentViewsRepository.RestInterceptor.Properties.definition))
				basePart.setDefinition((EObject)msg.getNewValue());
			
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
			ComponentPackage.eINSTANCE.getItemInterceptor_MasterOn(),
			ComponentPackage.eINSTANCE.getRestInterceptor_Definition()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == ComponentViewsRepository.RestInterceptor.Properties.definition;
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
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}


	

}
