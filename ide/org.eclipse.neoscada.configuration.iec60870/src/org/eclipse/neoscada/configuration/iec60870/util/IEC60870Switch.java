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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.neoscada.configuration.iec60870.*;
import org.eclipse.neoscada.configuration.iec60870.ClientDataModuleOptions;
import org.eclipse.neoscada.configuration.iec60870.ClientDevice;
import org.eclipse.neoscada.configuration.iec60870.DataModuleOptions;
import org.eclipse.neoscada.configuration.iec60870.Device;
import org.eclipse.neoscada.configuration.iec60870.DriverApplication;
import org.eclipse.neoscada.configuration.iec60870.Exporter;
import org.eclipse.neoscada.configuration.iec60870.ExporterItemInterceptor;
import org.eclipse.neoscada.configuration.iec60870.IEC60870Device;
import org.eclipse.neoscada.configuration.iec60870.IEC60870Driver;
import org.eclipse.neoscada.configuration.iec60870.IEC60870Package;
import org.eclipse.neoscada.configuration.iec60870.Item;
import org.eclipse.neoscada.configuration.iec60870.ProtocolOptions;
import org.eclipse.scada.configuration.component.ItemInterceptor;
import org.eclipse.scada.configuration.component.MasterAssigned;
import org.eclipse.scada.configuration.infrastructure.AbstractEquinoxDriver;
import org.eclipse.scada.configuration.infrastructure.EquinoxBase;
import org.eclipse.scada.configuration.infrastructure.NamedApplication;
import org.eclipse.scada.configuration.world.Application;
import org.eclipse.scada.configuration.world.Documentable;
import org.eclipse.scada.configuration.world.Driver;
import org.eclipse.scada.configuration.world.NamedDocumentable;
import org.eclipse.scada.configuration.world.osgi.ApplicationModule;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.neoscada.configuration.iec60870.IEC60870Package
 * @generated
 */
public class IEC60870Switch<T> extends Switch<T>
{
    /**
     * The cached model package
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static IEC60870Package modelPackage;

    /**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IEC60870Switch ()
    {
        if ( modelPackage == null )
        {
            modelPackage = IEC60870Package.eINSTANCE;
        }
    }

    /**
     * Checks whether this is a switch for the given package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param ePackage the package in question.
     * @return whether this is a switch for the given package.
     * @generated
     */
    @Override
    protected boolean isSwitchFor ( EPackage ePackage )
    {
        return ePackage == modelPackage;
    }

