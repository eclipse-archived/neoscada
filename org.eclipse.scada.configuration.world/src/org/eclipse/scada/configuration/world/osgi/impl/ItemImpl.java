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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.configuration.world.osgi.ItemFeatureEntry;
import org.eclipse.scada.configuration.world.osgi.ItemInformation;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ItemImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ItemImpl#getInformation <em>Information</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ItemImpl#getItemFeatures <em>Item Features</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ItemImpl extends MinimalEObjectImpl.Container implements Item
{
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
     * The cached value of the '{@link #getInformation() <em>Information</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInformation()
     * @generated
     * @ordered
     */
    protected ItemInformation information;

    /**
     * The cached value of the '{@link #getItemFeatures() <em>Item Features</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getItemFeatures()
     * @generated
     * @ordered
     */
    protected EList<ItemFeatureEntry> itemFeatures;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ItemImpl ()
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
        return OsgiPackage.Literals.ITEM;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.ITEM__NAME, oldName, name ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ItemInformation getInformation ()
    {
        if ( information != null && information.eIsProxy () )
        {
            InternalEObject oldInformation = (InternalEObject)information;
            information = (ItemInformation)eResolveProxy ( oldInformation );
            if ( information != oldInformation )
            {
                InternalEObject newInformation = (InternalEObject)information;
                NotificationChain msgs = oldInformation.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - OsgiPackage.ITEM__INFORMATION, null, null );
                if ( newInformation.eInternalContainer () == null )
                {
                    msgs = newInformation.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - OsgiPackage.ITEM__INFORMATION, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, OsgiPackage.ITEM__INFORMATION, oldInformation, information ) );
            }
        }
        return information;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ItemInformation basicGetInformation ()
    {
        return information;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInformation ( ItemInformation newInformation, NotificationChain msgs )
    {
        ItemInformation oldInformation = information;
        information = newInformation;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, OsgiPackage.ITEM__INFORMATION, oldInformation, newInformation );
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
    public void setInformation ( ItemInformation newInformation )
    {
        if ( newInformation != information )
        {
            NotificationChain msgs = null;
            if ( information != null )
                msgs = ( (InternalEObject)information ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - OsgiPackage.ITEM__INFORMATION, null, msgs );
            if ( newInformation != null )
                msgs = ( (InternalEObject)newInformation ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - OsgiPackage.ITEM__INFORMATION, null, msgs );
            msgs = basicSetInformation ( newInformation, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.ITEM__INFORMATION, newInformation, newInformation ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ItemFeatureEntry> getItemFeatures ()
    {
        if ( itemFeatures == null )
        {
            itemFeatures = new EObjectContainmentWithInverseEList.Resolving<ItemFeatureEntry> ( ItemFeatureEntry.class, this, OsgiPackage.ITEM__ITEM_FEATURES, OsgiPackage.ITEM_FEATURE_ENTRY__ITEM );
        }
        return itemFeatures;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings ( "unchecked" )
    @Override
    public NotificationChain eInverseAdd ( InternalEObject otherEnd, int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case OsgiPackage.ITEM__ITEM_FEATURES:
                return ( (InternalEList<InternalEObject>)(InternalEList<?>)getItemFeatures () ).basicAdd ( otherEnd, msgs );
        }
        return super.eInverseAdd ( otherEnd, featureID, msgs );
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
            case OsgiPackage.ITEM__INFORMATION:
                return basicSetInformation ( null, msgs );
            case OsgiPackage.ITEM__ITEM_FEATURES:
                return ( (InternalEList<?>)getItemFeatures () ).basicRemove ( otherEnd, msgs );
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
            case OsgiPackage.ITEM__NAME:
                return getName ();
            case OsgiPackage.ITEM__INFORMATION:
                if ( resolve )
                    return getInformation ();
                return basicGetInformation ();
            case OsgiPackage.ITEM__ITEM_FEATURES:
                return getItemFeatures ();
        }
        return super.eGet ( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings ( "unchecked" )
    @Override
    public void eSet ( int featureID, Object newValue )
    {
        switch ( featureID )
        {
            case OsgiPackage.ITEM__NAME:
                setName ( (String)newValue );
                return;
            case OsgiPackage.ITEM__INFORMATION:
                setInformation ( (ItemInformation)newValue );
                return;
            case OsgiPackage.ITEM__ITEM_FEATURES:
                getItemFeatures ().clear ();
                getItemFeatures ().addAll ( (Collection<? extends ItemFeatureEntry>)newValue );
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
            case OsgiPackage.ITEM__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case OsgiPackage.ITEM__INFORMATION:
                setInformation ( (ItemInformation)null );
                return;
            case OsgiPackage.ITEM__ITEM_FEATURES:
                getItemFeatures ().clear ();
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
            case OsgiPackage.ITEM__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
            case OsgiPackage.ITEM__INFORMATION:
                return information != null;
            case OsgiPackage.ITEM__ITEM_FEATURES:
                return itemFeatures != null && !itemFeatures.isEmpty ();
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
        result.append ( " (name: " ); //$NON-NLS-1$
        result.append ( name );
        result.append ( ')' );
        return result.toString ();
    }

} //ItemImpl
