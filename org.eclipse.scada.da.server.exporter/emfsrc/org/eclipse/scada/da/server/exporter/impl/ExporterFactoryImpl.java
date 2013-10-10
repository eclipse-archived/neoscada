/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.exporter.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.scada.da.server.exporter.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExporterFactoryImpl extends EFactoryImpl implements ExporterFactory
{
    //$NON-NLS-1$

    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static ExporterFactory init ()
    {
        try
        {
            ExporterFactory theExporterFactory = (ExporterFactory)EPackage.Registry.INSTANCE.getEFactory ( ExporterPackage.eNS_URI );
            if ( theExporterFactory != null )
            {
                return theExporterFactory;
            }
        }
        catch ( Exception exception )
        {
            EcorePlugin.INSTANCE.log ( exception );
        }
        return new ExporterFactoryImpl ();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExporterFactoryImpl ()
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
            case ExporterPackage.ANNOUNCER_TYPE:
                return createAnnouncerType ();
            case ExporterPackage.CONFIGURATION_TYPE:
                return createConfigurationType ();
            case ExporterPackage.DOCUMENT_ROOT:
                return createDocumentRoot ();
            case ExporterPackage.EXPORT_TYPE:
                return createExportType ();
            case ExporterPackage.HIVE_CONFIGURATION_TYPE:
                return createHiveConfigurationType ();
            case ExporterPackage.HIVE_TYPE:
                return createHiveType ();
            default:
                throw new IllegalArgumentException ( "The class '" + eClass.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AnnouncerType createAnnouncerType ()
    {
        AnnouncerTypeImpl announcerType = new AnnouncerTypeImpl ();
        return announcerType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ConfigurationType createConfigurationType ()
    {
        ConfigurationTypeImpl configurationType = new ConfigurationTypeImpl ();
        return configurationType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DocumentRoot createDocumentRoot ()
    {
        DocumentRootImpl documentRoot = new DocumentRootImpl ();
        return documentRoot;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExportType createExportType ()
    {
        ExportTypeImpl exportType = new ExportTypeImpl ();
        return exportType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public HiveConfigurationType createHiveConfigurationType ()
    {
        HiveConfigurationTypeImpl hiveConfigurationType = new HiveConfigurationTypeImpl ();
        return hiveConfigurationType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public HiveType createHiveType ()
    {
        HiveTypeImpl hiveType = new HiveTypeImpl ();
        return hiveType;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExporterPackage getExporterPackage ()
    {
        return (ExporterPackage)getEPackage ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static ExporterPackage getPackage ()
    {
        return ExporterPackage.eINSTANCE;
    }

} //ExporterFactoryImpl
