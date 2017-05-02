/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.init;

/**
 * Initialization interface
 * 
 * @author Jens Reimann
 */
public interface Initializer
{
    /**
     * Perform initialization for a specific type
     * <p>
     * The idea is to join in initializing all stuff related to the provided
     * type. So the type can for example by the string
     * <q>emf</q> and then all initializers which want to join that
     * initialization phase simply perform their initialization when the method
     * is called with the string
     * <q>emf</q>.
     * </p>
     * 
     * @param type
     *            the type to initialize
     */
    public void initialize ( Object type );
}
