DESCRIPTION = "The Open webOS power management daemon"
AUTHOR = "Hewlett-Packard Development Company, L.P"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/README.md;md5=55a6001c5e0219eb260937964862a8a6"
PV = "4.0.0-rc1+gitr${SRCPV}"
PR = "r1"

DEPENDS = "glib-2.0 cjson-openwebos luna-service2 nyx-lib"

SRC_URI = " \
  git://github.com/openwebos/powerd.git;protocol=http;branch=master \
  file://add-missing-dependency-librt.patch"
S = "${WORKDIR}/git"

SRCREV = "5077891a3430aa6ed5c10b222d82126b44a905cc"

inherit cmake

EXTRA_OECMAKE = "-DTARGET_CORE_OS=rockhopper"

PACKAGES += "${PN}-upstart"

FILES_${PN}-upstart = "${sysconfdir}/event.d/powerd"
