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
package org.eclipse.scada.protocol.iec60870.server.data;

import org.eclipse.scada.protocol.iec60870.asdu.ASDUHeader;
import org.eclipse.scada.protocol.iec60870.asdu.types.ASDUAddress;
import org.eclipse.scada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.eclipse.scada.protocol.iec60870.asdu.types.Value;
import org.eclipse.scada.protocol.iec60870.io.MirrorCommand;

import com.google.common.base.Function;
import com.google.common.util.concurrent.ListenableFuture;

/**
 * A data model for the IEC60870-5 protocol stack<br/>
 * <h1>Locking</h1>
 * <p>
 * The data model might need to used mutex locks in order to protect its
 * internal data store. However there are a few requirements in the terms of
 * locking the implementation has to fulfill.
 * </p>
 * <p>
 * The data model must not call listeners or complete futures holding a lock.
 * The simplest way to achieve this is to push all events to an executor while
 * holding the lock.
 * </p>
 * <p>
 * The following methods itself must not be synchronized:
 * <ul>
 * <li>{@link #read(ASDUAddress, InformationObjectAddress)}</li>
 * <li>{@link #readAll(ASDUAddress, DataListener)}</li>
 * </ul>
 * </p>
 */
public interface DataModel
{
    public Subscription subscribe ( DataListener listener );

    /**
     * Read a specific value <br/>
     * The future will be called with the result of the read operation. If the
     * value is unknown the future must be called with <code>null</code>.
     *
     * @param address
     *            the address to read
     * @return a listener to the operation, <code>null</code> if the data model
     *         instantly decide that the value cannot be read
     */
    public ListenableFuture<Value<?>> read ( ASDUAddress asduAddress, InformationObjectAddress address );

    /**
     * Read all values from the internal structures <br/>
     * The data will not be returned by the future, but pushed to the
     * {@link DataListener}.
     *
     * @param asduAddress
     *            the ASDU common address
     * @param prepare
     *            a runnable that will be called before the actual processing,
     *            from the same thread the listener will be called. But only
     *            when the request actually can be processed. If the runnable
     *            was called, the method must not return <code>null</code>.
     * @param listener
     *            the data receiver
     * @return the future which indicates the end of the transmission. This can
     *         be <code>null</code> if the ASDU address was unknown.
     */
    public ListenableFuture<Void> readAll ( ASDUAddress asduAddress, Runnable prepare, DataListener listener );

    /**
     * Create a new background iterator <br/>
     * If the implementation does not support background transmissions,
     * <code>null</code> may be returned. <br/>
     * The background iterator instance <em>must not</em> cache values. As this
     * would cause a situation where more up-to-date values would get
     * overwritten by the cached values of the background iterator.
     *
     * @return the new background iterator or <code>null</code>
     */
    public BackgroundIterator createBackgroundIterator ();

    /**
     * A method that will call the provided function for each known ASDU address<br>
     * <p>
     * <em>Note</em> that the ASDUs must not change until each function call has
     * been completed.
     * </p>
     * <p>
     * The function call can be performed asynchronously.
     * </p>
     *
     * @param function
     *            the function to call for each known ASDU address
     * @param ifNoneFound
     *            will be called if there are no known common ASDU addresses,
     *            may be <code>null</code>
     */
    public void forAllAsdu ( Function<ASDUAddress, Void> function, Runnable ifNoneFound );

    public void dispose ();

    public void writeCommand ( ASDUHeader header, InformationObjectAddress informationObjectAddress, boolean state, byte type, MirrorCommand mirrorCommand, boolean execute );

    public void writeValue ( ASDUHeader header, InformationObjectAddress informationObjectAddress, float value, byte type, MirrorCommand mirrorCommand, boolean execute );

    public void writeScaledValue ( ASDUHeader header, InformationObjectAddress informationObjectAddress, short value, byte type, MirrorCommand mirrorCommand, boolean execute );

}
