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
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
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
import org.eclipse.scada.configuration.component.DataComponent;
import org.eclipse.scada.configuration.component.GlobalizeComponent;
import org.eclipse.scada.configuration.component.Level;
import org.eclipse.scada.configuration.component.parts.ComponentViewsRepository;
import org.eclipse.scada.configuration.component.parts.GlobalizeComponentPropertiesEditionPart;
import org.eclipse.scada.configuration.infrastructure.InfrastructureFactory;
import org.eclipse.scada.configuration.infrastructure.MasterImport;
import org.eclipse.scada.configuration.item.CustomizationPipeline;
import org.eclipse.scada.configuration.item.Selector;
import org.eclipse.scada.configuration.world.WorldPackage;


// End of user code

/**
 * @author IBH SYSTEMS GmbH
 * 
 */
public class GlobalizeComponentPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
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
	 * Settings for components ReferencesTable
	 */
	private ReferencesTableSettings componentsSettings;
	
	/**
	 * Settings for sourceMaster EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings sourceMasterSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public GlobalizeComponentPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject globalizeComponent, String editing_mode) {
		super(editingContext, globalizeComponent, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = ComponentViewsRepository.class;
		partKey = ComponentViewsRepository.GlobalizeComponent.class;
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
			
			final GlobalizeComponent globalizeComponent = (GlobalizeComponent)elt;
			final GlobalizeComponentPropertiesEditionPart basePart = (GlobalizeComponentPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(ComponentViewsRepository.GlobalizeComponent.Properties.shortDescription))
				basePart.setShortDescription(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, globalizeComponent.getShortDescription()));
			
			if (isAccessible(ComponentViewsRepository.GlobalizeComponent.Properties.name))
				basePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, globalizeComponent.getName()));
			
			if (isAccessible(ComponentViewsRepository.GlobalizeComponent.Properties.level)) {
				// init part
				levelSettings = new EObjectFlatComboSettings(globalizeComponent, ComponentPackage.eINSTANCE.getComponent_Level());
				basePart.initLevel(levelSettings);
				// set the button mode
				basePart.setLevelButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(ComponentViewsRepository.GlobalizeComponent.Properties.customizationPipeline)) {
				// init part
				customizationPipelineSettings = new EObjectFlatComboSettings(globalizeComponent, ComponentPackage.eINSTANCE.getComponent_CustomizationPipeline());
				basePart.initCustomizationPipeline(customizationPipelineSettings);
				// set the button mode
				basePart.setCustomizationPipelineButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(ComponentViewsRepository.GlobalizeComponent.Properties.archiveSelector)) {
				// init part
				archiveSelectorSettings = new EObjectFlatComboSettings(globalizeComponent, ComponentPackage.eINSTANCE.getComponent_ArchiveSelector());
				basePart.initArchiveSelector(archiveSelectorSettings);
				// set the button mode
				basePart.setArchiveSelectorButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(ComponentViewsRepository.GlobalizeComponent.Properties.components)) {
				componentsSettings = new ReferencesTableSettings(globalizeComponent, ComponentPackage.eINSTANCE.getGlobalizeComponent_Components());
				basePart.initComponents(componentsSettings);
			}
			if (isAccessible(ComponentViewsRepository.GlobalizeComponent.Properties.sourceMaster)) {
				// init part
				sourceMasterSettings = new EObjectFlatComboSettings(globalizeComponent, ComponentPackage.eINSTANCE.getGlobalizeComponent_SourceMaster());
				basePart.initSourceMaster(sourceMasterSettings);
				// set the button mode
				basePart.setSourceMasterButtonMode(ButtonsModeEnum.BROWSE);
			}
			// init filters
			
			
			if (isAccessible(ComponentViewsRepository.GlobalizeComponent.Properties.level)) {
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
			if (isAccessible(ComponentViewsRepository.GlobalizeComponent.Properties.customizationPipeline)) {
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
			if (isAccessible(ComponentViewsRepository.GlobalizeComponent.Properties.archiveSelector)) {
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
			if (isAccessible(ComponentViewsRepository.GlobalizeComponent.Properties.components)) {
				basePart.addFilterToComponents(new EObjectFilter(ComponentPackage.Literals.DATA_COMPONENT));
				// Start of user code for additional businessfilters for components
				// End of user code
			}
			if (isAccessible(ComponentViewsRepository.GlobalizeComponent.Properties.sourceMaster)) {
				basePart.addFilterToSourceMaster(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof MasterImport);
					}
					
				});
				// Start of user code for additional businessfilters for sourceMaster
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
		if (editorKey == ComponentViewsRepository.GlobalizeComponent.Properties.shortDescription) {
			return WorldPackage.eINSTANCE.getDocumentable_ShortDescription();
		}
		if (editorKey == ComponentViewsRepository.GlobalizeComponent.Properties.name) {
			return WorldPackage.eINSTANCE.getDocumentable_Name();
		}
		if (editorKey == ComponentViewsRepository.GlobalizeComponent.Properties.level) {
			return ComponentPackage.eINSTANCE.getComponent_Level();
		}
		if (editorKey == ComponentViewsRepository.GlobalizeComponent.Properties.customizationPipeline) {
			return ComponentPackage.eINSTANCE.getComponent_CustomizationPipeline();
		}
		if (editorKey == ComponentViewsRepository.GlobalizeComponent.Properties.archiveSelector) {
			return ComponentPackage.eINSTANCE.getComponent_ArchiveSelector();
		}
		if (editorKey == ComponentViewsRepository.GlobalizeComponent.Properties.components) {
			return ComponentPackage.eINSTANCE.getGlobalizeComponent_Components();
		}
		if (editorKey == ComponentViewsRepository.GlobalizeComponent.Properties.sourceMaster) {
			return ComponentPackage.eINSTANCE.getGlobalizeComponent_SourceMaster();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		GlobalizeComponent globalizeComponent = (GlobalizeComponent)semanticObject;
		if (ComponentViewsRepository.GlobalizeComponent.Properties.shortDescription == event.getAffectedEditor()) {
			globalizeComponent.setShortDescription((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (ComponentViewsRepository.GlobalizeComponent.Properties.name == event.getAffectedEditor()) {
			globalizeComponent.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (ComponentViewsRepository.GlobalizeComponent.Properties.level == event.getAffectedEditor()) {
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
		if (ComponentViewsRepository.GlobalizeComponent.Properties.customizationPipeline == event.getAffectedEditor()) {
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
		if (ComponentViewsRepository.GlobalizeComponent.Properties.archiveSelector == event.getAffectedEditor()) {
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
		if (ComponentViewsRepository.GlobalizeComponent.Properties.components == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				if (event.getNewValue() instanceof DataComponent) {
					componentsSettings.addToReference((EObject) event.getNewValue());
				}
			} else if (event.getKind() == PropertiesEditionEvent.REMOVE) {
				componentsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				componentsSettings.move(event.getNewIndex(), (DataComponent) event.getNewValue());
			}
		}
		if (ComponentViewsRepository.GlobalizeComponent.Properties.sourceMaster == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				sourceMasterSettings.setToReference((MasterImport)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				MasterImport eObject = InfrastructureFactory.eINSTANCE.createMasterImport();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				sourceMasterSettings.setToReference(eObject);
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
			GlobalizeComponentPropertiesEditionPart basePart = (GlobalizeComponentPropertiesEditionPart)editingPart;
			if (WorldPackage.eINSTANCE.getDocumentable_ShortDescription().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(ComponentViewsRepository.GlobalizeComponent.Properties.shortDescription)) {
				if (msg.getNewValue() != null) {
					basePart.setShortDescription(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setShortDescription("");
				}
			}
			if (WorldPackage.eINSTANCE.getDocumentable_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(ComponentViewsRepository.GlobalizeComponent.Properties.name)) {
				if (msg.getNewValue() != null) {
					basePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setName("");
				}
			}
			if (ComponentPackage.eINSTANCE.getComponent_Level().equals(msg.getFeature()) && basePart != null && isAccessible(ComponentViewsRepository.GlobalizeComponent.Properties.level))
				basePart.setLevel((EObject)msg.getNewValue());
			if (ComponentPackage.eINSTANCE.getComponent_CustomizationPipeline().equals(msg.getFeature()) && basePart != null && isAccessible(ComponentViewsRepository.GlobalizeComponent.Properties.customizationPipeline))
				basePart.setCustomizationPipeline((EObject)msg.getNewValue());
			if (ComponentPackage.eINSTANCE.getComponent_ArchiveSelector().equals(msg.getFeature()) && basePart != null && isAccessible(ComponentViewsRepository.GlobalizeComponent.Properties.archiveSelector))
				basePart.setArchiveSelector((EObject)msg.getNewValue());
			if (ComponentPackage.eINSTANCE.getGlobalizeComponent_Components().equals(msg.getFeature())  && isAccessible(ComponentViewsRepository.GlobalizeComponent.Properties.components))
				basePart.updateComponents();
			if (ComponentPackage.eINSTANCE.getGlobalizeComponent_SourceMaster().equals(msg.getFeature()) && basePart != null && isAccessible(ComponentViewsRepository.GlobalizeComponent.Properties.sourceMaster))
				basePart.setSourceMaster((EObject)msg.getNewValue());
			
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
			ComponentPackage.eINSTANCE.getComponent_Level(),
			ComponentPackage.eINSTANCE.getComponent_CustomizationPipeline(),
			ComponentPackage.eINSTANCE.getComponent_ArchiveSelector(),
			ComponentPackage.eINSTANCE.getGlobalizeComponent_Components(),
			ComponentPackage.eINSTANCE.getGlobalizeComponent_SourceMaster()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == ComponentViewsRepository.GlobalizeComponent.Properties.sourceMaster;
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
				if (ComponentViewsRepository.GlobalizeComponent.Properties.shortDescription == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(WorldPackage.eINSTANCE.getDocumentable_ShortDescription().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(WorldPackage.eINSTANCE.getDocumentable_ShortDescription().getEAttributeType(), newValue);
				}
				if (ComponentViewsRepository.GlobalizeComponent.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(WorldPackage.eINSTANCE.getDocumentable_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(WorldPackage.eINSTANCE.getDocumentable_Name().getEAttributeType(), newValue);
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
