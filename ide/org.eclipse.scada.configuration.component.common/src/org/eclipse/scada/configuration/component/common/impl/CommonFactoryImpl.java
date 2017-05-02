/**
 * Copyright (c) 2013 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 *
 */
package org.eclipse.scada.configuration.component.common.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.scada.configuration.component.common.ChangeHeartbeatDetector;
import org.eclipse.scada.configuration.component.common.CommonFactory;
import org.eclipse.scada.configuration.component.common.CommonPackage;
import org.eclipse.scada.configuration.component.common.CurrentTimeComponent;
import org.eclipse.scada.configuration.component.common.DateFormat;
import org.eclipse.scada.configuration.component.common.ScaledValue;
import org.eclipse.scada.configuration.component.common.TimerAction;
import org.eclipse.scada.configuration.component.common.ToggleHeartbeatGenerator;
import org.eclipse.scada.configuration.world.osgi.DataType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CommonFactoryImpl extends EFactoryImpl implements CommonFactory
{
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static CommonFactory init ()
    {
        try
        {
            CommonFactory theCommonFactory = (CommonFactory)EPackage.Registry.INSTANCE.getEFactory ( CommonPackage.eNS_URI );
            if ( theCommonFactory != null )
            {
                return theCommonFactory;
            }
        }
        catch ( Exception exception )
        {
            EcorePlugin.INSTANCE.log ( exception );
        }
        return new CommonFactoryImpl ();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CommonFactoryImpl ()
    {
        super ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create ( EClass eClass )
    {
        switch ( eClass.getClassifierID () )
        {
            case CommonPackage.TOGGLE_HEARTBEAT_GENERATOR:
                return createToggleHeartbeatGenerator ();
            case CommonPackage.CHANGE_HEARTBEAT_DETECTOR:
                return createChangeHeartbeatDetector ();
            case CommonPackage.TIMER_ACTION:
                return createTimerAction ();
            case CommonPackage.CURRENT_TIME_COMPONENT:
                return createCurrentTimeComponent ();
            case CommonPackage.SCALED_VALUE:
                return createScaledValue ();
            default:
                throw new IllegalArgumentException ( "The class '" + eClass.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object createFromString ( EDataType eDataType, String initialValue )
    {
        switch ( eDataType.getClassifierID () )
        {
            case CommonPackage.DATE_FORMAT:
                return createDateFormatFromString ( eDataType, initialValue );
            default:
                throw new IllegalArgumentException ( "The datatype '" + eDataType.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String convertToString ( EDataType eDataType, Object instanceValue )
    {
        switch ( eDataType.getClassifierID () )
        {
            case CommonPackage.DATE_FORMAT:
                return convertDateFormatToString ( eDataType, instanceValue );
            default:
                throw new IllegalArgumentException ( "The datatype '" + eDataType.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ToggleHeartbeatGenerator createToggleHeartbeatGenerator ()
    {
        ToggleHeartbeatGeneratorImpl toggleHeartbeatGenerator = new ToggleHeartbeatGeneratorImpl ();
        return toggleHeartbeatGenerator;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ChangeHeartbeatDetector createChangeHeartbeatDetector ()
    {
        ChangeHeartbeatDetectorImpl changeHeartbeatDetector = new ChangeHeartbeatDetectorImpl ();
        return changeHeartbeatDetector;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public TimerAction createTimerAction ()
    {
        TimerActionImpl timerAction = new TimerActionImpl ();
        return timerAction;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public CurrentTimeComponent createCurrentTimeComponent ()
    {
        CurrentTimeComponentImpl currentTimeComponent = new CurrentTimeComponentImpl ();
        return currentTimeComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public ScaledValue createScaledValue ()
    {
        final ScaledValueImpl scaledValue = new ScaledValueImpl ();
        scaledValue.setDataType ( DataType.FLOAT );
        return scaledValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DateFormat createDateFormatFromString ( EDataType eDataType, String initialValue )
    {
        return (DateFormat)super.createFromString ( eDataType, initialValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String convertDateFormatToString ( EDataType eDataType, Object instanceValue )
    {
        return super.convertToString ( eDataType, instanceValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public CommonPackage getCommonPackage ()
    {
        return (CommonPackage)getEPackage ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static CommonPackage getPackage ()
    {
        return CommonPackage.eINSTANCE;
    }

} //CommonFactoryImpl
