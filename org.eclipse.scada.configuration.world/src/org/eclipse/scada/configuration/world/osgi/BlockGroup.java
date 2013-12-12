/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world.osgi;

import org.eclipse.emf.common.util.EList;
import org.eclipse.scada.configuration.world.Documentable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.BlockGroup#getHandlers <em>Handlers</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.BlockGroup#getHierarchy <em>Hierarchy</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getBlockGroup()
 * @model
 * @generated
 */
public interface BlockGroup extends Documentable {
	/**
	 * Returns the value of the '<em><b>Handlers</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.BlockHandler}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.scada.configuration.world.osgi.BlockHandler#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Handlers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Handlers</em>' reference list.
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getBlockGroup_Handlers()
	 * @see org.eclipse.scada.configuration.world.osgi.BlockHandler#getGroup
	 * @model opposite="group"
	 * @generated
	 */
	EList<BlockHandler> getHandlers();

	/**
	 * Returns the value of the '<em><b>Hierarchy</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hierarchy</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hierarchy</em>' attribute list.
	 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getBlockGroup_Hierarchy()
	 * @model
	 * @generated
	 */
	EList<String> getHierarchy();

} // BlockGroup
