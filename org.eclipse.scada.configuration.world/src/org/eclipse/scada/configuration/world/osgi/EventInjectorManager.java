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
package org.eclipse.scada.configuration.world.osgi;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Injector Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.EventInjectorManager#getHandler <em>Handler</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEventInjectorManager()
 * @model
 * @generated
 */
public interface EventInjectorManager extends IndependentConfiguration
{
    /**
     * Returns the value of the '<em><b>Handler</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.EventHandler}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Handler</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Handler</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getEventInjectorManager_Handler()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<EventHandler> getHandler ();

} // EventInjectorManager
