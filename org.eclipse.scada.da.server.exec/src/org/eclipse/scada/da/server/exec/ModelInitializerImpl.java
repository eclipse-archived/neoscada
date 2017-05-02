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
package org.eclipse.scada.da.server.exec;

import org.eclipse.scada.da.exec.configuration.ConfigurationPackage;
import org.eclipse.scada.utils.init.Initializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelInitializerImpl implements Initializer
{

    private final static Logger logger = LoggerFactory.getLogger ( ModelInitializerImpl.class );

    @Override
    public void initialize ( final Object type )
    {
        if ( type.equals ( "emf" ) )
        {
            logger.info ( "Initializing model" );
            ConfigurationPackage.eINSTANCE.eClass ();
            logger.info ( "Initialized model: {}", ConfigurationPackage.eNS_URI );
        }
    }

}
