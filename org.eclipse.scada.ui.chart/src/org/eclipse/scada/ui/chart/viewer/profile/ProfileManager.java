/*******************************************************************************
 * Copyright (c) 2012, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - observe text label
 *******************************************************************************/
package org.eclipse.scada.ui.chart.viewer.profile;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.observable.list.ListDiff;
import org.eclipse.core.databinding.observable.list.ListDiffVisitor;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.scada.ui.chart.model.Profile;
import org.eclipse.scada.ui.chart.model.ProfileSwitcherType;
import org.eclipse.scada.ui.chart.viewer.ChartContext;
import org.eclipse.scada.ui.chart.viewer.ExtensionSpaceProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProfileManager
{

    private final static Logger logger = LoggerFactory.getLogger ( ProfileManager.class );

    private static final Comparator<? super Profile> COMPARATOR = new Comparator<Profile> () {

        @Override
        public int compare ( final Profile o1, final Profile o2 )
        {
            if ( o1.getId () == null && o2.getId () == null )
            {
                return 0;
            }
            if ( o1.getId () == null )
            {
                return -1;
            }
            return o1.getId ().compareTo ( o2.getId () );
        }

    };

    private final WritableList list;

    private ProfileSwitcherType type = ProfileSwitcherType.BUTTON;

    private final Map<String, ProfileEntry> profileEntries = new HashMap<String, ProfileEntry> ();

    private final List<Profile> profiles = new LinkedList<Profile> ();

    private Profile activeProfile;

    private final ExtensionSpaceProvider extensionSpaceProvider;

    private Composite wrapper;

    private final DataBindingContext ctx;

    private final ChartContext chartContext;

    public ProfileManager ( final DataBindingContext ctx, final Realm realm, final ExtensionSpaceProvider extensionSpaceProvider, final ChartContext chartContext )
    {
        this.ctx = ctx;
        this.extensionSpaceProvider = extensionSpaceProvider;
        this.chartContext = chartContext;
        this.list = new WritableList ( realm );
        this.list.addListChangeListener ( new IListChangeListener () {

            @Override
            public void handleListChange ( final ListChangeEvent event )
            {
                handleChange ( event.diff );
            }
        } );
    }

    public void setActiveProfile ( final Profile activeProfile )
    {
        logger.debug ( "Setting active profile: {}", activeProfile ); //$NON-NLS-1$

        if ( this.activeProfile == activeProfile )
        {
            return;
        }

        this.activeProfile = activeProfile;

        ProfileEntry selectedEntry = null;
        if ( activeProfile != null )
        {
            selectedEntry = this.profileEntries.get ( activeProfile.getId () );
        }
        else if ( this.type == ProfileSwitcherType.CHECK )
        {
            try
            {
                selectedEntry = this.profileEntries.get ( this.profiles.get ( 1 /*second one*/).getId () );
                logger.debug ( "Selected by checkbox: {}", selectedEntry );
            }
            catch ( final Exception e )
            {
                logger.warn ( "Failed to switch", e );
            }
        }

        activateEntry ( selectedEntry );
    }

    private void activateEntry ( final ProfileEntry selectedEntry )
    {
        logger.debug ( "Active entry: {}", selectedEntry );

        // first deactivate all
        for ( final ProfileEntry entry : this.profileEntries.values () )
        {
            entry.deactivate ();
        }

        // now activate the correct one
        for ( final ProfileEntry entry : this.profileEntries.values () )
        {
            if ( entry == selectedEntry )
            {
                entry.activate ();
            }
        }
        // after the profiles have changed we might have different renderers
        this.chartContext.getChartRenderer ().relayout ();
    }

    public Profile getActiveProfile ()
    {
        return this.activeProfile;
    }

    public void setType ( final ProfileSwitcherType type )
    {
        if ( this.type == type )
        {
            return;
        }

        this.type = type;
        refresh ();
    }

    public ProfileSwitcherType getType ()
    {
        return this.type;
    }

    protected void handleChange ( final ListDiff diff )
    {
        diff.accept ( new ListDiffVisitor () {

            @Override
            public void handleRemove ( final int index, final Object element )
            {
                ProfileManager.this.handleRemove ( (Profile)element );
            }

            @Override
            public void handleAdd ( final int index, final Object element )
            {
                ProfileManager.this.handleAdd ( (Profile)element );
            }
        } );
    }

    protected void handleAdd ( final Profile profile )
    {
        this.profiles.add ( profile );
        Collections.sort ( this.profiles, COMPARATOR );

        refresh ();
    }

    private void refresh ()
    {
        disposeAllEntries ();
        createAllEntries ();

        // 
        final Profile profile = this.activeProfile;
        setActiveProfile ( null );
        setActiveProfile ( profile );
    }

    private void createAllEntries ()
    {
        final Composite extensionSpace = this.extensionSpaceProvider.getExtensionSpace ();
        if ( extensionSpace == null )
        {
            return;
        }

        this.wrapper = new Composite ( extensionSpace, SWT.NONE );
        final RowLayout layout = new RowLayout ( SWT.HORIZONTAL );
        layout.marginTop = layout.marginBottom = 0;
        this.wrapper.setLayout ( layout );

        int i = 0;
        for ( final Profile profile : this.profiles )
        {
            final ProfileEntry entry = createProfileEntry ( profile, i );
            if ( entry != null )
            {
                this.profileEntries.put ( profile.getId (), entry );
            }
            i++;
        }

        final Label sep = new Label ( this.wrapper, SWT.SEPARATOR | SWT.VERTICAL );
        sep.setLayoutData ( new RowData ( SWT.DEFAULT, 20 ) );

        extensionSpace.layout ();
    }

    private ProfileEntry createProfileEntry ( final Profile profile, final int i )
    {
        switch ( this.type )
        {
            case BUTTON:
                return new ButtonProfileEntry ( this.ctx, this.wrapper, this, profile, this.chartContext );
            case RADIO:
                return new RadioProfileEntry ( this.ctx, this.wrapper, this, profile, this.chartContext );
            case CHECK:
                if ( i == 0 )
                {
                    return new CheckProfileEntry ( this.ctx, this.wrapper, this, profile, this.chartContext );
                }
                else
                {
                    // the checkbox style only allows up to two entries
                    return new ProfileEntry ( this.ctx, this, profile, this.chartContext );
                }
            default:
                return null;
        }
    }

    private void disposeAllEntries ()
    {
        for ( final ProfileEntry entry : this.profileEntries.values () )
        {
            entry.dispose ();
        }

        this.profileEntries.clear ();
        if ( this.wrapper != null )
        {
            this.wrapper.dispose ();
            this.wrapper = null;
        }
    }

    protected void handleRemove ( final Profile profile )
    {
        this.profiles.remove ( profile );
        final ProfileEntry entry = this.profileEntries.remove ( profile.getId () );
        if ( entry != null )
        {
            entry.dispose ();
        }
    }

    public void dispose ()
    {
        disposeAllEntries ();
        this.list.dispose ();
    }

    public WritableList getList ()
    {
        return this.list;
    }

}
