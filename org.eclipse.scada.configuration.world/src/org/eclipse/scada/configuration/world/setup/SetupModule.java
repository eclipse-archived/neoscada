/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.world.setup;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.utils.ecore.validation.ValidationContext;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.scada.configuration.world.setup.SetupPackage#getSetupModule()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface SetupModule extends EObject
{

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @model contextDataType="org.eclipse.scada.configuration.world.ValidationContext"
     * @generated
     */
    void validateOperatingSystem ( OperatingSystemDescriptor descriptor, ValidationContext context );
} // SetupModule
