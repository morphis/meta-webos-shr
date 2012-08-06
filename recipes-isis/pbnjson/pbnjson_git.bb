DESCRIPTION = "Pbnjson is Palm's Better Native JSON library. Supports schemas and has C \
and C++ APIs."
AUTHOR = "Hewlett-Packard Development Company, L.P"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://../README.md;md5=12f96df86e1fac200e836c51251bb264"
PV = "1.1.0+gitr${SRCPV}"
PR = "r3"

# only headers in -dev
ALLOW_EMPTY_${PN} = "1"

DEPENDS = "yajl libpcre"

SRC_URI = " \
  git://github.com/isis-project/pbnjson.git;protocol=http;branch=master \
  file://fix-compilation-errors.patch;striplevel=2 \
  file://set-soversion.patch;striplevel=2"
S = "${WORKDIR}/git/src"

SRCREV = "5ec5900086c8f79f8830b717f2d7cc885c44bba1"

inherit cmake

EXTRA_OECMAKE = "-DWITH_TESTS=False -DCMAKE_BUILD_TYPE=release"
