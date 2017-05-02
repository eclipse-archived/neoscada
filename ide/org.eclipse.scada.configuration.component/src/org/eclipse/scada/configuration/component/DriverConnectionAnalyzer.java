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
package org.eclipse.scada.configuration.component;

import org.eclipse.scada.configuration.infrastructure.Driver;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Driver Connection Analyzer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.DriverConnectionAnalyzer#getDriver <em>Driver</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.component.ComponentPackage#getDriverConnectionAnalyzer()
 * @model
 * @generated
 */
public interface DriverConnectionAnalyzer extends MasterComponent
{
    /**
     * Returns the value of the '<em><b>Driver</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Driver</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Driver</em>' reference.
     * @see #setDriver(Driver)
     * @see org.eclipse.scada.configuration.component.ComponentPackage#getDriverConnectionAnalyzer_Driver()
     * @model required="true"
     * @generated
     */
    Driver getDriver ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.DriverConnectionAnalyzer#getDriver <em>Driver</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Driver</em>' reference.
     * @see #getDriver()
     * @generated
     */
    void setDriver ( Driver value );

} // DriverConnectionAnalyzer
