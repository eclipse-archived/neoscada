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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.scada.configuration.component.exec.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExecComponentsFactoryImpl extends EFactoryImpl implements ExecComponentsFactory
{
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static ExecComponentsFactory init ()
    {
        try
        {
            ExecComponentsFactory theExecComponentsFactory = (ExecComponentsFactory)EPackage.Registry.INSTANCE.getEFactory ( ExecComponentsPackage.eNS_URI );
            if ( theExecComponentsFactory != null )
            {
                return theExecComponentsFactory;
            }
        }
        catch ( Exception exception )
        {
            EcorePlugin.INSTANCE.log ( exception );
        }
        return new ExecComponentsFactoryImpl ();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExecComponentsFactoryImpl ()
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
            case ExecComponentsPackage.EXEC_JOB:
                return createExecJob ();
            case ExecComponentsPackage.LOAD_AVERAGE:
                return createLoadAverage ();
            case ExecComponentsPackage.LOAD_AVERAGE_CONFIGURATION:
                return createLoadAverageConfiguration ();
            case ExecComponentsPackage.PING_CHECK:
                return createPingCheck ();
            case ExecComponentsPackage.PING_CHECK_CONFIGURATION:
                return createPingCheckConfiguration ();
            case ExecComponentsPackage.SYSTEM_INFORMATION_VM_STAT:
                return createSystemInformationVMStat ();
            default:
                throw new IllegalArgumentException ( "The class '" + eClass.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExecJob createExecJob ()
    {
        ExecJobImpl execJob = new ExecJobImpl ();
        return execJob;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LoadAverage createLoadAverage ()
    {
        LoadAverageImpl loadAverage = new LoadAverageImpl ();
        return loadAverage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public LoadAverageConfiguration createLoadAverageConfiguration ()
    {
        LoadAverageConfigurationImpl loadAverageConfiguration = new LoadAverageConfigurationImpl ();
        return loadAverageConfiguration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PingCheck createPingCheck ()
    {
        PingCheckImpl pingCheck = new PingCheckImpl ();
        return pingCheck;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PingCheckConfiguration createPingCheckConfiguration ()
    {
        PingCheckConfigurationImpl pingCheckConfiguration = new PingCheckConfigurationImpl ();
        return pingCheckConfiguration;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SystemInformationVMStat createSystemInformationVMStat ()
    {
        SystemInformationVMStatImpl systemInformationVMStat = new SystemInformationVMStatImpl ();
        return systemInformationVMStat;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExecComponentsPackage getExecComponentsPackage ()
    {
        return (ExecComponentsPackage)getEPackage ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static ExecComponentsPackage getPackage ()
    {
        return ExecComponentsPackage.eINSTANCE;
    }

} //ExecComponentsFactoryImpl
