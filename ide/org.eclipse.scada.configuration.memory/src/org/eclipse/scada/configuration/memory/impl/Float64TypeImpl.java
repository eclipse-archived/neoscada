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
import org.eclipse.scada.configuration.memory.Float64Type;
import org.eclipse.scada.configuration.memory.MemoryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Float64 Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class Float64TypeImpl extends BaseScalarTypeImpl implements Float64Type
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected Float64TypeImpl ()
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
        return MemoryPackage.Literals.FLOAT64_TYPE;
    }

    @Override
    public String encode ()
    {
        return String.format ( "DOUBLE:%s:0", this.index );
    }

    /**
     * @generated NOT
     */
    @Override
    public int getLength ()
    {
        return 8;
    }

} //Float64TypeImpl
