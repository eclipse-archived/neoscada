/**
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.component;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.configuration.world.PropertyEntry;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.Container#getItemInterceptors <em>Item Interceptors</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.Container#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.component.ComponentPackage#getContainer()
 * @model abstract="true"
 * @generated
 */
public interface Container extends EObject
{
    /**
     * Returns the value of the '<em><b>Item Interceptors</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.component.ItemInterceptor}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Item Interceptors</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Item Interceptors</em>' containment reference list.
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getContainer_ItemInterceptors()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<ItemInterceptor> getItemInterceptors ();

    /**
     * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.PropertyEntry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Properties</em>' containment reference list.
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getContainer_Properties()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<PropertyEntry> getProperties ();

} // Container
