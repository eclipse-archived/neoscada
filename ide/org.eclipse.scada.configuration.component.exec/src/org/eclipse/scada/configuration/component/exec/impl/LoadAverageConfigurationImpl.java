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
package org.eclipse.scada.configuration.component.exec.impl;

import java.util.regex.Pattern;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.scada.configuration.component.exec.ExecComponentsPackage;
import org.eclipse.scada.configuration.component.exec.LoadAverageConfiguration;
import org.eclipse.scada.configuration.component.impl.ConfigurationImpl;
import org.eclipse.scada.configuration.security.SecurityFactory;
import org.eclipse.scada.configuration.security.SecurityPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Load Average Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.exec.impl.LoadAverageConfigurationImpl#getPeriod <em>Period</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.exec.impl.LoadAverageConfigurationImpl#getPattern <em>Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LoadAverageConfigurationImpl extends ConfigurationImpl implements LoadAverageConfiguration
{
    /**
     * The default value of the '{@link #getPeriod() <em>Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPeriod()
     * @generated
     * @ordered
     */
    protected static final int PERIOD_EDEFAULT = 1000;

    /**
     * The cached value of the '{@link #getPeriod() <em>Period</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPeriod()
     * @generated
     * @ordered
     */
    protected int period = PERIOD_EDEFAULT;

    /**
     * The default value of the '{@link #getPattern() <em>Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getPattern()
     * @generated
     * @ordered
     */
    protected static final Pattern PATTERN_EDEFAULT = (Pattern)SecurityFactory.eINSTANCE.createFromString ( SecurityPackage.eINSTANCE.getPattern (), "([0-9]+) users?.*averages?: +([0-9]+[,\\\\.][0-9]*),? +([0-9]+[,\\\\.][0-9]*),? +([0-9]+[,\\\\.][0-9]*)" ); //$NON-NLS-1$

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
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected LoadAverageConfigurationImpl ()
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
        return ExecComponentsPackage.Literals.LOAD_AVERAGE_CONFIGURATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getPeriod ()
    {
        return period;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPeriod ( int newPeriod )
    {
        int oldPeriod = period;
        period = newPeriod;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ExecComponentsPackage.LOAD_AVERAGE_CONFIGURATION__PERIOD, oldPeriod, period ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Pattern getPattern ()
    {
        return pattern;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setPattern ( Pattern newPattern )
    {
        Pattern oldPattern = pattern;
        pattern = newPattern;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ExecComponentsPackage.LOAD_AVERAGE_CONFIGURATION__PATTERN, oldPattern, pattern ) );
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
            case ExecComponentsPackage.LOAD_AVERAGE_CONFIGURATION__PERIOD:
                return getPeriod ();
            case ExecComponentsPackage.LOAD_AVERAGE_CONFIGURATION__PATTERN:
                return getPattern ();
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
            case ExecComponentsPackage.LOAD_AVERAGE_CONFIGURATION__PERIOD:
                setPeriod ( (Integer)newValue );
                return;
            case ExecComponentsPackage.LOAD_AVERAGE_CONFIGURATION__PATTERN:
                setPattern ( (Pattern)newValue );
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
            case ExecComponentsPackage.LOAD_AVERAGE_CONFIGURATION__PERIOD:
                setPeriod ( PERIOD_EDEFAULT );
                return;
            case ExecComponentsPackage.LOAD_AVERAGE_CONFIGURATION__PATTERN:
                setPattern ( PATTERN_EDEFAULT );
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
            case ExecComponentsPackage.LOAD_AVERAGE_CONFIGURATION__PERIOD:
                return period != PERIOD_EDEFAULT;
            case ExecComponentsPackage.LOAD_AVERAGE_CONFIGURATION__PATTERN:
                return PATTERN_EDEFAULT == null ? pattern != null : !PATTERN_EDEFAULT.equals ( pattern );
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
        result.append ( " (period: " ); //$NON-NLS-1$
        result.append ( period );
        result.append ( ", pattern: " ); //$NON-NLS-1$
        result.append ( pattern );
        result.append ( ')' );
        return result.toString ();
    }

} //LoadAverageConfigurationImpl
