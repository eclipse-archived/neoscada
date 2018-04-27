package org.eclipse.neoscada.protocol.iec60870.asdu.message;

import io.netty.buffer.ByteBuf;

import org.eclipse.neoscada.protocol.iec60870.ProtocolOptions;
import org.eclipse.neoscada.protocol.iec60870.asdu.ASDUHeader;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.ASDU;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.Cause;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.CommandValue;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.InformationStructure;

@ASDU ( id = 48, name = "C_SE_NA_1", informationStructure = InformationStructure.SINGLE )
public class SetPointCommandNormalizedValue extends AbstractSetPointCommandNormalizedValue implements ValueCommandMessage
{
    public SetPointCommandNormalizedValue ( final ASDUHeader header, final InformationObjectAddress informationObjectAddress, final double value, final byte type, final boolean execute )
    {
        super ( header, informationObjectAddress, new CommandValue<Double> ( value, System.currentTimeMillis () ), false, type, execute );
    }

    public SetPointCommandNormalizedValue ( final ASDUHeader header, final InformationObjectAddress informationObjectAddress, final double value )
    {
        this ( header, informationObjectAddress, value, (byte)0, true );
    }

    @Override
    public SetPointCommandNormalizedValue mirror ( final Cause cause, final boolean positive )
    {
        return new SetPointCommandNormalizedValue ( this.header.clone ( cause, positive ), this.informationObjectAddress, this.getValue ().getValue (), this.getType (), this.isExecute () );
    }

    public static SetPointCommandNormalizedValue parse ( final ProtocolOptions options, final byte length, final ASDUHeader header, final ByteBuf data )
    {
        final InformationObjectAddress address = InformationObjectAddress.parse ( options, data );

        final short value = data.readShort ();

        final byte b = data.readByte ();

        final byte type = (byte) ( b & 0b011111111 );
        final boolean execute = ! ( ( b & 0b100000000 ) > 0 );

        return new SetPointCommandNormalizedValue ( header, address,  (double) ( value / 32768.0 ), type, execute );
    }
}
