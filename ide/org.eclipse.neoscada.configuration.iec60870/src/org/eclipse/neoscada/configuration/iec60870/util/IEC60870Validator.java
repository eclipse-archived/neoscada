/**
 * Copyright (c) 2014, 2016 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 *
 */
package org.eclipse.neoscada.configuration.iec60870.util;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.neoscada.configuration.iec60870.*;
import org.eclipse.neoscada.configuration.iec60870.AddressInformation;
import org.eclipse.neoscada.configuration.iec60870.ClientDataModuleOptions;
import org.eclipse.neoscada.configuration.iec60870.ClientDevice;
import org.eclipse.neoscada.configuration.iec60870.DataModuleOptions;
import org.eclipse.neoscada.configuration.iec60870.DataType;
import org.eclipse.neoscada.configuration.iec60870.Device;
import org.eclipse.neoscada.configuration.iec60870.DriverApplication;
import org.eclipse.neoscada.configuration.iec60870.Exporter;
import org.eclipse.neoscada.configuration.iec60870.ExporterItemInterceptor;
import org.eclipse.neoscada.configuration.iec60870.IEC60870Device;
import org.eclipse.neoscada.configuration.iec60870.IEC60870Driver;
import org.eclipse.neoscada.configuration.iec60870.IEC60870Package;
import org.eclipse.neoscada.configuration.iec60870.Item;
import org.eclipse.neoscada.configuration.iec60870.ProtocolOptions;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package
 * @generated
 */
public class IEC60870Validator extends EObjectValidator
{
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final IEC60870Validator INSTANCE = new IEC60870Validator ();

    /**
     * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.common.util.Diagnostic#getSource()
     * @see org.eclipse.emf.common.util.Diagnostic#getCode()
     * @generated
     */
    public static final String DIAGNOSTIC_SOURCE = "org.eclipse.neoscada.configuration.iec60870"; //$NON-NLS-1$

