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
package org.eclipse.scada.configuration.globalization.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.globalization.Authorative;
import org.eclipse.scada.configuration.globalization.Filter;
import org.eclipse.scada.configuration.globalization.Global;
import org.eclipse.scada.configuration.globalization.GlobalizePackage;
import org.eclipse.scada.configuration.globalization.Local;
import org.eclipse.scada.configuration.world.Credentials;
import org.eclipse.scada.configuration.world.osgi.MasterServer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Local</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.globalization.impl.LocalImpl#getLocal <em>Local</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.globalization.impl.LocalImpl#getLogonCredentials <em>Logon Credentials</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.globalization.impl.LocalImpl#getFilters <em>Filters</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.globalization.impl.LocalImpl#isDefaultInclude <em>Default Include</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.globalization.impl.LocalImpl#getGlobal <em>Global</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.globalization.impl.LocalImpl#getAuthoratives <em>Authoratives</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.globalization.impl.LocalImpl#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LocalImpl extends MinimalEObjectImpl.Container implements Local
{
    /**
     * The cached value of the '{@link #getLocal() <em>Local</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLocal()
     * @generated
     * @ordered
     */
    protected MasterServer local;

    /**
     * The cached value of the '{@link #getLogonCredentials() <em>Logon Credentials</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getLogonCredentials()
     * @generated
     * @ordered
     */
    protected Credentials logonCredentials;

    /**
     * The cached value of the '{@link #getFilters() <em>Filters</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFilters()
     * @generated
     * @ordered
     */
    protected EList<Filter> filters;

    /**
     * The default value of the '{@link #isDefaultInclude() <em>Default Include</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDefaultInclude()
     * @generated
     * @ordered
     */
    protected static final boolean DEFAULT_INCLUDE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isDefaultInclude() <em>Default Include</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDefaultInclude()
     * @generated
     * @ordered
     */
    protected boolean defaultInclude = DEFAULT_INCLUDE_EDEFAULT;

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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected LocalImpl ()
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
        return GlobalizePackage.Literals.LOCAL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MasterServer getLocal ()
    {
        if ( local != null && local.eIsProxy () )
        {
            InternalEObject oldLocal = (InternalEObject)local;
            local = (MasterServer)eResolveProxy ( oldLocal );
            if ( local != oldLocal )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, GlobalizePackage.LOCAL__LOCAL, oldLocal, local ) );
            }
        }
        return local;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MasterServer basicGetLocal ()
    {
        return local;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setLocal ( MasterServer newLocal )
    {
        MasterServer oldLocal = local;
        local = newLocal;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, GlobalizePackage.LOCAL__LOCAL, oldLocal, local ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Credentials getLogonCredentials ()
    {
        if ( logonCredentials != null && logonCredentials.eIsProxy () )
        {
            InternalEObject oldLogonCredentials = (InternalEObject)logonCredentials;
            logonCredentials = (Credentials)eResolveProxy ( oldLogonCredentials );
            if ( logonCredentials != oldLogonCredentials )
            {
                InternalEObject newLogonCredentials = (InternalEObject)logonCredentials;
                NotificationChain msgs = oldLogonCredentials.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - GlobalizePackage.LOCAL__LOGON_CREDENTIALS, null, null );
                if ( newLogonCredentials.eInternalContainer () == null )
                {
                    msgs = newLogonCredentials.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - GlobalizePackage.LOCAL__LOGON_CREDENTIALS, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, GlobalizePackage.LOCAL__LOGON_CREDENTIALS, oldLogonCredentials, logonCredentials ) );
            }
        }
        return logonCredentials;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Credentials basicGetLogonCredentials ()
    {
        return logonCredentials;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetLogonCredentials ( Credentials newLogonCredentials, NotificationChain msgs )
    {
        Credentials oldLogonCredentials = logonCredentials;
        logonCredentials = newLogonCredentials;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, GlobalizePackage.LOCAL__LOGON_CREDENTIALS, oldLogonCredentials, newLogonCredentials );
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
    public void setLogonCredentials ( Credentials newLogonCredentials )
    {
        if ( newLogonCredentials != logonCredentials )
        {
            NotificationChain msgs = null;
            if ( logonCredentials != null )
                msgs = ( (InternalEObject)logonCredentials ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - GlobalizePackage.LOCAL__LOGON_CREDENTIALS, null, msgs );
            if ( newLogonCredentials != null )
                msgs = ( (InternalEObject)newLogonCredentials ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - GlobalizePackage.LOCAL__LOGON_CREDENTIALS, null, msgs );
            msgs = basicSetLogonCredentials ( newLogonCredentials, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, GlobalizePackage.LOCAL__LOGON_CREDENTIALS, newLogonCredentials, newLogonCredentials ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Filter> getFilters ()
    {
        if ( filters == null )
        {
            filters = new EObjectContainmentEList.Resolving<Filter> ( Filter.class, this, GlobalizePackage.LOCAL__FILTERS );
        }
        return filters;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isDefaultInclude ()
    {
        return defaultInclude;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDefaultInclude ( boolean newDefaultInclude )
    {
        boolean oldDefaultInclude = defaultInclude;
        defaultInclude = newDefaultInclude;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, GlobalizePackage.LOCAL__DEFAULT_INCLUDE, oldDefaultInclude, defaultInclude ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Global getGlobal ()
    {
        if ( eContainerFeatureID () != GlobalizePackage.LOCAL__GLOBAL )
            return null;
        return (Global)eContainer ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Global basicGetGlobal ()
    {
        if ( eContainerFeatureID () != GlobalizePackage.LOCAL__GLOBAL )
            return null;
        return (Global)eInternalContainer ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetGlobal ( Global newGlobal, NotificationChain msgs )
    {
        msgs = eBasicSetContainer ( (InternalEObject)newGlobal, GlobalizePackage.LOCAL__GLOBAL, msgs );
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setGlobal ( Global newGlobal )
    {
        if ( newGlobal != eInternalContainer () || ( eContainerFeatureID () != GlobalizePackage.LOCAL__GLOBAL && newGlobal != null ) )
        {
            if ( EcoreUtil.isAncestor ( this, newGlobal ) )
                throw new IllegalArgumentException ( "Recursive containment not allowed for " + toString () ); //$NON-NLS-1$
            NotificationChain msgs = null;
            if ( eInternalContainer () != null )
                msgs = eBasicRemoveFromContainer ( msgs );
            if ( newGlobal != null )
                msgs = ( (InternalEObject)newGlobal ).eInverseAdd ( this, GlobalizePackage.GLOBAL__LOCALS, Global.class, msgs );
            msgs = basicSetGlobal ( newGlobal, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, GlobalizePackage.LOCAL__GLOBAL, newGlobal, newGlobal ) );
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
            authoratives = new EObjectContainmentEList.Resolving<Authorative> ( Authorative.class, this, GlobalizePackage.LOCAL__AUTHORATIVES );
        }
        return authoratives;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, GlobalizePackage.LOCAL__ID, oldId, id ) );
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
            case GlobalizePackage.LOCAL__GLOBAL:
                if ( eInternalContainer () != null )
                    msgs = eBasicRemoveFromContainer ( msgs );
                return basicSetGlobal ( (Global)otherEnd, msgs );
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
            case GlobalizePackage.LOCAL__LOGON_CREDENTIALS:
                return basicSetLogonCredentials ( null, msgs );
            case GlobalizePackage.LOCAL__FILTERS:
                return ( (InternalEList<?>)getFilters () ).basicRemove ( otherEnd, msgs );
            case GlobalizePackage.LOCAL__GLOBAL:
                return basicSetGlobal ( null, msgs );
            case GlobalizePackage.LOCAL__AUTHORATIVES:
                return ( (InternalEList<?>)getAuthoratives () ).basicRemove ( otherEnd, msgs );
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
            case GlobalizePackage.LOCAL__GLOBAL:
                return eInternalContainer ().eInverseRemove ( this, GlobalizePackage.GLOBAL__LOCALS, Global.class, msgs );
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
            case GlobalizePackage.LOCAL__LOCAL:
                if ( resolve )
                    return getLocal ();
                return basicGetLocal ();
            case GlobalizePackage.LOCAL__LOGON_CREDENTIALS:
                if ( resolve )
                    return getLogonCredentials ();
                return basicGetLogonCredentials ();
            case GlobalizePackage.LOCAL__FILTERS:
                return getFilters ();
            case GlobalizePackage.LOCAL__DEFAULT_INCLUDE:
                return isDefaultInclude ();
            case GlobalizePackage.LOCAL__GLOBAL:
                if ( resolve )
                    return getGlobal ();
                return basicGetGlobal ();
            case GlobalizePackage.LOCAL__AUTHORATIVES:
                return getAuthoratives ();
            case GlobalizePackage.LOCAL__ID:
                return getId ();
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
            case GlobalizePackage.LOCAL__LOCAL:
                setLocal ( (MasterServer)newValue );
                return;
            case GlobalizePackage.LOCAL__LOGON_CREDENTIALS:
                setLogonCredentials ( (Credentials)newValue );
                return;
            case GlobalizePackage.LOCAL__FILTERS:
                getFilters ().clear ();
                getFilters ().addAll ( (Collection<? extends Filter>)newValue );
                return;
            case GlobalizePackage.LOCAL__DEFAULT_INCLUDE:
                setDefaultInclude ( (Boolean)newValue );
                return;
            case GlobalizePackage.LOCAL__GLOBAL:
                setGlobal ( (Global)newValue );
                return;
            case GlobalizePackage.LOCAL__AUTHORATIVES:
                getAuthoratives ().clear ();
                getAuthoratives ().addAll ( (Collection<? extends Authorative>)newValue );
                return;
            case GlobalizePackage.LOCAL__ID:
                setId ( (String)newValue );
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
            case GlobalizePackage.LOCAL__LOCAL:
                setLocal ( (MasterServer)null );
                return;
            case GlobalizePackage.LOCAL__LOGON_CREDENTIALS:
                setLogonCredentials ( (Credentials)null );
                return;
            case GlobalizePackage.LOCAL__FILTERS:
                getFilters ().clear ();
                return;
            case GlobalizePackage.LOCAL__DEFAULT_INCLUDE:
                setDefaultInclude ( DEFAULT_INCLUDE_EDEFAULT );
                return;
            case GlobalizePackage.LOCAL__GLOBAL:
                setGlobal ( (Global)null );
                return;
            case GlobalizePackage.LOCAL__AUTHORATIVES:
                getAuthoratives ().clear ();
                return;
            case GlobalizePackage.LOCAL__ID:
                setId ( ID_EDEFAULT );
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
            case GlobalizePackage.LOCAL__LOCAL:
                return local != null;
            case GlobalizePackage.LOCAL__LOGON_CREDENTIALS:
                return logonCredentials != null;
            case GlobalizePackage.LOCAL__FILTERS:
                return filters != null && !filters.isEmpty ();
            case GlobalizePackage.LOCAL__DEFAULT_INCLUDE:
                return defaultInclude != DEFAULT_INCLUDE_EDEFAULT;
            case GlobalizePackage.LOCAL__GLOBAL:
                return basicGetGlobal () != null;
            case GlobalizePackage.LOCAL__AUTHORATIVES:
                return authoratives != null && !authoratives.isEmpty ();
            case GlobalizePackage.LOCAL__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals ( id );
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
        result.append ( " (defaultInclude: " ); //$NON-NLS-1$
        result.append ( defaultInclude );
        result.append ( ", id: " ); //$NON-NLS-1$
        result.append ( id );
        result.append ( ')' );
        return result.toString ();
    }

} //LocalImpl
