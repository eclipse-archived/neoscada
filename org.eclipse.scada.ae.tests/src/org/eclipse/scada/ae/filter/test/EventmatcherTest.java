/*******************************************************************************
 * Copyright (c) 2009, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.filter.test;

import java.util.Date;
import java.util.UUID;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.Event.EventBuilder;
import org.eclipse.scada.ae.Event.Fields;
import org.eclipse.scada.ae.filter.internal.EventMatcherImpl;
import org.junit.Assert;
import org.junit.Test;

public class EventmatcherTest
{
    @Test
    public void testMatchesMultiple ()
    {
        EventMatcherImpl em = new EventMatcherImpl ( "(|(monitorType=R-L)(monitorType=R-HH))" );
        EventBuilder eb = Event.create ().id ( new UUID ( 0, 1 ) ).sourceTimestamp ( new Date () ).entryTimestamp ( new Date () );
        eb.attribute ( Fields.MONITOR_TYPE, "R-L" );
        Assert.assertTrue ( em.matches ( eb.build () ) );
    }
}
