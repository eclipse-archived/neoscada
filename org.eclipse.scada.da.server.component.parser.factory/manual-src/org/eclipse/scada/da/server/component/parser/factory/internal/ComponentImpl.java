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
package org.eclipse.scada.da.server.component.parser.factory.internal;

import java.util.concurrent.ScheduledExecutorService;

import org.eclipse.scada.base.extractor.extract.Extractor;
import org.eclipse.scada.base.extractor.input.Input;
import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.component.Hive;
import org.eclipse.scada.da.server.component.parser.ParserComponent;
import org.eclipse.scada.da.server.component.parser.factory.CreationContext;
import org.eclipse.scada.da.server.component.parser.factory.configuration.Component;
import org.eclipse.scada.da.server.component.parser.factory.configuration.ExtractorDefinition;

public class ComponentImpl extends ParserComponent
{
    private final Input input;

    public ComponentImpl ( final ScheduledExecutorService executor, final Hive hive, final FolderCommon folder, final Component component )
    {
        super ( executor, hive, folder, component.getId () );

        final CreationContext creationContext = new CreationContext () {

            @Override
            public ScheduledExecutorService getExecutor ()
            {
                return executor;
            }
        };
        this.input = component.getInput ().createInput ( creationContext );

        for ( final ExtractorDefinition extractorDef : component.getExtractors () )
        {
            final Extractor extractor = extractorDef.createExtractor ( creationContext );
            bindInput ( this.input, extractor, extractorDef.getPrefix () );
        }
    }

    @Override
    public void dispose ()
    {
        if ( this.input != null )
        {
            this.input.dispose ();
        }
        super.dispose ();
    }

}
