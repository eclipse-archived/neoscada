function evalActive () {
	var value = data.get("INPUT");

	if (!(value === undefined) && value != null && value.isConnected() && !value.isError () ) {
		var c = value.getValue ();
		if ( c != null ) {
			return c.asBoolean ();
		}
	}

	return false;	
}

function currentState () {
	return active ? state : null;
}

var active = false;