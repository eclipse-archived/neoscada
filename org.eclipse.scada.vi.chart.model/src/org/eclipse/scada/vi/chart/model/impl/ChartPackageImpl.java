/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.chart.model.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.scada.vi.chart.model.ChartFactory;
import org.eclipse.scada.vi.chart.model.ChartPackage;
import org.eclipse.scada.vi.chart.model.ChartView;
import org.eclipse.scada.vi.model.VisualInterfacePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ChartPackageImpl extends EPackageImpl implements ChartPackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass chartViewEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.eclipse.scada.vi.chart.model.ChartPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private ChartPackageImpl ()
    {
        super ( eNS_URI, ChartFactory.eINSTANCE );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link ChartPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static ChartPackage init ()
    {
        if ( isInited )
            return (ChartPackage)EPackage.Registry.INSTANCE.getEPackage ( ChartPackage.eNS_URI );

        // Obtain or create and register package
        ChartPackageImpl theChartPackage = (ChartPackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof ChartPackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new ChartPackageImpl () );

        isInited = true;

        // Initialize simple dependencies
        VisualInterfacePackage.eINSTANCE.eClass ();

        // Create package meta-data objects
        theChartPackage.createPackageContents ();

        // Initialize created meta-data
        theChartPackage.initializePackageContents ();

        // Mark meta-data to indicate it can't be changed
        theChartPackage.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( ChartPackage.eNS_URI, theChartPackage );
        return theChartPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getChartView ()
    {
        return chartViewEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getChartView_ConfigurationUri ()
    {
        return (EAttribute)chartViewEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ChartFactory getChartFactory ()
    {
        return (ChartFactory)getEFactoryInstance ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents ()
    {
        if ( isCreated )
            return;
        isCreated = true;

        // Create classes and their features
        chartViewEClass = createEClass ( CHART_VIEW );
        createEAttribute ( chartViewEClass, CHART_VIEW__CONFIGURATION_URI );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents ()
    {
        if ( isInitialized )
            return;
        isInitialized = true;

        // Initialize package
        setName ( eNAME );
        setNsPrefix ( eNS_PREFIX );
        setNsURI ( eNS_URI );

        // Obtain other dependent packages
        VisualInterfacePackage theVisualInterfacePackage = (VisualInterfacePackage)EPackage.Registry.INSTANCE.getEPackage ( VisualInterfacePackage.eNS_URI );

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        chartViewEClass.getESuperTypes ().add ( theVisualInterfacePackage.getFigure () );

        // Initialize classes and features; add operations and parameters
        initEClass ( chartViewEClass, ChartView.class, "ChartView", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getChartView_ConfigurationUri (), ecorePackage.getEString (), "configurationUri", null, 1, 1, ChartView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        // Create resource
        createResource ( eNS_URI );
    }

} //ChartPackageImpl
