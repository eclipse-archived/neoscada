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

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IResource;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.scada.configuration.recipe.Definition;
import org.eclipse.scada.configuration.recipe.Profile;
import org.eclipse.scada.configuration.utils.ModelLoader;
import org.eclipse.scada.ui.utils.SelectionHelper;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.actions.CompoundContributionItem;
import org.eclipse.ui.menus.IWorkbenchContribution;
import org.eclipse.ui.services.IServiceLocator;
import org.eclipse.ui.statushandlers.StatusManager;

public class ProfilesContribution extends CompoundContributionItem implements IWorkbenchContribution
{

    private IServiceLocator serviceLocator;

    public ProfilesContribution ()
    {
    }

    public ProfilesContribution ( final String id )
    {
        super ( id );
    }

    @Override
    protected IContributionItem[] getContributionItems ()
    {
        final ISelectionService ss = (ISelectionService)this.serviceLocator.getService ( ISelectionService.class );

        if ( ss == null )
        {
            return new IContributionItem[0];
        }

        final ISelection sel = ss.getSelection ();

        final List<IContributionItem> items = new LinkedList<> ();

        addFromFileResource ( items, sel );
        /*
        addFromObject ( items, sel );
        addFromResource ( items, sel );
        */

        return items.toArray ( new IContributionItem[items.size ()] );
    }

    private void addFromFileResource ( final List<IContributionItem> defs, final ISelection sel )
    {
        final ModelLoader<Definition> loader = new ModelLoader<> ( Definition.class );

        for ( final IResource res : SelectionHelper.iterable ( sel, IResource.class ) )
        {
            try
            {
                final Definition def = loader.load ( res.getLocationURI () );
                if ( def != null )
                {
                    addDefinition ( defs, res.getParent (), def );
                }

            }
            catch ( final Exception e )
            {
                // ignore
                StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ), StatusManager.LOG );
            }
        }
    }

    /*
    private void addFromResource ( final List<IContributionItem> defs, final ISelection sel )
    {
        for ( final Resource r : SelectionHelper.iterable ( sel, Resource.class ) )
        {
            final Definition ele = (Definition)EcoreUtil.getObjectByType ( r.getContents (), RecipePackage.Literals.DEFINITION );
            if ( ele != null )
            {
                defs.add ( ele );
            }
        }
    }

    private void addFromObject ( final List<IContributionItem> defs, final ISelection sel )
    {
        for ( final Definition def : SelectionHelper.iterable ( sel, Definition.class ) )
        {
            defs.add ( def );
        }
    }
    */

    private void addDefinition ( final List<IContributionItem> items, final IContainer parent, final Definition def )
    {
        items.add ( new DefinitionContributionItem ( parent, def ) );
        for ( final Profile p : def.getProfiles () )
        {
            items.add ( new ProfileContributionItem ( parent, def, p ) );
        }
    }

    @Override
    public void initialize ( final IServiceLocator serviceLocator )
    {
        this.serviceLocator = serviceLocator;
    }

}
