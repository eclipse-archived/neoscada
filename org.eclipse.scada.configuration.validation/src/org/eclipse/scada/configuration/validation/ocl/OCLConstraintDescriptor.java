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

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.ConstraintSeverity;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.AbstractConstraintDescriptor;
import org.eclipse.ocl.ecore.Constraint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class OCLConstraintDescriptor extends AbstractConstraintDescriptor
{

    private final static Logger logger = LoggerFactory.getLogger ( OCLConstraintDescriptor.class );

    private final Constraint constraint;

    private final String id;

    private final String name;

    private final String namespace;

    private final int code;

    private String messagePattern;

    private ConstraintSeverity severity;

    public OCLConstraintDescriptor ( final String namespace, final Constraint constraint, final int code, final ResourceBundle messages )
    {
        this.constraint = constraint;

        String name = constraint.getName ();
        if ( name == null )
        {
            name = Long.toHexString ( System.identityHashCode ( constraint ) );
        }

        this.id = namespace + '.' + name;
        this.name = name;
        this.namespace = namespace;
        this.code = code;

        if ( messages != null )
        {
            this.messagePattern = getString ( messages, name + ".message" );
            final String severityString = getString ( messages, name + ".severity" );
            if ( severityString != null )
            {
                this.severity = ConstraintSeverity.valueOf ( severityString );
            }
        }
        if ( this.severity == null )
        {
            this.severity = ConstraintSeverity.ERROR;
        }
    }

    public String getString ( final ResourceBundle messages, final String name )
    {
        try
        {
            return messages.getString ( name );
        }
        catch ( final MissingResourceException e )
        {
            logger.debug ( "Did not find: {}", name );
            return null;
        }
    }

    final Constraint getConstraint ()
    {
        return this.constraint;
    }

    @Override
    public String getBody ()
    {
        return this.constraint.getSpecification ().getBodyExpression ().toString ();
    }

    @Override
    public String getDescription ()
    {
        return getBody ();
    }

    @Override
    public EvaluationMode<?> getEvaluationMode ()
    {
        return EvaluationMode.BATCH;
    }

    @Override
    public String getId ()
    {
        return this.id;
    }

    @Override
    public String getMessagePattern ()
    {
        if ( this.messagePattern != null )
        {
            return this.messagePattern;
        }
        else
        {
            return String.format ( "Constraint %s violated on {0}", getName () ); //$NON-NLS-1$
        }
    }

    @Override
    public String getName ()
    {
        return this.name;
    }

    @Override
    public String getPluginId ()
    {
        return this.namespace;
    }

    @Override
    public ConstraintSeverity getSeverity ()
    {
        return this.severity;
    }

    @Override
    public int getStatusCode ()
    {
        return this.code;
    }

    @Override
    public boolean targetsEvent ( final Notification notification )
    {
        return false;
    }

    @Override
    public boolean targetsTypeOf ( final EObject eObject )
    {
        return this.constraint.getSpecification ().getContextVariable ().getType ().isInstance ( eObject );
    }

}
