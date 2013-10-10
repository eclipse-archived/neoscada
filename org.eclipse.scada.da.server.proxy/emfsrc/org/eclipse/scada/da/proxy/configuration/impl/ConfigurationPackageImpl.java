/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.proxy.configuration.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.scada.da.proxy.configuration.ConfigurationFactory;
import org.eclipse.scada.da.proxy.configuration.ConfigurationPackage;
import org.eclipse.scada.da.proxy.configuration.ConnectionType;
import org.eclipse.scada.da.proxy.configuration.DocumentRoot;
import org.eclipse.scada.da.proxy.configuration.FolderType;
import org.eclipse.scada.da.proxy.configuration.ProxyType;
import org.eclipse.scada.da.proxy.configuration.RootType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConfigurationPackageImpl extends EPackageImpl implements ConfigurationPackage
{
    //$NON-NLS-1$

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass connectionTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass documentRootEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass folderTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass proxyTypeEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass rootTypeEClass = null;

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
     * @see org.eclipse.scada.da.proxy.configuration.ConfigurationPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private ConfigurationPackageImpl ()
    {
        super ( eNS_URI, ConfigurationFactory.eINSTANCE );
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
     * <p>This method is used to initialize {@link ConfigurationPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static ConfigurationPackage init ()
    {
        if ( isInited )
            return (ConfigurationPackage)EPackage.Registry.INSTANCE.getEPackage ( ConfigurationPackage.eNS_URI );

        // Obtain or create and register package
        ConfigurationPackageImpl theConfigurationPackage = (ConfigurationPackageImpl) ( EPackage.Registry.INSTANCE.get ( eNS_URI ) instanceof ConfigurationPackageImpl ? EPackage.Registry.INSTANCE.get ( eNS_URI ) : new ConfigurationPackageImpl () );

        isInited = true;

        // Initialize simple dependencies
        XMLTypePackage.eINSTANCE.eClass ();

        // Create package meta-data objects
        theConfigurationPackage.createPackageContents ();

        // Initialize created meta-data
        theConfigurationPackage.initializePackageContents ();

        // Mark meta-data to indicate it can't be changed
        theConfigurationPackage.freeze ();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put ( ConfigurationPackage.eNS_URI, theConfigurationPackage );
        return theConfigurationPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getConnectionType ()
    {
        return connectionTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getConnectionType_Folder ()
    {
        return (EReference)connectionTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getConnectionType_ClassName ()
    {
        return (EAttribute)connectionTypeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getConnectionType_Id ()
    {
        return (EAttribute)connectionTypeEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getConnectionType_Prefix ()
    {
        return (EAttribute)connectionTypeEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getConnectionType_Uri ()
    {
        return (EAttribute)connectionTypeEClass.getEStructuralFeatures ().get ( 4 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getDocumentRoot ()
    {
        return documentRootEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getDocumentRoot_Mixed ()
    {
        return (EAttribute)documentRootEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_XMLNSPrefixMap ()
    {
        return (EReference)documentRootEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_XSISchemaLocation ()
    {
        return (EReference)documentRootEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getDocumentRoot_Root ()
    {
        return (EReference)documentRootEClass.getEStructuralFeatures ().get ( 3 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getFolderType ()
    {
        return folderTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFolderType_Group ()
    {
        return (EAttribute)folderTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getFolderType_Location ()
    {
        return (EAttribute)folderTypeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getProxyType ()
    {
        return proxyTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getProxyType_Connection ()
    {
        return (EReference)proxyTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProxyType_Prefix ()
    {
        return (EAttribute)proxyTypeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getProxyType_Wait ()
    {
        return (EAttribute)proxyTypeEClass.getEStructuralFeatures ().get ( 2 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getRootType ()
    {
        return rootTypeEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getRootType_Proxy ()
    {
        return (EReference)rootTypeEClass.getEStructuralFeatures ().get ( 0 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getRootType_Separator ()
    {
        return (EAttribute)rootTypeEClass.getEStructuralFeatures ().get ( 1 );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ConfigurationFactory getConfigurationFactory ()
    {
        return (ConfigurationFactory)getEFactoryInstance ();
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
        connectionTypeEClass = createEClass ( CONNECTION_TYPE );
        createEReference ( connectionTypeEClass, CONNECTION_TYPE__FOLDER );
        createEAttribute ( connectionTypeEClass, CONNECTION_TYPE__CLASS_NAME );
        createEAttribute ( connectionTypeEClass, CONNECTION_TYPE__ID );
        createEAttribute ( connectionTypeEClass, CONNECTION_TYPE__PREFIX );
        createEAttribute ( connectionTypeEClass, CONNECTION_TYPE__URI );

        documentRootEClass = createEClass ( DOCUMENT_ROOT );
        createEAttribute ( documentRootEClass, DOCUMENT_ROOT__MIXED );
        createEReference ( documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP );
        createEReference ( documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION );
        createEReference ( documentRootEClass, DOCUMENT_ROOT__ROOT );

        folderTypeEClass = createEClass ( FOLDER_TYPE );
        createEAttribute ( folderTypeEClass, FOLDER_TYPE__GROUP );
        createEAttribute ( folderTypeEClass, FOLDER_TYPE__LOCATION );

        proxyTypeEClass = createEClass ( PROXY_TYPE );
        createEReference ( proxyTypeEClass, PROXY_TYPE__CONNECTION );
        createEAttribute ( proxyTypeEClass, PROXY_TYPE__PREFIX );
        createEAttribute ( proxyTypeEClass, PROXY_TYPE__WAIT );

        rootTypeEClass = createEClass ( ROOT_TYPE );
        createEReference ( rootTypeEClass, ROOT_TYPE__PROXY );
        createEAttribute ( rootTypeEClass, ROOT_TYPE__SEPARATOR );
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
        XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage ( XMLTypePackage.eNS_URI );

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes

        // Initialize classes, features, and operations; add parameters
        initEClass ( connectionTypeEClass, ConnectionType.class, "ConnectionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getConnectionType_Folder (), this.getFolderType (), null, "folder", null, 0, 1, ConnectionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getConnectionType_ClassName (), theXMLTypePackage.getString (), "className", null, 1, 1, ConnectionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getConnectionType_Id (), theXMLTypePackage.getString (), "id", null, 1, 1, ConnectionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getConnectionType_Prefix (), theXMLTypePackage.getString (), "prefix", null, 1, 1, ConnectionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getConnectionType_Uri (), theXMLTypePackage.getString (), "uri", null, 1, 1, ConnectionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getDocumentRoot_Mixed (), ecorePackage.getEFeatureMapEntry (), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getDocumentRoot_XMLNSPrefixMap (), ecorePackage.getEStringToStringMapEntry (), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getDocumentRoot_XSISchemaLocation (), ecorePackage.getEStringToStringMapEntry (), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEReference ( getDocumentRoot_Root (), this.getRootType (), null, "root", null, 0, -2, null, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( folderTypeEClass, FolderType.class, "FolderType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEAttribute ( getFolderType_Group (), ecorePackage.getEFeatureMapEntry (), "group", null, 0, -1, FolderType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getFolderType_Location (), theXMLTypePackage.getString (), "location", null, 0, -1, FolderType.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$

        initEClass ( proxyTypeEClass, ProxyType.class, "ProxyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getProxyType_Connection (), this.getConnectionType (), null, "connection", null, 1, -1, ProxyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getProxyType_Prefix (), theXMLTypePackage.getString (), "prefix", null, 1, 1, ProxyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getProxyType_Wait (), theXMLTypePackage.getInt (), "wait", "0", 0, 1, ProxyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        initEClass ( rootTypeEClass, RootType.class, "RootType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS ); //$NON-NLS-1$
        initEReference ( getRootType_Proxy (), this.getProxyType (), null, "proxy", null, 1, -1, RootType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$
        initEAttribute ( getRootType_Separator (), theXMLTypePackage.getString (), "separator", ".", 0, 1, RootType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED ); //$NON-NLS-1$ //$NON-NLS-2$

        // Create resource
        createResource ( eNS_URI );

        // Create annotations
        // http:///org/eclipse/emf/ecore/util/ExtendedMetaData
        createExtendedMetaDataAnnotations ();
    }

    /**
     * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void createExtendedMetaDataAnnotations ()
    {
        String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData"; //$NON-NLS-1$		
        addAnnotation ( connectionTypeEClass, source, new String[] { "name", "ConnectionType", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getConnectionType_Folder (), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "folder", //$NON-NLS-1$ //$NON-NLS-2$
        "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getConnectionType_ClassName (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "className" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getConnectionType_Id (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "id" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getConnectionType_Prefix (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "prefix" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getConnectionType_Uri (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "uri" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( documentRootEClass, source, new String[] { "name", "", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "mixed" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getDocumentRoot_Mixed (), source, new String[] { "kind", "elementWildcard", //$NON-NLS-1$ //$NON-NLS-2$
        "name", ":mixed" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getDocumentRoot_XMLNSPrefixMap (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "xmlns:prefix" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getDocumentRoot_XSISchemaLocation (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "xsi:schemaLocation" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getDocumentRoot_Root (), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "root", //$NON-NLS-1$ //$NON-NLS-2$
        "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( folderTypeEClass, source, new String[] { "name", "FolderType", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getFolderType_Group (), source, new String[] { "kind", "group", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "group:0" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getFolderType_Location (), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "location", //$NON-NLS-1$ //$NON-NLS-2$
        "namespace", "##targetNamespace", //$NON-NLS-1$ //$NON-NLS-2$
        "group", "#group:0" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( proxyTypeEClass, source, new String[] { "name", "ProxyType", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getProxyType_Connection (), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "connection", //$NON-NLS-1$ //$NON-NLS-2$
        "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getProxyType_Prefix (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "prefix" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getProxyType_Wait (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "wait" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( rootTypeEClass, source, new String[] { "name", "RootType", //$NON-NLS-1$ //$NON-NLS-2$
        "kind", "elementOnly" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getRootType_Proxy (), source, new String[] { "kind", "element", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "proxy", //$NON-NLS-1$ //$NON-NLS-2$
        "namespace", "##targetNamespace" //$NON-NLS-1$ //$NON-NLS-2$
        } );
        addAnnotation ( getRootType_Separator (), source, new String[] { "kind", "attribute", //$NON-NLS-1$ //$NON-NLS-2$
        "name", "separator" //$NON-NLS-1$ //$NON-NLS-2$
        } );
    }

} //ConfigurationPackageImpl
