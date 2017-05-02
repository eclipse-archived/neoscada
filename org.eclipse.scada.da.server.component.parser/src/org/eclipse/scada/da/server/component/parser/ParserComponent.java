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
package org.eclipse.scada.da.server.component.parser;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

import org.eclipse.scada.base.extractor.extract.Extractor;
import org.eclipse.scada.base.extractor.extract.Extractor.Result;
import org.eclipse.scada.base.extractor.extract.ItemDescriptor;
import org.eclipse.scada.base.extractor.extract.ItemValue;
import org.eclipse.scada.base.extractor.input.Data;
import org.eclipse.scada.base.extractor.input.Input;
import org.eclipse.scada.base.extractor.input.Input.Listener;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.browser.common.query.GroupFolder;
import org.eclipse.scada.da.server.browser.common.query.IDNameProvider;
import org.eclipse.scada.da.server.browser.common.query.InvisibleStorage;
import org.eclipse.scada.da.server.browser.common.query.NameProvider;
import org.eclipse.scada.da.server.browser.common.query.PatternNameProvider;
import org.eclipse.scada.da.server.browser.common.query.SplitGroupProvider;
import org.eclipse.scada.da.server.browser.common.query.SplitNameProvider;
import org.eclipse.scada.da.server.common.AttributeMode;
import org.eclipse.scada.da.server.common.chain.DataItemInputChained;
import org.eclipse.scada.da.server.component.Component;
import org.eclipse.scada.da.server.component.ComponentItemFactory;
import org.eclipse.scada.da.server.component.Hive;
import org.eclipse.scada.utils.ExceptionHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ParserComponent extends Component
{
    private final static Logger logger = LoggerFactory.getLogger ( ParserComponent.class );

    private final Set<Input> inputs = new HashSet<> ();

    private final String prefix;

    private final Hive hive;

    private final InvisibleStorage storage;

    private final GroupFolder groupFolder;

    private final Map<Extractor, Map<String, DataItemInputChained>> itemCache = new HashMap<> ();

    private ComponentItemFactory itemFactory;

    private Variant lastError;

    public ParserComponent ( final Executor executor, final Hive hive, final FolderCommon folder, final String activationPrefix )
    {
        super ( executor, hive, activationPrefix );
        this.hive = hive;
        this.prefix = activationPrefix;
        this.storage = new InvisibleStorage ();

        final Pattern pattern = Pattern.compile ( Pattern.quote ( this.prefix + "." ) + "(.*)" );
        final NameProvider nameProvider = new PatternNameProvider ( new IDNameProvider (), pattern, 1 );
        final SplitGroupProvider groupProvider = new SplitGroupProvider ( nameProvider, "\\.", 0, 1 );
        this.groupFolder = new GroupFolder ( groupProvider, new SplitNameProvider ( new IDNameProvider (), "\\.", 0, 1, "." ), folder );
        this.storage.addChild ( this.groupFolder );
    }

    protected void bindInput ( final Input input, final Extractor extractor, final String prefix )
    {
        this.inputs.add ( input );
        input.addInputListener ( new Listener () {

            @Override
            public void processInput ( final Data data )
            {
                processResult ( extractor, extractor.processData ( data ), prefix );
            }
        } );
    }

    protected synchronized void processResult ( final Extractor extractor, final Result result, final String prefix )
    {
        logger.trace ( "Process result: {} from: {} ({})", result, extractor, prefix );

        try
        {
            if ( result.getError () != null )
            {
                setError ( extractor, prefix, result.getError () != null ? result.getError () : new IllegalStateException ( "No data" ), result.getItemValues () );
            }
            else
            {
                setValues ( extractor, prefix, result.getItemValues () != null ? result.getItemValues () : Collections.<ItemDescriptor, ItemValue> emptyMap () );
            }
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed process result", e );
        }
    }

    private void setError ( final Extractor extractor, final String prefix, final Throwable throwable, final Map<ItemDescriptor, ItemValue> items )
    {
        if ( this.lastError == null )
        {
            this.lastError = Variant.valueOf ( System.currentTimeMillis () );
        }

        Map<String, DataItemInputChained> cache = this.itemCache.get ( extractor );

        if ( cache == null )
        {
            cache = new HashMap<> ();
            this.itemCache.put ( extractor, cache );
        }

        // if this is the first error we might need to create the items first
        if ( items != null )
        {
            for ( final ItemDescriptor descriptor : items.keySet () )
            {
                final String localId = makeId ( prefix, descriptor.getLocalId () );
                getOrCreateItem ( extractor, prefix, cache, descriptor, localId );
            }
        }

        final Map<String, Variant> attributes = new HashMap<> ();
        attributes.put ( "parser.error", Variant.TRUE );
        attributes.put ( "parser.error.message", Variant.valueOf ( ExceptionHelper.extractMessage ( throwable ) ) );
        attributes.put ( "timestamp", this.lastError );

        // we iterate over all items now, recently created and old ones
        for ( final DataItemInputChained item : cache.values () )
        {
            item.updateData ( Variant.NULL, attributes, AttributeMode.SET );
        }
    }

    private void setValues ( final Extractor extractor, final String prefix, final Map<ItemDescriptor, ItemValue> itemValues )
    {
        this.lastError = null;

        Map<String, DataItemInputChained> cache = this.itemCache.get ( extractor );
        if ( cache == null )
        {
            cache = new HashMap<> ();
            this.itemCache.put ( extractor, cache );
        }

        final Set<String> keys = new HashSet<> ( cache.keySet () );

        for ( final Map.Entry<ItemDescriptor, ItemValue> entry : itemValues.entrySet () )
        {
            final String localId = makeId ( prefix, entry.getKey ().getLocalId () );

            final DataItemInputChained item = getOrCreateItem ( extractor, prefix, cache, entry.getKey (), localId );
            keys.remove ( localId );
            item.updateData ( entry.getValue ().getValue (), entry.getValue ().getAttributes (), AttributeMode.SET );
        }

        // remove remaining items
        for ( final String remove : keys )
        {
            disposeItem ( extractor, remove );
        }
    }

    private DataItemInputChained getOrCreateItem ( final Extractor extractor, final String prefix, final Map<String, DataItemInputChained> cache, final ItemDescriptor descriptor, final String localId )
    {
        DataItemInputChained item = cache.get ( localId );
        if ( item == null )
        {
            item = createItem ( extractor, prefix, descriptor );
        }
        return item;
    }

    private void disposeItem ( final Extractor extractor, final String localId )
    {
        logger.debug ( "Dispose item: {}", localId );

        final Map<String, DataItemInputChained> cache = this.itemCache.get ( extractor );
        final DataItemInputChained item = cache.remove ( localId );
        if ( item == null )
        {
            logger.debug ( "Item not found" );
            return;
        }

        this.storage.removed ( new org.eclipse.scada.da.server.browser.common.query.ItemDescriptor ( item, null ) );
        this.itemFactory.disposeItem ( localId );
    }

    private DataItemInputChained createItem ( final Extractor extractor, final String prefix, final ItemDescriptor descriptor )
    {
        final String localId = makeId ( prefix, descriptor.getLocalId () );
        final DataItemInputChained item = this.itemFactory.createInput ( localId, descriptor.getAttributes () );

        Map<String, DataItemInputChained> cache = this.itemCache.get ( extractor );
        if ( cache == null )
        {
            cache = new HashMap<> ();
            this.itemCache.put ( extractor, cache );
        }

        cache.put ( localId, item );
        this.storage.added ( new org.eclipse.scada.da.server.browser.common.query.ItemDescriptor ( item, descriptor.getAttributes () ) );
        return item;
    }

    private String makeId ( final String prefix, final String localId )
    {
        if ( prefix != null )
        {
            return prefix + "." + localId;
        }
        else
        {
            return localId;
        }
    }

    @Override
    protected void performStart ()
    {
        this.itemFactory = new ComponentItemFactory ( this.hive, this.storage, this.prefix );
        for ( final Input input : this.inputs )
        {
            logger.debug ( "Starting input: {}", input );
            input.start ();
        }
    }

    @Override
    protected void performStop ()
    {
        for ( final Input input : this.inputs )
        {
            logger.debug ( "Stopping input: {}", input );
            input.stop ();
        }
        this.storage.clear ();
        this.itemFactory.dispose ();
        this.itemCache.clear ();
    }

}
