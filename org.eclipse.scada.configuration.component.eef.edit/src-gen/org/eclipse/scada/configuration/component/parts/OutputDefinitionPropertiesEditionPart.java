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
import org.eclipse.emf.common.util.EList;


// End of user code

/**
 * @author IBH SYSTEMS GmbH
 * 
 */
public interface OutputDefinitionPropertiesEditionPart {

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
	 * @return the localTag
	 * 
	 */
	public EList getLocalTag();

	/**
	 * Defines a new localTag
	 * @param newValue the new localTag to set
	 * 
	 */
	public void setLocalTag(EList newValue);

	/**
	 * Add a value to the localTag multivalued attribute.
	 * @param newValue the value to add
	 */
	public void addToLocalTag(Object newValue);

	/**
	 * Remove a value to the localTag multivalued attribute.
	 * @param newValue the value to remove
	 */
	public void removeToLocalTag(Object newValue);





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
