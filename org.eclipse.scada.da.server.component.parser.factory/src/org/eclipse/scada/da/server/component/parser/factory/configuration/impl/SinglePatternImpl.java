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

import java.lang.reflect.InvocationTargetException;
import java.util.regex.Pattern;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.scada.base.extractor.extract.Extractor;
import org.eclipse.scada.base.extractor.extract.pattern.SinglePatternExtractor;
import org.eclipse.scada.da.server.component.parser.factory.CreationContext;
import org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage;
import org.eclipse.scada.da.server.component.parser.factory.configuration.SinglePattern;
import org.eclipse.scada.da.server.component.parser.factory.internal.Descriptors;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Single Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.SinglePatternImpl#getPrefix
 * <em>Prefix</em>}</li>
 * <li>
 * {@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.SinglePatternImpl#getPattern
 * <em>Pattern</em>}</li>
 * <li>
 * {@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.SinglePatternImpl#isFullMatch
 * <em>Full Match</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class SinglePatternImpl extends MinimalEObjectImpl.Container implements SinglePattern
{
    /**
     * The default value of the '{@link #getPrefix() <em>Prefix</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getPrefix()
     * @generated
     * @ordered
     */
    protected static final String PREFIX_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getPrefix()
     * @generated
     * @ordered
     */
    protected String prefix = PREFIX_EDEFAULT;

    /**
     * The default value of the '{@link #getPattern() <em>Pattern</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getPattern()
     * @generated
     * @ordered
     */
    protected static final Pattern PATTERN_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPattern() <em>Pattern</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getPattern()
     * @generated
     * @ordered
     */
    protected Pattern pattern = PATTERN_EDEFAULT;

    /**
     * The default value of the '{@link #isFullMatch() <em>Full Match</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #isFullMatch()
     * @generated
     * @ordered
     */
    protected static final boolean FULL_MATCH_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isFullMatch() <em>Full Match</em>}'
     * attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #isFullMatch()
     * @generated
     * @ordered
     */
    protected boolean fullMatch = FULL_MATCH_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    protected SinglePatternImpl ()
    {
        super ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass ()
    {
        return ParserPackage.Literals.SINGLE_PATTERN;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String getPrefix ()
    {
        return this.prefix;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setPrefix ( final String newPrefix )
    {
        final String oldPrefix = this.prefix;
        this.prefix = newPrefix;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, ParserPackage.SINGLE_PATTERN__PREFIX, oldPrefix, this.prefix ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Pattern getPattern ()
    {
        return this.pattern;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setPattern ( final Pattern newPattern )
    {
        final Pattern oldPattern = this.pattern;
        this.pattern = newPattern;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, ParserPackage.SINGLE_PATTERN__PATTERN, oldPattern, this.pattern ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean isFullMatch ()
    {
        return this.fullMatch;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setFullMatch ( final boolean newFullMatch )
    {
        final boolean oldFullMatch = this.fullMatch;
        this.fullMatch = newFullMatch;
        if ( eNotificationRequired () )
        {
            eNotify ( new ENotificationImpl ( this, Notification.SET, ParserPackage.SINGLE_PATTERN__FULL_MATCH, oldFullMatch, this.fullMatch ) );
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public Extractor createExtractor ( final CreationContext creationContext )
    {
        return new SinglePatternExtractor ( getPattern (), isFullMatch (), Descriptors.convert ( null ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet ( final int featureID, final boolean resolve, final boolean coreType )
    {
        switch ( featureID )
        {
            case ParserPackage.SINGLE_PATTERN__PREFIX:
                return getPrefix ();
            case ParserPackage.SINGLE_PATTERN__PATTERN:
                return getPattern ();
            case ParserPackage.SINGLE_PATTERN__FULL_MATCH:
                return isFullMatch ();
        }
        return super.eGet ( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet ( final int featureID, final Object newValue )
    {
        switch ( featureID )
        {
            case ParserPackage.SINGLE_PATTERN__PREFIX:
                setPrefix ( (String)newValue );
                return;
            case ParserPackage.SINGLE_PATTERN__PATTERN:
                setPattern ( (Pattern)newValue );
                return;
            case ParserPackage.SINGLE_PATTERN__FULL_MATCH:
                setFullMatch ( (Boolean)newValue );
                return;
        }
        super.eSet ( featureID, newValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eUnset ( final int featureID )
    {
        switch ( featureID )
        {
            case ParserPackage.SINGLE_PATTERN__PREFIX:
                setPrefix ( PREFIX_EDEFAULT );
                return;
            case ParserPackage.SINGLE_PATTERN__PATTERN:
                setPattern ( PATTERN_EDEFAULT );
                return;
            case ParserPackage.SINGLE_PATTERN__FULL_MATCH:
                setFullMatch ( FULL_MATCH_EDEFAULT );
                return;
        }
        super.eUnset ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean eIsSet ( final int featureID )
    {
        switch ( featureID )
        {
            case ParserPackage.SINGLE_PATTERN__PREFIX:
                return PREFIX_EDEFAULT == null ? this.prefix != null : !PREFIX_EDEFAULT.equals ( this.prefix );
            case ParserPackage.SINGLE_PATTERN__PATTERN:
                return PATTERN_EDEFAULT == null ? this.pattern != null : !PATTERN_EDEFAULT.equals ( this.pattern );
            case ParserPackage.SINGLE_PATTERN__FULL_MATCH:
                return this.fullMatch != FULL_MATCH_EDEFAULT;
        }
        return super.eIsSet ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eInvoke ( final int operationID, final EList<?> arguments ) throws InvocationTargetException
    {
        switch ( operationID )
        {
            case ParserPackage.SINGLE_PATTERN___CREATE_EXTRACTOR__CREATIONCONTEXT:
                return createExtractor ( (CreationContext)arguments.get ( 0 ) );
        }
        return super.eInvoke ( operationID, arguments );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString ()
    {
        if ( eIsProxy () )
        {
            return super.toString ();
        }

        final StringBuffer result = new StringBuffer ( super.toString () );
        result.append ( " (prefix: " ); //$NON-NLS-1$
        result.append ( this.prefix );
        result.append ( ", pattern: " ); //$NON-NLS-1$
        result.append ( this.pattern );
        result.append ( ", fullMatch: " ); //$NON-NLS-1$
        result.append ( this.fullMatch );
        result.append ( ')' );
        return result.toString ();
    }

} //SinglePatternImpl
