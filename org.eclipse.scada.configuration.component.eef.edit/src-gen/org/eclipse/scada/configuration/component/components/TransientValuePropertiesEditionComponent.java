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
import org.eclipse.emf.eef.runtime.context.impl.EObjectPropertiesEditionContext;
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.filters.EObjectFilter;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.impl.utils.EEFUtils;
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
import org.eclipse.scada.configuration.component.TransientValue;
import org.eclipse.scada.configuration.component.parts.ComponentViewsRepository;
import org.eclipse.scada.configuration.component.parts.TransientValuePropertiesEditionPart;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.infrastructure.MasterServer;
import org.eclipse.scada.configuration.item.CustomizationPipeline;
import org.eclipse.scada.configuration.item.Selector;
import org.eclipse.scada.configuration.world.osgi.DataType;


// End of user code

/**
 * @author IBH SYSTEMS GmbH
 * 
 */
public class TransientValuePropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
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
	public TransientValuePropertiesEditionComponent(PropertiesEditingContext editingContext, EObject transientValue, String editing_mode) {
		super(editingContext, transientValue, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = ComponentViewsRepository.class;
		partKey = ComponentViewsRepository.TransientValue.class;
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
			
			final TransientValue transientValue = (TransientValue)elt;
			final TransientValuePropertiesEditionPart basePart = (TransientValuePropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(ComponentViewsRepository.TransientValue.Properties.level)) {
				// init part
				levelSettings = new EObjectFlatComboSettings(transientValue, ComponentPackage.eINSTANCE.getComponent_Level());
				basePart.initLevel(levelSettings);
				// set the button mode
				basePart.setLevelButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(ComponentViewsRepository.TransientValue.Properties.customizationPipeline)) {
				// init part
				customizationPipelineSettings = new EObjectFlatComboSettings(transientValue, ComponentPackage.eINSTANCE.getComponent_CustomizationPipeline());
				basePart.initCustomizationPipeline(customizationPipelineSettings);
				// set the button mode
				basePart.setCustomizationPipelineButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(ComponentViewsRepository.TransientValue.Properties.archiveSelector)) {
				// init part
				archiveSelectorSettings = new EObjectFlatComboSettings(transientValue, ComponentPackage.eINSTANCE.getComponent_ArchiveSelector());
				basePart.initArchiveSelector(archiveSelectorSettings);
				// set the button mode
				basePart.setArchiveSelectorButtonMode(ButtonsModeEnum.BROWSE);
			}
			if (isAccessible(ComponentViewsRepository.TransientValue.Properties.masterOn)) {
				masterOnSettings = new ReferencesTableSettings(transientValue, ComponentPackage.eINSTANCE.getMasterComponent_MasterOn());
				basePart.initMasterOn(masterOnSettings);
			}
			if (isAccessible(ComponentViewsRepository.TransientValue.Properties.name))
				basePart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, transientValue.getName()));
			
			if (isAccessible(ComponentViewsRepository.TransientValue.Properties.dataType)) {
				basePart.initDataType(EEFUtils.choiceOfValues(transientValue, ComponentPackage.eINSTANCE.getSingleValue_DataType()), transientValue.getDataType());
			}
			if (isAccessible(ComponentViewsRepository.TransientValue.Properties.customizationTags))
				basePart.setCustomizationTags(transientValue.getCustomizationTags());
			
			// init filters
			if (isAccessible(ComponentViewsRepository.TransientValue.Properties.level)) {
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
			if (isAccessible(ComponentViewsRepository.TransientValue.Properties.customizationPipeline)) {
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
			if (isAccessible(ComponentViewsRepository.TransientValue.Properties.archiveSelector)) {
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
			if (isAccessible(ComponentViewsRepository.TransientValue.Properties.masterOn)) {
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
		if (editorKey == ComponentViewsRepository.TransientValue.Properties.level) {
			return ComponentPackage.eINSTANCE.getComponent_Level();
		}
		if (editorKey == ComponentViewsRepository.TransientValue.Properties.customizationPipeline) {
			return ComponentPackage.eINSTANCE.getComponent_CustomizationPipeline();
		}
		if (editorKey == ComponentViewsRepository.TransientValue.Properties.archiveSelector) {
			return ComponentPackage.eINSTANCE.getComponent_ArchiveSelector();
		}
		if (editorKey == ComponentViewsRepository.TransientValue.Properties.masterOn) {
			return ComponentPackage.eINSTANCE.getMasterComponent_MasterOn();
		}
		if (editorKey == ComponentViewsRepository.TransientValue.Properties.name) {
			return ComponentPackage.eINSTANCE.getSingleValue_Name();
		}
		if (editorKey == ComponentViewsRepository.TransientValue.Properties.dataType) {
			return ComponentPackage.eINSTANCE.getSingleValue_DataType();
		}
		if (editorKey == ComponentViewsRepository.TransientValue.Properties.customizationTags) {
			return ComponentPackage.eINSTANCE.getSingleValue_CustomizationTags();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		TransientValue transientValue = (TransientValue)semanticObject;
		if (ComponentViewsRepository.TransientValue.Properties.level == event.getAffectedEditor()) {
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
		if (ComponentViewsRepository.TransientValue.Properties.customizationPipeline == event.getAffectedEditor()) {
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
		if (ComponentViewsRepository.TransientValue.Properties.archiveSelector == event.getAffectedEditor()) {
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
		if (ComponentViewsRepository.TransientValue.Properties.masterOn == event.getAffectedEditor()) {
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
		if (ComponentViewsRepository.TransientValue.Properties.name == event.getAffectedEditor()) {
			transientValue.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (ComponentViewsRepository.TransientValue.Properties.dataType == event.getAffectedEditor()) {
			transientValue.setDataType((DataType)event.getNewValue());
		}
		if (ComponentViewsRepository.TransientValue.Properties.customizationTags == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				transientValue.getCustomizationTags().clear();
				transientValue.getCustomizationTags().addAll(((EList) event.getNewValue()));
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
			TransientValuePropertiesEditionPart basePart = (TransientValuePropertiesEditionPart)editingPart;
			if (ComponentPackage.eINSTANCE.getComponent_Level().equals(msg.getFeature()) && basePart != null && isAccessible(ComponentViewsRepository.TransientValue.Properties.level))
				basePart.setLevel((EObject)msg.getNewValue());
			if (ComponentPackage.eINSTANCE.getComponent_CustomizationPipeline().equals(msg.getFeature()) && basePart != null && isAccessible(ComponentViewsRepository.TransientValue.Properties.customizationPipeline))
				basePart.setCustomizationPipeline((EObject)msg.getNewValue());
			if (ComponentPackage.eINSTANCE.getComponent_ArchiveSelector().equals(msg.getFeature()) && basePart != null && isAccessible(ComponentViewsRepository.TransientValue.Properties.archiveSelector))
				basePart.setArchiveSelector((EObject)msg.getNewValue());
			if (ComponentPackage.eINSTANCE.getMasterComponent_MasterOn().equals(msg.getFeature())  && isAccessible(ComponentViewsRepository.TransientValue.Properties.masterOn))
				basePart.updateMasterOn();
			if (ComponentPackage.eINSTANCE.getSingleValue_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(ComponentViewsRepository.TransientValue.Properties.name)) {
				if (msg.getNewValue() != null) {
					basePart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					basePart.setName("");
				}
			}
			if (ComponentPackage.eINSTANCE.getSingleValue_DataType().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && isAccessible(ComponentViewsRepository.TransientValue.Properties.dataType))
				basePart.setDataType((DataType)msg.getNewValue());
			
			if (ComponentPackage.eINSTANCE.getSingleValue_CustomizationTags().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(ComponentViewsRepository.TransientValue.Properties.customizationTags)) {
				if (msg.getNewValue() instanceof EList<?>) {
					basePart.setCustomizationTags((EList<?>)msg.getNewValue());
				} else if (msg.getNewValue() == null) {
					basePart.setCustomizationTags(new BasicEList<Object>());
				} else {
					BasicEList<Object> newValueAsList = new BasicEList<Object>();
					newValueAsList.add(msg.getNewValue());
					basePart.setCustomizationTags(newValueAsList);
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
			ComponentPackage.eINSTANCE.getComponent_Level(),
			ComponentPackage.eINSTANCE.getComponent_CustomizationPipeline(),
			ComponentPackage.eINSTANCE.getComponent_ArchiveSelector(),
			ComponentPackage.eINSTANCE.getMasterComponent_MasterOn(),
			ComponentPackage.eINSTANCE.getSingleValue_Name(),
			ComponentPackage.eINSTANCE.getSingleValue_DataType(),
			ComponentPackage.eINSTANCE.getSingleValue_CustomizationTags()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#isRequired(java.lang.Object, int)
	 * 
	 */
	public boolean isRequired(Object key, int kind) {
		return key == ComponentViewsRepository.TransientValue.Properties.name;
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
				if (ComponentViewsRepository.TransientValue.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(ComponentPackage.eINSTANCE.getSingleValue_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(ComponentPackage.eINSTANCE.getSingleValue_Name().getEAttributeType(), newValue);
				}
				if (ComponentViewsRepository.TransientValue.Properties.dataType == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(ComponentPackage.eINSTANCE.getSingleValue_DataType().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(ComponentPackage.eINSTANCE.getSingleValue_DataType().getEAttributeType(), newValue);
				}
				if (ComponentViewsRepository.TransientValue.Properties.customizationTags == event.getAffectedEditor()) {
					BasicDiagnostic chain = new BasicDiagnostic();
					for (Iterator iterator = ((List)event.getNewValue()).iterator(); iterator.hasNext();) {
						chain.add(Diagnostician.INSTANCE.validate(ComponentPackage.eINSTANCE.getSingleValue_CustomizationTags().getEAttributeType(), iterator.next()));
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
