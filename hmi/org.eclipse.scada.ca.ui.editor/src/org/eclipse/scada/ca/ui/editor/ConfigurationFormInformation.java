/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ca.ui.editor;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.scada.ca.ui.editor.config.form.ConfigurationForm;

public class ConfigurationFormInformation
{

    private final IConfigurationElement configuration;

    public ConfigurationFormInformation ( final IConfigurationElement configuration )
    {
        this.configuration = configuration;
    }

    public String getLabel ()
    {
        return this.configuration.getAttribute ( "label" );
    }

    public Set<String> getFactoryIds ()
    {
        final Set<String> result = new HashSet<String> ();

        // by attribute
        final String factoryId = this.configuration.getAttribute ( "factoryId" );
        if ( factoryId != null && !factoryId.isEmpty () )
        {
            result.add ( factoryId );
        }

        // by child element
        for ( final IConfigurationElement ele : this.configuration.getChildren ( "factory" ) )
        {
            if ( ele.getValue () != null && !ele.getValue ().isEmpty () )
            {
                result.add ( ele.getValue () );
            }
        }

        return result;
    }

    public ConfigurationForm create () throws CoreException
    {
        return (ConfigurationForm)this.configuration.createExecutableExtension ( "class" );
    }
}
