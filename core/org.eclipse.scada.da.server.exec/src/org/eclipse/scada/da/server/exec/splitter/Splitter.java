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
package org.eclipse.scada.da.server.exec.splitter;

public interface Splitter
{
    /**
     * Split of lines from the buffer
     * @param inputBuffer the input buffer to split
     * @return a result or <code>null</code> if there was nothing to split off
     */
    public SplitResult split ( String inputBuffer );
}
