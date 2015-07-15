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
package org.eclipse.scada.configuration.world;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>World</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.World#getNodes <em>Nodes</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.World#getOptions <em>Options</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.world.WorldPackage#getWorld()
 * @model
 * @generated
 */
public interface World extends EObject
{
    /**
     * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.Node}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Nodes</em>' containment reference list isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Nodes</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.WorldPackage#getWorld_Nodes()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<Node> getNodes ();

    /**
     * Returns the value of the '<em><b>Options</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Options</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Options</em>' containment reference.
     * @see #setOptions(Options)
     * @see org.eclipse.scada.configuration.world.WorldPackage#getWorld_Options()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    Options getOptions ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.World#getOptions <em>Options</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Options</em>' containment reference.
     * @see #getOptions()
     * @generated
     */
    void setOptions ( Options value );

} // World
