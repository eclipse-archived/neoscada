default:

DIST ?= debian
ARCH ?= `uname -i`
VERSION = 0.1.0
PACKAGE = org.eclipse.scada.deploy.packages

EXTRA_DIST = $(PACKAGE).spec

install:
	install -d "$(DESTDIR)/etc/eclipsescada"
	
	install -d "$(DESTDIR)/usr/jar"
	install -d "$(DESTDIR)/usr/share/eclipsescada"
	
	install -d "$(DESTDIR)/var/log/eclipsescada"
	install -d "$(DESTDIR)/var/run/eclipsescada"
	install -d "$(DESTDIR)/var/lib/eclipsescada"
	
	install -d "$(DESTDIR)/etc/default"

	if [ -f "src/default/eclipsescada.$(DIST)" ]; then install -m 0644 "src/default/eclipsescada.$(DIST)" "$(DESTDIR)/etc/default/eclipsescada"; fi
	if [ -f "src/default/eclipsescada.$(DIST).$(ARCH)" ]; then install -m 0644 "src/default/eclipsescada.$(DIST).$(ARCH)" "$(DESTDIR)/etc/default/eclipsescada"; fi

dist:
	rm -Rf "$(PACKAGE)-$(VERSION)"
	mkdir "$(PACKAGE)-$(VERSION)"
	cp -a Makefile debian src "$(PACKAGE)-$(VERSION)"
	cp $(EXTRA_DIST) "$(PACKAGE)-$(VERSION)"
	tar czf "$(PACKAGE)-$(VERSION).tar.gz" "$(PACKAGE)-$(VERSION)"
	rm -Rf "$(PACKAGE)-$(VERSION)"
	
clean:
	-rm *.tar.gz
	
.PHONY: default install dist clean
