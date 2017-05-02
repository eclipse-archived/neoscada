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
package org.eclipse.scada.configuration.driver.jdbc.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.scada.configuration.driver.jdbc.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JdbcFactoryImpl extends EFactoryImpl implements JdbcFactory
{
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static JdbcFactory init ()
    {
        try
        {
            JdbcFactory theJdbcFactory = (JdbcFactory)EPackage.Registry.INSTANCE.getEFactory ( JdbcPackage.eNS_URI );
            if ( theJdbcFactory != null )
            {
                return theJdbcFactory;
            }
        }
        catch ( Exception exception )
        {
            EcorePlugin.INSTANCE.log ( exception );
        }
        return new JdbcFactoryImpl ();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public JdbcFactoryImpl ()
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
            case JdbcPackage.JDBC_DRIVER_INSTANCE:
                return createJdbcDriverInstance ();
            case JdbcPackage.UPDATE_COMMAND:
                return createUpdateCommand ();
            case JdbcPackage.QUERY_COMPONENT:
                return createQueryComponent ();
            case JdbcPackage.UPDATE_MAPPING:
                return createUpdateMapping ();
            case JdbcPackage.COLUMN_MAPPING:
                return createColumnMapping ();
            case JdbcPackage.JDBC_DRIVER:
                return createJdbcDriver ();
            default:
                throw new IllegalArgumentException ( "The class '" + eClass.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public JdbcDriverInstance createJdbcDriverInstance ()
    {
        JdbcDriverInstanceImpl jdbcDriverInstance = new JdbcDriverInstanceImpl ();
        return jdbcDriverInstance;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UpdateCommand createUpdateCommand ()
    {
        UpdateCommandImpl updateCommand = new UpdateCommandImpl ();
        return updateCommand;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public QueryComponent createQueryComponent ()
    {
        QueryComponentImpl queryComponent = new QueryComponentImpl ();
        return queryComponent;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UpdateMapping createUpdateMapping ()
    {
        UpdateMappingImpl updateMapping = new UpdateMappingImpl ();
        return updateMapping;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ColumnMapping createColumnMapping ()
    {
        ColumnMappingImpl columnMapping = new ColumnMappingImpl ();
        return columnMapping;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public JdbcDriver createJdbcDriver ()
    {
        JdbcDriverImpl jdbcDriver = new JdbcDriverImpl ();
        return jdbcDriver;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public JdbcPackage getJdbcPackage ()
    {
        return (JdbcPackage)getEPackage ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static JdbcPackage getPackage ()
    {
        return JdbcPackage.eINSTANCE;
    }

} //JdbcFactoryImpl
