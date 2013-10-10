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
package org.eclipse.scada.da.jdbc.configuration.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage;
import org.eclipse.scada.da.jdbc.configuration.QueryType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Query Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class QueryTypeImpl extends AbstractQueryTypeImpl implements QueryType
{
    //$NON-NLS-1$

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected QueryTypeImpl ()
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
        return ConfigurationPackage.Literals.QUERY_TYPE;
    }

} //QueryTypeImpl
