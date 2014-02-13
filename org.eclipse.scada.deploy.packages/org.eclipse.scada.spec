%define version @@VERSION@@

%define buildroot %{_tmppath}/%{name}-%{version}-root
%define es_user eclipsescada

%if 0%{?suse_version}
%define distribution suse
%else
%define distribution centos
%endif

%define _profiledir	/etc/profile.d
%define _defaultdir	/etc/default
%define _confdir	/etc/eclipsescada
%define _jardir		/usr/jar
%define _logdir		/var/log
%define _libdir		/usr/lib
%define _rundir		/var/run
%define _datadir	/usr/share
%define _homebasedir	/var/lib
%define qualifier %(date +"%Y%m%d%H%M")

Name:		org.eclipse.scada
Version:	%{version}
Release:	%{qualifier}
Summary:	The Eclipse SCADA System
Group:		System Environment/Base
License:	EPL
URL:		http://eclipse.org/eclipsescada
Source:		%{name}-%{version}.tar.gz
BuildRoot:	%{buildroot}
BuildArch:	noarch

# Global requires

Requires: org.eclipse.scada.distribution-base = %{version}
Requires: rsync

%package centos6
Summary: Base setup for CentOS6 based distributions
Group:   System Environment/Base
Provides: org.eclipse.scada.distribution-base

# for adding the user with "adduser"
Requires: shadow-utils
# for the "getent" command
Requires: glibc-common
# for jsvc
Requires: jakarta-commons-daemon-jsvc
Requires: openssh-clients
Requires: perl

%package suse
Summary: Base setup for Suse based distributions
Group:   System Environment/Base
Provides: org.eclipse.scada.distribution-base

# for adding the user with "useradd"
Requires: shadow
# for the "getent" command
Requires: glibc
# for jsvc
Requires: apache-commons-daemon-jsvc
Requires: openssh
Requires: perl-base

%package p2
Summary:	P2 deployment system for Eclipse SCADA
Group:   System Environment/Base

Requires: org.eclipse.scada.deploy.p2director-incubation

#BuildRequires: unzip
#BuildRequires: wget

%description
The Eclipse SCADA system

%description p2
A deployment system for P2/Equinox based application of the Eclipse SCADA system

%description centos6
A distribution specific base package for CentOS 6 compatible distributions

%description suse
A distribution specific base package for Suse compatible distributions

%prep
%setup -q

%build
make DIST=%{distribution}

%install
make DIST=%{distribution} DESTDIR=%{buildroot} install

%clean
[ ${RPM_BUILD_ROOT} != "/" ] && rm -rf ${RPM_BUILD_ROOT}

# script run after installation

%pre
if ! getent passwd "%{es_user}" >/dev/null; then
	# create new user
	useradd --system --user-group --home "%{_homebasedir}/%{es_user}" --comment "Eclipse SCADA User" "%{es_user}"
fi
mkdir -p "%{_homebasedir}/%{es_user}"
chown -R "%{es_user}:%{es_user}" "%{_homebasedir}/%{es_user}"

# script run after un-install

%postun
if [ "$1" -eq "0" ]; then
	# zero means this we are the last and now are gone
	# so perform a complete uninstall
	if which userdel >/dev/null 2>&1; then
		userdel "%{es_user}" > /dev/null || true
	fi
	groupdel "%{es_user}" > /dev/null || true
fi

%files
%defattr(-,root,root,-)
%config %{_defaultdir}/%{es_user}
%dir %{_jardir}
%dir %{_confdir}
%dir %{_confdir}/schema
%dir %attr(775,root,%{es_user}) %{_logdir}/%{es_user}
%dir %attr(775,root,%{es_user}) %{_rundir}/%{es_user}
%dir %{_datadir}/%{es_user}
%{_profiledir}/eclipsescada.sh
%{_bindir}/es*
%{_bindir}/hds-replicate-once
%doc

%files suse
%dir %{_libdir}/perl5/site_perl/EclipseSCADA
%{_libdir}/perl5/site_perl/EclipseSCADA/*

%files centos6
%dir %{_datadir}/perl5/EclipseSCADA
%{_datadir}/perl5/EclipseSCADA/*

%files p2
%defattr(-,root,root,-)
%dir %attr(755,root,root) %{_datadir}/%{es_user}/profiles
%dir %attr(755,root,root) %{_datadir}/%{es_user}/p2
%{_bindir}/p2.*

%changelog
* Thu Feb 13 2014 Jens Reimann <jens.reimann@ibh-systems.com> - 0.1.0-2
- Split up distribution dependent packages
* Fri Oct 18 2013 Jens Reimann <jens.reimann@ibh-systems.com> - 0.1.0-1
- Initial version
