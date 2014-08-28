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

package org.eclipse.scada.configuration.validation.internal;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A property tester for use in XML enablement expressions on {@link EObject}s.
 * This tester supports the following properties:
 * <dl>
 * <dt>ePackage</dt>
 * <dd>value is the expected namespace URI of the {@link EPackage} containing
 * the object's {@link org.eclipse.emf.ecore.EClass}</dd>
 * </dl>
 */
public class EObjectPropertyTester extends PropertyTester
{

    private final static Logger logger = LoggerFactory.getLogger ( EObjectPropertyTester.class );

    @Override
    public boolean test ( final Object receiver, final String property, final Object[] args, final Object expectedValue )
    {
        logger.debug ( "Testing - receiver: {}, property: {}, expected: {}", receiver, property, expectedValue );
        boolean result = false;

        if ( "ePackage".equals ( property ) ) { //$NON-NLS-1$
            final EPackage actual = ( (EObject)receiver ).eClass ().getEPackage ();

            // check for null just in case
            result = actual != null && actual.getNsURI ().equals ( expectedValue );
        }

        logger.debug ( "Result: {}", result );

        return result;
    }

}
