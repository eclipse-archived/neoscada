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
package org.eclipse.scada.configuration.item.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.scada.configuration.item.CallSuper;
import org.eclipse.scada.configuration.item.CustomizationRequest;
import org.eclipse.scada.configuration.item.ItemPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Call Super</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class CallSuperImpl extends StepImpl implements CallSuper
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CallSuperImpl ()
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
        return ItemPackage.Literals.CALL_SUPER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void execute ( final CustomizationRequest request )
    {
        getContainingPipeline ().getParent ().customize ( request );
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
            case ItemPackage.CALL_SUPER___EXECUTE__CUSTOMIZATIONREQUEST:
                execute ( (CustomizationRequest)arguments.get ( 0 ) );
                return null;
        }
        return super.eInvoke ( operationID, arguments );
    }

} //CallSuperImpl
