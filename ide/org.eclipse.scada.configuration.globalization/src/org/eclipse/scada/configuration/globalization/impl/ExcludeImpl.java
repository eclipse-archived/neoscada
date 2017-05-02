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
import org.eclipse.scada.configuration.globalization.Exclude;
import org.eclipse.scada.configuration.globalization.GlobalizePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Exclude</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ExcludeImpl extends PatternFilterImpl implements Exclude
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ExcludeImpl ()
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
        return GlobalizePackage.Literals.EXCLUDE;
    }

} //ExcludeImpl
