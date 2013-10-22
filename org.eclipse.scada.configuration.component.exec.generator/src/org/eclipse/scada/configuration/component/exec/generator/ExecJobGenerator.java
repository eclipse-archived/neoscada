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
package org.eclipse.scada.configuration.component.exec.generator;

import org.eclipse.scada.configuration.component.exec.ExecJob;
import org.eclipse.scada.configuration.component.generator.DriverGenerator;
import org.eclipse.scada.configuration.world.ExecDriver;
import org.eclipse.scada.da.exec.configuration.ConfigurationFactory;
import org.eclipse.scada.da.exec.configuration.RootType;

public abstract class ExecJobGenerator extends DriverGenerator
{
    private final ExecJob execJob;

    public ExecJobGenerator ( final ExecJob execJob )
    {
        super ( execJob );
        this.execJob = execJob;
    }

    @Override
    public ExecDriver findDriver ()
    {
        final ExecDriver driver = (ExecDriver)this.context.getDriverMap ().get ( this.execJob.getRunsOn () );
        if ( driver == null )
        {
            throw new IllegalStateException ( String.format ( "ExecJob component %s has no driver assigned", this.execJob ) );
        }
        return driver;
    }

    public RootType findRoot ()
    {
        final ExecDriver driver = findDriver ();

        RootType root = driver.getRoot ();
        if ( root != null )
        {
            return root;
        }
        else
        {
            root = ConfigurationFactory.eINSTANCE.createRootType ();
            driver.setRoot ( root );
            return root;
        }
    }

    protected String jobName ()
    {
        return "CMD." + getFullLevelName () + "." + this.execJob.getName ();
    }

    protected String localItem ( final String tag )
    {
        return jobName () + "." + tag;
    }
}
