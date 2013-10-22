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
package org.eclipse.scada.configuration.memory.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.scada.configuration.memory.MemoryPackage;
import org.eclipse.scada.configuration.memory.UnsignedInteger16Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '
 * <em><b>Unsigned Integer16 Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class UnsignedInteger16TypeImpl extends BaseScalarTypeImpl implements UnsignedInteger16Type
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected UnsignedInteger16TypeImpl ()
    {
        super ();
    }

    @Override
    public String encode ()
    {
        return String.format ( "WORD:%s:0", this.index );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass ()
    {
        return MemoryPackage.Literals.UNSIGNED_INTEGER16_TYPE;
    }

} //UnsignedInteger16TypeImpl
