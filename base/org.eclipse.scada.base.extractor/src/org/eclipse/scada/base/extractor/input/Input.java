/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.base.extractor.input;

import org.eclipse.scada.base.extractor.transform.Transformer;

public interface Input
{
    public interface Listener
    {
        public void processInput ( Data data );
    }

    public void addInputListener ( Listener listener );

    public void removeInputListener ( Listener listener );

    public void setTransformers ( final Transformer[] transformers );

    public void addTransformer ( final Transformer transformer );

    public void removeTransformer ( final Transformer transformer );

    public void start ();

    public void stop ();

    public void dispose ();
}
