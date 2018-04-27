package org.eclipse.neoscada.da.server.iec60870;

import java.io.Serializable;

public class QualifiedCommandMessage implements Serializable
{
    private static final long serialVersionUID = 7639673966961773588L;

    private CommandMessage commandMessage;

    private byte qualifierOfCommand;

    public QualifiedCommandMessage ( CommandMessage commandMessage, byte qualifierOfCommand )
    {
        this.commandMessage = commandMessage;
        this.qualifierOfCommand = qualifierOfCommand;
    }

    public QualifiedCommandMessage ( CommandMessage commandMessage )
    {
        this.commandMessage = commandMessage;
        this.qualifierOfCommand = 0;
    }

    public CommandMessage getCommandMessage ()
    {
        return commandMessage;
    }

    public byte getQualifierOfCommand ()
    {
        return qualifierOfCommand;
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( commandMessage == null ) ? 0 : commandMessage.hashCode () );
        result = prime * result + qualifierOfCommand;
        return result;
    }

    @Override
    public boolean equals ( Object obj )
    {
        if ( this == obj )
            return true;
        if ( obj == null )
            return false;
        if ( getClass () != obj.getClass () )
            return false;
        QualifiedCommandMessage other = (QualifiedCommandMessage)obj;
        if ( commandMessage != other.commandMessage )
            return false;
        if ( qualifierOfCommand != other.qualifierOfCommand )
            return false;
        return true;
    }

    @Override
    public String toString ()
    {
        return "QualifiedCommandMessage [commandMessage=" + commandMessage + ", qualifierOfCommand=" + qualifierOfCommand + "]";
    }
}
