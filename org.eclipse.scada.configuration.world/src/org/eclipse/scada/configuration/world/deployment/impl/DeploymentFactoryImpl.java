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
package org.eclipse.scada.configuration.world.deployment.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.scada.configuration.world.deployment.Author;
import org.eclipse.scada.configuration.world.deployment.ChangeEntry;
import org.eclipse.scada.configuration.world.deployment.DebianDeploymentMechanism;
import org.eclipse.scada.configuration.world.deployment.DeploymentFactory;
import org.eclipse.scada.configuration.world.deployment.DeploymentInformation;
import org.eclipse.scada.configuration.world.deployment.DeploymentPackage;
import org.eclipse.scada.configuration.world.deployment.RedhatDeploymentMechanism;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DeploymentFactoryImpl extends EFactoryImpl implements DeploymentFactory
{
    /**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static DeploymentFactory init ()
    {
        try
        {
            DeploymentFactory theDeploymentFactory = (DeploymentFactory)EPackage.Registry.INSTANCE.getEFactory ( DeploymentPackage.eNS_URI );
            if ( theDeploymentFactory != null )
            {
                return theDeploymentFactory;
            }
        }
        catch ( Exception exception )
        {
            EcorePlugin.INSTANCE.log ( exception );
        }
        return new DeploymentFactoryImpl ();
    }

    /**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DeploymentFactoryImpl ()
    {
        super ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public EObject create ( EClass eClass )
    {
        switch ( eClass.getClassifierID () )
        {
            case DeploymentPackage.DEBIAN_DEPLOYMENT_MECHANISM:
                return createDebianDeploymentMechanism ();
            case DeploymentPackage.AUTHOR:
                return createAuthor ();
            case DeploymentPackage.REDHAT_DEPLOYMENT_MECHANISM:
                return createRedhatDeploymentMechanism ();
            case DeploymentPackage.DEPLOYMENT_INFORMATION:
                return createDeploymentInformation ();
            case DeploymentPackage.CHANGE_ENTRY:
                return createChangeEntry ();
            default:
                throw new IllegalArgumentException ( "The class '" + eClass.getName () + "' is not a valid classifier" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public DebianDeploymentMechanism createDebianDeploymentMechanism ()
    {
        DebianDeploymentMechanismImpl debianDeploymentMechanism = new DebianDeploymentMechanismImpl ();
        return debianDeploymentMechanism;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Author createAuthor ()
    {
        AuthorImpl author = new AuthorImpl ();
        return author;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public RedhatDeploymentMechanism createRedhatDeploymentMechanism ()
    {
        RedhatDeploymentMechanismImpl redhatDeploymentMechanism = new RedhatDeploymentMechanismImpl ();
        return redhatDeploymentMechanism;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public DeploymentInformation createDeploymentInformation ()
    {
        DeploymentInformationImpl deploymentInformation = new DeploymentInformationImpl ();
        return deploymentInformation;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated NOT
     */
    @Override
    public ChangeEntry createChangeEntry ()
    {
        final ChangeEntryImpl changeEntry = new ChangeEntryImpl ();
        changeEntry.setDate ( new java.util.Date () );
        return changeEntry;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public DeploymentPackage getDeploymentPackage ()
    {
        return (DeploymentPackage)getEPackage ();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
    @Deprecated
    public static DeploymentPackage getPackage ()
    {
        return DeploymentPackage.eINSTANCE;
    }

} //DeploymentFactoryImpl
