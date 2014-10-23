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
package org.eclipse.scada.configuration.component.common.lib;

import static org.eclipse.scada.configuration.component.common.lib.Helper.loadResource;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.scada.configuration.component.common.ScaledValue;
import org.eclipse.scada.configuration.component.generator.AbstractDanglingGenerator;
import org.eclipse.scada.configuration.component.lib.create.CreationRequest;
import org.eclipse.scada.configuration.component.lib.create.ItemCreator;
import org.eclipse.scada.configuration.world.osgi.DataType;
import org.eclipse.scada.configuration.world.osgi.FormulaItem;
import org.eclipse.scada.configuration.world.osgi.FormulaItemInbound;
import org.eclipse.scada.configuration.world.osgi.OsgiFactory;
import org.eclipse.scada.configuration.world.osgi.TypedItemReference;
import org.eclipse.scada.utils.str.StringReplacer;

public class ScaledValueGeneratorGenerator extends AbstractDanglingGenerator
{
    private static final Pattern PATTERN = Pattern.compile ( "@@(.*?)@@" );

    private final ScaledValue generator;

    public ScaledValueGeneratorGenerator ( final ScaledValue generator )
    {
        super ( generator );
        this.generator = generator;
    }

    @Override
    public void createItems ( final ItemCreator itemCreator )
    {
        if ( this.generator.getSourceItem () == null )
        {
            throw new IllegalStateException ( "'sourceItem' not set" );
        }

        final FormulaItem item = OsgiFactory.eINSTANCE.createFormulaItem ();
        item.setScriptEngine ( "JavaScript" );

        final FormulaItemInbound inbound = OsgiFactory.eINSTANCE.createFormulaItemInbound ();

        final TypedItemReference ref = OsgiFactory.eINSTANCE.createTypedItemReference ();
        ref.setName ( "A" );
        ref.setItem ( this.generator.getSourceItem ().createReference () );
        ref.setType ( DataType.FLOAT );
        inbound.getInputs ().add ( ref );
        inbound.setInputFormula ( makeInputFormula () );

        item.setInbound ( inbound );

        final CreationRequest<FormulaItem> req = itemCreator.addItem ( item );
        req.localTags ( this.generator.getName () );
        req.dataType ( this.generator.getDataType () );
        req.customizationTags ( this.generator.getCustomizationTags () );
        req.information ( this.generator.getShortDescription (), null, null );

        createFormulaItem ( req );
    }

    private String makeInputFormula ()
    {
        final StringBuilder sb = new StringBuilder ();

        if ( this.generator.isValidateRange () )
        {
            sb.append ( loadResource ( "scaled.value.input.validate.js" ) );
        }
        sb.append ( loadResource ( "scaled.value.input.js" ) );

        final Map<String, Object> properties = new HashMap<> ();
        properties.put ( "generator", this.generator );

        return StringReplacer.replace ( sb.toString (), StringReplacer.newBeansSource ( properties ), PATTERN );
    }
}
