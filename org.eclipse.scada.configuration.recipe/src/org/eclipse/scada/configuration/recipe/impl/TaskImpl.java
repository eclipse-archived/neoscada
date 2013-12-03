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
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.recipe.Definition;
import org.eclipse.scada.configuration.recipe.Execute;
import org.eclipse.scada.configuration.recipe.RecipePackage;
import org.eclipse.scada.configuration.recipe.Task;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.recipe.impl.TaskImpl#getExecute <em>Execute</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.recipe.impl.TaskImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.recipe.impl.TaskImpl#getDefinition <em>Definition</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.recipe.impl.TaskImpl#getOrder <em>Order</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TaskImpl extends MinimalEObjectImpl.Container implements Task
{
    /**
     * The cached value of the '{@link #getExecute() <em>Execute</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getExecute()
     * @generated
     * @ordered
     */
    protected EList<Execute> execute;

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
     * The default value of the '{@link #getOrder() <em>Order</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOrder()
     * @generated
     * @ordered
     */
    protected static final int ORDER_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getOrder() <em>Order</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOrder()
     * @generated
     * @ordered
     */
    protected int order = ORDER_EDEFAULT;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TaskImpl ()
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
        return RecipePackage.Literals.TASK;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<Execute> getExecute ()
    {
        if ( execute == null )
        {
            execute = new EObjectContainmentWithInverseEList.Resolving<Execute> ( Execute.class, this, RecipePackage.TASK__EXECUTE, RecipePackage.EXECUTE__TASK );
        }
        return execute;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, RecipePackage.TASK__NAME, oldName, name ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Definition getDefinition ()
    {
        if ( eContainerFeatureID () != RecipePackage.TASK__DEFINITION )
            return null;
        return (Definition)eContainer ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Definition basicGetDefinition ()
    {
        if ( eContainerFeatureID () != RecipePackage.TASK__DEFINITION )
            return null;
        return (Definition)eInternalContainer ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDefinition ( Definition newDefinition, NotificationChain msgs )
    {
        msgs = eBasicSetContainer ( (InternalEObject)newDefinition, RecipePackage.TASK__DEFINITION, msgs );
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDefinition ( Definition newDefinition )
    {
        if ( newDefinition != eInternalContainer () || ( eContainerFeatureID () != RecipePackage.TASK__DEFINITION && newDefinition != null ) )
        {
            if ( EcoreUtil.isAncestor ( this, newDefinition ) )
                throw new IllegalArgumentException ( "Recursive containment not allowed for " + toString () ); //$NON-NLS-1$
            NotificationChain msgs = null;
            if ( eInternalContainer () != null )
                msgs = eBasicRemoveFromContainer ( msgs );
            if ( newDefinition != null )
                msgs = ( (InternalEObject)newDefinition ).eInverseAdd ( this, RecipePackage.DEFINITION__TASK, Definition.class, msgs );
            msgs = basicSetDefinition ( newDefinition, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, RecipePackage.TASK__DEFINITION, newDefinition, newDefinition ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public int getOrder ()
    {
        return order;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setOrder ( int newOrder )
    {
        int oldOrder = order;
        order = newOrder;
        if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, RecipePackage.TASK__ORDER, oldOrder, order ) );
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
            case RecipePackage.TASK__EXECUTE:
                return ( (InternalEList<InternalEObject>)(InternalEList<?>)getExecute () ).basicAdd ( otherEnd, msgs );
            case RecipePackage.TASK__DEFINITION:
                if ( eInternalContainer () != null )
                    msgs = eBasicRemoveFromContainer ( msgs );
                return basicSetDefinition ( (Definition)otherEnd, msgs );
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
            case RecipePackage.TASK__EXECUTE:
                return ( (InternalEList<?>)getExecute () ).basicRemove ( otherEnd, msgs );
            case RecipePackage.TASK__DEFINITION:
                return basicSetDefinition ( null, msgs );
        }
        return super.eInverseRemove ( otherEnd, featureID, msgs );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature ( NotificationChain msgs )
    {
        switch ( eContainerFeatureID () )
        {
            case RecipePackage.TASK__DEFINITION:
                return eInternalContainer ().eInverseRemove ( this, RecipePackage.DEFINITION__TASK, Definition.class, msgs );
        }
        return super.eBasicRemoveFromContainerFeature ( msgs );
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
            case RecipePackage.TASK__EXECUTE:
                return getExecute ();
            case RecipePackage.TASK__NAME:
                return getName ();
            case RecipePackage.TASK__DEFINITION:
                if ( resolve )
                    return getDefinition ();
                return basicGetDefinition ();
            case RecipePackage.TASK__ORDER:
                return getOrder ();
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
            case RecipePackage.TASK__EXECUTE:
                getExecute ().clear ();
                getExecute ().addAll ( (Collection<? extends Execute>)newValue );
                return;
            case RecipePackage.TASK__NAME:
                setName ( (String)newValue );
                return;
            case RecipePackage.TASK__DEFINITION:
                setDefinition ( (Definition)newValue );
                return;
            case RecipePackage.TASK__ORDER:
                setOrder ( (Integer)newValue );
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
            case RecipePackage.TASK__EXECUTE:
                getExecute ().clear ();
                return;
            case RecipePackage.TASK__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case RecipePackage.TASK__DEFINITION:
                setDefinition ( (Definition)null );
                return;
            case RecipePackage.TASK__ORDER:
                setOrder ( ORDER_EDEFAULT );
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
            case RecipePackage.TASK__EXECUTE:
                return execute != null && !execute.isEmpty ();
            case RecipePackage.TASK__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
            case RecipePackage.TASK__DEFINITION:
                return basicGetDefinition () != null;
            case RecipePackage.TASK__ORDER:
                return order != ORDER_EDEFAULT;
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
        result.append ( ", order: " ); //$NON-NLS-1$
        result.append ( order );
        result.append ( ')' );
        return result.toString ();
    }

} //TaskImpl
