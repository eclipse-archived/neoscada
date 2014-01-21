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
#include "PingTarget.h"

PingTarget::PingTarget ( PingServer & pingServer, const std::string & id, sockaddr * to, socklen_t addrLen, const std::string & hostname ) :
    pingServer ( pingServer ), //!< The ping server instance
    id ( id ), //!< id of the object
    to ( to ), //!< the address to ping
    addrLen ( addrLen ), //!< The address length
    hostname ( hostname ), //!< The hostname
    sequenceNr ( 0 ), //!< the starting sequence
    rttStats ( 20 ), //!< The stats count
    reachStats ( 20 ), //!< The reach count
    reachItem ( id + ".reach", DataItem::INPUT ), //!< The data item for reachability
    rttItem ( id + ".rtt", DataItem::INPUT ) //!< The data item for RTT stats
    {
    }

PingTarget::~PingTarget ()
{
}

void PingTarget::tick ()
{
    sequenceNr++;
    char buffer[255];

    pingServer.ping ( to, addrLen, sequenceNr );

    if ( reachStats.isValid () )
    {
        std::map<std::string, std::string> attributes;
        sprintf ( buffer, "DOUBLE#%.2f", reachability () );
        attributes.clear ();
        reachItem.updateValue ( std::auto_ptr<std::string> ( new std::string ( buffer ) ), attributes );
    }
    else
    {
        std::map<std::string, std::string> attributes;
        attributes["invalid.error"] = "BOOL#true";
        reachItem.updateValue ( std::auto_ptr<std::string> ( new std::string ( "NULL#" ) ), attributes );
    }

    if ( rttStats.isValid () )
    {
        std::map<std::string, std::string> attributes;
        sprintf ( buffer, "DOUBLE#%.0f", rtt () );
        attributes.clear ();
        rttItem.updateValue ( std::auto_ptr<std::string> ( new std::string ( buffer ) ), attributes );
    }
    else
    {
        std::map<std::string, std::string> attributes;
        attributes["invalid.error"] = "BOOL#true";
        rttItem.updateValue ( std::auto_ptr<std::string> ( new std::string ( "NULL#" ) ), attributes );
    }

    reachStats.push ( 0 );
}

/*!
 * calculate the reachability
 * @return the current reachability
 */
double PingTarget::reachability () const
{
    return reachStats.average ( 0.0 ) * 2.0;
}

/*!
 * calculate the round trip time
 * @return
 */
double PingTarget::rtt () const
{
    double tmp = rttStats.average ( 0.0 );
    return ( (double)tmp ) / 1000.0;
}

void PingTarget::received ( long rtt )
{
    reachStats.push ( 1 );
    rttStats.push ( rtt );
}

void PingTarget::registerHive ( Hive * hive )
{
    hive->registerItem ( &reachItem );
    hive->registerItem ( &rttItem );
}

void PingTarget::unregisterHive ( Hive * hive )
{
    hive->unregisterItem ( &reachItem );
    hive->unregisterItem ( &rttItem );
}
