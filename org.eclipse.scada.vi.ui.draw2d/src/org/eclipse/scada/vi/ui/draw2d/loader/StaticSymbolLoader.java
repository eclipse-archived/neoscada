/*******************************************************************************
 * Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.vi.ui.draw2d.loader;

import java.net.URL;
import java.nio.charset.Charset;

import org.eclipse.scada.vi.model.Symbol;

import com.google.common.io.Resources;

public class StaticSymbolLoader implements SymbolLoader
{
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
        return "<unknown>";
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
        return uri;
    }

    @Override
    public String loadStringResource ( final String url ) throws Exception
    {
        return Resources.toString ( new URL ( url ), Charset.forName ( "UTF-8" ) );
    }
}
