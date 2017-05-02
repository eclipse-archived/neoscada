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
package org.eclipse.scada.configuration.memory.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.scada.configuration.memory.MemoryPackage;
import org.eclipse.scada.configuration.memory.UnsignedInteger8Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unsigned Integer8 Type</b></em>
 * '.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class UnsignedInteger8TypeImpl extends BaseScalarTypeImpl implements UnsignedInteger8Type
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected UnsignedInteger8TypeImpl ()
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
        return MemoryPackage.Literals.UNSIGNED_INTEGER8_TYPE;
    }

    /**
     * @generated NOT
     */
    @Override
    public int getLength ()
    {
        return 1;
    }

    @Override
    public String encode ()
    {
        return String.format ( "UINT8:%s:0", this.index );
    }

} //UnsignedInteger8TypeImpl
