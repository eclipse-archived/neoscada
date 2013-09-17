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
package org.eclipse.scada.utils;

import org.eclipse.scada.utils.concurrent.ListeningFutureTest;
import org.eclipse.scada.utils.exec.AsyncOperationTest;
import org.eclipse.scada.utils.exec.SyncOperationTest;
import org.eclipse.scada.utils.str.EncoderTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith ( Suite.class )
@Suite.SuiteClasses ( { ListeningFutureTest.class, AsyncOperationTest.class, EncoderTest.class, SyncOperationTest.class } )
public class TestSuite
{
}
