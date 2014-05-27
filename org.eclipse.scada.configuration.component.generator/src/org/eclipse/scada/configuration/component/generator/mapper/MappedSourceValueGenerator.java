/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.component.generator.mapper;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.scada.configuration.component.DanglingItemReference;
import org.eclipse.scada.configuration.component.MappedSourceValue;
import org.eclipse.scada.configuration.component.generator.DataComponentGenerator;
import org.eclipse.scada.configuration.component.lib.Items;
import org.eclipse.scada.configuration.component.lib.create.CreationRequest;
import org.eclipse.scada.configuration.component.lib.create.ItemCreator;
import org.eclipse.scada.configuration.generator.FinishContext;
import org.eclipse.scada.configuration.generator.GeneratorContext.MasterContext;
import org.eclipse.scada.configuration.lib.DefaultFeatures;
import org.eclipse.scada.configuration.lib.ItemCustomizer;
import org.eclipse.scada.configuration.world.osgi.DataMapper;
import org.eclipse.scada.configuration.world.osgi.ReferenceItem;

public class MappedSourceValueGenerator extends DataComponentGenerator
{

    private final MappedSourceValue mappedSourceValue;

    public MappedSourceValueGenerator ( final MappedSourceValue mappedSourceValue )
    {
        super ( mappedSourceValue );
        this.mappedSourceValue = mappedSourceValue;
    }

    private final List<ReferenceItem> refs = new LinkedList<> ();

    @Override
    public void createItems ( final ItemCreator itemCreator )
    {
        final DanglingItemReference source = this.mappedSourceValue.getInput ().createReference ();
        final CreationRequest<ReferenceItem> c = itemCreator.createReferenceItem ( source );
        c.customizationTags ( this.mappedSourceValue.getCustomizationTags () );
        c.localTags ( this.mappedSourceValue.getName () );
        c.dataType ( this.mappedSourceValue.getDataType () );
        final ReferenceItem item = c.create ();

        this.refs.add ( item );
    }

    @Override
    protected void finishForMaster ( final FinishContext context, final MasterContext master )
    {
        super.finishForMaster ( context, master );
        for ( final ReferenceItem item : this.refs )
        {
            item.setSource ( Items.replaceDanglingReference ( this.context, master.getImplementation (), item.getSource () ) );
            final ItemCustomizer mapperFeature = DefaultFeatures.MAPPER ( context.requestMapping ( this.mappedSourceValue.getMapper (), DataMapper.class ) );
            mapperFeature.customize ( item );
        }
    }
}
