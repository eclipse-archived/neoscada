/*******************************************************************************
 * Copyright (c) 2011, 2016 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *     IBH SYSTEMS GmbH - minor cleanups
 *******************************************************************************/
package org.eclipse.scada.vi.ui.draw2d.loader;

import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.scada.vi.model.Symbol;
import org.eclipse.scada.vi.model.VisualInterfacePackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.Resources;

public class XMISymbolLoader implements SymbolLoader
{
    private final static Logger logger = LoggerFactory.getLogger ( XMISymbolLoader.class );

    private static final XMIResourceFactoryImpl FACTORY_INSTANCE = new XMIResourceFactoryImpl ();

    private final URI uri;

    private Symbol symbol;

    public XMISymbolLoader ( final String uri )
    {
        this ( URI.createURI ( uri ) );
    }

    public XMISymbolLoader ( final URI uri )
    {
        this.uri = uri;
    }

    @Override
    public String getSourceName ()
    {
        return this.uri.toString ();
    }

    @Override
    public Symbol loadSymbol () throws Exception
    {
        if ( this.symbol == null )
        {
            load ();
            if ( this.symbol == null )
            {
                throw new IllegalStateException ( String.format ( "Resource '%s' did not contain a symbol", this.uri ) );
            }
        }
        return this.symbol;
    }

    @Override
    public String resolveUri ( final String uri )
    {
        final String result = URI.createURI ( uri ).resolve ( this.uri ).toString ();
        logger.debug ( "Resolved URI: {} -> {}", uri, result ); //$NON-NLS-1$
        return result;
    }

    @Override
    public String loadStringResource ( final String url ) throws Exception
    {
        final String target = resolveUri ( url );
        logger.debug ( "Loading resource from: {}", target ); //$NON-NLS-1$
        return Resources.toString ( new URL ( target ), StandardCharsets.UTF_8 );
    }

    protected void load () throws Exception
    {
        // register model
        VisualInterfacePackage.eINSTANCE.eClass ();

        this.symbol = null;

        final ResourceSet resourceSet = new ResourceSetImpl ();

        // set resource factory to XMI on extension map
        resourceSet.getResourceFactoryRegistry ().getExtensionToFactoryMap ().put ( "vi", FACTORY_INSTANCE ); //$NON-NLS-1$

        final Resource resource = resourceSet.getResource ( this.uri, true );

        this.symbol = (Symbol)EcoreUtil.getObjectByType ( resource.getContents (), VisualInterfacePackage.Literals.SYMBOL );
    }
}
