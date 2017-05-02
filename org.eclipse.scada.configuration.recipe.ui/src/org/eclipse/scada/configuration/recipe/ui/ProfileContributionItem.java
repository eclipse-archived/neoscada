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
package org.eclipse.scada.configuration.recipe.ui;

import org.eclipse.core.resources.IContainer;
import org.eclipse.scada.configuration.recipe.Definition;
import org.eclipse.scada.configuration.recipe.Profile;

public class ProfileContributionItem extends DefinitionContributionItem
{

    private final Profile profile;

    public ProfileContributionItem ( final IContainer parent, final Definition definition, final Profile profile )
    {
        super ( parent, definition );
        this.profile = profile;
    }

    @Override
    protected Profile getProfile ()
    {
        return this.profile;
    }

}
