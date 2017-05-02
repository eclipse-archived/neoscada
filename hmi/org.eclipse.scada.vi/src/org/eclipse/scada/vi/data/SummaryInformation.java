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
package org.eclipse.scada.vi.data;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.scada.da.client.DataItemValue;
import org.eclipse.scada.core.ui.styles.StateInformation;

public class SummaryInformation
{

    private final Map<String, DataValue> data;

    private final Collection<SummaryInformation> childData;

    private final List<String> nameHierarchy;

    public SummaryInformation ( final List<String> nameHierarchy, final Map<String, DataValue> data, final Collection<SummaryInformation> childData )
    {
        this.nameHierarchy = nameHierarchy;
        this.data = data;
        this.childData = childData == null ? Collections.<SummaryInformation> emptyList () : childData;
    }

    public SummaryInformation ( final Map<String, DataValue> data )
    {
        this ( Collections.<String> emptyList (), data, Collections.<SummaryInformation> emptyList () );
    }

    public boolean isValid ()
    {
        for ( final Map.Entry<String, DataValue> entry : this.data.entrySet () )
        {
            if ( entry.getValue () == null || entry.getValue ().isIgnoreSummary () )
            {
                continue;
            }

            final DataItemValue value = entry.getValue ().getValue ();
            if ( value == null || !value.isConnected () || value.isError () || value.getValue () == null || value.getValue ().isNull () && entry.getValue ().isNullInvalid () )
            {
                return false;
            }
        }

        for ( final SummaryInformation child : this.childData )
        {
            if ( !child.isValid () )
            {
                return false;
            }
        }

        return true;
    }

    public boolean isConnected ()
    {
        for ( final Map.Entry<String, DataValue> entry : this.data.entrySet () )
        {
            if ( entry.getValue () == null || entry.getValue ().isIgnoreSummary () )
            {
                continue;

            }
            if ( !entry.getValue ().getValue ().isConnected () )
            {
                return false;
            }
        }

        for ( final SummaryInformation child : this.childData )
        {
            if ( !child.isConnected () )
            {
                return false;
            }
        }

        return true;
    }

    public boolean isError ()
    {
        return isAttribute ( "error", false );
    }

    public boolean isAlarm ()
    {
        return isAttribute ( "alarm", false );
    }

    public boolean isWarning ()
    {
        return isAttribute ( "warning", false );
    }

    public boolean isManual ()
    {
        return isAttribute ( "manual", false );
    }

    public boolean isBlocked ()
    {
        return isAttribute ( "blocked", false );
    }

    public boolean isAckRequired ( final String severity )
    {
        return isAttribute ( severity + ".ackRequired", false );
    }

    public boolean isAttribute ( final String attributeName, final boolean defaultValue )
    {
        for ( final DataValue value : this.data.values () )
        {
            if ( value == null || value.getValue () == null || value.isIgnoreSummary () )
            {
                continue;
            }

            if ( value.getValue ().isAttribute ( attributeName, defaultValue ) )
            {
                return true;
            }
        }

        for ( final SummaryInformation child : this.childData )
        {
            if ( child.isAttribute ( attributeName, defaultValue ) )
            {
                return true;
            }
        }
        return false;
    }

    public StateInformation getStateInformation ()
    {
        return new SummaryStateInformation ( this );
    }

    @Override
    public String toString ()
    {
        final StringBuilder sb = new StringBuilder ();

        sb.append ( "[attrs: " + this.data.size () );
        sb.append ( ", childs: " + this.childData.size () );

        sb.append ( ", valid: " + isValid () );

        sb.append ( ", error: " + isError () );
        sb.append ( ", alarm: " + isAlarm () );
        sb.append ( ", manual: " + isManual () );
        sb.append ( ", blocked: " + isBlocked () );

        sb.append ( "]" );

        return sb.toString ();
    }

    public void dump ( final PrintStream out )
    {
        dump ( "", out );
    }

    private static String PAD = "   ";

    protected void dump ( final String in, final PrintStream out )
    {
        out.println ( in + PAD + "name: " + this.nameHierarchy );
        out.print ( in + PAD + "valid: " + isValid () );
        out.print ( ", connected: " + isConnected () );
        out.print ( ", error: " + isError () );
        out.print ( ", alarm: " + isAlarm () );
        out.print ( ", warning: " + isWarning () );
        out.print ( ", manual: " + isManual () );
        out.print ( ", blocked: " + isBlocked () );
        out.println ();
        if ( !this.data.isEmpty () )
        {
            out.println ( in + PAD + "data:" );
            for ( final Map.Entry<String, DataValue> entry : this.data.entrySet () )
            {
                out.print ( in + PAD + PAD + entry.getKey () + "=>" );
                entry.getValue ().dump ( out );
                out.println ();
            }
        }
        if ( !this.childData.isEmpty () )
        {
            out.println ( in + PAD + "children:" );
            for ( final SummaryInformation child : this.childData )
            {
                child.dump ( in + PAD + PAD, out );
            }
        }
    }
}
