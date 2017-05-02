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
package org.eclipse.scada.configuration.component.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.DanglingItemReference;
import org.eclipse.scada.configuration.component.ItemReferenceInputDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '
 * <em><b>Item Reference Input Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.ItemReferenceInputDefinitionImpl#getItemId <em>Item Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ItemReferenceInputDefinitionImpl extends InputDefinitionImpl implements ItemReferenceInputDefinition
{
    /**
     * The default value of the '{@link #getItemId() <em>Item Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getItemId()
     * @generated
     * @ordered
     */
    protected static final String ITEM_ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getItemId() <em>Item Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getItemId()
     * @generated
     * @ordered
     */
    protected String itemId = ITEM_ID_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ItemReferenceInputDefinitionImpl ()
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
        return ComponentPackage.Literals.ITEM_REFERENCE_INPUT_DEFINITION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getItemId ()
    {
        return itemId;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setItemId ( String newItemId )
    {
        String oldItemId = itemId;
        itemId = newItemId;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.ITEM_REFERENCE_INPUT_DEFINITION__ITEM_ID, oldItemId, itemId ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DanglingItemReference createReference ()
    {
        final org.eclipse.scada.configuration.component.AbsoluteDanglingReference danglingRef = org.eclipse.scada.configuration.component.ComponentFactory.eINSTANCE.createAbsoluteDanglingReference ();
        danglingRef.setName ( getItemId () );
        return danglingRef;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet ( int featureID, boolean resolve, boolean coreType )
    {
        switch ( featureID )
        {
            case ComponentPackage.ITEM_REFERENCE_INPUT_DEFINITION__ITEM_ID:
                return getItemId ();
        }
        return super.eGet ( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eSet ( int featureID, Object newValue )
    {
        switch ( featureID )
        {
            case ComponentPackage.ITEM_REFERENCE_INPUT_DEFINITION__ITEM_ID:
                setItemId ( (String)newValue );
                return;
        }
        super.eSet ( featureID, newValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset ( int featureID )
    {
        switch ( featureID )
        {
            case ComponentPackage.ITEM_REFERENCE_INPUT_DEFINITION__ITEM_ID:
                setItemId ( ITEM_ID_EDEFAULT );
                return;
        }
        super.eUnset ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet ( int featureID )
    {
        switch ( featureID )
        {
            case ComponentPackage.ITEM_REFERENCE_INPUT_DEFINITION__ITEM_ID:
                return ITEM_ID_EDEFAULT == null ? itemId != null : !ITEM_ID_EDEFAULT.equals ( itemId );
        }
        return super.eIsSet ( featureID );
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
            case ComponentPackage.ITEM_REFERENCE_INPUT_DEFINITION___CREATE_REFERENCE:
                return createReference ();
        }
        return super.eInvoke ( operationID, arguments );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString ()
    {
        if ( eIsProxy () )
            return super.toString ();

        StringBuffer result = new StringBuffer ( super.toString () );
        result.append ( " (itemId: " ); //$NON-NLS-1$
        result.append ( itemId );
        result.append ( ')' );
        return result.toString ();
    }

} //ItemReferenceInputDefinitionImpl
