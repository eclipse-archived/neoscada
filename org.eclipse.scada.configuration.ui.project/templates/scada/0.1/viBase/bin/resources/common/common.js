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
// more common

function isString(obj) {
	if (obj === undefined) {
		return false;
	}
	if (obj === null) {
		return false;
	}
	if (typeof obj === "string") {
		return true;
	}
	if (obj instanceof java.lang.String) {
		return true;
	}
	return false;
}

function isMap(obj) {
	if (obj === undefined) {
		return false;
	}
	if (obj === null) {
		return false;
	}
	if (typeof obj === "object") {
		return true;
	}
	if (obj instanceof java.lang.Map) {
		return true;
	}
	return false;
}

function toJavaMap(obj) {
	var result = new java.util.HashMap();
	for ( var key in obj) {
		result.put(key, obj[key]);
	}
	return result;
}

function dump(obj) {
	if (isString(obj)) {
		return "" + obj;
	} else if (isMap(obj)) {
		return "" + toJavaMap(obj);
	} else {
		return "" + obj;
	}
}
