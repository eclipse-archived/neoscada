/*******************************************************************************
 * Copyright (c) 2014, 2016 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *     Red Hat Inc - enhancements
 *******************************************************************************/
package org.eclipse.neoscada.releng.p2.to.maven;

import java.util.List;

import org.eclipse.equinox.p2.metadata.IInstallableUnit;

public interface MavenMapping
{
    public List<MavenReference> makeReference ( IInstallableUnit iu ) throws Exception;
}
