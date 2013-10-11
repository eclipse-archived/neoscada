/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - additional work
/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ui.chart.viewer.input;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.script.ScriptContext;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;

import org.eclipse.jface.resource.ResourceManager;
import org.eclipse.scada.chart.AsyncFunctionSeriesData;
import org.eclipse.scada.chart.DataEntry;
import org.eclipse.scada.chart.Realm;
import org.eclipse.scada.chart.XAxis;
import org.eclipse.scada.chart.YAxis;
import org.eclipse.scada.chart.swt.render.AbstractLineRender;
import org.eclipse.scada.chart.swt.render.StepRenderer;
import org.eclipse.scada.ui.chart.viewer.ChartViewer;
import org.eclipse.scada.utils.script.ScriptExecutor;

public class ScriptInput extends LineInput
{

    private AbstractLineRender renderer;

    private ChartViewer viewer;

    private String script;

    private ScriptEngineManager scriptEngineManager;

    private ScriptExecutor scriptExecutor;

    private AsyncFunctionSeriesData dataSeries;

    public ScriptInput ( final ChartViewer viewer, final Realm realm, final ResourceManager resourceManager, final XAxis xAxis, final YAxis yAxis )
    {
        super ( resourceManager );
        this.scriptEngineManager = new ScriptEngineManager ();

        this.viewer = viewer;

        this.renderer = new StepRenderer ( viewer.getChartRenderer (), this.dataSeries = new AsyncFunctionSeriesData ( realm, xAxis, yAxis, 0 ) {

            @Override
            protected Double eval ( final long timestamp )
            {
                return handleEval ( timestamp );
            }
        } );
        viewer.getChartRenderer ().addRenderer ( this.renderer );

        attachHover ( viewer, xAxis );
    }

    protected Double handleEval ( final long timestamp )
    {
        if ( this.scriptExecutor == null )
        {
            return null;
        }

        final ScriptContext context = new SimpleScriptContext ();
        context.setAttribute ( "timestamp", timestamp, ScriptContext.GLOBAL_SCOPE ); //$NON-NLS-1$
        try
        {
            final Map<String, Object> var = new HashMap<String, Object> ( 1 );
            var.put ( "timestamp", timestamp ); //$NON-NLS-1$
            final Object result = this.scriptExecutor.execute ( context, var );
            if ( result == null )
            {
                return null;
            }
            if ( result instanceof Number )
            {
                return ( (Number)result ).doubleValue ();
            }
            else
            {
                return Double.parseDouble ( result.toString () );
            }
        }
        catch ( final Exception e )
        {
            return null;
        }
    }

    @Override
    public void dispose ()
    {
        this.viewer.getChartRenderer ().removeRenderer ( this.renderer );
        this.renderer.dispose ();
        super.dispose ();
    }

    public void setScript ( final String script )
    {
        this.script = script;
        try
        {
            this.scriptExecutor = null;
            this.scriptExecutor = new ScriptExecutor ( this.scriptEngineManager, "JavaScript", script, getClass ().getClassLoader () ); //$NON-NLS-1$
            this.dataSeries.regenerate ();
            firePropertyChange ( ChartInput.PROP_STATE, null, getState () );
        }
        catch ( final ScriptException e )
        {
            throw new IllegalArgumentException ( e );
        }
    }

    public String getScript ()
    {
        return this.script;
    }

    @Override
    public void setSelection ( final boolean state )
    {
    }

    @Override
    protected void setSelectedTimestamp ( final Date selectedTimestamp )
    {
        super.setSelectedTimestamp ( selectedTimestamp );
        final DataEntry value = this.dataSeries.getViewData ().getEntries ().lower ( new DataEntry ( selectedTimestamp.getTime (), null ) );
        if ( value == null )
        {
            setSelectedValue ( null );
        }
        else
        {
            setSelectedValue ( value.toString () );
        }

    }

    @Override
    public void tick ( final long now )
    {
    }

    @Override
    public String getState ()
    {
        return this.scriptExecutor == null ? "invalid" : "valid"; //$NON-NLS-1$ //$NON-NLS-2$
    }

    @Override
    protected AbstractLineRender getLineRenderer ()
    {
        return this.renderer;
    }

}
