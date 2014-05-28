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
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.scada.configuration.driver.parser.ParserDriver;
import org.eclipse.scada.configuration.driver.parser.ParserFactory;
import org.eclipse.scada.configuration.driver.parser.ParserPackage;
import org.eclipse.scada.configuration.world.WorldPackage;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class ParserPackageImpl extends EPackageImpl implements ParserPackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass parserDriverEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
     * package
     * package URI value.
     * <p>
     * Note: the correct way to create the package is via the static factory
     * method {@link #init init()}, which also performs initialization of the
     * package, or returns the registered package, if one already exists. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.eclipse.scada.configuration.driver.parser.ParserPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private ParserPackageImpl ()
    {
        super ( eNS_URI, ParserFactory.eINSTANCE );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model,
     * and for any others upon which it depends.
     * <p>
     * This method is used to initialize {@link ParserPackage#eINSTANCE} when
     * that field is accessed. Clients should not invoke it directly. Instead,
     * they should simply access that field to obtain the package. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static ParserPackage init ()
    {
        if ( isInited )
        {
            return (ParserPackage)EPackage.Registry.INSTANCE
                    .getEPackage ( ParserPackage.eNS_URI );
        }

        // Obtain or create and register package
        final ParserPackageImpl theParserPackage = (ParserPackageImpl) ( EPackage.Registry.INSTANCE
                .get ( eNS_URI ) instanceof ParserPackageImpl ? EPackage.Registry.INSTANCE
                .get ( eNS_URI ) : new ParserPackageImpl () );

        isInited = true;

        // Initialize simple dependencies
        org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage.eINSTANCE
                .eClass ();
        WorldPackage.eINSTANCE.eClass ();

        // Create package meta-data objects
        theParserPackage.createPackageContents ();

        // Initialize created meta-data
        theParserPackage.initializePackageContents ();

        // Mark meta-data to indicate it can't be changed
        theParserPackage.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( ParserPackage.eNS_URI, theParserPackage );
        return theParserPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getParserDriver ()
    {
        return this.parserDriverEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getParserDriver_Components ()
    {
        return (EReference)this.parserDriverEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ParserFactory getParserFactory ()
    {
        return (ParserFactory)getEFactoryInstance ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package. This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void createPackageContents ()
    {
        if ( this.isCreated )
        {
            return;
        }
        this.isCreated = true;

        // Create classes and their features
        this.parserDriverEClass = createEClass ( PARSER_DRIVER );
        createEReference ( this.parserDriverEClass, PARSER_DRIVER__COMPONENTS );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model. This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public void initializePackageContents ()
    {
        if ( this.isInitialized )
        {
            return;
        }
        this.isInitialized = true;

        // Initialize package
        setName ( eNAME );
        setNsPrefix ( eNS_PREFIX );
        setNsURI ( eNS_URI );

        // Obtain other dependent packages
        final WorldPackage theWorldPackage = (WorldPackage)EPackage.Registry.INSTANCE
                .getEPackage ( WorldPackage.eNS_URI );
        final OsgiPackage theOsgiPackage = (OsgiPackage)EPackage.Registry.INSTANCE
                .getEPackage ( OsgiPackage.eNS_URI );
        final org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage theParserPackage_1 = (org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage)EPackage.Registry.INSTANCE
                .getEPackage ( org.eclipse.scada.da.server.component.parser.factory.configuration.ParserPackage.eNS_URI );

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.parserDriverEClass.getESuperTypes ().add ( theWorldPackage.getDriver () );
        this.parserDriverEClass.getESuperTypes ().add (
                theOsgiPackage.getEquinoxApplication () );

        // Initialize classes, features, and operations; add parameters
        initEClass (
                this.parserDriverEClass,
                ParserDriver.class, "ParserDriver", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference (
                getParserDriver_Components (),
                theParserPackage_1.getComponent (),
                null, "components", null, 0, -1, ParserDriver.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        // Create resource
        createResource ( eNS_URI );
    }

} //ParserPackageImpl
