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
package org.eclipse.scada.configuration.component.lib.create;

import java.util.Collection;

import org.eclipse.scada.configuration.world.osgi.DataType;
import org.eclipse.scada.configuration.world.osgi.Item;

public interface CreationRequest<T extends Item>
{
    public CreationRequest<T> localTags ( String... localTags );

    public CreationRequest<T> localTags ( Collection<String> localTags );

    public CreationRequest<T> customizationTags ( String... tags );

    public CreationRequest<T> customizationTags ( Collection<String> tags );

    public CreationRequest<T> dataType ( DataType dataType );

    public CreationRequest<T> information ( String description, String unit, String system );

    public T create ();

    public void addMasterListener ( MasterListener<T> masterListener );
}