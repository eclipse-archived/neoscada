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

import org.apache.maven.plugin.MojoExecutionException;
import org.codehaus.plexus.component.annotations.Component;

@Component ( hint = "static", role = QualifierNameProvider.class )
public class StaticNameProvider implements QualifierNameProvider
{
    @Override
    public String createName ( final Configuration configuration ) throws MojoExecutionException
    {
        return Helper.getProperty ( configuration, "staticQualifier", null );
    }
}
