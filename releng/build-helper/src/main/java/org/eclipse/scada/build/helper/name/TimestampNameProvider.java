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
package org.eclipse.scada.build.helper.name;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

import org.apache.maven.plugin.MojoExecutionException;
import org.codehaus.plexus.component.annotations.Component;
import org.codehaus.plexus.component.annotations.Requirement;
import org.codehaus.plexus.logging.Logger;
import org.eclipse.tycho.buildversion.BuildTimestampProvider;

@Component ( hint = "timestamp", role = QualifierNameProvider.class )
public class TimestampNameProvider implements QualifierNameProvider
{
    @Requirement ( role = BuildTimestampProvider.class )
    protected Map<String, BuildTimestampProvider> timestampProviders;

    @Requirement
    private Logger logger;

    protected Date getBuildTimestamp ( final Configuration configuration ) throws MojoExecutionException
    {
        final String timestampProvider = getTimestampProvider ( configuration );
        this.logger.debug ( String.format ( "Using timestamp provider '%s' for %s", timestampProvider, configuration.getProject ().getId () ) );

        final BuildTimestampProvider provider = this.timestampProviders.get ( timestampProvider );
        if ( provider == null )
        {
            throw new MojoExecutionException ( "Unable to lookup BuildTimestampProvider with hint='" + timestampProvider + "'" );
        }

        return provider.getTimestamp ( configuration.getSession (), configuration.getProject (), configuration.getExecution () );
    }

    protected String getFormat ( final Configuration configuration )
    {
        return Helper.getProperty ( configuration, "buildTimestampFormat", "'v'yyyyMMdd-HHmm" );
    }

    protected String getTimestampProvider ( final Configuration configuration )
    {
        return Helper.getProperty ( configuration, "timestampProvider", "default" );
    }

    @Override
    public String createName ( final Configuration configuration ) throws MojoExecutionException
    {
        final String formatString = getFormat ( configuration );
        this.logger.debug ( "Using format string: " + formatString );

        final DateFormat format = new SimpleDateFormat ( formatString );
        format.setTimeZone ( TimeZone.getTimeZone ( "UTC" ) );
        return format.format ( getBuildTimestamp ( configuration ) );
    }
}
