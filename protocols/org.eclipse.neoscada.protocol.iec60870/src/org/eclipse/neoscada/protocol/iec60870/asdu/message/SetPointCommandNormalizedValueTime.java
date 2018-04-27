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

@ASDU ( id = 61, name = "C_SE_TA_1", informationStructure = InformationStructure.SINGLE )
public class SetPointCommandNormalizedValueTime extends AbstractSetPointCommandNormalizedValue implements ValueCommandMessage
{
    public SetPointCommandNormalizedValueTime ( final ASDUHeader header, final InformationObjectAddress informationObjectAddress, final CommandValue<Double> value, final byte type, final boolean execute )
    {
        super ( header, informationObjectAddress, value, true, type, execute );
    }

    public SetPointCommandNormalizedValueTime ( final ASDUHeader header, final InformationObjectAddress informationObjectAddress, final CommandValue<Double> value )
    {
        this ( header, informationObjectAddress, value, (byte)0, true );
    }

    @Override
    public SetPointCommandNormalizedValueTime mirror ( final Cause cause, final boolean positive )
    {
        return new SetPointCommandNormalizedValueTime ( this.header.clone ( cause, positive ), this.informationObjectAddress, this.getValue (), this.getType (), this.isExecute () );
    }

    public static SetPointCommandNormalizedValueTime parse ( final ProtocolOptions options, final byte length, final ASDUHeader header, final ByteBuf data )
    {
        final InformationObjectAddress address = InformationObjectAddress.parse ( options, data );

        final short value = data.readShort ();

        final byte b = data.readByte ();

        final byte type = (byte) ( b & 0b011111111 );
        final boolean execute = ! ( ( b & 0b100000000 ) > 0 );

        final long timestamp = TypeHelper.parseTimestamp ( options, data );

        return new SetPointCommandNormalizedValueTime ( header, address, new CommandValue<Double> (  (double) ( value / 32768.0 ), timestamp ), type, execute );
    }
}
