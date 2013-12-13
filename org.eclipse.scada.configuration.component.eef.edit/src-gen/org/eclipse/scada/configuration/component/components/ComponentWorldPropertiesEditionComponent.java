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
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.ComponentWorld;
import org.eclipse.scada.configuration.component.Configuration;
import org.eclipse.scada.configuration.component.ItemInterceptor;
import org.eclipse.scada.configuration.component.Service;
import org.eclipse.scada.configuration.component.parts.ComponentViewsRepository;
import org.eclipse.scada.configuration.component.parts.ComponentWorldPropertiesEditionPart;
import org.eclipse.scada.configuration.infrastructure.InfrastructureFactory;
import org.eclipse.scada.configuration.infrastructure.World;
import org.eclipse.scada.configuration.item.CustomizationPipeline;
import org.eclipse.scada.configuration.item.Selector;


// End of user code

/**
 * @author IBH SYSTEMS GmbH
 * 
 */
public class ComponentWorldPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	/**
	 * Settings for itemInterceptors ReferencesTable
	 */
	protected ReferencesTableSettings itemInterceptorsSettings;
	
	/**
	 * Settings for configurations ReferencesTable
	 */
	protected ReferencesTableSettings configurationsSettings;
	
	/**
	 * Settings for services ReferencesTable
	 */
	protected ReferencesTableSettings servicesSettings;
	
	/**
	 * Settings for infrastructure EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings infrastructureSettings;
	
	/**
	 * Settings for defaultCustomizationPipeline EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings defaultCustomizationPipelineSettings;
	
	/**
	 * Settings for defaultArchiveSelector EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings defaultArchiveSelectorSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public ComponentWorldPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject componentWorld, String editing_mode) {
		super(editingContext, componentWorld, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = ComponentViewsRepository.class;
		partKey = ComponentViewsRepository.ComponentWorld.class;
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
			
			final ComponentWorld componentWorld = (ComponentWorld)elt;
			final ComponentWorldPropertiesEditionPart basePart = (ComponentWorldPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(ComponentViewsRepository.ComponentWorld.Properties.itemInterceptors)) {
				itemInterceptorsSettings = new ReferencesTableSettings(componentWorld, ComponentPackage.eINSTANCE.getContainer_ItemInterceptors());
				basePart.initItemInterceptors(itemInterceptorsSettings);
			}
			if (isAccessible(ComponentViewsRepository.ComponentWorld.Properties.configurations)) {
				configurationsSettings = new ReferencesTableSettings(componentWorld, ComponentPackage.eINSTANCE.getComponentWorld_Configurations());
				basePart.initConfigurations(configurationsSettings);
			}
			if (isAccessible(ComponentViewsRepository.ComponentWorld.Properties.services)) {
				servicesSettings = new ReferencesTableSettings(componentWorld, ComponentPackage.eINSTANCE.getComponentWorld_Services());
				basePart.initServices(servicesSettings);
			}
			if (isAccessible(ComponentViewsRepository.ComponentWorld.Properties.infrastructure)) {
				// init part
				infrastructureSettings = new EObjectFlatComboSettings(componentWorld, ComponentPackage.eINSTANCE.getComponentWorld_Infrastructure());
				basePart.initInfrastructure(infrastructureSettings);
				// set the button mode
				basePart.setInfrastructureButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(ComponentViewsRepository.ComponentWorld.Properties.defaultCustomizationPipeline)) {
				// init part
				defaultCustomizationPipelineSettings = new EObjectFlatComboSettings(componentWorld, ComponentPackage.eINSTANCE.getComponentWorld_DefaultCustomizationPipeline());
				basePart.initDefaultCustomizationPipeline(defaultCustomizationPipelineSettings);
				// set the button mode
				basePart.setDefaultCustomizationPipelineButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(ComponentViewsRepository.ComponentWorld.Properties.defaultArchiveSelector)) {
				// init part
				defaultArchiveSelectorSettings = new EObjectFlatComboSettings(componentWorld, ComponentPackage.eINSTANCE.getComponentWorld_DefaultArchiveSelector());
				basePart.initDefaultArchiveSelector(defaultArchiveSelectorSettings);
				// set the button mode
				basePart.setDefaultArchiveSelectorButtonMode(ButtonsModeEnum.BROWSE);
			}
			// init filters
			if (isAccessible(ComponentViewsRepository.ComponentWorld.Properties.itemInterceptors)) {
				basePart.addFilterToItemInterceptors(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof ItemInterceptor); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for itemInterceptors
				// End of user code
			}
			if (isAccessible(ComponentViewsRepository.ComponentWorld.Properties.configurations)) {
				basePart.addFilterToConfigurations(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Configuration); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for configurations
				// End of user code
			}
			if (isAccessible(ComponentViewsRepository.ComponentWorld.Properties.services)) {
				basePart.addFilterToServices(new ViewerFilter() {
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Service); //$NON-NLS-1$ 
					}
			
				});
				// Start of user code for additional businessfilters for services
				// End of user code
			}
			if (isAccessible(ComponentViewsRepository.ComponentWorld.Properties.infrastructure)) {
				basePart.addFilterToInfrastructure(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof World);
					}
					
				});
				// Start of user code for additional businessfilters for infrastructure
				// End of user code
			}
			if (isAccessible(ComponentViewsRepository.ComponentWorld.Properties.defaultCustomizationPipeline)) {
				basePart.addFilterToDefaultCustomizationPipeline(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof CustomizationPipeline); //$NON-NLS-1$ 
					}
					
				});
				// Start of user code for additional businessfilters for defaultCustomizationPipeline
				// End of user code
			}
			if (isAccessible(ComponentViewsRepository.ComponentWorld.Properties.defaultArchiveSelector)) {
				basePart.addFilterToDefaultArchiveSelector(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof Selector); //$NON-NLS-1$ 
					}
					
				});
				// Start of user code for additional businessfilters for defaultArchiveSelector
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
		if (editorKey == ComponentViewsRepository.ComponentWorld.Properties.itemInterceptors) {
			return ComponentPackage.eINSTANCE.getContainer_ItemInterceptors();
		}
		if (editorKey == ComponentViewsRepository.ComponentWorld.Properties.configurations) {
			return ComponentPackage.eINSTANCE.getComponentWorld_Configurations();
		}
		if (editorKey == ComponentViewsRepository.ComponentWorld.Properties.services) {
			return ComponentPackage.eINSTANCE.getComponentWorld_Services();
		}
		if (editorKey == ComponentViewsRepository.ComponentWorld.Properties.infrastructure) {
			return ComponentPackage.eINSTANCE.getComponentWorld_Infrastructure();
		}
		if (editorKey == ComponentViewsRepository.ComponentWorld.Properties.defaultCustomizationPipeline) {
			return ComponentPackage.eINSTANCE.getComponentWorld_DefaultCustomizationPipeline();
		}
		if (editorKey == ComponentViewsRepository.ComponentWorld.Properties.defaultArchiveSelector) {
			return ComponentPackage.eINSTANCE.getComponentWorld_DefaultArchiveSelector();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		ComponentWorld componentWorld = (ComponentWorld)semanticObject;
		if (ComponentViewsRepository.ComponentWorld.Properties.itemInterceptors == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, itemInterceptorsSettings, editingContext.getAdapterFactory());
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
				itemInterceptorsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				itemInterceptorsSettings.move(event.getNewIndex(), (ItemInterceptor) event.getNewValue());
			}
		}
		if (ComponentViewsRepository.ComponentWorld.Properties.configurations == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, configurationsSettings, editingContext.getAdapterFactory());
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
				configurationsSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				configurationsSettings.move(event.getNewIndex(), (Configuration) event.getNewValue());
			}
		}
		if (ComponentViewsRepository.ComponentWorld.Properties.services == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, servicesSettings, editingContext.getAdapterFactory());
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
				servicesSettings.removeFromReference((EObject) event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.MOVE) {
				servicesSettings.move(event.getNewIndex(), (Service) event.getNewValue());
			}
		}
		if (ComponentViewsRepository.ComponentWorld.Properties.infrastructure == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				infrastructureSettings.setToReference((World)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				World eObject = InfrastructureFactory.eINSTANCE.createWorld();
				EObjectPropertiesEditionContext context = new EObjectPropertiesEditionContext(editingContext, this, eObject, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(eObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy != null) {
						policy.execute();
					}
				}
				infrastructureSettings.setToReference(eObject);
			}
		}
		if (ComponentViewsRepository.ComponentWorld.Properties.defaultCustomizationPipeline == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				defaultCustomizationPipelineSettings.setToReference((CustomizationPipeline)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, defaultCustomizationPipelineSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			}
		}
		if (ComponentViewsRepository.ComponentWorld.Properties.defaultArchiveSelector == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				defaultArchiveSelectorSettings.setToReference((Selector)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, defaultArchiveSelectorSettings, editingContext.getAdapterFactory());
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
			ComponentWorldPropertiesEditionPart basePart = (ComponentWorldPropertiesEditionPart)editingPart;
			if (ComponentPackage.eINSTANCE.getContainer_ItemInterceptors().equals(msg.getFeature()) && isAccessible(ComponentViewsRepository.ComponentWorld.Properties.itemInterceptors))
				basePart.updateItemInterceptors();
			if (ComponentPackage.eINSTANCE.getComponentWorld_Configurations().equals(msg.getFeature()) && isAccessible(ComponentViewsRepository.ComponentWorld.Properties.configurations))
				basePart.updateConfigurations();
			if (ComponentPackage.eINSTANCE.getComponentWorld_Services().equals(msg.getFeature()) && isAccessible(ComponentViewsRepository.ComponentWorld.Properties.services))
				basePart.updateServices();
			if (ComponentPackage.eINSTANCE.getComponentWorld_Infrastructure().equals(msg.getFeature()) && basePart != null && isAccessible(ComponentViewsRepository.ComponentWorld.Properties.infrastructure))
				basePart.setInfrastructure((EObject)msg.getNewValue());
			if (ComponentPackage.eINSTANCE.getComponentWorld_DefaultCustomizationPipeline().equals(msg.getFeature()) && basePart != null && isAccessible(ComponentViewsRepository.ComponentWorld.Properties.defaultCustomizationPipeline))
				basePart.setDefaultCustomizationPipeline((EObject)msg.getNewValue());
			if (ComponentPackage.eINSTANCE.getComponentWorld_DefaultArchiveSelector().equals(msg.getFeature()) && basePart != null && isAccessible(ComponentViewsRepository.ComponentWorld.Properties.defaultArchiveSelector))
				basePart.setDefaultArchiveSelector((EObject)msg.getNewValue());
			
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
			ComponentPackage.eINSTANCE.getContainer_ItemInterceptors(),
			ComponentPackage.eINSTANCE.getComponentWorld_Configurations(),
			ComponentPackage.eINSTANCE.getComponentWorld_Services(),
			ComponentPackage.eINSTANCE.getComponentWorld_Infrastructure(),
			ComponentPackage.eINSTANCE.getComponentWorld_DefaultCustomizationPipeline(),
			ComponentPackage.eINSTANCE.getComponentWorld_DefaultArchiveSelector()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == ComponentViewsRepository.ComponentWorld.Properties.infrastructure;
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
