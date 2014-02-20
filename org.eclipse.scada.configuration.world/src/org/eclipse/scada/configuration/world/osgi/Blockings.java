/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
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
import org.eclipse.scada.configuration.world.NamedDocumentable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Blockings</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.Blockings#getGroups <em>Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getBlockings()
 * @model
 * @generated
 */
public interface Blockings extends NamedDocumentable, ApplicationModule
{
    /**
     * Returns the value of the '<em><b>Groups</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.BlockGroup}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Groups</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Groups</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getBlockings_Groups()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<BlockGroup> getGroups ();

} // Blockings
