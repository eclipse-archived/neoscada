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

import org.eclipse.scada.vi.model.Symbol;

public interface SymbolLoader
{
    public String getSourceName ();

    public Symbol loadSymbol () throws Exception;

    public ClassLoader getClassLoader ();

    public String resolveUri ( String uri );

    public String loadStringResource ( String url ) throws Exception;
}