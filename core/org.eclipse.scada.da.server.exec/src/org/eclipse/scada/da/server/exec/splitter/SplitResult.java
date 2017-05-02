/*******************************************************************************
 * Copyright (c) 2009, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.exec.splitter;

public class SplitResult
{
    private String remainingBuffer;

    private String[] lines = new String[0];

    public String getRemainingBuffer ()
    {
        return this.remainingBuffer;
    }

    public void setRemainingBuffer ( final String remainingBuffer )
    {
        this.remainingBuffer = remainingBuffer;
    }

    public String[] getLines ()
    {
        return this.lines;
    }

    public void setLines ( final String[] lines )
    {
        this.lines = lines;
    }

}
