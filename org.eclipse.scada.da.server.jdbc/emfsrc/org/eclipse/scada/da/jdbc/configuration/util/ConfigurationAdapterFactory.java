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
package org.eclipse.scada.da.jdbc.configuration.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.da.jdbc.configuration.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.scada.da.jdbc.configuration.ConfigurationPackage
 * @generated
 */
public class ConfigurationAdapterFactory extends AdapterFactoryImpl
{
    //$NON-NLS-1$

    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static ConfigurationPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ConfigurationAdapterFactory ()
    {
        if ( modelPackage == null )
        {
            modelPackage = ConfigurationPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType ( Object object )
    {
        if ( object == modelPackage )
        {
            return true;
        }
        if ( object instanceof EObject )
        {
            return ( (EObject)object ).eClass ().getEPackage () == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ConfigurationSwitch<Adapter> modelSwitch = new ConfigurationSwitch<Adapter> () {
        @Override
        public Adapter caseAbstractQueryType ( AbstractQueryType object )
        {
            return createAbstractQueryTypeAdapter ();
        }

        @Override
        public Adapter caseColumnMappingType ( ColumnMappingType object )
        {
            return createColumnMappingTypeAdapter ();
        }

        @Override
        public Adapter caseCommandsType ( CommandsType object )
        {
            return createCommandsTypeAdapter ();
        }

        @Override
        public Adapter caseConnectionType ( ConnectionType object )
        {
            return createConnectionTypeAdapter ();
        }

        @Override
        public Adapter caseDocumentRoot ( DocumentRoot object )
        {
            return createDocumentRootAdapter ();
        }

        @Override
        public Adapter caseQueryType ( QueryType object )
        {
            return createQueryTypeAdapter ();
        }

        @Override
        public Adapter caseRootType ( RootType object )
        {
            return createRootTypeAdapter ();
        }

        @Override
        public Adapter caseTabularQueryType ( TabularQueryType object )
        {
            return createTabularQueryTypeAdapter ();
        }

        @Override
        public Adapter caseUpdateColumnsType ( UpdateColumnsType object )
        {
            return createUpdateColumnsTypeAdapter ();
        }

        @Override
        public Adapter caseUpdateMappingType ( UpdateMappingType object )
        {
            return createUpdateMappingTypeAdapter ();
        }

        @Override
        public Adapter caseUpdateType ( UpdateType object )
        {
            return createUpdateTypeAdapter ();
        }

        @Override
        public Adapter defaultCase ( EObject object )
        {
            return createEObjectAdapter ();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter ( Notifier target )
    {
        return modelSwitch.doSwitch ( (EObject)target );
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.jdbc.configuration.AbstractQueryType <em>Abstract Query Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.jdbc.configuration.AbstractQueryType
     * @generated
     */
    public Adapter createAbstractQueryTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.jdbc.configuration.ColumnMappingType <em>Column Mapping Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.jdbc.configuration.ColumnMappingType
     * @generated
     */
    public Adapter createColumnMappingTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.jdbc.configuration.CommandsType <em>Commands Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.jdbc.configuration.CommandsType
     * @generated
     */
    public Adapter createCommandsTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.jdbc.configuration.ConnectionType <em>Connection Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.jdbc.configuration.ConnectionType
     * @generated
     */
    public Adapter createConnectionTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.jdbc.configuration.DocumentRoot <em>Document Root</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.jdbc.configuration.DocumentRoot
     * @generated
     */
    public Adapter createDocumentRootAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.jdbc.configuration.QueryType <em>Query Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.jdbc.configuration.QueryType
     * @generated
     */
    public Adapter createQueryTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.jdbc.configuration.RootType <em>Root Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.jdbc.configuration.RootType
     * @generated
     */
    public Adapter createRootTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.jdbc.configuration.TabularQueryType <em>Tabular Query Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.jdbc.configuration.TabularQueryType
     * @generated
     */
    public Adapter createTabularQueryTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.jdbc.configuration.UpdateColumnsType <em>Update Columns Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.jdbc.configuration.UpdateColumnsType
     * @generated
     */
    public Adapter createUpdateColumnsTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.jdbc.configuration.UpdateMappingType <em>Update Mapping Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.jdbc.configuration.UpdateMappingType
     * @generated
     */
    public Adapter createUpdateMappingTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.da.jdbc.configuration.UpdateType <em>Update Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.da.jdbc.configuration.UpdateType
     * @generated
     */
    public Adapter createUpdateTypeAdapter ()
    {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter ()
    {
        return null;
    }

} //ConfigurationAdapterFactory
