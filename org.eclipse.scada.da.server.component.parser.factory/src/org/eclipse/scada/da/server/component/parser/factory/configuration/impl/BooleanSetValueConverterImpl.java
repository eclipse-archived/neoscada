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
import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.scada.base.extractor.convert.ValueConverter;
import org.eclipse.scada.da.server.component.parser.factory.configuration.BooleanSetValueConverter;
import org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '
 * <em><b>Boolean Set Value Converter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.BooleanSetValueConverterImpl#getTrueValues <em>True Values</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.BooleanSetValueConverterImpl#getFalseValues <em>False Values</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.BooleanSetValueConverterImpl#getOtherwise <em>Otherwise</em>}</li>
 *   <li>{@link org.eclipse.scada.da.server.component.parser.factory.configuration.impl.BooleanSetValueConverterImpl#isIgnoreCase <em>Ignore Case</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BooleanSetValueConverterImpl extends MinimalEObjectImpl.Container implements BooleanSetValueConverter
{
    /**
     * The cached value of the '{@link #getTrueValues() <em>True Values</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTrueValues()
     * @generated
     * @ordered
     */
    protected EList<String> trueValues;

    /**
     * The cached value of the '{@link #getFalseValues() <em>False Values</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getFalseValues()
     * @generated
     * @ordered
     */
    protected EList<String> falseValues;

    /**
     * The default value of the '{@link #getOtherwise() <em>Otherwise</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOtherwise()
     * @generated
     * @ordered
     */
    protected static final Boolean OTHERWISE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOtherwise() <em>Otherwise</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOtherwise()
     * @generated
     * @ordered
     */
    protected Boolean otherwise = OTHERWISE_EDEFAULT;

    /**
     * The default value of the '{@link #isIgnoreCase() <em>Ignore Case</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIgnoreCase()
     * @generated
     * @ordered
     */
    protected static final boolean IGNORE_CASE_EDEFAULT = false;

    /**
     * The cached value of the '{@link #isIgnoreCase() <em>Ignore Case</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isIgnoreCase()
     * @generated
     * @ordered
     */
    protected boolean ignoreCase = IGNORE_CASE_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected BooleanSetValueConverterImpl ()
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
        return ParserPackage.Literals.BOOLEAN_SET_VALUE_CONVERTER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<String> getTrueValues ()
    {
        if ( trueValues == null )
        {
            trueValues = new EDataTypeUniqueEList<String> ( String.class, this, ParserPackage.BOOLEAN_SET_VALUE_CONVERTER__TRUE_VALUES );
        }
        return trueValues;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<String> getFalseValues ()
    {
        if ( falseValues == null )
        {
            falseValues = new EDataTypeUniqueEList<String> ( String.class, this, ParserPackage.BOOLEAN_SET_VALUE_CONVERTER__FALSE_VALUES );
        }
        return falseValues;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Boolean getOtherwise ()
    {
        return otherwise;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setOtherwise ( Boolean newOtherwise )
    {
        Boolean oldOtherwise = otherwise;
        otherwise = newOtherwise;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ParserPackage.BOOLEAN_SET_VALUE_CONVERTER__OTHERWISE, oldOtherwise, otherwise ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isIgnoreCase ()
    {
        return ignoreCase;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setIgnoreCase ( boolean newIgnoreCase )
    {
        boolean oldIgnoreCase = ignoreCase;
        ignoreCase = newIgnoreCase;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ParserPackage.BOOLEAN_SET_VALUE_CONVERTER__IGNORE_CASE, oldIgnoreCase, ignoreCase ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public ValueConverter createConverter ()
    {
        return new org.eclipse.scada.base.extractor.convert.BooleanSetValueConverter ( new HashSet<> ( this.trueValues ), new HashSet<> ( this.falseValues ), this.otherwise, this.ignoreCase );
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
            case ParserPackage.BOOLEAN_SET_VALUE_CONVERTER__TRUE_VALUES:
                return getTrueValues ();
            case ParserPackage.BOOLEAN_SET_VALUE_CONVERTER__FALSE_VALUES:
                return getFalseValues ();
            case ParserPackage.BOOLEAN_SET_VALUE_CONVERTER__OTHERWISE:
                return getOtherwise ();
            case ParserPackage.BOOLEAN_SET_VALUE_CONVERTER__IGNORE_CASE:
                return isIgnoreCase ();
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
            case ParserPackage.BOOLEAN_SET_VALUE_CONVERTER__TRUE_VALUES:
                getTrueValues ().clear ();
                getTrueValues ().addAll ( (Collection<? extends String>)newValue );
                return;
            case ParserPackage.BOOLEAN_SET_VALUE_CONVERTER__FALSE_VALUES:
                getFalseValues ().clear ();
                getFalseValues ().addAll ( (Collection<? extends String>)newValue );
                return;
            case ParserPackage.BOOLEAN_SET_VALUE_CONVERTER__OTHERWISE:
                setOtherwise ( (Boolean)newValue );
                return;
            case ParserPackage.BOOLEAN_SET_VALUE_CONVERTER__IGNORE_CASE:
                setIgnoreCase ( (Boolean)newValue );
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
            case ParserPackage.BOOLEAN_SET_VALUE_CONVERTER__TRUE_VALUES:
                getTrueValues ().clear ();
                return;
            case ParserPackage.BOOLEAN_SET_VALUE_CONVERTER__FALSE_VALUES:
                getFalseValues ().clear ();
                return;
            case ParserPackage.BOOLEAN_SET_VALUE_CONVERTER__OTHERWISE:
                setOtherwise ( OTHERWISE_EDEFAULT );
                return;
            case ParserPackage.BOOLEAN_SET_VALUE_CONVERTER__IGNORE_CASE:
                setIgnoreCase ( IGNORE_CASE_EDEFAULT );
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
            case ParserPackage.BOOLEAN_SET_VALUE_CONVERTER__TRUE_VALUES:
                return trueValues != null && !trueValues.isEmpty ();
            case ParserPackage.BOOLEAN_SET_VALUE_CONVERTER__FALSE_VALUES:
                return falseValues != null && !falseValues.isEmpty ();
            case ParserPackage.BOOLEAN_SET_VALUE_CONVERTER__OTHERWISE:
                return OTHERWISE_EDEFAULT == null ? otherwise != null : !OTHERWISE_EDEFAULT.equals ( otherwise );
            case ParserPackage.BOOLEAN_SET_VALUE_CONVERTER__IGNORE_CASE:
                return ignoreCase != IGNORE_CASE_EDEFAULT;
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
            case ParserPackage.BOOLEAN_SET_VALUE_CONVERTER___CREATE_CONVERTER:
                return createConverter ();
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
        result.append ( " (trueValues: " ); //$NON-NLS-1$
        result.append ( trueValues );
        result.append ( ", falseValues: " ); //$NON-NLS-1$
        result.append ( falseValues );
        result.append ( ", otherwise: " ); //$NON-NLS-1$
        result.append ( otherwise );
        result.append ( ", ignoreCase: " ); //$NON-NLS-1$
        result.append ( ignoreCase );
        result.append ( ')' );
        return result.toString ();
    }

} //BooleanSetValueConverterImpl
