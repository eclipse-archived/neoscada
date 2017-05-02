/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - additional work
 *******************************************************************************/
package org.eclipse.scada.ae.ui.views;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS
{
    private static final ResourceBundle RESOURCE_BUNDLE;

    private static final String BUNDLE_NAME = "org.eclipse.scada.ae.ui.views.messages"; //$NON-NLS-1$

    // public static String Acknowledge;

    public static String ID;

    public static String AckTimestamp;

    public static String AckUser;

    public static String State;

    public static String Timestamp;

    public static String Value;

    public static String Item;

    public static String ItemDescription;

    public static String Message;

    public static String MonitorsViewTable_LastFailValue;

    public static String MonitorsViewTable_StatusTimestamp;

    public static String MonitorsViewTable_Severity;

    public static String from;

    public static String to;

    public static String search_for_events;

    public static String search_for_events_description;

    // public static String QBE;

    // public static String free_form_query;

    public static String filter_must_not_be_null;

    public static String custom_field;

    public static String add_assertion;

    public static String not;

    public static String argument;

    public static String remove;

    public static String a_condition;

    public static String add_or_condition;

    public static String clear;

    public static String sourceTimestamp;

    public static String entryTimestamp;

    public static String message;

    public static String monitorType;

    public static String eventType;

    public static String item;

    public static String value;

    public static String priority;

    public static String source;

    public static String actorType;

    public static String actorName;

    public static String component;

    public static String system;

    public static String hive;

    public static String location;

    public static String messageSource;

    public static String comment;

    static
    {
        // initialize resource bundle
        NLS.initializeMessages ( BUNDLE_NAME, Messages.class );
        RESOURCE_BUNDLE = ResourceBundle.getBundle ( BUNDLE_NAME );
    }

    private Messages ()
    {
    }

    public static String getString ( final String key )
    {
        try
        {
            return RESOURCE_BUNDLE.getString ( key );
        }
        catch ( final MissingResourceException e )
        {
            return key;
        }
    }
}
