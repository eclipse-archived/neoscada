if ( @@inMin@@ > @@inMax@@ ) {
	var r = "MIN(@@inMin@@) > MAX(@@inMax@@)";
	if ( @@value@@ > @@inMin@@) {
	   throw "Out of range (" + r + "): @@value@@ = " + @@value@@ + "; @@value@@ > @@inMin@@";
	}
	if ( @@value@@ < @@inMax@@) {
		   throw "Out of range (" + r + "): @@value@@ = " + @@value@@ + "; @@value@@ < @@inMax@@";
	}
} else {
	var r = "MIN(@@inMin@@) < MAX(@@inMax@@)";
	if ( @@value@@ > @@inMax@@) {
	   throw "Out of range (" + r + "): @@value@@ = " + @@value@@ + "; @@value@@ > @@inMax@@";
	}
	if ( @@value@@ < @@inMin@@) {
	   throw "Out of range (" + r + "): @@value@@ = " + @@value@@ + "; @@value@@ < @@inMin@@";
	}
}
