package org.eclipse.neoscada.protocol.iec60870.asdu.message;

import org.eclipse.neoscada.protocol.iec60870.ProtocolOptions;
import org.eclipse.neoscada.protocol.iec60870.asdu.ASDUHeader;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.CommandValue;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.TypeHelper;

import io.netty.buffer.ByteBuf;

public abstract class AbstractSetPointCommandScaledValue extends AbstractInformationObjectMessage
{
    private final byte type;

    private final boolean execute;

    private final CommandValue<Short> value;

    private final boolean withTimestamp;

    public AbstractSetPointCommandScaledValue ( final ASDUHeader header, final InformationObjectAddress informationObjectAddress, final CommandValue<Short> value, boolean withTimestamp, final byte type, final boolean execute )
    {
        super ( header, informationObjectAddress );
        this.value = value;
        this.type = type;
        this.execute = execute;
        this.withTimestamp = withTimestamp;
    }

    public byte getType ()
    {
        return this.type;
    }

    public CommandValue<Short> getValue ()
    {
        return this.value;
    }

    public boolean isExecute ()
    {
        return this.execute;
    }

    @Override
    public void encode ( final ProtocolOptions options, final ByteBuf out )
    {
        EncodeHelper.encodeHeader ( this, options, null, this.header, out );

        this.informationObjectAddress.encode ( options, out );

        out.writeShort ( this.value.getValue () );

        byte b = 0;

        b |= this.type & 0b011111111;
        b |= this.execute ? 0 : 0b100000000;

        out.writeByte ( b );
        
        if ( withTimestamp )
        {
            TypeHelper.encodeTimestamp ( options, out, value.getTimestamp () );
        }
    }
}
