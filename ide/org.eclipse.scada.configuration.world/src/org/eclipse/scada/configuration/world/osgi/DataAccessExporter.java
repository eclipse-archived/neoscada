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
 * A representation of the model object '<em><b>Data Access Exporter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.DataAccessExporter#getExports <em>Exports</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getDataAccessExporter()
 * @model
 * @generated
 */
public interface DataAccessExporter extends Exporter
{
    /**
     * Returns the value of the '<em><b>Exports</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.ItemExport}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Exports</em>' reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Exports</em>' containment reference list.
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getDataAccessExporter_Exports()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<ItemExport> getExports ();

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model kind="operation" required="true"
     *        annotation="http://www.eclipse.org/emf/2002/GenModel body='return \"da\";'"
     * @generated
     */
    String getTypeTag ();

} // DataAccessExporter
