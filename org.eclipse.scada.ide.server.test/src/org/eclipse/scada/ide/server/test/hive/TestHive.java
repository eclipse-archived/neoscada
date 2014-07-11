/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ide.server.test.hive;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.browser.common.FolderCommon;
import org.eclipse.scada.da.server.common.MemoryDataItem;
import org.eclipse.scada.da.server.common.ValidationStrategy;
import org.eclipse.scada.da.server.common.impl.HiveCommon;

public class TestHive extends HiveCommon
{
    private FolderCommon rootFolder;

    private MemoryDataItem transientItem;

    public TestHive ()
    {
        setRootFolder ( this.rootFolder = new FolderCommon () );
        setValidatonStrategy ( ValidationStrategy.GRANT_ALL );
    }

    @Override
    public String getHiveId ()
    {
        return TestHive.class.getName ();
    }

    @Override
    protected void performStart () throws Exception
    {
        super.performStart ();

        this.transientItem = new MemoryDataItem ( "transient" );
        registerItem ( this.transientItem );
        this.rootFolder.add ( "transient", this.transientItem, makeDescription ( "A transient data item" ) );
    }

    private Map<String, Variant> makeDescription ( final String string )
    {
        final Map<String, Variant> result = new HashMap<> ( 1 );
        result.put ( "description", Variant.valueOf ( string ) ); //$NON-NLS-1$
        return result;
    }

    @Override
    protected void performStop () throws Exception
    {
        super.performStop ();
    }

}
