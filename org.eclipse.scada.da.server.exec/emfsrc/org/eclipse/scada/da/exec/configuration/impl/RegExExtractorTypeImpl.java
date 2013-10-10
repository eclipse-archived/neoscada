/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.exec.configuration.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.da.exec.configuration.ConfigurationPackage;
import org.eclipse.scada.da.exec.configuration.RegExExtractorType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reg Ex Extractor Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.impl.RegExExtractorTypeImpl#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipse.scada.da.exec.configuration.impl.RegExExtractorTypeImpl#isRequireFullMatch <em>Require Full Match</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RegExExtractorTypeImpl extends FieldExtractorTypeImpl implements RegExExtractorType
{
    //$NON-NLS-1$

    /**
     * The default value of the '{@link #getExpression() <em>Expression</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExpression()
     * @generated
     * @ordered
     */
    protected static final String EXPRESSION_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getExpression() <em>Expression</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExpression()
     * @generated
     * @ordered
     */
    protected String expression = EXPRESSION_EDEFAULT;

    /**
     * The default value of the '{@link #isRequireFullMatch() <em>Require Full Match</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isRequireFullMatch()
     * @generated
     * @ordered
     */
    protected static final boolean REQUIRE_FULL_MATCH_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isRequireFullMatch() <em>Require Full Match</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isRequireFullMatch()
     * @generated
     * @ordered
     */
    protected boolean requireFullMatch = REQUIRE_FULL_MATCH_EDEFAULT;

    /**
     * This is true if the Require Full Match attribute has been set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    protected boolean requireFullMatchESet;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RegExExtractorTypeImpl ()
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
        return ConfigurationPackage.Literals.REG_EX_EXTRACTOR_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getExpression ()
    {
        return expression;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setExpression ( String newExpression )
    {
        String oldExpression = expression;
        expression = newExpression;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.REG_EX_EXTRACTOR_TYPE__EXPRESSION, oldExpression, expression ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isRequireFullMatch ()
    {
        return requireFullMatch;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRequireFullMatch ( boolean newRequireFullMatch )
    {
        boolean oldRequireFullMatch = requireFullMatch;
        requireFullMatch = newRequireFullMatch;
        boolean oldRequireFullMatchESet = requireFullMatchESet;
        requireFullMatchESet = true;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ConfigurationPackage.REG_EX_EXTRACTOR_TYPE__REQUIRE_FULL_MATCH, oldRequireFullMatch, requireFullMatch, !oldRequireFullMatchESet ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void unsetRequireFullMatch ()
    {
        boolean oldRequireFullMatch = requireFullMatch;
        boolean oldRequireFullMatchESet = requireFullMatchESet;
        requireFullMatch = REQUIRE_FULL_MATCH_EDEFAULT;
        requireFullMatchESet = false;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.UNSET, ConfigurationPackage.REG_EX_EXTRACTOR_TYPE__REQUIRE_FULL_MATCH, oldRequireFullMatch, REQUIRE_FULL_MATCH_EDEFAULT, oldRequireFullMatchESet ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isSetRequireFullMatch ()
    {
        return requireFullMatchESet;
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
            case ConfigurationPackage.REG_EX_EXTRACTOR_TYPE__EXPRESSION:
                return getExpression ();
            case ConfigurationPackage.REG_EX_EXTRACTOR_TYPE__REQUIRE_FULL_MATCH:
                return isRequireFullMatch ();
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
            case ConfigurationPackage.REG_EX_EXTRACTOR_TYPE__EXPRESSION:
                setExpression ( (String)newValue );
                return;
            case ConfigurationPackage.REG_EX_EXTRACTOR_TYPE__REQUIRE_FULL_MATCH:
                setRequireFullMatch ( (Boolean)newValue );
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
            case ConfigurationPackage.REG_EX_EXTRACTOR_TYPE__EXPRESSION:
                setExpression ( EXPRESSION_EDEFAULT );
                return;
            case ConfigurationPackage.REG_EX_EXTRACTOR_TYPE__REQUIRE_FULL_MATCH:
                unsetRequireFullMatch ();
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
            case ConfigurationPackage.REG_EX_EXTRACTOR_TYPE__EXPRESSION:
                return EXPRESSION_EDEFAULT == null ? expression != null : !EXPRESSION_EDEFAULT.equals ( expression );
            case ConfigurationPackage.REG_EX_EXTRACTOR_TYPE__REQUIRE_FULL_MATCH:
                return isSetRequireFullMatch ();
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
        result.append ( " (expression: " ); //$NON-NLS-1$
        result.append ( expression );
        result.append ( ", requireFullMatch: " ); //$NON-NLS-1$
        if ( requireFullMatchESet )
            result.append ( requireFullMatch );
        else
            result.append ( "<unset>" ); //$NON-NLS-1$
        result.append ( ')' );
        return result.toString ();
    }

} //RegExExtractorTypeImpl
