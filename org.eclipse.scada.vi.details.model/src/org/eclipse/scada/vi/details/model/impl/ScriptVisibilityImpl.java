/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.details.model.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.vi.details.model.DetailViewPackage;
import org.eclipse.scada.vi.details.model.ScriptVisibility;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Script Visibility</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.ScriptVisibilityImpl#getScript <em>Script</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.ScriptVisibilityImpl#getScriptLanguage <em>Script Language</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScriptVisibilityImpl extends VisibilityImpl implements ScriptVisibility
{
    /**
     * The default value of the '{@link #getScript() <em>Script</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getScript()
     * @generated
     * @ordered
     */
    protected static final String SCRIPT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getScript() <em>Script</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getScript()
     * @generated
     * @ordered
     */
    protected String script = SCRIPT_EDEFAULT;

    /**
     * The default value of the '{@link #getScriptLanguage() <em>Script Language</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getScriptLanguage()
     * @generated
     * @ordered
     */
    protected static final String SCRIPT_LANGUAGE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getScriptLanguage() <em>Script Language</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getScriptLanguage()
     * @generated
     * @ordered
     */
    protected String scriptLanguage = SCRIPT_LANGUAGE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ScriptVisibilityImpl ()
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
        return DetailViewPackage.Literals.SCRIPT_VISIBILITY;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getScript ()
    {
        return script;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setScript ( String newScript )
    {
        String oldScript = script;
        script = newScript;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.SCRIPT_VISIBILITY__SCRIPT, oldScript, script ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getScriptLanguage ()
    {
        return scriptLanguage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setScriptLanguage ( String newScriptLanguage )
    {
        String oldScriptLanguage = scriptLanguage;
        scriptLanguage = newScriptLanguage;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.SCRIPT_VISIBILITY__SCRIPT_LANGUAGE, oldScriptLanguage, scriptLanguage ) );
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
            case DetailViewPackage.SCRIPT_VISIBILITY__SCRIPT:
                return getScript ();
            case DetailViewPackage.SCRIPT_VISIBILITY__SCRIPT_LANGUAGE:
                return getScriptLanguage ();
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
            case DetailViewPackage.SCRIPT_VISIBILITY__SCRIPT:
                setScript ( (String)newValue );
                return;
            case DetailViewPackage.SCRIPT_VISIBILITY__SCRIPT_LANGUAGE:
                setScriptLanguage ( (String)newValue );
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
            case DetailViewPackage.SCRIPT_VISIBILITY__SCRIPT:
                setScript ( SCRIPT_EDEFAULT );
                return;
            case DetailViewPackage.SCRIPT_VISIBILITY__SCRIPT_LANGUAGE:
                setScriptLanguage ( SCRIPT_LANGUAGE_EDEFAULT );
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
            case DetailViewPackage.SCRIPT_VISIBILITY__SCRIPT:
                return SCRIPT_EDEFAULT == null ? script != null : !SCRIPT_EDEFAULT.equals ( script );
            case DetailViewPackage.SCRIPT_VISIBILITY__SCRIPT_LANGUAGE:
                return SCRIPT_LANGUAGE_EDEFAULT == null ? scriptLanguage != null : !SCRIPT_LANGUAGE_EDEFAULT.equals ( scriptLanguage );
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
        result.append ( " (script: " ); //$NON-NLS-1$
        result.append ( script );
        result.append ( ", scriptLanguage: " ); //$NON-NLS-1$
        result.append ( scriptLanguage );
        result.append ( ')' );
        return result.toString ();
    }

} //ScriptVisibilityImpl
