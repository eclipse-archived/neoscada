#!/bin/bash
# init file for $$driverName$$
#
# chkconfig: - 50 50
# description: Eclipse SCADA driver instance $$driverName$$
#
# processname: /usr/bin/jsvc
# config: /etc/eclipsescada/drivers/$$driverName$$/
# pidfile: /var/run/$$driverName$$.pid

### BEGIN INIT INFO
# Provides: scada.driver.$$driverName$$
# Required-Start: $local_fs $network
# Required-Stop: $local_fs $network
# Should-Start: 
# Should-Stop: 
# Default-Start: 
# Default-Stop: 
# Short-Description: start and stop Eclipse SCADA Driver instance $$driverName$$
# Description: Eclipse SCADA driver instance $$driverName$$
### END INIT INFO

# source function library
. /lib/

RETVAL=0
instanceName="$$driverName$$"
pidfile="/var/run/$instanceName.pid"

start (){
    echo -n $"Starting driver instance - $instanceName: "
    if [ $UID -ne 0 ]; then
	RETVAL=1
	failure
    else
	esDriverExporter "$instanceName" && success || failure
	RETVAL=$?
    fi;
    echo
    return $RETVAL
}

stop () {
    echo -n $"Stopping driver instance - $instanceName: "
    if [ $UID -ne 0 ]; then
	RETVAL=1
	failure
    else
	esDriverExporter "$instanceName" -stop && success || failure
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
