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
package org.eclipse.scada.configuration.item.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.configuration.item.CustomScriptSelector;
import org.eclipse.scada.configuration.item.ItemPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Custom Script Selector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.item.impl.CustomScriptSelectorImpl#getScriptEngine <em>Script Engine</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CustomScriptSelectorImpl extends ScriptSelectorImpl implements CustomScriptSelector
{
    /**
     * The default value of the '{@link #getScriptEngine() <em>Script Engine</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getScriptEngine()
     * @generated
     * @ordered
     */
    protected static final String SCRIPT_ENGINE_EDEFAULT = "JavaScript"; //$NON-NLS-1$

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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CustomScriptSelectorImpl ()
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
        return ItemPackage.Literals.CUSTOM_SCRIPT_SELECTOR;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ItemPackage.CUSTOM_SCRIPT_SELECTOR__SCRIPT_ENGINE, oldScriptEngine, scriptEngine ) );
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
            case ItemPackage.CUSTOM_SCRIPT_SELECTOR__SCRIPT_ENGINE:
                return getScriptEngine ();
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
            case ItemPackage.CUSTOM_SCRIPT_SELECTOR__SCRIPT_ENGINE:
                setScriptEngine ( (String)newValue );
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
            case ItemPackage.CUSTOM_SCRIPT_SELECTOR__SCRIPT_ENGINE:
                setScriptEngine ( SCRIPT_ENGINE_EDEFAULT );
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
            case ItemPackage.CUSTOM_SCRIPT_SELECTOR__SCRIPT_ENGINE:
                return SCRIPT_ENGINE_EDEFAULT == null ? scriptEngine != null : !SCRIPT_ENGINE_EDEFAULT.equals ( scriptEngine );
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

} //CustomScriptSelectorImpl
