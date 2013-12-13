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
public interface RestInterceptorPropertiesEditionPart {



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
	 * @return the definition
	 * 
	 */
	public EObject getDefinition();

	/**
	 * Init the definition
	 * @param settings the combo setting
	 */
	public void initDefinition(EObjectFlatComboSettings settings);

	/**
	 * Defines a new definition
	 * @param newValue the new definition to set
	 * 
	 */
	public void setDefinition(EObject newValue);

	/**
	 * Defines the button mode
	 * @param newValue the new mode to set
	 * 
	 */
	public void setDefinitionButtonMode(ButtonsModeEnum newValue);

	/**
	 * Adds the given filter to the definition edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addFilterToDefinition(ViewerFilter filter);

	/**
	 * Adds the given filter to the definition edition editor.
	 * 
	 * @param filter
	 *            a viewer filter
	 * @see org.eclipse.jface.viewers.StructuredViewer#addFilter(ViewerFilter)
	 * 
	 */
	public void addBusinessFilterToDefinition(ViewerFilter filter);





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
