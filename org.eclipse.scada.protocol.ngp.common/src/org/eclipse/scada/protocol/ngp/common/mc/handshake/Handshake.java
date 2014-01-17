/*******************************************************************************
 * Copyright (c) 2010, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - implement security callback system
 *     IBH SYSTEMS GmbH - add documentation
 *******************************************************************************/

package org.eclipse.scada.protocol.ngp.common.mc.handshake;

import java.util.Map;

import org.eclipse.scada.protocol.ngp.common.mc.message.AcceptMessage;
import org.eclipse.scada.protocol.ngp.common.mc.message.HelloMessage;
import org.eclipse.scada.protocol.ngp.common.mc.message.StartMessage;

/**
 * A handshake module which will take part on the message channel setup
 * procedure
 * 
 * @author Jens Reimann
 */
public interface Handshake
{
    /**
     * Called by the client, putting together all properties for the
     * {@link HelloMessage}
     * 
     * @param context
     *            the handshake context
     * @param helloProperties
     *            the properties to fill
     */
    public void request ( HandshakeContext context, Map<String, String> helloProperties );

    /**
     * Called by the server and actually performing the handshake based on the
     * helloProperties from the client
     * <p>
     * The server needs to evaluate what the client requested and puts the
     * result into the acceptedProperties. No action will be done right now. The
     * result in the acceptedProperties will also be sent to the client.
     * </p>
     * 
     * @param context
     *            the handshake context
     * @param helloProperties
     *            the properties from the client
     * @param acceptedProperties
     *            the properties to fill with the result of the handshake
     * @throws Exception
     *             if anything goes wrong
     */
    public void handshake ( HandshakeContext context, Map<String, String> helloProperties, Map<String, String> acceptedProperties ) throws Exception;

    /**
     * Activate the results from the previous handshake run. This is called on
     * the server directly and on the client when the {@link AcceptMessage} was
     * received.
     * <p>
     * In this phase all handshake modules should apply the changes needed. They
     * may also change the sessions filter chain to change the way it
     * communicates.
     * </p>
     * <p>
     * This method will be called before the ACCEPT/START packet is sent. This
     * means that on the server side filters that change the encoding must be
     * deactivated for the first packet. On the client side the first packet
     * must already be encoded.
     * </p>
     * 
     * @param context
     *            the handshake context
     * @param acceptedProperties
     *            the accepted properties from the servers handshake run
     * @throws Exception
     *             if anything goes wrong
     */
    public void apply ( HandshakeContext context, Map<String, String> acceptedProperties ) throws Exception;

    /**
     * A second apply run performed directly after the run to
     * {@link #apply(HandshakeContext, Map)}
     * <p>
     * This second apply run has the possibility to perform stuff which needs to
     * be done after all changes to the filter change have been performed. So
     * messages sent in this phase will already be encoded correctly.
     * </p>
     * 
     * @param context
     *            the handshake context
     * @param acceptedProperties
     *            the accepted properties from the servers handshake run
     * @throws Exception
     *             if anything goes wrong
     */
    public void postApply ( HandshakeContext context, Map<String, String> acceptedProperties ) throws Exception;

    /**
     * Called on the server and client when the session got started.
     * <p>
     * For the server this may either be directly after the handshake run or
     * later when the {@link StartMessage} has been received. This depends on
     * the fact weather the client supports the session start command.
     * </p>
     * <p>
     * For the client this is after the session has been accepted
     * </p>
     * 
     * @param context
     *            the handshake context
     * @param acceptedProperties
     *            the accepted properties from the servers handshake run
     * @throws Exception
     *             if anything goes wrong
     */
    public void sessionStarted ( HandshakeContext context, Map<String, String> acceptedProperties ) throws Exception;
}
