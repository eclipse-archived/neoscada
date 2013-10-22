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
package org.eclipse.scada.configuration.component.exec;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.scada.configuration.component.DataComponent;
import org.eclipse.scada.configuration.infrastructure.Driver;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exec Job</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.exec.ExecJob#getRunsOn <em>Runs On</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.exec.ExecJob#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.component.exec.ExecComponentsPackage#getExecJob()
 * @model
 * @generated
 */
public interface ExecJob extends DataComponent
{
    /**
     * Returns the value of the '<em><b>Runs On</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Runs On</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Runs On</em>' reference.
     * @see #setRunsOn(Driver)
     * @see org.eclipse.scada.configuration.component.exec.ExecComponentsPackage#getExecJob_RunsOn()
     * @model required="true"
     * @generated
     */
    Driver getRunsOn ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.exec.ExecJob#getRunsOn <em>Runs On</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Runs On</em>' reference.
     * @see #getRunsOn()
     * @generated
     */
    void setRunsOn ( Driver value );

    /**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see org.eclipse.scada.configuration.component.exec.ExecComponentsPackage#getExecJob_Name()
     * @model required="true"
     * @generated
     */
    String getName ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.component.exec.ExecJob#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
    void setName ( String value );

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model required="true"
     * @generated
     */
    boolean hasExecDriver ( DiagnosticChain diagnostics, Map<Object, Object> context );

} // ExecJob
