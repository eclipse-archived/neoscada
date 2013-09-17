/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.sec.callback;

import java.util.Map;

/**
 * @since 1.1
 */
public class ConfirmationCallback extends LabelCallback
{
    public static final String TYPE = "confirm";

    private static final String PROP_CONFIRMATION_TYPE = "confirmationType";

    public static final String PROP_VALUE = "value";

    private Boolean value;

    private ConfirmationType confirmationType;

    public static enum ConfirmationType
    {
        /**
         * Show an information message. Always returns true.
         */
        INFORMATION,
        /**
         * Show a warning message. Always returns true.
         */
        WARNING,
        /**
         * Show an error message. Always returns true.
         */
        ERROR,
        /**
         * Ask for confirmation (ok, cancel). Returns true or false.
         */
        CONFIRM,
        /**
         * Ask for confirmation (yes, no). Returns true or false.
         */
        QUESTION,
        /**
         * Ask for confirmation (yes, no, cancel). Returns true or false. If the
         * user presses cancel the request will be aborted, not canceled.
         */
        QUESTION_WITH_CANCEL;
    }

    public ConfirmationCallback ()
    {
    }

    public ConfirmationCallback ( final ConfirmationType type, final String label, final int order )
    {
        super ( label, order );
        this.confirmationType = type == null ? ConfirmationType.CONFIRM : type;
    }

    public ConfirmationType getConfirmationType ()
    {
        return this.confirmationType;
    }

    public void setConfirmationType ( final ConfirmationType confirmationType )
    {
        this.confirmationType = confirmationType;
    }

    public void setValue ( final Boolean value )
    {
        this.value = value;
    }

    public Boolean getValue ()
    {
        return this.value;
    }

    @Override
    public String getType ()
    {
        return TYPE;
    }

    @Override
    public void parseRequestAttributes ( final Map<String, String> attributes )
    {
        super.parseRequestAttributes ( attributes );
        this.confirmationType = ConfirmationType.valueOf ( attributes.get ( PROP_CONFIRMATION_TYPE ) );
    }

    @Override
    protected void injectRequestAttributes ( final Map<String, String> request )
    {
        super.injectRequestAttributes ( request );
        request.put ( PROP_CONFIRMATION_TYPE, this.confirmationType.name () );
    }

    @Override
    public void parseResponseAttributes ( final Map<String, String> attributes )
    {
        final String result = attributes.get ( PROP_VALUE );
        if ( result != null )
        {
            this.value = Boolean.parseBoolean ( result );
        }
        else
        {
            this.value = null;
        }
    }

    @Override
    protected void injectResponseAttributes ( final Map<String, String> result )
    {
        super.injectResponseAttributes ( result );
        if ( this.value != null )
        {
            result.put ( PROP_VALUE, "" + this.value );
        }
    }
}
