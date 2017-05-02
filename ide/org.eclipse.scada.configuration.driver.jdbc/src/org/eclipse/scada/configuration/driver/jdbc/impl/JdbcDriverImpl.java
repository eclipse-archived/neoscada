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

import org.eclipse.scada.configuration.driver.jdbc.JdbcDriver;
import org.eclipse.scada.configuration.driver.jdbc.JdbcPackage;

import org.eclipse.scada.configuration.infrastructure.impl.AbstractCommonDriverImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Driver</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class JdbcDriverImpl extends AbstractCommonDriverImpl implements JdbcDriver
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected JdbcDriverImpl ()
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
        return JdbcPackage.Literals.JDBC_DRIVER;
    }

} //JdbcDriverImpl
