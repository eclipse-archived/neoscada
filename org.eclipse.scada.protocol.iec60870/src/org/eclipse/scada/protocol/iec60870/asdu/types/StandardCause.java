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
package org.eclipse.scada.protocol.iec60870.asdu.types;

public enum StandardCause implements Cause
{
    INVALID ( (short)0, null ),
    PERIODIC ( (short)1, "per/cyc" ),
    BACKGROUND ( (short)2, "back" ),
    SPONTANEOUS ( (short)3, "spont" ),
    INITIAL ( (short)4, "init" ),
    REQUEST ( (short)5, "req" ),
    ACTIVATED ( (short)6, "act" ),
    ACTIVATION_CONFIRM ( (short)7, "actcon" ),
    DEACTIVATED ( (short)8, "deact" ),
    DEACTIVATION_CONFIRM ( (short)9, "deactcon" ),
    ACTIVATION_TERMINATION ( (short)10, "actterm" ),
    RETURN_REMOTE ( (short)11, "retrem" ),
    RETURN_LOCAL ( (short)12, "retloc" ),
    FILE_TRANSMISSION ( (short)13, "file" ),

    STATION_REQUEST ( (short)20, "inrogen" ),
    GROUP_REQUEST_1 ( (short)21, "inro1" ),
    GROUP_REQUEST_2 ( (short)22, "inro2" ),
    GROUP_REQUEST_3 ( (short)23, "inro3" ),
    GROUP_REQUEST_4 ( (short)24, "inro4" ),
    GROUP_REQUEST_5 ( (short)25, "inro5" ),
    GROUP_REQUEST_6 ( (short)26, "inro6" ),
    GROUP_REQUEST_7 ( (short)27, "inro7" ),
    GROUP_REQUEST_8 ( (short)28, "inro8" ),
    GROUP_REQUEST_9 ( (short)29, "inro9" ),
    GROUP_REQUEST_10 ( (short)30, "inro10" ),
    GROUP_REQUEST_11 ( (short)31, "inro11" ),
    GROUP_REQUEST_12 ( (short)32, "inro12" ),
    GROUP_REQUEST_13 ( (short)33, "inro13" ),
    GROUP_REQUEST_14 ( (short)34, "inro14" ),
    GROUP_REQUEST_15 ( (short)35, "inro15" ),
    GROUP_REQUEST_16 ( (short)36, "inro16" ),

    COUNTER_GENERAL ( (short)37, "reqcogen" ),
    COUNTER_GROUP_1 ( (short)38, "reqco1" ),
    COUNTER_GROUP_2 ( (short)39, "reqco2" ),
    COUNTER_GROUP_3 ( (short)40, "reqco3" ),
    COUNTER_GROUP_4 ( (short)41, "reqco4" ),

    UNKNOWN_TYPE ( (short)44, null ),
    UNKNOWN_REASON ( (short)45, null ),
    UNKNOWN_ASDU_ADDRESS ( (short)46, null ),
    UNKNOWN_INFORMATION_OBJECT_ADDRESS ( (short)47, null );

    private short value;

    private String label;

    private StandardCause ( final short value, final String label )
    {
        this.value = value;
        this.label = label;
    }

    public String getLabel ()
    {
        return this.label;
    }

    @Override
    public String toString ()
    {
        return this.label != null ? String.format ( "[%s:%s]", this.value, this.label ) : String.format ( "[%s]", this.value );
    }

    @Override
    public short getValue ()
    {
        return this.value;
    }
}
