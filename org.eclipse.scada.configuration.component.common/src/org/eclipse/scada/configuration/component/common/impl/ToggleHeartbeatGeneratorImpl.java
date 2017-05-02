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
package org.eclipse.scada.configuration.component.common.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.scada.configuration.component.common.CommonPackage;
import org.eclipse.scada.configuration.component.common.ToggleHeartbeatGenerator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Toggle Heartbeat Generator</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ToggleHeartbeatGeneratorImpl extends HeartbeatGeneratorImpl implements ToggleHeartbeatGenerator
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ToggleHeartbeatGeneratorImpl ()
    {
        super ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass ()
    {
        return CommonPackage.Literals.TOGGLE_HEARTBEAT_GENERATOR;
    }

} //ToggleHeartbeatGeneratorImpl
