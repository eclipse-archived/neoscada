/*******************************************************************************
 * Copyright (c) 2009, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.ui.client.signalgenerator;

import org.eclipse.scada.da.ui.client.signalgenerator.page.GeneratorPage;

public class GeneratorPageInformation
{
    private GeneratorPage generatorPage;

    private String sortKey;

    private String label;

    public GeneratorPage getGeneratorPage ()
    {
        return this.generatorPage;
    }

    public void setGeneratorPage ( final GeneratorPage generatorPage )
    {
        this.generatorPage = generatorPage;
    }

    public String getSortKey ()
    {
        return this.sortKey;
    }

    public void setSortKey ( final String sortKey )
    {
        this.sortKey = sortKey;
    }

    public String getLabel ()
    {
        return this.label;
    }

    public void setLabel ( final String label )
    {
        this.label = label;
    }

}
