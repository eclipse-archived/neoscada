/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.details.swt.impl.visibility;

import javax.script.ScriptContext;
import javax.script.ScriptEngineManager;

import org.eclipse.scada.utils.script.ScriptExecutor;
import org.eclipse.scada.vi.details.swt.Activator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScriptVisibilityProviderImpl extends AbstractVisibilityProvider
{

    private final static Logger logger = LoggerFactory.getLogger ( ScriptVisibilityProviderImpl.class );

    public ScriptVisibilityProviderImpl ( final ScriptEngineManager scriptEngineManager, final ScriptContext scriptContext, String engineName, final String scriptCode )
    {
        fireChange ( false );

        if ( engineName == null || engineName.isEmpty () )
        {
            engineName = "JavaScript";
        }

        try
        {
            final ScriptExecutor executor = new ScriptExecutor ( scriptEngineManager, engineName, scriptCode, Activator.class.getClassLoader () );
            fireChange ( makeResult ( executor.execute ( scriptContext ) ) );
        }
        catch ( final Exception e )
        {
            logger.warn ( "Failed to eval visibility", e );
        }
    }

    private boolean makeResult ( final Object result )
    {
        if ( result == null )
        {
            return false;
        }
        if ( result instanceof Boolean )
        {
            return (Boolean)result;
        }
        if ( result instanceof Number )
        {
            return ( (Number)result ).longValue () != 0;
        }
        return Boolean.parseBoolean ( result.toString () );
    }

    @Override
    public void dispose ()
    {
    }

}
