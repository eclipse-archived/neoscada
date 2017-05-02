/*******************************************************************************
 * Copyright (c) 2006, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.statuscodes;

import org.eclipse.scada.utils.lang.Immutable;

@Immutable
public class StatusCode
{
    private final String moduleCode;

    private final String subModuleCode;

    private final long code;

    private final SeverityLevel severity;

    public StatusCode ( final String module, final String subModule, final long code, final SeverityLevel severity )
    {
        this.moduleCode = module;
        this.subModuleCode = subModule;
        this.code = code;
        this.severity = severity;
    }

    public String getModuleCode ()
    {
        return this.moduleCode;
    }

    public String getSubModuleCode ()
    {
        return this.subModuleCode;
    }

    public long getNumberCode ()
    {
        return this.code;
    }

    public SeverityLevel getSeverity ()
    {
        return this.severity;
    }

    @Override
    public String toString ()
    {
        final String statusCode = String.format ( "%s-%s-%08X", this.moduleCode, this.subModuleCode, this.code );
        return statusCode;
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) ( this.code ^ this.code >>> 32 );
        result = prime * result + ( this.moduleCode == null ? 0 : this.moduleCode.hashCode () );
        result = prime * result + ( this.subModuleCode == null ? 0 : this.subModuleCode.hashCode () );
        return result;
    }

    @Override
    public boolean equals ( final Object obj )
    {
        if ( this == obj )
        {
            return true;
        }
        if ( obj == null )
        {
            return false;
        }
        if ( getClass () != obj.getClass () )
        {
            return false;
        }
        final StatusCode other = (StatusCode)obj;
        if ( this.code != other.code )
        {
            return false;
        }
        if ( this.moduleCode == null )
        {
            if ( other.moduleCode != null )
            {
                return false;
            }
        }
        else if ( !this.moduleCode.equals ( other.moduleCode ) )
        {
            return false;
        }
        if ( this.subModuleCode == null )
        {
            if ( other.subModuleCode != null )
            {
                return false;
            }
        }
        else if ( !this.subModuleCode.equals ( other.subModuleCode ) )
        {
            return false;
        }
        return true;
    }

}
