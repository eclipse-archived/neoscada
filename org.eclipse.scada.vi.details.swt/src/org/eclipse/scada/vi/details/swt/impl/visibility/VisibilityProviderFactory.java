/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *     Jürgen Rose - additional work
 *******************************************************************************/
package org.eclipse.scada.vi.details.swt.impl.visibility;

import java.util.Map;

import javax.script.ScriptContext;
import javax.script.ScriptEngineManager;

import org.eclipse.scada.utils.str.StringReplacer;
import org.eclipse.scada.vi.details.model.Invisible;
import org.eclipse.scada.vi.details.model.PermissionVisibility;
import org.eclipse.scada.vi.details.model.ScriptVisibility;
import org.eclipse.scada.vi.details.model.TestVisibility;
import org.eclipse.scada.vi.details.model.Visibility;
import org.eclipse.scada.vi.details.swt.Constants;

public class VisibilityProviderFactory
{
    private final ScriptEngineManager scriptEngineManager;

    private final ScriptContext scriptContext;

    private final Map<String, String> properties;

    public VisibilityProviderFactory ( final ScriptEngineManager scriptEngineManager, final ScriptContext scriptContext, final Map<String, String> properties )
    {
        this.scriptEngineManager = scriptEngineManager;
        this.scriptContext = scriptContext;
        this.properties = properties;
    }

    /**
     * Create a visibility provider
     * 
     * @param object
     *            the model object on which the instance should be created
     * @return never returns <code>null</code>
     */
    public VisibilityProvider createProvider ( final Visibility object )
    {
        if ( object == null )
        {
            return StaticVisibileProvider.VISIBLE_INSTANCE;
        }
        if ( object instanceof PermissionVisibility )
        {
            return new PermissionVisibilityProviderImpl ( resolveProperties ( ( (PermissionVisibility)object ).getRequiredPermission () ) );
        }
        if ( object instanceof ScriptVisibility )
        {
            return new ScriptVisibilityProviderImpl ( this.scriptEngineManager, this.scriptContext, ( (ScriptVisibility)object ).getScriptLanguage (), ( (ScriptVisibility)object ).getScript () );
        }
        if ( object instanceof Invisible )
        {
            return StaticVisibileProvider.INVISIBLE_INSTANCE;
        }
        if ( object instanceof TestVisibility )
        {
            return new TestVisibilityImpl ( ( (TestVisibility)object ).getId () );
        }

        return StaticVisibileProvider.INVISIBLE_INSTANCE;
    }

    private String resolveProperties ( final String input )
    {
        if ( input == null )
        {
            return null;
        }

        return StringReplacer.replace ( input, StringReplacer.newSource ( this.properties ), Constants.DEFAULT_PATTERN );
    }
}
