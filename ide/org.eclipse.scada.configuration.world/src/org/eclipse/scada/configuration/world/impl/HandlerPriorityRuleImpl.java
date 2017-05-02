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
package org.eclipse.scada.configuration.world.impl;

import java.util.regex.Pattern;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.scada.configuration.world.HandlerPriorityRule;
import org.eclipse.scada.configuration.world.WorldPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Handler Priority Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.impl.HandlerPriorityRuleImpl#getOrder <em>Order</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.impl.HandlerPriorityRuleImpl#getFactoryId <em>Factory Id</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.impl.HandlerPriorityRuleImpl#getConfigurationFilter <em>Configuration Filter</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.impl.HandlerPriorityRuleImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.impl.HandlerPriorityRuleImpl#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HandlerPriorityRuleImpl extends MinimalEObjectImpl.Container implements HandlerPriorityRule
{
    /**
     * The default value of the '{@link #getOrder() <em>Order</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOrder()
     * @generated
     * @ordered
     */
    protected static final int ORDER_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getOrder() <em>Order</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOrder()
     * @generated
     * @ordered
     */
    protected int order = ORDER_EDEFAULT;

    /**
     * The default value of the '{@link #getFactoryId() <em>Factory Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFactoryId()
     * @generated
     * @ordered
     */
    protected static final String FACTORY_ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getFactoryId() <em>Factory Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFactoryId()
     * @generated
     * @ordered
     */
    protected String factoryId = FACTORY_ID_EDEFAULT;

    /**
     * The default value of the '{@link #getConfigurationFilter() <em>Configuration Filter</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConfigurationFilter()
     * @generated
     * @ordered
     */
    protected static final Pattern CONFIGURATION_FILTER_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getConfigurationFilter() <em>Configuration Filter</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConfigurationFilter()
     * @generated
     * @ordered
     */
    protected Pattern configurationFilter = CONFIGURATION_FILTER_EDEFAULT;

    /**
     * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPriority()
     * @generated
     * @ordered
     */
    protected static final int PRIORITY_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPriority()
     * @generated
     * @ordered
     */
    protected int priority = PRIORITY_EDEFAULT;

    /**
     * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected static final String DESCRIPTION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDescription()
     * @generated
     * @ordered
     */
    protected String description = DESCRIPTION_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected HandlerPriorityRuleImpl ()
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
        return WorldPackage.Literals.HANDLER_PRIORITY_RULE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getOrder ()
    {
        return order;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOrder ( int newOrder )
    {
        int oldOrder = order;
        order = newOrder;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, WorldPackage.HANDLER_PRIORITY_RULE__ORDER, oldOrder, order ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getFactoryId ()
    {
        return factoryId;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFactoryId ( String newFactoryId )
    {
        String oldFactoryId = factoryId;
        factoryId = newFactoryId;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, WorldPackage.HANDLER_PRIORITY_RULE__FACTORY_ID, oldFactoryId, factoryId ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Pattern getConfigurationFilter ()
    {
        return configurationFilter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setConfigurationFilter ( Pattern newConfigurationFilter )
    {
        Pattern oldConfigurationFilter = configurationFilter;
        configurationFilter = newConfigurationFilter;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, WorldPackage.HANDLER_PRIORITY_RULE__CONFIGURATION_FILTER, oldConfigurationFilter, configurationFilter ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getPriority ()
    {
        return priority;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPriority ( int newPriority )
    {
        int oldPriority = priority;
        priority = newPriority;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, WorldPackage.HANDLER_PRIORITY_RULE__PRIORITY, oldPriority, priority ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDescription ()
    {
        return description;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDescription ( String newDescription )
    {
        String oldDescription = description;
        description = newDescription;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, WorldPackage.HANDLER_PRIORITY_RULE__DESCRIPTION, oldDescription, description ) );
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
            case WorldPackage.HANDLER_PRIORITY_RULE__ORDER:
                return getOrder ();
            case WorldPackage.HANDLER_PRIORITY_RULE__FACTORY_ID:
                return getFactoryId ();
            case WorldPackage.HANDLER_PRIORITY_RULE__CONFIGURATION_FILTER:
                return getConfigurationFilter ();
            case WorldPackage.HANDLER_PRIORITY_RULE__PRIORITY:
                return getPriority ();
            case WorldPackage.HANDLER_PRIORITY_RULE__DESCRIPTION:
                return getDescription ();
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
            case WorldPackage.HANDLER_PRIORITY_RULE__ORDER:
                setOrder ( (Integer)newValue );
                return;
            case WorldPackage.HANDLER_PRIORITY_RULE__FACTORY_ID:
                setFactoryId ( (String)newValue );
                return;
            case WorldPackage.HANDLER_PRIORITY_RULE__CONFIGURATION_FILTER:
                setConfigurationFilter ( (Pattern)newValue );
                return;
            case WorldPackage.HANDLER_PRIORITY_RULE__PRIORITY:
                setPriority ( (Integer)newValue );
                return;
            case WorldPackage.HANDLER_PRIORITY_RULE__DESCRIPTION:
                setDescription ( (String)newValue );
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
            case WorldPackage.HANDLER_PRIORITY_RULE__ORDER:
                setOrder ( ORDER_EDEFAULT );
                return;
            case WorldPackage.HANDLER_PRIORITY_RULE__FACTORY_ID:
                setFactoryId ( FACTORY_ID_EDEFAULT );
                return;
            case WorldPackage.HANDLER_PRIORITY_RULE__CONFIGURATION_FILTER:
                setConfigurationFilter ( CONFIGURATION_FILTER_EDEFAULT );
                return;
            case WorldPackage.HANDLER_PRIORITY_RULE__PRIORITY:
                setPriority ( PRIORITY_EDEFAULT );
                return;
            case WorldPackage.HANDLER_PRIORITY_RULE__DESCRIPTION:
                setDescription ( DESCRIPTION_EDEFAULT );
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
            case WorldPackage.HANDLER_PRIORITY_RULE__ORDER:
                return order != ORDER_EDEFAULT;
            case WorldPackage.HANDLER_PRIORITY_RULE__FACTORY_ID:
                return FACTORY_ID_EDEFAULT == null ? factoryId != null : !FACTORY_ID_EDEFAULT.equals ( factoryId );
            case WorldPackage.HANDLER_PRIORITY_RULE__CONFIGURATION_FILTER:
                return CONFIGURATION_FILTER_EDEFAULT == null ? configurationFilter != null : !CONFIGURATION_FILTER_EDEFAULT.equals ( configurationFilter );
            case WorldPackage.HANDLER_PRIORITY_RULE__PRIORITY:
                return priority != PRIORITY_EDEFAULT;
            case WorldPackage.HANDLER_PRIORITY_RULE__DESCRIPTION:
                return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals ( description );
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
        result.append ( " (order: " ); //$NON-NLS-1$
        result.append ( order );
        result.append ( ", factoryId: " ); //$NON-NLS-1$
        result.append ( factoryId );
        result.append ( ", configurationFilter: " ); //$NON-NLS-1$
        result.append ( configurationFilter );
        result.append ( ", priority: " ); //$NON-NLS-1$
        result.append ( priority );
        result.append ( ", description: " ); //$NON-NLS-1$
        result.append ( description );
        result.append ( ')' );
        return result.toString ();
    }

} //HandlerPriorityRuleImpl
