package org.eclipse.scada.ae.server.handler.script;

import javax.script.ScriptContext;
import javax.script.SimpleScriptContext;

import org.eclipse.scada.ae.Event;
import org.eclipse.scada.ae.Event.EventBuilder;
import org.eclipse.scada.ae.server.handler.AbstractEventHandler;
import org.eclipse.scada.ae.server.handler.InjectionContext;
import org.eclipse.scada.ae.server.injector.EventInjectorQueue;
import org.eclipse.scada.utils.script.ScriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScriptEventHandler extends AbstractEventHandler
{
    private final static Logger logger = LoggerFactory.getLogger ( ScriptEventHandler.class.getName () + ".scripts" );

    private final ScriptExecutor script;

    private final EventInjectorQueue injector;

    public ScriptEventHandler ( final ScriptExecutor script, final EventInjectorQueue injector )
    {
        this.script = script;
        this.injector = injector;
    }

    @Override
    public Event handleEvent ( final Event event, final InjectionContext context )
    {
        final ScriptContext scriptContext = new SimpleScriptContext ();
        try
        {
            scriptContext.setAttribute ( "event", event, ScriptContext.GLOBAL_SCOPE );
            scriptContext.setAttribute ( "logger", logger, ScriptContext.GLOBAL_SCOPE );
            scriptContext.setAttribute ( "injector", this.injector, ScriptContext.GLOBAL_SCOPE );

            final Object result = this.script.execute ( scriptContext );
            final Event resultEvent = convert ( result, event );
            logger.debug ( "Result: {}", resultEvent );
            return resultEvent;
        }
        catch ( final Exception e )
        {
            return event;
        }
    }

    private Event convert ( final Object result, final Event event )
    {
        logger.debug ( "Converting result - result: {}, event: {}", result, event );

        if ( result == null )
        {
            return null;
        }
        if ( result instanceof Boolean )
        {
            return (Boolean)result ? event : null;
        }
        if ( result instanceof Event )
        {
            return (Event)result;
        }
        else if ( result instanceof EventBuilder )
        {
            return ( (EventBuilder)result ).build ();
        }
        throw new IllegalStateException ( String.format ( "Invalid return type: %s", result.getClass () ) );
    }
}
