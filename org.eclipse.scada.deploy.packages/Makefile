default:

SHELL := /bin/bash

EXTRA_DIST = \
	Makefile.defs \
	Makefile.*.defs

include Makefile.defs
-include Makefile.$(DIST).defs

SVERSION=$(shell echo "$(VERSION)" | sed s/-SNAPSHOT/.SNAPSHOT/)

dist:
	rm -Rf "$(PACKAGE)-$(SVERSION)"
	mkdir "$(PACKAGE)-$(SVERSION)"
	cat "$(PACKAGE).spec" | sed s/@@VERSION@@/$(SVERSION)/ > "$(PACKAGE)-$(SVERSION)"/"$(PACKAGE).spec"
	cp -a Makefile debian src "$(PACKAGE)-$(SVERSION)"
	cp $(EXTRA_DIST) "$(PACKAGE)-$(SVERSION)"
	tar czf "$(PACKAGE)-$(SVERSION).tar.gz" "$(PACKAGE)-$(SVERSION)"
	rm -Rf "$(PACKAGE)-$(SVERSION)"

install:
	install -d "$(DESTDIR)/etc/eclipsescada"
	install -d "$(DESTDIR)/etc/eclipsescada/schema"
	
	install -d "$(DESTDIR)/usr/jar"
	install -d "$(DESTDIR)/usr/share/eclipsescada"
	install -d "$(DESTDIR)/usr/share/eclipsescada/profiles"
	install -d "$(DESTDIR)/usr/share/eclipsescada/p2"
	
	install -d "$(DESTDIR)/var/log/eclipsescada"
	install -d "$(DESTDIR)/var/run/eclipsescada"
	install -d "$(DESTDIR)/var/lib/eclipsescada"

	install -d "$(DESTDIR)/etc/profile.d"
	install -m 0644 src/default/eclipsescada.sh "$(DESTDIR)/etc/profile.d"
	
	install -d "$(DESTDIR)/etc/default"

	if [ -f "src/default/eclipsescada.$(DIST)" ]; then install -m 0644 "src/default/eclipsescada.$(DIST)" "$(DESTDIR)/etc/default/eclipsescada"; fi
	if [ -f "src/default/eclipsescada.$(DIST).$(ARCH)" ]; then install -m 0644 "src/default/eclipsescada.$(DIST).$(ARCH)" "$(DESTDIR)/etc/default/eclipsescada"; fi
	
	# binaries
	
	mkdir -p "$(DESTDIR)/usr/bin"
	install -m 0755 -t "$(DESTDIR)/usr/bin" src/bin/*
	
	mkdir -p "$(DESTDIR)/$(PERL_DIR)/EclipseSCADA"
	install -m 0644 -t "$(DESTDIR)/$(PERL_DIR)/EclipseSCADA" src/perl/EclipseSCADA/*
	
clean:
	-rm *.tar.gz
	
.PHONY: default install clean dist
