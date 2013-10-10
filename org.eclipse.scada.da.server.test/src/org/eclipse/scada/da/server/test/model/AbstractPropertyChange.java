/*******************************************************************************
 * Copyright (c) 2009, 2010 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.da.server.test.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AbstractPropertyChange
{
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport ( this );

    public void addPropertyChangeListener ( final PropertyChangeListener listener )
    {
        this.propertyChangeSupport.addPropertyChangeListener ( listener );
    }

    public void addPropertyChangeListener ( final String propertyName, final PropertyChangeListener listener )
    {
        this.propertyChangeSupport.addPropertyChangeListener ( propertyName, listener );
    }

    protected void firePropertyChange ( final PropertyChangeEvent evt )
    {
        this.propertyChangeSupport.firePropertyChange ( evt );
    }

    protected void firePropertyChange ( final String propertyName, final boolean oldValue, final boolean newValue )
    {
        this.propertyChangeSupport.firePropertyChange ( propertyName, oldValue, newValue );
    }

    protected void firePropertyChange ( final String propertyName, final int oldValue, final int newValue )
    {
        this.propertyChangeSupport.firePropertyChange ( propertyName, oldValue, newValue );
    }

    protected void firePropertyChange ( final String propertyName, final Object oldValue, final Object newValue )
    {
        this.propertyChangeSupport.firePropertyChange ( propertyName, oldValue, newValue );
    }

    public void removePropertyChangeListener ( final PropertyChangeListener listener )
    {
        this.propertyChangeSupport.removePropertyChangeListener ( listener );
    }

    public void removePropertyChangeListener ( final String propertyName, final PropertyChangeListener listener )
    {
        this.propertyChangeSupport.removePropertyChangeListener ( propertyName, listener );
    }
}
