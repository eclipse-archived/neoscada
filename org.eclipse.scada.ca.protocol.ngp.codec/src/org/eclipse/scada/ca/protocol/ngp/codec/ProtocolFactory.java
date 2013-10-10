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
package org.eclipse.scada.ca.protocol.ngp.codec;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.scada.protocol.ngp.common.mc.protocol.osbp.BinaryContext;
import org.eclipse.scada.protocol.ngp.common.mc.protocol.osbp.BinaryMessageCodec;
import org.eclipse.scada.protocol.ngp.common.mc.protocol.osbp.BinaryProtocolDescriptor;
import org.eclipse.scada.protocol.ngp.common.mc.protocol.osbp.DefaultBinaryContext;

public final class ProtocolFactory
{
    private ProtocolFactory ()
    {
    }

    public static final String VERSION = "ca.1/core.1";

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
        codecs.add ( new org.eclipse.scada.ca.protocol.ngp.codec.impl.GetFactoriesRequest () );
        codecs.add ( new org.eclipse.scada.ca.protocol.ngp.codec.impl.GetFactoriesResponse () );
        codecs.add ( new org.eclipse.scada.ca.protocol.ngp.codec.impl.GetFactoryWithDataRequest () );
        codecs.add ( new org.eclipse.scada.ca.protocol.ngp.codec.impl.GetFactoryWithDataResponse () );
        codecs.add ( new org.eclipse.scada.ca.protocol.ngp.codec.impl.GetConfigurationRequest () );
        codecs.add ( new org.eclipse.scada.ca.protocol.ngp.codec.impl.GetConfigurationResponse () );
        codecs.add ( new org.eclipse.scada.ca.protocol.ngp.codec.impl.ApplyDiffRequest () );
        codecs.add ( new org.eclipse.scada.ca.protocol.ngp.codec.impl.ApplyDiffResponse () );
        codecs.add ( new org.eclipse.scada.ca.protocol.ngp.codec.impl.ErrorResponse () );

        // included messages
        org.eclipse.scada.core.protocol.ngp.codec.ProtocolFactory.fillCodecs ( codecs );
    }
}
