/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.memory.manager.lib;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.scada.configuration.memory.Attribute;
import org.eclipse.scada.configuration.memory.TypeDefinition;
import org.eclipse.scada.configuration.memory.TypeSystem;
import org.eclipse.scada.configuration.memory.Variable;
import org.eclipse.scada.configuration.memory.manager.MemoryManagerModule;
import org.eclipse.scada.configuration.memory.manager.MemoryManagerPackage;
import org.eclipse.scada.configuration.world.lib.oscar.OscarContext;
import org.eclipse.scada.configuration.world.lib.oscar.OscarProcessor;
import org.eclipse.scada.configuration.world.osgi.EquinoxApplication;

public class MemoryModelOscarProcessor implements OscarProcessor
{

    @Override
    public void process ( final OscarContext ctx, final EquinoxApplication application, final IProgressMonitor monitor )
    {
        try
        {
            final Collection<Object> modules = EcoreUtil.getObjectsByType ( application.getModules (), MemoryManagerPackage.Literals.MEMORY_MANAGER_MODULE );

            if ( modules.isEmpty () )
            {
                return;
            }
            if ( modules.size () > 1 )
            {
                throw new IllegalStateException ( String.format ( "There must only be one module instance of type: %s", MemoryManagerModule.class.getName () ) );
            }

            process ( ctx, application, (MemoryManagerModule)modules.iterator ().next (), monitor );
        }
        finally
        {
            monitor.done ();
        }
    }

    private void process ( final OscarContext ctx, final EquinoxApplication application, final MemoryManagerModule manager, final IProgressMonitor monitor )
    {
        final TypeSystem ts = manager.getTypeSystem ();
        if ( ts == null )
        {
            throw new IllegalStateException ( "Type system must not be null" );
        }

        final Set<String> typeNames = new HashSet<> ();
        final Set<TypeSystem> systems = new HashSet<> ();
        processSystem ( ctx, ts, systems, typeNames );
    }

    protected void processSystem ( final OscarContext ctx, final TypeSystem ts, final Set<TypeSystem> systems, final Set<String> typeNames )
    {
        if ( !systems.add ( ts ) )
        {
            throw new IllegalStateException ( String.format ( "Circualar dependency at %s discovered.", ts ) );
        }

        for ( final TypeSystem subTs : ts.getIncludes () )
        {
            processSystem ( ctx, subTs, systems, typeNames );
        }
        for ( final TypeDefinition def : ts.getTypes () )
        {
            processTypeDefinition ( ctx, ts, def, typeNames );
        }
    }

    private void processTypeDefinition ( final OscarContext ctx, final TypeSystem ts, final TypeDefinition def, final Set<String> typeNames )
    {
        final Map<String, String> data = new HashMap<> ();

        final String typeName = def.getName ();

        if ( !typeNames.add ( typeName ) )
        {
            throw new IllegalStateException ( String.format ( "Duplicate type name '%s'", typeName ) );
        }

        for ( final Variable var : def.getVariables () )
        {
            data.put ( "variable." + var.getName (), var.getType ().encode () ); //$NON-NLS-1$
            for ( final Attribute attr : var.getAttributes () )
            {
                data.put ( String.format ( "attribute.%s.%s", var.getName (), attr.getName () ), attr.getType ().encode () ); //$NON-NLS-1$
            }
        }

        ctx.addData ( "org.eclipse.scada.da.server.common.memory.types", typeName, data ); //$NON-NLS-1$
    }
}
