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
package org.eclipse.scada.configuration.component.exec.lib;

import org.eclipse.scada.configuration.component.exec.SystemInformationVMStat;
import org.eclipse.scada.configuration.world.osgi.DataType;
import org.eclipse.scada.da.exec.configuration.ConfigurationFactory;
import org.eclipse.scada.da.exec.configuration.EnvEntryType;
import org.eclipse.scada.da.exec.configuration.ProcessType;
import org.eclipse.scada.da.exec.configuration.RootType;
import org.eclipse.scada.da.exec.configuration.SplitContinuousCommandType;
import org.eclipse.scada.da.exec.configuration.SplitterExtractorType;
import org.eclipse.scada.da.exec.configuration.SplitterType;

public class SystemInformationVMStatGenerator extends AbstractFieldJobGenerator
{
    public SystemInformationVMStatGenerator ( final SystemInformationVMStat configuration )
    {
        super ( configuration );
    }

    @Override
    protected ItemSpec[] getItems ()
    {
        return new ItemSpec[] { //
        new ItemSpec ( "A", "procs.run", DataType.INT64, "The number of processes waiting for run time", null, new String[] { "PROCS", "RUN" }, new String[] { "input" } ), //
        new ItemSpec ( "A", "procs.blocked", DataType.INT64, "The number of processes in uninterruptible sleep", null, new String[] { "PROCS", "BLOCKED" }, new String[] { "input" } ), //
        new ItemSpec ( "A", "memory.swpd", DataType.INT64, "The amount of virtual memory used", "KiB", new String[] { "MEM", "SWAPPED" }, new String[] { "input" } ), //
        new ItemSpec ( "A", "memory.free", DataType.INT64, "The amount of idle memory", "KiB", new String[] { "MEM", "FREE" }, new String[] { "input" } ), //
        new ItemSpec ( "A", "memory.buff", DataType.INT64, "The amount of memory used as buffers", "KiB", new String[] { "MEM", "BUFFER" }, new String[] { "input" } ), //
        new ItemSpec ( "A", "memory.cache", DataType.INT64, "The amount of memory used as cache", "KiB", new String[] { "MEM", "CACHE" }, new String[] { "input" } ), //
        new ItemSpec ( "A", "swap.in", DataType.INT64, "Amount of memory swapped in from disk", "/s", new String[] { "SWAP", "IN" }, new String[] { "input" } ), //
        new ItemSpec ( "A", "swap.out", DataType.INT64, "Amount of memory swapped out from disk", "/s", new String[] { "SWAP", "OUT" }, new String[] { "input" } ), //
        new ItemSpec ( "A", "block.in", DataType.INT64, "Blocks received from a block device", "/s", new String[] { "BLOCK", "IN" }, new String[] { "input" } ), //
        new ItemSpec ( "A", "block.out", DataType.INT64, "Blocks sent to a block device", "/s", new String[] { "BLOCK", "OUT" }, new String[] { "input" } ), //
        new ItemSpec ( "A", "system.in", DataType.INT64, "The number of interrupts per second, including the clock", "int/s", new String[] { "SYS", "INT" }, new String[] { "input" } ), //
        new ItemSpec ( "A", "system.cs", DataType.INT64, "The number of context switches per second", "cs/s", new String[] { "SYS", "CS" }, new String[] { "input" } ), //
        new ItemSpec ( "A", "cpu.us", DataType.FLOAT, "Time spent running non-kernel code", "%", new String[] { "CPU", "USER" }, new String[] { "input" } ), //
        new ItemSpec ( "A", "cpu.sy", DataType.FLOAT, "Time spent running kernel code", "%", new String[] { "CPU", "SYS" }, new String[] { "input" } ), //
        new ItemSpec ( "A", "cpu.id", DataType.FLOAT, "Time spent idle", "%", new String[] { "CPU", "IDLE" }, new String[] { "input" } ), //
        new ItemSpec ( "A", "cpu.wa", DataType.FLOAT, "Time spent waiting for IO", "%", new String[] { "CPU", "WAIT" }, new String[] { "input" } ), //
        };
    }

    @Override
    protected void generateExecDriverConfiguration ()
    {
        final RootType root = findRoot ();

        final SplitContinuousCommandType cmd = ConfigurationFactory.eINSTANCE.createSplitContinuousCommandType ();
        cmd.setId ( jobName () );
        cmd.setRestartDelay ( 1000 );
        cmd.setMaxInputBuffer ( 2000 );
        cmd.setIgnoreStartLines ( 2 );
        root.getCommand ().add ( cmd );

        final ProcessType process = ConfigurationFactory.eINSTANCE.createProcessType ();
        process.setExec ( "vmstat" ); //$NON-NLS-1$
        process.getArgument ().add ( "-n" ); //$NON-NLS-1$
        process.getArgument ().add ( "1" ); //$NON-NLS-1$
        cmd.setProcess ( process );

        final EnvEntryType env = ConfigurationFactory.eINSTANCE.createEnvEntryType ();
        env.setName ( "LANG" ); //$NON-NLS-1$ 
        env.setValue ( "en_US" ); //$NON-NLS-1$ 
        process.getEnv ().add ( env );

        final SplitterType splitter = ConfigurationFactory.eINSTANCE.createSplitterType ();
        splitter.setType ( "newline" ); //$NON-NLS-1$
        cmd.setSplitter ( splitter );

        final SplitterExtractorType ext = ConfigurationFactory.eINSTANCE.createSplitterExtractorType ();
        ext.setSplitExpression ( " " );
        ext.setName ( "A" ); //$NON-NLS-1$ 
        cmd.getExtractor ().add ( ext );

        // create fields
        createItemFieldsFor ( ext );
    }
}
