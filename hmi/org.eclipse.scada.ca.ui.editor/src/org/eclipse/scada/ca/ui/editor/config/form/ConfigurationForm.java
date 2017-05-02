/*******************************************************************************
 * Copyright (c) 2012, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.ca.ui.editor.config.form;

import org.eclipse.scada.ca.ui.editor.input.ConfigurationEditorInput;
import org.eclipse.swt.widgets.Composite;

public interface ConfigurationForm
{
    public void createFormPart ( Composite parent, ConfigurationEditorInput input );

    public void dispose ();

    public void setFocus ();
}
