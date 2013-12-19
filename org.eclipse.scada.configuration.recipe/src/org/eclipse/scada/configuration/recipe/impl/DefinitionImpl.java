/**
 * Copyright (c) 2013 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.eclipse.scada.configuration.recipe.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.recipe.Definition;
import org.eclipse.scada.configuration.recipe.PropertyEntry;
import org.eclipse.scada.configuration.recipe.RecipePackage;
import org.eclipse.scada.configuration.recipe.Task;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.recipe.impl.DefinitionImpl#getTask <em>Task</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.recipe.impl.DefinitionImpl#getImport <em>Import</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.recipe.impl.DefinitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.recipe.impl.DefinitionImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.recipe.impl.DefinitionImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DefinitionImpl extends MinimalEObjectImpl.Container implements Definition
{
    /**
     * The cached value of the '{@link #getTask() <em>Task</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getTask()
     * @generated
     * @ordered
     */
    protected EList<Task> task;

    /**
     * The cached value of the '{@link #getImport() <em>Import</em>}' reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getImport()
     * @generated
     * @ordered
     */
    protected EList<Definition> import_;

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
     * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getProperties()
     * @generated
     * @ordered
     */
    protected EList<PropertyEntry> properties;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DefinitionImpl ()
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
        return RecipePackage.Literals.DEFINITION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Task> getTask ()
    {
        if ( task == null )
        {
            task = new EObjectContainmentWithInverseEList.Resolving<Task> ( Task.class, this, RecipePackage.DEFINITION__TASK, RecipePackage.TASK__DEFINITION );
        }
        return task;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Definition> getImport ()
    {
        if ( import_ == null )
        {
            import_ = new EObjectResolvingEList<Definition> ( Definition.class, this, RecipePackage.DEFINITION__IMPORT );
        }
        return import_;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, RecipePackage.DEFINITION__NAME, oldName, name ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String getId ()
    {
        return id;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setId ( String newId )
    {
        String oldId = id;
        id = newId;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, RecipePackage.DEFINITION__ID, oldId, id ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<PropertyEntry> getProperties ()
    {
        if ( properties == null )
        {
            properties = new EObjectContainmentEList.Resolving<PropertyEntry> ( PropertyEntry.class, this, RecipePackage.DEFINITION__PROPERTIES );
        }
        return properties;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings ( "unchecked" )
    @Override
    public NotificationChain eInverseAdd ( InternalEObject otherEnd, int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case RecipePackage.DEFINITION__TASK:
                return ( (InternalEList<InternalEObject>)(InternalEList<?>)getTask () ).basicAdd ( otherEnd, msgs );
        }
        return super.eInverseAdd ( otherEnd, featureID, msgs );
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
            case RecipePackage.DEFINITION__TASK:
                return ( (InternalEList<?>)getTask () ).basicRemove ( otherEnd, msgs );
            case RecipePackage.DEFINITION__PROPERTIES:
                return ( (InternalEList<?>)getProperties () ).basicRemove ( otherEnd, msgs );
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
            case RecipePackage.DEFINITION__TASK:
                return getTask ();
            case RecipePackage.DEFINITION__IMPORT:
                return getImport ();
            case RecipePackage.DEFINITION__NAME:
                return getName ();
            case RecipePackage.DEFINITION__ID:
                return getId ();
            case RecipePackage.DEFINITION__PROPERTIES:
                return getProperties ();
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
            case RecipePackage.DEFINITION__TASK:
                getTask ().clear ();
                getTask ().addAll ( (Collection<? extends Task>)newValue );
                return;
            case RecipePackage.DEFINITION__IMPORT:
                getImport ().clear ();
                getImport ().addAll ( (Collection<? extends Definition>)newValue );
                return;
            case RecipePackage.DEFINITION__NAME:
                setName ( (String)newValue );
                return;
            case RecipePackage.DEFINITION__ID:
                setId ( (String)newValue );
                return;
            case RecipePackage.DEFINITION__PROPERTIES:
                getProperties ().clear ();
                getProperties ().addAll ( (Collection<? extends PropertyEntry>)newValue );
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
            case RecipePackage.DEFINITION__TASK:
                getTask ().clear ();
                return;
            case RecipePackage.DEFINITION__IMPORT:
                getImport ().clear ();
                return;
            case RecipePackage.DEFINITION__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case RecipePackage.DEFINITION__ID:
                setId ( ID_EDEFAULT );
                return;
            case RecipePackage.DEFINITION__PROPERTIES:
                getProperties ().clear ();
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
            case RecipePackage.DEFINITION__TASK:
                return task != null && !task.isEmpty ();
            case RecipePackage.DEFINITION__IMPORT:
                return import_ != null && !import_.isEmpty ();
            case RecipePackage.DEFINITION__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
            case RecipePackage.DEFINITION__ID:
                return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals ( id );
            case RecipePackage.DEFINITION__PROPERTIES:
                return properties != null && !properties.isEmpty ();
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
        result.append ( " (name: " ); //$NON-NLS-1$
        result.append ( name );
        result.append ( ", id: " ); //$NON-NLS-1$
        result.append ( id );
        result.append ( ')' );
        return result.toString ();
    }

} //DefinitionImpl
