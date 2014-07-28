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
package org.eclipse.scada.configuration.world.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.scada.configuration.world.PostgresDatabaseSettings;
import org.eclipse.scada.configuration.world.WorldPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '
 * <em><b>Postgres Database Settings</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class PostgresDatabaseSettingsImpl extends AbstractGenericDatabaseSettingsImpl implements PostgresDatabaseSettings
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected PostgresDatabaseSettingsImpl ()
    {
        super ();
    }

    @Override
    protected Map<String, String> getSpecificProperties ()
    {
        final Map<String, String> result = new HashMap<> ();
        return result;
    }

    @Override
    public String getUrl ()
    {
        if ( getServerName () != null && getDatabaseName () != null )
        {
            return String.format ( "jdbc:postgres://%s/%s", getServerName (), getDatabaseName () );
        }
        else
        {
            return null;
        }
    }

    @Override
    public String getDriverName ()
    {
        return "org.postgresql.Driver"; //$NON-NLS-1$
    }

    @Override
    public EList<String> getBundles ()
    {
        return ECollections.asEList ( "org.openscada.external.postgresql" ); //$NON-NLS-1$
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass ()
    {
        return WorldPackage.Literals.POSTGRES_DATABASE_SETTINGS;
    }

} //PostgresDatabaseSettingsImpl
