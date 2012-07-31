DESCRIPTION = "The Open webOS storage management daemon"
AUTHOR = "Hewlett-Packard Development Company, L.P"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/README.md;md5=76aa6fbe3ee3d5bbff1b96a09c5be6b6"
PV = "2.1.0-rc1+gitr${SRCPV}"
PR = "r0"

DEPENDS = "glib-2.0 cjson-openwebos luna-service2 nyx-lib"

SRC_URI = " \
  git://github.com/openwebos/storaged.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

SRCREV = "55fd020d173fec7d931b5855dfed36d7df063d5c"

inherit cmake

EXTRA_OECMAKE = "-DTARGET_CORE_OS=rockhopper"
