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
package org.eclipse.scada.configuration.component.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.DataComponent;
import org.eclipse.scada.configuration.component.GlobalizeComponent;
import org.eclipse.scada.configuration.infrastructure.MasterImport;
import org.eclipse.scada.configuration.infrastructure.MasterServer;
import org.eclipse.scada.configuration.world.NamedDocumentable;
import org.eclipse.scada.configuration.world.WorldPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Globalize Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.GlobalizeComponentImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.GlobalizeComponentImpl#getComponents <em>Components</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.component.impl.GlobalizeComponentImpl#getSourceMaster <em>Source Master</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GlobalizeComponentImpl extends DataComponentImpl implements GlobalizeComponent
{
    /**
     * The default value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected static final String NAME_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getName()
     * @generated
     * @ordered
     */
    protected String name = NAME_EDEFAULT;

    /**
     * The cached value of the '{@link #getComponents() <em>Components</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getComponents()
     * @generated
     * @ordered
     */
    protected EList<DataComponent> components;

    /**
     * The cached value of the '{@link #getSourceMaster() <em>Source Master</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSourceMaster()
     * @generated
     * @ordered
     */
    protected MasterImport sourceMaster;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected GlobalizeComponentImpl ()
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
        return ComponentPackage.Literals.GLOBALIZE_COMPONENT;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getName ()
    {
        return name;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setName ( String newName )
    {
        String oldName = name;
        name = newName;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.GLOBALIZE_COMPONENT__NAME, oldName, name ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<DataComponent> getComponents ()
    {
        if ( components == null )
        {
            components = new EObjectResolvingEList<DataComponent> ( DataComponent.class, this, ComponentPackage.GLOBALIZE_COMPONENT__COMPONENTS );
        }
        return components;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public MasterImport getSourceMaster ()
    {
        if ( sourceMaster != null && sourceMaster.eIsProxy () )
        {
            InternalEObject oldSourceMaster = (InternalEObject)sourceMaster;
            sourceMaster = (MasterImport)eResolveProxy ( oldSourceMaster );
            if ( sourceMaster != oldSourceMaster )
            {
                if ( eNotificationRequired () )
                    eNotify ( new ENotificationImpl ( this, Notification.RESOLVE, ComponentPackage.GLOBALIZE_COMPONENT__SOURCE_MASTER, oldSourceMaster, sourceMaster ) );
            }
        }
        return sourceMaster;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public MasterImport basicGetSourceMaster ()
    {
        return sourceMaster;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setSourceMaster ( MasterImport newSourceMaster )
    {
        MasterImport oldSourceMaster = sourceMaster;
        sourceMaster = newSourceMaster;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, ComponentPackage.GLOBALIZE_COMPONENT__SOURCE_MASTER, oldSourceMaster, sourceMaster ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public EList<MasterServer> getMasterOn ()
    {
        if ( getSourceMaster () != null && getSourceMaster ().getMaster () != null )
        {
            return ECollections.singletonEList ( getSourceMaster ().getMaster () );
        }
        else
        {
            return ECollections.emptyEList ();
        }
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
            case ComponentPackage.GLOBALIZE_COMPONENT__NAME:
                return getName ();
            case ComponentPackage.GLOBALIZE_COMPONENT__COMPONENTS:
                return getComponents ();
            case ComponentPackage.GLOBALIZE_COMPONENT__SOURCE_MASTER:
                if ( resolve )
                    return getSourceMaster ();
                return basicGetSourceMaster ();
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
            case ComponentPackage.GLOBALIZE_COMPONENT__NAME:
                setName ( (String)newValue );
                return;
            case ComponentPackage.GLOBALIZE_COMPONENT__COMPONENTS:
                getComponents ().clear ();
                getComponents ().addAll ( (Collection<? extends DataComponent>)newValue );
                return;
            case ComponentPackage.GLOBALIZE_COMPONENT__SOURCE_MASTER:
                setSourceMaster ( (MasterImport)newValue );
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
            case ComponentPackage.GLOBALIZE_COMPONENT__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case ComponentPackage.GLOBALIZE_COMPONENT__COMPONENTS:
                getComponents ().clear ();
                return;
            case ComponentPackage.GLOBALIZE_COMPONENT__SOURCE_MASTER:
                setSourceMaster ( (MasterImport)null );
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
            case ComponentPackage.GLOBALIZE_COMPONENT__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
            case ComponentPackage.GLOBALIZE_COMPONENT__COMPONENTS:
                return components != null && !components.isEmpty ();
            case ComponentPackage.GLOBALIZE_COMPONENT__SOURCE_MASTER:
                return sourceMaster != null;
        }
        return super.eIsSet ( featureID );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID ( int derivedFeatureID, Class<?> baseClass )
    {
        if ( baseClass == NamedDocumentable.class )
        {
            switch ( derivedFeatureID )
            {
                case ComponentPackage.GLOBALIZE_COMPONENT__NAME:
                    return WorldPackage.NAMED_DOCUMENTABLE__NAME;
                default:
                    return -1;
            }
        }
        return super.eBaseStructuralFeatureID ( derivedFeatureID, baseClass );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID ( int baseFeatureID, Class<?> baseClass )
    {
        if ( baseClass == NamedDocumentable.class )
        {
            switch ( baseFeatureID )
            {
                case WorldPackage.NAMED_DOCUMENTABLE__NAME:
                    return ComponentPackage.GLOBALIZE_COMPONENT__NAME;
                default:
                    return -1;
            }
        }
        return super.eDerivedStructuralFeatureID ( baseFeatureID, baseClass );
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
        result.append ( " (name: " ); //$NON-NLS-1$
        result.append ( name );
        result.append ( ')' );
        return result.toString ();
    }

} //GlobalizeComponentImpl
