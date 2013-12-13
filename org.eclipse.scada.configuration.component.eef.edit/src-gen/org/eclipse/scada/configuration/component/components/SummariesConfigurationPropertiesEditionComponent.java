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
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.SummariesConfiguration;
import org.eclipse.scada.configuration.component.parts.ComponentViewsRepository;
import org.eclipse.scada.configuration.component.parts.SummariesConfigurationPropertiesEditionPart;


// End of user code

/**
 * @author IBH SYSTEMS GmbH
 * 
 */
public class SummariesConfigurationPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String BASE_PART = "Base"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public SummariesConfigurationPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject summariesConfiguration, String editing_mode) {
		super(editingContext, summariesConfiguration, editing_mode);
		parts = new String[] { BASE_PART };
		repositoryKey = ComponentViewsRepository.class;
		partKey = ComponentViewsRepository.SummariesConfiguration.class;
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
			
			final SummariesConfiguration summariesConfiguration = (SummariesConfiguration)elt;
			final SummariesConfigurationPropertiesEditionPart basePart = (SummariesConfigurationPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(ComponentViewsRepository.SummariesConfiguration.Properties.itemThreshold))
				basePart.setItemThreshold(EEFConverterUtil.convertToString(EcorePackage.Literals.EINTEGER_OBJECT, summariesConfiguration.getItemThreshold()));
			
			// init filters
			
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
		if (editorKey == ComponentViewsRepository.SummariesConfiguration.Properties.itemThreshold) {
			return ComponentPackage.eINSTANCE.getSummariesConfiguration_ItemThreshold();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		SummariesConfiguration summariesConfiguration = (SummariesConfiguration)semanticObject;
		if (ComponentViewsRepository.SummariesConfiguration.Properties.itemThreshold == event.getAffectedEditor()) {
			summariesConfiguration.setItemThreshold((java.lang.Integer)EEFConverterUtil.createFromString(EcorePackage.Literals.EINTEGER_OBJECT, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			SummariesConfigurationPropertiesEditionPart basePart = (SummariesConfigurationPropertiesEditionPart)editingPart;
			if (ComponentPackage.eINSTANCE.getSummariesConfiguration_ItemThreshold().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && basePart != null && isAccessible(ComponentViewsRepository.SummariesConfiguration.Properties.itemThreshold)) {
				if (msg.getNewValue() != null) {
					basePart.setItemThreshold(EcoreUtil.convertToString(EcorePackage.Literals.EINTEGER_OBJECT, msg.getNewValue()));
				} else {
					basePart.setItemThreshold("");
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
			ComponentPackage.eINSTANCE.getSummariesConfiguration_ItemThreshold()		);
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
				if (ComponentViewsRepository.SummariesConfiguration.Properties.itemThreshold == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(ComponentPackage.eINSTANCE.getSummariesConfiguration_ItemThreshold().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(ComponentPackage.eINSTANCE.getSummariesConfiguration_ItemThreshold().getEAttributeType(), newValue);
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
