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
package org.eclipse.scada.da.server.common;

/**
 * An enum which defines how attributes are provided
 * @author Jens Reimann
 *
 */
public enum AttributeMode
{
    /**
     * All attributes are set. This is a full set of all attributes and not a difference
     * set. All previously known attributes have to be cleared out and only the new set
     * must be used.
     */
    SET,
    /**
     * Only changed attributes are provided. This set of attributes contains only the
     * changed ones which need to be merged with the already exisiting attributes.
     */
    UPDATE
}
