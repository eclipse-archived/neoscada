/**
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.component.common;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.component.common.CommonPackage
 * @generated
 */
public interface CommonFactory extends EFactory
{
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    CommonFactory eINSTANCE = org.eclipse.scada.configuration.component.common.impl.CommonFactoryImpl.init ();

    /**
     * Returns a new object of class '<em>Toggle Heartbeat Generator</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Toggle Heartbeat Generator</em>'.
     * @generated
     */
    ToggleHeartbeatGenerator createToggleHeartbeatGenerator ();

    /**
     * Returns a new object of class '<em>Change Heartbeat Detector</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Change Heartbeat Detector</em>'.
     * @generated
     */
    ChangeHeartbeatDetector createChangeHeartbeatDetector ();

    /**
     * Returns a new object of class '<em>Timer Action</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Timer Action</em>'.
     * @generated
     */
    TimerAction createTimerAction ();

    /**
     * Returns a new object of class '<em>Current Time Component</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Current Time Component</em>'.
     * @generated
     */
    CurrentTimeComponent createCurrentTimeComponent ();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    CommonPackage getCommonPackage ();

} //CommonFactory
