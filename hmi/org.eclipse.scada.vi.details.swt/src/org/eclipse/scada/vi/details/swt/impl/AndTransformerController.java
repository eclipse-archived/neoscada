/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.details.swt.impl;

import java.util.List;
import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.data.SubscriptionState;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.vi.details.swt.source.ValueSourceController;

public class AndTransformerController extends CompositeTransformerController
{

    public AndTransformerController ( final List<ValueSourceController> values )
    {
        super ( values );
    }

    @Override
    public DataItemValue value ()
    {
        final Map<String, Variant> attributes = createAttributes ();
        final SubscriptionState state = createState ();

        for ( final ValueSourceController controller : this.values )
        {
            final DataItemValue value = controller.value ();
            if ( !value.getValue ().asBoolean () )
            {
                return new DataItemValue ( Variant.FALSE, attributes, state );
            }
        }
        return new DataItemValue ( Variant.TRUE, attributes, state );
    }

}
