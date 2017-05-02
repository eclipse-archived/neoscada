/*******************************************************************************
 * Copyright (c) 2009, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.hd.server;

import org.eclipse.scada.hd.ItemListListener;

/**
 * The session object for HD services
 * @author Jens Reimann
 * @since 0.14.0
 *
 */
public interface Session extends org.eclipse.scada.core.server.Session
{
    public void setItemListListener ( ItemListListener itemListListener );
}
