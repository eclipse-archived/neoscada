%define _datadir /usr/share
%define version $$version$$
%define qualifier $$qualifier$$
%define buildroot %{_topdir}/%{name}-%{version}-root

Name:      $$packageName$$
Summary:   Eclipse SCADA Configuration for "$$nodeName$$"
Version:   %{version}
Release:   %{qualifier}
License:   $$license$$
BuildArch: noarch
Packager:  $$authorName$$ <$$authorEmail$$>
Group:     Applications/System
Source0:   %{name}_%{version}.%{qualifier}.tar.gz
BuildRoot: %{buildroot}
$$depends$$

%description
This is the configuration package for node "$$nodeName$$".

%prep
rm -Rf %{name}
tar xzpf %_sourcedir/%{name}_%{version}.%{qualifier}.tar.gz

%build

%install
rm -rf $RPM_BUILD_ROOT
cd %{name}
make DESTDIR=$RPM_BUILD_ROOT install
cd ..

%clean
[ ${RPM_BUILD_ROOT} != "/" ] && rm -rf ${RPM_BUILD_ROOT}

%post
$$postinst.scripts$$
$$create.apps$$
$$start.apps$$

multiuserScreen="$$multiuserScreen$$"
if [ ! -f ~neoscada/.screenrc ]; then
   test "$multiuserScreen" -eq "1" && echo "multiuser on\nacladd root" > ~neoscada/.screenrc
fi

%postun
$$postrem.scripts$$

%pre
$$stop.apps$$
$$preinst.scripts$$

%preun
$$stop.apps$$
$$prerem.scripts$$

%files
%defattr(-,root,root)
$$files$$

%changelog
$$changeLog$$
