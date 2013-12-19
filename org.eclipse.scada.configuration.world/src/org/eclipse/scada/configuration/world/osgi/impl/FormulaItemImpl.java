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
import org.eclipse.scada.configuration.world.osgi.CodeFragment;
import org.eclipse.scada.configuration.world.osgi.FormulaItem;
import org.eclipse.scada.configuration.world.osgi.FormulaItemInbound;
import org.eclipse.scada.configuration.world.osgi.FormulaItemOutbound;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Formula Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.FormulaItemImpl#getScriptEngine <em>Script Engine</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.FormulaItemImpl#getInitScripts <em>Init Scripts</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.FormulaItemImpl#getOutbound <em>Outbound</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.impl.FormulaItemImpl#getInbound <em>Inbound</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FormulaItemImpl extends ItemImpl implements FormulaItem
{
    /**
     * The default value of the '{@link #getScriptEngine() <em>Script Engine</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getScriptEngine()
     * @generated
     * @ordered
     */
    protected static final String SCRIPT_ENGINE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getScriptEngine() <em>Script Engine</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getScriptEngine()
     * @generated
     * @ordered
     */
    protected String scriptEngine = SCRIPT_ENGINE_EDEFAULT;

    /**
     * The cached value of the '{@link #getInitScripts() <em>Init Scripts</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInitScripts()
     * @generated
     * @ordered
     */
    protected EList<CodeFragment> initScripts;

    /**
     * The cached value of the '{@link #getOutbound() <em>Outbound</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOutbound()
     * @generated
     * @ordered
     */
    protected FormulaItemOutbound outbound;

    /**
     * The cached value of the '{@link #getInbound() <em>Inbound</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInbound()
     * @generated
     * @ordered
     */
    protected FormulaItemInbound inbound;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected FormulaItemImpl ()
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
        return OsgiPackage.Literals.FORMULA_ITEM;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getScriptEngine ()
    {
        return scriptEngine;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setScriptEngine ( String newScriptEngine )
    {
        String oldScriptEngine = scriptEngine;
        scriptEngine = newScriptEngine;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.FORMULA_ITEM__SCRIPT_ENGINE, oldScriptEngine, scriptEngine ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<CodeFragment> getInitScripts ()
    {
        if ( initScripts == null )
        {
            initScripts = new EObjectContainmentEList.Resolving<CodeFragment> ( CodeFragment.class, this, OsgiPackage.FORMULA_ITEM__INIT_SCRIPTS );
        }
        return initScripts;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FormulaItemOutbound getOutbound ()
    {
        if ( outbound != null && outbound.eIsProxy () )
        {
            InternalEObject oldOutbound = (InternalEObject)outbound;
            outbound = (FormulaItemOutbound)eResolveProxy ( oldOutbound );
            if ( outbound != oldOutbound )
            {
                InternalEObject newOutbound = (InternalEObject)outbound;
                NotificationChain msgs = oldOutbound.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - OsgiPackage.FORMULA_ITEM__OUTBOUND, null, null );
                if ( newOutbound.eInternalContainer () == null )
                {
                    msgs = newOutbound.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - OsgiPackage.FORMULA_ITEM__OUTBOUND, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, OsgiPackage.FORMULA_ITEM__OUTBOUND, oldOutbound, outbound ) );
            }
        }
        return outbound;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FormulaItemOutbound basicGetOutbound ()
    {
        return outbound;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetOutbound ( FormulaItemOutbound newOutbound,
            NotificationChain msgs )
    {
        FormulaItemOutbound oldOutbound = outbound;
        outbound = newOutbound;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, OsgiPackage.FORMULA_ITEM__OUTBOUND, oldOutbound, newOutbound );
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
    public void setOutbound ( FormulaItemOutbound newOutbound )
    {
        if ( newOutbound != outbound )
        {
            NotificationChain msgs = null;
            if ( outbound != null )
                msgs = ( (InternalEObject)outbound ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - OsgiPackage.FORMULA_ITEM__OUTBOUND, null, msgs );
            if ( newOutbound != null )
                msgs = ( (InternalEObject)newOutbound ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - OsgiPackage.FORMULA_ITEM__OUTBOUND, null, msgs );
            msgs = basicSetOutbound ( newOutbound, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.FORMULA_ITEM__OUTBOUND, newOutbound, newOutbound ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FormulaItemInbound getInbound ()
    {
        if ( inbound != null && inbound.eIsProxy () )
        {
            InternalEObject oldInbound = (InternalEObject)inbound;
            inbound = (FormulaItemInbound)eResolveProxy ( oldInbound );
            if ( inbound != oldInbound )
            {
                InternalEObject newInbound = (InternalEObject)inbound;
                NotificationChain msgs = oldInbound.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - OsgiPackage.FORMULA_ITEM__INBOUND, null, null );
                if ( newInbound.eInternalContainer () == null )
                {
                    msgs = newInbound.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - OsgiPackage.FORMULA_ITEM__INBOUND, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, OsgiPackage.FORMULA_ITEM__INBOUND, oldInbound, inbound ) );
            }
        }
        return inbound;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public FormulaItemInbound basicGetInbound ()
    {
        return inbound;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetInbound ( FormulaItemInbound newInbound,
            NotificationChain msgs )
    {
        FormulaItemInbound oldInbound = inbound;
        inbound = newInbound;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, OsgiPackage.FORMULA_ITEM__INBOUND, oldInbound, newInbound );
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
    public void setInbound ( FormulaItemInbound newInbound )
    {
        if ( newInbound != inbound )
        {
            NotificationChain msgs = null;
            if ( inbound != null )
                msgs = ( (InternalEObject)inbound ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - OsgiPackage.FORMULA_ITEM__INBOUND, null, msgs );
            if ( newInbound != null )
                msgs = ( (InternalEObject)newInbound ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - OsgiPackage.FORMULA_ITEM__INBOUND, null, msgs );
            msgs = basicSetInbound ( newInbound, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, OsgiPackage.FORMULA_ITEM__INBOUND, newInbound, newInbound ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove ( InternalEObject otherEnd,
            int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case OsgiPackage.FORMULA_ITEM__INIT_SCRIPTS:
                return ( (InternalEList<?>)getInitScripts () ).basicRemove ( otherEnd, msgs );
            case OsgiPackage.FORMULA_ITEM__OUTBOUND:
                return basicSetOutbound ( null, msgs );
            case OsgiPackage.FORMULA_ITEM__INBOUND:
                return basicSetInbound ( null, msgs );
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
            case OsgiPackage.FORMULA_ITEM__SCRIPT_ENGINE:
                return getScriptEngine ();
            case OsgiPackage.FORMULA_ITEM__INIT_SCRIPTS:
                return getInitScripts ();
            case OsgiPackage.FORMULA_ITEM__OUTBOUND:
                if ( resolve )
                    return getOutbound ();
                return basicGetOutbound ();
            case OsgiPackage.FORMULA_ITEM__INBOUND:
                if ( resolve )
                    return getInbound ();
                return basicGetInbound ();
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
            case OsgiPackage.FORMULA_ITEM__SCRIPT_ENGINE:
                setScriptEngine ( (String)newValue );
                return;
            case OsgiPackage.FORMULA_ITEM__INIT_SCRIPTS:
                getInitScripts ().clear ();
                getInitScripts ().addAll ( (Collection<? extends CodeFragment>)newValue );
                return;
            case OsgiPackage.FORMULA_ITEM__OUTBOUND:
                setOutbound ( (FormulaItemOutbound)newValue );
                return;
            case OsgiPackage.FORMULA_ITEM__INBOUND:
                setInbound ( (FormulaItemInbound)newValue );
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
            case OsgiPackage.FORMULA_ITEM__SCRIPT_ENGINE:
                setScriptEngine ( SCRIPT_ENGINE_EDEFAULT );
                return;
            case OsgiPackage.FORMULA_ITEM__INIT_SCRIPTS:
                getInitScripts ().clear ();
                return;
            case OsgiPackage.FORMULA_ITEM__OUTBOUND:
                setOutbound ( (FormulaItemOutbound)null );
                return;
            case OsgiPackage.FORMULA_ITEM__INBOUND:
                setInbound ( (FormulaItemInbound)null );
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
            case OsgiPackage.FORMULA_ITEM__SCRIPT_ENGINE:
                return SCRIPT_ENGINE_EDEFAULT == null ? scriptEngine != null : !SCRIPT_ENGINE_EDEFAULT.equals ( scriptEngine );
            case OsgiPackage.FORMULA_ITEM__INIT_SCRIPTS:
                return initScripts != null && !initScripts.isEmpty ();
            case OsgiPackage.FORMULA_ITEM__OUTBOUND:
                return outbound != null;
            case OsgiPackage.FORMULA_ITEM__INBOUND:
                return inbound != null;
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
        result.append ( " (scriptEngine: " ); //$NON-NLS-1$
        result.append ( scriptEngine );
        result.append ( ')' );
        return result.toString ();
    }

} //FormulaItemImpl
