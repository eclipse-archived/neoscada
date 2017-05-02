/**
 * Copyright (c) 2015 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.component.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.ReadOnlySingleValue;
import org.eclipse.scada.configuration.component.SingleValue;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Read Only Single Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ReadOnlySingleValueImpl extends SingleValueImpl implements ReadOnlySingleValue
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ReadOnlySingleValueImpl ()
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
        return ComponentPackage.Literals.READ_ONLY_SINGLE_VALUE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isWritable ()
    {
        return false;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eDerivedOperationID ( int baseOperationID, Class<?> baseClass )
    {
        if ( baseClass == SingleValue.class )
        {
            switch ( baseOperationID )
            {
                case ComponentPackage.SINGLE_VALUE___IS_WRITABLE:
                    return ComponentPackage.READ_ONLY_SINGLE_VALUE___IS_WRITABLE;
                default:
                    return super.eDerivedOperationID ( baseOperationID, baseClass );
            }
        }
        return super.eDerivedOperationID ( baseOperationID, baseClass );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eInvoke ( int operationID, EList<?> arguments ) throws InvocationTargetException
    {
        switch ( operationID )
        {
            case ComponentPackage.READ_ONLY_SINGLE_VALUE___IS_WRITABLE:
                return isWritable ();
        }
        return super.eInvoke ( operationID, arguments );
    }

} //ReadOnlySingleValueImpl
