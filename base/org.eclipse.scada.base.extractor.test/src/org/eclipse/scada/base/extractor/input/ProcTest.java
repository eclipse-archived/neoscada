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
package org.eclipse.scada.base.extractor.input;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.eclipse.scada.base.extractor.extract.Extractor;
import org.eclipse.scada.base.extractor.extract.pattern.VariableFieldPatternExtractor;
import org.eclipse.scada.base.extractor.extract.split.SplitExtractor;
import org.eclipse.scada.base.extractor.extract.table.SplitTableExtractor;
import org.eclipse.scada.base.extractor.input.file.FileInput;
import org.eclipse.scada.base.extractor.input.utils.AbstractExtractTest;
import org.eclipse.scada.base.extractor.input.utils.ExtractorListener;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProcTest extends AbstractExtractTest
{

    private ScheduledExecutorService executor;

    @Before
    public void setup ()
    {
        this.executor = Executors.newSingleThreadScheduledExecutor ();
    }

    @After
    public void destroy () throws InterruptedException
    {
        this.executor.shutdown ();
        this.executor.awaitTermination ( Long.MAX_VALUE, TimeUnit.MILLISECONDS );
    }

    @Test
    public void cpuInfo () throws InterruptedException
    {
        final FileInput input = new FileInput ( this.executor, new File ( "/proc/cpuinfo" ), 100 );

        final Map<String, Extractor> subExtractors = new HashMap<String, Extractor> ();

        {
            subExtractors.put ( "fields", new VariableFieldPatternExtractor ( Pattern.compile ( "^(.*?)\\s+: (.*)$", Pattern.MULTILINE ), 1, 2, null ) );
        }

        final Extractor extractor = new SplitExtractor ( "\n\n", subExtractors );

        process ( input, extractor );
    }

    @Test
    public void swaps () throws InterruptedException
    {
        final FileInput input = new FileInput ( this.executor, new File ( "/proc/swaps" ), 100 );
        final SplitTableExtractor extractor = new SplitTableExtractor ( "\n", "\\s+", 0 );

        process ( input, extractor );
    }

    @Test
    public void mounts () throws InterruptedException
    {
        final FileInput input = new FileInput ( this.executor, new File ( "/proc/mounts" ), 100 );
        final SplitTableExtractor extractor = new SplitTableExtractor ( "\n", "\\s+", 1, new String[] { "target", "mountPoint", "fsType", "options", "flags1", "flags2" }, null );

        process ( input, extractor );
    }

    private void process ( final FileInput input, final Extractor extractor ) throws InterruptedException
    {
        input.addInputListener ( new ExtractorListener ( extractor ) );

        input.start ();

        Thread.sleep ( 100 );
        input.dispose ();
    }

}
