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
package org.eclipse.scada.configuration.memory.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.scada.configuration.memory.MemoryPackage;
import org.eclipse.scada.configuration.memory.SignedInteger8Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Signed Integer8 Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class SignedInteger8TypeImpl extends BaseScalarTypeImpl implements SignedInteger8Type
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SignedInteger8TypeImpl ()
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
        return MemoryPackage.Literals.SIGNED_INTEGER8_TYPE;
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
        return String.format ( "INT8:%s:0", this.index );
    }

} //SignedInteger8TypeImpl
