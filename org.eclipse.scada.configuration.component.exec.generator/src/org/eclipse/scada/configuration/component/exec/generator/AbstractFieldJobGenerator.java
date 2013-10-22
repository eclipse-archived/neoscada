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
package org.eclipse.scada.configuration.component.exec.generator;

import org.eclipse.scada.configuration.component.exec.ExecJob;
import org.eclipse.scada.configuration.component.lib.create.CreationRequest;
import org.eclipse.scada.configuration.component.lib.create.ItemCreator;
import org.eclipse.scada.configuration.generator.GenerationContext;
import org.eclipse.scada.configuration.world.osgi.DataType;
import org.eclipse.scada.configuration.world.osgi.SourceItem;
import org.eclipse.scada.da.exec.configuration.ConfigurationFactory;
import org.eclipse.scada.da.exec.configuration.FieldExtractorType;
import org.eclipse.scada.da.exec.configuration.FieldType;
import org.eclipse.scada.da.exec.configuration.VariantTypeType;

public abstract class AbstractFieldJobGenerator extends ExecJobGenerator
{

    protected static class ItemSpec
    {
        private final String extractorName;

        private final String sourcePart;

        private final DataType dataType;

        private final String[] localPart;

        private final String[] customizationTags;

        private final String description;

        private final String unit;

        protected ItemSpec ( final String extractorName, final String sourcePart, final DataType dataType, final String description, final String unit, final String[] localPart, final String[] customizationTags )
        {
            this.extractorName = extractorName;
            this.sourcePart = sourcePart;
            this.dataType = dataType;
            this.localPart = localPart.clone ();
            this.customizationTags = customizationTags.clone ();
            this.description = description;
            this.unit = unit;
        }

        public String getUnit ()
        {
            return this.unit;
        }

        public String getDescription ()
        {
            return this.description;
        }

        public String getExtractorName ()
        {
            return this.extractorName;
        }

        public String getSourcePart ()
        {
            return this.sourcePart;
        }

        public DataType getDataType ()
        {
            return this.dataType;
        }

        public String[] getLocalPart ()
        {
            return this.localPart;
        }

        public String[] getCustomizationTags ()
        {
            return this.customizationTags;
        };

        public String getFullLocal ()
        {
            return String.format ( "%s.%s", this.extractorName, this.sourcePart );
        }

    }

    private final ExecJob execJob;

    protected abstract ItemSpec[] getItems ();

    @Override
    public void createItems ( final ItemCreator itemCreator )
    {
        for ( final ItemSpec item : getItems () )
        {
            if ( item.getSourcePart () == null )
            {
                continue;
            }
            final CreationRequest<SourceItem> c = itemCreator.createSourceItem ( this.execJob.getRunsOn (), localItem ( item.getFullLocal () ) );
            c.localTags ( item.getLocalPart () ).information ( item.getDescription (), item.getUnit (), null );
            c.dataType ( item.getDataType () ).customizationTags ( item.getCustomizationTags () );
            c.create ();
        }
    }

    public AbstractFieldJobGenerator ( final ExecJob execJob )
    {
        super ( execJob );
        this.execJob = execJob;
    }

    protected void createItemFieldsFor ( final FieldExtractorType ext )
    {
        for ( final ItemSpec item : getItems () )
        {
            if ( item.getExtractorName ().equals ( ext.getName () ) )
            {
                createField ( ext, item.getSourcePart (), Helper.convert ( item.getDataType () ) );
            }
        }
    }

    protected void createField ( final FieldExtractorType ext, final String name, final VariantTypeType variantType )
    {
        final FieldType field = ConfigurationFactory.eINSTANCE.createFieldType ();

        field.setName ( name );
        field.setVariantType ( variantType );

        ext.getField ().add ( field );
    }

    protected abstract void generateExecDriverConfiguration ();

    @Override
    public void generate ( final GenerationContext context )
    {
        super.generate ( context );
        generateExecDriverConfiguration ();
    }

}