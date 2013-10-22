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
package org.eclipse.scada.configuration.world.osgi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.configuration.world.osgi.MovingAverage;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Moving Average</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.MovingAverageImpl#getShortDescription <em>Short Description</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.MovingAverageImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.MovingAverageImpl#getItem <em>Item</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.MovingAverageImpl#getRange <em>Range</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.MovingAverageImpl#getNullRange <em>Null Range</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.MovingAverageImpl#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.MovingAverageImpl#getTriggerOnly <em>Trigger Only</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MovingAverageImpl extends MinimalEObjectImpl.Container implements MovingAverage
{
    /**
     * The default value of the '{@link #getShortDescription() <em>Short Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getShortDescription()
     * @generated
     * @ordered
     */
    protected static final String SHORT_DESCRIPTION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getShortDescription() <em>Short Description</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getShortDescription()
     * @generated
     * @ordered
     */
    protected String shortDescription = SHORT_DESCRIPTION_EDEFAULT;

    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The cached value of the '{@link #getItem() <em>Item</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getItem()
     * @generated
     * @ordered
     */
    protected Item item;

    /**
     * The default value of the '{@link #getRange() <em>Range</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRange()
     * @generated
     * @ordered
     */
    protected static final long RANGE_EDEFAULT = 0L;

    /**
     * The cached value of the '{@link #getRange() <em>Range</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRange()
     * @generated
     * @ordered
     */
    protected long range = RANGE_EDEFAULT;

    /**
     * The default value of the '{@link #getNullRange() <em>Null Range</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNullRange()
     * @generated
     * @ordered
     */
    protected static final long NULL_RANGE_EDEFAULT = 0L;

    /**
     * The cached value of the '{@link #getNullRange() <em>Null Range</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getNullRange()
     * @generated
     * @ordered
     */
    protected long nullRange = NULL_RANGE_EDEFAULT;

    /**
     * The default value of the '{@link #getTrigger() <em>Trigger</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTrigger()
     * @generated
     * @ordered
     */
    protected static final long TRIGGER_EDEFAULT = 1L;

    /**
     * The cached value of the '{@link #getTrigger() <em>Trigger</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTrigger()
     * @generated
     * @ordered
     */
    protected long trigger = TRIGGER_EDEFAULT;

    /**
     * The default value of the '{@link #getTriggerOnly() <em>Trigger Only</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTriggerOnly()
     * @generated
     * @ordered
     */
    protected static final Boolean TRIGGER_ONLY_EDEFAULT = Boolean.FALSE;

    /**
     * The cached value of the '{@link #getTriggerOnly() <em>Trigger Only</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTriggerOnly()
     * @generated
     * @ordered
     */
    protected Boolean triggerOnly = TRIGGER_ONLY_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MovingAverageImpl ()
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
        return OsgiPackage.Literals.MOVING_AVERAGE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getShortDescription ()
    {
        return shortDescription;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setShortDescription ( String newShortDescription )
    {
        String oldShortDescription = shortDescription;
        shortDescription = newShortDescription;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.MOVING_AVERAGE__SHORT_DESCRIPTION, oldShortDescription, shortDescription ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName ()
    {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName ( String newName )
    {
        String oldName = name;
        name = newName;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.MOVING_AVERAGE__NAME, oldName, name ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Item getItem ()
    {
        if ( item != null && item.eIsProxy () )
        {
            InternalEObject oldItem = (InternalEObject)item;
            item = (Item)eResolveProxy ( oldItem );
            if ( item != oldItem )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, OsgiPackage.MOVING_AVERAGE__ITEM, oldItem, item ) );
            }
        }
        return item;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Item basicGetItem ()
    {
        return item;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setItem ( Item newItem )
    {
        Item oldItem = item;
        item = newItem;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.MOVING_AVERAGE__ITEM, oldItem, item ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public long getRange ()
    {
        return range;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRange ( long newRange )
    {
        long oldRange = range;
        range = newRange;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.MOVING_AVERAGE__RANGE, oldRange, range ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public long getNullRange ()
    {
        return nullRange;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setNullRange ( long newNullRange )
    {
        long oldNullRange = nullRange;
        nullRange = newNullRange;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.MOVING_AVERAGE__NULL_RANGE, oldNullRange, nullRange ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public long getTrigger ()
    {
        return trigger;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTrigger ( long newTrigger )
    {
        long oldTrigger = trigger;
        trigger = newTrigger;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.MOVING_AVERAGE__TRIGGER, oldTrigger, trigger ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Boolean getTriggerOnly ()
    {
        return triggerOnly;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTriggerOnly ( Boolean newTriggerOnly )
    {
        Boolean oldTriggerOnly = triggerOnly;
        triggerOnly = newTriggerOnly;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.MOVING_AVERAGE__TRIGGER_ONLY, oldTriggerOnly, triggerOnly ) );
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
            case OsgiPackage.MOVING_AVERAGE__SHORT_DESCRIPTION:
                return getShortDescription ();
            case OsgiPackage.MOVING_AVERAGE__NAME:
                return getName ();
            case OsgiPackage.MOVING_AVERAGE__ITEM:
                if ( resolve )
                    return getItem ();
                return basicGetItem ();
            case OsgiPackage.MOVING_AVERAGE__RANGE:
                return getRange ();
            case OsgiPackage.MOVING_AVERAGE__NULL_RANGE:
                return getNullRange ();
            case OsgiPackage.MOVING_AVERAGE__TRIGGER:
                return getTrigger ();
            case OsgiPackage.MOVING_AVERAGE__TRIGGER_ONLY:
                return getTriggerOnly ();
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
            case OsgiPackage.MOVING_AVERAGE__SHORT_DESCRIPTION:
                setShortDescription ( (String)newValue );
                return;
            case OsgiPackage.MOVING_AVERAGE__NAME:
                setName ( (String)newValue );
                return;
            case OsgiPackage.MOVING_AVERAGE__ITEM:
                setItem ( (Item)newValue );
                return;
            case OsgiPackage.MOVING_AVERAGE__RANGE:
                setRange ( (Long)newValue );
                return;
            case OsgiPackage.MOVING_AVERAGE__NULL_RANGE:
                setNullRange ( (Long)newValue );
                return;
            case OsgiPackage.MOVING_AVERAGE__TRIGGER:
                setTrigger ( (Long)newValue );
                return;
            case OsgiPackage.MOVING_AVERAGE__TRIGGER_ONLY:
                setTriggerOnly ( (Boolean)newValue );
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
            case OsgiPackage.MOVING_AVERAGE__SHORT_DESCRIPTION:
                setShortDescription ( SHORT_DESCRIPTION_EDEFAULT );
                return;
            case OsgiPackage.MOVING_AVERAGE__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case OsgiPackage.MOVING_AVERAGE__ITEM:
                setItem ( (Item)null );
                return;
            case OsgiPackage.MOVING_AVERAGE__RANGE:
                setRange ( RANGE_EDEFAULT );
                return;
            case OsgiPackage.MOVING_AVERAGE__NULL_RANGE:
                setNullRange ( NULL_RANGE_EDEFAULT );
                return;
            case OsgiPackage.MOVING_AVERAGE__TRIGGER:
                setTrigger ( TRIGGER_EDEFAULT );
                return;
            case OsgiPackage.MOVING_AVERAGE__TRIGGER_ONLY:
                setTriggerOnly ( TRIGGER_ONLY_EDEFAULT );
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
            case OsgiPackage.MOVING_AVERAGE__SHORT_DESCRIPTION:
                return SHORT_DESCRIPTION_EDEFAULT == null ? shortDescription != null : !SHORT_DESCRIPTION_EDEFAULT.equals ( shortDescription );
            case OsgiPackage.MOVING_AVERAGE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
            case OsgiPackage.MOVING_AVERAGE__ITEM:
                return item != null;
            case OsgiPackage.MOVING_AVERAGE__RANGE:
                return range != RANGE_EDEFAULT;
            case OsgiPackage.MOVING_AVERAGE__NULL_RANGE:
                return nullRange != NULL_RANGE_EDEFAULT;
            case OsgiPackage.MOVING_AVERAGE__TRIGGER:
                return trigger != TRIGGER_EDEFAULT;
            case OsgiPackage.MOVING_AVERAGE__TRIGGER_ONLY:
                return TRIGGER_ONLY_EDEFAULT == null ? triggerOnly != null : !TRIGGER_ONLY_EDEFAULT.equals ( triggerOnly );
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
        result.append ( " (shortDescription: " ); //$NON-NLS-1$
        result.append ( shortDescription );
        result.append ( ", name: " ); //$NON-NLS-1$
        result.append ( name );
        result.append ( ", range: " ); //$NON-NLS-1$
        result.append ( range );
        result.append ( ", nullRange: " ); //$NON-NLS-1$
        result.append ( nullRange );
        result.append ( ", trigger: " ); //$NON-NLS-1$
        result.append ( trigger );
        result.append ( ", triggerOnly: " ); //$NON-NLS-1$
        result.append ( triggerOnly );
        result.append ( ')' );
        return result.toString ();
    }

} //MovingAverageImpl
