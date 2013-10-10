/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.da.net.handler;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.OperationParameters;
import org.eclipse.scada.core.net.MessageHelper;
import org.eclipse.scada.net.base.data.MapValue;
import org.eclipse.scada.net.base.data.Message;
import org.eclipse.scada.net.base.data.StringValue;
import org.eclipse.scada.utils.lang.Holder;

public class WriteOperation
{

    /**
     * @since 1.1
     */
    public static Message create ( final String itemName, final Variant value, final OperationParameters operationParameters )
    {
        final Message message = new Message ( Messages.CC_WRITE_OPERATION );

        message.getValues ().put ( "item-name", new StringValue ( itemName ) );
        message.getValues ().put ( "value", MessageHelper.variantToValue ( value ) );

        MessageHelper.encodeOperationParameters ( operationParameters, message );

        return message;
    }

    public static void parse ( final Message message, final Holder<String> itemName, final Holder<Variant> value, final Holder<OperationParameters> operationParameters )
    {
        // FIXME: handle missing item name

        final MapValue values = message.getValues ();

        itemName.value = values.get ( "item-name" ).toString ();

        value.value = MessageHelper.valueToVariant ( values.get ( "value" ), Variant.NULL );

        operationParameters.value = MessageHelper.convertOperationParameters ( values.get ( MessageHelper.FIELD_OPERATION_PARAMETERS ) );
    }
}
