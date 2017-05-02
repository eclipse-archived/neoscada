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
#ifndef PINGTARGET_H_
#define PINGTARGET_H_

class PingTarget;

#include "headers.h"

#include "PingServer.h"
#include "StatsArray.h"
#include "DataItem.h"

class PingTarget {
public:
	PingTarget(PingServer & pingServer, const std::string & id, sockaddr * to, socklen_t addrLen, const std::string & hostname );
	virtual ~PingTarget();

	virtual void tick ();

	virtual void received ( long rtt );

	virtual double reachability () const;
	virtual double rtt () const;

	virtual void registerHive ( Hive * hive );
	virtual void unregisterHive ( Hive * hive );

private:
	PingServer & pingServer;
	std::string id;
	sockaddr * to;
	socklen_t addrLen;
	std::string hostname;
	int sequenceNr;

	StatsArray<uint32_t> rttStats;
	StatsArray<double> reachStats;

	DataItem reachItem;
	DataItem rttItem;
};

#endif /* PINGTARGET_H_ */
