/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.lib;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.scada.configuration.world.NamedDocumentable;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.configuration.world.osgi.ItemInformation;
import org.eclipse.scada.configuration.world.osgi.SummaryGroup;
import org.eclipse.scada.utils.str.StringHelper;

public final class Names
{
    private Names ()
    {
    }

    public static final String delimiter = ".";

    public static String makeName ( final NamedDocumentable documentable )
    {
        if ( documentable.getName () != null )
        {
            return documentable.getName ();
        }
        else
        {
            return EcoreUtil.getID ( documentable );
        }
    }

    public static List<String> makeHierarchy ( SummaryGroup group )
    {
        final List<String> result = new LinkedList<> ();

        while ( group != null )
        {
            result.add ( 0, group.getName () );
            group = (SummaryGroup) ( group.eContainer () instanceof SummaryGroup ? group.eContainer () : null );
        }

        return result;
    }

    public static String makeHierarchy ( final List<String> hierarchy )
    {
        return StringHelper.join ( hierarchy, delimiter );
    }

    public static String makeId ( final SummaryGroup group )
    {
        return makeHierarchy ( makeHierarchy ( group ) );
    }

    public static List<String> makeHierarchy ( final Item item )
    {
        final ItemInformation info = item.getInformation ();
        if ( info == null )
        {
            return Collections.emptyList ();
        }

        return info.getHierarchy ();
    }
}
