/*******************************************************************************
 * Copyright (c) 2010, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ui.utils.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

public class ShowViewHandler extends AbstractHandler
{
    /**
     * The name of the parameter providing the view identifier.
     */
    private static final String PARAMETER_NAME_VIEW_ID = "org.eclipse.scada.ui.utils.showView.viewId"; //$NON-NLS-1$

    /**
     * Creates a new ShowViewHandler that will open the view in its default location.
     */
    public ShowViewHandler ()
    {
    }

    @Override
    public final Object execute ( final ExecutionEvent event ) throws ExecutionException
    {
        final IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked ( event );

        final Object value = event.getParameter ( PARAMETER_NAME_VIEW_ID );

        try
        {
            final String[] viewIds = ( (String)value ).split ( ":" );
            if ( viewIds.length == 1 )
            {
                openView ( viewIds[0], null, window );
            }
            else if ( viewIds.length == 2 )
            {
                openView ( viewIds[0], viewIds[1], window );
            }
        }
        catch ( final PartInitException e )
        {
            throw new ExecutionException ( "Part could not be initialized", e ); //$NON-NLS-1$
        }

        return null;
    }

    /**
     * Opens the view with the given identifier.
     * 
     * @param viewId
     *            The view to open; must not be <code>null</code>
     * @throws PartInitException
     *             If the part could not be initialized.
     */
    private final void openView ( final String viewId, final String secondaryId, final IWorkbenchWindow activeWorkbenchWindow ) throws PartInitException
    {

        final IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage ();
        if ( activePage == null )
        {
            return;
        }
        if ( secondaryId != null )
        {
            activePage.showView ( viewId, secondaryId, IWorkbenchPage.VIEW_ACTIVATE );
        }
        else
        {
            activePage.showView ( viewId );
        }

    }
}
