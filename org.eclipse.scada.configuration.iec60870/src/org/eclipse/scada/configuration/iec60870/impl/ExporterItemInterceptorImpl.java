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
package org.eclipse.scada.configuration.iec60870.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.scada.configuration.iec60870.DataModuleOptions;
import org.eclipse.scada.configuration.iec60870.ExporterItemInterceptor;
import org.eclipse.scada.configuration.iec60870.IEC60870Package;
import org.eclipse.scada.configuration.iec60870.ProtocolOptions;

import org.eclipse.scada.configuration.infrastructure.MasterServer;

import org.eclipse.scada.configuration.script.Script;

import org.eclipse.scada.configuration.world.PropertyEntry;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Exporter Item Interceptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.iec60870.impl.ExporterItemInterceptorImpl#getMasterOn <em>Master On</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.iec60870.impl.ExporterItemInterceptorImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.iec60870.impl.ExporterItemInterceptorImpl#getScript <em>Script</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.iec60870.impl.ExporterItemInterceptorImpl#getProtocolOptions <em>Protocol Options</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.iec60870.impl.ExporterItemInterceptorImpl#getDataModuleOptions <em>Data Module Options</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.iec60870.impl.ExporterItemInterceptorImpl#getPort <em>Port</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExporterItemInterceptorImpl extends MinimalEObjectImpl.Container implements ExporterItemInterceptor
{
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
     * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProperties()
     * @generated
     * @ordered
     */
    protected EList<PropertyEntry> properties;

    /**
     * The cached value of the '{@link #getScript() <em>Script</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getScript()
     * @generated
     * @ordered
     */
    protected Script script;

    /**
     * The cached value of the '{@link #getProtocolOptions() <em>Protocol Options</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProtocolOptions()
     * @generated
     * @ordered
     */
    protected ProtocolOptions protocolOptions;

    /**
     * The cached value of the '{@link #getDataModuleOptions() <em>Data Module Options</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataModuleOptions()
     * @generated
     * @ordered
     */
    protected DataModuleOptions dataModuleOptions;

    /**
     * The default value of the '{@link #getPort() <em>Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPort()
     * @generated
     * @ordered
     */
    protected static final short PORT_EDEFAULT = 2404;

    /**
     * The cached value of the '{@link #getPort() <em>Port</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPort()
     * @generated
     * @ordered
     */
    protected short port = PORT_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ExporterItemInterceptorImpl ()
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
        return IEC60870Package.Literals.EXPORTER_ITEM_INTERCEPTOR;
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
            masterOn = new EObjectResolvingEList<MasterServer> ( MasterServer.class, this, IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__MASTER_ON );
        }
        return masterOn;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<PropertyEntry> getProperties ()
    {
        if ( properties == null )
        {
            properties = new EObjectContainmentEList.Resolving<PropertyEntry> ( PropertyEntry.class, this, IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__PROPERTIES );
        }
        return properties;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Script getScript ()
    {
        return script;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetScript ( Script newScript, NotificationChain msgs )
    {
        Script oldScript = script;
        script = newScript;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__SCRIPT, oldScript, newScript );
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
    public void setScript ( Script newScript )
    {
        if ( newScript != script )
        {
            NotificationChain msgs = null;
            if ( script != null )
                msgs = ( (InternalEObject)script ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__SCRIPT, null, msgs );
            if ( newScript != null )
                msgs = ( (InternalEObject)newScript ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__SCRIPT, null, msgs );
            msgs = basicSetScript ( newScript, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__SCRIPT, newScript, newScript ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ProtocolOptions getProtocolOptions ()
    {
        return protocolOptions;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetProtocolOptions ( ProtocolOptions newProtocolOptions, NotificationChain msgs )
    {
        ProtocolOptions oldProtocolOptions = protocolOptions;
        protocolOptions = newProtocolOptions;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__PROTOCOL_OPTIONS, oldProtocolOptions, newProtocolOptions );
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
    public void setProtocolOptions ( ProtocolOptions newProtocolOptions )
    {
        if ( newProtocolOptions != protocolOptions )
        {
            NotificationChain msgs = null;
            if ( protocolOptions != null )
                msgs = ( (InternalEObject)protocolOptions ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__PROTOCOL_OPTIONS, null, msgs );
            if ( newProtocolOptions != null )
                msgs = ( (InternalEObject)newProtocolOptions ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__PROTOCOL_OPTIONS, null, msgs );
            msgs = basicSetProtocolOptions ( newProtocolOptions, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__PROTOCOL_OPTIONS, newProtocolOptions, newProtocolOptions ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataModuleOptions getDataModuleOptions ()
    {
        return dataModuleOptions;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDataModuleOptions ( DataModuleOptions newDataModuleOptions, NotificationChain msgs )
    {
        DataModuleOptions oldDataModuleOptions = dataModuleOptions;
        dataModuleOptions = newDataModuleOptions;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__DATA_MODULE_OPTIONS, oldDataModuleOptions, newDataModuleOptions );
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
    public void setDataModuleOptions ( DataModuleOptions newDataModuleOptions )
    {
        if ( newDataModuleOptions != dataModuleOptions )
        {
            NotificationChain msgs = null;
            if ( dataModuleOptions != null )
                msgs = ( (InternalEObject)dataModuleOptions ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__DATA_MODULE_OPTIONS, null, msgs );
            if ( newDataModuleOptions != null )
                msgs = ( (InternalEObject)newDataModuleOptions ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__DATA_MODULE_OPTIONS, null, msgs );
            msgs = basicSetDataModuleOptions ( newDataModuleOptions, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__DATA_MODULE_OPTIONS, newDataModuleOptions, newDataModuleOptions ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public short getPort ()
    {
        return port;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPort ( short newPort )
    {
        short oldPort = port;
        port = newPort;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__PORT, oldPort, port ) );
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
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__PROPERTIES:
                return ( (InternalEList<?>)getProperties () ).basicRemove ( otherEnd, msgs );
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__SCRIPT:
                return basicSetScript ( null, msgs );
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__PROTOCOL_OPTIONS:
                return basicSetProtocolOptions ( null, msgs );
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__DATA_MODULE_OPTIONS:
                return basicSetDataModuleOptions ( null, msgs );
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
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__MASTER_ON:
                return getMasterOn ();
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__PROPERTIES:
                return getProperties ();
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__SCRIPT:
                return getScript ();
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__PROTOCOL_OPTIONS:
                return getProtocolOptions ();
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__DATA_MODULE_OPTIONS:
                return getDataModuleOptions ();
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__PORT:
                return getPort ();
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
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__MASTER_ON:
                getMasterOn ().clear ();
                getMasterOn ().addAll ( (Collection<? extends MasterServer>)newValue );
                return;
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__PROPERTIES:
                getProperties ().clear ();
                getProperties ().addAll ( (Collection<? extends PropertyEntry>)newValue );
                return;
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__SCRIPT:
                setScript ( (Script)newValue );
                return;
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__PROTOCOL_OPTIONS:
                setProtocolOptions ( (ProtocolOptions)newValue );
                return;
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__DATA_MODULE_OPTIONS:
                setDataModuleOptions ( (DataModuleOptions)newValue );
                return;
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__PORT:
                setPort ( (Short)newValue );
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
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__MASTER_ON:
                getMasterOn ().clear ();
                return;
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__PROPERTIES:
                getProperties ().clear ();
                return;
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__SCRIPT:
                setScript ( (Script)null );
                return;
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__PROTOCOL_OPTIONS:
                setProtocolOptions ( (ProtocolOptions)null );
                return;
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__DATA_MODULE_OPTIONS:
                setDataModuleOptions ( (DataModuleOptions)null );
                return;
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__PORT:
                setPort ( PORT_EDEFAULT );
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
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__MASTER_ON:
                return masterOn != null && !masterOn.isEmpty ();
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__PROPERTIES:
                return properties != null && !properties.isEmpty ();
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__SCRIPT:
                return script != null;
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__PROTOCOL_OPTIONS:
                return protocolOptions != null;
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__DATA_MODULE_OPTIONS:
                return dataModuleOptions != null;
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR__PORT:
                return port != PORT_EDEFAULT;
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
        result.append ( " (port: " ); //$NON-NLS-1$
        result.append ( port );
        result.append ( ')' );
        return result.toString ();
    }

} //ExporterItemInterceptorImpl
