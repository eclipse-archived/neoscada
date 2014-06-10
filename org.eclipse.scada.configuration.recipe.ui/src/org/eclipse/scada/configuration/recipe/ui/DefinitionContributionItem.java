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

import java.net.URISyntaxException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.ContributionItem;
import org.eclipse.scada.configuration.recipe.Definition;
import org.eclipse.scada.configuration.recipe.Profile;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.statushandlers.StatusManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefinitionContributionItem extends ContributionItem
{
    private final static Logger logger = LoggerFactory.getLogger ( DefinitionContributionItem.class );

    private final Definition definition;

    private final IContainer parent;

    public DefinitionContributionItem ( final IContainer parent, final Definition definition )
    {
        this.parent = parent;
        this.definition = definition;
    }

    @Override
    public void fill ( final org.eclipse.swt.widgets.Menu menu, final int index )
    {
        final MenuItem item = new MenuItem ( menu, SWT.NONE, index );

        final Profile profile = getProfile ();

        final String name = this.definition.getName () == null ? "<unnamed>" : this.definition.getName ();
        String profileName = profile != null ? profile.getName () : "default";
        if ( profileName == null )
        {
            profileName = "<unnamed>";
        }

        item.setText ( String.format ( "Run %s (%s)", name, profileName ) );

        item.addSelectionListener ( new SelectionAdapter () {
            @Override
            public void widgetSelected ( final SelectionEvent evt )
            {
                try
                {
                    run ( name );
                }
                catch ( final Exception e )
                {
                    logger.warn ( "Failed to run", e );
                    StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ), StatusManager.BLOCK );
                }
            }
        } );
    }

    protected Profile getProfile ()
    {
        return null;
    }

    protected void run ( final String name ) throws URISyntaxException
    {
        final WorkspaceJob job = new WorkspaceJob ( String.format ( "Run recipe: %s", name ) ) {

            @Override
            public IStatus runInWorkspace ( final IProgressMonitor monitor ) throws CoreException
            {
                try
                {
                    RecipeHelper.processFile ( DefinitionContributionItem.this.parent, DefinitionContributionItem.this.definition, getProfile (), monitor );
                }
                catch ( final Exception e )
                {
                    logger.warn ( "Failed to process", e );
                    return StatusHelper.convertStatus ( Activator.PLUGIN_ID, e );
                }
                return Status.OK_STATUS;
            }
        };
        job.setUser ( true );
        job.setSystem ( false );
        job.schedule ();
    }
}