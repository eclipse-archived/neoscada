/*******************************************************************************
 * Copyright (c) 2006, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.utils.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * An abstract base class for property change support. Derive your class from
 * this one if you
 * would like to add default property change support
 * 
 * @author Jens Reimann
 */
public class AbstractPropertyChange
{

    private transient final PropertyChangeSupport listeners = new PropertyChangeSupport ( this );

    public void addPropertyChangeListener ( final PropertyChangeListener listener )
    {
        this.listeners.addPropertyChangeListener ( listener );
    }

    public void removePropertyChangeListener ( final PropertyChangeListener listener )
    {
        this.listeners.removePropertyChangeListener ( listener );
    }

    public void addPropertyChangeListener ( final String propertyName, final PropertyChangeListener listener )
    {
        this.listeners.addPropertyChangeListener ( propertyName, listener );
    }

    public void removePropertyChangeListener ( final String propertyName, final PropertyChangeListener listener )
    {
        this.listeners.removePropertyChangeListener ( propertyName, listener );
    }

    protected void fireIndexedPropertyChange ( final String propertyName, final int index, final boolean oldValue, final boolean newValue )
    {
        this.listeners.fireIndexedPropertyChange ( propertyName, index, oldValue, newValue );
    }

    protected void fireIndexedPropertyChange ( final String propertyName, final int index, final int oldValue, final int newValue )
    {
        this.listeners.fireIndexedPropertyChange ( propertyName, index, oldValue, newValue );
    }

    protected void fireIndexedPropertyChange ( final String propertyName, final int index, final Object oldValue, final Object newValue )
    {
        this.listeners.fireIndexedPropertyChange ( propertyName, index, oldValue, newValue );
    }

    protected void firePropertyChange ( final PropertyChangeEvent evt )
    {
        this.listeners.firePropertyChange ( evt );
    }

    protected void firePropertyChange ( final String propertyName, final boolean oldValue, final boolean newValue )
    {
        this.listeners.firePropertyChange ( propertyName, oldValue, newValue );
    }

    protected void firePropertyChange ( final String propertyName, final int oldValue, final int newValue )
    {
        this.listeners.firePropertyChange ( propertyName, oldValue, newValue );
    }

    protected void firePropertyChange ( final String propertyName, final Object oldValue, final Object newValue )
    {
        this.listeners.firePropertyChange ( propertyName, oldValue, newValue );
    }

}