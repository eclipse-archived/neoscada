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
package org.eclipse.scada.configuration.validation.ocl;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.ocl.AbstractOCLModelConstraint;
import org.eclipse.ocl.EnvironmentFactory;
import org.eclipse.ocl.Query;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation of the constraint that our provider provides.
 * 
 * @author Christian W. Damus (cdamus)
 */
class OCLConstraint extends AbstractOCLModelConstraint<EClassifier, Constraint, EClass, EObject>
{

    private final static Logger logger = LoggerFactory.getLogger ( OCLConstraint.class );

    private final OCL.Query query;

    OCLConstraint ( final OCLConstraintDescriptor desc, final OCL ocl )
    {
        super ( desc );

        this.query = ocl.createQuery ( desc.getConstraint () );
    }

    // override this method to indicate that we are doing new-style OCL
    @Override
    protected EnvironmentFactory<?, EClassifier, ?, ?, ?, ?, ?, ?, ?, Constraint, EClass, EObject> createOCLEnvironmentFactory ()
    {
        return this.query.getOCL ().getEnvironment ().getFactory ();
    }

    @Override
    public Query<EClassifier, EClass, EObject> getConstraintCondition ( final EObject target )
    {
        return this.query;
    }

    @Override
    public IStatus validate ( final IValidationContext ctx )
    {
        final IStatus result = super.validate ( ctx );

        logger.debug ( "Validating - this: {}, result: {}, ctx: {}", this, result, ctx );

        return result;
    }
}
