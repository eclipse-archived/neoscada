/*******************************************************************************
 * Copyright (c) 2006, 2011 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.osgi;

import org.osgi.framework.ServiceReference;

public interface SingleServiceListener<T>
{
    /**
     * The method is called when the service instance has changed
     * 
     * @param reference
     *            the new service reference or <code>null</code> if no matching
     *            service is availabe
     * @param service
     *            the new service instance or <code>null</code> if no matching
     *            service is availabe
     */
    public void serviceChange ( ServiceReference<T> reference, T service );
}
