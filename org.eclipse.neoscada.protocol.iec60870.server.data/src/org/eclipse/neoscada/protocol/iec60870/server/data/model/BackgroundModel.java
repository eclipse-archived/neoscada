/*******************************************************************************
 * Copyright (c) 2016 Red Hat Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat Inc - initial API and implementation
 *******************************************************************************/
package org.eclipse.neoscada.protocol.iec60870.server.data.model;

import java.util.Optional;

import org.eclipse.neoscada.protocol.iec60870.server.data.BackgroundIterator;

public interface BackgroundModel
{
    public static final BackgroundModel NONE = new BackgroundModel () {

        @Override
        public Optional<BackgroundIterator> createBackgroundIterator ()
        {
            return Optional.empty ();
        }

        @Override
        public Runnable dispose ()
        {
            return () -> {
            };
        }
    };

    /**
     * Create a new background iterator
     *
     * @return a new optional background iterator instance, never returns null
     */
    public Optional<BackgroundIterator> createBackgroundIterator ();

    public Runnable dispose ();
}
