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
#ifndef PINGSERVER_H_
#define PINGSERVER_H_

#include "headers.h"

class PingServer;

#include "PingTarget.h"

class PingServer {
 public:
  PingServer ( uint32_t loopDelay );
  virtual ~PingServer ();

  virtual void ping ( const sockaddr * addr, socklen_t addrLen, int sequenceNr );
  virtual void receive ( unsigned int timeout );

  virtual PingTarget * addTarget ( const std::string & id, const std::string & targetName );

  virtual void tick ();
  virtual void loop ();

 protected:
  virtual void processPacket ( sockaddr_in * from, int rc, u_char * packet );

 private:
  std::map < std::string, std::list < PingTarget* > > targets;
  int sock_icmp;
  bool debug;
  bool dontRoute;
  uint16_t ident;
  int datalen;
  uint32_t loopDelay;
};

#endif /* PINGSERVER_H_ */
