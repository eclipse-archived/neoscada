/**
 * Copyright (c) 2013 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.modbus.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.scada.configuration.infrastructure.MasterServer;
import org.eclipse.scada.configuration.modbus.ModbusExporterInterceptor;
import org.eclipse.scada.configuration.modbus.ModbusExporterModule;
import org.eclipse.scada.configuration.modbus.ModbusPackage;
import org.eclipse.scada.configuration.script.Script;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Exporter Interceptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.modbus.impl.ModbusExporterInterceptorImpl#getMasterOn <em>Master On</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.impl.ModbusExporterInterceptorImpl#getSettings <em>Settings</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.modbus.impl.ModbusExporterInterceptorImpl#getScript <em>Script</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ModbusExporterInterceptorImpl extends MinimalEObjectImpl.Container implements ModbusExporterInterceptor
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
     * The cached value of the '{@link #getSettings() <em>Settings</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSettings()
     * @generated
     * @ordered
     */
    protected ModbusExporterModule settings;

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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ModbusExporterInterceptorImpl ()
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
        return ModbusPackage.Literals.MODBUS_EXPORTER_INTERCEPTOR;
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
            masterOn = new EObjectResolvingEList<MasterServer> ( MasterServer.class, this, ModbusPackage.MODBUS_EXPORTER_INTERCEPTOR__MASTER_ON );
        }
        return masterOn;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModbusExporterModule getSettings ()
    {
        if ( settings != null && settings.eIsProxy () )
        {
            InternalEObject oldSettings = (InternalEObject)settings;
            settings = (ModbusExporterModule)eResolveProxy ( oldSettings );
            if ( settings != oldSettings )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ModbusPackage.MODBUS_EXPORTER_INTERCEPTOR__SETTINGS, oldSettings, settings ) );
            }
        }
        return settings;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ModbusExporterModule basicGetSettings ()
    {
        return settings;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSettings ( ModbusExporterModule newSettings )
    {
        ModbusExporterModule oldSettings = settings;
        settings = newSettings;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ModbusPackage.MODBUS_EXPORTER_INTERCEPTOR__SETTINGS, oldSettings, settings ) );
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
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, ModbusPackage.MODBUS_EXPORTER_INTERCEPTOR__SCRIPT, oldScript, newScript );
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
                msgs = ( (InternalEObject)script ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ModbusPackage.MODBUS_EXPORTER_INTERCEPTOR__SCRIPT, null, msgs );
            if ( newScript != null )
                msgs = ( (InternalEObject)newScript ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ModbusPackage.MODBUS_EXPORTER_INTERCEPTOR__SCRIPT, null, msgs );
            msgs = basicSetScript ( newScript, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ModbusPackage.MODBUS_EXPORTER_INTERCEPTOR__SCRIPT, newScript, newScript ) );
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
            case ModbusPackage.MODBUS_EXPORTER_INTERCEPTOR__SCRIPT:
                return basicSetScript ( null, msgs );
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
            case ModbusPackage.MODBUS_EXPORTER_INTERCEPTOR__MASTER_ON:
                return getMasterOn ();
            case ModbusPackage.MODBUS_EXPORTER_INTERCEPTOR__SETTINGS:
                if ( resolve )
                    return getSettings ();
                return basicGetSettings ();
            case ModbusPackage.MODBUS_EXPORTER_INTERCEPTOR__SCRIPT:
                return getScript ();
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
            case ModbusPackage.MODBUS_EXPORTER_INTERCEPTOR__MASTER_ON:
                getMasterOn ().clear ();
                getMasterOn ().addAll ( (Collection<? extends MasterServer>)newValue );
                return;
            case ModbusPackage.MODBUS_EXPORTER_INTERCEPTOR__SETTINGS:
                setSettings ( (ModbusExporterModule)newValue );
                return;
            case ModbusPackage.MODBUS_EXPORTER_INTERCEPTOR__SCRIPT:
                setScript ( (Script)newValue );
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
            case ModbusPackage.MODBUS_EXPORTER_INTERCEPTOR__MASTER_ON:
                getMasterOn ().clear ();
                return;
            case ModbusPackage.MODBUS_EXPORTER_INTERCEPTOR__SETTINGS:
                setSettings ( (ModbusExporterModule)null );
                return;
            case ModbusPackage.MODBUS_EXPORTER_INTERCEPTOR__SCRIPT:
                setScript ( (Script)null );
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
            case ModbusPackage.MODBUS_EXPORTER_INTERCEPTOR__MASTER_ON:
                return masterOn != null && !masterOn.isEmpty ();
            case ModbusPackage.MODBUS_EXPORTER_INTERCEPTOR__SETTINGS:
                return settings != null;
            case ModbusPackage.MODBUS_EXPORTER_INTERCEPTOR__SCRIPT:
                return script != null;
        }
        return super.eIsSet ( featureID );
    }

} //ModbusExporterInterceptorImpl
