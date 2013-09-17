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
package org.eclipse.scada.utils.exec;

public interface LongRunningOperation
{

    public abstract boolean isComplete ();

    public abstract Throwable getError ();

    public abstract void waitForCompletion () throws InterruptedException;

    public abstract void waitForCompletion ( int timeout ) throws InterruptedException;

}