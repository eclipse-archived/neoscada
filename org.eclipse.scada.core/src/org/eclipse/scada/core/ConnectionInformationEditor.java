/*******************************************************************************
 * Copyright (c) 2006, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.core;

import java.beans.PropertyEditorSupport;

/**
 * A property editor for the {@link ConnectionInformation} class
 * 
 * @author Jens Reimann
 * @since 0.12
 */
public class ConnectionInformationEditor extends PropertyEditorSupport
{
    @Override
    public void setAsText ( final String text ) throws IllegalArgumentException
    {
        setValue ( ConnectionInformation.fromURI ( text ) );
    }
}
