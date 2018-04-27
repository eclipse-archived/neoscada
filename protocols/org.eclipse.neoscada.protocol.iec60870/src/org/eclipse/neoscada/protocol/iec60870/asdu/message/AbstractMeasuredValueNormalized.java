package org.eclipse.neoscada.protocol.iec60870.asdu.message;

import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.neoscada.protocol.iec60870.ProtocolOptions;
import org.eclipse.neoscada.protocol.iec60870.asdu.ASDUHeader;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.InformationEntry;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.TypeHelper;
import org.eclipse.neoscada.protocol.iec60870.asdu.types.Value;

public abstract class AbstractMeasuredValueNormalized extends AbstractMessage
{
    protected final List<InformationEntry<Double>> entries;

    private final boolean withTimestamp;

    public AbstractMeasuredValueNormalized ( final ASDUHeader header, final List<InformationEntry<Double>> entries, final boolean withTimestamp )
    {
        super ( header );
        this.entries = entries;
        this.withTimestamp = withTimestamp;
    }

    public List<InformationEntry<Double>> getEntries ()
    {
        return this.entries;
    }

    @Override
    public void encode ( final ProtocolOptions options, final ByteBuf out )
    {
        EncodeHelper.encodeHeader ( this, options, this.entries.size (), this.header, out );

        for ( final InformationEntry<Double> entry : this.entries )
        {
            entry.getAddress ().encode ( options, out );
            TypeHelper.encodeNormalizedValue ( options, out, entry.getValue (), this.withTimestamp );
        }
    }

    protected static List<InformationEntry<Double>> parseEntries ( final ProtocolOptions options, final byte length, final ByteBuf data, final boolean withTimestamp )
    {
        final List<InformationEntry<Double>> values = new ArrayList<> ( length );
        for ( int i = 0; i < length; i++ )
        {
            final InformationObjectAddress address = InformationObjectAddress.parse ( options, data );
            final Value<Double> value = TypeHelper.parseNormalizedValue ( options, data, withTimestamp );
            values.add ( new InformationEntry<> ( address, value ) );
        }
        return values;
    }
}