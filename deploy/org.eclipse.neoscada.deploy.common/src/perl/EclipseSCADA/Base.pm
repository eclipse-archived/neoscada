##################################################################################
# Copyright (c) 2011, 2014 TH4 SYSTEMS GmbH and others.
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
$VERSION = '0.03';

sub excluded {
   my $file = shift;
   return 1 if $file =~ /.*\.source_.*/;
   foreach my $exp ( @_ ) {
      return 1 if $file =~ $exp;
   }
   return 0;
}

sub trim($)
{
  my $string = shift;
  $string =~ s/^\s+//;
  $string =~ s/\s+$//;
  return $string;
}

sub classpath () {
   my @classpath = ();

# exclude list

   my @excludes = ();

   if ( -d configurationRoot() . "/jarcfg" ) {
      find ( sub {
         if  ( -r $File::Find::name and $File::Find::name =~ /\.exclude$/ ) {
            if ( open FILE, "<$File::Find::name" ) {
              while ( my $line = <FILE> ) {
                  push @excludes, trim($line);
              }
              close FILE;
            }
         }
      }, configurationRoot () . "/jarcfg" );
   }

# home/jar

   if ( -d home() . "/jar" ) {
      find ( sub {
         push @classpath, $File::Find::name if -r $File::Find::name and $File::Find::name =~ /\.jar$/ and not excluded($File::Find::name,@excludes);
      }, home() . "/jar" );
   }

# p2 repos

   my @repos = ();
   find ( { no_chdir => 1, wanted => sub {
	return if ! -d $File::Find::name;
	my $plugins = $File::Find::name . "/plugins";
	push @repos, $plugins if -d $plugins;
   }}, "/usr/share/neoscada/p2" );

   if ( @repos ) {
      find ( sub {
         push @classpath, $File::Find::name if -r $File::Find::name and $File::Find::name =~ /\.jar$/ and not excluded($File::Find::name,@excludes);
      }, @repos );
   }
   
   return @classpath;
}

sub home () {
  Carp::croak ( "'NEOSCADA_HOME' not set") unless $ENV{"NEOSCADA_HOME"};
  return $ENV{'NEOSCADA_HOME'};
}

sub configurationRoot () {
  return $ENV{'NEOSCADA_CONFIGURATION_ROOT'} if $ENV{'NEOSCADA_CONFIGURATION_ROOT'};
  return "/etc/neoscada";
}

sub pidfileRoot () {
  return $ENV{'NEOSCADA_PIDFILE_ROOT'} if $ENV{'NEOSCADA_PIDFILE_ROOT'};
  return "/var/run";
}

1;
__END__
