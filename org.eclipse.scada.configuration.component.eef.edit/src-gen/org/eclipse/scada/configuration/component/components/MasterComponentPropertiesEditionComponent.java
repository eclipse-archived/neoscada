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
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.scada.configuration.component.ComponentFactory;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.Level;
import org.eclipse.scada.configuration.component.MasterComponent;
import org.eclipse.scada.configuration.component.parts.ComponentViewsRepository;
import org.eclipse.scada.configuration.component.parts.MasterComponentPropertiesEditionPart;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.infrastructure.MasterServer;
import org.eclipse.scada.configuration.item.CustomizationPipeline;
import org.eclipse.scada.configuration.item.Selector;


// End of user code

/**
 * @author IBH SYSTEMS GmbH
 * 
 */
public class MasterComponentPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for level EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings levelSettings;
	
	/**
	 * Settings for customizationPipeline EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings customizationPipelineSettings;
	
	/**
	 * Settings for archiveSelector EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings archiveSelectorSettings;
	
	/**
	 * Settings for masterOn ReferencesTable
	 */
	private ReferencesTableSettings masterOnSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public MasterComponentPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject masterComponent, String editing_mode) {
		super(editingContext, masterComponent, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = ComponentViewsRepository.class;
		partKey = ComponentViewsRepository.MasterComponent.class;
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
			
			final MasterComponent masterComponent = (MasterComponent)elt;
			final MasterComponentPropertiesEditionPart basePart = (MasterComponentPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(ComponentViewsRepository.MasterComponent.Properties.level)) {
				// init part
				levelSettings = new EObjectFlatComboSettings(masterComponent, ComponentPackage.eINSTANCE.getComponent_Level());
				basePart.initLevel(levelSettings);
				// set the button mode
				basePart.setLevelButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(ComponentViewsRepository.MasterComponent.Properties.customizationPipeline)) {
				// init part
				customizationPipelineSettings = new EObjectFlatComboSettings(masterComponent, ComponentPackage.eINSTANCE.getComponent_CustomizationPipeline());
				basePart.initCustomizationPipeline(customizationPipelineSettings);
				// set the button mode
				basePart.setCustomizationPipelineButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(ComponentViewsRepository.MasterComponent.Properties.archiveSelector)) {
				// init part
				archiveSelectorSettings = new EObjectFlatComboSettings(masterComponent, ComponentPackage.eINSTANCE.getComponent_ArchiveSelector());
				basePart.initArchiveSelector(archiveSelectorSettings);
				// set the button mode
				basePart.setArchiveSelectorButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(ComponentViewsRepository.MasterComponent.Properties.masterOn)) {
				masterOnSettings = new ReferencesTableSettings(masterComponent, ComponentPackage.eINSTANCE.getMasterComponent_MasterOn());
				basePart.initMasterOn(masterOnSettings);
			}
			// init filters
			if (isAccessible(ComponentViewsRepository.MasterComponent.Properties.level)) {
				basePart.addFilterToLevel(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Level); //$NON-NLS-1$ 
					}
					
				});
				// Start of user code for additional businessfilters for level
				// End of user code
			}
			if (isAccessible(ComponentViewsRepository.MasterComponent.Properties.customizationPipeline)) {
				basePart.addFilterToCustomizationPipeline(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof CustomizationPipeline); //$NON-NLS-1$ 
					}
					
				});
				// Start of user code for additional businessfilters for customizationPipeline
				// End of user code
			}
			if (isAccessible(ComponentViewsRepository.MasterComponent.Properties.archiveSelector)) {
				basePart.addFilterToArchiveSelector(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Selector); //$NON-NLS-1$ 
					}
					
				});
				// Start of user code for additional businessfilters for archiveSelector
				// End of user code
			}
			if (isAccessible(ComponentViewsRepository.MasterComponent.Properties.masterOn)) {
				basePart.addFilterToMasterOn(new EObjectFilter(InfrastructurePackage.Literals.MASTER_SERVER));
				// Start of user code for additional businessfilters for masterOn
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
		if (editorKey == ComponentViewsRepository.MasterComponent.Properties.level) {
			return ComponentPackage.eINSTANCE.getComponent_Level();
		}
		if (editorKey == ComponentViewsRepository.MasterComponent.Properties.customizationPipeline) {
			return ComponentPackage.eINSTANCE.getComponent_CustomizationPipeline();
		}
		if (editorKey == ComponentViewsRepository.MasterComponent.Properties.archiveSelector) {
			return ComponentPackage.eINSTANCE.getComponent_ArchiveSelector();
		}
		if (editorKey == ComponentViewsRepository.MasterComponent.Properties.masterOn) {
			return ComponentPackage.eINSTANCE.getMasterComponent_MasterOn();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		MasterComponent masterComponent = (MasterComponent)semanticObject;
		if (ComponentViewsRepository.MasterComponent.Properties.level == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				levelSettings.setToReference((Level)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				Level eObject = ComponentFactory.eINSTANCE.createLevel();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				levelSettings.setToReference(eObject);
			}
		}
		if (ComponentViewsRepository.MasterComponent.Properties.customizationPipeline == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				customizationPipelineSettings.setToReference((CustomizationPipeline)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, customizationPipelineSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			}
		}
		if (ComponentViewsRepository.MasterComponent.Properties.archiveSelector == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				archiveSelectorSettings.setToReference((Selector)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, archiveSelectorSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			}
		}
		if (ComponentViewsRepository.MasterComponent.Properties.masterOn == event.getAffectedEditor()) {
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
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			MasterComponentPropertiesEditionPart basePart = (MasterComponentPropertiesEditionPart)editingPart;
			if (ComponentPackage.eINSTANCE.getComponent_Level().equals(msg.getFeature()) && basePart != null && isAccessible(ComponentViewsRepository.MasterComponent.Properties.level))
				basePart.setLevel((EObject)msg.getNewValue());
			if (ComponentPackage.eINSTANCE.getComponent_CustomizationPipeline().equals(msg.getFeature()) && basePart != null && isAccessible(ComponentViewsRepository.MasterComponent.Properties.customizationPipeline))
				basePart.setCustomizationPipeline((EObject)msg.getNewValue());
			if (ComponentPackage.eINSTANCE.getComponent_ArchiveSelector().equals(msg.getFeature()) && basePart != null && isAccessible(ComponentViewsRepository.MasterComponent.Properties.archiveSelector))
				basePart.setArchiveSelector((EObject)msg.getNewValue());
			if (ComponentPackage.eINSTANCE.getMasterComponent_MasterOn().equals(msg.getFeature())  && isAccessible(ComponentViewsRepository.MasterComponent.Properties.masterOn))
				basePart.updateMasterOn();
			
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
			ComponentPackage.eINSTANCE.getComponent_Level(),
			ComponentPackage.eINSTANCE.getComponent_CustomizationPipeline(),
			ComponentPackage.eINSTANCE.getComponent_ArchiveSelector(),
			ComponentPackage.eINSTANCE.getMasterComponent_MasterOn()		);
		return new NotificationFilter[] {filter,};
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
