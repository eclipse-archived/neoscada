package org.eclipse.scada.configuration.component.generator.global;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.Status;
import org.eclipse.scada.configuration.component.Component;
import org.eclipse.scada.configuration.component.generator.util.Components;
import org.eclipse.scada.configuration.component.lib.create.AbstractComponentItemCreator;
import org.eclipse.scada.configuration.component.lib.create.MasterListener;
import org.eclipse.scada.configuration.item.CustomizationRequest;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CaptureItemCreatorImpl extends AbstractComponentItemCreator
{

    private final static Logger logger = LoggerFactory.getLogger ( CaptureItemCreatorImpl.class );

    public static class ItemCreation
    {
        private final Item item;

        private final CustomizationRequest customizationRequest;

        public ItemCreation ( final Item item, final CustomizationRequest customizationRequest )
        {
            this.item = item;
            this.customizationRequest = customizationRequest;
        }

        public Item getItem ()
        {
            return this.item;
        }

        public CustomizationRequest getCustomizationRequest ()
        {
            return this.customizationRequest;
        }
    }

    private final Map<List<String>, ItemCreation> entries;

    public CaptureItemCreatorImpl ( final Component component, final Map<List<String>, ItemCreation> entries )
    {
        super ( component );
        this.entries = entries;
    }

    @Override
    public void createMarker ( final Status status )
    {
        // TODO: add real UI marker
    }

    @Override
    protected <T extends Item> void itemAdded ( final T item, final CustomizationRequest customizationRequest, final List<String> originalLocalTags, final Set<MasterListener<T>> masterListeners )
    {
        logger.debug ( "Adding item: {}", item );
        this.entries.put ( new ArrayList<String> ( originalLocalTags ), new ItemCreation ( item, customizationRequest ) );
    }

    @Override
    protected void customizeItem ( final Item item, final CustomizationRequest customizationRequest )
    {
        Components.customizeItem ( this.component, item, customizationRequest );
    }
}