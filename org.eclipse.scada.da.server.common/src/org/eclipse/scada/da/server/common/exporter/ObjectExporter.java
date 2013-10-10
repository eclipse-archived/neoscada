/*******************************************************************************
 * Copyright (c) 2010, 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.common.exporter;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;

import org.eclipse.scada.core.Variant;
import org.eclipse.scada.da.server.common.item.factory.ItemFactory;
import org.eclipse.scada.utils.lang.Disposable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * An object exporter which will bind to the change events of a bean.
 * <p>
 * The object exporter is attached to a bean using {@link #attachTarget(Object)}
 * and reads out the initial state of the bean and tries to subscribe to the
 * bean using the method
 * <q>addPropertyChangeListener</q>. Changes announced by the bean will then be
 * reflected in the data items of the exporter.
 * </p>
 * <p>
 * The difference to the {@link StaticObjectExporter} is, that the bean class
 * type must not be known in advance and data items will be created on the fly
 * based on the provided target object. If the target bean does not provide the
 * <q>addPropertyChangeListener</q> method it still shows the state the target
 * bean had on attaching but will not update. Attaching to a new target object
 * is more expensive using the {@link ObjectExporter} since all data items will
 * be destroyed in the process.
 * </p>
 * 
 * @author Jens Reimann
 */
public class ObjectExporter extends AbstractObjectExporter implements PropertyChangeListener, Disposable
{
    private final static Logger logger = LoggerFactory.getLogger ( ObjectExporter.class );

    private Object target;

    private boolean bound;

    private Map<String, Variant> additionalAttributes;

    /**
     * Create a new object exporter
     * 
     * @param itemFactory
     *            the factory used to create items. This factory is disposed
     *            when the object exporter is disposed.
     */
    public ObjectExporter ( final ItemFactory itemFactory )
    {
        this ( itemFactory, false, false );
    }

    /**
     * Create a new object exporter
     * 
     * @param itemFactory
     *            the factory used to create items. This factory is disposed
     *            when the object exporter is disposed.
     * @param readOnly
     *            set to <code>true</code> in order to make all items read-only
     * @param nullIsError
     *            set to <code>true</code> to mark fields that are
     *            <code>null</code> with an error attribute
     */
    public ObjectExporter ( final ItemFactory itemFactory, final boolean readOnly, final boolean nullIsError, final String prefix )
    {
        super ( itemFactory, readOnly, nullIsError, prefix );
    }

    public ObjectExporter ( final ItemFactory itemFactory, final boolean readOnly, final boolean nullIsError )
    {
        this ( itemFactory, readOnly, nullIsError, null );
    }

    /**
     * attach a new target. the old target will get detached.
     * 
     * @param target
     *            the new target
     */
    public synchronized void attachTarget ( final Object target )
    {
        detachTarget ();

        this.target = target;
        if ( target == null )
        {
            return;
        }

        final Method m = getEventMethod ( "addPropertyChangeListener" );
        try
        {
            m.invoke ( this.target, (PropertyChangeListener)this );
            this.bound = true;
        }
        catch ( final Throwable e )
        {
            logger.info ( "Failed to add property listener", e );
        }

        createDataItems ( target.getClass () );
    }

    public synchronized void setAttributes ( final Map<String, Variant> additionalAttributes )
    {
        if ( additionalAttributes != null )
        {
            this.additionalAttributes = Collections.unmodifiableMap ( additionalAttributes );
        }
        else
        {
            this.additionalAttributes = null;
        }

        updateItemsFromTarget ();
    }

    @Override
    protected Map<String, Variant> getAdditionalAttributes ()
    {
        return this.additionalAttributes;
    }

    @Override
    protected void fillAttributes ( final PropertyDescriptor pd, final Map<String, Variant> attributes )
    {
        super.fillAttributes ( pd, attributes );
        attributes.put ( "exporter.bound", Variant.valueOf ( this.bound ) );
    }

    /**
     * detach from the current target if we have one
     */
    public synchronized void detachTarget ()
    {
        if ( this.target == null )
        {
            return;
        }

        if ( this.bound )
        {
            final Method m = getEventMethod ( "removePropertyChangeListener" );
            try
            {
                m.invoke ( this.target, (PropertyChangeListener)this );
            }
            catch ( final Throwable e )
            {
                logger.info ( "Failed to dispose listener", e );
            }
        }

        this.items.clear ();
        this.attributes.clear ();

        this.factory.disposeAllItems ();
        this.target = null;
        this.bound = false;
    }

    protected Method getEventMethod ( final String methodName )
    {
        try
        {
            return this.target.getClass ().getMethod ( methodName, PropertyChangeListener.class );
        }
        catch ( final SecurityException e )
        {
            logger.info ( "Failed to get add method", e );
            return null;
        }
        catch ( final NoSuchMethodException e )
        {
            logger.info ( "Failed to get add method", e );
            return null;
        }
    }

    @Override
    public synchronized void propertyChange ( final PropertyChangeEvent evt )
    {
        updateAttribute ( evt.getPropertyName (), evt.getNewValue (), null, null );
    }

    @Override
    protected Object getTarget ()
    {
        return this.target;
    }

}
