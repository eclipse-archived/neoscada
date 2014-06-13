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
package org.eclipse.scada.configuration.iec60870.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.scada.configuration.component.ItemInterceptor;
import org.eclipse.scada.configuration.iec60870.*;

import org.eclipse.scada.configuration.world.osgi.ApplicationModule;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.iec60870.IEC60870Package
 * @generated
 */
public class IEC60870AdapterFactory extends AdapterFactoryImpl
{
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static IEC60870Package modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public IEC60870AdapterFactory ()
    {
        if ( modelPackage == null )
        {
            modelPackage = IEC60870Package.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType ( Object object )
    {
        if ( object == modelPackage )
        {
            return true;
        }
        if ( object instanceof EObject )
        {
            return ( (EObject)object ).eClass ().getEPackage () == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IEC60870Switch<Adapter> modelSwitch =
            new IEC60870Switch<Adapter> ()
            {
                @Override
                public Adapter caseExporter ( Exporter object )
                {
                    return createExporterAdapter ();
                }

                @Override
                public Adapter caseDevice ( Device object )
                {
                    return createDeviceAdapter ();
                }

                @Override
                public Adapter caseItem ( Item object )
                {
                    return createItemAdapter ();
                }

                @Override
                public Adapter caseExporterItemInterceptor ( ExporterItemInterceptor object )
                {
                    return createExporterItemInterceptorAdapter ();
                }

                @Override
                public Adapter caseProtocolOptions ( ProtocolOptions object )
                {
                    return createProtocolOptionsAdapter ();
                }

                @Override
                public Adapter caseDataModuleOptions ( DataModuleOptions object )
                {
                    return createDataModuleOptionsAdapter ();
                }

                @Override
                public Adapter caseApplicationModule ( ApplicationModule object )
                {
                    return createApplicationModuleAdapter ();
                }

                @Override
                public Adapter caseItemInterceptor ( ItemInterceptor object )
                {
                    return createItemInterceptorAdapter ();
                }

                @Override
                public Adapter defaultCase ( EObject object )
                {
                    return createEObjectAdapter ();
                }
            };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter ( Notifier target )
    {
        return modelSwitch.doSwitch ( (EObject)target );
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.iec60870.Exporter <em>Exporter</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.iec60870.Exporter
     * @generated
     */
    public Adapter createExporterAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.iec60870.Device <em>Device</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.iec60870.Device
     * @generated
     */
    public Adapter createDeviceAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.iec60870.Item <em>Item</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.iec60870.Item
     * @generated
     */
    public Adapter createItemAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.iec60870.ExporterItemInterceptor <em>Exporter Item Interceptor</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.iec60870.ExporterItemInterceptor
     * @generated
     */
    public Adapter createExporterItemInterceptorAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.iec60870.ProtocolOptions <em>Protocol Options</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.iec60870.ProtocolOptions
     * @generated
     */
    public Adapter createProtocolOptionsAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.iec60870.DataModuleOptions <em>Data Module Options</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.iec60870.DataModuleOptions
     * @generated
     */
    public Adapter createDataModuleOptionsAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.osgi.ApplicationModule <em>Application Module</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.osgi.ApplicationModule
     * @generated
     */
    public Adapter createApplicationModuleAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.component.ItemInterceptor <em>Item Interceptor</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.component.ItemInterceptor
     * @generated
     */
    public Adapter createItemInterceptorAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter ()
    {
        return null;
    }

} //IEC60870AdapterFactory
