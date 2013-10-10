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
package org.eclipse.scada.da.server.dave;

import org.eclipse.scada.utils.lang.Immutable;

@Immutable
public class BlockConfiguration
{
    private String id;

    private String name;

    private int area;

    private int block;

    private int start;

    private int count;

    private String daveDevice;

    private String type;

    private boolean enableStatistics = false;

    private long period;

    public BlockConfiguration ()
    {
    }

    public BlockConfiguration ( final String daveDevice, final String id, final String name, final String type, final int area, final int block, final int start, final int count, final boolean enableStatistics, final long period )
    {
        this.daveDevice = daveDevice;
        this.type = type;
        this.id = id;
        this.name = name;
        this.area = area;
        this.block = block;
        this.start = start;
        this.count = count;
        this.enableStatistics = enableStatistics;
        this.period = period;
    }

    public String getId ()
    {
        return this.id;
    }

    public void setId ( final String id )
    {
        this.id = id;
    }

    public String getType ()
    {
        return this.type;
    }

    public void setType ( final String type )
    {
        this.type = type;
    }

    public String getName ()
    {
        return this.name;
    }

    public void setName ( final String name )
    {
        this.name = name;
    }

    public int getArea ()
    {
        return this.area;
    }

    public void setArea ( final int area )
    {
        this.area = area;
    }

    public int getBlock ()
    {
        return this.block;
    }

    public void setBlock ( final int block )
    {
        this.block = block;
    }

    public int getStart ()
    {
        return this.start;
    }

    public void setStart ( final int start )
    {
        this.start = start;
    }

    public int getCount ()
    {
        return this.count;
    }

    public void setCount ( final int count )
    {
        this.count = count;
    }

    public String getDaveDevice ()
    {
        return this.daveDevice;
    }

    public void setDaveDevice ( final String daveDevice )
    {
        this.daveDevice = daveDevice;
    }

    @Override
    public String toString ()
    {
        return String.format ( "{device: %s, id: %s, name: %s, area: 0x%02x, block: %s, start: %s, count: %s}", this.daveDevice, this.id, this.name, this.area, this.block, this.start, this.count );
    }

    public boolean isEnableStatistics ()
    {
        return this.enableStatistics;
    }

    public void setEnableStatistics ( final boolean enableStatistics )
    {
        this.enableStatistics = enableStatistics;
    }

    public long getPeriod ()
    {
        return this.period;
    }

    public void setPeriod ( final long period )
    {
        this.period = period;
    }

}
