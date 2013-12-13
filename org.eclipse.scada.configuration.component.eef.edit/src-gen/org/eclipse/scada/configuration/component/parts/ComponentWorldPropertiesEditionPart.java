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

// Start of user code for imports
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * @author IBH SYSTEMS GmbH
 * 
 */
public interface ComponentWorldPropertiesEditionPart {



	/**
	 * Init the itemInterceptors
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initItemInterceptors(ReferencesTableSettings settings);

	/**
	 * Update the itemInterceptors
	 * @param newValue the itemInterceptors to update
	 * 
	 */
	public void updateItemInterceptors();

	/**
	 * Adds the given filter to the itemInterceptors edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToItemInterceptors(ViewerFilter filter);

	/**
	 * Adds the given filter to the itemInterceptors edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToItemInterceptors(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the itemInterceptors table
	 * 
	 */
	public boolean isContainedInItemInterceptorsTable(EObject element);




	/**
	 * Init the configurations
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initConfigurations(ReferencesTableSettings settings);

	/**
	 * Update the configurations
	 * @param newValue the configurations to update
	 * 
	 */
	public void updateConfigurations();

	/**
	 * Adds the given filter to the configurations edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToConfigurations(ViewerFilter filter);

	/**
	 * Adds the given filter to the configurations edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToConfigurations(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the configurations table
	 * 
	 */
	public boolean isContainedInConfigurationsTable(EObject element);




	/**
	 * Init the services
	 * @param current the current value
	 * @param containgFeature the feature where to navigate if necessary
	 * @param feature the feature to manage
	 */
	public void initServices(ReferencesTableSettings settings);

	/**
	 * Update the services
	 * @param newValue the services to update
	 * 
	 */
	public void updateServices();

	/**
	 * Adds the given filter to the services edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToServices(ViewerFilter filter);

	/**
	 * Adds the given filter to the services edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToServices(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the services table
	 * 
	 */
	public boolean isContainedInServicesTable(EObject element);


	/**
	 * @return the infrastructure
	 * 
	 */
	public EObject getInfrastructure();

	/**
	 * Init the infrastructure
	 * @param settings the combo setting
	 */
	public void initInfrastructure(EObjectFlatComboSettings settings);

	/**
	 * Defines a new infrastructure
	 * @param newValue the new infrastructure to set
	 * 
	 */
	public void setInfrastructure(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setInfrastructureButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the infrastructure edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToInfrastructure(ViewerFilter filter);

	/**
	 * Adds the given filter to the infrastructure edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToInfrastructure(ViewerFilter filter);


	/**
	 * @return the defaultCustomizationPipeline
	 * 
	 */
	public EObject getDefaultCustomizationPipeline();

	/**
	 * Init the defaultCustomizationPipeline
	 * @param settings the combo setting
	 */
	public void initDefaultCustomizationPipeline(EObjectFlatComboSettings settings);

	/**
	 * Defines a new defaultCustomizationPipeline
	 * @param newValue the new defaultCustomizationPipeline to set
	 * 
	 */
	public void setDefaultCustomizationPipeline(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setDefaultCustomizationPipelineButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the defaultCustomizationPipeline edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToDefaultCustomizationPipeline(ViewerFilter filter);

	/**
	 * Adds the given filter to the defaultCustomizationPipeline edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToDefaultCustomizationPipeline(ViewerFilter filter);


	/**
	 * @return the defaultArchiveSelector
	 * 
	 */
	public EObject getDefaultArchiveSelector();

	/**
	 * Init the defaultArchiveSelector
	 * @param settings the combo setting
	 */
	public void initDefaultArchiveSelector(EObjectFlatComboSettings settings);

	/**
	 * Defines a new defaultArchiveSelector
	 * @param newValue the new defaultArchiveSelector to set
	 * 
	 */
	public void setDefaultArchiveSelector(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setDefaultArchiveSelectorButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the defaultArchiveSelector edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToDefaultArchiveSelector(ViewerFilter filter);

	/**
	 * Adds the given filter to the defaultArchiveSelector edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToDefaultArchiveSelector(ViewerFilter filter);





	/**
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
