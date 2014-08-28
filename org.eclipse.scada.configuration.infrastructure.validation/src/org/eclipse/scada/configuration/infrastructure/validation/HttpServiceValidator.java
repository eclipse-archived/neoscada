/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.configuration.infrastructure.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.scada.configuration.infrastructure.EventInjectorHttp;
import org.eclipse.scada.configuration.infrastructure.HttpServiceModule;
import org.eclipse.scada.configuration.infrastructure.HttpServices;
import org.eclipse.scada.configuration.infrastructure.InfrastructurePackage;
import org.eclipse.scada.configuration.infrastructure.WebAdminConsole;
import org.eclipse.scada.ide.validation.ValidationContext;
import org.eclipse.scada.ide.validation.Validator;

public class HttpServiceValidator implements Validator
{
    @Override
    public void validate ( final ValidationContext context )
    {
        if ( context.getTarget () instanceof WebAdminConsole )
        {
            performValidation ( (WebAdminConsole)context.getTarget (), InfrastructurePackage.Literals.WEB_ADMIN_CONSOLE__HTTP_SERVICE, context );
        }
        else if ( context.getTarget () instanceof EventInjectorHttp )
        {
            performValidation ( (EventInjectorHttp)context.getTarget (), InfrastructurePackage.Literals.EVENT_INJECTOR_HTTP__HTTP_SERVICE, context );
        }
    }

    protected void performValidation ( final EObject target, final EStructuralFeature feature, final ValidationContext ctx )
    {
        final Object service = target.eGet ( feature );
        if ( service == null )
        {
            return;
        }

        if ( ! ( service instanceof HttpServiceModule ) )
        {
            throw new IllegalStateException ( String.format ( "Validator can only handle %s", HttpServiceModule.class.getName () ) );
        }

        if ( HttpServices.isValid ( target, (HttpServiceModule)service ) )
        {
            ctx.add ( feature, "Selected HTTP Service is not present in the target application setup. The selected service must be either a module in the same application or in the selected configuration of the application." );
        }
    }

}
