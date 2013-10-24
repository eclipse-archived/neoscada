##################################################################################
# Copyright (c) 2011, 2013 TH4 SYSTEMS GmbH and others.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
# Contributors:
#      TH4 SYSTEMS GmbH - initial API and implementation
##################################################################################
package EclipseSCADA::Base;

use strict;
use vars qw($VERSION @ISA @EXPORT @EXPORT_OK);

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
   
   my $where = home() . "/jar";
   my $next;
   while (defined($next = <$where/*.jar>)) {
     if ( -r $next ) 
     {
       push @classpath, $next;    
     }
   }
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
