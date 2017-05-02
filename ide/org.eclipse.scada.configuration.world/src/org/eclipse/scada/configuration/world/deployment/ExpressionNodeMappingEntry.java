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
package org.eclipse.scada.configuration.world.deployment;

import java.util.regex.Pattern;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression Node Mapping Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Replace the hostname with an case insensitive regular expression. The replacement string may reference capture groups using the dollar ($) sign. See also java.util.regex.Matcher.replaceAll - http://docs.oracle.com/javase/7/docs/api/java/util/regex/Matcher.html#replaceAll%28java.lang.String%29
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.ExpressionNodeMappingEntry#getPattern <em>Pattern</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.deployment.ExpressionNodeMappingEntry#getReplacement <em>Replacement</em>}</li>
 * </ul>
 *
 * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage#getExpressionNodeMappingEntry()
 * @model
 * @generated
 */
public interface ExpressionNodeMappingEntry extends MappingEntry
{
    /**
     * Returns the value of the '<em><b>Pattern</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Pattern</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Pattern</em>' attribute.
     * @see #setPattern(Pattern)
     * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage#getExpressionNodeMappingEntry_Pattern()
     * @model dataType="org.eclipse.scada.configuration.world.Pattern" required="true"
     * @generated
     */
    Pattern getPattern ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.deployment.ExpressionNodeMappingEntry#getPattern <em>Pattern</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Pattern</em>' attribute.
     * @see #getPattern()
     * @generated
     */
    void setPattern ( Pattern value );

    /**
     * Returns the value of the '<em><b>Replacement</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Replacement</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Replacement</em>' attribute.
     * @see #setReplacement(String)
     * @see org.eclipse.scada.configuration.world.deployment.DeploymentPackage#getExpressionNodeMappingEntry_Replacement()
     * @model required="true"
     * @generated
     */
    String getReplacement ();

    /**
     * Sets the value of the '{@link org.eclipse.scada.configuration.world.deployment.ExpressionNodeMappingEntry#getReplacement <em>Replacement</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Replacement</em>' attribute.
     * @see #getReplacement()
     * @generated
     */
    void setReplacement ( String value );

} // ExpressionNodeMappingEntry
