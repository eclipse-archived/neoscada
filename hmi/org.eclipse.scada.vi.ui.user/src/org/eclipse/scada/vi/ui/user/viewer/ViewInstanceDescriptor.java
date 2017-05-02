/*******************************************************************************
 * Copyright (c) 2012 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.ui.user.viewer;

import java.net.URI;
import java.util.Comparator;
import java.util.Map;

import org.eclipse.core.expressions.Expression;

public class ViewInstanceDescriptor
{

    public static final Comparator<? super ViewInstanceDescriptor> DESCRIPTOR_ORDER_COMPARATOR = new Comparator<ViewInstanceDescriptor> () {
        @Override
        public int compare ( final ViewInstanceDescriptor o1, final ViewInstanceDescriptor o2 )
        {
            return Integer.valueOf ( o1.getOrder () ).compareTo ( o2.getOrder () );
        }
    };

    private final String id;

    private final String parentId;

    private final URI uri;

    private final String name;

    private final Map<String, String> properties;

    private final Boolean zooming;

    private final Expression visibleExpression;

    private final Expression lazyExpression;

    private final int order;

    private final boolean defaultInstance;

    private final Expression defaultInstanceExpression;

    private final ViewInstanceFactory factory;

    private final String summaryConnectionId;

    private final String summaryItemId;

    private final boolean mainView;

    public ViewInstanceDescriptor ( final String id, final String parentId, final ViewInstanceFactory factory, final URI uri, final String name, final int order, final boolean defaultInstance, final Boolean zooming, final Expression lazyExpression, final Expression visibleExpression, final Expression defaultInstanceExpression, final String summaryConnectionId, final String summaryItemId, final boolean mainView, final Map<String, String> properties )
    {
        super ();
        this.id = id;
        this.parentId = parentId;
        this.factory = factory;
        this.uri = uri;
        this.name = name;
        this.properties = properties;
        this.order = order;
        this.defaultInstance = defaultInstance;
        this.zooming = zooming;
        this.lazyExpression = lazyExpression;
        this.visibleExpression = visibleExpression;
        this.defaultInstanceExpression = defaultInstanceExpression;
        this.summaryConnectionId = summaryConnectionId;
        this.summaryItemId = summaryItemId;
        this.mainView = mainView;
    }

    public boolean isMainView ()
    {
        return this.mainView;
    }

    public boolean isDefaultInstance ()
    {
        return this.defaultInstance;
    }

    public Expression getDefaultInstanceExpression ()
    {
        return this.defaultInstanceExpression;
    }

    public Expression getLazyExpression ()
    {
        return this.lazyExpression;
    }

    public Expression getVisibleExpression ()
    {
        return this.visibleExpression;
    }

    public Boolean getZooming ()
    {
        return this.zooming;
    }

    public String getId ()
    {
        return this.id;
    }

    public String getParentId ()
    {
        return this.parentId;
    }

    public URI getUri ()
    {
        return this.uri;
    }

    public String getName ()
    {
        return this.name;
    }

    public Map<String, String> getProperties ()
    {
        return this.properties;
    }

    public int getOrder ()
    {
        return this.order;
    }

    public ViewInstanceFactory getFactory ()
    {
        return this.factory;
    }

    public String getSummaryConnectionId ()
    {
        return this.summaryConnectionId;
    }

    public String getSummaryItemId ()
    {
        return this.summaryItemId;
    }

    @Override
    public String toString ()
    {
        return String.format ( "[ViewInstance: %s]", this.id );
    }

    @Override
    public int hashCode ()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( this.id == null ? 0 : this.id.hashCode () );
        return result;
    }

    @Override
    public boolean equals ( final Object obj )
    {
        if ( this == obj )
        {
            return true;
        }
        if ( obj == null )
        {
            return false;
        }
        if ( getClass () != obj.getClass () )
        {
            return false;
        }
        final ViewInstanceDescriptor other = (ViewInstanceDescriptor)obj;
        if ( this.id == null )
        {
            if ( other.id != null )
            {
                return false;
            }
        }
        else if ( !this.id.equals ( other.id ) )
        {
            return false;
        }
        return true;
    }
}
