var value = values.get("A");

if (!(value === undefined) && value != null && value.isConnected() && !value.isError () ) {
	var c = value.getTimestamp();
	if (c != null) {
		lastChange = c.getTimeInMillis ();
	}
}

// eval
if ( !(lastChange === undefined) && lastChange != null )
	java.lang.System.currentTimeMillis() - lastChange < heartbeatTimeout;
else
	null;