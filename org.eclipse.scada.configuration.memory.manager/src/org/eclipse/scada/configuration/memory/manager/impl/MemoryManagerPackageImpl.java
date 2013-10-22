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
package org.eclipse.scada.configuration.memory.manager.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.scada.configuration.memory.MemoryPackage;
import org.eclipse.scada.configuration.memory.manager.MemoryManagerFactory;
import org.eclipse.scada.configuration.memory.manager.MemoryManagerModule;
import org.eclipse.scada.configuration.memory.manager.MemoryManagerPackage;
import org.eclipse.scada.configuration.world.WorldPackage;
import org.eclipse.scada.configuration.world.osgi.OsgiPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MemoryManagerPackageImpl extends EPackageImpl implements MemoryManagerPackage
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass memoryManagerModuleEClass = null;

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
     * @see org.eclipse.scada.configuration.memory.manager.MemoryManagerPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private MemoryManagerPackageImpl ()
    {
        super ( eNS_URI, MemoryManagerFactory.eINSTANCE );
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
     * <p>This method is used to initialize {@link MemoryManagerPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static MemoryManagerPackage init ()
    {
        if ( isInited )
            return (MemoryManagerPackage)EPackage.Registry.INSTANCE.getEPackage ( MemoryManagerPackage.eNS_URI );

        // Obtain or create and register package
        MemoryManagerPackageImpl theMemoryManagerPackage = (MemoryManagerPackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof MemoryManagerPackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new MemoryManagerPackageImpl () );

        isInited = true;

        // Initialize simple dependencies
        MemoryPackage.eINSTANCE.eClass ();
        WorldPackage.eINSTANCE.eClass ();

        // Create package meta-data objects
        theMemoryManagerPackage.createPackageContents ();

        // Initialize created meta-data
        theMemoryManagerPackage.initializePackageContents ();

        // Mark meta-data to indicate it can't be changed
        theMemoryManagerPackage.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( MemoryManagerPackage.eNS_URI, theMemoryManagerPackage );
        return theMemoryManagerPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getMemoryManagerModule ()
    {
        return memoryManagerModuleEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getMemoryManagerModule_TypeSystem ()
    {
        return (EReference)memoryManagerModuleEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MemoryManagerFactory getMemoryManagerFactory ()
    {
        return (MemoryManagerFactory)getEFactoryInstance ();
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
        memoryManagerModuleEClass = createEClass ( MEMORY_MANAGER_MODULE );
        createEReference ( memoryManagerModuleEClass, MEMORY_MANAGER_MODULE__TYPE_SYSTEM );
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
        OsgiPackage theOsgiPackage = (OsgiPackage)EPackage.Registry.INSTANCE.getEPackage ( OsgiPackage.eNS_URI );
        MemoryPackage theMemoryPackage = (MemoryPackage)EPackage.Registry.INSTANCE.getEPackage ( MemoryPackage.eNS_URI );

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        memoryManagerModuleEClass.getESuperTypes ().add ( theOsgiPackage.getApplicationConfiguration () );

        // Initialize classes, features, and operations; add parameters
        initEClass ( memoryManagerModuleEClass, MemoryManagerModule.class, "MemoryManagerModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getMemoryManagerModule_TypeSystem (), theMemoryPackage.getTypeSystem (), null, "typeSystem", null, 1, 1, MemoryManagerModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        // Create resource
        createResource ( eNS_URI );

        // Create annotations
        // http://eclipse.org/SCADA/Configuration/ExclusiveGroup
        createExclusiveGroupAnnotations ();
    }

    /**
     * Initializes the annotations for <b>http://eclipse.org/SCADA/Configuration/ExclusiveGroup</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createExclusiveGroupAnnotations ()
    {
        String source = "http://eclipse.org/SCADA/Configuration/ExclusiveGroup"; //$NON-NLS-1$		
        addAnnotation ( memoryManagerModuleEClass,
                source,
                new String[]
                {       "groupId", "memory.manager" //$NON-NLS-1$ //$NON-NLS-2$
                } );
    }

} //MemoryManagerPackageImpl
