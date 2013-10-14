default:

DIST ?= debian
ARCH ?= `uname -i`

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
	
.PHONY: default install
