package org.eclipse.neoscada.protocol.iec60870.asdu.message;

import io.netty.buffer.ByteBuf;

import org.eclipse.neoscada.protocol.iec60870.ProtocolOptions;
import org.eclipse.neoscada.protocol.iec60870.asdu.ASDUHeader;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.ASDU;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.Cause;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.CommandValue;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.InformationStructure;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.TypeHelper;

@ASDU ( id = 58, name = "C_SC_TA_1", informationStructure = InformationStructure.SINGLE )
public class SingleCommandTime extends AbstractSingleCommand implements ValueCommandMessage
{
    public SingleCommandTime ( final ASDUHeader header, final InformationObjectAddress informationObjectAddress, final CommandValue<Boolean> value, final byte type, final boolean execute )
    {
        super ( header, informationObjectAddress, value, true, type, execute );
    }

    public SingleCommandTime ( final ASDUHeader header, final InformationObjectAddress informationObjectAddress, final CommandValue<Boolean> value )
    {
        this ( header, informationObjectAddress, value, (byte)0, true );
    }

    @Override
    public SingleCommandTime mirror ( final Cause cause, final boolean positive )
    {
        return new SingleCommandTime ( this.header.clone ( cause, positive ), this.informationObjectAddress, getValue (), getType (), isExecute () );
    }

    public static SingleCommandTime parse ( final ProtocolOptions options, final byte length, final ASDUHeader header, final ByteBuf data )
    {
        final InformationObjectAddress address = InformationObjectAddress.parse ( options, data );

        final byte b = data.readByte ();

        final boolean state = ( b & 0b00000001 ) > 0;
        final byte type = (byte) ( ( b & 0b011111100 ) >> 2 );
        final boolean execute = ! ( ( b & 0b100000000 ) > 0 );
        
        final long timestamp = TypeHelper.parseTimestamp ( options, data );

        return new SingleCommandTime ( header, address, new CommandValue<Boolean> ( state, timestamp ), type, execute );
    }
}
