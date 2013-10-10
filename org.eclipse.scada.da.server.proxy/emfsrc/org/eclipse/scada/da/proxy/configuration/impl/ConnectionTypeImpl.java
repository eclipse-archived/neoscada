/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.proxy.configuration.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.scada.da.proxy.configuration.ConfigurationPackage;
import org.eclipse.scada.da.proxy.configuration.ConnectionType;
import org.eclipse.scada.da.proxy.configuration.FolderType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.proxy.configuration.impl.ConnectionTypeImpl#getFolder <em>Folder</em>}</li>
 *   <li>{@link org.eclipse.scada.da.proxy.configuration.impl.ConnectionTypeImpl#getClassName <em>Class Name</em>}</li>
 *   <li>{@link org.eclipse.scada.da.proxy.configuration.impl.ConnectionTypeImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.scada.da.proxy.configuration.impl.ConnectionTypeImpl#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.eclipse.scada.da.proxy.configuration.impl.ConnectionTypeImpl#getUri <em>Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectionTypeImpl extends MinimalEObjectImpl.Container implements ConnectionType
{
    //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getFolder() <em>Folder</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFolder()
     * @generated
     * @ordered
     */
    protected FolderType folder;

    /**
     * The default value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getClassName()
     * @generated
     * @ordered
     */
    protected static final String CLASS_NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getClassName()
     * @generated
     * @ordered
     */
    protected String className = CLASS_NAME_EDEFAULT;

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
     * The default value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPrefix()
     * @generated
     * @ordered
     */
    protected static final String PREFIX_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPrefix()
     * @generated
     * @ordered
     */
    protected String prefix = PREFIX_EDEFAULT;

    /**
     * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUri()
     * @generated
     * @ordered
     */
    protected static final String URI_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getUri() <em>Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUri()
     * @generated
     * @ordered
     */
    protected String uri = URI_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ConnectionTypeImpl ()
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
        return ConfigurationPackage.Literals.CONNECTION_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FolderType getFolder ()
    {
        return folder;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetFolder ( FolderType newFolder, NotificationChain msgs )
    {
        FolderType oldFolder = folder;
        folder = newFolder;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.CONNECTION_TYPE__FOLDER, oldFolder, newFolder );
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
    public void setFolder ( FolderType newFolder )
    {
        if ( newFolder != folder )
        {
            NotificationChain msgs = null;
            if ( folder != null )
                msgs = ( (InternalEObject)folder ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.CONNECTION_TYPE__FOLDER, null, msgs );
            if ( newFolder != null )
                msgs = ( (InternalEObject)newFolder ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ConfigurationPackage.CONNECTION_TYPE__FOLDER, null, msgs );
            msgs = basicSetFolder ( newFolder, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.CONNECTION_TYPE__FOLDER, newFolder, newFolder ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getClassName ()
    {
        return className;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setClassName ( String newClassName )
    {
        String oldClassName = className;
        className = newClassName;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.CONNECTION_TYPE__CLASS_NAME, oldClassName, className ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getId ()
    {
        return id;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setId ( String newId )
    {
        String oldId = id;
        id = newId;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.CONNECTION_TYPE__ID, oldId, id ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getPrefix ()
    {
        return prefix;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPrefix ( String newPrefix )
    {
        String oldPrefix = prefix;
        prefix = newPrefix;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.CONNECTION_TYPE__PREFIX, oldPrefix, prefix ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getUri ()
    {
        return uri;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUri ( String newUri )
    {
        String oldUri = uri;
        uri = newUri;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.CONNECTION_TYPE__URI, oldUri, uri ) );
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
            case ConfigurationPackage.CONNECTION_TYPE__FOLDER:
                return basicSetFolder ( null, msgs );
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
            case ConfigurationPackage.CONNECTION_TYPE__FOLDER:
                return getFolder ();
            case ConfigurationPackage.CONNECTION_TYPE__CLASS_NAME:
                return getClassName ();
            case ConfigurationPackage.CONNECTION_TYPE__ID:
                return getId ();
            case ConfigurationPackage.CONNECTION_TYPE__PREFIX:
                return getPrefix ();
            case ConfigurationPackage.CONNECTION_TYPE__URI:
                return getUri ();
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
            case ConfigurationPackage.CONNECTION_TYPE__FOLDER:
                setFolder ( (FolderType)newValue );
                return;
            case ConfigurationPackage.CONNECTION_TYPE__CLASS_NAME:
                setClassName ( (String)newValue );
                return;
            case ConfigurationPackage.CONNECTION_TYPE__ID:
                setId ( (String)newValue );
                return;
            case ConfigurationPackage.CONNECTION_TYPE__PREFIX:
                setPrefix ( (String)newValue );
                return;
            case ConfigurationPackage.CONNECTION_TYPE__URI:
                setUri ( (String)newValue );
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
            case ConfigurationPackage.CONNECTION_TYPE__FOLDER:
                setFolder ( (FolderType)null );
                return;
            case ConfigurationPackage.CONNECTION_TYPE__CLASS_NAME:
                setClassName ( CLASS_NAME_EDEFAULT );
                return;
            case ConfigurationPackage.CONNECTION_TYPE__ID:
                setId ( ID_EDEFAULT );
                return;
            case ConfigurationPackage.CONNECTION_TYPE__PREFIX:
                setPrefix ( PREFIX_EDEFAULT );
                return;
            case ConfigurationPackage.CONNECTION_TYPE__URI:
                setUri ( URI_EDEFAULT );
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
            case ConfigurationPackage.CONNECTION_TYPE__FOLDER:
                return folder != null;
            case ConfigurationPackage.CONNECTION_TYPE__CLASS_NAME:
                return CLASS_NAME_EDEFAULT == null ? className != null : !CLASS_NAME_EDEFAULT.equals ( className );
            case ConfigurationPackage.CONNECTION_TYPE__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals ( id );
            case ConfigurationPackage.CONNECTION_TYPE__PREFIX:
                return PREFIX_EDEFAULT == null ? prefix != null : !PREFIX_EDEFAULT.equals ( prefix );
            case ConfigurationPackage.CONNECTION_TYPE__URI:
                return URI_EDEFAULT == null ? uri != null : !URI_EDEFAULT.equals ( uri );
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
        result.append ( " (className: " ); //$NON-NLS-1$
        result.append ( className );
        result.append ( ", id: " ); //$NON-NLS-1$
        result.append ( id );
        result.append ( ", prefix: " ); //$NON-NLS-1$
        result.append ( prefix );
        result.append ( ", uri: " ); //$NON-NLS-1$
        result.append ( uri );
        result.append ( ')' );
        return result.toString ();
    }

} //ConnectionTypeImpl
