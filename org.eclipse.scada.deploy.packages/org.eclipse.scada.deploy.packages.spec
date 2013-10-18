Name:		org.eclipse.scada.deploy.packages
Version:	0.1.0
Release:	1%{?dist}
Summary:	The Eclipse SCADA System
Group:		System Environment/Base
License:	EPL
URL:		http://eclipse.org
Source:		%{name}-%{version}.tar.gz
BuildRoot:	%{_tmppath}/%{name}-%{version}-%{release}-root-%(%{__id_u} -n)

#BuildRequires:
#Requires:	

%description
The Eclipse SCADA System

%prep
%setup -q

%build
make

%install
make DESTDIR=%{buildroot} install

%clean
rm -rf %{buildroot}

%files
%defattr(-,root,root,-)
%doc

%changelog
* Fri Oct 18 2013 Jens Reimann <jens.reimann@ibh-systems.com> - 0.1.0-1
- Initial version
