package org.eclipse.scada.da.buffer;

import org.eclipse.scada.da.datasource.data.DataItemValueRange;

public interface BufferedDataSourceListener
{
    void stateChanged ( DataItemValueRange dataItemValueRange );
}
