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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.scada.configuration.recipe.CaptureOutput;
import org.eclipse.scada.configuration.recipe.Execute;
import org.eclipse.scada.configuration.recipe.InputReference;
import org.eclipse.scada.configuration.recipe.InputValue;
import org.eclipse.scada.configuration.recipe.MapInput;
import org.eclipse.scada.configuration.recipe.RecipePackage;
import org.eclipse.scada.configuration.recipe.Task;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.scada.configuration.recipe.impl.ExecuteImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.recipe.impl.ExecuteImpl#getTask <em>Task</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.recipe.impl.ExecuteImpl#getMapInput <em>Map Input</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.recipe.impl.ExecuteImpl#getInputValue <em>Input Value</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.recipe.impl.ExecuteImpl#getOutput <em>Output</em>}</li>
 *   <li>{@link org.eclipse.scada.configuration.recipe.impl.ExecuteImpl#getInputReference <em>Input Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecuteImpl extends MinimalEObjectImpl.Container implements Execute
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
     * The cached value of the '{@link #getMapInput() <em>Map Input</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getMapInput()
     * @generated
     * @ordered
     */
    protected EList<MapInput> mapInput;

    /**
     * The cached value of the '{@link #getInputValue() <em>Input Value</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInputValue()
     * @generated
     * @ordered
     */
    protected EList<InputValue> inputValue;

    /**
     * The cached value of the '{@link #getOutput() <em>Output</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOutput()
     * @generated
     * @ordered
     */
    protected EList<CaptureOutput> output;

    /**
     * The cached value of the '{@link #getInputReference() <em>Input Reference</em>}' containment reference list.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getInputReference()
     * @generated
     * @ordered
     */
    protected EList<InputReference> inputReference;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ExecuteImpl ()
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
        return RecipePackage.Literals.EXECUTE;
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
            eNotify ( new ENotificationImpl ( this, Notification.SET, RecipePackage.EXECUTE__NAME, oldName, name ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Task getTask ()
    {
        if ( eContainerFeatureID () != RecipePackage.EXECUTE__TASK )
            return null;
        return (Task)eContainer ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Task basicGetTask ()
    {
        if ( eContainerFeatureID () != RecipePackage.EXECUTE__TASK )
            return null;
        return (Task)eInternalContainer ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetTask ( Task newTask, NotificationChain msgs )
    {
        msgs = eBasicSetContainer ( (InternalEObject)newTask, RecipePackage.EXECUTE__TASK, msgs );
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setTask ( Task newTask )
    {
        if ( newTask != eInternalContainer () || ( eContainerFeatureID () != RecipePackage.EXECUTE__TASK && newTask != null ) )
        {
            if ( EcoreUtil.isAncestor ( this, newTask ) )
                throw new IllegalArgumentException ( "Recursive containment not allowed for " + toString () ); //$NON-NLS-1$
            NotificationChain msgs = null;
            if ( eInternalContainer () != null )
                msgs = eBasicRemoveFromContainer ( msgs );
            if ( newTask != null )
                msgs = ( (InternalEObject)newTask ).eInverseAdd ( this, RecipePackage.TASK__EXECUTE, Task.class, msgs );
            msgs = basicSetTask ( newTask, msgs );
            if ( msgs != null )
                msgs.dispatch ();
        }
        else if ( eNotificationRequired () )
            eNotify ( new ENotificationImpl ( this, Notification.SET, RecipePackage.EXECUTE__TASK, newTask, newTask ) );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<MapInput> getMapInput ()
    {
        if ( mapInput == null )
        {
            mapInput = new EObjectContainmentEList.Resolving<MapInput> ( MapInput.class, this, RecipePackage.EXECUTE__MAP_INPUT );
        }
        return mapInput;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<InputValue> getInputValue ()
    {
        if ( inputValue == null )
        {
            inputValue = new EObjectContainmentEList.Resolving<InputValue> ( InputValue.class, this, RecipePackage.EXECUTE__INPUT_VALUE );
        }
        return inputValue;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<CaptureOutput> getOutput ()
    {
        if ( output == null )
        {
            output = new EObjectContainmentEList.Resolving<CaptureOutput> ( CaptureOutput.class, this, RecipePackage.EXECUTE__OUTPUT );
        }
        return output;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EList<InputReference> getInputReference ()
    {
        if ( inputReference == null )
        {
            inputReference = new EObjectContainmentEList.Resolving<InputReference> ( InputReference.class, this, RecipePackage.EXECUTE__INPUT_REFERENCE );
        }
        return inputReference;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd ( InternalEObject otherEnd, int featureID, NotificationChain msgs )
    {
        switch ( featureID )
        {
            case RecipePackage.EXECUTE__TASK:
                if ( eInternalContainer () != null )
                    msgs = eBasicRemoveFromContainer ( msgs );
                return basicSetTask ( (Task)otherEnd, msgs );
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
            case RecipePackage.EXECUTE__TASK:
                return basicSetTask ( null, msgs );
            case RecipePackage.EXECUTE__MAP_INPUT:
                return ( (InternalEList<?>)getMapInput () ).basicRemove ( otherEnd, msgs );
            case RecipePackage.EXECUTE__INPUT_VALUE:
                return ( (InternalEList<?>)getInputValue () ).basicRemove ( otherEnd, msgs );
            case RecipePackage.EXECUTE__OUTPUT:
                return ( (InternalEList<?>)getOutput () ).basicRemove ( otherEnd, msgs );
            case RecipePackage.EXECUTE__INPUT_REFERENCE:
                return ( (InternalEList<?>)getInputReference () ).basicRemove ( otherEnd, msgs );
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
            case RecipePackage.EXECUTE__TASK:
                return eInternalContainer ().eInverseRemove ( this, RecipePackage.TASK__EXECUTE, Task.class, msgs );
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
            case RecipePackage.EXECUTE__NAME:
                return getName ();
            case RecipePackage.EXECUTE__TASK:
                if ( resolve )
                    return getTask ();
                return basicGetTask ();
            case RecipePackage.EXECUTE__MAP_INPUT:
                return getMapInput ();
            case RecipePackage.EXECUTE__INPUT_VALUE:
                return getInputValue ();
            case RecipePackage.EXECUTE__OUTPUT:
                return getOutput ();
            case RecipePackage.EXECUTE__INPUT_REFERENCE:
                return getInputReference ();
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
            case RecipePackage.EXECUTE__NAME:
                setName ( (String)newValue );
                return;
            case RecipePackage.EXECUTE__TASK:
                setTask ( (Task)newValue );
                return;
            case RecipePackage.EXECUTE__MAP_INPUT:
                getMapInput ().clear ();
                getMapInput ().addAll ( (Collection<? extends MapInput>)newValue );
                return;
            case RecipePackage.EXECUTE__INPUT_VALUE:
                getInputValue ().clear ();
                getInputValue ().addAll ( (Collection<? extends InputValue>)newValue );
                return;
            case RecipePackage.EXECUTE__OUTPUT:
                getOutput ().clear ();
                getOutput ().addAll ( (Collection<? extends CaptureOutput>)newValue );
                return;
            case RecipePackage.EXECUTE__INPUT_REFERENCE:
                getInputReference ().clear ();
                getInputReference ().addAll ( (Collection<? extends InputReference>)newValue );
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
            case RecipePackage.EXECUTE__NAME:
                setName ( NAME_EDEFAULT );
                return;
            case RecipePackage.EXECUTE__TASK:
                setTask ( (Task)null );
                return;
            case RecipePackage.EXECUTE__MAP_INPUT:
                getMapInput ().clear ();
                return;
            case RecipePackage.EXECUTE__INPUT_VALUE:
                getInputValue ().clear ();
                return;
            case RecipePackage.EXECUTE__OUTPUT:
                getOutput ().clear ();
                return;
            case RecipePackage.EXECUTE__INPUT_REFERENCE:
                getInputReference ().clear ();
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
            case RecipePackage.EXECUTE__NAME:
                return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals ( name );
            case RecipePackage.EXECUTE__TASK:
                return basicGetTask () != null;
            case RecipePackage.EXECUTE__MAP_INPUT:
                return mapInput != null && !mapInput.isEmpty ();
            case RecipePackage.EXECUTE__INPUT_VALUE:
                return inputValue != null && !inputValue.isEmpty ();
            case RecipePackage.EXECUTE__OUTPUT:
                return output != null && !output.isEmpty ();
            case RecipePackage.EXECUTE__INPUT_REFERENCE:
                return inputReference != null && !inputReference.isEmpty ();
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
        result.append ( ')' );
        return result.toString ();
    }

} //ExecuteImpl
