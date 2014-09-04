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

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.world.PropertyEntry;
import org.eclipse.scada.configuration.world.osgi.MailEventHandler;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mail Event Handler</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.MailEventHandlerImpl#getSessionProperties <em>Session Properties</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.MailEventHandlerImpl#getFrom <em>From</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.MailEventHandlerImpl#getTo <em>To</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.MailEventHandlerImpl#getUsername <em>Username</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.MailEventHandlerImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.MailEventHandlerImpl#getQueueId <em>Queue Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MailEventHandlerImpl extends MinimalEObjectImpl.Container implements MailEventHandler
{
    /**
     * The cached value of the '{@link #getSessionProperties() <em>Session Properties</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSessionProperties()
     * @generated
     * @ordered
     */
    protected EList<PropertyEntry> sessionProperties;

    /**
     * The default value of the '{@link #getFrom() <em>From</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFrom()
     * @generated
     * @ordered
     */
    protected static final String FROM_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getFrom() <em>From</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFrom()
     * @generated
     * @ordered
     */
    protected String from = FROM_EDEFAULT;

    /**
     * The cached value of the '{@link #getTo() <em>To</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTo()
     * @generated
     * @ordered
     */
    protected EList<String> to;

    /**
     * The default value of the '{@link #getUsername() <em>Username</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUsername()
     * @generated
     * @ordered
     */
    protected static final String USERNAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getUsername() <em>Username</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUsername()
     * @generated
     * @ordered
     */
    protected String username = USERNAME_EDEFAULT;

    /**
     * The default value of the '{@link #getPassword() <em>Password</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPassword()
     * @generated
     * @ordered
     */
    protected static final String PASSWORD_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPassword()
     * @generated
     * @ordered
     */
    protected String password = PASSWORD_EDEFAULT;

    /**
     * The default value of the '{@link #getQueueId() <em>Queue Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getQueueId()
     * @generated
     * @ordered
     */
    protected static final String QUEUE_ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getQueueId() <em>Queue Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getQueueId()
     * @generated
     * @ordered
     */
    protected String queueId = QUEUE_ID_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected MailEventHandlerImpl ()
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
        return OsgiPackage.Literals.MAIL_EVENT_HANDLER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<PropertyEntry> getSessionProperties ()
    {
        if ( sessionProperties == null )
        {
            sessionProperties = new EObjectContainmentEList.Resolving<PropertyEntry> ( PropertyEntry.class, this, OsgiPackage.MAIL_EVENT_HANDLER__SESSION_PROPERTIES );
        }
        return sessionProperties;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getFrom ()
    {
        return from;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setFrom ( String newFrom )
    {
        String oldFrom = from;
        from = newFrom;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.MAIL_EVENT_HANDLER__FROM, oldFrom, from ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getTo ()
    {
        if ( to == null )
        {
            to = new EDataTypeUniqueEList<String> ( String.class, this, OsgiPackage.MAIL_EVENT_HANDLER__TO );
        }
        return to;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getUsername ()
    {
        return username;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUsername ( String newUsername )
    {
        String oldUsername = username;
        username = newUsername;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.MAIL_EVENT_HANDLER__USERNAME, oldUsername, username ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getPassword ()
    {
        return password;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPassword ( String newPassword )
    {
        String oldPassword = password;
        password = newPassword;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.MAIL_EVENT_HANDLER__PASSWORD, oldPassword, password ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getQueueId ()
    {
        return queueId;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setQueueId ( String newQueueId )
    {
        String oldQueueId = queueId;
        queueId = newQueueId;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.MAIL_EVENT_HANDLER__QUEUE_ID, oldQueueId, queueId ) );
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
            case OsgiPackage.MAIL_EVENT_HANDLER__SESSION_PROPERTIES:
                return ( (InternalEList<?>)getSessionProperties () ).basicRemove ( otherEnd, msgs );
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
            case OsgiPackage.MAIL_EVENT_HANDLER__SESSION_PROPERTIES:
                return getSessionProperties ();
            case OsgiPackage.MAIL_EVENT_HANDLER__FROM:
                return getFrom ();
            case OsgiPackage.MAIL_EVENT_HANDLER__TO:
                return getTo ();
            case OsgiPackage.MAIL_EVENT_HANDLER__USERNAME:
                return getUsername ();
            case OsgiPackage.MAIL_EVENT_HANDLER__PASSWORD:
                return getPassword ();
            case OsgiPackage.MAIL_EVENT_HANDLER__QUEUE_ID:
                return getQueueId ();
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
            case OsgiPackage.MAIL_EVENT_HANDLER__SESSION_PROPERTIES:
                getSessionProperties ().clear ();
                getSessionProperties ().addAll ( (Collection<? extends PropertyEntry>)newValue );
                return;
            case OsgiPackage.MAIL_EVENT_HANDLER__FROM:
                setFrom ( (String)newValue );
                return;
            case OsgiPackage.MAIL_EVENT_HANDLER__TO:
                getTo ().clear ();
                getTo ().addAll ( (Collection<? extends String>)newValue );
                return;
            case OsgiPackage.MAIL_EVENT_HANDLER__USERNAME:
                setUsername ( (String)newValue );
                return;
            case OsgiPackage.MAIL_EVENT_HANDLER__PASSWORD:
                setPassword ( (String)newValue );
                return;
            case OsgiPackage.MAIL_EVENT_HANDLER__QUEUE_ID:
                setQueueId ( (String)newValue );
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
            case OsgiPackage.MAIL_EVENT_HANDLER__SESSION_PROPERTIES:
                getSessionProperties ().clear ();
                return;
            case OsgiPackage.MAIL_EVENT_HANDLER__FROM:
                setFrom ( FROM_EDEFAULT );
                return;
            case OsgiPackage.MAIL_EVENT_HANDLER__TO:
                getTo ().clear ();
                return;
            case OsgiPackage.MAIL_EVENT_HANDLER__USERNAME:
                setUsername ( USERNAME_EDEFAULT );
                return;
            case OsgiPackage.MAIL_EVENT_HANDLER__PASSWORD:
                setPassword ( PASSWORD_EDEFAULT );
                return;
            case OsgiPackage.MAIL_EVENT_HANDLER__QUEUE_ID:
                setQueueId ( QUEUE_ID_EDEFAULT );
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
            case OsgiPackage.MAIL_EVENT_HANDLER__SESSION_PROPERTIES:
                return sessionProperties != null && !sessionProperties.isEmpty ();
            case OsgiPackage.MAIL_EVENT_HANDLER__FROM:
                return FROM_EDEFAULT == null ? from != null : !FROM_EDEFAULT.equals ( from );
            case OsgiPackage.MAIL_EVENT_HANDLER__TO:
                return to != null && !to.isEmpty ();
            case OsgiPackage.MAIL_EVENT_HANDLER__USERNAME:
                return USERNAME_EDEFAULT == null ? username != null : !USERNAME_EDEFAULT.equals ( username );
            case OsgiPackage.MAIL_EVENT_HANDLER__PASSWORD:
                return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals ( password );
            case OsgiPackage.MAIL_EVENT_HANDLER__QUEUE_ID:
                return QUEUE_ID_EDEFAULT == null ? queueId != null : !QUEUE_ID_EDEFAULT.equals ( queueId );
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
        result.append ( " (from: " ); //$NON-NLS-1$
        result.append ( from );
        result.append ( ", to: " ); //$NON-NLS-1$
        result.append ( to );
        result.append ( ", username: " ); //$NON-NLS-1$
        result.append ( username );
        result.append ( ", password: " ); //$NON-NLS-1$
        result.append ( password );
        result.append ( ", queueId: " ); //$NON-NLS-1$
        result.append ( queueId );
        result.append ( ')' );
        return result.toString ();
    }

} //MailEventHandlerImpl
