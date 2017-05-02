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
package org.eclipse.scada.utils.ui.server.internal.app;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.scada.utils.ui.server.internal.TreeNode;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;

public class TreeNodeLabelProvider extends ObservableMapLabelProvider implements IFontProvider
{
    private static final long serialVersionUID = 1L;

    private final TreeViewer viewer;

    private final Font font;

    private final Font defaultFont;

    public TreeNodeLabelProvider ( final TreeViewer viewer, final IObservableMap... attributeMaps )
    {
        super ( attributeMaps );
        this.viewer = viewer;

        this.defaultFont = viewer.getControl ().getFont ();

        final FontData[] fds = this.viewer.getControl ().getFont ().getFontData ();
        for ( final FontData fd : fds )
        {
            fd.setStyle ( SWT.ITALIC );
        }
        this.font = new Font ( this.viewer.getControl ().getDisplay (), fds );
    }

    @Override
    public Font getFont ( final Object element )
    {
        final TreeNode node = (TreeNode)element;
        if ( node.isProviderSet () )
        {
            return this.defaultFont;
        }
        else
        {
            return this.font;
        }
    }

    @Override
    public String getText ( final Object element )
    {
        final TreeNode node = (TreeNode)element;
        return node.getName ();
    }

    @Override
    public void dispose ()
    {
        super.dispose ();
        this.font.dispose ();
    }

}