%define version 0.1.0

%define buildroot %{_tmppath}/%{name}-%{version}-root
%define es_user eclipsescada
%define distribution centos

%define _defaultdir	/etc/default
%define _confdir	/etc/eclipsescada
%define _jardir		/usr/jar
%define _logdir		/var/log
%define _rundir		/var/run
%define _datadir	/usr/share
%define _homebasedir	/var/lib
%define qualifier %(date +"+%Y%m%d%H%M")

Name:		org.eclipse.scada
Version:	%{version}
Release:	%{qualifier}
Summary:	The Eclipse SCADA System
Group:		System Environment/Base
License:	EPL
URL:		http://projects.eclipse.org/projects/technology.eclipsescada
Source:		%{name}-%{version}.tar.gz
BuildRoot:	%{buildroot}
BuildArch:	noarch

#BuildRequires: unzip
#BuildRequires: wget

# for adding the user with "adduser"
Requires: shadow-utils
# for the "getent" command
Requires: glibc-common

%description
The Eclipse SCADA System

%prep
%setup -q

%build
DIST=%{distribution} make

%install
make DESTDIR=%{buildroot} install

%clean
[ ${RPM_BUILD_ROOT} != "/" ] && rm -rf ${RPM_BUILD_ROOT}



# script run after installation

%post
if ! getent passwd "%{es_user}" >/dev/null; then
	# create new user
	adduser --system --user-group --home "%{_homebasedir}/%{es_user}" --comment "Eclipse SCADA User" "%{es_user}" 
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
%dir %attr(755,root,root) %{_datadir}/%{es_user}/profiles
%dir %attr(755,root,root) %{_datadir}/%{es_user}/p2
%doc

%changelog
* Fri Oct 18 2013 Jens Reimann <jens.reimann@ibh-systems.com> - 0.1.0-1
- Initial version
