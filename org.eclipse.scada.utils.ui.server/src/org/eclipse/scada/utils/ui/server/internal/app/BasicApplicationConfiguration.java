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
package org.eclipse.scada.utils.ui.server.internal.app;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.rap.rwt.RWT;
import org.eclipse.rap.rwt.application.Application;
import org.eclipse.rap.rwt.application.Application.OperationMode;
import org.eclipse.rap.rwt.application.ApplicationConfiguration;
import org.eclipse.rap.rwt.client.WebClient;

public class BasicApplicationConfiguration implements ApplicationConfiguration
{
    @Override
    public void configure ( final Application application )
    {
        application.setOperationMode ( OperationMode.SWT_COMPATIBILITY );

        final Map<String, String> properties = new HashMap<String, String> ();
        properties.put ( WebClient.PAGE_TITLE, "Server UI" );
        application.addStyleSheet ( RWT.DEFAULT_THEME_ID, "theme/theme.css" );
        application.addEntryPoint ( "/ui", MainEntryPoint.class, properties );
    }

}
