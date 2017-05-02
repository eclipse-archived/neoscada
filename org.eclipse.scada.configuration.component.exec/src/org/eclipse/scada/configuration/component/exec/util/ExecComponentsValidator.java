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
package org.eclipse.scada.configuration.component.exec.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.scada.configuration.component.exec.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.component.exec.ExecComponentsPackage
 * @generated
 */
public class ExecComponentsValidator extends EObjectValidator
{
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final ExecComponentsValidator INSTANCE = new ExecComponentsValidator ();

    /**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
    public static final String DIAGNOSTIC_SOURCE = "org.eclipse.scada.configuration.component.exec"; //$NON-NLS-1$

    /**
     * The {@link org.eclipse.emf.common.util.Diagnostic#getCode() code} for constraint 'Has Exec Driver' of 'Exec Job'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final int EXEC_JOB__HAS_EXEC_DRIVER = 1;

    /**
     * A constant with a fixed name that can be used as the base value for additional hand written constants.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 1;

    /**
     * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExecComponentsValidator ()
    {
        super ();
    }

    /**
     * Returns the package of this validator switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EPackage getEPackage ()
    {
        return ExecComponentsPackage.eINSTANCE;
    }

    /**
     * Calls <code>validateXXX</code> for the corresponding classifier of the model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected boolean validate ( int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        switch ( classifierID )
        {
            case ExecComponentsPackage.EXEC_JOB:
                return validateExecJob ( (ExecJob)value, diagnostics, context );
            case ExecComponentsPackage.LOAD_AVERAGE:
                return validateLoadAverage ( (LoadAverage)value, diagnostics, context );
            case ExecComponentsPackage.LOAD_AVERAGE_CONFIGURATION:
                return validateLoadAverageConfiguration ( (LoadAverageConfiguration)value, diagnostics, context );
            case ExecComponentsPackage.PING_CHECK:
                return validatePingCheck ( (PingCheck)value, diagnostics, context );
            case ExecComponentsPackage.PING_CHECK_CONFIGURATION:
                return validatePingCheckConfiguration ( (PingCheckConfiguration)value, diagnostics, context );
            case ExecComponentsPackage.SYSTEM_INFORMATION_VM_STAT:
                return validateSystemInformationVMStat ( (SystemInformationVMStat)value, diagnostics, context );
            default:
                return true;
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateExecJob ( ExecJob execJob, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        if ( !validate_NoCircularContainment ( execJob, diagnostics, context ) )
            return false;
        boolean result = validate_EveryMultiplicityConforms ( execJob, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryDataValueConforms ( execJob, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryReferenceIsContained ( execJob, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryBidirectionalReferenceIsPaired ( execJob, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryProxyResolves ( execJob, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_UniqueID ( execJob, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryKeyUnique ( execJob, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryMapEntryUnique ( execJob, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validateExecJob_hasExecDriver ( execJob, diagnostics, context );
        return result;
    }

    /**
     * Validates the hasExecDriver constraint of '<em>Exec Job</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateExecJob_hasExecDriver ( ExecJob execJob, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return execJob.hasExecDriver ( diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateLoadAverage ( LoadAverage loadAverage, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        if ( !validate_NoCircularContainment ( loadAverage, diagnostics, context ) )
            return false;
        boolean result = validate_EveryMultiplicityConforms ( loadAverage, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryDataValueConforms ( loadAverage, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryReferenceIsContained ( loadAverage, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryBidirectionalReferenceIsPaired ( loadAverage, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryProxyResolves ( loadAverage, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_UniqueID ( loadAverage, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryKeyUnique ( loadAverage, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryMapEntryUnique ( loadAverage, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validateExecJob_hasExecDriver ( loadAverage, diagnostics, context );
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateLoadAverageConfiguration ( LoadAverageConfiguration loadAverageConfiguration, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( loadAverageConfiguration, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validatePingCheck ( PingCheck pingCheck, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        if ( !validate_NoCircularContainment ( pingCheck, diagnostics, context ) )
            return false;
        boolean result = validate_EveryMultiplicityConforms ( pingCheck, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryDataValueConforms ( pingCheck, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryReferenceIsContained ( pingCheck, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryBidirectionalReferenceIsPaired ( pingCheck, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryProxyResolves ( pingCheck, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_UniqueID ( pingCheck, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryKeyUnique ( pingCheck, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryMapEntryUnique ( pingCheck, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validateExecJob_hasExecDriver ( pingCheck, diagnostics, context );
        return result;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validatePingCheckConfiguration ( PingCheckConfiguration pingCheckConfiguration, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( pingCheckConfiguration, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateSystemInformationVMStat ( SystemInformationVMStat systemInformationVMStat, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        if ( !validate_NoCircularContainment ( systemInformationVMStat, diagnostics, context ) )
            return false;
        boolean result = validate_EveryMultiplicityConforms ( systemInformationVMStat, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryDataValueConforms ( systemInformationVMStat, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryReferenceIsContained ( systemInformationVMStat, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryBidirectionalReferenceIsPaired ( systemInformationVMStat, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryProxyResolves ( systemInformationVMStat, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_UniqueID ( systemInformationVMStat, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryKeyUnique ( systemInformationVMStat, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryMapEntryUnique ( systemInformationVMStat, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validateExecJob_hasExecDriver ( systemInformationVMStat, diagnostics, context );
        return result;
    }

    /**
     * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator ()
    {
        // TODO
        // Specialize this to return a resource locator for messages specific to this validator.
        // Ensure that you remove @generated or mark it @generated NOT
        return super.getResourceLocator ();
    }

} //ExecComponentsValidator
