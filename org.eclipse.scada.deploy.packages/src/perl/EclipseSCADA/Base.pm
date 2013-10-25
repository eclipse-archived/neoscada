##################################################################################
# Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
# Contributors:
#      TH4 SYSTEMS GmbH - initial API and implementation
#      IBH SYSTEMS GmbH - also add <p2repo>/plugins/*.jar to the classpath
##################################################################################
package EclipseSCADA::Base;

use strict;
use vars qw($VERSION @ISA @EXPORT @EXPORT_OK);
use File::Find;

require Exporter;
require Carp;

@ISA = qw(Exporter AutoLoader);
# Items to export into callers namespace by default. Note: do not export
# names by default without a very good reason. Use EXPORT_OK instead.
# Do not simply export all your public functions/methods/constants.
@EXPORT = qw(
);
$VERSION = '0.01';

sub classpath () {
   my @classpath = ();

# home/jar   

   find ( sub {
	push @classpath, $File::Find::name if -r $File::Find::name and $File::Find::name =~ /\.jar$/;
   }, home()."/jar" );

# p2 repos

   my @repos = ();
   find ( { no_chdir => 1, wanted => sub {
	my $plugins = $File::Find::name ."/plugins";
	push @repos, $plugins if -d $plugins;
   }}, "/usr/share/eclipsescada/p2" );

   find ( sub {
	push @classpath, $File::Find::name if -r $File::Find::name and $File::Find::name =~ /\.jar$/;
   }, @repos );
   
   return @classpath;
}


sub home () {
  Carp::croak ( "'ECLIPSE_SCADA_HOME' not set") unless $ENV{"ECLIPSE_SCADA_HOME"};
  return $ENV{'ECLIPSE_SCADA_HOME'};
}

sub configurationRoot () {
  return $ENV{'ECLIPSE_SCADA_CONFIGURATION_ROOT'} if $ENV{'ECLIPSE_SCADA_CONFIGURATION_ROOT'};
  return "/etc/eclipsescada";
}

sub pidfileRoot () {
  return $ENV{'ECLIPSE_SCADA_PIDFILE_ROOT'} if $ENV{'ECLIPSE_SCADA_PIDFILE_ROOT'};
  return "/var/run";
}

1;
__END__
