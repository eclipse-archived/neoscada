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
package org.eclipse.scada.base.json;

import org.eclipse.scada.core.VariantEditor;
import org.eclipse.scada.core.VariantType;

/**
 * Variant JSON encoding
 * <p>
 * The variant is encoded as JSON object with two fields: <code>type</code> and
 * <code>value</code>. Type contains the type string from {@link VariantType}
 * (except {@link VariantType#UNKNOWN}. Value contains the data encoded in the
 * type of the variant. If the type is <code>null</code> then the field is set
 * to <code>null</code> for when serialized, but when deserialized the value is
 * ignored.
 * </p>
 * <h2>Deserialization</h2>
 * <p>
 * For the deserialization there are several options. The variant can be encoded
 * as primitive (including null). So the type will be guessed by the value that
 * is coming in, which might not always be what you expect. If it is a string,
 * the type prefix handling of {@link VariantEditor} will be used (e.g.
 * <q>INT32#1</q>).
 * </p>
 * <p>
 * In addition it can be provided as it is serialized (with <code>type</code>
 * and <code>value</code> fields.
 * </p>
 * 
 * @author Jens Reimann
 */
public interface VariantJson
{
    public static final String FIELD_TYPE = "type"; //$NON-NLS-1$

    public static final String FIELD_VALUE = "value"; //$NON-NLS-1$
}
