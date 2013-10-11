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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.scada.vi.model.Symbol;
import org.eclipse.scada.vi.model.VisualInterfacePackage;
import org.eclipse.scada.vi.ui.draw2d.Activator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.Resources;

public class XMISymbolLoader implements SymbolLoader
{

    private final static Logger logger = LoggerFactory.getLogger ( XMISymbolLoader.class );

    private final URI uri;

    private Symbol symbol;

    private final ClassLoader classLoader;

    public XMISymbolLoader ( final String uri )
    {
        this ( URI.createURI ( uri ) );
    }

    public XMISymbolLoader ( final URI uri )
    {
        this.uri = uri;
        this.classLoader = findClassLoader ( uri );
    }

    @Override
    public String getSourceName ()
    {
        return this.uri.toString ();
    }

    private ClassLoader findClassLoader ( final URI uri )
    {
        return Activator.class.getClassLoader ();
    }

    @Override
    public ClassLoader getClassLoader ()
    {
        return this.classLoader;
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
        logger.debug ( "Resolved URI: {} -> {}", uri, result );
        return result;
    }

    @Override
    public String loadStringResource ( final String url ) throws Exception
    {
        final URI uri = URI.createURI ( url ).resolve ( this.uri );

        logger.debug ( "Loading resource from: {}", uri );

        return Resources.toString ( new URL ( uri.toString () ), Charset.forName ( "UTF-8" ) );
    }

    protected void load () throws Exception
    {
        // register model
        VisualInterfacePackage.eINSTANCE.eClass ();

        this.symbol = null;

        final ResourceSet resourceSet = new ResourceSetImpl ();

        // set resource factory to XMI on extension map
        resourceSet.getResourceFactoryRegistry ().getExtensionToFactoryMap ().put ( "vi", new XMIResourceFactoryImpl () ); //$NON-NLS-1$

        final Resource resource = resourceSet.getResource ( this.uri, true );

        this.symbol = (Symbol)EcoreUtil.getObjectByType ( resource.getContents (), VisualInterfacePackage.Literals.SYMBOL );
    }
}
