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
package org.eclipse.scada.common.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;
import org.eclipse.scada.common.CommonPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CommonXMLProcessor extends XMLProcessor
{
   

    /**
     * Public constructor to instantiate the helper.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CommonXMLProcessor ()
    {
        super ( ( EPackage.Registry.INSTANCE ) );
        CommonPackage.eINSTANCE.eClass ();
    }

    /**
     * Register for "*" and "xml" file extensions the CommonResourceFactoryImpl factory.
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
            registrations.put ( XML_EXTENSION, new CommonResourceFactoryImpl () );
            registrations.put ( STAR_EXTENSION, new CommonResourceFactoryImpl () );
        }
        return registrations;
    }

} //CommonXMLProcessor
