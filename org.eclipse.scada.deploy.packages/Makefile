default:

SHELL := /bin/bash

EXTRA_DIST = $(PACKAGE).spec \
	Makefile.defs \
	Makefile.*.defs

include Makefile.defs
-include Makefile.$(DIST).defs

dist:
	rm -Rf "$(PACKAGE)-$(VERSION)"
	mkdir "$(PACKAGE)-$(VERSION)"
	cp -a Makefile debian src "$(PACKAGE)-$(VERSION)"
	cp $(EXTRA_DIST) "$(PACKAGE)-$(VERSION)"
	tar czf "$(PACKAGE)-$(VERSION).tar.gz" "$(PACKAGE)-$(VERSION)"
	rm -Rf "$(PACKAGE)-$(VERSION)"

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
	rm -Rf rpmbuild
	
.PHONY: default install clean dist
