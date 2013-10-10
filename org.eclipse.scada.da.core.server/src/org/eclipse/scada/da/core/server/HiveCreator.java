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
package org.eclipse.scada.da.core.server;

/**
 * @since 1.1
 */
public interface HiveCreator
{
    public static final String SERVICE_REFERENCE_TYPE = "openscada.hiveReferenceType";

    public Hive createHive ( String reference, Object configuration ) throws Exception;
}
