/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.ui.project.template;

import org.eclipse.pde.ui.templates.ITemplateSection;
import org.eclipse.pde.ui.templates.NewPluginTemplateWizard;

public class PluginContentWizard extends NewPluginTemplateWizard
{

    @Override
    public ITemplateSection[] createTemplateSections ()
    {
        return createDefaultTemplateSections ();
    }

    public static ITemplateSection[] createDefaultTemplateSections ()
    {
        return new ITemplateSection[] {
                new ConnectionContextTemplate (),
                new ConnectionDefinitionsTemplate (),
                new AEViewSection (),
                new DetailViewTemplate ( "org.eclipse.scada.details.node", "node" ),
                new VIBaseTemplate ()
        };
    }

}
