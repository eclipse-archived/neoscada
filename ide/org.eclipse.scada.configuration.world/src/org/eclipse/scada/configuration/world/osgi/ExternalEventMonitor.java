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
import org.eclipse.scada.configuration.world.PropertyEntry;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>External Event Monitor</b></em>
 * '.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ExternalEventMonitor#getFilter <em>Filter</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ExternalEventMonitor#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getExternalEventMonitor()
 * @model
 * @generated
 */
public interface ExternalEventMonitor extends NamedDocumentable
{
    /**
     * Returns the value of the '<em><b>Filter</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Filter</em>' attribute isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Filter</em>' attribute.
     * @see #setFilter(String)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getExternalEventMonitor_Filter()
     * @model required="true"
     * @generated
     */
    String getFilter ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.ExternalEventMonitor#getFilter <em>Filter</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Filter</em>' attribute.
     * @see #getFilter()
     * @generated
     */
    void setFilter ( String value );

    /**
     * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.PropertyEntry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Properties</em>' containment reference list
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Properties</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getExternalEventMonitor_Properties()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<PropertyEntry> getProperties ();

} // ExternalEventMonitor
