DESCRIPTION = "The Open webOS sleep scheduling daemon"
AUTHOR = "Hewlett-Packard Development Company, L.P"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/README.md;md5=5b6a0fa6d5039ac085000220e04305d5"
PV = "1.1.0-rc1+gitr${SRCPV}"
PR = "r1"

DEPENDS = "glib-2.0 cjson-openwebos luna-service2 nyx-lib powerd sqlite3"

SRC_URI = " \
  git://github.com/openwebos/sleepd.git;protocol=http;branch=master \
  file://fix-ldflags.patch"
S = "${WORKDIR}/git"

SRCREV = "9d5ce660eba324e8172117d53690c82431e5dc01"

inherit cmake

EXTRA_OECMAKE = "-DTARGET_CORE_OS=rockhopper"

PACKAGES += "${PN}-upstart"

FILES_${PN}-upstart = "${sysconfdir}/event.d/sleepd"
