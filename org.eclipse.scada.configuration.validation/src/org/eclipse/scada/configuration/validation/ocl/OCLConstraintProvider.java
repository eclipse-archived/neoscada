/*******************************************************************************
 * Copyright (c) 2013, 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.validation.ocl;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.validation.model.Category;
import org.eclipse.emf.validation.model.CategoryManager;
import org.eclipse.emf.validation.model.IModelConstraint;
import org.eclipse.emf.validation.service.AbstractConstraintProvider;
import org.eclipse.emf.validation.service.ConstraintExistsException;
import org.eclipse.ocl.OCLInput;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.scada.configuration.validation.internal.ValidationPlugin;
import org.osgi.framework.Bundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provider of constraints parsed from OCL documents.
 * 
 * @author Christian W. Damus (cdamus)
 */
public class OCLConstraintProvider extends AbstractConstraintProvider
{

    private final static Logger logger = LoggerFactory.getLogger ( OCLConstraintProvider.class );

    private static final String E_OCL = "ocl"; //$NON-NLS-1$

    private static final String A_PATH = "path"; //$NON-NLS-1$

    private static final String A_CATEGORY = "category"; //$NON-NLS-1$

    @Override
    public void setInitializationData ( final IConfigurationElement config, final String propertyName, final Object data ) throws CoreException
    {
        super.setInitializationData ( config, propertyName, data );

        logger.debug ( "Initialize" );

        // create the constraint category
        String categoryID = config.getDeclaringExtension ().getUniqueIdentifier ();
        if ( categoryID == null )
        {
            categoryID = "OCLProvider@" + Long.toHexString ( System.identityHashCode ( this ) ); //$NON-NLS-1$
        }

        categoryID = "org.eclipse.scada.configuration/" + categoryID; //$NON-NLS-1$

        logger.debug ( "Category ID: {}", categoryID );

        final Category category = CategoryManager.getInstance ().getCategory ( categoryID );
        category.setName ( config.getAttribute ( A_CATEGORY ) );

        final Bundle contributor = Platform.getBundle ( config.getDeclaringExtension ().getNamespaceIdentifier () );

        final IConfigurationElement[] ocls = config.getChildren ( E_OCL );
        for ( int i = 0; i < ocls.length; i++ )
        {
            final String path = ocls[i].getAttribute ( A_PATH );

            if ( path != null && path.length () > 0 )
            {
                // categorize by OCL document name
                final IPath ipath = new Path ( path );
                logger.debug ( "Loading: {}", ipath );
                parseConstraints ( CategoryManager.getInstance ().getCategory ( category, ipath.lastSegment () ), contributor, path );
            }
        }

        try
        {
            final Collection<? extends IModelConstraint> contraints = getConstraints ();
            logger.debug ( "Registering {} constraints", contraints.size () );
            registerConstraints ( contraints );
        }
        catch ( final ConstraintExistsException e )
        {
            throw new CoreException ( new Status ( IStatus.ERROR, ValidationPlugin.getID (), 1, "Registration of OCL constraints failed", e ) );
        }
    }

    private void parseConstraints ( final Category category, final Bundle bundle, final String path )
    {
        logger.debug ( "Category: {}", category );

        final String baseName = path.replaceFirst ( "\\.ocl", "" );

        logger.debug ( "Loading resources from: {}", baseName );
        ResourceBundle messages = null;
        try
        {
            messages = ResourceBundle.getBundle ( baseName, Locale.getDefault (), OCLConstraintProvider.class.getClassLoader () );
        }
        catch ( final MissingResourceException e )
        {
            logger.debug ( "Failed to load resources", e );
        }

        final URL url = bundle.getEntry ( path );

        if ( url != null )
        {
            try
            {
                final InputStream input = url.openStream ();

                try
                {
                    parseConstraints ( category, bundle.getSymbolicName (), input, messages );
                }
                catch ( final ParserException e )
                {
                    final String msg = String.format ( "Failed to parse OCL constraints in %s:%s", bundle.getSymbolicName (), path );
                    ValidationPlugin.log ( msg, e );
                }
                finally
                {
                    input.close ();
                }
            }
            catch ( final IOException e )
            {
                final String msg = String.format ( "Failed to load OCL constraints from %s:%s", bundle.getSymbolicName (), path );
                ValidationPlugin.log ( msg, e );
            }
        }
    }

    private void parseConstraints ( final Category category, final String namespace, final InputStream input, final ResourceBundle messages ) throws ParserException
    {

        final OCLInput oclInput = new OCLInput ( input );

        final OCL ocl = OCL.newInstance ();

        for ( final Constraint constraint : ocl.parse ( oclInput ) )
        {
            if ( isInvariant ( constraint ) )
            {
                // only add invariant constraints for validation
                addConstraint ( category, namespace, ocl, constraint, messages );
            }
        }
    }

    private boolean isInvariant ( final Constraint constraint )
    {
        return UMLReflection.INVARIANT.equals ( constraint.getStereotype () );
    }

    private void addConstraint ( final Category category, final String namespace, final OCL ocl, final Constraint constraint, final ResourceBundle messages )
    {
        final Collection<IModelConstraint> constraints = getConstraints ();

        final OCLConstraintDescriptor desc = new OCLConstraintDescriptor ( namespace, constraint, constraints.size () + 1, messages );
        if ( category != null )
        {
            category.addConstraint ( desc );
        }

        constraints.add ( new OCLConstraint ( desc, ocl ) );

        logger.debug ( "Added contraint: {}, {}", ocl, desc );
    }
}
