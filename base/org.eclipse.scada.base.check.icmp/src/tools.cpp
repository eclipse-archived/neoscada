#include "tools.h"

/*
 * in_cksum and tvsub extracted from:
 *      ping.c
 *
 *  see http://ws.edu.isoc.org/materials/src/ping.c
 *
 *  Modified:
 *      Jens Reimann <jens.reimann@ibh-systems.com> in order to
 *      compile with recent C++ compilers
 */

/*
 *                      P I N G . C
 *
 * Using the InterNet Control Message Protocol (ICMP) "ECHO" facility,
 * measure round-trip-delays and packet loss across network paths.
 *
 * Author -
 *      Mike Muuss
 *      U. S. Army Ballistic Research Laboratory
 *      December, 1983
 * Modified at Uc Berkeley
 *
 * Changed argument to inet_ntoa() to be struct in_addr instead of u_long
 * DFM BRL 1992
 *
 * Status -
 *      Public Domain.  Distribution Unlimited.
 *
 * Bugs -
 *      More statistics could always be gathered.
 *      This program has to run SUID to ROOT to access the ICMP socket.
 */

u_short in_cksum(u_short *addr, int len)
{
        register int nleft = len;
        register u_short *w = addr;
        register u_short answer;
        register int sum = 0;

        /*
         *  Our algorithm is simple, using a 32 bit accumulator (sum),
         *  we add sequential 16 bit words to it, and at the end, fold
         *  back all the carry bits from the top 16 bits into the lower
         *  16 bits.
         */
        while( nleft > 1 )  {
                sum += *w++;
                nleft -= 2;
        }

        /* mop up an odd byte, if necessary */
        if( nleft == 1 ) {
                u_short u = 0;

                *(u_char *)(&u) = *(u_char *)w ;
                sum += u;
        }

        /*
         * add back carry outs from top 16 bits to low 16 bits
         */
        sum = (sum >> 16) + (sum & 0xffff);     /* add hi 16 to low 16 */
        sum += (sum >> 16);                     /* add carry */
        answer = ~sum;                          /* truncate to 16 bits */
        return (answer);
}

uint64_t time_diff( struct timeval *in, struct timeval *out )
{
	uint64_t dsec = out->tv_sec - in->tv_sec;
	uint64_t dusec = out->tv_usec - in->tv_usec;

	printf ( "%ld - %ld\n", dsec, dusec );

	return ( dsec * 1000L * 1000L ) + dusec;
}
