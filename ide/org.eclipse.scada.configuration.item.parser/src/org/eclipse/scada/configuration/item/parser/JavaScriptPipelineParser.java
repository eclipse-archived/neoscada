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
package org.eclipse.scada.configuration.item.parser;

import java.io.IOException;
import java.io.OutputStreamWriter;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.scada.configuration.item.ItemFactory;
import org.eclipse.scada.configuration.item.JavaScriptCustomizationPipeline;
import org.eclipse.scada.configuration.item.ScriptCustomizationPipeline;

public class JavaScriptPipelineParser implements Factory
{
    private static class ScriptCustomizationPipelineResource extends ScriptResourceImpl
    {
        public ScriptCustomizationPipelineResource ( final URI uri, final String scriptEngine, final String fileExtension, final String defaultCharacterSet )
        {
            super ( uri, scriptEngine, fileExtension, defaultCharacterSet );
        }

        @Override
        protected void write ( final OutputStreamWriter writer ) throws IOException
        {
            final ScriptCustomizationPipeline content = (ScriptCustomizationPipeline)getContents ().get ( 0 );
            if ( content.getScriptEngine () != null && !content.getScriptEngine ().equals ( this.scriptEngine ) )
            {
                throw new IllegalArgumentException ( String.format ( "Script language must be of type '%s' in order to save it as '%s' file.", this.scriptEngine, this.fileExtension ) );
            }
            writer.write ( content.getCode () );
        }

        @Override
        protected EObject parse ( final String data )
        {
            final JavaScriptCustomizationPipeline content = ItemFactory.eINSTANCE.createJavaScriptCustomizationPipeline ();
            content.setCode ( data );
            return content;
        }
    }

    @Override
    public Resource createResource ( final URI uri )
    {
        return new ScriptCustomizationPipelineResource ( uri, "JavaScript", "icm_js", "UTF-8" );
    }
}
