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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Archive Server</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ValueArchiveServer#getArchives <em>Archives</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.ValueArchiveServer#getDefaultArchiveConfiguration <em>Default Archive Configuration</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getValueArchiveServer()
 * @model abstract="true"
 * @generated
 */
public interface ValueArchiveServer extends EquinoxApplication
{

    /**
     * Returns the value of the '<em><b>Archives</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.ValueArchive}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Archives</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Archives</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getValueArchiveServer_Archives()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<ValueArchive> getArchives ();

    /**
     * Returns the value of the '<em><b>Default Archive Configuration</b></em>' containment reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Default Archive Configuration</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Default Archive Configuration</em>' containment reference.
     * @see #setDefaultArchiveConfiguration(ArchiveConfiguration)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getValueArchiveServer_DefaultArchiveConfiguration()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    ArchiveConfiguration getDefaultArchiveConfiguration ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.ValueArchiveServer#getDefaultArchiveConfiguration <em>Default Archive Configuration</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Default Archive Configuration</em>' containment reference.
     * @see #getDefaultArchiveConfiguration()
     * @generated
     */
    void setDefaultArchiveConfiguration ( ArchiveConfiguration value );
} // ValueArchiveServer
