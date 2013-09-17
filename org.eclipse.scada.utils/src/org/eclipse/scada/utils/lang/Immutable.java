/*******************************************************************************
 * Copyright (c) 2006, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.lang;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Tags a class as following the immutable pattern
 * 
 * @author Jens Reiman
 * @since 0.13.0
 */
@Target ( ElementType.TYPE )
public @interface Immutable
{
}
