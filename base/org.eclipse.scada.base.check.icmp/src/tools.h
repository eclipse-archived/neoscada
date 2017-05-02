/*******************************************************************************
 * Copyright (c) 2008, 2014 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - prepare for Eclipse SCADA contribution
 *                        re-implement time diff
 *******************************************************************************/
#ifndef TOOLS_H_
#define TOOLS_H_

#include "headers.h"

u_short in_cksum ( u_short * data, int len );
uint64_t time_diff ( struct timeval * out, struct timeval * in );

#endif /* TOOLS_H_ */
