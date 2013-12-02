/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.world.lib.oscar;

import org.eclipse.scada.configuration.generator.Profiles;
import org.eclipse.scada.configuration.world.lib.oscar.P2ProfileProcessor;
import org.eclipse.scada.configuration.world.osgi.profile.Profile;
import org.eclipse.scada.configuration.world.osgi.profile.ProfileFactory;
import org.junit.Assert;
import org.junit.Test;

public class P2ProfileTest
{
    @Test
    public void flatten1 ()
    {
        final Profile p1 = ProfileFactory.eINSTANCE.createProfile ();
        final Profile p2 = ProfileFactory.eINSTANCE.createProfile ();

        p1.getIncludes ().add ( p2 );

        Profiles.addStartBundle ( p1, "a" );
        Profiles.addStartBundle ( p1, "b" );
        Profiles.addStartBundle ( p2, "c" );
        Profiles.addStartBundle ( p2, "d" );

        final Profile p3 = P2ProfileProcessor.flatten ( p1 );

        Assert.assertTrue ( "Profile has start bundle 'a'", Profiles.hasStartBundle ( p3, "a" ) );
        Assert.assertTrue ( "Profile has start bundle 'b'", Profiles.hasStartBundle ( p3, "b" ) );
        Assert.assertTrue ( "Profile has start bundle 'c'", Profiles.hasStartBundle ( p3, "c" ) );
        Assert.assertTrue ( "Profile has start bundle 'd'", Profiles.hasStartBundle ( p3, "d" ) );

        Assert.assertTrue ( "Profile has no more includes", p3.getIncludes ().isEmpty () );
    }
}
