/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - implement security callback system
 *******************************************************************************/
package org.eclipse.scada.core.protocol.ngp.codec;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.scada.ngp.common.codec.osbp.BinaryContext;
import org.eclipse.scada.ngp.common.codec.osbp.BinaryMessageCodec;
import org.eclipse.scada.ngp.common.codec.osbp.BinaryProtocolDescriptor;
import org.eclipse.scada.ngp.common.codec.osbp.DefaultBinaryContext;

public final class ProtocolFactory
{
    private ProtocolFactory ()
    {
    }

    public static final String VERSION = "core.1";

    private final static class ProtocolDescriptor extends BinaryProtocolDescriptor
    {
        public ProtocolDescriptor ()
        {
            super ( new DefaultBinaryContext () );
        }

        public ProtocolDescriptor ( final BinaryContext binaryContext )
        {
            super ( binaryContext );
        }

        @Override
        public String getProtocolId ()
        {
            return this.binaryContext.getProtocolIdPart () + '/' + VERSION;
        }

        @Override
        protected Collection<BinaryMessageCodec> getCodecs ()
        {
            final Collection<BinaryMessageCodec> codecs = new LinkedList<BinaryMessageCodec> ();

            ProtocolFactory.fillCodecs ( codecs );

            return codecs;
        }
    }

    public static org.eclipse.scada.protocol.ngp.common.mc.protocol.ProtocolDescriptor createProtocolDescriptor ()
    {
        return new ProtocolDescriptor ();
    }

    public static org.eclipse.scada.protocol.ngp.common.mc.protocol.ProtocolDescriptor createProtocolDescriptor ( final BinaryContext binaryContext )
    {
        return new ProtocolDescriptor ( binaryContext );
    }

    public static void fillCodecs ( final Collection<BinaryMessageCodec> codecs )
    {
        // local messages 
        codecs.add ( new org.eclipse.scada.core.protocol.ngp.codec.impl.CreateSession () );
        codecs.add ( new org.eclipse.scada.core.protocol.ngp.codec.impl.SessionAccepted () );
        codecs.add ( new org.eclipse.scada.core.protocol.ngp.codec.impl.SessionRejected () );
        codecs.add ( new org.eclipse.scada.core.protocol.ngp.codec.impl.SessionPrivilegesChanged () );
        codecs.add ( new org.eclipse.scada.core.protocol.ngp.codec.impl.RequestCallbacks () );
        codecs.add ( new org.eclipse.scada.core.protocol.ngp.codec.impl.RespondCallbacks () );

    }
}
