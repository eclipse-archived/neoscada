#!/bin/bash
# init file for @@appName@@
#
# chkconfig: - 50 50
# description: Eclipse SCADA application instance @@appName@@
#
# processname: /usr/bin/scada.app.@@appName@@.launcher
# pidfile: /var/run/scada.app.@@appName@@.pid

### BEGIN INIT INFO
# Provides: scada.app.@@appName@@
# Required-Start: $local_fs $network
# Required-Stop: $local_fs $network
# Should-Start: 
# Should-Stop: 
# Default-Start: 
# Default-Stop: 
# Short-Description: start and stop Eclipse SCADA application instance @@appName@@
# Description: Eclipse SCADA application instance @@appName@@
### END INIT INFO

USER=neoscada

# source function library
if [ -r /etc/init.d/functions ]; then
    . /etc/init.d/functions
    es_failure () { failure ; }
    es_success () { success ; }
    es_start () { daemon --user=$USER --pidfile="$pidfile" "$prog" ; }
    es_stop () { killproc -p "$pidfile" "$prog" ; }
    es_check () { echo ; }
    es_exit () { exit $RETVAL ; }
fi
if [ -r /etc/rc.status ]; then
    . /etc/rc.status
    es_failure () { rc_failed "$?" ; }
    es_success () { true ; }
    es_check () { rc_status -v ; }
    es_start () { startproc -u $USER -p "$pidfile" "$prog" ; }
    es_stop () { killproc -p "$pidfile" "$prog" ; }
    es_exit () { rc_exit ; }
    rc_reset
fi

. /etc/default/$USER

RETVAL=0
instanceName="@@appName@@"
pidfile="/var/run/scada.app.@@appName@@.pid"
prog="/usr/bin/scada.app.@@appName@@.launcher"

start (){
    echo -n $"Starting application instance - $instanceName: "
    if [ $UID -ne 0 ]; then
		RETVAL=1
		es_failure
    elif [ ! -d ~$USER/"$instanceName" ]; then
		RETVAL=2
		es_failure
    else
		es_start
		RETVAL=$?
    fi
    es_check
    return $RETVAL
}

stop () {
    echo -n $"Stopping application instance - $instanceName: "
    if [ $UID -ne 0 ]; then
		RETVAL=1
		es_failure
    else
		es_stop
		RETVAL=$?
    fi
    es_check
    return $RETVAL
}

status () {
    if [ -e "$pidfile" ]; then
	echo "running: `cat "$pidfile"`"
    else
	echo "not running"
    fi
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
