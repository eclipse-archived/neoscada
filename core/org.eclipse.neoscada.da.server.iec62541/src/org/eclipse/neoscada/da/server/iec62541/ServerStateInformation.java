package org.eclipse.neoscada.da.server.iec62541;

public class ServerStateInformation
{
    private final MiloConnectionState state;

    public static class Builder
    {
        private MiloConnectionState state = MiloConnectionState.SLEEPING;

        public Builder ()
        {
        }

        public Builder state ( final MiloConnectionState state )
        {
            this.state = state;
            return this;
        }

        public ServerStateInformation create ()
        {
            return new ServerStateInformation ( this.state );
        }
    }

    private ServerStateInformation ( final MiloConnectionState state )
    {
        this.state = state;
    }

    public MiloConnectionState getState ()
    {
        return this.state;
    }
}
