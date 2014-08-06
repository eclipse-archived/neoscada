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
package org.eclipse.scada.configuration.world.setup.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.eclipse.scada.configuration.world.setup.OperatingSystemDescriptor;
import org.eclipse.scada.configuration.world.setup.SetupModule;
import org.eclipse.scada.configuration.world.setup.SetupModuleContainer;
import org.eclipse.scada.configuration.world.setup.SetupPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Module Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.world.setup.impl.SetupModuleContainerImpl#getModules <em>Modules</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.world.setup.impl.SetupModuleContainerImpl#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SetupModuleContainerImpl extends MinimalEObjectImpl.Container implements SetupModuleContainer
{
    /**
     * The cached value of the '{@link #getModules() <em>Modules</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getModules()
     * @generated
     * @ordered
     */
    protected EList<SetupModule> modules;

    /**
     * The default value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected static final String ID_EDEFAULT = null;

    /**
     * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getId()
     * @generated
     * @ordered
     */
    protected String id = ID_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SetupModuleContainerImpl ()
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
        return SetupPackage.Literals.SETUP_MODULE_CONTAINER;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EList<SetupModule> getModules ()
    {
        if ( modules == null )
        {
            modules = new EObjectContainmentEList.Resolving<SetupModule> ( SetupModule.class, this, SetupPackage.SETUP_MODULE_CONTAINER__MODULES );
        }
        return modules;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String getId ()
    {
        return id;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void setId ( String newId )
    {
        String oldId = id;
        id = newId;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, SetupPackage.SETUP_MODULE_CONTAINER__ID, oldId, id ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated NOT
     */
    @Override
    public IStatus validateOperatingSystem ( final OperatingSystemDescriptor descriptor, final IValidationContext context )
    {
        final Collection<IStatus> result = new LinkedList<IStatus> ();
        for ( final SetupModule module : this.modules )
        {
            final IStatus s = module.validateOperatingSystem ( descriptor, context );
            if ( s != null && !s.isOK () )
            {
                result.add ( s );
            }
        }

        if ( result.isEmpty () )
        {
            return Status.OK_STATUS;
        }
        else
        {
            return ConstraintStatus.createMultiStatus ( context, result );
        }
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
            case SetupPackage.SETUP_MODULE_CONTAINER__MODULES:
                return ( (InternalEList<?>)getModules () ).basicRemove ( otherEnd, msgs );
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
            case SetupPackage.SETUP_MODULE_CONTAINER__MODULES:
                return getModules ();
            case SetupPackage.SETUP_MODULE_CONTAINER__ID:
                return getId ();
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
            case SetupPackage.SETUP_MODULE_CONTAINER__MODULES:
                getModules ().clear ();
                getModules ().addAll ( (Collection<? extends SetupModule>)newValue );
                return;
            case SetupPackage.SETUP_MODULE_CONTAINER__ID:
                setId ( (String)newValue );
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
            case SetupPackage.SETUP_MODULE_CONTAINER__MODULES:
                getModules ().clear ();
                return;
            case SetupPackage.SETUP_MODULE_CONTAINER__ID:
                setId ( ID_EDEFAULT );
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
            case SetupPackage.SETUP_MODULE_CONTAINER__MODULES:
                return modules != null && !modules.isEmpty ();
            case SetupPackage.SETUP_MODULE_CONTAINER__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals ( id );
        }
        return super.eIsSet ( featureID );
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
            case SetupPackage.SETUP_MODULE_CONTAINER___VALIDATE_OPERATING_SYSTEM__OPERATINGSYSTEMDESCRIPTOR_IVALIDATIONCONTEXT:
                return validateOperatingSystem ( (OperatingSystemDescriptor)arguments.get ( 0 ), (IValidationContext)arguments.get ( 1 ) );
        }
        return super.eInvoke ( operationID, arguments );
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
        result.append ( " (id: " ); //$NON-NLS-1$
        result.append ( id );
        result.append ( ')' );
        return result.toString ();
    }

} //SetupModuleContainerImpl
