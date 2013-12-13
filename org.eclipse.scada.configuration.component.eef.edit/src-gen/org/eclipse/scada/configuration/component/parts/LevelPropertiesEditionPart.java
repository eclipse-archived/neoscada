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
public interface LevelPropertiesEditionPart {



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
	 * @return the parent
	 * 
	 */
	public EObject getParent_();

	/**
	 * Init the parent
	 * @param settings the combo setting
	 */
	public void initParent_(EObjectFlatComboSettings settings);

	/**
	 * Defines a new parent
	 * @param newValue the new parent to set
	 * 
	 */
	public void setParent_(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setParent_ButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the parent edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToParent_(ViewerFilter filter);

	/**
	 * Adds the given filter to the parent edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToParent_(ViewerFilter filter);


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
	 * Returns the internationalized title text.
	 * 
	 * @return the internationalized title text.
	 * 
	 */
	public String getTitle();

	// Start of user code for additional methods
	
	// End of user code

}
