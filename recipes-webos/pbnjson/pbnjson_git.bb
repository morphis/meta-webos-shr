DESCRIPTION = "Pbnjson is Palm's Better Native JSON library. Supports schemas and has C \
and C++ APIs."
AUTHOR = "Hewlett-Packard Development Company, L.P"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/README.md;md5=12f96df86e1fac200e836c51251bb264"
PV = "1.1.0+gitr${SRCPV}"
PR = "r0"

DEPENDS = "yajl libpcre"

SRC_URI = " \
  git://github.com/isis-project/pbnjson.git;protocol=http;branch=master \
  file://yajl-get-error-ex-removable.patch;striplevel=2"
S = "${WORKDIR}/git/src"

SRCREV = "519040930b2c407743906f8a7e7da4f78e1d1c49"

inherit cmake

EXTRA_OECMAKE = "-DWITH_TESTS=False"