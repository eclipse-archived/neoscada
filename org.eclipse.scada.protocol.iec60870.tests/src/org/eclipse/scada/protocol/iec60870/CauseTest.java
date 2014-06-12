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
package org.eclipse.scada.protocol.iec60870;

import org.eclipse.scada.protocol.iec60870.asdu.types.CauseOfTransmission;
import org.eclipse.scada.protocol.iec60870.asdu.types.Causes;
import org.eclipse.scada.protocol.iec60870.asdu.types.StandardCause;
import org.junit.Assert;
import org.junit.Test;

public class CauseTest
{
    /**
     * Plain compare
     */
    @Test
    public void test1 ()
    {
        final CauseOfTransmission cot1 = new CauseOfTransmission ( StandardCause.ACTIVATED );
        final CauseOfTransmission cot2 = new CauseOfTransmission ( StandardCause.ACTIVATED );
        final CauseOfTransmission cot3 = new CauseOfTransmission ( StandardCause.ACTIVATION_CONFIRM );

        Assert.assertEquals ( cot1, cot2 );
        Assert.assertNotEquals ( cot1, cot3 );
        Assert.assertNotEquals ( cot2, cot3 );
    }

    /**
     * Compare enum vs value
     */
    @Test
    public void test2 ()
    {
        final CauseOfTransmission cot1 = new CauseOfTransmission ( StandardCause.ACTIVATED );
        final CauseOfTransmission cot2 = new CauseOfTransmission ( Causes.valueOf ( StandardCause.ACTIVATED.getValue () ) );
        final CauseOfTransmission cot3 = new CauseOfTransmission ( Causes.valueOf ( StandardCause.ACTIVATION_CONFIRM.getValue () ) );

        Assert.assertEquals ( cot1, cot2 );
        Assert.assertNotEquals ( cot1, cot3 );
        Assert.assertNotEquals ( cot2, cot3 );
    }
}
