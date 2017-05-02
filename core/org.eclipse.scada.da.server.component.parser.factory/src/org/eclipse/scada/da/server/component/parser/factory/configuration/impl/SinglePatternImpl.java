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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.scada.base.extractor.extract.Extractor;
import org.eclipse.scada.base.extractor.extract.pattern.SinglePatternExtractor;
import org.eclipse.scada.da.server.component.parser.factory.CreationContext;
import org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage;
import org.eclipse.scada.da.server.component.parser.factory.configuration.SinglePattern;
import org.eclipse.scada.da.server.component.parser.factory.configuration.ValueDescriptor;
import org.eclipse.scada.da.server.component.parser.factory.internal.Descriptors;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Single Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.SinglePatternImpl#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.SinglePatternImpl#getPattern <em>Pattern</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.SinglePatternImpl#isFullMatch <em>Full Match</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.SinglePatternImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SinglePatternImpl extends MinimalEObjectImpl.Container implements SinglePattern
{
    /**
     * The default value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPrefix()
     * @generated
     * @ordered
     */
    protected static final String PREFIX_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPrefix() <em>Prefix</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPrefix()
     * @generated
     * @ordered
     */
    protected String prefix = PREFIX_EDEFAULT;

    /**
     * The default value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPattern()
     * @generated
     * @ordered
     */
    protected static final Pattern PATTERN_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPattern()
     * @generated
     * @ordered
     */
    protected Pattern pattern = PATTERN_EDEFAULT;

    /**
     * The default value of the '{@link #isFullMatch() <em>Full Match</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isFullMatch()
     * @generated
     * @ordered
     */
    protected static final boolean FULL_MATCH_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isFullMatch() <em>Full Match</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isFullMatch()
     * @generated
     * @ordered
     */
    protected boolean fullMatch = FULL_MATCH_EDEFAULT;

    /**
     * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValue()
     * @generated
     * @ordered
     */
    protected ValueDescriptor value;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SinglePatternImpl ()
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
        return ParserPackage.Literals.SINGLE_PATTERN;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getPrefix ()
    {
        return prefix;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setPrefix ( String newPrefix )
    {
        String oldPrefix = prefix;
        prefix = newPrefix;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ParserPackage.SINGLE_PATTERN__PREFIX, oldPrefix, prefix ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Pattern getPattern ()
    {
        return pattern;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setPattern ( Pattern newPattern )
    {
        Pattern oldPattern = pattern;
        pattern = newPattern;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ParserPackage.SINGLE_PATTERN__PATTERN, oldPattern, pattern ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isFullMatch ()
    {
        return fullMatch;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setFullMatch ( boolean newFullMatch )
    {
        boolean oldFullMatch = fullMatch;
        fullMatch = newFullMatch;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ParserPackage.SINGLE_PATTERN__FULL_MATCH, oldFullMatch, fullMatch ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ValueDescriptor getValue ()
    {
        if ( value != null && value.eIsProxy () )
        {
            InternalEObject oldValue = (InternalEObject)value;
            value = (ValueDescriptor)eResolveProxy ( oldValue );
            if ( value != oldValue )
            {
                InternalEObject newValue = (InternalEObject)value;
                NotificationChain msgs = oldValue.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ParserPackage.SINGLE_PATTERN__VALUE, null, null );
                if ( newValue.eInternalContainer () == null )
                {
                    msgs = newValue.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ParserPackage.SINGLE_PATTERN__VALUE, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ParserPackage.SINGLE_PATTERN__VALUE, oldValue, value ) );
            }
        }
        return value;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ValueDescriptor basicGetValue ()
    {
        return value;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetValue ( ValueDescriptor newValue, NotificationChain msgs )
    {
        ValueDescriptor oldValue = value;
        value = newValue;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, ParserPackage.SINGLE_PATTERN__VALUE, oldValue, newValue );
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
    @Override
    public void setValue ( ValueDescriptor newValue )
    {
        if ( newValue != value )
        {
            NotificationChain msgs = null;
            if ( value != null )
                msgs = ( (InternalEObject)value ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ParserPackage.SINGLE_PATTERN__VALUE, null, msgs );
            if ( newValue != null )
                msgs = ( (InternalEObject)newValue ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ParserPackage.SINGLE_PATTERN__VALUE, null, msgs );
            msgs = basicSetValue ( newValue, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ParserPackage.SINGLE_PATTERN__VALUE, newValue, newValue ) );
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
        return new SinglePatternExtractor ( getPattern (), isFullMatch (), Descriptors.convert ( getValue () ) );
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
            case ParserPackage.SINGLE_PATTERN__VALUE:
                return basicSetValue ( null, msgs );
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
            case ParserPackage.SINGLE_PATTERN__PREFIX:
                return getPrefix ();
            case ParserPackage.SINGLE_PATTERN__PATTERN:
                return getPattern ();
            case ParserPackage.SINGLE_PATTERN__FULL_MATCH:
                return isFullMatch ();
            case ParserPackage.SINGLE_PATTERN__VALUE:
                if ( resolve )
                    return getValue ();
                return basicGetValue ();
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
            case ParserPackage.SINGLE_PATTERN__PREFIX:
                setPrefix ( (String)newValue );
                return;
            case ParserPackage.SINGLE_PATTERN__PATTERN:
                setPattern ( (Pattern)newValue );
                return;
            case ParserPackage.SINGLE_PATTERN__FULL_MATCH:
                setFullMatch ( (Boolean)newValue );
                return;
            case ParserPackage.SINGLE_PATTERN__VALUE:
                setValue ( (ValueDescriptor)newValue );
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
            case ParserPackage.SINGLE_PATTERN__PREFIX:
                setPrefix ( PREFIX_EDEFAULT );
                return;
            case ParserPackage.SINGLE_PATTERN__PATTERN:
                setPattern ( PATTERN_EDEFAULT );
                return;
            case ParserPackage.SINGLE_PATTERN__FULL_MATCH:
                setFullMatch ( FULL_MATCH_EDEFAULT );
                return;
            case ParserPackage.SINGLE_PATTERN__VALUE:
                setValue ( (ValueDescriptor)null );
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
            case ParserPackage.SINGLE_PATTERN__PREFIX:
                return PREFIX_EDEFAULT == null ? prefix != null : !PREFIX_EDEFAULT.equals ( prefix );
            case ParserPackage.SINGLE_PATTERN__PATTERN:
                return PATTERN_EDEFAULT == null ? pattern != null : !PATTERN_EDEFAULT.equals ( pattern );
            case ParserPackage.SINGLE_PATTERN__FULL_MATCH:
                return fullMatch != FULL_MATCH_EDEFAULT;
            case ParserPackage.SINGLE_PATTERN__VALUE:
                return value != null;
        }
        return super.eIsSet ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eInvoke ( int operationID, EList<?> arguments ) throws InvocationTargetException
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
     * @generated
     */
    @Override
    public String toString ()
    {
        if ( eIsProxy () )
            return super.toString ();

        StringBuffer result = new StringBuffer ( super.toString () );
        result.append ( " (prefix: " ); //$NON-NLS-1$
        result.append ( prefix );
        result.append ( ", pattern: " ); //$NON-NLS-1$
        result.append ( pattern );
        result.append ( ", fullMatch: " ); //$NON-NLS-1$
        result.append ( fullMatch );
        result.append ( ')' );
        return result.toString ();
    }

} //SinglePatternImpl
