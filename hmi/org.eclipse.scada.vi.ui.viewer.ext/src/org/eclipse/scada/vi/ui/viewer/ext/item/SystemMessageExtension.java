/*******************************************************************************
 * Copyright (c) 2013 Jens Reimann and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Jens Reimann - initial API and implementation
 *******************************************************************************/
package org.eclipse.scada.vi.ui.viewer.ext.item;

import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.scada.core.Variant;
import org.eclipse.scada.vi.ui.user.viewer.ViewManager;
import org.eclipse.scada.vi.ui.user.viewer.ext.ViewerExtension;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class SystemMessageExtension extends AbstractItemExtension implements ViewerExtension
{

    public static class SystemMessageLabel extends DataItemLabel
    {
        private final LocalResourceManager resourceManager;

        public SystemMessageLabel ( final Composite parent, final String connectionId, final String itemId )
        {
            super ( parent, connectionId, itemId );
            this.resourceManager = new LocalResourceManager ( JFaceResources.getResources ( parent.getDisplay () ), this.label );
        }

        @Override
        protected void bind ()
        {
            this.model.addValueChangeListener ( new IValueChangeListener () {

                @Override
                public void handleValueChange ( final ValueChangeEvent event )
                {
                    if ( !SystemMessageLabel.this.label.isDisposed () )
                    {
                        process ( event.diff.getNewValue () );
                    }
                }
            } );
        }

        protected void process ( final Object value )
        {
            String text = "";

            if ( value instanceof Variant )
            {
                text = ( (Variant)value ).asString ( "" );
            }
            final int idx = text.indexOf ( "#" );

            String icon = null;
            if ( idx >= 0 && idx < text.length () )
            {
                icon = text.substring ( 0, idx );
                text = text.substring ( idx + 1 );
            }

            this.label.setText ( text );

            if ( icon == null )
            {
                this.label.setImage ( null );
            }
            else
            {
                this.label.setImage ( this.resourceManager.createImageWithDefault ( makeDescriptor ( icon ) ) );
            }

            this.label.getParent ().layout ();
        }

        private ImageDescriptor makeDescriptor ( final String icon )
        {
            if ( "info".equalsIgnoreCase ( icon ) )
            {
                return ImageDescriptor.createFromFile ( SystemMessageExtension.class, "icons/information.png" );
            }
            else if ( "warning".equalsIgnoreCase ( icon ) )
            {
                return ImageDescriptor.createFromFile ( SystemMessageExtension.class, "icons/exclamation.png" );
            }

            return ImageDescriptor.getMissingImageDescriptor ();
        }
    }

    @Override
    public Control create ( final Composite parent, final ViewManager viewManager, final boolean horizontal )
    {
        return new SystemMessageLabel ( parent, this.connectionId, this.itemId ).getControl ();
    }

}
