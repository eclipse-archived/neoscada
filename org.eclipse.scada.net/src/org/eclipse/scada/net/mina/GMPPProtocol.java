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
package org.eclipse.scada.net.mina;

public interface GMPPProtocol
{

    public final static int VT_STRING = 0x000000001;

    public final static int VT_LONG = 0x000000002;

    public final static int VT_DOUBLE = 0x000000003;

    public final static int VT_VOID = 0x000000004;

    public final static int VT_INTEGER = 0x000000005;

    public final static int VT_LIST = 0x000000006;

    public final static int VT_MAP = 0x000000007;

    public final static int VT_BOOLEAN = 0x000000008;

    public final int HEADER_SIZE = 4 + 8 + 8 + 8 + 4;

}
