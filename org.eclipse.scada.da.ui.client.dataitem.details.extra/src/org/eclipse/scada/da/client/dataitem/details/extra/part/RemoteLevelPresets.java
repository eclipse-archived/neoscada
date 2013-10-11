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
package org.eclipse.scada.da.client.dataitem.details.extra.part;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.core.Variant;

public class RemoteLevelPresets extends GenericLevelPresets
{
    @Override
    protected boolean isUnsafe ( final String string )
    {
        return false;
    }

    @Override
    protected boolean isActive ( final String string )
    {
        return getBooleanAttribute ( String.format ( "remote.level.%s.active", string ) ); //$NON-NLS-1$
    }

    @Override
    protected Number getPreset ( final String string )
    {
        return getNumberAttribute ( String.format ( "remote.level.%s.preset", string ), null ); //$NON-NLS-1$
    }

    @Override
    protected boolean isAlarm ( final String string )
    {
        return getBooleanAttribute ( String.format ( "remote.level.%s.alarm", string ) ); //$NON-NLS-1$
    }

    @Override
    protected boolean isWarning ( final String string )
    {
        return getBooleanAttribute ( String.format ( "remote.level.%s.warning", string ) ); //$NON-NLS-1$
    }

    @Override
    protected boolean isAckRequired ( final String string, final String severity )
    {
        return getBooleanAttribute ( String.format ( "remote.level.%s.%s.ackRequired", string, severity ) ); //$NON-NLS-1$
    }

    @Override
    protected boolean isError ( final String string )
    {
        return getBooleanAttribute ( String.format ( "remote.level.%s.error", string ) ); //$NON-NLS-1$
    }

    @Override
    protected void setPreset ( final Variant value, final boolean active, final String tag )
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ( 2 );

        attributes.put ( String.format ( "remote.level.%s.preset", tag ), value ); //$NON-NLS-1$
        attributes.put ( String.format ( "remote.level.%s.active", tag ), active ? Variant.TRUE : Variant.FALSE ); //$NON-NLS-1$

        this.item.writeAtrtibutes ( attributes, null, makeDisplayCallback () );
    }

    @Override
    protected void setActive ( final boolean state, final String tag )
    {
        final Map<String, Variant> attributes = new HashMap<String, Variant> ( 1 );

        attributes.put ( String.format ( "remote.level.%s.active", tag ), state ? Variant.TRUE : Variant.FALSE ); //$NON-NLS-1$

        this.item.writeAtrtibutes ( attributes, null, makeDisplayCallback () );
    }

    @Override
    protected boolean isAvailable ()
    {
        return hasAttribute ( "remote.level.high.alarm" ) || hasAttribute ( "remote.level.low.alarm" ) || hasAttribute ( "remote.level.highhigh.alarm" ) || hasAttribute ( "remote.level.lowlow.alarm" );
    }

    @Override
    protected String getMinTag ()
    {
        return "floor";
    }

    @Override
    protected String getMaxTag ()
    {
        return "ceil";
    }

    @Override
    protected String getHighHighTag ()
    {
        return "highhigh";
    }

    @Override
    protected String getHighTag ()
    {
        return "high";
    }

    @Override
    protected String getLowTag ()
    {
        return "low";
    }

    @Override
    protected String getLowLowTag ()
    {
        return "lowlow";
    }

}
