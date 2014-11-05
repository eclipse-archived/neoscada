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
import org.eclipse.scada.configuration.memory.SignedInteger16Type;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Signed Integer16 Type</b></em>
 * '.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class SignedInteger16TypeImpl extends OrderedTypeImpl implements SignedInteger16Type
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SignedInteger16TypeImpl ()
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
        return MemoryPackage.Literals.SIGNED_INTEGER16_TYPE;
    }

    /**
     * @generated NOT
     */
    @Override
    public int getLength ()
    {
        return 2;
    }

    @Override
    public String encode ()
    {
        return String.format ( "INT16:%s:0:%s", this.index, this.order );
    }

} //SignedInteger16TypeImpl
