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
package org.eclipse.scada.configuration.script;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.configuration.script.ScriptPackage
 * @generated
 */
public interface ScriptFactory extends EFactory
{
    /**
     * The singleton instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    ScriptFactory eINSTANCE = org.eclipse.scada.configuration.script.impl.ScriptFactoryImpl.init ();

    /**
     * Returns a new object of class '<em>Generic Script</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Generic Script</em>'.
     * @generated
     */
    GenericScript createGenericScript ();

    /**
     * Returns a new object of class '<em>Java Script</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Java Script</em>'.
     * @generated
     */
    JavaScript createJavaScript ();

    /**
     * Returns a new object of class '<em>Reference</em>'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return a new object of class '<em>Reference</em>'.
     * @generated
     */
    ScriptReference createScriptReference ();

    /**
     * Returns the package supported by this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the package supported by this factory.
     * @generated
     */
    ScriptPackage getScriptPackage ();

} //ScriptFactory
