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
package org.eclipse.scada.configuration.infrastructure.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.globalization.Authorative;
import org.eclipse.scada.configuration.infrastructure.Driver;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.infrastructure.MasterImport;
import org.eclipse.scada.configuration.infrastructure.MasterServer;
import org.eclipse.scada.configuration.infrastructure.ValueArchiveServer;
import org.eclipse.scada.configuration.world.Credentials;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Master Server</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.MasterServerImpl#getAuthoratives <em>Authoratives</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.MasterServerImpl#getImportMaster <em>Import Master</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.MasterServerImpl#getDriver <em>Driver</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.MasterServerImpl#getArchiveTo <em>Archive To</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.MasterServerImpl#getLocalCredentials <em>Local Credentials</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MasterServerImpl extends EquinoxApplicationImpl implements MasterServer
{
    /**
     * The cached value of the '{@link #getAuthoratives() <em>Authoratives</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAuthoratives()
     * @generated
     * @ordered
     */
    protected EList<Authorative> authoratives;

    /**
     * The cached value of the '{@link #getImportMaster() <em>Import Master</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImportMaster()
     * @generated
     * @ordered
     */
    protected EList<MasterImport> importMaster;

    /**
     * The cached value of the '{@link #getDriver() <em>Driver</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDriver()
     * @generated
     * @ordered
     */
    protected EList<Driver> driver;

    /**
     * The cached value of the '{@link #getArchiveTo() <em>Archive To</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getArchiveTo()
     * @generated
     * @ordered
     */
    protected ValueArchiveServer archiveTo;

    /**
     * The cached value of the '{@link #getLocalCredentials() <em>Local Credentials</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLocalCredentials()
     * @generated
     * @ordered
     */
    protected Credentials localCredentials;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MasterServerImpl ()
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
        return InfrastructurePackage.Literals.MASTER_SERVER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Authorative> getAuthoratives ()
    {
        if ( authoratives == null )
        {
            authoratives = new EObjectContainmentEList.Resolving<Authorative> ( Authorative.class, this, InfrastructurePackage.MASTER_SERVER__AUTHORATIVES );
        }
        return authoratives;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<MasterImport> getImportMaster ()
    {
        if ( importMaster == null )
        {
            importMaster = new EObjectContainmentEList.Resolving<MasterImport> ( MasterImport.class, this, InfrastructurePackage.MASTER_SERVER__IMPORT_MASTER );
        }
        return importMaster;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Driver> getDriver ()
    {
        if ( driver == null )
        {
            driver = new EObjectResolvingEList<Driver> ( Driver.class, this, InfrastructurePackage.MASTER_SERVER__DRIVER );
        }
        return driver;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ValueArchiveServer getArchiveTo ()
    {
        if ( archiveTo != null && archiveTo.eIsProxy () )
        {
            InternalEObject oldArchiveTo = (InternalEObject)archiveTo;
            archiveTo = (ValueArchiveServer)eResolveProxy ( oldArchiveTo );
            if ( archiveTo != oldArchiveTo )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, InfrastructurePackage.MASTER_SERVER__ARCHIVE_TO, oldArchiveTo, archiveTo ) );
            }
        }
        return archiveTo;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ValueArchiveServer basicGetArchiveTo ()
    {
        return archiveTo;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setArchiveTo ( ValueArchiveServer newArchiveTo )
    {
        ValueArchiveServer oldArchiveTo = archiveTo;
        archiveTo = newArchiveTo;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.MASTER_SERVER__ARCHIVE_TO, oldArchiveTo, archiveTo ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Credentials getLocalCredentials ()
    {
        if ( localCredentials != null && localCredentials.eIsProxy () )
        {
            InternalEObject oldLocalCredentials = (InternalEObject)localCredentials;
            localCredentials = (Credentials)eResolveProxy ( oldLocalCredentials );
            if ( localCredentials != oldLocalCredentials )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, InfrastructurePackage.MASTER_SERVER__LOCAL_CREDENTIALS, oldLocalCredentials, localCredentials ) );
            }
        }
        return localCredentials;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Credentials basicGetLocalCredentials ()
    {
        return localCredentials;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLocalCredentials ( Credentials newLocalCredentials )
    {
        Credentials oldLocalCredentials = localCredentials;
        localCredentials = newLocalCredentials;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.MASTER_SERVER__LOCAL_CREDENTIALS, oldLocalCredentials, localCredentials ) );
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
            case InfrastructurePackage.MASTER_SERVER__AUTHORATIVES:
                return ( (InternalEList<?>)getAuthoratives () ).basicRemove ( otherEnd, msgs );
            case InfrastructurePackage.MASTER_SERVER__IMPORT_MASTER:
                return ( (InternalEList<?>)getImportMaster () ).basicRemove ( otherEnd, msgs );
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
            case InfrastructurePackage.MASTER_SERVER__AUTHORATIVES:
                return getAuthoratives ();
            case InfrastructurePackage.MASTER_SERVER__IMPORT_MASTER:
                return getImportMaster ();
            case InfrastructurePackage.MASTER_SERVER__DRIVER:
                return getDriver ();
            case InfrastructurePackage.MASTER_SERVER__ARCHIVE_TO:
                if ( resolve )
                    return getArchiveTo ();
                return basicGetArchiveTo ();
            case InfrastructurePackage.MASTER_SERVER__LOCAL_CREDENTIALS:
                if ( resolve )
                    return getLocalCredentials ();
                return basicGetLocalCredentials ();
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
            case InfrastructurePackage.MASTER_SERVER__AUTHORATIVES:
                getAuthoratives ().clear ();
                getAuthoratives ().addAll ( (Collection<? extends Authorative>)newValue );
                return;
            case InfrastructurePackage.MASTER_SERVER__IMPORT_MASTER:
                getImportMaster ().clear ();
                getImportMaster ().addAll ( (Collection<? extends MasterImport>)newValue );
                return;
            case InfrastructurePackage.MASTER_SERVER__DRIVER:
                getDriver ().clear ();
                getDriver ().addAll ( (Collection<? extends Driver>)newValue );
                return;
            case InfrastructurePackage.MASTER_SERVER__ARCHIVE_TO:
                setArchiveTo ( (ValueArchiveServer)newValue );
                return;
            case InfrastructurePackage.MASTER_SERVER__LOCAL_CREDENTIALS:
                setLocalCredentials ( (Credentials)newValue );
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
            case InfrastructurePackage.MASTER_SERVER__AUTHORATIVES:
                getAuthoratives ().clear ();
                return;
            case InfrastructurePackage.MASTER_SERVER__IMPORT_MASTER:
                getImportMaster ().clear ();
                return;
            case InfrastructurePackage.MASTER_SERVER__DRIVER:
                getDriver ().clear ();
                return;
            case InfrastructurePackage.MASTER_SERVER__ARCHIVE_TO:
                setArchiveTo ( (ValueArchiveServer)null );
                return;
            case InfrastructurePackage.MASTER_SERVER__LOCAL_CREDENTIALS:
                setLocalCredentials ( (Credentials)null );
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
            case InfrastructurePackage.MASTER_SERVER__AUTHORATIVES:
                return authoratives != null && !authoratives.isEmpty ();
            case InfrastructurePackage.MASTER_SERVER__IMPORT_MASTER:
                return importMaster != null && !importMaster.isEmpty ();
            case InfrastructurePackage.MASTER_SERVER__DRIVER:
                return driver != null && !driver.isEmpty ();
            case InfrastructurePackage.MASTER_SERVER__ARCHIVE_TO:
                return archiveTo != null;
            case InfrastructurePackage.MASTER_SERVER__LOCAL_CREDENTIALS:
                return localCredentials != null;
        }
        return super.eIsSet ( featureID );
    }

} //MasterServerImpl
