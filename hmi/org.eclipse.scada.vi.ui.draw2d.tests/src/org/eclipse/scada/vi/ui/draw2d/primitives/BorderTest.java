package org.eclipse.scada.vi.ui.draw2d.primitives;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class BorderTest
{
    @Test
    public void test1 ()
    {
        final Map<String, String> result = FigureController.parseBorderArguments ( "", "[inner=LINE:[a=1],outer=LINE:[b=2]]" );
        Assert.assertEquals ( "LINE:[a=1]", result.get ( "inner" ) );
        Assert.assertEquals ( "LINE:[b=2]", result.get ( "outer" ) );
    }

    @Test
    public void test2 ()
    {
        final Map<String, String> result = FigureController.parseBorderArguments ( "", "[inner=LINE:[a=1,c=1],outer=LINE:[b=2,d=2]]" );
        Assert.assertEquals ( "LINE:[a=1,c=1]", result.get ( "inner" ) );
        Assert.assertEquals ( "LINE:[b=2,d=2]", result.get ( "outer" ) );
    }

    @Test
    public void test3 ()
    {
        final Map<String, String> result = FigureController.parseBorderArguments ( "", "[inner=COMPOUND:[inner=LINE:[a=1,c=1],outer=LINE:[b=2,d=2]],outer=LINE:[x=2,y=2]]" );
        Assert.assertEquals ( "COMPOUND:[inner=LINE:[a=1,c=1],outer=LINE:[b=2,d=2]]", result.get ( "inner" ) );
        Assert.assertEquals ( "LINE:[x=2,y=2]", result.get ( "outer" ) );
    }
}
