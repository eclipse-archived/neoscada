/**
 * Copyright (c) 2013 IBH SYSTEMS GmbH.
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
import org.eclipse.scada.configuration.world.PropertyEntry;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rest Exporter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.RestExporter#getItems <em>Items</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.RestExporter#getHiveProperties <em>Hive Properties</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.RestExporter#getContextId <em>Context Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getRestExporter()
 * @model
 * @generated
 */
public interface RestExporter extends ApplicationModule
{
    /**
     * Returns the value of the '<em><b>Items</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.Item}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Items</em>' reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Items</em>' reference list.
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getRestExporter_Items()
     * @model
     * @generated
     */
    EList<Item> getItems ();

    /**
     * Returns the value of the '<em><b>Hive Properties</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.PropertyEntry}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Hive Properties</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Hive Properties</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getRestExporter_HiveProperties()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<PropertyEntry> getHiveProperties ();

    /**
     * Returns the value of the '<em><b>Context Id</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Context Id</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Context Id</em>' attribute.
     * @see #setContextId(String)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getRestExporter_ContextId()
     * @model required="true"
     * @generated
     */
    String getContextId ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.RestExporter#getContextId <em>Context Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Context Id</em>' attribute.
     * @see #getContextId()
     * @generated
     */
    void setContextId ( String value );

} // RestExporter
