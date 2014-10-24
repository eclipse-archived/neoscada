package org.eclipse.scada.build.helper.target;

import java.io.File;
import java.util.List;

import javax.xml.xpath.XPathExpressionException;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.eclipse.scada.build.helper.AbstractHelperMojo;
import org.eclipse.scada.build.helper.XmlHelper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @since 0.0.19
 */
@Mojo (
        name = "merge-target-files",
        defaultPhase = LifecyclePhase.COMPILE,
        aggregator = false,
        requiresProject = true,
        requiresDirectInvocation = false )
public class MergeMojo extends AbstractHelperMojo
{
    @Parameter ( property = "sourceFiles", required = true )
    protected List<File> sourceFiles;

    @Parameter ( property = "targetFile", required = true )
    protected File targetFile;

    @Parameter ( property = "name", required = false )
    protected String name;

    @Override
    public void execute () throws MojoExecutionException, MojoFailureException
    {
        if ( this.sourceFiles == null || this.sourceFiles.isEmpty () )
        {
            throw new MojoFailureException ( "'sourceFiles' must not be empty!" );
        }

        try
        {
            Document doc = null;

            for ( final File file : this.sourceFiles )
            {
                if ( doc == null )
                {
                    doc = XmlHelper.parse ( file );
                }
                else
                {
                    doc = merge ( doc, XmlHelper.parse ( file ) );
                }
            }

            updateInformation ( doc );

            XmlHelper.write ( doc, this.targetFile );
        }
        catch ( final Exception e )
        {
            throw new MojoExecutionException ( "Failed to merge target files", e );
        }
    }

    private void updateInformation ( final Document doc )
    {
        final Element targetElement = doc.getDocumentElement ();
        if ( this.name != null )
        {
            targetElement.setAttribute ( "name", this.name );
        }
    }

    protected Document merge ( final Document doc, final Document fragment ) throws XPathExpressionException
    {
        final List<Node> locNodes = XmlHelper.findNodes ( doc, "/target/locations" );
        if ( locNodes.isEmpty () )
        {
            throw new IllegalStateException ( "Unable to find locations element in source document" );
        }

        final Element locations = (Element)locNodes.get ( 0 );

        for ( final Node node : XmlHelper.findNodes ( fragment, "//location" ) )
        {
            locations.appendChild ( doc.importNode ( node, true ) );
        }
        return doc;
    }
}
