/*******************************************************************************
 * Copyright (c) 2008, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - prepare for Eclipse SCADA contribution
 *                        re-implement time diff
 *******************************************************************************/
#include "headers.h"

#include "PingServer.h"
#include "tools.h"

#define	MAXWAIT		10	/* max time to wait for response, sec. */
#define	MAXPACKET	4096	/* max packet size */
#define VERBOSE		1	/* verbose flag */
#define QUIET		2	/* quiet flag */
#define FLOOD		4	/* floodping flag */
#ifndef MAXHOSTNAMELEN
#define MAXHOSTNAMELEN	64
#endif

PingServer::PingServer ( uint32_t loopDelay ) :
  debug ( false ),
  dontRoute ( false ),
  ident ( getpid () & 0xFFFF ),
  datalen ( 64 ),
  loopDelay ( loopDelay )
{
  int on = 1;
  struct protoent *proto;

  // create the icmp socket
  datalen = 64 - 8;

  if ( ( proto = getprotobyname ( "icmp" ) ) == NULL )
    {
      fprintf ( stderr, "icmp: unknown protocol\n" );
      exit ( 10 );
    }

  if ( ( sock_icmp = socket ( AF_INET, SOCK_RAW, proto->p_proto ) ) < 0 )
    {
      perror ( "ping: socket" );
      exit ( 5 );
    }
  if ( debug )
    {
      setsockopt ( sock_icmp, SOL_SOCKET, SO_DEBUG, &on, sizeof ( on ) );
    }
  if ( dontRoute )
    {
      setsockopt ( sock_icmp, SOL_SOCKET, SO_DONTROUTE, &on, sizeof ( on ) );
    }
}

uint64_t mtime ()
{
  timeval tv;
  gettimeofday ( &tv, NULL );
  return ( tv.tv_sec * 1000 ) + ( tv.tv_usec / 1000 );
}

void set_tv ( timeval * tv, uint64_t msecs )
{
  tv->tv_sec = msecs / 1000;
  tv->tv_usec = ( msecs % 1000 ) * 1000;
}

/**
 * @param timeout the timeout in milliseconds
 */
void PingServer::receive ( unsigned int timeout )
{
  u_char packet[MAXPACKET+1];
  int len = sizeof ( packet );

  struct sockaddr_in from;
  socklen_t fromlen = sizeof ( from );

  fd_set readFd;

  uint64_t startTimestamp = mtime ();

  timeval tv;
  do
    {
      uint64_t diff = mtime () - startTimestamp;
      if ( diff >= timeout )
	{
	  return;
	}
      set_tv ( &tv, timeout - diff );

      // clear FDs
      FD_ZERO(&readFd);
      FD_SET(sock_icmp,&readFd);

      int rc = select ( sock_icmp + 1, &readFd, NULL, NULL, &tv );
      if ( rc > 0 )
	{
	  rc = recvfrom ( sock_icmp, packet, len, 0, (sockaddr*)&from, &fromlen );
	  if ( from.sin_family == AF_INET )
	    {
	      processPacket ( &from, rc, packet );
	    }
	}
    } while ( true );

}

void PingServer::processPacket ( sockaddr_in * from, int rc, u_char * packet )
{
  // get the time first
  timeval tv;
  gettimeofday ( &tv, NULL);

  register struct icmp *icp;
  char buffer[MAXHOSTNAMELEN+1];
  strncpy ( buffer, inet_ntoa ( from->sin_addr ), MAXHOSTNAMELEN );
  buffer[MAXHOSTNAMELEN] = 0;

  // still checking ip packet

  struct ip * ip = (struct ip*)packet;
  int hlen = ip->ip_hl << 2;
  if ( rc < ICMP_MINLEN + hlen )
    {
      // std::cout << "Packet too small" << std::endl;
      return;
    }

  rc -= hlen;
  icp = (struct icmp*) ( packet + hlen );

  // now we got icmp
  struct timeval *tp = (struct timeval *) ( packet + hlen + 8 );
  printf ( "packet - sec: %ld, usec: %ld\n", tp->tv_sec, tp->tv_usec );
  printf ( "local  - sec: %ld, usec: %ld\n", tv.tv_sec, tv.tv_usec );
  uint64_t rtt = time_diff ( tp, &tv );

  switch ( icp->icmp_type )
    {
    case ICMP_ECHOREPLY:
      // no-op
      break;
    case ICMP_ECHO:
      // silently ignore ... could be our own anyway
      break;
    default:
      std::cout << "Packet not of type ICMP_ECHOREPLY (" << (int)icp->icmp_type << ")" << std::endl;
      return;
    }
  if ( ident != icp->icmp_id )
    {
      // std::cout << "Packet is not ours" << std::endl;
      return;
    }

  std::map < std::string, std::list < PingTarget* > >::iterator i = targets.find ( std::string ( buffer ) );
  if ( i != targets.end () )
    {

	printf ( "reply from %s (bytes of data: %d) (seq: %d) (ident: %d) (rtt: %.2f ms)\n", buffer, rc, icp->icmp_seq, icp->icmp_id,
        ( (double)rtt ) / 1000.0 );

      //    i->second->received ( rtt );

      for ( std::list<PingTarget*>::iterator i2 = i->second.begin (); i2 != i->second.end (); i2++ )
	{
	  PingTarget * target = *i2;
	  target->received ( rtt );
	}

    }
}

