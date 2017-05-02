/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.exec.command;

import java.util.Collection;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.common.chain.DataItemInputChained;
import org.eclipse.scada.da.server.exec.Hive;
import org.eclipse.scada.da.server.exec.extractor.Extractor;
import org.eclipse.scada.da.server.exec.splitter.Splitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExtractorContinuousCommand extends AbstractContinuousCommand
{
    private final static Logger logger = LoggerFactory.getLogger ( ExtractorContinuousCommand.class );

    private int currentLineCount;

    private final Collection<Extractor> extrators;

    private final int ignoreStartLines;

    private DataItemInputChained lastInput;

    public ExtractorContinuousCommand ( final String id, final ProcessConfiguration processConfiguration, final int restartDelay, final int maxInputBuffer, final int ignoreStartLines, final Splitter splitter, final Collection<Extractor> extractors )
    {
        super ( id, processConfiguration, restartDelay, maxInputBuffer, splitter );
        this.extrators = extractors;
        this.ignoreStartLines = ignoreStartLines;
    }

    @Override
    public void start ( final Hive hive, final FolderCommon parentFolder )
    {
        super.start ( hive, parentFolder );

        this.lastInput = this.itemFactory.createInput ( "lastInput", null );

        for ( final Extractor extractor : this.extrators )
        {
            extractor.register ( hive, this.itemFactory );
        }
    }

    @Override
    public void stop ()
    {
        for ( final Extractor extractor : this.extrators )
        {
            extractor.unregister ();
        }

        super.stop ();
    }

    @Override
    protected void processFailed ( final Throwable e )
    {
        super.processFailed ( e );
        final ExecutionResult result = new ExecutionResult ();
        result.setExecutionError ( new RuntimeException ( "Process failed", e ) );
        for ( final Extractor extractor : this.extrators )
        {
            extractor.process ( result );
        }

    }

    @Override
    protected void handleStdLine ( final String line )
    {
        logger.debug ( "Got line: " + line );
        this.lastInput.updateData ( Variant.valueOf ( line ), null, null );

        this.currentLineCount++;
        if ( this.currentLineCount > this.ignoreStartLines )
        {
            final ExecutionResult result = new ExecutionResult ();
            result.setOutput ( line );
            for ( final Extractor extractor : this.extrators )
            {
                extractor.process ( result );
            }
        }
    }

    @Override
    protected void processStarted ( final Process process )
    {
        this.currentLineCount = 0;
        super.processStarted ( process );
    }

}
