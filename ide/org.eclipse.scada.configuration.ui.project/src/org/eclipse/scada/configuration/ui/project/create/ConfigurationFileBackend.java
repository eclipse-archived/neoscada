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
package org.eclipse.scada.configuration.ui.project.create;

public class ConfigurationFileBackend extends FileBackend
{

    public ConfigurationFileBackend ()
    {
        super ( "org.eclipse.scada.ca.file", "org.eclipse.scada.ca.file.root", "${user.home}/.neoscada/ca.%s" );
    }

}
