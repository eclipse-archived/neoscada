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
package org.eclipse.scada.configuration.component.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.DanglingItemReference;
import org.eclipse.scada.configuration.world.osgi.impl.ItemImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dangling Item Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class DanglingItemReferenceImpl extends ItemImpl implements DanglingItemReference
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DanglingItemReferenceImpl ()
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
        return ComponentPackage.Literals.DANGLING_ITEM_REFERENCE;
    }

} //DanglingItemReferenceImpl
