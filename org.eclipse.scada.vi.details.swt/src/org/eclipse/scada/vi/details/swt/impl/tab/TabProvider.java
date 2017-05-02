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
package org.eclipse.scada.vi.details.swt.impl.tab;

import org.eclipse.scada.vi.data.SummaryProvider;
import org.eclipse.swt.widgets.Composite;

public interface TabProvider
{

    public interface Folder
    {
        public Composite getContainer ();

        void setVisible ( boolean visible );

        public void dispose ();

        public void setSummaryProvider ( SummaryProvider summaryProvider );
    }

    public Folder createFolder ( int index, String label );

    public void dispose ();
}
