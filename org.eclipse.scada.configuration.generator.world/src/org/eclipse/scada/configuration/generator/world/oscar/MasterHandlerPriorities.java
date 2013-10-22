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
package org.eclipse.scada.configuration.generator.world.oscar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.scada.configuration.utils.ModelLoader;
import org.eclipse.scada.configuration.world.HandlerPriorityRule;
import org.eclipse.scada.configuration.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MasterHandlerPriorities
{
    private final static Logger logger = LoggerFactory.getLogger ( MasterHandlerPriorities.class );

    private static final String DEFAULT_RULES_URI = System.getProperty ( "org.eclipse.scada.configurator.generator.world.defaultMasterHandlerPrioritiesUri", "platform:/plugin/org.eclipse.scada.configuration.lib/model/defaultPriorities.eswm" );

    private final List<HandlerPriorityRule> rules;

    public MasterHandlerPriorities ( final World world )
    {
        if ( world != null && world.getOptions () != null && world.getOptions ().getMasterHandlerPriorities () != null )
        {
            logger.info ( "Using master handler priority rules from model: {}", world.getOptions ().getMasterHandlerPriorities () );
            this.rules = makeRules ( world.getOptions ().getMasterHandlerPriorities () );
        }
        else
        {
            logger.info ( "Using default master handler priority rules from {}", DEFAULT_RULES_URI );
            this.rules = makeRules ( loadDefaultRules () );
        }
    }

    private static List<HandlerPriorityRule> makeRules ( final org.eclipse.scada.configuration.world.MasterHandlerPriorities masterHandlerPriorities )
    {
        if ( masterHandlerPriorities == null )
        {
            return Collections.emptyList ();
        }

        logger.debug ( "Set has {} rules", masterHandlerPriorities.getRules ().size () );
        logger.debug ( "Name: {}", masterHandlerPriorities.getName () );
        logger.debug ( "IsProxy: {}", masterHandlerPriorities.eIsProxy () );
        logger.debug ( "Rules: {}", masterHandlerPriorities.getRules () );

        final List<HandlerPriorityRule> result = new ArrayList<> ( masterHandlerPriorities.getRules () );

        Collections.sort ( result, new Comparator<HandlerPriorityRule> () {

            @Override
            public int compare ( final HandlerPriorityRule o1, final HandlerPriorityRule o2 )
            {
                final Integer i1 = o1.getOrder ();
                final Integer i2 = o2.getOrder ();
                return i1.compareTo ( i2 );
            }
        } );

        return result;
    }

    private static org.eclipse.scada.configuration.world.MasterHandlerPriorities loadDefaultRules ()
    {
        try
        {
            return new ModelLoader<> ( org.eclipse.scada.configuration.world.MasterHandlerPriorities.class ).load ( URI.createURI ( DEFAULT_RULES_URI ) );
        }
        catch ( final IOException e )
        {
            throw new RuntimeException ( e );
        }
    }

    public int findPriority ( final String factoryId, final String configurationId )
    {
        final Integer result = findPriority ( factoryId, configurationId, null );
        if ( result != null )
        {
            return result;
        }
        throw new IllegalStateException ( String.format ( "Unable to find master handler priority for %s/%s", factoryId, configurationId ) );
    }

    public Integer findPriority ( final String factoryId, final String configurationId, final Integer defaultValue )
    {
        logger.debug ( "{} / {} - {} rules", factoryId, configurationId, this.rules.size () );

        for ( final HandlerPriorityRule rule : this.rules )
        {
            logger.debug ( "  -> {} - {}", rule.getFactoryId (), rule.getConfigurationFilter () );
            if ( rule.getFactoryId () != null && !rule.getFactoryId ().equals ( factoryId ) )
            {
                continue;
            }
            if ( rule.getConfigurationFilter () != null && !rule.getConfigurationFilter ().matcher ( configurationId ).matches () )
            {
                continue;
            }
            return rule.getPriority ();
        }
        return defaultValue;
    }
}
