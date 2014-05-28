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
package org.eclipse.scada.configuration.driver.parser.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.scada.configuration.driver.parser.ParserDriver;
import org.eclipse.scada.configuration.driver.parser.ParserFactory;
import org.eclipse.scada.configuration.driver.parser.ParserPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class ParserFactoryImpl extends EFactoryImpl implements ParserFactory
{
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public static ParserFactory init ()
    {
        try
        {
            final ParserFactory theParserFactory = (ParserFactory)EPackage.Registry.INSTANCE
                    .getEFactory ( ParserPackage.eNS_URI );
            if ( theParserFactory != null )
            {
                return theParserFactory;
            }
        }
        catch ( final Exception exception )
        {
            EcorePlugin.INSTANCE.log ( exception );
        }
        return new ParserFactoryImpl ();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public ParserFactoryImpl ()
    {
        super ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EObject create ( final EClass eClass )
    {
        switch ( eClass.getClassifierID () )
        {
            case ParserPackage.PARSER_DRIVER:
                return createParserDriver ();
            default:
                throw new IllegalArgumentException (
                        "The class '" + eClass.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ParserDriver createParserDriver ()
    {
        final ParserDriverImpl parserDriver = new ParserDriverImpl ();
        return parserDriver;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ParserPackage getParserPackage ()
    {
        return (ParserPackage)getEPackage ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @deprecated
     * @generated
     */
    @Deprecated
    public static ParserPackage getPackage ()
    {
        return ParserPackage.eINSTANCE;
    }

} //ParserFactoryImpl
