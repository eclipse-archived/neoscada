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
package org.eclipse.scada.configuration.security.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.scada.configuration.security.CA;
import org.eclipse.scada.configuration.security.SecurityPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CA</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.security.impl.CAImpl#getCertificateUrl <em>Certificate Url</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.security.impl.CAImpl#getCrlUrl <em>Crl Url</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CAImpl extends EObjectImpl implements CA
{
    /**
     * The default value of the '{@link #getCertificateUrl() <em>Certificate Url</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCertificateUrl()
     * @generated
     * @ordered
     */
    protected static final String CERTIFICATE_URL_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getCertificateUrl() <em>Certificate Url</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCertificateUrl()
     * @generated
     * @ordered
     */
    protected String certificateUrl = CERTIFICATE_URL_EDEFAULT;

    /**
     * The cached value of the '{@link #getCrlUrl() <em>Crl Url</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCrlUrl()
     * @generated
     * @ordered
     */
    protected EList<String> crlUrl;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CAImpl ()
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
        return SecurityPackage.Literals.CA;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getCertificateUrl ()
    {
        return certificateUrl;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCertificateUrl ( String newCertificateUrl )
    {
        String oldCertificateUrl = certificateUrl;
        certificateUrl = newCertificateUrl;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, SecurityPackage.CA__CERTIFICATE_URL, oldCertificateUrl, certificateUrl ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getCrlUrl ()
    {
        if ( crlUrl == null )
        {
            crlUrl = new EDataTypeUniqueEList<String> ( String.class, this, SecurityPackage.CA__CRL_URL );
        }
        return crlUrl;
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
            case SecurityPackage.CA__CERTIFICATE_URL:
                return getCertificateUrl ();
            case SecurityPackage.CA__CRL_URL:
                return getCrlUrl ();
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
            case SecurityPackage.CA__CERTIFICATE_URL:
                setCertificateUrl ( (String)newValue );
                return;
            case SecurityPackage.CA__CRL_URL:
                getCrlUrl ().clear ();
                getCrlUrl ().addAll ( (Collection<? extends String>)newValue );
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
            case SecurityPackage.CA__CERTIFICATE_URL:
                setCertificateUrl ( CERTIFICATE_URL_EDEFAULT );
                return;
            case SecurityPackage.CA__CRL_URL:
                getCrlUrl ().clear ();
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
            case SecurityPackage.CA__CERTIFICATE_URL:
                return CERTIFICATE_URL_EDEFAULT == null ? certificateUrl != null : !CERTIFICATE_URL_EDEFAULT.equals ( certificateUrl );
            case SecurityPackage.CA__CRL_URL:
                return crlUrl != null && !crlUrl.isEmpty ();
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
        result.append ( " (certificateUrl: " ); //$NON-NLS-1$
        result.append ( certificateUrl );
        result.append ( ", crlUrl: " ); //$NON-NLS-1$
        result.append ( crlUrl );
        result.append ( ')' );
        return result.toString ();
    }

} //CAImpl
