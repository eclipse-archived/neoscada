package org.eclipse.neoscada.protocol.iec60870.asdu.types;

import java.util.Date;

public class CommandValue<T>
{
    private final T value;

    private long timestamp;

    public CommandValue ( final T value, final long timestamp )
    {
        this.value = value;
        this.timestamp = timestamp;
    }

    public long getTimestamp ()
    {
        return this.timestamp;
    }

    public T getValue ()
    {
        return this.value;
    }

    public static CommandValue<Boolean> TRUE ()
    {
        return new CommandValue<Boolean> ( Boolean.TRUE, System.currentTimeMillis () );
    }

    public static CommandValue<Boolean> FALSE ()
    {
        return new CommandValue<Boolean> ( Boolean.FALSE, System.currentTimeMillis () );
    }

    @Override
    public String toString ()
    {
        return String.format ( "[%s: %s - %3$tF %3$tH:%3$tM:%3$tS.%3$tL %3$tZ %3$tz", this.value.getClass ().getSimpleName (), this.value, new Date ( this.timestamp ) );
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) ( this.timestamp ^ this.timestamp >>> 32 );
        result = prime * result + ( this.value == null ? 0 : this.value.hashCode () );
        return result;
    }

    @Override
    public boolean equals ( final Object obj )
    {
        if ( this == obj )
        {
            return true;
        }
        if ( obj == null )
        {
            return false;
        }
        if ( getClass () != obj.getClass () )
        {
            return false;
        }
        final CommandValue<?> other = (CommandValue<?>)obj;
        if ( this.timestamp != other.timestamp )
        {
            return false;
        }
        if ( this.value == null )
        {
            if ( other.value != null )
            {
                return false;
            }
        }
        else if ( !this.value.equals ( other.value ) )
        {
            return false;
        }
        return true;
    }
}
