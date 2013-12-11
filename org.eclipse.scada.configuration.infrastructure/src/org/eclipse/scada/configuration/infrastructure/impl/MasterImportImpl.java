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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.infrastructure.MasterImport;
import org.eclipse.scada.configuration.infrastructure.MasterServer;
import org.eclipse.scada.configuration.item.Selector;
import org.eclipse.scada.configuration.world.Credentials;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Master Import</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.MasterImportImpl#getImportedMaster <em>Imported Master</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.MasterImportImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.MasterImportImpl#getCredentials <em>Credentials</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.MasterImportImpl#getImportSelector <em>Import Selector</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.infrastructure.impl.MasterImportImpl#getMaster <em>Master</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MasterImportImpl extends MinimalEObjectImpl.Container implements MasterImport
{
    /**
     * The cached value of the '{@link #getImportedMaster() <em>Imported Master</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImportedMaster()
     * @generated
     * @ordered
     */
    protected MasterServer importedMaster;

    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final String ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected String id = ID_EDEFAULT;

    /**
     * The cached value of the '{@link #getCredentials() <em>Credentials</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCredentials()
     * @generated
     * @ordered
     */
    protected Credentials credentials;

    /**
     * The cached value of the '{@link #getImportSelector() <em>Import Selector</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImportSelector()
     * @generated
     * @ordered
     */
    protected Selector importSelector;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MasterImportImpl ()
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
        return InfrastructurePackage.Literals.MASTER_IMPORT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public MasterServer getImportedMaster ()
    {
        if ( importedMaster != null && importedMaster.eIsProxy () )
        {
            InternalEObject oldImportedMaster = (InternalEObject)importedMaster;
            importedMaster = (MasterServer)eResolveProxy ( oldImportedMaster );
            if ( importedMaster != oldImportedMaster )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, InfrastructurePackage.MASTER_IMPORT__IMPORTED_MASTER, oldImportedMaster, importedMaster ) );
            }
        }
        return importedMaster;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MasterServer basicGetImportedMaster ()
    {
        return importedMaster;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setImportedMaster ( MasterServer newImportedMaster )
    {
        MasterServer oldImportedMaster = importedMaster;
        importedMaster = newImportedMaster;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.MASTER_IMPORT__IMPORTED_MASTER, oldImportedMaster, importedMaster ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getId ()
    {
        return id;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setId ( String newId )
    {
        String oldId = id;
        id = newId;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.MASTER_IMPORT__ID, oldId, id ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Credentials getCredentials ()
    {
        if ( credentials != null && credentials.eIsProxy () )
        {
            InternalEObject oldCredentials = (InternalEObject)credentials;
            credentials = (Credentials)eResolveProxy ( oldCredentials );
            if ( credentials != oldCredentials )
            {
                InternalEObject newCredentials = (InternalEObject)credentials;
                NotificationChain msgs = oldCredentials.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.MASTER_IMPORT__CREDENTIALS, null, null );
                if ( newCredentials.eInternalContainer () == null )
                {
                    msgs = newCredentials.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.MASTER_IMPORT__CREDENTIALS, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, InfrastructurePackage.MASTER_IMPORT__CREDENTIALS, oldCredentials, credentials ) );
            }
        }
        return credentials;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Credentials basicGetCredentials ()
    {
        return credentials;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetCredentials ( Credentials newCredentials, NotificationChain msgs )
    {
        Credentials oldCredentials = credentials;
        credentials = newCredentials;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.MASTER_IMPORT__CREDENTIALS, oldCredentials, newCredentials );
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
    public void setCredentials ( Credentials newCredentials )
    {
        if ( newCredentials != credentials )
        {
            NotificationChain msgs = null;
            if ( credentials != null )
                msgs = ( (InternalEObject)credentials ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.MASTER_IMPORT__CREDENTIALS, null, msgs );
            if ( newCredentials != null )
                msgs = ( (InternalEObject)newCredentials ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - InfrastructurePackage.MASTER_IMPORT__CREDENTIALS, null, msgs );
            msgs = basicSetCredentials ( newCredentials, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.MASTER_IMPORT__CREDENTIALS, newCredentials, newCredentials ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Selector getImportSelector ()
    {
        if ( importSelector != null && importSelector.eIsProxy () )
        {
            InternalEObject oldImportSelector = (InternalEObject)importSelector;
            importSelector = (Selector)eResolveProxy ( oldImportSelector );
            if ( importSelector != oldImportSelector )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, InfrastructurePackage.MASTER_IMPORT__IMPORT_SELECTOR, oldImportSelector, importSelector ) );
            }
        }
        return importSelector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Selector basicGetImportSelector ()
    {
        return importSelector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setImportSelector ( Selector newImportSelector )
    {
        Selector oldImportSelector = importSelector;
        importSelector = newImportSelector;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.MASTER_IMPORT__IMPORT_SELECTOR, oldImportSelector, importSelector ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MasterServer getMaster ()
    {
        if ( eContainerFeatureID () != InfrastructurePackage.MASTER_IMPORT__MASTER )
            return null;
        return (MasterServer)eContainer ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MasterServer basicGetMaster ()
    {
        if ( eContainerFeatureID () != InfrastructurePackage.MASTER_IMPORT__MASTER )
            return null;
        return (MasterServer)eInternalContainer ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetMaster ( MasterServer newMaster, NotificationChain msgs )
    {
        msgs = eBasicSetContainer ( (InternalEObject)newMaster, InfrastructurePackage.MASTER_IMPORT__MASTER, msgs );
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMaster ( MasterServer newMaster )
    {
        if ( newMaster != eInternalContainer () || ( eContainerFeatureID () != InfrastructurePackage.MASTER_IMPORT__MASTER && newMaster != null ) )
        {
            if ( EcoreUtil.isAncestor ( this, newMaster ) )
                throw new IllegalArgumentException ( "Recursive containment not allowed for " + toString () ); //$NON-NLS-1$
            NotificationChain msgs = null;
            if ( eInternalContainer () != null )
                msgs = eBasicRemoveFromContainer ( msgs );
            if ( newMaster != null )
                msgs = ( (InternalEObject)newMaster ).eInverseAdd ( this, InfrastructurePackage.MASTER_SERVER__IMPORT_MASTER, MasterServer.class, msgs );
            msgs = basicSetMaster ( newMaster, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, InfrastructurePackage.MASTER_IMPORT__MASTER, newMaster, newMaster ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd ( InternalEObject otherEnd, int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case InfrastructurePackage.MASTER_IMPORT__MASTER:
                if ( eInternalContainer () != null )
                    msgs = eBasicRemoveFromContainer ( msgs );
                return basicSetMaster ( (MasterServer)otherEnd, msgs );
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
            case InfrastructurePackage.MASTER_IMPORT__CREDENTIALS:
                return basicSetCredentials ( null, msgs );
            case InfrastructurePackage.MASTER_IMPORT__MASTER:
                return basicSetMaster ( null, msgs );
        }
        return super.eInverseRemove ( otherEnd, featureID, msgs );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature ( NotificationChain msgs )
    {
        switch ( eContainerFeatureID () )
        {
            case InfrastructurePackage.MASTER_IMPORT__MASTER:
                return eInternalContainer ().eInverseRemove ( this, InfrastructurePackage.MASTER_SERVER__IMPORT_MASTER, MasterServer.class, msgs );
        }
        return super.eBasicRemoveFromContainerFeature ( msgs );
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
            case InfrastructurePackage.MASTER_IMPORT__IMPORTED_MASTER:
                if ( resolve )
                    return getImportedMaster ();
                return basicGetImportedMaster ();
            case InfrastructurePackage.MASTER_IMPORT__ID:
                return getId ();
            case InfrastructurePackage.MASTER_IMPORT__CREDENTIALS:
                if ( resolve )
                    return getCredentials ();
                return basicGetCredentials ();
            case InfrastructurePackage.MASTER_IMPORT__IMPORT_SELECTOR:
                if ( resolve )
                    return getImportSelector ();
                return basicGetImportSelector ();
            case InfrastructurePackage.MASTER_IMPORT__MASTER:
                if ( resolve )
                    return getMaster ();
                return basicGetMaster ();
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
            case InfrastructurePackage.MASTER_IMPORT__IMPORTED_MASTER:
                setImportedMaster ( (MasterServer)newValue );
                return;
            case InfrastructurePackage.MASTER_IMPORT__ID:
                setId ( (String)newValue );
                return;
            case InfrastructurePackage.MASTER_IMPORT__CREDENTIALS:
                setCredentials ( (Credentials)newValue );
                return;
            case InfrastructurePackage.MASTER_IMPORT__IMPORT_SELECTOR:
                setImportSelector ( (Selector)newValue );
                return;
            case InfrastructurePackage.MASTER_IMPORT__MASTER:
                setMaster ( (MasterServer)newValue );
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
            case InfrastructurePackage.MASTER_IMPORT__IMPORTED_MASTER:
                setImportedMaster ( (MasterServer)null );
                return;
            case InfrastructurePackage.MASTER_IMPORT__ID:
                setId ( ID_EDEFAULT );
                return;
            case InfrastructurePackage.MASTER_IMPORT__CREDENTIALS:
                setCredentials ( (Credentials)null );
                return;
            case InfrastructurePackage.MASTER_IMPORT__IMPORT_SELECTOR:
                setImportSelector ( (Selector)null );
                return;
            case InfrastructurePackage.MASTER_IMPORT__MASTER:
                setMaster ( (MasterServer)null );
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
            case InfrastructurePackage.MASTER_IMPORT__IMPORTED_MASTER:
                return importedMaster != null;
            case InfrastructurePackage.MASTER_IMPORT__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals ( id );
            case InfrastructurePackage.MASTER_IMPORT__CREDENTIALS:
                return credentials != null;
            case InfrastructurePackage.MASTER_IMPORT__IMPORT_SELECTOR:
                return importSelector != null;
            case InfrastructurePackage.MASTER_IMPORT__MASTER:
                return basicGetMaster () != null;
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
        result.append ( " (id: " ); //$NON-NLS-1$
        result.append ( id );
        result.append ( ')' );
        return result.toString ();
    }

} //MasterImportImpl
