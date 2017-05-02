<?xml version="1.0"?>
<xsl:stylesheet version="2.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:wix="http://schemas.microsoft.com/wix/2006/wi">
	
	<xsl:output omit-xml-declaration="yes" indent="yes"/>
  
	<xsl:key name="exe-search" match="wix:Component[contains(wix:File/@Source, '.exe')]" use="@Id"/>
	<xsl:template match="wix:Component[key('exe-search', @Id)]"/>
	<xsl:template match="wix:ComponentRef[key('exe-search', @Id)]"/>
	
	<xsl:template match="node()|@*">
    <xsl:copy>
      <xsl:apply-templates select="node()|@*"/>
    </xsl:copy>
	</xsl:template>
  
  
</xsl:stylesheet>