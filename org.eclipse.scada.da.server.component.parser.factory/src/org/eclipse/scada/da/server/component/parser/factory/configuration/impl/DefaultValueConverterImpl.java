/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 */
package org.eclipse.scada.da.server.component.parser.factory.configuration.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.scada.base.extractor.convert.ValueConverter;
import org.eclipse.scada.da.server.component.parser.factory.configuration.DefaultValueConverter;
import org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '
 * <em><b>Default Value Converter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DefaultValueConverterImpl extends MinimalEObjectImpl.Container implements DefaultValueConverter
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DefaultValueConverterImpl ()
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
        return ParserPackage.Literals.DEFAULT_VALUE_CONVERTER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public ValueConverter createConverter ()
    {
        return org.eclipse.scada.base.extractor.convert.DefaultValueConverter.INSTANCE;
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
            case ParserPackage.DEFAULT_VALUE_CONVERTER___CREATE_CONVERTER:
                return createConverter ();
        }
        return super.eInvoke ( operationID, arguments );
    }

} //DefaultValueConverterImpl
