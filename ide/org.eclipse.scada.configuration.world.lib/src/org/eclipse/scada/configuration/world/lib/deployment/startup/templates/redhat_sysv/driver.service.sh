#!/bin/bash
# init file for @@driverName@@
#
# chkconfig: - 50 50
# description: Eclipse SCADA driver instance @@driverName@@
#
# processname: /usr/bin/jsvc
# config: /etc/neoscada/drivers/@@driverName@@/
# pidfile: /var/run/driver.@@driverName@@.pid

### BEGIN INIT INFO
# Provides: scada.driver.@@driverName@@
# Required-Start: $local_fs $network
# Required-Stop: $local_fs $network
# Should-Start: 
# Should-Stop: 
# Default-Start: 
# Default-Stop: 
# Short-Description: start and stop Eclipse SCADA Driver instance @@driverName@@
# Description: Eclipse SCADA driver instance @@driverName@@
### END INIT INFO

# source function library
if [ -r /etc/init.d/functions ]; then
    . /etc/init.d/functions
    es_failure () { failure ; }
    es_success () { success ; }
    es_check () { echo ; }
    es_exit () { exit $RETVAL ; }
fi
if [ -r /etc/rc.status ]; then
    . /etc/rc.status
    es_failure () { rc_failed $? ; }
    es_success () { true ; }
    es_check () { rc_status -v ; }
    es_exit () { rc_exit ; }
    rc_reset
fi

RETVAL=0
instanceName="@@driverName@@"
pidfile="/var/run/driver.@@driverName@@.pid"

start (){
    echo -n $"Starting driver instance - $instanceName: "
    if [ $UID -ne 0 ]; then
	    RETVAL=1
	    es_failure
    else
	    esDriverExporter "$instanceName" && es_success || es_failure
	    RETVAL=$?
    fi;
    es_check
    return $RETVAL
}

stop () {
    echo -n $"Stopping driver instance - $instanceName: "
    if [ $UID -ne 0 ]; then
	    RETVAL=1
	    es_failure
    else
	    esDriverExporter "$instanceName" -stop && es_success || es_failure
	    RETVAL=$?
    fi;
    es_check
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

es_exit
