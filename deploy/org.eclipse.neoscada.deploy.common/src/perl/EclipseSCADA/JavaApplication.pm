##################################################################################
# Copyright (c) 2011, 2014 TH4 SYSTEMS GmbH and others.
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
# 
# Contributors:
#      TH4 SYSTEMS GmbH - initial API and implementation
#      IBH SYSTEMS GmbH - remove default JVM settings
##################################################################################
package EclipseSCADA::JavaApplication;

use strict;
use vars qw($VERSION @ISA @EXPORT @EXPORT_OK);

use base 'EclipseSCADA::Application';

require Exporter;

#@ISA = qw(EclipseSCADA::Application);
# Items to export into callers namespace by default. Note: do not export
# names by default without a very good reason. Use EXPORT_OK instead.
# Do not simply export all your public functions/methods/constants.
@EXPORT = qw(
);
$VERSION = '0.03';

sub new {
    my $class = shift;
    my $className = shift;
    my $instanceName = shift;
    
    my $self = EclipseSCADA::Application->new (
      "/usr/bin/jsvc"
    );
    
    $self->{'className'} = $className;
    $self->{'instanceName'} = $instanceName;
    $self->{'classpath'} = ();
    $self->{'properties'} = {};
    $self->{'javaArgs'} = ();

    bless $self, $class;

    return $self;
}

sub classpath {
  my $self = shift;
  if ( @_ ) {
    $self->{'classpath'} = \@_;
  }
  return $self->{'classpath'};
}

sub appendClasspath {
  my $self = shift;
  push @{$self->{'classpath'}}, @_;
}

sub instanceName {
  my $self = shift;
  if (@_) {
    $self->{'instanceName'} = shift;
  }
  return $self->{'instanceName'};
}

sub user {
  my $self = shift;
  if (@_) {
    $self->{'user'} = shift;
  }
  return $self->{'user'};
}

sub attach {
  my $self = shift;
  if (@_) {
    $self->{'attach'} = shift;
  }
  return $self->{'attach'};
}

sub stop {
  my $self = shift;
  if (@_) {
    $self->{'stop'} = shift;
  }
  return $self->{'stop'};
}

sub properties {
  my $self = shift;
  if (@_) {
    $self->{'properties'} = shift;
  }
  return $self->{'properties'};
}

sub javaArgs {
  my $self = shift;
  if ( @_ ) {
    $self->{'javaArgs'} = \@_;
  }
  return $self->{'javaArgs'};
}

sub addProperty {
  my $self = shift;
  my $key = shift;
  my $value = shift;
  $self->{'properties'}->{$key} = $value;
  
  return $self; 
}

sub addJavaArgument {
  my $self = shift;
  push @{$self->{'javaArgs'}}, @_;
  return $self;
}

sub logbackConfiguration {
  my $self = shift;
  if (@_) {
    $self->{'properties'}->{'logback.configurationFile'} = shift;
  }
  return $self->{'properties'}->{'logback.configurationFile'};
}

sub gatherArgs {
  my $self = shift;
  my @args = ();
  
  # add the classpath
  if ( $self->{'classpath'} )
  {
    push @args, "-cp";
    push @args, join(":", @{$self->{'classpath'}} );
  }
  
  # add debug flags
  push @args, "-debug", "-nodetach" if $self->{'debug'};
  push @args, "-verbose" if $self->{'verbose'};
  
  push @args, "-stop" if $self->{'stop'};
  push @args, "-nodetach" if $self->{'attach'};
  
  # add a "run as" user
  if ( $self->{'user'} )
  {
    push @args, "-user", $self->{'user'}; 
  }
  
  # add java properties
  foreach my $key ( keys ( %{$self->{'properties'} } ) ) 
  {
    my $value = $self->{'properties'}->{$key};
    push @args, "-D" . $key . "=" . $value;
  }

  # add java properties
  push @args, @{$self->{'javaArgs'}};
  
  # switch to debug mode
  push @args, "-Xdebug", "-Xrunjdwp:transport=dt_socket,address=1303,server=y,suspend=n" if $self->{'debug'};
  
  # add pid file
  push @args, "-pidfile", EclipseSCADA::Base->pidfileRoot () . "/driver." . $self->{'instanceName'} . ".pid";
  
  # add the class name
  push @args, $self->{'className'};

  if ( $self->debug () )
  {
	  print "JRE_HOME=$ENV{JRE_HOME}\n";
	  print "JAVA_HOME=$ENV{JAVA_HOME}\n";
  }
  
  push @args, @{$self->{'args'}};
  return @args;
}

1;
__END__
