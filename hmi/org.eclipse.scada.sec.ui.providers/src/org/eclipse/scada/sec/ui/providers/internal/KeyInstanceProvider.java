/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.sec.ui.providers.internal;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.sec.ui.providers.KeyInformation;
import org.eclipse.scada.sec.ui.providers.KeyInstanceManager;
import org.eclipse.scada.sec.ui.providers.KeyInstanceManager.StatusListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.AbstractSourceProvider;
import org.eclipse.ui.ISources;
import org.eclipse.ui.services.IServiceLocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KeyInstanceProvider extends AbstractSourceProvider implements StatusListener
{

    private final static Logger logger = LoggerFactory.getLogger ( KeyInstanceProvider.class );

    private static final String VAR_DEFAULT_KEY = "org.eclipse.scada.sec.ui.providers.KeyInstance.defaultKey";

    private static final String VAR_IS_DEFAULT_KEY = "org.eclipse.scada.sec.ui.providers.KeyInstance.isDefaultKey";

    private KeyInstanceManager mgr;

    public KeyInstanceProvider ()
    {
    }

    @Override
    public void initialize ( final IServiceLocator locator )
    {
        super.initialize ( locator );
        this.mgr = KeyInstanceManager.getInstance ( Display.getCurrent () );
        this.mgr.addStatusListener ( this );
    }

    @Override
    public void dispose ()
    {
        this.mgr.removeStatusListener ( this );
    }

    @SuppressWarnings ( { "rawtypes", "unchecked" } )
    @Override
    public Map getCurrentState ()
    {
        final Map result = new HashMap ();

        result.put ( VAR_DEFAULT_KEY, this.mgr.getDefaultKey () );
        result.put ( VAR_IS_DEFAULT_KEY, this.mgr.getDefaultKey () != null );

        return result;
    }

    @Override
    public String[] getProvidedSourceNames ()
    {
        return new String[] { VAR_DEFAULT_KEY };
    }

    @Override
    public void defaultKeyChanged ( final KeyInformation key, final Date validUntil )
    {
        logger.debug ( "Default key changed: {} -> {}", key, validUntil );

        fireSourceChanged ( ISources.WORKBENCH, getCurrentState () );
    }
}