PingTarget * PingServer::addTarget ( const std::string & id, const std::string & targetName )
{
  struct sockaddr_in *to = new sockaddr_in;
  bzero ( to, sizeof(sockaddr_in) );

  std::string hostname;
  char hnamebuf[MAXHOSTNAMELEN+1];

  struct hostent *hp; /* Pointer to host info */

  to->sin_family = AF_INET;
  to->sin_addr.s_addr = inet_addr ( targetName.c_str () );
  if ( to->sin_addr.s_addr != (unsigned)-1 )
    {
      strcpy ( hnamebuf, targetName.c_str () );
      hostname = hnamebuf;
    }
  else
    {
      hp = gethostbyname ( targetName.c_str () );
      if ( hp )
	{
	  to->sin_family = hp->h_addrtype;
	  bcopy ( hp->h_addr, ( caddr_t ) & to->sin_addr, hp->h_length );
	  hostname = hp->h_name;
	}
      else
	{
	  // FIXME: no exits
	  printf ( "%s: unknown host %s\n", targetName.c_str (), targetName.c_str () );
	  exit ( 1 );
	}
    }

  // add new entry
  char buffer[MAXHOSTNAMELEN+1];
  strncpy ( buffer, inet_ntoa ( to->sin_addr ), MAXHOSTNAMELEN );
  PingTarget * newTarget = new PingTarget ( *this, id, (sockaddr*)to, (socklen_t)sizeof(sockaddr_in), hostname );
  std::string newTargetName = buffer;

  targets[newTargetName].push_back ( newTarget );

  return newTarget;
}

void PingServer::ping ( const sockaddr * addr, socklen_t addrLen, int sequenceNr )
{
  struct timezone tz; /* leftover */
  static u_char outpack[MAXPACKET+1];
  register struct icmp *icp = (struct icmp *)outpack;
  int i, cc;
  register struct timeval *tp = (struct timeval *)&outpack[8];
  // register u_char *datap = &outpack[8 + sizeof(struct timeval)];

  /* FIXME: we should also send the alias string in the packet so that
   * we can filter later for that when we search the target that receives
   * the ping. At the moment we get reachability numbers greater than 1
   * in cases we have configured the target multiple times.
   */

  icp->icmp_type = ICMP_ECHO;
  icp->icmp_code = 0;
  icp->icmp_cksum = 0;
  icp->icmp_seq = sequenceNr;
  icp->icmp_id = ident; /* ID */

  cc = datalen + 8; /* skips ICMP portion */

  gettimeofday ( tp, &tz );

  icp->icmp_cksum = in_cksum ( (u_short*)outpack, cc );

  i = sendto ( sock_icmp, outpack, cc, 0, addr, addrLen );

  if ( i < 0 )
    {
      perror ( "sendto" );
    }
  else
    {
      // cout << "Sent " << i << " bytes of data" << endl;
    }

}

void PingServer::tick ()
{
  for ( std::map<std::string, std::list < PingTarget* > >::iterator i = targets.begin (); i != targets.end (); i++ )
    {
      for ( std::list < PingTarget * >::iterator i2 = i->second.begin (); i2 != i->second.end (); i2++ )
	{
	  PingTarget * target = *i2;
	  target->tick ();
	}
    }
}

void PingServer::loop ()
{
  while ( true )
    {
      receive ( loopDelay );
      tick ();
    }
}

PingServer::~PingServer ()
{
  close ( sock_icmp );
}
