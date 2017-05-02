/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.lib;

import java.util.Iterator;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.scada.ae.data.Severity;
import org.eclipse.scada.configuration.world.osgi.Block;
import org.eclipse.scada.configuration.world.osgi.BooleanMonitor;
import org.eclipse.scada.configuration.world.osgi.DataMapper;
import org.eclipse.scada.configuration.world.osgi.EventLogger;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.configuration.world.osgi.ItemFeatureEntry;
import org.eclipse.scada.configuration.world.osgi.LevelMonitor;
import org.eclipse.scada.configuration.world.osgi.ManualOverride;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;
import org.eclipse.scada.configuration.world.osgi.Rounding;
import org.eclipse.scada.configuration.world.osgi.RoundingType;
import org.eclipse.scada.configuration.world.osgi.Scale;
import org.eclipse.scada.configuration.world.osgi.ValueMapper;

public class DefaultFeatures
{
    private static final class LevelCustomizer implements ItemCustomizer
    {
        private final Double value;

        private final String name;

        private final LevelMonitor template;

        private LevelCustomizer ( final String name, final Double value, final LevelMonitor template )
        {
            this.name = name;
            this.value = value;
            this.template = template;
        }

        @Override
        public void customize ( final Item item )
        {
            final LevelMonitor levelMonitor = EcoreUtil.copy ( this.template );
            levelMonitor.setName ( this.name );
            levelMonitor.setPreset ( this.value );
            registerFeature ( item, levelMonitor );
        };
    }

    public static final ItemCustomizer WRITE_LOGGER = EVENT_LOGGER ( true, true, false, false );

    public static final ItemCustomizer VALUE_LOGGER = EVENT_LOGGER ( false, false, true, false );

    public static final ItemCustomizer EVENT_LOGGER = EVENT_LOGGER ( true, true, true, true );

    public static final ItemCustomizer EVENT_LOGGER ( final boolean logWrites, final boolean logSubscriptionChange, final boolean logValueChange, final boolean logAttributesChange )
    {
        return new ItemCustomizer () {

            @Override
            public void customize ( final Item item )
            {
                final EventLogger feature = OsgiFactory.eINSTANCE.createEventLogger ();
                feature.setName ( "write.logger" );
                feature.setLogWrites ( logWrites );
                feature.setLogSubscriptionChange ( logSubscriptionChange );
                feature.setLogValueChange ( logValueChange );
                feature.setLogAttributesChange ( logAttributesChange );
                registerFeature ( item, feature );
            }
        };
    };

    public static ItemCustomizer MANUAL_OVERRIDE = MANUAL_OVERRIDE ( null );

    public static ItemCustomizer MANUAL_OVERRIDE ( final String value )
    {
        return new ItemCustomizer () {

            @Override
            public void customize ( final Item item )
            {
                final ManualOverride manualOverride = OsgiFactory.eINSTANCE.createManualOverride ();
                manualOverride.setInitialValue ( value );
                manualOverride.setName ( "local.manual" );
                registerFeature ( item, manualOverride );
            }
        };
    }

    private static LevelMonitor DEFAULT_MIN;

    private static LevelMonitor DEFAULT_MAX;

    private static LevelMonitor DEFAULT_HIGHHIGH;

    private static LevelMonitor DEFAULT_HIGH;

    private static LevelMonitor DEFAULT_LOW;

    private static LevelMonitor DEFAULT_LOWLOW;

    static
    {
        DEFAULT_MIN = OsgiFactory.eINSTANCE.createLevelMonitor ();
        DEFAULT_MIN.setCap ( true );
        DEFAULT_MIN.setLowerOk ( false );
        DEFAULT_MIN.setIncludedOk ( true );
        DEFAULT_MIN.setPrefix ( "min" );
        DEFAULT_MIN.setMonitorType ( "MIN" );
        DEFAULT_MIN.setSeverity ( Severity.ERROR );
        DEFAULT_MIN.setDemotePrefix ( "maintenance" );

        DEFAULT_MAX = OsgiFactory.eINSTANCE.createLevelMonitor ();
        DEFAULT_MAX.setCap ( true );
        DEFAULT_MAX.setLowerOk ( true );
        DEFAULT_MAX.setIncludedOk ( true );
        DEFAULT_MAX.setPrefix ( "max" );
        DEFAULT_MAX.setMonitorType ( "MAX" );
        DEFAULT_MAX.setSeverity ( Severity.ERROR );
        DEFAULT_MAX.setDemotePrefix ( "maintenance" );

        DEFAULT_HIGHHIGH = OsgiFactory.eINSTANCE.createLevelMonitor ();
        DEFAULT_HIGHHIGH.setCap ( false );
        DEFAULT_HIGHHIGH.setLowerOk ( true );
        DEFAULT_HIGHHIGH.setIncludedOk ( false );
        DEFAULT_HIGHHIGH.setPrefix ( "highhigh" );
        DEFAULT_HIGHHIGH.setMonitorType ( "HH" );
        DEFAULT_HIGHHIGH.setSeverity ( Severity.ALARM );
        DEFAULT_HIGHHIGH.setDemotePrefix ( "maintenance" );

        DEFAULT_HIGH = OsgiFactory.eINSTANCE.createLevelMonitor ();
        DEFAULT_HIGH.setCap ( false );
        DEFAULT_HIGH.setLowerOk ( true );
        DEFAULT_HIGH.setIncludedOk ( false );
        DEFAULT_HIGH.setPrefix ( "high" );
        DEFAULT_HIGH.setMonitorType ( "H" );
        DEFAULT_HIGH.setSeverity ( Severity.WARNING );
        DEFAULT_HIGH.setDemotePrefix ( "maintenance" );

        DEFAULT_LOW = OsgiFactory.eINSTANCE.createLevelMonitor ();
        DEFAULT_LOW.setCap ( false );
        DEFAULT_LOW.setLowerOk ( false );
        DEFAULT_LOW.setIncludedOk ( false );
        DEFAULT_LOW.setPrefix ( "low" );
        DEFAULT_LOW.setMonitorType ( "L" );
        DEFAULT_LOW.setSeverity ( Severity.WARNING );
        DEFAULT_LOW.setDemotePrefix ( "maintenance" );

        DEFAULT_LOWLOW = OsgiFactory.eINSTANCE.createLevelMonitor ();
        DEFAULT_LOWLOW.setCap ( false );
        DEFAULT_LOWLOW.setLowerOk ( false );
        DEFAULT_LOWLOW.setIncludedOk ( false );
        DEFAULT_LOWLOW.setPrefix ( "lowlow" );
        DEFAULT_LOWLOW.setMonitorType ( "LL" );
        DEFAULT_LOWLOW.setSeverity ( Severity.ALARM );
        DEFAULT_LOWLOW.setDemotePrefix ( "maintenance" );
    }

