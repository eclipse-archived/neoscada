/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.driver.parser.lib;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.scada.configuration.driver.parser.ParserComponentHost;
import org.eclipse.scada.configuration.driver.parser.ParserDriver;
import org.eclipse.scada.configuration.driver.parser.ParserFactory;
import org.eclipse.scada.configuration.infrastructure.lib.DriverHandler;

public class DriverHandlerImpl extends AbstractDriverHandler<ParserComponentHost, ParserDriver> implements DriverHandler
{
    @Override
    protected ParserDriver createDriver ( final ParserComponentHost driver )
    {
        final ParserDriver result = ParserFactory.eINSTANCE.createParserDriver ();

        result.getComponents ().addAll ( EcoreUtil.copyAll ( driver.getComponents () ) );

        return result;
    }
}
