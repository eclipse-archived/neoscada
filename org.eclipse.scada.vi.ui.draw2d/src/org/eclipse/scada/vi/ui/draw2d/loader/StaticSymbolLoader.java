/*******************************************************************************
 * Copyright (c) 2011, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *     IBH SYSTEMS GmbH - improve implementation
 *******************************************************************************/
package org.eclipse.scada.vi.ui.draw2d.loader;

import java.net.URL;
import java.nio.charset.Charset;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.scada.vi.model.Symbol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.Resources;

public class StaticSymbolLoader implements SymbolLoader
{
    private final static Logger logger = LoggerFactory.getLogger ( StaticSymbolLoader.class );

    private final Symbol symbol;

    private final ClassLoader classLoader;

    public StaticSymbolLoader ( final Symbol symbol, final ClassLoader classLoader )
    {
        this.symbol = symbol;
        this.classLoader = classLoader;
    }

    @Override
    public String getSourceName ()
    {
        final Resource r = this.symbol.eResource ();
        if ( r != null && r.getURI () == null )
        {
            return r.getURI ().toString ();
        }
        else
        {
            return "<unknown>";
        }
    }

    @Override
    public Symbol loadSymbol ()
    {
        return this.symbol;
    }

    @Override
    public ClassLoader getClassLoader ()
    {
        return this.classLoader;
    }

    @Override
    public String resolveUri ( final String uri )
    {
        final Resource r = this.symbol.eResource ();
        if ( r == null )
        {
            return uri;
        }

        final URI u = r.getURI ();
        if ( u == null )
        {
            return uri;
        }

        logger.debug ( "Resolve - base: {}, uri: {}", u, uri );

        return URI.createURI ( uri ).resolve ( u ).toString ();
    }

    @Override
    public String loadStringResource ( final String url ) throws Exception
    {
        final String target = resolveUri ( url );
        logger.debug ( "Loading resource from: {}", target ); //$NON-NLS-1$
        return Resources.toString ( new URL ( target ), Charset.forName ( "UTF-8" ) ); //$NON-NLS-1$
    }

}
