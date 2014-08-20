/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 *
 */
package org.eclipse.scada.configuration.setup.common.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.scada.configuration.setup.common.CommonPackage;
import org.eclipse.scada.configuration.setup.common.PostgresSetupModule;
import org.eclipse.scada.configuration.setup.common.PostgresSetupModuleValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 *
 * @see org.eclipse.scada.configuration.setup.common.CommonPackage
 * @generated
 */
public class CommonValidator extends EObjectValidator
{
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public static final CommonValidator INSTANCE = new CommonValidator ();

    /**
     * A constant for the
     * {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of
     * diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes}
     * from this package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
    public static final String DIAGNOSTIC_SOURCE = "org.eclipse.scada.configuration.setup.common"; //$NON-NLS-1$

    /**
     * A constant with a fixed name that can be used as the base value for
     * additional hand written constants.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

    /**
     * A constant with a fixed name that can be used as the base value for
     * additional hand written constants in a derived class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public CommonValidator ()
    {
        super ();
    }

    /**
     * Returns the package of this validator switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EPackage getEPackage ()
    {
        return CommonPackage.eINSTANCE;
    }

    /**
     * Calls <code>validateXXX</code> for the corresponding classifier of the
     * model.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected boolean validate ( final int classifierID, final Object value, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        switch ( classifierID )
        {
            case CommonPackage.POSTGRES_SETUP_MODULE:
                return validatePostgresSetupModule ( (PostgresSetupModule)value, diagnostics, context );
            default:
                return true;
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    public boolean validatePostgresSetupModule ( final PostgresSetupModule postgresSetupModule, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        if ( !validate_NoCircularContainment ( postgresSetupModule, diagnostics, context ) )
        {
            return false;
        }
        boolean result = validate_EveryMultiplicityConforms ( postgresSetupModule, diagnostics, context );
        if ( result || diagnostics != null )
        {
            result &= validate_EveryDataValueConforms ( postgresSetupModule, diagnostics, context );
        }
        if ( result || diagnostics != null )
        {
            result &= validate_EveryReferenceIsContained ( postgresSetupModule, diagnostics, context );
        }
        if ( result || diagnostics != null )
        {
            result &= validate_EveryBidirectionalReferenceIsPaired ( postgresSetupModule, diagnostics, context );
        }
        if ( result || diagnostics != null )
        {
            result &= validate_EveryProxyResolves ( postgresSetupModule, diagnostics, context );
        }
        if ( result || diagnostics != null )
        {
            result &= validate_UniqueID ( postgresSetupModule, diagnostics, context );
        }
        if ( result || diagnostics != null )
        {
            result &= validate_EveryKeyUnique ( postgresSetupModule, diagnostics, context );
        }
        if ( result || diagnostics != null )
        {
            result &= validate_EveryMapEntryUnique ( postgresSetupModule, diagnostics, context );
        }
        if ( result || diagnostics != null )
        {
            result &= validatePostgresSetupModule_resources ( postgresSetupModule, diagnostics, context );
        }
        return result;
    }

    /**
     * Validates the resources constraint of '<em>Postgres Setup Module</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated NOT
     */
    public boolean validatePostgresSetupModule_resources ( final PostgresSetupModule postgresSetupModule, final DiagnosticChain diagnostics, final Map<Object, Object> context )
    {
        return new PostgresSetupModuleValidator ().validate ( postgresSetupModule, diagnostics, context );
    }

    /**
     * Returns the resource locator that will be used to fetch messages for this
     * validator's diagnostics.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
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

} //CommonValidator
