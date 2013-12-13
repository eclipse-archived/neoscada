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
public interface MappedSourceValuePropertiesEditionPart {

	/**
	 * @return the shortDescription
	 * 
	 */
	public String getShortDescription();

	/**
	 * Defines a new shortDescription
	 * @param newValue the new shortDescription to set
	 * 
	 */
	public void setShortDescription(String newValue);


	/**
	 * @return the name
	 * 
	 */
	public String getName();

	/**
	 * Defines a new name
	 * @param newValue the new name to set
	 * 
	 */
	public void setName(String newValue);


	/**
	 * @return the level
	 * 
	 */
	public EObject getLevel();

	/**
	 * Init the level
	 * @param settings the combo setting
	 */
	public void initLevel(EObjectFlatComboSettings settings);

	/**
	 * Defines a new level
	 * @param newValue the new level to set
	 * 
	 */
	public void setLevel(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setLevelButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the level edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToLevel(ViewerFilter filter);

	/**
	 * Adds the given filter to the level edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToLevel(ViewerFilter filter);


	/**
	 * @return the customizationPipeline
	 * 
	 */
	public EObject getCustomizationPipeline();

	/**
	 * Init the customizationPipeline
	 * @param settings the combo setting
	 */
	public void initCustomizationPipeline(EObjectFlatComboSettings settings);

	/**
	 * Defines a new customizationPipeline
	 * @param newValue the new customizationPipeline to set
	 * 
	 */
	public void setCustomizationPipeline(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setCustomizationPipelineButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the customizationPipeline edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToCustomizationPipeline(ViewerFilter filter);

	/**
	 * Adds the given filter to the customizationPipeline edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToCustomizationPipeline(ViewerFilter filter);


	/**
	 * @return the archiveSelector
	 * 
	 */
	public EObject getArchiveSelector();

	/**
	 * Init the archiveSelector
	 * @param settings the combo setting
	 */
	public void initArchiveSelector(EObjectFlatComboSettings settings);

	/**
	 * Defines a new archiveSelector
	 * @param newValue the new archiveSelector to set
	 * 
	 */
	public void setArchiveSelector(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setArchiveSelectorButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the archiveSelector edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToArchiveSelector(ViewerFilter filter);

	/**
	 * Adds the given filter to the archiveSelector edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToArchiveSelector(ViewerFilter filter);




	/**
	 * Init the masterOn
	 * @param settings settings for the masterOn ReferencesTable 
	 */
	public void initMasterOn(ReferencesTableSettings settings);

	/**
	 * Update the masterOn
	 * @param newValue the masterOn to update
	 * 
	 */
	public void updateMasterOn();

	/**
	 * Adds the given filter to the masterOn edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToMasterOn(ViewerFilter filter);

	/**
	 * Adds the given filter to the masterOn edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToMasterOn(ViewerFilter filter);

	/**
	 * @return true if the given element is contained inside the masterOn table
	 * 
	 */
	public boolean isContainedInMasterOnTable(EObject element);


	/**
	 * @return the mapper
	 * 
	 */
	public EObject getMapper();

	/**
	 * Init the mapper
	 * @param settings the combo setting
	 */
	public void initMapper(EObjectFlatComboSettings settings);

	/**
	 * Defines a new mapper
	 * @param newValue the new mapper to set
	 * 
	 */
	public void setMapper(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setMapperButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the mapper edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToMapper(ViewerFilter filter);

	/**
	 * Adds the given filter to the mapper edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToMapper(ViewerFilter filter);





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
