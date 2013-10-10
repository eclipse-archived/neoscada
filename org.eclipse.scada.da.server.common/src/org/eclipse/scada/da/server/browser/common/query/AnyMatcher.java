/*******************************************************************************
 * Copyright (c) 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.browser.common.query;

/**
 * A matcher that matches any item descriptor
 * @author Jens Reimann
 *
 */
public class AnyMatcher implements Matcher
{

    public boolean matches ( final ItemDescriptor desc )
    {
        return true;
    }

}
