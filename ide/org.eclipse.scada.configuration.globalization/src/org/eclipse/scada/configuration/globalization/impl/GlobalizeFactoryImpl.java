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
package org.eclipse.scada.configuration.globalization.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.scada.configuration.globalization.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GlobalizeFactoryImpl extends EFactoryImpl implements GlobalizeFactory
{
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static GlobalizeFactory init ()
    {
        try
        {
            GlobalizeFactory theGlobalizeFactory = (GlobalizeFactory)EPackage.Registry.INSTANCE.getEFactory ( GlobalizePackage.eNS_URI );
            if ( theGlobalizeFactory != null )
            {
                return theGlobalizeFactory;
            }
        }
        catch ( Exception exception )
        {
            EcorePlugin.INSTANCE.log ( exception );
        }
        return new GlobalizeFactoryImpl ();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GlobalizeFactoryImpl ()
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
            case GlobalizePackage.GLOBALIZATION:
                return createGlobalization ();
            case GlobalizePackage.LOCAL:
                return createLocal ();
            case GlobalizePackage.INCLUDE:
                return createInclude ();
            case GlobalizePackage.EXCLUDE:
                return createExclude ();
            case GlobalizePackage.GLOBAL:
                return createGlobal ();
            case GlobalizePackage.EVENT_POOL_IMPORT:
                return createEventPoolImport ();
            case GlobalizePackage.MONITOR_POOL_IMPORT:
                return createMonitorPoolImport ();
            case GlobalizePackage.AUTHORATIVE:
                return createAuthorative ();
            case GlobalizePackage.ITEM_NAME_FILTER:
                return createItemNameFilter ();
            default:
                throw new IllegalArgumentException ( "The class '" + eClass.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Globalization createGlobalization ()
    {
        GlobalizationImpl globalization = new GlobalizationImpl ();
        return globalization;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Local createLocal ()
    {
        LocalImpl local = new LocalImpl ();
        return local;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Include createInclude ()
    {
        IncludeImpl include = new IncludeImpl ();
        return include;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Exclude createExclude ()
    {
        ExcludeImpl exclude = new ExcludeImpl ();
        return exclude;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Global createGlobal ()
    {
        GlobalImpl global = new GlobalImpl ();
        return global;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EventPoolImport createEventPoolImport ()
    {
        EventPoolImportImpl eventPoolImport = new EventPoolImportImpl ();
        return eventPoolImport;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MonitorPoolImport createMonitorPoolImport ()
    {
        MonitorPoolImportImpl monitorPoolImport = new MonitorPoolImportImpl ();
        return monitorPoolImport;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Authorative createAuthorative ()
    {
        AuthorativeImpl authorative = new AuthorativeImpl ();
        return authorative;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ItemNameFilter createItemNameFilter ()
    {
        ItemNameFilterImpl itemNameFilter = new ItemNameFilterImpl ();
        return itemNameFilter;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public GlobalizePackage getGlobalizePackage ()
    {
        return (GlobalizePackage)getEPackage ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static GlobalizePackage getPackage ()
    {
        return GlobalizePackage.eINSTANCE;
    }

} //GlobalizeFactoryImpl