    /**
     * A constant with a fixed name that can be used as the base value for additional hand written constants.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

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
    public IEC60870Validator ()
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
        return IEC60870Package.eINSTANCE;
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
            case IEC60870Package.EXPORTER:
                return validateExporter ( (Exporter)value, diagnostics, context );
            case IEC60870Package.DEVICE:
                return validateDevice ( (Device)value, diagnostics, context );
            case IEC60870Package.ITEM:
                return validateItem ( (Item)value, diagnostics, context );
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR:
                return validateExporterItemInterceptor ( (ExporterItemInterceptor)value, diagnostics, context );
            case IEC60870Package.PROTOCOL_OPTIONS:
                return validateProtocolOptions ( (ProtocolOptions)value, diagnostics, context );
            case IEC60870Package.DATA_MODULE_OPTIONS:
                return validateDataModuleOptions ( (DataModuleOptions)value, diagnostics, context );
            case IEC60870Package.CLIENT_DEVICE:
                return validateClientDevice ( (ClientDevice)value, diagnostics, context );
            case IEC60870Package.DRIVER_APPLICATION:
                return validateDriverApplication ( (DriverApplication)value, diagnostics, context );
            case IEC60870Package.CLIENT_DATA_MODULE_OPTIONS:
                return validateClientDataModuleOptions ( (ClientDataModuleOptions)value, diagnostics, context );
            case IEC60870Package.IEC60870_DRIVER:
                return validateIEC60870Driver ( (IEC60870Driver)value, diagnostics, context );
            case IEC60870Package.IEC60870_DEVICE:
                return validateIEC60870Device ( (IEC60870Device)value, diagnostics, context );
            case IEC60870Package.ITEM_TYPE:
                return validateItemType ( (ItemType)value, diagnostics, context );
            case IEC60870Package.DATA_TYPE:
                return validateDataType ( (DataType)value, diagnostics, context );
            case IEC60870Package.IEC_TYPE:
                return validateIECType ( (IECType)value, diagnostics, context );
            case IEC60870Package.ADDRESS:
                return validateAddress ( (AddressInformation)value, diagnostics, context );
            default:
                return true;
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateExporter ( Exporter exporter, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( exporter, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDevice ( Device device, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( device, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateItem ( Item item, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( item, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateExporterItemInterceptor ( ExporterItemInterceptor exporterItemInterceptor, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( exporterItemInterceptor, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateProtocolOptions ( ProtocolOptions protocolOptions, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        if ( !validate_NoCircularContainment ( protocolOptions, diagnostics, context ) )
            return false;
        boolean result = validate_EveryMultiplicityConforms ( protocolOptions, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryDataValueConforms ( protocolOptions, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryReferenceIsContained ( protocolOptions, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryBidirectionalReferenceIsPaired ( protocolOptions, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryProxyResolves ( protocolOptions, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_UniqueID ( protocolOptions, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryKeyUnique ( protocolOptions, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryMapEntryUnique ( protocolOptions, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validateProtocolOptions_asduAddressSizeCheck ( protocolOptions, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validateProtocolOptions_causeOfTransmissionSizeCheck ( protocolOptions, diagnostics, context );
        return result;
    }

    /**
     * The cached validation expression for the asduAddressSizeCheck constraint of '<em>Protocol Options</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final String PROTOCOL_OPTIONS__ASDU_ADDRESS_SIZE_CHECK__EEXPRESSION = "asduAddressSize>=1 and asduAddressSize <=2"; //$NON-NLS-1$

    /**
     * Validates the asduAddressSizeCheck constraint of '<em>Protocol Options</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateProtocolOptions_asduAddressSizeCheck ( ProtocolOptions protocolOptions, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate ( IEC60870Package.Literals.PROTOCOL_OPTIONS, protocolOptions, diagnostics, context, "http://www.eclipse.org/emf/2002/Ecore/OCL", //$NON-NLS-1$
                "asduAddressSizeCheck", //$NON-NLS-1$
                PROTOCOL_OPTIONS__ASDU_ADDRESS_SIZE_CHECK__EEXPRESSION, Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0 );
    }

    /**
     * The cached validation expression for the causeOfTransmissionSizeCheck constraint of '<em>Protocol Options</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final String PROTOCOL_OPTIONS__CAUSE_OF_TRANSMISSION_SIZE_CHECK__EEXPRESSION = "causeOfTransmissionSize>=1 and causeOfTransmissionSize<=2"; //$NON-NLS-1$

    /**
     * Validates the causeOfTransmissionSizeCheck constraint of '<em>Protocol Options</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateProtocolOptions_causeOfTransmissionSizeCheck ( ProtocolOptions protocolOptions, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate ( IEC60870Package.Literals.PROTOCOL_OPTIONS, protocolOptions, diagnostics, context, "http://www.eclipse.org/emf/2002/Ecore/OCL", //$NON-NLS-1$
                "causeOfTransmissionSizeCheck", //$NON-NLS-1$
                PROTOCOL_OPTIONS__CAUSE_OF_TRANSMISSION_SIZE_CHECK__EEXPRESSION, Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDataModuleOptions ( DataModuleOptions dataModuleOptions, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( dataModuleOptions, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateClientDevice ( ClientDevice clientDevice, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( clientDevice, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDriverApplication ( DriverApplication driverApplication, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( driverApplication, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateClientDataModuleOptions ( ClientDataModuleOptions clientDataModuleOptions, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( clientDataModuleOptions, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateIEC60870Driver ( IEC60870Driver iec60870Driver, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( iec60870Driver, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateIEC60870Device ( IEC60870Device iec60870Device, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        if ( !validate_NoCircularContainment ( iec60870Device, diagnostics, context ) )
            return false;
        boolean result = validate_EveryMultiplicityConforms ( iec60870Device, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryDataValueConforms ( iec60870Device, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryReferenceIsContained ( iec60870Device, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryBidirectionalReferenceIsPaired ( iec60870Device, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryProxyResolves ( iec60870Device, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_UniqueID ( iec60870Device, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryKeyUnique ( iec60870Device, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validate_EveryMapEntryUnique ( iec60870Device, diagnostics, context );
        if ( result || diagnostics != null )
            result &= validateIEC60870Device_portCheck ( iec60870Device, diagnostics, context );
        return result;
    }

    /**
     * The cached validation expression for the portCheck constraint of '<em>Device</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static final String IEC60870_DEVICE__PORT_CHECK__EEXPRESSION = "port > 0 and port < 65535"; //$NON-NLS-1$

    /**
     * Validates the portCheck constraint of '<em>Device</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateIEC60870Device_portCheck ( IEC60870Device iec60870Device, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate ( IEC60870Package.Literals.IEC60870_DEVICE, iec60870Device, diagnostics, context, "http://www.eclipse.org/emf/2002/Ecore/OCL", //$NON-NLS-1$
                "portCheck", //$NON-NLS-1$
                IEC60870_DEVICE__PORT_CHECK__EEXPRESSION, Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateItemType ( ItemType itemType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return validate_EveryDefaultConstraint ( itemType, diagnostics, context );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateDataType ( DataType dataType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateIECType ( IECType iecType, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return true;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean validateAddress ( AddressInformation address, DiagnosticChain diagnostics, Map<Object, Object> context )
    {
        return true;
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

} //IEC60870Validator
