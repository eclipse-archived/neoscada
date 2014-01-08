function evalActive () {
	var value = data.get("INPUT");
	activeValue = value;
	
	if (!(value === undefined) && value != null && value.isConnected() && !value.isError () ) {
		var c = value.getValue ();
		if ( c != null ) {
			return c.asBoolean ();
		}
	}

	return false;	
}

function currentState () {
	var b = new org.eclipse.scada.da.datasource.script.DataItemValueBuilder ();
	b.setConnected ( true );
	
	if ( active )
		b.setValue ( org.eclipse.scada.core.Variant.valueOf ( state ) );

	if (!(activeValue === undefined) && activeValue != null ) {
		b.setAttribute ( "input.value.raw", org.eclipse.scada.core.Variant.valueOf ( "" + activeValue.getValue () ) );
		if ( activeValue.getValue () != null )
			b.setAttribute ( "input.value", org.eclipse.scada.core.Variant.valueOf ( activeValue.getValue ().asBoolean () ) );
		b.setAttribute ( "input.connected", org.eclipse.scada.core.Variant.valueOf ( activeValue.isConnected () ) );
	}
	
	return b;
}

var activeValue = null;
var active = false;