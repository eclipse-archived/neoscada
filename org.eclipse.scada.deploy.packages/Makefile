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

	test -f "src/eclipse.scada.$(DIST)" && install -m 0644 "src/eclipse.scada.$(DIST)" "$(DESTDIR)/etc/default/eclipse.scada"
	test -f "src/eclipse.scada.$(DIST).$(ARCH)" && install -m 0644 "src/eclipse.scada.$(DIST).$(ARCH)" "$(DESTDIR)/etc/default/eclipse.scada"
	
.PHONY: default install
