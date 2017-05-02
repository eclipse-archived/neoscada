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
package org.eclipse.scada.configuration.dave.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.scada.configuration.dave.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DaveFactoryImpl extends EFactoryImpl implements DaveFactory
{
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static DaveFactory init ()
    {
        try
        {
            DaveFactory theDaveFactory = (DaveFactory)EPackage.Registry.INSTANCE.getEFactory ( DavePackage.eNS_URI );
            if ( theDaveFactory != null )
            {
                return theDaveFactory;
            }
        }
        catch ( Exception exception )
        {
            EcorePlugin.INSTANCE.log ( exception );
        }
        return new DaveFactoryImpl ();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DaveFactoryImpl ()
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
            case DavePackage.DAVE_DEVICE:
                return createDaveDevice ();
            case DavePackage.DAVE_DRIVER:
                return createDaveDriver ();
            case DavePackage.DAVE_COMMUNICATION_PROCESSOR:
                return createDaveCommunicationProcessor ();
            case DavePackage.DAVE_REQUEST_BLOCK:
                return createDaveRequestBlock ();
            case DavePackage.DAVE_BLOCK_DEFINITION:
                return createDaveBlockDefinition ();
            default:
                throw new IllegalArgumentException ( "The class '" + eClass.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DaveDevice createDaveDevice ()
    {
        DaveDeviceImpl daveDevice = new DaveDeviceImpl ();
        return daveDevice;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DaveDriver createDaveDriver ()
    {
        DaveDriverImpl daveDriver = new DaveDriverImpl ();
        return daveDriver;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DaveCommunicationProcessor createDaveCommunicationProcessor ()
    {
        DaveCommunicationProcessorImpl daveCommunicationProcessor = new DaveCommunicationProcessorImpl ();
        return daveCommunicationProcessor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DaveRequestBlock createDaveRequestBlock ()
    {
        DaveRequestBlockImpl daveRequestBlock = new DaveRequestBlockImpl ();
        return daveRequestBlock;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DaveBlockDefinition createDaveBlockDefinition ()
    {
        DaveBlockDefinitionImpl daveBlockDefinition = new DaveBlockDefinitionImpl ();
        return daveBlockDefinition;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DavePackage getDavePackage ()
    {
        return (DavePackage)getEPackage ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static DavePackage getPackage ()
    {
        return DavePackage.eINSTANCE;
    }

} //DaveFactoryImpl
