package org.eclipse.neoscada.da.server.iec62541;
import java.util.Map;

import org.eclipse.scada.ca.common.factory.AbstractServiceConfigurationFactory;
import org.eclipse.scada.sec.UserInformation;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

public class ConfigurationFactory extends AbstractServiceConfigurationFactory<OpcUaConnection>
{
    private final OpcUaHive hive;

    public ConfigurationFactory ( final OpcUaHive hive )
    {
        super ( FrameworkUtil.getBundle ( ConfigurationFactory.class ).getBundleContext (), true );

        this.hive = hive;
    }

    @Override
    protected Entry<OpcUaConnection> createService ( final UserInformation userInformation, final String configurationId, final BundleContext context, final Map<String, String> parameters ) throws Exception
    {
        final OpcUaConnection service = this.hive.addServer ( configurationId, parameters );
        return new Entry<OpcUaConnection> ( configurationId, service );
    }

    @Override
    protected void disposeService ( final UserInformation userInformation, final String configurationId, final OpcUaConnection service )
    {
        this.hive.removeServer ( configurationId );
    }

    @Override
    protected Entry<OpcUaConnection> updateService ( final UserInformation userInformation, final String configurationId, final Entry<OpcUaConnection> entry, final Map<String, String> parameters ) throws Exception
    {
        return null; // we are "create only"
    }

}
