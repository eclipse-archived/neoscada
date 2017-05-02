/*******************************************************************************
 * Copyright (c) 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.core.ui.styles.generator;

import java.util.Set;

import org.eclipse.jface.resource.ColorDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.scada.core.ui.styles.Activator;
import org.eclipse.scada.core.ui.styles.ColorUpdater;
import org.eclipse.scada.core.ui.styles.ImageConstants;
import org.eclipse.scada.core.ui.styles.StateInformation;
import org.eclipse.scada.core.ui.styles.StateInformation.State;
import org.eclipse.scada.core.ui.styles.StyleHandler.Style;

public abstract class SimpleRuleStyleGenerator extends AbstractStyleGenerator
{

    private static final ColorDescriptor COLOR_DISCONNECTED_BG = ColorDescriptor.createFrom ( new RGB ( 233, 88, 254 ) );

    private static final ColorDescriptor COLOR_ERROR_BG = ColorDescriptor.createFrom ( new RGB ( 233, 88, 254 ) );

    private static final ColorDescriptor COLOR_ALARM_BG = ColorDescriptor.createFrom ( new RGB ( 235, 53, 37 ) );

    private static final ColorDescriptor COLOR_WARNING_BG = ColorDescriptor.createFrom ( new RGB ( 255, 222, 0 ) );

    private static final ColorDescriptor COLOR_MANUAL_BG = ColorDescriptor.createFrom ( new RGB ( 100, 149, 237 ) );

    private static final ColorDescriptor COLOR_BLOCK_FG = ColorDescriptor.createFrom ( new RGB ( 255, 255, 255 ) );

    private static final ColorDescriptor COLOR_BLOCK_BG = ColorDescriptor.createFrom ( new RGB ( 0, 0, 0 ) );

    private final LocalResourceManager resourceManager;

    private final ColorUpdater colorBgDisconnected;

    private final ColorUpdater colorBgAlarm;

    private final ColorUpdater colorBgWarning;

    private final ColorUpdater colorBgManual;

    private final ColorUpdater colorBgBlock;

    private final ColorUpdater colorFgBlock;

    private final ColorUpdater colorBgError;

    private final IPropertyChangeListener listener = new IPropertyChangeListener () {

        @Override
        public void propertyChange ( final PropertyChangeEvent event )
        {
            fireConfigurationChanged ();
        }
    };

    public SimpleRuleStyleGenerator ()
    {
        this.resourceManager = new LocalResourceManager ( JFaceResources.getResources () );

        this.colorBgDisconnected = new ColorUpdater ( "org.eclipse.scada.core.ui.styles.alarming.disconnected.bg", this.resourceManager, COLOR_DISCONNECTED_BG ); //$NON-NLS-1$
        this.colorBgError = new ColorUpdater ( "org.eclipse.scada.core.ui.styles.alarming.error.bg", this.resourceManager, COLOR_ERROR_BG ); //$NON-NLS-1$
        this.colorBgAlarm = new ColorUpdater ( "org.eclipse.scada.core.ui.styles.alarming.alarm.bg", this.resourceManager, COLOR_ALARM_BG ); //$NON-NLS-1$
        this.colorBgWarning = new ColorUpdater ( "org.eclipse.scada.core.ui.styles.alarming.warning.bg", this.resourceManager, COLOR_WARNING_BG ); //$NON-NLS-1$
        this.colorBgManual = new ColorUpdater ( "org.eclipse.scada.core.ui.styles.alarming.manual.bg", this.resourceManager, COLOR_MANUAL_BG ); //$NON-NLS-1$
        this.colorBgBlock = new ColorUpdater ( "org.eclipse.scada.core.ui.styles.alarming.block.bg", this.resourceManager, COLOR_BLOCK_BG ); //$NON-NLS-1$

        this.colorFgBlock = new ColorUpdater ( "org.eclipse.scada.core.ui.styles.alarming.block.fg", this.resourceManager, COLOR_BLOCK_FG ); //$NON-NLS-1$

        JFaceResources.getColorRegistry ().addListener ( this.listener );
    }

    protected abstract Rule[] getRules ();

    private static class Context
    {
        Set<State> states;

        Image image;

        Color background;

        Color foreground;

        boolean blink = false;

        boolean fast = true;

        boolean warningActive = false;

        boolean alarmActive = false;

        boolean errorActive = false;
    }

    public interface Rule
    {
        public void test ( Context context );
    }

    final Rule BLOCK_RULE = new Rule () {
        @Override
        public void test ( final Context context )
        {
            if ( context.states.contains ( State.BLOCK ) )
            {
                context.background = SimpleRuleStyleGenerator.this.colorBgBlock.getColor ();
                context.foreground = SimpleRuleStyleGenerator.this.colorFgBlock.getColor ();
                context.image = Activator.getDefault ().getImageRegistry ().get ( ImageConstants.IMG_BLOCK );
            }
        }
    };

    final Rule MANUAL_RULE = new Rule () {
        @Override
        public void test ( final Context context )
        {
            if ( context.states.contains ( State.MANUAL ) )
            {
                context.background = SimpleRuleStyleGenerator.this.colorBgManual.getColor ();
                context.foreground = null;
                context.image = Activator.getDefault ().getImageRegistry ().get ( ImageConstants.IMG_MANUAL );
            }
        }
    };

    final Rule WARNING_RULE = new Rule () {
        @Override
        public void test ( final Context context )
        {
            if ( context.states.contains ( State.WARNING ) )
            {
                context.warningActive = true;
                context.blink = false;
                context.background = SimpleRuleStyleGenerator.this.colorBgWarning.getColor ();
                context.foreground = null;
                context.image = Activator.getDefault ().getImageRegistry ().get ( ImageConstants.IMG_WARNING );
            }
        }
    };

    final Rule WARNING_ACK_RULE = new Rule () {
        @Override
        public void test ( final Context context )
        {
            if ( context.states.contains ( State.WARNING_ACK ) )
            {
                context.background = SimpleRuleStyleGenerator.this.colorBgWarning.getColor ();
                context.foreground = null;
                context.image = Activator.getDefault ().getImageRegistry ().get ( ImageConstants.IMG_WARNING );
                context.blink = true;
                context.fast = context.warningActive;
            }
        }
    };

    final Rule ALARM_RULE = new Rule () {
        @Override
        public void test ( final Context context )
        {
            if ( context.states.contains ( State.ALARM ) )
            {
                context.alarmActive = true;
                context.blink = false;
                context.background = SimpleRuleStyleGenerator.this.colorBgAlarm.getColor ();
                context.foreground = null;
                context.image = Activator.getDefault ().getImageRegistry ().get ( ImageConstants.IMG_ALARM );
            }
        }
    };

    final Rule ALARM_ACK_RULE = new Rule () {
        @Override
        public void test ( final Context context )
        {
            if ( context.states.contains ( State.ALARM_ACK ) )
            {
                context.background = SimpleRuleStyleGenerator.this.colorBgAlarm.getColor ();
                context.foreground = null;
                context.image = Activator.getDefault ().getImageRegistry ().get ( ImageConstants.IMG_ALARM );
                context.blink = true;
                context.fast = context.alarmActive;
            }
        }
    };

    final Rule ERROR_RULE = new Rule () {
        @Override
        public void test ( final Context context )
        {
            if ( context.states.contains ( State.ERROR ) )
            {
                context.errorActive = true;
                context.blink = false;
                context.background = SimpleRuleStyleGenerator.this.colorBgError.getColor ();
                context.foreground = null;
                context.image = Activator.getDefault ().getImageRegistry ().get ( ImageConstants.IMG_ERROR );
            }
        }
    };

    final Rule ERROR_ACK_RULE = new Rule () {
        @Override
        public void test ( final Context context )
        {
            if ( context.states.contains ( State.ERROR_ACK ) )
            {
                context.background = SimpleRuleStyleGenerator.this.colorBgError.getColor ();
                context.foreground = null;
                context.image = Activator.getDefault ().getImageRegistry ().get ( ImageConstants.IMG_ERROR );
                context.blink = true;
                context.fast = context.errorActive;
            }
        }
    };

    final Rule DISCONNECTED_RULE = new Rule () {
        @Override
        public void test ( final Context context )
        {
            if ( context.states.contains ( State.DISCONNECTED ) )
            {
                context.background = SimpleRuleStyleGenerator.this.colorBgDisconnected.getColor ();
                context.foreground = null;
                context.image = Activator.getDefault ().getImageRegistry ().get ( ImageConstants.IMG_DISCONNECTED );
            }
        }
    };

    @Override
    public Style generateStyle ( final StateInformation state )
    {
        if ( state == null )
        {
            return null;
        }

        final Context context = new Context ();

        context.states = state.getStates ();

        for ( final Rule rule : getRules () )
        {
            rule.test ( context );
        }

        if ( context.blink )
        {
            if ( context.fast )
            {
                return new Style ( new Image[] { context.image, null }, new Color[] { context.foreground, null }, new Color[] { context.background, null }, null );
            }
            else
            {
                return new Style ( new Image[] { context.image, context.image, context.image, null, null, null }, new Color[] { context.foreground, context.foreground, context.foreground, null, null, null }, new Color[] { context.background, context.background, context.background, null, null, null }, null );
            }
        }
        else
        {
            return new Style ( new Image[] { context.image }, new Color[] { context.foreground }, new Color[] { context.background }, null );
        }
    }

    @Override
    public void dispose ()
    {
        JFaceResources.getColorRegistry ().removeListener ( this.listener );
        this.resourceManager.dispose ();
    }
}