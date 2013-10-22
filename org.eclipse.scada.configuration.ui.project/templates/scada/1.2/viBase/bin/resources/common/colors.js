/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
var background = {
	"invalid": "#e958fe", // magenta
	"error": "#e958fe", // magenta
	"blocked": "#222222",
	"manual": "#6495ED", // blueish
	"alarm": "#EB3525", // red
	"warning": "#ffde25", // yellowish
	"ok": "#FFFFFF",
};

var foreground = {
	"invalid": "#C0C0C0",
	"alarm": "#C0C0C0",
	"ok": "#00FF00",
};

function colorToString ( color )
{
	if ( color == null )
		return null;
	
	return color.toHex ();
}

function convertColorStyleToString ( colors )
{
	var result = "";
	
	var len = colors.size();
	for ( var i = 0; i < len;i++ )
		{
			var color = colors.get(i);
			
			if ( result != "" ) result += "|";
			if ( color != null )
				result += colorToString ( color );
		}
	
	return result;
}

function getBackgroundStyleForSummary ( summary, defaultColor )
{
	var styles = styleGenerator.generateStyle ( summary.getStateInformation () );
	
	var result = convertColorStyleToString ( styles.getBackgroundColorAsList () );
	
	if ( result == "" )
		return defaultColor;
	else
		return result;
}

function getBackgroundStyle ( data )
{
	return getBackgroundStyleForSummary ( data.getSummary(), background["ok"] );
}