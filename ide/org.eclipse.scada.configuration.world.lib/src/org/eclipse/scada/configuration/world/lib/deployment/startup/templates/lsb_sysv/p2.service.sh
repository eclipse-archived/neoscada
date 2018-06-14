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

set -e

. /lib/lsb/init-functions
. /etc/default/$USER

instanceName="@@appName@@"
pidfile="/var/run/scada.app.@@appName@@.pid"
prog="/usr/bin/scada.app.@@appName@@.launcher"

start (){
   if [ -r "$pidfile" ]; then
      log_failure_msg "PID file exists. Stop first."
      log_end_msg 1
   elif [ $UID -ne 0 ]; then
      log_failure_msg "Must be started with root permissions"
      log_end_msg 2
   elif [ ! -d ~$USER/"$instanceName" ]; then
      log_failure_msg "Instance was not created. Use \"scada.create.@@appName@@\""
      log_end_msg 3
   else
      log_daemon_msg "Starting application instance: @@appName@@"
      set +e
      start-stop-daemon --start --quiet --pidfile "$pidfile" --chuid $USER --exec "$prog"
      set -e
      log_end_msg $?
   fi
}

stop () {
   log_daemon_msg "Stopping application instance: @@appName@@"
   if [ $UID -ne 0 ]; then
      log_failure_msg "Must be stopped with root permissions"
      log_end_msg 1
   else
      set +e
      start-stop-daemon --stop --quiet --pidfile "$pidfile"
      set -e
      log_end_msg $?
      rm -f "$pidfile"
   fi
}

status () {
   if [ -e "$pidfile" ]; then
      log_success_msg "running: `cat "$pidfile"`"
   else
      log_success_msg "not running"
   fi
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
   status)
      status
      ;;
   condrestart|try-restart)
      condrestart
      ;;
  *)
      echo $"Usage: $0 {start|stop|status|restart|condrestart}"
      exit 1
esac

exit 0
