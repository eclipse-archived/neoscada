/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.infrastructure.lib;

import java.util.Collection;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.IValidationContext;

public interface DriverValidator<T>
{
    public void validate ( final IValidationContext ctx, final T driver, final Collection<IStatus> result );
}
