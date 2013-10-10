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
package org.eclipse.scada.da.exec.configuration.util;

import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

import org.eclipse.emf.ecore.xmi.XMLResource;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource Factory</b> associated with the package.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.da.exec.configuration.util.ConfigurationResourceImpl
 * @generated
 */
public class ConfigurationResourceFactoryImpl extends ResourceFactoryImpl
{
    //$NON-NLS-1$

    /**
     * Creates an instance of the resource factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ConfigurationResourceFactoryImpl ()
    {
        super ();
    }

    /**
     * Creates an instance of the resource.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Resource createResource ( URI uri )
    {
        XMLResource result = new ConfigurationResourceImpl ( uri );
        result.getDefaultSaveOptions ().put ( XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE );
        result.getDefaultLoadOptions ().put ( XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE );

        result.getDefaultSaveOptions ().put ( XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE );

        result.getDefaultLoadOptions ().put ( XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE );
        result.getDefaultSaveOptions ().put ( XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE );

        result.getDefaultLoadOptions ().put ( XMLResource.OPTION_USE_LEXICAL_HANDLER, Boolean.TRUE );
        return result;
    }

} //ConfigurationResourceFactoryImpl
