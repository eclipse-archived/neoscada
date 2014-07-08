package org.eclipse.scada.protocol.iec60870.client;

public interface ConnectionStateListener
{
    public void connected ();

    public void disconnected ( Throwable error );
}
