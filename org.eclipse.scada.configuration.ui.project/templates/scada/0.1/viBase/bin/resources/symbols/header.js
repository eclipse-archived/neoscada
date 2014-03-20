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
// set the background to gray for the header
background["ok"] = "#B4B5B4";

function initSymbol() {
	// title
	controller.getElement("title").setText(
			controller.getProperty("title", "<Title>")
	);

	// item
	var sum = controller.getProperty("sumItem");
	if (sum != null) {
		controller.registerItem("sum", controller.getProperty("sumItem"),
				controller.getProperty("connection"));
	}

	if (getViewId() != null) {
		controller.getElement("title").setCursor("HAND");
	}

	if (getDetailsId() != null) {
		controller.getElement("infoImage").setVisible(true);
	}
}

function updateSymbol() {
	setBackgroundStyle(getBackgroundStyle(data));
}

function setBackgroundStyle(style) {
	controller.getElement("background").setBackgroundColor(style);
}

function getViewId() {
	return controller.getProperty("viewId");
}

function getDetailsId() {
	return controller.getProperty("detailsId");
}

function openView() {
	var viewId = getViewId();
	if (viewId != null) {
		viewManager.showView(viewId);
	}
}

function header_openDetails() {
	var detailsId = getDetailsId();
	var details = controller.getProperty("details");
	if (details === undefined || details === null) {
		openDetailDialogById(detailsId);
	} else {
		openDetailDialogWithProperties(detailsId, details);
	}
}