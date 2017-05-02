/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.driver.parser;

import org.eclipse.emf.common.util.EList;
import org.eclipse.scada.configuration.infrastructure.AbstractEquinoxDriver;
import org.eclipse.scada.da.server.component.parser.factory.configuration.Component;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Host</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.driver.parser.ParserComponentHost#getComponents <em>Components</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.driver.parser.ParserPackage#getParserComponentHost()
 * @model
 * @generated
 */
public interface ParserComponentHost extends AbstractEquinoxDriver
{
    /**
     * Returns the value of the '<em><b>Components</b></em>' containment reference list.
     * The list contents are of type {@link org.eclipse.scada.da.server.component.parser.factory.configuration.Component}.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Components</em>' containment reference list isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Components</em>' containment reference list.
     * @see org.eclipse.scada.configuration.driver.parser.ParserPackage#getParserComponentHost_Components()
     * @model containment="true" resolveProxies="true"
     * @generated
     */
    EList<Component> getComponents ();

} // ParserComponentHost
