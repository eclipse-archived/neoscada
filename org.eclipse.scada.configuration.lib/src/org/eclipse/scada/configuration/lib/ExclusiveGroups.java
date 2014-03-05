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
package org.eclipse.scada.configuration.lib;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ExclusiveGroups
{
    private final static Logger logger = LoggerFactory.getLogger ( ExclusiveGroups.class );

    private static final String VALUE_GROUP_ID = "groupId"; //$NON-NLS-1$

    private static final String SOURCE_NAME = "http://eclipse.org/SCADA/Configuration/World/ExclusiveGroup"; //$NON-NLS-1$

    private ExclusiveGroups ()
    {
    }

    /**
     * Remove exclusive groups from a collection of objects
     * 
     * @param objects
     *            the objects to process
     * @param groupIds
     *            the groups to remove
     */
    public static void removeGroups ( final Collection<? extends EObject> objects, final Set<String> groupIds )
    {
        if ( groupIds == null || groupIds.isEmpty () )
        {
            return;
        }

        for ( final Iterator<? extends EObject> i = objects.iterator (); i.hasNext (); )
        {
            final EObject obj = i.next ();

            final EAnnotation annotation = findAnnotation ( obj );
            if ( annotation == null )
            {
                continue;
            }

            final String groupId = annotation.getDetails ().get ( VALUE_GROUP_ID );
            if ( groupId == null )
            {
                continue;
            }

            if ( groupIds.contains ( groupId ) )
            {
                i.remove ();
            }
        }
    }

    /**
     * Finds the annotation even on supertypes
     * 
     * @param target
     *            the object to check
     * @return the annotation or <code>null</code> the object or its supertypes
     *         don't have the annotation
     */
    public static EAnnotation findAnnotation ( final EObject target )
    {
        EAnnotation annotation;

        annotation = target.eClass ().getEAnnotation ( SOURCE_NAME );
        if ( annotation != null )
        {
            logger.debug ( "Found direct annotation - target: {}, annotation: {}", target, annotation );
            return annotation;
        }

        for ( final EClass clazz : target.eClass ().getEAllSuperTypes () )
        {
            logger.debug ( "Checking supertype: {}", clazz );
            annotation = clazz.getEAnnotation ( SOURCE_NAME );
            if ( annotation != null )
            {
                logger.debug ( "Found annotation - target: {}, superclass: {}, annotation: {}", target, clazz, annotation );
                return annotation;
            }
        }
        logger.debug ( "Annotation on {} not found", target );
        return null;
    }

    /**
     * Make a set of group ids present in the object collection
     * 
     * @param objects
     *            the objects to check
     * @return the group set, never <code>null</code>
     */
    public static Set<String> makeGroupIds ( final Collection<? extends EObject> objects )
    {
        final Set<String> result = new HashSet<> ();

        for ( final EObject obj : objects )
        {
            final EAnnotation annotation = findAnnotation ( obj );
            if ( annotation == null )
            {
                continue;
            }
            final String groupId = annotation.getDetails ().get ( VALUE_GROUP_ID );
            if ( groupId == null )
            {
                continue;
            }
            result.add ( groupId );
        }

        return result;
    }

    /**
     * Remove all exclusive objects that are in the one group from the other
     * 
     * @param objects
     *            the object from which objects will be removed
     * @param sourceObjects
     *            the source of the exclusive group objects
     */
    public static void removeGroups ( final Collection<? extends EObject> objects, final Collection<? extends EObject> sourceObjects )
    {
        removeGroups ( objects, makeGroupIds ( sourceObjects ) );
    }

    /**
     * Return an aggregated map of group violations
     * <p>
     * This method actually calls {@link #aggregateGroups(EList)} and only
     * returns groups with a size greater than 1.
     * </p>
     * 
     * @param objects
     *            the objects to validate
     * @return the map of group violations
     */
    public static Map<String, Set<EObject>> validate ( final EList<? extends EObject> objects )
    {
        final Map<String, Set<EObject>> map = aggregateGroups ( objects );

        final Map<String, Set<EObject>> result = new HashMap<> ();

        for ( final Map.Entry<String, Set<EObject>> entry : map.entrySet () )
        {
            if ( entry.getValue ().size () > 1 )
            {
                result.put ( entry.getKey (), entry.getValue () );
            }
        }

        return result;
    }

    /**
     * Group objects by groupId
     * <p>
     * Note that object without are group are not returned
     * </p>
     * 
     * @param objects
     *            the object to group
     * @return the grouped objects
     */
    public static Map<String, Set<EObject>> aggregateGroups ( final EList<? extends EObject> objects )
    {
        final Map<String, Set<EObject>> map = new HashMap<> ();

        for ( final EObject obj : objects )
        {
            final EAnnotation annotation = findAnnotation ( obj );
            if ( annotation == null )
            {
                continue;
            }
            final String groupId = annotation.getDetails ().get ( VALUE_GROUP_ID );
            if ( groupId == null )
            {
                continue;
            }

            Set<EObject> set = map.get ( groupId );
            if ( set == null )
            {
                set = new HashSet<> ();
                map.put ( groupId, set );
            }
            set.add ( obj );
        }

        return map;
    }
}