    /**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
    @Override
    protected T doSwitch ( int classifierID, EObject theEObject )
    {
        switch ( classifierID )
        {
            case IEC60870Package.EXPORTER:
            {
                Exporter exporter = (Exporter)theEObject;
                T result = caseExporter ( exporter );
                if ( result == null )
                    result = caseApplicationModule ( exporter );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case IEC60870Package.DEVICE:
            {
                Device device = (Device)theEObject;
                T result = caseDevice ( device );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case IEC60870Package.ITEM:
            {
                Item item = (Item)theEObject;
                T result = caseItem ( item );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case IEC60870Package.EXPORTER_ITEM_INTERCEPTOR:
            {
                ExporterItemInterceptor exporterItemInterceptor = (ExporterItemInterceptor)theEObject;
                T result = caseExporterItemInterceptor ( exporterItemInterceptor );
                if ( result == null )
                    result = caseItemInterceptor ( exporterItemInterceptor );
                if ( result == null )
                    result = caseMasterAssigned ( exporterItemInterceptor );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case IEC60870Package.PROTOCOL_OPTIONS:
            {
                ProtocolOptions protocolOptions = (ProtocolOptions)theEObject;
                T result = caseProtocolOptions ( protocolOptions );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case IEC60870Package.DATA_MODULE_OPTIONS:
            {
                DataModuleOptions dataModuleOptions = (DataModuleOptions)theEObject;
                T result = caseDataModuleOptions ( dataModuleOptions );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case IEC60870Package.CLIENT_DEVICE:
            {
                ClientDevice clientDevice = (ClientDevice)theEObject;
                T result = caseClientDevice ( clientDevice );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case IEC60870Package.DRIVER_APPLICATION:
            {
                DriverApplication driverApplication = (DriverApplication)theEObject;
                T result = caseDriverApplication ( driverApplication );
                if ( result == null )
                    result = caseDriver ( driverApplication );
                if ( result == null )
                    result = caseEquinoxApplication ( driverApplication );
                if ( result == null )
                    result = caseApplication ( driverApplication );
                if ( result == null )
                    result = caseNamedDocumentable ( driverApplication );
                if ( result == null )
                    result = caseDocumentable ( driverApplication );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case IEC60870Package.CLIENT_DATA_MODULE_OPTIONS:
            {
                ClientDataModuleOptions clientDataModuleOptions = (ClientDataModuleOptions)theEObject;
                T result = caseClientDataModuleOptions ( clientDataModuleOptions );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case IEC60870Package.IEC60870_DRIVER:
            {
                IEC60870Driver iec60870Driver = (IEC60870Driver)theEObject;
                T result = caseIEC60870Driver ( iec60870Driver );
                if ( result == null )
                    result = caseAbstractEquinoxDriver ( iec60870Driver );
                if ( result == null )
                    result = caseInfrastructure_Driver ( iec60870Driver );
                if ( result == null )
                    result = caseEquinoxBase ( iec60870Driver );
                if ( result == null )
                    result = caseNamedApplication ( iec60870Driver );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case IEC60870Package.IEC60870_DEVICE:
            {
                IEC60870Device iec60870Device = (IEC60870Device)theEObject;
                T result = caseIEC60870Device ( iec60870Device );
                if ( result == null )
                    result = caseInfrastructure_Device ( iec60870Device );
                if ( result == null )
                    result = caseNamedDocumentable ( iec60870Device );
                if ( result == null )
                    result = caseDocumentable ( iec60870Device );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            case IEC60870Package.ITEM_TYPE:
            {
                ItemType itemType = (ItemType)theEObject;
                T result = caseItemType ( itemType );
                if ( result == null )
                    result = defaultCase ( theEObject );
                return result;
            }
            default:
                return defaultCase ( theEObject );
        }
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Exporter</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Exporter</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseExporter ( Exporter object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Device</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Device</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDevice ( Device object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Item</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Item</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseItem ( Item object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Exporter Item Interceptor</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Exporter Item Interceptor</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseExporterItemInterceptor ( ExporterItemInterceptor object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Protocol Options</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Protocol Options</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseProtocolOptions ( ProtocolOptions object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Data Module Options</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data Module Options</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDataModuleOptions ( DataModuleOptions object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Client Device</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Client Device</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseClientDevice ( ClientDevice object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Driver Application</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Driver Application</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDriverApplication ( DriverApplication object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Client Data Module Options</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Client Data Module Options</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseClientDataModuleOptions ( ClientDataModuleOptions object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Driver</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Driver</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIEC60870Driver ( IEC60870Driver object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Device</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Device</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseIEC60870Device ( IEC60870Device object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Item Type</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Item Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseItemType ( ItemType object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Application Module</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Application Module</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseApplicationModule ( ApplicationModule object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Master Assigned</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Master Assigned</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseMasterAssigned ( MasterAssigned object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Item Interceptor</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Item Interceptor</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseItemInterceptor ( ItemInterceptor object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Documentable</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Documentable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDocumentable ( Documentable object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Named Documentable</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Named Documentable</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNamedDocumentable ( NamedDocumentable object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Application</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Application</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseApplication ( Application object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Driver</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Driver</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseDriver ( Driver object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Equinox Application</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Equinox Application</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEquinoxApplication ( EquinoxApplication object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Named Application</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Named Application</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseNamedApplication ( NamedApplication object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Driver</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Driver</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseInfrastructure_Driver ( org.eclipse.scada.configuration.infrastructure.Driver object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Equinox Base</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Equinox Base</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseEquinoxBase ( EquinoxBase object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Abstract Equinox Driver</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Abstract Equinox Driver</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseAbstractEquinoxDriver ( AbstractEquinoxDriver object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>Device</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Device</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
    public T caseInfrastructure_Device ( org.eclipse.scada.configuration.infrastructure.Device object )
    {
        return null;
    }

    /**
     * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
     * <!-- begin-user-doc -->
     * This implementation returns null;
     * returning a non-null result will terminate the switch, but this is the
     * last case anyway.
     * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject)
     * @generated
     */
    @Override
    public T defaultCase ( EObject object )
    {
        return null;
    }

} //IEC60870Switch
