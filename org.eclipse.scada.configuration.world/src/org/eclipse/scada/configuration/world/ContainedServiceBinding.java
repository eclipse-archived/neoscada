/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.world;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contained Service Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.ContainedServiceBinding#getService <em>Service</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.world.WorldPackage#getContainedServiceBinding()
 * @model
 * @generated
 */
public interface ContainedServiceBinding extends ServiceBinding
{
    /**
     * Returns the value of the '<em><b>Service</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Service</em>' containment reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Service</em>' containment reference.
     * @see #setService(EObject)
     * @see org.eclipse.scada.configuration.world.WorldPackage#getContainedServiceBinding_Service()
     * @model containment="true" resolveProxies="true" required="true"
     * @generated
     */
    EObject getService ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.ContainedServiceBinding#getService <em>Service</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Service</em>' containment reference.
     * @see #getService()
     * @generated
     */
    void setService ( EObject value );

} // ContainedServiceBinding
