/**
 * Copyright (c) 2011, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 */
package org.eclipse.scada.vi.model.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.scada.vi.model.Connection;
import org.eclipse.scada.vi.model.Cursor;
import org.eclipse.scada.vi.model.Dimension;
import org.eclipse.scada.vi.model.Primitive;
import org.eclipse.scada.vi.model.Symbol;
import org.eclipse.scada.vi.model.TimeTrigger;
import org.eclipse.scada.vi.model.VisualInterfacePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Symbol</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.scada.vi.model.impl.SymbolImpl#getRoot <em>Root</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.SymbolImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.SymbolImpl#getOnInit <em>On Init</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.SymbolImpl#getOnDispose <em>On Dispose</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.SymbolImpl#getOnUpdate <em>On Update</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.SymbolImpl#getScriptModules <em>Script Modules</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.SymbolImpl#getCursors <em>Cursors</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.SymbolImpl#getBackgroundColor <em>Background Color</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.SymbolImpl#getDesignSize <em>Design Size</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.SymbolImpl#getConnections <em>Connections</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.SymbolImpl#getBackgroundImage <em>Background Image</em>}</li>
 *   <li>{@link org.eclipse.scada.vi.model.impl.SymbolImpl#getTimeTriggers <em>Time Triggers</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SymbolImpl extends EObjectImpl implements Symbol
{
    /**
     * The cached value of the '{@link #getRoot() <em>Root</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getRoot()
     * @generated
     * @ordered
     */
    protected Primitive root;

    /**
     * The cached value of the '{@link #getProperties() <em>Properties</em>}' map.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProperties()
     * @generated
     * @ordered
     */
    protected EMap<String, String> properties;

    /**
     * The default value of the '{@link #getOnInit() <em>On Init</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOnInit()
     * @generated
     * @ordered
     */
    protected static final String ON_INIT_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOnInit() <em>On Init</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOnInit()
     * @generated
     * @ordered
     */
    protected String onInit = ON_INIT_EDEFAULT;

    /**
     * The default value of the '{@link #getOnDispose() <em>On Dispose</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOnDispose()
     * @generated
     * @ordered
     */
    protected static final String ON_DISPOSE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOnDispose() <em>On Dispose</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOnDispose()
     * @generated
     * @ordered
     */
    protected String onDispose = ON_DISPOSE_EDEFAULT;

    /**
     * The default value of the '{@link #getOnUpdate() <em>On Update</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOnUpdate()
     * @generated
     * @ordered
     */
    protected static final String ON_UPDATE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getOnUpdate() <em>On Update</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOnUpdate()
     * @generated
     * @ordered
     */
    protected String onUpdate = ON_UPDATE_EDEFAULT;

    /**
     * The cached value of the '{@link #getScriptModules() <em>Script Modules</em>}' attribute list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getScriptModules()
     * @generated
     * @ordered
     */
    protected EList<String> scriptModules;

    /**
     * The cached value of the '{@link #getCursors() <em>Cursors</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getCursors()
     * @generated
     * @ordered
     */
    protected Cursor cursors;

    /**
     * The default value of the '{@link #getBackgroundColor() <em>Background Color</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBackgroundColor()
     * @generated
     * @ordered
     */
    protected static final String BACKGROUND_COLOR_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getBackgroundColor() <em>Background Color</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBackgroundColor()
     * @generated
     * @ordered
     */
    protected String backgroundColor = BACKGROUND_COLOR_EDEFAULT;

    /**
     * The cached value of the '{@link #getDesignSize() <em>Design Size</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDesignSize()
     * @generated
     * @ordered
     */
    protected Dimension designSize;

    /**
     * The cached value of the '{@link #getConnections() <em>Connections</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getConnections()
     * @generated
     * @ordered
     */
    protected EList<Connection> connections;

    /**
     * The default value of the '{@link #getBackgroundImage() <em>Background Image</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBackgroundImage()
     * @generated
     * @ordered
     */
    protected static final String BACKGROUND_IMAGE_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getBackgroundImage() <em>Background Image</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getBackgroundImage()
     * @generated
     * @ordered
     */
    protected String backgroundImage = BACKGROUND_IMAGE_EDEFAULT;

    /**
     * The cached value of the '{@link #getTimeTriggers() <em>Time Triggers</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTimeTriggers()
     * @generated
     * @ordered
     */
    protected EList<TimeTrigger> timeTriggers;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SymbolImpl ()
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
        return VisualInterfacePackage.Literals.SYMBOL;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Primitive getRoot ()
    {
        return root;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetRoot ( Primitive newRoot, NotificationChain msgs )
    {
        Primitive oldRoot = root;
        root = newRoot;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.SYMBOL__ROOT, oldRoot, newRoot );
            if ( msgs == null )
                msgs = notification;
            else
                msgs.add ( notification );
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setRoot ( Primitive newRoot )
    {
        if ( newRoot != root )
        {
            NotificationChain msgs = null;
            if ( root != null )
                msgs = ( (InternalEObject)root ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - VisualInterfacePackage.SYMBOL__ROOT, null, msgs );
            if ( newRoot != null )
                msgs = ( (InternalEObject)newRoot ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - VisualInterfacePackage.SYMBOL__ROOT, null, msgs );
            msgs = basicSetRoot ( newRoot, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.SYMBOL__ROOT, newRoot, newRoot ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EMap<String, String> getProperties ()
    {
        if ( properties == null )
        {
            properties = new EcoreEMap<String, String> ( VisualInterfacePackage.Literals.STRING_TO_STRING_MAP, StringToStringMapImpl.class, this, VisualInterfacePackage.SYMBOL__PROPERTIES );
        }
        return properties;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getOnInit ()
    {
        return onInit;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOnInit ( String newOnInit )
    {
        String oldOnInit = onInit;
        onInit = newOnInit;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.SYMBOL__ON_INIT, oldOnInit, onInit ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getOnDispose ()
    {
        return onDispose;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOnDispose ( String newOnDispose )
    {
        String oldOnDispose = onDispose;
        onDispose = newOnDispose;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.SYMBOL__ON_DISPOSE, oldOnDispose, onDispose ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getOnUpdate ()
    {
        return onUpdate;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOnUpdate ( String newOnUpdate )
    {
        String oldOnUpdate = onUpdate;
        onUpdate = newOnUpdate;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.SYMBOL__ON_UPDATE, oldOnUpdate, onUpdate ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<String> getScriptModules ()
    {
        if ( scriptModules == null )
        {
            scriptModules = new EDataTypeUniqueEList<String> ( String.class, this, VisualInterfacePackage.SYMBOL__SCRIPT_MODULES );
        }
        return scriptModules;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Cursor getCursors ()
    {
        return cursors;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetCursors ( Cursor newCursors, NotificationChain msgs )
    {
        Cursor oldCursors = cursors;
        cursors = newCursors;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.SYMBOL__CURSORS, oldCursors, newCursors );
            if ( msgs == null )
                msgs = notification;
            else
                msgs.add ( notification );
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCursors ( Cursor newCursors )
    {
        if ( newCursors != cursors )
        {
            NotificationChain msgs = null;
            if ( cursors != null )
                msgs = ( (InternalEObject)cursors ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - VisualInterfacePackage.SYMBOL__CURSORS, null, msgs );
            if ( newCursors != null )
                msgs = ( (InternalEObject)newCursors ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - VisualInterfacePackage.SYMBOL__CURSORS, null, msgs );
            msgs = basicSetCursors ( newCursors, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.SYMBOL__CURSORS, newCursors, newCursors ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getBackgroundColor ()
    {
        return backgroundColor;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBackgroundColor ( String newBackgroundColor )
    {
        String oldBackgroundColor = backgroundColor;
        backgroundColor = newBackgroundColor;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.SYMBOL__BACKGROUND_COLOR, oldBackgroundColor, backgroundColor ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Dimension getDesignSize ()
    {
        return designSize;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDesignSize ( Dimension newDesignSize, NotificationChain msgs )
    {
        Dimension oldDesignSize = designSize;
        designSize = newDesignSize;
        if ( eNotificationRequired () )
        {
            ENotificationImpl notification = new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.SYMBOL__DESIGN_SIZE, oldDesignSize, newDesignSize );
            if ( msgs == null )
                msgs = notification;
            else
                msgs.add ( notification );
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDesignSize ( Dimension newDesignSize )
    {
        if ( newDesignSize != designSize )
        {
            NotificationChain msgs = null;
            if ( designSize != null )
                msgs = ( (InternalEObject)designSize ).eInverseRemove ( this, EOPPOSITE_FEATURE_BASE - VisualInterfacePackage.SYMBOL__DESIGN_SIZE, null, msgs );
            if ( newDesignSize != null )
                msgs = ( (InternalEObject)newDesignSize ).eInverseAdd ( this, EOPPOSITE_FEATURE_BASE - VisualInterfacePackage.SYMBOL__DESIGN_SIZE, null, msgs );
            msgs = basicSetDesignSize ( newDesignSize, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.SYMBOL__DESIGN_SIZE, newDesignSize, newDesignSize ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Connection> getConnections ()
    {
        if ( connections == null )
        {
            connections = new EObjectContainmentEList<Connection> ( Connection.class, this, VisualInterfacePackage.SYMBOL__CONNECTIONS );
        }
        return connections;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getBackgroundImage ()
    {
        return backgroundImage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setBackgroundImage ( String newBackgroundImage )
    {
        String oldBackgroundImage = backgroundImage;
        backgroundImage = newBackgroundImage;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, VisualInterfacePackage.SYMBOL__BACKGROUND_IMAGE, oldBackgroundImage, backgroundImage ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<TimeTrigger> getTimeTriggers ()
    {
        if ( timeTriggers == null )
        {
            timeTriggers = new EObjectContainmentEList<TimeTrigger> ( TimeTrigger.class, this, VisualInterfacePackage.SYMBOL__TIME_TRIGGERS );
        }
        return timeTriggers;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove ( InternalEObject otherEnd, int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case VisualInterfacePackage.SYMBOL__ROOT:
                return basicSetRoot ( null, msgs );
            case VisualInterfacePackage.SYMBOL__PROPERTIES:
                return ( (InternalEList<?>)getProperties () ).basicRemove ( otherEnd, msgs );
            case VisualInterfacePackage.SYMBOL__CURSORS:
                return basicSetCursors ( null, msgs );
            case VisualInterfacePackage.SYMBOL__DESIGN_SIZE:
                return basicSetDesignSize ( null, msgs );
            case VisualInterfacePackage.SYMBOL__CONNECTIONS:
                return ( (InternalEList<?>)getConnections () ).basicRemove ( otherEnd, msgs );
            case VisualInterfacePackage.SYMBOL__TIME_TRIGGERS:
                return ( (InternalEList<?>)getTimeTriggers () ).basicRemove ( otherEnd, msgs );
        }
        return super.eInverseRemove ( otherEnd, featureID, msgs );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet ( int featureID, boolean resolve, boolean coreType )
    {
        switch ( featureID )
        {
            case VisualInterfacePackage.SYMBOL__ROOT:
                return getRoot ();
            case VisualInterfacePackage.SYMBOL__PROPERTIES:
                if ( coreType )
                    return getProperties ();
                else
                    return getProperties ().map ();
            case VisualInterfacePackage.SYMBOL__ON_INIT:
                return getOnInit ();
            case VisualInterfacePackage.SYMBOL__ON_DISPOSE:
                return getOnDispose ();
            case VisualInterfacePackage.SYMBOL__ON_UPDATE:
                return getOnUpdate ();
            case VisualInterfacePackage.SYMBOL__SCRIPT_MODULES:
                return getScriptModules ();
            case VisualInterfacePackage.SYMBOL__CURSORS:
                return getCursors ();
            case VisualInterfacePackage.SYMBOL__BACKGROUND_COLOR:
                return getBackgroundColor ();
            case VisualInterfacePackage.SYMBOL__DESIGN_SIZE:
                return getDesignSize ();
            case VisualInterfacePackage.SYMBOL__CONNECTIONS:
                return getConnections ();
            case VisualInterfacePackage.SYMBOL__BACKGROUND_IMAGE:
                return getBackgroundImage ();
            case VisualInterfacePackage.SYMBOL__TIME_TRIGGERS:
                return getTimeTriggers ();
        }
        return super.eGet ( featureID, resolve, coreType );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings ( "unchecked" )
    @Override
    public void eSet ( int featureID, Object newValue )
    {
        switch ( featureID )
        {
            case VisualInterfacePackage.SYMBOL__ROOT:
                setRoot ( (Primitive)newValue );
                return;
            case VisualInterfacePackage.SYMBOL__PROPERTIES:
                ( (EStructuralFeature.Setting)getProperties () ).set ( newValue );
                return;
            case VisualInterfacePackage.SYMBOL__ON_INIT:
                setOnInit ( (String)newValue );
                return;
            case VisualInterfacePackage.SYMBOL__ON_DISPOSE:
                setOnDispose ( (String)newValue );
                return;
            case VisualInterfacePackage.SYMBOL__ON_UPDATE:
                setOnUpdate ( (String)newValue );
                return;
            case VisualInterfacePackage.SYMBOL__SCRIPT_MODULES:
                getScriptModules ().clear ();
                getScriptModules ().addAll ( (Collection<? extends String>)newValue );
                return;
            case VisualInterfacePackage.SYMBOL__CURSORS:
                setCursors ( (Cursor)newValue );
                return;
            case VisualInterfacePackage.SYMBOL__BACKGROUND_COLOR:
                setBackgroundColor ( (String)newValue );
                return;
            case VisualInterfacePackage.SYMBOL__DESIGN_SIZE:
                setDesignSize ( (Dimension)newValue );
                return;
            case VisualInterfacePackage.SYMBOL__CONNECTIONS:
                getConnections ().clear ();
                getConnections ().addAll ( (Collection<? extends Connection>)newValue );
                return;
            case VisualInterfacePackage.SYMBOL__BACKGROUND_IMAGE:
                setBackgroundImage ( (String)newValue );
                return;
            case VisualInterfacePackage.SYMBOL__TIME_TRIGGERS:
                getTimeTriggers ().clear ();
                getTimeTriggers ().addAll ( (Collection<? extends TimeTrigger>)newValue );
                return;
        }
        super.eSet ( featureID, newValue );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset ( int featureID )
    {
        switch ( featureID )
        {
            case VisualInterfacePackage.SYMBOL__ROOT:
                setRoot ( (Primitive)null );
                return;
            case VisualInterfacePackage.SYMBOL__PROPERTIES:
                getProperties ().clear ();
                return;
            case VisualInterfacePackage.SYMBOL__ON_INIT:
                setOnInit ( ON_INIT_EDEFAULT );
                return;
            case VisualInterfacePackage.SYMBOL__ON_DISPOSE:
                setOnDispose ( ON_DISPOSE_EDEFAULT );
                return;
            case VisualInterfacePackage.SYMBOL__ON_UPDATE:
                setOnUpdate ( ON_UPDATE_EDEFAULT );
                return;
            case VisualInterfacePackage.SYMBOL__SCRIPT_MODULES:
                getScriptModules ().clear ();
                return;
            case VisualInterfacePackage.SYMBOL__CURSORS:
                setCursors ( (Cursor)null );
                return;
            case VisualInterfacePackage.SYMBOL__BACKGROUND_COLOR:
                setBackgroundColor ( BACKGROUND_COLOR_EDEFAULT );
                return;
            case VisualInterfacePackage.SYMBOL__DESIGN_SIZE:
                setDesignSize ( (Dimension)null );
                return;
            case VisualInterfacePackage.SYMBOL__CONNECTIONS:
                getConnections ().clear ();
                return;
            case VisualInterfacePackage.SYMBOL__BACKGROUND_IMAGE:
                setBackgroundImage ( BACKGROUND_IMAGE_EDEFAULT );
                return;
            case VisualInterfacePackage.SYMBOL__TIME_TRIGGERS:
                getTimeTriggers ().clear ();
                return;
        }
        super.eUnset ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet ( int featureID )
    {
        switch ( featureID )
        {
            case VisualInterfacePackage.SYMBOL__ROOT:
                return root != null;
            case VisualInterfacePackage.SYMBOL__PROPERTIES:
                return properties != null && !properties.isEmpty ();
            case VisualInterfacePackage.SYMBOL__ON_INIT:
                return ON_INIT_EDEFAULT == null ? onInit != null : !ON_INIT_EDEFAULT.equals ( onInit );
            case VisualInterfacePackage.SYMBOL__ON_DISPOSE:
                return ON_DISPOSE_EDEFAULT == null ? onDispose != null : !ON_DISPOSE_EDEFAULT.equals ( onDispose );
            case VisualInterfacePackage.SYMBOL__ON_UPDATE:
                return ON_UPDATE_EDEFAULT == null ? onUpdate != null : !ON_UPDATE_EDEFAULT.equals ( onUpdate );
            case VisualInterfacePackage.SYMBOL__SCRIPT_MODULES:
                return scriptModules != null && !scriptModules.isEmpty ();
            case VisualInterfacePackage.SYMBOL__CURSORS:
                return cursors != null;
            case VisualInterfacePackage.SYMBOL__BACKGROUND_COLOR:
                return BACKGROUND_COLOR_EDEFAULT == null ? backgroundColor != null : !BACKGROUND_COLOR_EDEFAULT.equals ( backgroundColor );
            case VisualInterfacePackage.SYMBOL__DESIGN_SIZE:
                return designSize != null;
            case VisualInterfacePackage.SYMBOL__CONNECTIONS:
                return connections != null && !connections.isEmpty ();
            case VisualInterfacePackage.SYMBOL__BACKGROUND_IMAGE:
                return BACKGROUND_IMAGE_EDEFAULT == null ? backgroundImage != null : !BACKGROUND_IMAGE_EDEFAULT.equals ( backgroundImage );
            case VisualInterfacePackage.SYMBOL__TIME_TRIGGERS:
                return timeTriggers != null && !timeTriggers.isEmpty ();
        }
        return super.eIsSet ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString ()
    {
        if ( eIsProxy () )
            return super.toString ();

        StringBuffer result = new StringBuffer ( super.toString () );
        result.append ( " (onInit: " ); //$NON-NLS-1$
        result.append ( onInit );
        result.append ( ", onDispose: " ); //$NON-NLS-1$
        result.append ( onDispose );
        result.append ( ", onUpdate: " ); //$NON-NLS-1$
        result.append ( onUpdate );
        result.append ( ", scriptModules: " ); //$NON-NLS-1$
        result.append ( scriptModules );
        result.append ( ", backgroundColor: " ); //$NON-NLS-1$
        result.append ( backgroundColor );
        result.append ( ", backgroundImage: " ); //$NON-NLS-1$
        result.append ( backgroundImage );
        result.append ( ')' );
        return result.toString ();
    }

} //SymbolImpl
