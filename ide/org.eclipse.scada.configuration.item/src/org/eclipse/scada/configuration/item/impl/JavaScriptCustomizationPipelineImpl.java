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
package org.eclipse.scada.configuration.item.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.scada.configuration.item.ItemPackage;
import org.eclipse.scada.configuration.item.JavaScriptCustomizationPipeline;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Java Script Customization Pipeline</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class JavaScriptCustomizationPipelineImpl extends ScriptCustomizationPipelineImpl implements JavaScriptCustomizationPipeline
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected JavaScriptCustomizationPipelineImpl ()
    {
        super ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass ()
    {
        return ItemPackage.Literals.JAVA_SCRIPT_CUSTOMIZATION_PIPELINE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getScriptEngine ()
    {
        return "JavaScript";
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eInvoke ( int operationID, EList<?> arguments ) throws InvocationTargetException
    {
        switch ( operationID )
        {
            case ItemPackage.JAVA_SCRIPT_CUSTOMIZATION_PIPELINE___GET_SCRIPT_ENGINE:
                return getScriptEngine ();
        }
        return super.eInvoke ( operationID, arguments );
    }

} //JavaScriptCustomizationPipelineImpl
