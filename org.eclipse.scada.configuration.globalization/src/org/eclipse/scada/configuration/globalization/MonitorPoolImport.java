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
package org.eclipse.scada.configuration.globalization;

import org.eclipse.scada.configuration.world.Documentable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Monitor Pool Import</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.globalization.MonitorPoolImport#getLocalName <em>Local Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.globalization.MonitorPoolImport#isIncludeLocal <em>Include Local</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.globalization.GlobalizePackage#getMonitorPoolImport()
 * @model
 * @generated
 */
public interface MonitorPoolImport extends Documentable
{
    /**
     * Returns the value of the '<em><b>Local Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Local Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Local Name</em>' attribute.
     * @see #setLocalName(String)
     * @see org.eclipse.scada.configuration.globalization.GlobalizePackage#getMonitorPoolImport_LocalName()
     * @model required="true"
     * @generated
     */
    String getLocalName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.globalization.MonitorPoolImport#getLocalName <em>Local Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Local Name</em>' attribute.
     * @see #getLocalName()
     * @generated
     */
    void setLocalName ( String value );

    /**
     * Returns the value of the '<em><b>Include Local</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Include Local</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Include Local</em>' attribute.
     * @see #setIncludeLocal(boolean)
     * @see org.eclipse.scada.configuration.globalization.GlobalizePackage#getMonitorPoolImport_IncludeLocal()
     * @model required="true"
     * @generated
     */
    boolean isIncludeLocal ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.globalization.MonitorPoolImport#isIncludeLocal <em>Include Local</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Include Local</em>' attribute.
     * @see #isIncludeLocal()
     * @generated
     */
    void setIncludeLocal ( boolean value );

} // MonitorPoolImport
