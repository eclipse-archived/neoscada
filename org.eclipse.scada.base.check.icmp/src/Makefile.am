bin_PROGRAMS = eclipse_scada_ping

eclipse_scada_ping_SOURCES = \
	main.cpp		\
	DataItem.cpp	\
	DataItem.h		\
	Hive.cpp		\
	Hive.h			\
	PingServer.cpp	\
	PingServer.h	\
	PingTarget.cpp	\
	PingTarget.h	\
	StatsArray.cpp	\
	StatsArray.h	\
	tools.cpp		\
	tools.h			\
	headers.h

install-exec-hook:
	chmod u+s $(DESTDIR)$(bindir)/eclipse_scada_ping
