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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.scada.configuration.script.JavaScript;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.configuration.world.osgi.ScriptEventHandler;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Script Event Handler</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.ScriptEventHandlerImpl#getScript <em>Script</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScriptEventHandlerImpl extends MinimalEObjectImpl.Container implements ScriptEventHandler
{
    /**
     * The cached value of the '{@link #getScript() <em>Script</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getScript()
     * @generated
     * @ordered
     */
    protected JavaScript script;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ScriptEventHandlerImpl ()
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
        return OsgiPackage.Literals.SCRIPT_EVENT_HANDLER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public JavaScript getScript ()
    {
        if ( script != null && script.eIsProxy () )
        {
            InternalEObject oldScript = (InternalEObject)script;
            script = (JavaScript)eResolveProxy ( oldScript );
            if ( script != oldScript )
            {
                InternalEObject newScript = (InternalEObject)script;
                NotificationChain msgs = oldScript.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - OsgiPackage.SCRIPT_EVENT_HANDLER__SCRIPT, null, null );
                if ( newScript.eInternalContainer () == null )
                {
                    msgs = newScript.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - OsgiPackage.SCRIPT_EVENT_HANDLER__SCRIPT, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, OsgiPackage.SCRIPT_EVENT_HANDLER__SCRIPT, oldScript, script ) );
            }
        }
        return script;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public JavaScript basicGetScript ()
    {
        return script;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetScript ( JavaScript newScript, NotificationChain msgs )
    {
        JavaScript oldScript = script;
        script = newScript;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, OsgiPackage.SCRIPT_EVENT_HANDLER__SCRIPT, oldScript, newScript );
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
    public void setScript ( JavaScript newScript )
    {
        if ( newScript != script )
        {
            NotificationChain msgs = null;
            if ( script != null )
                msgs = ( (InternalEObject)script ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - OsgiPackage.SCRIPT_EVENT_HANDLER__SCRIPT, null, msgs );
            if ( newScript != null )
                msgs = ( (InternalEObject)newScript ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - OsgiPackage.SCRIPT_EVENT_HANDLER__SCRIPT, null, msgs );
            msgs = basicSetScript ( newScript, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.SCRIPT_EVENT_HANDLER__SCRIPT, newScript, newScript ) );
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
            case OsgiPackage.SCRIPT_EVENT_HANDLER__SCRIPT:
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
            case OsgiPackage.SCRIPT_EVENT_HANDLER__SCRIPT:
                if ( resolve )
                    return getScript ();
                return basicGetScript ();
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
            case OsgiPackage.SCRIPT_EVENT_HANDLER__SCRIPT:
                setScript ( (JavaScript)newValue );
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
            case OsgiPackage.SCRIPT_EVENT_HANDLER__SCRIPT:
                setScript ( (JavaScript)null );
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
            case OsgiPackage.SCRIPT_EVENT_HANDLER__SCRIPT:
                return script != null;
        }
        return super.eIsSet ( featureID );
    }

} //ScriptEventHandlerImpl
