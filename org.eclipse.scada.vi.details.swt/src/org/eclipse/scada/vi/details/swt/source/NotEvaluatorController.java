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
package org.eclipse.scada.vi.details.swt.source;

import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.vi.data.DataValue;
import org.eclipse.scada.vi.data.SummaryInformation;

public class NotEvaluatorController implements ValueSourceController
{

    private final ValueSourceController eval;

    public NotEvaluatorController ( final ValueSourceController eval )
    {
        this.eval = eval;
    }

    @Override
    public DataItemValue value ()
    {
        final DataItemValue.Builder builder = new DataItemValue.Builder ( this.eval.value () );

        builder.setValue ( Variant.valueOf ( !builder.getValue ().asBoolean () ) );

        return builder.build ();
    }

    @Override
    public void updateData ( final Map<String, DataValue> values, final SummaryInformation state )
    {
        this.eval.updateData ( values, state );
    }

}
