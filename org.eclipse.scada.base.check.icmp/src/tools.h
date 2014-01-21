/*******************************************************************************
 * Copyright (c) 2008, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - prepare for Eclipse SCADA contribution
 *******************************************************************************/
#ifndef TOOLS_H_
#define TOOLS_H_

#include "headers.h"

u_short in_cksum ( void * data, int len );
uint64_t tvsub ( struct timeval * out, struct timeval * in );

#endif /* TOOLS_H_ */
