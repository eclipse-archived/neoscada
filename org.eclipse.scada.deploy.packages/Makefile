default:

DIST ?= debian
ARCH ?= `uname -i`
VERSION = 0.1.0
PACKAGE = org.eclipse.scada.deploy.packages

install:
	install -d "$(DESTDIR)/etc/eclipse.scada"
	
	install -d "$(DESTDIR)/usr/jar"
	install -d "$(DESTDIR)/usr/share/eclipse.scada"
	
	install -d "$(DESTDIR)/var/log/eclipse.scada"
	install -d "$(DESTDIR)/var/run/eclipse.scada"
	install -d "$(DESTDIR)/var/lib/eclipse.scada"
	
	install -d "$(DESTDIR)/etc/default"

	if [ -f "src/eclipse.scada.$(DIST)" ]; then install -m 0644 "src/eclipse.scada.$(DIST)" "$(DESTDIR)/etc/default/eclipse.scada"; fi
	if [ -f "src/eclipse.scada.$(DIST).$(ARCH)" ]; then install -m 0644 "src/eclipse.scada.$(DIST).$(ARCH)" "$(DESTDIR)/etc/default/eclipse.scada"; fi

dist:
	rm -Rf "$(PACKAGE)-$(VERSION)"
	mkdir "$(PACKAGE)-$(VERSION)"
	cp -a Makefile debian src "$(PACKAGE)-$(VERSION)"
	tar czf "$(PACKAGE)-$(VERSION).tar.gz" "$(PACKAGE)-$(VERSION)"
	rm -Rf "$(PACKAGE)-$(VERSION)"
	
clean:
	-rm *.tar.gz
	
.PHONY: default install dist clean
