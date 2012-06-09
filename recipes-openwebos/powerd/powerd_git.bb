DESCRIPTION = "The Open webOS power management daemon"
AUTHOR = "Hewlett-Packard Development Company, L.P"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/README.md;md5=55a6001c5e0219eb260937964862a8a6"
PV = "4.0.0-rc1+gitr${SRCPV}"
PR = "r0"

DEPENDS = "glib-2.0 cjson-openwebos luna-service2 nyx-lib"

SRC_URI = " \
  git://github.com/openwebos/powerd.git;protocol=http;branch=master \
  file://add-missing-dependency-librt.patch"
S = "${WORKDIR}/git"

SRCREV = "fbf56b4a02b74e06a6ab31f30c67cda3fddcbd03"

inherit cmake

EXTRA_OECMAKE = "-DTARGET_CORE_OS=rockhopper"
