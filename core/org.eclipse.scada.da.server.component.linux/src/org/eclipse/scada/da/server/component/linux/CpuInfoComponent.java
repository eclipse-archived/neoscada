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
package org.eclipse.scada.da.server.component.linux;

import java.io.File;
import java.util.concurrent.ScheduledExecutorService;
import java.util.regex.Pattern;

import org.eclipse.scada.base.extractor.convert.DefaultValueConverter;
import org.eclipse.scada.base.extractor.extract.Extractor;
import org.eclipse.scada.base.extractor.extract.pattern.VariableFieldPatternExtractor;
import org.eclipse.scada.base.extractor.extract.split.SplitExtractor;
import org.eclipse.scada.base.extractor.input.file.FileInput;
import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.component.Hive;
import org.eclipse.scada.da.server.component.parser.ParserComponent;

public class CpuInfoComponent extends ParserComponent
{
    private final ScheduledExecutorService executor;

    private final FileInput input;

    public CpuInfoComponent ( final ScheduledExecutorService executor, final Hive hive, final FolderCommon folder, final String activationPrefix )
    {
        super ( executor, hive, folder, activationPrefix );
        this.executor = executor;

        this.input = new FileInput ( this.executor, new File ( "/proc/cpuinfo" ), 1000 ); //$NON-NLS-1$

        final Extractor extractor = new SplitExtractor ( "\n\n", new VariableFieldPatternExtractor ( Pattern.compile ( "^(.*?)\\s+: (.*)$", Pattern.MULTILINE ), 1, 2, DefaultValueConverter.INSTANCE ) ); //$NON-NLS-1$ //$NON-NLS-2$
        bindInput ( this.input, extractor, "prefix" ); //$NON-NLS-1$
    }
}
