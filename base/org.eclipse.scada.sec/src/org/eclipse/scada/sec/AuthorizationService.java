/*******************************************************************************
 * Copyright (c) 2010, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     Jens Reimann - further development
 *******************************************************************************/
package org.eclipse.scada.sec;

import java.util.Map;

import org.eclipse.scada.sec.authz.AuthorizationRule;

/**
 * An interface for a service authorizing an operation
 * <p>
 * The authorization service only acts on already authenticated user information
 * objects.
 * </p>
 * 
 * @author Jens Reimann
 * @since 0.15.0
 */
public interface AuthorizationService
{
    public static final String RULE_TYPES = "rule.types";

    public AuthorizationRule createRule ( Map<String, String> properties ) throws Exception;

}
