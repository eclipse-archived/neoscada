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
 * A representation of the model object '<em><b>Monitor Pool Proxy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.MonitorPoolProxy#getLocal <em>Local</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.MonitorPoolProxy#getRemote <em>Remote</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getMonitorPoolProxy()
 * @model
 * @generated
 */
public interface MonitorPoolProxy extends NamedDocumentable
{
    /**
     * Returns the value of the '<em><b>Local</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.MonitorPool}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Local</em>' reference list isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Local</em>' reference list.
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getMonitorPoolProxy_Local()
     * @model
     * @generated
     */
    EList<MonitorPool> getLocal ();

    /**
     * Returns the value of the '<em><b>Remote</b></em>' reference list.
     * The list contents are of type {@link org.eclipse.scada.configuration.world.osgi.MonitorPool}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Remote</em>' reference list isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Remote</em>' reference list.
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getMonitorPoolProxy_Remote()
     * @model
     * @generated
     */
    EList<MonitorPool> getRemote ();

} // MonitorPoolProxy