    public static ItemCustomizer MIN ( final Double value )
    {
        return new LevelCustomizer ( "local.level.min", value, DEFAULT_MIN );
    }

    public static ItemCustomizer MAX ( final Double value )
    {
        return new LevelCustomizer ( "local.level.max", value, DEFAULT_MAX );
    }

    public static ItemCustomizer H ( final Double value )
    {
        return new LevelCustomizer ( "local.level.high", value, DEFAULT_HIGH );
    }

    public static ItemCustomizer HH ( final Double value )
    {
        return new LevelCustomizer ( "local.level.highhigh", value, DEFAULT_HIGHHIGH );
    }

    public static ItemCustomizer L ( final Double value )
    {
        return new LevelCustomizer ( "local.level.low", value, DEFAULT_LOW );
    }

    public static ItemCustomizer LL ( final Double value )
    {
        return new LevelCustomizer ( "local.level.lowlow", value, DEFAULT_LOWLOW );
    }

    public static ItemCustomizer ASUM = ASUM ( 1 );

    public static ItemCustomizer ASUM ( final int level )
    {
        return new AttributesSummary ( level );
    }

    public static ItemCustomizer ASUM ()
    {
        return new AttributesSummary ( 1 );
    }

    public static ItemCustomizer BOOL_MONITOR ( final boolean referenceValue, final Severity severity, final boolean requireAck )
    {
        return new ItemCustomizer () {

            @Override
            public void customize ( final Item item )
            {
                final BooleanMonitor feature = OsgiFactory.eINSTANCE.createBooleanMonitor ();
                feature.setActive ( true );
                feature.setReferenceValue ( referenceValue );
                feature.setSeverity ( severity );
                feature.setRequireAck ( requireAck );
                feature.setName ( "local.bool.monitor" );
                registerFeature ( item, feature );
            }
        };
    }

    public static ItemCustomizer SCALE ( final Double factor, final Double offset )
    {
        return new ItemCustomizer () {

            @Override
            public void customize ( final Item item )
            {
                final Scale feature = OsgiFactory.eINSTANCE.createScale ();
                feature.setActive ( factor != null || offset != null );
                feature.setFactor ( factor );
                feature.setOffset ( offset );
                feature.setName ( "local.scale" );
                registerFeature ( item, feature );
            }
        };
    }

    public static ItemCustomizer ROUND ( final RoundingType type )
    {
        return new ItemCustomizer () {

            @Override
            public void customize ( final Item item )
            {
                final Rounding feature = OsgiFactory.eINSTANCE.createRounding ();
                feature.setType ( type == null ? RoundingType.NONE : type );
                feature.setName ( "local.rounding" );
                registerFeature ( item, feature );
            }
        };
    }

    public static ItemCustomizer BLOCK = BLOCK ();

    public static ItemCustomizer BLOCK ()
    {
        return new ItemCustomizer () {

            @Override
            public void customize ( final Item item )
            {
                final Block feature = OsgiFactory.eINSTANCE.createBlock ();
                feature.setName ( "local.block" );
                registerFeature ( item, feature );
            }
        };
    }

    public static void registerFeature ( final Item item, final ItemFeatureEntry feature )
    {
        final Iterator<ItemFeatureEntry> i = item.getItemFeatures ().iterator ();
        while ( i.hasNext () )
        {
            final ItemFeatureEntry entry = i.next ();
            if ( entry.getName ().equals ( feature.getName () ) )
            {
                i.remove ();
            }
        }

        item.getItemFeatures ().add ( feature );
    }

    public static ItemCustomizer MAPPER ( final DataMapper mapper, final String sourceAttribute, final String targetAttribute )
    {
        return new ItemCustomizer () {

            @Override
            public void customize ( final Item item )
            {
                final ValueMapper valueMapper = OsgiFactory.eINSTANCE.createValueMapper ();
                valueMapper.setDataMapper ( mapper );
                valueMapper.setName ( "value.mapper" );
                valueMapper.setSourceAttribute ( sourceAttribute );
                valueMapper.setTargetAttribute ( targetAttribute );
                registerFeature ( item, valueMapper );
            }
        };
    }

    public static ItemCustomizer MAPPER ( final DataMapper mapper )
    {
        return MAPPER ( mapper, null, null );
    }

}
