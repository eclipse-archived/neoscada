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
package org.eclipse.scada.releng.repgen;

import java.io.File;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class B3Builder extends AbstractBuilder
{

    private static final String NS_B3AGGR = "http://www.eclipse.org/b3/2011/aggregator/1.1.0";

    private static final String NS_XMI = "http://www.omg.org/XMI";

    private final String label;

    public B3Builder ( final String label )
    {
        this.label = label;
    }

    public void addRepository ( final File dir )
    {
        //  this.repos.add ( dir );
    }

    public void build ( final File updates ) throws Exception
    {
        final Document doc = createDocument ();

        final Element a = doc.createElementNS ( NS_B3AGGR, "aggregator:Aggregation" );
        doc.appendChild ( a );
        a.setAttributeNS ( NS_XMI, "xmi:version", "2.0" );
        a.setAttribute ( "label", this.label );

        final Element vs = doc.createElementNS ( NS_B3AGGR, "validationSets" );
        a.appendChild ( vs );
        vs.setAttribute ( "label", "Validation Set" );

        addConfiguration ( a, null, null, null );
        addConfiguration ( a, null, "linux", "gtk" );
        addConfiguration ( a, "x86_64", "linux", "gtk" );
        addConfiguration ( a, "x86_64", "macosx", "cocoa" );
        addConfiguration ( a, "x86_64", null, null );

        addValidationRepository ( vs, "http://download.eclipse.org/releases/kepler" );
        final Element c = addContributions ( vs, "Eclipse SCADA" );

        addRepository ( c, "https://hudson.eclipse.org/eclipsescada/job/org.eclipse.scada.external-master/lastSuccessfulBuild/artifact/output/p2/" );

        write ( doc, new File ( updates, "composite.b3aggr" ) );
    }

    private Element addRepository ( final Element c, final String location )
    {
        final Document doc = c.getOwnerDocument ();
        final Element v = doc.createElement ( "repositories" );
        c.appendChild ( v );

        v.setAttribute ( "location", location );

        return v;
    }

    private Element addContributions ( final Element a, final String label )
    {
        final Document doc = a.getOwnerDocument ();
        final Element v = doc.createElement ( "contributions" );
        a.appendChild ( v );

        v.setAttribute ( "label", label );

        return v;
    }

    private void addValidationRepository ( final Element a, final String location )
    {
        final Document doc = a.getOwnerDocument ();
        final Element v = doc.createElement ( "validationRepositories" );
        a.appendChild ( v );

        v.setAttribute ( "location", location );
    }

    private void addContact ( final Element a, final String name, final String email )
    {
        final Document doc = a.getOwnerDocument ();
        final Element c = doc.createElement ( "contacts" );
        a.appendChild ( c );

        c.setAttribute ( "name", name );
        c.setAttribute ( "email", email );
    }

    protected void addConfiguration ( final Element a, final String arch, final String os, final String ws )
    {
        final Document doc = a.getOwnerDocument ();
        final Element c = doc.createElement ( "configurations" );
        a.appendChild ( c );

        if ( arch != null )
        {
            c.setAttribute ( "architecture", arch );
        }
        if ( os != null )
        {
            c.setAttribute ( "operatingSystem", os );
        }
        if ( ws != null )
        {
            c.setAttribute ( "windowSystem", ws );
        }
    }

}
