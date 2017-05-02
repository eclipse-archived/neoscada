/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.details.swt.impl.tab;

import java.util.Collections;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Item;
import org.eclipse.scada.core.ui.styles.StateStyler;
import org.eclipse.scada.core.ui.styles.StyleBlinker;
import org.eclipse.scada.core.ui.styles.StyleBlinker.CurrentStyle;
import org.eclipse.scada.vi.data.DataValue;
import org.eclipse.scada.vi.data.SummaryInformation;
import org.eclipse.scada.vi.data.SummaryListener;
import org.eclipse.scada.vi.data.SummaryProvider;
import org.eclipse.scada.vi.data.SummaryStateInformation;
import org.eclipse.scada.vi.details.swt.Activator;
import org.eclipse.scada.vi.details.swt.impl.tab.TabProvider.Folder;

public abstract class BaseFolderImplementation implements SummaryListener, Folder
{

    private SummaryProvider summaryProvider;

    protected SummaryInformation summaryInformation;

    protected StateStyler styler;

    protected final int index;

    private final String label;

    private StyleBlinker blinker;

    private Boolean visible;

    private final MenuManager mgr;

    private final Action dumpAction;

    private final ActionContributionItem contribution;

    public BaseFolderImplementation ( final int index, final String label, final MenuManager mgr )
    {
        this.summaryInformation = new SummaryInformation ( Collections.<String, DataValue> emptyMap () );
        this.index = index;
        this.label = label;
        this.mgr = mgr;

        this.dumpAction = new Action ( "Dump summaries for: " + this.label ) {
            @Override
            public void run ()
            {
                BaseFolderImplementation.this.summaryInformation.dump ( System.out );
            };
        };
        this.contribution = new ActionContributionItem ( this.dumpAction );
    }

    protected void addMenu ()
    {
        if ( !Boolean.getBoolean ( "vi.debug" ) )
        {
            return;
        }

        this.mgr.add ( this.contribution );
        this.mgr.update ();
    }

    protected void removeMenu ()
    {
        this.mgr.remove ( this.contribution );
        this.mgr.update ();
    }

    @Override
    public void setSummaryProvider ( final SummaryProvider summaryProvider )
    {
        this.summaryProvider = summaryProvider;
        summaryProvider.addSummaryListener ( this );
    }

    @Override
    public void summaryChanged ( final SummaryInformation summaryInformation )
    {
        this.summaryInformation = summaryInformation;
        if ( this.styler != null )
        {
            this.styler.style ( new SummaryStateInformation ( summaryInformation ) );
        }
    }

    @Override
    public void dispose ()
    {
        this.summaryProvider.removeSummaryListener ( this );
    }

    protected void useItem ( final Item item )
    {
        if ( this.label != null )
        {
            item.setText ( this.label );
        }
        item.setImage ( getEmptyImage () );

        this.blinker = new StyleBlinker () {

            @Override
            public void update ( final CurrentStyle currentStyle )
            {
                if ( !item.isDisposed () )
                {
                    updateItem ( item, currentStyle );
                }
            }
        };
        this.styler = new StateStyler ( this.blinker );
        this.styler.style ( new SummaryStateInformation ( this.summaryInformation ) );
    }

    protected void updateItem ( final Item item, final CurrentStyle currentStyle )
    {
        if ( currentStyle.image != null )
        {
            item.setImage ( currentStyle.image );
        }
        else
        {
            item.setImage ( getEmptyImage () );
        }
    }

    private Image getEmptyImage ()
    {
        return Activator.getDefault ().getImageRegistry ().get ( Activator.IMG_EMPTY );
    }

    @Override
    public void setVisible ( final boolean visible )
    {
        if ( this.visible != null && this.visible == visible )
        {
            return;
        }

        if ( visible )
        {
            show ();
        }
        else
        {
            hide ();
        }
    }

    protected void hide ()
    {
        this.visible = false;
        this.styler.dispose ();
        this.blinker.dispose ();
        removeMenu ();
    }

    protected void show ()
    {
        this.visible = true;
        addMenu ();
    }
}
