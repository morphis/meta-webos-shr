DESCRIPTION = "Luna-service2 provides a bus-based IPC mechanism used between components in webOS."
AUTHOR = "Hewlett-Packard Development Company, L.P"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/README.md;md5=0805e6a5927b13bf0f0738f011936c0c"
PV = "3.0.0+gitr${SRCPV}"
PR = "r2"

SRC_URI = " \
  git://github.com/openwebos/luna-service2.git;protocol=http;branch=master \
  file://dont-use-custom-memcpy.patch"
S = "${WORKDIR}/git"

SRCREV = "f8ec6f03134a1263bc6e21e261c869b7e1e3848c"

DEPENDS = "glib-2.0 cjson-openwebos pmloglib"

inherit cmake

EXTRA_OECMAKE = "-DTARGET_CORE_OS=rockhopper"

pkg_postinst_${PN} () {
  mkdir -p ${datadir}/ls2/roles/prv
  mkdir -p ${datadir}/ls2/roles/pub
}
