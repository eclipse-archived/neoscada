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
/*
 * opens item detail dialog
 */
function openItemDetails(connectionId, itemId) {
	println("Opening item detail dialog: " + connectionId + "#" + itemId);
	controller
			.executeCommand(
					"org.eclipse.scada.da.client.dataitem.details.openDetailsDialog",
					{
						"org.eclipse.scada.da.client.dataitem.details.itemId" : itemId,
						"org.eclipse.scada.da.client.dataitem.details.connectionId" : connectionId
					});
}

/*
 * opens detail dialog given by detailId from properties
 */
function openDetailDialogDefault() {
	println("called openDetailDialogDefault with: id = "
			+ controller.getProperty("detailsId") + ", properties = "
			+ controller.getPropertiesAsMap());
	controller.executeCommand("org.eclipse.scada.vi.details.showDetailDialog", {
		"org.eclipse.scada.vi.details.showDetailDialog.id" : controller
				.getProperty("detailsId"),
		"org.eclipse.scada.vi.details.showDetailDialog.parameters" : GSON
				.toJson(controller.getPropertiesAsMap())
	});
}

/*
 * opens detail dialog with explicit id
 */
function openDetailDialogById(id) {
	println("called openDetailDialogDefault with: id = " + id
			+ ", properties = " + controller.getPropertiesAsMap());
	controller.executeCommand("org.eclipse.scada.vi.details.showDetailDialog", {
		"org.eclipse.scada.vi.details.showDetailDialog.id" : id,
		"org.eclipse.scada.vi.details.showDetailDialog.parameters" : GSON
				.toJson(controller.getPropertiesAsMap())
	});
}

/*
 * opens detail dialog with explicit id, and additional properties which
 * overwrite default properties
 */
function openDetailDialogWithProperties(id, properties) {
	println("called openDetailDialogDefault with: id = " + id
			+ ", implicit properties = " + controller.getPropertiesAsMap()
			+ ", explicit properties = " + dump(properties));
	var finalProperties = new java.util.HashMap(controller.getPropertiesAsMap());
	if (isString(properties)) {
		finalProperties.putAll(GSON.fromJson(properties, java.util.HashMap));
	} else if (isMap(properties)) {
		finalProperties.putAll(properties);
	}
	controller.executeCommand("org.eclipse.scada.vi.details.showDetailDialog", {
		"org.eclipse.scada.vi.details.showDetailDialog.id" : id,
		"org.eclipse.scada.vi.details.showDetailDialog.parameters" : GSON
				.toJson(finalProperties)
	});
}
