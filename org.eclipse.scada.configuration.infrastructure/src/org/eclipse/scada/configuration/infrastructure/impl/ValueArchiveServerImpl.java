/*******************************************************************************
 * Copyright (c) 2013, 2016 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.infrastructure.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.infrastructure.ValueArchiveServer;
import org.eclipse.scada.configuration.world.osgi.ArchiveConfiguration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value Archive Server</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.ValueArchiveServerImpl#getDefaultArchiveconfiguration <em>Default Archiveconfiguration</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ValueArchiveServerImpl extends EquinoxApplicationImpl implements ValueArchiveServer
{
    /**
     * The cached value of the '{@link #getDefaultArchiveconfiguration() <em>Default Archiveconfiguration</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultArchiveconfiguration()
     * @generated
     * @ordered
     */
    protected ArchiveConfiguration defaultArchiveconfiguration;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ValueArchiveServerImpl ()
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
        return InfrastructurePackage.Literals.VALUE_ARCHIVE_SERVER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ArchiveConfiguration getDefaultArchiveconfiguration ()
    {
        if ( defaultArchiveconfiguration != null && defaultArchiveconfiguration.eIsProxy () )
        {
            InternalEObject oldDefaultArchiveconfiguration = (InternalEObject)defaultArchiveconfiguration;
            defaultArchiveconfiguration = (ArchiveConfiguration)eResolveProxy ( oldDefaultArchiveconfiguration );
            if ( defaultArchiveconfiguration != oldDefaultArchiveconfiguration )
            {
                InternalEObject newDefaultArchiveconfiguration = (InternalEObject)defaultArchiveconfiguration;
                NotificationChain msgs = oldDefaultArchiveconfiguration.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.VALUE_ARCHIVE_SERVER__DEFAULT_ARCHIVECONFIGURATION, null, null );
                if ( newDefaultArchiveconfiguration.eInternalContainer () == null )
                {
                    msgs = newDefaultArchiveconfiguration.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.VALUE_ARCHIVE_SERVER__DEFAULT_ARCHIVECONFIGURATION, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, InfrastructurePackage.VALUE_ARCHIVE_SERVER__DEFAULT_ARCHIVECONFIGURATION, oldDefaultArchiveconfiguration, defaultArchiveconfiguration ) );
            }
        }
        return defaultArchiveconfiguration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ArchiveConfiguration basicGetDefaultArchiveconfiguration ()
    {
        return defaultArchiveconfiguration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDefaultArchiveconfiguration ( ArchiveConfiguration newDefaultArchiveconfiguration, NotificationChain msgs )
    {
        ArchiveConfiguration oldDefaultArchiveconfiguration = defaultArchiveconfiguration;
        defaultArchiveconfiguration = newDefaultArchiveconfiguration;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.VALUE_ARCHIVE_SERVER__DEFAULT_ARCHIVECONFIGURATION, oldDefaultArchiveconfiguration, newDefaultArchiveconfiguration );
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
    @Override
    public void setDefaultArchiveconfiguration ( ArchiveConfiguration newDefaultArchiveconfiguration )
    {
        if ( newDefaultArchiveconfiguration != defaultArchiveconfiguration )
        {
            NotificationChain msgs = null;
            if ( defaultArchiveconfiguration != null )
                msgs = ( (InternalEObject)defaultArchiveconfiguration ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.VALUE_ARCHIVE_SERVER__DEFAULT_ARCHIVECONFIGURATION, null, msgs );
            if ( newDefaultArchiveconfiguration != null )
                msgs = ( (InternalEObject)newDefaultArchiveconfiguration ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.VALUE_ARCHIVE_SERVER__DEFAULT_ARCHIVECONFIGURATION, null, msgs );
            msgs = basicSetDefaultArchiveconfiguration ( newDefaultArchiveconfiguration, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.VALUE_ARCHIVE_SERVER__DEFAULT_ARCHIVECONFIGURATION, newDefaultArchiveconfiguration, newDefaultArchiveconfiguration ) );
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
            case InfrastructurePackage.VALUE_ARCHIVE_SERVER__DEFAULT_ARCHIVECONFIGURATION:
                return basicSetDefaultArchiveconfiguration ( null, msgs );
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
            case InfrastructurePackage.VALUE_ARCHIVE_SERVER__DEFAULT_ARCHIVECONFIGURATION:
                if ( resolve )
                    return getDefaultArchiveconfiguration ();
                return basicGetDefaultArchiveconfiguration ();
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
            case InfrastructurePackage.VALUE_ARCHIVE_SERVER__DEFAULT_ARCHIVECONFIGURATION:
                setDefaultArchiveconfiguration ( (ArchiveConfiguration)newValue );
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
            case InfrastructurePackage.VALUE_ARCHIVE_SERVER__DEFAULT_ARCHIVECONFIGURATION:
                setDefaultArchiveconfiguration ( (ArchiveConfiguration)null );
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
            case InfrastructurePackage.VALUE_ARCHIVE_SERVER__DEFAULT_ARCHIVECONFIGURATION:
                return defaultArchiveconfiguration != null;
        }
        return super.eIsSet ( featureID );
    }

} //ValueArchiveServerImpl
