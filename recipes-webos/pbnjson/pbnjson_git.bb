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

SRCREV = "5b0d5347d16c7cdf540e94f4f0a9a218b9fd7693"

inherit cmake

EXTRA_OECMAKE = "-DWITH_TESTS=False"
