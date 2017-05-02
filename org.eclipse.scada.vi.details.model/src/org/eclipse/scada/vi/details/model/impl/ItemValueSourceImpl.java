/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.details.model.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.vi.details.model.DetailViewPackage;
import org.eclipse.scada.vi.details.model.ItemValueSource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Item Value Source</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.ItemValueSourceImpl#getValueKey <em>Value Key</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ItemValueSourceImpl extends ValueSourceImpl implements ItemValueSource
{
    /**
     * The default value of the '{@link #getValueKey() <em>Value Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValueKey()
     * @generated
     * @ordered
     */
    protected static final String VALUE_KEY_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getValueKey() <em>Value Key</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValueKey()
     * @generated
     * @ordered
     */
    protected String valueKey = VALUE_KEY_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ItemValueSourceImpl ()
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
        return DetailViewPackage.Literals.ITEM_VALUE_SOURCE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getValueKey ()
    {
        return valueKey;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setValueKey ( String newValueKey )
    {
        String oldValueKey = valueKey;
        valueKey = newValueKey;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.ITEM_VALUE_SOURCE__VALUE_KEY, oldValueKey, valueKey ) );
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
            case DetailViewPackage.ITEM_VALUE_SOURCE__VALUE_KEY:
                return getValueKey ();
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
            case DetailViewPackage.ITEM_VALUE_SOURCE__VALUE_KEY:
                setValueKey ( (String)newValue );
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
            case DetailViewPackage.ITEM_VALUE_SOURCE__VALUE_KEY:
                setValueKey ( VALUE_KEY_EDEFAULT );
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
            case DetailViewPackage.ITEM_VALUE_SOURCE__VALUE_KEY:
                return VALUE_KEY_EDEFAULT == null ? valueKey != null : !VALUE_KEY_EDEFAULT.equals ( valueKey );
        }
        return super.eIsSet ( featureID );
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
        result.append ( " (valueKey: " ); //$NON-NLS-1$
        result.append ( valueKey );
        result.append ( ')' );
        return result.toString ();
    }

} //ItemValueSourceImpl
