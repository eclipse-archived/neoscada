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
import org.eclipse.scada.configuration.memory.UnsignedInteger32Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '
 * <em><b>Unsigned Integer32 Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class UnsignedInteger32TypeImpl extends OrderedTypeImpl implements UnsignedInteger32Type
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected UnsignedInteger32TypeImpl ()
    {
        super ();
    }

    @Override
    public String encode ()
    {
        return String.format ( "DINT:%s:0:%s", this.index, this.order );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass ()
    {
        return MemoryPackage.Literals.UNSIGNED_INTEGER32_TYPE;
    }

    /**
     * @generated NOT
     */
    @Override
    public int getLength ()
    {
        return 4;
    }

} //UnsignedInteger32TypeImpl
