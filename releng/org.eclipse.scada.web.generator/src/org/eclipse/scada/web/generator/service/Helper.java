/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.web.generator.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.eclipse.emf.common.util.URI;

public class Helper {

	public String formatDateUrl(String format, Date date) {
		if (date == null)
			date = new Date();
		return new SimpleDateFormat(format).format(date);
	}

	public String permaEncode(String title) throws UnsupportedEncodingException {
		title = title.toLowerCase();
		title = title.replaceAll("[^a-zA-Z0-9]", "_");
		return title;
	}

	public String encodeHtml(String string) {
		if ( string == null )
			return null;
		
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
	
	public Integer getIndex ( Date date ) 
	{
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int result = c.get(Calendar.YEAR) * 100 + (c.get(Calendar.MONTH)+1);
		return result;
	}
	
	public String makeArchiveLabel ( Integer value  )
	{
		int month = ( value % 100 ) -1 ;
		int year = value / 100;
		Calendar c = Calendar.getInstance();
		c.set(year, month, 1);
		return new SimpleDateFormat("MMMM yyyy").format(c.getTime());
	}
	
	public String archiveLink ( Integer value  )
	{
		int month = ( value % 100 ) ;
		int year = value / 100;
		return String.format ("%04d/%02d", year, month);
	}
	
	public String currentYear ()
	{
		Calendar c = new GregorianCalendar();
		return "" + c.get(Calendar.YEAR);
	}
}
