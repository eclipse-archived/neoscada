package org.eclipse.scada.da.datasource.totalizer;

import java.util.concurrent.TimeUnit;

public class TestSched
{
    public static void main ( final String[] args ) throws InterruptedException
    {
        System.out.println ( TimeUnit.MILLISECONDS.convert ( 1, TimeUnit.MINUTES ) );
        System.out.println ( TimeUnit.MINUTES.convert ( 1, TimeUnit.MILLISECONDS ) );
        //        System.err.println ( TimeUnit.valueOf ( "HOURS" ) );
        //        final EnumSet<TimeUnit> allowed = EnumSet.of ( TimeUnit.DAYS, TimeUnit.HOURS, TimeUnit.MINUTES, TimeUnit.SECONDS );
        //        System.out.println ( allowed );
        //        final ScheduledExecutorService s = Executors.newSingleThreadScheduledExecutor ();
        //        final ScheduledFuture<?> sf = s.scheduleAtFixedRate ( new Runnable () {
        //            @Override
        //            public void run ()
        //            {
        //                System.out.println ( "called " + new Date () );
        //            }
        //        }, 3, 3, TimeUnit.SECONDS );
        //        Thread.sleep ( 7000l );
        //        System.out.println ( "exiting" );
        //        sf.cancel ( false );
        //        Thread.sleep ( 10000l );
        //        System.out.println ( "close" );
        //        s.shutdownNow ();
    }
}
