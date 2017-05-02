/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ae.ui.views.dialog;

import org.eclipse.scada.utils.lang.Pair;

public interface FilterChangedListener
{
    public void onFilterChanged ( Pair<SearchType, String> filter );

    public void onFilterParseError ( Pair<SearchType, String> error );
}
