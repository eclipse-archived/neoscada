/**
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.world.osgi;

import org.eclipse.scada.configuration.world.osgi.profile.Profile;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '
 * <em><b>Default Equinox Application</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.osgi.DefaultEquinoxApplication#getProfile <em>Profile</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getDefaultEquinoxApplication()
 * @model
 * @generated
 */
public interface DefaultEquinoxApplication extends EquinoxApplication
{
    /**
     * Returns the value of the '<em><b>Profile</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Profile</em>' reference isn't clear, there
     * really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Profile</em>' reference.
     * @see #setProfile(Profile)
     * @see org.eclipse.scada.configuration.world.osgi.OsgiPackage#getDefaultEquinoxApplication_Profile()
     * @model required="true"
     * @generated
     */
    @Override
    Profile getProfile ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.osgi.DefaultEquinoxApplication#getProfile <em>Profile</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Profile</em>' reference.
     * @see #getProfile()
     * @generated
     */
    void setProfile ( Profile value );

} // DefaultEquinoxApplication
