package org.eclipse.neoscada.da.server.iec62541;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;

import org.eclipse.scada.utils.concurrent.AbstractFuture;

public abstract class TransformResultFuture<From, To> extends AbstractFuture<To>
{
    private final CompletableFuture<From> fromFuture;

    public TransformResultFuture ( final CompletableFuture<From> fromFuture, final Executor executor )
    {
        this.fromFuture = fromFuture;

        this.fromFuture.whenCompleteAsync ( new BiConsumer<From, Throwable> () {

            @Override
            public void accept ( final From from, final Throwable t )
            {
                try
                {
                    if ( t == null )
                    {
                        setResult ( transform ( from ) );
                    }
                    else
                    {
                        setError ( t );
                    }
                }
                catch ( final Exception e )
                {
                    setError ( e );
                }
            }
        }, executor );
    }

    protected abstract To transform ( From from ) throws Exception;

    @Override
    public boolean cancel ( final boolean mayInterruptIfRunning )
    {
        this.fromFuture.cancel ( mayInterruptIfRunning );
        return super.cancel ( mayInterruptIfRunning );
    }

}
