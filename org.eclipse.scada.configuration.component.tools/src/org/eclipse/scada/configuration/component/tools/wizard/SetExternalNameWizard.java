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
package org.eclipse.scada.configuration.component.tools.wizard;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Callable;

import javax.script.CompiledScript;
import javax.script.ScriptContext;
import javax.script.SimpleScriptContext;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.scada.configuration.component.ComponentPackage;
import org.eclipse.scada.configuration.component.ExternalValue;
import org.eclipse.scada.configuration.component.tools.Activator;
import org.eclipse.scada.configuration.component.tools.utils.CompoundManager;
import org.eclipse.scada.ui.utils.SelectionHelper;
import org.eclipse.scada.ui.utils.status.StatusHelper;
import org.eclipse.scada.utils.script.Scripts;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.statushandlers.StatusManager;

public class SetExternalNameWizard extends Wizard implements IWorkbenchWizard
{

    private ScriptPage scriptPage;

    private IStructuredSelection selection;

    public SetExternalNameWizard ( final IStructuredSelection selection )
    {
        this.selection = selection;
        setDialogSettings ( DialogSettings.getOrCreateSection ( Activator.getDefault ().getDialogSettings (), "setExternalNameWizard" ) );
    }

    @Override
    public boolean performFinish ()
    {
        final CompiledScript script = this.scriptPage.getScript ();

        try
        {
            getContainer ().run ( false, false, new IRunnableWithProgress () {

                @Override
                public void run ( final IProgressMonitor monitor ) throws InvocationTargetException, InterruptedException
                {
                    try
                    {
                        setExternalName ( script );
                    }
                    catch ( final Exception e )
                    {
                        throw new InvocationTargetException ( e );
                    }
                    finally
                    {
                        monitor.done ();
                    }
                }
            } );
        }
        catch ( final Exception e )
        {
            StatusManager.getManager ().handle ( StatusHelper.convertStatus ( Activator.PLUGIN_ID, e ) );
        }

        return true;
    }

    @Override
    public void addPages ()
    {
        addPage ( this.scriptPage = new ScriptPage () );
        addPage ( new PreviewPage ( this.scriptPage, this.selection ) );
    }

    public void setExternalName ( final CompiledScript script ) throws Exception
    {
        final CompoundManager manager = new CompoundManager ();

        for ( final ExternalValue v : SelectionHelper.iterable ( this.selection, ExternalValue.class ) )
        {
            final EditingDomain domain = AdapterFactoryEditingDomain.getEditingDomainFor ( v );
            if ( domain == null )
            {
                continue;
            }
            final String name = evalName ( script, v );
            manager.append ( domain, SetCommand.create ( domain, v, ComponentPackage.Literals.EXTERNAL_VALUE__SOURCE_NAME, name ) );
        }

        manager.executeAll ();
    }

    public static String evalName ( final CompiledScript script, final ExternalValue v ) throws Exception
    {
        final SimpleScriptContext ctx = new SimpleScriptContext ();

        ctx.setAttribute ( "item", v, ScriptContext.ENGINE_SCOPE ); //$NON-NLS-1$

        final Object result = Scripts.executeWithClassLoader ( Activator.class.getClassLoader (), new Callable<Object> () {

            @Override
            public Object call () throws Exception
            {
                return script.eval ( ctx );
            }
        } );

        if ( result == null )
        {
            return null;
        }

        return result.toString ();
    }

    @Override
    public void init ( final IWorkbench workbench, final IStructuredSelection selection )
    {
        this.selection = selection;
    }

}
