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

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.scada.configuration.infrastructure.Device;
import org.eclipse.scada.configuration.infrastructure.Driver;
import org.eclipse.scada.configuration.infrastructure.MasterImport;
import org.eclipse.scada.configuration.item.CustomizationRequest;
import org.eclipse.scada.configuration.world.osgi.ChangeCounterItem;
import org.eclipse.scada.configuration.world.osgi.ChangeType;
import org.eclipse.scada.configuration.world.osgi.ConstantItem;
import org.eclipse.scada.configuration.world.osgi.ErrorHandling;
import org.eclipse.scada.configuration.world.osgi.Item;
import org.eclipse.scada.configuration.world.osgi.PersistentItem;
import org.eclipse.scada.configuration.world.osgi.ReferenceItem;
import org.eclipse.scada.configuration.world.osgi.SourceItem;
import org.eclipse.scada.configuration.world.osgi.TransientItem;
import org.eclipse.scada.core.Variant;

public interface ItemCreator
{
    public abstract void createMarker ( IStatus status );

    public abstract CreationRequest<PersistentItem> createPersistentItem ();

    public abstract CreationRequest<TransientItem> createTransientItem ();

    public abstract CreationRequest<ConstantItem> createConstantItem ( String value );

    public abstract CreationRequest<ChangeCounterItem> createChangeCounterItem (ChangeType changeType, ErrorHandling errorHandling, List<Variant> values);

    public abstract CreationRequest<ReferenceItem> createReferenceItem ( Item item );

    public abstract CreationRequest<SourceItem> createSelfItem ( String sourceName );

    public abstract CreationRequest<SourceItem> createSourceItem ( Driver source, String sourceName );

    public abstract CreationRequest<SourceItem> createImportItem ( MasterImport masterImport, String sourceName );

    public abstract <T extends Device> CreationRequest<SourceItem> createDeviceItem ( T device, String sourceName );

    public abstract <T extends Item> T addItem ( T item, CustomizationRequest customizationRequest );

    public abstract <T extends Item> CreationRequest<T> addItem ( T item );

    public void markUnsupported ();
}
