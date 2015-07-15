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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.ae.data.Severity;
import org.eclipse.scada.configuration.world.osgi.ListMonitor;
import org.eclipse.scada.configuration.world.osgi.ListMonitorEntry;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>List Monitor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ListMonitorImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ListMonitorImpl#getMessageAttribute <em>Message Attribute</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ListMonitorImpl#isDefaultAck <em>Default Ack</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ListMonitorImpl#getDefaultSeverity <em>Default Severity</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ListMonitorImpl#getMonitorType <em>Monitor Type</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ListMonitorImpl#getDemotePrefix <em>Demote Prefix</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ListMonitorImpl#getEntries <em>Entries</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ListMonitorImpl extends ItemFeatureEntryImpl implements ListMonitor
{
    /**
     * The default value of the '{@link #getMessage() <em>Message</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMessage()
     * @generated
     * @ordered
     */
    protected static final String MESSAGE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getMessage() <em>Message</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMessage()
     * @generated
     * @ordered
     */
    protected String message = MESSAGE_EDEFAULT;

    /**
     * The default value of the '{@link #getMessageAttribute() <em>Message Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMessageAttribute()
     * @generated
     * @ordered
     */
    protected static final String MESSAGE_ATTRIBUTE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getMessageAttribute() <em>Message Attribute</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMessageAttribute()
     * @generated
     * @ordered
     */
    protected String messageAttribute = MESSAGE_ATTRIBUTE_EDEFAULT;

    /**
     * The default value of the '{@link #isDefaultAck() <em>Default Ack</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDefaultAck()
     * @generated
     * @ordered
     */
    protected static final boolean DEFAULT_ACK_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isDefaultAck() <em>Default Ack</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isDefaultAck()
     * @generated
     * @ordered
     */
    protected boolean defaultAck = DEFAULT_ACK_EDEFAULT;

    /**
     * The default value of the '{@link #getDefaultSeverity() <em>Default Severity</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultSeverity()
     * @generated
     * @ordered
     */
    protected static final Severity DEFAULT_SEVERITY_EDEFAULT = (Severity)OsgiFactory.eINSTANCE.createFromString ( OsgiPackage.eINSTANCE.getSeverity (), "ALARM" ); //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getDefaultSeverity() <em>Default Severity</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDefaultSeverity()
     * @generated
     * @ordered
     */
    protected Severity defaultSeverity = DEFAULT_SEVERITY_EDEFAULT;

    /**
     * The default value of the '{@link #getMonitorType() <em>Monitor Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMonitorType()
     * @generated
     * @ordered
     */
    protected static final String MONITOR_TYPE_EDEFAULT = "LIST"; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getMonitorType() <em>Monitor Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMonitorType()
     * @generated
     * @ordered
     */
    protected String monitorType = MONITOR_TYPE_EDEFAULT;

    /**
     * The default value of the '{@link #getDemotePrefix() <em>Demote Prefix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDemotePrefix()
     * @generated
     * @ordered
     */
    protected static final String DEMOTE_PREFIX_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getDemotePrefix() <em>Demote Prefix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDemotePrefix()
     * @generated
     * @ordered
     */
    protected String demotePrefix = DEMOTE_PREFIX_EDEFAULT;

    /**
     * The cached value of the '{@link #getEntries() <em>Entries</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getEntries()
     * @generated
     * @ordered
     */
    protected EList<ListMonitorEntry> entries;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ListMonitorImpl ()
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
        return OsgiPackage.Literals.LIST_MONITOR;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getMessage ()
    {
        return message;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMessage ( String newMessage )
    {
        String oldMessage = message;
        message = newMessage;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.LIST_MONITOR__MESSAGE, oldMessage, message ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getMessageAttribute ()
    {
        return messageAttribute;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMessageAttribute ( String newMessageAttribute )
    {
        String oldMessageAttribute = messageAttribute;
        messageAttribute = newMessageAttribute;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.LIST_MONITOR__MESSAGE_ATTRIBUTE, oldMessageAttribute, messageAttribute ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isDefaultAck ()
    {
        return defaultAck;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDefaultAck ( boolean newDefaultAck )
    {
        boolean oldDefaultAck = defaultAck;
        defaultAck = newDefaultAck;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.LIST_MONITOR__DEFAULT_ACK, oldDefaultAck, defaultAck ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Severity getDefaultSeverity ()
    {
        return defaultSeverity;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDefaultSeverity ( Severity newDefaultSeverity )
    {
        Severity oldDefaultSeverity = defaultSeverity;
        defaultSeverity = newDefaultSeverity;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.LIST_MONITOR__DEFAULT_SEVERITY, oldDefaultSeverity, defaultSeverity ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getMonitorType ()
    {
        return monitorType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setMonitorType ( String newMonitorType )
    {
        String oldMonitorType = monitorType;
        monitorType = newMonitorType;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.LIST_MONITOR__MONITOR_TYPE, oldMonitorType, monitorType ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getDemotePrefix ()
    {
        return demotePrefix;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDemotePrefix ( String newDemotePrefix )
    {
        String oldDemotePrefix = demotePrefix;
        demotePrefix = newDemotePrefix;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.LIST_MONITOR__DEMOTE_PREFIX, oldDemotePrefix, demotePrefix ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<ListMonitorEntry> getEntries ()
    {
        if ( entries == null )
        {
            entries = new EObjectContainmentEList.Resolving<ListMonitorEntry> ( ListMonitorEntry.class, this, OsgiPackage.LIST_MONITOR__ENTRIES );
        }
        return entries;
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
            case OsgiPackage.LIST_MONITOR__ENTRIES:
                return ( (InternalEList<?>)getEntries () ).basicRemove ( otherEnd, msgs );
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
            case OsgiPackage.LIST_MONITOR__MESSAGE:
                return getMessage ();
            case OsgiPackage.LIST_MONITOR__MESSAGE_ATTRIBUTE:
                return getMessageAttribute ();
            case OsgiPackage.LIST_MONITOR__DEFAULT_ACK:
                return isDefaultAck ();
            case OsgiPackage.LIST_MONITOR__DEFAULT_SEVERITY:
                return getDefaultSeverity ();
            case OsgiPackage.LIST_MONITOR__MONITOR_TYPE:
                return getMonitorType ();
            case OsgiPackage.LIST_MONITOR__DEMOTE_PREFIX:
                return getDemotePrefix ();
            case OsgiPackage.LIST_MONITOR__ENTRIES:
                return getEntries ();
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
            case OsgiPackage.LIST_MONITOR__MESSAGE:
                setMessage ( (String)newValue );
                return;
            case OsgiPackage.LIST_MONITOR__MESSAGE_ATTRIBUTE:
                setMessageAttribute ( (String)newValue );
                return;
            case OsgiPackage.LIST_MONITOR__DEFAULT_ACK:
                setDefaultAck ( (Boolean)newValue );
                return;
            case OsgiPackage.LIST_MONITOR__DEFAULT_SEVERITY:
                setDefaultSeverity ( (Severity)newValue );
                return;
            case OsgiPackage.LIST_MONITOR__MONITOR_TYPE:
                setMonitorType ( (String)newValue );
                return;
            case OsgiPackage.LIST_MONITOR__DEMOTE_PREFIX:
                setDemotePrefix ( (String)newValue );
                return;
            case OsgiPackage.LIST_MONITOR__ENTRIES:
                getEntries ().clear ();
                getEntries ().addAll ( (Collection<? extends ListMonitorEntry>)newValue );
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
            case OsgiPackage.LIST_MONITOR__MESSAGE:
                setMessage ( MESSAGE_EDEFAULT );
                return;
            case OsgiPackage.LIST_MONITOR__MESSAGE_ATTRIBUTE:
                setMessageAttribute ( MESSAGE_ATTRIBUTE_EDEFAULT );
                return;
            case OsgiPackage.LIST_MONITOR__DEFAULT_ACK:
                setDefaultAck ( DEFAULT_ACK_EDEFAULT );
                return;
            case OsgiPackage.LIST_MONITOR__DEFAULT_SEVERITY:
                setDefaultSeverity ( DEFAULT_SEVERITY_EDEFAULT );
                return;
            case OsgiPackage.LIST_MONITOR__MONITOR_TYPE:
                setMonitorType ( MONITOR_TYPE_EDEFAULT );
                return;
            case OsgiPackage.LIST_MONITOR__DEMOTE_PREFIX:
                setDemotePrefix ( DEMOTE_PREFIX_EDEFAULT );
                return;
            case OsgiPackage.LIST_MONITOR__ENTRIES:
                getEntries ().clear ();
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
            case OsgiPackage.LIST_MONITOR__MESSAGE:
                return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals ( message );
            case OsgiPackage.LIST_MONITOR__MESSAGE_ATTRIBUTE:
                return MESSAGE_ATTRIBUTE_EDEFAULT == null ? messageAttribute != null : !MESSAGE_ATTRIBUTE_EDEFAULT.equals ( messageAttribute );
            case OsgiPackage.LIST_MONITOR__DEFAULT_ACK:
                return defaultAck != DEFAULT_ACK_EDEFAULT;
            case OsgiPackage.LIST_MONITOR__DEFAULT_SEVERITY:
                return DEFAULT_SEVERITY_EDEFAULT == null ? defaultSeverity != null : !DEFAULT_SEVERITY_EDEFAULT.equals ( defaultSeverity );
            case OsgiPackage.LIST_MONITOR__MONITOR_TYPE:
                return MONITOR_TYPE_EDEFAULT == null ? monitorType != null : !MONITOR_TYPE_EDEFAULT.equals ( monitorType );
            case OsgiPackage.LIST_MONITOR__DEMOTE_PREFIX:
                return DEMOTE_PREFIX_EDEFAULT == null ? demotePrefix != null : !DEMOTE_PREFIX_EDEFAULT.equals ( demotePrefix );
            case OsgiPackage.LIST_MONITOR__ENTRIES:
                return entries != null && !entries.isEmpty ();
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
        result.append ( " (message: " ); //$NON-NLS-1$
        result.append ( message );
        result.append ( ", messageAttribute: " ); //$NON-NLS-1$
        result.append ( messageAttribute );
        result.append ( ", defaultAck: " ); //$NON-NLS-1$
        result.append ( defaultAck );
        result.append ( ", defaultSeverity: " ); //$NON-NLS-1$
        result.append ( defaultSeverity );
        result.append ( ", monitorType: " ); //$NON-NLS-1$
        result.append ( monitorType );
        result.append ( ", demotePrefix: " ); //$NON-NLS-1$
        result.append ( demotePrefix );
        result.append ( ')' );
        return result.toString ();
    }

} //ListMonitorImpl
