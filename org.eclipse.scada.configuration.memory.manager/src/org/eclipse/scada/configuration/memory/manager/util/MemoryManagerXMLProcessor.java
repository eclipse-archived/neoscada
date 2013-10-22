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
package org.eclipse.scada.configuration.memory.manager.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;
import org.eclipse.scada.configuration.memory.manager.MemoryManagerPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MemoryManagerXMLProcessor extends XMLProcessor
{

    /**
     * Public constructor to instantiate the helper.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MemoryManagerXMLProcessor ()
    {
        super ( ( EPackage.Registry.INSTANCE ) );
        MemoryManagerPackage.eINSTANCE.eClass ();
    }

    /**
     * Register for "*" and "xml" file extensions the MemoryManagerResourceFactoryImpl factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected Map<String, Resource.Factory> getRegistrations ()
    {
        if ( registrations == null )
        {
            super.getRegistrations ();
            registrations.put ( XML_EXTENSION, new MemoryManagerResourceFactoryImpl () );
            registrations.put ( STAR_EXTENSION, new MemoryManagerResourceFactoryImpl () );
        }
        return registrations;
    }

} //MemoryManagerXMLProcessor
