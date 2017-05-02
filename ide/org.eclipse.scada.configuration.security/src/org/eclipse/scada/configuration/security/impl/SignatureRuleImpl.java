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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.security.CA;
import org.eclipse.scada.configuration.security.Script;
import org.eclipse.scada.configuration.security.SecurityPackage;
import org.eclipse.scada.configuration.security.SignatureRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Signature Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.security.impl.SignatureRuleImpl#getTrustedCertificationAuthority <em>Trusted Certification Authority</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.security.impl.SignatureRuleImpl#isIndentXml <em>Indent Xml</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.security.impl.SignatureRuleImpl#getPostProcessor <em>Post Processor</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.security.impl.SignatureRuleImpl#getReloadPeriod <em>Reload Period</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SignatureRuleImpl extends RuleImpl implements SignatureRule
{
    /**
     * The cached value of the '{@link #getTrustedCertificationAuthority() <em>Trusted Certification Authority</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTrustedCertificationAuthority()
     * @generated
     * @ordered
     */
    protected EList<CA> trustedCertificationAuthority;

    /**
     * The default value of the '{@link #isIndentXml() <em>Indent Xml</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIndentXml()
     * @generated
     * @ordered
     */
    protected static final boolean INDENT_XML_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isIndentXml() <em>Indent Xml</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIndentXml()
     * @generated
     * @ordered
     */
    protected boolean indentXml = INDENT_XML_EDEFAULT;

    /**
     * The cached value of the '{@link #getPostProcessor() <em>Post Processor</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPostProcessor()
     * @generated
     * @ordered
     */
    protected Script postProcessor;

    /**
     * The default value of the '{@link #getReloadPeriod() <em>Reload Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReloadPeriod()
     * @generated
     * @ordered
     */
    protected static final int RELOAD_PERIOD_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getReloadPeriod() <em>Reload Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getReloadPeriod()
     * @generated
     * @ordered
     */
    protected int reloadPeriod = RELOAD_PERIOD_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SignatureRuleImpl ()
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
        return SecurityPackage.Literals.SIGNATURE_RULE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<CA> getTrustedCertificationAuthority ()
    {
        if ( trustedCertificationAuthority == null )
        {
            trustedCertificationAuthority = new EObjectContainmentEList.Resolving<CA> ( CA.class, this, SecurityPackage.SIGNATURE_RULE__TRUSTED_CERTIFICATION_AUTHORITY );
        }
        return trustedCertificationAuthority;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isIndentXml ()
    {
        return indentXml;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setIndentXml ( boolean newIndentXml )
    {
        boolean oldIndentXml = indentXml;
        indentXml = newIndentXml;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, SecurityPackage.SIGNATURE_RULE__INDENT_XML, oldIndentXml, indentXml ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Script getPostProcessor ()
    {
        if ( postProcessor != null && postProcessor.eIsProxy () )
        {
            InternalEObject oldPostProcessor = (InternalEObject)postProcessor;
            postProcessor = (Script)eResolveProxy ( oldPostProcessor );
            if ( postProcessor != oldPostProcessor )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, SecurityPackage.SIGNATURE_RULE__POST_PROCESSOR, oldPostProcessor, postProcessor ) );
            }
        }
        return postProcessor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Script basicGetPostProcessor ()
    {
        return postProcessor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPostProcessor ( Script newPostProcessor )
    {
        Script oldPostProcessor = postProcessor;
        postProcessor = newPostProcessor;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, SecurityPackage.SIGNATURE_RULE__POST_PROCESSOR, oldPostProcessor, postProcessor ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getReloadPeriod ()
    {
        return reloadPeriod;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setReloadPeriod ( int newReloadPeriod )
    {
        int oldReloadPeriod = reloadPeriod;
        reloadPeriod = newReloadPeriod;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, SecurityPackage.SIGNATURE_RULE__RELOAD_PERIOD, oldReloadPeriod, reloadPeriod ) );
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
            case SecurityPackage.SIGNATURE_RULE__TRUSTED_CERTIFICATION_AUTHORITY:
                return ( (InternalEList<?>)getTrustedCertificationAuthority () ).basicRemove ( otherEnd, msgs );
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
            case SecurityPackage.SIGNATURE_RULE__TRUSTED_CERTIFICATION_AUTHORITY:
                return getTrustedCertificationAuthority ();
            case SecurityPackage.SIGNATURE_RULE__INDENT_XML:
                return isIndentXml ();
            case SecurityPackage.SIGNATURE_RULE__POST_PROCESSOR:
                if ( resolve )
                    return getPostProcessor ();
                return basicGetPostProcessor ();
            case SecurityPackage.SIGNATURE_RULE__RELOAD_PERIOD:
                return getReloadPeriod ();
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
            case SecurityPackage.SIGNATURE_RULE__TRUSTED_CERTIFICATION_AUTHORITY:
                getTrustedCertificationAuthority ().clear ();
                getTrustedCertificationAuthority ().addAll ( (Collection<? extends CA>)newValue );
                return;
            case SecurityPackage.SIGNATURE_RULE__INDENT_XML:
                setIndentXml ( (Boolean)newValue );
                return;
            case SecurityPackage.SIGNATURE_RULE__POST_PROCESSOR:
                setPostProcessor ( (Script)newValue );
                return;
            case SecurityPackage.SIGNATURE_RULE__RELOAD_PERIOD:
                setReloadPeriod ( (Integer)newValue );
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
            case SecurityPackage.SIGNATURE_RULE__TRUSTED_CERTIFICATION_AUTHORITY:
                getTrustedCertificationAuthority ().clear ();
                return;
            case SecurityPackage.SIGNATURE_RULE__INDENT_XML:
                setIndentXml ( INDENT_XML_EDEFAULT );
                return;
            case SecurityPackage.SIGNATURE_RULE__POST_PROCESSOR:
                setPostProcessor ( (Script)null );
                return;
            case SecurityPackage.SIGNATURE_RULE__RELOAD_PERIOD:
                setReloadPeriod ( RELOAD_PERIOD_EDEFAULT );
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
            case SecurityPackage.SIGNATURE_RULE__TRUSTED_CERTIFICATION_AUTHORITY:
                return trustedCertificationAuthority != null && !trustedCertificationAuthority.isEmpty ();
            case SecurityPackage.SIGNATURE_RULE__INDENT_XML:
                return indentXml != INDENT_XML_EDEFAULT;
            case SecurityPackage.SIGNATURE_RULE__POST_PROCESSOR:
                return postProcessor != null;
            case SecurityPackage.SIGNATURE_RULE__RELOAD_PERIOD:
                return reloadPeriod != RELOAD_PERIOD_EDEFAULT;
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
        result.append ( " (indentXml: " ); //$NON-NLS-1$
        result.append ( indentXml );
        result.append ( ", reloadPeriod: " ); //$NON-NLS-1$
        result.append ( reloadPeriod );
        result.append ( ')' );
        return result.toString ();
    }

    @Override
    public String getRuleType ()
    {
        return "signature";
    }

} //SignatureRuleImpl
