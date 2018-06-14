/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.ui.project.create;

import java.util.Arrays;
import java.util.List;

public enum TargetPlatforms implements TargetPlatformProfile
{
    KEPLER ( "Eclipse Oxygen (4.7)" ) //$NON-NLS-1$
    {
        @Override
        public List<String> getRepositories ()
        {
            return Arrays.asList ( //
                    "http://download.eclipse.org/releases/oxygen", //$NON-NLS-1$
                    "http://download.eclipse.org/eclipsescada/updates/release/0.5.0/" //$NON-NLS-1$
            );
        }
    };

    private String label;

    private TargetPlatforms ( final String label )
    {
        this.label = label;
    }

    @Override
    public String getLabel ()
    {
        return this.label;
    }

}
