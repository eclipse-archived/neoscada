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

instanceName="@@driverName@@"
pidfile="/var/run/driver.@@driverName@@.pid"

set -e

. /lib/lsb/init-functions

start (){
    log_daemon_msg "Starting driver instance: @@driverName@@"
    esDriverExporter "$instanceName"
    log_end_msg $?
}

stop () {
    log_daemon_msg "Stopping driver instance: @@driverName@@"
    esDriverExporter "$instanceName" -stop
    log_end_msg $?
    rm -rf "$pidfile"
}

status () {
    if [ -e "$pidfile" ]; then
       pid="`cat "$pidfile"`"
	    log_success_msg "Driver instance @@driverName@@ running: $pid"
    else
	    log_success_msg "Driver instance @@driverName@@ not running"
    fi;
}

restart(){
    stop
    start
}

condrestart(){
    [ -e "$pidfile" ] && restart
}

case "$1" in
  start)
        start
        ;;
  stop)
        stop
        ;;
  restart)
        restart
        ;;
  condrestart|try-restart)
        condrestart
        ;;
  status)
        status
        ;;
  *)
        echo "Usage: $0 {start|stop|status|restart|condrestart}"
        exit 1
esac

exit 0

