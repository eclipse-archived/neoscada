/*******************************************************************************
 * Copyright (c) 2008, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - prepare for Eclipse SCADA contribution
 *******************************************************************************/
#include "headers.h"

#include "PingServer.h"

#define DEFAULT_PING_PERIOD 250

void test1 ()
{
    StatsArray<int> sa ( 20 );
    sa.push ( 0 );
    sa.push ( 0 );
    sa.push ( 0 );
    sa.push ( 0 );
    sa.push ( 0 );
    sa.push ( 0 );
    sa.push ( 0 );
    sa.push ( 0 );
    sa.push ( 0 );
    sa.push ( 0 );
    sa.push ( 0 );
    std::cout << sa.isValid () << std::endl;
}

int getPingPeriod ()
{
    char * periodString = ::getenv ( "PING_PERIOD" );
    if ( periodString )
    {
        int period = ::atoi ( periodString );
        if ( period >= 0 )
        {
            return period;
        }
    }
    return DEFAULT_PING_PERIOD;
}

int main ( int argc, char ** argv )
{
    PingServer pingServer ( getPingPeriod () );

    Hive hive ( std::cout );

    // init phase
    DataItem stateItem ( "state", DataItem::INPUT );
    stateItem.updateValue ( "STRING#LOOKUP" );
    hive.registerItem ( &stateItem );
    DataItem currentEntryItem ( "currentLookup", DataItem::INPUT );
    hive.registerItem ( &currentEntryItem );

    // lookup
    for ( int i = 1; i < argc; i++ )
    {
        std::string id = argv[i];
        std::string hostname = argv[i];

        currentEntryItem.updateValue ( "STRING#" + id );

        PingTarget * target;

        // check if an alias ID is set
        int idx = id.find ( "=" );
        int slen = id.length ();
        if ( idx > 0 && idx + 1 < slen )
        {
            std::string arg = argv[i];
            hostname = arg.substr ( 0, idx );
            int len = slen - ( idx + 1 );
            id = arg.substr ( idx + 1, len );

            target = pingServer.addTarget ( id, hostname );
        }
        else
        {
            // no alias
            target = pingServer.addTarget ( id, hostname );
        }

        target->registerHive ( &hive );
    }

    // run
    stateItem.updateValue ( "STRING#RUNNING" );
    currentEntryItem.updateValue ( "NULL#" );
    pingServer.loop ();

    return 0;
}
