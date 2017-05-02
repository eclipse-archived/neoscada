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
package org.eclipse.scada.configuration.world.osgi.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;
import org.eclipse.scada.configuration.world.osgi.SfpDataAccessConnection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '
 * <em><b>Sfp Data Access Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class SfpDataAccessConnectionImpl extends DataAccessConnectionImpl implements SfpDataAccessConnection
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SfpDataAccessConnectionImpl ()
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
        return OsgiPackage.Literals.SFP_DATA_ACCESS_CONNECTION;
    }

    /**
     * @generated NOT
     */
    @Override
    public String makeUri ( final boolean localhost )
    {
        return makeBasicUri ( localhost, "da", "sfp" );
    }

} //SfpDataAccessConnectionImpl
