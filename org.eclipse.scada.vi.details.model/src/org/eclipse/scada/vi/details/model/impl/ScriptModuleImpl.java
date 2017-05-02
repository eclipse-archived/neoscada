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
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.scada.vi.details.model.DetailViewPackage;
import org.eclipse.scada.vi.details.model.ScriptModule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Script Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.ScriptModuleImpl#getScriptLanguage <em>Script Language</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.ScriptModuleImpl#getCode <em>Code</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.details.model.impl.ScriptModuleImpl#getCodeUri <em>Code Uri</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ScriptModuleImpl extends EObjectImpl implements ScriptModule
{
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
     * The default value of the '{@link #getCode() <em>Code</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCode()
     * @generated
     * @ordered
     */
    protected static final String CODE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCode() <em>Code</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCode()
     * @generated
     * @ordered
     */
    protected String code = CODE_EDEFAULT;

    /**
     * The default value of the '{@link #getCodeUri() <em>Code Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCodeUri()
     * @generated
     * @ordered
     */
    protected static final String CODE_URI_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCodeUri() <em>Code Uri</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCodeUri()
     * @generated
     * @ordered
     */
    protected String codeUri = CODE_URI_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ScriptModuleImpl ()
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
        return DetailViewPackage.Literals.SCRIPT_MODULE;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.SCRIPT_MODULE__SCRIPT_LANGUAGE, oldScriptLanguage, scriptLanguage ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getCode ()
    {
        return code;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCode ( String newCode )
    {
        String oldCode = code;
        code = newCode;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.SCRIPT_MODULE__CODE, oldCode, code ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getCodeUri ()
    {
        return codeUri;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCodeUri ( String newCodeUri )
    {
        String oldCodeUri = codeUri;
        codeUri = newCodeUri;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, DetailViewPackage.SCRIPT_MODULE__CODE_URI, oldCodeUri, codeUri ) );
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
            case DetailViewPackage.SCRIPT_MODULE__SCRIPT_LANGUAGE:
                return getScriptLanguage ();
            case DetailViewPackage.SCRIPT_MODULE__CODE:
                return getCode ();
            case DetailViewPackage.SCRIPT_MODULE__CODE_URI:
                return getCodeUri ();
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
            case DetailViewPackage.SCRIPT_MODULE__SCRIPT_LANGUAGE:
                setScriptLanguage ( (String)newValue );
                return;
            case DetailViewPackage.SCRIPT_MODULE__CODE:
                setCode ( (String)newValue );
                return;
            case DetailViewPackage.SCRIPT_MODULE__CODE_URI:
                setCodeUri ( (String)newValue );
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
            case DetailViewPackage.SCRIPT_MODULE__SCRIPT_LANGUAGE:
                setScriptLanguage ( SCRIPT_LANGUAGE_EDEFAULT );
                return;
            case DetailViewPackage.SCRIPT_MODULE__CODE:
                setCode ( CODE_EDEFAULT );
                return;
            case DetailViewPackage.SCRIPT_MODULE__CODE_URI:
                setCodeUri ( CODE_URI_EDEFAULT );
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
            case DetailViewPackage.SCRIPT_MODULE__SCRIPT_LANGUAGE:
                return SCRIPT_LANGUAGE_EDEFAULT == null ? scriptLanguage != null : !SCRIPT_LANGUAGE_EDEFAULT.equals ( scriptLanguage );
            case DetailViewPackage.SCRIPT_MODULE__CODE:
                return CODE_EDEFAULT == null ? code != null : !CODE_EDEFAULT.equals ( code );
            case DetailViewPackage.SCRIPT_MODULE__CODE_URI:
                return CODE_URI_EDEFAULT == null ? codeUri != null : !CODE_URI_EDEFAULT.equals ( codeUri );
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
        result.append ( " (scriptLanguage: " ); //$NON-NLS-1$
        result.append ( scriptLanguage );
        result.append ( ", code: " ); //$NON-NLS-1$
        result.append ( code );
        result.append ( ", codeUri: " ); //$NON-NLS-1$
        result.append ( codeUri );
        result.append ( ')' );
        return result.toString ();
    }

} //ScriptModuleImpl
