package org.eclipse.neoscada.da.server.iec62541;

import java.io.Serializable;
import java.net.URL;

public class ServerConfiguration implements Serializable
{
    private static final long serialVersionUID = 1L;

    final private URL url;

    public ServerConfiguration ( URL url )
    {
        this.url = url;
    }

    public URL getUrl ()
    {
        return url;
    }
}
