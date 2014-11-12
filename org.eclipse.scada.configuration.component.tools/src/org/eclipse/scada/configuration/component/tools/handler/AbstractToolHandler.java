package org.eclipse.scada.configuration.component.tools.handler;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.scada.configuration.component.ComponentWorld;
import org.eclipse.scada.configuration.component.lib.Worlds;
import org.eclipse.scada.configuration.component.tools.Activator;
import org.eclipse.scada.configuration.infrastructure.World;
import org.eclipse.scada.ui.databinding.AbstractSelectionHandler;
import org.eclipse.scada.ui.utils.SelectionHelper;

public abstract class AbstractToolHandler extends AbstractSelectionHandler
{

    public AbstractToolHandler ()
    {
        super ();
    }

    protected World findInfrastructureWorld () throws CoreException
    {
        ComponentWorld world = null;
        for ( final EObject v : SelectionHelper.iterable ( getSelection (), EObject.class ) )
        {
            final ComponentWorld w = Worlds.findComponentWorld ( v );
            if ( w == null )
            {
                throw new CoreException ( new Status ( IStatus.ERROR, Activator.PLUGIN_ID, String.format ( "Element does not belong to a component world: %s", v ) ) );
            }
            if ( world != null && w != world )
            {
                throw new CoreException ( new Status ( IStatus.ERROR, Activator.PLUGIN_ID, String.format ( "Elements belong to different component worlds. This is not supported for now.", v ) ) );
            }
            world = w;
        }
        return world.getInfrastructure ();
    }

}
