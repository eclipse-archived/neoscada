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
package org.eclipse.scada.configuration.world.osgi.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.scada.configuration.world.Endpoint;
import org.eclipse.scada.configuration.world.osgi.DataAccessConnection;
import org.eclipse.scada.configuration.world.osgi.DataAccessExporter;
import org.eclipse.scada.configuration.world.osgi.Exporter;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Access Connection</b></em>
 * '.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DataAccessConnectionImpl extends ConnectionImpl implements DataAccessConnection
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DataAccessConnectionImpl ()
    {
        super ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass ()
    {
        return OsgiPackage.Literals.DATA_ACCESS_CONNECTION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getTypeTag ()
    {
        return "da";
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String makeUri ( final boolean localhost )
    {
        return super.makeBasicUri ( localhost, "da", "ngp" );
    }

    @Override
    public EList<Endpoint> getPossibleEndpoints ( final Exporter exporter )
    {
        if ( ! ( exporter instanceof DataAccessExporter ) )
        {
            return ECollections.emptyEList ();
        }

        return exporter.getEndpoints ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eInvoke ( int operationID, EList<?> arguments ) throws InvocationTargetException
    {
        switch ( operationID )
        {
            case OsgiPackage.DATA_ACCESS_CONNECTION___GET_TYPE_TAG:
                return getTypeTag ();
            case OsgiPackage.DATA_ACCESS_CONNECTION___MAKE_URI__BOOLEAN:
                return makeUri ( (Boolean)arguments.get ( 0 ) );
        }
        return super.eInvoke ( operationID, arguments );
    }

} //DataAccessConnectionImpl
