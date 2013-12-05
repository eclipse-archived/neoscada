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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.DataMapperService;
import org.eclipse.scada.configuration.infrastructure.MasterServer;
import org.eclipse.scada.configuration.world.osgi.DataMapper;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Mapper Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.DataMapperServiceImpl#getDataMapper <em>Data Mapper</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.DataMapperServiceImpl#getMasterOn <em>Master On</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataMapperServiceImpl extends MinimalEObjectImpl.Container implements DataMapperService
{
    /**
     * The cached value of the '{@link #getDataMapper() <em>Data Mapper</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataMapper()
     * @generated
     * @ordered
     */
    protected DataMapper dataMapper;

    /**
     * The cached value of the '{@link #getMasterOn() <em>Master On</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMasterOn()
     * @generated
     * @ordered
     */
    protected EList<MasterServer> masterOn;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DataMapperServiceImpl ()
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
        return ComponentPackage.Literals.DATA_MAPPER_SERVICE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataMapper getDataMapper ()
    {
        if ( dataMapper != null && dataMapper.eIsProxy () )
        {
            InternalEObject oldDataMapper = (InternalEObject)dataMapper;
            dataMapper = (DataMapper)eResolveProxy ( oldDataMapper );
            if ( dataMapper != oldDataMapper )
            {
                InternalEObject newDataMapper = (InternalEObject)dataMapper;
                NotificationChain msgs = oldDataMapper.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.DATA_MAPPER_SERVICE__DATA_MAPPER, null, null );
                if ( newDataMapper.eInternalContainer () == null )
                {
                    msgs = newDataMapper.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.DATA_MAPPER_SERVICE__DATA_MAPPER, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.DATA_MAPPER_SERVICE__DATA_MAPPER, oldDataMapper, dataMapper ) );
            }
        }
        return dataMapper;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataMapper basicGetDataMapper ()
    {
        return dataMapper;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDataMapper ( DataMapper newDataMapper, NotificationChain msgs )
    {
        DataMapper oldDataMapper = dataMapper;
        dataMapper = newDataMapper;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, ComponentPackage.DATA_MAPPER_SERVICE__DATA_MAPPER, oldDataMapper, newDataMapper );
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
    public void setDataMapper ( DataMapper newDataMapper )
    {
        if ( newDataMapper != dataMapper )
        {
            NotificationChain msgs = null;
            if ( dataMapper != null )
                msgs = ( (InternalEObject)dataMapper ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.DATA_MAPPER_SERVICE__DATA_MAPPER, null, msgs );
            if ( newDataMapper != null )
                msgs = ( (InternalEObject)newDataMapper ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ComponentPackage.DATA_MAPPER_SERVICE__DATA_MAPPER, null, msgs );
            msgs = basicSetDataMapper ( newDataMapper, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.DATA_MAPPER_SERVICE__DATA_MAPPER, newDataMapper, newDataMapper ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<MasterServer> getMasterOn ()
    {
        if ( masterOn == null )
        {
            masterOn = new EObjectResolvingEList<MasterServer> ( MasterServer.class, this, ComponentPackage.DATA_MAPPER_SERVICE__MASTER_ON );
        }
        return masterOn;
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
            case ComponentPackage.DATA_MAPPER_SERVICE__DATA_MAPPER:
                return basicSetDataMapper ( null, msgs );
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
            case ComponentPackage.DATA_MAPPER_SERVICE__DATA_MAPPER:
                if ( resolve )
                    return getDataMapper ();
                return basicGetDataMapper ();
            case ComponentPackage.DATA_MAPPER_SERVICE__MASTER_ON:
                return getMasterOn ();
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
            case ComponentPackage.DATA_MAPPER_SERVICE__DATA_MAPPER:
                setDataMapper ( (DataMapper)newValue );
                return;
            case ComponentPackage.DATA_MAPPER_SERVICE__MASTER_ON:
                getMasterOn ().clear ();
                getMasterOn ().addAll ( (Collection<? extends MasterServer>)newValue );
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
            case ComponentPackage.DATA_MAPPER_SERVICE__DATA_MAPPER:
                setDataMapper ( (DataMapper)null );
                return;
            case ComponentPackage.DATA_MAPPER_SERVICE__MASTER_ON:
                getMasterOn ().clear ();
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
            case ComponentPackage.DATA_MAPPER_SERVICE__DATA_MAPPER:
                return dataMapper != null;
            case ComponentPackage.DATA_MAPPER_SERVICE__MASTER_ON:
                return masterOn != null && !masterOn.isEmpty ();
        }
        return super.eIsSet ( featureID );
    }

} //DataMapperServiceImpl
