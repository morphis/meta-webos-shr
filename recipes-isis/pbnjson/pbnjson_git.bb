DESCRIPTION = "Pbnjson is Palm's Better Native JSON library. Supports schemas and has C \
and C++ APIs."
AUTHOR = "Hewlett-Packard Development Company, L.P"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://../README.md;md5=12f96df86e1fac200e836c51251bb264"
PV = "1.1.0+gitr${SRCPV}"
PR = "r0"

DEPENDS = "yajl libpcre"

SRC_URI = " \
  git://github.com/isis-project/pbnjson.git;protocol=http;branch=master \
  file://fix-compilation-errors.patch;striplevel=2"
S = "${WORKDIR}/git/src"

SRCREV = "bdad3ab1e5f0d0cfa8430004f99bdc4459450597"

inherit cmake

EXTRA_OECMAKE = "-DWITH_TESTS=False"
