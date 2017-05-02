/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.details.swt.impl.visibility;

public interface VisibilityProvider
{
    public interface Listener
    {
        public void visibilityChanged ( boolean state );
    }

    public void addListener ( Listener listener );

    public void removeListener ( Listener listener );

    public void dispose ();
}
