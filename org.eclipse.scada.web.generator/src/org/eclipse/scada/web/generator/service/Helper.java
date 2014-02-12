package org.eclipse.scada.web.generator.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.emf.common.util.URI;

public class Helper {

	public String formatDateUrl(String format, Date date) {
		if (date == null)
			date = new Date();
		return new SimpleDateFormat(format).format(date);
	}

	public String parmaEncode(String title) throws UnsupportedEncodingException {
		title = title.toLowerCase();
		title = title.replaceAll("[^a-z]", "_");
		return title;
	}

	public String encodeHtml(String string) {
		// FIXME: we could do better than that with an additional library
		string = string.replace("&", "&amp;");
		string = string.replace("<", "&lt;");
		string = string.replace(">", "&gt;");
		string = string.replace("\"", "&quot;");
		return string;
	}

	public String md5(String string) {
		string = string.toLowerCase();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] data = md.digest(string.getBytes("CP1252"));
			StringBuffer sb = new StringBuffer();
			for (byte b : data) {
				sb.append(String.format("%02x", b));
			}
			return sb.toString();
		} catch (Exception e) {
			return null;
		}
	}
	
	public String relative ( String base, String uri )
	{
		URI baseUri = URI.createURI(base);
		return URI.createURI(uri).deresolve(baseUri,false,true,false).toString();
	}
	
	public String encodeUrl ( String url ) throws UnsupportedEncodingException
	{
		return URLEncoder.encode(url,"UTF-8");
	}
	
	// FIXME: make method for making a URL relative
}
