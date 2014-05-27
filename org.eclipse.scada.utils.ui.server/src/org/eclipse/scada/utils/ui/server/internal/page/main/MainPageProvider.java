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
package org.eclipse.scada.utils.ui.server.internal.page.main;

import org.eclipse.scada.utils.ui.server.Page;
import org.eclipse.scada.utils.ui.server.PageProvider;
import org.eclipse.scada.utils.ui.server.internal.Properties;

public class MainPageProvider implements PageProvider
{

    @Override
    public String getName ()
    {
        return System.getProperty ( Properties.MAIN_PAGE_LABEL, "Home" );
    }

    @Override
    public String[] getPath ()
    {
        return new String[0];
    }

    @Override
    public Page createPage ()
    {
        return new MainPage ();
    }

}
