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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.component.exec.ExecComponentsPackage
 * @generated
 */
public interface ExecComponentsFactory extends EFactory
{
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ExecComponentsFactory eINSTANCE = org.eclipse.scada.configuration.component.exec.impl.ExecComponentsFactoryImpl.init ();

    /**
     * Returns a new object of class '<em>Exec Job</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Exec Job</em>'.
     * @generated
     */
    ExecJob createExecJob ();

    /**
     * Returns a new object of class '<em>Load Average</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Load Average</em>'.
     * @generated
     */
    LoadAverage createLoadAverage ();

    /**
     * Returns a new object of class '<em>Load Average Configuration</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Load Average Configuration</em>'.
     * @generated
     */
    LoadAverageConfiguration createLoadAverageConfiguration ();

    /**
     * Returns a new object of class '<em>Ping Check</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Ping Check</em>'.
     * @generated
     */
    PingCheck createPingCheck ();

    /**
     * Returns a new object of class '<em>Ping Check Configuration</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Ping Check Configuration</em>'.
     * @generated
     */
    PingCheckConfiguration createPingCheckConfiguration ();

    /**
     * Returns a new object of class '<em>System Information VM Stat</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>System Information VM Stat</em>'.
     * @generated
     */
    SystemInformationVMStat createSystemInformationVMStat ();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    ExecComponentsPackage getExecComponentsPackage ();

} //ExecComponentsFactory
