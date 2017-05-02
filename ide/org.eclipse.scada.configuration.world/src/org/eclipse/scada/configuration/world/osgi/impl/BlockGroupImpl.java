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
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.world.osgi.BlockGroup;
import org.eclipse.scada.configuration.world.osgi.BlockHandler;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Block Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.BlockGroupImpl#getShortDescription <em>Short Description</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.BlockGroupImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.BlockGroupImpl#getHandlers <em>Handlers</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.BlockGroupImpl#getHierarchy <em>Hierarchy</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BlockGroupImpl extends MinimalEObjectImpl.Container implements BlockGroup
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
     * The cached value of the '{@link #getHandlers() <em>Handlers</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHandlers()
     * @generated
     * @ordered
     */
    protected EList<BlockHandler> handlers;

    /**
     * The cached value of the '{@link #getHierarchy() <em>Hierarchy</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getHierarchy()
     * @generated
     * @ordered
     */
    protected EList<String> hierarchy;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected BlockGroupImpl ()
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
        return OsgiPackage.Literals.BLOCK_GROUP;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.BLOCK_GROUP__SHORT_DESCRIPTION, oldShortDescription, shortDescription ) );
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.BLOCK_GROUP__NAME, oldName, name ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<BlockHandler> getHandlers ()
    {
        if ( handlers == null )
        {
            handlers = new EObjectWithInverseResolvingEList<BlockHandler> ( BlockHandler.class, this, OsgiPackage.BLOCK_GROUP__HANDLERS, OsgiPackage.BLOCK_HANDLER__GROUP );
        }
        return handlers;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getHierarchy ()
    {
        if ( hierarchy == null )
        {
            hierarchy = new EDataTypeUniqueEList<String> ( String.class, this, OsgiPackage.BLOCK_GROUP__HIERARCHY );
        }
        return hierarchy;
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
            case OsgiPackage.BLOCK_GROUP__HANDLERS:
                return ( (InternalEList<InternalEObject>)(InternalEList<?>)getHandlers () ).basicAdd ( otherEnd, msgs );
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
            case OsgiPackage.BLOCK_GROUP__HANDLERS:
                return ( (InternalEList<?>)getHandlers () ).basicRemove ( otherEnd, msgs );
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
            case OsgiPackage.BLOCK_GROUP__SHORT_DESCRIPTION:
                return getShortDescription ();
            case OsgiPackage.BLOCK_GROUP__NAME:
                return getName ();
            case OsgiPackage.BLOCK_GROUP__HANDLERS:
                return getHandlers ();
            case OsgiPackage.BLOCK_GROUP__HIERARCHY:
                return getHierarchy ();
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
            case OsgiPackage.BLOCK_GROUP__SHORT_DESCRIPTION:
                setShortDescription ( (String)newValue );
                return;
            case OsgiPackage.BLOCK_GROUP__NAME:
                setName ( (String)newValue );
                return;
            case OsgiPackage.BLOCK_GROUP__HANDLERS:
                getHandlers ().clear ();
                getHandlers ().addAll ( (Collection<? extends BlockHandler>)newValue );
                return;
            case OsgiPackage.BLOCK_GROUP__HIERARCHY:
                getHierarchy ().clear ();
                getHierarchy ().addAll ( (Collection<? extends String>)newValue );
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
            case OsgiPackage.BLOCK_GROUP__SHORT_DESCRIPTION:
                setShortDescription ( SHORT_DESCRIPTION_EDEFAULT );
                return;
            case OsgiPackage.BLOCK_GROUP__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case OsgiPackage.BLOCK_GROUP__HANDLERS:
                getHandlers ().clear ();
                return;
            case OsgiPackage.BLOCK_GROUP__HIERARCHY:
                getHierarchy ().clear ();
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
            case OsgiPackage.BLOCK_GROUP__SHORT_DESCRIPTION:
                return SHORT_DESCRIPTION_EDEFAULT == null ? shortDescription != null : !SHORT_DESCRIPTION_EDEFAULT.equals ( shortDescription );
            case OsgiPackage.BLOCK_GROUP__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
            case OsgiPackage.BLOCK_GROUP__HANDLERS:
                return handlers != null && !handlers.isEmpty ();
            case OsgiPackage.BLOCK_GROUP__HIERARCHY:
                return hierarchy != null && !hierarchy.isEmpty ();
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
        result.append ( ", hierarchy: " ); //$NON-NLS-1$
        result.append ( hierarchy );
        result.append ( ')' );
        return result.toString ();
    }

} //BlockGroupImpl
