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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.scada.configuration.component.common.*;

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
            default:
                throw new IllegalArgumentException ( "The class '" + eClass.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
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
