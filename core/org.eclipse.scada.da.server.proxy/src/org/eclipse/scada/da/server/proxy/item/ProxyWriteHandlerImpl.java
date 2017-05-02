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
package org.eclipse.scada.da.server.proxy.item;

import java.util.Collections;
import java.util.Map;

import org.eclipse.scada.core.OperationException;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.core.client.NoConnectionException;
import org.eclipse.scada.core.server.OperationParameters;
import org.eclipse.scada.core.server.OperationParametersHelper;
import org.eclipse.scada.da.client.WriteAttributeOperationCallback;
import org.eclipse.scada.da.client.WriteOperationCallback;
import org.eclipse.scada.da.core.WriteAttributeResult;
import org.eclipse.scada.da.core.WriteAttributeResults;
import org.eclipse.scada.da.server.proxy.connection.ProxySubConnection;
import org.eclipse.scada.da.server.proxy.utils.ProxyPrefixName;
import org.eclipse.scada.da.server.proxy.utils.ProxySubConnectionId;
import org.eclipse.scada.da.server.proxy.utils.ProxyUtils;
import org.eclipse.scada.utils.concurrent.AbstractFuture;

public class ProxyWriteHandlerImpl extends ProxyItemSupport implements ProxyWriteHandler
{
    public static class AttributeResultHandler extends AbstractFuture<WriteAttributeResults> implements WriteAttributeOperationCallback
    {
        @Override
        public void failed ( final String error )
        {
            setError ( new RuntimeException ( error ).fillInStackTrace () );
        }

        @Override
        public void error ( final Throwable e )
        {
            setError ( e );
        }

        @Override
        public void complete ( final WriteAttributeResults result )
        {
            setResult ( result );
        }
    }

    public static class ValueResultHandler extends AbstractFuture<Void> implements WriteOperationCallback
    {
        @Override
        public void failed ( final String error )
        {
            setError ( new RuntimeException ( error ).fillInStackTrace () );
        }

        @Override
        public void error ( final Throwable e )
        {
            setError ( e );
        }

        @Override
        public void complete ()
        {
            setResult ( null );
        }
    }

    protected final Map<ProxySubConnectionId, ProxySubConnection> subConnections;

    public ProxyWriteHandlerImpl ( final String separator, final ProxyPrefixName prefix, final Map<ProxySubConnectionId, ProxySubConnection> subConnections, final ProxySubConnectionId currentConnection, final String proxyItemId )
    {
        super ( separator, prefix, currentConnection, proxyItemId );
        this.subConnections = Collections.unmodifiableMap ( subConnections );
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.da.server.proxy.ProxyWriteHandler#write(java.lang.String, org.eclipse.scada.core.Variant)
     */
    @Override
    public void write ( final String itemId, final Variant value, final OperationParameters operationParameters ) throws NoConnectionException, OperationException
    {
        final ProxySubConnection subConnection = this.subConnections.get ( this.currentConnection );
        final String actualItemId = ProxyUtils.originalItemId ( itemId, this.separator, this.prefix, subConnection.getPrefix () );

        final ValueResultHandler callback = new ValueResultHandler ();
        subConnection.getConnection ().write ( actualItemId, value, OperationParametersHelper.toData ( operationParameters ), callback );
        try
        {
            callback.get ();
        }
        catch ( final Exception e )
        {
            throw new OperationException ( e );
        }
    }

    /* (non-Javadoc)
     * @see org.eclipse.scada.da.server.proxy.ProxyWriteHandler#writeAttributes(java.lang.String, java.util.Map, org.eclipse.scada.da.core.WriteAttributeResults)
     */
    @Override
    public void writeAttributes ( final String itemId, final Map<String, Variant> attributes, final WriteAttributeResults writeAttributeResults, final OperationParameters operationParameters )
    {
        final ProxySubConnection subConnection = this.subConnections.get ( this.currentConnection );
        final String actualItemId = ProxyUtils.originalItemId ( itemId, this.separator, this.prefix, subConnection.getPrefix () );

        final AttributeResultHandler callback = new AttributeResultHandler ();

        WriteAttributeResults actualWriteAttributeResults;
        try
        {
            subConnection.getConnection ().writeAttributes ( actualItemId, attributes, OperationParametersHelper.toData ( operationParameters ), callback );
            actualWriteAttributeResults = callback.get ();
        }
        catch ( final Exception e )
        {
            actualWriteAttributeResults = attributesCouldNotBeWritten ( attributes, e );
        }
        writeAttributeResults.putAll ( actualWriteAttributeResults );
    }

    /**
     * creates a WriteAttributeResults object for given attributes filled
     * with given exception for each attribute
     * 
     * @param attributes
     * @param e
     * @return
     */
    private WriteAttributeResults attributesCouldNotBeWritten ( final Map<String, Variant> attributes, final Exception e )
    {
        final WriteAttributeResults results = new WriteAttributeResults ();
        for ( final String name : attributes.keySet () )
        {
            results.put ( name, new WriteAttributeResult ( e ) );
        }
        return results;
    }

}
