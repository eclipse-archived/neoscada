/*******************************************************************************
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ui.singleviewer.app;

import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.actions.ContributionItemFactory;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor
{
    private IWorkbenchAction exitAction;

    private IWorkbenchAction aboutAction;

    private IWorkbenchAction newWindowAction;

    private IContributionItem showViews;

    private IContributionItem newWizards;

    public ApplicationActionBarAdvisor ( final IActionBarConfigurer configurer )
    {
        super ( configurer );
    }

    @Override
    protected void makeActions ( final IWorkbenchWindow window )
    {
        this.exitAction = ActionFactory.QUIT.create ( window );
        register ( this.exitAction );

        this.aboutAction = ActionFactory.ABOUT.create ( window );
        register ( this.aboutAction );

        this.newWindowAction = ActionFactory.OPEN_NEW_WINDOW.create ( window );
        register ( this.newWindowAction );

        register ( ActionFactory.NEW_WIZARD_DROP_DOWN.create ( window ) );
        register ( ActionFactory.NEW.create ( window ) );
        register ( ActionFactory.INTRO.create ( window ) );
        register ( ActionFactory.SAVE.create ( window ) );

        this.showViews = ContributionItemFactory.VIEWS_SHORTLIST.create ( window );
        this.newWizards = ContributionItemFactory.NEW_WIZARD_SHORTLIST.create ( window );

        register ( ActionFactory.NEW_EDITOR.create ( window ) );
        register ( ActionFactory.PREFERENCES.create ( window ) );
    }

    @Override
    protected void fillMenuBar ( final IMenuManager menuBar )
    {
        final MenuManager fileMenu = new MenuManager ( "&File", IWorkbenchActionConstants.M_FILE );
        final MenuManager windowMenu = new MenuManager ( "&Window", IWorkbenchActionConstants.M_WINDOW );
        final MenuManager helpMenu = new MenuManager ( "&Help", IWorkbenchActionConstants.M_HELP );
        final MenuManager fileNewMenu = new MenuManager ( "&New", IWorkbenchActionConstants.NEW_EXT );
        final MenuManager windowNewMenu = new MenuManager ( "Show &View", IWorkbenchActionConstants.SHOW_EXT );

        menuBar.add ( fileMenu );
        // Add a group marker indicating where action set menus will appear.
        menuBar.add ( new GroupMarker ( IWorkbenchActionConstants.MB_ADDITIONS ) );
        menuBar.add ( windowMenu );
        menuBar.add ( helpMenu );

        // File
        fileMenu.add ( this.newWindowAction );
        fileMenu.add ( new Separator () );
        fileMenu.add ( fileNewMenu );
        fileMenu.add ( getAction ( ActionFactory.SAVE.getId () ) );
        fileMenu.add ( getAction ( ActionFactory.NEW_EDITOR.getId () ) );
        fileMenu.add ( new GroupMarker ( IWorkbenchActionConstants.OPEN_EXT ) );

        fileMenu.add ( new Separator () );
        fileMenu.add ( this.exitAction );

        fileNewMenu.add ( this.newWizards );

        // Window
        windowNewMenu.add ( this.showViews );
        windowMenu.add ( windowNewMenu );
        windowMenu.add ( getAction ( ActionFactory.PREFERENCES.getId () ) );

        // Help
        helpMenu.add ( this.aboutAction );
        helpMenu.add ( getAction ( ActionFactory.INTRO.getId () ) );
    }

}
