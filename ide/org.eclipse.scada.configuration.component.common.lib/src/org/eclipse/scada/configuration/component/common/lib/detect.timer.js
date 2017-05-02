// eval
if ( !(lastChange === undefined) && lastChange != null )
	java.lang.System.currentTimeMillis() - lastChange < heartbeatTimeout;
else
	null;