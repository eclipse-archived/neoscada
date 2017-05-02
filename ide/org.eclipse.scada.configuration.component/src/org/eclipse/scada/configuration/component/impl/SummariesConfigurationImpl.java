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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.SummariesConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Summaries Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.SummariesConfigurationImpl#getItemThreshold <em>Item Threshold</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SummariesConfigurationImpl extends ConfigurationImpl implements SummariesConfiguration
{
    /**
     * The default value of the '{@link #getItemThreshold() <em>Item Threshold</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getItemThreshold()
     * @generated
     * @ordered
     */
    protected static final Integer ITEM_THRESHOLD_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getItemThreshold() <em>Item Threshold</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getItemThreshold()
     * @generated
     * @ordered
     */
    protected Integer itemThreshold = ITEM_THRESHOLD_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SummariesConfigurationImpl ()
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
        return ComponentPackage.Literals.SUMMARIES_CONFIGURATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Integer getItemThreshold ()
    {
        return itemThreshold;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setItemThreshold ( Integer newItemThreshold )
    {
        Integer oldItemThreshold = itemThreshold;
        itemThreshold = newItemThreshold;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.SUMMARIES_CONFIGURATION__ITEM_THRESHOLD, oldItemThreshold, itemThreshold ) );
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
            case ComponentPackage.SUMMARIES_CONFIGURATION__ITEM_THRESHOLD:
                return getItemThreshold ();
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
            case ComponentPackage.SUMMARIES_CONFIGURATION__ITEM_THRESHOLD:
                setItemThreshold ( (Integer)newValue );
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
            case ComponentPackage.SUMMARIES_CONFIGURATION__ITEM_THRESHOLD:
                setItemThreshold ( ITEM_THRESHOLD_EDEFAULT );
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
            case ComponentPackage.SUMMARIES_CONFIGURATION__ITEM_THRESHOLD:
                return ITEM_THRESHOLD_EDEFAULT == null ? itemThreshold != null : !ITEM_THRESHOLD_EDEFAULT.equals ( itemThreshold );
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
        result.append ( " (itemThreshold: " ); //$NON-NLS-1$
        result.append ( itemThreshold );
        result.append ( ')' );
        return result.toString ();
    }

} //SummariesConfigurationImpl
