#!/bin/bash
# init file for $$appName$$
#
# chkconfig: - 50 50
# description: Eclipse SCADA driver instance $$appName$$
#
# processname: /usr/bin/jsvc
# pidfile: /var/run/$$appName$$.pid

### BEGIN INIT INFO
# Provides: scada.app.$$appName$$
# Required-Start: $local_fs $network
# Required-Stop: $local_fs $network
# Should-Start: 
# Should-Stop: 
# Default-Start: 
# Default-Stop: 
# Short-Description: start and stop Eclipse SCADA application instance $$appName$$
# Description: Eclipse SCADA application instance $$appName$$
### END INIT INFO

# source function library
. /etc/init.d/functions
. /etc/default/eclipsescada

RETVAL=0
instanceName="$$appName$$"
pidfile="/var/run/eclipsescada/scada.app.$instanceName.pid"
prog="/usr/bin/scada.app.$$appName$$.launcher"

start (){
    echo -n $"Starting application instance - $instanceName: "
    if [ $UID -ne 0 ]; then
	RETVAL=1
	failure
    elif [ ! -d ~eclipsescada/"$instanceName" ]; then
	RETVAL=2
	failure
    else
	daemon --user="eclipsescada" --pidfile="$pidfile" "$prog"
	RETVAL=$?
    fi;
    echo
    return $RETVAL
}

stop () {
    echo -n $"Stopping application instance - $instanceName: "
    if [ $UID -ne 0 ]; then
	RETVAL=1
	failure
    else
	killproc -p "$pidfile" "$prog"
	RETVAL=$?
    fi;
    echo
    return $RETVAL
}

status () {
    if [ -e "$pidfile" ]; then
	echo "running: `cat "$pidfile"`"
    else
	echo "not running"
    fi;
}

restart(){
    stop
    start
}

condrestart(){
    [ -e "$pidfile" ] && restart
    return 0
}

case "$1" in
  start)
        start
        RETVAL=$?
        ;;
  stop)
        stop
        RETVAL=$?
        ;;
  restart)
        restart
        RETVAL=$?
        ;;
  status)
	status
        RETVAL=$?
        ;;
  condrestart|try-restart)
        condrestart
        RETVAL=$?
        ;;
  *)
        echo $"Usage: $0 {start|stop|status|restart|condrestart}"
        RETVAL=2
esac

exit $RETVAL
