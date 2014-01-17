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
package org.eclipse.scada.configuration.world.osgi.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.scada.configuration.world.osgi.BufferedValue;
import org.eclipse.scada.configuration.world.osgi.ItemReference;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.configuration.world.osgi.Persistence;
import org.eclipse.scada.core.Variant;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Buffered Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.BufferedValueImpl#getShortDescription <em>Short Description</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.BufferedValueImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.BufferedValueImpl#getItem <em>Item</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.BufferedValueImpl#getInitialValue <em>Initial Value</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.BufferedValueImpl#getRange <em>Range</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.BufferedValueImpl#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.BufferedValueImpl#getTriggerOnly <em>Trigger Only</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.BufferedValueImpl#getPersistence <em>Persistence</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BufferedValueImpl extends MinimalEObjectImpl.Container implements BufferedValue
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
     * The cached value of the '{@link #getItem() <em>Item</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getItem()
     * @generated
     * @ordered
     */
    protected ItemReference item;

    /**
     * The default value of the '{@link #getInitialValue() <em>Initial Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInitialValue()
     * @generated
     * @ordered
     */
    protected static final Variant INITIAL_VALUE_EDEFAULT = (Variant)OsgiFactory.eINSTANCE.createFromString ( OsgiPackage.eINSTANCE.getVariant (), "" ); //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getInitialValue() <em>Initial Value</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInitialValue()
     * @generated
     * @ordered
     */
    protected Variant initialValue = INITIAL_VALUE_EDEFAULT;

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
     * The default value of the '{@link #getPersistence() <em>Persistence</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPersistence()
     * @generated
     * @ordered
     */
    protected static final Persistence PERSISTENCE_EDEFAULT = Persistence.NONE;

    /**
     * The cached value of the '{@link #getPersistence() <em>Persistence</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPersistence()
     * @generated
     * @ordered
     */
    protected Persistence persistence = PERSISTENCE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected BufferedValueImpl ()
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
        return OsgiPackage.Literals.BUFFERED_VALUE;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.BUFFERED_VALUE__SHORT_DESCRIPTION, oldShortDescription, shortDescription ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.BUFFERED_VALUE__NAME, oldName, name ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ItemReference getItem ()
    {
        if ( item != null && item.eIsProxy () )
        {
            InternalEObject oldItem = (InternalEObject)item;
            item = (ItemReference)eResolveProxy ( oldItem );
            if ( item != oldItem )
            {
                InternalEObject newItem = (InternalEObject)item;
                NotificationChain msgs = oldItem.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - OsgiPackage.BUFFERED_VALUE__ITEM, null, null );
                if ( newItem.eInternalContainer () == null )
                {
                    msgs = newItem.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - OsgiPackage.BUFFERED_VALUE__ITEM, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, OsgiPackage.BUFFERED_VALUE__ITEM, oldItem, item ) );
            }
        }
        return item;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ItemReference basicGetItem ()
    {
        return item;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetItem ( ItemReference newItem, NotificationChain msgs )
    {
        ItemReference oldItem = item;
        item = newItem;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, OsgiPackage.BUFFERED_VALUE__ITEM, oldItem, newItem );
            if ( msgs == null )
                msgs = notification;
            else
                msgs.add ( notification );
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setItem ( ItemReference newItem )
    {
        if ( newItem != item )
        {
            NotificationChain msgs = null;
            if ( item != null )
                msgs = ( (InternalEObject)item ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - OsgiPackage.BUFFERED_VALUE__ITEM, null, msgs );
            if ( newItem != null )
                msgs = ( (InternalEObject)newItem ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - OsgiPackage.BUFFERED_VALUE__ITEM, null, msgs );
            msgs = basicSetItem ( newItem, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.BUFFERED_VALUE__ITEM, newItem, newItem ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Variant getInitialValue ()
    {
        return initialValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setInitialValue ( Variant newInitialValue )
    {
        Variant oldInitialValue = initialValue;
        initialValue = newInitialValue;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.BUFFERED_VALUE__INITIAL_VALUE, oldInitialValue, initialValue ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.BUFFERED_VALUE__RANGE, oldRange, range ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.BUFFERED_VALUE__TRIGGER, oldTrigger, trigger ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.BUFFERED_VALUE__TRIGGER_ONLY, oldTriggerOnly, triggerOnly ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Persistence getPersistence ()
    {
        return persistence;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPersistence ( Persistence newPersistence )
    {
        Persistence oldPersistence = persistence;
        persistence = newPersistence == null ? PERSISTENCE_EDEFAULT : newPersistence;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.BUFFERED_VALUE__PERSISTENCE, oldPersistence, persistence ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove ( InternalEObject otherEnd, int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case OsgiPackage.BUFFERED_VALUE__ITEM:
                return basicSetItem ( null, msgs );
        }
        return super.eInverseRemove ( otherEnd, featureID, msgs );
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
            case OsgiPackage.BUFFERED_VALUE__SHORT_DESCRIPTION:
                return getShortDescription ();
            case OsgiPackage.BUFFERED_VALUE__NAME:
                return getName ();
            case OsgiPackage.BUFFERED_VALUE__ITEM:
                if ( resolve )
                    return getItem ();
                return basicGetItem ();
            case OsgiPackage.BUFFERED_VALUE__INITIAL_VALUE:
                return getInitialValue ();
            case OsgiPackage.BUFFERED_VALUE__RANGE:
                return getRange ();
            case OsgiPackage.BUFFERED_VALUE__TRIGGER:
                return getTrigger ();
            case OsgiPackage.BUFFERED_VALUE__TRIGGER_ONLY:
                return getTriggerOnly ();
            case OsgiPackage.BUFFERED_VALUE__PERSISTENCE:
                return getPersistence ();
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
            case OsgiPackage.BUFFERED_VALUE__SHORT_DESCRIPTION:
                setShortDescription ( (String)newValue );
                return;
            case OsgiPackage.BUFFERED_VALUE__NAME:
                setName ( (String)newValue );
                return;
            case OsgiPackage.BUFFERED_VALUE__ITEM:
                setItem ( (ItemReference)newValue );
                return;
            case OsgiPackage.BUFFERED_VALUE__INITIAL_VALUE:
                setInitialValue ( (Variant)newValue );
                return;
            case OsgiPackage.BUFFERED_VALUE__RANGE:
                setRange ( (Long)newValue );
                return;
            case OsgiPackage.BUFFERED_VALUE__TRIGGER:
                setTrigger ( (Long)newValue );
                return;
            case OsgiPackage.BUFFERED_VALUE__TRIGGER_ONLY:
                setTriggerOnly ( (Boolean)newValue );
                return;
            case OsgiPackage.BUFFERED_VALUE__PERSISTENCE:
                setPersistence ( (Persistence)newValue );
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
            case OsgiPackage.BUFFERED_VALUE__SHORT_DESCRIPTION:
                setShortDescription ( SHORT_DESCRIPTION_EDEFAULT );
                return;
            case OsgiPackage.BUFFERED_VALUE__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case OsgiPackage.BUFFERED_VALUE__ITEM:
                setItem ( (ItemReference)null );
                return;
            case OsgiPackage.BUFFERED_VALUE__INITIAL_VALUE:
                setInitialValue ( INITIAL_VALUE_EDEFAULT );
                return;
            case OsgiPackage.BUFFERED_VALUE__RANGE:
                setRange ( RANGE_EDEFAULT );
                return;
            case OsgiPackage.BUFFERED_VALUE__TRIGGER:
                setTrigger ( TRIGGER_EDEFAULT );
                return;
            case OsgiPackage.BUFFERED_VALUE__TRIGGER_ONLY:
                setTriggerOnly ( TRIGGER_ONLY_EDEFAULT );
                return;
            case OsgiPackage.BUFFERED_VALUE__PERSISTENCE:
                setPersistence ( PERSISTENCE_EDEFAULT );
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
            case OsgiPackage.BUFFERED_VALUE__SHORT_DESCRIPTION:
                return SHORT_DESCRIPTION_EDEFAULT == null ? shortDescription != null : !SHORT_DESCRIPTION_EDEFAULT.equals ( shortDescription );
            case OsgiPackage.BUFFERED_VALUE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
            case OsgiPackage.BUFFERED_VALUE__ITEM:
                return item != null;
            case OsgiPackage.BUFFERED_VALUE__INITIAL_VALUE:
                return INITIAL_VALUE_EDEFAULT == null ? initialValue != null : !INITIAL_VALUE_EDEFAULT.equals ( initialValue );
            case OsgiPackage.BUFFERED_VALUE__RANGE:
                return range != RANGE_EDEFAULT;
            case OsgiPackage.BUFFERED_VALUE__TRIGGER:
                return trigger != TRIGGER_EDEFAULT;
            case OsgiPackage.BUFFERED_VALUE__TRIGGER_ONLY:
                return TRIGGER_ONLY_EDEFAULT == null ? triggerOnly != null : !TRIGGER_ONLY_EDEFAULT.equals ( triggerOnly );
            case OsgiPackage.BUFFERED_VALUE__PERSISTENCE:
                return persistence != PERSISTENCE_EDEFAULT;
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
        result.append ( ", initialValue: " ); //$NON-NLS-1$
        result.append ( initialValue );
        result.append ( ", range: " ); //$NON-NLS-1$
        result.append ( range );
        result.append ( ", trigger: " ); //$NON-NLS-1$
        result.append ( trigger );
        result.append ( ", triggerOnly: " ); //$NON-NLS-1$
        result.append ( triggerOnly );
        result.append ( ", persistence: " ); //$NON-NLS-1$
        result.append ( persistence );
        result.append ( ')' );
        return result.toString ();
    }

} //BufferedValueImpl
