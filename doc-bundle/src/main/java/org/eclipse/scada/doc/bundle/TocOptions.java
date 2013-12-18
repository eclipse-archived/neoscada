package org.eclipse.scada.doc.bundle;

public class TocOptions
{
    private String label = "API Reference";

    private String linkTo = "tocreference.xml#javadoc";

    public void setLabel ( final String label )
    {
        this.label = label;
    }

    public String getLabel ()
    {
        return this.label;
    }

    public String getLinkTo ()
    {
        return this.linkTo;
    }

    public void setLinkTo ( final String linkTo )
    {
        this.linkTo = linkTo;
    }
}
