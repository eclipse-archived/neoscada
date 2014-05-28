/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 */
package org.eclipse.scada.da.server.component.parser.factory.configuration.impl;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.base.extractor.input.url.UrlConnectionInput;
import org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage;
import org.eclipse.scada.da.server.component.parser.factory.configuration.UrlInput;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Url Input</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.UrlInputImpl#getUrl <em>Url</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.UrlInputImpl#isProbeCharacterSet <em>Probe Character Set</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.UrlInputImpl#getCharset <em>Charset</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UrlInputImpl extends AbstractPeriodInputImpl implements UrlInput
{
    /**
     * The default value of the '{@link #getUrl() <em>Url</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUrl()
     * @generated
     * @ordered
     */
    protected static final String URL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getUrl() <em>Url</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getUrl()
     * @generated
     * @ordered
     */
    protected String url = URL_EDEFAULT;

    /**
     * The default value of the '{@link #isProbeCharacterSet() <em>Probe Character Set</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isProbeCharacterSet()
     * @generated
     * @ordered
     */
    protected static final boolean PROBE_CHARACTER_SET_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isProbeCharacterSet() <em>Probe Character Set</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isProbeCharacterSet()
     * @generated
     * @ordered
     */
    protected boolean probeCharacterSet = PROBE_CHARACTER_SET_EDEFAULT;

    /**
     * The default value of the '{@link #getCharset() <em>Charset</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCharset()
     * @generated
     * @ordered
     */
    protected static final String CHARSET_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCharset() <em>Charset</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCharset()
     * @generated
     * @ordered
     */
    protected String charset = CHARSET_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected UrlInputImpl ()
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
        return ParserPackage.Literals.URL_INPUT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getUrl ()
    {
        return url;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setUrl ( String newUrl )
    {
        String oldUrl = url;
        url = newUrl;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ParserPackage.URL_INPUT__URL, oldUrl, url ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isProbeCharacterSet ()
    {
        return probeCharacterSet;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setProbeCharacterSet ( boolean newProbeCharacterSet )
    {
        boolean oldProbeCharacterSet = probeCharacterSet;
        probeCharacterSet = newProbeCharacterSet;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ParserPackage.URL_INPUT__PROBE_CHARACTER_SET, oldProbeCharacterSet, probeCharacterSet ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getCharset ()
    {
        return charset;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setCharset ( String newCharset )
    {
        String oldCharset = charset;
        charset = newCharset;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ParserPackage.URL_INPUT__CHARSET, oldCharset, charset ) );
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
            case ParserPackage.URL_INPUT__URL:
                return getUrl ();
            case ParserPackage.URL_INPUT__PROBE_CHARACTER_SET:
                return isProbeCharacterSet ();
            case ParserPackage.URL_INPUT__CHARSET:
                return getCharset ();
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
            case ParserPackage.URL_INPUT__URL:
                setUrl ( (String)newValue );
                return;
            case ParserPackage.URL_INPUT__PROBE_CHARACTER_SET:
                setProbeCharacterSet ( (Boolean)newValue );
                return;
            case ParserPackage.URL_INPUT__CHARSET:
                setCharset ( (String)newValue );
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
            case ParserPackage.URL_INPUT__URL:
                setUrl ( URL_EDEFAULT );
                return;
            case ParserPackage.URL_INPUT__PROBE_CHARACTER_SET:
                setProbeCharacterSet ( PROBE_CHARACTER_SET_EDEFAULT );
                return;
            case ParserPackage.URL_INPUT__CHARSET:
                setCharset ( CHARSET_EDEFAULT );
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
            case ParserPackage.URL_INPUT__URL:
                return URL_EDEFAULT == null ? url != null : !URL_EDEFAULT.equals ( url );
            case ParserPackage.URL_INPUT__PROBE_CHARACTER_SET:
                return probeCharacterSet != PROBE_CHARACTER_SET_EDEFAULT;
            case ParserPackage.URL_INPUT__CHARSET:
                return CHARSET_EDEFAULT == null ? charset != null : !CHARSET_EDEFAULT.equals ( charset );
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
        result.append ( " (url: " ); //$NON-NLS-1$
        result.append ( url );
        result.append ( ", probeCharacterSet: " ); //$NON-NLS-1$
        result.append ( probeCharacterSet );
        result.append ( ", charset: " ); //$NON-NLS-1$
        result.append ( charset );
        result.append ( ')' );
        return result.toString ();
    }

    @Override
    public org.eclipse.scada.base.extractor.input.Input createInput ( final org.eclipse.scada.da.server.component.parser.factory.CreationContext creationContext )
    {
        try
        {
            if ( getCharset () != null && !getCharset ().isEmpty () )
            {
                return new UrlConnectionInput ( creationContext.getExecutor (), new URL ( getUrl () ), Charset.forName ( getCharset () ), getPeriod () );
            }
            else
            {
                return new UrlConnectionInput ( creationContext.getExecutor (), new URL ( getUrl () ), isProbeCharacterSet (), getPeriod () );
            }
        }
        catch ( final MalformedURLException e )
        {
            throw new RuntimeException ( "Failed to create input", e );
        }
    };

} //UrlInputImpl
