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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.scada.base.extractor.extract.Extractor;
import org.eclipse.scada.base.extractor.extract.PlainTextExtractor;
import org.eclipse.scada.da.server.component.parser.factory.CreationContext;
import org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage;
import org.eclipse.scada.da.server.component.parser.factory.configuration.PlainText;
import org.eclipse.scada.da.server.component.parser.factory.configuration.ValueConverterDefinition;
import org.eclipse.scada.da.server.component.parser.factory.internal.Descriptors;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Plain Text</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.PlainTextImpl#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.PlainTextImpl#isTrim <em>Trim</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.PlainTextImpl#getValueConverter <em>Value Converter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PlainTextImpl extends MinimalEObjectImpl.Container implements PlainText
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
     * The default value of the '{@link #isTrim() <em>Trim</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isTrim()
     * @generated
     * @ordered
     */
    protected static final boolean TRIM_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isTrim() <em>Trim</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isTrim()
     * @generated
     * @ordered
     */
    protected boolean trim = TRIM_EDEFAULT;

    /**
     * The cached value of the '{@link #getValueConverter() <em>Value Converter</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getValueConverter()
     * @generated
     * @ordered
     */
    protected ValueConverterDefinition valueConverter;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PlainTextImpl ()
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
        return ParserPackage.Literals.PLAIN_TEXT;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, ParserPackage.PLAIN_TEXT__PREFIX, oldPrefix, prefix ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isTrim ()
    {
        return trim;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setTrim ( boolean newTrim )
    {
        boolean oldTrim = trim;
        trim = newTrim;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ParserPackage.PLAIN_TEXT__TRIM, oldTrim, trim ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ValueConverterDefinition getValueConverter ()
    {
        if ( valueConverter != null && valueConverter.eIsProxy () )
        {
            InternalEObject oldValueConverter = (InternalEObject)valueConverter;
            valueConverter = (ValueConverterDefinition)eResolveProxy ( oldValueConverter );
            if ( valueConverter != oldValueConverter )
            {
                InternalEObject newValueConverter = (InternalEObject)valueConverter;
                NotificationChain msgs = oldValueConverter.eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ParserPackage.PLAIN_TEXT__VALUE_CONVERTER, null, null );
                if ( newValueConverter.eInternalContainer () == null )
                {
                    msgs = newValueConverter.eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ParserPackage.PLAIN_TEXT__VALUE_CONVERTER, null, msgs );
                }
                if ( msgs != null )
                    msgs.dispatch ();
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ParserPackage.PLAIN_TEXT__VALUE_CONVERTER, oldValueConverter, valueConverter ) );
            }
        }
        return valueConverter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ValueConverterDefinition basicGetValueConverter ()
    {
        return valueConverter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetValueConverter ( ValueConverterDefinition newValueConverter, NotificationChain msgs )
    {
        ValueConverterDefinition oldValueConverter = valueConverter;
        valueConverter = newValueConverter;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, ParserPackage.PLAIN_TEXT__VALUE_CONVERTER, oldValueConverter, newValueConverter );
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
    public void setValueConverter ( ValueConverterDefinition newValueConverter )
    {
        if ( newValueConverter != valueConverter )
        {
            NotificationChain msgs = null;
            if ( valueConverter != null )
                msgs = ( (InternalEObject)valueConverter ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - ParserPackage.PLAIN_TEXT__VALUE_CONVERTER, null, msgs );
            if ( newValueConverter != null )
                msgs = ( (InternalEObject)newValueConverter ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - ParserPackage.PLAIN_TEXT__VALUE_CONVERTER, null, msgs );
            msgs = basicSetValueConverter ( newValueConverter, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ParserPackage.PLAIN_TEXT__VALUE_CONVERTER, newValueConverter, newValueConverter ) );
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
        return new PlainTextExtractor ( isTrim (), Descriptors.createConverter ( this.valueConverter ) );
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
            case ParserPackage.PLAIN_TEXT__VALUE_CONVERTER:
                return basicSetValueConverter ( null, msgs );
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
            case ParserPackage.PLAIN_TEXT__PREFIX:
                return getPrefix ();
            case ParserPackage.PLAIN_TEXT__TRIM:
                return isTrim ();
            case ParserPackage.PLAIN_TEXT__VALUE_CONVERTER:
                if ( resolve )
                    return getValueConverter ();
                return basicGetValueConverter ();
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
            case ParserPackage.PLAIN_TEXT__PREFIX:
                setPrefix ( (String)newValue );
                return;
            case ParserPackage.PLAIN_TEXT__TRIM:
                setTrim ( (Boolean)newValue );
                return;
            case ParserPackage.PLAIN_TEXT__VALUE_CONVERTER:
                setValueConverter ( (ValueConverterDefinition)newValue );
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
            case ParserPackage.PLAIN_TEXT__PREFIX:
                setPrefix ( PREFIX_EDEFAULT );
                return;
            case ParserPackage.PLAIN_TEXT__TRIM:
                setTrim ( TRIM_EDEFAULT );
                return;
            case ParserPackage.PLAIN_TEXT__VALUE_CONVERTER:
                setValueConverter ( (ValueConverterDefinition)null );
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
            case ParserPackage.PLAIN_TEXT__PREFIX:
                return PREFIX_EDEFAULT == null ? prefix != null : !PREFIX_EDEFAULT.equals ( prefix );
            case ParserPackage.PLAIN_TEXT__TRIM:
                return trim != TRIM_EDEFAULT;
            case ParserPackage.PLAIN_TEXT__VALUE_CONVERTER:
                return valueConverter != null;
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
            case ParserPackage.PLAIN_TEXT___CREATE_EXTRACTOR__CREATIONCONTEXT:
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
        result.append ( ", trim: " ); //$NON-NLS-1$
        result.append ( trim );
        result.append ( ')' );
        return result.toString ();
    }

} //PlainTextImpl
